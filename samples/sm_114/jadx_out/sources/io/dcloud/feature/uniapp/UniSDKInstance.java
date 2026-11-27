package io.dcloud.feature.uniapp;

/* JADX INFO: loaded from: classes2.dex */
public class UniSDKInstance extends com.taobao.weex.WXSDKInstance {
    private boolean isCompilerWithUniapp;

    public UniSDKInstance(android.content.Context context) {
        super(context);
        this.isCompilerWithUniapp = true;
    }

    public UniSDKInstance(android.content.Context context, android.content.Context context2) {
        super(context, context2);
        this.isCompilerWithUniapp = true;
    }

    public UniSDKInstance() {
        this.isCompilerWithUniapp = true;
    }

    public UniSDKInstance(android.content.Context context, java.lang.String str) {
        super(context, str);
        this.isCompilerWithUniapp = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.WXSDKInstance
    public io.dcloud.feature.uniapp.UniSDKInstance newNestedInstance() {
        return new io.dcloud.feature.uniapp.UniSDKInstance(this.mContext);
    }

    public void setCompilerWithUniapp(boolean z) {
        this.isCompilerWithUniapp = z;
    }

    @Override // com.taobao.weex.WXSDKInstance, io.dcloud.feature.uniapp.AbsSDKInstance
    public boolean isCompilerWithUniapp() {
        return this.isCompilerWithUniapp;
    }
}
