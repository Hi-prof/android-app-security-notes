package kotlin.reflect.jvm.internal.impl.builtins;

/* JADX INFO: compiled from: UnsignedType.kt */
/* JADX INFO: loaded from: classes2.dex */
public enum UnsignedArrayType {
    UBYTEARRAY(kotlin.reflect.jvm.internal.impl.name.ClassId.Companion.fromString$default(kotlin.reflect.jvm.internal.impl.name.ClassId.Companion, "kotlin/UByteArray", false, 2, null)),
    USHORTARRAY(kotlin.reflect.jvm.internal.impl.name.ClassId.Companion.fromString$default(kotlin.reflect.jvm.internal.impl.name.ClassId.Companion, "kotlin/UShortArray", false, 2, null)),
    UINTARRAY(kotlin.reflect.jvm.internal.impl.name.ClassId.Companion.fromString$default(kotlin.reflect.jvm.internal.impl.name.ClassId.Companion, "kotlin/UIntArray", false, 2, null)),
    ULONGARRAY(kotlin.reflect.jvm.internal.impl.name.ClassId.Companion.fromString$default(kotlin.reflect.jvm.internal.impl.name.ClassId.Companion, "kotlin/ULongArray", false, 2, null));

    private static final /* synthetic */ kotlin.enums.EnumEntries $ENTRIES = kotlin.enums.EnumEntriesKt.enumEntries(values());
    private final kotlin.reflect.jvm.internal.impl.name.ClassId classId;
    private final kotlin.reflect.jvm.internal.impl.name.Name typeName;

    UnsignedArrayType(kotlin.reflect.jvm.internal.impl.name.ClassId classId) {
        this.classId = classId;
        this.typeName = classId.getShortClassName();
    }

    public final kotlin.reflect.jvm.internal.impl.name.Name getTypeName() {
        return this.typeName;
    }
}
