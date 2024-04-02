package com.onlines.enums;

public enum ErrCodelEnum {
    success(0, "成功"),
    fail(-1, "失败"),
    error(500, "系统异常"),
    parameter_error(2, "参数校验失败");

    private int code;
    private String desc;

    private ErrCodelEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
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
        for (ErrCodelEnum refer : ErrCodelEnum.values())
            if (code == refer.getCode())
                return refer.getDesc();
        return null;
    }


}
