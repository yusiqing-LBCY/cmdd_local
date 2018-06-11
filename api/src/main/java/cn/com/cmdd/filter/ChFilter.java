package cn.com.cmdd.filter;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ChFilter implements Filter {
	private final static int MAX_REQUEST = 2; // 时间段内最多访问次数
	private final static int TIME = 30 * 60 * 1000; // 时间段（毫秒）
	private final static String KEY = "IpCount";// map的key
	/**
	 * 过滤器配置对象用于获取ServletContext，ServletContext不宜作为成员变量，因为在此处需要频繁读写，
	 * Filter和Servlet一样都是单例多线程，不能将含写操作的数据类型定义成员变量，线程安全问题。
	 */
	private FilterConfig config;

	public void init(FilterConfig config) throws ServletException {
		this.config = config;// 对象初始化
		ServletContext sc = config.getServletContext();// 获取全局（application）对象
		Map<String, IpCount> map = new HashMap<String, IpCount>();// ip和对象的映射
		sc.setAttribute(KEY, map);// 将map存入
		// LinkedHashMap有序，访问效率低于hashmap，数据量不大可以使用
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		ServletContext sc = config.getServletContext();// 获取全局（application）对象
		Map<String, IpCount> map = (Map<String, IpCount>) sc.getAttribute(KEY);//获取ip和对象的映射
		String ip = request.getRemoteAddr();// 获取访问者ip
		if (map.containsKey(ip)) {// 此ip不是第一次访问
			IpCount t = map.get(ip);//取出此ip的对象
			if (System.currentTimeMillis() - t.getFirstTime() <= TIME) {// 此ip两次请求间隔在设定时间内
				if (t.getTimes() < MAX_REQUEST) {// 请求次数在限制范围内，累加访问次数
					t.setTimes(t.getTimes() + 1);
					map.put(ip, t);
					sc.setAttribute(KEY, map);
					chain.doFilter(request, response);
					System.out.println(ip + "  在间隔时间内第" + t.getTimes()
							+ "次请求，放行");
				} else {// 请求次数在限制范围外
					System.out.println(ip + "  在间隔时间内请求上限，禁止放行，给客户端提示");
					response.getWriter().print("access_limited");
				}
			} else {// 此ip两次请求间隔在设定时间外，重置访问次数和访问时间
				t.setFirstTime(System.currentTimeMillis());
				t.setTimes(1);
				map.put(ip, t);
				sc.setAttribute(KEY, map);
				chain.doFilter(request, response);
				System.out.println(ip + "  在间隔时间外第一次请求，直接放行");
			}

		} else {// 此ip第一次访问
			IpCount t = new IpCount();//创建对象
			t.setFirstTime(System.currentTimeMillis());//设置对象访问时间
			t.setTimes(1);//设置对象访问次数为1
			map.put(ip, t);//对象和ip映射
			sc.setAttribute(KEY, map);//存储记录
			chain.doFilter(request, response);//放行
			System.out.println(ip + "第一次请求，直接放行");
		}

	}

	public void destroy() {
		// 在 Filter 实例被 Web 容器从服务移除之前调用 ，可用于释放资源
		config = null;
	}
}

class IpCount {
	private long firstTime;// 记录访问时间
	private int times;// 访问次数

	public long getFirstTime() {
		return firstTime;
	}

	public void setFirstTime(long firstTime) {
		this.firstTime = firstTime;
	}

	public int getTimes() {
		return times;
	}

	public void setTimes(int times) {
		this.times = times;
	}
}