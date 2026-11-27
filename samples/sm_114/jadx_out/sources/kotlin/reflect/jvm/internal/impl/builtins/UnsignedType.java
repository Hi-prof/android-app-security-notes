package kotlin.reflect.jvm.internal.impl.builtins;

/* JADX INFO: compiled from: UnsignedType.kt */
/* JADX INFO: loaded from: classes2.dex */
public enum UnsignedType {
    UBYTE(kotlin.reflect.jvm.internal.impl.name.ClassId.Companion.fromString$default(kotlin.reflect.jvm.internal.impl.name.ClassId.Companion, "kotlin/UByte", false, 2, null)),
    USHORT(kotlin.reflect.jvm.internal.impl.name.ClassId.Companion.fromString$default(kotlin.reflect.jvm.internal.impl.name.ClassId.Companion, "kotlin/UShort", false, 2, null)),
    UINT(kotlin.reflect.jvm.internal.impl.name.ClassId.Companion.fromString$default(kotlin.reflect.jvm.internal.impl.name.ClassId.Companion, "kotlin/UInt", false, 2, null)),
    ULONG(kotlin.reflect.jvm.internal.impl.name.ClassId.Companion.fromString$default(kotlin.reflect.jvm.internal.impl.name.ClassId.Companion, "kotlin/ULong", false, 2, null));

    private static final /* synthetic */ kotlin.enums.EnumEntries $ENTRIES = kotlin.enums.EnumEntriesKt.enumEntries(values());
    private final kotlin.reflect.jvm.internal.impl.name.ClassId arrayClassId;
    private final kotlin.reflect.jvm.internal.impl.name.ClassId classId;
    private final kotlin.reflect.jvm.internal.impl.name.Name typeName;

    UnsignedType(kotlin.reflect.jvm.internal.impl.name.ClassId classId) {
        this.classId = classId;
        kotlin.reflect.jvm.internal.impl.name.Name shortClassName = classId.getShortClassName();
        this.typeName = shortClassName;
        kotlin.reflect.jvm.internal.impl.name.FqName packageFqName = classId.getPackageFqName();
        kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier = kotlin.reflect.jvm.internal.impl.name.Name.identifier(shortClassName.asString() + "Array");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier, "identifier(...)");
        this.arrayClassId = new kotlin.reflect.jvm.internal.impl.name.ClassId(packageFqName, nameIdentifier);
    }

    public final kotlin.reflect.jvm.internal.impl.name.ClassId getClassId() {
        return this.classId;
    }

    public final kotlin.reflect.jvm.internal.impl.name.Name getTypeName() {
        return this.typeName;
    }

    public final kotlin.reflect.jvm.internal.impl.name.ClassId getArrayClassId() {
        return this.arrayClassId;
    }
}
