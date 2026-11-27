package com.alibaba.fastjson.parser;

/* JADX INFO: loaded from: classes.dex */
public final class JSONReaderScanner extends com.alibaba.fastjson.parser.JSONLexerBase {
    private static final java.lang.ThreadLocal<char[]> BUF_LOCAL = new java.lang.ThreadLocal<>();
    private char[] buf;
    private int bufLength;
    private java.io.Reader reader;

    public JSONReaderScanner(java.lang.String str) {
        this(str, com.alibaba.fastjson.JSON.DEFAULT_PARSER_FEATURE);
    }

    public JSONReaderScanner(java.lang.String str, int i) {
        this(new java.io.StringReader(str), i);
    }

    public JSONReaderScanner(char[] cArr, int i) {
        this(cArr, i, com.alibaba.fastjson.JSON.DEFAULT_PARSER_FEATURE);
    }

    public JSONReaderScanner(java.io.Reader reader) {
        this(reader, com.alibaba.fastjson.JSON.DEFAULT_PARSER_FEATURE);
    }

    public JSONReaderScanner(java.io.Reader reader, int i) {
        super(i);
        this.reader = reader;
        java.lang.ThreadLocal<char[]> threadLocal = BUF_LOCAL;
        char[] cArr = threadLocal.get();
        this.buf = cArr;
        if (cArr != null) {
            threadLocal.set(null);
        }
        if (this.buf == null) {
            this.buf = new char[16384];
        }
        try {
            this.bufLength = reader.read(this.buf);
            this.bp = -1;
            next();
            if (this.ch == 65279) {
                next();
            }
        } catch (java.io.IOException e) {
            throw new com.alibaba.fastjson.JSONException(e.getMessage(), e);
        }
    }

