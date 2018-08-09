package io.fhao.modules.sale.dao;

import io.fhao.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import io.fhao.modules.sale.entity.SaleGoods;

@Mapper
public interface SaleGoodsDao extends BaseDao<SaleGoods> {
	
}
