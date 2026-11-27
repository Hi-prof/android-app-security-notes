package kotlin.reflect.jvm.internal.impl.km;

/* JADX INFO: compiled from: Nodes.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class KmClassifier {
    public /* synthetic */ KmClassifier(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private KmClassifier() {
    }

    /* JADX INFO: compiled from: Nodes.kt */
    public static final class Class extends kotlin.reflect.jvm.internal.impl.km.KmClassifier {
        private final java.lang.String name;

        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof kotlin.reflect.jvm.internal.impl.km.KmClassifier.Class) && kotlin.jvm.internal.Intrinsics.areEqual(this.name, ((kotlin.reflect.jvm.internal.impl.km.KmClassifier.Class) obj).name);
        }

        public int hashCode() {
            return this.name.hashCode();
        }

        public java.lang.String toString() {
            return "Class(name=" + this.name + com.taobao.weex.el.parse.Operators.BRACKET_END;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Class(java.lang.String name) {
            super(null);
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
            this.name = name;
        }

        public final java.lang.String getName() {
            return this.name;
        }
    }

    /* JADX INFO: compiled from: Nodes.kt */
    public static final class TypeParameter extends kotlin.reflect.jvm.internal.impl.km.KmClassifier {
        private final int id;

        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof kotlin.reflect.jvm.internal.impl.km.KmClassifier.TypeParameter) && this.id == ((kotlin.reflect.jvm.internal.impl.km.KmClassifier.TypeParameter) obj).id;
        }

        public int hashCode() {
            return this.id;
        }

        public java.lang.String toString() {
            return "TypeParameter(id=" + this.id + com.taobao.weex.el.parse.Operators.BRACKET_END;
        }

        public TypeParameter(int i) {
            super(null);
            this.id = i;
        }

        public final int getId() {
            return this.id;
        }
    }

    /* JADX INFO: compiled from: Nodes.kt */
    public static final class TypeAlias extends kotlin.reflect.jvm.internal.impl.km.KmClassifier {
        private final java.lang.String name;

        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof kotlin.reflect.jvm.internal.impl.km.KmClassifier.TypeAlias) && kotlin.jvm.internal.Intrinsics.areEqual(this.name, ((kotlin.reflect.jvm.internal.impl.km.KmClassifier.TypeAlias) obj).name);
        }

        public int hashCode() {
            return this.name.hashCode();
        }

        public java.lang.String toString() {
            return "TypeAlias(name=" + this.name + com.taobao.weex.el.parse.Operators.BRACKET_END;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TypeAlias(java.lang.String name) {
            super(null);
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
            this.name = name;
        }

        public final java.lang.String getName() {
            return this.name;
        }
    }
}
