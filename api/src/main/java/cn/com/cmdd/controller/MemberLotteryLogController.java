package cn.com.cmdd.controller;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import cn.com.cmdd.dao.MemberLotteryLogDao;
import cn.com.cmdd.domain.MemberLotteryLog;
import cn.com.cmdd.service.MemberLotteryLogService;
import cn.com.cmdd.util.ResponseObject;

@Controller//@CrossOrigin(origins = "*")
public class MemberLotteryLogController {
	private final static Logger LOGGER = LoggerFactory.getLogger(MemberLotteryLogController.class);

	@Autowired
	private MemberLotteryLogService memberLotteryLogService;
	
	@Autowired
	private MemberLotteryLogDao memberLotteryLogDao;

	@RequestMapping(value="/memberLottery/isUpload",method=RequestMethod.GET)
	@ResponseBody
	public ResponseObject isUpload(
			HttpServletRequest request,
			HttpServletResponse response)
	{
		ResponseObject responseObject = new ResponseObject(ResponseObject.ok,null);
		
		try {
			
			responseObject.msg=memberLotteryLogDao.selectByIsUpload();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			responseObject.code=ResponseObject.serverError;
			responseObject.msg=e.getLocalizedMessage();
			e.printStackTrace();
		}
		return responseObject;
	}
	
	@RequestMapping(value="/memberLottery/isUpload/{id}",method=RequestMethod.PUT)
	@ResponseBody
	public ResponseObject isUpload(
			HttpServletRequest request,
			HttpServletResponse response,
			@PathVariable("id")Long id)
	{
		
		/*if(!AuthCheck.UserCheck(request, response, KEYS.SHOP)){
			return null;
		}*/
		
		ResponseObject responseObject = new ResponseObject(ResponseObject.ok,null);
		
		try {
			memberLotteryLogDao.updateIsUpload(id);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			responseObject.code=ResponseObject.serverError;
			responseObject.msg=e.getLocalizedMessage();
			e.printStackTrace();
		}
		return responseObject;
	}
	
	@RequestMapping(value="/lottery-phone",method=RequestMethod.POST)
	@ResponseBody
	public ResponseObject addMemberLotteryLog(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestBody MemberLotteryLog memberLotteryLog)
	{
		
		ResponseObject responseObject = new ResponseObject(ResponseObject.ok, null);
		try{
			memberLotteryLogService.addMemberLotteryLog(memberLotteryLog);
			
		}catch(Exception e){
			responseObject.code = ResponseObject.serverError;
			responseObject.msg = e.getLocalizedMessage();
			e.printStackTrace();
		}
		return responseObject;
	}

	
	@RequestMapping(value="/lottery-phone/{id}",method=RequestMethod.GET)
	@ResponseBody
	public ResponseObject getMemberLotteryLog(
			HttpServletRequest request, 
			HttpServletResponse response,
			@PathVariable("id")Long id)
	{
		
		ResponseObject responseObject = new ResponseObject(ResponseObject.ok, null);
		try {
			memberLotteryLogService.getMemberLotteryLog(id);
		} catch (Exception e) {
			responseObject.code = ResponseObject.serverError;
			responseObject.msg = e.getLocalizedMessage();
			e.printStackTrace();
		}
		return responseObject;
	}
	
	
	@RequestMapping(value="/lottery-order/{order_id}",method=RequestMethod.GET)
	@ResponseBody
	public ResponseObject getMemberLotteryLogByOrderId(
			HttpServletRequest request, 
			HttpServletResponse response,
			@PathVariable("order_id")Long order_id)
	{
		ResponseObject responseObject = new ResponseObject(ResponseObject.ok, null);
		try {
			memberLotteryLogService.getMemberLotteryLogByOrderId(order_id);
		} catch (Exception e) {
			responseObject.code = ResponseObject.serverError;
			responseObject.msg = e.getLocalizedMessage();
			e.printStackTrace();
		}
		return responseObject;
	}
	
	@RequestMapping(value="shop/{shop_id}/lotterylog-phone/{phone}/list",method=RequestMethod.GET)
	@ResponseBody
	public ResponseObject getMemberLotteryLogListByPhoneAndShopId(@PathVariable("shop_id")int shop_id,@PathVariable("phone")String phone){
		ResponseObject responseObject = new ResponseObject(ResponseObject.ok,null);
		try {
			responseObject.msg = memberLotteryLogService.getMemberLotteryLogListByPhoneAndShopId(shop_id,phone);
		} catch (Exception e) {
			responseObject.code = ResponseObject.serverError;
			responseObject.msg = e.getLocalizedMessage();
			e.printStackTrace();
		}
		return responseObject;
	}
	
	
	
	@RequestMapping(value="/lottery-phone/{id}",method=RequestMethod.PUT)
	@ResponseBody
	public ResponseObject updateMemberLotteryLog(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") Long id, @RequestBody MemberLotteryLog memberLotteryLog){

		ResponseObject responseObject = new ResponseObject(ResponseObject.ok,null);
		try {
			memberLotteryLog.setId(id);
			memberLotteryLogService.updateMemberLotteryLog(memberLotteryLog);
			Map<String,Object> resultMap = new HashMap<String,Object>();
			resultMap.put("memberLotteryLog_id", id);
			responseObject.msg = resultMap;
		} catch (Exception e) {
			responseObject.code = ResponseObject.serverError;
			responseObject.msg = e.getLocalizedMessage();
			e.printStackTrace();
		}
		return responseObject;
	}
	
	
	@RequestMapping(value="/lottery-phone/{id}",method=RequestMethod.DELETE)
	@ResponseBody
	public ResponseObject deleteAddress(HttpServletRequest request, 
			HttpServletResponse response, 
			@PathVariable("id")Long id)
	{

		ResponseObject responseObject = new ResponseObject(ResponseObject.ok, null);
		try {
			memberLotteryLogService.deleteMemberLotteryLog(id);
		} catch (Exception e) {
			responseObject.code = ResponseObject.serverError;
			responseObject.msg = e.getLocalizedMessage();
			e.printStackTrace();
		}
		System.out.println("111111");
		
		
		return responseObject;
	}
	
}
