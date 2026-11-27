package kotlin.reflect.jvm.internal;

/* JADX INFO: compiled from: KClassImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 n*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u00042\u00020\u00052\u00020\u0006:\u0002mnB\u0015\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0004\b\t\u0010\nJ\u0016\u00101\u001a\b\u0012\u0004\u0012\u0002020*2\u0006\u00103\u001a\u000204H\u0016J\u0016\u00105\u001a\b\u0012\u0004\u0012\u0002060*2\u0006\u00103\u001a\u000204H\u0016J\u0012\u00107\u001a\u0004\u0018\u0001022\u0006\u00108\u001a\u000209H\u0016J\u0012\u0010H\u001a\u00020I2\b\u0010J\u001a\u0004\u0018\u00010\u0002H\u0016J\u0013\u0010e\u001a\u00020I2\b\u0010f\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010g\u001a\u000209H\u0016J\b\u0010h\u001a\u00020;H\u0016J\u0018\u0010i\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010j\u001a\u00020kH\u0002J\u0018\u0010l\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010j\u001a\u00020kH\u0002R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR!\u0010\r\u001a\u0012\u0012\u000e\u0012\f0\u000fR\b\u0012\u0004\u0012\u00028\u00000\u00000\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020 8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020$8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020$8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b(\u0010&R\u001e\u0010)\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030+0*8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020/0*8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b0\u0010-R\u0016\u0010:\u001a\u0004\u0018\u00010;8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b<\u0010=R\u0016\u0010>\u001a\u0004\u0018\u00010;8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b?\u0010=R \u0010@\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000A0*8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bB\u0010-R\u001e\u0010C\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040*8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bD\u0010-R\u0016\u0010E\u001a\u0004\u0018\u00018\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bF\u0010GR\u001a\u0010K\u001a\b\u0012\u0004\u0012\u00020L0\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bM\u0010\u001eR\u001a\u0010N\u001a\b\u0012\u0004\u0012\u00020O0\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bP\u0010\u001eR\"\u0010Q\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00040\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bR\u0010\u001eR\u0016\u0010S\u001a\u0004\u0018\u00010T8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bU\u0010VR\u0014\u0010W\u001a\u00020X8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bY\u0010ZR\u0014\u0010[\u001a\u00020I8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b[\u0010\\R\u0014\u0010]\u001a\u00020I8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b]\u0010\\R\u0014\u0010^\u001a\u00020I8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b^\u0010\\R\u0014\u0010_\u001a\u00020I8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b_\u0010\\R\u0014\u0010`\u001a\u00020I8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b`\u0010\\R\u0014\u0010a\u001a\u00020I8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\ba\u0010\\R\u0014\u0010b\u001a\u00020I8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bb\u0010\\R\u0014\u0010c\u001a\u00020I8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bc\u0010\\R\u0014\u0010d\u001a\u00020I8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bd\u0010\\¨\u0006o"}, d2 = {"Lkotlin/reflect/jvm/internal/KClassImpl;", "T", "", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Lkotlin/reflect/KClass;", "Lkotlin/reflect/jvm/internal/KClassifierImpl;", "Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;", "jClass", "Ljava/lang/Class;", "<init>", "(Ljava/lang/Class;)V", "getJClass", "()Ljava/lang/Class;", "data", "Lkotlin/Lazy;", "Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "getData", "()Lkotlin/Lazy;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "kmClass", "Lkotlin/reflect/jvm/internal/impl/km/KmClass;", "getKmClass", "()Lkotlin/metadata/KmClass;", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "classId", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "getClassId", "()Lorg/jetbrains/kotlin/name/ClassId;", "memberScope", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "getMemberScope$kotlin_reflection", "()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", "staticScope", "getStaticScope$kotlin_reflection", "members", "", "Lkotlin/reflect/KCallable;", "getMembers", "()Ljava/util/Collection;", "constructorDescriptors", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "getProperties", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "name", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "getFunctions", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "getLocalProperty", "index", "", "simpleName", "", "getSimpleName", "()Ljava/lang/String;", "qualifiedName", "getQualifiedName", "constructors", "Lkotlin/reflect/KFunction;", "getConstructors", "nestedClasses", "getNestedClasses", "objectInstance", "getObjectInstance", "()Ljava/lang/Object;", "isInstance", "", "value", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "supertypes", "Lkotlin/reflect/KType;", "getSupertypes", "sealedSubclasses", "getSealedSubclasses", com.taobao.weex.common.Constants.Name.VISIBILITY, "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", "modality", "Lkotlin/reflect/jvm/internal/impl/km/Modality;", "getModality", "()Lkotlin/metadata/Modality;", "isFinal", "()Z", "isOpen", "isAbstract", "isSealed", "isData", "isInner", "isCompanion", "isFun", "isValue", "equals", "other", "hashCode", "toString", "createSyntheticClassOrFail", "moduleData", "Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/RuntimeModuleData;", "createSyntheticClass", "Data", "Companion", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class KClassImpl<T> extends kotlin.reflect.jvm.internal.KDeclarationContainerImpl implements kotlin.reflect.KClass<T>, kotlin.reflect.jvm.internal.KClassifierImpl, kotlin.reflect.jvm.internal.KTypeParameterOwnerImpl {
    private static final java.util.Set<java.lang.String> SPECIAL_JVM_ANNOTATION_NAMES;
    private final kotlin.Lazy<kotlin.reflect.jvm.internal.KClassImpl<T>.Data> data;
    private final java.lang.Class<T> jClass;

    /* JADX INFO: compiled from: KClassImpl.kt */
    @kotlin.Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader.Kind.values().length];
            try {
                iArr[kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader.Kind.FILE_FACADE.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader.Kind.MULTIFILE_CLASS.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader.Kind.MULTIFILE_CLASS_PART.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader.Kind.SYNTHETIC_CLASS.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader.Kind.UNKNOWN.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader.Kind.CLASS.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // kotlin.jvm.internal.ClassBasedDeclarationContainer
    public java.lang.Class<T> getJClass() {
        return this.jClass;
    }

    /* JADX INFO: compiled from: KClassImpl.kt */
    @kotlin.Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u001f\u001a\u00020\u00182\n\u0010 \u001a\u0006\u0012\u0002\b\u00030!H\u0002R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u00188FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0010\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u00188FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0010\u001a\u0004\b\u001d\u0010\u001aR-\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000$0#8FX\u0086\u0084\u0002¢\u0006\u0012\n\u0004\b)\u0010\u0010\u0012\u0004\b%\u0010&\u001a\u0004\b'\u0010(R%\u0010*\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030+0#8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\u0010\u001a\u0004\b,\u0010(R#\u0010.\u001a\u0004\u0018\u00018\u00008FX\u0086\u0084\u0002¢\u0006\u0012\n\u0004\b2\u0010\n\u0012\u0004\b/\u0010&\u001a\u0004\b0\u00101R!\u00103\u001a\b\u0012\u0004\u0012\u0002040\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b6\u0010\u0010\u001a\u0004\b5\u0010\u0015R!\u00107\u001a\b\u0012\u0004\u0012\u0002080\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b:\u0010\u0010\u001a\u0004\b9\u0010\u0015R)\u0010;\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000+0\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b=\u0010\u0010\u001a\u0004\b<\u0010\u0015R%\u0010>\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030?0#8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bA\u0010\u0010\u001a\u0004\b@\u0010(R%\u0010B\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030?0#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bD\u0010\u0010\u001a\u0004\bC\u0010(R%\u0010E\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030?0#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bG\u0010\u0010\u001a\u0004\bF\u0010(R%\u0010H\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030?0#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010\u0010\u001a\u0004\bI\u0010(R%\u0010K\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030?0#8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bM\u0010\u0010\u001a\u0004\bL\u0010(R%\u0010N\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030?0#8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bP\u0010\u0010\u001a\u0004\bO\u0010(R%\u0010Q\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030?0#8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bS\u0010\u0010\u001a\u0004\bR\u0010(R%\u0010T\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030?0#8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bV\u0010\u0010\u001a\u0004\bU\u0010(¨\u0006W"}, d2 = {"Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "<init>", "(Lkotlin/reflect/jvm/internal/KClassImpl;)V", "kmClass", "Lkotlin/reflect/jvm/internal/impl/km/KmClass;", "getKmClass", "()Lkotlin/metadata/KmClass;", "kmClass$delegate", "Lkotlin/Lazy;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "descriptor$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "annotations$delegate", "simpleName", "", "getSimpleName", "()Ljava/lang/String;", "simpleName$delegate", "qualifiedName", "getQualifiedName", "qualifiedName$delegate", "calculateLocalClassName", "jClass", "Ljava/lang/Class;", "constructors", "", "Lkotlin/reflect/KFunction;", "getConstructors$annotations", "()V", "getConstructors", "()Ljava/util/Collection;", "constructors$delegate", "nestedClasses", "Lkotlin/reflect/KClass;", "getNestedClasses", "nestedClasses$delegate", "objectInstance", "getObjectInstance$annotations", "getObjectInstance", "()Ljava/lang/Object;", "objectInstance$delegate", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "typeParameters$delegate", "supertypes", "Lkotlin/reflect/KType;", "getSupertypes", "supertypes$delegate", "sealedSubclasses", "getSealedSubclasses", "sealedSubclasses$delegate", "declaredNonStaticMembers", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "getDeclaredNonStaticMembers", "declaredNonStaticMembers$delegate", "declaredStaticMembers", "getDeclaredStaticMembers", "declaredStaticMembers$delegate", "inheritedNonStaticMembers", "getInheritedNonStaticMembers", "inheritedNonStaticMembers$delegate", "inheritedStaticMembers", "getInheritedStaticMembers", "inheritedStaticMembers$delegate", "allNonStaticMembers", "getAllNonStaticMembers", "allNonStaticMembers$delegate", "allStaticMembers", "getAllStaticMembers", "allStaticMembers$delegate", "declaredMembers", "getDeclaredMembers", "declaredMembers$delegate", "allMembers", "getAllMembers", "allMembers$delegate", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public final class Data extends kotlin.reflect.jvm.internal.KDeclarationContainerImpl.Data {
        static final /* synthetic */ kotlin.reflect.KProperty<java.lang.Object>[] $$delegatedProperties = {kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.KClassImpl.Data.class, "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", 0)), kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.KClassImpl.Data.class, "annotations", "getAnnotations()Ljava/util/List;", 0)), kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.KClassImpl.Data.class, "simpleName", "getSimpleName()Ljava/lang/String;", 0)), kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.KClassImpl.Data.class, "qualifiedName", "getQualifiedName()Ljava/lang/String;", 0)), kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.KClassImpl.Data.class, "constructors", "getConstructors()Ljava/util/Collection;", 0)), kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.KClassImpl.Data.class, "nestedClasses", "getNestedClasses()Ljava/util/Collection;", 0)), kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.KClassImpl.Data.class, "typeParameters", "getTypeParameters()Ljava/util/List;", 0)), kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.KClassImpl.Data.class, "supertypes", "getSupertypes()Ljava/util/List;", 0)), kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.KClassImpl.Data.class, "sealedSubclasses", "getSealedSubclasses()Ljava/util/List;", 0)), kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.KClassImpl.Data.class, "declaredNonStaticMembers", "getDeclaredNonStaticMembers()Ljava/util/Collection;", 0)), kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.KClassImpl.Data.class, "declaredStaticMembers", "getDeclaredStaticMembers()Ljava/util/Collection;", 0)), kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.KClassImpl.Data.class, "inheritedNonStaticMembers", "getInheritedNonStaticMembers()Ljava/util/Collection;", 0)), kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.KClassImpl.Data.class, "inheritedStaticMembers", "getInheritedStaticMembers()Ljava/util/Collection;", 0)), kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.KClassImpl.Data.class, "allNonStaticMembers", "getAllNonStaticMembers()Ljava/util/Collection;", 0)), kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.KClassImpl.Data.class, "allStaticMembers", "getAllStaticMembers()Ljava/util/Collection;", 0)), kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.KClassImpl.Data.class, "declaredMembers", "getDeclaredMembers()Ljava/util/Collection;", 0)), kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.KClassImpl.Data.class, "allMembers", "getAllMembers()Ljava/util/Collection;", 0))};

        /* JADX INFO: renamed from: allMembers$delegate, reason: from kotlin metadata */
        private final kotlin.reflect.jvm.internal.ReflectProperties.LazySoftVal allMembers;

        /* JADX INFO: renamed from: allNonStaticMembers$delegate, reason: from kotlin metadata */
        private final kotlin.reflect.jvm.internal.ReflectProperties.LazySoftVal allNonStaticMembers;

        /* JADX INFO: renamed from: allStaticMembers$delegate, reason: from kotlin metadata */
        private final kotlin.reflect.jvm.internal.ReflectProperties.LazySoftVal allStaticMembers;

        /* JADX INFO: renamed from: annotations$delegate, reason: from kotlin metadata */
        private final kotlin.reflect.jvm.internal.ReflectProperties.LazySoftVal annotations;

        /* JADX INFO: renamed from: constructors$delegate, reason: from kotlin metadata */
        private final kotlin.reflect.jvm.internal.ReflectProperties.LazySoftVal constructors;

        /* JADX INFO: renamed from: declaredMembers$delegate, reason: from kotlin metadata */
        private final kotlin.reflect.jvm.internal.ReflectProperties.LazySoftVal declaredMembers;

        /* JADX INFO: renamed from: declaredNonStaticMembers$delegate, reason: from kotlin metadata */
        private final kotlin.reflect.jvm.internal.ReflectProperties.LazySoftVal declaredNonStaticMembers;

        /* JADX INFO: renamed from: declaredStaticMembers$delegate, reason: from kotlin metadata */
        private final kotlin.reflect.jvm.internal.ReflectProperties.LazySoftVal declaredStaticMembers;

        /* JADX INFO: renamed from: descriptor$delegate, reason: from kotlin metadata */
        private final kotlin.reflect.jvm.internal.ReflectProperties.LazySoftVal descriptor;

        /* JADX INFO: renamed from: inheritedNonStaticMembers$delegate, reason: from kotlin metadata */
        private final kotlin.reflect.jvm.internal.ReflectProperties.LazySoftVal inheritedNonStaticMembers;

        /* JADX INFO: renamed from: inheritedStaticMembers$delegate, reason: from kotlin metadata */
        private final kotlin.reflect.jvm.internal.ReflectProperties.LazySoftVal inheritedStaticMembers;

        /* JADX INFO: renamed from: kmClass$delegate, reason: from kotlin metadata */
        private final kotlin.Lazy kmClass;

        /* JADX INFO: renamed from: nestedClasses$delegate, reason: from kotlin metadata */
        private final kotlin.reflect.jvm.internal.ReflectProperties.LazySoftVal nestedClasses;

        /* JADX INFO: renamed from: objectInstance$delegate, reason: from kotlin metadata */
        private final kotlin.Lazy objectInstance;

        /* JADX INFO: renamed from: qualifiedName$delegate, reason: from kotlin metadata */
        private final kotlin.reflect.jvm.internal.ReflectProperties.LazySoftVal qualifiedName;

        /* JADX INFO: renamed from: sealedSubclasses$delegate, reason: from kotlin metadata */
        private final kotlin.reflect.jvm.internal.ReflectProperties.LazySoftVal sealedSubclasses;

        /* JADX INFO: renamed from: simpleName$delegate, reason: from kotlin metadata */
        private final kotlin.reflect.jvm.internal.ReflectProperties.LazySoftVal simpleName;

        /* JADX INFO: renamed from: supertypes$delegate, reason: from kotlin metadata */
        private final kotlin.reflect.jvm.internal.ReflectProperties.LazySoftVal supertypes;

        /* JADX INFO: renamed from: typeParameters$delegate, reason: from kotlin metadata */
        private final kotlin.reflect.jvm.internal.ReflectProperties.LazySoftVal typeParameters;

        public Data() {
            super();
            this.kmClass = kotlin.LazyKt.lazy(kotlin.LazyThreadSafetyMode.PUBLICATION, new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$0
                private final kotlin.reflect.jvm.internal.KClassImpl.Data arg$0;

                {
                    this.arg$0 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public java.lang.Object invoke() {
                    return kotlin.reflect.jvm.internal.KClassImpl.Data.kmClass_delegate$lambda$1(this.arg$0);
                }
            });
            this.descriptor = kotlin.reflect.jvm.internal.ReflectProperties.lazySoft(new kotlin.jvm.functions.Function0(kotlin.reflect.jvm.internal.KClassImpl.this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$1
                private final kotlin.reflect.jvm.internal.KClassImpl arg$0;

                {
                    this.arg$0 = kClassImpl;
                }

                @Override // kotlin.jvm.functions.Function0
                public java.lang.Object invoke() {
                    return kotlin.reflect.jvm.internal.KClassImpl.Data.descriptor_delegate$lambda$2(this.arg$0);
                }
            });
            this.annotations = kotlin.reflect.jvm.internal.ReflectProperties.lazySoft(new kotlin.jvm.functions.Function0(kotlin.reflect.jvm.internal.KClassImpl.this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$2
                private final kotlin.reflect.jvm.internal.KClassImpl arg$0;

                {
                    this.arg$0 = kClassImpl;
                }

                @Override // kotlin.jvm.functions.Function0
                public java.lang.Object invoke() {
                    return kotlin.reflect.jvm.internal.KClassImpl.Data.annotations_delegate$lambda$4(this.arg$0);
                }
            });
            this.simpleName = kotlin.reflect.jvm.internal.ReflectProperties.lazySoft(new kotlin.jvm.functions.Function0(kotlin.reflect.jvm.internal.KClassImpl.this, this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$3
                private final kotlin.reflect.jvm.internal.KClassImpl arg$0;
                private final kotlin.reflect.jvm.internal.KClassImpl.Data arg$1;

                {
                    this.arg$0 = kClassImpl;
                    this.arg$1 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public java.lang.Object invoke() {
                    return kotlin.reflect.jvm.internal.KClassImpl.Data.simpleName_delegate$lambda$5(this.arg$0, this.arg$1);
                }
            });
            this.qualifiedName = kotlin.reflect.jvm.internal.ReflectProperties.lazySoft(new kotlin.jvm.functions.Function0(kotlin.reflect.jvm.internal.KClassImpl.this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$4
                private final kotlin.reflect.jvm.internal.KClassImpl arg$0;

                {
                    this.arg$0 = kClassImpl;
                }

                @Override // kotlin.jvm.functions.Function0
                public java.lang.Object invoke() {
                    return kotlin.reflect.jvm.internal.KClassImpl.Data.qualifiedName_delegate$lambda$6(this.arg$0);
                }
            });
            this.constructors = kotlin.reflect.jvm.internal.ReflectProperties.lazySoft(new kotlin.jvm.functions.Function0(kotlin.reflect.jvm.internal.KClassImpl.this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$5
                private final kotlin.reflect.jvm.internal.KClassImpl arg$0;

                {
                    this.arg$0 = kClassImpl;
                }

                @Override // kotlin.jvm.functions.Function0
                public java.lang.Object invoke() {
                    return kotlin.reflect.jvm.internal.KClassImpl.Data.constructors_delegate$lambda$10(this.arg$0);
                }
            });
            this.nestedClasses = kotlin.reflect.jvm.internal.ReflectProperties.lazySoft(new kotlin.jvm.functions.Function0(this, kotlin.reflect.jvm.internal.KClassImpl.this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$6
                private final kotlin.reflect.jvm.internal.KClassImpl.Data arg$0;
                private final kotlin.reflect.jvm.internal.KClassImpl arg$1;

                {
                    this.arg$0 = this;
                    this.arg$1 = kClassImpl;
                }

                @Override // kotlin.jvm.functions.Function0
                public java.lang.Object invoke() {
                    return kotlin.reflect.jvm.internal.KClassImpl.Data.nestedClasses_delegate$lambda$13(this.arg$0, this.arg$1);
                }
            });
            this.objectInstance = kotlin.LazyKt.lazy(kotlin.LazyThreadSafetyMode.PUBLICATION, new kotlin.jvm.functions.Function0(this, kotlin.reflect.jvm.internal.KClassImpl.this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$7
                private final kotlin.reflect.jvm.internal.KClassImpl.Data arg$0;
                private final kotlin.reflect.jvm.internal.KClassImpl arg$1;

                {
                    this.arg$0 = this;
                    this.arg$1 = kClassImpl;
                }

                @Override // kotlin.jvm.functions.Function0
                public java.lang.Object invoke() {
                    return kotlin.reflect.jvm.internal.KClassImpl.Data.objectInstance_delegate$lambda$14(this.arg$0, this.arg$1);
                }
            });
            this.typeParameters = kotlin.reflect.jvm.internal.ReflectProperties.lazySoft(new kotlin.jvm.functions.Function0(this, kotlin.reflect.jvm.internal.KClassImpl.this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$8
                private final kotlin.reflect.jvm.internal.KClassImpl.Data arg$0;
                private final kotlin.reflect.jvm.internal.KClassImpl arg$1;

                {
                    this.arg$0 = this;
                    this.arg$1 = kClassImpl;
                }

                @Override // kotlin.jvm.functions.Function0
                public java.lang.Object invoke() {
                    return kotlin.reflect.jvm.internal.KClassImpl.Data.typeParameters_delegate$lambda$16(this.arg$0, this.arg$1);
                }
            });
            this.supertypes = kotlin.reflect.jvm.internal.ReflectProperties.lazySoft(new kotlin.jvm.functions.Function0(this, kotlin.reflect.jvm.internal.KClassImpl.this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$9
                private final kotlin.reflect.jvm.internal.KClassImpl.Data arg$0;
                private final kotlin.reflect.jvm.internal.KClassImpl arg$1;

                {
                    this.arg$0 = this;
                    this.arg$1 = kClassImpl;
                }

                @Override // kotlin.jvm.functions.Function0
                public java.lang.Object invoke() {
                    return kotlin.reflect.jvm.internal.KClassImpl.Data.supertypes_delegate$lambda$21(this.arg$0, this.arg$1);
                }
            });
            this.sealedSubclasses = kotlin.reflect.jvm.internal.ReflectProperties.lazySoft(new kotlin.jvm.functions.Function0(kotlin.reflect.jvm.internal.KClassImpl.this, this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$10
                private final kotlin.reflect.jvm.internal.KClassImpl arg$0;
                private final kotlin.reflect.jvm.internal.KClassImpl.Data arg$1;

                {
                    this.arg$0 = kClassImpl;
                    this.arg$1 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public java.lang.Object invoke() {
                    return kotlin.reflect.jvm.internal.KClassImpl.Data.sealedSubclasses_delegate$lambda$23(this.arg$0, this.arg$1);
                }
            });
            this.declaredNonStaticMembers = kotlin.reflect.jvm.internal.ReflectProperties.lazySoft(new kotlin.jvm.functions.Function0(kotlin.reflect.jvm.internal.KClassImpl.this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$11
                private final kotlin.reflect.jvm.internal.KClassImpl arg$0;

                {
                    this.arg$0 = kClassImpl;
                }

                @Override // kotlin.jvm.functions.Function0
                public java.lang.Object invoke() {
                    return kotlin.reflect.jvm.internal.KClassImpl.Data.declaredNonStaticMembers_delegate$lambda$24(this.arg$0);
                }
            });
            this.declaredStaticMembers = kotlin.reflect.jvm.internal.ReflectProperties.lazySoft(new kotlin.jvm.functions.Function0(kotlin.reflect.jvm.internal.KClassImpl.this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$12
                private final kotlin.reflect.jvm.internal.KClassImpl arg$0;

                {
                    this.arg$0 = kClassImpl;
                }

                @Override // kotlin.jvm.functions.Function0
                public java.lang.Object invoke() {
                    return kotlin.reflect.jvm.internal.KClassImpl.Data.declaredStaticMembers_delegate$lambda$25(this.arg$0);
                }
            });
            this.inheritedNonStaticMembers = kotlin.reflect.jvm.internal.ReflectProperties.lazySoft(new kotlin.jvm.functions.Function0(kotlin.reflect.jvm.internal.KClassImpl.this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$13
                private final kotlin.reflect.jvm.internal.KClassImpl arg$0;

                {
                    this.arg$0 = kClassImpl;
                }

                @Override // kotlin.jvm.functions.Function0
                public java.lang.Object invoke() {
                    return kotlin.reflect.jvm.internal.KClassImpl.Data.inheritedNonStaticMembers_delegate$lambda$26(this.arg$0);
                }
            });
            this.inheritedStaticMembers = kotlin.reflect.jvm.internal.ReflectProperties.lazySoft(new kotlin.jvm.functions.Function0(kotlin.reflect.jvm.internal.KClassImpl.this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$14
                private final kotlin.reflect.jvm.internal.KClassImpl arg$0;

                {
                    this.arg$0 = kClassImpl;
                }

                @Override // kotlin.jvm.functions.Function0
                public java.lang.Object invoke() {
                    return kotlin.reflect.jvm.internal.KClassImpl.Data.inheritedStaticMembers_delegate$lambda$27(this.arg$0);
                }
            });
            this.allNonStaticMembers = kotlin.reflect.jvm.internal.ReflectProperties.lazySoft(new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$15
                private final kotlin.reflect.jvm.internal.KClassImpl.Data arg$0;

                {
                    this.arg$0 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public java.lang.Object invoke() {
                    return kotlin.reflect.jvm.internal.KClassImpl.Data.allNonStaticMembers_delegate$lambda$28(this.arg$0);
                }
            });
            this.allStaticMembers = kotlin.reflect.jvm.internal.ReflectProperties.lazySoft(new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$16
                private final kotlin.reflect.jvm.internal.KClassImpl.Data arg$0;

                {
                    this.arg$0 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public java.lang.Object invoke() {
                    return kotlin.reflect.jvm.internal.KClassImpl.Data.allStaticMembers_delegate$lambda$29(this.arg$0);
                }
            });
            this.declaredMembers = kotlin.reflect.jvm.internal.ReflectProperties.lazySoft(new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$17
                private final kotlin.reflect.jvm.internal.KClassImpl.Data arg$0;

                {
                    this.arg$0 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public java.lang.Object invoke() {
                    return kotlin.reflect.jvm.internal.KClassImpl.Data.declaredMembers_delegate$lambda$30(this.arg$0);
                }
            });
            this.allMembers = kotlin.reflect.jvm.internal.ReflectProperties.lazySoft(new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$18
                private final kotlin.reflect.jvm.internal.KClassImpl.Data arg$0;

                {
                    this.arg$0 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public java.lang.Object invoke() {
                    return kotlin.reflect.jvm.internal.KClassImpl.Data.allMembers_delegate$lambda$31(this.arg$0);
                }
            });
        }

        public final kotlin.reflect.jvm.internal.impl.km.KmClass getKmClass() {
            return (kotlin.reflect.jvm.internal.impl.km.KmClass) this.kmClass.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final kotlin.reflect.jvm.internal.impl.km.KmClass kmClass_delegate$lambda$1(kotlin.reflect.jvm.internal.KClassImpl.Data data) {
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor descriptor = data.getDescriptor();
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor deserializedClassDescriptor = descriptor instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor ? (kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor) descriptor : null;
            if (deserializedClassDescriptor != null) {
                return kotlin.reflect.jvm.internal.impl.km.internal.ReadersKt.toKmClass$default(deserializedClassDescriptor.getClassProto(), deserializedClassDescriptor.getC().getNameResolver(), false, null, 6, null);
            }
            return null;
        }

        public final kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor getDescriptor() {
            T value = this.descriptor.getValue(this, $$delegatedProperties[0]);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            return (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor descriptor_delegate$lambda$2(kotlin.reflect.jvm.internal.KClassImpl kClassImpl) {
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptorFindClassAcrossModuleDependencies;
            kotlin.reflect.jvm.internal.impl.name.ClassId classId = kClassImpl.getClassId();
            kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData moduleData = kClassImpl.getData().getValue().getModuleData();
            kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor module = moduleData.getModule();
            if (classId.isLocal() && kClassImpl.getJClass().isAnnotationPresent(kotlin.Metadata.class)) {
                classDescriptorFindClassAcrossModuleDependencies = moduleData.getDeserialization().deserializeClass(classId);
            } else {
                classDescriptorFindClassAcrossModuleDependencies = kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt.findClassAcrossModuleDependencies(module, classId);
            }
            return classDescriptorFindClassAcrossModuleDependencies == null ? kClassImpl.createSyntheticClassOrFail(classId, moduleData) : classDescriptorFindClassAcrossModuleDependencies;
        }

        public final java.util.List<java.lang.annotation.Annotation> getAnnotations() {
            T value = this.annotations.getValue(this, $$delegatedProperties[1]);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            return (java.util.List) value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final java.util.List annotations_delegate$lambda$4(kotlin.reflect.jvm.internal.KClassImpl kClassImpl) {
            java.lang.annotation.Annotation[] annotations = kClassImpl.getJClass().getAnnotations();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(annotations, "getAnnotations(...)");
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (java.lang.annotation.Annotation annotation : annotations) {
                if (!kotlin.reflect.jvm.internal.KClassImpl.SPECIAL_JVM_ANNOTATION_NAMES.contains(kotlin.jvm.JvmClassMappingKt.getJavaClass(kotlin.jvm.JvmClassMappingKt.getAnnotationClass(annotation)).getName())) {
                    arrayList.add(annotation);
                }
            }
            return kotlin.reflect.jvm.internal.UtilKt.unwrapRepeatableAnnotations(arrayList);
        }

        public final java.lang.String getSimpleName() {
            return (java.lang.String) this.simpleName.getValue(this, $$delegatedProperties[2]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final java.lang.String simpleName_delegate$lambda$5(kotlin.reflect.jvm.internal.KClassImpl kClassImpl, kotlin.reflect.jvm.internal.KClassImpl.Data data) {
            if (kClassImpl.getJClass().isAnonymousClass()) {
                return null;
            }
            kotlin.reflect.jvm.internal.impl.name.ClassId classId = kClassImpl.getClassId();
            if (classId.isLocal()) {
                return data.calculateLocalClassName(kClassImpl.getJClass());
            }
            java.lang.String strAsString = classId.getShortClassName().asString();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strAsString, "asString(...)");
            return strAsString;
        }

        public final java.lang.String getQualifiedName() {
            return (java.lang.String) this.qualifiedName.getValue(this, $$delegatedProperties[3]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final java.lang.String qualifiedName_delegate$lambda$6(kotlin.reflect.jvm.internal.KClassImpl kClassImpl) {
            if (kClassImpl.getJClass().isAnonymousClass()) {
                return null;
            }
            kotlin.reflect.jvm.internal.impl.name.ClassId classId = kClassImpl.getClassId();
            if (classId.isLocal()) {
                return null;
            }
            return classId.asSingleFqName().asString();
        }

        private final java.lang.String calculateLocalClassName(java.lang.Class<?> jClass) {
            java.lang.String simpleName = jClass.getSimpleName();
            java.lang.reflect.Method enclosingMethod = jClass.getEnclosingMethod();
            if (enclosingMethod != null) {
                kotlin.jvm.internal.Intrinsics.checkNotNull(simpleName);
                return kotlin.text.StringsKt.substringAfter$default(simpleName, enclosingMethod.getName() + '$', (java.lang.String) null, 2, (java.lang.Object) null);
            }
            java.lang.reflect.Constructor<?> enclosingConstructor = jClass.getEnclosingConstructor();
            if (enclosingConstructor != null) {
                kotlin.jvm.internal.Intrinsics.checkNotNull(simpleName);
                return kotlin.text.StringsKt.substringAfter$default(simpleName, enclosingConstructor.getName() + '$', (java.lang.String) null, 2, (java.lang.Object) null);
            }
            kotlin.jvm.internal.Intrinsics.checkNotNull(simpleName);
            return kotlin.text.StringsKt.substringAfter$default(simpleName, '$', (java.lang.String) null, 2, (java.lang.Object) null);
        }

        public final java.util.Collection<kotlin.reflect.KFunction<T>> getConstructors() {
            T value = this.constructors.getValue(this, $$delegatedProperties[4]);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            return (java.util.Collection) value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final java.util.List constructors_delegate$lambda$10(kotlin.reflect.jvm.internal.KClassImpl kClassImpl) {
            java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor> constructorDescriptors = kClassImpl.getConstructorDescriptors();
            java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(constructorDescriptors, 10));
            java.util.Iterator<T> it = constructorDescriptors.iterator();
            while (it.hasNext()) {
                arrayList.add(new kotlin.reflect.jvm.internal.KFunctionImpl(kClassImpl, (kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor) it.next()));
            }
            return arrayList;
        }

        public final java.util.Collection<kotlin.reflect.KClass<?>> getNestedClasses() {
            T value = this.nestedClasses.getValue(this, $$delegatedProperties[5]);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            return (java.util.Collection) value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final java.util.List nestedClasses_delegate$lambda$13(kotlin.reflect.jvm.internal.KClassImpl.Data data, kotlin.reflect.jvm.internal.KClassImpl kClassImpl) {
            kotlin.reflect.jvm.internal.impl.km.KmClass kmClass = data.getKmClass();
            if (kmClass != null) {
                kotlin.reflect.jvm.internal.impl.name.ClassId classId = kotlin.reflect.jvm.internal.MetadataUtilKt.toClassId(kmClass.getName());
                java.lang.ClassLoader safeClassLoader = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt.getSafeClassLoader(kClassImpl.getJClass());
                java.util.List<java.lang.String> nestedClasses = kmClass.getNestedClasses();
                java.util.ArrayList arrayList = new java.util.ArrayList();
                java.util.Iterator<T> it = nestedClasses.iterator();
                while (it.hasNext()) {
                    kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier = kotlin.reflect.jvm.internal.impl.name.Name.identifier((java.lang.String) it.next());
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier, "identifier(...)");
                    java.lang.Class clsLoadClass$default = kotlin.reflect.jvm.internal.UtilKt.loadClass$default(safeClassLoader, classId.createNestedClassId(nameIdentifier), 0, 2, null);
                    kotlin.reflect.KClass kotlinClass = clsLoadClass$default != null ? kotlin.jvm.JvmClassMappingKt.getKotlinClass(clsLoadClass$default) : null;
                    if (kotlinClass != null) {
                        arrayList.add(kotlinClass);
                    }
                }
                return arrayList;
            }
            java.lang.Class<?>[] declaredClasses = kClassImpl.getJClass().getDeclaredClasses();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(declaredClasses, "getDeclaredClasses(...)");
            java.util.ArrayList arrayList2 = new java.util.ArrayList();
            for (java.lang.Class<?> cls : declaredClasses) {
                kotlin.jvm.internal.Intrinsics.checkNotNull(cls);
                kotlin.reflect.KClass kotlinClass2 = kotlin.jvm.JvmClassMappingKt.getKotlinClass(cls);
                if (kotlinClass2 != null) {
                    arrayList2.add(kotlinClass2);
                }
            }
            return arrayList2;
        }

        public final T getObjectInstance() {
            return (T) this.objectInstance.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final java.lang.Object objectInstance_delegate$lambda$14(kotlin.reflect.jvm.internal.KClassImpl.Data data, kotlin.reflect.jvm.internal.KClassImpl kClassImpl) throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException {
            java.lang.reflect.Field declaredField;
            kotlin.reflect.jvm.internal.impl.km.KmClass kmClass = data.getKmClass();
            if (kmClass == null || !(kotlin.reflect.jvm.internal.impl.km.Attributes.getKind(kmClass) == kotlin.reflect.jvm.internal.impl.km.ClassKind.OBJECT || kotlin.reflect.jvm.internal.impl.km.Attributes.getKind(kmClass) == kotlin.reflect.jvm.internal.impl.km.ClassKind.COMPANION_OBJECT)) {
                return null;
            }
            if (kotlin.reflect.jvm.internal.impl.km.Attributes.getKind(kmClass) == kotlin.reflect.jvm.internal.impl.km.ClassKind.COMPANION_OBJECT && !kotlin.collections.CollectionsKt.contains(kotlin.reflect.jvm.internal.impl.builtins.CompanionObjectMapping.INSTANCE.getClassIds(), kotlin.reflect.jvm.internal.MetadataUtilKt.toClassId(kmClass.getName()).getOuterClassId())) {
                declaredField = kClassImpl.getJClass().getEnclosingClass().getDeclaredField(kotlin.reflect.jvm.internal.MetadataUtilKt.toNonLocalSimpleName(kmClass.getName()));
            } else {
                declaredField = kClassImpl.getJClass().getDeclaredField("INSTANCE");
            }
            java.lang.Object obj = declaredField.get(null);
            kotlin.jvm.internal.Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of kotlin.reflect.jvm.internal.KClassImpl");
            return obj;
        }

        public final java.util.List<kotlin.reflect.KTypeParameter> getTypeParameters() {
            T value = this.typeParameters.getValue(this, $$delegatedProperties[6]);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            return (java.util.List) value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final java.util.List typeParameters_delegate$lambda$16(kotlin.reflect.jvm.internal.KClassImpl.Data data, kotlin.reflect.jvm.internal.KClassImpl kClassImpl) {
            java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> declaredTypeParameters = data.getDescriptor().getDeclaredTypeParameters();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(declaredTypeParameters, "getDeclaredTypeParameters(...)");
            java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> list = declaredTypeParameters;
            java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(list, 10));
            for (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor typeParameterDescriptor : list) {
                kotlin.jvm.internal.Intrinsics.checkNotNull(typeParameterDescriptor);
                arrayList.add(new kotlin.reflect.jvm.internal.KTypeParameterImpl(kClassImpl, typeParameterDescriptor));
            }
            return arrayList;
        }

        public final java.util.List<kotlin.reflect.KType> getSupertypes() {
            T value = this.supertypes.getValue(this, $$delegatedProperties[7]);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            return (java.util.List) value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final java.util.List supertypes_delegate$lambda$21(final kotlin.reflect.jvm.internal.KClassImpl.Data data, final kotlin.reflect.jvm.internal.KClassImpl kClassImpl) {
            java.util.Collection<kotlin.reflect.jvm.internal.impl.types.KotlinType> collectionMo1836getSupertypes = data.getDescriptor().getTypeConstructor().mo1836getSupertypes();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(collectionMo1836getSupertypes, "getSupertypes(...)");
            java.util.ArrayList arrayList = new java.util.ArrayList(collectionMo1836getSupertypes.size());
            for (final kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType : collectionMo1836getSupertypes) {
                kotlin.jvm.internal.Intrinsics.checkNotNull(kotlinType);
                arrayList.add(new kotlin.reflect.jvm.internal.KTypeImpl(kotlinType, new kotlin.jvm.functions.Function0(kotlinType, data, kClassImpl) { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$19
                    private final kotlin.reflect.jvm.internal.impl.types.KotlinType arg$0;
                    private final kotlin.reflect.jvm.internal.KClassImpl.Data arg$1;
                    private final kotlin.reflect.jvm.internal.KClassImpl arg$2;

                    {
                        this.arg$0 = kotlinType;
                        this.arg$1 = data;
                        this.arg$2 = kClassImpl;
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public java.lang.Object invoke() {
                        return kotlin.reflect.jvm.internal.KClassImpl.Data.supertypes_delegate$lambda$21$lambda$18$lambda$17(this.arg$0, this.arg$1, this.arg$2);
                    }
                }));
            }
            java.util.ArrayList arrayList2 = arrayList;
            if (!kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isSpecialClassWithNoSupertypes(data.getDescriptor())) {
                java.util.ArrayList arrayList3 = arrayList;
                if ((arrayList3 instanceof java.util.Collection) && arrayList3.isEmpty()) {
                    kotlin.reflect.jvm.internal.impl.types.SimpleType anyType = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getBuiltIns(data.getDescriptor()).getAnyType();
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(anyType, "getAnyType(...)");
                    arrayList2.add(new kotlin.reflect.jvm.internal.KTypeImpl(anyType, new kotlin.jvm.functions.Function0() { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$20
                        @Override // kotlin.jvm.functions.Function0
                        public java.lang.Object invoke() {
                            return kotlin.reflect.jvm.internal.KClassImpl.Data.supertypes_delegate$lambda$21$lambda$20();
                        }
                    }));
                } else {
                    java.util.Iterator<T> it = arrayList3.iterator();
                    while (it.hasNext()) {
                        kotlin.reflect.jvm.internal.impl.descriptors.ClassKind kind = kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.getClassDescriptorForType(((kotlin.reflect.jvm.internal.KTypeImpl) it.next()).getType()).getKind();
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(kind, "getKind(...)");
                        if (kind == kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.INTERFACE || kind == kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.ANNOTATION_CLASS) {
                        }
                    }
                    kotlin.reflect.jvm.internal.impl.types.SimpleType anyType2 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getBuiltIns(data.getDescriptor()).getAnyType();
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(anyType2, "getAnyType(...)");
                    arrayList2.add(new kotlin.reflect.jvm.internal.KTypeImpl(anyType2, new kotlin.jvm.functions.Function0() { // from class: kotlin.reflect.jvm.internal.KClassImpl$Data$$Lambda$20
                        @Override // kotlin.jvm.functions.Function0
                        public java.lang.Object invoke() {
                            return kotlin.reflect.jvm.internal.KClassImpl.Data.supertypes_delegate$lambda$21$lambda$20();
                        }
                    }));
                }
            }
            return kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.compact(arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final java.lang.reflect.Type supertypes_delegate$lambda$21$lambda$18$lambda$17(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType, kotlin.reflect.jvm.internal.KClassImpl.Data data, kotlin.reflect.jvm.internal.KClassImpl kClassImpl) {
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor = kotlinType.getConstructor().mo1835getDeclarationDescriptor();
            if (!(classifierDescriptorMo1835getDeclarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor)) {
                throw new kotlin.reflect.jvm.internal.KotlinReflectionInternalError("Supertype not a class: " + classifierDescriptorMo1835getDeclarationDescriptor);
            }
            java.lang.Class<?> javaClass = kotlin.reflect.jvm.internal.UtilKt.toJavaClass((kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) classifierDescriptorMo1835getDeclarationDescriptor);
            if (javaClass == null) {
                throw new kotlin.reflect.jvm.internal.KotlinReflectionInternalError("Unsupported superclass of " + data + ": " + classifierDescriptorMo1835getDeclarationDescriptor);
            }
            if (kotlin.jvm.internal.Intrinsics.areEqual(kClassImpl.getJClass().getSuperclass(), javaClass)) {
                java.lang.reflect.Type genericSuperclass = kClassImpl.getJClass().getGenericSuperclass();
                kotlin.jvm.internal.Intrinsics.checkNotNull(genericSuperclass);
                return genericSuperclass;
            }
            java.lang.Class<?>[] interfaces = kClassImpl.getJClass().getInterfaces();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(interfaces, "getInterfaces(...)");
            int iIndexOf = kotlin.collections.ArraysKt.indexOf(interfaces, javaClass);
            if (iIndexOf >= 0) {
                java.lang.reflect.Type type = kClassImpl.getJClass().getGenericInterfaces()[iIndexOf];
                kotlin.jvm.internal.Intrinsics.checkNotNull(type);
                return type;
            }
            throw new kotlin.reflect.jvm.internal.KotlinReflectionInternalError("No superclass of " + data + " in Java reflection for " + classifierDescriptorMo1835getDeclarationDescriptor);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final java.lang.reflect.Type supertypes_delegate$lambda$21$lambda$20() {
            return java.lang.Object.class;
        }

        public final java.util.List<kotlin.reflect.KClass<? extends T>> getSealedSubclasses() {
            T value = this.sealedSubclasses.getValue(this, $$delegatedProperties[8]);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            return (java.util.List) value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final java.util.List sealedSubclasses_delegate$lambda$23(kotlin.reflect.jvm.internal.KClassImpl kClassImpl, kotlin.reflect.jvm.internal.KClassImpl.Data data) throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
            java.util.ArrayList arrayListEmptyList;
            java.lang.ClassLoader safeClassLoader = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt.getSafeClassLoader(kClassImpl.getJClass());
            kotlin.reflect.jvm.internal.impl.km.KmClass kmClass = data.getKmClass();
            if (kmClass != null) {
                java.util.List<java.lang.String> sealedSubclasses = kmClass.getSealedSubclasses();
                java.util.ArrayList arrayList = new java.util.ArrayList();
                java.util.Iterator<T> it = sealedSubclasses.iterator();
                while (it.hasNext()) {
                    kotlin.reflect.KClass<?> kClassLoadKClass = kotlin.reflect.jvm.internal.MetadataUtilKt.loadKClass(safeClassLoader, (java.lang.String) it.next());
                    if (kClassLoadKClass != null) {
                        arrayList.add(kClassLoadKClass);
                    }
                }
                arrayListEmptyList = arrayList;
            } else if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.Java16SealedRecordLoader.INSTANCE.loadIsSealed(kClassImpl.getJClass()), (java.lang.Object) true)) {
                java.lang.Class<?>[] clsArrLoadGetPermittedSubclasses = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.Java16SealedRecordLoader.INSTANCE.loadGetPermittedSubclasses(kClassImpl.getJClass());
                if (clsArrLoadGetPermittedSubclasses != null) {
                    java.util.ArrayList arrayList2 = new java.util.ArrayList(clsArrLoadGetPermittedSubclasses.length);
                    for (java.lang.Class<?> cls : clsArrLoadGetPermittedSubclasses) {
                        arrayList2.add(kotlin.jvm.JvmClassMappingKt.getKotlinClass(cls));
                    }
                    arrayListEmptyList = arrayList2;
                } else {
                    arrayListEmptyList = null;
                }
                if (arrayListEmptyList == null) {
                    arrayListEmptyList = kotlin.collections.CollectionsKt.emptyList();
                }
            } else {
                arrayListEmptyList = kotlin.collections.CollectionsKt.emptyList();
            }
            kotlin.jvm.internal.Intrinsics.checkNotNull(arrayListEmptyList, "null cannot be cast to non-null type kotlin.collections.List<kotlin.reflect.KClass<out T of kotlin.reflect.jvm.internal.KClassImpl>>");
            return arrayListEmptyList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final java.util.Collection declaredNonStaticMembers_delegate$lambda$24(kotlin.reflect.jvm.internal.KClassImpl kClassImpl) {
            return kClassImpl.getMembers(kClassImpl.getMemberScope$kotlin_reflection(), kotlin.reflect.jvm.internal.KDeclarationContainerImpl.MemberBelonginess.DECLARED);
        }

        public final java.util.Collection<kotlin.reflect.jvm.internal.KCallableImpl<?>> getDeclaredNonStaticMembers() {
            T value = this.declaredNonStaticMembers.getValue(this, $$delegatedProperties[9]);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            return (java.util.Collection) value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final java.util.Collection declaredStaticMembers_delegate$lambda$25(kotlin.reflect.jvm.internal.KClassImpl kClassImpl) {
            return kClassImpl.getMembers(kClassImpl.getStaticScope$kotlin_reflection(), kotlin.reflect.jvm.internal.KDeclarationContainerImpl.MemberBelonginess.DECLARED);
        }

        private final java.util.Collection<kotlin.reflect.jvm.internal.KCallableImpl<?>> getDeclaredStaticMembers() {
            T value = this.declaredStaticMembers.getValue(this, $$delegatedProperties[10]);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            return (java.util.Collection) value;
        }

        private final java.util.Collection<kotlin.reflect.jvm.internal.KCallableImpl<?>> getInheritedNonStaticMembers() {
            T value = this.inheritedNonStaticMembers.getValue(this, $$delegatedProperties[11]);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            return (java.util.Collection) value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final java.util.Collection inheritedNonStaticMembers_delegate$lambda$26(kotlin.reflect.jvm.internal.KClassImpl kClassImpl) {
            return kClassImpl.getMembers(kClassImpl.getMemberScope$kotlin_reflection(), kotlin.reflect.jvm.internal.KDeclarationContainerImpl.MemberBelonginess.INHERITED);
        }

        private final java.util.Collection<kotlin.reflect.jvm.internal.KCallableImpl<?>> getInheritedStaticMembers() {
            T value = this.inheritedStaticMembers.getValue(this, $$delegatedProperties[12]);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            return (java.util.Collection) value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final java.util.Collection inheritedStaticMembers_delegate$lambda$27(kotlin.reflect.jvm.internal.KClassImpl kClassImpl) {
            return kClassImpl.getMembers(kClassImpl.getStaticScope$kotlin_reflection(), kotlin.reflect.jvm.internal.KDeclarationContainerImpl.MemberBelonginess.INHERITED);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final java.util.List allNonStaticMembers_delegate$lambda$28(kotlin.reflect.jvm.internal.KClassImpl.Data data) {
            return kotlin.collections.CollectionsKt.plus((java.util.Collection) data.getDeclaredNonStaticMembers(), (java.lang.Iterable) data.getInheritedNonStaticMembers());
        }

        public final java.util.Collection<kotlin.reflect.jvm.internal.KCallableImpl<?>> getAllNonStaticMembers() {
            T value = this.allNonStaticMembers.getValue(this, $$delegatedProperties[13]);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            return (java.util.Collection) value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final java.util.List allStaticMembers_delegate$lambda$29(kotlin.reflect.jvm.internal.KClassImpl.Data data) {
            return kotlin.collections.CollectionsKt.plus((java.util.Collection) data.getDeclaredStaticMembers(), (java.lang.Iterable) data.getInheritedStaticMembers());
        }

        public final java.util.Collection<kotlin.reflect.jvm.internal.KCallableImpl<?>> getAllStaticMembers() {
            T value = this.allStaticMembers.getValue(this, $$delegatedProperties[14]);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            return (java.util.Collection) value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final java.util.List declaredMembers_delegate$lambda$30(kotlin.reflect.jvm.internal.KClassImpl.Data data) {
            return kotlin.collections.CollectionsKt.plus((java.util.Collection) data.getDeclaredNonStaticMembers(), (java.lang.Iterable) data.getDeclaredStaticMembers());
        }

        public final java.util.Collection<kotlin.reflect.jvm.internal.KCallableImpl<?>> getDeclaredMembers() {
            T value = this.declaredMembers.getValue(this, $$delegatedProperties[15]);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            return (java.util.Collection) value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final java.util.List allMembers_delegate$lambda$31(kotlin.reflect.jvm.internal.KClassImpl.Data data) {
            return kotlin.collections.CollectionsKt.plus((java.util.Collection) data.getAllNonStaticMembers(), (java.lang.Iterable) data.getAllStaticMembers());
        }

        public final java.util.Collection<kotlin.reflect.jvm.internal.KCallableImpl<?>> getAllMembers() {
            T value = this.allMembers.getValue(this, $$delegatedProperties[16]);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            return (java.util.Collection) value;
        }
    }

    public KClassImpl(java.lang.Class<T> jClass) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(jClass, "jClass");
        this.jClass = jClass;
        this.data = kotlin.LazyKt.lazy(kotlin.LazyThreadSafetyMode.PUBLICATION, new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.KClassImpl$$Lambda$0
            private final kotlin.reflect.jvm.internal.KClassImpl arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.KClassImpl.data$lambda$0(this.arg$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.KClassImpl.Data data$lambda$0(kotlin.reflect.jvm.internal.KClassImpl kClassImpl) {
        return new kotlin.reflect.jvm.internal.KClassImpl.Data();
    }

    public final kotlin.Lazy<kotlin.reflect.jvm.internal.KClassImpl<T>.Data> getData() {
        return this.data;
    }

    @Override // kotlin.reflect.jvm.internal.KClassifierImpl
    public kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor getDescriptor() {
        return this.data.getValue().getDescriptor();
    }

    private final kotlin.reflect.jvm.internal.impl.km.KmClass getKmClass() {
        return this.data.getValue().getKmClass();
    }

    @Override // kotlin.reflect.KAnnotatedElement
    public java.util.List<java.lang.annotation.Annotation> getAnnotations() {
        return this.data.getValue().getAnnotations();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kotlin.reflect.jvm.internal.impl.name.ClassId getClassId() {
        return kotlin.reflect.jvm.internal.RuntimeTypeMapper.INSTANCE.mapJvmClassToKotlinClassId(getJClass());
    }

    public final kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope getMemberScope$kotlin_reflection() {
        return getDescriptor().getDefaultType().getMemberScope();
    }

    public final kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope getStaticScope$kotlin_reflection() {
        kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope staticScope = getDescriptor().getStaticScope();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(staticScope, "getStaticScope(...)");
        return staticScope;
    }

    @Override // kotlin.reflect.KDeclarationContainer
    public java.util.Collection<kotlin.reflect.KCallable<?>> getMembers() {
        return this.data.getValue().getAllMembers();
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor> getConstructorDescriptors() {
        kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor descriptor = getDescriptor();
        if (descriptor.getKind() == kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.INTERFACE || descriptor.getKind() == kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.OBJECT) {
            return kotlin.collections.CollectionsKt.emptyList();
        }
        java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor> constructors = descriptor.getConstructors();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(constructors, "getConstructors(...)");
        return constructors;
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor> getProperties(kotlin.reflect.jvm.internal.impl.name.Name name) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        return kotlin.collections.CollectionsKt.plus((java.util.Collection) getMemberScope$kotlin_reflection().getContributedVariables(name, kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation.FROM_REFLECTION), (java.lang.Iterable) getStaticScope$kotlin_reflection().getContributedVariables(name, kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation.FROM_REFLECTION));
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor> getFunctions(kotlin.reflect.jvm.internal.impl.name.Name name) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        return kotlin.collections.CollectionsKt.plus((java.util.Collection) getMemberScope$kotlin_reflection().getContributedFunctions(name, kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation.FROM_REFLECTION), (java.lang.Iterable) getStaticScope$kotlin_reflection().getContributedFunctions(name, kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation.FROM_REFLECTION));
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor getLocalProperty(int index) {
        java.lang.Class<?> declaringClass;
        if (kotlin.jvm.internal.Intrinsics.areEqual(getJClass().getSimpleName(), "DefaultImpls") && (declaringClass = getJClass().getDeclaringClass()) != null && declaringClass.isInterface()) {
            kotlin.reflect.KClass kotlinClass = kotlin.jvm.JvmClassMappingKt.getKotlinClass(declaringClass);
            kotlin.jvm.internal.Intrinsics.checkNotNull(kotlinClass, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
            return ((kotlin.reflect.jvm.internal.KClassImpl) kotlinClass).getLocalProperty(index);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor descriptor = getDescriptor();
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor deserializedClassDescriptor = descriptor instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor ? (kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor) descriptor : null;
        if (deserializedClassDescriptor != null) {
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class classProto = deserializedClassDescriptor.getClassProto();
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property>> classLocalVariable = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.classLocalVariable;
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(classLocalVariable, "classLocalVariable");
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property property = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property) kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt.getExtensionOrNull(classProto, classLocalVariable, index);
            if (property != null) {
                return (kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor) kotlin.reflect.jvm.internal.UtilKt.deserializeToDescriptor(getJClass(), property, deserializedClassDescriptor.getC().getNameResolver(), deserializedClassDescriptor.getC().getTypeTable(), deserializedClassDescriptor.getMetadataVersion(), new kotlin.jvm.functions.Function2() { // from class: kotlin.reflect.jvm.internal.KClassImpl$$Lambda$1
                    @Override // kotlin.jvm.functions.Function2
                    public java.lang.Object invoke(java.lang.Object obj, java.lang.Object obj2) {
                        return kotlin.reflect.jvm.internal.KClassImpl.getLocalProperty$lambda$4$lambda$3$lambda$2((kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer) obj, (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property) obj2);
                    }
                });
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor getLocalProperty$lambda$4$lambda$3$lambda$2(kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer deserializeToDescriptor, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property proto) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(deserializeToDescriptor, "$this$deserializeToDescriptor");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(proto, "proto");
        return deserializeToDescriptor.loadProperty(proto, true);
    }

    @Override // kotlin.reflect.KClass
    public java.lang.String getSimpleName() {
        return this.data.getValue().getSimpleName();
    }

    @Override // kotlin.reflect.KClass
    public java.lang.String getQualifiedName() {
        return this.data.getValue().getQualifiedName();
    }

    @Override // kotlin.reflect.KClass
    public java.util.Collection<kotlin.reflect.KFunction<T>> getConstructors() {
        return this.data.getValue().getConstructors();
    }

    @Override // kotlin.reflect.KClass
    public java.util.Collection<kotlin.reflect.KClass<?>> getNestedClasses() {
        return this.data.getValue().getNestedClasses();
    }

    @Override // kotlin.reflect.KClass
    public T getObjectInstance() {
        return this.data.getValue().getObjectInstance();
    }

    @Override // kotlin.reflect.KClass
    public boolean isInstance(java.lang.Object value) {
        java.lang.Integer functionClassArity = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt.getFunctionClassArity(getJClass());
        if (functionClassArity != null) {
            return kotlin.jvm.internal.TypeIntrinsics.isFunctionOfArity(value, functionClassArity.intValue());
        }
        java.lang.Class wrapperByPrimitive = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt.getWrapperByPrimitive(getJClass());
        if (wrapperByPrimitive == null) {
            wrapperByPrimitive = getJClass();
        }
        return wrapperByPrimitive.isInstance(value);
    }

    @Override // kotlin.reflect.KClass
    public java.util.List<kotlin.reflect.KTypeParameter> getTypeParameters() {
        return this.data.getValue().getTypeParameters();
    }

    @Override // kotlin.reflect.KClass
    public java.util.List<kotlin.reflect.KType> getSupertypes() {
        return this.data.getValue().getSupertypes();
    }

    @Override // kotlin.reflect.KClass
    public java.util.List<kotlin.reflect.KClass<? extends T>> getSealedSubclasses() {
        return this.data.getValue().getSealedSubclasses();
    }

    @Override // kotlin.reflect.KClass
    public kotlin.reflect.KVisibility getVisibility() {
        kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility visibility = getDescriptor().getVisibility();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(visibility, "getVisibility(...)");
        return kotlin.reflect.jvm.internal.UtilKt.toKVisibility(visibility);
    }

    private final kotlin.reflect.jvm.internal.impl.km.Modality getModality() {
        kotlin.reflect.jvm.internal.impl.km.Modality modality;
        kotlin.reflect.jvm.internal.impl.km.KmClass kmClass = getKmClass();
        if (kmClass != null && (modality = kotlin.reflect.jvm.internal.impl.km.Attributes.getModality(kmClass)) != null) {
            return modality;
        }
        if (getJClass().isAnnotation() || getJClass().isEnum()) {
            return kotlin.reflect.jvm.internal.impl.km.Modality.FINAL;
        }
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.Java16SealedRecordLoader.INSTANCE.loadIsSealed(getJClass()), (java.lang.Object) true)) {
            return kotlin.reflect.jvm.internal.impl.km.Modality.SEALED;
        }
        if (java.lang.reflect.Modifier.isAbstract(getJClass().getModifiers())) {
            return kotlin.reflect.jvm.internal.impl.km.Modality.ABSTRACT;
        }
        return !java.lang.reflect.Modifier.isFinal(getJClass().getModifiers()) ? kotlin.reflect.jvm.internal.impl.km.Modality.OPEN : kotlin.reflect.jvm.internal.impl.km.Modality.FINAL;
    }

    @Override // kotlin.reflect.KClass
    public boolean isFinal() {
        return getModality() == kotlin.reflect.jvm.internal.impl.km.Modality.FINAL;
    }

    @Override // kotlin.reflect.KClass
    public boolean isOpen() {
        return getModality() == kotlin.reflect.jvm.internal.impl.km.Modality.OPEN;
    }

    @Override // kotlin.reflect.KClass
    public boolean isAbstract() {
        return getModality() == kotlin.reflect.jvm.internal.impl.km.Modality.ABSTRACT;
    }

    @Override // kotlin.reflect.KClass
    public boolean isSealed() {
        return getModality() == kotlin.reflect.jvm.internal.impl.km.Modality.SEALED;
    }

    @Override // kotlin.reflect.KClass
    public boolean isData() {
        kotlin.reflect.jvm.internal.impl.km.KmClass kmClass = getKmClass();
        return kmClass != null && kotlin.reflect.jvm.internal.impl.km.Attributes.isData(kmClass);
    }

    @Override // kotlin.reflect.KClass
    public boolean isInner() {
        kotlin.reflect.jvm.internal.impl.km.KmClass kmClass = getKmClass();
        if (kmClass == null) {
            return (getJClass().getDeclaringClass() == null || java.lang.reflect.Modifier.isStatic(getJClass().getModifiers())) ? false : true;
        }
        return kotlin.reflect.jvm.internal.impl.km.Attributes.isInner(kmClass);
    }

    @Override // kotlin.reflect.KClass
    public boolean isCompanion() {
        kotlin.reflect.jvm.internal.impl.km.KmClass kmClass = getKmClass();
        return (kmClass != null ? kotlin.reflect.jvm.internal.impl.km.Attributes.getKind(kmClass) : null) == kotlin.reflect.jvm.internal.impl.km.ClassKind.COMPANION_OBJECT;
    }

    @Override // kotlin.reflect.KClass
    public boolean isFun() {
        kotlin.reflect.jvm.internal.impl.km.KmClass kmClass = getKmClass();
        return kmClass != null && kotlin.reflect.jvm.internal.impl.km.Attributes.isFunInterface(kmClass);
    }

    @Override // kotlin.reflect.KClass
    public boolean isValue() {
        kotlin.reflect.jvm.internal.impl.km.KmClass kmClass = getKmClass();
        return kmClass != null && kotlin.reflect.jvm.internal.impl.km.Attributes.isValue(kmClass);
    }

    @Override // kotlin.reflect.KClass
    public boolean equals(java.lang.Object other) {
        return (other instanceof kotlin.reflect.jvm.internal.KClassImpl) && kotlin.jvm.internal.Intrinsics.areEqual(kotlin.jvm.JvmClassMappingKt.getJavaObjectType(this), kotlin.jvm.JvmClassMappingKt.getJavaObjectType((kotlin.reflect.KClass) other));
    }

    @Override // kotlin.reflect.KClass
    public int hashCode() {
        return kotlin.jvm.JvmClassMappingKt.getJavaObjectType(this).hashCode();
    }

    public java.lang.String toString() {
        java.lang.String str;
        java.lang.StringBuilder sb = new java.lang.StringBuilder("class ");
        kotlin.reflect.jvm.internal.impl.name.ClassId classId = getClassId();
        kotlin.reflect.jvm.internal.impl.name.FqName packageFqName = classId.getPackageFqName();
        if (packageFqName.isRoot()) {
            str = "";
        } else {
            str = packageFqName.asString() + com.taobao.weex.el.parse.Operators.DOT;
        }
        sb.append(str + kotlin.text.StringsKt.replace$default(classId.getRelativeClassName().asString(), com.taobao.weex.el.parse.Operators.DOT, '$', false, 4, (java.lang.Object) null));
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor createSyntheticClassOrFail(kotlin.reflect.jvm.internal.impl.name.ClassId classId, kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData moduleData) {
        kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader classHeader;
        if (getJClass().isSynthetic()) {
            return createSyntheticClass(classId, moduleData);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass reflectKotlinClassCreate = kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass.Factory.create(getJClass());
        kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader.Kind kind = (reflectKotlinClassCreate == null || (classHeader = reflectKotlinClassCreate.getClassHeader()) == null) ? null : classHeader.getKind();
        switch (kind == null ? -1 : kotlin.reflect.jvm.internal.KClassImpl.WhenMappings.$EnumSwitchMapping$0[kind.ordinal()]) {
            case -1:
            case 6:
                throw new kotlin.reflect.jvm.internal.KotlinReflectionInternalError("Unresolved class: " + getJClass() + " (kind = " + kind + com.taobao.weex.el.parse.Operators.BRACKET_END);
            case 0:
            default:
                throw new kotlin.NoWhenBranchMatchedException();
            case 1:
            case 2:
            case 3:
            case 4:
                return createSyntheticClass(classId, moduleData);
            case 5:
                throw new kotlin.reflect.jvm.internal.KotlinReflectionInternalError("Unknown class: " + getJClass() + " (kind = " + kind + com.taobao.weex.el.parse.Operators.BRACKET_END);
        }
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor createSyntheticClass(kotlin.reflect.jvm.internal.impl.name.ClassId classId, kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData moduleData) {
        final kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl classDescriptorImpl = new kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl(new kotlin.reflect.jvm.internal.impl.descriptors.impl.EmptyPackageFragmentDescriptor(moduleData.getModule(), classId.getPackageFqName()), classId.getShortClassName(), kotlin.reflect.jvm.internal.impl.descriptors.Modality.FINAL, kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.CLASS, kotlin.collections.CollectionsKt.listOf(moduleData.getModule().getBuiltIns().getAny().getDefaultType()), kotlin.reflect.jvm.internal.impl.descriptors.SourceElement.NO_SOURCE, false, moduleData.getDeserialization().getStorageManager());
        final kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager = moduleData.getDeserialization().getStorageManager();
        classDescriptorImpl.initialize(new kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope(classDescriptorImpl, storageManager) { // from class: kotlin.reflect.jvm.internal.KClassImpl$createSyntheticClass$1$1
            {
                super(storageManager, classDescriptorImpl);
            }

            @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope
            protected java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor> computeDeclaredFunctions() {
                return kotlin.collections.CollectionsKt.emptyList();
            }
        }, kotlin.collections.SetsKt.emptySet(), null);
        return classDescriptorImpl;
    }

    static {
        java.util.Set<kotlin.reflect.jvm.internal.impl.name.ClassId> special_annotations = kotlin.reflect.jvm.internal.impl.SpecialJvmAnnotations.INSTANCE.getSPECIAL_ANNOTATIONS();
        java.util.HashSet hashSet = new java.util.HashSet();
        java.util.Iterator<T> it = special_annotations.iterator();
        while (it.hasNext()) {
            hashSet.add(((kotlin.reflect.jvm.internal.impl.name.ClassId) it.next()).asSingleFqName().toString());
        }
        SPECIAL_JVM_ANNOTATION_NAMES = hashSet;
    }
}
