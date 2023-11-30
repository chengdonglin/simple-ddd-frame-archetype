package cn.dmai.frame.infrastructure.mq.local;

import cn.dmai.frame.base.event.TopicMessage;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.event.EventHandlerI;


/**
 * @Author linchengdong
 * @Date 2023-11-30 15:11
 * @PackageName:cn.dmai.frame.infrastructure.mq.local
 * @ClassName: Local
 * @Description: public class TestLocalEventHandler implements LocalEventHandler<TopicMessage>
 * @Version 1.0
 */
public interface LocalEventHandler<T extends TopicMessage> extends EventHandlerI<Response, T> {
}
