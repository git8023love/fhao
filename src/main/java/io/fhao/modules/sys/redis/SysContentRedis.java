package io.fhao.modules.sys.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.fhao.common.utils.RedisUtils;
import io.fhao.modules.sys.entity.SysContent;

/**
 * @author hgw
 * @Description: TODO()
 * @date 2017-9-5 10:28
 */
@Component
public class SysContentRedis {

    private static final String NAME="SysContent:";

    @Autowired
    private RedisUtils redisUtils;

    public void saveOrUpdate(SysContent content) {
        if(content==null){
            return ;
        }

        String id=NAME+content.getId();
        redisUtils.set(id, content);
    }

    public void delete(SysContent content) {
        if(content==null){
            return ;
        }

        redisUtils.delete(NAME+content.getId());
    }

    public SysContent get(Object key){
        return redisUtils.get(NAME+key, SysContent.class);
    }

}
