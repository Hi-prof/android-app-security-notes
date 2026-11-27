package io.dcloud.uts;

/* JADX INFO: compiled from: Map.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u001e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003j\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002`\u00042\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00060\u0005B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bB\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\f¢\u0006\u0004\b\n\u0010\rB\u001d\b\u0016\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000¢\u0006\u0004\b\n\u0010\u000fB\t\b\u0016¢\u0006\u0004\b\n\u0010\u0010B\u001f\b\u0016\u0012\u0014\u0010\u0011\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00060\u0006¢\u0006\u0004\b\n\u0010\u0012B\u001d\b\u0016\u0012\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0014¢\u0006\u0004\b\n\u0010\u0015J)\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0017\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0019J\u0015\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0017\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001cJ\u0015\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u0017\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001cJ+\u0010\u001e\u001a\u00020\u001f2!\u0010 \u001a\u001d\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u001f0!H\u0016J@\u0010\u001e\u001a\u00020\u001f26\u0010 \u001a2\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u001f0$H\u0016Ja\u0010\u001e\u001a\u00020\u001f2W\u0010 \u001aS\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(\u0017\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u001f0%H\u0016J+\u0010&\u001a\u00020\u001f2!\u0010 \u001a\u001d\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u001f0!H\u0016J@\u0010&\u001a\u00020\u001f26\u0010 \u001a2\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u001f0$H\u0016Ja\u0010&\u001a\u00020\u001f2W\u0010 \u001aS\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(\u0017\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u001f0%H\u0016J\b\u0010'\u001a\u00020\fH\u0016J\b\u0010(\u001a\u00020)H\u0016J\u0016\u0010*\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00060+H\u0016J\u0013\u0010,\u001a\u00020\u001b2\b\u0010-\u001a\u0004\u0018\u00010\u0007H\u0096\u0002J\u0017\u0010.\u001a\u0004\u0018\u00010)2\u0006\u0010\u0017\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010/J\u0017\u00100\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0017\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00101J\u0017\u00102\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0017\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00103J\u0017\u00104\u001a\u0004\u0018\u0001052\u0006\u0010\u0017\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00106J\u0017\u00107\u001a\u0004\u0018\u0001082\u0006\u0010\u0017\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00109¨\u0006:"}, d2 = {"Lio/dcloud/uts/Map;", "K", "V", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "Lio/dcloud/uts/UTSValueIterable;", "Lio/dcloud/uts/UTSArray;", "", io.dcloud.common.constant.AbsoluteConst.JSON_KEY_SIZE, "", "<init>", "(Ljava/lang/Number;)V", "", "(I)V", "map", "(Lio/dcloud/uts/Map;)V", "()V", "mutableList", "(Lio/dcloud/uts/UTSArray;)V", "kotlinMap", "", "(Ljava/util/Map;)V", "set", io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_KEY, "value", "(Ljava/lang/Object;Ljava/lang/Object;)Lio/dcloud/uts/Map;", "delete", "", "(Ljava/lang/Object;)Z", "has", "forEach", "", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlin/Function2;", "Lkotlin/Function3;", "forEachUTS", "hashCode", "toString", "", "valueIterator", "Lio/dcloud/uts/UTSIterator;", "equals", "other", "getString", "(Ljava/lang/Object;)Ljava/lang/String;", "getInteger", "(Ljava/lang/Object;)Ljava/lang/Integer;", "getBoolean", "(Ljava/lang/Object;)Ljava/lang/Boolean;", "getLong", "", "(Ljava/lang/Object;)Ljava/lang/Long;", "getDouble", "", "(Ljava/lang/Object;)Ljava/lang/Double;", "utsplugin_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class Map<K, V> extends java.util.LinkedHashMap<K, V> implements io.dcloud.uts.UTSValueIterable<io.dcloud.uts.UTSArray<java.lang.Object>> {
    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(java.lang.Object other) {
        return this == other;
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ java.util.Set<java.util.Map.Entry<K, V>> entrySet() {
        return (java.util.Set<java.util.Map.Entry<K, V>>) getEntries();
    }

    public /* bridge */ java.util.Set<java.util.Map.Entry<java.lang.Object, java.lang.Object>> getEntries() {
        return super.entrySet();
    }

    public /* bridge */ java.util.Set<java.lang.Object> getKeys() {
        return super.keySet();
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ java.util.Collection<java.lang.Object> getValues() {
        return super.values();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ java.util.Set<K> keySet() {
        return (java.util.Set<K>) getKeys();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ java.util.Collection<V> values() {
        return (java.util.Collection<V>) getValues();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Map(java.lang.Number size) {
        super(size.intValue());
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(size, "size");
    }

    public Map(int i) {
        super(i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Map(io.dcloud.uts.Map<K, V> map) {
        super(map);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(map, "map");
    }

    public Map() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Map(io.dcloud.uts.UTSArray<io.dcloud.uts.UTSArray<java.lang.Object>> mutableList) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(mutableList, "mutableList");
        for (io.dcloud.uts.UTSArray<java.lang.Object> uTSArray : mutableList) {
            if (io.dcloud.uts.NumberKt.compareTo(uTSArray.getLength(), (java.lang.Number) 1) > 0) {
                set(uTSArray.get(0), uTSArray.get(1));
            } else {
                kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) uTSArray.getLength(), (java.lang.Object) 1);
            }
        }
    }

    public Map(java.util.Map<K, ? extends V> kotlinMap) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinMap, "kotlinMap");
        putAll(kotlinMap);
    }

    public io.dcloud.uts.Map<K, V> set(K key, V value) {
        put(key, value);
        return this;
    }

    public boolean delete(K key) {
        if (!containsKey(key)) {
            return false;
        }
        remove(key);
        return true;
    }

    public boolean has(K key) {
        return containsKey(key);
    }

    public void forEach(kotlin.jvm.functions.Function1<? super V, kotlin.Unit> action) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(action, "action");
        for (java.util.Map.Entry<K, V> entry : entrySet()) {
            entry.getKey();
            action.invoke(entry.getValue());
        }
    }

    public void forEach(kotlin.jvm.functions.Function2<? super V, ? super K, kotlin.Unit> action) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(action, "action");
        for (java.util.Map.Entry<K, V> entry : entrySet()) {
            action.invoke(entry.getValue(), entry.getKey());
        }
    }

    public void forEach(kotlin.jvm.functions.Function3<? super V, ? super K, ? super io.dcloud.uts.Map<K, V>, kotlin.Unit> action) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(action, "action");
        for (java.util.Map.Entry<K, V> entry : entrySet()) {
            action.invoke(entry.getValue(), entry.getKey(), this);
        }
    }

    public void forEachUTS(kotlin.jvm.functions.Function1<? super V, kotlin.Unit> action) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(action, "action");
        for (java.util.Map.Entry<K, V> entry : entrySet()) {
            entry.getKey();
            action.invoke(entry.getValue());
        }
    }

    public void forEachUTS(kotlin.jvm.functions.Function2<? super V, ? super K, kotlin.Unit> action) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(action, "action");
        for (java.util.Map.Entry<K, V> entry : entrySet()) {
            action.invoke(entry.getValue(), entry.getKey());
        }
    }

    public void forEachUTS(kotlin.jvm.functions.Function3<? super V, ? super K, ? super io.dcloud.uts.Map<K, V>, kotlin.Unit> action) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(action, "action");
        for (java.util.Map.Entry<K, V> entry : entrySet()) {
            action.invoke(entry.getValue(), entry.getKey(), this);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        return java.lang.System.identityHashCode(this);
    }

    @Override // java.util.AbstractMap
    public java.lang.String toString() {
        return "[object Map]";
    }

    @Override // io.dcloud.uts.UTSValueIterable
    public io.dcloud.uts.UTSIterator<io.dcloud.uts.UTSArray<java.lang.Object>> valueIterator() {
        final java.util.Iterator<java.util.Map.Entry<K, V>> it = entrySet().iterator();
        return new io.dcloud.uts.UTSIterator<>(new kotlin.jvm.functions.Function0() { // from class: io.dcloud.uts.Map$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final java.lang.Object invoke() {
                return io.dcloud.uts.Map.valueIterator$lambda$7(it);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final io.dcloud.uts.UTSIteratorResult valueIterator$lambda$7(java.util.Iterator it) {
        if (!it.hasNext()) {
            return new io.dcloud.uts.UTSIteratorResult(true, new io.dcloud.uts.UTSArray());
        }
        java.util.Map.Entry entry = (java.util.Map.Entry) it.next();
        return new io.dcloud.uts.UTSIteratorResult(false, io.dcloud.uts.UTSArrayKt.utsArrayOf(entry.getKey(), entry.getValue()));
    }

    public java.lang.String getString(K key) {
        if (get(key) == null) {
            return null;
        }
        return io.dcloud.uts.NumberKt.toString_number_nullable$default(get(key), (java.lang.Number) null, 1, (java.lang.Object) null);
    }

    public java.lang.Integer getInteger(K key) {
        return com.alibaba.fastjson.util.TypeUtils.castToInt(get(key));
    }

    public java.lang.Boolean getBoolean(K key) {
        V v = get(key);
        if (v == null) {
            return null;
        }
        return com.alibaba.fastjson.util.TypeUtils.castToBoolean(v);
    }

    public java.lang.Long getLong(K key) {
        return com.alibaba.fastjson.util.TypeUtils.castToLong(get(key));
    }

    public java.lang.Double getDouble(K key) {
        return com.alibaba.fastjson.util.TypeUtils.castToDouble(get(key));
    }
}
