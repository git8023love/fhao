package io.fhao.modules.sale.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author hgw
 * @Description: TODO(供应商)
 * @date 2018-07-26 15:18:24
 */
public class SaleSupply implements Serializable {
	
	//
	private Long id;
	//供应商名称
	private String name;
	//供应商缩写
	private String shortname;
	//付款单位名称
	private String unitname;
	//地址
	private String address;
	//网址
	private String www;
	//邮箱
	private String email;
	//公司电话
	private String telno;
	//公司传真
	private String faxno;
	//联系人
	private String cman;
	//传呼/手机
	private String bpno;
	//邮政编码
	private String zipno;
	//开户银行
	private String khbank;
	//银行帐号
	private String accno;
	//经营范围
	private String bscope;
	//
	private String taxno;
	//法人代表
	private String juridicalperson;
	//条码
	private BigDecimal barcodefee;
	//谈判级别
	private String negotiationlevel;
	//代理级别
	private String agencylevel;
	//省份
	private String povince;
	//城市
	private String city;
	//县/区
	private String district;
	//区域标志
	private Integer areaflag;
	//供应商类型
	private Integer supplytype;
	//供应商经营类型 0=区域供应商 1=全国供应商
	private Integer supregionflag;

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
	 * 设置：供应商名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：供应商名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：供应商缩写
	 */
	public void setShortname(String shortname) {
		this.shortname = shortname;
	}
	/**
	 * 获取：供应商缩写
	 */
	public String getShortname() {
		return shortname;
	}
	/**
	 * 设置：付款单位名称
	 */
	public void setUnitname(String unitname) {
		this.unitname = unitname;
	}
	/**
	 * 获取：付款单位名称
	 */
	public String getUnitname() {
		return unitname;
	}
	/**
	 * 设置：地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：地址
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：网址
	 */
	public void setWww(String www) {
		this.www = www;
	}
	/**
	 * 获取：网址
	 */
	public String getWww() {
		return www;
	}
	/**
	 * 设置：邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 获取：邮箱
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 设置：公司电话
	 */
	public void setTelno(String telno) {
		this.telno = telno;
	}
	/**
	 * 获取：公司电话
	 */
	public String getTelno() {
		return telno;
	}
	/**
	 * 设置：公司传真
	 */
	public void setFaxno(String faxno) {
		this.faxno = faxno;
	}
	/**
	 * 获取：公司传真
	 */
	public String getFaxno() {
		return faxno;
	}
	/**
	 * 设置：联系人
	 */
	public void setCman(String cman) {
		this.cman = cman;
	}
	/**
	 * 获取：联系人
	 */
	public String getCman() {
		return cman;
	}
	/**
	 * 设置：传呼/手机
	 */
	public void setBpno(String bpno) {
		this.bpno = bpno;
	}
	/**
	 * 获取：传呼/手机
	 */
	public String getBpno() {
		return bpno;
	}
	/**
	 * 设置：邮政编码
	 */
	public void setZipno(String zipno) {
		this.zipno = zipno;
	}
	/**
	 * 获取：邮政编码
	 */
	public String getZipno() {
		return zipno;
	}
	/**
	 * 设置：开户银行
	 */
	public void setKhbank(String khbank) {
		this.khbank = khbank;
	}
	/**
	 * 获取：开户银行
	 */
	public String getKhbank() {
		return khbank;
	}
	/**
	 * 设置：银行帐号
	 */
	public void setAccno(String accno) {
		this.accno = accno;
	}
	/**
	 * 获取：银行帐号
	 */
	public String getAccno() {
		return accno;
	}
	/**
	 * 设置：经营范围
	 */
	public void setBscope(String bscope) {
		this.bscope = bscope;
	}
	/**
	 * 获取：经营范围
	 */
	public String getBscope() {
		return bscope;
	}
	/**
	 * 设置：
	 */
	public void setTaxno(String taxno) {
		this.taxno = taxno;
	}
	/**
	 * 获取：
	 */
	public String getTaxno() {
		return taxno;
	}
	/**
	 * 设置：法人代表
	 */
	public void setJuridicalperson(String juridicalperson) {
		this.juridicalperson = juridicalperson;
	}
	/**
	 * 获取：法人代表
	 */
	public String getJuridicalperson() {
		return juridicalperson;
	}
	/**
	 * 设置：条码
	 */
	public void setBarcodefee(BigDecimal barcodefee) {
		this.barcodefee = barcodefee;
	}
	/**
	 * 获取：条码
	 */
	public BigDecimal getBarcodefee() {
		return barcodefee;
	}
	/**
	 * 设置：谈判级别
	 */
	public void setNegotiationlevel(String negotiationlevel) {
		this.negotiationlevel = negotiationlevel;
	}
	/**
	 * 获取：谈判级别
	 */
	public String getNegotiationlevel() {
		return negotiationlevel;
	}
	/**
	 * 设置：代理级别
	 */
	public void setAgencylevel(String agencylevel) {
		this.agencylevel = agencylevel;
	}
	/**
	 * 获取：代理级别
	 */
	public String getAgencylevel() {
		return agencylevel;
	}
	/**
	 * 设置：省份
	 */
	public void setPovince(String povince) {
		this.povince = povince;
	}
	/**
	 * 获取：省份
	 */
	public String getPovince() {
		return povince;
	}
	/**
	 * 设置：城市
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * 获取：城市
	 */
	public String getCity() {
		return city;
	}
	/**
	 * 设置：县/区
	 */
	public void setDistrict(String district) {
		this.district = district;
	}
	/**
	 * 获取：县/区
	 */
	public String getDistrict() {
		return district;
	}
	/**
	 * 设置：区域标志
	 */
	public void setAreaflag(Integer areaflag) {
		this.areaflag = areaflag;
	}
	/**
	 * 获取：区域标志
	 */
	public Integer getAreaflag() {
		return areaflag;
	}
	/**
	 * 设置：供应商类型
	 */
	public void setSupplytype(Integer supplytype) {
		this.supplytype = supplytype;
	}
	/**
	 * 获取：供应商类型
	 */
	public Integer getSupplytype() {
		return supplytype;
	}
	/**
	 * 设置：供应商经营类型 0=区域供应商 1=全国供应商
	 */
	public void setSupregionflag(Integer supregionflag) {
		this.supregionflag = supregionflag;
	}
	/**
	 * 获取：供应商经营类型 0=区域供应商 1=全国供应商
	 */
	public Integer getSupregionflag() {
		return supregionflag;
	}

}
