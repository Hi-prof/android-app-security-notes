package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

/* JADX INFO: compiled from: ProtoEnumFlagsUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ProtoEnumFlagsUtilsKt {

    /* JADX INFO: compiled from: ProtoEnumFlagsUtils.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.MemberKind.values().length];
            try {
                iArr[kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.MemberKind.DECLARATION.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.MemberKind.FAKE_OVERRIDE.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.MemberKind.DELEGATION.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.MemberKind.SYNTHESIZED.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind.values().length];
            try {
                iArr2[kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind.DECLARATION.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                iArr2[kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind.FAKE_OVERRIDE.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                iArr2[kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind.DELEGATION.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
            try {
                iArr2[kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind.SYNTHESIZED.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Visibility.values().length];
            try {
                iArr3[kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Visibility.INTERNAL.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused9) {
            }
            try {
                iArr3[kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Visibility.PRIVATE.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused10) {
            }
            try {
                iArr3[kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Visibility.PRIVATE_TO_THIS.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused11) {
            }
            try {
                iArr3[kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Visibility.PROTECTED.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused12) {
            }
            try {
                iArr3[kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Visibility.PUBLIC.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused13) {
            }
            try {
                iArr3[kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Visibility.LOCAL.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused14) {
            }
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    public static final kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind memberKind(kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags protoEnumFlags, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.MemberKind memberKind) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(protoEnumFlags, "<this>");
        int i = memberKind == null ? -1 : kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlagsUtilsKt.WhenMappings.$EnumSwitchMapping$0[memberKind.ordinal()];
        if (i == 1) {
            return kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind.DECLARATION;
        }
        if (i == 2) {
            return kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind.FAKE_OVERRIDE;
        }
        if (i == 3) {
            return kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind.DELEGATION;
        }
        if (i == 4) {
            return kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind.SYNTHESIZED;
        }
        return kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind.DECLARATION;
    }

    public static final kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility descriptorVisibility(kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags protoEnumFlags, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Visibility visibility) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(protoEnumFlags, "<this>");
        switch (visibility == null ? -1 : kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlagsUtilsKt.WhenMappings.$EnumSwitchMapping$2[visibility.ordinal()]) {
            case 1:
                kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility INTERNAL = kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.INTERNAL;
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(INTERNAL, "INTERNAL");
                return INTERNAL;
            case 2:
                kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility PRIVATE = kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.PRIVATE;
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(PRIVATE, "PRIVATE");
                return PRIVATE;
            case 3:
                kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility PRIVATE_TO_THIS = kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.PRIVATE_TO_THIS;
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(PRIVATE_TO_THIS, "PRIVATE_TO_THIS");
                return PRIVATE_TO_THIS;
            case 4:
                kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility PROTECTED = kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.PROTECTED;
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(PROTECTED, "PROTECTED");
                return PROTECTED;
            case 5:
                kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility PUBLIC = kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.PUBLIC;
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(PUBLIC, "PUBLIC");
                return PUBLIC;
            case 6:
                kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility LOCAL = kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.LOCAL;
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(LOCAL, "LOCAL");
                return LOCAL;
            default:
                kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility PRIVATE2 = kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.PRIVATE;
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(PRIVATE2, "PRIVATE");
                return PRIVATE2;
        }
    }
}
