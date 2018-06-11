package cn.com.cmdd.dao;

import cn.com.cmdd.domain.Image;

public interface ImageDao {

	Image getImage(int id);

	void updateImage(Image image);

	void addImage(Image image);

	void deleteImage(Integer logo_id);

}
