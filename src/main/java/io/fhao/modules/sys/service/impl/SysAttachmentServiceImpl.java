package io.fhao.modules.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.fhao.modules.sys.dao.SysAttachmentDao;
import io.fhao.modules.sys.entity.SysAttachment;
import io.fhao.modules.sys.service.SysAttachmentService;

import java.util.List;
import java.util.Map;

/**
 * @author hgw
 * @Description: TODO()
 * @date 2017-7-10 17:02
 */
@Service("sysAttachmentService")
public class SysAttachmentServiceImpl implements SysAttachmentService {

    @Autowired
    private SysAttachmentDao sysAttachmentDao;

    @Override
    public List<SysAttachment> queryList(Map<String, Object> map) {
        return sysAttachmentDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return sysAttachmentDao.queryTotal(map);
    }

    @Override
    public SysAttachment queryObject(Long id) {
        return sysAttachmentDao.queryObject(id);
    }

    @Override
    @Transactional
    public void deleteBatch(Long[] ids) {
        sysAttachmentDao.deleteBatch(ids);
    }

    @Override
    @Transactional
    public void save(SysAttachment sysAttachment) {
        sysAttachmentDao.save(sysAttachment);
    }

}
