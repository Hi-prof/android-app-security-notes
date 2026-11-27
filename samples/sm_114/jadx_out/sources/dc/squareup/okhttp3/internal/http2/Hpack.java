package dc.squareup.okhttp3.internal.http2;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
final class Hpack {
    static final java.util.Map<dc.squareup.okio.ByteString, java.lang.Integer> NAME_TO_FIRST_INDEX;
    private static final int PREFIX_4_BITS = 15;
    private static final int PREFIX_5_BITS = 31;
    private static final int PREFIX_6_BITS = 63;
    private static final int PREFIX_7_BITS = 127;
    static final dc.squareup.okhttp3.internal.http2.Header[] STATIC_HEADER_TABLE;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static final class Reader {
        dc.squareup.okhttp3.internal.http2.Header[] dynamicTable;
        int dynamicTableByteCount;
        int headerCount;
        private final java.util.List<dc.squareup.okhttp3.internal.http2.Header> headerList;
        private final int headerTableSizeSetting;
        private int maxDynamicTableByteCount;
        int nextHeaderIndex;
        private final dc.squareup.okio.BufferedSource source;

        Reader(int i, dc.squareup.okio.Source source) {
            this(i, i, source);
        }

        private void adjustDynamicTableByteCount() {
            int i = this.maxDynamicTableByteCount;
            int i2 = this.dynamicTableByteCount;
            if (i < i2) {
                if (i == 0) {
                    clearDynamicTable();
                } else {
                    evictToRecoverBytes(i2 - i);
                }
            }
        }

        private void clearDynamicTable() {
            java.util.Arrays.fill(this.dynamicTable, (java.lang.Object) null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private int dynamicTableIndex(int i) {
            return this.nextHeaderIndex + 1 + i;
        }

        private int evictToRecoverBytes(int i) {
            int i2;
            int i3 = 0;
            if (i > 0) {
                int length = this.dynamicTable.length;
                while (true) {
                    length--;
                    i2 = this.nextHeaderIndex;
                    if (length < i2 || i <= 0) {
                        break;
                    }
                    int i4 = this.dynamicTable[length].hpackSize;
                    i -= i4;
                    this.dynamicTableByteCount -= i4;
                    this.headerCount--;
                    i3++;
                }
                dc.squareup.okhttp3.internal.http2.Header[] headerArr = this.dynamicTable;
                int i5 = i2 + 1;
                java.lang.System.arraycopy(headerArr, i5, headerArr, i5 + i3, this.headerCount);
                this.nextHeaderIndex += i3;
            }
            return i3;
        }

        private dc.squareup.okio.ByteString getName(int i) throws java.io.IOException {
            if (isStaticHeader(i)) {
                return dc.squareup.okhttp3.internal.http2.Hpack.STATIC_HEADER_TABLE[i].name;
            }
            int iDynamicTableIndex = dynamicTableIndex(i - dc.squareup.okhttp3.internal.http2.Hpack.STATIC_HEADER_TABLE.length);
            if (iDynamicTableIndex >= 0) {
                dc.squareup.okhttp3.internal.http2.Header[] headerArr = this.dynamicTable;
                if (iDynamicTableIndex < headerArr.length) {
                    return headerArr[iDynamicTableIndex].name;
                }
            }
            throw new java.io.IOException("Header index too large " + (i + 1));
        }

        private void insertIntoDynamicTable(int i, dc.squareup.okhttp3.internal.http2.Header header) {
            this.headerList.add(header);
            int i2 = header.hpackSize;
            if (i != -1) {
                i2 -= this.dynamicTable[dynamicTableIndex(i)].hpackSize;
            }
            int i3 = this.maxDynamicTableByteCount;
            if (i2 > i3) {
                clearDynamicTable();
                return;
            }
            int iEvictToRecoverBytes = evictToRecoverBytes((this.dynamicTableByteCount + i2) - i3);
            if (i == -1) {
                int i4 = this.headerCount + 1;
                dc.squareup.okhttp3.internal.http2.Header[] headerArr = this.dynamicTable;
                if (i4 > headerArr.length) {
                    dc.squareup.okhttp3.internal.http2.Header[] headerArr2 = new dc.squareup.okhttp3.internal.http2.Header[headerArr.length * 2];
                    java.lang.System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                    this.nextHeaderIndex = this.dynamicTable.length - 1;
                    this.dynamicTable = headerArr2;
                }
                int i5 = this.nextHeaderIndex;
                this.nextHeaderIndex = i5 - 1;
                this.dynamicTable[i5] = header;
                this.headerCount++;
            } else {
                this.dynamicTable[i + dynamicTableIndex(i) + iEvictToRecoverBytes] = header;
            }
            this.dynamicTableByteCount += i2;
        }

        private boolean isStaticHeader(int i) {
            return i >= 0 && i <= dc.squareup.okhttp3.internal.http2.Hpack.STATIC_HEADER_TABLE.length - 1;
        }

        private int readByte() throws java.io.IOException {
            return this.source.readByte() & 255;
        }

        private void readIndexedHeader(int i) throws java.io.IOException {
            if (isStaticHeader(i)) {
                this.headerList.add(dc.squareup.okhttp3.internal.http2.Hpack.STATIC_HEADER_TABLE[i]);
                return;
            }
            int iDynamicTableIndex = dynamicTableIndex(i - dc.squareup.okhttp3.internal.http2.Hpack.STATIC_HEADER_TABLE.length);
            if (iDynamicTableIndex >= 0) {
                dc.squareup.okhttp3.internal.http2.Header[] headerArr = this.dynamicTable;
                if (iDynamicTableIndex < headerArr.length) {
                    this.headerList.add(headerArr[iDynamicTableIndex]);
                    return;
                }
            }
            throw new java.io.IOException("Header index too large " + (i + 1));
        }

        private void readLiteralHeaderWithIncrementalIndexingIndexedName(int i) throws java.io.IOException {
            insertIntoDynamicTable(-1, new dc.squareup.okhttp3.internal.http2.Header(getName(i), readByteString()));
        }

        private void readLiteralHeaderWithIncrementalIndexingNewName() throws java.io.IOException {
            insertIntoDynamicTable(-1, new dc.squareup.okhttp3.internal.http2.Header(dc.squareup.okhttp3.internal.http2.Hpack.checkLowercase(readByteString()), readByteString()));
        }

        private void readLiteralHeaderWithoutIndexingIndexedName(int i) throws java.io.IOException {
            this.headerList.add(new dc.squareup.okhttp3.internal.http2.Header(getName(i), readByteString()));
        }

        private void readLiteralHeaderWithoutIndexingNewName() throws java.io.IOException {
            this.headerList.add(new dc.squareup.okhttp3.internal.http2.Header(dc.squareup.okhttp3.internal.http2.Hpack.checkLowercase(readByteString()), readByteString()));
        }

        public java.util.List<dc.squareup.okhttp3.internal.http2.Header> getAndResetHeaderList() {
            java.util.ArrayList arrayList = new java.util.ArrayList(this.headerList);
            this.headerList.clear();
            return arrayList;
        }

        int maxDynamicTableByteCount() {
            return this.maxDynamicTableByteCount;
        }

        dc.squareup.okio.ByteString readByteString() throws java.io.IOException {
            int i = readByte();
            boolean z = (i & 128) == 128;
            int i2 = readInt(i, 127);
            return z ? dc.squareup.okio.ByteString.of(dc.squareup.okhttp3.internal.http2.Huffman.get().decode(this.source.readByteArray(i2))) : this.source.readByteString(i2);
        }

        void readHeaders() throws java.io.IOException {
            while (!this.source.exhausted()) {
                byte b = this.source.readByte();
                int i = b & 255;
                if (i == 128) {
                    throw new java.io.IOException("index == 0");
                }
                if ((b & kotlin.jvm.internal.ByteCompanionObject.MIN_VALUE) == 128) {
                    readIndexedHeader(readInt(i, 127) - 1);
                } else if (i == 64) {
                    readLiteralHeaderWithIncrementalIndexingNewName();
                } else if ((b & 64) == 64) {
                    readLiteralHeaderWithIncrementalIndexingIndexedName(readInt(i, 63) - 1);
                } else if ((b & org.mozilla.universalchardet.prober.HebrewProber.SPACE) == 32) {
                    int i2 = readInt(i, 31);
                    this.maxDynamicTableByteCount = i2;
                    if (i2 < 0 || i2 > this.headerTableSizeSetting) {
                        throw new java.io.IOException("Invalid dynamic table size update " + this.maxDynamicTableByteCount);
                    }
                    adjustDynamicTableByteCount();
                } else if (i == 16 || i == 0) {
                    readLiteralHeaderWithoutIndexingNewName();
                } else {
                    readLiteralHeaderWithoutIndexingIndexedName(readInt(i, 15) - 1);
                }
            }
        }

        int readInt(int i, int i2) throws java.io.IOException {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                int i5 = readByte();
                if ((i5 & 128) == 0) {
                    return i2 + (i5 << i4);
                }
                i2 += (i5 & 127) << i4;
                i4 += 7;
            }
        }

        Reader(int i, int i2, dc.squareup.okio.Source source) {
            this.headerList = new java.util.ArrayList();
            this.dynamicTable = new dc.squareup.okhttp3.internal.http2.Header[8];
            this.nextHeaderIndex = 7;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
            this.headerTableSizeSetting = i;
            this.maxDynamicTableByteCount = i2;
            this.source = dc.squareup.okio.Okio.buffer(source);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static final class Writer {
        private static final int SETTINGS_HEADER_TABLE_SIZE = 4096;
        private static final int SETTINGS_HEADER_TABLE_SIZE_LIMIT = 16384;
        dc.squareup.okhttp3.internal.http2.Header[] dynamicTable;
        int dynamicTableByteCount;
        private boolean emitDynamicTableSizeUpdate;
        int headerCount;
        int headerTableSizeSetting;
        int maxDynamicTableByteCount;
        int nextHeaderIndex;
        private final dc.squareup.okio.Buffer out;
        private int smallestHeaderTableSizeSetting;
        private final boolean useCompression;

        Writer(dc.squareup.okio.Buffer buffer) {
            this(4096, true, buffer);
        }

        private void adjustDynamicTableByteCount() {
            int i = this.maxDynamicTableByteCount;
            int i2 = this.dynamicTableByteCount;
            if (i < i2) {
                if (i == 0) {
                    clearDynamicTable();
                } else {
                    evictToRecoverBytes(i2 - i);
                }
            }
        }

        private void clearDynamicTable() {
            java.util.Arrays.fill(this.dynamicTable, (java.lang.Object) null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private int evictToRecoverBytes(int i) {
            int i2;
            int i3 = 0;
            if (i > 0) {
                int length = this.dynamicTable.length;
                while (true) {
                    length--;
                    i2 = this.nextHeaderIndex;
                    if (length < i2 || i <= 0) {
                        break;
                    }
                    int i4 = this.dynamicTable[length].hpackSize;
                    i -= i4;
                    this.dynamicTableByteCount -= i4;
                    this.headerCount--;
                    i3++;
                }
                dc.squareup.okhttp3.internal.http2.Header[] headerArr = this.dynamicTable;
                int i5 = i2 + 1;
                java.lang.System.arraycopy(headerArr, i5, headerArr, i5 + i3, this.headerCount);
                dc.squareup.okhttp3.internal.http2.Header[] headerArr2 = this.dynamicTable;
                int i6 = this.nextHeaderIndex + 1;
                java.util.Arrays.fill(headerArr2, i6, i6 + i3, (java.lang.Object) null);
                this.nextHeaderIndex += i3;
            }
            return i3;
        }

        private void insertIntoDynamicTable(dc.squareup.okhttp3.internal.http2.Header header) {
            int i = header.hpackSize;
            int i2 = this.maxDynamicTableByteCount;
            if (i > i2) {
                clearDynamicTable();
                return;
            }
            evictToRecoverBytes((this.dynamicTableByteCount + i) - i2);
            int i3 = this.headerCount + 1;
            dc.squareup.okhttp3.internal.http2.Header[] headerArr = this.dynamicTable;
            if (i3 > headerArr.length) {
                dc.squareup.okhttp3.internal.http2.Header[] headerArr2 = new dc.squareup.okhttp3.internal.http2.Header[headerArr.length * 2];
                java.lang.System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                this.nextHeaderIndex = this.dynamicTable.length - 1;
                this.dynamicTable = headerArr2;
            }
            int i4 = this.nextHeaderIndex;
            this.nextHeaderIndex = i4 - 1;
            this.dynamicTable[i4] = header;
            this.headerCount++;
            this.dynamicTableByteCount += i;
        }

        void setHeaderTableSizeSetting(int i) {
            this.headerTableSizeSetting = i;
            int iMin = java.lang.Math.min(i, 16384);
            int i2 = this.maxDynamicTableByteCount;
            if (i2 == iMin) {
                return;
            }
            if (iMin < i2) {
                this.smallestHeaderTableSizeSetting = java.lang.Math.min(this.smallestHeaderTableSizeSetting, iMin);
            }
            this.emitDynamicTableSizeUpdate = true;
            this.maxDynamicTableByteCount = iMin;
            adjustDynamicTableByteCount();
        }

        void writeByteString(dc.squareup.okio.ByteString byteString) throws java.io.IOException {
            if (!this.useCompression || dc.squareup.okhttp3.internal.http2.Huffman.get().encodedLength(byteString) >= byteString.size()) {
                writeInt(byteString.size(), 127, 0);
                this.out.write(byteString);
                return;
            }
            dc.squareup.okio.Buffer buffer = new dc.squareup.okio.Buffer();
            dc.squareup.okhttp3.internal.http2.Huffman.get().encode(byteString, buffer);
            dc.squareup.okio.ByteString byteString2 = buffer.readByteString();
            writeInt(byteString2.size(), 127, 128);
            this.out.write(byteString2);
        }

        /* JADX WARN: Code duplicated, block: B:26:0x006f  */
        /* JADX WARN: Code duplicated, block: B:28:0x0077  */
        /* JADX WARN: Code duplicated, block: B:30:0x0083  */
        /* JADX WARN: Code duplicated, block: B:33:0x0098 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:34:0x009a  */
        /* JADX WARN: Code duplicated, block: B:37:0x00a7  */
        /* JADX WARN: Code duplicated, block: B:38:0x00af  */
        /* JADX WARN: Code duplicated, block: B:40:0x00b3  */
        /* JADX WARN: Code duplicated, block: B:41:0x00c2  */
        /* JADX WARN: Code duplicated, block: B:46:0x00db  */
        /* JADX WARN: Code duplicated, block: B:55:0x008f A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:57:0x00a2 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:58:0x00a2 A[SYNTHETIC] */
        void writeHeaders(java.util.List<dc.squareup.okhttp3.internal.http2.Header> list) throws java.io.IOException {
            int length;
            int length2;
            int i;
            int length3;
            if (this.emitDynamicTableSizeUpdate) {
                int i2 = this.smallestHeaderTableSizeSetting;
                if (i2 < this.maxDynamicTableByteCount) {
                    writeInt(i2, 31, 32);
                }
                this.emitDynamicTableSizeUpdate = false;
                this.smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
                writeInt(this.maxDynamicTableByteCount, 31, 32);
            }
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                dc.squareup.okhttp3.internal.http2.Header header = list.get(i3);
                dc.squareup.okio.ByteString asciiLowercase = header.name.toAsciiLowercase();
                dc.squareup.okio.ByteString byteString = header.value;
                java.lang.Integer num = dc.squareup.okhttp3.internal.http2.Hpack.NAME_TO_FIRST_INDEX.get(asciiLowercase);
                if (num != null) {
                    int iIntValue = num.intValue();
                    length2 = iIntValue + 1;
                    if (length2 > 1 && length2 < 8) {
                        dc.squareup.okhttp3.internal.http2.Header[] headerArr = dc.squareup.okhttp3.internal.http2.Hpack.STATIC_HEADER_TABLE;
                        if (dc.squareup.okhttp3.internal.Util.equal(headerArr[iIntValue].value, byteString)) {
                            length = length2;
                        } else if (dc.squareup.okhttp3.internal.Util.equal(headerArr[length2].value, byteString)) {
                            length2 = iIntValue + 2;
                            length = length2;
                        }
                        if (length2 == -1) {
                            length3 = this.dynamicTable.length;
                            for (i = this.nextHeaderIndex + 1; i < length3; i++) {
                                if (!dc.squareup.okhttp3.internal.Util.equal(this.dynamicTable[i].name, asciiLowercase)) {
                                    if (dc.squareup.okhttp3.internal.Util.equal(this.dynamicTable[i].value, byteString)) {
                                        length2 = (i - this.nextHeaderIndex) + dc.squareup.okhttp3.internal.http2.Hpack.STATIC_HEADER_TABLE.length;
                                        break;
                                    } else if (length == -1) {
                                        length = (i - this.nextHeaderIndex) + dc.squareup.okhttp3.internal.http2.Hpack.STATIC_HEADER_TABLE.length;
                                    }
                                }
                            }
                        }
                        if (length2 != -1) {
                            writeInt(length2, 127, 128);
                        } else if (length == -1) {
                            this.out.writeByte(64);
                            writeByteString(asciiLowercase);
                            writeByteString(byteString);
                            insertIntoDynamicTable(header);
                        } else if (asciiLowercase.startsWith(dc.squareup.okhttp3.internal.http2.Header.PSEUDO_PREFIX) || dc.squareup.okhttp3.internal.http2.Header.TARGET_AUTHORITY.equals(asciiLowercase)) {
                            writeInt(length, 63, 64);
                            writeByteString(byteString);
                            insertIntoDynamicTable(header);
                        } else {
                            writeInt(length, 15, 0);
                            writeByteString(byteString);
                        }
                    }
                    length = length2;
                } else {
                    length = -1;
                }
                length2 = -1;
                if (length2 == -1) {
                    length3 = this.dynamicTable.length;
                    while (i < length3) {
                        if (!dc.squareup.okhttp3.internal.Util.equal(this.dynamicTable[i].name, asciiLowercase)) {
                            if (dc.squareup.okhttp3.internal.Util.equal(this.dynamicTable[i].value, byteString)) {
                                length2 = (i - this.nextHeaderIndex) + dc.squareup.okhttp3.internal.http2.Hpack.STATIC_HEADER_TABLE.length;
                                break;
                            } else if (length == -1) {
                                length = (i - this.nextHeaderIndex) + dc.squareup.okhttp3.internal.http2.Hpack.STATIC_HEADER_TABLE.length;
                            }
                        }
                    }
                }
                if (length2 != -1) {
                    writeInt(length2, 127, 128);
                } else if (length == -1) {
                    this.out.writeByte(64);
                    writeByteString(asciiLowercase);
                    writeByteString(byteString);
                    insertIntoDynamicTable(header);
                } else if (asciiLowercase.startsWith(dc.squareup.okhttp3.internal.http2.Header.PSEUDO_PREFIX)) {
                    writeInt(length, 63, 64);
                    writeByteString(byteString);
                    insertIntoDynamicTable(header);
                } else {
                    writeInt(length, 63, 64);
                    writeByteString(byteString);
                    insertIntoDynamicTable(header);
                }
            }
        }

        void writeInt(int i, int i2, int i3) {
            if (i < i2) {
                this.out.writeByte(i | i3);
                return;
            }
            this.out.writeByte(i3 | i2);
            int i4 = i - i2;
            while (i4 >= 128) {
                this.out.writeByte(128 | (i4 & 127));
                i4 >>>= 7;
            }
            this.out.writeByte(i4);
        }

        Writer(int i, boolean z, dc.squareup.okio.Buffer buffer) {
            this.smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
            this.dynamicTable = new dc.squareup.okhttp3.internal.http2.Header[8];
            this.nextHeaderIndex = 7;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
            this.headerTableSizeSetting = i;
            this.maxDynamicTableByteCount = i;
            this.useCompression = z;
            this.out = buffer;
        }
    }

    static {
        dc.squareup.okhttp3.internal.http2.Header header = new dc.squareup.okhttp3.internal.http2.Header(dc.squareup.okhttp3.internal.http2.Header.TARGET_AUTHORITY, "");
        dc.squareup.okio.ByteString byteString = dc.squareup.okhttp3.internal.http2.Header.TARGET_METHOD;
        dc.squareup.okhttp3.internal.http2.Header header2 = new dc.squareup.okhttp3.internal.http2.Header(byteString, "GET");
        dc.squareup.okhttp3.internal.http2.Header header3 = new dc.squareup.okhttp3.internal.http2.Header(byteString, "POST");
        dc.squareup.okio.ByteString byteString2 = dc.squareup.okhttp3.internal.http2.Header.TARGET_PATH;
        dc.squareup.okhttp3.internal.http2.Header header4 = new dc.squareup.okhttp3.internal.http2.Header(byteString2, "/");
        dc.squareup.okhttp3.internal.http2.Header header5 = new dc.squareup.okhttp3.internal.http2.Header(byteString2, "/index.html");
        dc.squareup.okio.ByteString byteString3 = dc.squareup.okhttp3.internal.http2.Header.TARGET_SCHEME;
        dc.squareup.okhttp3.internal.http2.Header header6 = new dc.squareup.okhttp3.internal.http2.Header(byteString3, "http");
        dc.squareup.okhttp3.internal.http2.Header header7 = new dc.squareup.okhttp3.internal.http2.Header(byteString3, "https");
        dc.squareup.okio.ByteString byteString4 = dc.squareup.okhttp3.internal.http2.Header.RESPONSE_STATUS;
        STATIC_HEADER_TABLE = new dc.squareup.okhttp3.internal.http2.Header[]{header, header2, header3, header4, header5, header6, header7, new dc.squareup.okhttp3.internal.http2.Header(byteString4, "200"), new dc.squareup.okhttp3.internal.http2.Header(byteString4, "204"), new dc.squareup.okhttp3.internal.http2.Header(byteString4, "206"), new dc.squareup.okhttp3.internal.http2.Header(byteString4, "304"), new dc.squareup.okhttp3.internal.http2.Header(byteString4, "400"), new dc.squareup.okhttp3.internal.http2.Header(byteString4, "404"), new dc.squareup.okhttp3.internal.http2.Header(byteString4, "500"), new dc.squareup.okhttp3.internal.http2.Header("accept-charset", ""), new dc.squareup.okhttp3.internal.http2.Header("accept-encoding", "gzip, deflate"), new dc.squareup.okhttp3.internal.http2.Header("accept-language", ""), new dc.squareup.okhttp3.internal.http2.Header("accept-ranges", ""), new dc.squareup.okhttp3.internal.http2.Header("accept", ""), new dc.squareup.okhttp3.internal.http2.Header("access-control-allow-origin", ""), new dc.squareup.okhttp3.internal.http2.Header("age", ""), new dc.squareup.okhttp3.internal.http2.Header("allow", ""), new dc.squareup.okhttp3.internal.http2.Header("authorization", ""), new dc.squareup.okhttp3.internal.http2.Header("cache-control", ""), new dc.squareup.okhttp3.internal.http2.Header("content-disposition", ""), new dc.squareup.okhttp3.internal.http2.Header("content-encoding", ""), new dc.squareup.okhttp3.internal.http2.Header("content-language", ""), new dc.squareup.okhttp3.internal.http2.Header("content-length", ""), new dc.squareup.okhttp3.internal.http2.Header("content-location", ""), new dc.squareup.okhttp3.internal.http2.Header("content-range", ""), new dc.squareup.okhttp3.internal.http2.Header("content-type", ""), new dc.squareup.okhttp3.internal.http2.Header("cookie", ""), new dc.squareup.okhttp3.internal.http2.Header("date", ""), new dc.squareup.okhttp3.internal.http2.Header("etag", ""), new dc.squareup.okhttp3.internal.http2.Header("expect", ""), new dc.squareup.okhttp3.internal.http2.Header("expires", ""), new dc.squareup.okhttp3.internal.http2.Header("from", ""), new dc.squareup.okhttp3.internal.http2.Header("host", ""), new dc.squareup.okhttp3.internal.http2.Header("if-match", ""), new dc.squareup.okhttp3.internal.http2.Header("if-modified-since", ""), new dc.squareup.okhttp3.internal.http2.Header("if-none-match", ""), new dc.squareup.okhttp3.internal.http2.Header("if-range", ""), new dc.squareup.okhttp3.internal.http2.Header("if-unmodified-since", ""), new dc.squareup.okhttp3.internal.http2.Header("last-modified", ""), new dc.squareup.okhttp3.internal.http2.Header(io.dcloud.feature.uniapp.adapter.AbsURIAdapter.LINK, ""), new dc.squareup.okhttp3.internal.http2.Header("location", ""), new dc.squareup.okhttp3.internal.http2.Header("max-forwards", ""), new dc.squareup.okhttp3.internal.http2.Header("proxy-authenticate", ""), new dc.squareup.okhttp3.internal.http2.Header("proxy-authorization", ""), new dc.squareup.okhttp3.internal.http2.Header(io.dcloud.common.constant.AbsoluteConst.PULL_REFRESH_RANGE, ""), new dc.squareup.okhttp3.internal.http2.Header("referer", ""), new dc.squareup.okhttp3.internal.http2.Header("refresh", ""), new dc.squareup.okhttp3.internal.http2.Header("retry-after", ""), new dc.squareup.okhttp3.internal.http2.Header("server", ""), new dc.squareup.okhttp3.internal.http2.Header("set-cookie", ""), new dc.squareup.okhttp3.internal.http2.Header("strict-transport-security", ""), new dc.squareup.okhttp3.internal.http2.Header("transfer-encoding", ""), new dc.squareup.okhttp3.internal.http2.Header(com.taobao.weex.http.WXHttpUtil.KEY_USER_AGENT, ""), new dc.squareup.okhttp3.internal.http2.Header("vary", ""), new dc.squareup.okhttp3.internal.http2.Header("via", ""), new dc.squareup.okhttp3.internal.http2.Header("www-authenticate", "")};
        NAME_TO_FIRST_INDEX = nameToFirstIndex();
    }

    private Hpack() {
    }

    static dc.squareup.okio.ByteString checkLowercase(dc.squareup.okio.ByteString byteString) throws java.io.IOException {
        int size = byteString.size();
        for (int i = 0; i < size; i++) {
            byte b = byteString.getByte(i);
            if (b >= 65 && b <= 90) {
                throw new java.io.IOException("PROTOCOL_ERROR response malformed: mixed case name: " + byteString.utf8());
            }
        }
        return byteString;
    }

    private static java.util.Map<dc.squareup.okio.ByteString, java.lang.Integer> nameToFirstIndex() {
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap(STATIC_HEADER_TABLE.length);
        int i = 0;
        while (true) {
            dc.squareup.okhttp3.internal.http2.Header[] headerArr = STATIC_HEADER_TABLE;
            if (i >= headerArr.length) {
                return java.util.Collections.unmodifiableMap(linkedHashMap);
            }
            if (!linkedHashMap.containsKey(headerArr[i].name)) {
                linkedHashMap.put(headerArr[i].name, java.lang.Integer.valueOf(i));
            }
            i++;
        }
    }
}
