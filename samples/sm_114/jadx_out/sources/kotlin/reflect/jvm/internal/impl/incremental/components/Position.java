package kotlin.reflect.jvm.internal.impl.incremental.components;

/* JADX INFO: compiled from: LookupLocation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Position implements java.io.Serializable {
    public static final kotlin.reflect.jvm.internal.impl.incremental.components.Position.Companion Companion = new kotlin.reflect.jvm.internal.impl.incremental.components.Position.Companion(null);
    private static final kotlin.reflect.jvm.internal.impl.incremental.components.Position NO_POSITION = new kotlin.reflect.jvm.internal.impl.incremental.components.Position(-1, -1);
    private final int column;
    private final int line;

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof kotlin.reflect.jvm.internal.impl.incremental.components.Position)) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.incremental.components.Position position = (kotlin.reflect.jvm.internal.impl.incremental.components.Position) obj;
        return this.line == position.line && this.column == position.column;
    }

    public int hashCode() {
        return (this.line * 31) + this.column;
    }

    public java.lang.String toString() {
        return "Position(line=" + this.line + ", column=" + this.column + com.taobao.weex.el.parse.Operators.BRACKET_END;
    }

    /* JADX INFO: compiled from: LookupLocation.kt */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final kotlin.reflect.jvm.internal.impl.incremental.components.Position getNO_POSITION() {
            return kotlin.reflect.jvm.internal.impl.incremental.components.Position.NO_POSITION;
        }
    }

    public Position(int i, int i2) {
        this.line = i;
        this.column = i2;
    }
}
