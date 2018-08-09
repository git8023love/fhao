package io.fhao.modules.sale.service;

import java.util.List;
import java.util.Map;

import io.fhao.modules.sale.entity.SaleSupply;

/**
 * @author hgw
 * @Description: TODO(供应商)
 * @date 2018-07-26 15:18:24
 */
public interface SaleSupplyService {
	
	SaleSupply queryObject(Long id);
	
	List<SaleSupply> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SaleSupply saleSupply);
	
	void update(SaleSupply saleSupply);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);

}
