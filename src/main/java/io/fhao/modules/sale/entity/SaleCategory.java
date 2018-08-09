package io.fhao.modules.sale.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author hgw
 * @Description: TODO(商品分类)
 * @date 2018-07-25 19:32:52
 */
public class SaleCategory implements Serializable {
	
	//
	private Long id;
	//上级部门ID，一级部门为0
	private Long parentId;
	//类别名称
	@NotBlank(message="类别名称不能为空")
	private String name;
	//上级类别名称
	private String parentName;
	
	//是否删除  -1：已删除  0：正常
	private Integer delFlag;
	/**
	 * ztree属性
	 */
	private Boolean open;

	private List<?> list;

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：上级部门ID，一级部门为0
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	/**
	 * 获取：上级部门ID，一级部门为0
	 */
	public Long getParentId() {
		return parentId;
	}
	/**
	 * 设置：类别名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：类别名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the parentName
	 */
	public String getParentName() {
		return parentName;
	}
	/**
	 * @param parentName the parentName to set
	 */
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	/**
	 * 设置：是否删除  -1：已删除  0：正常
	 */
	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}
	/**
	 * 获取：是否删除  -1：已删除  0：正常
	 */
	public Integer getDelFlag() {
		return delFlag;
	}
	/**
	 * @return the open
	 */
	public Boolean getOpen() {
		return open;
	}
	/**
	 * @param open the open to set
	 */
	public void setOpen(Boolean open) {
		this.open = open;
	}
	/**
	 * @return the list
	 */
	public List<?> getList() {
		return list;
	}
	/**
	 * @param list the list to set
	 */
	public void setList(List<?> list) {
		this.list = list;
	}

}