    public JSONReaderScanner(char[] cArr, int i, int i2) {
        this(new java.io.CharArrayReader(cArr, 0, i), i2);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final char charAt(int i) {
        int i2 = this.bufLength;
        if (i >= i2) {
            if (i2 == -1) {
                return i < this.sp ? this.buf[i] : com.alibaba.fastjson.parser.JSONLexer.EOI;
            }
            if (this.bp == 0) {
                char[] cArr = this.buf;
                int length = (cArr.length * 3) / 2;
                char[] cArr2 = new char[length];
                java.lang.System.arraycopy(cArr, this.bp, cArr2, 0, this.bufLength);
                int i3 = this.bufLength;
                try {
                    this.bufLength += this.reader.read(cArr2, i3, length - i3);
                    this.buf = cArr2;
                } catch (java.io.IOException e) {
                    throw new com.alibaba.fastjson.JSONException(e.getMessage(), e);
                }
            } else {
                int i4 = this.bufLength - this.bp;
                if (i4 > 0) {
                    java.lang.System.arraycopy(this.buf, this.bp, this.buf, 0, i4);
                }
                try {
                    java.io.Reader reader = this.reader;
                    char[] cArr3 = this.buf;
                    int i5 = reader.read(cArr3, i4, cArr3.length - i4);
                    this.bufLength = i5;
                    if (i5 == 0) {
                        throw new com.alibaba.fastjson.JSONException("illegal state, textLength is zero");
                    }
                    if (i5 == -1) {
                        return com.alibaba.fastjson.parser.JSONLexer.EOI;
                    }
                    this.bufLength = i5 + i4;
                    i -= this.bp;
                    this.np -= this.bp;
                    this.bp = 0;
                } catch (java.io.IOException e2) {
                    throw new com.alibaba.fastjson.JSONException(e2.getMessage(), e2);
                }
            }
        }
        return this.buf[i];
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final int indexOf(char c, int i) {
        int i2 = i - this.bp;
        while (true) {
            char cCharAt = charAt(this.bp + i2);
            if (c == cCharAt) {
                return i2 + this.bp;
            }
            if (cCharAt == 26) {
                return -1;
            }
            i2++;
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final java.lang.String addSymbol(int i, int i2, int i3, com.alibaba.fastjson.parser.SymbolTable symbolTable) {
        return symbolTable.addSymbol(this.buf, i, i2, i3);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final char next() {
        int i = this.bp + 1;
        this.bp = i;
        int i2 = this.bufLength;
        if (i >= i2) {
            if (i2 == -1) {
                return com.alibaba.fastjson.parser.JSONLexer.EOI;
            }
            if (this.sp > 0) {
                int i3 = this.bufLength - this.sp;
                if (this.ch == '\"' && i3 > 0) {
                    i3--;
                }
                char[] cArr = this.buf;
                java.lang.System.arraycopy(cArr, i3, cArr, 0, this.sp);
            }
            this.np = -1;
            int i4 = this.sp;
            this.bp = i4;
            try {
                int i5 = this.bp;
                char[] cArr2 = this.buf;
                int length = cArr2.length - i5;
                if (length == 0) {
                    char[] cArr3 = new char[cArr2.length * 2];
                    java.lang.System.arraycopy(cArr2, 0, cArr3, 0, cArr2.length);
                    this.buf = cArr3;
                    length = cArr3.length - i5;
                }
                int i6 = this.reader.read(this.buf, this.bp, length);
                this.bufLength = i6;
                if (i6 == 0) {
                    throw new com.alibaba.fastjson.JSONException("illegal stat, textLength is zero");
                }
                if (i6 == -1) {
                    this.ch = com.alibaba.fastjson.parser.JSONLexer.EOI;
                    return com.alibaba.fastjson.parser.JSONLexer.EOI;
                }
                this.bufLength = i6 + this.bp;
                i = i4;
            } catch (java.io.IOException e) {
                throw new com.alibaba.fastjson.JSONException(e.getMessage(), e);
            }
        }
        char c = this.buf[i];
        this.ch = c;
        return c;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    protected final void copyTo(int i, int i2, char[] cArr) {
        java.lang.System.arraycopy(this.buf, i, cArr, 0, i2);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final boolean charArrayCompare(char[] cArr) {
        for (int i = 0; i < cArr.length; i++) {
            if (charAt(this.bp + i) != cArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public byte[] bytesValue() {
        if (this.token == 26) {
            throw new com.alibaba.fastjson.JSONException("TODO");
        }
        return com.alibaba.fastjson.util.IOUtils.decodeBase64(this.buf, this.np + 1, this.sp);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    protected final void arrayCopy(int i, char[] cArr, int i2, int i3) {
        java.lang.System.arraycopy(this.buf, i, cArr, i2, i3);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final java.lang.String stringVal() {
        if (!this.hasSpecial) {
            int i = this.np + 1;
            if (i < 0) {
                throw new java.lang.IllegalStateException();
            }
            if (i > this.buf.length - this.sp) {
                throw new java.lang.IllegalStateException();
            }
            return new java.lang.String(this.buf, i, this.sp);
        }
        return new java.lang.String(this.sbuf, 0, this.sp);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final java.lang.String subString(int i, int i2) {
        if (i2 < 0) {
            throw new java.lang.StringIndexOutOfBoundsException(i2);
        }
        return new java.lang.String(this.buf, i, i2);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final char[] sub_chars(int i, int i2) {
        if (i2 < 0) {
            throw new java.lang.StringIndexOutOfBoundsException(i2);
        }
        if (i == 0) {
            return this.buf;
        }
        char[] cArr = new char[i2];
        java.lang.System.arraycopy(this.buf, i, cArr, 0, i2);
        return cArr;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final java.lang.String numberString() {
        int i = this.np;
        if (i == -1) {
            i = 0;
        }
        char cCharAt = charAt((this.sp + i) - 1);
        int i2 = this.sp;
        if (cCharAt == 'L' || cCharAt == 'S' || cCharAt == 'B' || cCharAt == 'F' || cCharAt == 'D') {
            i2--;
        }
        return new java.lang.String(this.buf, i, i2);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final java.math.BigDecimal decimalValue() {
        int i = this.np;
        if (i == -1) {
            i = 0;
        }
        char cCharAt = charAt((this.sp + i) - 1);
        int i2 = this.sp;
        if (cCharAt == 'L' || cCharAt == 'S' || cCharAt == 'B' || cCharAt == 'F' || cCharAt == 'D') {
            i2--;
        }
        if (i2 > 65535) {
            throw new com.alibaba.fastjson.JSONException("decimal overflow");
        }
        return new java.math.BigDecimal(this.buf, i, i2, java.math.MathContext.UNLIMITED);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        super.close();
        char[] cArr = this.buf;
        if (cArr.length <= 65536) {
            BUF_LOCAL.set(cArr);
        }
        this.buf = null;
        com.alibaba.fastjson.util.IOUtils.close(this.reader);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public boolean isEOF() {
        return this.bufLength == -1 || this.bp == this.buf.length || (this.ch == 26 && this.bp + 1 >= this.buf.length);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final boolean isBlankInput() {
        int i = 0;
        while (true) {
            char c = this.buf[i];
            if (c == 26) {
                this.token = 20;
                return true;
            }
            if (!isWhitespace(c)) {
                return false;
            }
            i++;
        }
    }
}
