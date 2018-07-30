package io.fhao.modules.sys.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import io.fhao.modules.sys.entity.SysContentTaxonomy;

import java.util.List;

@Mapper
public interface SysContentTaxonomyDao extends BaseDao<SysContentTaxonomy> {

    /**
     * 根据内容ID 类型，获取分类,专题,标签ID列表
     */
    List<Long> queryTaxonomyIdList(@Param("contentId") Long contentId, @Param("types") Integer[] types);

    /**
     * 根据内容ID 类型，获取分类,专题,标签的name列表
     */
    List<String> queryTaxonomyNameList(@Param("contentId") Long contentId, @Param("types") Integer[] types);
	
}
