package tv.cjump.jni;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceUtils {
    public static final java.lang.String ABI_MIPS = "mips";
    public static final java.lang.String ABI_X86 = "x86";
    private static final int EM_386 = 3;
    private static final int EM_AARCH64 = 183;
    private static final int EM_ARM = 40;
    private static final int EM_MIPS = 8;
    private static tv.cjump.jni.DeviceUtils.ARCH sArch = tv.cjump.jni.DeviceUtils.ARCH.Unknown;

    public enum ARCH {
        Unknown,
        ARM,
        X86,
        MIPS,
        ARM64
    }

    /* JADX INFO: Removed unreachable split cross block B:61:0x0097 */
    /* JADX WARN: Code duplicated, block: B:37:0x0081 A[Catch: IOException -> 0x006b, all -> 0x009b, PHI: r4
  0x0081: PHI (r4v7 java.io.RandomAccessFile) = (r4v26 java.io.RandomAccessFile), (r4v27 java.io.RandomAccessFile) binds: [B:36:0x007f, B:41:0x0089] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #7 {IOException -> 0x006b, blocks: (B:21:0x0067, B:37:0x0081), top: B:62:0x001b, outer: #6 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v22 */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v24 */
    /* JADX WARN: Type inference failed for: r4v25 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v9 */
    public static synchronized tv.cjump.jni.DeviceUtils.ARCH getMyCpuArch() {
        java.io.RandomAccessFile randomAccessFile;
        byte[] bArr = new byte[20];
        java.io.File file = new java.io.File(android.os.Environment.getRootDirectory(), "lib/libc.so");
        if (file.canRead()) {
            ?? r4 = 0;
            java.io.RandomAccessFile randomAccessFile2 = null;
            java.io.RandomAccessFile randomAccessFile3 = null;
            r4 = 0;
            try {
                try {
                    try {
                        java.io.RandomAccessFile randomAccessFile4 = new java.io.RandomAccessFile(file, "r");
                        try {
                            randomAccessFile4.readFully(bArr);
                            ?? r5 = 8;
                            r5 = 8;
                            r5 = 8;
                            r5 = 8;
                            int i = bArr[18] | (bArr[19] << 8);
                            if (i == 3) {
                                sArch = tv.cjump.jni.DeviceUtils.ARCH.X86;
                            } else if (i == 8) {
                                sArch = tv.cjump.jni.DeviceUtils.ARCH.MIPS;
                            } else if (i == 40) {
                                sArch = tv.cjump.jni.DeviceUtils.ARCH.ARM;
                            } else if (i == 183) {
                                sArch = tv.cjump.jni.DeviceUtils.ARCH.ARM64;
                            } else {
                                java.lang.StringBuilder sb = new java.lang.StringBuilder("libc.so is unknown arch: ");
                                sb.append(java.lang.Integer.toHexString(i));
                                android.util.Log.e("NativeBitmapFactory", sb.toString());
                                r5 = sb;
                            }
                            randomAccessFile4.close();
                            r4 = r5;
                        } catch (java.io.FileNotFoundException e) {
                            e = e;
                            randomAccessFile2 = randomAccessFile4;
                            e.printStackTrace();
                            r4 = randomAccessFile2;
                            randomAccessFile = randomAccessFile2;
                            if (randomAccessFile2 != null) {
                                randomAccessFile.close();
                                r4 = randomAccessFile;
                            }
                        } catch (java.io.IOException e2) {
                            e = e2;
                            randomAccessFile3 = randomAccessFile4;
                            e.printStackTrace();
                            r4 = randomAccessFile3;
                            randomAccessFile = randomAccessFile3;
                            if (randomAccessFile3 != null) {
                                randomAccessFile.close();
                                r4 = randomAccessFile;
                            }
                        } catch (java.lang.Throwable th) {
                            th = th;
                            r4 = randomAccessFile4;
                            if (r4 != 0) {
                                try {
                                    r4.close();
                                } catch (java.io.IOException e3) {
                                    e3.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                    }
                } catch (java.io.FileNotFoundException e4) {
                    e = e4;
                } catch (java.io.IOException e5) {
                    e = e5;
                }
            } catch (java.io.IOException e6) {
                e6.printStackTrace();
            }
        }
        return sArch;
    }

    public static java.lang.String get_CPU_ABI() {
        return android.os.Build.CPU_ABI;
    }

    public static java.lang.String get_CPU_ABI2() {
        try {
            java.lang.reflect.Field declaredField = android.os.Build.class.getDeclaredField("CPU_ABI2");
            if (declaredField == null) {
                return null;
            }
            java.lang.Object obj = declaredField.get(null);
            if (obj instanceof java.lang.String) {
                return (java.lang.String) obj;
            }
            return null;
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static boolean supportABI(java.lang.String str) {
        java.lang.String _cpu_abi = get_CPU_ABI();
        if (android.text.TextUtils.isEmpty(_cpu_abi) || !_cpu_abi.equalsIgnoreCase(str)) {
            return !android.text.TextUtils.isEmpty(get_CPU_ABI2()) && _cpu_abi.equalsIgnoreCase(str);
        }
        return true;
    }

    public static boolean supportX86() {
        return supportABI("x86");
    }

    public static boolean supportMips() {
        return supportABI(ABI_MIPS);
    }

    public static boolean isARMSimulatedByX86() {
        return !supportX86() && tv.cjump.jni.DeviceUtils.ARCH.X86.equals(getMyCpuArch());
    }

    public static boolean isMiBox2Device() {
        return android.os.Build.MANUFACTURER.equalsIgnoreCase("Xiaomi") && android.os.Build.PRODUCT.equalsIgnoreCase("dredd");
    }

    public static boolean isMagicBoxDevice() {
        return android.os.Build.MANUFACTURER.equalsIgnoreCase("MagicBox") && android.os.Build.PRODUCT.equalsIgnoreCase("MagicBox");
    }

    public static boolean isProblemBoxDevice() {
        return isMiBox2Device() || isMagicBoxDevice();
    }

    public static boolean isRealARMArch() {
        return (supportABI(com.facebook.soloader.MinElf.ISA.ARM) || supportABI("armeabi")) && tv.cjump.jni.DeviceUtils.ARCH.ARM.equals(getMyCpuArch());
    }

    public static boolean isRealX86Arch() {
        return supportABI("x86") || tv.cjump.jni.DeviceUtils.ARCH.X86.equals(getMyCpuArch());
    }
}
