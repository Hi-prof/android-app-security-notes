package kotlin.reflect.jvm.internal.impl.platform;

/* JADX INFO: compiled from: platformUtil.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PlatformUtilKt {
    public static final java.lang.String getPresentableDescription(kotlin.reflect.jvm.internal.impl.platform.TargetPlatform targetPlatform) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(targetPlatform, "<this>");
        return kotlin.collections.CollectionsKt.joinToString$default(targetPlatform.getComponentPlatforms(), "/", null, null, 0, null, null, 62, null);
    }
}
