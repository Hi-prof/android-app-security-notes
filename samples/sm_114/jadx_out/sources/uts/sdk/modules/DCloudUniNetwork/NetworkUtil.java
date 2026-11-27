package uts.sdk.modules.DCloudUniNetwork;

/* JADX INFO: compiled from: index.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0016\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Luts/sdk/modules/DCloudUniNetwork/NetworkUtil;", "", "<init>", "()V", "Companion", "uni-network_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class NetworkUtil {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final uts.sdk.modules.DCloudUniNetwork.NetworkUtil.Companion INSTANCE = new uts.sdk.modules.DCloudUniNetwork.NetworkUtil.Companion(null);

    /* JADX INFO: compiled from: index.kt */
    @kotlin.Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\t0\u0007J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0005¨\u0006\r"}, d2 = {"Luts/sdk/modules/DCloudUniNetwork/NetworkUtil$Companion;", "", "<init>", "()V", "convertHeaders", "Lio/dcloud/uts/UTSJSONObject;", "headers", "", "", "", "parseCookie", "Lio/dcloud/uts/UTSArray;", com.taobao.weex.ui.component.WXBasicComponentType.HEADER, "uni-network_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final io.dcloud.uts.UTSJSONObject convertHeaders(java.util.Map<java.lang.String, java.util.List<java.lang.String>> headers) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(headers, "headers");
            io.dcloud.uts.UTSJSONObject uTSJSONObject_uO = io.dcloud.uts.UTSJSONObjectKt._uO(new kotlin.Pair[0]);
            for (java.util.Map.Entry<java.lang.String, java.util.List<java.lang.String>> entry : headers.entrySet()) {
                java.lang.String key = entry.getKey();
                java.util.List<java.lang.String> value = entry.getValue();
                if (key == null) {
                    key = "_";
                }
                if (value.size() != 0) {
                    if (value.size() == 1) {
                        uTSJSONObject_uO.set(key, value.get(0));
                    } else {
                        uTSJSONObject_uO.set(key, io.dcloud.uts.NumberKt.toString(value, (java.lang.Number) 10));
                    }
                }
            }
            return uTSJSONObject_uO;
        }

        public final io.dcloud.uts.UTSArray<java.lang.String> parseCookie(io.dcloud.uts.UTSJSONObject header) throws java.lang.IllegalAccessException {
            if (header != null) {
                java.lang.String string = header.getString(io.dcloud.common.DHInterface.IWebview.SET_COOKIE);
                if (string == null) {
                    string = header.getString("set-cookie");
                }
                if (string != null) {
                    io.dcloud.uts.UTSArray uTSArray = new io.dcloud.uts.UTSArray();
                    if (kotlin.jvm.internal.Intrinsics.areEqual(io.dcloud.uts.StringKt.charAt(string, (java.lang.Number) 0), com.taobao.weex.el.parse.Operators.ARRAY_START_STR) && kotlin.jvm.internal.Intrinsics.areEqual(io.dcloud.uts.StringKt.charAt(string, java.lang.Integer.valueOf(string.length() - 1)), com.taobao.weex.el.parse.Operators.ARRAY_END_STR)) {
                        string = io.dcloud.uts.StringKt.slice(string, (java.lang.Number) 1, (java.lang.Number) (-1));
                    }
                    io.dcloud.uts.UTSArray<java.lang.String> uTSArraySplit = io.dcloud.uts.StringKt.split(string, ";");
                    for (java.lang.Number numberInc = (java.lang.Number) 0; io.dcloud.uts.NumberKt.compareTo(numberInc, uTSArraySplit.getLength()) < 0; numberInc = io.dcloud.uts.NumberKt.inc(numberInc)) {
                        if (!io.dcloud.uts.NumberKt.numberEquals(io.dcloud.uts.StringKt.indexOf$default(uTSArraySplit.get(numberInc), "Expires=", null, 2, null), -1) || !io.dcloud.uts.NumberKt.numberEquals(io.dcloud.uts.StringKt.indexOf$default(uTSArraySplit.get(numberInc), "expires=", null, 2, null), -1)) {
                            uTSArray.push(io.dcloud.uts.StringKt.replace(uTSArraySplit.get(numberInc), ",", ""));
                        } else {
                            uTSArray.push(uTSArraySplit.get(numberInc));
                        }
                    }
                    return io.dcloud.uts.StringKt.split(uTSArray.join(";"), ",");
                }
                return new io.dcloud.uts.UTSArray<>();
            }
            return new io.dcloud.uts.UTSArray<>();
        }
    }
}
