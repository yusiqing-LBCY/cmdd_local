package cn.com.cmdd.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.cmdd.dao.CategoryDao;
import cn.com.cmdd.domain.Category;
import cn.com.cmdd.service.CategoryService;
import cn.com.cmdd.util.ResponseObject;

/**
 * @typeName CategoryController
 * @description 
		Summary : TODO 
		Member Property :TODO
		Member Method:TODO
 * @author yusiqing
 * @date 2017年6月13日 下午6:45:34
 */
@Controller//@CrossOrigin(origins = "*")
public class CategoryController {
	
	private final static org.slf4j.Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private CategoryDao categoryDao;
		
	@RequestMapping(value="/category",method=RequestMethod.POST)
	@ResponseBody
	public ResponseObject saveCategory(
										HttpServletRequest request,
										HttpServletResponse response,
										@RequestBody Category category
																			){
		
		/*if(!AuthCheck.UserCheck(request, response, KEYS.SHOP)){
			return null;
		}*/
		
		ResponseObject responseObject = new ResponseObject(ResponseObject.ok,null);
		
		try {
			Integer id = categoryService.saveCategory(category);
			HashMap<String,Object> resultMap = new HashMap<String,Object>();
			resultMap.put("Category_id", id);
			responseObject.msg=resultMap;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			responseObject.code=ResponseObject.serverError;
			responseObject.msg=e.getLocalizedMessage();
			e.printStackTrace();
		}
		return responseObject;
	}
	
	@RequestMapping(value="/shop/{id}/category/list",method=RequestMethod.GET)
	@ResponseBody
	public ResponseObject getCategory(HttpServletRequest request,HttpServletResponse response,@PathVariable("id")Integer shop_id){
		ResponseObject responseObject = new ResponseObject(ResponseObject.ok,null);
		
		try {
			responseObject.msg=categoryService.getCategory(shop_id, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			responseObject.code=ResponseObject.serverError;
			responseObject.msg=e.getLocalizedMessage();
			e.printStackTrace();
		}
		return responseObject;
	}
	
	@RequestMapping(value="/category/{id}",method=RequestMethod.PUT)
	@ResponseBody
	public ResponseObject updateCategory(HttpServletRequest request,HttpServletResponse response,@PathVariable("id")Integer id,@RequestBody Category category){
		
		/*if(!AuthCheck.UserCheck(request, response, KEYS.SHOP)){
			return null;
		}*/
		
		ResponseObject responseObject = new ResponseObject(ResponseObject.ok,null);
		
		try {
			categoryService.updateCategory(category);
			HashMap<String,Object> resultMap = new HashMap<String,Object>();
			resultMap.put("Category_id", id);
			responseObject.msg=resultMap;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			responseObject.code=ResponseObject.serverError;
			responseObject.msg=e.getLocalizedMessage();
			e.printStackTrace();
		}
		return responseObject;
	}
	
	@RequestMapping(value="/category/{id}",method=RequestMethod.GET)
	@ResponseBody
	public ResponseObject getCategoryById(HttpServletRequest request,HttpServletResponse response,@PathVariable("id")Integer id){
				
		ResponseObject responseObject = new ResponseObject(ResponseObject.ok,null);
		
		try {					
			responseObject.msg = categoryService.getCategory(null, id).get(0);		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			responseObject.code=ResponseObject.serverError;
			responseObject.msg=e.getLocalizedMessage();
			e.printStackTrace();
		}
		return responseObject;
	}
	
	@RequestMapping(value="/category/{id}",method=RequestMethod.DELETE)
	@ResponseBody
	public ResponseObject deleteCategory(HttpServletRequest request,HttpServletResponse response,@PathVariable("id")Integer id){
		
		/*if(!AuthCheck.UserCheck(request, response, KEYS.SHOP)){
			return null;
		}*/
		
		ResponseObject responseObject = new ResponseObject(ResponseObject.ok,null);
		
		try {
			categoryService.deleteCategory(id);
			HashMap<String, Object> resultmap = new HashMap<String,Object>();
			resultmap.put("Category_id", id);
			responseObject.msg=resultmap;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			responseObject.code=ResponseObject.serverError;
			responseObject.msg=e.getLocalizedMessage();
			e.printStackTrace();
		}
		return responseObject;
	}	
	
	
	@RequestMapping(value="/category/isUpload",method=RequestMethod.GET)
	@ResponseBody
	public ResponseObject isUpload(HttpServletRequest request,HttpServletResponse response){
		ResponseObject responseObject = new ResponseObject(ResponseObject.ok,null);
		
		try {
			
			responseObject.msg=categoryDao.getCategoselectByIsUpload();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			responseObject.code=ResponseObject.serverError;
			responseObject.msg=e.getLocalizedMessage();
			e.printStackTrace();
		}
		return responseObject;
	}
	
	@RequestMapping(value="/category/isUpload/{id}",method=RequestMethod.PUT)
	@ResponseBody
	public ResponseObject isUpload(HttpServletRequest request,HttpServletResponse response,@PathVariable("id")Integer id){
		
		/*if(!AuthCheck.UserCheck(request, response, KEYS.SHOP)){
			return null;
		}*/
		
		ResponseObject responseObject = new ResponseObject(ResponseObject.ok,null);
		
		try {
			categoryDao.updateIsUpload(id);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			responseObject.code=ResponseObject.serverError;
			responseObject.msg=e.getLocalizedMessage();
			e.printStackTrace();
		}
		return responseObject;
	}
	
	
}
