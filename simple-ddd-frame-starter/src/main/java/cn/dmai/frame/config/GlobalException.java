package cn.dmai.frame.config;

import cn.dmai.frame.base.exception.BizException;
import cn.dmai.frame.base.response.ApiCode;
import cn.dmai.frame.base.response.ResponseMessage;
import cn.dmai.frame.base.response.ResponseMessageBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;

/**
 * @Author linchengdong
 * @Date 2023-11-29 13:49
 * @PackageName:cn.dmai.frame.config
 * @ClassName: GlobalException
 * @Description: TODO
 * @Version 1.0
 */
@RestControllerAdvice
@Order(Ordered.LOWEST_PRECEDENCE)
@Slf4j
public class GlobalException {


    /**
     * 参数校验异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseMessage validException(BindException e) {
        StringBuilder message = new StringBuilder();
        //获得校验异常信息
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        for (FieldError error : fieldErrors) {
            message.append(error.getField()).append(error.getDefaultMessage()).append(",");
        }
        message = new StringBuilder(message.substring(0, message.length() - 1));
        return ResponseMessageBuilder.failed(ApiCode.PARAMS_VALID_ERROR.getValue(), message.toString());
    }

    /**
     * 统一处理请求参数校验(普通传参)
     *
     * @param e ConstraintViolationException
     * @return Result
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseMessage handleConstraintViolationException(ConstraintViolationException e) {
        StringBuilder msg = new StringBuilder();
        Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
        for (ConstraintViolation<?> constraintViolation : constraintViolations) {
            String message = constraintViolation.getMessage();
            msg.append(message).append(System.lineSeparator());
        }
        return ResponseMessageBuilder.failed(ApiCode.PARAMS_VALID_ERROR.getValue(), msg.toString());
    }

    /**
     * 自定义异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(BizException.class)
    @ResponseStatus(HttpStatus.OK)
    public ResponseMessage bizException(BizException e) {
        log.error("[Global-Exception] - 发生业务异常！", e);
        return ResponseMessageBuilder.failed(e.getCode(), e.getMessage());
    }


    @ExceptionHandler(value = RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseMessage handleRuntimeException(Exception e) {
        log.error("系统内部异常，异常信息", e);
        return ResponseMessageBuilder.failed(ApiCode.SERVER_ERROR.getValue(), e.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseMessage handleException(Exception e) {
        log.error("系统内部异常，异常信息", e);
        return ResponseMessageBuilder.failed(ApiCode.SERVER_ERROR.getValue(), e.getMessage());
    }
}
