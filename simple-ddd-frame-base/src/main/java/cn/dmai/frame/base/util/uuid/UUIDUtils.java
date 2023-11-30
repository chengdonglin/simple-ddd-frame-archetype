package cn.dmai.frame.base.util.uuid;

import java.util.UUID;

/**
 * @Author linchengdong
 * @Date 2023-11-29 15:27
 * @PackageName:cn.dmai.frame.base.util.uuid
 * @ClassName: UUIDUtils
 * @Description: TODO
 * @Version 1.0
 */
public class UUIDUtils {

    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
