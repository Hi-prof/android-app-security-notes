package com.facebook.soloader;

/* JADX INFO: loaded from: classes.dex */
public interface ElfByteChannel extends java.nio.channels.ByteChannel {
    long position() throws java.io.IOException;

    com.facebook.soloader.ElfByteChannel position(long j) throws java.io.IOException;

    @Override // java.nio.channels.ReadableByteChannel
    int read(java.nio.ByteBuffer byteBuffer) throws java.io.IOException;

    int read(java.nio.ByteBuffer byteBuffer, long j) throws java.io.IOException;

    long size() throws java.io.IOException;

    com.facebook.soloader.ElfByteChannel truncate(long j) throws java.io.IOException;

    @Override // java.nio.channels.WritableByteChannel
    int write(java.nio.ByteBuffer byteBuffer) throws java.io.IOException;
}
