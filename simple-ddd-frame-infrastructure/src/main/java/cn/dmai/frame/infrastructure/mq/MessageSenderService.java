package cn.dmai.frame.infrastructure.mq;

import cn.dmai.frame.base.event.TopicMessage;
import org.apache.rocketmq.client.producer.TransactionSendResult;

import java.util.concurrent.TimeUnit;

/**
 * @Author linchengdong
 * @Date 2023-11-29 19:41
 * @PackageName:cn.dmai.frame.infrastructure.mq
 * @ClassName: MessageSenderService
 * @Description: TODO
 * @Version 1.0
 */
public interface MessageSenderService {


    /**
     * 发送消息
     * @param message
     */
    void send(TopicMessage message);

    /**
     * 发送事务消息，主要是RocketMQ
     * @param message 事务消息
     * @param arg 其他参数
     * @return 返回事务发送结果
     */
    default TransactionSendResult sendMessageInTransaction(TopicMessage message, Object arg){
        return null;
    }

    /**
     * 发送延时消息
     * @param message
     */
    default void sendDelayMessage(TopicMessage message, Integer duration, TimeUnit timeUnit) { }
}
