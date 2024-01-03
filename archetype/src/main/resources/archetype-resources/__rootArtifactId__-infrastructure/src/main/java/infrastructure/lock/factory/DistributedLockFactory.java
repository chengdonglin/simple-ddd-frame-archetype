#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.infrastructure.lock.factory;

import ${package}.infrastructure.lock.DistributedLock;

/**
 * @Author linchengdong
 * @Date 2023-11-30 10:17
 * @PackageName:${package}.infrastructure.lock.factory
 * @ClassName: DistributedLockFactory
 * @Description: 分布式锁工厂
 * @Version 1.0
 */
public interface DistributedLockFactory {

    /**
     * 根据key获取分布式锁
     * @param key
     * @return
     */
    DistributedLock getDistributedLock(String key);
}
