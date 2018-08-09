package io.fhao.modules.book.service;

import io.fhao.modules.book.entity.BookNove;
import java.util.List;
import java.util.Map;

/**
 * @author hgw
 * @Description: TODO(目录信息表)
 * @date 2018-08-08 14:04:23
 */
public interface BookNoveService {
	
	BookNove queryObject(Long id);
	
	List<BookNove> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(BookNove bookNove);
	
	void update(BookNove bookNove);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);

}
