package io.fhao.modules.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.fhao.modules.sys.dao.SysSaleSupplyDao;
import io.fhao.modules.sys.entity.SysSaleSupply;
import io.fhao.modules.sys.service.SysSaleSupplyService;

import java.util.List;
import java.util.Map;

@Service("saleSupplyService")
public class SysSaleSupplyServiceImpl implements SysSaleSupplyService {

	@Autowired
	private SysSaleSupplyDao saleSupplyDao;
	
	@Override
	public SysSaleSupply queryObject(Long id){
		return saleSupplyDao.queryObject(id);
	}
	
	@Override
	public List<SysSaleSupply> queryList(Map<String, Object> map){
		return saleSupplyDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return saleSupplyDao.queryTotal(map);
	}
	
	@Override
	public void save(SysSaleSupply saleSupply){
		saleSupplyDao.save(saleSupply);
	}
	
	@Override
	public void update(SysSaleSupply saleSupply){
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
