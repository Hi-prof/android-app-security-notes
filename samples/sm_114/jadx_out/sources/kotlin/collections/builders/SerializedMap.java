package kotlin.collections.builders;

/* JADX INFO: compiled from: MapBuilder.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0017\u0012\u000e\u0010\u0002\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\t\b\u0016¢\u0006\u0004\b\u0004\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0002R\u0016\u0010\u0002\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lkotlin/collections/builders/SerializedMap;", "Ljava/io/Externalizable;", "map", "", "<init>", "(Ljava/util/Map;)V", "()V", "writeExternal", "", "output", "Ljava/io/ObjectOutput;", "readExternal", "input", "Ljava/io/ObjectInput;", "readResolve", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
final class SerializedMap implements java.io.Externalizable {
    private static final long serialVersionUID = 0;
    private java.util.Map<?, ?> map;

    public SerializedMap(java.util.Map<?, ?> map) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(map, "map");
        this.map = map;
    }

    public SerializedMap() {
        this(kotlin.collections.MapsKt.emptyMap());
    }

    @Override // java.io.Externalizable
    public void writeExternal(java.io.ObjectOutput output) throws java.io.IOException {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(output, "output");
        output.writeByte(0);
        output.writeInt(this.map.size());
        for (java.util.Map.Entry<?, ?> entry : this.map.entrySet()) {
            output.writeObject(entry.getKey());
            output.writeObject(entry.getValue());
        }
    }

    @Override // java.io.Externalizable
    public void readExternal(java.io.ObjectInput input) throws java.io.InvalidObjectException {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(input, "input");
        byte b = input.readByte();
        if (b != 0) {
            throw new java.io.InvalidObjectException("Unsupported flags value: " + ((int) b));
        }
        int i = input.readInt();
        if (i < 0) {
            throw new java.io.InvalidObjectException("Illegal size value: " + i + com.taobao.weex.el.parse.Operators.DOT);
        }
        java.util.Map mapCreateMapBuilder = kotlin.collections.MapsKt.createMapBuilder(i);
        for (int i2 = 0; i2 < i; i2++) {
            mapCreateMapBuilder.put(input.readObject(), input.readObject());
        }
        this.map = kotlin.collections.MapsKt.build(mapCreateMapBuilder);
    }

    private final java.lang.Object readResolve() {
        return this.map;
    }
}
