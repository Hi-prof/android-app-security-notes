package kotlin.reflect.jvm.internal;

/* JADX INFO: loaded from: classes2.dex */
public class ReflectionFactoryImpl extends kotlin.jvm.internal.ReflectionFactory {
    @Override // kotlin.jvm.internal.ReflectionFactory
    public void setUpperBounds(kotlin.reflect.KTypeParameter kTypeParameter, java.util.List<kotlin.reflect.KType> list) {
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public kotlin.reflect.KClass createKotlinClass(java.lang.Class cls) {
        return new kotlin.reflect.jvm.internal.KClassImpl(cls);
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public kotlin.reflect.KClass createKotlinClass(java.lang.Class cls, java.lang.String str) {
        return new kotlin.reflect.jvm.internal.KClassImpl(cls);
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public kotlin.reflect.KDeclarationContainer getOrCreateKotlinPackage(java.lang.Class cls, java.lang.String str) {
        return kotlin.reflect.jvm.internal.CachesKt.getOrCreateKotlinPackage(cls);
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public kotlin.reflect.KClass getOrCreateKotlinClass(java.lang.Class cls) {
        return kotlin.reflect.jvm.internal.CachesKt.getOrCreateKotlinClass(cls);
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public kotlin.reflect.KClass getOrCreateKotlinClass(java.lang.Class cls, java.lang.String str) {
        return kotlin.reflect.jvm.internal.CachesKt.getOrCreateKotlinClass(cls);
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public java.lang.String renderLambdaToString(kotlin.jvm.internal.Lambda lambda) {
        return renderLambdaToString((kotlin.jvm.internal.FunctionBase) lambda);
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public java.lang.String renderLambdaToString(kotlin.jvm.internal.FunctionBase functionBase) {
        kotlin.reflect.jvm.internal.KFunctionImpl kFunctionImplAsKFunctionImpl;
        kotlin.reflect.KFunction kFunctionReflect = kotlin.reflect.jvm.ReflectLambdaKt.reflect(functionBase);
        if (kFunctionReflect != null && (kFunctionImplAsKFunctionImpl = kotlin.reflect.jvm.internal.UtilKt.asKFunctionImpl(kFunctionReflect)) != null) {
            return kotlin.reflect.jvm.internal.ReflectionObjectRenderer.INSTANCE.renderLambda(kFunctionImplAsKFunctionImpl.getDescriptor());
        }
        return super.renderLambdaToString(functionBase);
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public kotlin.reflect.KFunction function(kotlin.jvm.internal.FunctionReference functionReference) {
        return new kotlin.reflect.jvm.internal.KFunctionImpl(getOwner(functionReference), functionReference.getName(), functionReference.getSignature(), functionReference.getBoundReceiver());
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public kotlin.reflect.KProperty0 property0(kotlin.jvm.internal.PropertyReference0 propertyReference0) {
        return new kotlin.reflect.jvm.internal.KProperty0Impl(getOwner(propertyReference0), propertyReference0.getName(), propertyReference0.getSignature(), propertyReference0.getBoundReceiver());
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public kotlin.reflect.KMutableProperty0 mutableProperty0(kotlin.jvm.internal.MutablePropertyReference0 mutablePropertyReference0) {
        return new kotlin.reflect.jvm.internal.KMutableProperty0Impl(getOwner(mutablePropertyReference0), mutablePropertyReference0.getName(), mutablePropertyReference0.getSignature(), mutablePropertyReference0.getBoundReceiver());
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public kotlin.reflect.KProperty1 property1(kotlin.jvm.internal.PropertyReference1 propertyReference1) {
        return new kotlin.reflect.jvm.internal.KProperty1Impl(getOwner(propertyReference1), propertyReference1.getName(), propertyReference1.getSignature(), propertyReference1.getBoundReceiver());
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public kotlin.reflect.KMutableProperty1 mutableProperty1(kotlin.jvm.internal.MutablePropertyReference1 mutablePropertyReference1) {
        return new kotlin.reflect.jvm.internal.KMutableProperty1Impl(getOwner(mutablePropertyReference1), mutablePropertyReference1.getName(), mutablePropertyReference1.getSignature(), mutablePropertyReference1.getBoundReceiver());
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public kotlin.reflect.KProperty2 property2(kotlin.jvm.internal.PropertyReference2 propertyReference2) {
        return new kotlin.reflect.jvm.internal.KProperty2Impl(getOwner(propertyReference2), propertyReference2.getName(), propertyReference2.getSignature());
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public kotlin.reflect.KMutableProperty2 mutableProperty2(kotlin.jvm.internal.MutablePropertyReference2 mutablePropertyReference2) {
        return new kotlin.reflect.jvm.internal.KMutableProperty2Impl(getOwner(mutablePropertyReference2), mutablePropertyReference2.getName(), mutablePropertyReference2.getSignature());
    }

    private static kotlin.reflect.jvm.internal.KDeclarationContainerImpl getOwner(kotlin.jvm.internal.CallableReference callableReference) {
        kotlin.reflect.KDeclarationContainer owner = callableReference.getOwner();
        return owner instanceof kotlin.reflect.jvm.internal.KDeclarationContainerImpl ? (kotlin.reflect.jvm.internal.KDeclarationContainerImpl) owner : kotlin.reflect.jvm.internal.EmptyContainerForLocal.INSTANCE;
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public kotlin.reflect.KType typeOf(kotlin.reflect.KClassifier kClassifier, java.util.List<kotlin.reflect.KTypeProjection> list, boolean z) {
        if (kClassifier instanceof kotlin.jvm.internal.ClassBasedDeclarationContainer) {
            return kotlin.reflect.jvm.internal.CachesKt.getOrCreateKType(((kotlin.jvm.internal.ClassBasedDeclarationContainer) kClassifier).getJClass(), list, z);
        }
        return kotlin.reflect.full.KClassifiers.createType(kClassifier, list, z, java.util.Collections.EMPTY_LIST);
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public kotlin.reflect.KTypeParameter typeParameter(java.lang.Object obj, java.lang.String str, kotlin.reflect.KVariance kVariance, boolean z) {
        java.util.List<kotlin.reflect.KTypeParameter> typeParameters;
        if (obj instanceof kotlin.reflect.KClass) {
            typeParameters = ((kotlin.reflect.KClass) obj).getTypeParameters();
        } else if (obj instanceof kotlin.reflect.KCallable) {
            typeParameters = ((kotlin.reflect.KCallable) obj).getTypeParameters();
        } else {
            throw new java.lang.IllegalArgumentException("Type parameter container must be a class or a callable: " + obj);
        }
        for (kotlin.reflect.KTypeParameter kTypeParameter : typeParameters) {
            if (kTypeParameter.getName().equals(str)) {
                return kTypeParameter;
            }
        }
        throw new java.lang.IllegalArgumentException("Type parameter " + str + " is not found in container: " + obj);
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public kotlin.reflect.KType platformType(kotlin.reflect.KType kType, kotlin.reflect.KType kType2) {
        return kotlin.reflect.jvm.internal.TypeOfImplKt.createPlatformKType(kType, kType2);
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public kotlin.reflect.KType mutableCollectionType(kotlin.reflect.KType kType) {
        return kotlin.reflect.jvm.internal.TypeOfImplKt.createMutableCollectionKType(kType);
    }

    @Override // kotlin.jvm.internal.ReflectionFactory
    public kotlin.reflect.KType nothingType(kotlin.reflect.KType kType) {
        return kotlin.reflect.jvm.internal.TypeOfImplKt.createNothingType(kType);
    }

    public static void clearCaches() {
        kotlin.reflect.jvm.internal.CachesKt.clearCaches();
        kotlin.reflect.jvm.internal.ModuleByClassLoaderKt.clearModuleByClassLoaderCache();
    }
}
