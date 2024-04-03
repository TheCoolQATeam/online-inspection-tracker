package com.onlines.enums;

/**
 * 系统相应状态码枚举
 */
public enum ResponseCodeEnum {
    SUCCESS(0, "成功"),
    PARAM_ERROR(-1, "参数有误"),
    ERROR(500, "系统异常"),
    UID_ERROR(2, "用户ID和订单不匹配"),
    BATCH_ORDER_INVENTORY_CRASH(70, "周期订单排班冲突"),
    PARAMETER_VALIDATE_ERROR(3, "参数校验失败"),
    ORDER_CANCEL_FAIL(45, "订单取消失败"),
    BATCHORDER_CANCEL_FAIL(46, "周期服务取消失败"),
    CREATE_BATCH_ORDER_FAIL(72, "发生错误"),
    BLACK_USER(74, "抱歉！由于您有违规记录，我们无法继续为您提供服务。"),
    WORK_TIME_LIMITATION(23, "夜间1:00-6:00休息中，请于其他时间进行预约~"),
    DUPLICATED_OPERATION(124, "小主，您刚刚已提交过订单信息，系统正在处理，请勿重复操作~"),
    USER_DO_NOt_HAVE_CARD(78, "周期预约属于VIP卡用户专属服务,请先购买会员卡再尝试下单"),
    CANCEL_PUNISH(92, "现在取消订单，将会扣除%的订单金额，确认取消订单吗?"),
    ORDER_PAID(10, "订单已支付，不需要付款"),
    SECKILL_NOTSTART(11,"活动未开始"),
    SECKILL_END(12, "活动已结束"),
    SECKILL_REPEAT(13, "用户已参与"),
    SECKILL_FULL(14, "奖品已抢光"),
    CHECKCODE_FAIL(16, "验证失败"),
    SECKILL_FULL_COMFORT(15, "很遗憾，手慢啦，送您一张X"),
    SECKILL_FAIL(20, "秒杀失败"),
    ISNEW_WRONG(17, "抱歉，只有天鹅到家保洁新用户才能帮助好友组队，您可以组建自己的秒杀队伍赢取优惠"),
    NO_SECKILL_CHANCE(18, "未组队成功，快去邀请好友，立即参与秒杀"),
    SECKILL_CHANCE_NOTUSE(19, "您还有张超值秒杀券未使用，使用后可继续参与秒杀"),
    EXCLUSIVE_CARD_NOT_INIT(100, "卡片生成中"),
    EXCLUSIVE_CARD_NUMBER_ERROR(101,"领券失败，请稍后重试"),
    EXCLUSIVE_CARD_BIND_ERROR(102,"领取失败，请不要重复领取礼包"),
    EXCLUSIVE_CARD_ERROR(103,"保洁优享卡接口异常"),
    EXCLUSIVE_CARD_COUPON_OVER(104,"您的礼包已全部领取完毕"),
    NO_EXIST_LAST_TIME_SERVICE_SUB_ORDER(110,"不存在符合条件的服务完成子单"),
    COMBO_ORDER_STATE_ILLEGAL(111,"套餐状态非法"),
    NOT_COMBO_ORDER(112, "订单不是套餐单"),
    LOGIN_NOT_MATCH(-101,"未登录"),
    NOT_CARD(-102,"没有名片信息"),
    IMG_UPLOAD_OVERSIZE(5,"抱歉!上传的图片的尺寸请限制在10M以内"),
    IMG_UPLOAD_FAIL(6,"图片上传失败，请重新上传"),
    IMG_UPLOAD_PORN(7,"图片上传失败，图片鉴黄失败"),
    USER_IMPRESS_OVER(8,"好友印象已达上限"),
    ORDER_STATE_ERROR(9, "订单状态有误"),
    SUBCOMBO_CANCEL_CHECK_ERR(201, "系统繁忙，请稍后重试"),
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