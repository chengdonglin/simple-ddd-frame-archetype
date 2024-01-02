package cn.dmai.frame.base.mybatis.util;

import java.lang.annotation.*;

/**
 * @Author linchengdong
 * @Date 2023-12-04 15:13
 * @PackageName:cn.dmai.virtual.housekeeper
 * @ClassName: QuerySort
 * @Description: TODO
 * @Version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
public @interface QuerySort {
    String value() default "";
}
