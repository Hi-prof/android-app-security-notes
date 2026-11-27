package kotlin.reflect.jvm.internal.impl.load.java;

/* JADX INFO: compiled from: ClassicBuiltinSpecialProperties.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ClassicBuiltinSpecialProperties {
    public static final kotlin.reflect.jvm.internal.impl.load.java.ClassicBuiltinSpecialProperties INSTANCE = new kotlin.reflect.jvm.internal.impl.load.java.ClassicBuiltinSpecialProperties();

    private ClassicBuiltinSpecialProperties() {
    }

    public final java.lang.String getBuiltinSpecialPropertyGetterName(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor callableMemberDescriptor) {
        kotlin.reflect.jvm.internal.impl.name.Name name;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callableMemberDescriptor, "<this>");
        kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isBuiltIn(callableMemberDescriptor);
        kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor callableMemberDescriptorFirstOverridden$default = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.firstOverridden$default(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getPropertyIfAccessor(callableMemberDescriptor), false, new kotlin.jvm.functions.Function1() { // from class: kotlin.reflect.jvm.internal.impl.load.java.ClassicBuiltinSpecialProperties$$Lambda$0
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return java.lang.Boolean.valueOf(kotlin.reflect.jvm.internal.impl.load.java.ClassicBuiltinSpecialProperties.getBuiltinSpecialPropertyGetterName$lambda$1((kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) obj));
            }
        }, 1, null);
        if (callableMemberDescriptorFirstOverridden$default == null || (name = kotlin.reflect.jvm.internal.impl.load.java.BuiltinSpecialProperties.INSTANCE.getPROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP().get(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getFqNameSafe(callableMemberDescriptorFirstOverridden$default))) == null) {
            return null;
        }
        return name.asString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getBuiltinSpecialPropertyGetterName$lambda$1(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor it) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(it, "it");
        return INSTANCE.hasBuiltinSpecialPropertyFqName(it);
    }

    public final boolean hasBuiltinSpecialPropertyFqName(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor callableMemberDescriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callableMemberDescriptor, "callableMemberDescriptor");
        if (kotlin.reflect.jvm.internal.impl.load.java.BuiltinSpecialProperties.INSTANCE.getSPECIAL_SHORT_NAMES().contains(callableMemberDescriptor.getName())) {
            return hasBuiltinSpecialPropertyFqNameImpl(callableMemberDescriptor);
        }
        return false;
    }

    private final boolean hasBuiltinSpecialPropertyFqNameImpl(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor callableMemberDescriptor) {
        kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor callableMemberDescriptor2 = callableMemberDescriptor;
        if (kotlin.collections.CollectionsKt.contains(kotlin.reflect.jvm.internal.impl.load.java.BuiltinSpecialProperties.INSTANCE.getSPECIAL_FQ_NAMES(), kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.fqNameOrNull(callableMemberDescriptor2)) && callableMemberDescriptor.getValueParameters().isEmpty()) {
            return true;
        }
        if (!kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isBuiltIn(callableMemberDescriptor2)) {
            return false;
        }
        java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor> overriddenDescriptors = callableMemberDescriptor.getOverriddenDescriptors();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(overriddenDescriptors, "getOverriddenDescriptors(...)");
        java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor> collection = overriddenDescriptors;
        if (collection.isEmpty()) {
            return false;
        }
        for (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor callableMemberDescriptor3 : collection) {
            kotlin.reflect.jvm.internal.impl.load.java.ClassicBuiltinSpecialProperties classicBuiltinSpecialProperties = INSTANCE;
            kotlin.jvm.internal.Intrinsics.checkNotNull(callableMemberDescriptor3);
            if (classicBuiltinSpecialProperties.hasBuiltinSpecialPropertyFqName(callableMemberDescriptor3)) {
                return true;
            }
        }
        return false;
    }
}
