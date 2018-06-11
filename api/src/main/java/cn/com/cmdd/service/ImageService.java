package cn.com.cmdd.service;


import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import cn.com.cmdd.dao.ImageDao;
import cn.com.cmdd.domain.Image;
import cn.com.cmdd.util.LevelDBAPI;

@Service
public class ImageService {
	
	org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ImageService.class);
	
	@Autowired
	private ImageDao imageDao;
	
	
	public byte[] getImage(Integer id) {
		byte[] result = LevelDBAPI.get(id);
		log.info("image size is" + result.length);
		return result;
	}
	
	public int saveImage(Integer id,byte[] file){
		LevelDBAPI.post(id, file);
		
		return id;
	}
	public Integer DeleteImage(Integer id) {
		if(id > 0)
			LevelDBAPI.delete(id);
		
		return id;
	}
	
	@Transactional
	public int addImage(Integer id, MultipartFile file) throws IOException {
		if (id != null && id>0){
			Image image = imageDao.getImage(id);
			image.setOrigin_name(file.getOriginalFilename());
			image.setFile_size(file.getSize());
			imageDao.addImage(image);
			saveImage(id,file.getBytes());
			return id;
		}
		
		Image image = new Image();
		image.setOrigin_name(file.getOriginalFilename());
		image.setFile_size(file.getSize());
		imageDao.addImage(image);
		int image_id = image.getId();
		saveImage(image_id,file.getBytes());
		return image_id;
	}
}
