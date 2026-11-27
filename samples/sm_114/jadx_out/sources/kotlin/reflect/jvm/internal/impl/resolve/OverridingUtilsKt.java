package kotlin.reflect.jvm.internal.impl.resolve;

/* JADX INFO: compiled from: overridingUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class OverridingUtilsKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <H> java.util.Collection<H> selectMostSpecificInEachOverridableGroup(java.util.Collection<? extends H> collection, kotlin.jvm.functions.Function1<? super H, ? extends kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor> descriptorByHandle) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(collection, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(descriptorByHandle, "descriptorByHandle");
        if (collection.size() <= 1) {
            return collection;
        }
        java.util.LinkedList linkedList = new java.util.LinkedList(collection);
        kotlin.reflect.jvm.internal.impl.utils.SmartSet smartSetCreate = kotlin.reflect.jvm.internal.impl.utils.SmartSet.Companion.create();
        while (true) {
            java.util.LinkedList linkedList2 = linkedList;
            if (!linkedList2.isEmpty()) {
                java.lang.Object objFirst = kotlin.collections.CollectionsKt.first((java.util.List<? extends java.lang.Object>) linkedList);
                final kotlin.reflect.jvm.internal.impl.utils.SmartSet smartSetCreate2 = kotlin.reflect.jvm.internal.impl.utils.SmartSet.Companion.create();
                java.util.Collection<android.R.anim> collectionExtractMembersOverridableInBothWays = kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.extractMembersOverridableInBothWays(objFirst, linkedList2, descriptorByHandle, new kotlin.jvm.functions.Function1(smartSetCreate2) { // from class: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtilsKt$$Lambda$1
                    private final kotlin.reflect.jvm.internal.impl.utils.SmartSet arg$0;

                    {
                        this.arg$0 = smartSetCreate2;
                    }

                    @Override // kotlin.jvm.functions.Function1
                    /* JADX INFO: renamed from: invoke */
                    public java.lang.Object invoke2(java.lang.Object obj) {
                        return kotlin.reflect.jvm.internal.impl.resolve.OverridingUtilsKt.selectMostSpecificInEachOverridableGroup$lambda$2(this.arg$0, obj);
                    }
                });
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(collectionExtractMembersOverridableInBothWays, "extractMembersOverridableInBothWays(...)");
                if (collectionExtractMembersOverridableInBothWays.size() == 1 && smartSetCreate2.isEmpty()) {
                    java.lang.Object objSingle = kotlin.collections.CollectionsKt.single(collectionExtractMembersOverridableInBothWays);
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(objSingle, "single(...)");
                    smartSetCreate.add(objSingle);
                } else {
                    android.R.animator animatorVar = (java.lang.Object) kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.selectMostSpecificMember(collectionExtractMembersOverridableInBothWays, descriptorByHandle);
                    kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor callableDescriptorInvoke2 = descriptorByHandle.invoke2(animatorVar);
                    for (android.R.anim animVar : collectionExtractMembersOverridableInBothWays) {
                        kotlin.jvm.internal.Intrinsics.checkNotNull(animVar);
                        if (!kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.isMoreSpecific(callableDescriptorInvoke2, descriptorByHandle.invoke2(animVar))) {
                            smartSetCreate2.add(animVar);
                        }
                    }
                    kotlin.reflect.jvm.internal.impl.utils.SmartSet smartSet = smartSetCreate2;
                    if (!smartSet.isEmpty()) {
                        smartSetCreate.addAll(smartSet);
                    }
                    smartSetCreate.add(animatorVar);
                }
            } else {
                return smartSetCreate;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit selectMostSpecificInEachOverridableGroup$lambda$2(kotlin.reflect.jvm.internal.impl.utils.SmartSet smartSet, java.lang.Object obj) {
        kotlin.jvm.internal.Intrinsics.checkNotNull(obj);
        smartSet.add(obj);
        return kotlin.Unit.INSTANCE;
    }
}
