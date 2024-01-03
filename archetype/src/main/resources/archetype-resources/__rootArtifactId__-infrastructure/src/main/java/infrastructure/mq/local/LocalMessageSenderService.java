#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.infrastructure.mq.local;

import ${package}.base.constants.SystemConstants;
import ${package}.base.event.TopicMessage;
import ${package}.infrastructure.mq.MessageSenderService;
import com.alibaba.cola.event.EventBusI;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

/**
 * @Author linchengdong
 * @Date 2023-11-29 19:43
 * @PackageName:${package}.infrastructure.mq.local
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
