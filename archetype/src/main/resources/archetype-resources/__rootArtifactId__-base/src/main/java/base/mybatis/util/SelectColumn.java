#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.base.mybatis.util;

import java.lang.annotation.*;

/**
 * @Author linchengdong
 * @Date 2023-12-04 15:10
 * @PackageName:cn.dmai.virtual.housekeeper
 * @ClassName: SelectColumn
 * @Description: TODO
 * @Version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface SelectColumn {

    String[] value() default {};
}
