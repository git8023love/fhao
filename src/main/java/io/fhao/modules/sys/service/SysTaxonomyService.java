package io.fhao.modules.sys.service;

import java.util.List;
import java.util.Map;

import io.fhao.modules.sys.entity.SysTaxonomy;

/**
 * @author hgw
 * @Description: TODO()
 * @date 2017-8-22 10:23
 */
public interface SysTaxonomyService {

    List<SysTaxonomy> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    List<SysTaxonomy> queryListByType(Integer type);

    void save(SysTaxonomy taxonomy);

    void update(SysTaxonomy taxonomy);

    void delete(Long id);

    SysTaxonomy queryObject(Long id);

    List<SysTaxonomy> queryListByParentId(Long parentId);

    SysTaxonomy queryObjectBySlug(String slug);

}
