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

import cn.com.cmdd.dao.MemberRechargeLogDao;
import cn.com.cmdd.domain.MemberRechargeLog;
import cn.com.cmdd.service.MemberRechargeLogService;
import cn.com.cmdd.util.ResponseObject;

@Controller//@CrossOrigin(origins = "*")
public class MemberRechargeLogController {
	private final static Logger LOGGER = LoggerFactory.getLogger(MemberRechargeLogController.class);

	@Autowired
	private MemberRechargeLogService memberRechargeLogService;
	
	@Autowired
	private MemberRechargeLogDao memberRechargeLogDao;

	@RequestMapping(value="/memberRechargeLog/isUpload",method=RequestMethod.GET)
	@ResponseBody
	public ResponseObject isUpload(
			HttpServletRequest request,
			HttpServletResponse response)
	{
		ResponseObject responseObject = new ResponseObject(ResponseObject.ok,null);
		
		try {
			
			responseObject.msg=memberRechargeLogDao.selectByIsUpload();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			responseObject.code=ResponseObject.serverError;
			responseObject.msg=e.getLocalizedMessage();
			e.printStackTrace();
		}
		return responseObject;
	}
	
	@RequestMapping(value="/memberRechargeLog/isUpload/{id}",method=RequestMethod.PUT)
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
			memberRechargeLogDao.updateIsUpload(id);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			responseObject.code=ResponseObject.serverError;
			responseObject.msg=e.getLocalizedMessage();
			e.printStackTrace();
		}
		return responseObject;
	}
	@RequestMapping(value="/member-recharge",method=RequestMethod.POST)
	@ResponseBody
	public ResponseObject addMemberRechargeLog(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestBody MemberRechargeLog memberRechargeLog)
	{
		/*if(!AuthCheck.UserCheck(request, response, KEYS.SHOP)){
			return null;
		}*/
		
		ResponseObject responseObject = new ResponseObject(ResponseObject.ok, null);
		try{
			
			memberRechargeLogService.addMemberRechargeLog(memberRechargeLog);
			
		}catch(Exception e){
			responseObject.code = ResponseObject.serverError;
			responseObject.msg = e.getLocalizedMessage();
			e.printStackTrace();
		}
		return responseObject;
	}
	
	
	@RequestMapping(value="/member/{id}/recharge/list",method=RequestMethod.GET)
	@ResponseBody
	public ResponseObject getMemberRechargeLogList(@PathVariable("id")Long member_id)
	{
		ResponseObject responseObject = new ResponseObject(ResponseObject.ok,null);
		try {
			responseObject.msg = memberRechargeLogService.getMemberRechargeLogListByMember(member_id);
		} catch (Exception e) {
			responseObject.code = ResponseObject.serverError;
			responseObject.msg = e.getLocalizedMessage();
			e.printStackTrace();
		}
		return responseObject;
	}
	
	@RequestMapping(value="/shop/{id}/recharge/list",method=RequestMethod.GET)
	@ResponseBody
	public ResponseObject getMemberRechargeLogListByShop_id(@PathVariable("id") Integer shop_id)
	{
		ResponseObject responseObject = new ResponseObject(ResponseObject.ok,null);
		try {
			responseObject.msg = memberRechargeLogService.getMemberRechargeLogListByShop_id(shop_id);
		} catch (Exception e) {
			responseObject.code = ResponseObject.serverError;
			responseObject.msg = e.getLocalizedMessage();
			e.printStackTrace();
		}
		return responseObject;
	}

}
