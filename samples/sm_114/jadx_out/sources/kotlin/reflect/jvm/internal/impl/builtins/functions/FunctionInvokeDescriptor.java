package kotlin.reflect.jvm.internal.impl.builtins.functions;

/* JADX INFO: compiled from: FunctionInvokeDescriptor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FunctionInvokeDescriptor extends kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl {
    public static final kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionInvokeDescriptor.Factory Factory = new kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionInvokeDescriptor.Factory(null);

    public /* synthetic */ FunctionInvokeDescriptor(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor, kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionInvokeDescriptor functionInvokeDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind kind, boolean z, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(declarationDescriptor, functionInvokeDescriptor, kind, z);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExternal() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isInline() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isTailrec() {
        return false;
    }

    private FunctionInvokeDescriptor(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor, kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionInvokeDescriptor functionInvokeDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind kind, boolean z) {
        super(declarationDescriptor, functionInvokeDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion.getEMPTY(), kotlin.reflect.jvm.internal.impl.util.OperatorNameConventions.INVOKE, kind, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement.NO_SOURCE);
        setOperator(true);
        setSuspend(z);
        setHasStableParameterNames(false);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    protected kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor doSubstitute(kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl.CopyConfiguration configuration) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(configuration, "configuration");
        kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionInvokeDescriptor functionInvokeDescriptor = (kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionInvokeDescriptor) super.doSubstitute(configuration);
        if (functionInvokeDescriptor == null) {
            return null;
        }
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> valueParameters = functionInvokeDescriptor.getValueParameters();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> list = valueParameters;
        if (!(list instanceof java.util.Collection) || !list.isEmpty()) {
            java.util.Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                kotlin.reflect.jvm.internal.impl.types.KotlinType type = ((kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) it.next()).getType();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
                if (kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt.extractParameterNameFromFunctionTypeArgument(type) != null) {
                    java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> valueParameters2 = functionInvokeDescriptor.getValueParameters();
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(valueParameters2, "getValueParameters(...)");
                    java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> list2 = valueParameters2;
                    java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(list2, 10));
                    java.util.Iterator<T> it2 = list2.iterator();
                    while (it2.hasNext()) {
                        kotlin.reflect.jvm.internal.impl.types.KotlinType type2 = ((kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) it2.next()).getType();
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(type2, "getType(...)");
                        arrayList.add(kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt.extractParameterNameFromFunctionTypeArgument(type2));
                    }
                    return functionInvokeDescriptor.replaceParameterNames(arrayList);
                }
            }
        }
        return functionInvokeDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    protected kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl createSubstitutedCopy(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor newOwner, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor functionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind kind, kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations annotations, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement source) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(newOwner, "newOwner");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kind, "kind");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(annotations, "annotations");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(source, "source");
        return new kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionInvokeDescriptor(newOwner, (kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionInvokeDescriptor) functionDescriptor, kind, isSuspend());
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor replaceParameterNames(java.util.List<kotlin.reflect.jvm.internal.impl.name.Name> list) {
        kotlin.reflect.jvm.internal.impl.name.Name name;
        kotlin.Pair pair;
        int size = getValueParameters().size() - list.size();
        boolean z = true;
        if (size == 0) {
            java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> valueParameters = getValueParameters();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
            java.util.List listZip = kotlin.collections.CollectionsKt.zip(list, valueParameters);
            if (!(listZip instanceof java.util.Collection) || !listZip.isEmpty()) {
                java.util.Iterator it = listZip.iterator();
                do {
                    if (it.hasNext()) {
                        pair = (kotlin.Pair) it.next();
                    }
                } while (kotlin.jvm.internal.Intrinsics.areEqual((kotlin.reflect.jvm.internal.impl.name.Name) pair.component1(), ((kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) pair.component2()).getName()));
            }
            return this;
        }
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> valueParameters2 = getValueParameters();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(valueParameters2, "getValueParameters(...)");
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> list2 = valueParameters2;
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor valueParameterDescriptor : list2) {
            kotlin.reflect.jvm.internal.impl.name.Name name2 = valueParameterDescriptor.getName();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
            int index = valueParameterDescriptor.getIndex();
            int i = index - size;
            if (i >= 0 && (name = list.get(i)) != null) {
                name2 = name;
            }
            arrayList.add(valueParameterDescriptor.copy(this, name2, index));
        }
        java.util.ArrayList arrayList2 = arrayList;
        kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl.CopyConfiguration copyConfigurationNewCopyBuilder = newCopyBuilder(kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor.EMPTY);
        java.util.List<kotlin.reflect.jvm.internal.impl.name.Name> list3 = list;
        if ((list3 instanceof java.util.Collection) && list3.isEmpty()) {
            z = false;
        } else {
            java.util.Iterator<T> it2 = list3.iterator();
            while (it2.hasNext()) {
                if (((kotlin.reflect.jvm.internal.impl.name.Name) it2.next()) == null) {
                }
            }
            z = false;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl.CopyConfiguration original = copyConfigurationNewCopyBuilder.setHasSynthesizedParameterNames(z).setValueParameters((java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor>) arrayList2).setOriginal((kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) getOriginal());
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(original, "setOriginal(...)");
        kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor functionDescriptorDoSubstitute = super.doSubstitute(original);
        kotlin.jvm.internal.Intrinsics.checkNotNull(functionDescriptorDoSubstitute);
        return functionDescriptorDoSubstitute;
    }

    /* JADX INFO: compiled from: FunctionInvokeDescriptor.kt */
    public static final class Factory {
        public /* synthetic */ Factory(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Factory() {
        }

        public final kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionInvokeDescriptor create(kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassDescriptor functionClass, boolean z) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(functionClass, "functionClass");
            java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> declaredTypeParameters = functionClass.getDeclaredTypeParameters();
            kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionInvokeDescriptor functionInvokeDescriptor = new kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionInvokeDescriptor(functionClass, null, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind.DECLARATION, z, null);
            kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor thisAsReceiverParameter = functionClass.getThisAsReceiverParameter();
            java.util.List listEmptyList = kotlin.collections.CollectionsKt.emptyList();
            java.util.List listEmptyList2 = kotlin.collections.CollectionsKt.emptyList();
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (java.lang.Object obj : declaredTypeParameters) {
                if (((kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) obj).getVariance() != kotlin.reflect.jvm.internal.impl.types.Variance.IN_VARIANCE) {
                    break;
                }
                arrayList.add(obj);
            }
            java.lang.Iterable<kotlin.collections.IndexedValue> iterableWithIndex = kotlin.collections.CollectionsKt.withIndex(arrayList);
            java.util.ArrayList arrayList2 = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(iterableWithIndex, 10));
            for (kotlin.collections.IndexedValue indexedValue : iterableWithIndex) {
                arrayList2.add(kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionInvokeDescriptor.Factory.createValueParameter(functionInvokeDescriptor, indexedValue.getIndex(), (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) indexedValue.getValue()));
            }
            functionInvokeDescriptor.initialize((kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor) null, thisAsReceiverParameter, listEmptyList, listEmptyList2, (java.util.List) arrayList2, (kotlin.reflect.jvm.internal.impl.types.KotlinType) ((kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) kotlin.collections.CollectionsKt.last((java.util.List) declaredTypeParameters)).getDefaultType(), kotlin.reflect.jvm.internal.impl.descriptors.Modality.ABSTRACT, kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.PUBLIC);
            functionInvokeDescriptor.setHasSynthesizedParameterNames(true);
            return functionInvokeDescriptor;
        }

        private final kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor createValueParameter(kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionInvokeDescriptor functionInvokeDescriptor, int i, kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor typeParameterDescriptor) {
            java.lang.String lowerCase;
            java.lang.String strAsString = typeParameterDescriptor.getName().asString();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strAsString, "asString(...)");
            if (kotlin.jvm.internal.Intrinsics.areEqual(strAsString, "T")) {
                lowerCase = "instance";
            } else if (kotlin.jvm.internal.Intrinsics.areEqual(strAsString, "E")) {
                lowerCase = "receiver";
            } else {
                lowerCase = strAsString.toLowerCase(java.util.Locale.ROOT);
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            }
            kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionInvokeDescriptor functionInvokeDescriptor2 = functionInvokeDescriptor;
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations empty = kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion.getEMPTY();
            kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier = kotlin.reflect.jvm.internal.impl.name.Name.identifier(lowerCase);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier, "identifier(...)");
            kotlin.reflect.jvm.internal.impl.types.SimpleType defaultType = typeParameterDescriptor.getDefaultType();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(defaultType, "getDefaultType(...)");
            kotlin.reflect.jvm.internal.impl.descriptors.SourceElement NO_SOURCE = kotlin.reflect.jvm.internal.impl.descriptors.SourceElement.NO_SOURCE;
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(NO_SOURCE, "NO_SOURCE");
            return new kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl(functionInvokeDescriptor2, null, i, empty, nameIdentifier, defaultType, false, false, false, null, NO_SOURCE);
        }
    }
}
