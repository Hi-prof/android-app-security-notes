package com.facebook.imagepipeline.common;

/* JADX INFO: compiled from: BytesRange.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0087\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u0007\u001a\u00020\bJ\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0000H\u0086\u0002J\b\u0010\f\u001a\u00020\bH\u0016J\u0013\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0003H\u0016J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/facebook/imagepipeline/common/BytesRange;", "", "from", "", "to", "<init>", "(II)V", "toHttpRangeHeaderValue", "", "contains", "", "compare", "toString", "equals", "other", "hashCode", "component1", "component2", "copy", "Companion", "imagepipeline-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class BytesRange {
    public static final int TO_END_OF_CONTENT = Integer.MAX_VALUE;
    public final int from;
    public final int to;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final com.facebook.imagepipeline.common.BytesRange.Companion INSTANCE = new com.facebook.imagepipeline.common.BytesRange.Companion(null);
    private static final kotlin.Lazy<java.util.regex.Pattern> headerParsingRegEx$delegate = kotlin.LazyKt.lazy(new kotlin.jvm.functions.Function0() { // from class: com.facebook.imagepipeline.common.BytesRange$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final java.lang.Object invoke() {
            return com.facebook.imagepipeline.common.BytesRange.headerParsingRegEx_delegate$lambda$0();
        }
    });

    public static /* synthetic */ com.facebook.imagepipeline.common.BytesRange copy$default(com.facebook.imagepipeline.common.BytesRange bytesRange, int i, int i2, int i3, java.lang.Object obj) {
        if ((i3 & 1) != 0) {
            i = bytesRange.from;
        }
        if ((i3 & 2) != 0) {
            i2 = bytesRange.to;
        }
        return bytesRange.copy(i, i2);
    }

    @kotlin.jvm.JvmStatic
    public static final com.facebook.imagepipeline.common.BytesRange from(int i) {
        return INSTANCE.from(i);
    }

    @kotlin.jvm.JvmStatic
    public static final com.facebook.imagepipeline.common.BytesRange fromContentRangeHeader(java.lang.String str) throws java.lang.IllegalArgumentException {
        return INSTANCE.fromContentRangeHeader(str);
    }

    @kotlin.jvm.JvmStatic
    public static final com.facebook.imagepipeline.common.BytesRange toMax(int i) {
        return INSTANCE.toMax(i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getFrom() {
        return this.from;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getTo() {
        return this.to;
    }

    public final com.facebook.imagepipeline.common.BytesRange copy(int from, int to) {
        return new com.facebook.imagepipeline.common.BytesRange(from, to);
    }

    public BytesRange(int i, int i2) {
        this.from = i;
        this.to = i2;
    }

    public final java.lang.String toHttpRangeHeaderValue() {
        kotlin.jvm.internal.StringCompanionObject stringCompanionObject = kotlin.jvm.internal.StringCompanionObject.INSTANCE;
        com.facebook.imagepipeline.common.BytesRange.Companion companion = INSTANCE;
        java.lang.String str = java.lang.String.format(null, "bytes=%s-%s", java.util.Arrays.copyOf(new java.lang.Object[]{companion.valueOrEmpty(this.from), companion.valueOrEmpty(this.to)}, 2));
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public final boolean contains(com.facebook.imagepipeline.common.BytesRange compare) {
        return compare != null && this.from <= compare.from && compare.to <= this.to;
    }

    public java.lang.String toString() {
        kotlin.jvm.internal.StringCompanionObject stringCompanionObject = kotlin.jvm.internal.StringCompanionObject.INSTANCE;
        com.facebook.imagepipeline.common.BytesRange.Companion companion = INSTANCE;
        java.lang.String str = java.lang.String.format(null, "%s-%s", java.util.Arrays.copyOf(new java.lang.Object[]{companion.valueOrEmpty(this.from), companion.valueOrEmpty(this.to)}, 2));
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public boolean equals(java.lang.Object other) {
        if (this == other) {
            return true;
        }
        if (!kotlin.jvm.internal.Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        kotlin.jvm.internal.Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.facebook.imagepipeline.common.BytesRange");
        com.facebook.imagepipeline.common.BytesRange bytesRange = (com.facebook.imagepipeline.common.BytesRange) other;
        return this.from == bytesRange.from && this.to == bytesRange.to;
    }

    public int hashCode() {
        return (this.from * 31) + this.to;
    }

    /* JADX INFO: compiled from: BytesRange.kt */
    @kotlin.Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0005H\u0007J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0005H\u0007J\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\rH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/facebook/imagepipeline/common/BytesRange$Companion;", "", "<init>", "()V", "TO_END_OF_CONTENT", "", "headerParsingRegEx", "Ljava/util/regex/Pattern;", "getHeaderParsingRegEx", "()Ljava/util/regex/Pattern;", "headerParsingRegEx$delegate", "Lkotlin/Lazy;", "valueOrEmpty", "", "n", "from", "Lcom/facebook/imagepipeline/common/BytesRange;", "toMax", "to", "fromContentRangeHeader", com.taobao.weex.ui.component.WXBasicComponentType.HEADER, "imagepipeline-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final java.util.regex.Pattern getHeaderParsingRegEx() {
            java.lang.Object value = com.facebook.imagepipeline.common.BytesRange.headerParsingRegEx$delegate.getValue();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            return (java.util.regex.Pattern) value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final java.lang.String valueOrEmpty(int n) {
            return n == Integer.MAX_VALUE ? "" : java.lang.String.valueOf(n);
        }

        @kotlin.jvm.JvmStatic
        public final com.facebook.imagepipeline.common.BytesRange from(int from) {
            com.facebook.common.internal.Preconditions.checkArgument(java.lang.Boolean.valueOf(from >= 0));
            return new com.facebook.imagepipeline.common.BytesRange(from, Integer.MAX_VALUE);
        }

        @kotlin.jvm.JvmStatic
        public final com.facebook.imagepipeline.common.BytesRange toMax(int to) {
            com.facebook.common.internal.Preconditions.checkArgument(java.lang.Boolean.valueOf(to > 0));
            return new com.facebook.imagepipeline.common.BytesRange(0, to);
        }

        @kotlin.jvm.JvmStatic
        public final com.facebook.imagepipeline.common.BytesRange fromContentRangeHeader(java.lang.String header) throws java.lang.IllegalArgumentException {
            if (header == null) {
                return null;
            }
            try {
                java.lang.String[] strArrSplit = getHeaderParsingRegEx().split(header);
                com.facebook.common.internal.Preconditions.checkArgument(java.lang.Boolean.valueOf(strArrSplit.length == 4));
                com.facebook.common.internal.Preconditions.checkArgument(java.lang.Boolean.valueOf(kotlin.jvm.internal.Intrinsics.areEqual(strArrSplit[0], "bytes")));
                java.lang.String str = strArrSplit[1];
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(str, "get(...)");
                int i = java.lang.Integer.parseInt(str);
                java.lang.String str2 = strArrSplit[2];
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(str2, "get(...)");
                int i2 = java.lang.Integer.parseInt(str2);
                java.lang.String str3 = strArrSplit[3];
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(str3, "get(...)");
                int i3 = java.lang.Integer.parseInt(str3);
                com.facebook.common.internal.Preconditions.checkArgument(java.lang.Boolean.valueOf(i2 > i));
                com.facebook.common.internal.Preconditions.checkArgument(java.lang.Boolean.valueOf(i3 > i2));
                if (i2 < i3 - 1) {
                    return new com.facebook.imagepipeline.common.BytesRange(i, i2);
                }
                return new com.facebook.imagepipeline.common.BytesRange(i, Integer.MAX_VALUE);
            } catch (java.lang.IllegalArgumentException e) {
                kotlin.jvm.internal.StringCompanionObject stringCompanionObject = kotlin.jvm.internal.StringCompanionObject.INSTANCE;
                java.lang.String str4 = java.lang.String.format(null, "Invalid Content-Range header value: \"%s\"", java.util.Arrays.copyOf(new java.lang.Object[]{header}, 1));
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                throw new java.lang.IllegalArgumentException(str4, e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.util.regex.Pattern headerParsingRegEx_delegate$lambda$0() {
        return java.util.regex.Pattern.compile("[-/ ]");
    }
}
