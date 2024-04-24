package com.onlines.enums;

/**
 * 系统相应状态码枚举
 */
public enum ResponseCodeEnum {
    SUCCESS(0, "成功"),
    PARAM_ERROR(-1, "参数有误"),
    ERROR(500, "系统异常"),
    ;

    private int code;
    private String desc;

    ResponseCodeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static String getDescByCode(Short code) {
        for (ResponseCodeEnum refer : ResponseCodeEnum.values())
            if (code == refer.getCode())
                return refer.getDesc();
        return null;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static String getDescByCode(int code) {
        for (ResponseCodeEnum refer : ResponseCodeEnum.values())
            if (code == refer.getCode())
                return refer.getDesc();
        return null;
    }
}