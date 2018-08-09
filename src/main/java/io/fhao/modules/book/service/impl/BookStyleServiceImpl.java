package io.fhao.modules.book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import io.fhao.modules.book.dao.BookStyleDao;
import io.fhao.modules.book.entity.BookStyle;
import io.fhao.modules.book.service.BookStyleService;

@Service("bookStyleService")
public class BookStyleServiceImpl implements BookStyleService {

	@Autowired
	private BookStyleDao bookStyleDao;
	
	@Override
	public BookStyle queryObject(Long id){
		return bookStyleDao.queryObject(id);
	}
	
	@Override
	public List<BookStyle> queryList(Map<String, Object> map){
		return bookStyleDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return bookStyleDao.queryTotal(map);
	}
	
	@Override
	public void save(BookStyle bookStyle){
		bookStyleDao.save(bookStyle);
	}
	
	@Override
	public void update(BookStyle bookStyle){
		bookStyleDao.update(bookStyle);
	}
	
	@Override
	public void delete(Long id){
		bookStyleDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		bookStyleDao.deleteBatch(ids);
	}
	
}
