package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: AbstractTypeChecker.kt */
/* JADX INFO: loaded from: classes2.dex */
public class TypeCheckerState {
    private final boolean allowedTypeVariable;
    private int argumentsDepth;
    private final boolean isDnnTypesEqualToFlexible;
    private final boolean isErrorTypeEqualsToAnything;
    private final boolean isStubTypeEqualsToAnything;
    private final kotlin.reflect.jvm.internal.impl.types.AbstractTypePreparator kotlinTypePreparator;
    private final kotlin.reflect.jvm.internal.impl.types.AbstractTypeRefiner kotlinTypeRefiner;
    private java.util.ArrayDeque<kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker> supertypesDeque;
    private boolean supertypesLocked;
    private java.util.Set<kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker> supertypesSet;
    private final kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext typeSystemContext;

    /* JADX INFO: compiled from: AbstractTypeChecker.kt */
    public enum LowerCapturedTypePolicy {
        CHECK_ONLY_LOWER,
        CHECK_SUBTYPE_AND_LOWER,
        SKIP_LOWER;

        private static final /* synthetic */ kotlin.enums.EnumEntries $ENTRIES = kotlin.enums.EnumEntriesKt.enumEntries(values());
    }

    public java.lang.Boolean addSubtypeConstraint(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker subType, kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker superType, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(subType, "subType");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(superType, "superType");
        return null;
    }

    public boolean customIsSubtypeOf(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker subType, kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker superType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(subType, "subType");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(superType, "superType");
        return true;
    }

