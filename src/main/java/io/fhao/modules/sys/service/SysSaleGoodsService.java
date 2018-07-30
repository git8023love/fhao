package io.fhao.modules.sys.service;

import java.util.List;
import java.util.Map;

import io.fhao.modules.sys.entity.SysSaleGoods;

/**
 * @author hgw
 * @Description: TODO(商品表)
 * @date 2018-07-25 18:23:30
 */
public interface SysSaleGoodsService {
	
	SysSaleGoods queryObject(Long id);
	
	List<SysSaleGoods> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SysSaleGoods saleGoods);
	
	void update(SysSaleGoods saleGoods);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);

}
