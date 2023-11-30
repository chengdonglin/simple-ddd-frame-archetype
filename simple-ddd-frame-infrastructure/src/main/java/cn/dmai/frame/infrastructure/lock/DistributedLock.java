package cn.dmai.frame.infrastructure.lock;

import java.util.concurrent.TimeUnit;

/**
 * @Author linchengdong
 * @Date 2023-11-30 10:13
 * @PackageName:cn.dmai.frame.infrastructure.lock
 * @ClassName: DistributedLock
 * @Description: 分布式锁接口
 * @Version 1.0
 */
public interface DistributedLock {

    boolean tryLock(long waitTime, long leaseTime, TimeUnit unit) throws InterruptedException;

    boolean tryLock() throws InterruptedException;

    void lock(long leaseTime, TimeUnit unit);

    void unlock();

    boolean isLocked();

    boolean isHeldByThread(long threadId);

    boolean isHeldByCurrentThread();
}
