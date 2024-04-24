package com.onlines.enums;

public enum GroupEnum {
    GROUPA(1,"分组A"),
    GROUPB(2,"分组B");

    private int code;
    private String desc;

    private GroupEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
    public static String getDescByCode(Integer code) {
        for (GroupEnum refer : GroupEnum.values())
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
}
