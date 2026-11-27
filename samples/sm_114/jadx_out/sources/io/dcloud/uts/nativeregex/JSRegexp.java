package io.dcloud.uts.nativeregex;

/* JADX INFO: compiled from: JSRegexp.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 (2\u00020\u0001:\u0002()B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u00052\b\b\u0002\u0010\u001c\u001a\u00020\u000fJ\u000e\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u0005J\u0006\u0010\u001e\u001a\u00020\u0005J\u0006\u0010\u001f\u001a\u00020\u0016J\u0006\u0010 \u001a\u00020\u0016J\u0006\u0010!\u001a\u00020\u0016J\u0006\u0010\"\u001a\u00020\u0016J\u0006\u0010#\u001a\u00020\u0016J\u0006\u0010$\u001a\u00020\u0016J\u0006\u0010%\u001a\u00020\u0016J\u0006\u0010&\u001a\u00020\u0016J\b\u0010'\u001a\u00020\u0005H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR&\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006*"}, d2 = {"Lio/dcloud/uts/nativeregex/JSRegexp;", "", "bytecode", "", "pattern", "", "flags", "<init>", "([BLjava/lang/String;Ljava/lang/String;)V", "getBytecode", "()[B", "getPattern", "()Ljava/lang/String;", "getFlags", "value", "", "lastIndex", "getLastIndex", "()I", "setLastIndex", "(I)V", "hasGlobalOrSticky", "", "getHasGlobalOrSticky", "()Z", "exec", "Lio/dcloud/uts/RegExpExecArray;", "input", "startIndex", "test", "getSource", "isGlobal", "isIgnoreCase", "isMultiline", "isDotAll", "isUnicode", "isUnicodeSets", "isSticky", "hasIndices", "toString", "Companion", "MatchResult", "utsplugin_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class JSRegexp {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final io.dcloud.uts.nativeregex.JSRegexp.Companion INSTANCE = new io.dcloud.uts.nativeregex.JSRegexp.Companion(null);
    private final byte[] bytecode;
    private final java.lang.String flags;
    private int lastIndex;
    private final java.lang.String pattern;

    public /* synthetic */ JSRegexp(byte[] bArr, java.lang.String str, java.lang.String str2, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(bArr, str, str2);
    }

    private JSRegexp(byte[] bArr, java.lang.String str, java.lang.String str2) {
        this.bytecode = bArr;
        this.pattern = str;
        this.flags = str2;
    }

    public final byte[] getBytecode() {
        return this.bytecode;
    }

    public final java.lang.String getPattern() {
        return this.pattern;
    }

    public final java.lang.String getFlags() {
        return this.flags;
    }

    /* JADX INFO: compiled from: JSRegexp.kt */
    @kotlin.Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007¨\u0006\t"}, d2 = {"Lio/dcloud/uts/nativeregex/JSRegexp$Companion;", "", "<init>", "()V", "create", "Lio/dcloud/uts/nativeregex/JSRegexp;", "pattern", "", "flags", "utsplugin_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ io.dcloud.uts.nativeregex.JSRegexp create$default(io.dcloud.uts.nativeregex.JSRegexp.Companion companion, java.lang.String str, java.lang.String str2, int i, java.lang.Object obj) {
            if ((i & 2) != 0) {
                str2 = "";
            }
            return companion.create(str, str2);
        }

        public final io.dcloud.uts.nativeregex.JSRegexp create(java.lang.String pattern, java.lang.String flags) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(pattern, "pattern");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(flags, "flags");
            int length = flags.length();
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                char cCharAt = flags.charAt(i2);
                if (cCharAt == 'd') {
                    i |= 64;
                } else if (cCharAt == 'g') {
                    i |= 1;
                } else if (cCharAt == 'i') {
                    i |= 2;
                } else if (cCharAt == 'm') {
                    i |= 4;
                } else if (cCharAt == 's') {
                    i |= 8;
                } else if (cCharAt == 'y') {
                    i |= 32;
                } else if (cCharAt == 'u') {
                    i |= 16;
                } else {
                    if (cCharAt != 'v') {
                        throw new java.lang.IllegalArgumentException("无效的正则表达式标志: " + cCharAt);
                    }
                    i |= 128;
                }
            }
            return new io.dcloud.uts.nativeregex.JSRegexp(io.dcloud.uts.nativeregex.RegexpBridge.INSTANCE.compileRegexp(pattern, i), pattern, flags, null);
        }
    }

    /* JADX INFO: compiled from: JSRegexp.kt */
    @kotlin.Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\t\u0012\u0016\b\u0002\u0010\n\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0003\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0086\u0002J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001f\u001a\u00020\u0006H\u0016J\u0016\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010!\u001a\u00020\u0006HÆ\u0003J\t\u0010\"\u001a\u00020\u0004HÆ\u0003J\u0019\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\tHÆ\u0003J\u001c\u0010$\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0003\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017Jf\u0010%\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00042\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\t2\u0016\b\u0002\u0010\n\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0003\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010&J\t\u0010'\u001a\u00020\u0004HÖ\u0001R\u001b\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R!\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R!\u0010\n\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0003\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0019\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0011¨\u0006("}, d2 = {"Lio/dcloud/uts/nativeregex/JSRegexp$MatchResult;", "", "matches", "", "", "index", "", "input", "namedGroups", "", "matchIndices", "<init>", "([Ljava/lang/String;ILjava/lang/String;Ljava/util/Map;[[Ljava/lang/Integer;)V", "getMatches", "()[Ljava/lang/String;", "[Ljava/lang/String;", "getIndex", "()I", "getInput", "()Ljava/lang/String;", "getNamedGroups", "()Ljava/util/Map;", "getMatchIndices", "()[[Ljava/lang/Integer;", "[[Ljava/lang/Integer;", "length", "getLength", "get", "equals", "", "other", "hashCode", "component1", "component2", "component3", "component4", "component5", "copy", "([Ljava/lang/String;ILjava/lang/String;Ljava/util/Map;[[Ljava/lang/Integer;)Lio/dcloud/uts/nativeregex/JSRegexp$MatchResult;", "toString", "utsplugin_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class MatchResult {
        private final int index;
        private final java.lang.String input;
        private final java.lang.Integer[][] matchIndices;
        private final java.lang.String[] matches;
        private final java.util.Map<java.lang.String, java.lang.String> namedGroups;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ io.dcloud.uts.nativeregex.JSRegexp.MatchResult copy$default(io.dcloud.uts.nativeregex.JSRegexp.MatchResult matchResult, java.lang.String[] strArr, int i, java.lang.String str, java.util.Map map, java.lang.Integer[][] numArr, int i2, java.lang.Object obj) {
            if ((i2 & 1) != 0) {
                strArr = matchResult.matches;
            }
            if ((i2 & 2) != 0) {
                i = matchResult.index;
            }
            if ((i2 & 4) != 0) {
                str = matchResult.input;
            }
            if ((i2 & 8) != 0) {
                map = matchResult.namedGroups;
            }
            if ((i2 & 16) != 0) {
                numArr = matchResult.matchIndices;
            }
            java.lang.Integer[][] numArr2 = numArr;
            java.lang.String str2 = str;
            return matchResult.copy(strArr, i, str2, map, numArr2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final java.lang.String[] getMatches() {
            return this.matches;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getIndex() {
            return this.index;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final java.lang.String getInput() {
            return this.input;
        }

        public final java.util.Map<java.lang.String, java.lang.String> component4() {
            return this.namedGroups;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final java.lang.Integer[][] getMatchIndices() {
            return this.matchIndices;
        }

        public final io.dcloud.uts.nativeregex.JSRegexp.MatchResult copy(java.lang.String[] matches, int index, java.lang.String input, java.util.Map<java.lang.String, java.lang.String> namedGroups, java.lang.Integer[][] matchIndices) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(matches, "matches");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(input, "input");
            return new io.dcloud.uts.nativeregex.JSRegexp.MatchResult(matches, index, input, namedGroups, matchIndices);
        }

        public java.lang.String toString() {
            return "MatchResult(matches=" + java.util.Arrays.toString(this.matches) + ", index=" + this.index + ", input=" + this.input + ", namedGroups=" + this.namedGroups + ", matchIndices=" + java.util.Arrays.toString(this.matchIndices) + com.taobao.weex.el.parse.Operators.BRACKET_END;
        }

        public MatchResult(java.lang.String[] matches, int i, java.lang.String input, java.util.Map<java.lang.String, java.lang.String> map, java.lang.Integer[][] numArr) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(matches, "matches");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(input, "input");
            this.matches = matches;
            this.index = i;
            this.input = input;
            this.namedGroups = map;
            this.matchIndices = numArr;
        }

        public /* synthetic */ MatchResult(java.lang.String[] strArr, int i, java.lang.String str, java.util.Map map, java.lang.Integer[][] numArr, int i2, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this(strArr, i, str, (i2 & 8) != 0 ? null : map, (i2 & 16) != 0 ? null : numArr);
        }

        public final java.lang.String[] getMatches() {
            return this.matches;
        }

        public final int getIndex() {
            return this.index;
        }

        public final java.lang.String getInput() {
            return this.input;
        }

        public final java.util.Map<java.lang.String, java.lang.String> getNamedGroups() {
            return this.namedGroups;
        }

        public final java.lang.Integer[][] getMatchIndices() {
            return this.matchIndices;
        }

        public final int getLength() {
            return this.matches.length;
        }

        public final java.lang.String get(int index) {
            return this.matches[index];
        }

        public boolean equals(java.lang.Object other) {
            if (this == other) {
                return true;
            }
            if (!kotlin.jvm.internal.Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
                return false;
            }
            kotlin.jvm.internal.Intrinsics.checkNotNull(other, "null cannot be cast to non-null type io.dcloud.uts.nativeregex.JSRegexp.MatchResult");
            io.dcloud.uts.nativeregex.JSRegexp.MatchResult matchResult = (io.dcloud.uts.nativeregex.JSRegexp.MatchResult) other;
            return java.util.Arrays.equals(this.matches, matchResult.matches) && this.index == matchResult.index && kotlin.jvm.internal.Intrinsics.areEqual(this.input, matchResult.input);
        }

        public int hashCode() {
            return (((java.util.Arrays.hashCode(this.matches) * 31) + this.index) * 31) + this.input.hashCode();
        }
    }

    public final int getLastIndex() {
        return this.lastIndex;
    }

    public final void setLastIndex(int i) {
        if (i < 0) {
            this.lastIndex = 0;
        } else {
            this.lastIndex = i;
        }
    }

    private final boolean getHasGlobalOrSticky() {
        return kotlin.text.StringsKt.contains$default((java.lang.CharSequence) this.flags, 'g', false, 2, (java.lang.Object) null) || kotlin.text.StringsKt.contains$default((java.lang.CharSequence) this.flags, 'y', false, 2, (java.lang.Object) null);
    }

    public static /* synthetic */ io.dcloud.uts.RegExpExecArray exec$default(io.dcloud.uts.nativeregex.JSRegexp jSRegexp, java.lang.String str, int i, int i2, java.lang.Object obj) {
        if ((i2 & 2) != 0) {
            i = -1;
        }
        return jSRegexp.exec(str, i);
    }

    public final io.dcloud.uts.RegExpExecArray exec(java.lang.String input, int startIndex) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(input, "input");
        if (startIndex < 0) {
            startIndex = getHasGlobalOrSticky() ? getLastIndex() : 0;
        }
        io.dcloud.uts.RegExpExecArray regExpExecArrayExecRegexp = io.dcloud.uts.nativeregex.RegexpBridge.INSTANCE.execRegexp(this.bytecode, input, startIndex);
        if (regExpExecArrayExecRegexp == null) {
            if (getHasGlobalOrSticky()) {
                setLastIndex(0);
            }
            return null;
        }
        if (getHasGlobalOrSticky()) {
            java.lang.Object orNull = kotlin.collections.CollectionsKt.getOrNull(regExpExecArrayExecRegexp, 0);
            java.lang.String str = orNull instanceof java.lang.String ? (java.lang.String) orNull : null;
            setLastIndex(regExpExecArrayExecRegexp.getIndex() + (str != null ? str.length() : 0));
        }
        return regExpExecArrayExecRegexp;
    }

    public final boolean test(java.lang.String input) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(input, "input");
        return exec$default(this, input, 0, 2, null) != null;
    }

    public final java.lang.String getSource() {
        return io.dcloud.uts.nativeregex.RegexpBridge.INSTANCE.getSource(this.pattern);
    }

    public final boolean isGlobal() {
        return kotlin.text.StringsKt.contains$default((java.lang.CharSequence) this.flags, 'g', false, 2, (java.lang.Object) null);
    }

    public final boolean isIgnoreCase() {
        return kotlin.text.StringsKt.contains$default((java.lang.CharSequence) this.flags, 'i', false, 2, (java.lang.Object) null);
    }

    public final boolean isMultiline() {
        return kotlin.text.StringsKt.contains$default((java.lang.CharSequence) this.flags, 'm', false, 2, (java.lang.Object) null);
    }

    public final boolean isDotAll() {
        return kotlin.text.StringsKt.contains$default((java.lang.CharSequence) this.flags, 's', false, 2, (java.lang.Object) null);
    }

    public final boolean isUnicode() {
        return kotlin.text.StringsKt.contains$default((java.lang.CharSequence) this.flags, 'u', false, 2, (java.lang.Object) null);
    }

    public final boolean isUnicodeSets() {
        return kotlin.text.StringsKt.contains$default((java.lang.CharSequence) this.flags, 'v', false, 2, (java.lang.Object) null);
    }

    public final boolean isSticky() {
        return kotlin.text.StringsKt.contains$default((java.lang.CharSequence) this.flags, 'y', false, 2, (java.lang.Object) null);
    }

    public final boolean hasIndices() {
        return kotlin.text.StringsKt.contains$default((java.lang.CharSequence) this.flags, 'd', false, 2, (java.lang.Object) null);
    }

    public java.lang.String toString() {
        return "/" + this.pattern + '/' + this.flags;
    }
}
