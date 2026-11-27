package kotlin.io.path;

/* JADX INFO: compiled from: PathUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lkotlin/io/path/PathRelativizer;", "", "<init>", "()V", "emptyPath", "Ljava/nio/file/Path;", "kotlin.jvm.PlatformType", "parentPath", "tryRelativeTo", io.dcloud.common.constant.AbsoluteConst.XML_PATH, "base", "kotlin-stdlib-jdk7"}, k = 1, mv = {2, 2, 0}, xi = 48)
final class PathRelativizer {
    public static final kotlin.io.path.PathRelativizer INSTANCE = new kotlin.io.path.PathRelativizer();
    private static final java.nio.file.Path emptyPath = java.nio.file.Paths.get("", new java.lang.String[0]);
    private static final java.nio.file.Path parentPath = java.nio.file.Paths.get(io.dcloud.common.util.PdrUtil.FILE_PATH_ENTRY_BACK, new java.lang.String[0]);

    private PathRelativizer() {
    }

    public final java.nio.file.Path tryRelativeTo(java.nio.file.Path path, java.nio.file.Path base) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(path, "path");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(base, "base");
        java.nio.file.Path pathNormalize = base.normalize();
        java.nio.file.Path pathNormalize2 = path.normalize();
        java.nio.file.Path pathRelativize = pathNormalize.relativize(pathNormalize2);
        int iMin = java.lang.Math.min(pathNormalize.getNameCount(), pathNormalize2.getNameCount());
        for (int i = 0; i < iMin; i++) {
            java.nio.file.Path name = pathNormalize.getName(i);
            java.nio.file.Path path2 = parentPath;
            if (!kotlin.jvm.internal.Intrinsics.areEqual(name, path2)) {
                break;
            }
            if (!kotlin.jvm.internal.Intrinsics.areEqual(pathNormalize2.getName(i), path2)) {
                throw new java.lang.IllegalArgumentException("Unable to compute relative path");
            }
        }
        if (kotlin.jvm.internal.Intrinsics.areEqual(pathNormalize2, pathNormalize) || !kotlin.jvm.internal.Intrinsics.areEqual(pathNormalize, emptyPath)) {
            java.lang.String string = pathRelativize.toString();
            java.lang.String separator = pathRelativize.getFileSystem().getSeparator();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(separator, "getSeparator(...)");
            pathNormalize2 = kotlin.text.StringsKt.endsWith$default(string, separator, false, 2, (java.lang.Object) null) ? pathRelativize.getFileSystem().getPath(kotlin.text.StringsKt.dropLast(string, pathRelativize.getFileSystem().getSeparator().length()), new java.lang.String[0]) : pathRelativize;
        }
        kotlin.jvm.internal.Intrinsics.checkNotNull(pathNormalize2);
        return pathNormalize2;
    }
}
