package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

/* JADX INFO: compiled from: EnumEntriesDeserializationSupport.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class JvmEnumEntriesDeserializationSupport implements kotlin.reflect.jvm.internal.impl.serialization.deserialization.EnumEntriesDeserializationSupport {
    public static final kotlin.reflect.jvm.internal.impl.serialization.deserialization.JvmEnumEntriesDeserializationSupport INSTANCE = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.JvmEnumEntriesDeserializationSupport();

    private JvmEnumEntriesDeserializationSupport() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.EnumEntriesDeserializationSupport
    public java.lang.Boolean canSynthesizeEnumEntries() {
        return true;
    }
}
