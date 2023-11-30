package cn.dmai.frame.infrastructure.mq.local;

import cn.dmai.frame.base.constants.SystemConstants;
import cn.dmai.frame.base.event.TopicMessage;
import cn.dmai.frame.infrastructure.mq.MessageSenderService;
import com.alibaba.cola.event.EventBusI;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

/**
 * @Author linchengdong
 * @Date 2023-11-29 19:43
 * @PackageName:cn.dmai.frame.infrastructure.mq.local
 * @ClassName: LocalMessageSenderService
 * @Description: TODO
 * @Version 1.0
 */
@Component
@ConditionalOnProperty(name = "message.mq.type", havingValue = SystemConstants.COLA)
public class LocalMessageSenderService implements MessageSenderService {

    private final EventBusI eventBusI;

    public LocalMessageSenderService(EventBusI eventBusI) {
        this.eventBusI = eventBusI;
    }

    @Override
    public void send(TopicMessage message) {
        eventBusI.fire(message);
    }
}
