package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: loaded from: classes2.dex */
public class TypeProjectionImpl extends kotlin.reflect.jvm.internal.impl.types.TypeProjectionBase {
    private final kotlin.reflect.jvm.internal.impl.types.Variance projection;
    private final kotlin.reflect.jvm.internal.impl.types.KotlinType type;

    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        java.lang.String str = (i == 4 || i == 5) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        java.lang.Object[] objArr = new java.lang.Object[(i == 4 || i == 5) ? 2 : 3];
        switch (i) {
            case 1:
            case 2:
            case 3:
                objArr[0] = "type";
                break;
            case 4:
            case 5:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/TypeProjectionImpl";
                break;
            case 6:
                objArr[0] = "kotlinTypeRefiner";
                break;
            default:
                objArr[0] = "projection";
                break;
        }
        if (i == 4) {
            objArr[1] = "getProjectionKind";
        } else if (i != 5) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/TypeProjectionImpl";
        } else {
            objArr[1] = "getType";
        }
        if (i == 3) {
            objArr[2] = "replaceType";
        } else if (i != 4 && i != 5) {
            if (i != 6) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "refine";
            }
        }
        java.lang.String str2 = java.lang.String.format(str, objArr);
        if (i != 4 && i != 5) {
            throw new java.lang.IllegalArgumentException(str2);
        }
        throw new java.lang.IllegalStateException(str2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    public boolean isStarProjection() {
        return false;
    }

    public TypeProjectionImpl(kotlin.reflect.jvm.internal.impl.types.Variance variance, kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        if (variance == null) {
            $$$reportNull$$$0(0);
        }
        if (kotlinType == null) {
            $$$reportNull$$$0(1);
        }
        this.projection = variance;
        this.type = kotlinType;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TypeProjectionImpl(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        this(kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT, kotlinType);
        if (kotlinType == null) {
            $$$reportNull$$$0(2);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    public kotlin.reflect.jvm.internal.impl.types.Variance getProjectionKind() {
        kotlin.reflect.jvm.internal.impl.types.Variance variance = this.projection;
        if (variance == null) {
            $$$reportNull$$$0(4);
        }
        return variance;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    public kotlin.reflect.jvm.internal.impl.types.KotlinType getType() {
        kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType = this.type;
        if (kotlinType == null) {
            $$$reportNull$$$0(5);
        }
        return kotlinType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    public kotlin.reflect.jvm.internal.impl.types.TypeProjection refine(kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner kotlinTypeRefiner) {
        if (kotlinTypeRefiner == null) {
            $$$reportNull$$$0(6);
        }
        return new kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl(this.projection, kotlinTypeRefiner.refineType((kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) this.type));
    }
}
