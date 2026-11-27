package kotlin.reflect.jvm.internal.impl.name;

/* JADX INFO: compiled from: FqNameUnsafe.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FqNameUnsafe {
    public static final kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe.Companion Companion = new kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe.Companion(null);
    private static final kotlin.reflect.jvm.internal.impl.name.Name ROOT_NAME;
    private static final java.util.regex.Pattern SPLIT_BY_DOTS;
    private final java.lang.String fqName;
    private transient kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe parent;
    private transient kotlin.reflect.jvm.internal.impl.name.FqName safe;
    private transient kotlin.reflect.jvm.internal.impl.name.Name shortName;

    public /* synthetic */ FqNameUnsafe(java.lang.String str, kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe fqNameUnsafe, kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(str, fqNameUnsafe, name);
    }

    public FqNameUnsafe(java.lang.String fqName, kotlin.reflect.jvm.internal.impl.name.FqName safe) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fqName, "fqName");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(safe, "safe");
        this.fqName = fqName;
        this.safe = safe;
    }

    public FqNameUnsafe(java.lang.String fqName) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fqName, "fqName");
        this.fqName = fqName;
    }

    private FqNameUnsafe(java.lang.String str, kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe fqNameUnsafe, kotlin.reflect.jvm.internal.impl.name.Name name) {
        this.fqName = str;
        this.parent = fqNameUnsafe;
        this.shortName = name;
    }

    private final void compute() {
        int iIndexOfLastDotWithBackticksSupport = indexOfLastDotWithBackticksSupport(this.fqName);
        if (iIndexOfLastDotWithBackticksSupport >= 0) {
            java.lang.String strSubstring = this.fqName.substring(iIndexOfLastDotWithBackticksSupport + 1);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            this.shortName = kotlin.reflect.jvm.internal.impl.name.Name.guessByFirstCharacter(strSubstring);
            java.lang.String strSubstring2 = this.fqName.substring(0, iIndexOfLastDotWithBackticksSupport);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
            this.parent = new kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe(strSubstring2);
            return;
        }
        this.shortName = kotlin.reflect.jvm.internal.impl.name.Name.guessByFirstCharacter(this.fqName);
        this.parent = kotlin.reflect.jvm.internal.impl.name.FqName.ROOT.toUnsafe();
    }

    private final int indexOfLastDotWithBackticksSupport(java.lang.String str) {
        int length = str.length() - 1;
        boolean z = false;
        while (length >= 0) {
            char cCharAt = str.charAt(length);
            if (cCharAt == '.' && !z) {
                return length;
            }
            if (cCharAt == '`') {
                z = !z;
            } else if (cCharAt == '\\') {
                length--;
            }
            length--;
        }
        return -1;
    }

    public final java.lang.String asString() {
        return this.fqName;
    }

    public final boolean isSafe() {
        return this.safe != null || kotlin.text.StringsKt.indexOf$default((java.lang.CharSequence) asString(), kotlin.text.Typography.less, 0, false, 6, (java.lang.Object) null) < 0;
    }

    public final kotlin.reflect.jvm.internal.impl.name.FqName toSafe() {
        kotlin.reflect.jvm.internal.impl.name.FqName fqName = this.safe;
        if (fqName != null) {
            return fqName;
        }
        kotlin.reflect.jvm.internal.impl.name.FqName fqName2 = new kotlin.reflect.jvm.internal.impl.name.FqName(this);
        this.safe = fqName2;
        return fqName2;
    }

    public final boolean isRoot() {
        return this.fqName.length() == 0;
    }

    public final kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe parent() {
        kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe fqNameUnsafe = this.parent;
        if (fqNameUnsafe != null) {
            return fqNameUnsafe;
        }
        if (isRoot()) {
            throw new java.lang.IllegalStateException("root".toString());
        }
        compute();
        kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe fqNameUnsafe2 = this.parent;
        kotlin.jvm.internal.Intrinsics.checkNotNull(fqNameUnsafe2);
        return fqNameUnsafe2;
    }

    public final kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe child(kotlin.reflect.jvm.internal.impl.name.Name name) {
        java.lang.String strAsString;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        if (isRoot()) {
            strAsString = name.asString();
        } else {
            strAsString = this.fqName + com.taobao.weex.el.parse.Operators.DOT + name.asString();
        }
        kotlin.jvm.internal.Intrinsics.checkNotNull(strAsString);
        return new kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe(strAsString, this, name);
    }

    public final kotlin.reflect.jvm.internal.impl.name.Name shortName() {
        kotlin.reflect.jvm.internal.impl.name.Name name = this.shortName;
        if (name != null) {
            return name;
        }
        if (isRoot()) {
            throw new java.lang.IllegalStateException("root".toString());
        }
        compute();
        kotlin.reflect.jvm.internal.impl.name.Name name2 = this.shortName;
        kotlin.jvm.internal.Intrinsics.checkNotNull(name2);
        return name2;
    }

    public final kotlin.reflect.jvm.internal.impl.name.Name shortNameOrSpecial() {
        if (isRoot()) {
            return ROOT_NAME;
        }
        return shortName();
    }

    private static final java.util.List<kotlin.reflect.jvm.internal.impl.name.Name> pathSegments$collectSegmentsOf(kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe fqNameUnsafe) {
        if (fqNameUnsafe.isRoot()) {
            return new java.util.ArrayList();
        }
        java.util.List<kotlin.reflect.jvm.internal.impl.name.Name> listPathSegments$collectSegmentsOf = pathSegments$collectSegmentsOf(fqNameUnsafe.parent());
        listPathSegments$collectSegmentsOf.add(fqNameUnsafe.shortName());
        return listPathSegments$collectSegmentsOf;
    }

    public final java.util.List<kotlin.reflect.jvm.internal.impl.name.Name> pathSegments() {
        return pathSegments$collectSegmentsOf(this);
    }

    public final boolean startsWith(kotlin.reflect.jvm.internal.impl.name.Name segment) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(segment, "segment");
        if (isRoot()) {
            return false;
        }
        int iIndexOf$default = kotlin.text.StringsKt.indexOf$default((java.lang.CharSequence) this.fqName, com.taobao.weex.el.parse.Operators.DOT, 0, false, 6, (java.lang.Object) null);
        if (iIndexOf$default == -1) {
            iIndexOf$default = this.fqName.length();
        }
        int i = iIndexOf$default;
        java.lang.String strAsString = segment.asString();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strAsString, "asString(...)");
        return i == strAsString.length() && kotlin.text.StringsKt.regionMatches(this.fqName, 0, strAsString, 0, i, (16 & 16) != 0 ? false : false);
    }

    public java.lang.String toString() {
        if (!isRoot()) {
            return this.fqName;
        }
        java.lang.String strAsString = ROOT_NAME.asString();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strAsString, "asString(...)");
        return strAsString;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe) && kotlin.jvm.internal.Intrinsics.areEqual(this.fqName, ((kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe) obj).fqName);
    }

    public int hashCode() {
        return this.fqName.hashCode();
    }

    /* JADX INFO: compiled from: FqNameUnsafe.kt */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @kotlin.jvm.JvmStatic
        public final kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe topLevel(kotlin.reflect.jvm.internal.impl.name.Name shortName) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(shortName, "shortName");
            java.lang.String strAsString = shortName.asString();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strAsString, "asString(...)");
            return new kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe(strAsString, kotlin.reflect.jvm.internal.impl.name.FqName.ROOT.toUnsafe(), shortName, null);
        }
    }

    static {
        kotlin.reflect.jvm.internal.impl.name.Name nameSpecial = kotlin.reflect.jvm.internal.impl.name.Name.special("<root>");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameSpecial, "special(...)");
        ROOT_NAME = nameSpecial;
        java.util.regex.Pattern patternCompile = java.util.regex.Pattern.compile("\\.");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(patternCompile, "compile(...)");
        SPLIT_BY_DOTS = patternCompile;
    }
}
