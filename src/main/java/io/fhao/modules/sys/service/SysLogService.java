package io.fhao.modules.sys.service;

import java.util.List;
import java.util.Map;

import io.fhao.modules.sys.entity.SysLog;

public interface SysLogService {
	
	SysLog queryObject(Long id);
	
	List<SysLog> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SysLog sysLog);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
