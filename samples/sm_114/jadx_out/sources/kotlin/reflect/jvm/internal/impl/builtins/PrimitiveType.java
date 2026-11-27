package kotlin.reflect.jvm.internal.impl.builtins;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType, still in use, count: 1, list:
  (r0v1 kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType) from 0x0078: FILLED_NEW_ARRAY 
  (r0v1 kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType)
  (r1v2 kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType)
  (r2v3 kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType)
  (r5v2 kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType)
  (r7v2 kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType)
  (r9v2 kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType)
  (r11v2 kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType)
 A[WRAPPED] (LINE:32) elemType: kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType
	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:257)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:187)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: PrimitiveType.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PrimitiveType {
    BOOLEAN("Boolean"),
    CHAR("Char"),
    BYTE("Byte"),
    SHORT("Short"),
    INT("Int"),
    FLOAT("Float"),
    LONG("Long"),
    DOUBLE("Double");

    private final kotlin.Lazy arrayTypeFqName$delegate;
    private final kotlin.reflect.jvm.internal.impl.name.Name arrayTypeName;
    private final kotlin.Lazy typeFqName$delegate;
    private final kotlin.reflect.jvm.internal.impl.name.Name typeName;
    private static final /* synthetic */ kotlin.enums.EnumEntries $ENTRIES = kotlin.enums.EnumEntriesKt.enumEntries(values());
    public static final kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType.Companion Companion = new kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType.Companion(null);
    public static final java.util.Set<kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType> NUMBER_TYPES = kotlin.collections.SetsKt.setOf((java.lang.Object[]) new kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType[]{new kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType("Char"), new kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType("Byte"), new kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType("Short"), new kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType("Int"), new kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType("Float"), new kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType("Long"), new kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType("Double")});

    public static kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType valueOf(java.lang.String str) {
        return (kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType) java.lang.Enum.valueOf(kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType.class, str);
    }

    public static kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType[] values() {
        return (kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType[]) $VALUES.clone();
    }

    private PrimitiveType(java.lang.String str) {
        super(str, i);
        kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier = kotlin.reflect.jvm.internal.impl.name.Name.identifier(str);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier, "identifier(...)");
        this.typeName = nameIdentifier;
        kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier2 = kotlin.reflect.jvm.internal.impl.name.Name.identifier(str + "Array");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier2, "identifier(...)");
        this.arrayTypeName = nameIdentifier2;
        this.typeFqName$delegate = kotlin.LazyKt.lazy(kotlin.LazyThreadSafetyMode.PUBLICATION, new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType$$Lambda$0
            private final kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType.typeFqName_delegate$lambda$0(this.arg$0);
            }
        });
        this.arrayTypeFqName$delegate = kotlin.LazyKt.lazy(kotlin.LazyThreadSafetyMode.PUBLICATION, new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType$$Lambda$1
            private final kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType.arrayTypeFqName_delegate$lambda$1(this.arg$0);
            }
        });
    }

    static {
    }

    public final kotlin.reflect.jvm.internal.impl.name.Name getTypeName() {
        return this.typeName;
    }

    public final kotlin.reflect.jvm.internal.impl.name.Name getArrayTypeName() {
        return this.arrayTypeName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.name.FqName typeFqName_delegate$lambda$0(kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType primitiveType) {
        return kotlin.reflect.jvm.internal.impl.builtins.StandardNames.BUILT_INS_PACKAGE_FQ_NAME.child(primitiveType.typeName);
    }

    public final kotlin.reflect.jvm.internal.impl.name.FqName getTypeFqName() {
        return (kotlin.reflect.jvm.internal.impl.name.FqName) this.typeFqName$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.name.FqName arrayTypeFqName_delegate$lambda$1(kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType primitiveType) {
        return kotlin.reflect.jvm.internal.impl.builtins.StandardNames.BUILT_INS_PACKAGE_FQ_NAME.child(primitiveType.arrayTypeName);
    }

    public final kotlin.reflect.jvm.internal.impl.name.FqName getArrayTypeFqName() {
        return (kotlin.reflect.jvm.internal.impl.name.FqName) this.arrayTypeFqName$delegate.getValue();
    }

    /* JADX INFO: compiled from: PrimitiveType.kt */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
