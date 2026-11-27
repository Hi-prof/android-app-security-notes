package uts.sdk.modules.DCloudUniChooseMedia;

/* JADX INFO: compiled from: index.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000¢\u0001\n\u0000\n\u0002\u0010\u0004\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010$\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0013\u001a[\u0010%\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00132K\u0010&\u001aG\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b((\u0012\u0013\u0012\u00110)¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\f0'\u001ak\u0010,\u001a\u00020\f2\u0006\u0010(\u001a\u00020\u00012\u0006\u0010*\u001a\u00020)2\u0006\u0010-\u001a\u00020\u00032K\u0010&\u001aG\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b((\u0012\u0013\u0012\u00110)¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\f0'\u001a\u0016\u0010.\u001a\u00020\u00012\u000e\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u000100\u001a\u0016\u0010;\u001a\u00020\f2\u0006\u0010<\u001a\u00020\u00132\u0006\u0010*\u001a\u00020)\u001a\u0016\u0010@\u001a\u00020\f2\u0006\u0010<\u001a\u00020\u00132\u0006\u0010*\u001a\u00020)\u001a\u001e\u0010G\u001a\u00020\f2\u0006\u0010<\u001a\u00020\u00132\u0006\u0010(\u001a\u00020\u00012\u0006\u0010H\u001a\u00020\u0001\u001aR\u0010I\u001a\u00020\f2\u0006\u0010(\u001a\u00020\u00012\u0006\u0010H\u001a\u00020\u00012\u0006\u0010*\u001a\u00020)2\u000e\u0010J\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001002\b\u0010K\u001a\u0004\u0018\u00010\u00102\u000e\u0010L\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`M2\b\u0010N\u001a\u0004\u0018\u00010\u0003\u001a\u0018\u0010O\u001a\u0004\u0018\u00010P2\u0006\u0010Q\u001a\u00020\u00032\u0006\u0010R\u001a\u00020\u0001\u001a\u0018\u0010S\u001a\u0004\u0018\u00010P2\u0006\u0010Q\u001a\u00020\u00032\u0006\u0010R\u001a\u00020\u0001\u001a\u000e\u0010T\u001a\u00020U2\u0006\u0010Q\u001a\u00020\u0003\u001a\u000e\u0010V\u001a\u00020\u00032\u0006\u0010Q\u001a\u00020\u0003\u001a\u001a\u0010W\u001a\u0004\u0018\u00010X2\u0006\u0010Y\u001a\u00020\u00032\b\u0010Z\u001a\u0004\u0018\u00010\u0003\u001a\u0016\u0010[\u001a\u00020\f2\u0006\u0010\\\u001a\u00020\u00032\u0006\u0010]\u001a\u00020X\u001a\u001a\u0010^\u001a\u00020)2\b\u0010_\u001a\u0004\u0018\u00010`2\b\u0010Z\u001a\u0004\u0018\u00010\u0003\u001a\u0016\u0010a\u001a\u00020\u00012\u000e\u0010b\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`M\u001a\u0006\u0010c\u001a\u00020\u0003\u001a\u0016\u0010d\u001a\u00020)2\u0006\u0010e\u001a\u00020\u00032\u0006\u0010f\u001a\u00020\u0003\u001a\u000e\u0010g\u001a\u00020\u00012\u0006\u0010h\u001a\u00020\u0001\u001a\u000e\u0010i\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020j\"\u0014\u0010\u0015\u001a\u00020\u0003X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u001d\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00030\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0011\u0010\u001c\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017\"\u0014\u0010\u001e\u001a\u00020\u0003X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017\"0\u0010 \u001a!\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\f0\u0007j\u0002`!¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#\"c\u00101\u001aK\u0012\u0013\u0012\u001102¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(3\u0012\u0013\u0012\u001102¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(4\u0012\u0015\u0012\u0013\u0018\u000105¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(6\u0012\u0004\u0012\u00020\f\u0018\u00010'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:\"c\u0010=\u001aK\u0012\u0013\u0012\u001102¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(3\u0012\u0013\u0012\u001102¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(4\u0012\u0015\u0012\u0013\u0018\u000105¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(6\u0012\u0004\u0012\u00020\f\u0018\u00010'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u00108\"\u0004\b?\u0010:\"\u0011\u0010A\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\bB\u0010C\"c\u0010D\u001aK\u0012\u0013\u0012\u001102¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(3\u0012\u0013\u0012\u001102¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(4\u0012\u0015\u0012\u0013\u0018\u000105¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(6\u0012\u0004\u0012\u00020\f\u0018\u00010'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u00108\"\u0004\bF\u0010:*\n\u0010\u0000\"\u00020\u00012\u00020\u0001*\n\u0010\u0002\"\u00020\u00032\u00020\u0003*\n\u0010\u0004\"\u00020\u00052\u00020\u0005*@\u0010\u0006\"\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u00072\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007*S\u0010\r\"\u001d\u0012\u0013\u0012\u0011`\u000e¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u000720\u0012&\u0012$0\u0005j\u0011`\u000e¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007*@\u0010\u000f\"\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u00072\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007*\n\u0010\u0011\"\u00020\u00032\u00020\u0003*@\u0010\u0012\"\u001d\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\f0\u00072\u001d\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\f0\u0007¨\u0006k"}, d2 = {"ChooseMediaErrorCode", "", "ChooseMediaFileType", "", "ChooseMediaFail", "Luts/sdk/modules/DCloudUniChooseMedia/IChooseMediaError;", "ChooseMediaSuccessCallback", "Lkotlin/Function1;", "Luts/sdk/modules/DCloudUniChooseMedia/ChooseMediaSuccess;", "Lkotlin/ParameterName;", "name", com.taobao.weex.bridge.WXBridgeManager.METHOD_CALLBACK, "", "ChooseMediaFailCallback", "Luts/sdk/modules/DCloudUniChooseMedia/ChooseMediaFail;", "ChooseMediaCompleteCallback", "", "ChooseMediaPageOrientation", "ChooseMedia", "Luts/sdk/modules/DCloudUniChooseMedia/ChooseMediaOptions;", "options", "UniError_ChooseMedia", "getUniError_ChooseMedia", "()Ljava/lang/String;", "ChooseMediaUniErrors", "Lio/dcloud/uts/Map;", "getChooseMediaUniErrors", "()Lio/dcloud/uts/Map;", "mediaCachePath", "getMediaCachePath", "ASSETS_PATH", "getASSETS_PATH", "chooseMedia", "Luts/sdk/modules/DCloudUniChooseMedia/ChooseMedia;", "getChooseMedia", "()Lkotlin/jvm/functions/Function1;", "chooseMediaAll", "uniChooseMedia", "onSourceTypeSelect", "Lkotlin/Function3;", "count", "", "compressed", "index", "onMediaTypeSelect", io.dcloud.common.constant.AbsoluteConst.XML_ITEM, "getMediaType", "types", "Lio/dcloud/uts/UTSArray;", "takeVideoFunction", "", com.taobao.weex.common.WXModule.REQUEST_CODE, com.taobao.weex.common.WXModule.RESULT_CODE, "Landroid/content/Intent;", "data", "getTakeVideoFunction", "()Lkotlin/jvm/functions/Function3;", "setTakeVideoFunction", "(Lkotlin/jvm/functions/Function3;)V", "openCameraForMediaVideo", io.dcloud.common.constant.AbsoluteConst.JSON_KEY_OPTION, "takeCameraFunction", "getTakeCameraFunction", "setTakeCameraFunction", "openCameraForMediaImage", "GALLERY_MEDIA_PICKER_RESULT", "getGALLERY_MEDIA_PICKER_RESULT", "()Ljava/lang/Number;", "openMediaFunction", "getOpenMediaFunction", "setOpenMediaFunction", "openAlbumForMedia", "type", "openGalleryActivity", "sizeType", "crop", "pageOrientation", "Luts/sdk/modules/DCloudUniChooseMedia/ChooseMediaPageOrientation;", "useSystem", "getMediaFileByType", "Luts/sdk/modules/DCloudUniChooseMedia/ChooseMediaTempFile;", io.dcloud.common.constant.AbsoluteConst.XML_PATH, "mimeType", "getMediaTempFile", "getMediaInfo", "", "normalizeMediaPath", "getVideoMetadata", "Luts/sdk/modules/DCloudUniChooseMedia/VideoMetadata;", "src", "filePath", "fillVideoMetadataByExtractor", "reassignedPath", "videoInfo", "saveBitmapToLocalPath", "bitmap", "Landroid/graphics/Bitmap;", "getOrientation", "reassignedPageOrientation", "getGlobalConfig", "copyFile", "fromFilePath", "toFilePath", "formatNumber", "input", "chooseMediaByJs", "Luts/sdk/modules/DCloudUniChooseMedia/ChooseMediaOptionsJSONObject;", "uni-chooseMedia_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class IndexKt {
    private static final java.lang.String UniError_ChooseMedia = "uni-chooseMedia";
    private static kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super java.lang.Integer, ? super android.content.Intent, kotlin.Unit> openMediaFunction;
    private static kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super java.lang.Integer, ? super android.content.Intent, kotlin.Unit> takeCameraFunction;
    private static kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super java.lang.Integer, ? super android.content.Intent, kotlin.Unit> takeVideoFunction;
    private static final io.dcloud.uts.Map<java.lang.Number, java.lang.String> ChooseMediaUniErrors = new io.dcloud.uts.Map<>((io.dcloud.uts.UTSArray<io.dcloud.uts.UTSArray<java.lang.Object>>) io.dcloud.uts.UTSArrayKt._uA(io.dcloud.uts.UTSArrayKt._uA(1101001, "user cancel"), io.dcloud.uts.UTSArrayKt._uA(1101005, io.dcloud.common.constant.DOMException.MSG_NO_PERMISSION), io.dcloud.uts.UTSArrayKt._uA(1101006, "save error"), io.dcloud.uts.UTSArrayKt._uA(1101008, "camera error"), io.dcloud.uts.UTSArrayKt._uA(1101010, "unexpect error")));
    private static final java.lang.String mediaCachePath = io.dcloud.uts.UTSAndroid.INSTANCE.getAppCachePath() + "uni-media/";
    private static final java.lang.String ASSETS_PATH = "/android_asset/";
    private static final kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniChooseMedia.ChooseMediaOptions, kotlin.Unit> chooseMedia = new kotlin.jvm.functions.Function1() { // from class: uts.sdk.modules.DCloudUniChooseMedia.IndexKt$$ExternalSyntheticLambda10
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: invoke */
        public final java.lang.Object invoke2(java.lang.Object obj) {
            return uts.sdk.modules.DCloudUniChooseMedia.IndexKt.chooseMedia$lambda$0((uts.sdk.modules.DCloudUniChooseMedia.ChooseMediaOptions) obj);
        }
    };
    private static final java.lang.Number GALLERY_MEDIA_PICKER_RESULT = (java.lang.Number) 1004;

    public static final java.lang.String getUniError_ChooseMedia() {
        return UniError_ChooseMedia;
    }

    public static final io.dcloud.uts.Map<java.lang.Number, java.lang.String> getChooseMediaUniErrors() {
        return ChooseMediaUniErrors;
    }

    public static final java.lang.String getMediaCachePath() {
        return mediaCachePath;
    }

    public static final java.lang.String getASSETS_PATH() {
        return ASSETS_PATH;
    }

    public static final kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniChooseMedia.ChooseMediaOptions, kotlin.Unit> getChooseMedia() {
        return chooseMedia;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit chooseMedia$lambda$0(uts.sdk.modules.DCloudUniChooseMedia.ChooseMediaOptions chooseMediaOptions) {
        chooseMediaAll(chooseMediaOptions);
        return kotlin.Unit.INSTANCE;
    }

    public static final void chooseMediaAll(final uts.sdk.modules.DCloudUniChooseMedia.ChooseMediaOptions options) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(options, "options");
        uniChooseMedia(options, new kotlin.jvm.functions.Function3() { // from class: uts.sdk.modules.DCloudUniChooseMedia.IndexKt$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function3
            public final java.lang.Object invoke(java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3) {
                return uts.sdk.modules.DCloudUniChooseMedia.IndexKt.chooseMediaAll$lambda$5(options, (java.lang.Number) obj, ((java.lang.Boolean) obj2).booleanValue(), (java.lang.Number) obj3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:10:0x004c  */
    public static final kotlin.Unit chooseMediaAll$lambda$5(final uts.sdk.modules.DCloudUniChooseMedia.ChooseMediaOptions chooseMediaOptions, final java.lang.Number number, final boolean z, final java.lang.Number number2) {
        if (io.dcloud.uts.NumberKt.numberEquals(number2, 1)) {
            if (android.os.Build.VERSION.SDK_INT <= 32) {
                android.app.Activity uniActivity = io.dcloud.uts.UTSAndroid.INSTANCE.getUniActivity();
                kotlin.jvm.internal.Intrinsics.checkNotNull(uniActivity);
                if (uniActivity.getApplicationInfo().targetSdkVersion >= 33) {
                    openAlbumForMedia(chooseMediaOptions, number, getMediaType(chooseMediaOptions.getMediaType()));
                } else {
                    io.dcloud.uts.UTSAndroid uTSAndroid = io.dcloud.uts.UTSAndroid.INSTANCE;
                    android.app.Activity uniActivity2 = io.dcloud.uts.UTSAndroid.INSTANCE.getUniActivity();
                    kotlin.jvm.internal.Intrinsics.checkNotNull(uniActivity2);
                    uTSAndroid.requestSystemPermission(uniActivity2, io.dcloud.uts.UTSArrayKt._uA(com.hjq.permissions.Permission.READ_EXTERNAL_STORAGE), new kotlin.jvm.functions.Function2() { // from class: uts.sdk.modules.DCloudUniChooseMedia.IndexKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final java.lang.Object invoke(java.lang.Object obj, java.lang.Object obj2) {
                            return uts.sdk.modules.DCloudUniChooseMedia.IndexKt.chooseMediaAll$lambda$5$lambda$1(chooseMediaOptions, number, ((java.lang.Boolean) obj).booleanValue(), (io.dcloud.uts.UTSArray) obj2);
                        }
                    }, new kotlin.jvm.functions.Function2() { // from class: uts.sdk.modules.DCloudUniChooseMedia.IndexKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final java.lang.Object invoke(java.lang.Object obj, java.lang.Object obj2) {
                            return uts.sdk.modules.DCloudUniChooseMedia.IndexKt.chooseMediaAll$lambda$5$lambda$2(chooseMediaOptions, ((java.lang.Boolean) obj).booleanValue(), (io.dcloud.uts.UTSArray) obj2);
                        }
                    }, (16 & 16) != 0 ? false : false);
                }
            } else {
                openAlbumForMedia(chooseMediaOptions, number, getMediaType(chooseMediaOptions.getMediaType()));
            }
        } else if (android.os.Build.VERSION.SDK_INT >= 23) {
            io.dcloud.uts.UTSArray uTSArray_uA = io.dcloud.uts.UTSArrayKt._uA(com.hjq.permissions.Permission.CAMERA);
            kotlin.jvm.internal.Intrinsics.checkNotNull(uTSArray_uA, "null cannot be cast to non-null type io.dcloud.uts.UTSArray<kotlin.String>");
            io.dcloud.uts.UTSAndroid uTSAndroid2 = io.dcloud.uts.UTSAndroid.INSTANCE;
            android.app.Activity uniActivity3 = io.dcloud.uts.UTSAndroid.INSTANCE.getUniActivity();
            kotlin.jvm.internal.Intrinsics.checkNotNull(uniActivity3);
            uTSAndroid2.requestSystemPermission(uniActivity3, uTSArray_uA, new kotlin.jvm.functions.Function2() { // from class: uts.sdk.modules.DCloudUniChooseMedia.IndexKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final java.lang.Object invoke(java.lang.Object obj, java.lang.Object obj2) {
                    return uts.sdk.modules.DCloudUniChooseMedia.IndexKt.chooseMediaAll$lambda$5$lambda$3(number2, chooseMediaOptions, z, ((java.lang.Boolean) obj).booleanValue(), (io.dcloud.uts.UTSArray) obj2);
                }
            }, new kotlin.jvm.functions.Function2() { // from class: uts.sdk.modules.DCloudUniChooseMedia.IndexKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final java.lang.Object invoke(java.lang.Object obj, java.lang.Object obj2) {
                    return uts.sdk.modules.DCloudUniChooseMedia.IndexKt.chooseMediaAll$lambda$5$lambda$4(chooseMediaOptions, ((java.lang.Boolean) obj).booleanValue(), (io.dcloud.uts.UTSArray) obj2);
                }
            }, (16 & 16) != 0 ? false : false);
        } else if (io.dcloud.uts.NumberKt.numberEquals(number2, 0)) {
            openCameraForMediaImage(chooseMediaOptions, z);
        } else if (io.dcloud.uts.NumberKt.numberEquals(number2, 2)) {
            openCameraForMediaVideo(chooseMediaOptions, z);
        }
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit chooseMediaAll$lambda$5$lambda$1(uts.sdk.modules.DCloudUniChooseMedia.ChooseMediaOptions chooseMediaOptions, java.lang.Number number, boolean z, io.dcloud.uts.UTSArray<java.lang.String> uTSArray) {
        openAlbumForMedia(chooseMediaOptions, number, getMediaType(chooseMediaOptions.getMediaType()));
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit chooseMediaAll$lambda$5$lambda$2(uts.sdk.modules.DCloudUniChooseMedia.ChooseMediaOptions chooseMediaOptions, boolean z, io.dcloud.uts.UTSArray<java.lang.String> uTSArray) {
        uts.sdk.modules.DCloudUniChooseMedia.ChooseMediaErrorImpl chooseMediaErrorImpl = new uts.sdk.modules.DCloudUniChooseMedia.ChooseMediaErrorImpl((java.lang.Number) 1101005, UniError_ChooseMedia);
        kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniChooseMedia.IChooseMediaError, kotlin.Unit> fail = chooseMediaOptions.getFail();
        if (fail != null) {
            fail.invoke2(chooseMediaErrorImpl);
        }
        kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> complete = chooseMediaOptions.getComplete();
        if (complete != null) {
            complete.invoke2(chooseMediaErrorImpl);
        }
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit chooseMediaAll$lambda$5$lambda$3(java.lang.Number number, uts.sdk.modules.DCloudUniChooseMedia.ChooseMediaOptions chooseMediaOptions, boolean z, boolean z2, io.dcloud.uts.UTSArray<java.lang.String> uTSArray) {
        if (io.dcloud.uts.NumberKt.numberEquals(number, 0)) {
            openCameraForMediaImage(chooseMediaOptions, z);
        } else if (io.dcloud.uts.NumberKt.numberEquals(number, 2)) {
            openCameraForMediaVideo(chooseMediaOptions, z);
        }
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit chooseMediaAll$lambda$5$lambda$4(uts.sdk.modules.DCloudUniChooseMedia.ChooseMediaOptions chooseMediaOptions, boolean z, io.dcloud.uts.UTSArray<java.lang.String> uTSArray) {
        uts.sdk.modules.DCloudUniChooseMedia.ChooseMediaErrorImpl chooseMediaErrorImpl = new uts.sdk.modules.DCloudUniChooseMedia.ChooseMediaErrorImpl((java.lang.Number) 1101005, UniError_ChooseMedia);
        kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniChooseMedia.IChooseMediaError, kotlin.Unit> fail = chooseMediaOptions.getFail();
        if (fail != null) {
            fail.invoke2(chooseMediaErrorImpl);
        }
        kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> complete = chooseMediaOptions.getComplete();
        if (complete != null) {
            complete.invoke2(chooseMediaErrorImpl);
        }
        return kotlin.Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x006d  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [T, io.dcloud.uts.UTSArray] */
    /* JADX WARN: Type inference failed for: r6v11, types: [T, io.dcloud.uts.UTSArray] */
    /* JADX WARN: Type inference failed for: r6v13, types: [T, io.dcloud.uts.UTSArray] */
    /* JADX WARN: Type inference failed for: r6v15, types: [T, io.dcloud.uts.UTSArray] */
    /* JADX WARN: Type inference failed for: r6v7, types: [T, io.dcloud.uts.UTSArray] */
    /* JADX WARN: Type inference failed for: r6v9, types: [T, io.dcloud.uts.UTSArray] */
    public static final void uniChooseMedia(final uts.sdk.modules.DCloudUniChooseMedia.ChooseMediaOptions options, final kotlin.jvm.functions.Function3<? super java.lang.Number, ? super java.lang.Boolean, ? super java.lang.Number, kotlin.Unit> onSourceTypeSelect) {
        T t;
        io.dcloud.uts.UTSArray<java.lang.String> uTSArray_uA;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(options, "options");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(onSourceTypeSelect, "onSourceTypeSelect");
        final kotlin.jvm.internal.Ref.ObjectRef objectRef = new kotlin.jvm.internal.Ref.ObjectRef();
        if (options.getCount() != null) {
            java.lang.Number count = options.getCount();
            kotlin.jvm.internal.Intrinsics.checkNotNull(count);
            if (io.dcloud.uts.NumberKt.compareTo(count, (java.lang.Number) 0) <= 0) {
                t = (java.lang.Number) 9;
            } else {
                java.lang.Number count2 = options.getCount();
                kotlin.jvm.internal.Intrinsics.checkNotNull(count2);
                t = count2;
            }
        } else {
            t = (java.lang.Number) 9;
        }
        objectRef.element = t;
        final kotlin.jvm.internal.Ref.BooleanRef booleanRef = new kotlin.jvm.internal.Ref.BooleanRef();
        if (options.getSourceType() != null) {
            io.dcloud.uts.UTSArray<java.lang.String> sourceType = options.getSourceType();
            kotlin.jvm.internal.Intrinsics.checkNotNull(sourceType);
            if (io.dcloud.uts.NumberKt.compareTo(sourceType.getLength(), (java.lang.Number) 0) > 0) {
                uTSArray_uA = options.getSourceType();
                kotlin.jvm.internal.Intrinsics.checkNotNull(uTSArray_uA);
            } else {
                uTSArray_uA = io.dcloud.uts.UTSArrayKt._uA("album", "camera");
            }
        } else {
            uTSArray_uA = io.dcloud.uts.UTSArrayKt._uA("album", "camera");
        }
        io.dcloud.uts.UTSArray<java.lang.String> mediaType = options.getMediaType();
        if (mediaType == null) {
            mediaType = io.dcloud.uts.UTSArrayKt._uA("image", "video");
        }
        final kotlin.jvm.internal.Ref.ObjectRef objectRef2 = new kotlin.jvm.internal.Ref.ObjectRef();
        objectRef2.element = new io.dcloud.uts.UTSArray();
        if (uTSArray_uA.contains("camera")) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(mediaType);
            if (mediaType.contains("mix")) {
                objectRef2.element = io.dcloud.uts.UTSArrayKt._uA("拍摄", "录像");
            } else if (mediaType.contains("image") && mediaType.contains("video")) {
                objectRef2.element = io.dcloud.uts.UTSArrayKt._uA("拍摄", "录像");
            } else if (mediaType.contains("image")) {
                objectRef2.element = io.dcloud.uts.UTSArrayKt._uA("拍摄");
            } else if (mediaType.contains("video")) {
                objectRef2.element = io.dcloud.uts.UTSArrayKt._uA("录像");
            } else {
                objectRef2.element = io.dcloud.uts.UTSArrayKt._uA("拍摄", "录像");
            }
        }
        if (uTSArray_uA.contains("album")) {
            ((io.dcloud.uts.UTSArray) objectRef2.element).add("从相册选择");
        }
        if (io.dcloud.uts.NumberKt.numberEquals(((io.dcloud.uts.UTSArray) objectRef2.element).getLength(), 1)) {
            T t2 = objectRef.element;
            kotlin.jvm.internal.Intrinsics.checkNotNull(t2);
            boolean z = booleanRef.element;
            E e = ((io.dcloud.uts.UTSArray) objectRef2.element).get(0);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(e, "get(...)");
            onMediaTypeSelect((java.lang.Number) t2, z, (java.lang.String) e, onSourceTypeSelect);
            return;
        }
        if (io.dcloud.uts.NumberKt.compareTo(((io.dcloud.uts.UTSArray) objectRef2.element).getLength(), (java.lang.Number) 1) > 0) {
            io.dcloud.uniapp.extapi.UniPromptKt.getShowActionSheet().invoke2(new uts.sdk.modules.DCloudUniPrompt.ShowActionSheetOptions(null, null, (io.dcloud.uts.UTSArray) objectRef2.element, null, null, new kotlin.jvm.functions.Function1() { // from class: uts.sdk.modules.DCloudUniChooseMedia.IndexKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: invoke */
                public final java.lang.Object invoke2(java.lang.Object obj) {
                    return uts.sdk.modules.DCloudUniChooseMedia.IndexKt.uniChooseMedia$lambda$6(objectRef, booleanRef, objectRef2, onSourceTypeSelect, (uts.sdk.modules.DCloudUniPrompt.ShowActionSheetSuccess) obj);
                }
            }, new kotlin.jvm.functions.Function1() { // from class: uts.sdk.modules.DCloudUniChooseMedia.IndexKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: invoke */
                public final java.lang.Object invoke2(java.lang.Object obj) {
                    return uts.sdk.modules.DCloudUniChooseMedia.IndexKt.uniChooseMedia$lambda$7(options, (uts.sdk.modules.DCloudUniPrompt.IPromptError) obj);
                }
            }, null, 155, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit uniChooseMedia$lambda$6(kotlin.jvm.internal.Ref.ObjectRef<java.lang.Number> objectRef, kotlin.jvm.internal.Ref.BooleanRef booleanRef, kotlin.jvm.internal.Ref.ObjectRef<io.dcloud.uts.UTSArray<java.lang.String>> objectRef2, kotlin.jvm.functions.Function3<? super java.lang.Number, ? super java.lang.Boolean, ? super java.lang.Number, kotlin.Unit> function3, uts.sdk.modules.DCloudUniPrompt.ShowActionSheetSuccess showActionSheetSuccess) {
        java.lang.Number number = objectRef.element;
        kotlin.jvm.internal.Intrinsics.checkNotNull(number);
        boolean z = booleanRef.element;
        io.dcloud.uts.UTSArray<java.lang.String> uTSArray = objectRef2.element;
        java.lang.Number tapIndex = showActionSheetSuccess.getTapIndex();
        kotlin.jvm.internal.Intrinsics.checkNotNull(tapIndex);
        onMediaTypeSelect(number, z, uTSArray.get(tapIndex), function3);
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit uniChooseMedia$lambda$7(uts.sdk.modules.DCloudUniChooseMedia.ChooseMediaOptions chooseMediaOptions, uts.sdk.modules.DCloudUniPrompt.IPromptError iPromptError) {
        uts.sdk.modules.DCloudUniChooseMedia.ChooseMediaErrorImpl chooseMediaErrorImpl = new uts.sdk.modules.DCloudUniChooseMedia.ChooseMediaErrorImpl((java.lang.Number) 1101001, UniError_ChooseMedia);
        kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniChooseMedia.IChooseMediaError, kotlin.Unit> fail = chooseMediaOptions.getFail();
        if (fail != null) {
            fail.invoke2(chooseMediaErrorImpl);
        }
        kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> complete = chooseMediaOptions.getComplete();
        if (complete != null) {
            complete.invoke2(chooseMediaErrorImpl);
        }
        return kotlin.Unit.INSTANCE;
    }

    public static final void onMediaTypeSelect(java.lang.Number count, boolean z, java.lang.String item, kotlin.jvm.functions.Function3<? super java.lang.Number, ? super java.lang.Boolean, ? super java.lang.Number, kotlin.Unit> onSourceTypeSelect) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(count, "count");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(item, "item");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(onSourceTypeSelect, "onSourceTypeSelect");
        int iHashCode = item.hashCode();
        if (iHashCode == -1915178910) {
            if (item.equals("从相册选择")) {
                onSourceTypeSelect.invoke(count, java.lang.Boolean.valueOf(z), 1);
            }
        } else if (iHashCode == 777242) {
            if (item.equals("录像")) {
                onSourceTypeSelect.invoke(count, java.lang.Boolean.valueOf(z), 2);
            }
        } else if (iHashCode == 809751 && item.equals("拍摄")) {
            onSourceTypeSelect.invoke(count, java.lang.Boolean.valueOf(z), 0);
        }
    }

    public static final java.lang.Number getMediaType(io.dcloud.uts.UTSArray<java.lang.String> uTSArray) {
        if (uTSArray == null) {
            return (java.lang.Number) 101;
        }
        java.lang.String string = uTSArray.toString();
        java.util.Locale ENGLISH = java.util.Locale.ENGLISH;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
        java.lang.String lowerCase = string.toLowerCase(ENGLISH);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        java.lang.String str = lowerCase;
        if (kotlin.text.StringsKt.contains$default((java.lang.CharSequence) str, (java.lang.CharSequence) "mix", false, 2, (java.lang.Object) null)) {
            return (java.lang.Number) 101;
        }
        if (kotlin.text.StringsKt.contains$default((java.lang.CharSequence) str, (java.lang.CharSequence) "image", false, 2, (java.lang.Object) null) && kotlin.text.StringsKt.contains$default((java.lang.CharSequence) str, (java.lang.CharSequence) "video", false, 2, (java.lang.Object) null)) {
            return (java.lang.Number) 101;
        }
        if (kotlin.text.StringsKt.contains$default((java.lang.CharSequence) str, (java.lang.CharSequence) "image", false, 2, (java.lang.Object) null)) {
            return (java.lang.Number) 100;
        }
        if (kotlin.text.StringsKt.contains$default((java.lang.CharSequence) str, (java.lang.CharSequence) "video", false, 2, (java.lang.Object) null)) {
            return (java.lang.Number) 102;
        }
        return (java.lang.Number) 101;
    }

    public static final kotlin.jvm.functions.Function3<java.lang.Integer, java.lang.Integer, android.content.Intent, kotlin.Unit> getTakeVideoFunction() {
        return takeVideoFunction;
    }

    public static final void setTakeVideoFunction(kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super java.lang.Integer, ? super android.content.Intent, kotlin.Unit> function3) {
        takeVideoFunction = function3;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x00fe A[Catch: Exception -> 0x0110, TryCatch #0 {Exception -> 0x0110, blocks: (B:6:0x003c, B:8:0x005a, B:9:0x0065, B:11:0x00c1, B:13:0x00d4, B:14:0x00e2, B:17:0x00ea, B:19:0x00f9, B:21:0x0101, B:23:0x0109, B:20:0x00fe), top: B:26:0x003c }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v3, types: [T, java.io.File] */
    public static final void openCameraForMediaVideo(final uts.sdk.modules.DCloudUniChooseMedia.ChooseMediaOptions option, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(option, "option");
        final java.lang.Integer num = (java.lang.Number) 23;
        if (takeVideoFunction != null) {
            io.dcloud.uts.UTSAndroid uTSAndroid = io.dcloud.uts.UTSAndroid.INSTANCE;
            kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super java.lang.Integer, ? super android.content.Intent, kotlin.Unit> function3 = takeVideoFunction;
            kotlin.jvm.internal.Intrinsics.checkNotNull(function3);
            uTSAndroid.offAppActivityResult(function3);
        }
        final kotlin.jvm.internal.Ref.ObjectRef objectRef = new kotlin.jvm.internal.Ref.ObjectRef();
        objectRef.element = mediaCachePath + java.lang.System.currentTimeMillis() + ".mp4";
        try {
            final kotlin.jvm.internal.Ref.ObjectRef objectRef2 = new kotlin.jvm.internal.Ref.ObjectRef();
            objectRef2.element = new java.io.File((java.lang.String) objectRef.element);
            if (!((java.io.File) objectRef2.element).getParentFile().exists()) {
                ((java.io.File) objectRef2.element).getParentFile().mkdirs();
            }
            takeVideoFunction = new kotlin.jvm.functions.Function3() { // from class: uts.sdk.modules.DCloudUniChooseMedia.IndexKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function3
                public final java.lang.Object invoke(java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3) {
                    return uts.sdk.modules.DCloudUniChooseMedia.IndexKt.openCameraForMediaVideo$lambda$8(num, objectRef2, objectRef, option, ((java.lang.Integer) obj).intValue(), ((java.lang.Integer) obj2).intValue(), (android.content.Intent) obj3);
                }
            };
            io.dcloud.uts.UTSAndroid uTSAndroid2 = io.dcloud.uts.UTSAndroid.INSTANCE;
            kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super java.lang.Integer, ? super android.content.Intent, kotlin.Unit> function4 = takeVideoFunction;
            kotlin.jvm.internal.Intrinsics.checkNotNull(function4);
            uTSAndroid2.onAppActivityResult(function4);
            android.app.Activity uniActivity = io.dcloud.uts.UTSAndroid.INSTANCE.getUniActivity();
            kotlin.jvm.internal.Intrinsics.checkNotNull(uniActivity);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            android.app.Activity uniActivity2 = io.dcloud.uts.UTSAndroid.INSTANCE.getUniActivity();
            kotlin.jvm.internal.Intrinsics.checkNotNull(uniActivity2);
            sb.append(uniActivity2.getPackageName());
            sb.append(".dc.fileprovider");
            android.net.Uri uriForFile = androidx.core.content.FileProvider.getUriForFile(uniActivity, sb.toString(), (java.io.File) objectRef2.element);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(uriForFile, "getUriForFile(...)");
            android.content.Intent intent = new android.content.Intent("android.media.action.VIDEO_CAPTURE");
            intent.putExtra("output", uriForFile);
            if (option.getMaxDuration() != null) {
                java.lang.Number maxDuration = option.getMaxDuration();
                kotlin.jvm.internal.Intrinsics.checkNotNull(maxDuration);
                if (io.dcloud.uts.NumberKt.compareTo(maxDuration, (java.lang.Number) 0) > 0) {
                    java.lang.Number maxDuration2 = option.getMaxDuration();
                    kotlin.jvm.internal.Intrinsics.checkNotNull(maxDuration2);
                    intent.putExtra("android.intent.extra.durationLimit", maxDuration2);
                }
            }
            if (option.getCamera() != null) {
                java.lang.String camera = option.getCamera();
                kotlin.jvm.internal.Intrinsics.checkNotNull(camera);
                if (kotlin.jvm.internal.Intrinsics.areEqual(camera, "front")) {
                    intent.putExtra("android.intent.extras.CAMERA_FACING", 1);
                } else {
                    intent.putExtra("android.intent.extras.CAMERA_FACING", 0);
                }
            } else {
                intent.putExtra("android.intent.extras.CAMERA_FACING", 0);
            }
            android.app.Activity uniActivity3 = io.dcloud.uts.UTSAndroid.INSTANCE.getUniActivity();
            if (uniActivity3 != null) {
                uniActivity3.startActivityForResult(intent, num.intValue());
            }
        } catch (java.lang.Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit openCameraForMediaVideo$lambda$8(java.lang.Number number, kotlin.jvm.internal.Ref.ObjectRef<java.io.File> objectRef, kotlin.jvm.internal.Ref.ObjectRef<java.lang.String> objectRef2, uts.sdk.modules.DCloudUniChooseMedia.ChooseMediaOptions chooseMediaOptions, int i, int i2, android.content.Intent intent) {
        if (io.dcloud.uts.NumberKt.numberEquals(number, java.lang.Integer.valueOf(i))) {
            io.dcloud.uts.UTSAndroid uTSAndroid = io.dcloud.uts.UTSAndroid.INSTANCE;
            kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super java.lang.Integer, ? super android.content.Intent, kotlin.Unit> function3 = takeVideoFunction;
            kotlin.jvm.internal.Intrinsics.checkNotNull(function3);
            uTSAndroid.offAppActivityResult(function3);
            if (i2 == -1) {
                if (objectRef.element.exists()) {
                    uts.sdk.modules.DCloudUniChooseMedia.ChooseMediaTempFile mediaFileByType = getMediaFileByType(objectRef2.element, (java.lang.Number) 3);
                    if (mediaFileByType != null) {
                        uts.sdk.modules.DCloudUniChooseMedia.ChooseMediaSuccess chooseMediaSuccess = new uts.sdk.modules.DCloudUniChooseMedia.ChooseMediaSuccess(io.dcloud.uts.UTSArrayKt._uA(mediaFileByType), "video");
                        kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniChooseMedia.ChooseMediaSuccess, kotlin.Unit> success = chooseMediaOptions.getSuccess();
                        if (success != null) {
                            success.invoke2(chooseMediaSuccess);
                        }
                        kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> complete = chooseMediaOptions.getComplete();
                        if (complete != null) {
                            complete.invoke2(chooseMediaSuccess);
                        }
                    } else {
                        uts.sdk.modules.DCloudUniChooseMedia.ChooseMediaErrorImpl chooseMediaErrorImpl = new uts.sdk.modules.DCloudUniChooseMedia.ChooseMediaErrorImpl((java.lang.Number) 1101001, UniError_ChooseMedia);
                        kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniChooseMedia.IChooseMediaError, kotlin.Unit> fail = chooseMediaOptions.getFail();
                        if (fail != null) {
                            fail.invoke2(chooseMediaErrorImpl);
                        }
                        kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> complete2 = chooseMediaOptions.getComplete();
                        if (complete2 != null) {
                            complete2.invoke2(chooseMediaErrorImpl);
                        }
                    }
                } else {
                    uts.sdk.modules.DCloudUniChooseMedia.ChooseMediaErrorImpl chooseMediaErrorImpl2 = new uts.sdk.modules.DCloudUniChooseMedia.ChooseMediaErrorImpl((java.lang.Number) 1101008, UniError_ChooseMedia);
                    kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniChooseMedia.IChooseMediaError, kotlin.Unit> fail2 = chooseMediaOptions.getFail();
                    if (fail2 != null) {
                        fail2.invoke2(chooseMediaErrorImpl2);
                    }
                    kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> complete3 = chooseMediaOptions.getComplete();
                    if (complete3 != null) {
                        complete3.invoke2(chooseMediaErrorImpl2);
                    }
                }
            } else {
                uts.sdk.modules.DCloudUniChooseMedia.ChooseMediaErrorImpl chooseMediaErrorImpl3 = new uts.sdk.modules.DCloudUniChooseMedia.ChooseMediaErrorImpl((java.lang.Number) 1101001, UniError_ChooseMedia);
                kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniChooseMedia.IChooseMediaError, kotlin.Unit> fail3 = chooseMediaOptions.getFail();
                if (fail3 != null) {
                    fail3.invoke2(chooseMediaErrorImpl3);
                }
                kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> complete4 = chooseMediaOptions.getComplete();
                if (complete4 != null) {
                    complete4.invoke2(chooseMediaErrorImpl3);
                }
            }
            takeVideoFunction = null;
        }
        return kotlin.Unit.INSTANCE;
    }

    public static final kotlin.jvm.functions.Function3<java.lang.Integer, java.lang.Integer, android.content.Intent, kotlin.Unit> getTakeCameraFunction() {
        return takeCameraFunction;
    }

    public static final void setTakeCameraFunction(kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super java.lang.Integer, ? super android.content.Intent, kotlin.Unit> function3) {
        takeCameraFunction = function3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v3, types: [T, java.io.File] */
    public static final void openCameraForMediaImage(final uts.sdk.modules.DCloudUniChooseMedia.ChooseMediaOptions option, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(option, "option");
        final java.lang.Integer num = (java.lang.Number) 24;
        if (takeCameraFunction != null) {
            io.dcloud.uts.UTSAndroid uTSAndroid = io.dcloud.uts.UTSAndroid.INSTANCE;
            kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super java.lang.Integer, ? super android.content.Intent, kotlin.Unit> function3 = takeCameraFunction;
            kotlin.jvm.internal.Intrinsics.checkNotNull(function3);
            uTSAndroid.offAppActivityResult(function3);
        }
        final kotlin.jvm.internal.Ref.ObjectRef objectRef = new kotlin.jvm.internal.Ref.ObjectRef();
        objectRef.element = mediaCachePath + java.lang.System.currentTimeMillis() + ".jpg";
        try {
            final kotlin.jvm.internal.Ref.ObjectRef objectRef2 = new kotlin.jvm.internal.Ref.ObjectRef();
            objectRef2.element = new java.io.File((java.lang.String) objectRef.element);
            if (!((java.io.File) objectRef2.element).getParentFile().exists()) {
                ((java.io.File) objectRef2.element).getParentFile().mkdirs();
            }
            takeCameraFunction = new kotlin.jvm.functions.Function3() { // from class: uts.sdk.modules.DCloudUniChooseMedia.IndexKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function3
                public final java.lang.Object invoke(java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3) {
                    return uts.sdk.modules.DCloudUniChooseMedia.IndexKt.openCameraForMediaImage$lambda$9(num, objectRef2, objectRef, option, ((java.lang.Integer) obj).intValue(), ((java.lang.Integer) obj2).intValue(), (android.content.Intent) obj3);
                }
            };
            io.dcloud.uts.UTSAndroid uTSAndroid2 = io.dcloud.uts.UTSAndroid.INSTANCE;
            kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super java.lang.Integer, ? super android.content.Intent, kotlin.Unit> function4 = takeCameraFunction;
            kotlin.jvm.internal.Intrinsics.checkNotNull(function4);
            uTSAndroid2.onAppActivityResult(function4);
            android.app.Activity uniActivity = io.dcloud.uts.UTSAndroid.INSTANCE.getUniActivity();
            kotlin.jvm.internal.Intrinsics.checkNotNull(uniActivity);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            android.app.Activity uniActivity2 = io.dcloud.uts.UTSAndroid.INSTANCE.getUniActivity();
            kotlin.jvm.internal.Intrinsics.checkNotNull(uniActivity2);
            sb.append(uniActivity2.getPackageName());
            sb.append(".dc.fileprovider");
            android.net.Uri uriForFile = androidx.core.content.FileProvider.getUriForFile(uniActivity, sb.toString(), (java.io.File) objectRef2.element);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(uriForFile, "getUriForFile(...)");
            android.content.Intent intent = new android.content.Intent("android.media.action.IMAGE_CAPTURE");
            intent.putExtra("output", uriForFile);
            android.app.Activity uniActivity3 = io.dcloud.uts.UTSAndroid.INSTANCE.getUniActivity();
            if (uniActivity3 != null) {
                uniActivity3.startActivityForResult(intent, num.intValue());
            }
        } catch (java.lang.Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit openCameraForMediaImage$lambda$9(java.lang.Number number, kotlin.jvm.internal.Ref.ObjectRef<java.io.File> objectRef, kotlin.jvm.internal.Ref.ObjectRef<java.lang.String> objectRef2, uts.sdk.modules.DCloudUniChooseMedia.ChooseMediaOptions chooseMediaOptions, int i, int i2, android.content.Intent intent) {
        if (io.dcloud.uts.NumberKt.numberEquals(number, java.lang.Integer.valueOf(i))) {
            io.dcloud.uts.UTSAndroid uTSAndroid = io.dcloud.uts.UTSAndroid.INSTANCE;
            kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super java.lang.Integer, ? super android.content.Intent, kotlin.Unit> function3 = takeCameraFunction;
            kotlin.jvm.internal.Intrinsics.checkNotNull(function3);
            uTSAndroid.offAppActivityResult(function3);
            if (i2 == -1) {
                if (objectRef.element.exists()) {
                    uts.sdk.modules.DCloudUniChooseMedia.ChooseMediaTempFile mediaFileByType = getMediaFileByType(objectRef2.element, (java.lang.Number) 1);
                    if (mediaFileByType != null) {
                        uts.sdk.modules.DCloudUniChooseMedia.ChooseMediaSuccess chooseMediaSuccess = new uts.sdk.modules.DCloudUniChooseMedia.ChooseMediaSuccess(io.dcloud.uts.UTSArrayKt._uA(mediaFileByType), "image");
                        kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniChooseMedia.ChooseMediaSuccess, kotlin.Unit> success = chooseMediaOptions.getSuccess();
                        if (success != null) {
                            success.invoke2(chooseMediaSuccess);
                        }
                        kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> complete = chooseMediaOptions.getComplete();
                        if (complete != null) {
                            complete.invoke2(chooseMediaSuccess);
                        }
                    } else {
                        uts.sdk.modules.DCloudUniChooseMedia.ChooseMediaErrorImpl chooseMediaErrorImpl = new uts.sdk.modules.DCloudUniChooseMedia.ChooseMediaErrorImpl((java.lang.Number) 1101001, UniError_ChooseMedia);
                        kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniChooseMedia.IChooseMediaError, kotlin.Unit> fail = chooseMediaOptions.getFail();
                        if (fail != null) {
                            fail.invoke2(chooseMediaErrorImpl);
                        }
                        kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> complete2 = chooseMediaOptions.getComplete();
                        if (complete2 != null) {
                            complete2.invoke2(chooseMediaErrorImpl);
                        }
                    }
                } else {
                    uts.sdk.modules.DCloudUniChooseMedia.ChooseMediaErrorImpl chooseMediaErrorImpl2 = new uts.sdk.modules.DCloudUniChooseMedia.ChooseMediaErrorImpl((java.lang.Number) 1101008, UniError_ChooseMedia);
                    kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniChooseMedia.IChooseMediaError, kotlin.Unit> fail2 = chooseMediaOptions.getFail();
                    if (fail2 != null) {
                        fail2.invoke2(chooseMediaErrorImpl2);
                    }
                    kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> complete3 = chooseMediaOptions.getComplete();
                    if (complete3 != null) {
                        complete3.invoke2(chooseMediaErrorImpl2);
                    }
                }
            } else {
                uts.sdk.modules.DCloudUniChooseMedia.ChooseMediaErrorImpl chooseMediaErrorImpl3 = new uts.sdk.modules.DCloudUniChooseMedia.ChooseMediaErrorImpl((java.lang.Number) 1101001, UniError_ChooseMedia);
                kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniChooseMedia.IChooseMediaError, kotlin.Unit> fail3 = chooseMediaOptions.getFail();
                if (fail3 != null) {
                    fail3.invoke2(chooseMediaErrorImpl3);
                }
                kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> complete4 = chooseMediaOptions.getComplete();
                if (complete4 != null) {
                    complete4.invoke2(chooseMediaErrorImpl3);
                }
            }
            takeCameraFunction = null;
        }
        return kotlin.Unit.INSTANCE;
    }

    public static final java.lang.Number getGALLERY_MEDIA_PICKER_RESULT() {
        return GALLERY_MEDIA_PICKER_RESULT;
    }

    public static final kotlin.jvm.functions.Function3<java.lang.Integer, java.lang.Integer, android.content.Intent, kotlin.Unit> getOpenMediaFunction() {
        return openMediaFunction;
    }

    public static final void setOpenMediaFunction(kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super java.lang.Integer, ? super android.content.Intent, kotlin.Unit> function3) {
        openMediaFunction = function3;
    }

    public static final void openAlbumForMedia(final uts.sdk.modules.DCloudUniChooseMedia.ChooseMediaOptions option, java.lang.Number count, java.lang.Number type) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(option, "option");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(count, "count");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(type, "type");
        if (openMediaFunction != null) {
            io.dcloud.uts.UTSAndroid uTSAndroid = io.dcloud.uts.UTSAndroid.INSTANCE;
            kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super java.lang.Integer, ? super android.content.Intent, kotlin.Unit> function3 = openMediaFunction;
            kotlin.jvm.internal.Intrinsics.checkNotNull(function3);
            uTSAndroid.offAppActivityResult(function3);
        }
        openMediaFunction = new kotlin.jvm.functions.Function3() { // from class: uts.sdk.modules.DCloudUniChooseMedia.IndexKt$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function3
            public final java.lang.Object invoke(java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3) {
                return uts.sdk.modules.DCloudUniChooseMedia.IndexKt.openAlbumForMedia$lambda$11(option, ((java.lang.Integer) obj).intValue(), ((java.lang.Integer) obj2).intValue(), (android.content.Intent) obj3);
            }
        };
        io.dcloud.uts.UTSAndroid uTSAndroid2 = io.dcloud.uts.UTSAndroid.INSTANCE;
        kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super java.lang.Integer, ? super android.content.Intent, kotlin.Unit> function4 = openMediaFunction;
        kotlin.jvm.internal.Intrinsics.checkNotNull(function4);
        uTSAndroid2.onAppActivityResult(function4);
        openGalleryActivity(count, type, false, null, null, option.getPageOrientation(), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit openAlbumForMedia$lambda$11(uts.sdk.modules.DCloudUniChooseMedia.ChooseMediaOptions chooseMediaOptions, int i, int i2, android.content.Intent intent) {
        java.lang.String strJoin;
        java.util.ArrayList parcelableArrayListExtra;
        if (io.dcloud.uts.NumberKt.numberEquals(java.lang.Integer.valueOf(i), GALLERY_MEDIA_PICKER_RESULT)) {
            io.dcloud.uts.UTSAndroid uTSAndroid = io.dcloud.uts.UTSAndroid.INSTANCE;
            kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super java.lang.Integer, ? super android.content.Intent, kotlin.Unit> function3 = openMediaFunction;
            kotlin.jvm.internal.Intrinsics.checkNotNull(function3);
            uTSAndroid.offAppActivityResult(function3);
            io.dcloud.uts.UTSArray uTSArray = new io.dcloud.uts.UTSArray();
            io.dcloud.uts.UTSArray uTSArray2 = new io.dcloud.uts.UTSArray();
            if (intent != null && (parcelableArrayListExtra = intent.getParcelableArrayListExtra(com.dmcbig.mediapicker.PickerConfig.EXTRA_RESULT)) != null) {
                for (java.lang.Number numberInc = (java.lang.Number) 0; io.dcloud.uts.NumberKt.compareTo(numberInc, java.lang.Integer.valueOf(parcelableArrayListExtra.size())) < 0; numberInc = io.dcloud.uts.NumberKt.inc(numberInc)) {
                    java.lang.Object obj = parcelableArrayListExtra.get(numberInc.intValue());
                    kotlin.jvm.internal.Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type uts.sdk.modules.DCloudUniMedia.Media");
                    uts.sdk.modules.DCloudUniMedia.Media media = (uts.sdk.modules.DCloudUniMedia.Media) obj;
                    java.lang.String path = media.path;
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(path, "path");
                    uts.sdk.modules.DCloudUniChooseMedia.ChooseMediaTempFile mediaFileByType = getMediaFileByType(path, java.lang.Integer.valueOf(media.mediaType));
                    if (mediaFileByType != null) {
                        uTSArray.add(mediaFileByType);
                        if (uTSArray2.indexOf(mediaFileByType.getFileType()) == -1) {
                            uTSArray2.add(mediaFileByType.getFileType());
                        }
                    }
                }
            }
            if (uTSArray.size() == 0) {
                uts.sdk.modules.DCloudUniChooseMedia.ChooseMediaErrorImpl chooseMediaErrorImpl = new uts.sdk.modules.DCloudUniChooseMedia.ChooseMediaErrorImpl((java.lang.Number) 1101001, UniError_ChooseMedia);
                kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniChooseMedia.IChooseMediaError, kotlin.Unit> fail = chooseMediaOptions.getFail();
                if (fail != null) {
                    fail.invoke2(chooseMediaErrorImpl);
                }
                kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> complete = chooseMediaOptions.getComplete();
                if (complete != null) {
                    complete.invoke2(chooseMediaErrorImpl);
                }
            } else {
                if (chooseMediaOptions.getMediaType() != null) {
                    io.dcloud.uts.UTSArray<java.lang.String> mediaType = chooseMediaOptions.getMediaType();
                    kotlin.jvm.internal.Intrinsics.checkNotNull(mediaType);
                    java.lang.String string = mediaType.toString();
                    java.util.Locale ENGLISH = java.util.Locale.ENGLISH;
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
                    java.lang.String lowerCase = string.toLowerCase(ENGLISH);
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                    strJoin = "mix";
                    if (!kotlin.text.StringsKt.contains$default((java.lang.CharSequence) lowerCase, (java.lang.CharSequence) "mix", false, 2, (java.lang.Object) null)) {
                        strJoin = android.text.TextUtils.join(",", uTSArray2);
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strJoin, "join(...)");
                    }
                } else {
                    strJoin = android.text.TextUtils.join(",", uTSArray2);
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strJoin, "join(...)");
                }
                uts.sdk.modules.DCloudUniChooseMedia.ChooseMediaSuccess chooseMediaSuccess = new uts.sdk.modules.DCloudUniChooseMedia.ChooseMediaSuccess(uTSArray, strJoin);
                kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniChooseMedia.ChooseMediaSuccess, kotlin.Unit> success = chooseMediaOptions.getSuccess();
                if (success != null) {
                    success.invoke2(chooseMediaSuccess);
                }
                kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> complete2 = chooseMediaOptions.getComplete();
                if (complete2 != null) {
                    complete2.invoke2(chooseMediaSuccess);
                }
            }
            openMediaFunction = null;
        }
        return kotlin.Unit.INSTANCE;
    }

    public static final void openGalleryActivity(java.lang.Number count, java.lang.Number type, boolean z, io.dcloud.uts.UTSArray<java.lang.String> uTSArray, java.lang.Object obj, java.lang.String str, java.lang.String str2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(count, "count");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(type, "type");
        android.content.Intent intent = new android.content.Intent();
        android.app.Activity uniActivity = io.dcloud.uts.UTSAndroid.INSTANCE.getUniActivity();
        kotlin.jvm.internal.Intrinsics.checkNotNull(uniActivity);
        kotlin.jvm.internal.Intrinsics.checkNotNull(uniActivity);
        intent.setClassName(uniActivity, "uts.sdk.modules.DCloudUniMedia.SystemPickerActivity");
        intent.putExtra("select_mode", type);
        intent.putExtra(com.dmcbig.mediapicker.PickerConfig.SINGLE_SELECT, false);
        intent.putExtra(com.dmcbig.mediapicker.PickerConfig.COMPRESSED, z);
        intent.putExtra("max_select_count", count);
        if (uTSArray != null) {
            intent.putExtra(com.dmcbig.mediapicker.PickerConfig.SIZE_TYPE, io.dcloud.uts.JSON.stringify(uTSArray));
        }
        intent.putExtra("doc_path", mediaCachePath);
        intent.putExtra(com.dmcbig.mediapicker.PickerConfig.IMAGE_EDITABLE, true);
        intent.putExtra("page_orientation", getOrientation(str));
        intent.putExtra("copy_privacy_path", !io.dcloud.uts.UTSAndroid.INSTANCE.isUniAppX());
        android.app.Activity uniActivity2 = io.dcloud.uts.UTSAndroid.INSTANCE.getUniActivity();
        kotlin.jvm.internal.Intrinsics.checkNotNull(uniActivity2);
        kotlin.jvm.internal.Intrinsics.checkNotNull(uniActivity2);
        uniActivity2.startActivityForResult(intent, GALLERY_MEDIA_PICKER_RESULT.intValue());
    }

    public static final uts.sdk.modules.DCloudUniChooseMedia.ChooseMediaTempFile getMediaFileByType(java.lang.String path, java.lang.Number mimeType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(path, "path");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        if (kotlin.text.StringsKt.startsWith$default(path, "content://", false, 2, (java.lang.Object) null)) {
            android.app.Activity uniActivity = io.dcloud.uts.UTSAndroid.INSTANCE.getUniActivity();
            kotlin.jvm.internal.Intrinsics.checkNotNull(uniActivity);
            java.lang.String type = uniActivity.getContentResolver().getType(android.net.Uri.parse(path));
            kotlin.jvm.internal.Intrinsics.checkNotNull(type);
            if (kotlin.text.StringsKt.startsWith$default(type, "image/", false, 2, (java.lang.Object) null)) {
                return getMediaTempFile(path, (java.lang.Number) 1);
            }
            if (kotlin.text.StringsKt.startsWith$default(type, "video", false, 2, (java.lang.Object) null)) {
                return getMediaTempFile(path, (java.lang.Number) 3);
            }
            return null;
        }
        if (io.dcloud.uts.NumberKt.numberEquals(mimeType, 1) || io.dcloud.uts.NumberKt.numberEquals(mimeType, 3)) {
            return getMediaTempFile(path, mimeType);
        }
        java.lang.String strReplace = kotlin.text.StringsKt.startsWith$default(path, io.dcloud.common.adapter.util.DeviceInfo.FILE_PROTOCOL, false, 2, (java.lang.Object) null) ? io.dcloud.uts.StringKt.replace(path, io.dcloud.common.adapter.util.DeviceInfo.FILE_PROTOCOL, "") : path;
        try {
            android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
            options.inJustDecodeBounds = false;
            android.graphics.BitmapFactory.decodeFile(strReplace, options);
            if (options.outHeight >= 0 && options.outWidth >= 0) {
                return getMediaTempFile(path, (java.lang.Number) 1);
            }
            return getMediaTempFile(path, (java.lang.Number) 3);
        } catch (java.lang.Throwable unused) {
            return getMediaTempFile(path, (java.lang.Number) 3);
        }
    }

    public static final uts.sdk.modules.DCloudUniChooseMedia.ChooseMediaTempFile getMediaTempFile(java.lang.String path, java.lang.Number mimeType) {
        java.lang.String str;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(path, "path");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        if (kotlin.text.StringsKt.startsWith$default(path, io.dcloud.common.adapter.util.DeviceInfo.FILE_PROTOCOL, false, 2, (java.lang.Object) null) || kotlin.text.StringsKt.startsWith$default(path, "content://", false, 2, (java.lang.Object) null)) {
            str = path;
        } else {
            str = io.dcloud.common.adapter.util.DeviceInfo.FILE_PROTOCOL + path;
        }
        if (io.dcloud.uts.NumberKt.numberEquals(mimeType, 1)) {
            return new uts.sdk.modules.DCloudUniChooseMedia.ChooseMediaTempFile(str, "image", java.lang.Long.valueOf(getMediaInfo(path)), null, null, null, null, null, 248, null);
        }
        if (!io.dcloud.uts.NumberKt.numberEquals(mimeType, 3)) {
            return null;
        }
        uts.sdk.modules.DCloudUniChooseMedia.VideoMetadata videoMetadata = getVideoMetadata(path, mediaCachePath + "video_thumb_" + java.lang.System.currentTimeMillis() + ".jpg");
        double mediaInfo = (double) getMediaInfo(path);
        java.lang.Number number = formatNumber(java.lang.Double.valueOf(mediaInfo / 1024.0d));
        if (videoMetadata == null) {
            videoMetadata = new uts.sdk.modules.DCloudUniChooseMedia.VideoMetadata(java.lang.Double.valueOf(0.0d), number, java.lang.Double.valueOf(0.0d), java.lang.Double.valueOf(0.0d), "", java.lang.Double.valueOf(mediaInfo), "up", null, null, null, 896, null);
        }
        java.lang.String filePath = videoMetadata.getFilePath();
        java.lang.Number width = videoMetadata.getWidth();
        return new uts.sdk.modules.DCloudUniChooseMedia.ChooseMediaTempFile(str, "video", videoMetadata.getSize(), videoMetadata.getByteSize(), videoMetadata.getDuration(), videoMetadata.getHeight(), width, filePath);
    }

    public static final long getMediaInfo(java.lang.String path) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(path, "path");
        android.database.Cursor cursorQuery = null;
        if (kotlin.text.StringsKt.startsWith$default(path, "content://", false, 2, (java.lang.Object) null)) {
            try {
                android.content.Context appContext = io.dcloud.uts.UTSAndroid.INSTANCE.getAppContext();
                kotlin.jvm.internal.Intrinsics.checkNotNull(appContext);
                cursorQuery = appContext.getContentResolver().query(android.net.Uri.parse(path), null, null, null, null);
                if (cursorQuery == null || !cursorQuery.moveToFirst()) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return 0L;
                }
                int columnIndex = cursorQuery.getColumnIndex("_size");
                long j = cursorQuery.isNull(columnIndex) ? 0L : cursorQuery.getLong(columnIndex);
                cursorQuery.close();
                return j;
            } catch (java.lang.Throwable unused) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return 0L;
            }
        }
        java.lang.String str = ASSETS_PATH;
        if (kotlin.text.StringsKt.startsWith$default(path, str, false, 2, (java.lang.Object) null)) {
            try {
                android.app.Activity uniActivity = io.dcloud.uts.UTSAndroid.INSTANCE.getUniActivity();
                kotlin.jvm.internal.Intrinsics.checkNotNull(uniActivity);
                java.io.InputStream inputStreamOpen = uniActivity.getAssets().open(io.dcloud.uts.StringKt.replace(path, str, ""));
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(inputStreamOpen, "open(...)");
                int iAvailable = inputStreamOpen.available();
                inputStreamOpen.close();
                return iAvailable;
            } catch (java.lang.Throwable unused2) {
            }
        } else {
            java.io.File file = new java.io.File(path);
            if (file.exists()) {
                return file.length();
            }
            if (kotlin.text.StringsKt.startsWith$default(path, io.dcloud.common.adapter.util.DeviceInfo.FILE_PROTOCOL, false, 2, (java.lang.Object) null)) {
                java.io.File file2 = new java.io.File(io.dcloud.uts.StringKt.replace(path, io.dcloud.common.adapter.util.DeviceInfo.FILE_PROTOCOL, ""));
                if (file2.exists()) {
                    return file2.length();
                }
            }
        }
        return 0L;
    }

    public static final java.lang.String normalizeMediaPath(java.lang.String path) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(path, "path");
        return kotlin.text.StringsKt.startsWith$default(path, io.dcloud.common.adapter.util.DeviceInfo.FILE_PROTOCOL, false, 2, (java.lang.Object) null) ? io.dcloud.uts.StringKt.replace(path, io.dcloud.common.adapter.util.DeviceInfo.FILE_PROTOCOL, "") : path;
    }

    public static final uts.sdk.modules.DCloudUniChooseMedia.VideoMetadata getVideoMetadata(java.lang.String src, java.lang.String str) {
        java.lang.String str2;
        java.lang.Integer numValueOf;
        java.lang.String str3 = str;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(src, "src");
        java.lang.Double dValueOf = java.lang.Double.valueOf(0.0d);
        uts.sdk.modules.DCloudUniChooseMedia.VideoMetadata videoMetadata = new uts.sdk.modules.DCloudUniChooseMedia.VideoMetadata(dValueOf, dValueOf, dValueOf, dValueOf, "", dValueOf, "up", null, null, null, 896, null);
        java.lang.String strNormalizeMediaPath = normalizeMediaPath(src);
        android.media.MediaMetadataRetriever mediaMetadataRetriever = null;
        numberRound = null;
        java.lang.Number numberRound = null;
        boolean zStartsWith$default = kotlin.text.StringsKt.startsWith$default(strNormalizeMediaPath, "content://", false, 2, (java.lang.Object) null);
        java.io.File file = new java.io.File(strNormalizeMediaPath);
        if (!file.exists() && !zStartsWith$default) {
            strNormalizeMediaPath = io.dcloud.uts.UTSAndroid.INSTANCE.convert2AbsFullPath(src);
        }
        java.lang.String strNormalizeMediaPath2 = normalizeMediaPath(strNormalizeMediaPath);
        boolean zStartsWith$default2 = kotlin.text.StringsKt.startsWith$default(strNormalizeMediaPath2, "content://", false, 2, (java.lang.Object) null);
        if (kotlin.text.StringsKt.startsWith$default(strNormalizeMediaPath2, "/android_asset/", false, 2, (java.lang.Object) null)) {
            java.lang.String str4 = io.dcloud.uts.UTSAndroid.INSTANCE.getAppCachePath() + "uni-media/_" + java.lang.System.currentTimeMillis();
            if (!copyFile(strNormalizeMediaPath2, str4)) {
                return null;
            }
            strNormalizeMediaPath2 = str4;
        }
        if (!file.exists()) {
            file = new java.io.File(strNormalizeMediaPath2);
        }
        if (!file.exists() && !zStartsWith$default2) {
            return null;
        }
        videoMetadata.setByteSize(java.lang.Double.valueOf(getMediaInfo(strNormalizeMediaPath2)));
        videoMetadata.setSize(formatNumber(io.dcloud.uts.NumberKt.div(videoMetadata.getByteSize(), java.lang.Double.valueOf(1024.0d))));
        try {
            try {
                android.media.MediaMetadataRetriever mediaMetadataRetriever2 = new android.media.MediaMetadataRetriever();
                try {
                    if (kotlin.text.StringsKt.startsWith$default(strNormalizeMediaPath2, "content://", false, 2, (java.lang.Object) null)) {
                        android.app.Activity uniActivity = io.dcloud.uts.UTSAndroid.INSTANCE.getUniActivity();
                        kotlin.jvm.internal.Intrinsics.checkNotNull(uniActivity);
                        mediaMetadataRetriever2.setDataSource(uniActivity, android.net.Uri.parse(strNormalizeMediaPath2));
                    } else {
                        mediaMetadataRetriever2.setDataSource(strNormalizeMediaPath2);
                    }
                    if (!saveBitmapToLocalPath(mediaMetadataRetriever2.getFrameAtTime(0L, 2), str3)) {
                        videoMetadata.setFilePath("");
                    } else {
                        if (str3 == null) {
                            str3 = "";
                        }
                        videoMetadata.setFilePath(str3);
                    }
                    java.lang.String strExtractMetadata = mediaMetadataRetriever2.extractMetadata(9);
                    java.lang.String strExtractMetadata2 = mediaMetadataRetriever2.extractMetadata(18);
                    java.lang.Float fValueOf = strExtractMetadata2 != null ? java.lang.Float.valueOf(java.lang.Float.parseFloat(strExtractMetadata2)) : null;
                    java.lang.String strExtractMetadata3 = mediaMetadataRetriever2.extractMetadata(19);
                    java.lang.Float fValueOf2 = strExtractMetadata3 != null ? java.lang.Float.valueOf(java.lang.Float.parseFloat(strExtractMetadata3)) : null;
                    java.lang.String strExtractMetadata4 = mediaMetadataRetriever2.extractMetadata(24);
                    if (kotlin.jvm.internal.Intrinsics.areEqual("90", strExtractMetadata4) || kotlin.jvm.internal.Intrinsics.areEqual("270", strExtractMetadata4)) {
                        if (fValueOf2 == null) {
                            fValueOf2 = (java.lang.Number) 0;
                        }
                        videoMetadata.setWidth(fValueOf2);
                        if (fValueOf == null) {
                            fValueOf = (java.lang.Number) 0;
                        }
                        videoMetadata.setHeight(fValueOf);
                    } else {
                        if (fValueOf == null) {
                            fValueOf = (java.lang.Number) 0;
                        }
                        videoMetadata.setWidth(fValueOf);
                        if (fValueOf2 == null) {
                            fValueOf2 = (java.lang.Number) 0;
                        }
                        videoMetadata.setHeight(fValueOf2);
                    }
                    if (strExtractMetadata4 != null) {
                        int iHashCode = strExtractMetadata4.hashCode();
                        if (iHashCode != 1815) {
                            if (iHashCode != 48873) {
                                if (iHashCode == 49803 && strExtractMetadata4.equals("270")) {
                                    str2 = "left";
                                } else {
                                    str2 = "up";
                                }
                            } else if (strExtractMetadata4.equals("180")) {
                                str2 = "down";
                            } else {
                                str2 = "up";
                            }
                        } else if (strExtractMetadata4.equals("90")) {
                            str2 = "right";
                        } else {
                            str2 = "up";
                        }
                    } else {
                        str2 = "up";
                    }
                    java.lang.Number numberValueOf = (java.lang.Number) 0;
                    if (strExtractMetadata != null) {
                        try {
                            numberValueOf = java.lang.Float.valueOf(java.lang.Float.parseFloat(strExtractMetadata));
                        } catch (java.lang.Throwable unused) {
                        }
                    }
                    java.math.BigDecimal scale = java.math.BigDecimal.valueOf(numberValueOf.doubleValue() / ((double) 1000)).setScale(2, 4);
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(scale, "setScale(...)");
                    videoMetadata.setDuration(java.lang.Float.valueOf(scale.floatValue()));
                    videoMetadata.setOrientation(str2);
                    java.lang.String strExtractMetadata5 = mediaMetadataRetriever2.extractMetadata(12);
                    if (!android.text.TextUtils.isEmpty(strExtractMetadata5)) {
                        videoMetadata.setType(strExtractMetadata5);
                    }
                    java.lang.String strExtractMetadata6 = mediaMetadataRetriever2.extractMetadata(20);
                    if (strExtractMetadata6 != null) {
                        try {
                            numValueOf = java.lang.Integer.valueOf((int) (java.lang.Float.parseFloat(strExtractMetadata6) / 1000));
                        } catch (java.lang.Throwable unused2) {
                            numValueOf = null;
                        }
                    } else {
                        numValueOf = null;
                    }
                    videoMetadata.setBitrate(numValueOf);
                    java.lang.String strExtractMetadata7 = mediaMetadataRetriever2.extractMetadata(32);
                    if (!android.text.TextUtils.isEmpty(strExtractMetadata7)) {
                        try {
                            kotlin.jvm.internal.Intrinsics.checkNotNull(strExtractMetadata7);
                            kotlin.jvm.internal.Intrinsics.checkNotNull(strExtractMetadata7);
                            numberRound = io.dcloud.uts.Math.round(io.dcloud.uts.NumberKt.times(io.dcloud.uts.NumberKt.div(java.lang.Float.valueOf(java.lang.Float.parseFloat(strExtractMetadata7)), numberValueOf), (java.lang.Number) 1000));
                        } catch (java.lang.Throwable unused3) {
                        }
                    }
                    videoMetadata.setFps(numberRound);
                    mediaMetadataRetriever2.release();
                } catch (java.lang.Throwable unused4) {
                    mediaMetadataRetriever = mediaMetadataRetriever2;
                    if (mediaMetadataRetriever != null) {
                        mediaMetadataRetriever.release();
                    }
                    fillVideoMetadataByExtractor(strNormalizeMediaPath2, videoMetadata);
                    return videoMetadata;
                }
            } catch (java.lang.Throwable unused5) {
            }
        } catch (java.lang.Throwable unused6) {
        }
        fillVideoMetadataByExtractor(strNormalizeMediaPath2, videoMetadata);
        return videoMetadata;
    }

    public static final void fillVideoMetadataByExtractor(java.lang.String reassignedPath, uts.sdk.modules.DCloudUniChooseMedia.VideoMetadata videoInfo) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(reassignedPath, "reassignedPath");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(videoInfo, "videoInfo");
        android.media.MediaExtractor mediaExtractor = null;
        try {
            try {
                java.lang.String strNormalizeMediaPath = normalizeMediaPath(reassignedPath);
                android.media.MediaExtractor mediaExtractor2 = new android.media.MediaExtractor();
                try {
                    if (kotlin.text.StringsKt.startsWith$default(strNormalizeMediaPath, "content://", false, 2, (java.lang.Object) null)) {
                        android.app.Activity uniActivity = io.dcloud.uts.UTSAndroid.INSTANCE.getUniActivity();
                        kotlin.jvm.internal.Intrinsics.checkNotNull(uniActivity);
                        mediaExtractor2.setDataSource(uniActivity, android.net.Uri.parse(strNormalizeMediaPath), (java.util.Map<java.lang.String, java.lang.String>) null);
                    } else {
                        mediaExtractor2.setDataSource(strNormalizeMediaPath);
                    }
                    int trackCount = mediaExtractor2.getTrackCount();
                    for (java.lang.Number numberInc = (java.lang.Number) 0; io.dcloud.uts.NumberKt.compareTo(numberInc, java.lang.Integer.valueOf(trackCount)) < 0; numberInc = io.dcloud.uts.NumberKt.inc(numberInc)) {
                        android.media.MediaFormat trackFormat = mediaExtractor2.getTrackFormat(numberInc.intValue());
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(trackFormat, "getTrackFormat(...)");
                        java.lang.String string = trackFormat.getString(tv.danmaku.ijk.media.player.misc.IMediaFormat.KEY_MIME);
                        if (!android.text.TextUtils.isEmpty(string)) {
                            kotlin.jvm.internal.Intrinsics.checkNotNull(string);
                            kotlin.jvm.internal.Intrinsics.checkNotNull(string);
                            if (kotlin.text.StringsKt.startsWith$default(string, "video/", false, 2, (java.lang.Object) null)) {
                                if (android.text.TextUtils.isEmpty(videoInfo.getType())) {
                                    videoInfo.setType(string);
                                }
                                java.lang.Number numberValueOf = (java.lang.Number) 0;
                                java.lang.Number numberValueOf2 = (java.lang.Number) 0;
                                try {
                                    numberValueOf = java.lang.Float.valueOf(trackFormat.getInteger("width"));
                                } catch (java.lang.Throwable unused) {
                                }
                                try {
                                    numberValueOf2 = java.lang.Float.valueOf(trackFormat.getInteger("height"));
                                } catch (java.lang.Throwable unused2) {
                                }
                                boolean z = true;
                                boolean z2 = kotlin.jvm.internal.Intrinsics.areEqual(videoInfo.getOrientation(), "right") || kotlin.jvm.internal.Intrinsics.areEqual(videoInfo.getOrientation(), "left");
                                if (!z2) {
                                    try {
                                        int integer = trackFormat.getInteger(androidtranscoder.format.MediaFormatExtraConstants.KEY_ROTATION_DEGREES);
                                        if (integer != 90 && integer != 270) {
                                            z = false;
                                        }
                                        z2 = z;
                                    } catch (java.lang.Throwable unused3) {
                                    }
                                }
                                if (io.dcloud.uts.NumberKt.compareTo(numberValueOf, (java.lang.Number) 0) > 0 && io.dcloud.uts.NumberKt.compareTo(numberValueOf2, (java.lang.Number) 0) > 0 && (io.dcloud.uts.NumberKt.compareTo(videoInfo.getWidth(), (java.lang.Number) 0) <= 0 || io.dcloud.uts.NumberKt.compareTo(videoInfo.getHeight(), (java.lang.Number) 0) <= 0)) {
                                    if (z2) {
                                        if (io.dcloud.uts.NumberKt.compareTo(videoInfo.getWidth(), (java.lang.Number) 0) <= 0) {
                                            videoInfo.setWidth(numberValueOf2);
                                        }
                                        if (io.dcloud.uts.NumberKt.compareTo(videoInfo.getHeight(), (java.lang.Number) 0) <= 0) {
                                            videoInfo.setHeight(numberValueOf);
                                        }
                                    } else {
                                        if (io.dcloud.uts.NumberKt.compareTo(videoInfo.getWidth(), (java.lang.Number) 0) <= 0) {
                                            videoInfo.setWidth(numberValueOf);
                                        }
                                        if (io.dcloud.uts.NumberKt.compareTo(videoInfo.getHeight(), (java.lang.Number) 0) <= 0) {
                                            videoInfo.setHeight(numberValueOf2);
                                        }
                                    }
                                }
                                try {
                                    if (io.dcloud.uts.NumberKt.compareTo(videoInfo.getDuration(), (java.lang.Number) 0) <= 0) {
                                        long j = trackFormat.getLong("durationUs");
                                        if (j > 0) {
                                            java.math.BigDecimal scale = java.math.BigDecimal.valueOf(j / ((double) kotlin.time.DurationKt.NANOS_IN_MILLIS)).setScale(2, 4);
                                            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(scale, "setScale(...)");
                                            videoInfo.setDuration(java.lang.Float.valueOf(scale.floatValue()));
                                        }
                                    }
                                } catch (java.lang.Throwable unused4) {
                                }
                                try {
                                    if (videoInfo.getFps() != null) {
                                        break;
                                    }
                                    videoInfo.setFps(java.lang.Integer.valueOf(trackFormat.getInteger("frame-rate")));
                                    break;
                                } catch (java.lang.Throwable unused5) {
                                    break;
                                }
                            }
                        }
                    }
                    mediaExtractor2.release();
                } catch (java.lang.Throwable unused6) {
                    mediaExtractor = mediaExtractor2;
                    if (mediaExtractor != null) {
                        mediaExtractor.release();
                    }
                }
            } catch (java.lang.Throwable unused7) {
            }
        } catch (java.lang.Throwable unused8) {
        }
    }

    public static final boolean saveBitmapToLocalPath(android.graphics.Bitmap bitmap, java.lang.String str) throws java.io.IOException {
        if (android.text.TextUtils.isEmpty(str) || bitmap == null) {
            return false;
        }
        java.io.File file = new java.io.File(str);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        if (!file.exists()) {
            file.createNewFile();
        }
        java.io.FileOutputStream fileOutputStream = null;
        try {
            java.io.FileOutputStream fileOutputStream2 = new java.io.FileOutputStream(file);
            try {
                bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 100, fileOutputStream2);
                fileOutputStream2.close();
                return true;
            } catch (java.lang.Throwable unused) {
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                return false;
            }
        } catch (java.lang.Throwable unused2) {
        }
    }

    public static final java.lang.Number getOrientation(java.lang.String str) {
        if (str == null) {
            str = getGlobalConfig();
        }
        kotlin.jvm.internal.Intrinsics.checkNotNull(str);
        int iHashCode = str.hashCode();
        if (iHashCode != 3005871) {
            if (iHashCode != 729267099) {
                if (iHashCode == 1430647483 && str.equals("landscape")) {
                    return (java.lang.Number) 6;
                }
            } else if (str.equals("portrait")) {
                return (java.lang.Number) 1;
            }
        } else if (str.equals("auto")) {
            return (java.lang.Number) 2;
        }
        return (java.lang.Number) 1;
    }

    public static final java.lang.String getGlobalConfig() {
        java.lang.Object obj;
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("io.dcloud.uniapp.framework.IndexKt");
            if (cls != null) {
                java.lang.reflect.Field declaredField = cls.getDeclaredField("__uniConfig");
                declaredField.setAccessible(true);
                java.lang.Object obj2 = declaredField.get(null);
                if (obj2 != null) {
                    java.lang.reflect.Field declaredField2 = obj2.getClass().getDeclaredField("globalStyle");
                    declaredField2.setAccessible(true);
                    java.lang.Object obj3 = declaredField2.get(obj2);
                    if (obj3 != null && (obj3 instanceof io.dcloud.uts.Map) && (obj = ((java.util.Map) obj3).get("pageOrientation")) != null) {
                        return (java.lang.String) obj;
                    }
                }
            }
        } catch (java.lang.Throwable unused) {
        }
        return "portrait";
    }

    public static final boolean copyFile(java.lang.String fromFilePath, java.lang.String toFilePath) throws java.io.IOException {
        java.io.FileInputStream fileInputStream;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fromFilePath, "fromFilePath");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(toFilePath, "toFilePath");
        try {
            java.lang.String str = ASSETS_PATH;
            if (kotlin.text.StringsKt.startsWith$default(fromFilePath, str, false, 2, (java.lang.Object) null)) {
                android.app.Activity uniActivity = io.dcloud.uts.UTSAndroid.INSTANCE.getUniActivity();
                kotlin.jvm.internal.Intrinsics.checkNotNull(uniActivity);
                fileInputStream = uniActivity.getAssets().open(io.dcloud.uts.StringKt.replace(fromFilePath, str, ""));
            } else if (kotlin.text.StringsKt.startsWith$default(fromFilePath, "content://", false, 2, (java.lang.Object) null)) {
                android.app.Activity uniActivity2 = io.dcloud.uts.UTSAndroid.INSTANCE.getUniActivity();
                kotlin.jvm.internal.Intrinsics.checkNotNull(uniActivity2);
                fileInputStream = uniActivity2.getContentResolver().openInputStream(android.net.Uri.parse(fromFilePath));
            } else {
                java.io.File file = new java.io.File(fromFilePath);
                if (!file.exists() || !file.isFile() || !file.canRead()) {
                    return false;
                }
                fileInputStream = new java.io.FileInputStream(file);
            }
            if (fileInputStream == null) {
                return false;
            }
            java.io.File file2 = new java.io.File(toFilePath);
            if (!file2.getParentFile().exists()) {
                file2.getParentFile().mkdirs();
            }
            if (!file2.exists()) {
                file2.createNewFile();
            }
            java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file2);
            byte[] bArr = new byte[1024];
            for (int i = fileInputStream.read(bArr); i > 0; i = fileInputStream.read(bArr)) {
                fileOutputStream.write(bArr, 0, i);
            }
            fileInputStream.close();
            fileOutputStream.close();
            return true;
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    public static final java.lang.Number formatNumber(java.lang.Number input) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(input, "input");
        java.text.DecimalFormat decimalFormat = new java.text.DecimalFormat("#.###");
        decimalFormat.setDecimalSeparatorAlwaysShown(false);
        java.lang.String str = decimalFormat.format(input);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return java.lang.Float.valueOf(java.lang.Float.parseFloat(str));
    }

    public static final void chooseMediaByJs(final uts.sdk.modules.DCloudUniChooseMedia.ChooseMediaOptionsJSONObject options) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(options, "options");
        chooseMedia.invoke2(new uts.sdk.modules.DCloudUniChooseMedia.ChooseMediaOptions(options.getPageOrientation(), options.getCount(), options.getMediaType(), options.getSourceType(), options.getMaxDuration(), options.getCamera(), new kotlin.jvm.functions.Function1() { // from class: uts.sdk.modules.DCloudUniChooseMedia.IndexKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public final java.lang.Object invoke2(java.lang.Object obj) {
                return uts.sdk.modules.DCloudUniChooseMedia.IndexKt.chooseMediaByJs$lambda$13(options, (uts.sdk.modules.DCloudUniChooseMedia.ChooseMediaSuccess) obj);
            }
        }, new kotlin.jvm.functions.Function1() { // from class: uts.sdk.modules.DCloudUniChooseMedia.IndexKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public final java.lang.Object invoke2(java.lang.Object obj) {
                return uts.sdk.modules.DCloudUniChooseMedia.IndexKt.chooseMediaByJs$lambda$14(options, (uts.sdk.modules.DCloudUniChooseMedia.IChooseMediaError) obj);
            }
        }, new kotlin.jvm.functions.Function1() { // from class: uts.sdk.modules.DCloudUniChooseMedia.IndexKt$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public final java.lang.Object invoke2(java.lang.Object obj) {
                return uts.sdk.modules.DCloudUniChooseMedia.IndexKt.chooseMediaByJs$lambda$15(options, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit chooseMediaByJs$lambda$13(uts.sdk.modules.DCloudUniChooseMedia.ChooseMediaOptionsJSONObject chooseMediaOptionsJSONObject, uts.sdk.modules.DCloudUniChooseMedia.ChooseMediaSuccess chooseMediaSuccess) {
        io.dcloud.uts.UTSCallback success = chooseMediaOptionsJSONObject.getSuccess();
        if (success != null) {
            success.invoke(chooseMediaSuccess);
        }
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit chooseMediaByJs$lambda$14(uts.sdk.modules.DCloudUniChooseMedia.ChooseMediaOptionsJSONObject chooseMediaOptionsJSONObject, uts.sdk.modules.DCloudUniChooseMedia.IChooseMediaError iChooseMediaError) {
        io.dcloud.uts.UTSCallback fail = chooseMediaOptionsJSONObject.getFail();
        if (fail != null) {
            fail.invoke(iChooseMediaError);
        }
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit chooseMediaByJs$lambda$15(uts.sdk.modules.DCloudUniChooseMedia.ChooseMediaOptionsJSONObject chooseMediaOptionsJSONObject, java.lang.Object obj) {
        io.dcloud.uts.UTSCallback complete = chooseMediaOptionsJSONObject.getComplete();
        if (complete != null) {
            complete.invoke(obj);
        }
        return kotlin.Unit.INSTANCE;
    }
}
