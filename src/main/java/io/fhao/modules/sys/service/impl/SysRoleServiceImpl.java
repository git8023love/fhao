package io.fhao.modules.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.fhao.modules.sys.dao.SysRoleDao;
import io.fhao.modules.sys.entity.SysRole;
import io.fhao.modules.sys.service.SysRoleMenuService;
import io.fhao.modules.sys.service.SysRoleService;
import io.fhao.modules.sys.service.SysUserRoleService;
import io.fhao.modules.sys.service.SysUserService;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("sysRoleService")
public class SysRoleServiceImpl implements SysRoleService {

	@Autowired
	private SysRoleDao sysRoleDao;

	@Autowired
	private SysRoleMenuService sysRoleMenuService;

	@Autowired
	private SysUserRoleService sysUserRoleService;

	@Autowired
	private SysUserService sysUserService;

	@Override
	public SysRole queryObject(Long id) {
		return sysRoleDao.queryObject(id);
	}

	@Override
	public List<SysRole> queryList(Map<String, Object> map) {
		return sysRoleDao.queryList(map);
	}

	@Override
	public int queryTotal(Map<String, Object> map) {
		return sysRoleDao.queryTotal(map);
	}

	@Override
	@Transactional
	public void save(SysRole role) {
		role.setCreateTime(new Date());
		sysRoleDao.save(role);
		//保存角色与菜单关系
		sysRoleMenuService.saveOrUpdate(role.getId(), role.getMenuIdList());
	}

	@Override
	@Transactional
	public void update(SysRole role) {
		sysRoleDao.update(role);
		//更新角色与菜单关系
		sysRoleMenuService.saveOrUpdate(role.getId(), role.getMenuIdList());
	}

	@Override
	@Transactional
	public void deleteBatch(Long[] ids) {
		sysRoleDao.deleteBatch(ids);
		//删除角色与菜单关系
		sysRoleMenuService.deleteBatch(ids);
	}

}