    public TypeCheckerState(boolean z, boolean z2, boolean z3, boolean z4, kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext typeSystemContext, kotlin.reflect.jvm.internal.impl.types.AbstractTypePreparator kotlinTypePreparator, kotlin.reflect.jvm.internal.impl.types.AbstractTypeRefiner kotlinTypeRefiner) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeSystemContext, "typeSystemContext");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinTypePreparator, "kotlinTypePreparator");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        this.isErrorTypeEqualsToAnything = z;
        this.isStubTypeEqualsToAnything = z2;
        this.isDnnTypesEqualToFlexible = z3;
        this.allowedTypeVariable = z4;
        this.typeSystemContext = typeSystemContext;
        this.kotlinTypePreparator = kotlinTypePreparator;
        this.kotlinTypeRefiner = kotlinTypeRefiner;
    }

    public final boolean isErrorTypeEqualsToAnything() {
        return this.isErrorTypeEqualsToAnything;
    }

    public final boolean isStubTypeEqualsToAnything() {
        return this.isStubTypeEqualsToAnything;
    }

    public final boolean isDnnTypesEqualToFlexible() {
        return this.isDnnTypesEqualToFlexible;
    }

    public final kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext getTypeSystemContext() {
        return this.typeSystemContext;
    }

    public final kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker refineType(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker type) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(type, "type");
        return this.kotlinTypeRefiner.refineType(type);
    }

    public final kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker prepareType(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker type) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(type, "type");
        return this.kotlinTypePreparator.prepareType(type);
    }

    public kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.LowerCapturedTypePolicy getLowerCapturedTypePolicy(kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker subType, kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker superType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(subType, "subType");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(superType, "superType");
        return kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.LowerCapturedTypePolicy.CHECK_SUBTYPE_AND_LOWER;
    }

    public static /* synthetic */ java.lang.Boolean addSubtypeConstraint$default(kotlin.reflect.jvm.internal.impl.types.TypeCheckerState typeCheckerState, kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker, kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker2, boolean z, int i, java.lang.Object obj) {
        if (obj != null) {
            throw new java.lang.UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addSubtypeConstraint");
        }
        if ((i & 4) != 0) {
            z = false;
        }
        return typeCheckerState.addSubtypeConstraint(kotlinTypeMarker, kotlinTypeMarker2, z);
    }

    public boolean runForkingPoint(kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.ForkPointContext, kotlin.Unit> block) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(block, "block");
        kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.ForkPointContext.Default r0 = new kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.ForkPointContext.Default();
        block.invoke(r0);
        return r0.getResult();
    }

    /* JADX INFO: compiled from: AbstractTypeChecker.kt */
    public interface ForkPointContext {
        void fork(kotlin.jvm.functions.Function0<java.lang.Boolean> function0);

        /* JADX INFO: compiled from: AbstractTypeChecker.kt */
        public static final class Default implements kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.ForkPointContext {
            private boolean result;

            public final boolean getResult() {
                return this.result;
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.ForkPointContext
            public void fork(kotlin.jvm.functions.Function0<java.lang.Boolean> block) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(block, "block");
                if (this.result) {
                    return;
                }
                this.result = block.invoke().booleanValue();
            }
        }
    }

    public final java.util.ArrayDeque<kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker> getSupertypesDeque() {
        return this.supertypesDeque;
    }

    public final java.util.Set<kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker> getSupertypesSet() {
        return this.supertypesSet;
    }

    public final void initialize() {
        this.supertypesLocked = true;
        if (this.supertypesDeque == null) {
            this.supertypesDeque = new java.util.ArrayDeque<>(4);
        }
        if (this.supertypesSet == null) {
            this.supertypesSet = kotlin.reflect.jvm.internal.impl.utils.SmartSet.Companion.create();
        }
    }

    public final void clear() {
        java.util.ArrayDeque<kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker> arrayDeque = this.supertypesDeque;
        kotlin.jvm.internal.Intrinsics.checkNotNull(arrayDeque);
        arrayDeque.clear();
        java.util.Set<kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker> set = this.supertypesSet;
        kotlin.jvm.internal.Intrinsics.checkNotNull(set);
        set.clear();
        this.supertypesLocked = false;
    }

    /* JADX INFO: compiled from: AbstractTypeChecker.kt */
    public static abstract class SupertypesPolicy {
        public /* synthetic */ SupertypesPolicy(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: transformType */
        public abstract kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker mo1839transformType(kotlin.reflect.jvm.internal.impl.types.TypeCheckerState typeCheckerState, kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker);

        private SupertypesPolicy() {
        }

        /* JADX INFO: compiled from: AbstractTypeChecker.kt */
        public static final class None extends kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.SupertypesPolicy {
            public static final kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.SupertypesPolicy.None INSTANCE = new kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.SupertypesPolicy.None();

            private None() {
                super(null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.SupertypesPolicy
            /* JADX INFO: renamed from: transformType, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker mo1839transformType(kotlin.reflect.jvm.internal.impl.types.TypeCheckerState typeCheckerState, kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker kotlinTypeMarker) {
                return (kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker) transformType(typeCheckerState, kotlinTypeMarker);
            }

            public java.lang.Void transformType(kotlin.reflect.jvm.internal.impl.types.TypeCheckerState state, kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker type) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(state, "state");
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(type, "type");
                throw new java.lang.UnsupportedOperationException("Should not be called");
            }
        }

        /* JADX INFO: compiled from: AbstractTypeChecker.kt */
        public static final class UpperIfFlexible extends kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.SupertypesPolicy {
            public static final kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.SupertypesPolicy.UpperIfFlexible INSTANCE = new kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.SupertypesPolicy.UpperIfFlexible();

            private UpperIfFlexible() {
                super(null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.SupertypesPolicy
            /* JADX INFO: renamed from: transformType */
            public kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker mo1839transformType(kotlin.reflect.jvm.internal.impl.types.TypeCheckerState state, kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker type) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(state, "state");
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(type, "type");
                return state.getTypeSystemContext().upperBoundIfFlexible(type);
            }
        }

        /* JADX INFO: compiled from: AbstractTypeChecker.kt */
        public static final class LowerIfFlexible extends kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.SupertypesPolicy {
            public static final kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.SupertypesPolicy.LowerIfFlexible INSTANCE = new kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.SupertypesPolicy.LowerIfFlexible();

            private LowerIfFlexible() {
                super(null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.SupertypesPolicy
            /* JADX INFO: renamed from: transformType */
            public kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker mo1839transformType(kotlin.reflect.jvm.internal.impl.types.TypeCheckerState state, kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker type) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(state, "state");
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(type, "type");
                return state.getTypeSystemContext().lowerBoundIfFlexible(type);
            }
        }

        /* JADX INFO: compiled from: AbstractTypeChecker.kt */
        public static abstract class DoCustomTransform extends kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.SupertypesPolicy {
            public DoCustomTransform() {
                super(null);
            }
        }
    }

    public final boolean isAllowedTypeVariable(kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker type) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(type, "type");
        return this.allowedTypeVariable && this.typeSystemContext.isTypeVariableType(type);
    }
}
