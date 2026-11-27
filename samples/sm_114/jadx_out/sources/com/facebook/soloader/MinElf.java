package com.facebook.soloader;

/* JADX INFO: loaded from: classes.dex */
public final class MinElf {
    public static final int DT_NEEDED = 1;
    public static final int DT_NULL = 0;
    public static final int DT_STRTAB = 5;
    public static final int ELF_MAGIC = 1179403647;
    public static final int PN_XNUM = 65535;
    public static final int PT_DYNAMIC = 2;
    public static final int PT_LOAD = 1;
    private static final java.lang.String TAG = "MinElf";

    public interface ISA {
        public static final java.lang.String AARCH64 = "arm64-v8a";
        public static final java.lang.String ARM = "armeabi-v7a";
        public static final java.lang.String X86 = "x86";
        public static final java.lang.String X86_64 = "x86_64";
    }

    public static java.lang.String[] extract_DT_NEEDED(java.io.File file) throws java.io.IOException {
        com.facebook.soloader.ElfFileChannel elfFileChannel = new com.facebook.soloader.ElfFileChannel(file);
        try {
            java.lang.String[] strArrExtract_DT_NEEDED = extract_DT_NEEDED(elfFileChannel);
            elfFileChannel.close();
            return strArrExtract_DT_NEEDED;
        } catch (java.lang.Throwable th) {
            try {
                elfFileChannel.close();
            } catch (java.lang.Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static java.lang.String[] extract_DT_NEEDED_with_retries(com.facebook.soloader.ElfFileChannel elfFileChannel) throws java.io.IOException {
        int i = 0;
        while (true) {
            try {
                return extract_DT_NEEDED_no_retries(elfFileChannel);
            } catch (java.nio.channels.ClosedByInterruptException e) {
                i++;
                if (i > 4) {
                    throw e;
                }
                java.lang.Thread.interrupted();
                com.facebook.soloader.LogUtil.e(TAG, "retrying extract_DT_NEEDED due to ClosedByInterruptException", e);
                elfFileChannel.openChannel();
            }
        }
    }

    public static java.lang.String[] extract_DT_NEEDED(com.facebook.soloader.ElfByteChannel elfByteChannel) throws java.io.IOException {
        if (elfByteChannel instanceof com.facebook.soloader.ElfFileChannel) {
            return extract_DT_NEEDED_with_retries((com.facebook.soloader.ElfFileChannel) elfByteChannel);
        }
        return extract_DT_NEEDED_no_retries(elfByteChannel);
    }

    private static java.lang.String[] extract_DT_NEEDED_no_retries(com.facebook.soloader.ElfByteChannel elfByteChannel) throws java.io.IOException {
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        long j7;
        long j8;
        java.nio.ByteBuffer byteBufferAllocate = java.nio.ByteBuffer.allocate(8);
        byteBufferAllocate.order(java.nio.ByteOrder.LITTLE_ENDIAN);
        long j9 = getu32(elfByteChannel, byteBufferAllocate, 0L);
        if (j9 != 1179403647) {
            throw new com.facebook.soloader.MinElf.ElfError("file is not ELF: magic is 0x" + java.lang.Long.toHexString(j9) + ", it should be " + java.lang.Long.toHexString(1179403647L));
        }
        boolean z = getu8(elfByteChannel, byteBufferAllocate, 4L) == 1;
        long j10 = 5;
        if (getu8(elfByteChannel, byteBufferAllocate, 5L) == 2) {
            byteBufferAllocate.order(java.nio.ByteOrder.BIG_ENDIAN);
        }
        long j11 = z ? getu32(elfByteChannel, byteBufferAllocate, 28L) : get64(elfByteChannel, byteBufferAllocate, 32L);
        long j12 = z ? getu16(elfByteChannel, byteBufferAllocate, 44L) : getu16(elfByteChannel, byteBufferAllocate, 56L);
        int i = getu16(elfByteChannel, byteBufferAllocate, z ? 42L : 54L);
        long j13 = 40;
        if (j12 == 65535) {
            long j14 = z ? getu32(elfByteChannel, byteBufferAllocate, 32L) : get64(elfByteChannel, byteBufferAllocate, 40L);
            if (z) {
                j12 = getu32(elfByteChannel, byteBufferAllocate, j14 + 28);
            } else {
                j12 = getu32(elfByteChannel, byteBufferAllocate, j14 + 44);
            }
        }
        long j15 = j11;
        long j16 = 0;
        while (true) {
            if (j16 >= j12) {
                j = 0;
                break;
            }
            if (z) {
                j8 = getu32(elfByteChannel, byteBufferAllocate, j15);
            } else {
                j8 = getu32(elfByteChannel, byteBufferAllocate, j15);
            }
            if (j8 == 2) {
                if (z) {
                    j = getu32(elfByteChannel, byteBufferAllocate, j15 + 4);
                    break;
                }
                j = get64(elfByteChannel, byteBufferAllocate, j15 + 8);
                break;
            }
            j15 += (long) i;
            j16++;
            j13 = j13;
        }
        long j17 = j13;
        if (j == 0) {
            throw new com.facebook.soloader.MinElf.ElfError("ELF file does not contain dynamic linking information");
        }
        long j18 = j;
        long j19 = 0;
        int i2 = 0;
        while (true) {
            long j20 = z ? getu32(elfByteChannel, byteBufferAllocate, j18) : get64(elfByteChannel, byteBufferAllocate, j18);
            if (j20 == 1) {
                if (i2 == Integer.MAX_VALUE) {
                    throw new com.facebook.soloader.MinElf.ElfError("malformed DT_NEEDED section");
                }
                i2++;
            } else if (j20 == j10) {
                j19 = z ? getu32(elfByteChannel, byteBufferAllocate, j18 + 4) : get64(elfByteChannel, byteBufferAllocate, j18 + 8);
            }
            j18 += z ? 8L : 16L;
            if (j20 == 0) {
                if (j19 == 0) {
                    throw new com.facebook.soloader.MinElf.ElfError("Dynamic section string-table not found");
                }
                long j21 = j11;
                int i3 = 0;
                while (true) {
                    if (i3 >= j12) {
                        j2 = 0;
                        break;
                    }
                    if (z) {
                        j4 = getu32(elfByteChannel, byteBufferAllocate, j21);
                    } else {
                        j4 = getu32(elfByteChannel, byteBufferAllocate, j21);
                    }
                    if (j4 == 1) {
                        if (z) {
                            j5 = getu32(elfByteChannel, byteBufferAllocate, j21 + 8);
                        } else {
                            j5 = get64(elfByteChannel, byteBufferAllocate, j21 + 16);
                        }
                        if (z) {
                            j6 = getu32(elfByteChannel, byteBufferAllocate, j21 + 20);
                        } else {
                            j6 = get64(elfByteChannel, byteBufferAllocate, j21 + j17);
                        }
                        if (j5 <= j19 && j19 < j6 + j5) {
                            if (z) {
                                j7 = getu32(elfByteChannel, byteBufferAllocate, j21 + 4);
                            } else {
                                j7 = get64(elfByteChannel, byteBufferAllocate, j21 + 8);
                            }
                            j2 = j7 + (j19 - j5);
                            break;
                        }
                    } else {
                        i3 = i3;
                    }
                    j21 += (long) i;
                    i3++;
                }
                if (j2 == 0) {
                    throw new com.facebook.soloader.MinElf.ElfError("did not find file offset of DT_STRTAB table");
                }
                java.lang.String[] strArr = new java.lang.String[i2];
                int i4 = 0;
                do {
                    j3 = z ? getu32(elfByteChannel, byteBufferAllocate, j) : get64(elfByteChannel, byteBufferAllocate, j);
                    if (j3 == 1) {
                        strArr[i4] = getSz(elfByteChannel, byteBufferAllocate, (z ? getu32(elfByteChannel, byteBufferAllocate, j + 4) : get64(elfByteChannel, byteBufferAllocate, j + 8)) + j2);
                        if (i4 == Integer.MAX_VALUE) {
                            throw new com.facebook.soloader.MinElf.ElfError("malformed DT_NEEDED section");
                        }
                        i4++;
                    }
                    j += z ? 8L : 16L;
                } while (j3 != 0);
                if (i4 == i2) {
                    return strArr;
                }
                throw new com.facebook.soloader.MinElf.ElfError("malformed DT_NEEDED section");
            }
            j10 = 5;
        }
    }

    private static java.lang.String getSz(com.facebook.soloader.ElfByteChannel elfByteChannel, java.nio.ByteBuffer byteBuffer, long j) throws java.io.IOException {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        while (true) {
            long j2 = 1 + j;
            short u8Var = getu8(elfByteChannel, byteBuffer, j);
            if (u8Var != 0) {
                sb.append((char) u8Var);
                j = j2;
            } else {
                return sb.toString();
            }
        }
    }

    private static void read(com.facebook.soloader.ElfByteChannel elfByteChannel, java.nio.ByteBuffer byteBuffer, int i, long j) throws java.io.IOException {
        int i2;
        byteBuffer.position(0);
        byteBuffer.limit(i);
        while (byteBuffer.remaining() > 0 && (i2 = elfByteChannel.read(byteBuffer, j)) != -1) {
            j += (long) i2;
        }
        if (byteBuffer.remaining() > 0) {
            throw new com.facebook.soloader.MinElf.ElfError("ELF file truncated");
        }
        byteBuffer.position(0);
    }

    private static long get64(com.facebook.soloader.ElfByteChannel elfByteChannel, java.nio.ByteBuffer byteBuffer, long j) throws java.io.IOException {
        read(elfByteChannel, byteBuffer, 8, j);
        return byteBuffer.getLong();
    }

    private static long getu32(com.facebook.soloader.ElfByteChannel elfByteChannel, java.nio.ByteBuffer byteBuffer, long j) throws java.io.IOException {
        read(elfByteChannel, byteBuffer, 4, j);
        return ((long) byteBuffer.getInt()) & net.lingala.zip4j.util.InternalZipConstants.ZIP_64_SIZE_LIMIT;
    }

    private static int getu16(com.facebook.soloader.ElfByteChannel elfByteChannel, java.nio.ByteBuffer byteBuffer, long j) throws java.io.IOException {
        read(elfByteChannel, byteBuffer, 2, j);
        return byteBuffer.getShort() & kotlin.UShort.MAX_VALUE;
    }

    private static short getu8(com.facebook.soloader.ElfByteChannel elfByteChannel, java.nio.ByteBuffer byteBuffer, long j) throws java.io.IOException {
        read(elfByteChannel, byteBuffer, 1, j);
        return (short) (byteBuffer.get() & 255);
    }

    protected static class ElfError extends java.lang.UnsatisfiedLinkError {
        ElfError(java.lang.String str) {
            super(str);
        }
    }
}
