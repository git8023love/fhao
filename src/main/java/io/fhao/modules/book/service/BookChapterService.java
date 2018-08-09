package io.fhao.modules.book.service;

import io.fhao.modules.book.entity.BookChapter;
import java.util.List;
import java.util.Map;

/**
 * @author hgw
 * @Description: TODO(章节表)
 * @date 2018-08-08 14:04:23
 */
public interface BookChapterService {
	
	BookChapter queryObject(Long id);
	
	List<BookChapter> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(BookChapter bookChapter);
	
	void update(BookChapter bookChapter);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);

}
