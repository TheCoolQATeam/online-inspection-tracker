package com.onlines.enums;

public enum GroupEnum {
    JIAOYIPINGTAI(1,"交易平台"),
    TONGYONG(2,"通用"),
    ZHONGTAI(3,"中台"),
    BAOMU(4,"保姆"),
    YUESAO(5,"月嫂");

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
