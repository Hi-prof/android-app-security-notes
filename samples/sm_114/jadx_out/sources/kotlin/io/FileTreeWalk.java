package kotlin.io;

/* JADX INFO: compiled from: FileTreeWalk.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010(\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001b\u001c\u001dB\u008b\u0001\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007\u00128\u0010\u000b\u001a4\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\n\u0018\u00010\f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015B\u001b\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0014\u0010\u0016J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0018H\u0096\u0002J\u001a\u0010\u0006\u001a\u00020\u00002\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007J\u001a\u0010\t\u001a\u00020\u00002\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\u0007J \u0010\u000b\u001a\u00020\u00002\u0018\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\n0\fJ\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0013R\u000e\u0010\u0003\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R@\u0010\u000b\u001a4\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\n\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lkotlin/io/FileTreeWalk;", "Lkotlin/sequences/Sequence;", "Ljava/io/File;", "start", "direction", "Lkotlin/io/FileWalkDirection;", "onEnter", "Lkotlin/Function1;", "", "onLeave", "", "onFail", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "f", "Ljava/io/IOException;", "e", "maxDepth", "", "<init>", "(Ljava/io/File;Lkotlin/io/FileWalkDirection;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;I)V", "(Ljava/io/File;Lkotlin/io/FileWalkDirection;)V", "iterator", "", "function", "depth", "WalkState", "DirectoryState", "FileTreeWalkIterator", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FileTreeWalk implements kotlin.sequences.Sequence<java.io.File> {
    private final kotlin.io.FileWalkDirection direction;
    private final int maxDepth;
    private final kotlin.jvm.functions.Function1<java.io.File, java.lang.Boolean> onEnter;
    private final kotlin.jvm.functions.Function2<java.io.File, java.io.IOException, kotlin.Unit> onFail;
    private final kotlin.jvm.functions.Function1<java.io.File, kotlin.Unit> onLeave;
    private final java.io.File start;

    /* JADX WARN: Multi-variable type inference failed */
    private FileTreeWalk(java.io.File file, kotlin.io.FileWalkDirection fileWalkDirection, kotlin.jvm.functions.Function1<? super java.io.File, java.lang.Boolean> function1, kotlin.jvm.functions.Function1<? super java.io.File, kotlin.Unit> function2, kotlin.jvm.functions.Function2<? super java.io.File, ? super java.io.IOException, kotlin.Unit> function3, int i) {
        this.start = file;
        this.direction = fileWalkDirection;
        this.onEnter = function1;
        this.onLeave = function2;
        this.onFail = function3;
        this.maxDepth = i;
    }

    /* synthetic */ FileTreeWalk(java.io.File file, kotlin.io.FileWalkDirection fileWalkDirection, kotlin.jvm.functions.Function1 function1, kotlin.jvm.functions.Function1 function2, kotlin.jvm.functions.Function2 function3, int i, int i2, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(file, (i2 & 2) != 0 ? kotlin.io.FileWalkDirection.TOP_DOWN : fileWalkDirection, function1, function2, function3, (i2 & 32) != 0 ? Integer.MAX_VALUE : i);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FileTreeWalk(java.io.File start, kotlin.io.FileWalkDirection direction) {
        this(start, direction, null, null, null, 0, 32, null);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(start, "start");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(direction, "direction");
    }

    public /* synthetic */ FileTreeWalk(java.io.File file, kotlin.io.FileWalkDirection fileWalkDirection, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(file, (i & 2) != 0 ? kotlin.io.FileWalkDirection.TOP_DOWN : fileWalkDirection);
    }

    @Override // kotlin.sequences.Sequence
    public java.util.Iterator<java.io.File> iterator() {
        return new kotlin.io.FileTreeWalk.FileTreeWalkIterator();
    }

    /* JADX INFO: compiled from: FileTreeWalk.kt */
    @kotlin.Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\"\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\b\u001a\u0004\u0018\u00010\u0003H&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lkotlin/io/FileTreeWalk$WalkState;", "", "root", "Ljava/io/File;", "<init>", "(Ljava/io/File;)V", "getRoot", "()Ljava/io/File;", "step", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static abstract class WalkState {
        private final java.io.File root;

        public abstract java.io.File step();

        public WalkState(java.io.File root) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(root, "root");
            this.root = root;
        }

        public final java.io.File getRoot() {
            return this.root;
        }
    }

    /* JADX INFO: compiled from: FileTreeWalk.kt */
    @kotlin.Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\"\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lkotlin/io/FileTreeWalk$DirectoryState;", "Lkotlin/io/FileTreeWalk$WalkState;", "rootDir", "Ljava/io/File;", "<init>", "(Ljava/io/File;)V", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static abstract class DirectoryState extends kotlin.io.FileTreeWalk.WalkState {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DirectoryState(java.io.File rootDir) {
            super(rootDir);
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(rootDir, "rootDir");
        }
    }

    /* JADX INFO: compiled from: FileTreeWalk.kt */
    @kotlin.Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u000e\u000f\u0010B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\b\u001a\u00020\tH\u0014J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0002H\u0002J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0082\u0010R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lkotlin/io/FileTreeWalk$FileTreeWalkIterator;", "Lkotlin/collections/AbstractIterator;", "Ljava/io/File;", "<init>", "(Lkotlin/io/FileTreeWalk;)V", "state", "Ljava/util/ArrayDeque;", "Lkotlin/io/FileTreeWalk$WalkState;", "computeNext", "", "directoryState", "Lkotlin/io/FileTreeWalk$DirectoryState;", "root", "gotoNext", "BottomUpDirectoryState", "TopDownDirectoryState", "SingleFileState", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private final class FileTreeWalkIterator extends kotlin.collections.AbstractIterator<java.io.File> {
        private final java.util.ArrayDeque<kotlin.io.FileTreeWalk.WalkState> state;

        /* JADX INFO: compiled from: FileTreeWalk.kt */
        @kotlin.Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[kotlin.io.FileWalkDirection.values().length];
                try {
                    iArr[kotlin.io.FileWalkDirection.TOP_DOWN.ordinal()] = 1;
                } catch (java.lang.NoSuchFieldError unused) {
                }
                try {
                    iArr[kotlin.io.FileWalkDirection.BOTTOM_UP.ordinal()] = 2;
                } catch (java.lang.NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public FileTreeWalkIterator() {
            java.util.ArrayDeque<kotlin.io.FileTreeWalk.WalkState> arrayDeque = new java.util.ArrayDeque<>();
            this.state = arrayDeque;
            if (kotlin.io.FileTreeWalk.this.start.isDirectory()) {
                arrayDeque.push(directoryState(kotlin.io.FileTreeWalk.this.start));
            } else if (kotlin.io.FileTreeWalk.this.start.isFile()) {
                arrayDeque.push(new kotlin.io.FileTreeWalk.FileTreeWalkIterator.SingleFileState(this, kotlin.io.FileTreeWalk.this.start));
            } else {
                done();
            }
        }

        @Override // kotlin.collections.AbstractIterator
        protected void computeNext() {
            java.io.File fileGotoNext = gotoNext();
            if (fileGotoNext != null) {
                setNext(fileGotoNext);
            } else {
                done();
            }
        }

        private final kotlin.io.FileTreeWalk.DirectoryState directoryState(java.io.File root) {
            int i = kotlin.io.FileTreeWalk.FileTreeWalkIterator.WhenMappings.$EnumSwitchMapping$0[kotlin.io.FileTreeWalk.this.direction.ordinal()];
            if (i == 1) {
                return new kotlin.io.FileTreeWalk.FileTreeWalkIterator.TopDownDirectoryState(this, root);
            }
            if (i != 2) {
                throw new kotlin.NoWhenBranchMatchedException();
            }
            return new kotlin.io.FileTreeWalk.FileTreeWalkIterator.BottomUpDirectoryState(this, root);
        }

        private final java.io.File gotoNext() {
            while (true) {
                kotlin.io.FileTreeWalk.WalkState walkStatePeek = this.state.peek();
                if (walkStatePeek == null) {
                    return null;
                }
                java.io.File fileStep = walkStatePeek.step();
                if (fileStep == null) {
                    this.state.pop();
                } else {
                    if (kotlin.jvm.internal.Intrinsics.areEqual(fileStep, walkStatePeek.getRoot()) || !fileStep.isDirectory() || this.state.size() >= kotlin.io.FileTreeWalk.this.maxDepth) {
                        return fileStep;
                    }
                    this.state.push(directoryState(fileStep));
                }
            }
        }

        /* JADX INFO: compiled from: FileTreeWalk.kt */
        @kotlin.Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lkotlin/io/FileTreeWalk$FileTreeWalkIterator$BottomUpDirectoryState;", "Lkotlin/io/FileTreeWalk$DirectoryState;", "rootDir", "Ljava/io/File;", "<init>", "(Lkotlin/io/FileTreeWalk$FileTreeWalkIterator;Ljava/io/File;)V", "rootVisited", "", "fileList", "", "[Ljava/io/File;", "fileIndex", "", io.dcloud.common.constant.AbsoluteConst.EVENTS_FAILED, "step", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
        private final class BottomUpDirectoryState extends kotlin.io.FileTreeWalk.DirectoryState {
            private boolean failed;
            private int fileIndex;
            private java.io.File[] fileList;
            private boolean rootVisited;
            final /* synthetic */ kotlin.io.FileTreeWalk.FileTreeWalkIterator this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public BottomUpDirectoryState(kotlin.io.FileTreeWalk.FileTreeWalkIterator fileTreeWalkIterator, java.io.File rootDir) {
                super(rootDir);
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(rootDir, "rootDir");
                this.this$0 = fileTreeWalkIterator;
            }

            @Override // kotlin.io.FileTreeWalk.WalkState
            public java.io.File step() {
                if (!this.failed && this.fileList == null) {
                    kotlin.jvm.functions.Function1 function1 = kotlin.io.FileTreeWalk.this.onEnter;
                    if (function1 != null && !((java.lang.Boolean) function1.invoke(getRoot())).booleanValue()) {
                        return null;
                    }
                    java.io.File[] fileArrListFiles = getRoot().listFiles();
                    this.fileList = fileArrListFiles;
                    if (fileArrListFiles == null) {
                        kotlin.jvm.functions.Function2 function2 = kotlin.io.FileTreeWalk.this.onFail;
                        if (function2 != null) {
                            function2.invoke(getRoot(), new kotlin.io.AccessDeniedException(getRoot(), null, "Cannot list files in a directory", 2, null));
                        }
                        this.failed = true;
                    }
                }
                java.io.File[] fileArr = this.fileList;
                if (fileArr != null) {
                    int i = this.fileIndex;
                    kotlin.jvm.internal.Intrinsics.checkNotNull(fileArr);
                    if (i < fileArr.length) {
                        java.io.File[] fileArr2 = this.fileList;
                        kotlin.jvm.internal.Intrinsics.checkNotNull(fileArr2);
                        int i2 = this.fileIndex;
                        this.fileIndex = i2 + 1;
                        return fileArr2[i2];
                    }
                }
                if (this.rootVisited) {
                    kotlin.jvm.functions.Function1 function3 = kotlin.io.FileTreeWalk.this.onLeave;
                    if (function3 != null) {
                        function3.invoke(getRoot());
                    }
                    return null;
                }
                this.rootVisited = true;
                return getRoot();
            }
        }

        /* JADX INFO: compiled from: FileTreeWalk.kt */
        @kotlin.Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\r\u001a\u0004\u0018\u00010\u0003H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkotlin/io/FileTreeWalk$FileTreeWalkIterator$TopDownDirectoryState;", "Lkotlin/io/FileTreeWalk$DirectoryState;", "rootDir", "Ljava/io/File;", "<init>", "(Lkotlin/io/FileTreeWalk$FileTreeWalkIterator;Ljava/io/File;)V", "rootVisited", "", "fileList", "", "[Ljava/io/File;", "fileIndex", "", "step", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
        private final class TopDownDirectoryState extends kotlin.io.FileTreeWalk.DirectoryState {
            private int fileIndex;
            private java.io.File[] fileList;
            private boolean rootVisited;
            final /* synthetic */ kotlin.io.FileTreeWalk.FileTreeWalkIterator this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public TopDownDirectoryState(kotlin.io.FileTreeWalk.FileTreeWalkIterator fileTreeWalkIterator, java.io.File rootDir) {
                super(rootDir);
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(rootDir, "rootDir");
                this.this$0 = fileTreeWalkIterator;
            }

            /* JADX WARN: Code restructure failed: missing block: B:30:0x007e, code lost:
            
                if (r0.length == 0) goto L31;
             */
            @Override // kotlin.io.FileTreeWalk.WalkState
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public java.io.File step() {
                /*
                    r9 = this;
                    boolean r0 = r9.rootVisited
                    r1 = 0
                    if (r0 != 0) goto L28
                    kotlin.io.FileTreeWalk$FileTreeWalkIterator r0 = r9.this$0
                    kotlin.io.FileTreeWalk r0 = kotlin.io.FileTreeWalk.this
                    kotlin.jvm.functions.Function1 r0 = kotlin.io.FileTreeWalk.access$getOnEnter$p(r0)
                    if (r0 == 0) goto L20
                    java.io.File r2 = r9.getRoot()
                    java.lang.Object r0 = r0.invoke(r2)
                    java.lang.Boolean r0 = (java.lang.Boolean) r0
                    boolean r0 = r0.booleanValue()
                    if (r0 != 0) goto L20
                    return r1
                L20:
                    r0 = 1
                    r9.rootVisited = r0
                    java.io.File r0 = r9.getRoot()
                    return r0
                L28:
                    java.io.File[] r0 = r9.fileList
                    if (r0 == 0) goto L47
                    int r2 = r9.fileIndex
                    kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
                    int r0 = r0.length
                    if (r2 >= r0) goto L35
                    goto L47
                L35:
                    kotlin.io.FileTreeWalk$FileTreeWalkIterator r0 = r9.this$0
                    kotlin.io.FileTreeWalk r0 = kotlin.io.FileTreeWalk.this
                    kotlin.jvm.functions.Function1 r0 = kotlin.io.FileTreeWalk.access$getOnLeave$p(r0)
                    if (r0 == 0) goto L46
                    java.io.File r2 = r9.getRoot()
                    r0.invoke(r2)
                L46:
                    return r1
                L47:
                    java.io.File[] r0 = r9.fileList
                    if (r0 != 0) goto L92
                    java.io.File r0 = r9.getRoot()
                    java.io.File[] r0 = r0.listFiles()
                    r9.fileList = r0
                    if (r0 != 0) goto L76
                    kotlin.io.FileTreeWalk$FileTreeWalkIterator r0 = r9.this$0
                    kotlin.io.FileTreeWalk r0 = kotlin.io.FileTreeWalk.this
                    kotlin.jvm.functions.Function2 r0 = kotlin.io.FileTreeWalk.access$getOnFail$p(r0)
                    if (r0 == 0) goto L76
                    java.io.File r2 = r9.getRoot()
                    kotlin.io.AccessDeniedException r3 = new kotlin.io.AccessDeniedException
                    java.io.File r4 = r9.getRoot()
                    r7 = 2
                    r8 = 0
                    r5 = 0
                    java.lang.String r6 = "Cannot list files in a directory"
                    r3.<init>(r4, r5, r6, r7, r8)
                    r0.invoke(r2, r3)
                L76:
                    java.io.File[] r0 = r9.fileList
                    if (r0 == 0) goto L80
                    kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
                    int r0 = r0.length
                    if (r0 != 0) goto L92
                L80:
                    kotlin.io.FileTreeWalk$FileTreeWalkIterator r0 = r9.this$0
                    kotlin.io.FileTreeWalk r0 = kotlin.io.FileTreeWalk.this
                    kotlin.jvm.functions.Function1 r0 = kotlin.io.FileTreeWalk.access$getOnLeave$p(r0)
                    if (r0 == 0) goto L91
                    java.io.File r2 = r9.getRoot()
                    r0.invoke(r2)
                L91:
                    return r1
                L92:
                    java.io.File[] r0 = r9.fileList
                    kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
                    int r1 = r9.fileIndex
                    int r2 = r1 + 1
                    r9.fileIndex = r2
                    r0 = r0[r1]
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.io.FileTreeWalk.FileTreeWalkIterator.TopDownDirectoryState.step():java.io.File");
            }
        }

        /* JADX INFO: compiled from: FileTreeWalk.kt */
        @kotlin.Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lkotlin/io/FileTreeWalk$FileTreeWalkIterator$SingleFileState;", "Lkotlin/io/FileTreeWalk$WalkState;", "rootFile", "Ljava/io/File;", "<init>", "(Lkotlin/io/FileTreeWalk$FileTreeWalkIterator;Ljava/io/File;)V", "visited", "", "step", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
        private final class SingleFileState extends kotlin.io.FileTreeWalk.WalkState {
            final /* synthetic */ kotlin.io.FileTreeWalk.FileTreeWalkIterator this$0;
            private boolean visited;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SingleFileState(kotlin.io.FileTreeWalk.FileTreeWalkIterator fileTreeWalkIterator, java.io.File rootFile) {
                super(rootFile);
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(rootFile, "rootFile");
                this.this$0 = fileTreeWalkIterator;
            }

            @Override // kotlin.io.FileTreeWalk.WalkState
            public java.io.File step() {
                if (this.visited) {
                    return null;
                }
                this.visited = true;
                return getRoot();
            }
        }
    }

    public final kotlin.io.FileTreeWalk onEnter(kotlin.jvm.functions.Function1<? super java.io.File, java.lang.Boolean> function) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(function, "function");
        return new kotlin.io.FileTreeWalk(this.start, this.direction, function, this.onLeave, this.onFail, this.maxDepth);
    }

    public final kotlin.io.FileTreeWalk onLeave(kotlin.jvm.functions.Function1<? super java.io.File, kotlin.Unit> function) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(function, "function");
        return new kotlin.io.FileTreeWalk(this.start, this.direction, this.onEnter, function, this.onFail, this.maxDepth);
    }

    public final kotlin.io.FileTreeWalk onFail(kotlin.jvm.functions.Function2<? super java.io.File, ? super java.io.IOException, kotlin.Unit> function) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(function, "function");
        return new kotlin.io.FileTreeWalk(this.start, this.direction, this.onEnter, this.onLeave, function, this.maxDepth);
    }

    public final kotlin.io.FileTreeWalk maxDepth(int depth) {
        if (depth <= 0) {
            throw new java.lang.IllegalArgumentException("depth must be positive, but was " + depth + com.taobao.weex.el.parse.Operators.DOT);
        }
        return new kotlin.io.FileTreeWalk(this.start, this.direction, this.onEnter, this.onLeave, this.onFail, depth);
    }
}
