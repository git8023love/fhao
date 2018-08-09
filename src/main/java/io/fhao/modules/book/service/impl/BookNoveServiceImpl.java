package io.fhao.modules.book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import io.fhao.modules.book.dao.BookNoveDao;
import io.fhao.modules.book.entity.BookNove;
import io.fhao.modules.book.service.BookNoveService;

@Service("bookNoveService")
public class BookNoveServiceImpl implements BookNoveService {

	@Autowired
	private BookNoveDao bookNoveDao;
	
	@Override
	public BookNove queryObject(Long id){
		return bookNoveDao.queryObject(id);
	}
	
	@Override
	public List<BookNove> queryList(Map<String, Object> map){
		return bookNoveDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return bookNoveDao.queryTotal(map);
	}
	
	@Override
	public void save(BookNove bookNove){
		bookNoveDao.save(bookNove);
	}
	
	@Override
	public void update(BookNove bookNove){
		bookNoveDao.update(bookNove);
	}
	
	@Override
	public void delete(Long id){
		bookNoveDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		bookNoveDao.deleteBatch(ids);
	}
	
}
