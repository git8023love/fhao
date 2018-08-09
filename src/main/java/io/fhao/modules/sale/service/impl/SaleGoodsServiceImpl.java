package io.fhao.modules.sale.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.fhao.modules.sale.dao.SaleGoodsDao;
import io.fhao.modules.sale.entity.SaleGoods;
import io.fhao.modules.sale.service.SaleGoodsService;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("saleGoodsService")
public class SaleGoodsServiceImpl implements SaleGoodsService {

	@Autowired
	private SaleGoodsDao saleGoodsDao;
	
	@Override
	public SaleGoods queryObject(Long id){
		return saleGoodsDao.queryObject(id);
	}
	
	@Override
	public List<SaleGoods> queryList(Map<String, Object> map){
		return saleGoodsDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return saleGoodsDao.queryTotal(map);
	}
	
	@Override
	public void save(SaleGoods saleGoods){
		saleGoods.setCreateTime(new Date());
		saleGoods.setUpdateTime(new Date());
		saleGoodsDao.save(saleGoods);
	}
	
	@Override
	public void update(SaleGoods saleGoods){
		saleGoods.setUpdateTime(new Date());
		saleGoodsDao.update(saleGoods);
	}
	
	@Override
	public void delete(Long id){
		saleGoodsDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		saleGoodsDao.deleteBatch(ids);
	}
	
}
