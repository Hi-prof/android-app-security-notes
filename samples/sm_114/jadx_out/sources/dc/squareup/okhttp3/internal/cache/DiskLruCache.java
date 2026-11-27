package dc.squareup.okhttp3.internal.cache;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class DiskLruCache implements java.io.Closeable, java.io.Flushable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final long ANY_SEQUENCE_NUMBER = -1;
    private static final java.lang.String CLEAN = "CLEAN";
    private static final java.lang.String DIRTY = "DIRTY";
    static final java.lang.String JOURNAL_FILE = "journal";
    static final java.lang.String JOURNAL_FILE_BACKUP = "journal.bkp";
    static final java.lang.String JOURNAL_FILE_TEMP = "journal.tmp";
    static final java.util.regex.Pattern LEGAL_KEY_PATTERN = java.util.regex.Pattern.compile("[a-z0-9_-]{1,120}");
    static final java.lang.String MAGIC = "libcore.io.DiskLruCache";
    private static final java.lang.String READ = "READ";
    private static final java.lang.String REMOVE = "REMOVE";
    static final java.lang.String VERSION_1 = "1";
    private final int appVersion;
    boolean closed;
    final java.io.File directory;
    private final java.util.concurrent.Executor executor;
    final dc.squareup.okhttp3.internal.io.FileSystem fileSystem;
    boolean hasJournalErrors;
    boolean initialized;
    private final java.io.File journalFile;
    private final java.io.File journalFileBackup;
    private final java.io.File journalFileTmp;
    dc.squareup.okio.BufferedSink journalWriter;
    private long maxSize;
    boolean mostRecentRebuildFailed;
    boolean mostRecentTrimFailed;
    int redundantOpCount;
    final int valueCount;
    private long size = 0;
    final java.util.LinkedHashMap<java.lang.String, dc.squareup.okhttp3.internal.cache.DiskLruCache.Entry> lruEntries = new java.util.LinkedHashMap<>(0, 0.75f, true);
    private long nextSequenceNumber = 0;
    private final java.lang.Runnable cleanupRunnable = new java.lang.Runnable() { // from class: dc.squareup.okhttp3.internal.cache.DiskLruCache.1
        @Override // java.lang.Runnable
        public void run() {
            synchronized (dc.squareup.okhttp3.internal.cache.DiskLruCache.this) {
                dc.squareup.okhttp3.internal.cache.DiskLruCache diskLruCache = dc.squareup.okhttp3.internal.cache.DiskLruCache.this;
                if ((!diskLruCache.initialized) || diskLruCache.closed) {
                    return;
                }
                try {
                    diskLruCache.trimToSize();
                } catch (java.io.IOException unused) {
                    dc.squareup.okhttp3.internal.cache.DiskLruCache.this.mostRecentTrimFailed = true;
                }
                try {
                    if (dc.squareup.okhttp3.internal.cache.DiskLruCache.this.journalRebuildRequired()) {
                        dc.squareup.okhttp3.internal.cache.DiskLruCache.this.rebuildJournal();
                        dc.squareup.okhttp3.internal.cache.DiskLruCache.this.redundantOpCount = 0;
                    }
                } catch (java.io.IOException unused2) {
                    dc.squareup.okhttp3.internal.cache.DiskLruCache diskLruCache2 = dc.squareup.okhttp3.internal.cache.DiskLruCache.this;
                    diskLruCache2.mostRecentRebuildFailed = true;
                    diskLruCache2.journalWriter = dc.squareup.okio.Okio.buffer(dc.squareup.okio.Okio.blackhole());
                }
            }
        }
    };

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public final class Editor {
        private boolean done;
        final dc.squareup.okhttp3.internal.cache.DiskLruCache.Entry entry;
        final boolean[] written;

        Editor(dc.squareup.okhttp3.internal.cache.DiskLruCache.Entry entry) {
            this.entry = entry;
            this.written = entry.readable ? null : new boolean[dc.squareup.okhttp3.internal.cache.DiskLruCache.this.valueCount];
        }

        public void abort() throws java.io.IOException {
            synchronized (dc.squareup.okhttp3.internal.cache.DiskLruCache.this) {
                if (this.done) {
                    throw new java.lang.IllegalStateException();
                }
                if (this.entry.currentEditor == this) {
                    dc.squareup.okhttp3.internal.cache.DiskLruCache.this.completeEdit(this, false);
                }
                this.done = true;
            }
        }

        public void abortUnlessCommitted() {
            synchronized (dc.squareup.okhttp3.internal.cache.DiskLruCache.this) {
                if (!this.done && this.entry.currentEditor == this) {
                    try {
                        dc.squareup.okhttp3.internal.cache.DiskLruCache.this.completeEdit(this, false);
                    } catch (java.io.IOException unused) {
                    }
                }
            }
        }

        public void commit() throws java.io.IOException {
            synchronized (dc.squareup.okhttp3.internal.cache.DiskLruCache.this) {
                if (this.done) {
                    throw new java.lang.IllegalStateException();
                }
                if (this.entry.currentEditor == this) {
                    dc.squareup.okhttp3.internal.cache.DiskLruCache.this.completeEdit(this, true);
                }
                this.done = true;
            }
        }

        void detach() {
            if (this.entry.currentEditor != this) {
                return;
            }
            int i = 0;
            while (true) {
                dc.squareup.okhttp3.internal.cache.DiskLruCache diskLruCache = dc.squareup.okhttp3.internal.cache.DiskLruCache.this;
                if (i >= diskLruCache.valueCount) {
                    this.entry.currentEditor = null;
                    return;
                } else {
                    try {
                        diskLruCache.fileSystem.delete(this.entry.dirtyFiles[i]);
                    } catch (java.io.IOException unused) {
                    }
                    i++;
                }
            }
        }

        public dc.squareup.okio.Sink newSink(int i) {
            synchronized (dc.squareup.okhttp3.internal.cache.DiskLruCache.this) {
                if (this.done) {
                    throw new java.lang.IllegalStateException();
                }
                dc.squareup.okhttp3.internal.cache.DiskLruCache.Entry entry = this.entry;
                if (entry.currentEditor != this) {
                    return dc.squareup.okio.Okio.blackhole();
                }
                if (!entry.readable) {
                    this.written[i] = true;
                }
                try {
                    return new dc.squareup.okhttp3.internal.cache.FaultHidingSink(dc.squareup.okhttp3.internal.cache.DiskLruCache.this.fileSystem.sink(entry.dirtyFiles[i])) { // from class: dc.squareup.okhttp3.internal.cache.DiskLruCache.Editor.1
                        @Override // dc.squareup.okhttp3.internal.cache.FaultHidingSink
                        protected void onException(java.io.IOException iOException) {
                            synchronized (dc.squareup.okhttp3.internal.cache.DiskLruCache.this) {
                                dc.squareup.okhttp3.internal.cache.DiskLruCache.Editor.this.detach();
                            }
                        }
                    };
                } catch (java.io.FileNotFoundException unused) {
                    return dc.squareup.okio.Okio.blackhole();
                }
            }
        }

        public dc.squareup.okio.Source newSource(int i) {
            synchronized (dc.squareup.okhttp3.internal.cache.DiskLruCache.this) {
                if (this.done) {
                    throw new java.lang.IllegalStateException();
                }
                dc.squareup.okhttp3.internal.cache.DiskLruCache.Entry entry = this.entry;
                if (!entry.readable || entry.currentEditor != this) {
                    return null;
                }
                try {
                    return dc.squareup.okhttp3.internal.cache.DiskLruCache.this.fileSystem.source(entry.cleanFiles[i]);
                } catch (java.io.FileNotFoundException unused) {
                    return null;
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private final class Entry {
        final java.io.File[] cleanFiles;
        dc.squareup.okhttp3.internal.cache.DiskLruCache.Editor currentEditor;
        final java.io.File[] dirtyFiles;
        final java.lang.String key;
        final long[] lengths;
        boolean readable;
        long sequenceNumber;

        Entry(java.lang.String str) {
            this.key = str;
            int i = dc.squareup.okhttp3.internal.cache.DiskLruCache.this.valueCount;
            this.lengths = new long[i];
            this.cleanFiles = new java.io.File[i];
            this.dirtyFiles = new java.io.File[i];
            java.lang.StringBuilder sb = new java.lang.StringBuilder(str);
            sb.append(com.taobao.weex.el.parse.Operators.DOT);
            int length = sb.length();
            for (int i2 = 0; i2 < dc.squareup.okhttp3.internal.cache.DiskLruCache.this.valueCount; i2++) {
                sb.append(i2);
                this.cleanFiles[i2] = new java.io.File(dc.squareup.okhttp3.internal.cache.DiskLruCache.this.directory, sb.toString());
                sb.append(com.facebook.cache.disk.DefaultDiskStorage.FileType.TEMP);
                this.dirtyFiles[i2] = new java.io.File(dc.squareup.okhttp3.internal.cache.DiskLruCache.this.directory, sb.toString());
                sb.setLength(length);
            }
        }

        private java.io.IOException invalidLengths(java.lang.String[] strArr) throws java.io.IOException {
            throw new java.io.IOException("unexpected journal line: " + java.util.Arrays.toString(strArr));
        }

        void setLengths(java.lang.String[] strArr) throws java.io.IOException {
            if (strArr.length != dc.squareup.okhttp3.internal.cache.DiskLruCache.this.valueCount) {
                throw invalidLengths(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.lengths[i] = java.lang.Long.parseLong(strArr[i]);
                } catch (java.lang.NumberFormatException unused) {
                    throw invalidLengths(strArr);
                }
            }
        }

        dc.squareup.okhttp3.internal.cache.DiskLruCache.Snapshot snapshot() {
            dc.squareup.okhttp3.internal.cache.DiskLruCache diskLruCache;
            dc.squareup.okio.Source source;
            if (!java.lang.Thread.holdsLock(dc.squareup.okhttp3.internal.cache.DiskLruCache.this)) {
                throw new java.lang.AssertionError();
            }
            dc.squareup.okio.Source[] sourceArr = new dc.squareup.okio.Source[dc.squareup.okhttp3.internal.cache.DiskLruCache.this.valueCount];
            long[] jArr = (long[]) this.lengths.clone();
            int i = 0;
            int i2 = 0;
            while (true) {
                try {
                    dc.squareup.okhttp3.internal.cache.DiskLruCache diskLruCache2 = dc.squareup.okhttp3.internal.cache.DiskLruCache.this;
                    if (i2 >= diskLruCache2.valueCount) {
                        return diskLruCache2.new Snapshot(this.key, this.sequenceNumber, sourceArr, jArr);
                    }
                    sourceArr[i2] = diskLruCache2.fileSystem.source(this.cleanFiles[i2]);
                    i2++;
                } catch (java.io.FileNotFoundException unused) {
                    while (true) {
                        diskLruCache = dc.squareup.okhttp3.internal.cache.DiskLruCache.this;
                        if (i >= diskLruCache.valueCount || (source = sourceArr[i]) == null) {
                            break;
                        }
                        dc.squareup.okhttp3.internal.Util.closeQuietly(source);
                        i++;
                    }
                    try {
                        diskLruCache.removeEntry(this);
                        return null;
                    } catch (java.io.IOException unused2) {
                        return null;
                    }
                }
            }
        }

        void writeLengths(dc.squareup.okio.BufferedSink bufferedSink) throws java.io.IOException {
            for (long j : this.lengths) {
                bufferedSink.writeByte(32).writeDecimalLong(j);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public final class Snapshot implements java.io.Closeable {
        private final java.lang.String key;
        private final long[] lengths;
        private final long sequenceNumber;
        private final dc.squareup.okio.Source[] sources;

        Snapshot(java.lang.String str, long j, dc.squareup.okio.Source[] sourceArr, long[] jArr) {
            this.key = str;
            this.sequenceNumber = j;
            this.sources = sourceArr;
            this.lengths = jArr;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (dc.squareup.okio.Source source : this.sources) {
                dc.squareup.okhttp3.internal.Util.closeQuietly(source);
            }
        }

        public dc.squareup.okhttp3.internal.cache.DiskLruCache.Editor edit() throws java.io.IOException {
            return dc.squareup.okhttp3.internal.cache.DiskLruCache.this.edit(this.key, this.sequenceNumber);
        }

        public long getLength(int i) {
            return this.lengths[i];
        }

        public dc.squareup.okio.Source getSource(int i) {
            return this.sources[i];
        }

        public java.lang.String key() {
            return this.key;
        }
    }

    DiskLruCache(dc.squareup.okhttp3.internal.io.FileSystem fileSystem, java.io.File file, int i, int i2, long j, java.util.concurrent.Executor executor) {
        this.fileSystem = fileSystem;
        this.directory = file;
        this.appVersion = i;
        this.journalFile = new java.io.File(file, JOURNAL_FILE);
        this.journalFileTmp = new java.io.File(file, JOURNAL_FILE_TEMP);
        this.journalFileBackup = new java.io.File(file, JOURNAL_FILE_BACKUP);
        this.valueCount = i2;
        this.maxSize = j;
        this.executor = executor;
    }

    private synchronized void checkNotClosed() {
        if (isClosed()) {
            throw new java.lang.IllegalStateException("cache is closed");
        }
    }

    public static dc.squareup.okhttp3.internal.cache.DiskLruCache create(dc.squareup.okhttp3.internal.io.FileSystem fileSystem, java.io.File file, int i, int i2, long j) {
        if (j <= 0) {
            throw new java.lang.IllegalArgumentException("maxSize <= 0");
        }
        if (i2 > 0) {
            return new dc.squareup.okhttp3.internal.cache.DiskLruCache(fileSystem, file, i, i2, j, new java.util.concurrent.ThreadPoolExecutor(0, 1, 60L, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.LinkedBlockingQueue(), dc.squareup.okhttp3.internal.Util.threadFactory("OkHttp DiskLruCache", true)));
        }
        throw new java.lang.IllegalArgumentException("valueCount <= 0");
    }

    private dc.squareup.okio.BufferedSink newJournalWriter() throws java.io.FileNotFoundException {
        return dc.squareup.okio.Okio.buffer(new dc.squareup.okhttp3.internal.cache.FaultHidingSink(this.fileSystem.appendingSink(this.journalFile)) { // from class: dc.squareup.okhttp3.internal.cache.DiskLruCache.2
            static final /* synthetic */ boolean $assertionsDisabled = false;

            @Override // dc.squareup.okhttp3.internal.cache.FaultHidingSink
            protected void onException(java.io.IOException iOException) {
                dc.squareup.okhttp3.internal.cache.DiskLruCache.this.hasJournalErrors = true;
            }
        });
    }

    private void processJournal() throws java.io.IOException {
        this.fileSystem.delete(this.journalFileTmp);
        java.util.Iterator<dc.squareup.okhttp3.internal.cache.DiskLruCache.Entry> it = this.lruEntries.values().iterator();
        while (it.hasNext()) {
            dc.squareup.okhttp3.internal.cache.DiskLruCache.Entry next = it.next();
            int i = 0;
            if (next.currentEditor == null) {
                while (i < this.valueCount) {
                    this.size += next.lengths[i];
                    i++;
                }
            } else {
                next.currentEditor = null;
                while (i < this.valueCount) {
                    this.fileSystem.delete(next.cleanFiles[i]);
                    this.fileSystem.delete(next.dirtyFiles[i]);
                    i++;
                }
                it.remove();
            }
        }
    }

    private void readJournal() throws java.io.IOException {
        dc.squareup.okio.BufferedSource bufferedSourceBuffer = dc.squareup.okio.Okio.buffer(this.fileSystem.source(this.journalFile));
        try {
            java.lang.String utf8LineStrict = bufferedSourceBuffer.readUtf8LineStrict();
            java.lang.String utf8LineStrict2 = bufferedSourceBuffer.readUtf8LineStrict();
            java.lang.String utf8LineStrict3 = bufferedSourceBuffer.readUtf8LineStrict();
            java.lang.String utf8LineStrict4 = bufferedSourceBuffer.readUtf8LineStrict();
            java.lang.String utf8LineStrict5 = bufferedSourceBuffer.readUtf8LineStrict();
            if (!MAGIC.equals(utf8LineStrict) || !VERSION_1.equals(utf8LineStrict2) || !java.lang.Integer.toString(this.appVersion).equals(utf8LineStrict3) || !java.lang.Integer.toString(this.valueCount).equals(utf8LineStrict4) || !"".equals(utf8LineStrict5)) {
                throw new java.io.IOException("unexpected journal header: [" + utf8LineStrict + ", " + utf8LineStrict2 + ", " + utf8LineStrict4 + ", " + utf8LineStrict5 + com.taobao.weex.el.parse.Operators.ARRAY_END_STR);
            }
            int i = 0;
            while (true) {
                try {
                    readJournalLine(bufferedSourceBuffer.readUtf8LineStrict());
                    i++;
                } catch (java.io.EOFException unused) {
                    this.redundantOpCount = i - this.lruEntries.size();
                    if (bufferedSourceBuffer.exhausted()) {
                        this.journalWriter = newJournalWriter();
                    } else {
                        rebuildJournal();
                    }
                    dc.squareup.okhttp3.internal.Util.closeQuietly(bufferedSourceBuffer);
                    return;
                }
            }
        } catch (java.lang.Throwable th) {
            dc.squareup.okhttp3.internal.Util.closeQuietly(bufferedSourceBuffer);
            throw th;
        }
    }

    private void readJournalLine(java.lang.String str) throws java.io.IOException {
        java.lang.String strSubstring;
        int iIndexOf = str.indexOf(32);
        if (iIndexOf == -1) {
            throw new java.io.IOException("unexpected journal line: " + str);
        }
        int i = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(32, i);
        if (iIndexOf2 == -1) {
            strSubstring = str.substring(i);
            if (iIndexOf == 6 && str.startsWith(REMOVE)) {
                this.lruEntries.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i, iIndexOf2);
        }
        dc.squareup.okhttp3.internal.cache.DiskLruCache.Entry entry = this.lruEntries.get(strSubstring);
        if (entry == null) {
            entry = new dc.squareup.okhttp3.internal.cache.DiskLruCache.Entry(strSubstring);
            this.lruEntries.put(strSubstring, entry);
        }
        if (iIndexOf2 != -1 && iIndexOf == 5 && str.startsWith(CLEAN)) {
            java.lang.String[] strArrSplit = str.substring(iIndexOf2 + 1).split(com.taobao.weex.el.parse.Operators.SPACE_STR);
            entry.readable = true;
            entry.currentEditor = null;
            entry.setLengths(strArrSplit);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith(DIRTY)) {
            entry.currentEditor = new dc.squareup.okhttp3.internal.cache.DiskLruCache.Editor(entry);
        } else {
            if (iIndexOf2 == -1 && iIndexOf == 4 && str.startsWith(READ)) {
                return;
            }
            throw new java.io.IOException("unexpected journal line: " + str);
        }
    }

    private void validateKey(java.lang.String str) {
        if (LEGAL_KEY_PATTERN.matcher(str).matches()) {
            return;
        }
        throw new java.lang.IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + io.dcloud.common.util.JSUtil.QUOTE);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws java.io.IOException {
        if (this.initialized && !this.closed) {
            for (dc.squareup.okhttp3.internal.cache.DiskLruCache.Entry entry : (dc.squareup.okhttp3.internal.cache.DiskLruCache.Entry[]) this.lruEntries.values().toArray(new dc.squareup.okhttp3.internal.cache.DiskLruCache.Entry[this.lruEntries.size()])) {
                dc.squareup.okhttp3.internal.cache.DiskLruCache.Editor editor = entry.currentEditor;
                if (editor != null) {
                    editor.abort();
                }
            }
            trimToSize();
            this.journalWriter.close();
            this.journalWriter = null;
            this.closed = true;
            return;
        }
        this.closed = true;
    }

    synchronized void completeEdit(dc.squareup.okhttp3.internal.cache.DiskLruCache.Editor editor, boolean z) throws java.io.IOException {
        dc.squareup.okhttp3.internal.cache.DiskLruCache.Entry entry = editor.entry;
        if (entry.currentEditor != editor) {
            throw new java.lang.IllegalStateException();
        }
        if (z && !entry.readable) {
            for (int i = 0; i < this.valueCount; i++) {
                if (!editor.written[i]) {
                    editor.abort();
                    throw new java.lang.IllegalStateException("Newly created entry didn't create value for index " + i);
                }
                if (!this.fileSystem.exists(entry.dirtyFiles[i])) {
                    editor.abort();
                    return;
                }
            }
        }
        for (int i2 = 0; i2 < this.valueCount; i2++) {
            java.io.File file = entry.dirtyFiles[i2];
            if (!z) {
                this.fileSystem.delete(file);
            } else if (this.fileSystem.exists(file)) {
                java.io.File file2 = entry.cleanFiles[i2];
                this.fileSystem.rename(file, file2);
                long j = entry.lengths[i2];
                long size = this.fileSystem.size(file2);
                entry.lengths[i2] = size;
                this.size = (this.size - j) + size;
            }
        }
        this.redundantOpCount++;
        entry.currentEditor = null;
        if (entry.readable || z) {
            entry.readable = true;
            this.journalWriter.writeUtf8(CLEAN).writeByte(32);
            this.journalWriter.writeUtf8(entry.key);
            entry.writeLengths(this.journalWriter);
            this.journalWriter.writeByte(10);
            if (z) {
                long j2 = this.nextSequenceNumber;
                this.nextSequenceNumber = 1 + j2;
                entry.sequenceNumber = j2;
            }
        } else {
            this.lruEntries.remove(entry.key);
            this.journalWriter.writeUtf8(REMOVE).writeByte(32);
            this.journalWriter.writeUtf8(entry.key);
            this.journalWriter.writeByte(10);
        }
        this.journalWriter.flush();
        if (this.size > this.maxSize || journalRebuildRequired()) {
            this.executor.execute(this.cleanupRunnable);
        }
    }

    public void delete() throws java.io.IOException {
        close();
        this.fileSystem.deleteContents(this.directory);
    }

    public dc.squareup.okhttp3.internal.cache.DiskLruCache.Editor edit(java.lang.String str) throws java.io.IOException {
        return edit(str, -1L);
    }

    public synchronized void evictAll() throws java.io.IOException {
        initialize();
        for (dc.squareup.okhttp3.internal.cache.DiskLruCache.Entry entry : (dc.squareup.okhttp3.internal.cache.DiskLruCache.Entry[]) this.lruEntries.values().toArray(new dc.squareup.okhttp3.internal.cache.DiskLruCache.Entry[this.lruEntries.size()])) {
            removeEntry(entry);
        }
        this.mostRecentTrimFailed = false;
    }

    @Override // java.io.Flushable
    public synchronized void flush() throws java.io.IOException {
        if (this.initialized) {
            checkNotClosed();
            trimToSize();
            this.journalWriter.flush();
        }
    }

    public synchronized dc.squareup.okhttp3.internal.cache.DiskLruCache.Snapshot get(java.lang.String str) throws java.io.IOException {
        initialize();
        checkNotClosed();
        validateKey(str);
        dc.squareup.okhttp3.internal.cache.DiskLruCache.Entry entry = this.lruEntries.get(str);
        if (entry != null && entry.readable) {
            dc.squareup.okhttp3.internal.cache.DiskLruCache.Snapshot snapshot = entry.snapshot();
            if (snapshot == null) {
                return null;
            }
            this.redundantOpCount++;
            this.journalWriter.writeUtf8(READ).writeByte(32).writeUtf8(str).writeByte(10);
            if (!journalRebuildRequired()) {
                return snapshot;
            }
            this.executor.execute(this.cleanupRunnable);
            return snapshot;
        }
        return null;
    }

    public java.io.File getDirectory() {
        return this.directory;
    }

    public synchronized long getMaxSize() {
        return this.maxSize;
    }

    public synchronized boolean isClosed() {
        return this.closed;
    }

    boolean journalRebuildRequired() {
        int i = this.redundantOpCount;
        return i >= 2000 && i >= this.lruEntries.size();
    }

    synchronized void rebuildJournal() throws java.io.IOException {
        try {
            dc.squareup.okio.BufferedSink bufferedSink = this.journalWriter;
            if (bufferedSink != null) {
                bufferedSink.close();
            }
            dc.squareup.okio.BufferedSink bufferedSinkBuffer = dc.squareup.okio.Okio.buffer(this.fileSystem.sink(this.journalFileTmp));
            try {
                bufferedSinkBuffer.writeUtf8(MAGIC).writeByte(10);
                bufferedSinkBuffer.writeUtf8(VERSION_1).writeByte(10);
                bufferedSinkBuffer.writeDecimalLong(this.appVersion).writeByte(10);
                bufferedSinkBuffer.writeDecimalLong(this.valueCount).writeByte(10);
                bufferedSinkBuffer.writeByte(10);
                for (dc.squareup.okhttp3.internal.cache.DiskLruCache.Entry entry : this.lruEntries.values()) {
                    if (entry.currentEditor != null) {
                        bufferedSinkBuffer.writeUtf8(DIRTY).writeByte(32);
                        bufferedSinkBuffer.writeUtf8(entry.key);
                        bufferedSinkBuffer.writeByte(10);
                    } else {
                        bufferedSinkBuffer.writeUtf8(CLEAN).writeByte(32);
                        bufferedSinkBuffer.writeUtf8(entry.key);
                        entry.writeLengths(bufferedSinkBuffer);
                        bufferedSinkBuffer.writeByte(10);
                    }
                }
                bufferedSinkBuffer.close();
                if (this.fileSystem.exists(this.journalFile)) {
                    this.fileSystem.rename(this.journalFile, this.journalFileBackup);
                }
                this.fileSystem.rename(this.journalFileTmp, this.journalFile);
                this.fileSystem.delete(this.journalFileBackup);
                this.journalWriter = newJournalWriter();
                this.hasJournalErrors = false;
                this.mostRecentRebuildFailed = false;
            } catch (java.lang.Throwable th) {
                bufferedSinkBuffer.close();
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            throw th2;
        }
    }

    public synchronized boolean remove(java.lang.String str) throws java.io.IOException {
        initialize();
        checkNotClosed();
        validateKey(str);
        dc.squareup.okhttp3.internal.cache.DiskLruCache.Entry entry = this.lruEntries.get(str);
        if (entry == null) {
            return false;
        }
        boolean zRemoveEntry = removeEntry(entry);
        if (!zRemoveEntry || this.size > this.maxSize) {
            return zRemoveEntry;
        }
        this.mostRecentTrimFailed = false;
        return zRemoveEntry;
    }

    boolean removeEntry(dc.squareup.okhttp3.internal.cache.DiskLruCache.Entry entry) throws java.io.IOException {
        dc.squareup.okhttp3.internal.cache.DiskLruCache.Editor editor = entry.currentEditor;
        if (editor != null) {
            editor.detach();
        }
        for (int i = 0; i < this.valueCount; i++) {
            this.fileSystem.delete(entry.cleanFiles[i]);
            long j = this.size;
            long[] jArr = entry.lengths;
            this.size = j - jArr[i];
            jArr[i] = 0;
        }
        this.redundantOpCount++;
        this.journalWriter.writeUtf8(REMOVE).writeByte(32).writeUtf8(entry.key).writeByte(10);
        this.lruEntries.remove(entry.key);
        if (journalRebuildRequired()) {
            this.executor.execute(this.cleanupRunnable);
        }
        return true;
    }

    public synchronized void setMaxSize(long j) {
        this.maxSize = j;
        if (this.initialized) {
            this.executor.execute(this.cleanupRunnable);
        }
    }

    public synchronized long size() throws java.io.IOException {
        initialize();
        return this.size;
    }

    public synchronized java.util.Iterator<dc.squareup.okhttp3.internal.cache.DiskLruCache.Snapshot> snapshots() throws java.io.IOException {
        initialize();
        return new java.util.Iterator<dc.squareup.okhttp3.internal.cache.DiskLruCache.Snapshot>() { // from class: dc.squareup.okhttp3.internal.cache.DiskLruCache.3
            final java.util.Iterator<dc.squareup.okhttp3.internal.cache.DiskLruCache.Entry> delegate;
            dc.squareup.okhttp3.internal.cache.DiskLruCache.Snapshot nextSnapshot;
            dc.squareup.okhttp3.internal.cache.DiskLruCache.Snapshot removeSnapshot;

            {
                this.delegate = new java.util.ArrayList(dc.squareup.okhttp3.internal.cache.DiskLruCache.this.lruEntries.values()).iterator();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                dc.squareup.okhttp3.internal.cache.DiskLruCache.Snapshot snapshot;
                if (this.nextSnapshot != null) {
                    return true;
                }
                synchronized (dc.squareup.okhttp3.internal.cache.DiskLruCache.this) {
                    if (dc.squareup.okhttp3.internal.cache.DiskLruCache.this.closed) {
                        return false;
                    }
                    while (this.delegate.hasNext()) {
                        dc.squareup.okhttp3.internal.cache.DiskLruCache.Entry next = this.delegate.next();
                        if (next.readable && (snapshot = next.snapshot()) != null) {
                            this.nextSnapshot = snapshot;
                            return true;
                        }
                    }
                    return false;
                }
            }

            @Override // java.util.Iterator
            public void remove() {
                dc.squareup.okhttp3.internal.cache.DiskLruCache.Snapshot snapshot = this.removeSnapshot;
                if (snapshot == null) {
                    throw new java.lang.IllegalStateException("remove() before next()");
                }
                try {
                    dc.squareup.okhttp3.internal.cache.DiskLruCache.this.remove(snapshot.key);
                } catch (java.io.IOException unused) {
                } finally {
                    this.removeSnapshot = null;
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.Iterator
            public dc.squareup.okhttp3.internal.cache.DiskLruCache.Snapshot next() {
                if (!hasNext()) {
                    throw new java.util.NoSuchElementException();
                }
                dc.squareup.okhttp3.internal.cache.DiskLruCache.Snapshot snapshot = this.nextSnapshot;
                this.removeSnapshot = snapshot;
                this.nextSnapshot = null;
                return snapshot;
            }
        };
    }

    void trimToSize() throws java.io.IOException {
        while (this.size > this.maxSize) {
            removeEntry(this.lruEntries.values().iterator().next());
        }
        this.mostRecentTrimFailed = false;
    }

    synchronized dc.squareup.okhttp3.internal.cache.DiskLruCache.Editor edit(java.lang.String str, long j) throws java.io.IOException {
        initialize();
        checkNotClosed();
        validateKey(str);
        dc.squareup.okhttp3.internal.cache.DiskLruCache.Entry entry = this.lruEntries.get(str);
        if (j != -1 && (entry == null || entry.sequenceNumber != j)) {
            return null;
        }
        if (entry != null && entry.currentEditor != null) {
            return null;
        }
        if (!this.mostRecentTrimFailed && !this.mostRecentRebuildFailed) {
            this.journalWriter.writeUtf8(DIRTY).writeByte(32).writeUtf8(str).writeByte(10);
            this.journalWriter.flush();
            if (this.hasJournalErrors) {
                return null;
            }
            if (entry == null) {
                entry = new dc.squareup.okhttp3.internal.cache.DiskLruCache.Entry(str);
                this.lruEntries.put(str, entry);
            }
            dc.squareup.okhttp3.internal.cache.DiskLruCache.Editor editor = new dc.squareup.okhttp3.internal.cache.DiskLruCache.Editor(entry);
            entry.currentEditor = editor;
            return editor;
        }
        this.executor.execute(this.cleanupRunnable);
        return null;
    }

    public synchronized void initialize() throws java.io.IOException {
        if (this.initialized) {
            return;
        }
        if (this.fileSystem.exists(this.journalFileBackup)) {
            if (this.fileSystem.exists(this.journalFile)) {
                this.fileSystem.delete(this.journalFileBackup);
            } else {
                this.fileSystem.rename(this.journalFileBackup, this.journalFile);
            }
        }
        if (this.fileSystem.exists(this.journalFile)) {
            try {
                readJournal();
                processJournal();
                this.initialized = true;
                return;
            } catch (java.io.IOException e) {
                dc.squareup.okhttp3.internal.platform.Platform.get().log(5, "DiskLruCache " + this.directory + " is corrupt: " + e.getMessage() + ", removing", e);
                try {
                    delete();
                    this.closed = false;
                    rebuildJournal();
                    this.initialized = true;
                } catch (java.lang.Throwable th) {
                    this.closed = false;
                    throw th;
                }
            }
        }
        rebuildJournal();
        this.initialized = true;
    }
}
