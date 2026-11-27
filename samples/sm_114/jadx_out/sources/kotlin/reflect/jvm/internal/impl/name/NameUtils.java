package kotlin.reflect.jvm.internal.impl.name;

/* JADX INFO: compiled from: NameUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NameUtils {
    public static final kotlin.reflect.jvm.internal.impl.name.NameUtils INSTANCE = new kotlin.reflect.jvm.internal.impl.name.NameUtils();
    private static final kotlin.text.Regex SANITIZE_AS_JAVA_INVALID_CHARACTERS = new kotlin.text.Regex("[^\\p{L}\\p{Digit}]");
    private static final java.lang.String CONTEXT_RECEIVER_PREFIX = "$context_receiver";

    private NameUtils() {
    }

    @kotlin.jvm.JvmStatic
    public static final java.lang.String sanitizeAsJavaIdentifier(java.lang.String name) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        return SANITIZE_AS_JAVA_INVALID_CHARACTERS.replace(name, "_");
    }

    @kotlin.jvm.JvmStatic
    public static final kotlin.reflect.jvm.internal.impl.name.Name contextReceiverName(int i) {
        kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier = kotlin.reflect.jvm.internal.impl.name.Name.identifier(CONTEXT_RECEIVER_PREFIX + '_' + i);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier, "identifier(...)");
        return nameIdentifier;
    }
}
