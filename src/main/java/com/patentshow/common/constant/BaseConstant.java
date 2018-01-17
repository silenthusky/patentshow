package com.patentshow.common.constant;

/**
 * Created by unclexiao on 2017/12/6.
 */
public class BaseConstant {

    //订单状态 0未确认,1确认,2已取消,3无效,4退货

    public static final int ORDER_NOT_CONFIRM = 0;
    public static final int ORDER_CONFIRMED = 1;
    public static final int ORDER_CANCELLED = 2;
    public static final int ORDER_INVALID = 3;
    public static final int ORDER_RETURNING = 4;


    //支付方式 支付宝(0)、微信(1)

    public static final int PAY_BY_ALIPAY = 0;
    public static final int PAY_BY_WEIXIN = 1;


    //派送方式 顺丰（0）、中通(1)
    public static final int SHUNFENG_SHIP = 0;
    public static final int ZHONGTONG_SHIP = 1;


    //数据源
    public static final String SHOP = "shop";
    public static final String MYDW = "MYDW";


    //圈子类别
    public static final int BU_TAI_YI = 1;
    public static final int JIAN_KANG_CHENG = 2;
    public static final int PAO_BU = 3;
    public static final int YOU_YONG = 4;
    public static final int LV_YOU = 5;
    public static final int JIAN_FEI = 6;
    public static final int GOU_WU = 7;
    public static final int CHANG_GE = 8;
    public static final int JIAN_SHEN = 9;


    //接口返回Code定义

    //成功
    public static final int SUCCESS = 0;

    //返回值为null
    public static final int NULLRETURN = 1;

}
