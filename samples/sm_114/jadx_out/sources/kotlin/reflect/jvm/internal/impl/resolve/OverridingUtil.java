package kotlin.reflect.jvm.internal.impl.resolve;

/* JADX INFO: loaded from: classes2.dex */
public class OverridingUtil {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil DEFAULT;
    private static final kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker.TypeConstructorEquality DEFAULT_TYPE_CONSTRUCTOR_EQUALITY;
    private static final java.util.List<kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition> EXTERNAL_CONDITIONS = kotlin.collections.CollectionsKt.toList(java.util.ServiceLoader.load(kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition.class, kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition.class.getClassLoader()));
    private final kotlin.jvm.functions.Function2<kotlin.reflect.jvm.internal.impl.types.KotlinType, kotlin.reflect.jvm.internal.impl.types.KotlinType, java.lang.Boolean> customSubtype;
    private final kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker.TypeConstructorEquality equalityAxioms;
    private final kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypePreparator kotlinTypePreparator;
    private final kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner kotlinTypeRefiner;

    /* JADX WARN: Code duplicated, block: B:103:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:17:0x0035 A[FALL_THROUGH] */
    /* JADX WARN: Code duplicated, block: B:33:0x0058 A[FALL_THROUGH] */
    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        java.lang.String str;
        int i2;
        if (i != 11 && i != 12 && i != 16 && i != 21 && i != 93 && i != 96 && i != 101 && i != 42 && i != 43) {
            switch (i) {
                default:
                    switch (i) {
                        default:
                            switch (i) {
                                default:
                                    switch (i) {
                                        case tv.danmaku.ijk.media.player.IjkMediaMeta.FF_PROFILE_H264_EXTENDED /* 88 */:
                                        case com.alibaba.fastjson.asm.Opcodes.DUP /* 89 */:
                                        case 90:
                                            break;
                                        default:
                                            str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                                            break;
                                    }
                                case io.dcloud.common.DHInterface.IMgr.WindowEvent.OBTAIN_MP_TOP_PAGE_URL /* 78 */:
                                case 79:
                                case 80:
                                case io.dcloud.common.DHInterface.IMgr.WindowEvent.OBTAIN_APP_TOP_PAGE_DIRECT /* 81 */:
                                case 82:
                                    str = "@NotNull method %s.%s must not return null";
                                    break;
                            }
                        case 30:
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                            str = "@NotNull method %s.%s must not return null";
                            break;
                    }
                case 24:
                case 25:
                case 26:
                case 27:
                    str = "@NotNull method %s.%s must not return null";
                    break;
            }
        } else {
            str = "@NotNull method %s.%s must not return null";
        }
        if (i != 11 && i != 12 && i != 16 && i != 21 && i != 93 && i != 96 && i != 101 && i != 42 && i != 43) {
            switch (i) {
                default:
                    switch (i) {
                        default:
                            switch (i) {
                                default:
                                    switch (i) {
                                        case tv.danmaku.ijk.media.player.IjkMediaMeta.FF_PROFILE_H264_EXTENDED /* 88 */:
                                        case com.alibaba.fastjson.asm.Opcodes.DUP /* 89 */:
                                        case 90:
                                            break;
                                        default:
                                            i2 = 3;
                                            break;
                                    }
                                case io.dcloud.common.DHInterface.IMgr.WindowEvent.OBTAIN_MP_TOP_PAGE_URL /* 78 */:
                                case 79:
                                case 80:
                                case io.dcloud.common.DHInterface.IMgr.WindowEvent.OBTAIN_APP_TOP_PAGE_DIRECT /* 81 */:
                                case 82:
                                    i2 = 2;
                                    break;
                            }
                        case 30:
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                            i2 = 2;
                            break;
                    }
                case 24:
                case 25:
                case 26:
                case 27:
                    i2 = 2;
                    break;
            }
        } else {
            i2 = 2;
        }
        java.lang.Object[] objArr = new java.lang.Object[i2];
        switch (i) {
            case 1:
            case 7:
                objArr[0] = "kotlinTypePreparator";
                break;
            case 2:
                objArr[0] = "customSubtype";
                break;
            case 3:
            case 6:
            default:
                objArr[0] = "kotlinTypeRefiner";
                break;
            case 4:
                objArr[0] = "equalityAxioms";
                break;
            case 5:
                objArr[0] = "axioms";
                break;
            case 8:
            case 9:
                objArr[0] = "candidateSet";
                break;
            case 10:
                objArr[0] = "transformFirst";
                break;
            case 11:
            case 12:
            case 16:
            case 21:
            case 24:
            case 25:
            case 26:
            case 27:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 42:
            case 43:
            case io.dcloud.common.DHInterface.IMgr.WindowEvent.OBTAIN_MP_TOP_PAGE_URL /* 78 */:
            case 79:
            case 80:
            case io.dcloud.common.DHInterface.IMgr.WindowEvent.OBTAIN_APP_TOP_PAGE_DIRECT /* 81 */:
            case 82:
            case tv.danmaku.ijk.media.player.IjkMediaMeta.FF_PROFILE_H264_EXTENDED /* 88 */:
            case com.alibaba.fastjson.asm.Opcodes.DUP /* 89 */:
            case 90:
            case 93:
            case com.alibaba.fastjson.asm.Opcodes.IADD /* 96 */:
            case 101:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil";
                break;
            case 13:
                objArr[0] = "f";
                break;
            case 14:
                objArr[0] = "g";
                break;
            case 15:
            case 17:
                objArr[0] = "descriptor";
                break;
            case 18:
                objArr[0] = "result";
                break;
            case 19:
            case 22:
            case 28:
            case 38:
                objArr[0] = "superDescriptor";
                break;
            case 20:
            case 23:
            case 29:
            case 39:
                objArr[0] = "subDescriptor";
                break;
            case 40:
                objArr[0] = "firstParameters";
                break;
            case 41:
                objArr[0] = "secondParameters";
                break;
            case 44:
                objArr[0] = "typeInSuper";
                break;
            case 45:
                objArr[0] = "typeInSub";
                break;
            case 46:
            case 49:
            case io.dcloud.common.DHInterface.IMgr.WindowEvent.WINDOW_UPDATE_BACKGROUND /* 75 */:
                objArr[0] = "typeCheckerState";
                break;
            case 47:
                objArr[0] = "superTypeParameter";
                break;
            case 48:
                objArr[0] = "subTypeParameter";
                break;
            case 50:
                objArr[0] = "name";
                break;
            case 51:
                objArr[0] = "membersFromSupertypes";
                break;
            case 52:
                objArr[0] = "membersFromCurrent";
                break;
            case 53:
            case 59:
            case 62:
            case 84:
            case com.alibaba.fastjson.asm.Opcodes.POP /* 87 */:
            case 94:
                objArr[0] = "current";
                break;
            case 54:
            case 60:
            case 64:
            case com.facebook.imagepipeline.transcoder.JpegTranscoderUtils.DEFAULT_JPEG_QUALITY /* 85 */:
            case androidx.core.location.LocationRequestCompat.QUALITY_LOW_POWER /* 104 */:
                objArr[0] = com.taobao.weex.common.Constants.Name.STRATEGY;
                break;
            case com.alibaba.fastjson.asm.Opcodes.LSTORE /* 55 */:
                objArr[0] = "overriding";
                break;
            case 56:
                objArr[0] = "fromSuper";
                break;
            case com.alibaba.fastjson.asm.Opcodes.DSTORE /* 57 */:
                objArr[0] = "fromCurrent";
                break;
            case 58:
                objArr[0] = "descriptorsFromSuper";
                break;
            case kotlinx.coroutines.internal.LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
            case androidx.core.text.HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                objArr[0] = "notOverridden";
                break;
            case org.mozilla.universalchardet.prober.CharsetProber.ASCII_A_CAPITAL /* 65 */:
            case 67:
            case io.dcloud.common.DHInterface.IMgr.WindowEvent.ADD_ANIMATION_CALLBACK /* 71 */:
                objArr[0] = "a";
                break;
            case tv.danmaku.ijk.media.player.IjkMediaMeta.FF_PROFILE_H264_BASELINE /* 66 */:
            case 68:
            case io.dcloud.common.DHInterface.IMgr.WindowEvent.WINDOW_APPEND_TITLENVIEW /* 73 */:
                objArr[0] = "b";
                break;
            case 69:
                objArr[0] = "candidate";
                break;
            case io.dcloud.common.DHInterface.IMgr.WindowEvent.WINDOW_ANIMATION_END /* 70 */:
            case 86:
            case 91:
            case 107:
                objArr[0] = "descriptors";
                break;
            case io.dcloud.common.DHInterface.IMgr.WindowEvent.WINDOW_CRATE_TITLENVIEW /* 72 */:
                objArr[0] = "aReturnType";
                break;
            case io.dcloud.common.DHInterface.IMgr.WindowEvent.WINDOW_BACKGROUND_SET_WEBPARENT /* 74 */:
                objArr[0] = "bReturnType";
                break;
            case io.dcloud.common.DHInterface.IMgr.WindowEvent.CHECK_RESTART_TOP_WEBVIEW /* 76 */:
            case 83:
                objArr[0] = "overridables";
                break;
            case 77:
            case 99:
                objArr[0] = "descriptorByHandle";
                break;
            case 92:
                objArr[0] = "classModality";
                break;
            case 95:
                objArr[0] = "toFilter";
                break;
            case org.mozilla.universalchardet.prober.CharsetProber.ASCII_A /* 97 */:
            case 102:
                objArr[0] = "overrider";
                break;
            case 98:
            case 103:
                objArr[0] = "extractFrom";
                break;
            case 100:
                objArr[0] = "onConflict";
                break;
            case 105:
            case 106:
                objArr[0] = "memberDescriptor";
                break;
        }
        if (i == 11 || i == 12) {
            objArr[1] = "filterOverrides";
        } else if (i == 16) {
            objArr[1] = "getOverriddenDeclarations";
        } else if (i == 21) {
            objArr[1] = "isOverridableBy";
        } else if (i == 93) {
            objArr[1] = "getMinimalModality";
        } else if (i == 96) {
            objArr[1] = "filterVisibleFakeOverrides";
        } else if (i == 101) {
            objArr[1] = "extractMembersOverridableInBothWays";
        } else if (i != 42 && i != 43) {
            switch (i) {
                case 24:
                case 25:
                case 26:
                case 27:
                    objArr[1] = "isOverridableBy";
                    break;
                default:
                    switch (i) {
                        case 30:
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                            objArr[1] = "isOverridableByWithoutExternalConditions";
                            break;
                        default:
                            switch (i) {
                                case io.dcloud.common.DHInterface.IMgr.WindowEvent.OBTAIN_MP_TOP_PAGE_URL /* 78 */:
                                case 79:
                                case 80:
                                case io.dcloud.common.DHInterface.IMgr.WindowEvent.OBTAIN_APP_TOP_PAGE_DIRECT /* 81 */:
                                case 82:
                                    objArr[1] = "selectMostSpecificMember";
                                    break;
                                default:
                                    switch (i) {
                                        case tv.danmaku.ijk.media.player.IjkMediaMeta.FF_PROFILE_H264_EXTENDED /* 88 */:
                                        case com.alibaba.fastjson.asm.Opcodes.DUP /* 89 */:
                                        case 90:
                                            objArr[1] = "determineModalityForFakeOverride";
                                            break;
                                        default:
                                            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil";
                                            break;
                                    }
                                    break;
                            }
                            break;
                    }
                    break;
            }
        } else {
            objArr[1] = "createTypeCheckerState";
        }
        switch (i) {
            case 1:
            case 2:
                objArr[2] = "createWithTypePreparatorAndCustomSubtype";
                break;
            case 3:
            case 4:
                objArr[2] = "create";
                break;
            case 5:
            case 6:
            case 7:
                objArr[2] = "<init>";
                break;
            case 8:
                objArr[2] = "filterOutOverridden";
                break;
            case 9:
            case 10:
                objArr[2] = "filterOverrides";
                break;
            case 11:
            case 12:
            case 16:
            case 21:
            case 24:
            case 25:
            case 26:
            case 27:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 42:
            case 43:
            case io.dcloud.common.DHInterface.IMgr.WindowEvent.OBTAIN_MP_TOP_PAGE_URL /* 78 */:
            case 79:
            case 80:
            case io.dcloud.common.DHInterface.IMgr.WindowEvent.OBTAIN_APP_TOP_PAGE_DIRECT /* 81 */:
            case 82:
            case tv.danmaku.ijk.media.player.IjkMediaMeta.FF_PROFILE_H264_EXTENDED /* 88 */:
            case com.alibaba.fastjson.asm.Opcodes.DUP /* 89 */:
            case 90:
            case 93:
            case com.alibaba.fastjson.asm.Opcodes.IADD /* 96 */:
            case 101:
                break;
            case 13:
            case 14:
                objArr[2] = "overrides";
                break;
            case 15:
                objArr[2] = "getOverriddenDeclarations";
                break;
            case 17:
            case 18:
                objArr[2] = "collectOverriddenDeclarations";
                break;
            case 19:
            case 20:
            case 22:
            case 23:
                objArr[2] = "isOverridableBy";
                break;
            case 28:
            case 29:
                objArr[2] = "isOverridableByWithoutExternalConditions";
                break;
            case 38:
            case 39:
                objArr[2] = "getBasicOverridabilityProblem";
                break;
            case 40:
            case 41:
                objArr[2] = "createTypeCheckerState";
                break;
            case 44:
            case 45:
            case 46:
                objArr[2] = "areTypesEquivalent";
                break;
            case 47:
            case 48:
            case 49:
                objArr[2] = "areTypeParametersEquivalent";
                break;
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
                objArr[2] = "generateOverridesInFunctionGroup";
                break;
            case com.alibaba.fastjson.asm.Opcodes.LSTORE /* 55 */:
            case 56:
                objArr[2] = "isVisibleForOverride";
                break;
            case com.alibaba.fastjson.asm.Opcodes.DSTORE /* 57 */:
            case 58:
            case 59:
            case 60:
                objArr[2] = "extractAndBindOverridesForMember";
                break;
            case kotlinx.coroutines.internal.LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                objArr[2] = "allHasSameContainingDeclaration";
                break;
            case 62:
            case androidx.core.text.HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
            case 64:
                objArr[2] = "createAndBindFakeOverrides";
                break;
            case org.mozilla.universalchardet.prober.CharsetProber.ASCII_A_CAPITAL /* 65 */:
            case tv.danmaku.ijk.media.player.IjkMediaMeta.FF_PROFILE_H264_BASELINE /* 66 */:
                objArr[2] = "isMoreSpecific";
                break;
            case 67:
            case 68:
                objArr[2] = "isVisibilityMoreSpecific";
                break;
            case 69:
            case io.dcloud.common.DHInterface.IMgr.WindowEvent.WINDOW_ANIMATION_END /* 70 */:
                objArr[2] = "isMoreSpecificThenAllOf";
                break;
            case io.dcloud.common.DHInterface.IMgr.WindowEvent.ADD_ANIMATION_CALLBACK /* 71 */:
            case io.dcloud.common.DHInterface.IMgr.WindowEvent.WINDOW_CRATE_TITLENVIEW /* 72 */:
            case io.dcloud.common.DHInterface.IMgr.WindowEvent.WINDOW_APPEND_TITLENVIEW /* 73 */:
            case io.dcloud.common.DHInterface.IMgr.WindowEvent.WINDOW_BACKGROUND_SET_WEBPARENT /* 74 */:
            case io.dcloud.common.DHInterface.IMgr.WindowEvent.WINDOW_UPDATE_BACKGROUND /* 75 */:
                objArr[2] = "isReturnTypeMoreSpecific";
                break;
            case io.dcloud.common.DHInterface.IMgr.WindowEvent.CHECK_RESTART_TOP_WEBVIEW /* 76 */:
            case 77:
                objArr[2] = "selectMostSpecificMember";
                break;
            case 83:
            case 84:
            case com.facebook.imagepipeline.transcoder.JpegTranscoderUtils.DEFAULT_JPEG_QUALITY /* 85 */:
                objArr[2] = "createAndBindFakeOverride";
                break;
            case 86:
            case com.alibaba.fastjson.asm.Opcodes.POP /* 87 */:
                objArr[2] = "determineModalityForFakeOverride";
                break;
            case 91:
            case 92:
                objArr[2] = "getMinimalModality";
                break;
            case 94:
            case 95:
                objArr[2] = "filterVisibleFakeOverrides";
                break;
            case org.mozilla.universalchardet.prober.CharsetProber.ASCII_A /* 97 */:
            case 98:
            case 99:
            case 100:
            case 102:
            case 103:
            case androidx.core.location.LocationRequestCompat.QUALITY_LOW_POWER /* 104 */:
                objArr[2] = "extractMembersOverridableInBothWays";
                break;
            case 105:
                objArr[2] = "resolveUnknownVisibilityForMember";
                break;
            case 106:
                objArr[2] = "computeVisibilityToInherit";
                break;
            case 107:
                objArr[2] = "findMaxVisibility";
                break;
            default:
                objArr[2] = "createWithTypeRefiner";
                break;
        }
        java.lang.String str2 = java.lang.String.format(str, objArr);
        if (i != 11 && i != 12 && i != 16 && i != 21 && i != 93 && i != 96 && i != 101 && i != 42 && i != 43) {
            switch (i) {
                case 24:
                case 25:
                case 26:
                case 27:
                    break;
                default:
                    switch (i) {
                        case 30:
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                            break;
                        default:
                            switch (i) {
                                case io.dcloud.common.DHInterface.IMgr.WindowEvent.OBTAIN_MP_TOP_PAGE_URL /* 78 */:
                                case 79:
                                case 80:
                                case io.dcloud.common.DHInterface.IMgr.WindowEvent.OBTAIN_APP_TOP_PAGE_DIRECT /* 81 */:
                                case 82:
                                    break;
                                default:
                                    switch (i) {
                                        case tv.danmaku.ijk.media.player.IjkMediaMeta.FF_PROFILE_H264_EXTENDED /* 88 */:
                                        case com.alibaba.fastjson.asm.Opcodes.DUP /* 89 */:
                                        case 90:
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

    static {
        kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker.TypeConstructorEquality typeConstructorEquality = new kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker.TypeConstructorEquality() { // from class: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.1
            private static /* synthetic */ void $$$reportNull$$$0(int i) {
                java.lang.Object[] objArr = new java.lang.Object[3];
                if (i != 1) {
                    objArr[0] = "a";
                } else {
                    objArr[0] = "b";
                }
                objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$1";
                objArr[2] = "equals";
                throw new java.lang.IllegalArgumentException(java.lang.String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker.TypeConstructorEquality
            public boolean equals(kotlin.reflect.jvm.internal.impl.types.TypeConstructor typeConstructor, kotlin.reflect.jvm.internal.impl.types.TypeConstructor typeConstructor2) {
                if (typeConstructor == null) {
                    $$$reportNull$$$0(0);
                }
                if (typeConstructor2 == null) {
                    $$$reportNull$$$0(1);
                }
                return typeConstructor.equals(typeConstructor2);
            }
        };
        DEFAULT_TYPE_CONSTRUCTOR_EQUALITY = typeConstructorEquality;
        DEFAULT = new kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil(typeConstructorEquality, kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner.Default.INSTANCE, kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypePreparator.Default.INSTANCE, null);
    }

    public static kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil createWithTypeRefiner(kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner kotlinTypeRefiner) {
        if (kotlinTypeRefiner == null) {
            $$$reportNull$$$0(0);
        }
        return new kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil(DEFAULT_TYPE_CONSTRUCTOR_EQUALITY, kotlinTypeRefiner, kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypePreparator.Default.INSTANCE, null);
    }

    public static kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil create(kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner kotlinTypeRefiner, kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker.TypeConstructorEquality typeConstructorEquality) {
        if (kotlinTypeRefiner == null) {
            $$$reportNull$$$0(3);
        }
        if (typeConstructorEquality == null) {
            $$$reportNull$$$0(4);
        }
        return new kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil(typeConstructorEquality, kotlinTypeRefiner, kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypePreparator.Default.INSTANCE, null);
    }

    private OverridingUtil(kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker.TypeConstructorEquality typeConstructorEquality, kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner kotlinTypeRefiner, kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypePreparator kotlinTypePreparator, kotlin.jvm.functions.Function2<kotlin.reflect.jvm.internal.impl.types.KotlinType, kotlin.reflect.jvm.internal.impl.types.KotlinType, java.lang.Boolean> function2) {
        if (typeConstructorEquality == null) {
            $$$reportNull$$$0(5);
        }
        if (kotlinTypeRefiner == null) {
            $$$reportNull$$$0(6);
        }
        if (kotlinTypePreparator == null) {
            $$$reportNull$$$0(7);
        }
        this.equalityAxioms = typeConstructorEquality;
        this.kotlinTypeRefiner = kotlinTypeRefiner;
        this.kotlinTypePreparator = kotlinTypePreparator;
        this.customSubtype = function2;
    }

    public static <D extends kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor> java.util.Set<D> filterOutOverridden(java.util.Set<D> set) {
        if (set == null) {
            $$$reportNull$$$0(8);
        }
        return filterOverrides(set, !set.isEmpty() && kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.isTypeRefinementEnabled(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getModule(set.iterator().next())), null, new kotlin.jvm.functions.Function2<D, D, kotlin.Pair<kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.2
            /* JADX WARN: Incorrect types in method signature: (TD;TD;)Lkotlin/Pair<Lkotlin/reflect/jvm/internal/impl/descriptors/CallableDescriptor;Lkotlin/reflect/jvm/internal/impl/descriptors/CallableDescriptor;>; */
            @Override // kotlin.jvm.functions.Function2
            public kotlin.Pair invoke(kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor callableDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor callableDescriptor2) {
                return new kotlin.Pair(callableDescriptor, callableDescriptor2);
            }
        });
    }

    public static <D> java.util.Set<D> filterOverrides(java.util.Set<D> set, boolean z, kotlin.jvm.functions.Function0<?> function0, kotlin.jvm.functions.Function2<? super D, ? super D, kotlin.Pair<kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor>> function2) {
        if (set == null) {
            $$$reportNull$$$0(9);
        }
        if (function2 == null) {
            $$$reportNull$$$0(10);
        }
        if (set.size() <= 1) {
            if (set == null) {
                $$$reportNull$$$0(11);
            }
            return set;
        }
        java.util.LinkedHashSet linkedHashSet = new java.util.LinkedHashSet();
        for (java.lang.Object obj : set) {
            if (function0 != null) {
                function0.invoke();
            }
            java.util.Iterator it = linkedHashSet.iterator();
            while (true) {
                if (it.hasNext()) {
                    kotlin.Pair<kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor> pairInvoke = function2.invoke(obj, (java.lang.Object) it.next());
                    kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor callableDescriptorComponent1 = pairInvoke.component1();
                    kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor callableDescriptorComponent2 = pairInvoke.component2();
                    if (overrides(callableDescriptorComponent1, callableDescriptorComponent2, z, true)) {
                        it.remove();
                    } else if (overrides(callableDescriptorComponent2, callableDescriptorComponent1, z, true)) {
                        break;
                    }
                } else {
                    linkedHashSet.add(obj);
                    break;
                }
            }
        }
        return linkedHashSet;
    }

    public static <D extends kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor> boolean overrides(D d, D d2, boolean z, boolean z2) {
        if (d == null) {
            $$$reportNull$$$0(13);
        }
        if (d2 == null) {
            $$$reportNull$$$0(14);
        }
        if (!d.equals(d2) && kotlin.reflect.jvm.internal.impl.resolve.DescriptorEquivalenceForOverrides.INSTANCE.areEquivalent(d.getOriginal(), d2.getOriginal(), z, z2)) {
            return true;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor original = d2.getOriginal();
        java.util.Iterator it = kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.getAllOverriddenDescriptors(d).iterator();
        while (it.hasNext()) {
            if (kotlin.reflect.jvm.internal.impl.resolve.DescriptorEquivalenceForOverrides.INSTANCE.areEquivalent(original, (kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor) it.next(), z, z2)) {
                return true;
            }
        }
        return false;
    }

    public static java.util.Set<kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor> getOverriddenDeclarations(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor callableMemberDescriptor) {
        if (callableMemberDescriptor == null) {
            $$$reportNull$$$0(15);
        }
        java.util.LinkedHashSet linkedHashSet = new java.util.LinkedHashSet();
        collectOverriddenDeclarations(callableMemberDescriptor, linkedHashSet);
        return linkedHashSet;
    }

    private static void collectOverriddenDeclarations(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor callableMemberDescriptor, java.util.Set<kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor> set) {
        if (callableMemberDescriptor == null) {
            $$$reportNull$$$0(17);
        }
        if (set == null) {
            $$$reportNull$$$0(18);
        }
        if (callableMemberDescriptor.getKind().isReal()) {
            set.add(callableMemberDescriptor);
            return;
        }
        if (callableMemberDescriptor.getOverriddenDescriptors().isEmpty()) {
            throw new java.lang.IllegalStateException("No overridden descriptors found for (fake override) " + callableMemberDescriptor);
        }
        java.util.Iterator<? extends kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor> it = callableMemberDescriptor.getOverriddenDescriptors().iterator();
        while (it.hasNext()) {
            collectOverriddenDeclarations(it.next(), set);
        }
    }

    public kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo isOverridableBy(kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor callableDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor callableDescriptor2, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor) {
        if (callableDescriptor == null) {
            $$$reportNull$$$0(19);
        }
        if (callableDescriptor2 == null) {
            $$$reportNull$$$0(20);
        }
        kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo overrideCompatibilityInfoIsOverridableBy = isOverridableBy(callableDescriptor, callableDescriptor2, classDescriptor, false);
        if (overrideCompatibilityInfoIsOverridableBy == null) {
            $$$reportNull$$$0(21);
        }
        return overrideCompatibilityInfoIsOverridableBy;
    }

    public kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo isOverridableBy(kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor callableDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor callableDescriptor2, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor, boolean z) {
        if (callableDescriptor == null) {
            $$$reportNull$$$0(22);
        }
        if (callableDescriptor2 == null) {
            $$$reportNull$$$0(23);
        }
        kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo overrideCompatibilityInfoIsOverridableByWithoutExternalConditions = isOverridableByWithoutExternalConditions(callableDescriptor, callableDescriptor2, z);
        boolean z2 = overrideCompatibilityInfoIsOverridableByWithoutExternalConditions.getResult() == kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE;
        for (kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition externalOverridabilityCondition : EXTERNAL_CONDITIONS) {
            if (externalOverridabilityCondition.getContract() != kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition.Contract.CONFLICTS_ONLY && (!z2 || externalOverridabilityCondition.getContract() != kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition.Contract.SUCCESS_ONLY)) {
                int i = kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.AnonymousClass8.$SwitchMap$org$jetbrains$kotlin$resolve$ExternalOverridabilityCondition$Result[externalOverridabilityCondition.isOverridable(callableDescriptor, callableDescriptor2, classDescriptor).ordinal()];
                if (i == 1) {
                    z2 = true;
                } else if (i == 2) {
                    kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo overrideCompatibilityInfoIncompatible = kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.incompatible("External condition");
                    if (overrideCompatibilityInfoIncompatible == null) {
                        $$$reportNull$$$0(24);
                    }
                    return overrideCompatibilityInfoIncompatible;
                }
            }
        }
        if (!z2) {
            if (overrideCompatibilityInfoIsOverridableByWithoutExternalConditions == null) {
                $$$reportNull$$$0(25);
            }
            return overrideCompatibilityInfoIsOverridableByWithoutExternalConditions;
        }
        for (kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition externalOverridabilityCondition2 : EXTERNAL_CONDITIONS) {
            if (externalOverridabilityCondition2.getContract() == kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition.Contract.CONFLICTS_ONLY) {
                int i2 = kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.AnonymousClass8.$SwitchMap$org$jetbrains$kotlin$resolve$ExternalOverridabilityCondition$Result[externalOverridabilityCondition2.isOverridable(callableDescriptor, callableDescriptor2, classDescriptor).ordinal()];
                if (i2 == 1) {
                    throw new java.lang.IllegalStateException("Contract violation in " + externalOverridabilityCondition2.getClass().getName() + " condition. It's not supposed to end with success");
                }
                if (i2 == 2) {
                    kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo overrideCompatibilityInfoIncompatible2 = kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.incompatible("External condition");
                    if (overrideCompatibilityInfoIncompatible2 == null) {
                        $$$reportNull$$$0(26);
                    }
                    return overrideCompatibilityInfoIncompatible2;
                }
            }
        }
        kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo overrideCompatibilityInfoSuccess = kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.success();
        if (overrideCompatibilityInfoSuccess == null) {
            $$$reportNull$$$0(27);
        }
        return overrideCompatibilityInfoSuccess;
    }

    public kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo isOverridableByWithoutExternalConditions(kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor callableDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor callableDescriptor2, boolean z) {
        if (callableDescriptor == null) {
            $$$reportNull$$$0(28);
        }
        if (callableDescriptor2 == null) {
            $$$reportNull$$$0(29);
        }
        kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo basicOverridabilityProblem = getBasicOverridabilityProblem(callableDescriptor, callableDescriptor2);
        if (basicOverridabilityProblem != null) {
            if (basicOverridabilityProblem == null) {
                $$$reportNull$$$0(30);
            }
            return basicOverridabilityProblem;
        }
        java.util.List<kotlin.reflect.jvm.internal.impl.types.KotlinType> listCompiledValueParameters = compiledValueParameters(callableDescriptor);
        java.util.List<kotlin.reflect.jvm.internal.impl.types.KotlinType> listCompiledValueParameters2 = compiledValueParameters(callableDescriptor2);
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> typeParameters = callableDescriptor.getTypeParameters();
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> typeParameters2 = callableDescriptor2.getTypeParameters();
        int i = 0;
        if (typeParameters.size() != typeParameters2.size()) {
            while (i < listCompiledValueParameters.size()) {
                if (!kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker.DEFAULT.equalTypes(listCompiledValueParameters.get(i), listCompiledValueParameters2.get(i))) {
                    kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo overrideCompatibilityInfoIncompatible = kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.incompatible("Type parameter number mismatch");
                    if (overrideCompatibilityInfoIncompatible == null) {
                        $$$reportNull$$$0(31);
                    }
                    return overrideCompatibilityInfoIncompatible;
                }
                i++;
            }
            kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo overrideCompatibilityInfoConflict = kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.conflict("Type parameter number mismatch");
            if (overrideCompatibilityInfoConflict == null) {
                $$$reportNull$$$0(32);
            }
            return overrideCompatibilityInfoConflict;
        }
        kotlin.reflect.jvm.internal.impl.types.TypeCheckerState typeCheckerStateCreateTypeCheckerState = createTypeCheckerState(typeParameters, typeParameters2);
        for (int i2 = 0; i2 < typeParameters.size(); i2++) {
            if (!areTypeParametersEquivalent(typeParameters.get(i2), typeParameters2.get(i2), typeCheckerStateCreateTypeCheckerState)) {
                kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo overrideCompatibilityInfoIncompatible2 = kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.incompatible("Type parameter bounds mismatch");
                if (overrideCompatibilityInfoIncompatible2 == null) {
                    $$$reportNull$$$0(33);
                }
                return overrideCompatibilityInfoIncompatible2;
            }
        }
        while (i < listCompiledValueParameters.size()) {
            if (!areTypesEquivalent(listCompiledValueParameters.get(i), listCompiledValueParameters2.get(i), typeCheckerStateCreateTypeCheckerState)) {
                kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo overrideCompatibilityInfoIncompatible3 = kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.incompatible("Value parameter type mismatch");
                if (overrideCompatibilityInfoIncompatible3 == null) {
                    $$$reportNull$$$0(34);
                }
                return overrideCompatibilityInfoIncompatible3;
            }
            i++;
        }
        if ((callableDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) && (callableDescriptor2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) && ((kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) callableDescriptor).isSuspend() != ((kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) callableDescriptor2).isSuspend()) {
            kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo overrideCompatibilityInfoConflict2 = kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.conflict("Incompatible suspendability");
            if (overrideCompatibilityInfoConflict2 == null) {
                $$$reportNull$$$0(35);
            }
            return overrideCompatibilityInfoConflict2;
        }
        if (z) {
            kotlin.reflect.jvm.internal.impl.types.KotlinType returnType = callableDescriptor.getReturnType();
            kotlin.reflect.jvm.internal.impl.types.KotlinType returnType2 = callableDescriptor2.getReturnType();
            if (returnType != null && returnType2 != null && ((!kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt.isError(returnType2) || !kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt.isError(returnType)) && !kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker.INSTANCE.isSubtypeOf(typeCheckerStateCreateTypeCheckerState, returnType2.unwrap(), returnType.unwrap()))) {
                kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo overrideCompatibilityInfoConflict3 = kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.conflict("Return type mismatch");
                if (overrideCompatibilityInfoConflict3 == null) {
                    $$$reportNull$$$0(36);
                }
                return overrideCompatibilityInfoConflict3;
            }
        }
        kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo overrideCompatibilityInfoSuccess = kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.success();
        if (overrideCompatibilityInfoSuccess == null) {
            $$$reportNull$$$0(37);
        }
        return overrideCompatibilityInfoSuccess;
    }

    public static kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo getBasicOverridabilityProblem(kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor callableDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor callableDescriptor2) {
        boolean z;
        if (callableDescriptor == null) {
            $$$reportNull$$$0(38);
        }
        if (callableDescriptor2 == null) {
            $$$reportNull$$$0(39);
        }
        boolean z2 = callableDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
        if ((z2 && !(callableDescriptor2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor)) || (((z = callableDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor)) && !(callableDescriptor2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor))) {
            return kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.incompatible("Member kind mismatch");
        }
        if (!z2 && !z) {
            throw new java.lang.IllegalArgumentException("This type of CallableDescriptor cannot be checked for overridability: " + callableDescriptor);
        }
        if (!callableDescriptor.getName().equals(callableDescriptor2.getName())) {
            return kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.incompatible("Name mismatch");
        }
        kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo overrideCompatibilityInfoCheckReceiverAndParameterCount = checkReceiverAndParameterCount(callableDescriptor, callableDescriptor2);
        if (overrideCompatibilityInfoCheckReceiverAndParameterCount != null) {
            return overrideCompatibilityInfoCheckReceiverAndParameterCount;
        }
        return null;
    }

    private kotlin.reflect.jvm.internal.impl.types.TypeCheckerState createTypeCheckerState(java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> list, java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> list2) {
        if (list == null) {
            $$$reportNull$$$0(40);
        }
        if (list2 == null) {
            $$$reportNull$$$0(41);
        }
        if (list.isEmpty()) {
            kotlin.reflect.jvm.internal.impl.types.TypeCheckerState typeCheckerStateNewTypeCheckerState = new kotlin.reflect.jvm.internal.impl.resolve.OverridingUtilTypeSystemContext(null, this.equalityAxioms, this.kotlinTypeRefiner, this.kotlinTypePreparator, this.customSubtype).newTypeCheckerState(true, true, false);
            if (typeCheckerStateNewTypeCheckerState == null) {
                $$$reportNull$$$0(42);
            }
            return typeCheckerStateNewTypeCheckerState;
        }
        java.util.HashMap map = new java.util.HashMap();
        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i).getTypeConstructor(), list2.get(i).getTypeConstructor());
        }
        kotlin.reflect.jvm.internal.impl.types.TypeCheckerState typeCheckerStateNewTypeCheckerState2 = new kotlin.reflect.jvm.internal.impl.resolve.OverridingUtilTypeSystemContext(map, this.equalityAxioms, this.kotlinTypeRefiner, this.kotlinTypePreparator, this.customSubtype).newTypeCheckerState(true, true, false);
        if (typeCheckerStateNewTypeCheckerState2 == null) {
            $$$reportNull$$$0(43);
        }
        return typeCheckerStateNewTypeCheckerState2;
    }

    private static kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo checkReceiverAndParameterCount(kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor callableDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor callableDescriptor2) {
        if ((callableDescriptor.getExtensionReceiverParameter() == null) != (callableDescriptor2.getExtensionReceiverParameter() == null)) {
            return kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.incompatible("Receiver presence mismatch");
        }
        if (callableDescriptor.getValueParameters().size() != callableDescriptor2.getValueParameters().size()) {
            return kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.incompatible("Value parameter number mismatch");
        }
        return null;
    }

    private static boolean areTypesEquivalent(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType, kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType2, kotlin.reflect.jvm.internal.impl.types.TypeCheckerState typeCheckerState) {
        if (kotlinType == null) {
            $$$reportNull$$$0(44);
        }
        if (kotlinType2 == null) {
            $$$reportNull$$$0(45);
        }
        if (typeCheckerState == null) {
            $$$reportNull$$$0(46);
        }
        if (kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt.isError(kotlinType) && kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt.isError(kotlinType2)) {
            return true;
        }
        return kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker.INSTANCE.equalTypes(typeCheckerState, kotlinType.unwrap(), kotlinType2.unwrap());
    }

    private static boolean areTypeParametersEquivalent(kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor typeParameterDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor typeParameterDescriptor2, kotlin.reflect.jvm.internal.impl.types.TypeCheckerState typeCheckerState) {
        if (typeParameterDescriptor == null) {
            $$$reportNull$$$0(47);
        }
        if (typeParameterDescriptor2 == null) {
            $$$reportNull$$$0(48);
        }
        if (typeCheckerState == null) {
            $$$reportNull$$$0(49);
        }
        java.util.List<kotlin.reflect.jvm.internal.impl.types.KotlinType> upperBounds = typeParameterDescriptor.getUpperBounds();
        java.util.ArrayList arrayList = new java.util.ArrayList(typeParameterDescriptor2.getUpperBounds());
        if (upperBounds.size() != arrayList.size()) {
            return false;
        }
        for (kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType : upperBounds) {
            java.util.ListIterator listIterator = arrayList.listIterator();
            while (listIterator.hasNext()) {
                if (areTypesEquivalent(kotlinType, (kotlin.reflect.jvm.internal.impl.types.KotlinType) listIterator.next(), typeCheckerState)) {
                    listIterator.remove();
                }
            }
            return false;
        }
        return true;
    }

    private static java.util.List<kotlin.reflect.jvm.internal.impl.types.KotlinType> compiledValueParameters(kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor callableDescriptor) {
        kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor extensionReceiverParameter = callableDescriptor.getExtensionReceiverParameter();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (extensionReceiverParameter != null) {
            arrayList.add(extensionReceiverParameter.getType());
        }
        java.util.Iterator<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> it = callableDescriptor.getValueParameters().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getType());
        }
        return arrayList;
    }

    public void generateOverridesInFunctionGroup(kotlin.reflect.jvm.internal.impl.name.Name name, java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor> collection, java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor> collection2, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor, kotlin.reflect.jvm.internal.impl.resolve.OverridingStrategy overridingStrategy) {
        if (name == null) {
            $$$reportNull$$$0(50);
        }
        if (collection == null) {
            $$$reportNull$$$0(51);
        }
        if (collection2 == null) {
            $$$reportNull$$$0(52);
        }
        if (classDescriptor == null) {
            $$$reportNull$$$0(53);
        }
        if (overridingStrategy == null) {
            $$$reportNull$$$0(54);
        }
        java.util.LinkedHashSet linkedHashSet = new java.util.LinkedHashSet(collection);
        java.util.Iterator<? extends kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor> it = collection2.iterator();
        while (it.hasNext()) {
            linkedHashSet.removeAll(extractAndBindOverridesForMember(it.next(), collection, classDescriptor, overridingStrategy));
        }
        createAndBindFakeOverrides(classDescriptor, linkedHashSet, overridingStrategy);
    }

    public static boolean isVisibleForOverride(kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor memberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor memberDescriptor2, boolean z) {
        if (memberDescriptor == null) {
            $$$reportNull$$$0(55);
        }
        if (memberDescriptor2 == null) {
            $$$reportNull$$$0(56);
        }
        return !kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.isPrivate(memberDescriptor2.getVisibility()) && kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.isVisibleIgnoringReceiver(memberDescriptor2, memberDescriptor, z);
    }

    private java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor> extractAndBindOverridesForMember(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor callableMemberDescriptor, java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor> collection, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor, kotlin.reflect.jvm.internal.impl.resolve.OverridingStrategy overridingStrategy) {
        if (callableMemberDescriptor == null) {
            $$$reportNull$$$0(57);
        }
        if (collection == null) {
            $$$reportNull$$$0(58);
        }
        if (classDescriptor == null) {
            $$$reportNull$$$0(59);
        }
        if (overridingStrategy == null) {
            $$$reportNull$$$0(60);
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(collection.size());
        kotlin.reflect.jvm.internal.impl.utils.SmartSet smartSetCreate = kotlin.reflect.jvm.internal.impl.utils.SmartSet.create();
        for (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor callableMemberDescriptor2 : collection) {
            kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.Result result = isOverridableBy(callableMemberDescriptor2, callableMemberDescriptor, classDescriptor).getResult();
            boolean zIsVisibleForOverride = isVisibleForOverride(callableMemberDescriptor, callableMemberDescriptor2, false);
            int i = kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.AnonymousClass8.$SwitchMap$org$jetbrains$kotlin$resolve$OverridingUtil$OverrideCompatibilityInfo$Result[result.ordinal()];
            if (i == 1) {
                if (zIsVisibleForOverride) {
                    smartSetCreate.add(callableMemberDescriptor2);
                }
                arrayList.add(callableMemberDescriptor2);
            } else if (i == 2) {
                if (zIsVisibleForOverride) {
                    overridingStrategy.overrideConflict(callableMemberDescriptor2, callableMemberDescriptor);
                }
                arrayList.add(callableMemberDescriptor2);
            }
        }
        overridingStrategy.setOverriddenDescriptors(callableMemberDescriptor, smartSetCreate);
        return arrayList;
    }

    private static boolean allHasSameContainingDeclaration(java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor> collection) {
        if (collection == null) {
            $$$reportNull$$$0(61);
        }
        if (collection.size() < 2) {
            return true;
        }
        final kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration = collection.iterator().next().getContainingDeclaration();
        return kotlin.collections.CollectionsKt.all(collection, new kotlin.jvm.functions.Function1<kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, java.lang.Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.3
            @Override // kotlin.jvm.functions.Function1
            public java.lang.Boolean invoke2(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor callableMemberDescriptor) {
                return java.lang.Boolean.valueOf(callableMemberDescriptor.getContainingDeclaration() == containingDeclaration);
            }
        });
    }

    private static void createAndBindFakeOverrides(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor, java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor> collection, kotlin.reflect.jvm.internal.impl.resolve.OverridingStrategy overridingStrategy) {
        if (classDescriptor == null) {
            $$$reportNull$$$0(62);
        }
        if (collection == null) {
            $$$reportNull$$$0(63);
        }
        if (overridingStrategy == null) {
            $$$reportNull$$$0(64);
        }
        if (allHasSameContainingDeclaration(collection)) {
            java.util.Iterator<kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor> it = collection.iterator();
            while (it.hasNext()) {
                createAndBindFakeOverride(java.util.Collections.singleton(it.next()), classDescriptor, overridingStrategy);
            }
        } else {
            java.util.LinkedList linkedList = new java.util.LinkedList(collection);
            while (!linkedList.isEmpty()) {
                createAndBindFakeOverride(extractMembersOverridableInBothWays(kotlin.reflect.jvm.internal.impl.resolve.VisibilityUtilKt.findMemberWithMaxVisibility(linkedList), linkedList, overridingStrategy), classDescriptor, overridingStrategy);
            }
        }
    }

    public static boolean isMoreSpecific(kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor callableDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor callableDescriptor2) {
        if (callableDescriptor == null) {
            $$$reportNull$$$0(65);
        }
        if (callableDescriptor2 == null) {
            $$$reportNull$$$0(66);
        }
        kotlin.reflect.jvm.internal.impl.types.KotlinType returnType = callableDescriptor.getReturnType();
        kotlin.reflect.jvm.internal.impl.types.KotlinType returnType2 = callableDescriptor2.getReturnType();
        if (!isVisibilityMoreSpecific(callableDescriptor, callableDescriptor2)) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.types.TypeCheckerState typeCheckerStateCreateTypeCheckerState = DEFAULT.createTypeCheckerState(callableDescriptor.getTypeParameters(), callableDescriptor2.getTypeParameters());
        if (callableDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) {
            return isReturnTypeMoreSpecific(callableDescriptor, returnType, callableDescriptor2, returnType2, typeCheckerStateCreateTypeCheckerState);
        }
        if (callableDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor) {
            kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor propertyDescriptor = (kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor) callableDescriptor;
            kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor propertyDescriptor2 = (kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor) callableDescriptor2;
            if (!isAccessorMoreSpecific(propertyDescriptor.getSetter(), propertyDescriptor2.getSetter())) {
                return false;
            }
            if (propertyDescriptor.isVar() && propertyDescriptor2.isVar()) {
                return kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker.INSTANCE.equalTypes(typeCheckerStateCreateTypeCheckerState, returnType.unwrap(), returnType2.unwrap());
            }
            return (propertyDescriptor.isVar() || !propertyDescriptor2.isVar()) && isReturnTypeMoreSpecific(callableDescriptor, returnType, callableDescriptor2, returnType2, typeCheckerStateCreateTypeCheckerState);
        }
        throw new java.lang.IllegalArgumentException("Unexpected callable: " + callableDescriptor.getClass());
    }

    private static boolean isVisibilityMoreSpecific(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility2) {
        if (declarationDescriptorWithVisibility == null) {
            $$$reportNull$$$0(67);
        }
        if (declarationDescriptorWithVisibility2 == null) {
            $$$reportNull$$$0(68);
        }
        java.lang.Integer numCompare = kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.compare(declarationDescriptorWithVisibility.getVisibility(), declarationDescriptorWithVisibility2.getVisibility());
        return numCompare == null || numCompare.intValue() >= 0;
    }

    private static boolean isAccessorMoreSpecific(kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor propertyAccessorDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor propertyAccessorDescriptor2) {
        if (propertyAccessorDescriptor == null || propertyAccessorDescriptor2 == null) {
            return true;
        }
        return isVisibilityMoreSpecific(propertyAccessorDescriptor, propertyAccessorDescriptor2);
    }

    private static boolean isMoreSpecificThenAllOf(kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor callableDescriptor, java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor> collection) {
        if (callableDescriptor == null) {
            $$$reportNull$$$0(69);
        }
        if (collection == null) {
            $$$reportNull$$$0(70);
        }
        java.util.Iterator<kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor> it = collection.iterator();
        while (it.hasNext()) {
            if (!isMoreSpecific(callableDescriptor, it.next())) {
                return false;
            }
        }
        return true;
    }

    private static boolean isReturnTypeMoreSpecific(kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor callableDescriptor, kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor callableDescriptor2, kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType2, kotlin.reflect.jvm.internal.impl.types.TypeCheckerState typeCheckerState) {
        if (callableDescriptor == null) {
            $$$reportNull$$$0(71);
        }
        if (kotlinType == null) {
            $$$reportNull$$$0(72);
        }
        if (callableDescriptor2 == null) {
            $$$reportNull$$$0(73);
        }
        if (kotlinType2 == null) {
            $$$reportNull$$$0(74);
        }
        if (typeCheckerState == null) {
            $$$reportNull$$$0(75);
        }
        return kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker.INSTANCE.isSubtypeOf(typeCheckerState, kotlinType.unwrap(), kotlinType2.unwrap());
    }

    public static <H> H selectMostSpecificMember(java.util.Collection<H> collection, kotlin.jvm.functions.Function1<H, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor> function1) {
        H h;
        if (collection == null) {
            $$$reportNull$$$0(76);
        }
        if (function1 == null) {
            $$$reportNull$$$0(77);
        }
        if (collection.size() == 1) {
            H h2 = (H) kotlin.collections.CollectionsKt.first(collection);
            if (h2 == null) {
                $$$reportNull$$$0(78);
            }
            return h2;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(2);
        java.util.List map = kotlin.collections.CollectionsKt.map(collection, function1);
        H h3 = (H) kotlin.collections.CollectionsKt.first(collection);
        kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor callableDescriptorInvoke = function1.invoke2(h3);
        for (H h4 : collection) {
            kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor callableDescriptorInvoke2 = function1.invoke2(h4);
            if (isMoreSpecificThenAllOf(callableDescriptorInvoke2, map)) {
                arrayList.add(h4);
            }
            if (isMoreSpecific(callableDescriptorInvoke2, callableDescriptorInvoke) && !isMoreSpecific(callableDescriptorInvoke, callableDescriptorInvoke2)) {
                h3 = h4;
            }
        }
        if (arrayList.isEmpty()) {
            if (h3 == null) {
                $$$reportNull$$$0(79);
            }
            return h3;
        }
        if (arrayList.size() == 1) {
            H h5 = (H) kotlin.collections.CollectionsKt.first((java.lang.Iterable) arrayList);
            if (h5 == null) {
                $$$reportNull$$$0(80);
            }
            return h5;
        }
        java.util.Iterator it = arrayList.iterator();
        do {
            if (!it.hasNext()) {
                h = null;
                break;
            }
            h = (H) it.next();
        } while (kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt.isFlexible(function1.invoke2(h).getReturnType()));
        if (h != null) {
            if (h == null) {
                $$$reportNull$$$0(81);
            }
            return h;
        }
        H h6 = (H) kotlin.collections.CollectionsKt.first((java.lang.Iterable) arrayList);
        if (h6 == null) {
            $$$reportNull$$$0(82);
        }
        return h6;
    }

    private static void createAndBindFakeOverride(java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor> collection, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor, kotlin.reflect.jvm.internal.impl.resolve.OverridingStrategy overridingStrategy) {
        if (collection == null) {
            $$$reportNull$$$0(83);
        }
        if (classDescriptor == null) {
            $$$reportNull$$$0(84);
        }
        if (overridingStrategy == null) {
            $$$reportNull$$$0(85);
        }
        java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor> collectionFilterVisibleFakeOverrides = filterVisibleFakeOverrides(classDescriptor, collection);
        boolean zIsEmpty = collectionFilterVisibleFakeOverrides.isEmpty();
        if (!zIsEmpty) {
            collection = collectionFilterVisibleFakeOverrides;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor callableMemberDescriptorCopy = ((kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) selectMostSpecificMember(collection, new kotlin.jvm.functions.Function1<kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.4
            @Override // kotlin.jvm.functions.Function1
            public kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor invoke2(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor callableMemberDescriptor) {
                return callableMemberDescriptor;
            }
        })).copy(classDescriptor, determineModalityForFakeOverride(collection, classDescriptor), zIsEmpty ? kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.INVISIBLE_FAKE : kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.INHERITED, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind.FAKE_OVERRIDE, false);
        overridingStrategy.setOverriddenDescriptors(callableMemberDescriptorCopy, collection);
        overridingStrategy.addFakeOverride(callableMemberDescriptorCopy);
    }

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil$8, reason: invalid class name */
    static /* synthetic */ class AnonymousClass8 {
        static final /* synthetic */ int[] $SwitchMap$org$jetbrains$kotlin$descriptors$Modality;
        static final /* synthetic */ int[] $SwitchMap$org$jetbrains$kotlin$resolve$ExternalOverridabilityCondition$Result;
        static final /* synthetic */ int[] $SwitchMap$org$jetbrains$kotlin$resolve$OverridingUtil$OverrideCompatibilityInfo$Result;

        static {
            int[] iArr = new int[kotlin.reflect.jvm.internal.impl.descriptors.Modality.values().length];
            $SwitchMap$org$jetbrains$kotlin$descriptors$Modality = iArr;
            try {
                iArr[kotlin.reflect.jvm.internal.impl.descriptors.Modality.FINAL.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jetbrains$kotlin$descriptors$Modality[kotlin.reflect.jvm.internal.impl.descriptors.Modality.SEALED.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$jetbrains$kotlin$descriptors$Modality[kotlin.reflect.jvm.internal.impl.descriptors.Modality.OPEN.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$jetbrains$kotlin$descriptors$Modality[kotlin.reflect.jvm.internal.impl.descriptors.Modality.ABSTRACT.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.Result.values().length];
            $SwitchMap$org$jetbrains$kotlin$resolve$OverridingUtil$OverrideCompatibilityInfo$Result = iArr2;
            try {
                iArr2[kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$jetbrains$kotlin$resolve$OverridingUtil$OverrideCompatibilityInfo$Result[kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.Result.CONFLICT.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$jetbrains$kotlin$resolve$OverridingUtil$OverrideCompatibilityInfo$Result[kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.Result.INCOMPATIBLE.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition.Result.values().length];
            $SwitchMap$org$jetbrains$kotlin$resolve$ExternalOverridabilityCondition$Result = iArr3;
            try {
                iArr3[kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition.Result.OVERRIDABLE.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$org$jetbrains$kotlin$resolve$ExternalOverridabilityCondition$Result[kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition.Result.INCOMPATIBLE.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$org$jetbrains$kotlin$resolve$ExternalOverridabilityCondition$Result[kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition.Result.UNKNOWN.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused10) {
            }
        }
    }

    private static kotlin.reflect.jvm.internal.impl.descriptors.Modality determineModalityForFakeOverride(java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor> collection, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor) {
        if (collection == null) {
            $$$reportNull$$$0(86);
        }
        if (classDescriptor == null) {
            $$$reportNull$$$0(87);
        }
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        for (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor callableMemberDescriptor : collection) {
            int i = kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.AnonymousClass8.$SwitchMap$org$jetbrains$kotlin$descriptors$Modality[callableMemberDescriptor.getModality().ordinal()];
            if (i == 1) {
                kotlin.reflect.jvm.internal.impl.descriptors.Modality modality = kotlin.reflect.jvm.internal.impl.descriptors.Modality.FINAL;
                if (modality == null) {
                    $$$reportNull$$$0(88);
                }
                return modality;
            }
            if (i == 2) {
                throw new java.lang.IllegalStateException("Member cannot have SEALED modality: " + callableMemberDescriptor);
            }
            if (i == 3) {
                z2 = true;
            } else if (i == 4) {
                z3 = true;
            }
        }
        if (classDescriptor.isExpect() && classDescriptor.getModality() != kotlin.reflect.jvm.internal.impl.descriptors.Modality.ABSTRACT && classDescriptor.getModality() != kotlin.reflect.jvm.internal.impl.descriptors.Modality.SEALED) {
            z = true;
        }
        if (z2 && !z3) {
            kotlin.reflect.jvm.internal.impl.descriptors.Modality modality2 = kotlin.reflect.jvm.internal.impl.descriptors.Modality.OPEN;
            if (modality2 == null) {
                $$$reportNull$$$0(89);
            }
            return modality2;
        }
        if (!z2 && z3) {
            kotlin.reflect.jvm.internal.impl.descriptors.Modality modality3 = z ? classDescriptor.getModality() : kotlin.reflect.jvm.internal.impl.descriptors.Modality.ABSTRACT;
            if (modality3 == null) {
                $$$reportNull$$$0(90);
            }
            return modality3;
        }
        java.util.HashSet hashSet = new java.util.HashSet();
        java.util.Iterator<kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor> it = collection.iterator();
        while (it.hasNext()) {
            hashSet.addAll(getOverriddenDeclarations(it.next()));
        }
        return getMinimalModality(filterOutOverridden(hashSet), z, classDescriptor.getModality());
    }

    private static kotlin.reflect.jvm.internal.impl.descriptors.Modality getMinimalModality(java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor> collection, boolean z, kotlin.reflect.jvm.internal.impl.descriptors.Modality modality) {
        if (collection == null) {
            $$$reportNull$$$0(91);
        }
        if (modality == null) {
            $$$reportNull$$$0(92);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.Modality modality2 = kotlin.reflect.jvm.internal.impl.descriptors.Modality.ABSTRACT;
        for (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor callableMemberDescriptor : collection) {
            kotlin.reflect.jvm.internal.impl.descriptors.Modality modality3 = (z && callableMemberDescriptor.getModality() == kotlin.reflect.jvm.internal.impl.descriptors.Modality.ABSTRACT) ? modality : callableMemberDescriptor.getModality();
            if (modality3.compareTo(modality2) < 0) {
                modality2 = modality3;
            }
        }
        if (modality2 == null) {
            $$$reportNull$$$0(93);
        }
        return modality2;
    }

    public static java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor> filterVisibleFakeOverrides(final kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor, java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor> collection) {
        if (classDescriptor == null) {
            $$$reportNull$$$0(94);
        }
        if (collection == null) {
            $$$reportNull$$$0(95);
        }
        java.util.List listFilter = kotlin.collections.CollectionsKt.filter(collection, new kotlin.jvm.functions.Function1<kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, java.lang.Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.5
            @Override // kotlin.jvm.functions.Function1
            public java.lang.Boolean invoke2(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor callableMemberDescriptor) {
                boolean z = false;
                if (!kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.isPrivate(callableMemberDescriptor.getVisibility()) && kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.isVisibleIgnoringReceiver(callableMemberDescriptor, classDescriptor, false)) {
                    z = true;
                }
                return java.lang.Boolean.valueOf(z);
            }
        });
        if (listFilter == null) {
            $$$reportNull$$$0(96);
        }
        return listFilter;
    }

    public static <H> java.util.Collection<H> extractMembersOverridableInBothWays(H h, java.util.Collection<H> collection, kotlin.jvm.functions.Function1<H, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor> function1, kotlin.jvm.functions.Function1<H, kotlin.Unit> function2) {
        if (h == null) {
            $$$reportNull$$$0(97);
        }
        if (collection == null) {
            $$$reportNull$$$0(98);
        }
        if (function1 == null) {
            $$$reportNull$$$0(99);
        }
        if (function2 == null) {
            $$$reportNull$$$0(100);
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(h);
        kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor callableDescriptorInvoke = function1.invoke2(h);
        java.util.Iterator<H> it = collection.iterator();
        while (it.hasNext()) {
            H next = it.next();
            kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor callableDescriptorInvoke2 = function1.invoke2(next);
            if (h == next) {
                it.remove();
            } else {
                kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.Result bothWaysOverridability = getBothWaysOverridability(callableDescriptorInvoke, callableDescriptorInvoke2);
                if (bothWaysOverridability == kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE) {
                    arrayList.add(next);
                    it.remove();
                } else if (bothWaysOverridability == kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.Result.CONFLICT) {
                    function2.invoke2(next);
                    it.remove();
                }
            }
        }
        return arrayList;
    }

    public static kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.Result getBothWaysOverridability(kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor callableDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor callableDescriptor2) {
        kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil overridingUtil = DEFAULT;
        kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.Result result = overridingUtil.isOverridableBy(callableDescriptor2, callableDescriptor, null).getResult();
        kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.Result result2 = overridingUtil.isOverridableBy(callableDescriptor, callableDescriptor2, null).getResult();
        if (result == kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE && result2 == kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE) {
            return kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE;
        }
        return (result == kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.Result.CONFLICT || result2 == kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.Result.CONFLICT) ? kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.Result.CONFLICT : kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.Result.INCOMPATIBLE;
    }

    private static java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor> extractMembersOverridableInBothWays(final kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor callableMemberDescriptor, java.util.Queue<kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor> queue, final kotlin.reflect.jvm.internal.impl.resolve.OverridingStrategy overridingStrategy) {
        if (callableMemberDescriptor == null) {
            $$$reportNull$$$0(102);
        }
        if (queue == null) {
            $$$reportNull$$$0(103);
        }
        if (overridingStrategy == null) {
            $$$reportNull$$$0(androidx.core.location.LocationRequestCompat.QUALITY_LOW_POWER);
        }
        return extractMembersOverridableInBothWays(callableMemberDescriptor, queue, new kotlin.jvm.functions.Function1<kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.6
            @Override // kotlin.jvm.functions.Function1
            public kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor invoke2(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor callableMemberDescriptor2) {
                return callableMemberDescriptor2;
            }
        }, new kotlin.jvm.functions.Function1<kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.Unit>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.7
            @Override // kotlin.jvm.functions.Function1
            public kotlin.Unit invoke2(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor callableMemberDescriptor2) {
                overridingStrategy.inheritanceConflict(callableMemberDescriptor, callableMemberDescriptor2);
                return kotlin.Unit.INSTANCE;
            }
        });
    }

    public static void resolveUnknownVisibilityForMember(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor callableMemberDescriptor, kotlin.jvm.functions.Function1<kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.Unit> function1) {
        kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility descriptorVisibility;
        if (callableMemberDescriptor == null) {
            $$$reportNull$$$0(105);
        }
        for (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor callableMemberDescriptor2 : callableMemberDescriptor.getOverriddenDescriptors()) {
            if (callableMemberDescriptor2.getVisibility() == kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.INHERITED) {
                resolveUnknownVisibilityForMember(callableMemberDescriptor2, function1);
            }
        }
        if (callableMemberDescriptor.getVisibility() != kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.INHERITED) {
            return;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility descriptorVisibilityComputeVisibilityToInherit = computeVisibilityToInherit(callableMemberDescriptor);
        if (descriptorVisibilityComputeVisibilityToInherit == null) {
            if (function1 != null) {
                function1.invoke2(callableMemberDescriptor);
            }
            descriptorVisibility = kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.PUBLIC;
        } else {
            descriptorVisibility = descriptorVisibilityComputeVisibilityToInherit;
        }
        if (callableMemberDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl) {
            ((kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl) callableMemberDescriptor).setVisibility(descriptorVisibility);
            java.util.Iterator<kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor> it = ((kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor) callableMemberDescriptor).getAccessors().iterator();
            while (it.hasNext()) {
                resolveUnknownVisibilityForMember(it.next(), descriptorVisibilityComputeVisibilityToInherit == null ? null : function1);
            }
            return;
        }
        if (callableMemberDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl) {
            ((kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl) callableMemberDescriptor).setVisibility(descriptorVisibility);
            return;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyAccessorDescriptorImpl propertyAccessorDescriptorImpl = (kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyAccessorDescriptorImpl) callableMemberDescriptor;
        propertyAccessorDescriptorImpl.setVisibility(descriptorVisibility);
        if (descriptorVisibility != propertyAccessorDescriptorImpl.getCorrespondingProperty().getVisibility()) {
            propertyAccessorDescriptorImpl.setDefault(false);
        }
    }

    private static kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility computeVisibilityToInherit(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor callableMemberDescriptor) {
        if (callableMemberDescriptor == null) {
            $$$reportNull$$$0(106);
        }
        java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor> overriddenDescriptors = callableMemberDescriptor.getOverriddenDescriptors();
        kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility descriptorVisibilityFindMaxVisibility = findMaxVisibility(overriddenDescriptors);
        if (descriptorVisibilityFindMaxVisibility == null) {
            return null;
        }
        if (callableMemberDescriptor.getKind() == kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind.FAKE_OVERRIDE) {
            for (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor callableMemberDescriptor2 : overriddenDescriptors) {
                if (callableMemberDescriptor2.getModality() != kotlin.reflect.jvm.internal.impl.descriptors.Modality.ABSTRACT && !callableMemberDescriptor2.getVisibility().equals(descriptorVisibilityFindMaxVisibility)) {
                    return null;
                }
            }
            return descriptorVisibilityFindMaxVisibility;
        }
        return descriptorVisibilityFindMaxVisibility.normalize();
    }

    public static kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility findMaxVisibility(java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor> collection) {
        kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility descriptorVisibility;
        if (collection == null) {
            $$$reportNull$$$0(107);
        }
        if (collection.isEmpty()) {
            return kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.DEFAULT_VISIBILITY;
        }
        java.util.Iterator<? extends kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor> it = collection.iterator();
        loop0: while (true) {
            descriptorVisibility = null;
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                }
                kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility visibility = it.next().getVisibility();
                if (descriptorVisibility != null) {
                    java.lang.Integer numCompare = kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.compare(visibility, descriptorVisibility);
                    if (numCompare == null) {
                        break;
                    }
                    if (numCompare.intValue() > 0) {
                    }
                }
                descriptorVisibility = visibility;
            }
        }
        if (descriptorVisibility == null) {
            return null;
        }
        java.util.Iterator<? extends kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor> it2 = collection.iterator();
        while (it2.hasNext()) {
            java.lang.Integer numCompare2 = kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.compare(descriptorVisibility, it2.next().getVisibility());
            if (numCompare2 == null || numCompare2.intValue() < 0) {
                return null;
            }
        }
        return descriptorVisibility;
    }

    public static class OverrideCompatibilityInfo {
        private static final kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo SUCCESS = new kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo(kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE, "SUCCESS");
        private final java.lang.String debugMessage;
        private final kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.Result overridable;

        public enum Result {
            OVERRIDABLE,
            INCOMPATIBLE,
            CONFLICT
        }

        /* JADX WARN: Code duplicated, block: B:22:0x0031  */
        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            java.lang.String str = (i == 1 || i == 2 || i == 3 || i == 4) ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            java.lang.Object[] objArr = new java.lang.Object[(i == 1 || i == 2 || i == 3 || i == 4) ? 3 : 2];
            if (i == 1 || i == 2) {
                objArr[0] = "debugMessage";
            } else if (i == 3) {
                objArr[0] = com.taobao.weex.ui.component.WXImage.SUCCEED;
            } else if (i != 4) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverrideCompatibilityInfo";
            } else {
                objArr[0] = "debugMessage";
            }
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 4:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverrideCompatibilityInfo";
                    break;
                case 5:
                    objArr[1] = "getResult";
                    break;
                case 6:
                    objArr[1] = "getDebugMessage";
                    break;
                default:
                    objArr[1] = com.taobao.weex.ui.component.WXImage.SUCCEED;
                    break;
            }
            if (i == 1) {
                objArr[2] = "incompatible";
            } else if (i == 2) {
                objArr[2] = "conflict";
            } else if (i == 3 || i == 4) {
                objArr[2] = "<init>";
            }
            java.lang.String str2 = java.lang.String.format(str, objArr);
            if (i != 1 && i != 2 && i != 3 && i != 4) {
                throw new java.lang.IllegalStateException(str2);
            }
            throw new java.lang.IllegalArgumentException(str2);
        }

        public static kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo success() {
            kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo overrideCompatibilityInfo = SUCCESS;
            if (overrideCompatibilityInfo == null) {
                $$$reportNull$$$0(0);
            }
            return overrideCompatibilityInfo;
        }

        public static kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo incompatible(java.lang.String str) {
            if (str == null) {
                $$$reportNull$$$0(1);
            }
            return new kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo(kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.Result.INCOMPATIBLE, str);
        }

        public static kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo conflict(java.lang.String str) {
            if (str == null) {
                $$$reportNull$$$0(2);
            }
            return new kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo(kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.Result.CONFLICT, str);
        }

        public OverrideCompatibilityInfo(kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.Result result, java.lang.String str) {
            if (result == null) {
                $$$reportNull$$$0(3);
            }
            if (str == null) {
                $$$reportNull$$$0(4);
            }
            this.overridable = result;
            this.debugMessage = str;
        }

        public kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.Result getResult() {
            kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.Result result = this.overridable;
            if (result == null) {
                $$$reportNull$$$0(5);
            }
            return result;
        }

        public java.lang.String toString() {
            return this.overridable + ": " + this.debugMessage;
        }
    }
}
