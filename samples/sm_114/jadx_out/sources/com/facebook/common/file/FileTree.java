package com.facebook.common.file;

/* JADX INFO: loaded from: classes.dex */
public class FileTree {
    public static void walkFileTree(java.io.File file, com.facebook.common.file.FileTreeVisitor fileTreeVisitor) {
        fileTreeVisitor.preVisitDirectory(file);
        java.io.File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (java.io.File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    walkFileTree(file2, fileTreeVisitor);
                } else {
                    fileTreeVisitor.visitFile(file2);
                }
            }
        }
        fileTreeVisitor.postVisitDirectory(file);
    }

    public static boolean deleteContents(java.io.File file) {
        java.io.File[] fileArrListFiles = file.listFiles();
        boolean zDeleteRecursively = true;
        if (fileArrListFiles != null) {
            for (java.io.File file2 : fileArrListFiles) {
                zDeleteRecursively &= deleteRecursively(file2);
            }
        }
        return zDeleteRecursively;
    }

    public static boolean deleteRecursively(java.io.File file) {
        if (file.isDirectory()) {
            deleteContents(file);
        }
        return file.delete();
    }
}
