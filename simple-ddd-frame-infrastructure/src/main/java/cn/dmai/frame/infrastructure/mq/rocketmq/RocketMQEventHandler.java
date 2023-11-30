package cn.dmai.frame.infrastructure.mq.rocketmq;

import org.apache.rocketmq.spring.core.RocketMQListener;

/**
 * @Author linchengdong
 * @Date 2023-11-30 15:19
 * @PackageName:cn.dmai.frame.infrastructure.mq.rocketmq
 * @ClassName: RocketMQEventHandler
 * @Description: TODO
 * @Version 1.0
 */
public interface RocketMQEventHandler extends RocketMQListener<String> {
}
