package com.alibaba.fastjson.parser;

/* JADX INFO: loaded from: classes.dex */
public final class JSONScanner extends com.alibaba.fastjson.parser.JSONLexerBase {
    private final int len;
    private final java.lang.String text;

    static boolean checkDate(char c, char c2, char c3, char c4, char c5, char c6, int i, int i2) {
        if (c >= '0' && c <= '9' && c2 >= '0' && c2 <= '9' && c3 >= '0' && c3 <= '9' && c4 >= '0' && c4 <= '9') {
            if (c5 == '0') {
                if (c6 < '1' || c6 > '9') {
                    return false;
                }
            } else if (c5 != '1' || (c6 != '0' && c6 != '1' && c6 != '2')) {
                return false;
            }
            if (i == 48) {
                return i2 >= 49 && i2 <= 57;
            }
            if (i != 49 && i != 50) {
                return i == 51 && (i2 == 48 || i2 == 49);
            }
            if (i2 >= 48 && i2 <= 57) {
                return true;
            }
        }
        return false;
    }

    private boolean checkTime(char c, char c2, char c3, char c4, char c5, char c6) {
        if (c == '0') {
            if (c2 < '0' || c2 > '9') {
                return false;
            }
        } else {
            if (c != '1') {
                if (c == '2' && c2 >= '0' && c2 <= '4') {
                }
                return false;
            }
            if (c2 < '0' || c2 > '9') {
                return false;
            }
        }
        if (c3 < '0' || c3 > '5') {
            if (c3 != '6' || c4 != '0') {
                return false;
            }
        } else if (c4 < '0' || c4 > '9') {
            return false;
        }
        if (c5 < '0' || c5 > '5') {
            return c5 == '6' && c6 == '0';
        }
        return c6 >= '0' && c6 <= '9';
    }

    public JSONScanner(java.lang.String str) {
        this(str, com.alibaba.fastjson.JSON.DEFAULT_PARSER_FEATURE);
    }

