package io.fhao.modules.sys.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author hgw
 * @Description: TODO(商品表)
 * @date 2018-07-25 18:23:30
 */
public class SysSaleGoods implements Serializable {
	
	//
	private Long id;
	//商品条码
	private Long vgno;
	//商品编号
	private Long goodsNo;
	//商品中文名称
	private String goodsName;
	//商品英文名称
	private String englishName;
	//售价
	private Double price;
	//供应商ID
	private Long supplyId;
	//商品类型ID
	private Long categoryId;
	//创建时间
	private Date createTime;
	//更新时间
	private Date updateTime;
	//供应商名称
	private String supplyName;
	//类别名称
	private String categoryName;

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
	 * 设置：商品条码
	 */
	public void setVgno(Long vgno) {
		this.vgno = vgno;
	}
	/**
	 * 获取：商品条码
	 */
	public Long getVgno() {
		return vgno;
	}
	/**
	 * 设置：商品编号
	 */
	public void setGoodsNo(Long goodsNo) {
		this.goodsNo = goodsNo;
	}
	/**
	 * 获取：商品编号
	 */
	public Long getGoodsNo() {
		return goodsNo;
	}
	/**
	 * 设置：商品中文名称
	 */
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	/**
	 * 获取：商品中文名称
	 */
	public String getGoodsName() {
		return goodsName;
	}
	/**
	 * 设置：商品英文名称
	 */
	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}
	/**
	 * 获取：商品英文名称
	 */
	public String getEnglishName() {
		return englishName;
	}
	/**
	 * 设置：售价
	 */
	public void setPrice(Double price) {
		this.price = price;
	}
	/**
	 * 获取：售价
	 */
	public Double getPrice() {
		return price;
	}
	/**
	 * 设置：供应商ID
	 */
	public void setSupplyId(Long supplyId) {
		this.supplyId = supplyId;
	}
	/**
	 * 获取：供应商ID
	 */
	public Long getSupplyId() {
		return supplyId;
	}
	/**
	 * 设置：商品类型ID
	 */
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	/**
	 * 获取：商品类型ID
	 */
	public Long getCategoryId() {
		return categoryId;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：更新时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：更新时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * @return the supplyName
	 */
	public String getSupplyName() {
		return supplyName;
	}
	/**
	 * @param supplyName the supplyName to set
	 */
	public void setSupplyName(String supplyName) {
		this.supplyName = supplyName;
	}
	/**
	 * @return the categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}
	/**
	 * @param categoryName the categoryName to set
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
