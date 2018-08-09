package io.fhao.modules.book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import io.fhao.modules.book.dao.BookChapterDao;
import io.fhao.modules.book.entity.BookChapter;
import io.fhao.modules.book.service.BookChapterService;

@Service("bookChapterService")
public class BookChapterServiceImpl implements BookChapterService {

	@Autowired
	private BookChapterDao bookChapterDao;
	
	@Override
	public BookChapter queryObject(Long id){
		return bookChapterDao.queryObject(id);
	}
	
	@Override
	public List<BookChapter> queryList(Map<String, Object> map){
		return bookChapterDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return bookChapterDao.queryTotal(map);
	}
	
	@Override
	public void save(BookChapter bookChapter){
		bookChapterDao.save(bookChapter);
	}
	
	@Override
	public void update(BookChapter bookChapter){
		bookChapterDao.update(bookChapter);
	}
	
	@Override
	public void delete(Long id){
		bookChapterDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		bookChapterDao.deleteBatch(ids);
	}
	
}
