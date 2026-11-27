package kotlin.reflect.jvm.internal.impl.resolve.constants;

/* JADX INFO: compiled from: constantValues.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ConstantValue<T> {
    private final T value;

    public abstract kotlin.reflect.jvm.internal.impl.types.KotlinType getType(kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor moduleDescriptor);

    public ConstantValue(T t) {
        this.value = t;
    }

    public T getValue() {
        return this.value;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        T value = getValue();
        kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue constantValue = obj instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue ? (kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue) obj : null;
        return kotlin.jvm.internal.Intrinsics.areEqual(value, constantValue != null ? constantValue.getValue() : null);
    }

    public int hashCode() {
        T value = getValue();
        if (value != null) {
            return value.hashCode();
        }
        return 0;
    }

    public java.lang.String toString() {
        return java.lang.String.valueOf(getValue());
    }
}
