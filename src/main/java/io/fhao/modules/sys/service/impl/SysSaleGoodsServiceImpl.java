package io.fhao.modules.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.fhao.common.utils.DateUtils;
import io.fhao.modules.sys.dao.SysSaleGoodsDao;
import io.fhao.modules.sys.entity.SysSaleGoods;
import io.fhao.modules.sys.service.SysSaleGoodsService;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("saleGoodsService")
public class SysSaleGoodsServiceImpl implements SysSaleGoodsService {

	@Autowired
	private SysSaleGoodsDao saleGoodsDao;
	
	@Override
	public SysSaleGoods queryObject(Long id){
		return saleGoodsDao.queryObject(id);
	}
	
	@Override
	public List<SysSaleGoods> queryList(Map<String, Object> map){
		return saleGoodsDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return saleGoodsDao.queryTotal(map);
	}
	
	@Override
	public void save(SysSaleGoods saleGoods){
		saleGoods.setCreateTime(new Date());
		saleGoods.setUpdateTime(new Date());
		saleGoodsDao.save(saleGoods);
	}
	
	@Override
	public void update(SysSaleGoods saleGoods){
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
