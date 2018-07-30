package io.fhao.modules.sys.dao;

import org.apache.ibatis.annotations.Mapper;

import io.fhao.modules.sys.entity.SysDept;

import java.util.List;

@Mapper
public interface SysDeptDao extends BaseDao<SysDept> {

    /**
     * 查询子部门ID列表
     * @param parentId  上级部门ID
     */
    List<Long> queryDetpIdList(Long parentId);

}
