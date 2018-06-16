package cn.com.cmdd.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import cn.com.cmdd.dao.MemberIntegralDao;
import cn.com.cmdd.domain.MemberIntegral;
import cn.com.cmdd.util.ResponseObject;

@Controller
@RequestMapping("/member")//@CrossOrigin(origins = "*")
public class MemberIntegralController {

    @Autowired
    MemberIntegralDao memberIntegralDao;
    
    @RequestMapping(value="/memberIntegral/isUpload",method=RequestMethod.GET)
	@ResponseBody
	public ResponseObject isUpload(
			HttpServletRequest request,
			HttpServletResponse response)
    {
		ResponseObject responseObject = new ResponseObject(ResponseObject.ok,null);
		
		try {
			
			responseObject.msg=memberIntegralDao.selectByIsUpload();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			responseObject.code=ResponseObject.serverError;
			responseObject.msg=e.getLocalizedMessage();
			e.printStackTrace();
		}
		return responseObject;
	}
	
	@RequestMapping(value="/memberIntegral/isUpload/{id}",method=RequestMethod.PUT)
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
			memberIntegralDao.updateIsUpload(id);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			responseObject.code=ResponseObject.serverError;
			responseObject.msg=e.getLocalizedMessage();
			e.printStackTrace();
		}
		return responseObject;
	}
    
    //@PostMapping("/member_integral")
    @RequestMapping(value="/member_integral",method=RequestMethod.POST)
    @ResponseBody
    public ResponseObject saveAndUpdate(@RequestBody MemberIntegral memberIntegral){

        ResponseObject responseObject = new ResponseObject(ResponseObject.ok, null);

        try{
        	Long memberIntegralId = memberIntegral.getId();
        	if(memberIntegralId==null) {
        		 memberIntegralDao.insert(memberIntegral);
        	}else {
        		memberIntegralDao.update(memberIntegral);
        	}
           

        }catch (Exception e){

            responseObject.code = ResponseObject.serverError;
            responseObject.msg = e.getLocalizedMessage();
        }

        return responseObject;
    }

    //@GetMapping("/member_integral/shop_id/{shop_id}")
    @RequestMapping(value="/member_integral/shop_id/{shop_id}",method=RequestMethod.GET)
    @ResponseBody
    public ResponseObject get(@PathVariable("shop_id")Integer shopId){

        ResponseObject responseObject = new ResponseObject(ResponseObject.ok, null);

        try{
            responseObject.msg = memberIntegralDao.select(shopId);

        }catch (Exception e){

            responseObject.code = ResponseObject.serverError;
            responseObject.msg = e.getLocalizedMessage();
        }

        return responseObject;
    }
}
