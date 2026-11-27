package kotlin.sequences;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u001a.\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0014\b\u0004\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004H\u0087\bø\u0001\u0000\u001a\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0005\u001a+\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\t\"\u0002H\u0002¢\u0006\u0002\u0010\n\u001a!\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u000b\u001a\u0002H\u0002H\u0007¢\u0006\u0002\u0010\f\u001a\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\u0087\b\u001a\u0012\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002\u001a!\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001H\u0087\b\u001a2\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0004H\u0007\u001a\"\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0001\u001a)\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00120\u0001H\u0007¢\u0006\u0002\b\u0013\u001aC\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0014*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00140\u00050\u0015H\u0002¢\u0006\u0002\b\u0016\u001a@\u0010\u0017\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00140\u00190\u0018\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0014*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00140\u00180\u0001\u001a\u001e\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0007\u001a&\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u001cH\u0007\u001ab\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u001e\"\u0004\b\u0002\u0010\u00142\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0018\u0010 \u001a\u0014\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u001e0!2\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u0002H\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00140\u00050\u0015H\u0000\u001a\u001c\u0010#\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001\u001a&\u0010$\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020%2\u000e\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0004\u001a=\u0010$\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020%2\b\u0010'\u001a\u0004\u0018\u0001H\u00022\u0014\u0010&\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0015H\u0007¢\u0006\u0002\u0010(\u001a<\u0010$\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020%2\u000e\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u00042\u0014\u0010&\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0015\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006*"}, d2 = {"Sequence", "Lkotlin/sequences/Sequence;", "T", "iterator", "Lkotlin/Function0;", "", "asSequence", "sequenceOf", "elements", "", "([Ljava/lang/Object;)Lkotlin/sequences/Sequence;", com.alibaba.android.bindingx.core.internal.BindingXConstants.KEY_ELEMENT, "(Ljava/lang/Object;)Lkotlin/sequences/Sequence;", "emptySequence", "orEmpty", "ifEmpty", "defaultValue", "flatten", "", "flattenSequenceOfIterable", "R", "Lkotlin/Function1;", "flatten$SequencesKt__SequencesKt", "unzip", "Lkotlin/Pair;", "", "shuffled", "random", "Lkotlin/random/Random;", "flatMapIndexed", "C", "source", "transform", "Lkotlin/Function2;", "", "constrainOnce", "generateSequence", "", "nextFunction", "seed", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;", "seedFunction", "kotlin-stdlib"}, k = 5, mv = {2, 2, 0}, xi = 49, xs = "kotlin/sequences/SequencesKt")
public class SequencesKt__SequencesKt extends kotlin.sequences.SequencesKt__SequencesJVMKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.Object flatten$lambda$4$SequencesKt__SequencesKt(java.lang.Object obj) {
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.Object generateSequence$lambda$6$SequencesKt__SequencesKt(java.lang.Object obj) {
        return obj;
    }

    private static final <T> kotlin.sequences.Sequence<T> Sequence(final kotlin.jvm.functions.Function0<? extends java.util.Iterator<? extends T>> iterator) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(iterator, "iterator");
        return new kotlin.sequences.Sequence<T>() { // from class: kotlin.sequences.SequencesKt__SequencesKt.Sequence.1
            @Override // kotlin.sequences.Sequence
            public java.util.Iterator<T> iterator() {
                return iterator.invoke();
            }
        };
    }

    public static final <T> kotlin.sequences.Sequence<T> asSequence(final java.util.Iterator<? extends T> it) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(it, "<this>");
        return kotlin.sequences.SequencesKt.constrainOnce(new kotlin.sequences.Sequence<T>() { // from class: kotlin.sequences.SequencesKt__SequencesKt$asSequence$$inlined$Sequence$1
            @Override // kotlin.sequences.Sequence
            public java.util.Iterator<T> iterator() {
                return it;
            }
        });
    }

    public static final <T> kotlin.sequences.Sequence<T> sequenceOf(T... elements) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(elements, "elements");
        return kotlin.collections.ArraysKt.asSequence(elements);
    }

    public static final <T> kotlin.sequences.Sequence<T> sequenceOf(final T t) {
        return new kotlin.sequences.Sequence<T>() { // from class: kotlin.sequences.SequencesKt__SequencesKt$sequenceOf$$inlined$Sequence$1
            @Override // kotlin.sequences.Sequence
            public java.util.Iterator<T> iterator() {
                return new kotlin.sequences.SequencesKt__SequencesKt$sequenceOf$1$1(t);
            }
        };
    }

    private static final <T> kotlin.sequences.Sequence<T> sequenceOf() {
        return kotlin.sequences.SequencesKt.emptySequence();
    }

    public static final <T> kotlin.sequences.Sequence<T> emptySequence() {
        return kotlin.sequences.EmptySequence.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> kotlin.sequences.Sequence<T> orEmpty(kotlin.sequences.Sequence<? extends T> sequence) {
        return sequence == 0 ? kotlin.sequences.SequencesKt.emptySequence() : sequence;
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: kotlin.sequences.SequencesKt__SequencesKt$ifEmpty$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Sequences.kt */
    @kotlin.Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "T", "Lkotlin/sequences/SequenceScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @kotlin.coroutines.jvm.internal.DebugMetadata(c = "kotlin.sequences.SequencesKt__SequencesKt$ifEmpty$1", f = "Sequences.kt", i = {0, 0, 1, 1}, l = {102, androidx.core.location.LocationRequestCompat.QUALITY_LOW_POWER}, m = "invokeSuspend", n = {"$this$sequence", "iterator", "$this$sequence", "iterator"}, s = {"L$0", "L$1", "L$0", "L$1"})
    static final class C01311<T> extends kotlin.coroutines.jvm.internal.RestrictedSuspendLambda implements kotlin.jvm.functions.Function2<kotlin.sequences.SequenceScope<? super T>, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> {
        final /* synthetic */ kotlin.jvm.functions.Function0<kotlin.sequences.Sequence<T>> $defaultValue;
        final /* synthetic */ kotlin.sequences.Sequence<T> $this_ifEmpty;
        private /* synthetic */ java.lang.Object L$0;
        java.lang.Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C01311(kotlin.sequences.Sequence<? extends T> sequence, kotlin.jvm.functions.Function0<? extends kotlin.sequences.Sequence<? extends T>> function0, kotlin.coroutines.Continuation<? super kotlin.sequences.SequencesKt__SequencesKt.C01311> continuation) {
            super(2, continuation);
            this.$this_ifEmpty = sequence;
            this.$defaultValue = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.Continuation<kotlin.Unit> create(java.lang.Object obj, kotlin.coroutines.Continuation<?> continuation) {
            kotlin.sequences.SequencesKt__SequencesKt.C01311 c01311 = new kotlin.sequences.SequencesKt__SequencesKt.C01311(this.$this_ifEmpty, this.$defaultValue, continuation);
            c01311.L$0 = obj;
            return c01311;
        }

        @Override // kotlin.jvm.functions.Function2
        public final java.lang.Object invoke(kotlin.sequences.SequenceScope<? super T> sequenceScope, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
            return ((kotlin.sequences.SequencesKt__SequencesKt.C01311) create(sequenceScope, continuation)).invokeSuspend(kotlin.Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0047, code lost:
        
            if (r0.yieldAll(r7, r6) == r1) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0067, code lost:
        
            if (r0.yieldAll(r6.$defaultValue.invoke(), r6) == r1) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0069, code lost:
        
            return r1;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = r6.L$0
                kotlin.sequences.SequenceScope r0 = (kotlin.sequences.SequenceScope) r0
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r6.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L23
                if (r2 == r4) goto L1b
                if (r2 != r3) goto L13
                goto L1b
            L13:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L1b:
                java.lang.Object r0 = r6.L$1
                java.util.Iterator r0 = (java.util.Iterator) r0
                kotlin.ResultKt.throwOnFailure(r7)
                goto L6a
            L23:
                kotlin.ResultKt.throwOnFailure(r7)
                kotlin.sequences.Sequence<T> r7 = r6.$this_ifEmpty
                java.util.Iterator r7 = r7.iterator()
                boolean r2 = r7.hasNext()
                if (r2 == 0) goto L4a
                r2 = r6
                kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
                r6.L$0 = r3
                java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
                r6.L$1 = r3
                r6.label = r4
                java.lang.Object r7 = r0.yieldAll(r7, r2)
                if (r7 != r1) goto L6a
                goto L69
            L4a:
                kotlin.jvm.functions.Function0<kotlin.sequences.Sequence<T>> r2 = r6.$defaultValue
                java.lang.Object r2 = r2.invoke()
                kotlin.sequences.Sequence r2 = (kotlin.sequences.Sequence) r2
                r4 = r6
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
                r6.L$0 = r5
                java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
                r6.L$1 = r7
                r6.label = r3
                java.lang.Object r7 = r0.yieldAll(r2, r4)
                if (r7 != r1) goto L6a
            L69:
                return r1
            L6a:
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.sequences.SequencesKt__SequencesKt.C01311.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final <T> kotlin.sequences.Sequence<T> ifEmpty(kotlin.sequences.Sequence<? extends T> sequence, kotlin.jvm.functions.Function0<? extends kotlin.sequences.Sequence<? extends T>> defaultValue) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return kotlin.sequences.SequencesKt.sequence(new kotlin.sequences.SequencesKt__SequencesKt.C01311(sequence, defaultValue, null));
    }

    public static final <T> kotlin.sequences.Sequence<T> flatten(kotlin.sequences.Sequence<? extends kotlin.sequences.Sequence<? extends T>> sequence) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sequence, "<this>");
        return flatten$SequencesKt__SequencesKt(sequence, new kotlin.jvm.functions.Function1() { // from class: kotlin.sequences.SequencesKt__SequencesKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final java.lang.Object invoke(java.lang.Object obj) {
                return kotlin.sequences.SequencesKt__SequencesKt.flatten$lambda$2$SequencesKt__SequencesKt((kotlin.sequences.Sequence) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.util.Iterator flatten$lambda$2$SequencesKt__SequencesKt(kotlin.sequences.Sequence it) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(it, "it");
        return it.iterator();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.util.Iterator flatten$lambda$3$SequencesKt__SequencesKt(java.lang.Iterable it) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(it, "it");
        return it.iterator();
    }

    public static final <T> kotlin.sequences.Sequence<T> flattenSequenceOfIterable(kotlin.sequences.Sequence<? extends java.lang.Iterable<? extends T>> sequence) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sequence, "<this>");
        return flatten$SequencesKt__SequencesKt(sequence, new kotlin.jvm.functions.Function1() { // from class: kotlin.sequences.SequencesKt__SequencesKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final java.lang.Object invoke(java.lang.Object obj) {
                return kotlin.sequences.SequencesKt__SequencesKt.flatten$lambda$3$SequencesKt__SequencesKt((java.lang.Iterable) obj);
            }
        });
    }

    private static final <T, R> kotlin.sequences.Sequence<R> flatten$SequencesKt__SequencesKt(kotlin.sequences.Sequence<? extends T> sequence, kotlin.jvm.functions.Function1<? super T, ? extends java.util.Iterator<? extends R>> function1) {
        if (sequence instanceof kotlin.sequences.TransformingSequence) {
            return ((kotlin.sequences.TransformingSequence) sequence).flatten$kotlin_stdlib(function1);
        }
        return new kotlin.sequences.FlatteningSequence(sequence, new kotlin.jvm.functions.Function1() { // from class: kotlin.sequences.SequencesKt__SequencesKt$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final java.lang.Object invoke(java.lang.Object obj) {
                return kotlin.sequences.SequencesKt__SequencesKt.flatten$lambda$4$SequencesKt__SequencesKt(obj);
            }
        }, function1);
    }

    public static final <T, R> kotlin.Pair<java.util.List<T>, java.util.List<R>> unzip(kotlin.sequences.Sequence<? extends kotlin.Pair<? extends T, ? extends R>> sequence) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sequence, "<this>");
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        for (kotlin.Pair<? extends T, ? extends R> pair : sequence) {
            arrayList.add(pair.getFirst());
            arrayList2.add(pair.getSecond());
        }
        return kotlin.TuplesKt.to(arrayList, arrayList2);
    }

    public static final <T> kotlin.sequences.Sequence<T> shuffled(kotlin.sequences.Sequence<? extends T> sequence) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sequence, "<this>");
        return kotlin.sequences.SequencesKt.shuffled(sequence, kotlin.random.Random.INSTANCE);
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: kotlin.sequences.SequencesKt__SequencesKt$shuffled$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Sequences.kt */
    @kotlin.Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "T", "Lkotlin/sequences/SequenceScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @kotlin.coroutines.jvm.internal.DebugMetadata(c = "kotlin.sequences.SequencesKt__SequencesKt$shuffled$1", f = "Sequences.kt", i = {0, 0, 0, 0, 0}, l = {com.alibaba.fastjson.asm.Opcodes.GETSTATIC}, m = "invokeSuspend", n = {"$this$sequence", "buffer", "last", "value", "j"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"})
    static final class C01321<T> extends kotlin.coroutines.jvm.internal.RestrictedSuspendLambda implements kotlin.jvm.functions.Function2<kotlin.sequences.SequenceScope<? super T>, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> {
        final /* synthetic */ kotlin.random.Random $random;
        final /* synthetic */ kotlin.sequences.Sequence<T> $this_shuffled;
        int I$0;
        private /* synthetic */ java.lang.Object L$0;
        java.lang.Object L$1;
        java.lang.Object L$2;
        java.lang.Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C01321(kotlin.sequences.Sequence<? extends T> sequence, kotlin.random.Random random, kotlin.coroutines.Continuation<? super kotlin.sequences.SequencesKt__SequencesKt.C01321> continuation) {
            super(2, continuation);
            this.$this_shuffled = sequence;
            this.$random = random;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.Continuation<kotlin.Unit> create(java.lang.Object obj, kotlin.coroutines.Continuation<?> continuation) {
            kotlin.sequences.SequencesKt__SequencesKt.C01321 c01321 = new kotlin.sequences.SequencesKt__SequencesKt.C01321(this.$this_shuffled, this.$random, continuation);
            c01321.L$0 = obj;
            return c01321;
        }

        @Override // kotlin.jvm.functions.Function2
        public final java.lang.Object invoke(kotlin.sequences.SequenceScope<? super T> sequenceScope, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
            return ((kotlin.sequences.SequencesKt__SequencesKt.C01321) create(sequenceScope, continuation)).invokeSuspend(kotlin.Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object obj) {
            java.util.List mutableList;
            kotlin.sequences.SequenceScope sequenceScope = (kotlin.sequences.SequenceScope) this.L$0;
            java.lang.Object coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                kotlin.ResultKt.throwOnFailure(obj);
                mutableList = kotlin.sequences.SequencesKt.toMutableList(this.$this_shuffled);
            } else {
                if (i != 1) {
                    throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableList = (java.util.List) this.L$1;
                kotlin.ResultKt.throwOnFailure(obj);
            }
            while (!mutableList.isEmpty()) {
                int iNextInt = this.$random.nextInt(mutableList.size());
                java.lang.Object objRemoveLast = kotlin.collections.CollectionsKt.removeLast(mutableList);
                java.lang.Object obj2 = iNextInt < mutableList.size() ? mutableList.set(iNextInt, objRemoveLast) : objRemoveLast;
                this.L$0 = sequenceScope;
                this.L$1 = mutableList;
                this.L$2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(objRemoveLast);
                this.L$3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(obj2);
                this.I$0 = iNextInt;
                this.label = 1;
                if (sequenceScope.yield(obj2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return kotlin.Unit.INSTANCE;
        }
    }

    public static final <T> kotlin.sequences.Sequence<T> shuffled(kotlin.sequences.Sequence<? extends T> sequence, kotlin.random.Random random) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(random, "random");
        return kotlin.sequences.SequencesKt.sequence(new kotlin.sequences.SequencesKt__SequencesKt.C01321(sequence, random, null));
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: kotlin.sequences.SequencesKt__SequencesKt$flatMapIndexed$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Sequences.kt */
    @kotlin.Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "R", "Lkotlin/sequences/SequenceScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @kotlin.coroutines.jvm.internal.DebugMetadata(c = "kotlin.sequences.SequencesKt__SequencesKt$flatMapIndexed$1", f = "Sequences.kt", i = {0, 0, 0, 0}, l = {383}, m = "invokeSuspend", n = {"$this$sequence", com.alibaba.android.bindingx.core.internal.BindingXConstants.KEY_ELEMENT, "result", "index"}, s = {"L$0", "L$2", "L$3", "I$0"})
    static final class C01301<R> extends kotlin.coroutines.jvm.internal.RestrictedSuspendLambda implements kotlin.jvm.functions.Function2<kotlin.sequences.SequenceScope<? super R>, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> {
        final /* synthetic */ kotlin.jvm.functions.Function1<C, java.util.Iterator<R>> $iterator;
        final /* synthetic */ kotlin.sequences.Sequence<T> $source;
        final /* synthetic */ kotlin.jvm.functions.Function2<java.lang.Integer, T, C> $transform;
        int I$0;
        private /* synthetic */ java.lang.Object L$0;
        java.lang.Object L$1;
        java.lang.Object L$2;
        java.lang.Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C01301(kotlin.sequences.Sequence<? extends T> sequence, kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super T, ? extends C> function2, kotlin.jvm.functions.Function1<? super C, ? extends java.util.Iterator<? extends R>> function1, kotlin.coroutines.Continuation<? super kotlin.sequences.SequencesKt__SequencesKt.C01301> continuation) {
            super(2, continuation);
            this.$source = sequence;
            this.$transform = function2;
            this.$iterator = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.Continuation<kotlin.Unit> create(java.lang.Object obj, kotlin.coroutines.Continuation<?> continuation) {
            kotlin.sequences.SequencesKt__SequencesKt.C01301 c01301 = new kotlin.sequences.SequencesKt__SequencesKt.C01301(this.$source, this.$transform, this.$iterator, continuation);
            c01301.L$0 = obj;
            return c01301;
        }

        @Override // kotlin.jvm.functions.Function2
        public final java.lang.Object invoke(kotlin.sequences.SequenceScope<? super R> sequenceScope, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
            return ((kotlin.sequences.SequencesKt__SequencesKt.C01301) create(sequenceScope, continuation)).invokeSuspend(kotlin.Unit.INSTANCE);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object obj) {
            int i;
            java.util.Iterator it;
            kotlin.sequences.SequenceScope sequenceScope = (kotlin.sequences.SequenceScope) this.L$0;
            java.lang.Object coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            if (i2 == 0) {
                kotlin.ResultKt.throwOnFailure(obj);
                i = 0;
                it = this.$source.iterator();
            } else {
                if (i2 != 1) {
                    throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i = this.I$0;
                it = (java.util.Iterator) this.L$1;
                kotlin.ResultKt.throwOnFailure(obj);
            }
            while (it.hasNext()) {
                java.lang.Object next = it.next();
                kotlin.jvm.functions.Function2<java.lang.Integer, T, C> function2 = this.$transform;
                int i3 = i + 1;
                if (i < 0) {
                    kotlin.collections.CollectionsKt.throwIndexOverflow();
                }
                java.lang.Object objInvoke = function2.invoke(kotlin.coroutines.jvm.internal.Boxing.boxInt(i), (T) next);
                this.L$0 = sequenceScope;
                this.L$1 = it;
                this.L$2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(next);
                this.L$3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(objInvoke);
                this.I$0 = i3;
                this.label = 1;
                if (sequenceScope.yieldAll(this.$iterator.invoke((C) objInvoke), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                i = i3;
            }
            return kotlin.Unit.INSTANCE;
        }
    }

    public static final <T, C, R> kotlin.sequences.Sequence<R> flatMapIndexed(kotlin.sequences.Sequence<? extends T> source, kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super T, ? extends C> transform, kotlin.jvm.functions.Function1<? super C, ? extends java.util.Iterator<? extends R>> iterator) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(source, "source");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(transform, "transform");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(iterator, "iterator");
        return kotlin.sequences.SequencesKt.sequence(new kotlin.sequences.SequencesKt__SequencesKt.C01301(source, transform, iterator, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> kotlin.sequences.Sequence<T> constrainOnce(kotlin.sequences.Sequence<? extends T> sequence) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sequence, "<this>");
        return sequence instanceof kotlin.sequences.ConstrainedOnceSequence ? sequence : new kotlin.sequences.ConstrainedOnceSequence(sequence);
    }

    public static final <T> kotlin.sequences.Sequence<T> generateSequence(final kotlin.jvm.functions.Function0<? extends T> nextFunction) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nextFunction, "nextFunction");
        return kotlin.sequences.SequencesKt.constrainOnce(new kotlin.sequences.GeneratorSequence(nextFunction, new kotlin.jvm.functions.Function1() { // from class: kotlin.sequences.SequencesKt__SequencesKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final java.lang.Object invoke(java.lang.Object obj) {
                return kotlin.sequences.SequencesKt__SequencesKt.generateSequence$lambda$5$SequencesKt__SequencesKt(nextFunction, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.Object generateSequence$lambda$5$SequencesKt__SequencesKt(kotlin.jvm.functions.Function0 function0, java.lang.Object it) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(it, "it");
        return function0.invoke();
    }

    public static final <T> kotlin.sequences.Sequence<T> generateSequence(final T t, kotlin.jvm.functions.Function1<? super T, ? extends T> nextFunction) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nextFunction, "nextFunction");
        if (t == null) {
            return kotlin.sequences.EmptySequence.INSTANCE;
        }
        return new kotlin.sequences.GeneratorSequence(new kotlin.jvm.functions.Function0() { // from class: kotlin.sequences.SequencesKt__SequencesKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final java.lang.Object invoke() {
                return kotlin.sequences.SequencesKt__SequencesKt.generateSequence$lambda$6$SequencesKt__SequencesKt(t);
            }
        }, nextFunction);
    }

    public static final <T> kotlin.sequences.Sequence<T> generateSequence(kotlin.jvm.functions.Function0<? extends T> seedFunction, kotlin.jvm.functions.Function1<? super T, ? extends T> nextFunction) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(seedFunction, "seedFunction");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nextFunction, "nextFunction");
        return new kotlin.sequences.GeneratorSequence(seedFunction, nextFunction);
    }
}
