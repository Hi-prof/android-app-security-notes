package net.lingala.zip4j.io.outputstream;

/* JADX INFO: loaded from: classes2.dex */
public interface OutputStreamWithSplitZipSupport {
    int getCurrentSplitFileCounter();

    long getFilePointer() throws java.io.IOException;
}
