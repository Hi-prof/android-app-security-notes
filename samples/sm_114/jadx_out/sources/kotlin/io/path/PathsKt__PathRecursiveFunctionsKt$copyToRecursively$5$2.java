package kotlin.io.path;

/* JADX INFO: compiled from: PathRecursiveFunctions.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class PathsKt__PathRecursiveFunctionsKt$copyToRecursively$5$2 extends kotlin.jvm.internal.FunctionReferenceImpl implements kotlin.jvm.functions.Function2<java.nio.file.Path, java.nio.file.attribute.BasicFileAttributes, java.nio.file.FileVisitResult> {
    final /* synthetic */ kotlin.jvm.functions.Function3<kotlin.io.path.CopyActionContext, java.nio.file.Path, java.nio.file.Path, kotlin.io.path.CopyActionResult> $copyAction;
    final /* synthetic */ java.nio.file.Path $normalizedTarget;
    final /* synthetic */ kotlin.jvm.functions.Function3<java.nio.file.Path, java.nio.file.Path, java.lang.Exception, kotlin.io.path.OnErrorResult> $onError;
    final /* synthetic */ java.util.ArrayList<java.nio.file.Path> $stack;
    final /* synthetic */ java.nio.file.Path $target;
    final /* synthetic */ java.nio.file.Path $this_copyToRecursively;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    PathsKt__PathRecursiveFunctionsKt$copyToRecursively$5$2(java.util.ArrayList<java.nio.file.Path> arrayList, kotlin.jvm.functions.Function3<? super kotlin.io.path.CopyActionContext, ? super java.nio.file.Path, ? super java.nio.file.Path, ? extends kotlin.io.path.CopyActionResult> function3, java.nio.file.Path path, java.nio.file.Path path2, java.nio.file.Path path3, kotlin.jvm.functions.Function3<? super java.nio.file.Path, ? super java.nio.file.Path, ? super java.lang.Exception, ? extends kotlin.io.path.OnErrorResult> function4) {
        super(2, kotlin.jvm.internal.Intrinsics.Kotlin.class, "copy", "copyToRecursively$copy$PathsKt__PathRecursiveFunctionsKt(Ljava/util/ArrayList;Lkotlin/jvm/functions/Function3;Ljava/nio/file/Path;Ljava/nio/file/Path;Ljava/nio/file/Path;Lkotlin/jvm/functions/Function3;Ljava/nio/file/Path;Ljava/nio/file/attribute/BasicFileAttributes;)Ljava/nio/file/FileVisitResult;", 0);
        this.$stack = arrayList;
        this.$copyAction = function3;
        this.$this_copyToRecursively = path;
        this.$target = path2;
        this.$normalizedTarget = path3;
        this.$onError = function4;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ java.nio.file.FileVisitResult invoke(java.nio.file.Path path, java.nio.file.attribute.BasicFileAttributes basicFileAttributes) {
        return invoke2(io.dcloud.p.g4$$ExternalSyntheticApiModelOutline0.m464m((java.lang.Object) path), io.dcloud.p.g4$$ExternalSyntheticApiModelOutline0.m470m((java.lang.Object) basicFileAttributes));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final java.nio.file.FileVisitResult invoke2(java.nio.file.Path p0, java.nio.file.attribute.BasicFileAttributes p1) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(p0, "p0");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(p1, "p1");
        return kotlin.io.path.PathsKt__PathRecursiveFunctionsKt.copyToRecursively$copy$PathsKt__PathRecursiveFunctionsKt(this.$stack, this.$copyAction, this.$this_copyToRecursively, this.$target, this.$normalizedTarget, this.$onError, p0, p1);
    }
}
