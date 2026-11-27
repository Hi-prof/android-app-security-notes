package kotlin.io.path;

/* JADX INFO: compiled from: PathTreeWalk.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010(\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0016H\u0096\u0002JB\u0010\u0017\u001a\u00020\u0018*\b\u0012\u0004\u0012\u00020\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0018\u0010\u001e\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0 \u0012\u0004\u0012\u00020\u00180\u001fH\u0082H¢\u0006\u0002\u0010!J\u000e\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020\u0016H\u0002J\u000e\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00020\u0016H\u0002R\u000e\u0010\u0003\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\rR\u0014\u0010\u0014\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\r¨\u0006$"}, d2 = {"Lkotlin/io/path/PathTreeWalk;", "Lkotlin/sequences/Sequence;", "Ljava/nio/file/Path;", "start", "options", "", "Lkotlin/io/path/PathWalkOption;", "<init>", "(Ljava/nio/file/Path;[Lkotlin/io/path/PathWalkOption;)V", "[Lkotlin/io/path/PathWalkOption;", "followLinks", "", "getFollowLinks", "()Z", "linkOptions", "Ljava/nio/file/LinkOption;", "getLinkOptions", "()[Ljava/nio/file/LinkOption;", "includeDirectories", "getIncludeDirectories", "isBFS", "iterator", "", "yieldIfNeeded", "", "Lkotlin/sequences/SequenceScope;", "node", "Lkotlin/io/path/PathNode;", "entriesReader", "Lkotlin/io/path/DirectoryEntriesReader;", "entriesAction", "Lkotlin/Function1;", "", "(Lkotlin/sequences/SequenceScope;Lkotlin/io/path/PathNode;Lkotlin/io/path/DirectoryEntriesReader;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dfsIterator", "bfsIterator", "kotlin-stdlib-jdk7"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PathTreeWalk implements kotlin.sequences.Sequence<java.nio.file.Path> {
    private final kotlin.io.path.PathWalkOption[] options;
    private final java.nio.file.Path start;

    public PathTreeWalk(java.nio.file.Path start, kotlin.io.path.PathWalkOption[] options) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(start, "start");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(options, "options");
        this.start = start;
        this.options = options;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getFollowLinks() {
        return kotlin.collections.ArraysKt.contains(this.options, kotlin.io.path.PathWalkOption.FOLLOW_LINKS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final java.nio.file.LinkOption[] getLinkOptions() {
        return kotlin.io.path.LinkFollowing.INSTANCE.toLinkOptions(getFollowLinks());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getIncludeDirectories() {
        return kotlin.collections.ArraysKt.contains(this.options, kotlin.io.path.PathWalkOption.INCLUDE_DIRECTORIES);
    }

    private final boolean isBFS() {
        return kotlin.collections.ArraysKt.contains(this.options, kotlin.io.path.PathWalkOption.BREADTH_FIRST);
    }

    @Override // kotlin.sequences.Sequence
    public java.util.Iterator<java.nio.file.Path> iterator() {
        return isBFS() ? bfsIterator() : dfsIterator();
    }

    private final java.lang.Object yieldIfNeeded(kotlin.sequences.SequenceScope<? super java.nio.file.Path> sequenceScope, kotlin.io.path.PathNode pathNode, kotlin.io.path.DirectoryEntriesReader directoryEntriesReader, kotlin.jvm.functions.Function1<? super java.util.List<kotlin.io.path.PathNode>, kotlin.Unit> function1, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) throws java.nio.file.FileSystemLoopException {
        java.nio.file.Path path = pathNode.getPath();
        if (pathNode.getParent() != null) {
            kotlin.io.path.PathsKt.checkFileName(path);
        }
        java.nio.file.LinkOption[] linkOptions = getLinkOptions();
        java.nio.file.LinkOption[] linkOptionArr = (java.nio.file.LinkOption[]) java.util.Arrays.copyOf(linkOptions, linkOptions.length);
        if (java.nio.file.Files.isDirectory(path, (java.nio.file.LinkOption[]) java.util.Arrays.copyOf(linkOptionArr, linkOptionArr.length))) {
            if (!kotlin.io.path.PathTreeWalkKt.createsCycle(pathNode)) {
                if (getIncludeDirectories()) {
                    sequenceScope.yield(path, continuation);
                }
                java.nio.file.LinkOption[] linkOptions2 = getLinkOptions();
                java.nio.file.LinkOption[] linkOptionArr2 = (java.nio.file.LinkOption[]) java.util.Arrays.copyOf(linkOptions2, linkOptions2.length);
                if (java.nio.file.Files.isDirectory(path, (java.nio.file.LinkOption[]) java.util.Arrays.copyOf(linkOptionArr2, linkOptionArr2.length))) {
                    function1.invoke2(directoryEntriesReader.readEntries(pathNode));
                }
            } else {
                io.dcloud.p.g4$$ExternalSyntheticApiModelOutline0.m$6();
                throw io.dcloud.p.g4$$ExternalSyntheticApiModelOutline0.m457m(path.toString());
            }
        } else if (java.nio.file.Files.exists(path, (java.nio.file.LinkOption[]) java.util.Arrays.copyOf(new java.nio.file.LinkOption[]{java.nio.file.LinkOption.NOFOLLOW_LINKS}, 1))) {
            sequenceScope.yield(path, continuation);
            return kotlin.Unit.INSTANCE;
        }
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: kotlin.io.path.PathTreeWalk$dfsIterator$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PathTreeWalk.kt */
    @kotlin.Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Ljava/nio/file/Path;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @kotlin.coroutines.jvm.internal.DebugMetadata(c = "kotlin.io.path.PathTreeWalk$dfsIterator$1", f = "PathTreeWalk.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {191, 197, 210, com.facebook.imageutils.JfifUtil.MARKER_SOI}, m = "invokeSuspend", n = {"$this$iterator", "stack", "entriesReader", "startNode", "this_$iv", "$this$yieldIfNeeded$iv", "path$iv", "$i$f$yieldIfNeeded", "$this$iterator", "stack", "entriesReader", "startNode", "this_$iv", "$this$yieldIfNeeded$iv", "path$iv", "$i$f$yieldIfNeeded", "$this$iterator", "stack", "entriesReader", "startNode", "topNode", "topIterator", "pathNode", "this_$iv", "$this$yieldIfNeeded$iv", "path$iv", "$i$f$yieldIfNeeded", "$this$iterator", "stack", "entriesReader", "startNode", "topNode", "topIterator", "pathNode", "this_$iv", "$this$yieldIfNeeded$iv", "path$iv", "$i$f$yieldIfNeeded"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "I$0"})
    static final class C01191 extends kotlin.coroutines.jvm.internal.RestrictedSuspendLambda implements kotlin.jvm.functions.Function2<kotlin.sequences.SequenceScope<? super java.nio.file.Path>, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> {
        int I$0;
        private /* synthetic */ java.lang.Object L$0;
        java.lang.Object L$1;
        java.lang.Object L$2;
        java.lang.Object L$3;
        java.lang.Object L$4;
        java.lang.Object L$5;
        java.lang.Object L$6;
        java.lang.Object L$7;
        java.lang.Object L$8;
        java.lang.Object L$9;
        int label;

        C01191(kotlin.coroutines.Continuation<? super kotlin.io.path.PathTreeWalk.C01191> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.Continuation<kotlin.Unit> create(java.lang.Object obj, kotlin.coroutines.Continuation<?> continuation) {
            kotlin.io.path.PathTreeWalk.C01191 c01191 = kotlin.io.path.PathTreeWalk.this.new C01191(continuation);
            c01191.L$0 = obj;
            return c01191;
        }

        @Override // kotlin.jvm.functions.Function2
        public final java.lang.Object invoke(kotlin.sequences.SequenceScope<? super java.nio.file.Path> sequenceScope, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
            return ((kotlin.io.path.PathTreeWalk.C01191) create(sequenceScope, continuation)).invokeSuspend(kotlin.Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:42:0x01c2  */
        /* JADX WARN: Code duplicated, block: B:44:0x01d5  */
        /* JADX WARN: Code duplicated, block: B:46:0x01e7  */
        /* JADX WARN: Code duplicated, block: B:49:0x0202  */
        /* JADX WARN: Code duplicated, block: B:51:0x0208  */
        /* JADX WARN: Code duplicated, block: B:53:0x020e  */
        /* JADX WARN: Code duplicated, block: B:56:0x0241  */
        /* JADX WARN: Code duplicated, block: B:58:0x024f A[PHI: r3 r6 r9 r12 r13 r14
  0x024f: PHI (r3v8 kotlin.io.path.PathNode) = (r3v10 kotlin.io.path.PathNode), (r3v11 kotlin.io.path.PathNode) binds: [B:57:0x0248, B:52:0x020c] A[DONT_GENERATE, DONT_INLINE]
  0x024f: PHI (r6v18 kotlin.io.path.DirectoryEntriesReader) = (r6v20 kotlin.io.path.DirectoryEntriesReader), (r6v21 kotlin.io.path.DirectoryEntriesReader) binds: [B:57:0x0248, B:52:0x020c] A[DONT_GENERATE, DONT_INLINE]
  0x024f: PHI (r9v6 kotlin.collections.ArrayDeque) = (r9v8 kotlin.collections.ArrayDeque), (r9v9 kotlin.collections.ArrayDeque) binds: [B:57:0x0248, B:52:0x020c] A[DONT_GENERATE, DONT_INLINE]
  0x024f: PHI (r12v6 kotlin.io.path.PathNode) = (r12v8 kotlin.io.path.PathNode), (r12v11 kotlin.io.path.PathNode) binds: [B:57:0x0248, B:52:0x020c] A[DONT_GENERATE, DONT_INLINE]
  0x024f: PHI (r13v17 kotlin.io.path.PathTreeWalk) = (r13v19 kotlin.io.path.PathTreeWalk), (r13v20 kotlin.io.path.PathTreeWalk) binds: [B:57:0x0248, B:52:0x020c] A[DONT_GENERATE, DONT_INLINE]
  0x024f: PHI (r14v4 java.nio.file.Path) = (r14v5 java.nio.file.Path), (r14v6 java.nio.file.Path) binds: [B:57:0x0248, B:52:0x020c] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:60:0x0267  */
        /* JADX WARN: Code duplicated, block: B:61:0x0276  */
        /* JADX WARN: Code duplicated, block: B:63:0x0282  */
        /* JADX WARN: Code duplicated, block: B:65:0x0296  */
        /* JADX WARN: Code duplicated, block: B:69:0x02d8  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x0265 -> B:68:0x02d5). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x0267 -> B:68:0x02d5). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:64:0x0294 -> B:9:0x0043). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:66:0x02d2 -> B:68:0x02d5). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:69:0x02d8 -> B:68:0x02d5). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:42:0x01c2
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r17) {
            /*
                Method dump skipped, instruction units count: 736
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.io.path.PathTreeWalk.C01191.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private final java.util.Iterator<java.nio.file.Path> dfsIterator() {
        return kotlin.sequences.SequencesKt.iterator(new kotlin.io.path.PathTreeWalk.C01191(null));
    }

    /* JADX INFO: renamed from: kotlin.io.path.PathTreeWalk$bfsIterator$1, reason: invalid class name */
    /* JADX INFO: compiled from: PathTreeWalk.kt */
    @kotlin.Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Ljava/nio/file/Path;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @kotlin.coroutines.jvm.internal.DebugMetadata(c = "kotlin.io.path.PathTreeWalk$bfsIterator$1", f = "PathTreeWalk.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, l = {191, 197}, m = "invokeSuspend", n = {"$this$iterator", "queue", "entriesReader", "pathNode", "this_$iv", "$this$yieldIfNeeded$iv", "path$iv", "$i$f$yieldIfNeeded", "$this$iterator", "queue", "entriesReader", "pathNode", "this_$iv", "$this$yieldIfNeeded$iv", "path$iv", "$i$f$yieldIfNeeded"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0"})
    static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.RestrictedSuspendLambda implements kotlin.jvm.functions.Function2<kotlin.sequences.SequenceScope<? super java.nio.file.Path>, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> {
        int I$0;
        private /* synthetic */ java.lang.Object L$0;
        java.lang.Object L$1;
        java.lang.Object L$2;
        java.lang.Object L$3;
        java.lang.Object L$4;
        java.lang.Object L$5;
        java.lang.Object L$6;
        int label;

        AnonymousClass1(kotlin.coroutines.Continuation<? super kotlin.io.path.PathTreeWalk.AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.Continuation<kotlin.Unit> create(java.lang.Object obj, kotlin.coroutines.Continuation<?> continuation) {
            kotlin.io.path.PathTreeWalk.AnonymousClass1 anonymousClass1 = kotlin.io.path.PathTreeWalk.this.new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final java.lang.Object invoke(kotlin.sequences.SequenceScope<? super java.nio.file.Path> sequenceScope, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
            return ((kotlin.io.path.PathTreeWalk.AnonymousClass1) create(sequenceScope, continuation)).invokeSuspend(kotlin.Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:13:0x0092  */
        /* JADX WARN: Code duplicated, block: B:15:0x00a5  */
        /* JADX WARN: Code duplicated, block: B:20:0x00c7  */
        /* JADX WARN: Code duplicated, block: B:22:0x00cd  */
        /* JADX WARN: Code duplicated, block: B:25:0x00ee  */
        /* JADX WARN: Code duplicated, block: B:29:0x0110  */
        /* JADX WARN: Code duplicated, block: B:30:0x011b  */
        /* JADX WARN: Code duplicated, block: B:40:0x00c1 A[SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x010e -> B:11:0x0089). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0110 -> B:11:0x0089). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                Method dump skipped, instruction units count: 362
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.io.path.PathTreeWalk.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private final java.util.Iterator<java.nio.file.Path> bfsIterator() {
        return kotlin.sequences.SequencesKt.iterator(new kotlin.io.path.PathTreeWalk.AnonymousClass1(null));
    }
}
