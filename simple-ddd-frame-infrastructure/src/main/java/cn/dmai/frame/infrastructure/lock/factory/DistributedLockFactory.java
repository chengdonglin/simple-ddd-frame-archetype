package cn.dmai.frame.infrastructure.lock.factory;

import cn.dmai.frame.infrastructure.lock.DistributedLock;

/**
 * @Author linchengdong
 * @Date 2023-11-30 10:17
 * @PackageName:cn.dmai.frame.infrastructure.lock.factory
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
