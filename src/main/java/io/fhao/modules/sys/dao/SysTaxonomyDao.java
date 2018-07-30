package io.fhao.modules.sys.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import io.fhao.modules.sys.entity.SysTaxonomy;

import java.util.List;

/**
 * @author hgw
 * @Description: TODO()
 * @date 2017-8-22 10:21
 */
@Mapper
public interface SysTaxonomyDao extends BaseDao<SysTaxonomy>{

    List<SysTaxonomy> queryListByParentId(Long parentId);

    List<SysTaxonomy> queryListByType(@Param("type") Integer type);

    SysTaxonomy queryObjectBySlug(@Param("slug") String slug);

}
