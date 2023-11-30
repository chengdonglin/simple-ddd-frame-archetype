package cn.dmai.frame.base.response;

import cn.dmai.frame.base.enums.BaseEnum;

/**
 * @Author linchengdong
 * @Date 2023-11-29 11:29
 * @PackageName:cn.dmai.frame.base.response
 * @ClassName: ApiCode
 * @Description: 响应枚举
 * @Version 1.0
 */
public enum ApiCode implements BaseEnum<Integer> {

    SUCCESS(0, "success"),
    FAIL(-1, "failed"),
    PARAMS_VALID_ERROR(400, "参数校验异常"),
    SERVER_ERROR(500, "系统内部异常");

    private final Integer code;

    private final String label;

    ApiCode(Integer code, String label) {
        this.code = code;
        this.label = label;
    }


    @Override
    public Integer getValue() {
        return code;
    }

    @Override
    public String getLabel() {
        return label;
    }
}
