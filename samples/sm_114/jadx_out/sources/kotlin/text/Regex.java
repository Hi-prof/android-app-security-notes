package kotlin.text;

/* JADX INFO: compiled from: Regex.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 52\u00060\u0001j\u0002`\u0002:\u000245B\u0011\b\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\tB\u0019\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fB\u001f\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000e¢\u0006\u0004\b\u0005\u0010\u000fJ\u0011\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0086\u0004J\u000e\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u001a\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u001c\u001a\u00020\u001dJ\u001e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001f2\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u001c\u001a\u00020\u001dJ\u0010\u0010 \u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0017\u001a\u00020\u0018J\u001a\u0010!\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u001dH\u0007J\u0018\u0010#\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u001dH\u0007J\u0016\u0010$\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010%\u001a\u00020\bJ\"\u0010$\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00182\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00180'J\u0016\u0010(\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010%\u001a\u00020\bJ\u001e\u0010)\u001a\b\u0012\u0004\u0012\u00020\b0*2\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010+\u001a\u00020\u001dJ \u0010,\u001a\b\u0012\u0004\u0012\u00020\b0\u001f2\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010+\u001a\u00020\u001dH\u0007J\b\u0010-\u001a\u00020\bH\u0016J\u0006\u0010.\u001a\u00020\u0004J\b\u0010/\u001a\u000200H\u0002J\u0010\u00101\u001a\u0002022\u0006\u0010\u0017\u001a\u000203H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000e8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u00066"}, d2 = {"Lkotlin/text/Regex;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "nativePattern", "Ljava/util/regex/Pattern;", "<init>", "(Ljava/util/regex/Pattern;)V", "pattern", "", "(Ljava/lang/String;)V", io.dcloud.common.constant.AbsoluteConst.JSON_KEY_OPTION, "Lkotlin/text/RegexOption;", "(Ljava/lang/String;Lkotlin/text/RegexOption;)V", "options", "", "(Ljava/lang/String;Ljava/util/Set;)V", "getPattern", "()Ljava/lang/String;", "_options", "getOptions", "()Ljava/util/Set;", "matches", "", "input", "", "containsMatchIn", "find", "Lkotlin/text/MatchResult;", "startIndex", "", "findAll", "Lkotlin/sequences/Sequence;", "matchEntire", "matchAt", "index", "matchesAt", "replace", "replacement", "transform", "Lkotlin/Function1;", "replaceFirst", "split", "", "limit", "splitToSequence", "toString", "toPattern", "writeReplace", "", "readObject", "", "Ljava/io/ObjectInputStream;", "Serialized", "Companion", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Regex implements java.io.Serializable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final kotlin.text.Regex.Companion INSTANCE = new kotlin.text.Regex.Companion(null);
    private java.util.Set<? extends kotlin.text.RegexOption> _options;
    private final java.util.regex.Pattern nativePattern;

    public Regex(java.util.regex.Pattern nativePattern) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nativePattern, "nativePattern");
        this.nativePattern = nativePattern;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Regex(java.lang.String pattern) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(pattern, "pattern");
        java.util.regex.Pattern patternCompile = java.util.regex.Pattern.compile(pattern);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(patternCompile, "compile(...)");
        this(patternCompile);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Regex(java.lang.String pattern, kotlin.text.RegexOption option) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(pattern, "pattern");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(option, "option");
        java.util.regex.Pattern patternCompile = java.util.regex.Pattern.compile(pattern, INSTANCE.ensureUnicodeCase(option.getValue()));
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(patternCompile, "compile(...)");
        this(patternCompile);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Regex(java.lang.String pattern, java.util.Set<? extends kotlin.text.RegexOption> options) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(pattern, "pattern");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(options, "options");
        java.util.regex.Pattern patternCompile = java.util.regex.Pattern.compile(pattern, INSTANCE.ensureUnicodeCase(kotlin.text.RegexKt.toInt(options)));
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(patternCompile, "compile(...)");
        this(patternCompile);
    }

    public final java.lang.String getPattern() {
        java.lang.String strPattern = this.nativePattern.pattern();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strPattern, "pattern(...)");
        return strPattern;
    }

    public final java.util.Set<kotlin.text.RegexOption> getOptions() {
        java.util.Set set = this._options;
        if (set != null) {
            return set;
        }
        final int iFlags = this.nativePattern.flags();
        java.util.EnumSet enumSetAllOf = java.util.EnumSet.allOf(kotlin.text.RegexOption.class);
        kotlin.jvm.internal.Intrinsics.checkNotNull(enumSetAllOf);
        kotlin.collections.CollectionsKt.retainAll(enumSetAllOf, new kotlin.jvm.functions.Function1<kotlin.text.RegexOption, java.lang.Boolean>() { // from class: kotlin.text.Regex$special$$inlined$fromInt$1
            @Override // kotlin.jvm.functions.Function1
            public final java.lang.Boolean invoke(kotlin.text.RegexOption regexOption) {
                kotlin.text.RegexOption regexOption2 = regexOption;
                return java.lang.Boolean.valueOf((iFlags & regexOption2.getMask()) == regexOption2.getValue());
            }
        });
        java.util.Set<kotlin.text.RegexOption> setUnmodifiableSet = java.util.Collections.unmodifiableSet(enumSetAllOf);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(setUnmodifiableSet, "unmodifiableSet(...)");
        this._options = setUnmodifiableSet;
        return setUnmodifiableSet;
    }

    public final boolean matches(java.lang.CharSequence input) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(input, "input");
        return this.nativePattern.matcher(input).matches();
    }

    public final boolean containsMatchIn(java.lang.CharSequence input) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(input, "input");
        return this.nativePattern.matcher(input).find();
    }

    public static /* synthetic */ kotlin.text.MatchResult find$default(kotlin.text.Regex regex, java.lang.CharSequence charSequence, int i, int i2, java.lang.Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.find(charSequence, i);
    }

    public final kotlin.text.MatchResult find(java.lang.CharSequence input, int startIndex) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(input, "input");
        java.util.regex.Matcher matcher = this.nativePattern.matcher(input);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(matcher, "matcher(...)");
        return kotlin.text.RegexKt.findNext(matcher, startIndex, input);
    }

    public static /* synthetic */ kotlin.sequences.Sequence findAll$default(kotlin.text.Regex regex, java.lang.CharSequence charSequence, int i, int i2, java.lang.Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.findAll(charSequence, i);
    }

    public final kotlin.sequences.Sequence<kotlin.text.MatchResult> findAll(final java.lang.CharSequence input, final int startIndex) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(input, "input");
        if (startIndex < 0 || startIndex > input.length()) {
            throw new java.lang.IndexOutOfBoundsException("Start index out of bounds: " + startIndex + ", input length: " + input.length());
        }
        return kotlin.sequences.SequencesKt.generateSequence(new kotlin.jvm.functions.Function0() { // from class: kotlin.text.Regex$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final java.lang.Object invoke() {
                return this.f$0.find(input, startIndex);
            }
        }, (kotlin.jvm.functions.Function1) kotlin.text.Regex.AnonymousClass2.INSTANCE);
    }

    /* JADX INFO: renamed from: kotlin.text.Regex$findAll$2, reason: invalid class name */
    /* JADX INFO: compiled from: Regex.kt */
    @kotlin.Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    static final /* synthetic */ class AnonymousClass2 extends kotlin.jvm.internal.FunctionReferenceImpl implements kotlin.jvm.functions.Function1<kotlin.text.MatchResult, kotlin.text.MatchResult> {
        public static final kotlin.text.Regex.AnonymousClass2 INSTANCE = new kotlin.text.Regex.AnonymousClass2();

        AnonymousClass2() {
            super(1, kotlin.text.MatchResult.class, "next", "next()Lkotlin/text/MatchResult;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final kotlin.text.MatchResult invoke(kotlin.text.MatchResult p0) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(p0, "p0");
            return p0.next();
        }
    }

    public final kotlin.text.MatchResult matchEntire(java.lang.CharSequence input) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(input, "input");
        java.util.regex.Matcher matcher = this.nativePattern.matcher(input);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(matcher, "matcher(...)");
        return kotlin.text.RegexKt.matchEntire(matcher, input);
    }

    public final kotlin.text.MatchResult matchAt(java.lang.CharSequence input, int index) {
        kotlin.text.MatcherMatchResult matcherMatchResult;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(input, "input");
        java.util.regex.Matcher matcherRegion = this.nativePattern.matcher(input).useAnchoringBounds(false).useTransparentBounds(true).region(index, input.length());
        if (matcherRegion.lookingAt()) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(matcherRegion);
            matcherMatchResult = new kotlin.text.MatcherMatchResult(matcherRegion, input);
        } else {
            matcherMatchResult = null;
        }
        return matcherMatchResult;
    }

    public final boolean matchesAt(java.lang.CharSequence input, int index) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(input, "input");
        return this.nativePattern.matcher(input).useAnchoringBounds(false).useTransparentBounds(true).region(index, input.length()).lookingAt();
    }

    public final java.lang.String replace(java.lang.CharSequence input, java.lang.String replacement) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(input, "input");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(replacement, "replacement");
        java.lang.String strReplaceAll = this.nativePattern.matcher(input).replaceAll(replacement);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strReplaceAll, "replaceAll(...)");
        return strReplaceAll;
    }

    public final java.lang.String replace(java.lang.CharSequence input, kotlin.jvm.functions.Function1<? super kotlin.text.MatchResult, ? extends java.lang.CharSequence> transform) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(input, "input");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(transform, "transform");
        int iIntValue = 0;
        kotlin.text.MatchResult matchResultFind$default = find$default(this, input, 0, 2, null);
        if (matchResultFind$default == null) {
            return input.toString();
        }
        int length = input.length();
        java.lang.StringBuilder sb = new java.lang.StringBuilder(length);
        do {
            sb.append(input, iIntValue, matchResultFind$default.getRange().getStart().intValue());
            sb.append(transform.invoke(matchResultFind$default));
            iIntValue = matchResultFind$default.getRange().getEndInclusive().intValue() + 1;
            matchResultFind$default = matchResultFind$default.next();
            if (iIntValue >= length) {
                break;
            }
        } while (matchResultFind$default != null);
        if (iIntValue < length) {
            sb.append(input, iIntValue, length);
        }
        java.lang.String string = sb.toString();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public final java.lang.String replaceFirst(java.lang.CharSequence input, java.lang.String replacement) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(input, "input");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(replacement, "replacement");
        java.lang.String strReplaceFirst = this.nativePattern.matcher(input).replaceFirst(replacement);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strReplaceFirst, "replaceFirst(...)");
        return strReplaceFirst;
    }

    public static /* synthetic */ java.util.List split$default(kotlin.text.Regex regex, java.lang.CharSequence charSequence, int i, int i2, java.lang.Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.split(charSequence, i);
    }

    public final java.util.List<java.lang.String> split(java.lang.CharSequence input, int limit) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(input, "input");
        kotlin.text.StringsKt.requireNonNegativeLimit(limit);
        java.util.regex.Matcher matcher = this.nativePattern.matcher(input);
        if (limit == 1 || !matcher.find()) {
            return kotlin.collections.CollectionsKt.listOf(input.toString());
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(limit > 0 ? kotlin.ranges.RangesKt.coerceAtMost(limit, 10) : 10);
        int i = limit - 1;
        int iEnd = 0;
        do {
            arrayList.add(input.subSequence(iEnd, matcher.start()).toString());
            iEnd = matcher.end();
            if (i >= 0 && arrayList.size() == i) {
                break;
            }
        } while (matcher.find());
        arrayList.add(input.subSequence(iEnd, input.length()).toString());
        return arrayList;
    }

    public static /* synthetic */ kotlin.sequences.Sequence splitToSequence$default(kotlin.text.Regex regex, java.lang.CharSequence charSequence, int i, int i2, java.lang.Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.splitToSequence(charSequence, i);
    }

    public final kotlin.sequences.Sequence<java.lang.String> splitToSequence(java.lang.CharSequence input, int limit) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(input, "input");
        kotlin.text.StringsKt.requireNonNegativeLimit(limit);
        return kotlin.sequences.SequencesKt.sequence(new kotlin.text.Regex.AnonymousClass1(input, limit, null));
    }

    /* JADX INFO: renamed from: kotlin.text.Regex$splitToSequence$1, reason: invalid class name */
    /* JADX INFO: compiled from: Regex.kt */
    @kotlin.Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @kotlin.coroutines.jvm.internal.DebugMetadata(c = "kotlin.text.Regex$splitToSequence$1", f = "Regex.kt", i = {0, 0, 1, 1, 1, 1, 2, 2, 2, 2}, l = {280, 288, 292}, m = "invokeSuspend", n = {"$this$sequence", "matcher", "$this$sequence", "matcher", "nextStart", "splitCount", "$this$sequence", "matcher", "nextStart", "splitCount"}, s = {"L$0", "L$1", "L$0", "L$1", "I$0", "I$1", "L$0", "L$1", "I$0", "I$1"})
    static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.RestrictedSuspendLambda implements kotlin.jvm.functions.Function2<kotlin.sequences.SequenceScope<? super java.lang.String>, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> {
        final /* synthetic */ java.lang.CharSequence $input;
        final /* synthetic */ int $limit;
        int I$0;
        int I$1;
        private /* synthetic */ java.lang.Object L$0;
        java.lang.Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(java.lang.CharSequence charSequence, int i, kotlin.coroutines.Continuation<? super kotlin.text.Regex.AnonymousClass1> continuation) {
            super(2, continuation);
            this.$input = charSequence;
            this.$limit = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.Continuation<kotlin.Unit> create(java.lang.Object obj, kotlin.coroutines.Continuation<?> continuation) {
            kotlin.text.Regex.AnonymousClass1 anonymousClass1 = kotlin.text.Regex.this.new AnonymousClass1(this.$input, this.$limit, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final java.lang.Object invoke(kotlin.sequences.SequenceScope<? super java.lang.String> sequenceScope, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
            return ((kotlin.text.Regex.AnonymousClass1) create(sequenceScope, continuation)).invokeSuspend(kotlin.Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:21:0x0079  */
        /* JADX WARN: Code duplicated, block: B:24:0x0084  */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x00b6, code lost:
        
            if (r0.yield(r4.subSequence(r11, r4.length()).toString(), r10) == r1) goto L35;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x00d7, code lost:
        
            if (r0.yield(r10.$input.toString(), r10) == r1) goto L35;
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0079 -> B:22:0x007a). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                Method dump skipped, instruction units count: 221
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.text.Regex.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public java.lang.String toString() {
        java.lang.String string = this.nativePattern.toString();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    /* JADX INFO: renamed from: toPattern, reason: from getter */
    public final java.util.regex.Pattern getNativePattern() {
        return this.nativePattern;
    }

    private final java.lang.Object writeReplace() {
        java.lang.String strPattern = this.nativePattern.pattern();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strPattern, "pattern(...)");
        return new kotlin.text.Regex.Serialized(strPattern, this.nativePattern.flags());
    }

    private final void readObject(java.io.ObjectInputStream input) throws java.io.InvalidObjectException {
        throw new java.io.InvalidObjectException("Deserialization is supported via proxy only");
    }

    /* JADX INFO: compiled from: Regex.kt */
    @kotlin.Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u0000 \u000f2\u00060\u0001j\u0002`\u0002:\u0001\u000fB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lkotlin/text/Regex$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "pattern", "", "flags", "", "<init>", "(Ljava/lang/String;I)V", "getPattern", "()Ljava/lang/String;", "getFlags", "()I", "readResolve", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class Serialized implements java.io.Serializable {
        private static final long serialVersionUID = 0;
        private final int flags;
        private final java.lang.String pattern;

        public Serialized(java.lang.String pattern, int i) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(pattern, "pattern");
            this.pattern = pattern;
            this.flags = i;
        }

        public final int getFlags() {
            return this.flags;
        }

        public final java.lang.String getPattern() {
            return this.pattern;
        }

        private final java.lang.Object readResolve() {
            java.util.regex.Pattern patternCompile = java.util.regex.Pattern.compile(this.pattern, this.flags);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(patternCompile, "compile(...)");
            return new kotlin.text.Regex(patternCompile);
        }
    }

    /* JADX INFO: compiled from: Regex.kt */
    @kotlin.Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0002¨\u0006\r"}, d2 = {"Lkotlin/text/Regex$Companion;", "", "<init>", "()V", "fromLiteral", "Lkotlin/text/Regex;", "literal", "", "escape", "escapeReplacement", "ensureUnicodeCase", "", "flags", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int ensureUnicodeCase(int flags) {
            return (flags & 2) != 0 ? flags | 64 : flags;
        }

        private Companion() {
        }

        public final kotlin.text.Regex fromLiteral(java.lang.String literal) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(literal, "literal");
            return new kotlin.text.Regex(literal, kotlin.text.RegexOption.LITERAL);
        }

        public final java.lang.String escape(java.lang.String literal) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(literal, "literal");
            java.lang.String strQuote = java.util.regex.Pattern.quote(literal);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strQuote, "quote(...)");
            return strQuote;
        }

        public final java.lang.String escapeReplacement(java.lang.String literal) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(literal, "literal");
            java.lang.String strQuoteReplacement = java.util.regex.Matcher.quoteReplacement(literal);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strQuoteReplacement, "quoteReplacement(...)");
            return strQuoteReplacement;
        }
    }
}
