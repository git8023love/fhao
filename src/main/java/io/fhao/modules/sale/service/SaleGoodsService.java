package io.fhao.modules.sale.service;

import java.util.List;
import java.util.Map;

import io.fhao.modules.sale.entity.SaleGoods;

/**
 * @author hgw
 * @Description: TODO(商品表)
 * @date 2018-07-25 18:23:30
 */
public interface SaleGoodsService {
	
	SaleGoods queryObject(Long id);
	
	List<SaleGoods> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SaleGoods saleGoods);
	
	void update(SaleGoods saleGoods);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);

}