    public JSONScanner(java.lang.String str, int i) {
        super(i);
        this.text = str;
        this.len = str.length();
        this.bp = -1;
        next();
        if (this.ch == 65279) {
            next();
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final char charAt(int i) {
        return i >= this.len ? com.alibaba.fastjson.parser.JSONLexer.EOI : this.text.charAt(i);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final char next() {
        int i = this.bp + 1;
        this.bp = i;
        char cCharAt = i >= this.len ? com.alibaba.fastjson.parser.JSONLexer.EOI : this.text.charAt(i);
        this.ch = cCharAt;
        return cCharAt;
    }

    public JSONScanner(char[] cArr, int i) {
        this(cArr, i, com.alibaba.fastjson.JSON.DEFAULT_PARSER_FEATURE);
    }

    public JSONScanner(char[] cArr, int i, int i2) {
        this(new java.lang.String(cArr, 0, i), i2);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    protected final void copyTo(int i, int i2, char[] cArr) {
        this.text.getChars(i, i2 + i, cArr, 0);
    }

    static boolean charArrayCompare(java.lang.String str, int i, char[] cArr) {
        int length = cArr.length;
        if (length + i > str.length()) {
            return false;
        }
        for (int i2 = 0; i2 < length; i2++) {
            if (cArr[i2] != str.charAt(i + i2)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final boolean charArrayCompare(char[] cArr) {
        return charArrayCompare(this.text, this.bp, cArr);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final int indexOf(char c, int i) {
        return this.text.indexOf(c, i);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final java.lang.String addSymbol(int i, int i2, int i3, com.alibaba.fastjson.parser.SymbolTable symbolTable) {
        return symbolTable.addSymbol(this.text, i, i2, i3);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public byte[] bytesValue() {
        if (this.token == 26) {
            int i = this.np + 1;
            int i2 = this.sp;
            if (i2 % 2 != 0) {
                throw new com.alibaba.fastjson.JSONException("illegal state. " + i2);
            }
            int i3 = i2 / 2;
            byte[] bArr = new byte[i3];
            for (int i4 = 0; i4 < i3; i4++) {
                int i5 = (i4 * 2) + i;
                char cCharAt = this.text.charAt(i5);
                char cCharAt2 = this.text.charAt(i5 + 1);
                char c = '0';
                int i6 = cCharAt - (cCharAt <= '9' ? '0' : '7');
                if (cCharAt2 > '9') {
                    c = '7';
                }
                bArr[i4] = (byte) ((i6 << 4) | (cCharAt2 - c));
            }
            return bArr;
        }
        if (!this.hasSpecial) {
            return com.alibaba.fastjson.util.IOUtils.decodeBase64(this.text, this.np + 1, this.sp);
        }
        return com.alibaba.fastjson.util.IOUtils.decodeBase64(new java.lang.String(this.sbuf, 0, this.sp));
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final java.lang.String stringVal() {
        if (!this.hasSpecial) {
            return subString(this.np + 1, this.sp);
        }
        return new java.lang.String(this.sbuf, 0, this.sp);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final java.lang.String subString(int i, int i2) {
        if (com.alibaba.fastjson.util.ASMUtils.IS_ANDROID) {
            if (i2 < this.sbuf.length) {
                this.text.getChars(i, i + i2, this.sbuf, 0);
                return new java.lang.String(this.sbuf, 0, i2);
            }
            char[] cArr = new char[i2];
            this.text.getChars(i, i2 + i, cArr, 0);
            return new java.lang.String(cArr);
        }
        return this.text.substring(i, i2 + i);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final char[] sub_chars(int i, int i2) {
        if (com.alibaba.fastjson.util.ASMUtils.IS_ANDROID && i2 < this.sbuf.length) {
            this.text.getChars(i, i2 + i, this.sbuf, 0);
            return this.sbuf;
        }
        char[] cArr = new char[i2];
        this.text.getChars(i, i2 + i, cArr, 0);
        return cArr;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final java.lang.String numberString() {
        char cCharAt = charAt((this.np + this.sp) - 1);
        int i = this.sp;
        if (cCharAt == 'L' || cCharAt == 'S' || cCharAt == 'B' || cCharAt == 'F' || cCharAt == 'D') {
            i--;
        }
        return subString(this.np, i);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final java.math.BigDecimal decimalValue() {
        char cCharAt = charAt((this.np + this.sp) - 1);
        int i = this.sp;
        if (cCharAt == 'L' || cCharAt == 'S' || cCharAt == 'B' || cCharAt == 'F' || cCharAt == 'D') {
            i--;
        }
        if (i > 65535) {
            throw new com.alibaba.fastjson.JSONException("decimal overflow");
        }
        int i2 = this.np;
        if (i < this.sbuf.length) {
            this.text.getChars(i2, i2 + i, this.sbuf, 0);
            return new java.math.BigDecimal(this.sbuf, 0, i, java.math.MathContext.UNLIMITED);
        }
        char[] cArr = new char[i];
        this.text.getChars(i2, i2 + i, cArr, 0);
        return new java.math.BigDecimal(cArr, 0, i, java.math.MathContext.UNLIMITED);
    }

    public boolean scanISO8601DateIfMatch() {
        return scanISO8601DateIfMatch(true);
    }

    public boolean scanISO8601DateIfMatch(boolean z) {
        return scanISO8601DateIfMatch(z, this.len - this.bp);
    }

    /* JADX WARN: Code duplicated, block: B:310:0x05c3  */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00ed, code lost:
    
        if (r5 != ' ') goto L48;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean scanISO8601DateIfMatch(boolean r42, int r43) {
        /*
            Method dump skipped, instruction units count: 1881
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONScanner.scanISO8601DateIfMatch(boolean, int):boolean");
    }

    protected void setTime(char c, char c2, char c3, char c4, char c5, char c6) {
        this.calendar.set(11, ((c - '0') * 10) + (c2 - '0'));
        this.calendar.set(12, ((c3 - '0') * 10) + (c4 - '0'));
        this.calendar.set(13, ((c5 - '0') * 10) + (c6 - '0'));
    }

    protected void setTimeZone(char c, char c2, char c3) {
        setTimeZone(c, c2, c3, '0', '0');
    }

    protected void setTimeZone(char c, char c2, char c3, char c4, char c5) {
        int i = ((((c2 - '0') * 10) + (c3 - '0')) * 3600000) + ((((c4 - '0') * 10) + (c5 - '0')) * com.taobao.weex.common.WXRequest.DEFAULT_TIMEOUT_MS);
        if (c == '-') {
            i = -i;
        }
        if (this.calendar.getTimeZone().getRawOffset() != i) {
            this.calendar.setTimeZone(new java.util.SimpleTimeZone(i, java.lang.Integer.toString(i)));
        }
    }

    private void setCalendar(char c, char c2, char c3, char c4, char c5, char c6, char c7, char c8) {
        this.calendar = java.util.Calendar.getInstance(this.timeZone, this.locale);
        this.calendar.set(1, ((c - '0') * 1000) + ((c2 - '0') * 100) + ((c3 - '0') * 10) + (c4 - '0'));
        this.calendar.set(2, (((c5 - '0') * 10) + (c6 - '0')) - 1);
        this.calendar.set(5, ((c7 - '0') * 10) + (c8 - '0'));
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public boolean isEOF() {
        return this.bp == this.len || (this.ch == 26 && this.bp + 1 >= this.len);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public int scanFieldInt(char[] cArr) {
        int i;
        char cCharAt;
        this.matchStat = 0;
        int i2 = this.bp;
        char c = this.ch;
        if (!charArrayCompare(this.text, this.bp, cArr)) {
            this.matchStat = -2;
            return 0;
        }
        int length = this.bp + cArr.length;
        int i3 = length + 1;
        char cCharAt2 = charAt(length);
        boolean z = cCharAt2 == '\"';
        if (z) {
            cCharAt2 = charAt(i3);
            i3 = length + 2;
        }
        boolean z2 = cCharAt2 == '-';
        if (z2) {
            cCharAt2 = charAt(i3);
            i3++;
        }
        if (cCharAt2 < '0' || cCharAt2 > '9') {
            this.matchStat = -1;
            return 0;
        }
        int i4 = cCharAt2 - '0';
        while (true) {
            i = i3 + 1;
            cCharAt = charAt(i3);
            if (cCharAt < '0' || cCharAt > '9') {
                break;
            }
            int i5 = i4 * 10;
            if (i5 < i4) {
                this.matchStat = -1;
                return 0;
            }
            i4 = i5 + (cCharAt - '0');
            i3 = i;
        }
        if (cCharAt == '.') {
            this.matchStat = -1;
            return 0;
        }
        if (i4 < 0) {
            this.matchStat = -1;
            return 0;
        }
        if (z) {
            if (cCharAt != '\"') {
                this.matchStat = -1;
                return 0;
            }
            int i6 = i3 + 2;
            cCharAt = charAt(i);
            i = i6;
        }
        while (cCharAt != ',' && cCharAt != '}') {
            if (isWhitespace(cCharAt)) {
                int i7 = i + 1;
                cCharAt = charAt(i);
                i = i7;
            } else {
                this.matchStat = -1;
                return 0;
            }
        }
        int i8 = i - 1;
        this.bp = i8;
        if (cCharAt == ',') {
            int i9 = this.bp + 1;
            this.bp = i9;
            this.ch = charAt(i9);
            this.matchStat = 3;
            this.token = 16;
            if (z2) {
                return -i4;
            }
        } else {
            if (cCharAt == '}') {
                this.bp = i8;
                int i10 = this.bp + 1;
                this.bp = i10;
                char cCharAt3 = charAt(i10);
                while (true) {
                    if (cCharAt3 == ',') {
                        this.token = 16;
                        int i11 = this.bp + 1;
                        this.bp = i11;
                        this.ch = charAt(i11);
                        break;
                    }
                    if (cCharAt3 == ']') {
                        this.token = 15;
                        int i12 = this.bp + 1;
                        this.bp = i12;
                        this.ch = charAt(i12);
                        break;
                    }
                    if (cCharAt3 == '}') {
                        this.token = 13;
                        int i13 = this.bp + 1;
                        this.bp = i13;
                        this.ch = charAt(i13);
                        break;
                    }
                    if (cCharAt3 == 26) {
                        this.token = 20;
                        break;
                    }
                    if (isWhitespace(cCharAt3)) {
                        int i14 = this.bp + 1;
                        this.bp = i14;
                        cCharAt3 = charAt(i14);
                    } else {
                        this.bp = i2;
                        this.ch = c;
                        this.matchStat = -1;
                        return 0;
                    }
                }
                this.matchStat = 4;
            }
            if (z2) {
                return -i4;
            }
        }
        return i4;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public java.lang.String scanFieldString(char[] cArr) {
        this.matchStat = 0;
        int i = this.bp;
        char c = this.ch;
        while (!charArrayCompare(this.text, this.bp, cArr)) {
            if (isWhitespace(this.ch)) {
                next();
                while (isWhitespace(this.ch)) {
                    next();
                }
            } else {
                this.matchStat = -2;
                return stringDefaultValue();
            }
        }
        int length = this.bp + cArr.length;
        int i2 = length + 1;
        char cCharAt = charAt(length);
        int i3 = 0;
        if (cCharAt != '\"') {
            while (isWhitespace(cCharAt)) {
                i3++;
                int i4 = i2 + 1;
                char cCharAt2 = charAt(i2);
                i2 = i4;
                cCharAt = cCharAt2;
            }
            if (cCharAt != '\"') {
                this.matchStat = -1;
                return stringDefaultValue();
            }
        }
        int iIndexOf = indexOf('\"', i2);
        if (iIndexOf == -1) {
            throw new com.alibaba.fastjson.JSONException("unclosed str");
        }
        java.lang.String strSubString = subString(i2, iIndexOf - i2);
        if (strSubString.indexOf(92) != -1) {
            while (true) {
                int i5 = 0;
                for (int i6 = iIndexOf - 1; i6 >= 0 && charAt(i6) == '\\'; i6--) {
                    i5++;
                }
                if (i5 % 2 == 0) {
                    break;
                }
                iIndexOf = indexOf('\"', iIndexOf + 1);
            }
            int length2 = iIndexOf - (((this.bp + cArr.length) + 1) + i3);
            strSubString = readString(sub_chars(this.bp + cArr.length + 1 + i3, length2), length2);
        }
        if ((this.features & com.alibaba.fastjson.parser.Feature.TrimStringFieldValue.mask) != 0) {
            strSubString = strSubString.trim();
        }
        char cCharAt3 = charAt(iIndexOf + 1);
        while (cCharAt3 != ',' && cCharAt3 != '}') {
            if (isWhitespace(cCharAt3)) {
                char cCharAt4 = charAt(iIndexOf + 2);
                iIndexOf++;
                cCharAt3 = cCharAt4;
            } else {
                this.matchStat = -1;
                return stringDefaultValue();
            }
        }
        this.bp = iIndexOf + 1;
        this.ch = cCharAt3;
        if (cCharAt3 == ',') {
            int i7 = this.bp + 1;
            this.bp = i7;
            this.ch = charAt(i7);
            this.matchStat = 3;
            return strSubString;
        }
        int i8 = this.bp + 1;
        this.bp = i8;
        char cCharAt5 = charAt(i8);
        if (cCharAt5 == ',') {
            this.token = 16;
            int i9 = this.bp + 1;
            this.bp = i9;
            this.ch = charAt(i9);
        } else if (cCharAt5 == ']') {
            this.token = 15;
            int i10 = this.bp + 1;
            this.bp = i10;
            this.ch = charAt(i10);
        } else if (cCharAt5 == '}') {
            this.token = 13;
            int i11 = this.bp + 1;
            this.bp = i11;
            this.ch = charAt(i11);
        } else if (cCharAt5 == 26) {
            this.token = 20;
        } else {
            this.bp = i;
            this.ch = c;
            this.matchStat = -1;
            return stringDefaultValue();
        }
        this.matchStat = 4;
        return strSubString;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public java.util.Date scanFieldDate(char[] cArr) {
        java.util.Date date;
        char cCharAt;
        long j;
        java.util.Date date2;
        char cCharAt2;
        boolean z = false;
        this.matchStat = 0;
        int i = this.bp;
        char c = this.ch;
        java.util.Date date3 = null;
        if (!charArrayCompare(this.text, this.bp, cArr)) {
            this.matchStat = -2;
            return null;
        }
        int length = this.bp + cArr.length;
        int i2 = length + 1;
        char cCharAt3 = charAt(length);
        if (cCharAt3 == '\"') {
            int iIndexOf = indexOf('\"', i2);
            if (iIndexOf == -1) {
                throw new com.alibaba.fastjson.JSONException("unclosed str");
            }
            this.bp = i2;
            if (scanISO8601DateIfMatch(false, iIndexOf - i2)) {
                date2 = this.calendar.getTime();
                cCharAt2 = charAt(iIndexOf + 1);
                this.bp = i;
                while (cCharAt2 != ',' && cCharAt2 != '}') {
                    if (isWhitespace(cCharAt2)) {
                        int i3 = iIndexOf + 1;
                        char cCharAt4 = charAt(iIndexOf + 2);
                        iIndexOf = i3;
                        cCharAt2 = cCharAt4;
                    } else {
                        this.matchStat = -1;
                        return null;
                    }
                }
                this.bp = iIndexOf + 1;
                this.ch = cCharAt2;
                date = null;
            } else {
                this.bp = i;
                this.matchStat = -1;
                return null;
            }
        } else {
            char c2 = '9';
            if (cCharAt3 != '-' && (cCharAt3 < '0' || cCharAt3 > '9')) {
                this.matchStat = -1;
                return null;
            }
            if (cCharAt3 == '-') {
                cCharAt3 = charAt(i2);
                i2 = length + 2;
                z = true;
            }
            if (cCharAt3 < '0' || cCharAt3 > '9') {
                date = null;
                cCharAt = cCharAt3;
                j = 0;
            } else {
                j = cCharAt3 - '0';
                while (true) {
                    int i4 = i2 + 1;
                    date = date3;
                    cCharAt = charAt(i2);
                    if (cCharAt < '0' || cCharAt > c2) {
                        break;
                    }
                    j = (j * 10) + ((long) (cCharAt - '0'));
                    i2 = i4;
                    date3 = date;
                    c2 = '9';
                }
                if (cCharAt == ',' || cCharAt == '}') {
                    this.bp = i2;
                }
            }
            if (j < 0) {
                this.matchStat = -1;
                return date;
            }
            if (z) {
                j = -j;
            }
            date2 = new java.util.Date(j);
            cCharAt2 = cCharAt;
        }
        if (cCharAt2 == ',') {
            int i5 = this.bp + 1;
            this.bp = i5;
            this.ch = charAt(i5);
            this.matchStat = 3;
            this.token = 16;
            return date2;
        }
        int i6 = this.bp + 1;
        this.bp = i6;
        char cCharAt5 = charAt(i6);
        if (cCharAt5 == ',') {
            this.token = 16;
            int i7 = this.bp + 1;
            this.bp = i7;
            this.ch = charAt(i7);
        } else if (cCharAt5 == ']') {
            this.token = 15;
            int i8 = this.bp + 1;
            this.bp = i8;
            this.ch = charAt(i8);
        } else if (cCharAt5 == '}') {
            this.token = 13;
            int i9 = this.bp + 1;
            this.bp = i9;
            this.ch = charAt(i9);
        } else if (cCharAt5 == 26) {
            this.token = 20;
        } else {
            this.bp = i;
            this.ch = c;
            this.matchStat = -1;
            return date;
        }
        this.matchStat = 4;
        return date2;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public long scanFieldSymbol(char[] cArr) {
        this.matchStat = 0;
        while (!charArrayCompare(this.text, this.bp, cArr)) {
            if (isWhitespace(this.ch)) {
                next();
                while (isWhitespace(this.ch)) {
                    next();
                }
            } else {
                this.matchStat = -2;
                return 0L;
            }
        }
        int length = this.bp + cArr.length;
        int i = length + 1;
        char cCharAt = charAt(length);
        if (cCharAt != '\"') {
            while (isWhitespace(cCharAt)) {
                cCharAt = charAt(i);
                i++;
            }
            if (cCharAt != '\"') {
                this.matchStat = -1;
                return 0L;
            }
        }
        long j = com.alibaba.fastjson.util.TypeUtils.fnv1a_64_magic_hashcode;
        while (true) {
            int i2 = i + 1;
            char cCharAt2 = charAt(i);
            if (cCharAt2 == '\"') {
                this.bp = i2;
                char cCharAt3 = charAt(this.bp);
                this.ch = cCharAt3;
                while (cCharAt3 != ',') {
                    if (cCharAt3 == '}') {
                        next();
                        skipWhitespace();
                        char current = getCurrent();
                        if (current == ',') {
                            this.token = 16;
                            int i3 = this.bp + 1;
                            this.bp = i3;
                            this.ch = charAt(i3);
                        } else if (current == ']') {
                            this.token = 15;
                            int i4 = this.bp + 1;
                            this.bp = i4;
                            this.ch = charAt(i4);
                        } else if (current == '}') {
                            this.token = 13;
                            int i5 = this.bp + 1;
                            this.bp = i5;
                            this.ch = charAt(i5);
                        } else if (current == 26) {
                            this.token = 20;
                        } else {
                            this.matchStat = -1;
                            return 0L;
                        }
                        this.matchStat = 4;
                        return j;
                    }
                    if (isWhitespace(cCharAt3)) {
                        int i6 = this.bp + 1;
                        this.bp = i6;
                        cCharAt3 = charAt(i6);
                    } else {
                        this.matchStat = -1;
                        return 0L;
                    }
                }
                int i7 = this.bp + 1;
                this.bp = i7;
                this.ch = charAt(i7);
                this.matchStat = 3;
                return j;
            }
            if (i2 > this.len) {
                this.matchStat = -1;
                return 0L;
            }
            j = (j ^ ((long) cCharAt2)) * com.alibaba.fastjson.util.TypeUtils.fnv1a_64_magic_prime;
            i = i2;
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public java.util.Collection<java.lang.String> scanFieldStringArray(char[] cArr, java.lang.Class<?> cls) {
        int i;
        char cCharAt;
        char cCharAt2;
        int i2;
        this.matchStat = 0;
        while (true) {
            if (this.ch != '\n' && this.ch != ' ') {
                break;
            }
            int i3 = this.bp + 1;
            this.bp = i3;
            this.ch = i3 >= this.len ? com.alibaba.fastjson.parser.JSONLexer.EOI : this.text.charAt(i3);
        }
        if (!charArrayCompare(this.text, this.bp, cArr)) {
            this.matchStat = -2;
            return null;
        }
        java.util.Collection<java.lang.String> collectionNewCollectionByType = newCollectionByType(cls);
        int i4 = this.bp;
        char c = this.ch;
        int length = this.bp + cArr.length;
        int i5 = length + 1;
        if (charAt(length) != '[') {
            if (this.text.startsWith("ull", i5)) {
                i = length + 5;
                cCharAt = charAt(length + 4);
                collectionNewCollectionByType = null;
            } else {
                this.matchStat = -1;
                return null;
            }
        } else {
            int i6 = length + 2;
            char cCharAt3 = charAt(i5);
            while (true) {
                if (cCharAt3 != '\"') {
                    if (cCharAt3 == 'n' && this.text.startsWith("ull", i6)) {
                        char cCharAt4 = charAt(i6 + 3);
                        collectionNewCollectionByType.add(null);
                        cCharAt2 = cCharAt4;
                        i2 = i6 + 4;
                    } else {
                        if (cCharAt3 == ']' && collectionNewCollectionByType.size() == 0) {
                            i = i6 + 1;
                            cCharAt = charAt(i6);
                            break;
                        }
                        this.matchStat = -1;
                        return null;
                    }
                } else {
                    int iIndexOf = indexOf('\"', i6);
                    if (iIndexOf == -1) {
                        throw new com.alibaba.fastjson.JSONException("unclosed str");
                    }
                    java.lang.String strSubString = subString(i6, iIndexOf - i6);
                    if (strSubString.indexOf(92) != -1) {
                        while (true) {
                            int i7 = 0;
                            for (int i8 = iIndexOf - 1; i8 >= 0 && charAt(i8) == '\\'; i8--) {
                                i7++;
                            }
                            if (i7 % 2 == 0) {
                                break;
                            }
                            iIndexOf = indexOf('\"', iIndexOf + 1);
                        }
                        int i9 = iIndexOf - i6;
                        strSubString = readString(sub_chars(i6, i9), i9);
                    }
                    int i10 = iIndexOf + 1;
                    i2 = iIndexOf + 2;
                    cCharAt2 = charAt(i10);
                    collectionNewCollectionByType.add(strSubString);
                }
                if (cCharAt2 != ',') {
                    if (cCharAt2 == ']') {
                        i = i2 + 1;
                        cCharAt = charAt(i2);
                        while (isWhitespace(cCharAt)) {
                            int i11 = i + 1;
                            char cCharAt5 = charAt(i);
                            i = i11;
                            cCharAt = cCharAt5;
                        }
                        break;
                    }
                    this.matchStat = -1;
                    return null;
                }
                i6 = i2 + 1;
                cCharAt3 = charAt(i2);
            }
        }
        this.bp = i;
        if (cCharAt == ',') {
            this.ch = charAt(this.bp);
            this.matchStat = 3;
            return collectionNewCollectionByType;
        }
        if (cCharAt == '}') {
            char cCharAt6 = charAt(this.bp);
            while (cCharAt6 != ',') {
                if (cCharAt6 == ']') {
                    this.token = 15;
                    int i12 = this.bp + 1;
                    this.bp = i12;
                    this.ch = charAt(i12);
                } else if (cCharAt6 == '}') {
                    this.token = 13;
                    int i13 = this.bp + 1;
                    this.bp = i13;
                    this.ch = charAt(i13);
                } else if (cCharAt6 == 26) {
                    this.token = 20;
                    this.ch = cCharAt6;
                } else {
                    boolean z = false;
                    while (isWhitespace(cCharAt6)) {
                        int i14 = i + 1;
                        char cCharAt7 = charAt(i);
                        this.bp = i14;
                        i = i14;
                        cCharAt6 = cCharAt7;
                        z = true;
                    }
                    if (!z) {
                        this.matchStat = -1;
                        return null;
                    }
                }
                this.matchStat = 4;
                return collectionNewCollectionByType;
            }
            this.token = 16;
            int i15 = this.bp + 1;
            this.bp = i15;
            this.ch = charAt(i15);
            this.matchStat = 4;
            return collectionNewCollectionByType;
        }
        this.ch = c;
        this.bp = i4;
        this.matchStat = -1;
        return null;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public long scanFieldLong(char[] cArr) {
        int i;
        long j;
        char cCharAt;
        boolean z = false;
        this.matchStat = 0;
        int i2 = this.bp;
        char c = this.ch;
        long j2 = 0;
        if (!charArrayCompare(this.text, this.bp, cArr)) {
            this.matchStat = -2;
            return 0L;
        }
        int length = this.bp + cArr.length;
        int i3 = length + 1;
        char cCharAt2 = charAt(length);
        boolean z2 = cCharAt2 == '\"';
        if (z2) {
            cCharAt2 = charAt(i3);
            i3 = length + 2;
        }
        if (cCharAt2 == '-') {
            cCharAt2 = charAt(i3);
            i3++;
            z = true;
        }
        if (cCharAt2 < '0' || cCharAt2 > '9') {
            this.bp = i2;
            this.ch = c;
            this.matchStat = -1;
            return 0L;
        }
        long j3 = cCharAt2 - '0';
        while (true) {
            i = i3 + 1;
            j = j2;
            cCharAt = charAt(i3);
            if (cCharAt < '0' || cCharAt > '9') {
                break;
            }
            j3 = (j3 * 10) + ((long) (cCharAt - '0'));
            i3 = i;
            j2 = j;
        }
        if (cCharAt == '.') {
            this.matchStat = -1;
            return j;
        }
        if (z2) {
            if (cCharAt != '\"') {
                this.matchStat = -1;
                return j;
            }
            cCharAt = charAt(i);
            i = i3 + 2;
        }
        if (cCharAt == ',' || cCharAt == '}') {
            this.bp = i - 1;
        }
        if (j3 < j && (j3 != Long.MIN_VALUE || !z)) {
            this.bp = i2;
            this.ch = c;
            this.matchStat = -1;
            return j;
        }
        while (cCharAt != ',') {
            if (cCharAt == '}') {
                int i4 = this.bp + 1;
                this.bp = i4;
                char cCharAt3 = charAt(i4);
                while (true) {
                    if (cCharAt3 == ',') {
                        this.token = 16;
                        int i5 = this.bp + 1;
                        this.bp = i5;
                        this.ch = charAt(i5);
                        break;
                    }
                    if (cCharAt3 == ']') {
                        this.token = 15;
                        int i6 = this.bp + 1;
                        this.bp = i6;
                        this.ch = charAt(i6);
                        break;
                    }
                    if (cCharAt3 == '}') {
                        this.token = 13;
                        int i7 = this.bp + 1;
                        this.bp = i7;
                        this.ch = charAt(i7);
                        break;
                    }
                    if (cCharAt3 == 26) {
                        this.token = 20;
                        break;
                    }
                    if (isWhitespace(cCharAt3)) {
                        int i8 = this.bp + 1;
                        this.bp = i8;
                        cCharAt3 = charAt(i8);
                    } else {
                        this.bp = i2;
                        this.ch = c;
                        this.matchStat = -1;
                        return j;
                    }
                }
                this.matchStat = 4;
                if (z) {
                    return -j3;
                }
                return j3;
            }
            if (isWhitespace(cCharAt)) {
                this.bp = i;
                char cCharAt4 = charAt(i);
                i++;
                cCharAt = cCharAt4;
            } else {
                this.matchStat = -1;
                return j;
            }
        }
        int i9 = this.bp + 1;
        this.bp = i9;
        this.ch = charAt(i9);
        this.matchStat = 3;
        this.token = 16;
        if (z) {
            return -j3;
        }
        return j3;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x016d  */
    /* JADX WARN: Code duplicated, block: B:104:0x0173 A[LOOP:0: B:78:0x00f5->B:104:0x0173, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:109:0x0110 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:110:0x017e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:113:0x016a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:115:0x012d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:116:0x013f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:117:0x0153 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:82:0x010c  */
    /* JADX WARN: Code duplicated, block: B:87:0x0129  */
    /* JADX WARN: Code duplicated, block: B:90:0x013d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:92:0x014f  */
    /* JADX WARN: Code duplicated, block: B:97:0x015a  */
    /* JADX WARN: Code duplicated, block: B:99:0x0160 A[LOOP:1: B:85:0x0119->B:99:0x0160, LOOP_END] */
    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public boolean scanFieldBoolean(char[] cArr) {
        char cCharAt;
        boolean z;
        char cCharAt2;
        this.matchStat = 0;
        if (!charArrayCompare(this.text, this.bp, cArr)) {
            this.matchStat = -2;
            return false;
        }
        int i = this.bp;
        int length = this.bp + cArr.length;
        int i2 = length + 1;
        char cCharAt3 = charAt(length);
        boolean z2 = cCharAt3 == '\"';
        if (z2) {
            cCharAt3 = charAt(i2);
            i2 = length + 2;
        }
        if (cCharAt3 == 't') {
            int i3 = i2 + 1;
            if (charAt(i2) != 'r') {
                this.matchStat = -1;
                return false;
            }
            int i4 = i2 + 2;
            if (charAt(i3) != 'u') {
                this.matchStat = -1;
                return false;
            }
            int i5 = i2 + 3;
            if (charAt(i4) != 'e') {
                this.matchStat = -1;
                return false;
            }
            if (z2) {
                int i6 = i2 + 4;
                if (charAt(i5) != '\"') {
                    this.matchStat = -1;
                    return false;
                }
                i5 = i6;
            }
            this.bp = i5;
            cCharAt = charAt(this.bp);
        } else {
            if (cCharAt3 == 'f') {
                int i7 = i2 + 1;
                if (charAt(i2) != 'a') {
                    this.matchStat = -1;
                    return false;
                }
                int i8 = i2 + 2;
                if (charAt(i7) != 'l') {
                    this.matchStat = -1;
                    return false;
                }
                int i9 = i2 + 3;
                if (charAt(i8) != 's') {
                    this.matchStat = -1;
                    return false;
                }
                int i10 = i2 + 4;
                if (charAt(i9) != 'e') {
                    this.matchStat = -1;
                    return false;
                }
                if (z2) {
                    int i11 = i2 + 5;
                    if (charAt(i10) != '\"') {
                        this.matchStat = -1;
                        return false;
                    }
                    i10 = i11;
                }
                this.bp = i10;
                cCharAt = charAt(this.bp);
            } else if (cCharAt3 == '1') {
                if (z2) {
                    int i12 = i2 + 1;
                    if (charAt(i2) != '\"') {
                        this.matchStat = -1;
                        return false;
                    }
                    i2 = i12;
                }
                this.bp = i2;
                cCharAt = charAt(this.bp);
            } else if (cCharAt3 == '0') {
                if (z2) {
                    int i13 = i2 + 1;
                    if (charAt(i2) != '\"') {
                        this.matchStat = -1;
                        return false;
                    }
                    i2 = i13;
                }
                this.bp = i2;
                cCharAt = charAt(this.bp);
            } else {
                this.matchStat = -1;
                return false;
            }
            z = false;
            while (cCharAt != ',') {
                if (cCharAt == '}') {
                    int i14 = this.bp + 1;
                    this.bp = i14;
                    cCharAt2 = charAt(i14);
                    while (cCharAt2 != ',') {
                        if (cCharAt2 == ']') {
                            this.token = 15;
                            int i15 = this.bp + 1;
                            this.bp = i15;
                            this.ch = charAt(i15);
                        } else if (cCharAt2 == '}') {
                            this.token = 13;
                            int i16 = this.bp + 1;
                            this.bp = i16;
                            this.ch = charAt(i16);
                        } else if (cCharAt2 == 26) {
                            this.token = 20;
                        } else if (isWhitespace(cCharAt2)) {
                            int i17 = this.bp + 1;
                            this.bp = i17;
                            cCharAt2 = charAt(i17);
                        } else {
                            this.matchStat = -1;
                            return false;
                        }
                        this.matchStat = 4;
                        return z;
                    }
                    this.token = 16;
                    int i18 = this.bp + 1;
                    this.bp = i18;
                    this.ch = charAt(i18);
                    this.matchStat = 4;
                    return z;
                }
                if (isWhitespace(cCharAt)) {
                    int i19 = this.bp + 1;
                    this.bp = i19;
                    cCharAt = charAt(i19);
                } else {
                    this.bp = i;
                    charAt(this.bp);
                    this.matchStat = -1;
                    return false;
                }
            }
            int i20 = this.bp + 1;
            this.bp = i20;
            this.ch = charAt(i20);
            this.matchStat = 3;
            this.token = 16;
            return z;
        }
        z = true;
        while (cCharAt != ',') {
            if (cCharAt == '}') {
                int i110 = this.bp + 1;
                this.bp = i110;
                cCharAt2 = charAt(i110);
                while (cCharAt2 != ',') {
                    if (cCharAt2 == ']') {
                        this.token = 15;
                        int i111 = this.bp + 1;
                        this.bp = i111;
                        this.ch = charAt(i111);
                    } else if (cCharAt2 == '}') {
                        this.token = 13;
                        int i112 = this.bp + 1;
                        this.bp = i112;
                        this.ch = charAt(i112);
                    } else if (cCharAt2 == 26) {
                        this.token = 20;
                    } else if (isWhitespace(cCharAt2)) {
                        int i113 = this.bp + 1;
                        this.bp = i113;
                        cCharAt2 = charAt(i113);
                    } else {
                        this.matchStat = -1;
                        return false;
                    }
                    this.matchStat = 4;
                    return z;
                }
                this.token = 16;
                int i114 = this.bp + 1;
                this.bp = i114;
                this.ch = charAt(i114);
                this.matchStat = 4;
                return z;
            }
            if (isWhitespace(cCharAt)) {
                int i115 = this.bp + 1;
                this.bp = i115;
                cCharAt = charAt(i115);
            } else {
                this.bp = i;
                charAt(this.bp);
                this.matchStat = -1;
                return false;
            }
        }
        int i21 = this.bp + 1;
        this.bp = i21;
        this.ch = charAt(i21);
        this.matchStat = 3;
        this.token = 16;
        return z;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public final int scanInt(char c) {
        int i;
        char cCharAt;
        this.matchStat = 0;
        int i2 = this.bp;
        int i3 = this.bp;
        int i4 = i3 + 1;
        char cCharAt2 = charAt(i3);
        while (isWhitespace(cCharAt2)) {
            int i5 = i4 + 1;
            char cCharAt3 = charAt(i4);
            i4 = i5;
            cCharAt2 = cCharAt3;
        }
        boolean z = cCharAt2 == '\"';
        if (z) {
            int i6 = i4 + 1;
            char cCharAt4 = charAt(i4);
            i4 = i6;
            cCharAt2 = cCharAt4;
        }
        boolean z2 = cCharAt2 == '-';
        if (z2) {
            int i7 = i4 + 1;
            char cCharAt5 = charAt(i4);
            i4 = i7;
            cCharAt2 = cCharAt5;
        }
        if (cCharAt2 < '0' || cCharAt2 > '9') {
            if (cCharAt2 == 'n') {
                int i8 = i4 + 1;
                if (charAt(i4) == 'u') {
                    int i9 = i4 + 2;
                    if (charAt(i8) == 'l') {
                        int i10 = i4 + 3;
                        if (charAt(i9) == 'l') {
                            this.matchStat = 5;
                            int i11 = i4 + 4;
                            char cCharAt6 = charAt(i10);
                            if (z && cCharAt6 == '\"') {
                                cCharAt6 = charAt(i11);
                                i11 = i4 + 5;
                            }
                            while (cCharAt6 != ',') {
                                if (cCharAt6 == ']') {
                                    this.bp = i11;
                                    this.ch = charAt(this.bp);
                                    this.matchStat = 5;
                                    this.token = 15;
                                    return 0;
                                }
                                if (isWhitespace(cCharAt6)) {
                                    char cCharAt7 = charAt(i11);
                                    i11++;
                                    cCharAt6 = cCharAt7;
                                } else {
                                    this.matchStat = -1;
                                    return 0;
                                }
                            }
                            this.bp = i11;
                            this.ch = charAt(this.bp);
                            this.matchStat = 5;
                            this.token = 16;
                            return 0;
                        }
                    }
                }
            }
            this.matchStat = -1;
            return 0;
        }
        int i12 = cCharAt2 - '0';
        while (true) {
            i = i4 + 1;
            cCharAt = charAt(i4);
            if (cCharAt < '0' || cCharAt > '9') {
                break;
            }
            int i13 = i12 * 10;
            if (i13 < i12) {
                throw new com.alibaba.fastjson.JSONException("parseInt error : " + subString(i2, i4));
            }
            i12 = i13 + (cCharAt - '0');
            i4 = i;
        }
        if (cCharAt == '.') {
            this.matchStat = -1;
            return 0;
        }
        if (z) {
            if (cCharAt != '\"') {
                this.matchStat = -1;
                return 0;
            }
            cCharAt = charAt(i);
            i = i4 + 2;
        }
        if (i12 < 0) {
            this.matchStat = -1;
            return 0;
        }
        while (cCharAt != c) {
            if (isWhitespace(cCharAt)) {
                cCharAt = charAt(i);
                i++;
            } else {
                this.matchStat = -1;
                if (z2) {
                    return -i12;
                }
                return i12;
            }
        }
        this.bp = i;
        this.ch = charAt(this.bp);
        this.matchStat = 3;
        this.token = 16;
        if (z2) {
            return -i12;
        }
        return i12;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public double scanDouble(char c) {
        int i;
        char cCharAt;
        long j;
        long j2;
        int i2;
        int i3;
        int i4;
        double d;
        int i5;
        char cCharAt2;
        this.matchStat = 0;
        int i6 = this.bp;
        int i7 = i6 + 1;
        char cCharAt3 = charAt(i6);
        boolean z = cCharAt3 == '\"';
        if (z) {
            cCharAt3 = charAt(i7);
            i7 = i6 + 2;
        }
        boolean z2 = cCharAt3 == '-';
        if (z2) {
            cCharAt3 = charAt(i7);
            i7++;
        }
        if (cCharAt3 < '0' || cCharAt3 > '9') {
            boolean z3 = z;
            if (cCharAt3 == 'n') {
                int i8 = i7 + 1;
                if (charAt(i7) == 'u') {
                    int i9 = i7 + 2;
                    if (charAt(i8) == 'l') {
                        int i10 = i7 + 3;
                        if (charAt(i9) == 'l') {
                            this.matchStat = 5;
                            int i11 = i7 + 4;
                            char cCharAt4 = charAt(i10);
                            if (z3 && cCharAt4 == '\"') {
                                cCharAt4 = charAt(i11);
                                i11 = i7 + 5;
                            }
                            while (cCharAt4 != ',') {
                                if (cCharAt4 == ']') {
                                    this.bp = i11;
                                    this.ch = charAt(this.bp);
                                    this.matchStat = 5;
                                    this.token = 15;
                                    return 0.0d;
                                }
                                if (isWhitespace(cCharAt4)) {
                                    int i12 = i11 + 1;
                                    char cCharAt5 = charAt(i11);
                                    i11 = i12;
                                    cCharAt4 = cCharAt5;
                                } else {
                                    this.matchStat = -1;
                                    return 0.0d;
                                }
                            }
                            this.bp = i11;
                            this.ch = charAt(this.bp);
                            this.matchStat = 5;
                            this.token = 16;
                            return 0.0d;
                        }
                    }
                }
            }
            this.matchStat = -1;
            return 0.0d;
        }
        long j3 = cCharAt3 - '0';
        while (true) {
            i = i7 + 1;
            cCharAt = charAt(i7);
            if (cCharAt < '0' || cCharAt > '9') {
                break;
            }
            i7 = i;
            j3 = (j3 * 10) + ((long) (cCharAt - '0'));
        }
        if (cCharAt == '.') {
            int i13 = i7 + 2;
            char cCharAt6 = charAt(i);
            if (cCharAt6 < '0' || cCharAt6 > '9') {
                this.matchStat = -1;
                return 0.0d;
            }
            long j4 = (j3 * 10) + ((long) (cCharAt6 - '0'));
            long j5 = 10;
            while (true) {
                i5 = i13 + 1;
                cCharAt2 = charAt(i13);
                if (cCharAt2 < '0' || cCharAt2 > '9') {
                    break;
                }
                long j6 = (j4 * 10) + ((long) (cCharAt2 - '0'));
                j5 *= 10;
                i13 = i5;
                j4 = j6;
            }
            j = j4;
            j2 = j5;
            i = i5;
            cCharAt = cCharAt2;
        } else {
            j = j3;
            j2 = 1;
        }
        boolean z4 = cCharAt == 'e' || cCharAt == 'E';
        if (z4) {
            int i14 = i + 1;
            char cCharAt7 = charAt(i);
            if (cCharAt7 == '+' || cCharAt7 == '-') {
                i += 2;
                cCharAt = charAt(i14);
            } else {
                i = i14;
                cCharAt = cCharAt7;
            }
            while (cCharAt >= '0' && cCharAt <= '9') {
                char cCharAt8 = charAt(i);
                i++;
                cCharAt = cCharAt8;
            }
        }
        if (!z) {
            i2 = this.bp;
            int i15 = i;
            i3 = (i - i2) - 1;
            i4 = i15;
        } else {
            if (cCharAt != '\"') {
                this.matchStat = -1;
                return 0.0d;
            }
            int i16 = i + 1;
            char cCharAt9 = charAt(i);
            i2 = this.bp + 1;
            i3 = (i16 - i2) - 2;
            i4 = i16;
            cCharAt = cCharAt9;
        }
        if (z4 || i3 >= 18) {
            d = java.lang.Double.parseDouble(subString(i2, i3));
        } else {
            d = j / j2;
            if (z2) {
                d = -d;
            }
        }
        if (cCharAt == c) {
            this.bp = i4;
            this.ch = charAt(this.bp);
            this.matchStat = 3;
            this.token = 16;
            return d;
        }
        this.matchStat = -1;
        return d;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public long scanLong(char c) {
        int i;
        char cCharAt;
        this.matchStat = 0;
        int i2 = this.bp;
        int i3 = i2 + 1;
        char cCharAt2 = charAt(i2);
        boolean z = cCharAt2 == '\"';
        if (z) {
            cCharAt2 = charAt(i3);
            i3 = i2 + 2;
        }
        boolean z2 = cCharAt2 == '-';
        if (z2) {
            cCharAt2 = charAt(i3);
            i3++;
        }
        if (cCharAt2 >= '0' && cCharAt2 <= '9') {
            long j = cCharAt2 - '0';
            while (true) {
                i = i3 + 1;
                cCharAt = charAt(i3);
                if (cCharAt < '0' || cCharAt > '9') {
                    break;
                }
                j = (j * 10) + ((long) (cCharAt - '0'));
                i3 = i;
            }
            if (cCharAt == '.') {
                this.matchStat = -1;
                return 0L;
            }
            if (z) {
                if (cCharAt != '\"') {
                    this.matchStat = -1;
                    return 0L;
                }
                cCharAt = charAt(i);
                i = i3 + 2;
            }
            if (j < 0 && (j != Long.MIN_VALUE || !z2)) {
                this.matchStat = -1;
                return 0L;
            }
            while (cCharAt != c) {
                if (isWhitespace(cCharAt)) {
                    cCharAt = charAt(i);
                    i++;
                } else {
                    this.matchStat = -1;
                    return j;
                }
            }
            this.bp = i;
            this.ch = charAt(this.bp);
            this.matchStat = 3;
            this.token = 16;
            return z2 ? -j : j;
        }
        if (cCharAt2 == 'n') {
            int i4 = i3 + 1;
            if (charAt(i3) == 'u') {
                int i5 = i3 + 2;
                if (charAt(i4) == 'l') {
                    int i6 = i3 + 3;
                    if (charAt(i5) == 'l') {
                        this.matchStat = 5;
                        int i7 = i3 + 4;
                        char cCharAt3 = charAt(i6);
                        if (z && cCharAt3 == '\"') {
                            cCharAt3 = charAt(i7);
                            i7 = i3 + 5;
                        }
                        while (cCharAt3 != ',') {
                            if (cCharAt3 == ']') {
                                this.bp = i7;
                                this.ch = charAt(this.bp);
                                this.matchStat = 5;
                                this.token = 15;
                                return 0L;
                            }
                            if (isWhitespace(cCharAt3)) {
                                char cCharAt4 = charAt(i7);
                                i7++;
                                cCharAt3 = cCharAt4;
                            } else {
                                this.matchStat = -1;
                                return 0L;
                            }
                        }
                        this.bp = i7;
                        this.ch = charAt(this.bp);
                        this.matchStat = 5;
                        this.token = 16;
                        return 0L;
                    }
                }
            }
        }
        this.matchStat = -1;
        return 0L;
    }

    /* JADX WARN: Code duplicated, block: B:61:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:63:0x0107  */
    /* JADX WARN: Code duplicated, block: B:65:0x0113  */
    /* JADX WARN: Code duplicated, block: B:66:0x0124 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:67:0x0126  */
    /* JADX WARN: Code duplicated, block: B:68:0x0137  */
    /* JADX WARN: Code duplicated, block: B:70:0x013b  */
    /* JADX WARN: Code duplicated, block: B:71:0x014c  */
    /* JADX WARN: Code duplicated, block: B:73:0x0150  */
    /* JADX WARN: Code duplicated, block: B:76:0x0159  */
    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public java.util.Date scanDate(char c) {
        long j;
        char cCharAt;
        java.util.Date date;
        char cCharAt2;
        boolean z = false;
        this.matchStat = 0;
        int i = this.bp;
        char c2 = this.ch;
        int i2 = this.bp;
        int i3 = i2 + 1;
        char cCharAt3 = charAt(i2);
        if (cCharAt3 != '\"') {
            if (cCharAt3 != '-' && (cCharAt3 < '0' || cCharAt3 > '9')) {
                if (cCharAt3 == 'n') {
                    int i4 = i2 + 2;
                    if (charAt(i3) == 'u') {
                        int i5 = i2 + 3;
                        if (charAt(i4) == 'l') {
                            int i6 = i2 + 4;
                            if (charAt(i5) == 'l') {
                                cCharAt = charAt(i6);
                                this.bp = i6;
                                date = null;
                            }
                        }
                    }
                }
                this.bp = i;
                this.ch = c2;
                this.matchStat = -1;
                return null;
            }
            if (cCharAt3 == '-') {
                cCharAt3 = charAt(i3);
                i3 = i2 + 2;
                z = true;
            }
            if (cCharAt3 < '0' || cCharAt3 > '9') {
                j = 0;
            } else {
                j = cCharAt3 - '0';
                while (true) {
                    int i7 = i3 + 1;
                    cCharAt3 = charAt(i3);
                    if (cCharAt3 < '0' || cCharAt3 > '9') {
                        break;
                    }
                    j = (j * 10) + ((long) (cCharAt3 - '0'));
                    i3 = i7;
                }
                if (cCharAt3 == ',' || cCharAt3 == ']') {
                    this.bp = i3;
                }
            }
            cCharAt = cCharAt3;
            if (j < 0) {
                this.bp = i;
                this.ch = c2;
                this.matchStat = -1;
                return null;
            }
            if (z) {
                j = -j;
            }
            date = new java.util.Date(j);
            if (cCharAt == ',') {
                int i8 = this.bp + 1;
                this.bp = i8;
                this.ch = charAt(i8);
                this.matchStat = 3;
                return date;
            }
            int i9 = this.bp + 1;
            this.bp = i9;
            cCharAt2 = charAt(i9);
            if (cCharAt2 == ',') {
                this.token = 16;
                int i10 = this.bp + 1;
                this.bp = i10;
                this.ch = charAt(i10);
            } else if (cCharAt2 == ']') {
                this.token = 15;
                int i11 = this.bp + 1;
                this.bp = i11;
                this.ch = charAt(i11);
            } else if (cCharAt2 == '}') {
                this.token = 13;
                int i12 = this.bp + 1;
                this.bp = i12;
                this.ch = charAt(i12);
            } else if (cCharAt2 == 26) {
                this.ch = com.alibaba.fastjson.parser.JSONLexer.EOI;
                this.token = 20;
            } else {
                this.bp = i;
                this.ch = c2;
                this.matchStat = -1;
                return null;
            }
            this.matchStat = 4;
            return date;
        }
        int iIndexOf = indexOf('\"', i3);
        if (iIndexOf == -1) {
            throw new com.alibaba.fastjson.JSONException("unclosed str");
        }
        this.bp = i3;
        if (scanISO8601DateIfMatch(false, iIndexOf - i3)) {
            date = this.calendar.getTime();
            cCharAt = charAt(iIndexOf + 1);
            this.bp = i;
            while (cCharAt != ',' && cCharAt != ']') {
                if (isWhitespace(cCharAt)) {
                    cCharAt = charAt(iIndexOf + 2);
                    iIndexOf++;
                } else {
                    this.bp = i;
                    this.ch = c2;
                    this.matchStat = -1;
                    return null;
                }
            }
            this.bp = iIndexOf + 1;
            this.ch = cCharAt;
        } else {
            this.bp = i;
            this.ch = c2;
            this.matchStat = -1;
            return null;
        }
        if (cCharAt == ',') {
            int i13 = this.bp + 1;
            this.bp = i13;
            this.ch = charAt(i13);
            this.matchStat = 3;
            return date;
        }
        int i14 = this.bp + 1;
        this.bp = i14;
        cCharAt2 = charAt(i14);
        if (cCharAt2 == ',') {
            this.token = 16;
            int i15 = this.bp + 1;
            this.bp = i15;
            this.ch = charAt(i15);
        } else if (cCharAt2 == ']') {
            this.token = 15;
            int i16 = this.bp + 1;
            this.bp = i16;
            this.ch = charAt(i16);
        } else if (cCharAt2 == '}') {
            this.token = 13;
            int i17 = this.bp + 1;
            this.bp = i17;
            this.ch = charAt(i17);
        } else if (cCharAt2 == 26) {
            this.ch = com.alibaba.fastjson.parser.JSONLexer.EOI;
            this.token = 20;
        } else {
            this.bp = i;
            this.ch = c2;
            this.matchStat = -1;
            return null;
        }
        this.matchStat = 4;
        return date;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    protected final void arrayCopy(int i, char[] cArr, int i2, int i3) {
        this.text.getChars(i, i3 + i, cArr, i2);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public java.lang.String info() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        int i = 0;
        int i2 = 1;
        int i3 = 1;
        while (i < this.bp) {
            if (this.text.charAt(i) == '\n') {
                i2++;
                i3 = 1;
            }
            i++;
            i3++;
        }
        sb.append("pos ");
        sb.append(this.bp);
        sb.append(", line ");
        sb.append(i2);
        sb.append(", column ");
        sb.append(i3);
        if (this.text.length() < 65535) {
            sb.append(this.text);
        } else {
            sb.append(this.text.substring(0, 65535));
        }
        return sb.toString();
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public java.lang.String[] scanFieldStringArray(char[] cArr, int i, com.alibaba.fastjson.parser.SymbolTable symbolTable) {
        int i2;
        char cCharAt;
        int i3 = this.bp;
        char c = this.ch;
        while (isWhitespace(this.ch)) {
            next();
        }
        if (cArr != null) {
            this.matchStat = 0;
            if (!charArrayCompare(cArr)) {
                this.matchStat = -2;
                return null;
            }
            int length = this.bp + cArr.length;
            int i4 = length + 1;
            char cCharAt2 = this.text.charAt(length);
            while (isWhitespace(cCharAt2)) {
                cCharAt2 = this.text.charAt(i4);
                i4++;
            }
            if (cCharAt2 == ':') {
                i2 = i4 + 1;
                cCharAt = this.text.charAt(i4);
                while (isWhitespace(cCharAt)) {
                    cCharAt = this.text.charAt(i2);
                    i2++;
                }
            } else {
                this.matchStat = -1;
                return null;
            }
        } else {
            i2 = this.bp + 1;
            cCharAt = this.ch;
        }
        if (cCharAt == '[') {
            this.bp = i2;
            this.ch = this.text.charAt(this.bp);
            java.lang.String[] strArr = i >= 0 ? new java.lang.String[i] : new java.lang.String[4];
            int i5 = 0;
            while (true) {
                if (isWhitespace(this.ch)) {
                    next();
                } else {
                    if (this.ch != '\"') {
                        this.bp = i3;
                        this.ch = c;
                        this.matchStat = -1;
                        return null;
                    }
                    java.lang.String strScanSymbol = scanSymbol(symbolTable, '\"');
                    if (i5 == strArr.length) {
                        java.lang.String[] strArr2 = new java.lang.String[strArr.length + (strArr.length >> 1) + 1];
                        java.lang.System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
                        strArr = strArr2;
                    }
                    int i6 = i5 + 1;
                    strArr[i5] = strScanSymbol;
                    while (isWhitespace(this.ch)) {
                        next();
                    }
                    if (this.ch == ',') {
                        next();
                        i5 = i6;
                    } else {
                        if (strArr.length != i6) {
                            java.lang.String[] strArr3 = new java.lang.String[i6];
                            java.lang.System.arraycopy(strArr, 0, strArr3, 0, i6);
                            strArr = strArr3;
                        }
                        while (isWhitespace(this.ch)) {
                            next();
                        }
                        if (this.ch == ']') {
                            next();
                            return strArr;
                        }
                        this.bp = i3;
                        this.ch = c;
                        this.matchStat = -1;
                        return null;
                    }
                }
            }
        } else {
            if (cCharAt == 'n' && this.text.startsWith("ull", this.bp + 1)) {
                this.bp += 4;
                this.ch = this.text.charAt(this.bp);
                return null;
            }
            this.matchStat = -1;
            return null;
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public boolean matchField2(char[] cArr) {
        while (isWhitespace(this.ch)) {
            next();
        }
        if (!charArrayCompare(cArr)) {
            this.matchStat = -2;
            return false;
        }
        int length = this.bp + cArr.length;
        int i = length + 1;
        char cCharAt = this.text.charAt(length);
        while (isWhitespace(cCharAt)) {
            cCharAt = this.text.charAt(i);
            i++;
        }
        if (cCharAt == ':') {
            this.bp = i;
            this.ch = charAt(this.bp);
            return true;
        }
        this.matchStat = -2;
        return false;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final void skipObject() {
        skipObject(false);
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final void skipObject(boolean z) {
        int i = this.bp;
        boolean z2 = false;
        int i2 = 0;
        while (i < this.text.length()) {
            char cCharAt = this.text.charAt(i);
            if (cCharAt == '\\') {
                if (i >= this.len - 1) {
                    this.ch = cCharAt;
                    this.bp = i;
                    throw new com.alibaba.fastjson.JSONException("illegal str, " + info());
                }
                i++;
            } else if (cCharAt == '\"') {
                z2 = !z2;
            } else if (cCharAt != '{') {
                if (cCharAt == '}' && !z2 && (i2 = i2 - 1) == -1) {
                    this.bp = i + 1;
                    int i3 = this.bp;
                    int length = this.text.length();
                    char cCharAt2 = com.alibaba.fastjson.parser.JSONLexer.EOI;
                    if (i3 == length) {
                        this.ch = com.alibaba.fastjson.parser.JSONLexer.EOI;
                        this.token = 20;
                        return;
                    }
                    this.ch = this.text.charAt(this.bp);
                    if (this.ch == ',') {
                        this.token = 16;
                        int i4 = this.bp + 1;
                        this.bp = i4;
                        if (i4 < this.text.length()) {
                            cCharAt2 = this.text.charAt(i4);
                        }
                        this.ch = cCharAt2;
                        return;
                    }
                    if (this.ch == '}') {
                        this.token = 13;
                        next();
                        return;
                    } else if (this.ch == ']') {
                        this.token = 15;
                        next();
                        return;
                    } else {
                        nextToken(16);
                        return;
                    }
                }
            } else if (!z2) {
                i2++;
            }
            i++;
        }
        for (int i5 = 0; i5 < this.bp; i5++) {
            if (i5 < this.text.length() && this.text.charAt(i5) == ' ') {
                i++;
            }
        }
        if (i != this.text.length()) {
            return;
        }
        throw new com.alibaba.fastjson.JSONException("illegal str, " + info());
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public final void skipArray() {
        skipArray(false);
    }

    public final void skipArray(boolean z) {
        int i = this.bp;
        boolean z2 = false;
        int i2 = 0;
        while (i < this.text.length()) {
            char cCharAt = this.text.charAt(i);
            if (cCharAt == '\\') {
                if (i >= this.len - 1) {
                    this.ch = cCharAt;
                    this.bp = i;
                    throw new com.alibaba.fastjson.JSONException("illegal str, " + info());
                }
                i++;
            } else if (cCharAt == '\"') {
                z2 = !z2;
            } else if (cCharAt != '[') {
                char cCharAt2 = com.alibaba.fastjson.parser.JSONLexer.EOI;
                if (cCharAt == '{' && z) {
                    int i3 = this.bp + 1;
                    this.bp = i3;
                    if (i3 < this.text.length()) {
                        cCharAt2 = this.text.charAt(i3);
                    }
                    this.ch = cCharAt2;
                    skipObject(z);
                } else if (cCharAt == ']' && !z2 && (i2 = i2 - 1) == -1) {
                    this.bp = i + 1;
                    if (this.bp == this.text.length()) {
                        this.ch = com.alibaba.fastjson.parser.JSONLexer.EOI;
                        this.token = 20;
                        return;
                    } else {
                        this.ch = this.text.charAt(this.bp);
                        nextToken(16);
                        return;
                    }
                }
            } else if (!z2) {
                i2++;
            }
            i++;
        }
        if (i != this.text.length()) {
            return;
        }
        throw new com.alibaba.fastjson.JSONException("illegal str, " + info());
    }

    public final void skipString() {
        if (this.ch == '\"') {
            int i = this.bp;
            while (true) {
                i++;
                if (i < this.text.length()) {
                    char cCharAt = this.text.charAt(i);
                    if (cCharAt == '\\') {
                        if (i < this.len - 1) {
                            i++;
                        }
                    } else if (cCharAt == '\"') {
                        java.lang.String str = this.text;
                        int i2 = i + 1;
                        this.bp = i2;
                        this.ch = str.charAt(i2);
                        return;
                    }
                } else {
                    throw new com.alibaba.fastjson.JSONException("unclosed str");
                }
            }
        } else {
            throw new java.lang.UnsupportedOperationException();
        }
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public boolean seekArrayToItem(int i) {
        if (i < 0) {
            throw new java.lang.IllegalArgumentException("index must > 0, but " + i);
        }
        if (this.token == 20) {
            return false;
        }
        if (this.token != 14) {
            throw new java.lang.UnsupportedOperationException();
        }
        for (int i2 = 0; i2 < i; i2++) {
            skipWhitespace();
            if (this.ch == '\"' || this.ch == '\'') {
                skipString();
                if (this.ch == ',') {
                    next();
                } else {
                    if (this.ch == ']') {
                        next();
                        nextToken(16);
                        return false;
                    }
                    throw new com.alibaba.fastjson.JSONException("illegal json.");
                }
            } else {
                if (this.ch == '{') {
                    next();
                    this.token = 12;
                    skipObject(false);
                } else if (this.ch == '[') {
                    next();
                    this.token = 14;
                    skipArray(false);
                } else {
                    int i3 = this.bp + 1;
                    while (true) {
                        if (i3 < this.text.length()) {
                            char cCharAt = this.text.charAt(i3);
                            if (cCharAt == ',') {
                                this.bp = i3 + 1;
                                this.ch = charAt(this.bp);
                                break;
                            }
                            if (cCharAt == ']') {
                                this.bp = i3 + 1;
                                this.ch = charAt(this.bp);
                                nextToken();
                                return false;
                            }
                            i3++;
                        } else {
                            throw new com.alibaba.fastjson.JSONException("illegal json.");
                        }
                    }
                }
                if (this.token != 16) {
                    if (this.token == 15) {
                        return false;
                    }
                    throw new java.lang.UnsupportedOperationException();
                }
            }
        }
        nextToken();
        return true;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public int seekObjectToField(long j, boolean z) {
        int i = -1;
        if (this.token == 20) {
            return -1;
        }
        if (this.token != 13) {
            int i2 = 15;
            if (this.token != 15) {
                int i3 = 16;
                if (this.token != 12 && this.token != 16) {
                    throw new java.lang.UnsupportedOperationException(com.alibaba.fastjson.parser.JSONToken.name(this.token));
                }
                while (this.ch != '}') {
                    if (this.ch == 26) {
                        return i;
                    }
                    if (this.ch != '\"') {
                        skipWhitespace();
                    }
                    if (this.ch == '\"') {
                        int i4 = this.bp + 1;
                        long j2 = com.alibaba.fastjson.util.TypeUtils.fnv1a_64_magic_hashcode;
                        while (i4 < this.text.length()) {
                            char cCharAt = this.text.charAt(i4);
                            if (cCharAt == '\\') {
                                i4++;
                                if (i4 == this.text.length()) {
                                    throw new com.alibaba.fastjson.JSONException("unclosed str, " + info());
                                }
                                cCharAt = this.text.charAt(i4);
                            }
                            if (cCharAt == '\"') {
                                this.bp = i4 + 1;
                                this.ch = this.bp >= this.text.length() ? com.alibaba.fastjson.parser.JSONLexer.EOI : this.text.charAt(this.bp);
                                break;
                            }
                            j2 = (j2 ^ ((long) cCharAt)) * com.alibaba.fastjson.util.TypeUtils.fnv1a_64_magic_prime;
                            i4++;
                        }
                        if (j2 == j) {
                            if (this.ch != ':') {
                                skipWhitespace();
                            }
                            if (this.ch != ':') {
                                return 3;
                            }
                            int i5 = this.bp + 1;
                            this.bp = i5;
                            this.ch = i5 >= this.text.length() ? com.alibaba.fastjson.parser.JSONLexer.EOI : this.text.charAt(i5);
                            if (this.ch == ',') {
                                int i6 = this.bp + 1;
                                this.bp = i6;
                                this.ch = i6 >= this.text.length() ? com.alibaba.fastjson.parser.JSONLexer.EOI : this.text.charAt(i6);
                                this.token = i3;
                                return 3;
                            }
                            if (this.ch == ']') {
                                int i7 = this.bp + 1;
                                this.bp = i7;
                                this.ch = i7 >= this.text.length() ? com.alibaba.fastjson.parser.JSONLexer.EOI : this.text.charAt(i7);
                                this.token = i2;
                                return 3;
                            }
                            if (this.ch == '}') {
                                int i8 = this.bp + 1;
                                this.bp = i8;
                                this.ch = i8 >= this.text.length() ? com.alibaba.fastjson.parser.JSONLexer.EOI : this.text.charAt(i8);
                                this.token = 13;
                                return 3;
                            }
                            if (this.ch >= '0' && this.ch <= '9') {
                                this.sp = 0;
                                this.pos = this.bp;
                                scanNumber();
                                return 3;
                            }
                            nextToken(2);
                            return 3;
                        }
                        if (this.ch != ':') {
                            skipWhitespace();
                        }
                        if (this.ch == ':') {
                            int i9 = this.bp + 1;
                            this.bp = i9;
                            this.ch = i9 >= this.text.length() ? com.alibaba.fastjson.parser.JSONLexer.EOI : this.text.charAt(i9);
                            if (this.ch != '\"' && this.ch != '\'' && this.ch != '{' && this.ch != '[' && this.ch != '0' && this.ch != '1' && this.ch != '2' && this.ch != '3' && this.ch != '4' && this.ch != '5' && this.ch != '6' && this.ch != '7' && this.ch != '8' && this.ch != '9' && this.ch != '+' && this.ch != '-') {
                                skipWhitespace();
                            }
                            if (this.ch == '-' || this.ch == '+' || (this.ch >= '0' && this.ch <= '9')) {
                                next();
                                while (this.ch >= '0' && this.ch <= '9') {
                                    next();
                                }
                                if (this.ch == '.') {
                                    next();
                                    while (this.ch >= '0' && this.ch <= '9') {
                                        next();
                                    }
                                }
                                if (this.ch == 'E' || this.ch == 'e') {
                                    next();
                                    if (this.ch == '-' || this.ch == '+') {
                                        next();
                                    }
                                    while (this.ch >= '0' && this.ch <= '9') {
                                        next();
                                    }
                                }
                                if (this.ch != ',') {
                                    skipWhitespace();
                                }
                                if (this.ch == ',') {
                                    next();
                                }
                            } else if (this.ch == '\"') {
                                skipString();
                                if (this.ch != ',' && this.ch != '}') {
                                    skipWhitespace();
                                }
                                if (this.ch == ',') {
                                    next();
                                }
                            } else if (this.ch == 't') {
                                next();
                                if (this.ch == 'r') {
                                    next();
                                    if (this.ch == 'u') {
                                        next();
                                        if (this.ch == 'e') {
                                            next();
                                        }
                                    }
                                }
                                if (this.ch != ',' && this.ch != '}') {
                                    skipWhitespace();
                                }
                                if (this.ch == ',') {
                                    next();
                                }
                            } else if (this.ch == 'n') {
                                next();
                                if (this.ch == 'u') {
                                    next();
                                    if (this.ch == 'l') {
                                        next();
                                        if (this.ch == 'l') {
                                            next();
                                        }
                                    }
                                }
                                if (this.ch != ',' && this.ch != '}') {
                                    skipWhitespace();
                                }
                                if (this.ch == ',') {
                                    next();
                                }
                            } else if (this.ch == 'f') {
                                next();
                                if (this.ch == 'a') {
                                    next();
                                    if (this.ch == 'l') {
                                        next();
                                        if (this.ch == 's') {
                                            next();
                                            if (this.ch == 'e') {
                                                next();
                                            }
                                        }
                                    }
                                }
                                if (this.ch != ',' && this.ch != '}') {
                                    skipWhitespace();
                                }
                                if (this.ch == ',') {
                                    next();
                                }
                            } else if (this.ch == '{') {
                                int i10 = this.bp + 1;
                                this.bp = i10;
                                this.ch = i10 >= this.text.length() ? com.alibaba.fastjson.parser.JSONLexer.EOI : this.text.charAt(i10);
                                if (z) {
                                    this.token = 12;
                                    return 1;
                                }
                                skipObject(false);
                                if (this.token == 13) {
                                    return -1;
                                }
                            } else if (this.ch == '[') {
                                next();
                                if (z) {
                                    this.token = 14;
                                    return 2;
                                }
                                skipArray(false);
                                if (this.token == 13) {
                                    return -1;
                                }
                            } else {
                                throw new java.lang.UnsupportedOperationException();
                            }
                            i = -1;
                            i2 = 15;
                            i3 = 16;
                        } else {
                            throw new com.alibaba.fastjson.JSONException("illegal json, " + info());
                        }
                    } else {
                        throw new java.lang.UnsupportedOperationException();
                    }
                }
                next();
                nextToken();
                return i;
            }
        }
        nextToken();
        return -1;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase
    public int seekObjectToField(long[] jArr) {
        if (this.token != 12 && this.token != 16) {
            throw new java.lang.UnsupportedOperationException();
        }
        while (this.ch != '}') {
            char c = this.ch;
            char cCharAt = com.alibaba.fastjson.parser.JSONLexer.EOI;
            if (c == 26) {
                this.matchStat = -1;
                return -1;
            }
            if (this.ch != '\"') {
                skipWhitespace();
            }
            if (this.ch == '\"') {
                int i = this.bp + 1;
                long j = com.alibaba.fastjson.util.TypeUtils.fnv1a_64_magic_hashcode;
                while (i < this.text.length()) {
                    char cCharAt2 = this.text.charAt(i);
                    if (cCharAt2 == '\\') {
                        i++;
                        if (i == this.text.length()) {
                            throw new com.alibaba.fastjson.JSONException("unclosed str, " + info());
                        }
                        cCharAt2 = this.text.charAt(i);
                    }
                    if (cCharAt2 == '\"') {
                        this.bp = i + 1;
                        this.ch = this.bp >= this.text.length() ? com.alibaba.fastjson.parser.JSONLexer.EOI : this.text.charAt(this.bp);
                        break;
                    }
                    j = (j ^ ((long) cCharAt2)) * com.alibaba.fastjson.util.TypeUtils.fnv1a_64_magic_prime;
                    i++;
                }
                int i2 = 0;
                while (true) {
                    if (i2 >= jArr.length) {
                        i2 = -1;
                        break;
                    }
                    if (j == jArr[i2]) {
                        break;
                    }
                    i2++;
                }
                if (i2 != -1) {
                    if (this.ch != ':') {
                        skipWhitespace();
                    }
                    if (this.ch == ':') {
                        int i3 = this.bp + 1;
                        this.bp = i3;
                        this.ch = i3 >= this.text.length() ? com.alibaba.fastjson.parser.JSONLexer.EOI : this.text.charAt(i3);
                        if (this.ch == ',') {
                            int i4 = this.bp + 1;
                            this.bp = i4;
                            if (i4 < this.text.length()) {
                                cCharAt = this.text.charAt(i4);
                            }
                            this.ch = cCharAt;
                            this.token = 16;
                        } else if (this.ch == ']') {
                            int i5 = this.bp + 1;
                            this.bp = i5;
                            if (i5 < this.text.length()) {
                                cCharAt = this.text.charAt(i5);
                            }
                            this.ch = cCharAt;
                            this.token = 15;
                        } else if (this.ch == '}') {
                            int i6 = this.bp + 1;
                            this.bp = i6;
                            if (i6 < this.text.length()) {
                                cCharAt = this.text.charAt(i6);
                            }
                            this.ch = cCharAt;
                            this.token = 13;
                        } else if (this.ch >= '0' && this.ch <= '9') {
                            this.sp = 0;
                            this.pos = this.bp;
                            scanNumber();
                        } else {
                            nextToken(2);
                        }
                    }
                    this.matchStat = 3;
                    return i2;
                }
                if (this.ch != ':') {
                    skipWhitespace();
                }
                if (this.ch == ':') {
                    int i7 = this.bp + 1;
                    this.bp = i7;
                    this.ch = i7 >= this.text.length() ? com.alibaba.fastjson.parser.JSONLexer.EOI : this.text.charAt(i7);
                    if (this.ch != '\"' && this.ch != '\'' && this.ch != '{' && this.ch != '[' && this.ch != '0' && this.ch != '1' && this.ch != '2' && this.ch != '3' && this.ch != '4' && this.ch != '5' && this.ch != '6' && this.ch != '7' && this.ch != '8' && this.ch != '9' && this.ch != '+' && this.ch != '-') {
                        skipWhitespace();
                    }
                    if (this.ch == '-' || this.ch == '+' || (this.ch >= '0' && this.ch <= '9')) {
                        next();
                        while (this.ch >= '0' && this.ch <= '9') {
                            next();
                        }
                        if (this.ch == '.') {
                            next();
                            while (this.ch >= '0' && this.ch <= '9') {
                                next();
                            }
                        }
                        if (this.ch == 'E' || this.ch == 'e') {
                            next();
                            if (this.ch == '-' || this.ch == '+') {
                                next();
                            }
                            while (this.ch >= '0' && this.ch <= '9') {
                                next();
                            }
                        }
                        if (this.ch != ',') {
                            skipWhitespace();
                        }
                        if (this.ch == ',') {
                            next();
                        }
                    } else if (this.ch == '\"') {
                        skipString();
                        if (this.ch != ',' && this.ch != '}') {
                            skipWhitespace();
                        }
                        if (this.ch == ',') {
                            next();
                        }
                    } else if (this.ch == '{') {
                        int i8 = this.bp + 1;
                        this.bp = i8;
                        if (i8 < this.text.length()) {
                            cCharAt = this.text.charAt(i8);
                        }
                        this.ch = cCharAt;
                        skipObject(false);
                    } else if (this.ch == '[') {
                        next();
                        skipArray(false);
                    } else {
                        throw new java.lang.UnsupportedOperationException();
                    }
                } else {
                    throw new com.alibaba.fastjson.JSONException("illegal json, " + info());
                }
            } else {
                throw new java.lang.UnsupportedOperationException();
            }
        }
        next();
        nextToken();
        this.matchStat = -1;
        return -1;
    }

    @Override // com.alibaba.fastjson.parser.JSONLexerBase, com.alibaba.fastjson.parser.JSONLexer
    public java.lang.String scanTypeName(com.alibaba.fastjson.parser.SymbolTable symbolTable) {
        int iIndexOf;
        if (!this.text.startsWith("\"@type\":\"", this.bp) || (iIndexOf = this.text.indexOf(34, this.bp + 9)) == -1) {
            return null;
        }
        this.bp += 9;
        int iCharAt = 0;
        for (int i = this.bp; i < iIndexOf; i++) {
            iCharAt = (iCharAt * 31) + this.text.charAt(i);
        }
        java.lang.String strAddSymbol = addSymbol(this.bp, iIndexOf - this.bp, iCharAt, symbolTable);
        char cCharAt = this.text.charAt(iIndexOf + 1);
        if (cCharAt != ',' && cCharAt != ']') {
            return null;
        }
        this.bp = iIndexOf + 2;
        this.ch = this.text.charAt(this.bp);
        return strAddSymbol;
    }
}
