package io.fhao.modules.sale.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.fhao.modules.sale.dao.SaleSupplyDao;
import io.fhao.modules.sale.entity.SaleSupply;
import io.fhao.modules.sale.service.SaleSupplyService;

import java.util.List;
import java.util.Map;

@Service("saleSupplyService")
public class SaleSupplyServiceImpl implements SaleSupplyService {

	@Autowired
	private SaleSupplyDao saleSupplyDao;
	
	@Override
	public SaleSupply queryObject(Long id){
		return saleSupplyDao.queryObject(id);
	}
	
	@Override
	public List<SaleSupply> queryList(Map<String, Object> map){
		return saleSupplyDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return saleSupplyDao.queryTotal(map);
	}
	
	@Override
	public void save(SaleSupply saleSupply){
		saleSupplyDao.save(saleSupply);
	}
	
	@Override
	public void update(SaleSupply saleSupply){
		saleSupplyDao.update(saleSupply);
	}
	
	@Override
	public void delete(Long id){
		saleSupplyDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		saleSupplyDao.deleteBatch(ids);
	}
	
}
