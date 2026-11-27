package uts.sdk.modules.DCloudUniGetAccessibilityInfo;

/* JADX INFO: compiled from: index.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f\u001a\u0006\u0010\r\u001a\u00020\u0002\"\u001b\u0010\u0003\u001a\f\u0012\u0004\u0012\u00020\u00020\u0001j\u0002`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006*\u0016\u0010\u0000\"\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u000e"}, d2 = {"GetAccessibilityInfo", "Lkotlin/Function0;", "Lio/dcloud/uts/UTSJSONObject;", "getAccessibilityInfo", "Luts/sdk/modules/DCloudUniGetAccessibilityInfo/GetAccessibilityInfo;", "getGetAccessibilityInfo", "()Lkotlin/jvm/functions/Function0;", "isAccessibilitySettingsOn", "", "context", "Landroid/content/Context;", "service", "", "getAccessibilityInfoByJs", "uni-getAccessibilityInfo_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class IndexKt {
    private static final kotlin.jvm.functions.Function0<io.dcloud.uts.UTSJSONObject> getAccessibilityInfo = new kotlin.jvm.functions.Function0() { // from class: uts.sdk.modules.DCloudUniGetAccessibilityInfo.IndexKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final java.lang.Object invoke() {
            return uts.sdk.modules.DCloudUniGetAccessibilityInfo.IndexKt.getAccessibilityInfo$lambda$1();
        }
    };

    public static final kotlin.jvm.functions.Function0<io.dcloud.uts.UTSJSONObject> getGetAccessibilityInfo() {
        return getAccessibilityInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final io.dcloud.uts.UTSJSONObject getAccessibilityInfo$lambda$1() {
        android.app.Activity uniActivity = io.dcloud.uts.UTSAndroid.INSTANCE.getUniActivity();
        kotlin.jvm.internal.Intrinsics.checkNotNull(uniActivity);
        kotlin.jvm.internal.Intrinsics.checkNotNull(uniActivity);
        java.lang.Object systemService = uniActivity.getSystemService("accessibility");
        kotlin.jvm.internal.Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
        android.view.accessibility.AccessibilityManager accessibilityManager = (android.view.accessibility.AccessibilityManager) systemService;
        java.util.List<android.accessibilityservice.AccessibilityServiceInfo> installedAccessibilityServiceList = accessibilityManager.getInstalledAccessibilityServiceList();
        io.dcloud.uts.UTSArray uTSArray = new io.dcloud.uts.UTSArray();
        for (int i = 0; i < installedAccessibilityServiceList.size(); i++) {
            java.lang.String id = installedAccessibilityServiceList.get(i).getId();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
            if (isAccessibilitySettingsOn(uniActivity, id)) {
                android.accessibilityservice.AccessibilityServiceInfo accessibilityServiceInfo = installedAccessibilityServiceList.get(i);
                kotlin.jvm.internal.Intrinsics.checkNotNull(accessibilityServiceInfo, "null cannot be cast to non-null type android.accessibilityservice.AccessibilityServiceInfo");
                android.accessibilityservice.AccessibilityServiceInfo accessibilityServiceInfo2 = accessibilityServiceInfo;
                uTSArray.add(io.dcloud.uts.UTSJSONObjectKt._uO(kotlin.TuplesKt.to("id", accessibilityServiceInfo2.getId()), kotlin.TuplesKt.to("packageNames", accessibilityServiceInfo2.packageNames)));
            }
        }
        return io.dcloud.uts.UTSJSONObjectKt._uO(kotlin.TuplesKt.to("enabled", java.lang.Boolean.valueOf(accessibilityManager.isEnabled())), kotlin.TuplesKt.to(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_SERVICES, uTSArray));
    }

    public static final boolean isAccessibilitySettingsOn(android.content.Context context, java.lang.String service) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(service, "service");
        android.text.TextUtils.SimpleStringSplitter simpleStringSplitter = new android.text.TextUtils.SimpleStringSplitter(com.taobao.weex.el.parse.Operators.CONDITION_IF_MIDDLE);
        java.lang.String string = android.provider.Settings.Secure.getString(context.getApplicationContext().getContentResolver(), "enabled_accessibility_services");
        if (string == null) {
            return false;
        }
        simpleStringSplitter.setString(string);
        while (simpleStringSplitter.hasNext()) {
            java.lang.String next = simpleStringSplitter.next();
            kotlin.jvm.internal.Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.String");
            if (kotlin.jvm.internal.Intrinsics.areEqual(next, service)) {
                return true;
            }
        }
        return false;
    }

    public static final io.dcloud.uts.UTSJSONObject getAccessibilityInfoByJs() {
        return getAccessibilityInfo.invoke();
    }
}
