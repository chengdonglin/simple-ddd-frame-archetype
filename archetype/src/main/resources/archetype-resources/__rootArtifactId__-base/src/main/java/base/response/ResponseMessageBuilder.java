#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.base.response;

/**
 * @Author linchengdong
 * @Date 2023-11-29 11:02
 * @PackageName:${package}.base.response
 * @ClassName: ResponseMessageBuilder
 * @Description: TODO
 * @Version 1.0
 */
public class ResponseMessageBuilder {

    /**
     * 构建返回
     *
     * @param code
     * @param body
     * @param <T>
     * @return
     */
    public static <T> ResponseMessage<T> build(Integer code, T body) {
        return new ResponseMessage<>(code, ApiCode.SUCCESS.getLabel(), body);
    }

    /**
     * 构建返回
     *
     * @param body
     * @param <T>
     * @return
     */
    public static <T> ResponseMessage<T> build(T body) {
        return new ResponseMessage<>(ApiCode.SUCCESS.getValue(), ApiCode.SUCCESS.getLabel(), body);
    }

    /**
     * 构建返回
     *
     * @param apiCode
     * @param <T>
     * @return
     */
    public static <T> ResponseMessage<T> build(ApiCode apiCode) {
        return new ResponseMessage<>(apiCode.getValue(), apiCode.getLabel(), null);
    }

    public static ResponseMessage failed(Integer code, String msg) {
        return new ResponseMessage(code, msg, null);
    }


}
