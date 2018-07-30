package io.fhao.modules.sys.service;

import java.util.List;
import java.util.Map;

import io.fhao.modules.sys.entity.SysSaleSupply;

/**
 * @author hgw
 * @Description: TODO(供应商)
 * @date 2018-07-26 15:18:24
 */
public interface SysSaleSupplyService {
	
	SysSaleSupply queryObject(Long id);
	
	List<SysSaleSupply> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SysSaleSupply saleSupply);
	
	void update(SysSaleSupply saleSupply);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);

}
