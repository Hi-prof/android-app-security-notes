package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

/* JADX INFO: compiled from: predefinedEnhancementInfo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PredefinedFunctionEnhancementInfo {
    private final java.lang.String errorsSinceLanguageVersion;
    private final java.util.List<kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementInfo> parametersInfo;
    private final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementInfo returnTypeInfo;
    private final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedFunctionEnhancementInfo warningModeClone;

    public PredefinedFunctionEnhancementInfo() {
        this(null, null, null, 7, null);
    }

    public PredefinedFunctionEnhancementInfo(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementInfo typeEnhancementInfo, java.util.List<kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementInfo> parametersInfo, java.lang.String str) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(parametersInfo, "parametersInfo");
        this.returnTypeInfo = typeEnhancementInfo;
        this.parametersInfo = parametersInfo;
        this.errorsSinceLanguageVersion = str;
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedFunctionEnhancementInfo predefinedFunctionEnhancementInfo = null;
        if (str != null) {
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementInfo typeEnhancementInfoCopyForWarnings = typeEnhancementInfo != null ? typeEnhancementInfo.copyForWarnings() : null;
            java.util.List<kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementInfo> list = parametersInfo;
            java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(list, 10));
            for (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementInfo typeEnhancementInfo2 : list) {
                arrayList.add(typeEnhancementInfo2 != null ? typeEnhancementInfo2.copyForWarnings() : null);
            }
            predefinedFunctionEnhancementInfo = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedFunctionEnhancementInfo(typeEnhancementInfoCopyForWarnings, arrayList, null);
        }
        this.warningModeClone = predefinedFunctionEnhancementInfo;
    }

    public final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementInfo getReturnTypeInfo() {
        return this.returnTypeInfo;
    }

    public /* synthetic */ PredefinedFunctionEnhancementInfo(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementInfo typeEnhancementInfo, java.util.List list, java.lang.String str, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : typeEnhancementInfo, (i & 2) != 0 ? kotlin.collections.CollectionsKt.emptyList() : list, (i & 4) != 0 ? null : str);
    }

    public final java.util.List<kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementInfo> getParametersInfo() {
        return this.parametersInfo;
    }

    public final java.lang.String getErrorsSinceLanguageVersion() {
        return this.errorsSinceLanguageVersion;
    }

    public final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedFunctionEnhancementInfo getWarningModeClone() {
        return this.warningModeClone;
    }
}
