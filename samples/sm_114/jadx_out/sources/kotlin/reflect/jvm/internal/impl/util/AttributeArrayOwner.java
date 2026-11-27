package kotlin.reflect.jvm.internal.impl.util;

/* JADX INFO: compiled from: AttributeArrayOwner.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AttributeArrayOwner<K, T> extends kotlin.reflect.jvm.internal.impl.util.AbstractArrayMapOwner<K, T> {
    private kotlin.reflect.jvm.internal.impl.util.ArrayMap<T> arrayMap;

    protected AttributeArrayOwner(kotlin.reflect.jvm.internal.impl.util.ArrayMap<T> arrayMap) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(arrayMap, "arrayMap");
        this.arrayMap = arrayMap;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.AbstractArrayMapOwner
    protected final kotlin.reflect.jvm.internal.impl.util.ArrayMap<T> getArrayMap() {
        return this.arrayMap;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AttributeArrayOwner() {
        kotlin.reflect.jvm.internal.impl.util.EmptyArrayMap emptyArrayMap = kotlin.reflect.jvm.internal.impl.util.EmptyArrayMap.INSTANCE;
        kotlin.jvm.internal.Intrinsics.checkNotNull(emptyArrayMap, "null cannot be cast to non-null type org.jetbrains.kotlin.util.ArrayMap<T of org.jetbrains.kotlin.util.AttributeArrayOwner>");
        this(emptyArrayMap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.reflect.jvm.internal.impl.util.AbstractArrayMapOwner
    protected final void registerComponent(java.lang.String keyQualifiedName, T value) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(keyQualifiedName, "keyQualifiedName");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(value, "value");
        int id = getTypeRegistry().getId(keyQualifiedName);
        int size = this.arrayMap.getSize();
        if (size == 0) {
            kotlin.reflect.jvm.internal.impl.util.ArrayMap<T> arrayMap = this.arrayMap;
            if (!(arrayMap instanceof kotlin.reflect.jvm.internal.impl.util.EmptyArrayMap)) {
                throw new java.lang.IllegalStateException(buildDiagnosticMessage(arrayMap, 0, "EmptyArrayMap"));
            }
            this.arrayMap = new kotlin.reflect.jvm.internal.impl.util.OneElementArrayMap(value, id);
            return;
        }
        if (size == 1) {
            kotlin.reflect.jvm.internal.impl.util.ArrayMap<T> arrayMap2 = this.arrayMap;
            try {
                kotlin.jvm.internal.Intrinsics.checkNotNull(arrayMap2, "null cannot be cast to non-null type org.jetbrains.kotlin.util.OneElementArrayMap<T of org.jetbrains.kotlin.util.AttributeArrayOwner>");
                kotlin.reflect.jvm.internal.impl.util.OneElementArrayMap oneElementArrayMap = (kotlin.reflect.jvm.internal.impl.util.OneElementArrayMap) arrayMap2;
                if (oneElementArrayMap.getIndex() == id) {
                    this.arrayMap = new kotlin.reflect.jvm.internal.impl.util.OneElementArrayMap(value, id);
                    return;
                } else {
                    kotlin.reflect.jvm.internal.impl.util.ArrayMapImpl arrayMapImpl = new kotlin.reflect.jvm.internal.impl.util.ArrayMapImpl();
                    arrayMapImpl.set(oneElementArrayMap.getIndex(), oneElementArrayMap.getValue());
                    this.arrayMap = arrayMapImpl;
                }
            } catch (java.lang.ClassCastException e) {
                throw new java.lang.IllegalStateException(buildDiagnosticMessage(arrayMap2, 1, "OneElementArrayMap"), e);
            }
        }
        this.arrayMap.set(id, value);
    }

    private final java.lang.String buildDiagnosticMessage(kotlin.reflect.jvm.internal.impl.util.ArrayMap<T> arrayMap, int i, java.lang.String str) {
        T next;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Race condition happened, the size of ArrayMap is " + i + " but it isn't an `" + str + '`');
        sb.append('\n');
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder("Type: ");
        sb2.append(arrayMap.getClass());
        sb.append(sb2.toString());
        sb.append('\n');
        java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
        java.util.Map<java.lang.String, java.lang.Integer> mapAllValuesThreadUnsafeForRendering = getTypeRegistry().allValuesThreadUnsafeForRendering();
        sb3.append("[\n");
        kotlin.reflect.jvm.internal.impl.util.ArrayMap<T> arrayMap2 = arrayMap;
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(arrayMap2, 10));
        int i2 = 0;
        for (T t : arrayMap2) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                kotlin.collections.CollectionsKt.throwIndexOverflow();
            }
            java.util.Iterator<T> it = mapAllValuesThreadUnsafeForRendering.entrySet().iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (((java.lang.Number) ((java.util.Map.Entry) next).getValue()).intValue() != i2);
            sb3.append("  " + ((java.util.Map.Entry) next) + com.taobao.weex.el.parse.Operators.ARRAY_START + i2 + "]: " + t);
            sb3.append('\n');
            arrayList.add(sb3);
            i2 = i3;
        }
        sb3.append(com.taobao.weex.el.parse.Operators.ARRAY_END_STR);
        sb3.append('\n');
        sb.append("Content: " + sb3.toString());
        sb.append('\n');
        return sb.toString();
    }
}
