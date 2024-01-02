package cn.dmai.frame.base.mybatis.util;

import java.lang.annotation.*;

/**
 * @Author linchengdong
 * @Date 2023-12-04 15:15
 * @PackageName:cn.dmai.virtual.housekeeper
 * @ClassName: Query
 * @Description: TODO
 * @Version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
public @interface Query {
    String column();

    QueryType expression() default QueryType.EQ;

    boolean left() default false;
}
