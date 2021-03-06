package io.fhao.common.datasource.annotation;

import java.lang.annotation.*;

/**
 * @author hgw
 * @Description: TODO(多数据源注解)
 * @date 2017-9-26 16:53
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {

    String name() default "";

}
