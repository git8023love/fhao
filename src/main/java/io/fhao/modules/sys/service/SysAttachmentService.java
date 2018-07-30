package io.fhao.modules.sys.service;

import java.util.List;
import java.util.Map;

import io.fhao.modules.sys.entity.SysAttachment;

/**
 * @author hgw
 * @Description: TODO()
 * @date 2017-7-10 17:01
 */
public interface SysAttachmentService {

    /**
     * 获取List列表
     */
    List<SysAttachment> queryList(Map<String, Object> map);

    /**
     * 获取总记录数
     */
    int queryTotal(Map<String, Object> map);

    SysAttachment queryObject(Long id);

    void deleteBatch(Long[] ids);

    void save(SysAttachment sysAttachment);

}
