package io.fhao.modules.book.dao;

import io.fhao.modules.book.entity.BookChapter;
import io.fhao.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookChapterDao extends BaseDao<BookChapter> {
	
}
