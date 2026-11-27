package com.facebook.common.file;

/* JADX INFO: loaded from: classes.dex */
public interface FileTreeVisitor {
    void postVisitDirectory(java.io.File file);

    void preVisitDirectory(java.io.File file);

    void visitFile(java.io.File file);
}
