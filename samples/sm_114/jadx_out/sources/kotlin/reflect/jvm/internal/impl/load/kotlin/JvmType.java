package kotlin.reflect.jvm.internal.impl.load.kotlin;

/* JADX INFO: compiled from: methodSignatureMapping.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class JvmType {
    public static final kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Companion Companion = new kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Companion(null);
    private static final kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Primitive BOOLEAN = new kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Primitive(kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType.BOOLEAN);
    private static final kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Primitive CHAR = new kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Primitive(kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType.CHAR);
    private static final kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Primitive BYTE = new kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Primitive(kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType.BYTE);
    private static final kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Primitive SHORT = new kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Primitive(kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType.SHORT);
    private static final kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Primitive INT = new kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Primitive(kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType.INT);
    private static final kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Primitive FLOAT = new kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Primitive(kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType.FLOAT);
    private static final kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Primitive LONG = new kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Primitive(kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType.LONG);
    private static final kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Primitive DOUBLE = new kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Primitive(kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType.DOUBLE);

    public /* synthetic */ JvmType(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private JvmType() {
    }

    /* JADX INFO: compiled from: methodSignatureMapping.kt */
    public static final class Primitive extends kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType {
        private final kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType jvmPrimitiveType;

        public Primitive(kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType jvmPrimitiveType) {
            super(null);
            this.jvmPrimitiveType = jvmPrimitiveType;
        }

        public final kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType getJvmPrimitiveType() {
            return this.jvmPrimitiveType;
        }
    }

    /* JADX INFO: compiled from: methodSignatureMapping.kt */
    public static final class Object extends kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType {
        private final java.lang.String internalName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Object(java.lang.String internalName) {
            super(null);
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(internalName, "internalName");
            this.internalName = internalName;
        }

        public final java.lang.String getInternalName() {
            return this.internalName;
        }
    }

    /* JADX INFO: compiled from: methodSignatureMapping.kt */
    public static final class Array extends kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType {
        private final kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType elementType;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Array(kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType elementType) {
            super(null);
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(elementType, "elementType");
            this.elementType = elementType;
        }

        public final kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType getElementType() {
            return this.elementType;
        }
    }

    public java.lang.String toString() {
        return kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactoryImpl.INSTANCE.toString(this);
    }

    /* JADX INFO: compiled from: methodSignatureMapping.kt */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Primitive getBOOLEAN$descriptors_jvm() {
            return kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.BOOLEAN;
        }

        public final kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Primitive getCHAR$descriptors_jvm() {
            return kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.CHAR;
        }

        public final kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Primitive getBYTE$descriptors_jvm() {
            return kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.BYTE;
        }

        public final kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Primitive getSHORT$descriptors_jvm() {
            return kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.SHORT;
        }

        public final kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Primitive getINT$descriptors_jvm() {
            return kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.INT;
        }

        public final kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Primitive getFLOAT$descriptors_jvm() {
            return kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.FLOAT;
        }

        public final kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Primitive getLONG$descriptors_jvm() {
            return kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.LONG;
        }

        public final kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Primitive getDOUBLE$descriptors_jvm() {
            return kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.DOUBLE;
        }
    }
}
