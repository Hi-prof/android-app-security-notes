package io.dcloud.uts;

/* JADX INFO: compiled from: UTSAndroid.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000\u008c\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u0004\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0006\u001a\u0002H\u00052\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\"\u0010\n\u001a\u0002H\u0005\"\n\b\u0000\u0010\u0005\u0018\u0001*\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0086\b¢\u0006\u0002\u0010\rJ\u001a\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000f0\u0011J\u001e\u0010\u0012\u001a\u00020\u000f2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0011J\u001a\u0010\u0013\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000f0\u0011J\u001e\u0010\u0015\u001a\u00020\u000f2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0011J\u0014\u0010\u0016\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0017J\u0018\u0010\u0018\u001a\u00020\u000f2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0017J\u0014\u0010\u0019\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0017J\u0018\u0010\u001a\u001a\u00020\u000f2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0017J\u0014\u0010\u001b\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0017J\u0014\u0010\u001c\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0017J\u0014\u0010\u001d\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0017J\u0018\u0010\u001e\u001a\u00020\u000f2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0017JU\u0010\u001f\u001a\u00020\u000f2M\u0010\u0010\u001aI\u0012\u0013\u0012\u00110!¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0013\u0012\u00110!¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(%\u0012\u0015\u0012\u0013\u0018\u00010&¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u000f0 JY\u0010(\u001a\u00020\u000f2Q\b\u0002\u0010\u0010\u001aK\u0012\u0013\u0012\u00110!¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0013\u0012\u00110!¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(%\u0012\u0015\u0012\u0013\u0018\u00010&¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u000f\u0018\u00010 J\u0014\u0010)\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0017J\u0018\u0010*\u001a\u00020\u000f2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0017Ja\u0010+\u001a\u00020\u000f2W\u0010\u0010\u001aS\u0012\u0013\u0012\u00110!¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\b0,¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(-\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00140,¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u000f0 H\u0007Je\u0010/\u001a\u00020\u000f2[\b\u0002\u0010\u0010\u001aU\u0012\u0013\u0012\u00110!¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\b0,¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(-\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00140,¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u000f\u0018\u00010 H\u0007J\b\u00100\u001a\u0004\u0018\u000101J\b\u00102\u001a\u0004\u0018\u000103J\b\u00104\u001a\u0004\u0018\u000103J\b\u00105\u001a\u0004\u0018\u000106J\u000e\u00107\u001a\u00020\b2\u0006\u00108\u001a\u00020\bJ\u000e\u00109\u001a\u00020\b2\u0006\u0010:\u001a\u00020\bJ\u0006\u0010;\u001a\u00020<J\u0015\u0010=\u001a\u00020\b2\b\u0010>\u001a\u0004\u0018\u00010?¢\u0006\u0002\u0010@J\u0015\u0010=\u001a\u00020\b2\b\u0010>\u001a\u0004\u0018\u00010A¢\u0006\u0002\u0010BJ\u0015\u0010=\u001a\u00020\b2\b\u0010>\u001a\u0004\u0018\u00010!¢\u0006\u0002\u0010CJ\u0015\u0010=\u001a\u00020\b2\b\u0010>\u001a\u0004\u0018\u00010D¢\u0006\u0002\bEJ\u0015\u0010=\u001a\u00020\b2\b\u0010>\u001a\u0004\u0018\u00010F¢\u0006\u0002\u0010GJ\u0015\u0010=\u001a\u00020\b2\b\u0010>\u001a\u0004\u0018\u00010H¢\u0006\u0002\bIJ\u0015\u0010=\u001a\u00020\b2\b\u0010>\u001a\u0004\u0018\u00010J¢\u0006\u0002\u0010KJ\u0015\u0010=\u001a\u00020\b2\b\u0010>\u001a\u0004\u0018\u00010L¢\u0006\u0002\bMJ\u0015\u0010=\u001a\u00020\b2\b\u0010>\u001a\u0004\u0018\u00010N¢\u0006\u0002\u0010OJ\u0015\u0010=\u001a\u00020\b2\b\u0010>\u001a\u0004\u0018\u00010P¢\u0006\u0002\bQJ\u0010\u0010=\u001a\u00020\b2\b\u0010>\u001a\u0004\u0018\u00010\u0014J\u0010\u0010=\u001a\u00020\b2\b\u0010>\u001a\u0004\u0018\u00010\u0001J\u0011\u0010R\u001a\u00020S\"\u0006\b\u0000\u0010\u0005\u0018\u0001H\u0086\bJ\u0011\u0010T\u001a\u00020\b\"\u0006\b\u0000\u0010\u0005\u0018\u0001H\u0086\bJ\u001c\u0010U\u001a\u00020<2\u0006\u0010V\u001a\u0002032\f\u0010W\u001a\b\u0012\u0004\u0012\u00020\b0,J\"\u0010X\u001a\b\u0012\u0004\u0012\u00020\b0,2\u0006\u0010V\u001a\u0002032\f\u0010W\u001a\b\u0012\u0004\u0012\u00020\b0,J\u001c\u0010Y\u001a\u00020\u000f2\u0006\u0010V\u001a\u0002032\f\u0010W\u001a\b\u0012\u0004\u0012\u00020\b0,J¢\u0001\u0010Z\u001a\u00020\u000f2\u0006\u0010V\u001a\u0002032\f\u0010W\u001a\b\u0012\u0004\u0012\u00020\b0,2<\u0010[\u001a8\u0012\u0013\u0012\u00110<¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(]\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\b0,¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(^\u0012\u0004\u0012\u00020\u000f0\\2<\u0010_\u001a8\u0012\u0013\u0012\u00110<¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(`\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\b0,¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(^\u0012\u0004\u0012\u00020\u000f0\\2\b\b\u0002\u0010a\u001a\u00020<J/\u0010b\u001a\u00020\u000f2'\u0010c\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\b0,¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(d\u0012\u0004\u0012\u00020\u000f0\u0011J/\u0010e\u001a\u00020\u000f2'\u0010c\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\b0,¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(d\u0012\u0004\u0012\u00020\u000f0\u0011J/\u0010f\u001a\u00020\u000f2'\u0010c\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\b0,¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(d\u0012\u0004\u0012\u00020\u000f0\u0011J/\u0010g\u001a\u00020\u000f2'\u0010c\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\b0,¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(d\u0012\u0004\u0012\u00020\u000f0\u0011J/\u0010h\u001a\u00020\u000f2'\u0010c\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\b0,¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(d\u0012\u0004\u0012\u00020\u000f0\u0011J/\u0010i\u001a\u00020\u000f2'\u0010c\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\b0,¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(d\u0012\u0004\u0012\u00020\u000f0\u0011J\n\u0010j\u001a\u0004\u0018\u00010kH\u0002J\b\u0010l\u001a\u0004\u0018\u00010\bJ\u0006\u0010m\u001a\u00020<J\u0006\u0010n\u001a\u00020<J\u0006\u0010o\u001a\u00020\bJ\n\u0010p\u001a\u0004\u0018\u00010\bH\u0007J\b\u0010q\u001a\u0004\u0018\u00010\bJ\u0006\u0010r\u001a\u00020<J\u0006\u0010s\u001a\u00020<J\u000e\u0010t\u001a\u00020\u000f2\u0006\u0010u\u001a\u00020<J\u0006\u0010v\u001a\u00020\u000fJ\u000e\u0010w\u001a\u00020\u000b2\u0006\u0010V\u001a\u000201J\u000e\u0010x\u001a\u00020\u000b2\u0006\u0010V\u001a\u000201J\u000e\u0010y\u001a\u00020\b2\u0006\u0010V\u001a\u000201J\u0006\u0010z\u001a\u00020\bJ\u0006\u0010{\u001a\u00020\bJ\u0006\u0010|\u001a\u00020\bJ\u0006\u0010}\u001a\u00020\bJ\u0006\u0010~\u001a\u00020\bJ\u0006\u0010\u007f\u001a\u00020\u000bJ\u0007\u0010\u0080\u0001\u001a\u00020\bJ\u0007\u0010\u0081\u0001\u001a\u00020\bJ\u0007\u0010\u0082\u0001\u001a\u00020\u000bJ\u0007\u0010\u0083\u0001\u001a\u00020!J\u0007\u0010\u0084\u0001\u001a\u00020<J\u0007\u0010\u0085\u0001\u001a\u00020<J\t\u0010\u0086\u0001\u001a\u00020AH\u0002J\u0007\u0010\u0087\u0001\u001a\u00020!J\u0007\u0010\u0088\u0001\u001a\u00020!J\u0007\u0010\u0089\u0001\u001a\u00020\u000bJ\u0007\u0010\u008a\u0001\u001a\u00020<J\t\u0010\u008b\u0001\u001a\u00020\u000fH\u0007J\u0007\u0010\u008c\u0001\u001a\u00020\u000fJ\u0015\u0010\u008d\u0001\u001a\u0007\u0012\u0002\b\u00030\u008e\u00012\u0007\u0010\u008f\u0001\u001a\u00020\u0001J\u0015\u0010\u0090\u0001\u001a\u0007\u0012\u0002\b\u00030\u0091\u00012\u0007\u0010\u008f\u0001\u001a\u00020\u0001J\u0015\u0010\u0092\u0001\u001a\u00030\u0093\u00012\u000b\b\u0002\u0010\u0094\u0001\u001a\u0004\u0018\u00010\bJD\u0010\u0095\u0001\u001a\u00020\u000f2\u0007\u0010\u0094\u0001\u001a\u00020\b2%\u0010\u0096\u0001\u001a \u0012\u0016\u0012\u0014\u0018\u00010\u0001¢\u0006\r\b\"\u0012\t\b#\u0012\u0005\b\b(\u0097\u0001\u0012\u0004\u0012\u00020\u000f0\u00112\t\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u0001H\u0007J\u0010\u0010\u0098\u0001\u001a\u00020\u00142\u0007\u0010\u0099\u0001\u001a\u00020\u0014J\u0010\u0010\u009a\u0001\u001a\u00020\u00142\u0007\u0010\u009b\u0001\u001a\u00020\u0014J\u0013\u0010\u009e\u0001\u001a\u00020\u000f2\b\u0010\u009f\u0001\u001a\u00030 \u0001H\u0002J\b\u0010¡\u0001\u001a\u00030¢\u0001J\u0014\u0010£\u0001\u001a\u0005\u0018\u00010¤\u00012\b\u0010¥\u0001\u001a\u00030¦\u0001J\u001c\u0010ª\u0001\u001a\u00020\u000f2\u0013\u0010\u0010\u001a\u000f\u0012\u0005\u0012\u00030©\u0001\u0012\u0004\u0012\u00020\u000f0\u0011J\u001c\u0010«\u0001\u001a\u00020\u000f2\u0013\u0010\u0010\u001a\u000f\u0012\u0005\u0012\u00030©\u0001\u0012\u0004\u0012\u00020\u000f0\u0011J\u0010\u0010¬\u0001\u001a\u00020\u000f2\u0007\u0010\u00ad\u0001\u001a\u00020\u0001R\u0016\u0010\u009c\u0001\u001a\t\u0012\u0004\u0012\u00020\b0\u009d\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R0\u0010§\u0001\u001a#\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\b\u0012\u0011\u0012\u000f\u0012\u0005\u0012\u00030©\u0001\u0012\u0004\u0012\u00020\u000f0\u00110¨\u00010\u009d\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006®\u0001"}, d2 = {"Lio/dcloud/uts/UTSAndroid;", "", "<init>", "()V", "consoleDebugError", "T", com.facebook.common.util.UriUtil.LOCAL_RESOURCE_SCHEME, "info", "", "(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;", "parseObject", "Lio/dcloud/uts/UTSJSONObject;", "opts", "(Lio/dcloud/uts/UTSJSONObject;)Lio/dcloud/uts/UTSJSONObject;", "onAppConfigChange", "", com.taobao.weex.bridge.WXBridgeManager.METHOD_CALLBACK, "Lkotlin/Function1;", "offAppConfigChange", "onAppTrimMemory", "", "offAppTrimMemory", "onAppActivityPause", "Lkotlin/Function0;", "offAppActivityPause", "onAppActivityResume", "offAppActivityResume", "onAppActivityStop", "offAppActivityStop", "onAppActivityDestroy", "offAppActivityDestroy", "onAppActivityResult", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", com.taobao.weex.common.WXModule.REQUEST_CODE, com.taobao.weex.common.WXModule.RESULT_CODE, "Landroid/content/Intent;", "data", "offAppActivityResult", "onAppActivityBack", "offAppActivityBack", "onAppActivityRequestPermissionsResult", "Lio/dcloud/uts/UTSArray;", "permissions", com.taobao.weex.common.WXModule.GRANT_RESULTS, "offAppActivityRequestPermissionsResult", "getAppContext", "Landroid/content/Context;", "getUniActivity", "Landroid/app/Activity;", "getTopPageActivity", "getTopPageView", "Landroid/view/View;", "getResourcePath", "resourceName", "convert2AbsFullPath", "relativePath", "isUniMp", "", "typeof", "value", "", "(Ljava/lang/Double;)Ljava/lang/String;", "", "(Ljava/lang/Float;)Ljava/lang/String;", "(Ljava/lang/Integer;)Ljava/lang/String;", "Lkotlin/UInt;", "typeof-ExVfyTY", "", "(Ljava/lang/Byte;)Ljava/lang/String;", "Lkotlin/UByte;", "typeof-3swpYEE", "", "(Ljava/lang/Short;)Ljava/lang/String;", "Lkotlin/UShort;", "typeof-ffyZV3s", "", "(Ljava/lang/Long;)Ljava/lang/String;", "Lkotlin/ULong;", "typeof-ADd3fzo", "getGenericType", "Ljava/lang/reflect/Type;", "getGenericClassName", "checkSystemPermissionGranted", "context", "requestPermission", "getSystemPermissionDenied", "gotoSystemPermissionActivity", "requestSystemPermission", com.taobao.weex.ui.component.WXImage.SUCCEED, "Lkotlin/Function2;", "allRight", "grantedList", com.taobao.weex.common.Constants.Event.FAIL, "doNotAskAgain", "shallUnCheck", "onPermissionRequest", "listener", "permission", "onPermissionConfirm", "onPermissionComplete", "offPermissionRequest", "offPermissionConfirm", "offPermissionComplete", "getInstance", "Lio/dcloud/feature/uniapp/AbsSDKInstance;", "appJSBundleUrl", "appRunAssetMode", "getAppDarkMode", "getAppTheme", "getAppTempPath", "getAppCachePath", "isPrivacyAgree", "isUIThread", "setPrivacyAgree", "newVal", "resetPrivacyAgree", "getLanguageInfo", "getWebViewInfo", "getDeviceID", "getOAID", "getInnerVersion", "getUniCompileVersion", "getUniRuntimeVersion", "getAppId", "getAppVersion", "getAppName", "getOsTheme", "getScreenInfo", "getStatusBarHeight", "isTitleNViewShow", "isTabBarShow", "getScale", "getWindowHeight", "getWindowWidth", "getSafeAreaInsets", "isUniAppX", "quitApp", com.alibaba.android.bindingx.core.internal.BindingXConstants.STATE_EXIT, "getJavaClass", "Ljava/lang/Class;", "input", "getKotlinClass", "Lkotlin/reflect/KClass;", "getDispatcher", "Lio/dcloud/uts/task/UTSTaskDispatcher;", "threadName", "dispatchAsync", "action", "param", "rpx2px", "rpx", "devicePX2px", "devicePX", "initedHookProxys", "", "initUTSHooksClassArray", "application", "Landroid/app/Application;", "getDomCoroutineDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "getFileProviderUri", "Landroid/net/Uri;", "file", "Ljava/io/File;", "privacyAgreeList", "Lkotlin/Pair;", "Lio/dcloud/uts/PrivacyOption;", "onPrivacyAgreeChange", "offPrivacyAgreeChange", com.taobao.weex.bridge.WXBridgeManager.METHOD_DESTROY_INSTANCE, "obj", "utsplugin_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UTSAndroid {
    public static final io.dcloud.uts.UTSAndroid INSTANCE = new io.dcloud.uts.UTSAndroid();
    private static final java.util.List<java.lang.String> initedHookProxys = new java.util.ArrayList();
    private static final java.util.List<kotlin.Pair<java.lang.String, kotlin.jvm.functions.Function1<io.dcloud.uts.PrivacyOption, kotlin.Unit>>> privacyAgreeList = new java.util.ArrayList();

    public final void destroyInstance(java.lang.Object obj) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(obj, "obj");
    }

    public final boolean isUniAppX() {
        return false;
    }

    private UTSAndroid() {
    }

    public final <T> T consoleDebugError(T res, java.lang.String info) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(info, "info");
        if (res == null && io.dcloud.uts.ObjectKt.getGlobalError().get(java.lang.Thread.currentThread().getName()) != null) {
            io.dcloud.uts.console.error(io.dcloud.uts.ObjectKt.getGlobalError().get(java.lang.Thread.currentThread().getName()), info);
            io.dcloud.uts.ObjectKt.getGlobalError().put(java.lang.Thread.currentThread().getName(), null);
        }
        return res;
    }

    public final /* synthetic */ <T extends io.dcloud.uts.UTSJSONObject> T parseObject(io.dcloud.uts.UTSJSONObject opts) {
        java.lang.Object next;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(opts, "opts");
        kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(4, "T");
        kotlin.reflect.KClass orCreateKotlinClass = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(io.dcloud.uts.UTSJSONObject.class);
        T t = (T) kotlin.reflect.full.KClasses.createInstance(orCreateKotlinClass);
        java.util.Collection memberProperties = kotlin.reflect.full.KClasses.getMemberProperties(kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(opts.getClass()));
        for (kotlin.reflect.KProperty1 kProperty1 : kotlin.reflect.full.KClasses.getMemberProperties(orCreateKotlinClass)) {
            java.lang.String name = kProperty1.getName();
            java.util.Iterator it = memberProperties.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!kotlin.jvm.internal.Intrinsics.areEqual(((kotlin.reflect.KProperty1) next).getName(), name));
            kotlin.reflect.KProperty1 kProperty2 = (kotlin.reflect.KProperty1) next;
            if (kProperty2 != null) {
                if (kotlin.jvm.internal.Intrinsics.areEqual(kProperty1.getGetter().getReturnType().getClassifier(), kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(io.dcloud.uts.UTSCallback.class))) {
                    if (kProperty1 instanceof kotlin.reflect.KMutableProperty1) {
                        kotlin.reflect.KMutableProperty1.Setter setter = ((kotlin.reflect.KMutableProperty1) kProperty1).getSetter();
                        V vCall = kProperty2.getGetter().call(opts);
                        kotlin.jvm.internal.Intrinsics.checkNotNull(vCall);
                        setter.call(t, new io.dcloud.uts.UTSCallback(vCall));
                    }
                } else if (kProperty1 instanceof kotlin.reflect.KMutableProperty1) {
                    ((kotlin.reflect.KMutableProperty1) kProperty1).getSetter().call(t, kProperty2.getGetter().call(opts));
                }
            }
        }
        return t;
    }

    public final void onAppConfigChange(kotlin.jvm.functions.Function1<? super io.dcloud.uts.UTSJSONObject, kotlin.Unit> callback) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getOnConfigChangedListenFunc().add(callback);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void offAppConfigChange$default(io.dcloud.uts.UTSAndroid uTSAndroid, kotlin.jvm.functions.Function1 function1, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        uTSAndroid.offAppConfigChange(function1);
    }

    public final void offAppConfigChange(kotlin.jvm.functions.Function1<? super io.dcloud.uts.UTSJSONObject, kotlin.Unit> callback) {
        if (callback == null) {
            io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getOnConfigChangedListenFunc().clear();
        } else {
            io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getOnConfigChangedListenFunc().remove(callback);
        }
    }

    public final void onAppTrimMemory(kotlin.jvm.functions.Function1<? super java.lang.Number, kotlin.Unit> callback) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getOnTrimMemoryListenFunc().add(callback);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void offAppTrimMemory$default(io.dcloud.uts.UTSAndroid uTSAndroid, kotlin.jvm.functions.Function1 function1, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        uTSAndroid.offAppTrimMemory(function1);
    }

    public final void offAppTrimMemory(kotlin.jvm.functions.Function1<? super java.lang.Number, kotlin.Unit> callback) {
        if (callback == null) {
            io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getOnTrimMemoryListenFunc().clear();
        } else {
            io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getOnTrimMemoryListenFunc().remove(callback);
        }
    }

    public final void onAppActivityPause(kotlin.jvm.functions.Function0<kotlin.Unit> callback) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getPauseListenFunc().add(callback);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void offAppActivityPause$default(io.dcloud.uts.UTSAndroid uTSAndroid, kotlin.jvm.functions.Function0 function0, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        uTSAndroid.offAppActivityPause(function0);
    }

    public final void offAppActivityPause(kotlin.jvm.functions.Function0<kotlin.Unit> callback) {
        if (callback == null) {
            io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getPauseListenFunc().clear();
        } else {
            io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getPauseListenFunc().remove(callback);
        }
    }

    public final void onAppActivityResume(kotlin.jvm.functions.Function0<kotlin.Unit> callback) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getResumeListenFunc().add(callback);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void offAppActivityResume$default(io.dcloud.uts.UTSAndroid uTSAndroid, kotlin.jvm.functions.Function0 function0, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        uTSAndroid.offAppActivityResume(function0);
    }

    public final void offAppActivityResume(kotlin.jvm.functions.Function0<kotlin.Unit> callback) {
        if (callback == null) {
            io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getResumeListenFunc().clear();
        } else {
            io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getResumeListenFunc().remove(callback);
        }
    }

    public final void onAppActivityStop(kotlin.jvm.functions.Function0<kotlin.Unit> callback) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getStopListenFunc().add(callback);
    }

    public final void offAppActivityStop(kotlin.jvm.functions.Function0<kotlin.Unit> callback) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getStopListenFunc().remove(callback);
    }

    public final void onAppActivityDestroy(kotlin.jvm.functions.Function0<kotlin.Unit> callback) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getDestroyListenFunc().add(callback);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void offAppActivityDestroy$default(io.dcloud.uts.UTSAndroid uTSAndroid, kotlin.jvm.functions.Function0 function0, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        uTSAndroid.offAppActivityDestroy(function0);
    }

    public final void offAppActivityDestroy(kotlin.jvm.functions.Function0<kotlin.Unit> callback) {
        if (callback == null) {
            io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getDestroyListenFunc().clear();
        } else {
            io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getDestroyListenFunc().remove(callback);
        }
    }

    public final void onAppActivityResult(kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super java.lang.Integer, ? super android.content.Intent, kotlin.Unit> callback) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getOnActivityResultListenFunc().add(callback);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void offAppActivityResult$default(io.dcloud.uts.UTSAndroid uTSAndroid, kotlin.jvm.functions.Function3 function3, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            function3 = null;
        }
        uTSAndroid.offAppActivityResult(function3);
    }

    public final void offAppActivityResult(kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super java.lang.Integer, ? super android.content.Intent, kotlin.Unit> callback) {
        if (callback == null) {
            io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getOnActivityResultListenFunc().clear();
        } else {
            io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getOnActivityResultListenFunc().remove(callback);
        }
    }

    public final void onAppActivityBack(kotlin.jvm.functions.Function0<kotlin.Unit> callback) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getBackListenFunc().add(callback);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void offAppActivityBack$default(io.dcloud.uts.UTSAndroid uTSAndroid, kotlin.jvm.functions.Function0 function0, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        uTSAndroid.offAppActivityBack(function0);
    }

    public final void offAppActivityBack(kotlin.jvm.functions.Function0<kotlin.Unit> callback) {
        if (callback == null) {
            io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getBackListenFunc().clear();
        } else {
            io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getBackListenFunc().remove(callback);
        }
    }

    @kotlin.Deprecated(message = "已废弃，请使用requestSystemPermission", replaceWith = @kotlin.ReplaceWith(expression = "requestSystemPermission", imports = {}))
    public final void onAppActivityRequestPermissionsResult(kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super io.dcloud.uts.UTSArray<java.lang.String>, ? super io.dcloud.uts.UTSArray<java.lang.Number>, kotlin.Unit> callback) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getPermissionsResultListenFunc().add(callback);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void offAppActivityRequestPermissionsResult$default(io.dcloud.uts.UTSAndroid uTSAndroid, kotlin.jvm.functions.Function3 function3, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            function3 = null;
        }
        uTSAndroid.offAppActivityRequestPermissionsResult(function3);
    }

    @kotlin.Deprecated(message = "已废弃，请使用requestSystemPermission", replaceWith = @kotlin.ReplaceWith(expression = "requestSystemPermission", imports = {}))
    public final void offAppActivityRequestPermissionsResult(kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super io.dcloud.uts.UTSArray<java.lang.String>, ? super io.dcloud.uts.UTSArray<java.lang.Number>, kotlin.Unit> callback) {
        if (callback == null) {
            io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getPermissionsResultListenFunc().clear();
        } else {
            io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getPermissionsResultListenFunc().remove(callback);
        }
    }

    public final android.content.Context getAppContext() {
        return io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getHostAppContext();
    }

    public final android.app.Activity getUniActivity() {
        if (getInstance() == null) {
            return null;
        }
        io.dcloud.feature.weex.WeexInstanceMgr weexInstanceMgrSelf = io.dcloud.feature.weex.WeexInstanceMgr.self();
        io.dcloud.feature.uniapp.AbsSDKInstance uTSAndroid = getInstance();
        kotlin.jvm.internal.Intrinsics.checkNotNull(uTSAndroid, "null cannot be cast to non-null type com.taobao.weex.WXSDKInstance");
        io.dcloud.common.DHInterface.IWebview iWebviewFindWebview = weexInstanceMgrSelf.findWebview((com.taobao.weex.WXSDKInstance) uTSAndroid);
        if (iWebviewFindWebview == null) {
            return null;
        }
        return iWebviewFindWebview.getActivity();
    }

    public final android.app.Activity getTopPageActivity() {
        return getUniActivity();
    }

    public final android.view.View getTopPageView() {
        android.view.ViewGroup viewGroup;
        android.app.Activity uniActivity = getUniActivity();
        if (uniActivity == null || (viewGroup = (android.view.ViewGroup) uniActivity.findViewById(android.R.id.content)) == null) {
            return null;
        }
        return viewGroup.getChildAt(0);
    }

    public final java.lang.String getResourcePath(java.lang.String resourceName) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(resourceName, "resourceName");
        if (kotlin.text.StringsKt.startsWith$default(resourceName, "/", false, 2, (java.lang.Object) null)) {
            resourceName = io.dcloud.uts.StringKt.substring$default(resourceName, (java.lang.Number) 1, null, 2, null);
        }
        boolean zIsAppResourcesInAssetsPath = io.dcloud.common.util.AppRuntime.isAppResourcesInAssetsPath(getAppContext(), "");
        java.lang.String str = io.dcloud.common.util.BaseInfo.sCacheFsAppsPath;
        java.lang.String str2 = io.dcloud.common.util.BaseInfo.sDefaultBootApp + "/www/" + resourceName;
        java.lang.String str3 = io.dcloud.feature.internal.sdk.SDK.ANDROID_ASSET + str2;
        if (zIsAppResourcesInAssetsPath) {
            return str3;
        }
        return str + str2;
    }

    public final java.lang.String convert2AbsFullPath(java.lang.String relativePath) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(relativePath, "relativePath");
        if (getInstance() == null) {
            return "";
        }
        io.dcloud.feature.weex.WeexInstanceMgr weexInstanceMgrSelf = io.dcloud.feature.weex.WeexInstanceMgr.self();
        io.dcloud.feature.uniapp.AbsSDKInstance uTSAndroid = getInstance();
        kotlin.jvm.internal.Intrinsics.checkNotNull(uTSAndroid, "null cannot be cast to non-null type com.taobao.weex.WXSDKInstance");
        io.dcloud.common.DHInterface.IWebview iWebviewFindWebview = weexInstanceMgrSelf.findWebview((com.taobao.weex.WXSDKInstance) uTSAndroid);
        java.lang.String strConvert2AbsFullPath = iWebviewFindWebview.obtainFrameView().obtainApp().convert2AbsFullPath(iWebviewFindWebview.obtainFullUrl(), relativePath);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strConvert2AbsFullPath, "convert2AbsFullPath(...)");
        return strConvert2AbsFullPath;
    }

    public final boolean isUniMp() {
        return io.dcloud.feature.internal.sdk.SDK.isUniMP;
    }

    public final java.lang.String typeof(java.lang.Double value) {
        if (value == null) {
            return "object";
        }
        if (java.lang.Double.isNaN(value.doubleValue()) || kotlin.jvm.internal.Intrinsics.areEqual(value, Double.POSITIVE_INFINITY) || kotlin.jvm.internal.Intrinsics.areEqual(value, Double.NEGATIVE_INFINITY)) {
            return "number";
        }
        return "Double";
    }

    public final java.lang.String typeof(java.lang.Float value) {
        if (value == null) {
            return "object";
        }
        if (java.lang.Float.isNaN(value.floatValue()) || kotlin.jvm.internal.Intrinsics.areEqual(value, Float.POSITIVE_INFINITY) || kotlin.jvm.internal.Intrinsics.areEqual(value, Float.NEGATIVE_INFINITY)) {
            return "number";
        }
        return "Float";
    }

    public final java.lang.String typeof(java.lang.Integer value) {
        if (value == null) {
            return "object";
        }
        return "Int";
    }

    /* JADX INFO: renamed from: typeof-ExVfyTY, reason: not valid java name */
    public final java.lang.String m512typeofExVfyTY(kotlin.UInt value) {
        if (value == null) {
            return "object";
        }
        return "UInt";
    }

    public final java.lang.String typeof(java.lang.Byte value) {
        if (value == null) {
            return "object";
        }
        return "Byte";
    }

    /* JADX INFO: renamed from: typeof-3swpYEE, reason: not valid java name */
    public final java.lang.String m510typeof3swpYEE(kotlin.UByte value) {
        if (value == null) {
            return "object";
        }
        return "UByte";
    }

    public final java.lang.String typeof(java.lang.Short value) {
        if (value == null) {
            return "object";
        }
        return "Short";
    }

    /* JADX INFO: renamed from: typeof-ffyZV3s, reason: not valid java name */
    public final java.lang.String m513typeofffyZV3s(kotlin.UShort value) {
        if (value == null) {
            return "object";
        }
        return "UShort";
    }

    public final java.lang.String typeof(java.lang.Long value) {
        if (value == null) {
            return "object";
        }
        return "Long";
    }

    /* JADX INFO: renamed from: typeof-ADd3fzo, reason: not valid java name */
    public final java.lang.String m511typeofADd3fzo(kotlin.ULong value) {
        if (value == null) {
            return "object";
        }
        return "ULong";
    }

    public final java.lang.String typeof(java.lang.Number value) {
        if (value == null) {
            return "object";
        }
        return "number";
    }

    public final java.lang.String typeof(java.lang.Object value) {
        if (value instanceof java.lang.String) {
            return "string";
        }
        if (value instanceof java.lang.Character) {
            return "Char";
        }
        if (value instanceof java.lang.Number) {
            return "number";
        }
        if (value instanceof java.lang.Boolean) {
            return "boolean";
        }
        if (value instanceof kotlin.Function) {
            return "function";
        }
        if (value instanceof kotlin.UByte) {
            return "UByte";
        }
        if (value instanceof kotlin.UShort) {
            return "UShort";
        }
        if (value instanceof kotlin.ULong) {
            return "ULong";
        }
        if (value instanceof kotlin.UInt) {
            return "UInt";
        }
        return "object";
    }

    public final /* synthetic */ <T> java.lang.reflect.Type getGenericType() {
        kotlin.jvm.internal.Intrinsics.needClassReification();
        java.lang.reflect.Type type = new io.dcloud.uts.gson.reflect.TypeToken<T>() { // from class: io.dcloud.uts.UTSAndroid.getGenericType.1
        }.getType();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
        return type;
    }

    public final /* synthetic */ <T> java.lang.String getGenericClassName() {
        kotlin.jvm.internal.Intrinsics.needClassReification();
        java.lang.String name = new io.dcloud.uts.gson.reflect.TypeToken<T>() { // from class: io.dcloud.uts.UTSAndroid.getGenericClassName.1
        }.getRawType().getName();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        return name;
    }

    public final boolean checkSystemPermissionGranted(android.app.Activity context, io.dcloud.uts.UTSArray<java.lang.String> requestPermission) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(requestPermission, "requestPermission");
        return com.hjq.permissions.XXPermissions.isGranted(context, requestPermission);
    }

    public final io.dcloud.uts.UTSArray<java.lang.String> getSystemPermissionDenied(android.app.Activity context, io.dcloud.uts.UTSArray<java.lang.String> requestPermission) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(requestPermission, "requestPermission");
        io.dcloud.uts.UTSArray.Companion companion = io.dcloud.uts.UTSArray.INSTANCE;
        java.util.List<java.lang.String> denied = com.hjq.permissions.XXPermissions.getDenied(context, requestPermission);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(denied, "getDenied(...)");
        return companion.fromNative(denied);
    }

    public final void gotoSystemPermissionActivity(android.app.Activity context, io.dcloud.uts.UTSArray<java.lang.String> requestPermission) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(requestPermission, "requestPermission");
        com.hjq.permissions.XXPermissions.startPermissionActivity(context, (java.util.List<java.lang.String>) requestPermission);
    }

    public final void requestSystemPermission(android.app.Activity context, io.dcloud.uts.UTSArray<java.lang.String> requestPermission, final kotlin.jvm.functions.Function2<? super java.lang.Boolean, ? super io.dcloud.uts.UTSArray<java.lang.String>, kotlin.Unit> success, final kotlin.jvm.functions.Function2<? super java.lang.Boolean, ? super io.dcloud.uts.UTSArray<java.lang.String>, kotlin.Unit> fail, boolean shallUnCheck) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(requestPermission, "requestPermission");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(success, "success");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fail, "fail");
        io.dcloud.uts.android.AndroidUTSContext androidUTSContext = io.dcloud.uts.android.AndroidUTSContext.INSTANCE;
        java.lang.String TYPE_REQUEST = io.dcloud.common.DHInterface.message.action.PermissionRequestAction.TYPE_REQUEST;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(TYPE_REQUEST, "TYPE_REQUEST");
        androidUTSContext.permission(TYPE_REQUEST, requestPermission);
        android.app.Activity activity = context;
        io.dcloud.uts.UTSArray<java.lang.String> uTSArray = requestPermission;
        if (com.hjq.permissions.XXPermissions.isGranted(activity, uTSArray)) {
            success.invoke(true, io.dcloud.uts.UTSArray.INSTANCE.fromNative(uTSArray));
            io.dcloud.uts.android.AndroidUTSContext androidUTSContext2 = io.dcloud.uts.android.AndroidUTSContext.INSTANCE;
            java.lang.String TYPE_COMPLETE = io.dcloud.common.DHInterface.message.action.PermissionRequestAction.TYPE_COMPLETE;
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(TYPE_COMPLETE, "TYPE_COMPLETE");
            androidUTSContext2.permission(TYPE_COMPLETE, requestPermission);
            return;
        }
        java.util.List<java.lang.String> denied = com.hjq.permissions.XXPermissions.getDenied(activity, uTSArray);
        kotlin.jvm.internal.Intrinsics.checkNotNull(denied);
        requestPermission.removeAll(denied);
        if (requestPermission.size() > 0) {
            io.dcloud.uts.android.AndroidUTSContext androidUTSContext3 = io.dcloud.uts.android.AndroidUTSContext.INSTANCE;
            java.lang.String TYPE_COMPLETE2 = io.dcloud.common.DHInterface.message.action.PermissionRequestAction.TYPE_COMPLETE;
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(TYPE_COMPLETE2, "TYPE_COMPLETE");
            androidUTSContext3.permission(TYPE_COMPLETE2, requestPermission);
        }
        io.dcloud.uts.android.AndroidUTSContext androidUTSContext4 = io.dcloud.uts.android.AndroidUTSContext.INSTANCE;
        java.lang.String TYPE_CONFIRM = io.dcloud.common.DHInterface.message.action.PermissionRequestAction.TYPE_CONFIRM;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(TYPE_CONFIRM, "TYPE_CONFIRM");
        androidUTSContext4.permission(TYPE_CONFIRM, io.dcloud.uts.UTSArray.INSTANCE.fromNative(denied));
        com.hjq.permissions.XXPermissions xXPermissionsWith = com.hjq.permissions.XXPermissions.with(activity);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(xXPermissionsWith, "with(...)");
        if (shallUnCheck) {
            xXPermissionsWith = com.hjq.permissions.XXPermissions.with(activity).unchecked();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(xXPermissionsWith, "unchecked(...)");
        }
        xXPermissionsWith.permission(denied).request(new com.hjq.permissions.OnPermissionCallback() { // from class: io.dcloud.uts.UTSAndroid.requestSystemPermission.1
            @Override // com.hjq.permissions.OnPermissionCallback
            public void onGranted(java.util.List<java.lang.String> permissions, boolean allGranted) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(permissions, "permissions");
                io.dcloud.uts.UTSArray<java.lang.String> uTSArrayFromNative = io.dcloud.uts.UTSArray.INSTANCE.fromNative(permissions);
                success.invoke(java.lang.Boolean.valueOf(allGranted), uTSArrayFromNative);
                io.dcloud.uts.android.AndroidUTSContext androidUTSContext5 = io.dcloud.uts.android.AndroidUTSContext.INSTANCE;
                java.lang.String TYPE_COMPLETE3 = io.dcloud.common.DHInterface.message.action.PermissionRequestAction.TYPE_COMPLETE;
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(TYPE_COMPLETE3, "TYPE_COMPLETE");
                androidUTSContext5.permission(TYPE_COMPLETE3, uTSArrayFromNative);
            }

            @Override // com.hjq.permissions.OnPermissionCallback
            public void onDenied(java.util.List<java.lang.String> permissions, boolean doNotAskAgain) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(permissions, "permissions");
                io.dcloud.uts.UTSArray<java.lang.String> uTSArrayFromNative = io.dcloud.uts.UTSArray.INSTANCE.fromNative(permissions);
                fail.invoke(java.lang.Boolean.valueOf(doNotAskAgain), uTSArrayFromNative);
                io.dcloud.uts.android.AndroidUTSContext androidUTSContext5 = io.dcloud.uts.android.AndroidUTSContext.INSTANCE;
                java.lang.String TYPE_COMPLETE3 = io.dcloud.common.DHInterface.message.action.PermissionRequestAction.TYPE_COMPLETE;
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(TYPE_COMPLETE3, "TYPE_COMPLETE");
                androidUTSContext5.permission(TYPE_COMPLETE3, uTSArrayFromNative);
            }
        });
    }

    public final void onPermissionRequest(kotlin.jvm.functions.Function1<? super io.dcloud.uts.UTSArray<java.lang.String>, kotlin.Unit> listener) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(listener, "listener");
        io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getPermissionRequestFunc().add(listener);
    }

    public final void onPermissionConfirm(kotlin.jvm.functions.Function1<? super io.dcloud.uts.UTSArray<java.lang.String>, kotlin.Unit> listener) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(listener, "listener");
        io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getPermissionConfirmFunc().add(listener);
    }

    public final void onPermissionComplete(kotlin.jvm.functions.Function1<? super io.dcloud.uts.UTSArray<java.lang.String>, kotlin.Unit> listener) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(listener, "listener");
        io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getPermissionRequestFinishedFunc().add(listener);
    }

    public final void offPermissionRequest(kotlin.jvm.functions.Function1<? super io.dcloud.uts.UTSArray<java.lang.String>, kotlin.Unit> listener) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(listener, "listener");
        io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getPermissionRequestFunc().remove(listener);
    }

    public final void offPermissionConfirm(kotlin.jvm.functions.Function1<? super io.dcloud.uts.UTSArray<java.lang.String>, kotlin.Unit> listener) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(listener, "listener");
        io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getPermissionConfirmFunc().remove(listener);
    }

    public final void offPermissionComplete(kotlin.jvm.functions.Function1<? super io.dcloud.uts.UTSArray<java.lang.String>, kotlin.Unit> listener) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(listener, "listener");
        io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getPermissionRequestFinishedFunc().remove(listener);
    }

    private final io.dcloud.feature.uniapp.AbsSDKInstance getInstance() {
        if (io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getInstance() != null) {
            return io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getInstance();
        }
        if (com.taobao.weex.WXSDKManager.getInstance().getAllInstanceMap().isEmpty()) {
            return null;
        }
        java.util.Map<java.lang.String, com.taobao.weex.WXSDKInstance> allInstanceMap = com.taobao.weex.WXSDKManager.getInstance().getAllInstanceMap();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(allInstanceMap, "getAllInstanceMap(...)");
        return (io.dcloud.feature.uniapp.AbsSDKInstance) ((kotlin.Pair) kotlin.collections.CollectionsKt.last(kotlin.collections.MapsKt.toList(allInstanceMap))).getSecond();
    }

    public final java.lang.String appJSBundleUrl() {
        io.dcloud.feature.uniapp.AbsSDKInstance uTSAndroid = getInstance();
        if (uTSAndroid != null) {
            return uTSAndroid.getBundleUrl();
        }
        return null;
    }

    public final boolean appRunAssetMode() {
        return io.dcloud.common.util.AppRuntime.isAppResourcesInAssetsPath(getAppContext(), "");
    }

    public final boolean getAppDarkMode() {
        return io.dcloud.common.util.AppRuntime.getAppDarkMode(getAppContext());
    }

    public final java.lang.String getAppTheme() {
        java.lang.String appTheme = io.dcloud.common.util.AppRuntime.getAppTheme(getAppContext());
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(appTheme, "getAppTheme(...)");
        return appTheme;
    }

    @kotlin.Deprecated(message = "已废弃，请使用getAppCachePath", replaceWith = @kotlin.ReplaceWith(expression = "getAppCachePath", imports = {}))
    public final java.lang.String getAppTempPath() {
        if (getInstance() == null) {
            return null;
        }
        io.dcloud.feature.weex.WeexInstanceMgr weexInstanceMgrSelf = io.dcloud.feature.weex.WeexInstanceMgr.self();
        io.dcloud.feature.uniapp.AbsSDKInstance uTSAndroid = getInstance();
        kotlin.jvm.internal.Intrinsics.checkNotNull(uTSAndroid, "null cannot be cast to non-null type com.taobao.weex.WXSDKInstance");
        io.dcloud.common.DHInterface.IApp iAppObtainApp = weexInstanceMgrSelf.findWebview((com.taobao.weex.WXSDKInstance) uTSAndroid).obtainApp();
        if (iAppObtainApp != null) {
            return iAppObtainApp.obtainAppTempPath();
        }
        return null;
    }

    public final java.lang.String getAppCachePath() {
        if (getInstance() == null) {
            return null;
        }
        io.dcloud.feature.weex.WeexInstanceMgr weexInstanceMgrSelf = io.dcloud.feature.weex.WeexInstanceMgr.self();
        io.dcloud.feature.uniapp.AbsSDKInstance uTSAndroid = getInstance();
        kotlin.jvm.internal.Intrinsics.checkNotNull(uTSAndroid, "null cannot be cast to non-null type com.taobao.weex.WXSDKInstance");
        io.dcloud.common.DHInterface.IApp iAppObtainApp = weexInstanceMgrSelf.findWebview((com.taobao.weex.WXSDKInstance) uTSAndroid).obtainApp();
        if (iAppObtainApp != null) {
            return iAppObtainApp.obtainAppTempPath();
        }
        return null;
    }

    public final boolean isPrivacyAgree() {
        return io.dcloud.common.ui.PrivacyManager.getInstance().isAgreePrivacy(getAppContext());
    }

    public final boolean isUIThread() {
        return android.os.Looper.getMainLooper().getThread() == java.lang.Thread.currentThread();
    }

    public final void setPrivacyAgree(boolean newVal) {
        io.dcloud.common.ui.PrivacyManager.getInstance().setAgreePrivacy(getAppContext(), newVal);
    }

    public final void resetPrivacyAgree() {
        io.dcloud.common.ui.PrivacyManager.getInstance().resetPrivacyLocalConfig(getAppContext());
    }

    public final io.dcloud.uts.UTSJSONObject getLanguageInfo(android.content.Context context) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        io.dcloud.uts.UTSJSONObject uTSJSONObject = new io.dcloud.uts.UTSJSONObject();
        uTSJSONObject.set("appLanguage", io.dcloud.common.util.language.LanguageUtil.getCurrentLocaleLanguage(context));
        uTSJSONObject.set("osLanguage", io.dcloud.common.util.language.LanguageUtil.getDeviceDefLocalLanguage());
        return uTSJSONObject;
    }

    public final io.dcloud.uts.UTSJSONObject getWebViewInfo(android.content.Context context) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        if (getInstance() == null) {
            return new io.dcloud.uts.UTSJSONObject();
        }
        io.dcloud.uts.UTSJSONObject uTSJSONObject = new io.dcloud.uts.UTSJSONObject();
        io.dcloud.feature.weex.WeexInstanceMgr weexInstanceMgrSelf = io.dcloud.feature.weex.WeexInstanceMgr.self();
        io.dcloud.feature.uniapp.AbsSDKInstance uTSAndroid = getInstance();
        kotlin.jvm.internal.Intrinsics.checkNotNull(uTSAndroid, "null cannot be cast to non-null type com.taobao.weex.WXSDKInstance");
        uTSJSONObject.set("ua", weexInstanceMgrSelf.findWebview((com.taobao.weex.WXSDKInstance) uTSAndroid).getWebviewProperty(io.dcloud.common.DHInterface.IWebview.USER_AGENT));
        uTSJSONObject.set("version", io.dcloud.common.adapter.ui.webview.WebViewFactory.getWebViewUserAgentVersion(context));
        uTSJSONObject.set("kernel", io.dcloud.common.adapter.ui.webview.WebViewFactory.isOther() ? "x5webview" : "chrome");
        return uTSJSONObject;
    }

    public final java.lang.String getDeviceID(android.content.Context context) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        java.lang.String dCloudDeviceID = io.dcloud.common.util.AppRuntime.getDCloudDeviceID(context);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(dCloudDeviceID, "getDCloudDeviceID(...)");
        return dCloudDeviceID;
    }

    public final java.lang.String getOAID() {
        if (io.dcloud.common.adapter.util.DeviceInfo.oaids != null) {
            java.lang.String oaids = io.dcloud.common.adapter.util.DeviceInfo.oaids;
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(oaids, "oaids");
            java.lang.String[] strArr = (java.lang.String[]) io.dcloud.uts.StringKt.split(oaids, "|").toArray(new java.lang.String[0]);
            if (!(strArr.length == 0)) {
                return strArr[0];
            }
        }
        return "";
    }

    public final java.lang.String getInnerVersion() {
        return "1.9.9.82680";
    }

    public final java.lang.String getUniCompileVersion() {
        java.lang.Object objDispatchEvent = io.dcloud.EntryProxy.getInstnace().getCoreHandler().dispatchEvent(io.dcloud.common.DHInterface.IMgr.MgrType.AppMgr, 28, io.dcloud.common.util.BaseInfo.sDefaultBootApp);
        kotlin.jvm.internal.Intrinsics.checkNotNull(objDispatchEvent, "null cannot be cast to non-null type io.dcloud.common.DHInterface.IApp");
        java.lang.String strObtainConfigProperty = ((io.dcloud.common.DHInterface.IApp) objDispatchEvent).obtainConfigProperty(io.dcloud.common.constant.AbsoluteConst.APP_UNIAPP_VERSION);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strObtainConfigProperty, "obtainConfigProperty(...)");
        return strObtainConfigProperty;
    }

    public final java.lang.String getUniRuntimeVersion() {
        java.lang.String uniVersionV3 = io.dcloud.common.util.BaseInfo.uniVersionV3;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(uniVersionV3, "uniVersionV3");
        return uniVersionV3;
    }

    public final java.lang.String getAppId() {
        java.lang.String sCurrentAppOriginalAppid = io.dcloud.common.util.BaseInfo.sCurrentAppOriginalAppid;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(sCurrentAppOriginalAppid, "sCurrentAppOriginalAppid");
        return sCurrentAppOriginalAppid;
    }

    public final io.dcloud.uts.UTSJSONObject getAppVersion() {
        io.dcloud.uts.UTSJSONObject uTSJSONObject = new io.dcloud.uts.UTSJSONObject();
        java.lang.Object objDispatchEvent = io.dcloud.EntryProxy.getInstnace().getCoreHandler().dispatchEvent(io.dcloud.common.DHInterface.IMgr.MgrType.AppMgr, 28, io.dcloud.common.util.BaseInfo.sDefaultBootApp);
        kotlin.jvm.internal.Intrinsics.checkNotNull(objDispatchEvent, "null cannot be cast to non-null type io.dcloud.common.DHInterface.IApp");
        io.dcloud.common.DHInterface.IApp iApp = (io.dcloud.common.DHInterface.IApp) objDispatchEvent;
        uTSJSONObject.set("name", iApp.obtainAppVersionName());
        uTSJSONObject.set("code", iApp.obtainAppVersionCode());
        return uTSJSONObject;
    }

    public final java.lang.String getAppName() {
        java.lang.Object objDispatchEvent = io.dcloud.EntryProxy.getInstnace().getCoreHandler().dispatchEvent(io.dcloud.common.DHInterface.IMgr.MgrType.AppMgr, 28, io.dcloud.common.util.BaseInfo.sDefaultBootApp);
        kotlin.jvm.internal.Intrinsics.checkNotNull(objDispatchEvent, "null cannot be cast to non-null type io.dcloud.common.DHInterface.IApp");
        java.lang.String strObtainAppName = ((io.dcloud.common.DHInterface.IApp) objDispatchEvent).obtainAppName();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strObtainAppName, "obtainAppName(...)");
        return strObtainAppName;
    }

    public final java.lang.String getOsTheme() {
        return io.dcloud.common.adapter.util.DeviceInfo.isSystemNightMode(getUniActivity()).booleanValue() ? io.dcloud.common.ui.blur.DCBlurDraweeView.DARK : io.dcloud.common.ui.blur.DCBlurDraweeView.LIGHT;
    }

    public final io.dcloud.uts.UTSJSONObject getScreenInfo() {
        io.dcloud.uts.UTSJSONObject uTSJSONObject = new io.dcloud.uts.UTSJSONObject();
        java.lang.Object objDispatchEvent = io.dcloud.EntryProxy.getInstnace().getCoreHandler().dispatchEvent(io.dcloud.common.DHInterface.IMgr.MgrType.AppMgr, 28, io.dcloud.common.util.BaseInfo.sDefaultBootApp);
        kotlin.jvm.internal.Intrinsics.checkNotNull(objDispatchEvent, "null cannot be cast to non-null type io.dcloud.common.DHInterface.IApp");
        io.dcloud.common.DHInterface.IApp iApp = (io.dcloud.common.DHInterface.IApp) objDispatchEvent;
        int i = iApp.getInt(0);
        int i2 = iApp.getInt(1);
        float scale = getScale();
        uTSJSONObject.set("screenWidth", java.lang.Integer.valueOf(kotlin.math.MathKt.roundToInt(i / scale)));
        uTSJSONObject.set("screenHeight", java.lang.Integer.valueOf(kotlin.math.MathKt.roundToInt(i2 / scale)));
        return uTSJSONObject;
    }

    public final int getStatusBarHeight() {
        io.dcloud.common.adapter.util.DeviceInfo.updateStatusBarHeight(getUniActivity());
        return kotlin.math.MathKt.roundToInt(io.dcloud.common.adapter.util.DeviceInfo.sStatusBarHeight / getScale());
    }

    public final boolean isTitleNViewShow() {
        io.dcloud.feature.weex.WeexInstanceMgr weexInstanceMgrSelf = io.dcloud.feature.weex.WeexInstanceMgr.self();
        io.dcloud.feature.uniapp.AbsSDKInstance uTSAndroid = getInstance();
        kotlin.jvm.internal.Intrinsics.checkNotNull(uTSAndroid, "null cannot be cast to non-null type com.taobao.weex.WXSDKInstance");
        io.dcloud.common.DHInterface.IWebview iWebviewFindWebview = weexInstanceMgrSelf.findWebview((com.taobao.weex.WXSDKInstance) uTSAndroid);
        kotlin.jvm.internal.Intrinsics.checkNotNull(iWebviewFindWebview, "null cannot be cast to non-null type io.dcloud.common.adapter.ui.AdaWebview");
        io.dcloud.common.adapter.util.ViewOptions viewOptionsObtainFrameOptions = ((io.dcloud.common.adapter.ui.AdaWebview) iWebviewFindWebview).mFrameView.obtainFrameOptions();
        return (viewOptionsObtainFrameOptions == null || viewOptionsObtainFrameOptions.titleNView != null || viewOptionsObtainFrameOptions.isStatusbar) ? false : true;
    }

    public final boolean isTabBarShow() {
        io.dcloud.common.core.ui.TabBarWebview launchTabBar = io.dcloud.common.core.ui.TabBarWebviewMgr.getInstance().getLaunchTabBar();
        return launchTabBar != null && launchTabBar.isVisible();
    }

    private final float getScale() {
        android.app.Activity uniActivity = getUniActivity();
        java.lang.Object systemService = uniActivity != null ? uniActivity.getSystemService("window") : null;
        kotlin.jvm.internal.Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
        ((android.view.WindowManager) systemService).getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.scaledDensity;
    }

    public final int getWindowHeight() {
        int statusBarHeight = getStatusBarHeight();
        java.lang.Object objDispatchEvent = io.dcloud.EntryProxy.getInstnace().getCoreHandler().dispatchEvent(io.dcloud.common.DHInterface.IMgr.MgrType.AppMgr, 28, io.dcloud.common.util.BaseInfo.sDefaultBootApp);
        kotlin.jvm.internal.Intrinsics.checkNotNull(objDispatchEvent, "null cannot be cast to non-null type io.dcloud.common.DHInterface.IApp");
        int iRoundToInt = kotlin.math.MathKt.roundToInt(((io.dcloud.common.DHInterface.IApp) objDispatchEvent).getInt(1) / getScale());
        java.lang.Number[] numberArr = new java.lang.Number[2];
        numberArr[0] = java.lang.Integer.valueOf((iRoundToInt - (isTitleNViewShow() ? statusBarHeight + 44 : 0)) - (isTabBarShow() ? 50 : 0));
        numberArr[1] = java.lang.Integer.valueOf(iRoundToInt);
        return io.dcloud.uts.Math.min(numberArr).intValue();
    }

    public final int getWindowWidth() {
        java.lang.Object objDispatchEvent = io.dcloud.EntryProxy.getInstnace().getCoreHandler().dispatchEvent(io.dcloud.common.DHInterface.IMgr.MgrType.AppMgr, 28, io.dcloud.common.util.BaseInfo.sDefaultBootApp);
        kotlin.jvm.internal.Intrinsics.checkNotNull(objDispatchEvent, "null cannot be cast to non-null type io.dcloud.common.DHInterface.IApp");
        return io.dcloud.uts.Math.ceil(java.lang.Float.valueOf(((io.dcloud.common.DHInterface.IApp) objDispatchEvent).getInt(0) / getScale())).intValue();
    }

    public final io.dcloud.uts.UTSJSONObject getSafeAreaInsets() {
        io.dcloud.uts.UTSJSONObject uTSJSONObject = new io.dcloud.uts.UTSJSONObject();
        uTSJSONObject.set("left", 0);
        uTSJSONObject.set("right", 0);
        uTSJSONObject.set("bottom", 0);
        uTSJSONObject.set("top", java.lang.Integer.valueOf(isTitleNViewShow() ? 0 : getStatusBarHeight()));
        return uTSJSONObject;
    }

    @kotlin.Deprecated(message = "已废弃，使用 exit()替代", replaceWith = @kotlin.ReplaceWith(expression = "utsAndroid!!.quitApp()", imports = {"io.dcloud.uts.UTSAndroid.utsAndroid"}))
    public final void quitApp() {
        android.app.Activity uniActivity = INSTANCE.getUniActivity();
        if (uniActivity != null) {
            uniActivity.finish();
        }
    }

    public final void exit() {
        android.app.Activity uniActivity = INSTANCE.getUniActivity();
        if (uniActivity != null) {
            uniActivity.finish();
        }
    }

    public final java.lang.Class<?> getJavaClass(java.lang.Object input) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(input, "input");
        return input.getClass();
    }

    public final kotlin.reflect.KClass<?> getKotlinClass(java.lang.Object input) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(input, "input");
        return kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(input.getClass());
    }

    public static /* synthetic */ io.dcloud.uts.task.UTSTaskDispatcher getDispatcher$default(io.dcloud.uts.UTSAndroid uTSAndroid, java.lang.String str, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return uTSAndroid.getDispatcher(str);
    }

    public final io.dcloud.uts.task.UTSTaskDispatcher getDispatcher(java.lang.String threadName) {
        java.lang.String str = threadName;
        if (str == null || str.length() == 0) {
            return new io.dcloud.uts.task.UTSTaskDispatcher(android.os.Looper.myLooper());
        }
        java.lang.String lowerCase = io.dcloud.uts.StringKt.toLowerCase(threadName);
        int iHashCode = lowerCase.hashCode();
        if (iHashCode != 3366) {
            if (iHashCode != 99650) {
                if (iHashCode == 3343801 && lowerCase.equals("main")) {
                    return new io.dcloud.uts.task.MainTaskDispatcher();
                }
            } else if (lowerCase.equals(com.taobao.weex.ui.module.WXDomModule.WXDOM)) {
                return new io.dcloud.uts.task.MainTaskDispatcher();
            }
        } else if (lowerCase.equals("io")) {
            return new io.dcloud.uts.task.IOTaskDispatcher();
        }
        io.dcloud.uts.console.log("getDispatcher error: can not find " + threadName);
        return new io.dcloud.uts.task.UTSTaskDispatcher(android.os.Looper.myLooper());
    }

    @kotlin.Deprecated(message = "已废弃，使用 getDispatcher 方法来替代")
    public final void dispatchAsync(java.lang.String threadName, kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> action, java.lang.Object param) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(threadName, "threadName");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(action, "action");
        int iHashCode = threadName.hashCode();
        if (iHashCode != 3366) {
            if (iHashCode != 99650) {
                if (iHashCode == 3343801 && threadName.equals("main")) {
                    kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(kotlinx.coroutines.CoroutineScopeKt.MainScope(), null, null, new io.dcloud.uts.UTSAndroid.AnonymousClass1(action, param, null), 3, null);
                    return;
                }
            } else if (threadName.equals(com.taobao.weex.ui.module.WXDomModule.WXDOM)) {
                kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(kotlinx.coroutines.CoroutineScopeKt.MainScope(), null, null, new io.dcloud.uts.UTSAndroid.AnonymousClass2(action, param, null), 3, null);
                return;
            }
        } else if (threadName.equals("io")) {
            kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(kotlinx.coroutines.CoroutineScopeKt.CoroutineScope(kotlinx.coroutines.Dispatchers.getIO()), null, null, new io.dcloud.uts.UTSAndroid.AnonymousClass3(action, param, null), 3, null);
            return;
        }
        io.dcloud.uts.console.log("error: can not find " + threadName);
        kotlin.Unit unit = kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: io.dcloud.uts.UTSAndroid$dispatchAsync$1, reason: invalid class name */
    /* JADX INFO: compiled from: UTSAndroid.kt */
    @kotlin.Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @kotlin.coroutines.jvm.internal.DebugMetadata(c = "io.dcloud.uts.UTSAndroid$dispatchAsync$1", f = "UTSAndroid.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.SuspendLambda implements kotlin.jvm.functions.Function2<kotlinx.coroutines.CoroutineScope, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> {
        final /* synthetic */ kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> $action;
        final /* synthetic */ java.lang.Object $param;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> function1, java.lang.Object obj, kotlin.coroutines.Continuation<? super io.dcloud.uts.UTSAndroid.AnonymousClass1> continuation) {
            super(2, continuation);
            this.$action = function1;
            this.$param = obj;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.Continuation<kotlin.Unit> create(java.lang.Object obj, kotlin.coroutines.Continuation<?> continuation) {
            return new io.dcloud.uts.UTSAndroid.AnonymousClass1(this.$action, this.$param, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final java.lang.Object invoke(kotlinx.coroutines.CoroutineScope coroutineScope, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
            return ((io.dcloud.uts.UTSAndroid.AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(kotlin.Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object obj) {
            kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.ResultKt.throwOnFailure(obj);
            this.$action.invoke2(this.$param);
            return kotlin.Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: io.dcloud.uts.UTSAndroid$dispatchAsync$2, reason: invalid class name */
    /* JADX INFO: compiled from: UTSAndroid.kt */
    @kotlin.Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @kotlin.coroutines.jvm.internal.DebugMetadata(c = "io.dcloud.uts.UTSAndroid$dispatchAsync$2", f = "UTSAndroid.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends kotlin.coroutines.jvm.internal.SuspendLambda implements kotlin.jvm.functions.Function2<kotlinx.coroutines.CoroutineScope, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> {
        final /* synthetic */ kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> $action;
        final /* synthetic */ java.lang.Object $param;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> function1, java.lang.Object obj, kotlin.coroutines.Continuation<? super io.dcloud.uts.UTSAndroid.AnonymousClass2> continuation) {
            super(2, continuation);
            this.$action = function1;
            this.$param = obj;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.Continuation<kotlin.Unit> create(java.lang.Object obj, kotlin.coroutines.Continuation<?> continuation) {
            return new io.dcloud.uts.UTSAndroid.AnonymousClass2(this.$action, this.$param, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final java.lang.Object invoke(kotlinx.coroutines.CoroutineScope coroutineScope, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
            return ((io.dcloud.uts.UTSAndroid.AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(kotlin.Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object obj) {
            kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.ResultKt.throwOnFailure(obj);
            this.$action.invoke2(this.$param);
            return kotlin.Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: io.dcloud.uts.UTSAndroid$dispatchAsync$3, reason: invalid class name */
    /* JADX INFO: compiled from: UTSAndroid.kt */
    @kotlin.Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @kotlin.coroutines.jvm.internal.DebugMetadata(c = "io.dcloud.uts.UTSAndroid$dispatchAsync$3", f = "UTSAndroid.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends kotlin.coroutines.jvm.internal.SuspendLambda implements kotlin.jvm.functions.Function2<kotlinx.coroutines.CoroutineScope, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> {
        final /* synthetic */ kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> $action;
        final /* synthetic */ java.lang.Object $param;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> function1, java.lang.Object obj, kotlin.coroutines.Continuation<? super io.dcloud.uts.UTSAndroid.AnonymousClass3> continuation) {
            super(2, continuation);
            this.$action = function1;
            this.$param = obj;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.Continuation<kotlin.Unit> create(java.lang.Object obj, kotlin.coroutines.Continuation<?> continuation) {
            return new io.dcloud.uts.UTSAndroid.AnonymousClass3(this.$action, this.$param, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final java.lang.Object invoke(kotlinx.coroutines.CoroutineScope coroutineScope, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
            return ((io.dcloud.uts.UTSAndroid.AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(kotlin.Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object obj) {
            kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.ResultKt.throwOnFailure(obj);
            this.$action.invoke2(this.$param);
            return kotlin.Unit.INSTANCE;
        }
    }

    public final java.lang.Number rpx2px(java.lang.Number rpx) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(rpx, "rpx");
        if (getInstance() == null) {
            return (java.lang.Number) 0;
        }
        float floatByViewport = com.taobao.weex.utils.WXUtils.getFloatByViewport((java.lang.Object) rpx, 750);
        io.dcloud.feature.uniapp.AbsSDKInstance uTSAndroid = getInstance();
        kotlin.jvm.internal.Intrinsics.checkNotNull(uTSAndroid);
        float realPxByWidth = (int) com.taobao.weex.utils.WXViewUtils.getRealPxByWidth(floatByViewport, uTSAndroid.getInstanceViewPortWidthWithFloat());
        io.dcloud.feature.uniapp.AbsSDKInstance uTSAndroid2 = getInstance();
        kotlin.jvm.internal.Intrinsics.checkNotNull(uTSAndroid2);
        return java.lang.Integer.valueOf(kotlin.math.MathKt.roundToInt(realPxByWidth / uTSAndroid2.getContext().getApplicationContext().getResources().getDisplayMetrics().density));
    }

    public final java.lang.Number devicePX2px(java.lang.Number devicePX) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(devicePX, "devicePX");
        return java.lang.Float.valueOf(com.taobao.weex.utils.WXViewUtils.getWeexPxByReal(devicePX.floatValue(), 750));
    }

    private final void initUTSHooksClassArray(android.app.Application application) {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName(application.getPackageName() + ".BuildConfig");
            if (cls == null) {
                return;
            }
            java.lang.Object obj = cls.getField("UTSHooksClassArray").get(null);
            java.lang.String[] strArr = obj instanceof java.lang.String[] ? (java.lang.String[]) obj : null;
            if (strArr != null) {
                for (java.lang.String str : strArr) {
                    java.util.List<java.lang.String> list = initedHookProxys;
                    if (!list.contains(str)) {
                        try {
                            java.lang.Class<?> cls2 = java.lang.Class.forName(str);
                            if (cls2 != null) {
                                java.lang.Object objNewInstance = cls2.newInstance();
                                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                                if (objNewInstance instanceof io.dcloud.uts.UTSAndroidHookProxy) {
                                    list.add(str);
                                    ((io.dcloud.uts.UTSAndroidHookProxy) objNewInstance).onCreate(application);
                                }
                            }
                        } catch (java.lang.Exception unused) {
                        }
                    }
                }
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        try {
            io.dcloud.uts.android.AndroidUTSContext.INSTANCE.setHostAppContext(application.getApplicationContext());
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
    }

    public final kotlinx.coroutines.CoroutineDispatcher getDomCoroutineDispatcher() {
        return kotlinx.coroutines.Dispatchers.getDefault();
    }

    public final android.net.Uri getFileProviderUri(java.io.File file) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(file, "file");
        io.dcloud.uts.UTSAndroid uTSAndroid = INSTANCE;
        if (uTSAndroid.getAppContext() == null) {
            return null;
        }
        android.content.Context appContext = uTSAndroid.getAppContext();
        kotlin.jvm.internal.Intrinsics.checkNotNull(appContext);
        java.lang.String packageName = appContext.getPackageName();
        android.content.Context appContext2 = uTSAndroid.getAppContext();
        kotlin.jvm.internal.Intrinsics.checkNotNull(appContext2);
        return androidx.core.content.FileProvider.getUriForFile(appContext2, packageName + ".dc.fileprovider", file);
    }

    public final void onPrivacyAgreeChange(final kotlin.jvm.functions.Function1<? super io.dcloud.uts.PrivacyOption, kotlin.Unit> callback) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        java.lang.String string = java.util.UUID.randomUUID().toString();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        privacyAgreeList.add(new kotlin.Pair<>(string, callback));
        io.dcloud.common.ui.PrivacyManager.getInstance().registerPrivacyAgreeListener(string, new io.dcloud.common.ui.PrivacyManager.PrivacyAgreeCallback() { // from class: io.dcloud.uts.UTSAndroid$$ExternalSyntheticLambda0
            @Override // io.dcloud.common.ui.PrivacyManager.PrivacyAgreeCallback
            public final void call(java.lang.Boolean bool) {
                io.dcloud.uts.UTSAndroid.onPrivacyAgreeChange$lambda$3(callback, bool);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onPrivacyAgreeChange$lambda$3(kotlin.jvm.functions.Function1 function1, java.lang.Boolean bool) {
        kotlin.jvm.internal.Intrinsics.checkNotNull(bool);
        function1.invoke2(new io.dcloud.uts.PrivacyOption(bool.booleanValue()));
    }

    public final void offPrivacyAgreeChange(kotlin.jvm.functions.Function1<? super io.dcloud.uts.PrivacyOption, kotlin.Unit> callback) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        java.util.Iterator<kotlin.Pair<java.lang.String, kotlin.jvm.functions.Function1<io.dcloud.uts.PrivacyOption, kotlin.Unit>>> it = privacyAgreeList.iterator();
        while (it.hasNext()) {
            kotlin.Pair<java.lang.String, kotlin.jvm.functions.Function1<io.dcloud.uts.PrivacyOption, kotlin.Unit>> next = it.next();
            if (kotlin.jvm.internal.Intrinsics.areEqual(next.getSecond(), callback)) {
                it.remove();
                io.dcloud.common.ui.PrivacyManager.getInstance().unRegisterPrivacyAgreeListener(next.getFirst());
            }
        }
    }
}
