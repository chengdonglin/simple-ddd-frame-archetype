package cn.dmai.frame.base.mybatis.util;

import java.lang.annotation.*;

/**
 * @Author linchengdong
 * @Date 2023-12-04 15:14
 * @PackageName:cn.dmai.virtual.housekeeper
 * @ClassName: QueryOrder
 * @Description: TODO
 * @Version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
public @interface QueryOrder {
    String value() default "desc";
}
