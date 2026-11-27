package kotlin.reflect.jvm.internal.impl.name;

/* JADX INFO: compiled from: ClassId.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ClassId {
    public static final kotlin.reflect.jvm.internal.impl.name.ClassId.Companion Companion = new kotlin.reflect.jvm.internal.impl.name.ClassId.Companion(null);
    private final boolean isLocal;
    private final kotlin.reflect.jvm.internal.impl.name.FqName packageFqName;
    private final kotlin.reflect.jvm.internal.impl.name.FqName relativeClassName;

    @kotlin.jvm.JvmStatic
    public static final kotlin.reflect.jvm.internal.impl.name.ClassId topLevel(kotlin.reflect.jvm.internal.impl.name.FqName fqName) {
        return Companion.topLevel(fqName);
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof kotlin.reflect.jvm.internal.impl.name.ClassId)) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.name.ClassId classId = (kotlin.reflect.jvm.internal.impl.name.ClassId) obj;
        return kotlin.jvm.internal.Intrinsics.areEqual(this.packageFqName, classId.packageFqName) && kotlin.jvm.internal.Intrinsics.areEqual(this.relativeClassName, classId.relativeClassName) && this.isLocal == classId.isLocal;
    }

    public int hashCode() {
        return (((this.packageFqName.hashCode() * 31) + this.relativeClassName.hashCode()) * 31) + kotlin.UByte$$ExternalSyntheticBackport0.m(this.isLocal);
    }

    public ClassId(kotlin.reflect.jvm.internal.impl.name.FqName packageFqName, kotlin.reflect.jvm.internal.impl.name.FqName relativeClassName, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(packageFqName, "packageFqName");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(relativeClassName, "relativeClassName");
        this.packageFqName = packageFqName;
        this.relativeClassName = relativeClassName;
        this.isLocal = z;
        relativeClassName.isRoot();
    }

    public final kotlin.reflect.jvm.internal.impl.name.FqName getPackageFqName() {
        return this.packageFqName;
    }

    public final kotlin.reflect.jvm.internal.impl.name.FqName getRelativeClassName() {
        return this.relativeClassName;
    }

    public final boolean isLocal() {
        return this.isLocal;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ClassId(kotlin.reflect.jvm.internal.impl.name.FqName packageFqName, kotlin.reflect.jvm.internal.impl.name.Name topLevelName) {
        this(packageFqName, kotlin.reflect.jvm.internal.impl.name.FqName.Companion.topLevel(topLevelName), false);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(packageFqName, "packageFqName");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(topLevelName, "topLevelName");
    }

    public final kotlin.reflect.jvm.internal.impl.name.Name getShortClassName() {
        return this.relativeClassName.shortName();
    }

    public final kotlin.reflect.jvm.internal.impl.name.ClassId getOuterClassId() {
        kotlin.reflect.jvm.internal.impl.name.FqName fqNameParent = this.relativeClassName.parent();
        if (fqNameParent.isRoot()) {
            return null;
        }
        return new kotlin.reflect.jvm.internal.impl.name.ClassId(this.packageFqName, fqNameParent, this.isLocal);
    }

    public final boolean isNestedClass() {
        return !this.relativeClassName.parent().isRoot();
    }

    public final kotlin.reflect.jvm.internal.impl.name.ClassId createNestedClassId(kotlin.reflect.jvm.internal.impl.name.Name name) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        return new kotlin.reflect.jvm.internal.impl.name.ClassId(this.packageFqName, this.relativeClassName.child(name), this.isLocal);
    }

    public final kotlin.reflect.jvm.internal.impl.name.FqName asSingleFqName() {
        if (this.packageFqName.isRoot()) {
            return this.relativeClassName;
        }
        return new kotlin.reflect.jvm.internal.impl.name.FqName(this.packageFqName.asString() + com.taobao.weex.el.parse.Operators.DOT + this.relativeClassName.asString());
    }

    private static final java.lang.String asString$escapeSlashes(kotlin.reflect.jvm.internal.impl.name.FqName fqName) {
        java.lang.String strAsString = fqName.asString();
        if (!kotlin.text.StringsKt.contains$default((java.lang.CharSequence) strAsString, '/', false, 2, (java.lang.Object) null)) {
            return strAsString;
        }
        return "`" + strAsString + '`';
    }

    public final java.lang.String asString() {
        if (this.packageFqName.isRoot()) {
            return asString$escapeSlashes(this.relativeClassName);
        }
        return kotlin.text.StringsKt.replace$default(this.packageFqName.asString(), com.taobao.weex.el.parse.Operators.DOT, '/', false, 4, (java.lang.Object) null) + "/" + asString$escapeSlashes(this.relativeClassName);
    }

    public java.lang.String toString() {
        if (!this.packageFqName.isRoot()) {
            return asString();
        }
        return "/" + asString();
    }

    /* JADX INFO: compiled from: ClassId.kt */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @kotlin.jvm.JvmStatic
        public final kotlin.reflect.jvm.internal.impl.name.ClassId topLevel(kotlin.reflect.jvm.internal.impl.name.FqName topLevelFqName) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(topLevelFqName, "topLevelFqName");
            return new kotlin.reflect.jvm.internal.impl.name.ClassId(topLevelFqName.parent(), topLevelFqName.shortName());
        }

        public static /* synthetic */ kotlin.reflect.jvm.internal.impl.name.ClassId fromString$default(kotlin.reflect.jvm.internal.impl.name.ClassId.Companion companion, java.lang.String str, boolean z, int i, java.lang.Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            return companion.fromString(str, z);
        }

        @kotlin.jvm.JvmStatic
        public final kotlin.reflect.jvm.internal.impl.name.ClassId fromString(java.lang.String string, boolean z) {
            java.lang.String strReplace$default;
            java.lang.String str;
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(string, "string");
            java.lang.String str2 = string;
            int iIndexOf$default = kotlin.text.StringsKt.indexOf$default((java.lang.CharSequence) str2, '`', 0, false, 6, (java.lang.Object) null);
            if (iIndexOf$default == -1) {
                iIndexOf$default = string.length();
            }
            int iLastIndexOf$default = kotlin.text.StringsKt.lastIndexOf$default((java.lang.CharSequence) str2, "/", iIndexOf$default, false, 4, (java.lang.Object) null);
            if (iLastIndexOf$default == -1) {
                strReplace$default = kotlin.text.StringsKt.replace$default(string, "`", "", false, 4, (java.lang.Object) null);
                str = "";
            } else {
                java.lang.String strSubstring = string.substring(0, iLastIndexOf$default);
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                java.lang.String strReplace$default2 = kotlin.text.StringsKt.replace$default(strSubstring, '/', com.taobao.weex.el.parse.Operators.DOT, false, 4, (java.lang.Object) null);
                java.lang.String strSubstring2 = string.substring(iLastIndexOf$default + 1);
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                strReplace$default = kotlin.text.StringsKt.replace$default(strSubstring2, "`", "", false, 4, (java.lang.Object) null);
                str = strReplace$default2;
            }
            return new kotlin.reflect.jvm.internal.impl.name.ClassId(new kotlin.reflect.jvm.internal.impl.name.FqName(str), new kotlin.reflect.jvm.internal.impl.name.FqName(strReplace$default), z);
        }
    }
}
