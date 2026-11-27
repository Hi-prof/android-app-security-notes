package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

/* JADX INFO: compiled from: DeserializationConfiguration.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface DeserializationConfiguration {
    boolean getAllowUnstableDependencies();

    kotlin.reflect.jvm.internal.impl.metadata.deserialization.MetadataVersion getMetadataVersion();

    boolean getPreserveDeclarationsOrdering();

    boolean getReportErrorsOnPreReleaseDependencies();

    boolean getSkipMetadataVersionCheck();

    boolean getSkipPrereleaseCheck();

    boolean getTypeAliasesAllowed();

    /* JADX INFO: compiled from: DeserializationConfiguration.kt */
    public static final class Default implements kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration {
        public static final kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration.Default INSTANCE = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration.Default();

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration
        public boolean getAllowUnstableDependencies() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration
        public boolean getPreserveDeclarationsOrdering() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration
        public boolean getReportErrorsOnPreReleaseDependencies() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration
        public boolean getSkipMetadataVersionCheck() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration
        public boolean getSkipPrereleaseCheck() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration
        public boolean getTypeAliasesAllowed() {
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration
        public kotlin.reflect.jvm.internal.impl.metadata.deserialization.MetadataVersion getMetadataVersion() {
            return kotlin.reflect.jvm.internal.impl.metadata.deserialization.MetadataVersion.INSTANCE;
        }

        private Default() {
        }
    }
}
