package kotlin.io.path;

/* JADX INFO: compiled from: PathRecursiveFunctions.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class PathsKt__PathRecursiveFunctionsKt$copyToRecursively$5$3 extends kotlin.jvm.internal.FunctionReferenceImpl implements kotlin.jvm.functions.Function2<java.nio.file.Path, java.lang.Exception, java.nio.file.FileVisitResult> {
    final /* synthetic */ java.nio.file.Path $normalizedTarget;
    final /* synthetic */ kotlin.jvm.functions.Function3<java.nio.file.Path, java.nio.file.Path, java.lang.Exception, kotlin.io.path.OnErrorResult> $onError;
    final /* synthetic */ java.nio.file.Path $target;
    final /* synthetic */ java.nio.file.Path $this_copyToRecursively;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    PathsKt__PathRecursiveFunctionsKt$copyToRecursively$5$3(kotlin.jvm.functions.Function3<? super java.nio.file.Path, ? super java.nio.file.Path, ? super java.lang.Exception, ? extends kotlin.io.path.OnErrorResult> function3, java.nio.file.Path path, java.nio.file.Path path2, java.nio.file.Path path3) {
        super(2, kotlin.jvm.internal.Intrinsics.Kotlin.class, "error", "copyToRecursively$error$PathsKt__PathRecursiveFunctionsKt(Lkotlin/jvm/functions/Function3;Ljava/nio/file/Path;Ljava/nio/file/Path;Ljava/nio/file/Path;Ljava/nio/file/Path;Ljava/lang/Exception;)Ljava/nio/file/FileVisitResult;", 0);
        this.$onError = function3;
        this.$this_copyToRecursively = path;
        this.$target = path2;
        this.$normalizedTarget = path3;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ java.nio.file.FileVisitResult invoke(java.nio.file.Path path, java.lang.Exception exc) {
        return invoke2(io.dcloud.p.g4$$ExternalSyntheticApiModelOutline0.m464m((java.lang.Object) path), exc);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final java.nio.file.FileVisitResult invoke2(java.nio.file.Path p0, java.lang.Exception p1) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(p0, "p0");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(p1, "p1");
        return kotlin.io.path.PathsKt__PathRecursiveFunctionsKt.copyToRecursively$error$PathsKt__PathRecursiveFunctionsKt(this.$onError, this.$this_copyToRecursively, this.$target, this.$normalizedTarget, p0, p1);
    }
}
