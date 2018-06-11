package cn.com.cmdd.service;


import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.List;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.cmdd.dao.Dining_tableDao;
import cn.com.cmdd.dao.ImageDao;
import cn.com.cmdd.domain.Dining_table;
import cn.com.cmdd.domain.Image;
import cn.com.cmdd.util.EncodeImgZxing;

/**
 * @typeName Dining_tableService
 * @description 
		Summary : TODO 
		Member Property :TODO
		Member Method:TODO
 * @author yusiqing
 * @date 2017年6月12日 下午1:58:31
 */
@Service
@Transactional
public class Dining_tableService {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(Dining_tableService.class);
	
	@Autowired
	private Dining_tableDao dtd;
	
	@Autowired
	private ImageService imageService;
	
	@Autowired
	private ImageDao imageDao;
	
	public Integer saveDining_table(Dining_table dt){
		 try {
			dtd.saveDining_table(dt);
			
			//正式服
			//sBufferedImage encodeImg = EncodeImgZxing.encodeImg("http://admin.chanmaodd.com/www/#/table/"+dt.getId());
			
			//测试服
			BufferedImage encodeImg = EncodeImgZxing.encodeImg("http://test-admin.lbcy.com.cn/www/#/table/"+dt.getId());
			
			
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();			
			boolean booWrite = ImageIO.write(encodeImg,"png",byteArrayOutputStream);
			byte[] byteArray = byteArrayOutputStream.toByteArray();	
			Image image = new Image();
			image.setFile_size((long)byteArray.length);
			image.setOrigin_name("桌位id"+dt.getId()+"的二维码图片");
			imageDao.addImage(image);
			int saveImageId = imageService.saveImage(image.getId(), byteArray);
			Dining_table dining_table = new Dining_table();
			dining_table.setId(dt.getId());
			dining_table.setLogo_id(saveImageId);
			dtd.updateDining_table(dining_table);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return dt.getId();
	}
	
	public void deleteDining_table(Integer id){

		dtd.deleteDining_table(id);
	}
	
	public void updateDining_table(Dining_table dt){
		dtd.updateDining_table(dt);
	}
	
	public List<Dining_table> getDining_table(Integer shop_id, Integer id){

		return dtd.getDining_table(shop_id,id);
	}
}
