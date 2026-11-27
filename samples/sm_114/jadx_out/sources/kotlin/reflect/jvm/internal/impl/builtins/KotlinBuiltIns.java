package kotlin.reflect.jvm.internal.impl.builtins;

/* JADX INFO: loaded from: classes2.dex */
public abstract class KotlinBuiltIns {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final kotlin.reflect.jvm.internal.impl.name.Name BUILTINS_MODULE_NAME = kotlin.reflect.jvm.internal.impl.name.Name.special("<built-ins module>");
    private final kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull<kotlin.reflect.jvm.internal.impl.name.Name, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor> builtInClassesByName;
    private final kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue<java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor>> builtInPackagesImportedByDefault;
    private kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl builtInsModule;
    private kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue<kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl> postponedBuiltInsModule;
    private final kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue<kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.Primitives> primitives;
    private final kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager;

    /* JADX WARN: Code duplicated, block: B:17:0x0035 A[FALL_THROUGH] */
    /* JADX WARN: Code duplicated, block: B:33:0x0058 A[FALL_THROUGH] */
    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        java.lang.String str;
        int i2;
        if (i != 11 && i != 13 && i != 15 && i != 69 && i != 74 && i != 81 && i != 84 && i != 86 && i != 87) {
            switch (i) {
                default:
                    switch (i) {
                        default:
                            switch (i) {
                                default:
                                    switch (i) {
                                        case com.alibaba.fastjson.asm.Opcodes.LSTORE /* 55 */:
                                        case 56:
                                        case com.alibaba.fastjson.asm.Opcodes.DSTORE /* 57 */:
                                        case 58:
                                        case 59:
                                        case 60:
                                        case kotlinx.coroutines.internal.LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                                        case 62:
                                        case androidx.core.text.HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                                        case 64:
                                        case org.mozilla.universalchardet.prober.CharsetProber.ASCII_A_CAPITAL /* 65 */:
                                        case tv.danmaku.ijk.media.player.IjkMediaMeta.FF_PROFILE_H264_BASELINE /* 66 */:
                                        case 67:
                                            break;
                                        default:
                                            str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                                            break;
                                    }
                                case 48:
                                case 49:
                                case 50:
                                case 51:
                                case 52:
                                case 53:
                                    str = "@NotNull method %s.%s must not return null";
                                    break;
                            }
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                        case 26:
                        case 27:
                        case 28:
                        case 29:
                        case 30:
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                        case 38:
                        case 39:
                        case 40:
                        case 41:
                        case 42:
                        case 43:
                        case 44:
                        case 45:
                        case 46:
                            str = "@NotNull method %s.%s must not return null";
                            break;
                    }
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                    str = "@NotNull method %s.%s must not return null";
                    break;
            }
        } else {
            str = "@NotNull method %s.%s must not return null";
        }
        if (i != 11 && i != 13 && i != 15 && i != 69 && i != 74 && i != 81 && i != 84 && i != 86 && i != 87) {
            switch (i) {
                default:
                    switch (i) {
                        default:
                            switch (i) {
                                default:
                                    switch (i) {
                                        case com.alibaba.fastjson.asm.Opcodes.LSTORE /* 55 */:
                                        case 56:
                                        case com.alibaba.fastjson.asm.Opcodes.DSTORE /* 57 */:
                                        case 58:
                                        case 59:
                                        case 60:
                                        case kotlinx.coroutines.internal.LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                                        case 62:
                                        case androidx.core.text.HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                                        case 64:
                                        case org.mozilla.universalchardet.prober.CharsetProber.ASCII_A_CAPITAL /* 65 */:
                                        case tv.danmaku.ijk.media.player.IjkMediaMeta.FF_PROFILE_H264_BASELINE /* 66 */:
                                        case 67:
                                            break;
                                        default:
                                            i2 = 3;
                                            break;
                                    }
                                case 48:
                                case 49:
                                case 50:
                                case 51:
                                case 52:
                                case 53:
                                    i2 = 2;
                                    break;
                            }
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                        case 26:
                        case 27:
                        case 28:
                        case 29:
                        case 30:
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                        case 38:
                        case 39:
                        case 40:
                        case 41:
                        case 42:
                        case 43:
                        case 44:
                        case 45:
                        case 46:
                            i2 = 2;
                            break;
                    }
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                    i2 = 2;
                    break;
            }
        } else {
            i2 = 2;
        }
        java.lang.Object[] objArr = new java.lang.Object[i2];
        switch (i) {
            case 1:
            case io.dcloud.common.DHInterface.IMgr.WindowEvent.WINDOW_CRATE_TITLENVIEW /* 72 */:
                objArr[0] = "module";
                break;
            case 2:
                objArr[0] = "computation";
                break;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 11:
            case 13:
            case 15:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case com.alibaba.fastjson.asm.Opcodes.LSTORE /* 55 */:
            case 56:
            case com.alibaba.fastjson.asm.Opcodes.DSTORE /* 57 */:
            case 58:
            case 59:
            case 60:
            case kotlinx.coroutines.internal.LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
            case 62:
            case androidx.core.text.HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
            case 64:
            case org.mozilla.universalchardet.prober.CharsetProber.ASCII_A_CAPITAL /* 65 */:
            case tv.danmaku.ijk.media.player.IjkMediaMeta.FF_PROFILE_H264_BASELINE /* 66 */:
            case 67:
            case 69:
            case io.dcloud.common.DHInterface.IMgr.WindowEvent.WINDOW_BACKGROUND_SET_WEBPARENT /* 74 */:
            case io.dcloud.common.DHInterface.IMgr.WindowEvent.OBTAIN_APP_TOP_PAGE_DIRECT /* 81 */:
            case 84:
            case 86:
            case com.alibaba.fastjson.asm.Opcodes.POP /* 87 */:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns";
                break;
            case 9:
            case 10:
            case io.dcloud.common.DHInterface.IMgr.WindowEvent.CHECK_RESTART_TOP_WEBVIEW /* 76 */:
            case 77:
            case com.alibaba.fastjson.asm.Opcodes.DUP /* 89 */:
            case com.alibaba.fastjson.asm.Opcodes.IADD /* 96 */:
            case 103:
            case 107:
            case androidx.appcompat.app.AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR /* 108 */:
            case org.mozilla.universalchardet.prober.contextanalysis.EUCJPContextAnalysis.SINGLE_SHIFT_3 /* 143 */:
            case 146:
            case 147:
            case com.alibaba.fastjson.asm.Opcodes.FCMPL /* 149 */:
            case 157:
            case com.alibaba.fastjson.asm.Opcodes.IFLE /* 158 */:
            case 159:
                objArr[0] = "descriptor";
                break;
            case 12:
            case 98:
            case 100:
            case 102:
            case androidx.core.location.LocationRequestCompat.QUALITY_LOW_POWER /* 104 */:
            case 106:
            case 135:
                objArr[0] = "fqName";
                break;
            case 14:
                objArr[0] = "simpleName";
                break;
            case 16:
            case 17:
            case 54:
            case tv.danmaku.ijk.media.player.IjkMediaMeta.FF_PROFILE_H264_EXTENDED /* 88 */:
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case org.mozilla.universalchardet.prober.CharsetProber.ASCII_A /* 97 */:
            case 99:
            case 105:
            case androidx.appcompat.app.AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY /* 109 */:
            case tv.danmaku.ijk.media.player.IjkMediaMeta.FF_PROFILE_H264_HIGH_10 /* 110 */:
            case 111:
            case 113:
            case uni.app.UNIGF0182AE.BuildConfig.VERSION_CODE /* 114 */:
            case 115:
            case 116:
            case 117:
            case 118:
            case 119:
            case 120:
            case 121:
            case 122:
            case 123:
            case 124:
            case 125:
            case 126:
            case kotlinx.coroutines.scheduling.WorkQueueKt.MASK /* 127 */:
            case 128:
            case 129:
            case org.mozilla.universalchardet.prober.contextanalysis.SJISContextAnalysis.HIRAGANA_HIGHBYTE /* 130 */:
            case 131:
            case 132:
            case 133:
            case 134:
            case 136:
            case 137:
            case 138:
            case 139:
            case 140:
            case 141:
            case org.mozilla.universalchardet.prober.contextanalysis.EUCJPContextAnalysis.SINGLE_SHIFT_2 /* 142 */:
            case tv.danmaku.ijk.media.player.IjkMediaMeta.FF_PROFILE_H264_HIGH_444 /* 144 */:
            case 145:
            case com.alibaba.fastjson.asm.Opcodes.LCMP /* 148 */:
            case 150:
            case com.alibaba.fastjson.asm.Opcodes.DCMPL /* 151 */:
            case 152:
            case com.alibaba.fastjson.asm.Opcodes.IFEQ /* 153 */:
            case com.alibaba.fastjson.asm.Opcodes.IFNE /* 154 */:
            case 155:
            case 156:
            case 161:
                objArr[0] = "type";
                break;
            case 47:
                objArr[0] = "classSimpleName";
                break;
            case 68:
            case io.dcloud.common.DHInterface.IMgr.WindowEvent.WINDOW_ANIMATION_END /* 70 */:
                objArr[0] = "arrayType";
                break;
            case io.dcloud.common.DHInterface.IMgr.WindowEvent.ADD_ANIMATION_CALLBACK /* 71 */:
                objArr[0] = "notNullArrayType";
                break;
            case io.dcloud.common.DHInterface.IMgr.WindowEvent.WINDOW_APPEND_TITLENVIEW /* 73 */:
                objArr[0] = "primitiveType";
                break;
            case io.dcloud.common.DHInterface.IMgr.WindowEvent.WINDOW_UPDATE_BACKGROUND /* 75 */:
                objArr[0] = "kotlinType";
                break;
            case io.dcloud.common.DHInterface.IMgr.WindowEvent.OBTAIN_MP_TOP_PAGE_URL /* 78 */:
            case 82:
                objArr[0] = "projectionType";
                break;
            case 79:
            case 83:
            case com.facebook.imagepipeline.transcoder.JpegTranscoderUtils.DEFAULT_JPEG_QUALITY /* 85 */:
                objArr[0] = "argument";
                break;
            case 80:
                objArr[0] = "annotations";
                break;
            case 101:
                objArr[0] = "typeConstructor";
                break;
            case 112:
                objArr[0] = "classDescriptor";
                break;
            case com.alibaba.fastjson.asm.Opcodes.IF_ICMPNE /* 160 */:
                objArr[0] = "declarationDescriptor";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        if (i == 11) {
            objArr[1] = "getBuiltInsPackageScope";
        } else if (i == 13) {
            objArr[1] = "getBuiltInClassByFqName";
        } else if (i == 15) {
            objArr[1] = "getBuiltInClassByName";
        } else if (i == 69) {
            objArr[1] = "getArrayElementType";
        } else if (i == 74) {
            objArr[1] = "getPrimitiveArrayKotlinType";
        } else if (i == 81 || i == 84) {
            objArr[1] = "getArrayType";
        } else if (i == 86) {
            objArr[1] = "getEnumType";
        } else if (i != 87) {
            switch (i) {
                case 3:
                    objArr[1] = "getAdditionalClassPartsProvider";
                    break;
                case 4:
                    objArr[1] = "getPlatformDependentDeclarationFilter";
                    break;
                case 5:
                    objArr[1] = "getClassDescriptorFactories";
                    break;
                case 6:
                    objArr[1] = "getStorageManager";
                    break;
                case 7:
                    objArr[1] = "getBuiltInsModule";
                    break;
                case 8:
                    objArr[1] = "getBuiltInPackagesImportedByDefault";
                    break;
                default:
                    switch (i) {
                        case 18:
                            objArr[1] = "getSuspendFunction";
                            break;
                        case 19:
                            objArr[1] = "getKFunction";
                            break;
                        case 20:
                            objArr[1] = "getKSuspendFunction";
                            break;
                        case 21:
                            objArr[1] = "getKClass";
                            break;
                        case 22:
                            objArr[1] = "getKType";
                            break;
                        case 23:
                            objArr[1] = "getKCallable";
                            break;
                        case 24:
                            objArr[1] = "getKProperty";
                            break;
                        case 25:
                            objArr[1] = "getKProperty0";
                            break;
                        case 26:
                            objArr[1] = "getKProperty1";
                            break;
                        case 27:
                            objArr[1] = "getKProperty2";
                            break;
                        case 28:
                            objArr[1] = "getKMutableProperty0";
                            break;
                        case 29:
                            objArr[1] = "getKMutableProperty1";
                            break;
                        case 30:
                            objArr[1] = "getKMutableProperty2";
                            break;
                        case 31:
                            objArr[1] = "getIterator";
                            break;
                        case 32:
                            objArr[1] = "getIterable";
                            break;
                        case 33:
                            objArr[1] = "getMutableIterable";
                            break;
                        case 34:
                            objArr[1] = "getMutableIterator";
                            break;
                        case 35:
                            objArr[1] = "getCollection";
                            break;
                        case 36:
                            objArr[1] = "getMutableCollection";
                            break;
                        case 37:
                            objArr[1] = "getList";
                            break;
                        case 38:
                            objArr[1] = "getMutableList";
                            break;
                        case 39:
                            objArr[1] = "getSet";
                            break;
                        case 40:
                            objArr[1] = "getMutableSet";
                            break;
                        case 41:
                            objArr[1] = "getMap";
                            break;
                        case 42:
                            objArr[1] = "getMutableMap";
                            break;
                        case 43:
                            objArr[1] = "getMapEntry";
                            break;
                        case 44:
                            objArr[1] = "getMutableMapEntry";
                            break;
                        case 45:
                            objArr[1] = "getListIterator";
                            break;
                        case 46:
                            objArr[1] = "getMutableListIterator";
                            break;
                        default:
                            switch (i) {
                                case 48:
                                    objArr[1] = "getBuiltInTypeByClassName";
                                    break;
                                case 49:
                                    objArr[1] = "getNothingType";
                                    break;
                                case 50:
                                    objArr[1] = "getNullableNothingType";
                                    break;
                                case 51:
                                    objArr[1] = "getAnyType";
                                    break;
                                case 52:
                                    objArr[1] = "getNullableAnyType";
                                    break;
                                case 53:
                                    objArr[1] = "getDefaultBound";
                                    break;
                                default:
                                    switch (i) {
                                        case com.alibaba.fastjson.asm.Opcodes.LSTORE /* 55 */:
                                            objArr[1] = "getPrimitiveKotlinType";
                                            break;
                                        case 56:
                                            objArr[1] = "getNumberType";
                                            break;
                                        case com.alibaba.fastjson.asm.Opcodes.DSTORE /* 57 */:
                                            objArr[1] = "getByteType";
                                            break;
                                        case 58:
                                            objArr[1] = "getShortType";
                                            break;
                                        case 59:
                                            objArr[1] = "getIntType";
                                            break;
                                        case 60:
                                            objArr[1] = "getLongType";
                                            break;
                                        case kotlinx.coroutines.internal.LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                                            objArr[1] = "getFloatType";
                                            break;
                                        case 62:
                                            objArr[1] = "getDoubleType";
                                            break;
                                        case androidx.core.text.HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                                            objArr[1] = "getCharType";
                                            break;
                                        case 64:
                                            objArr[1] = "getBooleanType";
                                            break;
                                        case org.mozilla.universalchardet.prober.CharsetProber.ASCII_A_CAPITAL /* 65 */:
                                            objArr[1] = "getUnitType";
                                            break;
                                        case tv.danmaku.ijk.media.player.IjkMediaMeta.FF_PROFILE_H264_BASELINE /* 66 */:
                                            objArr[1] = "getStringType";
                                            break;
                                        case 67:
                                            objArr[1] = "getIterableType";
                                            break;
                                        default:
                                            objArr[1] = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns";
                                            break;
                                    }
                                    break;
                            }
                            break;
                    }
                    break;
            }
        } else {
            objArr[1] = "getAnnotationType";
        }
        switch (i) {
            case 1:
                objArr[2] = "setBuiltInsModule";
                break;
            case 2:
                objArr[2] = "setPostponedBuiltinsModuleComputation";
                break;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 11:
            case 13:
            case 15:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case com.alibaba.fastjson.asm.Opcodes.LSTORE /* 55 */:
            case 56:
            case com.alibaba.fastjson.asm.Opcodes.DSTORE /* 57 */:
            case 58:
            case 59:
            case 60:
            case kotlinx.coroutines.internal.LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
            case 62:
            case androidx.core.text.HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
            case 64:
            case org.mozilla.universalchardet.prober.CharsetProber.ASCII_A_CAPITAL /* 65 */:
            case tv.danmaku.ijk.media.player.IjkMediaMeta.FF_PROFILE_H264_BASELINE /* 66 */:
            case 67:
            case 69:
            case io.dcloud.common.DHInterface.IMgr.WindowEvent.WINDOW_BACKGROUND_SET_WEBPARENT /* 74 */:
            case io.dcloud.common.DHInterface.IMgr.WindowEvent.OBTAIN_APP_TOP_PAGE_DIRECT /* 81 */:
            case 84:
            case 86:
            case com.alibaba.fastjson.asm.Opcodes.POP /* 87 */:
                break;
            case 9:
                objArr[2] = "isBuiltIn";
                break;
            case 10:
                objArr[2] = "isUnderKotlinPackage";
                break;
            case 12:
                objArr[2] = "getBuiltInClassByFqName";
                break;
            case 14:
                objArr[2] = "getBuiltInClassByName";
                break;
            case 16:
                objArr[2] = "getPrimitiveClassDescriptor";
                break;
            case 17:
                objArr[2] = "getPrimitiveArrayClassDescriptor";
                break;
            case 47:
                objArr[2] = "getBuiltInTypeByClassName";
                break;
            case 54:
                objArr[2] = "getPrimitiveKotlinType";
                break;
            case 68:
                objArr[2] = "getArrayElementType";
                break;
            case io.dcloud.common.DHInterface.IMgr.WindowEvent.WINDOW_ANIMATION_END /* 70 */:
                objArr[2] = "getArrayElementTypeOrNull";
                break;
            case io.dcloud.common.DHInterface.IMgr.WindowEvent.ADD_ANIMATION_CALLBACK /* 71 */:
            case io.dcloud.common.DHInterface.IMgr.WindowEvent.WINDOW_CRATE_TITLENVIEW /* 72 */:
                objArr[2] = "getElementTypeForUnsignedArray";
                break;
            case io.dcloud.common.DHInterface.IMgr.WindowEvent.WINDOW_APPEND_TITLENVIEW /* 73 */:
                objArr[2] = "getPrimitiveArrayKotlinType";
                break;
            case io.dcloud.common.DHInterface.IMgr.WindowEvent.WINDOW_UPDATE_BACKGROUND /* 75 */:
                objArr[2] = "getPrimitiveArrayKotlinTypeByPrimitiveKotlinType";
                break;
            case io.dcloud.common.DHInterface.IMgr.WindowEvent.CHECK_RESTART_TOP_WEBVIEW /* 76 */:
            case 93:
                objArr[2] = "getPrimitiveType";
                break;
            case 77:
                objArr[2] = "getPrimitiveArrayType";
                break;
            case io.dcloud.common.DHInterface.IMgr.WindowEvent.OBTAIN_MP_TOP_PAGE_URL /* 78 */:
            case 79:
            case 80:
            case 82:
            case 83:
                objArr[2] = "getArrayType";
                break;
            case com.facebook.imagepipeline.transcoder.JpegTranscoderUtils.DEFAULT_JPEG_QUALITY /* 85 */:
                objArr[2] = "getEnumType";
                break;
            case tv.danmaku.ijk.media.player.IjkMediaMeta.FF_PROFILE_H264_EXTENDED /* 88 */:
                objArr[2] = "isArray";
                break;
            case com.alibaba.fastjson.asm.Opcodes.DUP /* 89 */:
            case 90:
                objArr[2] = "isArrayOrPrimitiveArray";
                break;
            case 91:
                objArr[2] = "isPrimitiveArray";
                break;
            case 92:
                objArr[2] = "getPrimitiveArrayElementType";
                break;
            case 94:
                objArr[2] = "isPrimitiveType";
                break;
            case 95:
                objArr[2] = "isPrimitiveTypeOrNullablePrimitiveType";
                break;
            case com.alibaba.fastjson.asm.Opcodes.IADD /* 96 */:
                objArr[2] = "isPrimitiveClass";
                break;
            case org.mozilla.universalchardet.prober.CharsetProber.ASCII_A /* 97 */:
            case 98:
            case 99:
            case 100:
                objArr[2] = "isConstructedFromGivenClass";
                break;
            case 101:
            case 102:
                objArr[2] = "isTypeConstructorForGivenClass";
                break;
            case 103:
            case androidx.core.location.LocationRequestCompat.QUALITY_LOW_POWER /* 104 */:
                objArr[2] = "classFqNameEquals";
                break;
            case 105:
            case 106:
                objArr[2] = "isNotNullConstructedFromGivenClass";
                break;
            case 107:
                objArr[2] = "isSpecialClassWithNoSupertypes";
                break;
            case androidx.appcompat.app.AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR /* 108 */:
            case androidx.appcompat.app.AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY /* 109 */:
                objArr[2] = "isAny";
                break;
            case tv.danmaku.ijk.media.player.IjkMediaMeta.FF_PROFILE_H264_HIGH_10 /* 110 */:
            case 112:
                objArr[2] = "isBoolean";
                break;
            case 111:
                objArr[2] = "isBooleanOrNullableBoolean";
                break;
            case 113:
                objArr[2] = "isNumber";
                break;
            case uni.app.UNIGF0182AE.BuildConfig.VERSION_CODE /* 114 */:
                objArr[2] = "isChar";
                break;
            case 115:
                objArr[2] = "isCharOrNullableChar";
                break;
            case 116:
                objArr[2] = "isInt";
                break;
            case 117:
                objArr[2] = "isByte";
                break;
            case 118:
                objArr[2] = "isLong";
                break;
            case 119:
                objArr[2] = "isLongOrNullableLong";
                break;
            case 120:
                objArr[2] = "isShort";
                break;
            case 121:
                objArr[2] = "isFloat";
                break;
            case 122:
                objArr[2] = "isFloatOrNullableFloat";
                break;
            case 123:
                objArr[2] = "isDouble";
                break;
            case 124:
                objArr[2] = "isUByte";
                break;
            case 125:
                objArr[2] = "isUShort";
                break;
            case 126:
                objArr[2] = "isUInt";
                break;
            case kotlinx.coroutines.scheduling.WorkQueueKt.MASK /* 127 */:
                objArr[2] = "isULong";
                break;
            case 128:
                objArr[2] = "isUByteArray";
                break;
            case 129:
                objArr[2] = "isUShortArray";
                break;
            case org.mozilla.universalchardet.prober.contextanalysis.SJISContextAnalysis.HIRAGANA_HIGHBYTE /* 130 */:
                objArr[2] = "isUIntArray";
                break;
            case 131:
                objArr[2] = "isULongArray";
                break;
            case 132:
                objArr[2] = "isUnsignedArrayType";
                break;
            case 133:
                objArr[2] = "isDoubleOrNullableDouble";
                break;
            case 134:
            case 135:
                objArr[2] = "isConstructedFromGivenClassAndNotNullable";
                break;
            case 136:
                objArr[2] = "isNothing";
                break;
            case 137:
                objArr[2] = "isNullableNothing";
                break;
            case 138:
                objArr[2] = "isNothingOrNullableNothing";
                break;
            case 139:
                objArr[2] = "isAnyOrNullableAny";
                break;
            case 140:
                objArr[2] = "isNullableAny";
                break;
            case 141:
                objArr[2] = "isDefaultBound";
                break;
            case org.mozilla.universalchardet.prober.contextanalysis.EUCJPContextAnalysis.SINGLE_SHIFT_2 /* 142 */:
                objArr[2] = "isUnit";
                break;
            case org.mozilla.universalchardet.prober.contextanalysis.EUCJPContextAnalysis.SINGLE_SHIFT_3 /* 143 */:
                objArr[2] = "mayReturnNonUnitValue";
                break;
            case tv.danmaku.ijk.media.player.IjkMediaMeta.FF_PROFILE_H264_HIGH_444 /* 144 */:
                objArr[2] = "isUnitOrNullableUnit";
                break;
            case 145:
                objArr[2] = "isBooleanOrSubtype";
                break;
            case 146:
                objArr[2] = "isMemberOfAny";
                break;
            case 147:
            case com.alibaba.fastjson.asm.Opcodes.LCMP /* 148 */:
                objArr[2] = "isEnum";
                break;
            case com.alibaba.fastjson.asm.Opcodes.FCMPL /* 149 */:
            case 150:
                objArr[2] = "isComparable";
                break;
            case com.alibaba.fastjson.asm.Opcodes.DCMPL /* 151 */:
                objArr[2] = "isCollectionOrNullableCollection";
                break;
            case 152:
                objArr[2] = "isListOrNullableList";
                break;
            case com.alibaba.fastjson.asm.Opcodes.IFEQ /* 153 */:
                objArr[2] = "isSetOrNullableSet";
                break;
            case com.alibaba.fastjson.asm.Opcodes.IFNE /* 154 */:
                objArr[2] = "isMapOrNullableMap";
                break;
            case 155:
                objArr[2] = "isIterableOrNullableIterable";
                break;
            case 156:
                objArr[2] = "isThrowableOrNullableThrowable";
                break;
            case 157:
                objArr[2] = "isThrowable";
                break;
            case com.alibaba.fastjson.asm.Opcodes.IFLE /* 158 */:
                objArr[2] = "isKClass";
                break;
            case 159:
                objArr[2] = "isNonPrimitiveArray";
                break;
            case com.alibaba.fastjson.asm.Opcodes.IF_ICMPNE /* 160 */:
                objArr[2] = "isDeprecated";
                break;
            case 161:
                objArr[2] = "isNotNullOrNullableFunctionSupertype";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        java.lang.String str2 = java.lang.String.format(str, objArr);
        if (i != 11 && i != 13 && i != 15 && i != 69 && i != 74 && i != 81 && i != 84 && i != 86 && i != 87) {
            switch (i) {
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                    break;
                default:
                    switch (i) {
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                        case 26:
                        case 27:
                        case 28:
                        case 29:
                        case 30:
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                        case 38:
                        case 39:
                        case 40:
                        case 41:
                        case 42:
                        case 43:
                        case 44:
                        case 45:
                        case 46:
                            break;
                        default:
                            switch (i) {
                                case 48:
                                case 49:
                                case 50:
                                case 51:
                                case 52:
                                case 53:
                                    break;
                                default:
                                    switch (i) {
                                        case com.alibaba.fastjson.asm.Opcodes.LSTORE /* 55 */:
                                        case 56:
                                        case com.alibaba.fastjson.asm.Opcodes.DSTORE /* 57 */:
                                        case 58:
                                        case 59:
                                        case 60:
                                        case kotlinx.coroutines.internal.LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                                        case 62:
                                        case androidx.core.text.HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                                        case 64:
                                        case org.mozilla.universalchardet.prober.CharsetProber.ASCII_A_CAPITAL /* 65 */:
                                        case tv.danmaku.ijk.media.player.IjkMediaMeta.FF_PROFILE_H264_BASELINE /* 66 */:
                                        case 67:
                                            break;
                                        default:
                                            throw new java.lang.IllegalArgumentException(str2);
                                    }
                                    break;
                            }
                            break;
                    }
                    break;
            }
        }
        throw new java.lang.IllegalStateException(str2);
    }

    protected KotlinBuiltIns(kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager) {
        if (storageManager == null) {
            $$$reportNull$$$0(0);
        }
        this.storageManager = storageManager;
        this.builtInPackagesImportedByDefault = storageManager.createLazyValue(new kotlin.jvm.functions.Function0<java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.1
            @Override // kotlin.jvm.functions.Function0
            public java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor> invoke() {
                return java.util.Arrays.asList(kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.this.getBuiltInsModule().getPackage(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.BUILT_INS_PACKAGE_FQ_NAME), kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.this.getBuiltInsModule().getPackage(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.COLLECTIONS_PACKAGE_FQ_NAME), kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.this.getBuiltInsModule().getPackage(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.RANGES_PACKAGE_FQ_NAME), kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.this.getBuiltInsModule().getPackage(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.ANNOTATION_PACKAGE_FQ_NAME));
            }
        });
        this.primitives = storageManager.createLazyValue(new kotlin.jvm.functions.Function0<kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.Primitives>() { // from class: kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.2
            @Override // kotlin.jvm.functions.Function0
            public kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.Primitives invoke() {
                java.util.EnumMap enumMap = new java.util.EnumMap(kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType.class);
                java.util.HashMap map = new java.util.HashMap();
                java.util.HashMap map2 = new java.util.HashMap();
                for (kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType primitiveType : kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType.values()) {
                    kotlin.reflect.jvm.internal.impl.types.SimpleType builtInTypeByClassName = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.this.getBuiltInTypeByClassName(primitiveType.getTypeName().asString());
                    kotlin.reflect.jvm.internal.impl.types.SimpleType builtInTypeByClassName2 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.this.getBuiltInTypeByClassName(primitiveType.getArrayTypeName().asString());
                    enumMap.put(primitiveType, builtInTypeByClassName2);
                    map.put(builtInTypeByClassName, builtInTypeByClassName2);
                    map2.put(builtInTypeByClassName2, builtInTypeByClassName);
                }
                return new kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.Primitives(enumMap, map, map2);
            }
        });
        this.builtInClassesByName = storageManager.createMemoizedFunction(new kotlin.jvm.functions.Function1<kotlin.reflect.jvm.internal.impl.name.Name, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.3
            @Override // kotlin.jvm.functions.Function1
            public kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor invoke2(kotlin.reflect.jvm.internal.impl.name.Name name) {
                kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor contributedClassifier = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.this.getBuiltInsPackageScope().mo1837getContributedClassifier(name, kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation.FROM_BUILTINS);
                if (contributedClassifier == null) {
                    throw new java.lang.AssertionError("Built-in class " + kotlin.reflect.jvm.internal.impl.builtins.StandardNames.BUILT_INS_PACKAGE_FQ_NAME.child(name) + " is not found");
                }
                if (!(contributedClassifier instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor)) {
                    throw new java.lang.AssertionError("Must be a class descriptor " + name + ", but was " + contributedClassifier);
                }
                return (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) contributedClassifier;
            }
        });
    }

    protected void createBuiltInsModule(boolean z) {
        kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl moduleDescriptorImpl = new kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl(BUILTINS_MODULE_NAME, this.storageManager, this, null);
        this.builtInsModule = moduleDescriptorImpl;
        moduleDescriptorImpl.initialize(kotlin.reflect.jvm.internal.impl.builtins.BuiltInsLoader.Companion.getInstance().createPackageFragmentProvider(this.storageManager, this.builtInsModule, getClassDescriptorFactories(), getPlatformDependentDeclarationFilter(), getAdditionalClassPartsProvider(), z));
        kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl moduleDescriptorImpl2 = this.builtInsModule;
        moduleDescriptorImpl2.setDependencies(moduleDescriptorImpl2);
    }

    public void setBuiltInsModule(final kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl moduleDescriptorImpl) {
        if (moduleDescriptorImpl == null) {
            $$$reportNull$$$0(1);
        }
        this.storageManager.compute(new kotlin.jvm.functions.Function0<java.lang.Void>() { // from class: kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.4
            @Override // kotlin.jvm.functions.Function0
            public java.lang.Void invoke() {
                if (kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.this.builtInsModule != null) {
                    throw new java.lang.AssertionError("Built-ins module is already set: " + kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.this.builtInsModule + " (attempting to reset to " + moduleDescriptorImpl + com.taobao.weex.el.parse.Operators.BRACKET_END_STR);
                }
                kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.this.builtInsModule = moduleDescriptorImpl;
                return null;
            }
        });
    }

    protected kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider getAdditionalClassPartsProvider() {
        kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider.None none = kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider.None.INSTANCE;
        if (none == null) {
            $$$reportNull$$$0(3);
        }
        return none;
    }

    protected kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter getPlatformDependentDeclarationFilter() {
        kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter.NoPlatformDependent noPlatformDependent = kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter.NoPlatformDependent.INSTANCE;
        if (noPlatformDependent == null) {
            $$$reportNull$$$0(4);
        }
        return noPlatformDependent;
    }

    protected java.lang.Iterable<kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory> getClassDescriptorFactories() {
        java.util.List listSingletonList = java.util.Collections.singletonList(new kotlin.reflect.jvm.internal.impl.builtins.functions.BuiltInFictitiousFunctionClassFactory(this.storageManager, getBuiltInsModule()));
        if (listSingletonList == null) {
            $$$reportNull$$$0(5);
        }
        return listSingletonList;
    }

    protected kotlin.reflect.jvm.internal.impl.storage.StorageManager getStorageManager() {
        kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager = this.storageManager;
        if (storageManager == null) {
            $$$reportNull$$$0(6);
        }
        return storageManager;
    }

    private static class Primitives {
        public final java.util.Map<kotlin.reflect.jvm.internal.impl.types.SimpleType, kotlin.reflect.jvm.internal.impl.types.SimpleType> kotlinArrayTypeToPrimitiveKotlinType;
        public final java.util.Map<kotlin.reflect.jvm.internal.impl.types.KotlinType, kotlin.reflect.jvm.internal.impl.types.SimpleType> primitiveKotlinTypeToKotlinArrayType;
        public final java.util.Map<kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType, kotlin.reflect.jvm.internal.impl.types.SimpleType> primitiveTypeToArrayKotlinType;

        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            java.lang.Object[] objArr = new java.lang.Object[3];
            if (i == 1) {
                objArr[0] = "primitiveKotlinTypeToKotlinArrayType";
            } else if (i != 2) {
                objArr[0] = "primitiveTypeToArrayKotlinType";
            } else {
                objArr[0] = "kotlinArrayTypeToPrimitiveKotlinType";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns$Primitives";
            objArr[2] = "<init>";
            throw new java.lang.IllegalArgumentException(java.lang.String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        private Primitives(java.util.Map<kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType, kotlin.reflect.jvm.internal.impl.types.SimpleType> map, java.util.Map<kotlin.reflect.jvm.internal.impl.types.KotlinType, kotlin.reflect.jvm.internal.impl.types.SimpleType> map2, java.util.Map<kotlin.reflect.jvm.internal.impl.types.SimpleType, kotlin.reflect.jvm.internal.impl.types.SimpleType> map3) {
            if (map == null) {
                $$$reportNull$$$0(0);
            }
            if (map2 == null) {
                $$$reportNull$$$0(1);
            }
            if (map3 == null) {
                $$$reportNull$$$0(2);
            }
            this.primitiveTypeToArrayKotlinType = map;
            this.primitiveKotlinTypeToKotlinArrayType = map2;
            this.kotlinArrayTypeToPrimitiveKotlinType = map3;
        }
    }

    public kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl getBuiltInsModule() {
        if (this.builtInsModule == null) {
            this.builtInsModule = this.postponedBuiltInsModule.invoke();
        }
        kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl moduleDescriptorImpl = this.builtInsModule;
        if (moduleDescriptorImpl == null) {
            $$$reportNull$$$0(7);
        }
        return moduleDescriptorImpl;
    }

    public static boolean isBuiltIn(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(9);
        }
        return kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.getParentOfType(declarationDescriptor, kotlin.reflect.jvm.internal.impl.builtins.BuiltInsPackageFragment.class, false) != null;
    }

    public static boolean isUnderKotlinPackage(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(10);
        }
        while (declarationDescriptor != null) {
            if (declarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor) {
                return ((kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor) declarationDescriptor).getFqName().startsWith(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.BUILT_INS_PACKAGE_NAME);
            }
            declarationDescriptor = declarationDescriptor.getContainingDeclaration();
        }
        return false;
    }

    public kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope getBuiltInsPackageScope() {
        kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope memberScope = getBuiltInsModule().getPackage(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.BUILT_INS_PACKAGE_FQ_NAME).getMemberScope();
        if (memberScope == null) {
            $$$reportNull$$$0(11);
        }
        return memberScope;
    }

    public kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor getBuiltInClassByFqName(kotlin.reflect.jvm.internal.impl.name.FqName fqName) {
        if (fqName == null) {
            $$$reportNull$$$0(12);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptorResolveClassByFqName = kotlin.reflect.jvm.internal.impl.descriptors.DescriptorUtilKt.resolveClassByFqName(getBuiltInsModule(), fqName, kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation.FROM_BUILTINS);
        if (classDescriptorResolveClassByFqName == null) {
            $$$reportNull$$$0(13);
        }
        return classDescriptorResolveClassByFqName;
    }

    private kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor getBuiltInClassByName(java.lang.String str) {
        if (str == null) {
            $$$reportNull$$$0(14);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptorInvoke = this.builtInClassesByName.invoke2(kotlin.reflect.jvm.internal.impl.name.Name.identifier(str));
        if (classDescriptorInvoke == null) {
            $$$reportNull$$$0(15);
        }
        return classDescriptorInvoke;
    }

    public kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor getAny() {
        return getBuiltInClassByName("Any");
    }

    public kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor getNothing() {
        return getBuiltInClassByName("Nothing");
    }

    private kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor getPrimitiveClassDescriptor(kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType primitiveType) {
        if (primitiveType == null) {
            $$$reportNull$$$0(16);
        }
        return getBuiltInClassByName(primitiveType.getTypeName().asString());
    }

    public kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor getArray() {
        return getBuiltInClassByName("Array");
    }

    public kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor getNumber() {
        return getBuiltInClassByName("Number");
    }

    public kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor getUnit() {
        return getBuiltInClassByName("Unit");
    }

    public kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor getFunction(int i) {
        return getBuiltInClassByName(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.getFunctionName(i));
    }

    public kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor getSuspendFunction(int i) {
        kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor builtInClassByFqName = getBuiltInClassByFqName(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.COROUTINES_PACKAGE_FQ_NAME.child(kotlin.reflect.jvm.internal.impl.name.Name.identifier(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.getSuspendFunctionName(i))));
        if (builtInClassByFqName == null) {
            $$$reportNull$$$0(18);
        }
        return builtInClassByFqName;
    }

    public kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor getString() {
        return getBuiltInClassByName("String");
    }

    public kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor getComparable() {
        return getBuiltInClassByName("Comparable");
    }

    public kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor getKClass() {
        kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor builtInClassByFqName = getBuiltInClassByFqName(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.kClass.toSafe());
        if (builtInClassByFqName == null) {
            $$$reportNull$$$0(21);
        }
        return builtInClassByFqName;
    }

    public kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor getCollection() {
        kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor builtInClassByFqName = getBuiltInClassByFqName(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.collection);
        if (builtInClassByFqName == null) {
            $$$reportNull$$$0(35);
        }
        return builtInClassByFqName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public kotlin.reflect.jvm.internal.impl.types.SimpleType getBuiltInTypeByClassName(java.lang.String str) {
        if (str == null) {
            $$$reportNull$$$0(47);
        }
        kotlin.reflect.jvm.internal.impl.types.SimpleType defaultType = getBuiltInClassByName(str).getDefaultType();
        if (defaultType == null) {
            $$$reportNull$$$0(48);
        }
        return defaultType;
    }

    public kotlin.reflect.jvm.internal.impl.types.SimpleType getNothingType() {
        kotlin.reflect.jvm.internal.impl.types.SimpleType defaultType = getNothing().getDefaultType();
        if (defaultType == null) {
            $$$reportNull$$$0(49);
        }
        return defaultType;
    }

    public kotlin.reflect.jvm.internal.impl.types.SimpleType getNullableNothingType() {
        kotlin.reflect.jvm.internal.impl.types.SimpleType simpleTypeMakeNullableAsSpecified = getNothingType().makeNullableAsSpecified(true);
        if (simpleTypeMakeNullableAsSpecified == null) {
            $$$reportNull$$$0(50);
        }
        return simpleTypeMakeNullableAsSpecified;
    }

    public kotlin.reflect.jvm.internal.impl.types.SimpleType getAnyType() {
        kotlin.reflect.jvm.internal.impl.types.SimpleType defaultType = getAny().getDefaultType();
        if (defaultType == null) {
            $$$reportNull$$$0(51);
        }
        return defaultType;
    }

    public kotlin.reflect.jvm.internal.impl.types.SimpleType getNullableAnyType() {
        kotlin.reflect.jvm.internal.impl.types.SimpleType simpleTypeMakeNullableAsSpecified = getAnyType().makeNullableAsSpecified(true);
        if (simpleTypeMakeNullableAsSpecified == null) {
            $$$reportNull$$$0(52);
        }
        return simpleTypeMakeNullableAsSpecified;
    }

    public kotlin.reflect.jvm.internal.impl.types.SimpleType getDefaultBound() {
        kotlin.reflect.jvm.internal.impl.types.SimpleType nullableAnyType = getNullableAnyType();
        if (nullableAnyType == null) {
            $$$reportNull$$$0(53);
        }
        return nullableAnyType;
    }

    public kotlin.reflect.jvm.internal.impl.types.SimpleType getPrimitiveKotlinType(kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType primitiveType) {
        if (primitiveType == null) {
            $$$reportNull$$$0(54);
        }
        kotlin.reflect.jvm.internal.impl.types.SimpleType defaultType = getPrimitiveClassDescriptor(primitiveType).getDefaultType();
        if (defaultType == null) {
            $$$reportNull$$$0(55);
        }
        return defaultType;
    }

    public kotlin.reflect.jvm.internal.impl.types.SimpleType getNumberType() {
        kotlin.reflect.jvm.internal.impl.types.SimpleType defaultType = getNumber().getDefaultType();
        if (defaultType == null) {
            $$$reportNull$$$0(56);
        }
        return defaultType;
    }

    public kotlin.reflect.jvm.internal.impl.types.SimpleType getByteType() {
        kotlin.reflect.jvm.internal.impl.types.SimpleType primitiveKotlinType = getPrimitiveKotlinType(kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType.BYTE);
        if (primitiveKotlinType == null) {
            $$$reportNull$$$0(57);
        }
        return primitiveKotlinType;
    }

    public kotlin.reflect.jvm.internal.impl.types.SimpleType getShortType() {
        kotlin.reflect.jvm.internal.impl.types.SimpleType primitiveKotlinType = getPrimitiveKotlinType(kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType.SHORT);
        if (primitiveKotlinType == null) {
            $$$reportNull$$$0(58);
        }
        return primitiveKotlinType;
    }

    public kotlin.reflect.jvm.internal.impl.types.SimpleType getIntType() {
        kotlin.reflect.jvm.internal.impl.types.SimpleType primitiveKotlinType = getPrimitiveKotlinType(kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType.INT);
        if (primitiveKotlinType == null) {
            $$$reportNull$$$0(59);
        }
        return primitiveKotlinType;
    }

    public kotlin.reflect.jvm.internal.impl.types.SimpleType getLongType() {
        kotlin.reflect.jvm.internal.impl.types.SimpleType primitiveKotlinType = getPrimitiveKotlinType(kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType.LONG);
        if (primitiveKotlinType == null) {
            $$$reportNull$$$0(60);
        }
        return primitiveKotlinType;
    }

    public kotlin.reflect.jvm.internal.impl.types.SimpleType getFloatType() {
        kotlin.reflect.jvm.internal.impl.types.SimpleType primitiveKotlinType = getPrimitiveKotlinType(kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType.FLOAT);
        if (primitiveKotlinType == null) {
            $$$reportNull$$$0(61);
        }
        return primitiveKotlinType;
    }

    public kotlin.reflect.jvm.internal.impl.types.SimpleType getDoubleType() {
        kotlin.reflect.jvm.internal.impl.types.SimpleType primitiveKotlinType = getPrimitiveKotlinType(kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType.DOUBLE);
        if (primitiveKotlinType == null) {
            $$$reportNull$$$0(62);
        }
        return primitiveKotlinType;
    }

    public kotlin.reflect.jvm.internal.impl.types.SimpleType getCharType() {
        kotlin.reflect.jvm.internal.impl.types.SimpleType primitiveKotlinType = getPrimitiveKotlinType(kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType.CHAR);
        if (primitiveKotlinType == null) {
            $$$reportNull$$$0(63);
        }
        return primitiveKotlinType;
    }

    public kotlin.reflect.jvm.internal.impl.types.SimpleType getBooleanType() {
        kotlin.reflect.jvm.internal.impl.types.SimpleType primitiveKotlinType = getPrimitiveKotlinType(kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType.BOOLEAN);
        if (primitiveKotlinType == null) {
            $$$reportNull$$$0(64);
        }
        return primitiveKotlinType;
    }

    public kotlin.reflect.jvm.internal.impl.types.SimpleType getUnitType() {
        kotlin.reflect.jvm.internal.impl.types.SimpleType defaultType = getUnit().getDefaultType();
        if (defaultType == null) {
            $$$reportNull$$$0(65);
        }
        return defaultType;
    }

    public kotlin.reflect.jvm.internal.impl.types.SimpleType getStringType() {
        kotlin.reflect.jvm.internal.impl.types.SimpleType defaultType = getString().getDefaultType();
        if (defaultType == null) {
            $$$reportNull$$$0(66);
        }
        return defaultType;
    }

    public kotlin.reflect.jvm.internal.impl.types.KotlinType getArrayElementType(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(68);
        }
        kotlin.reflect.jvm.internal.impl.types.KotlinType arrayElementTypeOrNull = getArrayElementTypeOrNull(kotlinType);
        if (arrayElementTypeOrNull != null) {
            if (arrayElementTypeOrNull == null) {
                $$$reportNull$$$0(69);
            }
            return arrayElementTypeOrNull;
        }
        throw new java.lang.IllegalStateException("not array: " + kotlinType);
    }

    public kotlin.reflect.jvm.internal.impl.types.KotlinType getArrayElementTypeOrNull(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        kotlin.reflect.jvm.internal.impl.types.KotlinType elementTypeForUnsignedArray;
        if (kotlinType == null) {
            $$$reportNull$$$0(70);
        }
        if (isArray(kotlinType)) {
            if (kotlinType.getArguments().size() != 1) {
                return null;
            }
            return kotlinType.getArguments().get(0).getType();
        }
        kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinTypeMakeNotNullable = kotlin.reflect.jvm.internal.impl.types.TypeUtils.makeNotNullable(kotlinType);
        kotlin.reflect.jvm.internal.impl.types.SimpleType simpleType = this.primitives.invoke().kotlinArrayTypeToPrimitiveKotlinType.get(kotlinTypeMakeNotNullable);
        if (simpleType != null) {
            return simpleType;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor containingModuleOrNull = kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.getContainingModuleOrNull(kotlinTypeMakeNotNullable);
        if (containingModuleOrNull == null || (elementTypeForUnsignedArray = getElementTypeForUnsignedArray(kotlinTypeMakeNotNullable, containingModuleOrNull)) == null) {
            return null;
        }
        return elementTypeForUnsignedArray;
    }

    private static kotlin.reflect.jvm.internal.impl.types.KotlinType getElementTypeForUnsignedArray(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType, kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor moduleDescriptor) {
        kotlin.reflect.jvm.internal.impl.name.ClassId classId;
        kotlin.reflect.jvm.internal.impl.name.ClassId unsignedClassIdByArrayClassId;
        kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptorFindClassAcrossModuleDependencies;
        if (kotlinType == null) {
            $$$reportNull$$$0(71);
        }
        if (moduleDescriptor == null) {
            $$$reportNull$$$0(72);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor = kotlinType.getConstructor().mo1835getDeclarationDescriptor();
        if (classifierDescriptorMo1835getDeclarationDescriptor == null || !kotlin.reflect.jvm.internal.impl.builtins.UnsignedTypes.INSTANCE.isShortNameOfUnsignedArray(classifierDescriptorMo1835getDeclarationDescriptor.getName()) || (classId = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getClassId(classifierDescriptorMo1835getDeclarationDescriptor)) == null || (unsignedClassIdByArrayClassId = kotlin.reflect.jvm.internal.impl.builtins.UnsignedTypes.INSTANCE.getUnsignedClassIdByArrayClassId(classId)) == null || (classDescriptorFindClassAcrossModuleDependencies = kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt.findClassAcrossModuleDependencies(moduleDescriptor, unsignedClassIdByArrayClassId)) == null) {
            return null;
        }
        return classDescriptorFindClassAcrossModuleDependencies.getDefaultType();
    }

    public kotlin.reflect.jvm.internal.impl.types.SimpleType getPrimitiveArrayKotlinType(kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType primitiveType) {
        if (primitiveType == null) {
            $$$reportNull$$$0(73);
        }
        kotlin.reflect.jvm.internal.impl.types.SimpleType simpleType = this.primitives.invoke().primitiveTypeToArrayKotlinType.get(primitiveType);
        if (simpleType == null) {
            $$$reportNull$$$0(74);
        }
        return simpleType;
    }

    public static kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType getPrimitiveType(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(76);
        }
        if (kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.primitiveTypeShortNames.contains(declarationDescriptor.getName())) {
            return kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.fqNameToPrimitiveType.get(kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.getFqName(declarationDescriptor));
        }
        return null;
    }

    public static kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType getPrimitiveArrayType(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(77);
        }
        if (kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.primitiveArrayTypeShortNames.contains(declarationDescriptor.getName())) {
            return kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.arrayClassFqNameToPrimitiveType.get(kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.getFqName(declarationDescriptor));
        }
        return null;
    }

    public kotlin.reflect.jvm.internal.impl.types.SimpleType getArrayType(kotlin.reflect.jvm.internal.impl.types.Variance variance, kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations annotations) {
        if (variance == null) {
            $$$reportNull$$$0(78);
        }
        if (kotlinType == null) {
            $$$reportNull$$$0(79);
        }
        if (annotations == null) {
            $$$reportNull$$$0(80);
        }
        kotlin.reflect.jvm.internal.impl.types.SimpleType simpleTypeSimpleNotNullType = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.simpleNotNullType(kotlin.reflect.jvm.internal.impl.types.TypeAttributesKt.toDefaultAttributes(annotations), getArray(), java.util.Collections.singletonList(new kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl(variance, kotlinType)));
        if (simpleTypeSimpleNotNullType == null) {
            $$$reportNull$$$0(81);
        }
        return simpleTypeSimpleNotNullType;
    }

    public kotlin.reflect.jvm.internal.impl.types.SimpleType getArrayType(kotlin.reflect.jvm.internal.impl.types.Variance variance, kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        if (variance == null) {
            $$$reportNull$$$0(82);
        }
        if (kotlinType == null) {
            $$$reportNull$$$0(83);
        }
        kotlin.reflect.jvm.internal.impl.types.SimpleType arrayType = getArrayType(variance, kotlinType, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion.getEMPTY());
        if (arrayType == null) {
            $$$reportNull$$$0(84);
        }
        return arrayType;
    }

    public static boolean isArray(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(88);
        }
        return isConstructedFromGivenClass(kotlinType, kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.array);
    }

    public static boolean isArrayOrPrimitiveArray(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor) {
        if (classDescriptor == null) {
            $$$reportNull$$$0(89);
        }
        return classFqNameEquals(classDescriptor, kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.array) || getPrimitiveArrayType(classDescriptor) != null;
    }

    public static boolean isArrayOrPrimitiveArray(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(90);
        }
        return isArray(kotlinType) || isPrimitiveArray(kotlinType);
    }

    public static boolean isPrimitiveArray(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(91);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor = kotlinType.getConstructor().mo1835getDeclarationDescriptor();
        return (classifierDescriptorMo1835getDeclarationDescriptor == null || getPrimitiveArrayType(classifierDescriptorMo1835getDeclarationDescriptor) == null) ? false : true;
    }

    public static kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType getPrimitiveArrayElementType(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(92);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor = kotlinType.getConstructor().mo1835getDeclarationDescriptor();
        if (classifierDescriptorMo1835getDeclarationDescriptor == null) {
            return null;
        }
        return getPrimitiveArrayType(classifierDescriptorMo1835getDeclarationDescriptor);
    }

    public static boolean isPrimitiveType(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(94);
        }
        return !kotlinType.isMarkedNullable() && isPrimitiveTypeOrNullablePrimitiveType(kotlinType);
    }

    public static boolean isPrimitiveTypeOrNullablePrimitiveType(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(95);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor = kotlinType.getConstructor().mo1835getDeclarationDescriptor();
        return (classifierDescriptorMo1835getDeclarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) && isPrimitiveClass((kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) classifierDescriptorMo1835getDeclarationDescriptor);
    }

    public static boolean isPrimitiveClass(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor) {
        if (classDescriptor == null) {
            $$$reportNull$$$0(96);
        }
        return getPrimitiveType(classDescriptor) != null;
    }

    private static boolean isConstructedFromGivenClass(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType, kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe fqNameUnsafe) {
        if (kotlinType == null) {
            $$$reportNull$$$0(97);
        }
        if (fqNameUnsafe == null) {
            $$$reportNull$$$0(98);
        }
        return isTypeConstructorForGivenClass(kotlinType.getConstructor(), fqNameUnsafe);
    }

    public static boolean isTypeConstructorForGivenClass(kotlin.reflect.jvm.internal.impl.types.TypeConstructor typeConstructor, kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe fqNameUnsafe) {
        if (typeConstructor == null) {
            $$$reportNull$$$0(101);
        }
        if (fqNameUnsafe == null) {
            $$$reportNull$$$0(102);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor = typeConstructor.mo1835getDeclarationDescriptor();
        return (classifierDescriptorMo1835getDeclarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) && classFqNameEquals(classifierDescriptorMo1835getDeclarationDescriptor, fqNameUnsafe);
    }

    private static boolean classFqNameEquals(kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptor, kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe fqNameUnsafe) {
        if (classifierDescriptor == null) {
            $$$reportNull$$$0(103);
        }
        if (fqNameUnsafe == null) {
            $$$reportNull$$$0(androidx.core.location.LocationRequestCompat.QUALITY_LOW_POWER);
        }
        return classifierDescriptor.getName().equals(fqNameUnsafe.shortName()) && fqNameUnsafe.equals(kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.getFqName(classifierDescriptor));
    }

    private static boolean isNotNullConstructedFromGivenClass(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType, kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe fqNameUnsafe) {
        if (kotlinType == null) {
            $$$reportNull$$$0(105);
        }
        if (fqNameUnsafe == null) {
            $$$reportNull$$$0(106);
        }
        return !kotlinType.isMarkedNullable() && isConstructedFromGivenClass(kotlinType, fqNameUnsafe);
    }

    public static boolean isSpecialClassWithNoSupertypes(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor) {
        if (classDescriptor == null) {
            $$$reportNull$$$0(107);
        }
        return classFqNameEquals(classDescriptor, kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.any) || classFqNameEquals(classDescriptor, kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.nothing);
    }

    public static boolean isAny(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor) {
        if (classDescriptor == null) {
            $$$reportNull$$$0(androidx.appcompat.app.AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR);
        }
        return classFqNameEquals(classDescriptor, kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.any);
    }

    public static boolean isBoolean(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(tv.danmaku.ijk.media.player.IjkMediaMeta.FF_PROFILE_H264_HIGH_10);
        }
        return isConstructedFromGivenClassAndNotNullable(kotlinType, kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames._boolean);
    }

    public static boolean isUByteArray(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(128);
        }
        return isConstructedFromGivenClassAndNotNullable(kotlinType, kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.uByteArrayFqName.toUnsafe());
    }

    public static boolean isUShortArray(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(129);
        }
        return isConstructedFromGivenClassAndNotNullable(kotlinType, kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.uShortArrayFqName.toUnsafe());
    }

    public static boolean isUIntArray(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(org.mozilla.universalchardet.prober.contextanalysis.SJISContextAnalysis.HIRAGANA_HIGHBYTE);
        }
        return isConstructedFromGivenClassAndNotNullable(kotlinType, kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.uIntArrayFqName.toUnsafe());
    }

    public static boolean isULongArray(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(131);
        }
        return isConstructedFromGivenClassAndNotNullable(kotlinType, kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.uLongArrayFqName.toUnsafe());
    }

    public static boolean isUnsignedArrayType(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(132);
        }
        return isUByteArray(kotlinType) || isUShortArray(kotlinType) || isUIntArray(kotlinType) || isULongArray(kotlinType);
    }

    private static boolean isConstructedFromGivenClassAndNotNullable(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType, kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe fqNameUnsafe) {
        if (kotlinType == null) {
            $$$reportNull$$$0(134);
        }
        if (fqNameUnsafe == null) {
            $$$reportNull$$$0(135);
        }
        return isConstructedFromGivenClass(kotlinType, fqNameUnsafe) && !kotlinType.isMarkedNullable();
    }

    public static boolean isNothing(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(136);
        }
        return isNothingOrNullableNothing(kotlinType) && !kotlin.reflect.jvm.internal.impl.types.TypeUtils.isNullableType(kotlinType);
    }

    public static boolean isNothingOrNullableNothing(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(138);
        }
        return isConstructedFromGivenClass(kotlinType, kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.nothing);
    }

    public static boolean isAnyOrNullableAny(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(139);
        }
        return isConstructedFromGivenClass(kotlinType, kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.any);
    }

    public static boolean isNullableAny(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(140);
        }
        return isAnyOrNullableAny(kotlinType) && kotlinType.isMarkedNullable();
    }

    public static boolean isDefaultBound(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(141);
        }
        return isNullableAny(kotlinType);
    }

    public static boolean isUnit(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        if (kotlinType == null) {
            $$$reportNull$$$0(org.mozilla.universalchardet.prober.contextanalysis.EUCJPContextAnalysis.SINGLE_SHIFT_2);
        }
        return isNotNullConstructedFromGivenClass(kotlinType, kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.unit);
    }

    public static boolean isString(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        return kotlinType != null && isNotNullConstructedFromGivenClass(kotlinType, kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.string);
    }

    public static boolean isKClass(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor) {
        if (classDescriptor == null) {
            $$$reportNull$$$0(com.alibaba.fastjson.asm.Opcodes.IFLE);
        }
        return classFqNameEquals(classDescriptor, kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.kClass);
    }

    public static boolean isDeprecated(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(com.alibaba.fastjson.asm.Opcodes.IF_ICMPNE);
        }
        if (declarationDescriptor.getOriginal().getAnnotations().hasAnnotation(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.deprecated)) {
            return true;
        }
        if (declarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor) {
            kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor propertyDescriptor = (kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor) declarationDescriptor;
            boolean zIsVar = propertyDescriptor.isVar();
            kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor getter = propertyDescriptor.getGetter();
            kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor setter = propertyDescriptor.getSetter();
            if (getter != null && isDeprecated(getter) && (!zIsVar || (setter != null && isDeprecated(setter)))) {
                return true;
            }
        }
        return false;
    }
}
