package com.facebook.fresco.urimod;

/* JADX INFO: compiled from: UriModifierInterface.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u0010J:\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH&J\u001c\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H&¨\u0006\u0011"}, d2 = {"Lcom/facebook/fresco/urimod/UriModifierInterface;", "", "modifyUri", "Lcom/facebook/fresco/urimod/UriModifierInterface$ModificationResult;", "imageSource", "Lcom/facebook/fresco/vito/source/UriImageSource;", "viewport", "Lcom/facebook/fresco/urimod/Dimensions;", "scaleType", "Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;", "callerContext", "contextChain", "Lcom/facebook/common/callercontext/ContextChain;", "modifyPrefetchUri", "Landroid/net/Uri;", "uri", "ModificationResult", "urimod_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface UriModifierInterface {
    android.net.Uri modifyPrefetchUri(android.net.Uri uri, java.lang.Object callerContext);

    com.facebook.fresco.urimod.UriModifierInterface.ModificationResult modifyUri(com.facebook.fresco.vito.source.UriImageSource imageSource, com.facebook.fresco.urimod.Dimensions viewport, com.facebook.drawee.drawable.ScalingUtils.ScaleType scaleType, java.lang.Object callerContext, com.facebook.common.callercontext.ContextChain contextChain);

    /* JADX INFO: compiled from: UriModifierInterface.kt */
    @kotlin.Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ com.facebook.fresco.urimod.UriModifierInterface.ModificationResult modifyUri$default(com.facebook.fresco.urimod.UriModifierInterface uriModifierInterface, com.facebook.fresco.vito.source.UriImageSource uriImageSource, com.facebook.fresco.urimod.Dimensions dimensions, com.facebook.drawee.drawable.ScalingUtils.ScaleType scaleType, java.lang.Object obj, com.facebook.common.callercontext.ContextChain contextChain, int i, java.lang.Object obj2) {
            if (obj2 != null) {
                throw new java.lang.UnsupportedOperationException("Super calls with default arguments not supported in this target, function: modifyUri");
            }
            if ((i & 16) != 0) {
                contextChain = null;
            }
            return uriModifierInterface.modifyUri(uriImageSource, dimensions, scaleType, obj, contextChain);
        }
    }

    /* JADX INFO: compiled from: UriModifierInterface.kt */
    @kotlin.Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u000b\f\r\u000eB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t\u0082\u0001\u0004\u000f\u0010\u0011\u0012¨\u0006\u0013"}, d2 = {"Lcom/facebook/fresco/urimod/UriModifierInterface$ModificationResult;", "", "comment", "", "<init>", "(Ljava/lang/String;)V", "bestAllowlistedSize", "", "getBestAllowlistedSize", "()Ljava/lang/Integer;", "toString", "Disabled", "Modified", "FallbackToOriginalUrl", "Unmodified", "Lcom/facebook/fresco/urimod/UriModifierInterface$ModificationResult$Disabled;", "Lcom/facebook/fresco/urimod/UriModifierInterface$ModificationResult$FallbackToOriginalUrl;", "Lcom/facebook/fresco/urimod/UriModifierInterface$ModificationResult$Modified;", "Lcom/facebook/fresco/urimod/UriModifierInterface$ModificationResult$Unmodified;", "urimod_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static abstract class ModificationResult {
        private final java.lang.String comment;

        public /* synthetic */ ModificationResult(java.lang.String str, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this(str);
        }

        public abstract java.lang.Integer getBestAllowlistedSize();

        private ModificationResult(java.lang.String str) {
            this.comment = str;
        }

        /* JADX INFO: renamed from: toString, reason: from getter */
        public java.lang.String getComment() {
            return this.comment;
        }

        /* JADX INFO: compiled from: UriModifierInterface.kt */
        @kotlin.Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/facebook/fresco/urimod/UriModifierInterface$ModificationResult$Disabled;", "Lcom/facebook/fresco/urimod/UriModifierInterface$ModificationResult;", "comment", "", "<init>", "(Ljava/lang/String;)V", "bestAllowlistedSize", "", "getBestAllowlistedSize", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "urimod_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Disabled extends com.facebook.fresco.urimod.UriModifierInterface.ModificationResult {
            private final java.lang.Integer bestAllowlistedSize;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Disabled(java.lang.String comment) {
                super("Disabled:" + comment, null);
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(comment, "comment");
            }

            @Override // com.facebook.fresco.urimod.UriModifierInterface.ModificationResult
            public java.lang.Integer getBestAllowlistedSize() {
                return this.bestAllowlistedSize;
            }
        }

        /* JADX INFO: compiled from: UriModifierInterface.kt */
        @kotlin.Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\n\u000bB\u0019\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u0082\u0001\u0002\f\r¨\u0006\u000e"}, d2 = {"Lcom/facebook/fresco/urimod/UriModifierInterface$ModificationResult$Modified;", "Lcom/facebook/fresco/urimod/UriModifierInterface$ModificationResult;", "newUri", "Landroid/net/Uri;", "comment", "", "<init>", "(Landroid/net/Uri;Ljava/lang/String;)V", "getNewUri", "()Landroid/net/Uri;", "ModifiedToAllowlistedSize", "ModifiedToMaxDimens", "Lcom/facebook/fresco/urimod/UriModifierInterface$ModificationResult$Modified$ModifiedToAllowlistedSize;", "Lcom/facebook/fresco/urimod/UriModifierInterface$ModificationResult$Modified$ModifiedToMaxDimens;", "urimod_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static abstract class Modified extends com.facebook.fresco.urimod.UriModifierInterface.ModificationResult {
            private final android.net.Uri newUri;

            public /* synthetic */ Modified(android.net.Uri uri, java.lang.String str, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
                this(uri, str);
            }

            /* JADX INFO: compiled from: UriModifierInterface.kt */
            @kotlin.Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/facebook/fresco/urimod/UriModifierInterface$ModificationResult$Modified$ModifiedToAllowlistedSize;", "Lcom/facebook/fresco/urimod/UriModifierInterface$ModificationResult$Modified;", "newUrl", "Landroid/net/Uri;", "bestAllowlistedSize", "", "<init>", "(Landroid/net/Uri;Ljava/lang/Integer;)V", "getBestAllowlistedSize", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "urimod_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
            public static final class ModifiedToAllowlistedSize extends com.facebook.fresco.urimod.UriModifierInterface.ModificationResult.Modified {
                private final java.lang.Integer bestAllowlistedSize;

                @Override // com.facebook.fresco.urimod.UriModifierInterface.ModificationResult
                public java.lang.Integer getBestAllowlistedSize() {
                    return this.bestAllowlistedSize;
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public ModifiedToAllowlistedSize(android.net.Uri newUrl, java.lang.Integer num) {
                    super(newUrl, "ModifiedToAllowlistedSize", null);
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(newUrl, "newUrl");
                    this.bestAllowlistedSize = num;
                }
            }

            private Modified(android.net.Uri uri, java.lang.String str) {
                super(str, null);
                this.newUri = uri;
            }

            public final android.net.Uri getNewUri() {
                return this.newUri;
            }

            /* JADX INFO: compiled from: UriModifierInterface.kt */
            @kotlin.Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/facebook/fresco/urimod/UriModifierInterface$ModificationResult$Modified$ModifiedToMaxDimens;", "Lcom/facebook/fresco/urimod/UriModifierInterface$ModificationResult$Modified;", "newUrl", "Landroid/net/Uri;", "bestAllowlistedSize", "", "<init>", "(Landroid/net/Uri;Ljava/lang/Integer;)V", "getBestAllowlistedSize", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "urimod_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
            public static final class ModifiedToMaxDimens extends com.facebook.fresco.urimod.UriModifierInterface.ModificationResult.Modified {
                private final java.lang.Integer bestAllowlistedSize;

                @Override // com.facebook.fresco.urimod.UriModifierInterface.ModificationResult
                public java.lang.Integer getBestAllowlistedSize() {
                    return this.bestAllowlistedSize;
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public ModifiedToMaxDimens(android.net.Uri newUrl, java.lang.Integer num) {
                    super(newUrl, "ModifiedToMaxDimens", null);
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(newUrl, "newUrl");
                    this.bestAllowlistedSize = num;
                }
            }
        }

        /* JADX INFO: compiled from: UriModifierInterface.kt */
        @kotlin.Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001a\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/facebook/fresco/urimod/UriModifierInterface$ModificationResult$FallbackToOriginalUrl;", "Lcom/facebook/fresco/urimod/UriModifierInterface$ModificationResult;", "bestAllowlistedSize", "", "<init>", "(Ljava/lang/Integer;)V", "getBestAllowlistedSize", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "copy", "(Ljava/lang/Integer;)Lcom/facebook/fresco/urimod/UriModifierInterface$ModificationResult$FallbackToOriginalUrl;", "equals", "", "other", "", "hashCode", "toString", "", "urimod_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final /* data */ class FallbackToOriginalUrl extends com.facebook.fresco.urimod.UriModifierInterface.ModificationResult {
            private final java.lang.Integer bestAllowlistedSize;

            public static /* synthetic */ com.facebook.fresco.urimod.UriModifierInterface.ModificationResult.FallbackToOriginalUrl copy$default(com.facebook.fresco.urimod.UriModifierInterface.ModificationResult.FallbackToOriginalUrl fallbackToOriginalUrl, java.lang.Integer num, int i, java.lang.Object obj) {
                if ((i & 1) != 0) {
                    num = fallbackToOriginalUrl.bestAllowlistedSize;
                }
                return fallbackToOriginalUrl.copy(num);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final java.lang.Integer getBestAllowlistedSize() {
                return this.bestAllowlistedSize;
            }

            public final com.facebook.fresco.urimod.UriModifierInterface.ModificationResult.FallbackToOriginalUrl copy(java.lang.Integer bestAllowlistedSize) {
                return new com.facebook.fresco.urimod.UriModifierInterface.ModificationResult.FallbackToOriginalUrl(bestAllowlistedSize);
            }

            public boolean equals(java.lang.Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof com.facebook.fresco.urimod.UriModifierInterface.ModificationResult.FallbackToOriginalUrl) && kotlin.jvm.internal.Intrinsics.areEqual(this.bestAllowlistedSize, ((com.facebook.fresco.urimod.UriModifierInterface.ModificationResult.FallbackToOriginalUrl) other).bestAllowlistedSize);
            }

            public int hashCode() {
                java.lang.Integer num = this.bestAllowlistedSize;
                if (num == null) {
                    return 0;
                }
                return num.hashCode();
            }

            @Override // com.facebook.fresco.urimod.UriModifierInterface.ModificationResult
            /* JADX INFO: renamed from: toString */
            public java.lang.String getComment() {
                return "FallbackToOriginalUrl(bestAllowlistedSize=" + this.bestAllowlistedSize + com.taobao.weex.el.parse.Operators.BRACKET_END_STR;
            }

            @Override // com.facebook.fresco.urimod.UriModifierInterface.ModificationResult
            public java.lang.Integer getBestAllowlistedSize() {
                return this.bestAllowlistedSize;
            }

            public FallbackToOriginalUrl(java.lang.Integer num) {
                super("FallbackToOriginalUrl", null);
                this.bestAllowlistedSize = num;
            }
        }

        /* JADX INFO: compiled from: UriModifierInterface.kt */
        @kotlin.Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ$\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/facebook/fresco/urimod/UriModifierInterface$ModificationResult$Unmodified;", "Lcom/facebook/fresco/urimod/UriModifierInterface$ModificationResult;", "reason", "", "bestAllowlistedSize", "", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getReason", "()Ljava/lang/String;", "getBestAllowlistedSize", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/facebook/fresco/urimod/UriModifierInterface$ModificationResult$Unmodified;", "equals", "", "other", "", "hashCode", "toString", "urimod_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final /* data */ class Unmodified extends com.facebook.fresco.urimod.UriModifierInterface.ModificationResult {
            private final java.lang.Integer bestAllowlistedSize;
            private final java.lang.String reason;

            public static /* synthetic */ com.facebook.fresco.urimod.UriModifierInterface.ModificationResult.Unmodified copy$default(com.facebook.fresco.urimod.UriModifierInterface.ModificationResult.Unmodified unmodified, java.lang.String str, java.lang.Integer num, int i, java.lang.Object obj) {
                if ((i & 1) != 0) {
                    str = unmodified.reason;
                }
                if ((i & 2) != 0) {
                    num = unmodified.bestAllowlistedSize;
                }
                return unmodified.copy(str, num);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final java.lang.String getReason() {
                return this.reason;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final java.lang.Integer getBestAllowlistedSize() {
                return this.bestAllowlistedSize;
            }

            public final com.facebook.fresco.urimod.UriModifierInterface.ModificationResult.Unmodified copy(java.lang.String reason, java.lang.Integer bestAllowlistedSize) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(reason, "reason");
                return new com.facebook.fresco.urimod.UriModifierInterface.ModificationResult.Unmodified(reason, bestAllowlistedSize);
            }

            public boolean equals(java.lang.Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof com.facebook.fresco.urimod.UriModifierInterface.ModificationResult.Unmodified)) {
                    return false;
                }
                com.facebook.fresco.urimod.UriModifierInterface.ModificationResult.Unmodified unmodified = (com.facebook.fresco.urimod.UriModifierInterface.ModificationResult.Unmodified) other;
                return kotlin.jvm.internal.Intrinsics.areEqual(this.reason, unmodified.reason) && kotlin.jvm.internal.Intrinsics.areEqual(this.bestAllowlistedSize, unmodified.bestAllowlistedSize);
            }

            public int hashCode() {
                int iHashCode = this.reason.hashCode() * 31;
                java.lang.Integer num = this.bestAllowlistedSize;
                return iHashCode + (num == null ? 0 : num.hashCode());
            }

            @Override // com.facebook.fresco.urimod.UriModifierInterface.ModificationResult
            /* JADX INFO: renamed from: toString */
            public java.lang.String getComment() {
                return "Unmodified(reason=" + this.reason + ", bestAllowlistedSize=" + this.bestAllowlistedSize + com.taobao.weex.el.parse.Operators.BRACKET_END_STR;
            }

            @Override // com.facebook.fresco.urimod.UriModifierInterface.ModificationResult
            public java.lang.Integer getBestAllowlistedSize() {
                return this.bestAllowlistedSize;
            }

            public final java.lang.String getReason() {
                return this.reason;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Unmodified(java.lang.String reason, java.lang.Integer num) {
                super("Unmodified(reason='" + reason + "'", null);
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(reason, "reason");
                this.reason = reason;
                this.bestAllowlistedSize = num;
            }
        }
    }
}
