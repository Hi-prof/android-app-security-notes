package kotlin.reflect.jvm.internal.impl.metadata.builtins;

/* JADX INFO: compiled from: readPackageFragment.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ReadPackageFragmentKt {
    public static final kotlin.Pair<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.PackageFragment, kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsBinaryVersion> readBuiltinsPackageFragment(java.io.InputStream inputStream) throws java.io.IOException {
        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.PackageFragment from;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(inputStream, "<this>");
        java.io.InputStream inputStream2 = inputStream;
        try {
            java.io.InputStream inputStream3 = inputStream2;
            kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsBinaryVersion from2 = kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsBinaryVersion.Companion.readFrom(inputStream3);
            if (from2.isCompatibleWithCurrentCompilerVersion()) {
                kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite extensionRegistryLiteNewInstance = kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite.newInstance();
                kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsProtoBuf.registerAllExtensions(extensionRegistryLiteNewInstance);
                from = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.PackageFragment.parseFrom(inputStream3, extensionRegistryLiteNewInstance);
            } else {
                from = null;
            }
            kotlin.Pair<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.PackageFragment, kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsBinaryVersion> pair = kotlin.TuplesKt.to(from, from2);
            kotlin.io.CloseableKt.closeFinally(inputStream2, null);
            return pair;
        } catch (java.lang.Throwable th) {
            try {
                throw th;
            } catch (java.lang.Throwable th2) {
                kotlin.io.CloseableKt.closeFinally(inputStream2, th);
                throw th2;
            }
        }
    }
}
