package kotlin.reflect.jvm.internal.impl.load.java;

/* JADX INFO: compiled from: Jsr305Settings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Jsr305Settings {
    private final kotlin.Lazy description$delegate;
    private final kotlin.reflect.jvm.internal.impl.load.java.ReportLevel globalLevel;
    private final boolean isDisabled;
    private final kotlin.reflect.jvm.internal.impl.load.java.ReportLevel migrationLevel;
    private final java.util.Map<kotlin.reflect.jvm.internal.impl.name.FqName, kotlin.reflect.jvm.internal.impl.load.java.ReportLevel> userDefinedLevelForSpecificAnnotation;

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof kotlin.reflect.jvm.internal.impl.load.java.Jsr305Settings)) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.load.java.Jsr305Settings jsr305Settings = (kotlin.reflect.jvm.internal.impl.load.java.Jsr305Settings) obj;
        return this.globalLevel == jsr305Settings.globalLevel && this.migrationLevel == jsr305Settings.migrationLevel && kotlin.jvm.internal.Intrinsics.areEqual(this.userDefinedLevelForSpecificAnnotation, jsr305Settings.userDefinedLevelForSpecificAnnotation);
    }

    public int hashCode() {
        int iHashCode = this.globalLevel.hashCode() * 31;
        kotlin.reflect.jvm.internal.impl.load.java.ReportLevel reportLevel = this.migrationLevel;
        return ((iHashCode + (reportLevel == null ? 0 : reportLevel.hashCode())) * 31) + this.userDefinedLevelForSpecificAnnotation.hashCode();
    }

    public java.lang.String toString() {
        return "Jsr305Settings(globalLevel=" + this.globalLevel + ", migrationLevel=" + this.migrationLevel + ", userDefinedLevelForSpecificAnnotation=" + this.userDefinedLevelForSpecificAnnotation + com.taobao.weex.el.parse.Operators.BRACKET_END;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Jsr305Settings(kotlin.reflect.jvm.internal.impl.load.java.ReportLevel globalLevel, kotlin.reflect.jvm.internal.impl.load.java.ReportLevel reportLevel, java.util.Map<kotlin.reflect.jvm.internal.impl.name.FqName, ? extends kotlin.reflect.jvm.internal.impl.load.java.ReportLevel> userDefinedLevelForSpecificAnnotation) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(globalLevel, "globalLevel");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(userDefinedLevelForSpecificAnnotation, "userDefinedLevelForSpecificAnnotation");
        this.globalLevel = globalLevel;
        this.migrationLevel = reportLevel;
        this.userDefinedLevelForSpecificAnnotation = userDefinedLevelForSpecificAnnotation;
        this.description$delegate = kotlin.LazyKt.lazy(new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.Jsr305Settings$$Lambda$0
            private final kotlin.reflect.jvm.internal.impl.load.java.Jsr305Settings arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.impl.load.java.Jsr305Settings.description_delegate$lambda$3(this.arg$0);
            }
        });
        this.isDisabled = globalLevel == kotlin.reflect.jvm.internal.impl.load.java.ReportLevel.IGNORE && reportLevel == kotlin.reflect.jvm.internal.impl.load.java.ReportLevel.IGNORE && userDefinedLevelForSpecificAnnotation.isEmpty();
    }

    public final kotlin.reflect.jvm.internal.impl.load.java.ReportLevel getGlobalLevel() {
        return this.globalLevel;
    }

    public final kotlin.reflect.jvm.internal.impl.load.java.ReportLevel getMigrationLevel() {
        return this.migrationLevel;
    }

    public /* synthetic */ Jsr305Settings(kotlin.reflect.jvm.internal.impl.load.java.ReportLevel reportLevel, kotlin.reflect.jvm.internal.impl.load.java.ReportLevel reportLevel2, java.util.Map map, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(reportLevel, (i & 2) != 0 ? null : reportLevel2, (i & 4) != 0 ? kotlin.collections.MapsKt.emptyMap() : map);
    }

    public final java.util.Map<kotlin.reflect.jvm.internal.impl.name.FqName, kotlin.reflect.jvm.internal.impl.load.java.ReportLevel> getUserDefinedLevelForSpecificAnnotation() {
        return this.userDefinedLevelForSpecificAnnotation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.String[] description_delegate$lambda$3(kotlin.reflect.jvm.internal.impl.load.java.Jsr305Settings jsr305Settings) {
        java.util.List listCreateListBuilder = kotlin.collections.CollectionsKt.createListBuilder();
        listCreateListBuilder.add(jsr305Settings.globalLevel.getDescription());
        kotlin.reflect.jvm.internal.impl.load.java.ReportLevel reportLevel = jsr305Settings.migrationLevel;
        if (reportLevel != null) {
            listCreateListBuilder.add("under-migration:" + reportLevel.getDescription());
        }
        for (java.util.Map.Entry<kotlin.reflect.jvm.internal.impl.name.FqName, kotlin.reflect.jvm.internal.impl.load.java.ReportLevel> entry : jsr305Settings.userDefinedLevelForSpecificAnnotation.entrySet()) {
            listCreateListBuilder.add("@" + entry.getKey() + com.taobao.weex.el.parse.Operators.CONDITION_IF_MIDDLE + entry.getValue().getDescription());
        }
        return (java.lang.String[]) kotlin.collections.CollectionsKt.build(listCreateListBuilder).toArray(new java.lang.String[0]);
    }

    public final boolean isDisabled() {
        return this.isDisabled;
    }
}
