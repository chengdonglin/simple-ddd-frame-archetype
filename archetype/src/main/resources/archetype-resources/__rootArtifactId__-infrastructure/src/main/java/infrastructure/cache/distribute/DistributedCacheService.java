#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.infrastructure.cache.distribute;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author linchengdong
 * @Date 2023-11-29 16:31
 * @PackageName:${package}.infrastructure.cache.distribute
 * @ClassName: DistributedCacheService
 * @Description: 分布式缓存接口
 * @Version 1.0
 */
public interface DistributedCacheService {

    void put(String key, String value);

    void put(String key, Object value);

    void put(String key, Object value, long timeout, TimeUnit unit);

    void put(String key, Object value, long expireTime);

    <T> T getObject(String key, Class<T> targetClass);

    Object getObject(String key);

    String getString(String key);

    <T> List<T> getList(String key, Class<T> targetClass);

    Boolean delete(String key);

    Boolean hasKey(String key);

    Long addSet(String key, Object... values);

    Long removeSet(String key, Object... values);

    Boolean isMemberSet(String key, Object o);

    /**
     * 扣减内存中的数据
     */
    default Long decrement(String key, long delta) {
        return null;
    }

    /**
     * 增加内存中的数据
     */
    default Long increment(String key, long delta) {
        return null;
    }

}
