package com.facebook.fresco.ui.common;

/* JADX INFO: compiled from: ImagePerfData.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\bD\u0018\u0000 q2\u00020\u0001:\u0001qBý\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u000b\u0012\u0006\u0010\u001d\u001a\u00020\u000b\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\b\u0010 \u001a\u0004\u0018\u00010!\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010%\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010)\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010*\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010+\u001a\u0004\u0018\u00010\u0005\u0012\u0018\u0010,\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0.0-\u0012\u0006\u0010/\u001a\u00020\u0014\u0012\b\u00100\u001a\u0004\u0018\u00010\u0005\u0012\b\u00101\u001a\u0004\u0018\u00010\u0005\u0012\b\u00102\u001a\u0004\u0018\u00010\u0016\u0012\b\u00103\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b4\u00105J\u0006\u0010p\u001a\u00020\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b:\u00109R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b=\u0010<R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b>\u0010<R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\bA\u0010@R\u0011\u0010\r\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\bB\u0010@R\u0011\u0010\u000e\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\bC\u0010@R\u0011\u0010\u000f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\bD\u0010@R\u0011\u0010\u0010\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\bE\u0010@R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010H\u001a\u0004\bF\u0010GR\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010H\u001a\u0004\bI\u0010GR\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010JR\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\bK\u0010LR\u0011\u0010\u0017\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\bM\u0010LR\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\bN\u0010OR\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\bP\u0010QR\u0011\u0010\u001c\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\bR\u0010@R\u0011\u0010\u001d\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\bS\u0010@R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\b\n\u0000\u001a\u0004\bT\u0010UR\u0013\u0010 \u001a\u0004\u0018\u00010!¢\u0006\b\n\u0000\u001a\u0004\bV\u0010WR\u0013\u0010\"\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bX\u00109R\u0013\u0010#\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bY\u00109R\u001b\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010%¢\u0006\n\n\u0002\u0010\\\u001a\u0004\bZ\u0010[R\u0013\u0010&\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b]\u00109R\u0013\u0010'\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b^\u00109R\u0013\u0010(\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b_\u00109R\u0013\u0010)\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b`\u00109R\u0015\u0010*\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010H\u001a\u0004\ba\u0010GR\u0013\u0010+\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bb\u00109R#\u0010,\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0.0-¢\u0006\b\n\u0000\u001a\u0004\bc\u0010dR\u0011\u0010/\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\be\u0010JR\u0013\u00100\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bf\u00109R\u0013\u00101\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bg\u00109R\u0015\u00102\u001a\u0004\u0018\u00010\u0016¢\u0006\n\n\u0002\u0010j\u001a\u0004\bh\u0010iR\u0015\u00103\u001a\u0004\u0018\u00010\u0016¢\u0006\n\n\u0002\u0010j\u001a\u0004\bk\u0010iR\u0011\u0010l\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\bm\u0010LR\u0011\u0010n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\bo\u0010@¨\u0006r"}, d2 = {"Lcom/facebook/fresco/ui/common/ImagePerfData;", "", "infra", "Lcom/facebook/fresco/ui/common/ImageRenderingInfra;", "controllerId", "", "requestId", "imageRequest", "callerContext", "imageInfo", "controllerSubmitTimeMs", "", "intermediateImageLoadTimeMs", "controllerFinalImageSetTimeMs", "controllerFailureTimeMs", "imageRequestStartTimeMs", "imageRequestEndTimeMs", "emptyEventTimestampNs", "releasedEventTimestampNs", "isPrefetch", "", "onScreenWidthPx", "", "onScreenHeightPx", "errorThrowable", "", "visibilityState", "Lcom/facebook/fresco/ui/common/VisibilityState;", "visibilityEventTimeMs", "invisibilityEventTimeMs", "dimensionsInfo", "Lcom/facebook/fresco/ui/common/DimensionsInfo;", "extraData", "Lcom/facebook/fresco/ui/common/ControllerListener2$Extras;", "callingClassNameOnVisible", "rootContextNameOnVisible", "contextChainArrayOnVisible", "", "contextChainExtrasOnVisible", "contentIdOnVisible", "surfaceOnVisible", "subSurfaceOnVisible", "msSinceLastNavigationOnVisible", "startupStatusOnVisible", "intermediateImageSetTimes", "", "Lkotlin/Pair;", "newIntermediateImageSetPointAvailable", "errorMessageOnFailure", "errorStacktraceStringOnFailure", "errorCodeOnFailure", "densityDpiOnSuccess", "<init>", "(Lcom/facebook/fresco/ui/common/ImageRenderingInfra;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;JJJJJJLjava/lang/Long;Ljava/lang/Long;ZIILjava/lang/Throwable;Lcom/facebook/fresco/ui/common/VisibilityState;JJLcom/facebook/fresco/ui/common/DimensionsInfo;Lcom/facebook/fresco/ui/common/ControllerListener2$Extras;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/util/List;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getInfra", "()Lcom/facebook/fresco/ui/common/ImageRenderingInfra;", "getControllerId", "()Ljava/lang/String;", "getRequestId", "getImageRequest", "()Ljava/lang/Object;", "getCallerContext", "getImageInfo", "getControllerSubmitTimeMs", "()J", "getIntermediateImageLoadTimeMs", "getControllerFinalImageSetTimeMs", "getControllerFailureTimeMs", "getImageRequestStartTimeMs", "getImageRequestEndTimeMs", "getEmptyEventTimestampNs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getReleasedEventTimestampNs", "()Z", "getOnScreenWidthPx", "()I", "getOnScreenHeightPx", "getErrorThrowable", "()Ljava/lang/Throwable;", "getVisibilityState", "()Lcom/facebook/fresco/ui/common/VisibilityState;", "getVisibilityEventTimeMs", "getInvisibilityEventTimeMs", "getDimensionsInfo", "()Lcom/facebook/fresco/ui/common/DimensionsInfo;", "getExtraData", "()Lcom/facebook/fresco/ui/common/ControllerListener2$Extras;", "getCallingClassNameOnVisible", "getRootContextNameOnVisible", "getContextChainArrayOnVisible", "()[Ljava/lang/String;", "[Ljava/lang/String;", "getContextChainExtrasOnVisible", "getContentIdOnVisible", "getSurfaceOnVisible", "getSubSurfaceOnVisible", "getMsSinceLastNavigationOnVisible", "getStartupStatusOnVisible", "getIntermediateImageSetTimes", "()Ljava/util/List;", "getNewIntermediateImageSetPointAvailable", "getErrorMessageOnFailure", "getErrorStacktraceStringOnFailure", "getErrorCodeOnFailure", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDensityDpiOnSuccess", "instanceId", "getInstanceId", "finalImageLoadTimeMs", "getFinalImageLoadTimeMs", "createDebugString", "Companion", "ui-common_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ImagePerfData {
    public static final long UNSET = -1;
    private final java.lang.Object callerContext;
    private final java.lang.String callingClassNameOnVisible;
    private final java.lang.String contentIdOnVisible;
    private final java.lang.String[] contextChainArrayOnVisible;
    private final java.lang.String contextChainExtrasOnVisible;
    private final long controllerFailureTimeMs;
    private final long controllerFinalImageSetTimeMs;
    private final java.lang.String controllerId;
    private final long controllerSubmitTimeMs;
    private final java.lang.Integer densityDpiOnSuccess;
    private final com.facebook.fresco.ui.common.DimensionsInfo dimensionsInfo;
    private final java.lang.Long emptyEventTimestampNs;
    private final java.lang.Integer errorCodeOnFailure;
    private final java.lang.String errorMessageOnFailure;
    private final java.lang.String errorStacktraceStringOnFailure;
    private final java.lang.Throwable errorThrowable;
    private final com.facebook.fresco.ui.common.ControllerListener2.Extras extraData;
    private final java.lang.Object imageInfo;
    private final java.lang.Object imageRequest;
    private final long imageRequestEndTimeMs;
    private final long imageRequestStartTimeMs;
    private final com.facebook.fresco.ui.common.ImageRenderingInfra infra;
    private final int instanceId;
    private final long intermediateImageLoadTimeMs;
    private final java.util.List<kotlin.Pair<java.lang.String, java.lang.Long>> intermediateImageSetTimes;
    private final long invisibilityEventTimeMs;
    private final boolean isPrefetch;
    private final java.lang.Long msSinceLastNavigationOnVisible;
    private final boolean newIntermediateImageSetPointAvailable;
    private final int onScreenHeightPx;
    private final int onScreenWidthPx;
    private final java.lang.Long releasedEventTimestampNs;
    private final java.lang.String requestId;
    private final java.lang.String rootContextNameOnVisible;
    private final java.lang.String startupStatusOnVisible;
    private final java.lang.String subSurfaceOnVisible;
    private final java.lang.String surfaceOnVisible;
    private final long visibilityEventTimeMs;
    private final com.facebook.fresco.ui.common.VisibilityState visibilityState;

    public ImagePerfData(com.facebook.fresco.ui.common.ImageRenderingInfra infra, java.lang.String str, java.lang.String str2, java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3, long j, long j2, long j3, long j4, long j5, long j6, java.lang.Long l, java.lang.Long l2, boolean z, int i, int i2, java.lang.Throwable th, com.facebook.fresco.ui.common.VisibilityState visibilityState, long j7, long j8, com.facebook.fresco.ui.common.DimensionsInfo dimensionsInfo, com.facebook.fresco.ui.common.ControllerListener2.Extras extras, java.lang.String str3, java.lang.String str4, java.lang.String[] strArr, java.lang.String str5, java.lang.String str6, java.lang.String str7, java.lang.String str8, java.lang.Long l3, java.lang.String str9, java.util.List<kotlin.Pair<java.lang.String, java.lang.Long>> intermediateImageSetTimes, boolean z2, java.lang.String str10, java.lang.String str11, java.lang.Integer num, java.lang.Integer num2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(infra, "infra");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(visibilityState, "visibilityState");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(intermediateImageSetTimes, "intermediateImageSetTimes");
        this.infra = infra;
        this.controllerId = str;
        this.requestId = str2;
        this.imageRequest = obj;
        this.callerContext = obj2;
        this.imageInfo = obj3;
        this.controllerSubmitTimeMs = j;
        this.intermediateImageLoadTimeMs = j2;
        this.controllerFinalImageSetTimeMs = j3;
        this.controllerFailureTimeMs = j4;
        this.imageRequestStartTimeMs = j5;
        this.imageRequestEndTimeMs = j6;
        this.emptyEventTimestampNs = l;
        this.releasedEventTimestampNs = l2;
        this.isPrefetch = z;
        this.onScreenWidthPx = i;
        this.onScreenHeightPx = i2;
        this.errorThrowable = th;
        this.visibilityState = visibilityState;
        this.visibilityEventTimeMs = j7;
        this.invisibilityEventTimeMs = j8;
        this.dimensionsInfo = dimensionsInfo;
        this.extraData = extras;
        this.callingClassNameOnVisible = str3;
        this.rootContextNameOnVisible = str4;
        this.contextChainArrayOnVisible = strArr;
        this.contextChainExtrasOnVisible = str5;
        this.contentIdOnVisible = str6;
        this.surfaceOnVisible = str7;
        this.subSurfaceOnVisible = str8;
        this.msSinceLastNavigationOnVisible = l3;
        this.startupStatusOnVisible = str9;
        this.intermediateImageSetTimes = intermediateImageSetTimes;
        this.newIntermediateImageSetPointAvailable = z2;
        this.errorMessageOnFailure = str10;
        this.errorStacktraceStringOnFailure = str11;
        this.errorCodeOnFailure = num;
        this.densityDpiOnSuccess = num2;
        this.instanceId = str != null ? str.hashCode() : 0;
    }

    public final com.facebook.fresco.ui.common.ImageRenderingInfra getInfra() {
        return this.infra;
    }

    public final java.lang.String getControllerId() {
        return this.controllerId;
    }

    public final java.lang.String getRequestId() {
        return this.requestId;
    }

    public final java.lang.Object getImageRequest() {
        return this.imageRequest;
    }

    public final java.lang.Object getCallerContext() {
        return this.callerContext;
    }

    public final java.lang.Object getImageInfo() {
        return this.imageInfo;
    }

    public final long getControllerSubmitTimeMs() {
        return this.controllerSubmitTimeMs;
    }

    public final long getIntermediateImageLoadTimeMs() {
        return this.intermediateImageLoadTimeMs;
    }

    public final long getControllerFinalImageSetTimeMs() {
        return this.controllerFinalImageSetTimeMs;
    }

    public final long getControllerFailureTimeMs() {
        return this.controllerFailureTimeMs;
    }

    public final long getImageRequestStartTimeMs() {
        return this.imageRequestStartTimeMs;
    }

    public final long getImageRequestEndTimeMs() {
        return this.imageRequestEndTimeMs;
    }

    public final java.lang.Long getEmptyEventTimestampNs() {
        return this.emptyEventTimestampNs;
    }

    public final java.lang.Long getReleasedEventTimestampNs() {
        return this.releasedEventTimestampNs;
    }

    /* JADX INFO: renamed from: isPrefetch, reason: from getter */
    public final boolean getIsPrefetch() {
        return this.isPrefetch;
    }

    public final int getOnScreenWidthPx() {
        return this.onScreenWidthPx;
    }

    public final int getOnScreenHeightPx() {
        return this.onScreenHeightPx;
    }

    public final java.lang.Throwable getErrorThrowable() {
        return this.errorThrowable;
    }

    public final com.facebook.fresco.ui.common.VisibilityState getVisibilityState() {
        return this.visibilityState;
    }

    public final long getVisibilityEventTimeMs() {
        return this.visibilityEventTimeMs;
    }

    public final long getInvisibilityEventTimeMs() {
        return this.invisibilityEventTimeMs;
    }

    public final com.facebook.fresco.ui.common.DimensionsInfo getDimensionsInfo() {
        return this.dimensionsInfo;
    }

    public final com.facebook.fresco.ui.common.ControllerListener2.Extras getExtraData() {
        return this.extraData;
    }

    public final java.lang.String getCallingClassNameOnVisible() {
        return this.callingClassNameOnVisible;
    }

    public final java.lang.String getRootContextNameOnVisible() {
        return this.rootContextNameOnVisible;
    }

    public final java.lang.String[] getContextChainArrayOnVisible() {
        return this.contextChainArrayOnVisible;
    }

    public final java.lang.String getContextChainExtrasOnVisible() {
        return this.contextChainExtrasOnVisible;
    }

    public final java.lang.String getContentIdOnVisible() {
        return this.contentIdOnVisible;
    }

    public final java.lang.String getSurfaceOnVisible() {
        return this.surfaceOnVisible;
    }

    public final java.lang.String getSubSurfaceOnVisible() {
        return this.subSurfaceOnVisible;
    }

    public final java.lang.Long getMsSinceLastNavigationOnVisible() {
        return this.msSinceLastNavigationOnVisible;
    }

    public final java.lang.String getStartupStatusOnVisible() {
        return this.startupStatusOnVisible;
    }

    public final java.util.List<kotlin.Pair<java.lang.String, java.lang.Long>> getIntermediateImageSetTimes() {
        return this.intermediateImageSetTimes;
    }

    public final boolean getNewIntermediateImageSetPointAvailable() {
        return this.newIntermediateImageSetPointAvailable;
    }

    public final java.lang.String getErrorMessageOnFailure() {
        return this.errorMessageOnFailure;
    }

    public final java.lang.String getErrorStacktraceStringOnFailure() {
        return this.errorStacktraceStringOnFailure;
    }

    public final java.lang.Integer getErrorCodeOnFailure() {
        return this.errorCodeOnFailure;
    }

    public final java.lang.Integer getDensityDpiOnSuccess() {
        return this.densityDpiOnSuccess;
    }

    public final int getInstanceId() {
        return this.instanceId;
    }

    public final long getFinalImageLoadTimeMs() {
        long j = this.imageRequestEndTimeMs;
        if (j != -1) {
            long j2 = this.imageRequestStartTimeMs;
            if (j2 != -1) {
                return j - j2;
            }
        }
        return -1L;
    }

    public final java.lang.String createDebugString() {
        java.lang.String string = com.facebook.common.internal.Objects.toStringHelper(this).add("rendering Infra", this.infra).add("controller ID", this.controllerId).add("request ID", this.requestId).add("controller submit", this.controllerSubmitTimeMs).add("controller final image", this.controllerFinalImageSetTimeMs).add("controller failure", this.controllerFailureTimeMs).add("start time", this.imageRequestStartTimeMs).add("end time", this.imageRequestEndTimeMs).add("prefetch", this.isPrefetch).add("caller context", this.callerContext).add("image request", this.imageRequest).add("image info", this.imageInfo).add("on-screen width", this.onScreenWidthPx).add("on-screen height", this.onScreenHeightPx).add("visibility state", this.visibilityState).add("visibility event", this.visibilityEventTimeMs).add("invisibility event", this.invisibilityEventTimeMs).add("dimensions info", this.dimensionsInfo).add("extra data", this.extraData).toString();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
