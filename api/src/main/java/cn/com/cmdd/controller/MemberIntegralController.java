package cn.com.cmdd.controller;


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

    //@PostMapping("/member_integral")
    @RequestMapping(value="/member_integral",method=RequestMethod.POST)
    @ResponseBody
    public ResponseObject saveAndUpdate(@RequestBody MemberIntegral memberIntegral){

        ResponseObject responseObject = new ResponseObject(ResponseObject.ok, null);

        try{

            responseObject.msg = memberIntegralDao.saveAndUpdateOne(memberIntegral);

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
