package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
abstract class p {
    static final java.util.concurrent.atomic.AtomicBoolean a = new java.util.concurrent.atomic.AtomicBoolean(false);

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static class a {
        private final byte[] a;
        private final byte[] b;
        private final byte[] c;

        public a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
            byte[] bArr4 = new byte[bArr.length];
            this.a = bArr4;
            java.lang.System.arraycopy(bArr, 0, bArr4, 0, bArr.length);
            byte[] bArr5 = new byte[bArr2.length];
            this.b = bArr5;
            java.lang.System.arraycopy(bArr2, 0, bArr5, 0, bArr2.length);
            byte[] bArr6 = new byte[bArr3.length];
            this.c = bArr6;
            java.lang.System.arraycopy(bArr3, 0, bArr6, 0, bArr3.length);
        }

        public byte[] a() {
            return this.a;
        }

        public byte[] b() {
            return this.b;
        }

        public byte[] c() {
            return this.c;
        }

        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            io.dcloud.p.p.a aVar = (io.dcloud.p.p.a) obj;
            return java.util.Arrays.equals(this.a, aVar.a) && java.util.Arrays.equals(this.b, aVar.b) && java.util.Arrays.equals(this.c, aVar.c);
        }

        public int hashCode() {
            return ((((java.util.Arrays.hashCode(this.a) + 31) * 31) + java.util.Arrays.hashCode(this.b)) * 31) + java.util.Arrays.hashCode(this.c);
        }

        public java.lang.String toString() {
            java.lang.String strEncodeToString = android.util.Base64.encodeToString(this.b, 2);
            java.lang.String strEncodeToString2 = android.util.Base64.encodeToString(this.a, 2);
            return io.dcloud.common.util.StringUtil.format(strEncodeToString + ":" + android.util.Base64.encodeToString(this.c, 2) + ":" + strEncodeToString2, new java.lang.Object[0]);
        }

        public static byte[] a(byte[] bArr, byte[] bArr2) {
            byte[] bArr3 = new byte[bArr.length + bArr2.length];
            java.lang.System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
            java.lang.System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
            return bArr3;
        }

        public a(java.lang.String str) {
            java.lang.String[] strArrSplit = str.split(":");
            if (strArrSplit.length == 3) {
                this.b = android.util.Base64.decode(strArrSplit[0], 2);
                this.c = android.util.Base64.decode(strArrSplit[1], 2);
                this.a = android.util.Base64.decode(strArrSplit[2], 2);
                return;
            }
            throw new java.lang.IllegalArgumentException("Cannot parse iv:ciphertext:mac");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static final class b {
        private static final byte[] a = d();

        /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
        public static class a extends java.security.SecureRandomSpi {
        }

        /* JADX INFO: renamed from: io.dcloud.p.p$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
        private static class C0071b extends java.security.Provider {
            public C0071b() {
                super("LinuxPRNG", 1.0d, "A Linux-specific random number provider that uses /dev/urandom");
                put("SecureRandom.SHA1PRNG", io.dcloud.p.p.b.a.class.getName());
                put("SecureRandom.SHA1PRNG ImplementedIn", "Software");
            }
        }

        public static void a() {
            b();
            f();
        }

        private static void b() {
        }

        private static byte[] c() {
            try {
                java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                java.io.DataOutputStream dataOutputStream = new java.io.DataOutputStream(byteArrayOutputStream);
                dataOutputStream.writeLong(java.lang.System.currentTimeMillis());
                dataOutputStream.writeLong(java.lang.System.nanoTime());
                dataOutputStream.writeInt(android.os.Process.myPid());
                dataOutputStream.writeInt(android.os.Process.myUid());
                dataOutputStream.write(a);
                dataOutputStream.close();
                return byteArrayOutputStream.toByteArray();
            } catch (java.io.IOException e) {
                throw new java.lang.SecurityException("Failed to generate seed", e);
            }
        }

        private static byte[] d() {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            java.lang.String str = android.os.Build.FINGERPRINT;
            if (str != null) {
                sb.append(str);
            }
            java.lang.String strE = e();
            if (strE != null) {
                sb.append(strE);
            }
            try {
                return sb.toString().getBytes("UTF-8");
            } catch (java.io.UnsupportedEncodingException unused) {
                throw new java.lang.RuntimeException("UTF-8 encoding not supported");
            }
        }

        private static java.lang.String e() {
            return null;
        }

        private static void f() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static class c {
        private java.security.Key a;
        private java.security.Key b;

        public c(java.security.Key key, java.security.Key key2) {
            a(key);
            b(key2);
        }

        public java.security.Key a() {
            return this.a;
        }

        public java.security.Key b() {
            return this.b;
        }

        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            io.dcloud.p.p.c cVar = (io.dcloud.p.p.c) obj;
            return this.b.equals(cVar.b) && this.a.equals(cVar.a);
        }

        public int hashCode() {
            return ((this.a.hashCode() + 31) * 31) + this.b.hashCode();
        }

        public java.lang.String toString() {
            return android.util.Base64.encodeToString(a().getEncoded(), 2) + ":" + android.util.Base64.encodeToString(b().getEncoded(), 2);
        }

        public void a(java.security.Key key) {
            this.a = key;
        }

        public void b(java.security.Key key) {
            this.b = key;
        }
    }

    public static io.dcloud.p.p.c a(java.lang.String str) throws java.security.InvalidKeyException {
        java.lang.String[] strArrSplit = str.split(":");
        if (strArrSplit.length != 2) {
            throw new java.lang.IllegalArgumentException("Cannot parse aesKey:hmacKey");
        }
        byte[] bArrDecode = android.util.Base64.decode(strArrSplit[0], 2);
        if (bArrDecode.length != 16) {
            throw new java.security.InvalidKeyException("Base64 decoded key is not 128 bytes");
        }
        byte[] bArrDecode2 = android.util.Base64.decode(strArrSplit[1], 2);
        if (bArrDecode2.length == 32) {
            return new io.dcloud.p.p.c(new javax.crypto.spec.SecretKeySpec(bArrDecode, 0, bArrDecode.length, "AES"), new javax.crypto.spec.SecretKeySpec(bArrDecode2, d()));
        }
        throw new java.security.InvalidKeyException("Base64 decoded key is not 256 bytes");
    }

    public static byte[] b() {
        return a(16);
    }

    public static io.dcloud.p.p.c c() throws java.security.NoSuchAlgorithmException {
        a();
        javax.crypto.KeyGenerator keyGenerator = javax.crypto.KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        return new io.dcloud.p.p.c(keyGenerator.generateKey(), new javax.crypto.spec.SecretKeySpec(a(32), d()));
    }

    private static java.lang.String d() {
        return io.dcloud.common.util.Base64.decodeString("##U1d4Z1lsSkpRRE0wTnc9PSo2YTNkODhmYS00YmEwLTQ3OWYtOTQyMi1lNWFhYmUxNTg5N2I2NQ==", true, 1);
    }

    public static java.lang.String b(io.dcloud.p.p.a aVar, io.dcloud.p.p.c cVar) {
        return a(aVar, cVar, "UTF-8");
    }

    public static io.dcloud.p.p.c a(java.lang.String str, byte[] bArr, int i) {
        a();
        byte[] encoded = javax.crypto.SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new javax.crypto.spec.PBEKeySpec(str.toCharArray(), bArr, i, com.facebook.imagepipeline.memory.BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT)).getEncoded();
        return new io.dcloud.p.p.c(new javax.crypto.spec.SecretKeySpec(a(encoded, 0, 16), "AES"), new javax.crypto.spec.SecretKeySpec(a(encoded, 16, 48), d()));
    }

    private static byte[] a(int i) {
        a();
        byte[] bArr = new byte[i];
        new java.security.SecureRandom().nextBytes(bArr);
        return bArr;
    }

    public static io.dcloud.p.p.a a(java.lang.String str, io.dcloud.p.p.c cVar) {
        return a(str, cVar, "UTF-8");
    }

    public static io.dcloud.p.p.a a(java.lang.String str, io.dcloud.p.p.c cVar, java.lang.String str2) {
        return a(str.getBytes(str2), cVar);
    }

    public static io.dcloud.p.p.a a(byte[] bArr, io.dcloud.p.p.c cVar) throws javax.crypto.BadPaddingException, javax.crypto.NoSuchPaddingException, javax.crypto.IllegalBlockSizeException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException, java.security.InvalidAlgorithmParameterException {
        byte[] bArrB = b();
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(io.dcloud.common.util.AESUtil.getDefaultTransformation());
        cipher.init(1, cVar.a(), new javax.crypto.spec.IvParameterSpec(bArrB));
        byte[] iv = cipher.getIV();
        byte[] bArrDoFinal = cipher.doFinal(bArr);
        return new io.dcloud.p.p.a(bArrDoFinal, iv, a(io.dcloud.p.p.a.a(iv, bArrDoFinal), cVar.b()));
    }

    private static void a() {
        java.util.concurrent.atomic.AtomicBoolean atomicBoolean = a;
        if (atomicBoolean.get()) {
            return;
        }
        synchronized (io.dcloud.p.p.b.class) {
            if (!atomicBoolean.get()) {
                io.dcloud.p.p.b.a();
                atomicBoolean.set(true);
            }
        }
    }

    public static java.lang.String a(io.dcloud.p.p.a aVar, io.dcloud.p.p.c cVar, java.lang.String str) {
        return new java.lang.String(a(aVar, cVar), str);
    }

    public static byte[] a(io.dcloud.p.p.a aVar, io.dcloud.p.p.c cVar) throws java.security.GeneralSecurityException {
        if (a(a(io.dcloud.p.p.a.a(aVar.b(), aVar.a()), cVar.b()), aVar.c())) {
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(io.dcloud.common.util.AESUtil.getDefaultTransformation());
            cipher.init(2, cVar.a(), new javax.crypto.spec.IvParameterSpec(aVar.b()));
            return cipher.doFinal(aVar.a());
        }
        throw new java.security.GeneralSecurityException("MAC stored in civ does not match computed MAC.");
    }

    public static byte[] a(byte[] bArr, java.security.Key key) throws java.security.NoSuchAlgorithmException, java.security.InvalidKeyException {
        javax.crypto.Mac mac = javax.crypto.Mac.getInstance(d());
        mac.init(key);
        return mac.doFinal(bArr);
    }

    public static boolean a(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return false;
        }
        int i = 0;
        for (int i2 = 0; i2 < bArr.length; i2++) {
            i |= bArr[i2] ^ bArr2[i2];
        }
        return i == 0;
    }

    private static byte[] a(byte[] bArr, int i, int i2) {
        int i3 = i2 - i;
        byte[] bArr2 = new byte[i3];
        java.lang.System.arraycopy(bArr, i, bArr2, 0, i3);
        return bArr2;
    }
}
