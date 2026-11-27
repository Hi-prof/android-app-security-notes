package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

/* JADX INFO: compiled from: EnumEntriesDeserializationSupport.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface EnumEntriesDeserializationSupport {
    java.lang.Boolean canSynthesizeEnumEntries();

    /* JADX INFO: compiled from: EnumEntriesDeserializationSupport.kt */
    public static final class Default implements kotlin.reflect.jvm.internal.impl.serialization.deserialization.EnumEntriesDeserializationSupport {
        public static final kotlin.reflect.jvm.internal.impl.serialization.deserialization.EnumEntriesDeserializationSupport.Default INSTANCE = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.EnumEntriesDeserializationSupport.Default();

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.EnumEntriesDeserializationSupport
        public java.lang.Boolean canSynthesizeEnumEntries() {
            return null;
        }

        private Default() {
        }
    }
}
