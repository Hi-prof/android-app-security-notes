package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public final class x0 implements java.io.Closeable {
    static final java.util.regex.Pattern o = java.util.regex.Pattern.compile("[a-z0-9_-]{1,64}");
    private static final java.io.OutputStream p = new io.dcloud.p.x0.b();
    private final java.io.File a;
    private final java.io.File b;
    private final java.io.File c;
    private final java.io.File d;
    private final int e;
    private long f;
    private final int g;
    private java.io.Writer i;
    private int k;
    private long h = 0;
    private final java.util.LinkedHashMap j = new java.util.LinkedHashMap(0, 0.75f, true);
    private long l = 0;
    final java.util.concurrent.ThreadPoolExecutor m = new java.util.concurrent.ThreadPoolExecutor(0, 1, 60, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.LinkedBlockingQueue());
    private final java.util.concurrent.Callable n = new io.dcloud.p.x0.a();

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class a implements java.util.concurrent.Callable {
        a() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public java.lang.Void call() {
            synchronized (io.dcloud.p.x0.this) {
                if (io.dcloud.p.x0.this.i == null) {
                    return null;
                }
                io.dcloud.p.x0.this.h();
                if (io.dcloud.p.x0.this.d()) {
                    io.dcloud.p.x0.this.g();
                    io.dcloud.p.x0.this.k = 0;
                }
                return null;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class b extends java.io.OutputStream {
        b() {
        }

        @Override // java.io.OutputStream
        public void write(int i) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public final class c {
        private final io.dcloud.p.x0.d a;
        private final boolean[] b;
        private boolean c;
        private boolean d;

        /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
        private class a extends java.io.FilterOutputStream {
            /* synthetic */ a(io.dcloud.p.x0.c cVar, java.io.OutputStream outputStream, io.dcloud.p.x0.a aVar) {
                this(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    ((java.io.FilterOutputStream) this).out.close();
                } catch (java.io.IOException unused) {
                    io.dcloud.p.x0.c.this.c = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    ((java.io.FilterOutputStream) this).out.flush();
                } catch (java.io.IOException unused) {
                    io.dcloud.p.x0.c.this.c = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i) {
                try {
                    ((java.io.FilterOutputStream) this).out.write(i);
                } catch (java.io.IOException unused) {
                    io.dcloud.p.x0.c.this.c = true;
                }
            }

            private a(java.io.OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                try {
                    ((java.io.FilterOutputStream) this).out.write(bArr, i, i2);
                } catch (java.io.IOException unused) {
                    io.dcloud.p.x0.c.this.c = true;
                }
            }
        }

        /* synthetic */ c(io.dcloud.p.x0 x0Var, io.dcloud.p.x0.d dVar, io.dcloud.p.x0.a aVar) {
            this(dVar);
        }

        private c(io.dcloud.p.x0.d dVar) {
            this.a = dVar;
            this.b = dVar.c ? null : new boolean[io.dcloud.p.x0.this.g];
        }

        public void b() {
            if (this.c) {
                io.dcloud.p.x0.this.a(this, false);
                io.dcloud.p.x0.this.d(this.a.a);
            } else {
                io.dcloud.p.x0.this.a(this, true);
            }
            this.d = true;
        }

        public java.io.OutputStream a(int i) {
            java.io.FileOutputStream fileOutputStream;
            io.dcloud.p.x0.c.a aVar;
            synchronized (io.dcloud.p.x0.this) {
                if (this.a.d == this) {
                    if (!this.a.c) {
                        this.b[i] = true;
                    }
                    java.io.File fileB = this.a.b(i);
                    try {
                        fileOutputStream = new java.io.FileOutputStream(fileB);
                    } catch (java.io.FileNotFoundException unused) {
                        io.dcloud.p.x0.this.a.mkdirs();
                        try {
                            fileOutputStream = new java.io.FileOutputStream(fileB);
                        } catch (java.io.FileNotFoundException unused2) {
                            return io.dcloud.p.x0.p;
                        }
                    }
                    aVar = new io.dcloud.p.x0.c.a(this, fileOutputStream, null);
                } else {
                    throw new java.lang.IllegalStateException();
                }
            }
            return aVar;
        }

        public void a() {
            io.dcloud.p.x0.this.a(this, false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private final class d {
        private final java.lang.String a;
        private final long[] b;
        private boolean c;
        private io.dcloud.p.x0.c d;
        private long e;

        /* synthetic */ d(io.dcloud.p.x0 x0Var, java.lang.String str, io.dcloud.p.x0.a aVar) {
            this(str);
        }

        private d(java.lang.String str) {
            this.a = str;
            this.b = new long[io.dcloud.p.x0.this.g];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(java.lang.String[] strArr) throws java.io.IOException {
            if (strArr.length != io.dcloud.p.x0.this.g) {
                throw a(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.b[i] = java.lang.Long.parseLong(strArr[i]);
                } catch (java.lang.NumberFormatException unused) {
                    throw a(strArr);
                }
            }
        }

        public java.lang.String a() {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            for (long j : this.b) {
                sb.append(' ');
                sb.append(j);
            }
            return sb.toString();
        }

        private java.io.IOException a(java.lang.String[] strArr) throws java.io.IOException {
            throw new java.io.IOException("unexpected journal line: " + java.util.Arrays.toString(strArr));
        }

        public java.io.File a(int i) {
            return new java.io.File(io.dcloud.p.x0.this.a, this.a + com.taobao.weex.el.parse.Operators.DOT_STR + i);
        }

        public java.io.File b(int i) {
            return new java.io.File(io.dcloud.p.x0.this.a, this.a + com.taobao.weex.el.parse.Operators.DOT_STR + i + com.facebook.cache.disk.DefaultDiskStorage.FileType.TEMP);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public final class e implements java.io.Closeable {
        private final java.lang.String a;
        private final long b;
        private final java.io.InputStream[] c;
        private final long[] d;

        /* synthetic */ e(io.dcloud.p.x0 x0Var, java.lang.String str, long j, java.io.InputStream[] inputStreamArr, long[] jArr, io.dcloud.p.x0.a aVar) {
            this(str, j, inputStreamArr, jArr);
        }

        public java.io.InputStream a(int i) {
            return this.c[i];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (java.io.InputStream inputStream : this.c) {
                io.dcloud.p.a5.a(inputStream);
            }
        }

        public java.lang.String getString(int i) {
            return io.dcloud.p.x0.b(a(i));
        }

        private e(java.lang.String str, long j, java.io.InputStream[] inputStreamArr, long[] jArr) {
            this.a = str;
            this.b = j;
            this.c = inputStreamArr;
            this.d = jArr;
        }
    }

    private x0(java.io.File file, int i, int i2, long j) {
        this.a = file;
        this.e = i;
        this.b = new java.io.File(file, "journal");
        this.c = new java.io.File(file, "journal.tmp");
        this.d = new java.io.File(file, "journal.bkp");
        this.g = i2;
        this.f = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void g() {
        try {
            java.io.Writer writer = this.i;
            if (writer != null) {
                writer.close();
            }
            java.io.BufferedWriter bufferedWriter = new java.io.BufferedWriter(new java.io.OutputStreamWriter(new java.io.FileOutputStream(this.c), io.dcloud.p.a5.a));
            try {
                bufferedWriter.write("libcore.io.DiskLruCache");
                bufferedWriter.write("\n");
                bufferedWriter.write("1");
                bufferedWriter.write("\n");
                bufferedWriter.write(java.lang.Integer.toString(this.e));
                bufferedWriter.write("\n");
                bufferedWriter.write(java.lang.Integer.toString(this.g));
                bufferedWriter.write("\n");
                bufferedWriter.write("\n");
                for (io.dcloud.p.x0.d dVar : this.j.values()) {
                    if (dVar.d != null) {
                        bufferedWriter.write("DIRTY " + dVar.a + '\n');
                    } else {
                        bufferedWriter.write("CLEAN " + dVar.a + dVar.a() + '\n');
                    }
                }
                bufferedWriter.close();
                if (this.b.exists()) {
                    a(this.b, this.d, true);
                }
                a(this.c, this.b, false);
                this.d.delete();
                this.i = new java.io.BufferedWriter(new java.io.OutputStreamWriter(new java.io.FileOutputStream(this.b, true), io.dcloud.p.a5.a));
            } catch (java.lang.Throwable th) {
                bufferedWriter.close();
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        while (this.h > this.f) {
            d((java.lang.String) ((java.util.Map.Entry) this.j.entrySet().iterator().next()).getKey());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.i == null) {
            return;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(this.j.values());
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            java.lang.Object obj = arrayList.get(i);
            i++;
            io.dcloud.p.x0.d dVar = (io.dcloud.p.x0.d) obj;
            if (dVar.d != null) {
                dVar.d.a();
            }
        }
        h();
        this.i.close();
        this.i = null;
    }

    public synchronized void flush() {
        b();
        h();
        this.i.flush();
    }

    private void c(java.lang.String str) throws java.io.IOException {
        java.lang.String strSubstring;
        int iIndexOf = str.indexOf(32);
        if (iIndexOf == -1) {
            throw new java.io.IOException("unexpected journal line: " + str);
        }
        int i = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(32, i);
        if (iIndexOf2 == -1) {
            strSubstring = str.substring(i);
            if (iIndexOf == 6 && str.startsWith("REMOVE")) {
                this.j.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i, iIndexOf2);
        }
        io.dcloud.p.x0.d dVar = (io.dcloud.p.x0.d) this.j.get(strSubstring);
        io.dcloud.p.x0.a aVar = null;
        if (dVar == null) {
            dVar = new io.dcloud.p.x0.d(this, strSubstring, aVar);
            this.j.put(strSubstring, dVar);
        }
        if (iIndexOf2 != -1 && iIndexOf == 5 && str.startsWith("CLEAN")) {
            java.lang.String[] strArrSplit = str.substring(iIndexOf2 + 1).split(com.taobao.weex.el.parse.Operators.SPACE_STR);
            dVar.c = true;
            dVar.d = null;
            dVar.b(strArrSplit);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith("DIRTY")) {
            dVar.d = new io.dcloud.p.x0.c(this, dVar, aVar);
        } else {
            if (iIndexOf2 == -1 && iIndexOf == 4 && str.startsWith("READ")) {
                return;
            }
            throw new java.io.IOException("unexpected journal line: " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d() {
        int i = this.k;
        return i >= 2000 && i >= this.j.size();
    }

    private void e() throws java.io.IOException {
        a(this.c);
        java.util.Iterator it = this.j.values().iterator();
        while (it.hasNext()) {
            io.dcloud.p.x0.d dVar = (io.dcloud.p.x0.d) it.next();
            int i = 0;
            if (dVar.d == null) {
                while (i < this.g) {
                    this.h += dVar.b[i];
                    i++;
                }
            } else {
                dVar.d = null;
                while (i < this.g) {
                    a(dVar.a(i));
                    a(dVar.b(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    private void f() {
        io.dcloud.p.q4 q4Var = new io.dcloud.p.q4(new java.io.FileInputStream(this.b), io.dcloud.p.a5.a);
        try {
            java.lang.String strB = q4Var.b();
            java.lang.String strB2 = q4Var.b();
            java.lang.String strB3 = q4Var.b();
            java.lang.String strB4 = q4Var.b();
            java.lang.String strB5 = q4Var.b();
            if (!"libcore.io.DiskLruCache".equals(strB) || !"1".equals(strB2) || !java.lang.Integer.toString(this.e).equals(strB3) || !java.lang.Integer.toString(this.g).equals(strB4) || !"".equals(strB5)) {
                throw new java.io.IOException("unexpected journal header: [" + strB + ", " + strB2 + ", " + strB4 + ", " + strB5 + com.taobao.weex.el.parse.Operators.ARRAY_END_STR);
            }
            int i = 0;
            while (true) {
                try {
                    c(q4Var.b());
                    i++;
                } catch (java.io.EOFException unused) {
                    this.k = i - this.j.size();
                    io.dcloud.p.a5.a(q4Var);
                    return;
                }
            }
        } catch (java.lang.Throwable th) {
            io.dcloud.p.a5.a(q4Var);
            throw th;
        }
    }

    public synchronized io.dcloud.p.x0.e b(java.lang.String str) throws java.lang.Throwable {
        java.lang.Throwable th;
        java.io.InputStream inputStream;
        try {
            b();
            e(str);
            io.dcloud.p.x0.d dVar = (io.dcloud.p.x0.d) this.j.get(str);
            if (dVar == null) {
                return null;
            }
            if (!dVar.c) {
                return null;
            }
            java.io.InputStream[] inputStreamArr = new java.io.InputStream[this.g];
            for (int i = 0; i < this.g; i++) {
                try {
                    try {
                        try {
                            inputStreamArr[i] = new java.io.FileInputStream(dVar.a(i));
                        } catch (java.lang.Throwable th2) {
                            th = th2;
                        }
                    } catch (java.io.FileNotFoundException unused) {
                        for (int i2 = 0; i2 < this.g && (inputStream = inputStreamArr[i2]) != null; i2++) {
                            io.dcloud.p.a5.a(inputStream);
                        }
                        return null;
                    }
                } catch (java.lang.Throwable th3) {
                    th = th3;
                    th = th;
                }
            }
            this.k++;
            this.i.append((java.lang.CharSequence) ("READ " + str + '\n'));
            if (d()) {
                this.m.submit(this.n);
            }
            return new io.dcloud.p.x0.e(this, str, dVar.e, inputStreamArr, dVar.b, null);
        } catch (java.lang.Throwable th4) {
            th = th4;
        }
        th = th;
        throw th;
    }

    public synchronized boolean d(java.lang.String str) {
        b();
        e(str);
        io.dcloud.p.x0.d dVar = (io.dcloud.p.x0.d) this.j.get(str);
        if (dVar != null && dVar.d == null) {
            for (int i = 0; i < this.g; i++) {
                java.io.File fileA = dVar.a(i);
                if (fileA.exists() && !fileA.delete()) {
                    throw new java.io.IOException("failed to delete " + fileA);
                }
                this.h -= dVar.b[i];
                dVar.b[i] = 0;
            }
            this.k++;
            this.i.append((java.lang.CharSequence) ("REMOVE " + str + '\n'));
            this.j.remove(str);
            if (d()) {
                this.m.submit(this.n);
            }
            return true;
        }
        return false;
    }

    public static io.dcloud.p.x0 a(java.io.File file, int i, int i2, long j) throws java.io.IOException {
        if (j <= 0) {
            throw new java.lang.IllegalArgumentException("maxSize <= 0");
        }
        if (i2 > 0) {
            java.io.File file2 = new java.io.File(file, "journal.bkp");
            if (file2.exists()) {
                java.io.File file3 = new java.io.File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    a(file2, file3, false);
                }
            }
            io.dcloud.p.x0 x0Var = new io.dcloud.p.x0(file, i, i2, j);
            if (x0Var.b.exists()) {
                try {
                    x0Var.f();
                    x0Var.e();
                    x0Var.i = new java.io.BufferedWriter(new java.io.OutputStreamWriter(new java.io.FileOutputStream(x0Var.b, true), io.dcloud.p.a5.a));
                    return x0Var;
                } catch (java.io.IOException e2) {
                    java.lang.System.out.println("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                    x0Var.c();
                }
            }
            file.mkdirs();
            io.dcloud.p.x0 x0Var2 = new io.dcloud.p.x0(file, i, i2, j);
            x0Var2.g();
            return x0Var2;
        }
        throw new java.lang.IllegalArgumentException("valueCount <= 0");
    }

    private void e(java.lang.String str) {
        if (o.matcher(str).matches()) {
            return;
        }
        throw new java.lang.IllegalArgumentException("keys must match regex [a-z0-9_-]{1,64}: \"" + str + io.dcloud.common.util.JSUtil.QUOTE);
    }

    public void c() throws java.io.IOException {
        close();
        io.dcloud.p.a5.a(this.a);
    }

    private void b() {
        if (this.i == null) {
            throw new java.lang.IllegalStateException("cache is closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.lang.String b(java.io.InputStream inputStream) {
        return io.dcloud.p.a5.a((java.io.Reader) new java.io.InputStreamReader(inputStream, io.dcloud.p.a5.b));
    }

    private static void a(java.io.File file) throws java.io.IOException {
        if (file.exists() && !file.delete()) {
            throw new java.io.IOException();
        }
    }

    private static void a(java.io.File file, java.io.File file2, boolean z) throws java.io.IOException {
        if (z) {
            a(file2);
        }
        if (!file.renameTo(file2)) {
            throw new java.io.IOException();
        }
    }

    public io.dcloud.p.x0.c a(java.lang.String str) {
        return a(str, -1L);
    }

    private synchronized io.dcloud.p.x0.c a(java.lang.String str, long j) {
        b();
        e(str);
        io.dcloud.p.x0.d dVar = (io.dcloud.p.x0.d) this.j.get(str);
        io.dcloud.p.x0.a aVar = null;
        if (j != -1 && (dVar == null || dVar.e != j)) {
            return null;
        }
        if (dVar != null) {
            if (dVar.d != null) {
                return null;
            }
        } else {
            dVar = new io.dcloud.p.x0.d(this, str, aVar);
            this.j.put(str, dVar);
        }
        io.dcloud.p.x0.c cVar = new io.dcloud.p.x0.c(this, dVar, aVar);
        dVar.d = cVar;
        this.i.write("DIRTY " + str + '\n');
        this.i.flush();
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(io.dcloud.p.x0.c cVar, boolean z) {
        io.dcloud.p.x0.d dVar = cVar.a;
        if (dVar.d == cVar) {
            if (z && !dVar.c) {
                for (int i = 0; i < this.g; i++) {
                    if (cVar.b[i]) {
                        if (!dVar.b(i).exists()) {
                            cVar.a();
                            return;
                        }
                    } else {
                        cVar.a();
                        throw new java.lang.IllegalStateException("Newly created entry didn't create value for index " + i);
                    }
                }
            }
            for (int i2 = 0; i2 < this.g; i2++) {
                java.io.File fileB = dVar.b(i2);
                if (z) {
                    if (fileB.exists()) {
                        java.io.File fileA = dVar.a(i2);
                        fileB.renameTo(fileA);
                        long j = dVar.b[i2];
                        long length = fileA.length();
                        dVar.b[i2] = length;
                        this.h = (this.h - j) + length;
                    }
                } else {
                    a(fileB);
                }
            }
            this.k++;
            dVar.d = null;
            if (!(dVar.c | z)) {
                this.j.remove(dVar.a);
                this.i.write("REMOVE " + dVar.a + '\n');
            } else {
                dVar.c = true;
                this.i.write("CLEAN " + dVar.a + dVar.a() + '\n');
                if (z) {
                    long j2 = this.l;
                    this.l = 1 + j2;
                    dVar.e = j2;
                }
            }
            this.i.flush();
            if (this.h > this.f || d()) {
                this.m.submit(this.n);
                return;
            }
            return;
        }
        throw new java.lang.IllegalStateException();
    }
}
