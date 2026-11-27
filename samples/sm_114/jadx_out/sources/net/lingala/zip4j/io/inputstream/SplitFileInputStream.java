package net.lingala.zip4j.io.inputstream;

/* JADX INFO: loaded from: classes2.dex */
public abstract class SplitFileInputStream extends java.io.InputStream {
    public abstract void prepareExtractionForFileHeader(net.lingala.zip4j.model.FileHeader fileHeader) throws java.io.IOException;
}
