package kotlin.reflect.jvm.internal.impl.km;

/* JADX INFO: compiled from: Nodes.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface KmDeclarationContainer {
    java.util.List<kotlin.reflect.jvm.internal.impl.km.KmFunction> getFunctions();

    java.util.List<kotlin.reflect.jvm.internal.impl.km.KmProperty> getProperties();

    java.util.List<kotlin.reflect.jvm.internal.impl.km.KmTypeAlias> getTypeAliases();
}
