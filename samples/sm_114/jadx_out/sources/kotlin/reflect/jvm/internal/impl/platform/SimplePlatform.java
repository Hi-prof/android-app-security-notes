package kotlin.reflect.jvm.internal.impl.platform;

/* JADX INFO: compiled from: TargetPlatform.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class SimplePlatform {
    private final java.lang.String platformName;
    private final kotlin.reflect.jvm.internal.impl.platform.TargetPlatformVersion targetPlatformVersion;

    public java.lang.String toString() {
        java.lang.String targetName = getTargetName();
        if (targetName.length() <= 0) {
            return this.platformName;
        }
        return this.platformName + " (" + targetName + com.taobao.weex.el.parse.Operators.BRACKET_END;
    }

    public java.lang.String getTargetName() {
        return getTargetPlatformVersion().getDescription();
    }

    public kotlin.reflect.jvm.internal.impl.platform.TargetPlatformVersion getTargetPlatformVersion() {
        return this.targetPlatformVersion;
    }
}
