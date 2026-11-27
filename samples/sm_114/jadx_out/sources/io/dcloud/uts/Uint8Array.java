package io.dcloud.uts;

/* JADX INFO: compiled from: Uint8Array.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010(\n\u0002\b\u0002\b\u0016\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0017\b\u0016\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0004\b\u0004\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB)\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\rJ\b\u0010\u0013\u001a\u00020\u0003H\u0016J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003H\u0016J_\u0010\u0016\u001a\u00020\u0000\"\b\b\u0000\u0010\u0017*\u00020\u00012K\u0010\u0018\u001aG\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u0011H\u0017¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u001d0\u0019H\u0016J\u001f\u0010\u001e\u001a\u00020\u001f2\b\u0010\u001c\u001a\u0004\u0018\u00010 2\u0006\u0010\u0015\u001a\u00020\u0003H\u0016¢\u0006\u0002\u0010!J_\u0010\"\u001a\u00020\u0000\"\b\b\u0000\u0010\u0017*\u00020\u00012K\u0010#\u001aG\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u0011H\u0017¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00030\u0019H\u0016J\u0010\u0010$\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020 H\u0016J\u001c\u0010%\u001a\u00020\u00002\b\u0010&\u001a\u0004\u0018\u00010\u00032\b\u0010'\u001a\u0004\u0018\u00010\u0003H\u0016J\u001c\u0010(\u001a\u00020\u00002\b\u0010)\u001a\u0004\u0018\u00010\u00032\b\u0010'\u001a\u0004\u0018\u00010\u0003H\u0016J\u000f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00030+H\u0096\u0002R\u001c\u0010\u000e\u001a\u00020\u0003X\u0096\u000e¢\u0006\u0010\n\u0002\b\u0012\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0005¨\u0006-"}, d2 = {"Lio/dcloud/uts/Uint8Array;", "Lio/dcloud/uts/TypedArray;", "length", "", "<init>", "(Ljava/lang/Number;)V", "array", "", "(Ljava/util/Collection;)V", "buffer", "Lio/dcloud/uts/ArrayBuffer;", "(Lio/dcloud/uts/ArrayBuffer;)V", "byteOffset", "(Lio/dcloud/uts/ArrayBuffer;Ljava/lang/Number;Ljava/lang/Number;)V", "BYTES_PER_ELEMENT", "getBYTES_PER_ELEMENT", "()Ljava/lang/Number;", "setBYTES_PER_ELEMENT", "BYTES_PER_ELEMENT$1", "getBytesPerElement", "convertValue", "value", com.taobao.weex.common.Constants.Name.FILTER, "T", "predicate", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "index", "", "putAuto", "", "", "(Ljava/lang/Integer;Ljava/lang/Number;)V", "map", "callbackfn", "getAuto", "slice", "start", "end", "subarray", "begin", "iterator", "", "Companion", "utsplugin_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class Uint8Array extends io.dcloud.uts.TypedArray {
    public static final int BYTES_PER_ELEMENT = 1;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final io.dcloud.uts.Uint8Array.Companion INSTANCE = new io.dcloud.uts.Uint8Array.Companion(null);

    /* JADX INFO: renamed from: BYTES_PER_ELEMENT$1, reason: from kotlin metadata */
    private java.lang.Number BYTES_PER_ELEMENT;

    @Override // io.dcloud.uts.TypedArray
    public java.lang.Number convertValue(java.lang.Number value) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(value, "value");
        return value;
    }

    @Override // io.dcloud.uts.TypedArray
    public java.lang.Number getBYTES_PER_ELEMENT() {
        return this.BYTES_PER_ELEMENT;
    }

    @Override // io.dcloud.uts.TypedArray
    public void setBYTES_PER_ELEMENT(java.lang.Number number) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(number, "<set-?>");
        this.BYTES_PER_ELEMENT = number;
    }

    @Override // io.dcloud.uts.TypedArray
    public java.lang.Number getBytesPerElement() {
        return (java.lang.Number) 1;
    }

    /* JADX INFO: compiled from: Uint8Array.kt */
    @kotlin.Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\"\u00020\n¢\u0006\u0002\u0010\u000bJ2\u0010\f\u001a\u00020\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u000e2\u001c\b\u0002\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lio/dcloud/uts/Uint8Array$Companion;", "", "<init>", "()V", "BYTES_PER_ELEMENT", "", "of", "Lio/dcloud/uts/Uint8Array;", "items", "", "", "([Ljava/lang/Number;)Lio/dcloud/uts/Uint8Array;", "from", "arrayLike", "", "mapFn", "Lkotlin/Function2;", "utsplugin_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final io.dcloud.uts.Uint8Array of(java.lang.Number... items) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(items, "items");
            io.dcloud.uts.Uint8Array uint8Array = new io.dcloud.uts.Uint8Array(java.lang.Integer.valueOf(items.length));
            java.util.ArrayList arrayList = new java.util.ArrayList(items.length);
            for (java.lang.Number number : items) {
                io.dcloud.uts.TypedArray.putAuto$default(uint8Array, null, java.lang.Byte.valueOf(number.byteValue()), 1, null);
                arrayList.add(kotlin.Unit.INSTANCE);
            }
            return uint8Array;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ io.dcloud.uts.Uint8Array from$default(io.dcloud.uts.Uint8Array.Companion companion, java.util.Collection collection, kotlin.jvm.functions.Function2 function2, int i, java.lang.Object obj) {
            if ((i & 2) != 0) {
                function2 = null;
            }
            return companion.from(collection, function2);
        }

        public final io.dcloud.uts.Uint8Array from(java.util.Collection<? extends java.lang.Number> arrayLike, kotlin.jvm.functions.Function2<? super java.lang.Number, ? super java.lang.Number, ? extends java.lang.Number> mapFn) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(arrayLike, "arrayLike");
            io.dcloud.uts.Uint8Array uint8Array = new io.dcloud.uts.Uint8Array(java.lang.Integer.valueOf(arrayLike.size()));
            int i = 0;
            for (java.lang.Number number : arrayLike) {
                if (mapFn != null) {
                    io.dcloud.uts.TypedArray.putAuto$default(uint8Array, null, java.lang.Byte.valueOf(mapFn.invoke(number, java.lang.Integer.valueOf(i)).byteValue()), 1, null);
                } else {
                    io.dcloud.uts.TypedArray.putAuto$default(uint8Array, null, java.lang.Byte.valueOf(number.byteValue()), 1, null);
                }
                i++;
            }
            return uint8Array;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Uint8Array(java.lang.Number length) {
        super(length);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(length, "length");
        this.BYTES_PER_ELEMENT = (java.lang.Number) 1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Uint8Array(java.util.Collection<? extends java.lang.Number> array) {
        super(array);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(array, "array");
        this.BYTES_PER_ELEMENT = (java.lang.Number) 1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Uint8Array(io.dcloud.uts.ArrayBuffer buffer) {
        super(buffer);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(buffer, "buffer");
        this.BYTES_PER_ELEMENT = (java.lang.Number) 1;
    }

    public /* synthetic */ Uint8Array(io.dcloud.uts.ArrayBuffer arrayBuffer, java.lang.Number number, java.lang.Number number2, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(arrayBuffer, (i & 2) != 0 ? null : number, (i & 4) != 0 ? null : number2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Uint8Array(io.dcloud.uts.ArrayBuffer buffer, java.lang.Number number, java.lang.Number number2) {
        super(buffer, number, number2);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(buffer, "buffer");
        this.BYTES_PER_ELEMENT = (java.lang.Number) 1;
    }

    @Override // io.dcloud.uts.TypedArray
    public <T extends io.dcloud.uts.TypedArray> io.dcloud.uts.Uint8Array filter(kotlin.jvm.functions.Function3<? super java.lang.Number, ? super java.lang.Number, ? super T, java.lang.Boolean> predicate) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(predicate, "predicate");
        io.dcloud.uts.UTSArray uTSArray = new io.dcloud.uts.UTSArray();
        int size = size();
        for (int i = 0; i < size; i++) {
            java.lang.Number auto = getAuto(i);
            java.lang.Integer numValueOf = java.lang.Integer.valueOf(auto.intValue());
            java.lang.Integer numValueOf2 = java.lang.Integer.valueOf(i);
            kotlin.jvm.internal.Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of io.dcloud.uts.Uint8Array.filter");
            if (predicate.invoke(numValueOf, numValueOf2, this).booleanValue()) {
                uTSArray.add(java.lang.Integer.valueOf(auto.intValue()));
            }
        }
        return new io.dcloud.uts.Uint8Array(uTSArray);
    }

    @Override // io.dcloud.uts.TypedArray
    public void putAuto(java.lang.Integer index, java.lang.Number value) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(value, "value");
        if (index == null) {
            getByteBuffer().put(value.byteValue());
        } else {
            getByteBuffer().put(index.intValue(), value.byteValue());
        }
    }

    @Override // io.dcloud.uts.TypedArray
    public <T extends io.dcloud.uts.TypedArray> io.dcloud.uts.Uint8Array map(kotlin.jvm.functions.Function3<? super java.lang.Number, ? super java.lang.Number, ? super T, ? extends java.lang.Number> callbackfn) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callbackfn, "callbackfn");
        int size = size();
        io.dcloud.uts.UTSArray uTSArray = new io.dcloud.uts.UTSArray();
        for (int i = 0; i < size; i++) {
            java.lang.Number auto = getAuto(i);
            java.lang.Integer numValueOf = java.lang.Integer.valueOf(i);
            kotlin.jvm.internal.Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of io.dcloud.uts.Uint8Array.map");
            uTSArray.add(java.lang.Integer.valueOf(callbackfn.invoke(auto, numValueOf, this).intValue()));
        }
        return new io.dcloud.uts.Uint8Array(uTSArray);
    }

    @Override // io.dcloud.uts.TypedArray
    public java.lang.Number getAuto(int index) {
        return java.lang.Integer.valueOf(kotlin.UByte.m559constructorimpl(getByteBuffer().get(index)) & 255);
    }

    @Override // io.dcloud.uts.TypedArray
    public io.dcloud.uts.Uint8Array slice(java.lang.Number start, java.lang.Number end) {
        if (start == null) {
            start = (java.lang.Number) 0;
        }
        if (end == null) {
            end = java.lang.Integer.valueOf(getLength().intValue());
        }
        io.dcloud.uts.UTSArray uTSArray = new io.dcloud.uts.UTSArray();
        int sliceIndex = io.dcloud.uts.utils.IndexKt.toSliceIndex(end, getLength().intValue());
        for (int sliceIndex2 = io.dcloud.uts.utils.IndexKt.toSliceIndex(start, getLength().intValue()); sliceIndex2 < sliceIndex; sliceIndex2++) {
            uTSArray.add(getAuto(sliceIndex2));
        }
        return new io.dcloud.uts.Uint8Array(uTSArray);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0031  */
    /* JADX WARN: Code duplicated, block: B:8:0x001a  */
    @Override // io.dcloud.uts.TypedArray
    public io.dcloud.uts.Uint8Array subarray(java.lang.Number begin, java.lang.Number end) {
        if (begin != null) {
            if (io.dcloud.uts.NumberKt.compareTo(begin, (java.lang.Number) 0) < 0) {
                begin = io.dcloud.uts.NumberKt.plus(getLength(), begin);
            }
            if (begin == null) {
                begin = (java.lang.Number) 0;
            }
        } else {
            begin = (java.lang.Number) 0;
        }
        if (end != null) {
            if (io.dcloud.uts.NumberKt.compareTo(end, (java.lang.Number) 0) < 0) {
                end = io.dcloud.uts.NumberKt.plus(getLength(), end);
            }
            if (end == null) {
                end = getLength();
            }
        } else {
            end = getLength();
        }
        int iCoerceIn = kotlin.ranges.RangesKt.coerceIn(begin.intValue(), 0, getLength().intValue());
        int iCoerceIn2 = kotlin.ranges.RangesKt.coerceIn(end.intValue(), iCoerceIn, getLength().intValue());
        io.dcloud.uts.UTSArray uTSArray = new io.dcloud.uts.UTSArray();
        while (iCoerceIn < iCoerceIn2) {
            uTSArray.push(getAuto(iCoerceIn));
            iCoerceIn++;
        }
        return new io.dcloud.uts.Uint8Array(uTSArray);
    }

    @Override // io.dcloud.uts.TypedArray, java.util.Collection, java.lang.Iterable
    public java.util.Iterator<java.lang.Number> iterator() {
        getByteBuffer().rewind();
        return new io.dcloud.uts.Uint8Array.AnonymousClass1();
    }

    /* JADX INFO: renamed from: io.dcloud.uts.Uint8Array$iterator$1, reason: invalid class name */
    /* JADX INFO: compiled from: Uint8Array.kt */
    @kotlin.Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0010(\n\u0002\u0010\u0004\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0004H\u0096\u0002J\t\u0010\u0005\u001a\u00020\u0002H\u0096\u0002¨\u0006\u0006"}, d2 = {"io/dcloud/uts/Uint8Array$iterator$1", "", "", "hasNext", "", "next", "utsplugin_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class AnonymousClass1 implements java.util.Iterator<java.lang.Number>, kotlin.jvm.internal.markers.KMappedMarker {
        @Override // java.util.Iterator
        public void remove() {
            throw new java.lang.UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        AnonymousClass1() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return io.dcloud.uts.Uint8Array.this.getByteBuffer().remaining() > 0;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public java.lang.Number next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            return java.lang.Integer.valueOf(kotlin.UByte.m559constructorimpl(io.dcloud.uts.Uint8Array.this.getByteBuffer().get()) & 255);
        }
    }
}
