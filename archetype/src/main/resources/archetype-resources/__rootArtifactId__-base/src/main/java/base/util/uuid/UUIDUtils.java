#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.base.util.uuid;

import java.util.UUID;

/**
 * @Author linchengdong
 * @Date 2023-11-29 15:27
 * @PackageName:${package}.base.util.uuid
 * @ClassName: UUIDUtils
 * @Description: TODO
 * @Version 1.0
 */
public class UUIDUtils {

    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
