package io.fhao.modules.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.fhao.common.Constant;
import io.fhao.common.utils.ShiroUtils;
import io.fhao.modules.sys.dao.SysContentDao;
import io.fhao.modules.sys.entity.SysContent;
import io.fhao.common.redis.SysContentRedis;
import io.fhao.modules.sys.service.SysContentService;
import io.fhao.modules.sys.service.SysContentTaxonomyService;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("sysContentService")
public class SysContentServiceImpl implements SysContentService {

	@Autowired
	private SysContentRedis sysContentRedis;

	@Autowired
	private SysContentDao sysContentDao;

	@Autowired
	private SysContentTaxonomyService sysContentTaxonomyService;
	
	@Override
	public SysContent queryObject(Long id){
		SysContent content = sysContentRedis.get(id);
		if(content == null){
			content = sysContentDao.queryObject(id);
			sysContentRedis.saveOrUpdate(content);
		}
		return content;
	}
	
	@Override
	public List<SysContent> queryList(Map<String, Object> map){
		return sysContentDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return sysContentDao.queryTotal(map);
	}
	
	@Override
	@Transactional
	public void save(SysContent content){
		content.setStatus(Constant.ContentStatus.NORMAL.getValue());
		content.setUserId(ShiroUtils.getUserId());
		content.setCreateTime(new Date());
		sysContentDao.save(content);

		//保存内容与分类专题关系
		sysContentTaxonomyService.saveOrUpdate(content.getId(), content.getTaxonomyIdList(), content.getTagNames());

		sysContentRedis.saveOrUpdate(content);
	}
	
	@Override
	@Transactional
	public void update(SysContent content){
		sysContentRedis.delete(content);

		content.setModifyTime(new Date());
		sysContentDao.update(content);

		//保存内容与分类专题关系
		sysContentTaxonomyService.saveOrUpdate(content.getId(), content.getTaxonomyIdList(), content.getTagNames());
	}
	
	@Override
	@Transactional
	public void deleteBatch(Long[] ids){
		for(Long id : ids){
			SysContent content = queryObject(id);
			sysContentRedis.delete(content);
		}

		sysContentDao.deleteBatch(ids);

		//删除内容与分类专题关系
		sysContentTaxonomyService.deleteBatch(ids);
	}
	
}
