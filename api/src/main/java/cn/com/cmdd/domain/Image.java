package cn.com.cmdd.domain;

import org.apache.ibatis.type.Alias;

@Alias("Image")

public class Image {
	private Integer id;
	private String origin_name;
	private Long file_size;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrigin_name() {
		return origin_name;
	}
	public void setOrigin_name(String origin_name) {
		this.origin_name = origin_name;
	}
	public Long getFile_size() {
		return file_size;
	}
	public void setFile_size(Long file_size) {
		this.file_size = file_size;
	}
	
}
