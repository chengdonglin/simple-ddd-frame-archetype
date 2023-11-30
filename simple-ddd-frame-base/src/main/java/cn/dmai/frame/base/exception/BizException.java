package cn.dmai.frame.base.exception;

import cn.dmai.frame.base.response.ApiCode;

/**
 * @Author linchengdong
 * @Date 2023-11-29 11:57
 * @PackageName:cn.dmai.frame.base.exception
 * @ClassName: GlobalExceptionHandler
 * @Description: 自定义异常
 * @Version 1.0
 */

public class BizException extends RuntimeException {

    private Integer code;

    public BizException(String message) {
        super(message);
    }

    public BizException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public BizException(ApiCode apiCode) {
        this(apiCode.getValue(), apiCode.getLabel());
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
