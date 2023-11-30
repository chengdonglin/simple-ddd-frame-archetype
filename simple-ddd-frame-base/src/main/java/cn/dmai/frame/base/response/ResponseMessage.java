package cn.dmai.frame.base.response;

import java.io.Serializable;

/**
 * @Author linchengdong
 * @Date 2023-11-29 11:00
 * @PackageName:cn.dmai.frame.base.response
 * @ClassName: ResponseMessage
 * @Description: 响应消息体
 * @Version 1.0
 */
public class ResponseMessage<T> implements Serializable {

    private Integer code;

    private String msg;

    private T data;

    public ResponseMessage() {
    }

    public ResponseMessage(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
