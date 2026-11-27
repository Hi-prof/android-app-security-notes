package kotlin.reflect.jvm.internal.impl.km.internal;

/* JADX INFO: compiled from: Writers.kt */
/* JADX INFO: loaded from: classes2.dex */
public class WriteContext {
    private final java.util.List<kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions> extensions;
    private final kotlin.reflect.jvm.internal.impl.metadata.serialization.StringTable strings;
    private final kotlin.reflect.jvm.internal.impl.metadata.serialization.MutableVersionRequirementTable versionRequirements;

    public final kotlin.reflect.jvm.internal.impl.metadata.serialization.StringTable getStrings() {
        return this.strings;
    }

    public final kotlin.reflect.jvm.internal.impl.metadata.serialization.MutableVersionRequirementTable getVersionRequirements$kotlin_metadata() {
        return this.versionRequirements;
    }

    public final java.util.List<kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions> getExtensions$kotlin_metadata() {
        return this.extensions;
    }

    public final int get(java.lang.String string) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(string, "string");
        return this.strings.getStringIndex(string);
    }

    public final int getClassName$kotlin_metadata(java.lang.String name) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        return kotlin.reflect.jvm.internal.impl.km.internal.WriteUtilsKt.getClassNameIndex(this.strings, name);
    }
}
