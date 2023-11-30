package cn.dmai.frame.base.event;

import com.alibaba.cola.event.DomainEventI;

/**
 * @Author linchengdong
 * @Date 2023-11-29 15:54
 * @PackageName:cn.dmai.frame.base.event
 * @ClassName: BaseEvent
 * @Description: 基础消息, 其他消息继承该类
 * @Version 1.0
 */
public abstract class TopicMessage implements DomainEventI {

    /**
     * 消息目的地，可以是消息主题
     */
    private String destination;

    public TopicMessage() {
    }

    public TopicMessage(String destination) {
        this.destination = destination;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
