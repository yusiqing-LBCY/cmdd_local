package cn.com.cmdd.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import cn.com.cmdd.dao.MemberCardDao;
import cn.com.cmdd.domain.MemberCard;
import cn.com.cmdd.util.ResponseObject;

@Controller//@CrossOrigin(origins = "*")
@RequestMapping(value = "/member/member_card")
public class MemberCardContrller {

    @Autowired
    MemberCardDao memberCardDao;

    //@GetMapping(value = "/{id}")
    @RequestMapping(value="{id}",method=RequestMethod.GET)
    @ResponseBody
    public ResponseObject get(@PathVariable("id")Integer id){
        ResponseObject responseObject = new ResponseObject(ResponseObject.ok, null);

        try{

            responseObject.msg = memberCardDao.select(id);

        }catch (Exception e){

            responseObject.code = ResponseObject.serverError;
            responseObject.msg = e.getLocalizedMessage();
        }

        return responseObject;
    }

    //@GetMapping(value = "/shop_id/{shop_id}")
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

            responseObject.msg = memberCardDao.insert(memberCard);

        }catch (Exception e){

            responseObject.code = ResponseObject.serverError;
            responseObject.msg = e.getLocalizedMessage();
        }

        return responseObject;

    }
    //@CrossOrigin(origins = "*")
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
