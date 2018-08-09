package io.fhao.modules.book.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author hgw
 * @Description: TODO(小说分类表)
 * @date 2018-08-08 14:04:23
 */
public class BookStyle implements Serializable {
	
	//分类
	private Long id;
	//分类名
	private String name;
	//父分类ID
	private Long parentId;
	//父分类名称
	private String parentName;
	//排序
	private Long remd;

	private Boolean open;

	private List<?> list;

	/**
	 * 设置：分类
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：分类
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：分类名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：分类名
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：父分类ID
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	/**
	 * 获取：父分类ID
	 */
	public Long getParentId() {
		return parentId;
	}
	/**
	 * 设置：排序
	 */
	public void setRemd(Long remd) {
		this.remd = remd;
	}
	/**
	 * 获取：排序
	 */
	public Long getRemd() {
		return remd;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public Boolean getOpen() {
		return open;
	}

	public void setOpen(Boolean open) {
		this.open = open;
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}
}
