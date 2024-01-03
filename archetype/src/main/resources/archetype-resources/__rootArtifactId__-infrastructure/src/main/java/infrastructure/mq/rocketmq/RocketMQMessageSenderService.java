#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.infrastructure.mq.rocketmq;

import ${package}.base.constants.SystemConstants;
import ${package}.base.event.TopicMessage;
import ${package}.infrastructure.mq.MessageSenderService;
import com.alibaba.fastjson.JSONObject;
import org.apache.rocketmq.client.producer.TransactionSendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * @Author linchengdong
 * @Date 2023-11-29 19:50
 * @PackageName:${package}.infrastructure.mq.rocketmq
 * @ClassName: RocketMQMessageSenderService
 * @Description: TODO
 * @Version 1.0
 */
@Component
@ConditionalOnProperty(name = "message.mq.type", havingValue = SystemConstants.ROCKETMQ)
public class RocketMQMessageSenderService implements MessageSenderService {

    private final RocketMQTemplate rocketMQTemplate;

    public RocketMQMessageSenderService(RocketMQTemplate rocketMQTemplate) {
        this.rocketMQTemplate = rocketMQTemplate;
    }

    @Override
    public void send(TopicMessage message) {
        rocketMQTemplate.send(message.getDestination(), this.getMessage(message));
    }

    @Override
    public TransactionSendResult sendMessageInTransaction(TopicMessage message, Object arg) {
        return rocketMQTemplate.sendMessageInTransaction(message.getDestination(), this.getMessage(message), arg);
    }

    //构建ROcketMQ发送的消息
    private Message<String> getMessage(TopicMessage message){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(SystemConstants.MSG_KEY, message);
        return MessageBuilder.withPayload(jsonObject.toJSONString()).build();
    }
}
