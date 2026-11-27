package kotlin.reflect.jvm.internal.impl.km;

/* JADX INFO: compiled from: Nodes.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class KmEnumEntry {
    private final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmAnnotation> annotations;
    private final java.util.List<kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmEnumEntryExtension> extensions;
    private java.lang.String name;

    public KmEnumEntry(java.lang.String name) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.annotations = new java.util.ArrayList(0);
        java.util.List<kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions> iNSTANCES$kotlin_metadata = kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions.Companion.getINSTANCES$kotlin_metadata();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<T> it = iNSTANCES$kotlin_metadata.iterator();
        while (it.hasNext()) {
            kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmEnumEntryExtension kmEnumEntryExtensionCreateEnumEntryExtension = ((kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions) it.next()).createEnumEntryExtension();
            if (kmEnumEntryExtensionCreateEnumEntryExtension != null) {
                arrayList.add(kmEnumEntryExtensionCreateEnumEntryExtension);
            }
        }
        this.extensions = arrayList;
    }

    public final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmAnnotation> getAnnotations() {
        return this.annotations;
    }

    public java.lang.String toString() {
        return this.name;
    }
}
