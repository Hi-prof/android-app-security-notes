package kotlin.reflect.jvm.internal.impl.km;

/* JADX INFO: compiled from: Annotations.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class KmAnnotationArgument {
    public /* synthetic */ KmAnnotationArgument(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract java.lang.String toString();

    private KmAnnotationArgument() {
    }

    /* JADX INFO: compiled from: Annotations.kt */
    public static abstract class LiteralValue<T> extends kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument {
        public /* synthetic */ LiteralValue(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public abstract T getValue();

        private LiteralValue() {
            super(null);
        }

        @Override // kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument
        public final java.lang.String toString() {
            java.lang.String string;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(getClass().getSimpleName());
            sb.append(com.taobao.weex.el.parse.Operators.BRACKET_START);
            if (this instanceof kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.StringValue) {
                string = io.dcloud.common.util.JSUtil.QUOTE + ((java.lang.Object) ((kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.StringValue) this).getValue()) + '\"';
            } else {
                string = getValue().toString();
            }
            sb.append(string);
            sb.append(com.taobao.weex.el.parse.Operators.BRACKET_END);
            return sb.toString();
        }
    }

    /* JADX INFO: compiled from: Annotations.kt */
    public static final class ByteValue extends kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.LiteralValue<java.lang.Byte> {
        private final byte value;

        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.ByteValue) && this.value == ((kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.ByteValue) obj).value;
        }

        public int hashCode() {
            return this.value;
        }

        public ByteValue(byte b) {
            super(null);
            this.value = b;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.LiteralValue
        public java.lang.Byte getValue() {
            return java.lang.Byte.valueOf(this.value);
        }
    }

    /* JADX INFO: compiled from: Annotations.kt */
    public static final class CharValue extends kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.LiteralValue<java.lang.Character> {
        private final char value;

        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.CharValue) && this.value == ((kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.CharValue) obj).value;
        }

        public int hashCode() {
            return this.value;
        }

        public CharValue(char c) {
            super(null);
            this.value = c;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.LiteralValue
        public java.lang.Character getValue() {
            return java.lang.Character.valueOf(this.value);
        }
    }

    /* JADX INFO: compiled from: Annotations.kt */
    public static final class ShortValue extends kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.LiteralValue<java.lang.Short> {
        private final short value;

        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.ShortValue) && this.value == ((kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.ShortValue) obj).value;
        }

        public int hashCode() {
            return this.value;
        }

        public ShortValue(short s) {
            super(null);
            this.value = s;
        }

        @Override // kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.LiteralValue
        public java.lang.Short getValue() {
            return java.lang.Short.valueOf(this.value);
        }
    }

    /* JADX INFO: compiled from: Annotations.kt */
    public static final class IntValue extends kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.LiteralValue<java.lang.Integer> {
        private final int value;

        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.IntValue) && this.value == ((kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.IntValue) obj).value;
        }

        public int hashCode() {
            return this.value;
        }

        public IntValue(int i) {
            super(null);
            this.value = i;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.LiteralValue
        public java.lang.Integer getValue() {
            return java.lang.Integer.valueOf(this.value);
        }
    }

    /* JADX INFO: compiled from: Annotations.kt */
    public static final class LongValue extends kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.LiteralValue<java.lang.Long> {
        private final long value;

        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.LongValue) && this.value == ((kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.LongValue) obj).value;
        }

        public int hashCode() {
            return kotlin.UByte$$ExternalSyntheticBackport0.m(this.value);
        }

        public LongValue(long j) {
            super(null);
            this.value = j;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.LiteralValue
        public java.lang.Long getValue() {
            return java.lang.Long.valueOf(this.value);
        }
    }

    /* JADX INFO: compiled from: Annotations.kt */
    public static final class FloatValue extends kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.LiteralValue<java.lang.Float> {
        private final float value;

        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.FloatValue) && java.lang.Float.compare(this.value, ((kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.FloatValue) obj).value) == 0;
        }

        public int hashCode() {
            return java.lang.Float.floatToIntBits(this.value);
        }

        public FloatValue(float f) {
            super(null);
            this.value = f;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.LiteralValue
        public java.lang.Float getValue() {
            return java.lang.Float.valueOf(this.value);
        }
    }

    /* JADX INFO: compiled from: Annotations.kt */
    public static final class DoubleValue extends kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.LiteralValue<java.lang.Double> {
        private final double value;

        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.DoubleValue) && java.lang.Double.compare(this.value, ((kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.DoubleValue) obj).value) == 0;
        }

        public int hashCode() {
            return kotlin.UByte$$ExternalSyntheticBackport0.m(this.value);
        }

        public DoubleValue(double d) {
            super(null);
            this.value = d;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.LiteralValue
        public java.lang.Double getValue() {
            return java.lang.Double.valueOf(this.value);
        }
    }

    /* JADX INFO: compiled from: Annotations.kt */
    public static final class BooleanValue extends kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.LiteralValue<java.lang.Boolean> {
        private final boolean value;

        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.BooleanValue) && this.value == ((kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.BooleanValue) obj).value;
        }

        public int hashCode() {
            return kotlin.UByte$$ExternalSyntheticBackport0.m(this.value);
        }

        public BooleanValue(boolean z) {
            super(null);
            this.value = z;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.LiteralValue
        public java.lang.Boolean getValue() {
            return java.lang.Boolean.valueOf(this.value);
        }
    }

    /* JADX INFO: compiled from: Annotations.kt */
    public static final class UByteValue extends kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.LiteralValue<kotlin.UByte> {
        private final byte value;

        public /* synthetic */ UByteValue(byte b, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this(b);
        }

        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.UByteValue) && this.value == ((kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.UByteValue) obj).value;
        }

        public int hashCode() {
            return kotlin.UByte.m571hashCodeimpl(this.value);
        }

        private UByteValue(byte b) {
            super(null);
            this.value = b;
        }

        @Override // kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.LiteralValue
        public /* bridge */ /* synthetic */ kotlin.UByte getValue() {
            return kotlin.UByte.m553boximpl(m1828getValuew2LRezQ());
        }

        /* JADX INFO: renamed from: getValue-w2LRezQ, reason: not valid java name */
        public byte m1828getValuew2LRezQ() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: Annotations.kt */
    public static final class UShortValue extends kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.LiteralValue<kotlin.UShort> {
        private final short value;

        public /* synthetic */ UShortValue(short s, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this(s);
        }

        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.UShortValue) && this.value == ((kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.UShortValue) obj).value;
        }

        public int hashCode() {
            return kotlin.UShort.m836hashCodeimpl(this.value);
        }

        private UShortValue(short s) {
            super(null);
            this.value = s;
        }

        @Override // kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.LiteralValue
        public /* bridge */ /* synthetic */ kotlin.UShort getValue() {
            return kotlin.UShort.m818boximpl(m1831getValueMh2AYeg());
        }

        /* JADX INFO: renamed from: getValue-Mh2AYeg, reason: not valid java name */
        public short m1831getValueMh2AYeg() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: Annotations.kt */
    public static final class UIntValue extends kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.LiteralValue<kotlin.UInt> {
        private final int value;

        public /* synthetic */ UIntValue(int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this(i);
        }

        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.UIntValue) && this.value == ((kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.UIntValue) obj).value;
        }

        public int hashCode() {
            return kotlin.UInt.m650hashCodeimpl(this.value);
        }

        private UIntValue(int i) {
            super(null);
            this.value = i;
        }

        @Override // kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.LiteralValue
        public /* bridge */ /* synthetic */ kotlin.UInt getValue() {
            return kotlin.UInt.m632boximpl(m1829getValuepVg5ArA());
        }

        /* JADX INFO: renamed from: getValue-pVg5ArA, reason: not valid java name */
        public int m1829getValuepVg5ArA() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: Annotations.kt */
    public static final class ULongValue extends kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.LiteralValue<kotlin.ULong> {
        private final long value;

        public /* synthetic */ ULongValue(long j, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this(j);
        }

        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.ULongValue) && this.value == ((kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.ULongValue) obj).value;
        }

        public int hashCode() {
            return kotlin.ULong.m729hashCodeimpl(this.value);
        }

        private ULongValue(long j) {
            super(null);
            this.value = j;
        }

        @Override // kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.LiteralValue
        public /* bridge */ /* synthetic */ kotlin.ULong getValue() {
            return kotlin.ULong.m711boximpl(m1830getValuesVKNKU());
        }

        /* JADX INFO: renamed from: getValue-s-VKNKU, reason: not valid java name */
        public long m1830getValuesVKNKU() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: Annotations.kt */
    public static final class StringValue extends kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.LiteralValue<java.lang.String> {
        private final java.lang.String value;

        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.StringValue) && kotlin.jvm.internal.Intrinsics.areEqual(this.value, ((kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.StringValue) obj).value);
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StringValue(java.lang.String value) {
            super(null);
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        @Override // kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.LiteralValue
        public java.lang.String getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: Annotations.kt */
    public static final class EnumValue extends kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument {
        private final java.lang.String enumClassName;
        private final java.lang.String enumEntryName;

        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.EnumValue)) {
                return false;
            }
            kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.EnumValue enumValue = (kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.EnumValue) obj;
            return kotlin.jvm.internal.Intrinsics.areEqual(this.enumClassName, enumValue.enumClassName) && kotlin.jvm.internal.Intrinsics.areEqual(this.enumEntryName, enumValue.enumEntryName);
        }

        public int hashCode() {
            return (this.enumClassName.hashCode() * 31) + this.enumEntryName.hashCode();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EnumValue(java.lang.String enumClassName, java.lang.String enumEntryName) {
            super(null);
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(enumClassName, "enumClassName");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(enumEntryName, "enumEntryName");
            this.enumClassName = enumClassName;
            this.enumEntryName = enumEntryName;
        }

        public final java.lang.String getEnumClassName() {
            return this.enumClassName;
        }

        public final java.lang.String getEnumEntryName() {
            return this.enumEntryName;
        }

        @Override // kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument
        public java.lang.String toString() {
            return "EnumValue(" + this.enumClassName + com.taobao.weex.el.parse.Operators.DOT + this.enumEntryName + com.taobao.weex.el.parse.Operators.BRACKET_END;
        }
    }

    /* JADX INFO: compiled from: Annotations.kt */
    public static final class AnnotationValue extends kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument {
        private final kotlin.reflect.jvm.internal.impl.km.KmAnnotation annotation;

        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.AnnotationValue) && kotlin.jvm.internal.Intrinsics.areEqual(this.annotation, ((kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.AnnotationValue) obj).annotation);
        }

        public int hashCode() {
            return this.annotation.hashCode();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnnotationValue(kotlin.reflect.jvm.internal.impl.km.KmAnnotation annotation) {
            super(null);
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(annotation, "annotation");
            this.annotation = annotation;
        }

        public final kotlin.reflect.jvm.internal.impl.km.KmAnnotation getAnnotation() {
            return this.annotation;
        }

        @Override // kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument
        public java.lang.String toString() {
            return "AnnotationValue(" + this.annotation + com.taobao.weex.el.parse.Operators.BRACKET_END;
        }
    }

    /* JADX INFO: compiled from: Annotations.kt */
    public static final class ArrayValue extends kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument {
        private final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument> elements;

        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.ArrayValue) && kotlin.jvm.internal.Intrinsics.areEqual(this.elements, ((kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.ArrayValue) obj).elements);
        }

        public int hashCode() {
            return this.elements.hashCode();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public ArrayValue(java.util.List<? extends kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument> elements) {
            super(null);
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(elements, "elements");
            this.elements = elements;
        }

        public final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument> getElements() {
            return this.elements;
        }

        @Override // kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument
        public java.lang.String toString() {
            return "ArrayValue(" + this.elements + com.taobao.weex.el.parse.Operators.BRACKET_END;
        }
    }

    /* JADX INFO: compiled from: Annotations.kt */
    public static final class KClassValue extends kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument {
        private final java.lang.String className;

        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.KClassValue) && kotlin.jvm.internal.Intrinsics.areEqual(this.className, ((kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.KClassValue) obj).className);
        }

        public int hashCode() {
            return this.className.hashCode();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public KClassValue(java.lang.String className) {
            super(null);
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(className, "className");
            this.className = className;
        }

        public final java.lang.String getClassName() {
            return this.className;
        }

        @Override // kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument
        public java.lang.String toString() {
            return "KClassValue(" + this.className + com.taobao.weex.el.parse.Operators.BRACKET_END;
        }
    }

    /* JADX INFO: compiled from: Annotations.kt */
    public static final class ArrayKClassValue extends kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument {
        private final int arrayDimensionCount;
        private final java.lang.String className;
        private final java.lang.String stringRepresentation;

        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.ArrayKClassValue)) {
                return false;
            }
            kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.ArrayKClassValue arrayKClassValue = (kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.ArrayKClassValue) obj;
            return kotlin.jvm.internal.Intrinsics.areEqual(this.className, arrayKClassValue.className) && this.arrayDimensionCount == arrayKClassValue.arrayDimensionCount;
        }

        public int hashCode() {
            return (this.className.hashCode() * 31) + this.arrayDimensionCount;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ArrayKClassValue(java.lang.String className, int i) {
            super(null);
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(className, "className");
            this.className = className;
            this.arrayDimensionCount = i;
            if (i <= 0) {
                throw new java.lang.IllegalArgumentException("ArrayKClassValue must have at least one dimension. For regular X::class argument, use KClassValue.".toString());
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder("ArrayKClassValue(");
            for (int i2 = 0; i2 < i; i2++) {
                sb.append("kotlin/Array<");
            }
            sb.append(this.className);
            int i3 = this.arrayDimensionCount;
            for (int i4 = 0; i4 < i3; i4++) {
                sb.append(com.taobao.weex.el.parse.Operators.G);
            }
            sb.append(com.taobao.weex.el.parse.Operators.BRACKET_END_STR);
            this.stringRepresentation = sb.toString();
        }

        public final int getArrayDimensionCount() {
            return this.arrayDimensionCount;
        }

        public final java.lang.String getClassName() {
            return this.className;
        }

        @Override // kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument
        public java.lang.String toString() {
            return this.stringRepresentation;
        }
    }
}
