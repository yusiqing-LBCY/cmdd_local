package cn.com.cmdd.controller;


import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import cn.com.cmdd.constant.KEYS;
import cn.com.cmdd.service.ImageService;
import cn.com.cmdd.util.ResponseObject;

@Controller//@CrossOrigin(origins = "*")
public class ImageController {
	
	@Autowired
	private ImageService imageService;
	
	@RequestMapping(value="/image/{id}",method=RequestMethod.GET)
	public void getImage(HttpServletResponse response, @PathVariable("id") Integer id){
		try{
			byte[] buf = imageService.getImage(id);
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setContentType("image/png");
			response.setContentLength(buf.length);
			OutputStream out = response.getOutputStream();
			try{
				FileCopyUtils.copy(buf, out);
				response.flushBuffer();
			}catch (Exception e) {
				return;
			}finally{
				out.close();
			}
		}
		catch (Exception e) {
			return;
		}
	}
	
	@RequestMapping(value="/image/{id}",method=RequestMethod.DELETE)
	@ResponseBody
	public ResponseObject deleteImage(HttpServletRequest request,
									  HttpServletResponse response,
									  @PathVariable("id") Integer id){
		if(!AuthCheck.UserCheck(request, response, KEYS.AGENT)){
			if(!AuthCheck.UserCheck(request, response, KEYS.SHOP)){	
				return null;
			}
		}
		
		ResponseObject responseObject  = new ResponseObject(ResponseObject.ok,null);
		try{
			Integer image_id = imageService.DeleteImage(id);
			Map<String,Object> resultMap = new HashMap<String,Object>();
			resultMap.put("image_id", image_id);
			responseObject.msg = resultMap;
		}catch(Exception e){
			responseObject.code = ResponseObject.serverError;
			responseObject.msg = e.getLocalizedMessage();
			e.printStackTrace();
		}
		return responseObject;
	}
	
	@RequestMapping(value="/image",method=RequestMethod.POST)
	@ResponseBody
	public ResponseObject addImage(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value="id" ,required =false)Integer id, 
			@RequestParam(value = "file", required = false) MultipartFile file) throws IOException{
		
		
		ResponseObject responseObject  = new ResponseObject(ResponseObject.ok,null);
		try{
			Integer image_id = imageService.addImage(id, file);
			Map<String,Object> resultMap = new HashMap<String,Object>();
			resultMap.put("image_id", image_id);
			responseObject.msg = resultMap;
		}catch(Exception e){
			responseObject.code = ResponseObject.serverError;
			responseObject.msg = e.getLocalizedMessage();
			e.printStackTrace();
		}
		return responseObject;
	}
	
}
