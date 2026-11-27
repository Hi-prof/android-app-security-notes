package kotlin.reflect.jvm.internal.impl.load.java.structure;

/* JADX INFO: compiled from: javaLoading.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class JavaLoadingKt {
    public static final boolean isObjectMethodInInterface(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember javaMember) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(javaMember, "<this>");
        return javaMember.getContainingClass().isInterface() && (javaMember instanceof kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod) && isObjectMethod((kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod) javaMember);
    }

    private static final boolean isObjectMethod(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod javaMethod) {
        java.lang.String strAsString = javaMethod.getName().asString();
        int iHashCode = strAsString.hashCode();
        if (iHashCode != -1776922004) {
            if (iHashCode == -1295482945) {
                if (strAsString.equals("equals")) {
                    return isMethodWithOneObjectParameter(javaMethod);
                }
                return false;
            }
            if (iHashCode != 147696667 || !strAsString.equals("hashCode")) {
                return false;
            }
        } else if (!strAsString.equals("toString")) {
            return false;
        }
        return javaMethod.getValueParameters().isEmpty();
    }

    private static final boolean isMethodWithOneObjectParameter(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod javaMethod) {
        kotlin.reflect.jvm.internal.impl.name.FqName fqName;
        kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter javaValueParameter = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter) kotlin.collections.CollectionsKt.singleOrNull((java.util.List) javaMethod.getValueParameters());
        kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType type = javaValueParameter != null ? javaValueParameter.getType() : null;
        kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType javaClassifierType = type instanceof kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType ? (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType) type : null;
        if (javaClassifierType == null) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifier classifier = javaClassifierType.getClassifier();
        return (classifier instanceof kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass) && (fqName = ((kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass) classifier).getFqName()) != null && kotlin.jvm.internal.Intrinsics.areEqual(fqName.asString(), "java.lang.Object");
    }
}
