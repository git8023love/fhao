package io.fhao.modules.book.service;

import io.fhao.modules.book.entity.BookStyle;
import java.util.List;
import java.util.Map;

/**
 * @author hgw
 * @Description: TODO(小说分类表)
 * @date 2018-08-08 14:04:23
 */
public interface BookStyleService {
	
	BookStyle queryObject(Long id);
	
	List<BookStyle> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(BookStyle bookStyle);
	
	void update(BookStyle bookStyle);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);

}
