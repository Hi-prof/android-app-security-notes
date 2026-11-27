package io.dcloud.uts;

/* JADX INFO: compiled from: Uint8ClampedArray.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 #2\u00020\u0001:\u0001#B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0017\b\u0016\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0004\b\u0004\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB)\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\rJ\u001f\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0003H\u0016¢\u0006\u0002\u0010\u0013J_\u0010\u0014\u001a\u00020\u0000\"\b\b\u0000\u0010\u0015*\u00020\u00162K\u0010\u0017\u001aG\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u0011H\u0015¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u001b0\u0018H\u0016J_\u0010\u001c\u001a\u00020\u0000\"\b\b\u0000\u0010\u0015*\u00020\u00162K\u0010\u001d\u001aG\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u0011H\u0015¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00030\u0018H\u0016J\u001c\u0010\u001e\u001a\u00020\u00002\b\u0010\u001f\u001a\u0004\u0018\u00010\u00032\b\u0010 \u001a\u0004\u0018\u00010\u0003H\u0016J\u001c\u0010!\u001a\u00020\u00002\b\u0010\"\u001a\u0004\u0018\u00010\u00032\b\u0010 \u001a\u0004\u0018\u00010\u0003H\u0016¨\u0006$"}, d2 = {"Lio/dcloud/uts/Uint8ClampedArray;", "Lio/dcloud/uts/Uint8Array;", "length", "", "<init>", "(Ljava/lang/Number;)V", "array", "", "(Ljava/util/Collection;)V", "buffer", "Lio/dcloud/uts/ArrayBuffer;", "(Lio/dcloud/uts/ArrayBuffer;)V", "byteOffset", "(Lio/dcloud/uts/ArrayBuffer;Ljava/lang/Number;Ljava/lang/Number;)V", "putAuto", "", "index", "", "value", "(Ljava/lang/Integer;Ljava/lang/Number;)V", com.taobao.weex.common.Constants.Name.FILTER, "T", "Lio/dcloud/uts/TypedArray;", "predicate", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "", "map", "callbackfn", "slice", "start", "end", "subarray", "begin", "Companion", "utsplugin_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Uint8ClampedArray extends io.dcloud.uts.Uint8Array {
    public static final int BYTES_PER_ELEMENT = 1;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final io.dcloud.uts.Uint8ClampedArray.Companion INSTANCE = new io.dcloud.uts.Uint8ClampedArray.Companion(null);

    /* JADX INFO: compiled from: Uint8ClampedArray.kt */
    @kotlin.Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\"\u00020\n¢\u0006\u0002\u0010\u000bJ2\u0010\f\u001a\u00020\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u000e2\u001c\b\u0002\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lio/dcloud/uts/Uint8ClampedArray$Companion;", "", "<init>", "()V", "BYTES_PER_ELEMENT", "", "of", "Lio/dcloud/uts/Uint8ClampedArray;", "items", "", "", "([Ljava/lang/Number;)Lio/dcloud/uts/Uint8ClampedArray;", "from", "arrayLike", "", "mapFn", "Lkotlin/Function2;", "utsplugin_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final io.dcloud.uts.Uint8ClampedArray of(java.lang.Number... items) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(items, "items");
            io.dcloud.uts.Uint8ClampedArray uint8ClampedArray = new io.dcloud.uts.Uint8ClampedArray(java.lang.Integer.valueOf(items.length));
            java.util.ArrayList arrayList = new java.util.ArrayList(items.length);
            for (java.lang.Number number : items) {
                io.dcloud.uts.TypedArray.putAuto$default(uint8ClampedArray, null, java.lang.Byte.valueOf(number.byteValue()), 1, null);
                arrayList.add(kotlin.Unit.INSTANCE);
            }
            return uint8ClampedArray;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ io.dcloud.uts.Uint8ClampedArray from$default(io.dcloud.uts.Uint8ClampedArray.Companion companion, java.util.Collection collection, kotlin.jvm.functions.Function2 function2, int i, java.lang.Object obj) {
            if ((i & 2) != 0) {
                function2 = null;
            }
            return companion.from(collection, function2);
        }

        public final io.dcloud.uts.Uint8ClampedArray from(java.util.Collection<? extends java.lang.Number> arrayLike, kotlin.jvm.functions.Function2<? super java.lang.Number, ? super java.lang.Number, ? extends java.lang.Number> mapFn) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(arrayLike, "arrayLike");
            io.dcloud.uts.Uint8ClampedArray uint8ClampedArray = new io.dcloud.uts.Uint8ClampedArray(java.lang.Integer.valueOf(arrayLike.size()));
            int i = 0;
            for (java.lang.Number number : arrayLike) {
                if (mapFn != null) {
                    io.dcloud.uts.TypedArray.putAuto$default(uint8ClampedArray, null, java.lang.Byte.valueOf(mapFn.invoke(number, java.lang.Integer.valueOf(i)).byteValue()), 1, null);
                } else {
                    io.dcloud.uts.TypedArray.putAuto$default(uint8ClampedArray, null, java.lang.Byte.valueOf(number.byteValue()), 1, null);
                }
                i++;
            }
            return uint8ClampedArray;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Uint8ClampedArray(java.lang.Number length) {
        super(length);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(length, "length");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Uint8ClampedArray(java.util.Collection<? extends java.lang.Number> array) {
        super(array);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(array, "array");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Uint8ClampedArray(io.dcloud.uts.ArrayBuffer buffer) {
        super(buffer);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(buffer, "buffer");
    }

    public /* synthetic */ Uint8ClampedArray(io.dcloud.uts.ArrayBuffer arrayBuffer, java.lang.Number number, java.lang.Number number2, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(arrayBuffer, (i & 2) != 0 ? null : number, (i & 4) != 0 ? null : number2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Uint8ClampedArray(io.dcloud.uts.ArrayBuffer buffer, java.lang.Number number, java.lang.Number number2) {
        super(buffer, number, number2);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(buffer, "buffer");
    }

    @Override // io.dcloud.uts.Uint8Array, io.dcloud.uts.TypedArray
    public void putAuto(java.lang.Integer index, java.lang.Number value) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(value, "value");
        if (io.dcloud.uts.NumberKt.compareTo(value, (java.lang.Number) 0) < 0) {
            value = (java.lang.Number) 0;
        } else if (io.dcloud.uts.NumberKt.compareTo(value, (java.lang.Number) 255) > 0) {
            value = (java.lang.Number) 255;
        }
        super.putAuto(index, value);
    }

    @Override // io.dcloud.uts.Uint8Array, io.dcloud.uts.TypedArray
    public <T extends io.dcloud.uts.TypedArray> io.dcloud.uts.Uint8ClampedArray filter(kotlin.jvm.functions.Function3<? super java.lang.Number, ? super java.lang.Number, ? super T, java.lang.Boolean> predicate) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(predicate, "predicate");
        io.dcloud.uts.UTSArray uTSArray = new io.dcloud.uts.UTSArray();
        int size = size();
        for (int i = 0; i < size; i++) {
            java.lang.Number auto = getAuto(i);
            java.lang.Integer numValueOf = java.lang.Integer.valueOf(auto.intValue());
            java.lang.Integer numValueOf2 = java.lang.Integer.valueOf(i);
            kotlin.jvm.internal.Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of io.dcloud.uts.Uint8ClampedArray.filter");
            if (predicate.invoke(numValueOf, numValueOf2, this).booleanValue()) {
                uTSArray.add(java.lang.Integer.valueOf(auto.intValue()));
            }
        }
        return new io.dcloud.uts.Uint8ClampedArray(uTSArray);
    }

    @Override // io.dcloud.uts.Uint8Array, io.dcloud.uts.TypedArray
    public <T extends io.dcloud.uts.TypedArray> io.dcloud.uts.Uint8ClampedArray map(kotlin.jvm.functions.Function3<? super java.lang.Number, ? super java.lang.Number, ? super T, ? extends java.lang.Number> callbackfn) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callbackfn, "callbackfn");
        int size = size();
        io.dcloud.uts.UTSArray uTSArray = new io.dcloud.uts.UTSArray();
        for (int i = 0; i < size; i++) {
            java.lang.Number auto = getAuto(i);
            java.lang.Integer numValueOf = java.lang.Integer.valueOf(i);
            kotlin.jvm.internal.Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of io.dcloud.uts.Uint8ClampedArray.map");
            uTSArray.add(java.lang.Integer.valueOf(callbackfn.invoke(auto, numValueOf, this).intValue()));
        }
        return new io.dcloud.uts.Uint8ClampedArray(uTSArray);
    }

    @Override // io.dcloud.uts.Uint8Array, io.dcloud.uts.TypedArray
    public io.dcloud.uts.Uint8ClampedArray slice(java.lang.Number start, java.lang.Number end) {
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
        return new io.dcloud.uts.Uint8ClampedArray(uTSArray);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0031  */
    /* JADX WARN: Code duplicated, block: B:8:0x001a  */
    @Override // io.dcloud.uts.Uint8Array, io.dcloud.uts.TypedArray
    public io.dcloud.uts.Uint8ClampedArray subarray(java.lang.Number begin, java.lang.Number end) {
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
        return new io.dcloud.uts.Uint8ClampedArray(uTSArray);
    }
}
