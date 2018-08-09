package io.fhao.modules.book.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author hgw
 * @Description: TODO(目录信息表)
 * @date 2018-08-08 14:04:23
 */
public class BookNove implements Serializable {
	
	//小说
	private Long id;
	//小说名
	private String name;
	//分类ID
	private Long styleid;
	//图片路径
	private String noveimgurl;
	//该文章原本的地址( 便于后期更新 )
	private String noveurl;
	//小说简介
	private String synopsis;
	//分类名称
	private String styleName;

	/**
	 * 设置：小说
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：小说
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：小说名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：小说名
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：分类ID
	 */
	public void setStyleid(Long styleid) {
		this.styleid = styleid;
	}
	/**
	 * 获取：分类ID
	 */
	public Long getStyleid() {
		return styleid;
	}
	/**
	 * 设置：图片路径
	 */
	public void setNoveimgurl(String noveimgurl) {
		this.noveimgurl = noveimgurl;
	}
	/**
	 * 获取：图片路径
	 */
	public String getNoveimgurl() {
		return noveimgurl;
	}
	/**
	 * 设置：该文章原本的地址( 便于后期更新 )
	 */
	public void setNoveurl(String noveurl) {
		this.noveurl = noveurl;
	}
	/**
	 * 获取：该文章原本的地址( 便于后期更新 )
	 */
	public String getNoveurl() {
		return noveurl;
	}
	/**
	 * 设置：小说简介
	 */
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	/**
	 * 获取：小说简介
	 */
	public String getSynopsis() {
		return synopsis;
	}

	public String getStyleName() {
		return styleName;
	}

	public void setStyleName(String styleName) {
		this.styleName = styleName;
	}
}
