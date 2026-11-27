package io.dcloud.feature.payment;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public interface IPaymentListener extends io.dcloud.common.DHInterface.IReflectAble {
    public static final int CODE_ACCOUNT_STATUS_ERROR = 62004;
    public static final int CODE_DATA_ERROR = 62003;
    public static final int CODE_DEVICE_NO_SUPPORT = 62002;
    public static final int CODE_NETWORK_ERROR = 62008;
    public static final int CODE_NO_INSTALL_MOBILE_SP = 62000;
    public static final int CODE_ORDER_INFO_ERROR = 62005;
    public static final int CODE_PAY_OPTION_ERROR = 62006;
    public static final int CODE_PAY_SERVER_ERROR = 62007;
    public static final int CODE_SUCCESS = 1;
    public static final int CODE_UNKNOWN = 62009;
    public static final int CODE_USER_CANCEL = 62001;

    void onError(int i, java.lang.String str);

    void onSuccess(io.dcloud.feature.payment.PaymentResult paymentResult);
}
