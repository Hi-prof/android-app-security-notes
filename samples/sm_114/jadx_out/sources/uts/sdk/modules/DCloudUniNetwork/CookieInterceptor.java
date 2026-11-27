package uts.sdk.modules.DCloudUniNetwork;

/* JADX INFO: compiled from: index.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\"\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000b0\t2\u0006\u0010\f\u001a\u00020\rH\u0002J*\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000b0\tH\u0002¨\u0006\u0013"}, d2 = {"Luts/sdk/modules/DCloudUniNetwork/CookieInterceptor;", "Lokhttp3/Interceptor;", "<init>", "()V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "toMap", "", "", "", "headers", "Lokhttp3/Headers;", "addCookies", "", "builder", "Lokhttp3/Request$Builder;", "localCookie", "uni-network_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class CookieInterceptor implements okhttp3.Interceptor {
    @Override // okhttp3.Interceptor
    public okhttp3.Response intercept(okhttp3.Interceptor.Chain chain) throws java.io.IOException {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(chain, "chain");
        okhttp3.Request request = chain.request();
        java.lang.String strHeader = request.header("cookie");
        java.net.URI uri = request.url().uri();
        java.net.CookieHandler cookieHandler = java.net.CookieHandler.getDefault();
        if (strHeader == null) {
            okhttp3.Request.Builder builderNewBuilder = request.newBuilder();
            try {
                okhttp3.Headers headers = request.headers();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(headers, "headers(...)");
                java.util.Map<java.lang.String, java.util.List<java.lang.String>> map = cookieHandler.get(uri, toMap(headers));
                kotlin.jvm.internal.Intrinsics.checkNotNull(builderNewBuilder);
                kotlin.jvm.internal.Intrinsics.checkNotNull(map);
                addCookies(builderNewBuilder, map);
            } catch (java.lang.Exception unused) {
            }
            request = builderNewBuilder.build();
        }
        okhttp3.Response responseProceed = chain.proceed(request);
        try {
            okhttp3.Headers headers2 = responseProceed.headers();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(headers2, "headers(...)");
            cookieHandler.put(uri, toMap(headers2));
        } catch (java.lang.Exception unused2) {
        }
        kotlin.jvm.internal.Intrinsics.checkNotNull(responseProceed);
        return responseProceed;
    }

    private final java.util.Map<java.lang.String, java.util.List<java.lang.String>> toMap(okhttp3.Headers headers) {
        java.util.TreeMap treeMap = new java.util.TreeMap(kotlin.text.StringsKt.getCASE_INSENSITIVE_ORDER(kotlin.jvm.internal.StringCompanionObject.INSTANCE));
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            java.lang.String strName = headers.name(i);
            java.util.TreeMap treeMap2 = treeMap;
            java.util.ArrayList arrayList = (java.util.List) treeMap2.get(strName);
            if (arrayList == null) {
                arrayList = new java.util.ArrayList();
                treeMap2.put(strName, arrayList);
            }
            java.lang.String strValue = headers.value(i);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strValue, "value(...)");
            arrayList.add(strValue);
        }
        return treeMap;
    }

    private final void addCookies(okhttp3.Request.Builder builder, java.util.Map<java.lang.String, java.util.List<java.lang.String>> localCookie) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        for (java.lang.String str : (java.util.Set) io.dcloud.uts.UTSIteratorKt.resolveUTSKeyIterator(localCookie.keySet())) {
            if (arrayList2.size() == 2) {
                break;
            }
            if (kotlin.text.StringsKt.equals("cookie", str, true) || kotlin.text.StringsKt.equals("cookie2", str, true)) {
                arrayList2.add(str);
                java.util.List<java.lang.String> list = localCookie.get(str);
                if (list != null && !list.isEmpty()) {
                    arrayList.addAll(list);
                }
            }
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.util.Iterator it = ((java.util.List) io.dcloud.uts.UTSIteratorKt.resolveUTSKeyIterator(arrayList)).iterator();
        while (it.hasNext()) {
            sb.append((java.lang.String) it.next());
            sb.append("; ");
        }
        java.lang.String string = sb.toString();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        if (kotlin.text.StringsKt.endsWith$default(string, "; ", false, 2, (java.lang.Object) null)) {
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(sb.delete(sb.length() - 2, sb.length() - 1), "this.delete(startIndex, endIndex)");
        }
        java.lang.String string2 = sb.toString();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
        if (string2.length() == 0) {
            return;
        }
        builder.addHeader(io.dcloud.common.DHInterface.IWebview.COOKIE, sb.toString());
    }
}
