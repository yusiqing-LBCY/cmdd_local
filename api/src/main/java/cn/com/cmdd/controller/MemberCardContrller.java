package cn.com.cmdd.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import cn.com.cmdd.dao.MemberCardDao;
import cn.com.cmdd.domain.MemberCard;
import cn.com.cmdd.util.ResponseObject;
@Controller
@RequestMapping(value = "/member/member_card")
public class MemberCardContrller {

    @Autowired
    MemberCardDao memberCardDao;

	@RequestMapping(value="/isUpload",method=RequestMethod.GET)
	@ResponseBody
	public ResponseObject isUpload(
			HttpServletRequest request,
			HttpServletResponse response)
	{
		ResponseObject responseObject = new ResponseObject(ResponseObject.ok,null);
		
		try {
			
			responseObject.msg=memberCardDao.selectByIsUpload();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			responseObject.code=ResponseObject.serverError;
			responseObject.msg=e.getLocalizedMessage();
			e.printStackTrace();
		}
		return responseObject;
	}
	
	@RequestMapping(value="/isUpload/{id}",method=RequestMethod.PUT)
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
			memberCardDao.updateIsUpload(id);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			responseObject.code=ResponseObject.serverError;
			responseObject.msg=e.getLocalizedMessage();
			e.printStackTrace();
		}
		return responseObject;
	}
    
    //@GetMapping(value = "/{id}")
    @RequestMapping(value="{id}",method=RequestMethod.GET)
    @ResponseBody
    public ResponseObject get(@PathVariable("id")Long id){
        ResponseObject responseObject = new ResponseObject(ResponseObject.ok, null);

        try{

        	 responseObject.msg = memberCardDao.select(id);

        }catch (Exception e){

            responseObject.code = ResponseObject.serverError;
            responseObject.msg = e.getLocalizedMessage();
        }

        return responseObject;
    }

    @RequestMapping(value="/shop_id/{shop_id}",method=RequestMethod.GET)
    @ResponseBody
    public ResponseObject getList(@PathVariable("shop_id")Integer shopId){
        ResponseObject responseObject = new ResponseObject(ResponseObject.ok, null);

        try{

            responseObject.msg = memberCardDao.selectList(shopId);

        }catch (Exception e){

            responseObject.code = ResponseObject.serverError;
            responseObject.msg = e.getLocalizedMessage();
        }

        return responseObject;
    }

    @RequestMapping(method=RequestMethod.POST)
    @ResponseBody
    public ResponseObject add(@RequestBody MemberCard memberCard){

        ResponseObject responseObject = new ResponseObject(ResponseObject.ok, null);

        try{

           memberCardDao.insert(memberCard);

        }catch (Exception e){

            responseObject.code = ResponseObject.serverError;
            responseObject.msg = e.getLocalizedMessage();
        }

        return responseObject;

    }

    @RequestMapping(method=RequestMethod.PUT)
    @ResponseBody
    public ResponseObject modify(@RequestBody MemberCard memberCard){

        ResponseObject responseObject = new ResponseObject(ResponseObject.ok, null);

        try {

            responseObject.msg = memberCardDao.update(memberCard);

        }catch (Exception e){

            responseObject.code = ResponseObject.serverError;
            responseObject.msg = e.getLocalizedMessage();

        }

        return responseObject;

    }

}
