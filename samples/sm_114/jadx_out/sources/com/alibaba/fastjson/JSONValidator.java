package com.alibaba.fastjson;

/* JADX INFO: loaded from: classes.dex */
public abstract class JSONValidator implements java.lang.Cloneable, java.io.Closeable {
    protected char ch;
    protected boolean eof;
    protected com.alibaba.fastjson.JSONValidator.Type type;
    private java.lang.Boolean validateResult;
    protected int pos = -1;
    protected int count = 0;
    protected boolean supportMultiValue = false;

    public enum Type {
        Object,
        Array,
        Value
    }

    static final boolean isWhiteSpace(char c) {
        return c == ' ' || c == '\t' || c == '\r' || c == '\n' || c == '\f' || c == '\b';
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
    }

    abstract void next();

    public static com.alibaba.fastjson.JSONValidator fromUtf8(byte[] bArr) {
        return new com.alibaba.fastjson.JSONValidator.UTF8Validator(bArr);
    }

    public static com.alibaba.fastjson.JSONValidator fromUtf8(java.io.InputStream inputStream) {
        return new com.alibaba.fastjson.JSONValidator.UTF8InputStreamValidator(inputStream);
    }

    public static com.alibaba.fastjson.JSONValidator from(java.lang.String str) {
        return new com.alibaba.fastjson.JSONValidator.UTF16Validator(str);
    }

    public static com.alibaba.fastjson.JSONValidator from(java.io.Reader reader) {
        return new com.alibaba.fastjson.JSONValidator.ReaderValidator(reader);
    }

    public boolean isSupportMultiValue() {
        return this.supportMultiValue;
    }

    public com.alibaba.fastjson.JSONValidator setSupportMultiValue(boolean z) {
        this.supportMultiValue = z;
        return this;
    }

    public com.alibaba.fastjson.JSONValidator.Type getType() {
        if (this.type == null) {
            validate();
        }
        return this.type;
    }

    public boolean validate() {
        java.lang.Boolean bool = this.validateResult;
        if (bool != null) {
            return bool.booleanValue();
        }
        while (any()) {
            skipWhiteSpace();
            this.count++;
            if (this.eof) {
                this.validateResult = true;
                return true;
            }
            if (this.supportMultiValue) {
                skipWhiteSpace();
                if (this.eof) {
                    this.validateResult = true;
                    return true;
                }
            } else {
                this.validateResult = false;
                return false;
            }
        }
        this.validateResult = false;
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:127:0x017d A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:130:0x0183  */
    /* JADX WARN: Code duplicated, block: B:132:0x018a A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:141:0x019c  */
    /* JADX WARN: Code duplicated, block: B:145:0x01a7 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:146:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:149:0x01b0 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:153:0x01b9 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:179:0x017f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:181:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:185:0x01bf A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    private boolean any() {
        char c;
        char c2;
        char c3;
        char c4;
        char c5;
        char c6;
        char c7;
        char c8;
        char c9;
        char c10 = this.ch;
        if (c10 == '\"') {
            next();
            while (!this.eof) {
                char c11 = this.ch;
                if (c11 == '\\') {
                    next();
                    if (this.ch == 'u') {
                        next();
                        next();
                        next();
                        next();
                        next();
                    } else {
                        next();
                    }
                } else {
                    if (c11 == '\"') {
                        next();
                        this.type = com.alibaba.fastjson.JSONValidator.Type.Value;
                        return true;
                    }
                    next();
                }
            }
            return false;
        }
        if (c10 != '+' && c10 != '-') {
            if (c10 == '[') {
                next();
                skipWhiteSpace();
                if (this.ch == ']') {
                    next();
                    this.type = com.alibaba.fastjson.JSONValidator.Type.Array;
                    return true;
                }
                while (any()) {
                    skipWhiteSpace();
                    char c12 = this.ch;
                    if (c12 != ',') {
                        if (c12 != ']') {
                            return false;
                        }
                        next();
                        this.type = com.alibaba.fastjson.JSONValidator.Type.Array;
                        return true;
                    }
                    next();
                    skipWhiteSpace();
                }
                return false;
            }
            if (c10 == 'f') {
                next();
                if (this.ch != 'a') {
                    return false;
                }
                next();
                if (this.ch != 'l') {
                    return false;
                }
                next();
                if (this.ch != 's') {
                    return false;
                }
                next();
                if (this.ch != 'e') {
                    return false;
                }
                next();
                if (!isWhiteSpace(this.ch) && (c7 = this.ch) != ',' && c7 != ']' && c7 != '}' && c7 != 0) {
                    return false;
                }
                this.type = com.alibaba.fastjson.JSONValidator.Type.Value;
                return true;
            }
            if (c10 == 'n') {
                next();
                if (this.ch != 'u') {
                    return false;
                }
                next();
                if (this.ch != 'l') {
                    return false;
                }
                next();
                if (this.ch != 'l') {
                    return false;
                }
                next();
                if (!isWhiteSpace(this.ch) && (c8 = this.ch) != ',' && c8 != ']' && c8 != '}' && c8 != 0) {
                    return false;
                }
                this.type = com.alibaba.fastjson.JSONValidator.Type.Value;
                return true;
            }
            if (c10 == 't') {
                next();
                if (this.ch != 'r') {
                    return false;
                }
                next();
                if (this.ch != 'u') {
                    return false;
                }
                next();
                if (this.ch != 'e') {
                    return false;
                }
                next();
                if (!isWhiteSpace(this.ch) && (c9 = this.ch) != ',' && c9 != ']' && c9 != '}' && c9 != 0) {
                    return false;
                }
                this.type = com.alibaba.fastjson.JSONValidator.Type.Value;
                return true;
            }
            if (c10 == '{') {
                next();
                while (isWhiteSpace(this.ch)) {
                    next();
                }
                if (this.ch == '}') {
                    next();
                    this.type = com.alibaba.fastjson.JSONValidator.Type.Object;
                    return true;
                }
                while (this.ch == '\"') {
                    fieldName();
                    skipWhiteSpace();
                    if (this.ch != ':') {
                        break;
                    }
                    next();
                    skipWhiteSpace();
                    if (!any()) {
                        return false;
                    }
                    skipWhiteSpace();
                    char c13 = this.ch;
                    if (c13 != ',') {
                        if (c13 != '}') {
                            break;
                        }
                        next();
                        this.type = com.alibaba.fastjson.JSONValidator.Type.Object;
                        return true;
                    }
                    next();
                    skipWhiteSpace();
                }
                return false;
            }
            switch (c10) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case com.alibaba.fastjson.asm.Opcodes.LSTORE /* 55 */:
                case '8':
                case com.alibaba.fastjson.asm.Opcodes.DSTORE /* 57 */:
                    break;
                default:
                    return false;
            }
        }
        if (c10 == '-' || c10 == '+') {
            next();
            skipWhiteSpace();
            char c14 = this.ch;
            if (c14 >= '0' && c14 <= '9') {
                do {
                    next();
                    c = this.ch;
                    if (c >= '0') {
                    }
                    if (c == '.') {
                        next();
                        c6 = this.ch;
                        if (c6 >= '0' || c6 > '9') {
                            return false;
                        }
                        while (true) {
                            char c15 = this.ch;
                            if (c15 >= '0' && c15 <= '9') {
                                next();
                            }
                        }
                    }
                    c2 = this.ch;
                    if (c2 != 'e' || c2 == 'E') {
                        next();
                        c3 = this.ch;
                        if (c3 != '-' || c3 == '+') {
                            next();
                        }
                        c4 = this.ch;
                        if (c4 >= '0' && c4 <= '9') {
                            next();
                            while (true) {
                                c5 = this.ch;
                                if (c5 < '0' && c5 <= '9') {
                                    next();
                                }
                            }
                        }
                    }
                    this.type = com.alibaba.fastjson.JSONValidator.Type.Value;
                    return true;
                } while (c <= '9');
                if (c == '.') {
                    next();
                    c6 = this.ch;
                    if (c6 >= '0') {
                    }
                    return false;
                }
                c2 = this.ch;
                if (c2 != 'e') {
                }
                next();
                c3 = this.ch;
                if (c3 != '-') {
                    next();
                } else {
                    next();
                }
                c4 = this.ch;
                if (c4 >= '0') {
                    next();
                    while (true) {
                        c5 = this.ch;
                        if (c5 < '0') {
                        }
                        this.type = com.alibaba.fastjson.JSONValidator.Type.Value;
                        return true;
                        next();
                    }
                }
            }
        } else {
            do {
                next();
                c = this.ch;
                if (c >= '0') {
                }
                if (c == '.') {
                    next();
                    c6 = this.ch;
                    if (c6 >= '0') {
                    }
                    return false;
                }
                c2 = this.ch;
                if (c2 != 'e') {
                }
                next();
                c3 = this.ch;
                if (c3 != '-') {
                    next();
                } else {
                    next();
                }
                c4 = this.ch;
                if (c4 >= '0') {
                    next();
                    while (true) {
                        c5 = this.ch;
                        if (c5 < '0') {
                        }
                        this.type = com.alibaba.fastjson.JSONValidator.Type.Value;
                        return true;
                        next();
                    }
                }
            } while (c <= '9');
            if (c == '.') {
                next();
                c6 = this.ch;
                if (c6 >= '0') {
                }
                return false;
            }
            c2 = this.ch;
            if (c2 != 'e') {
            }
            next();
            c3 = this.ch;
            if (c3 != '-') {
                next();
            } else {
                next();
            }
            c4 = this.ch;
            if (c4 >= '0') {
                next();
                while (true) {
                    c5 = this.ch;
                    if (c5 < '0') {
                    }
                    this.type = com.alibaba.fastjson.JSONValidator.Type.Value;
                    return true;
                    next();
                }
            }
        }
        return false;
    }

    protected void fieldName() {
        next();
        while (true) {
            char c = this.ch;
            if (c == '\\') {
                next();
                if (this.ch == 'u') {
                    next();
                    next();
                    next();
                    next();
                    next();
                } else {
                    next();
                }
            } else {
                if (c == '\"') {
                    next();
                    return;
                }
                next();
            }
        }
    }

    protected boolean string() {
        next();
        while (!this.eof) {
            char c = this.ch;
            if (c == '\\') {
                next();
                if (this.ch == 'u') {
                    next();
                    next();
                    next();
                    next();
                    next();
                } else {
                    next();
                }
            } else {
                if (c == '\"') {
                    next();
                    return true;
                }
                next();
            }
        }
        return false;
    }

    void skipWhiteSpace() {
        while (isWhiteSpace(this.ch)) {
            next();
        }
    }

    static class UTF8Validator extends com.alibaba.fastjson.JSONValidator {
        private final byte[] bytes;

        public UTF8Validator(byte[] bArr) {
            this.bytes = bArr;
            next();
            skipWhiteSpace();
        }

        @Override // com.alibaba.fastjson.JSONValidator
        void next() {
            this.pos++;
            int i = this.pos;
            byte[] bArr = this.bytes;
            if (i >= bArr.length) {
                this.ch = (char) 0;
                this.eof = true;
            } else {
                this.ch = (char) bArr[this.pos];
            }
        }
    }

    static class UTF8InputStreamValidator extends com.alibaba.fastjson.JSONValidator {
        private static final java.lang.ThreadLocal<byte[]> bufLocal = new java.lang.ThreadLocal<>();
        private byte[] buf;
        private final java.io.InputStream is;
        private int end = -1;
        private int readCount = 0;

        public UTF8InputStreamValidator(java.io.InputStream inputStream) {
            this.is = inputStream;
            java.lang.ThreadLocal<byte[]> threadLocal = bufLocal;
            byte[] bArr = threadLocal.get();
            this.buf = bArr;
            if (bArr != null) {
                threadLocal.set(null);
            } else {
                this.buf = new byte[8192];
            }
            next();
            skipWhiteSpace();
        }

        @Override // com.alibaba.fastjson.JSONValidator
        void next() {
            if (this.pos < this.end) {
                byte[] bArr = this.buf;
                int i = this.pos + 1;
                this.pos = i;
                this.ch = (char) bArr[i];
                return;
            }
            if (this.eof) {
                return;
            }
            try {
                java.io.InputStream inputStream = this.is;
                byte[] bArr2 = this.buf;
                int i2 = inputStream.read(bArr2, 0, bArr2.length);
                this.readCount++;
                if (i2 > 0) {
                    this.ch = (char) this.buf[0];
                    this.pos = 0;
                    this.end = i2 - 1;
                } else {
                    if (i2 == -1) {
                        this.pos = 0;
                        this.end = 0;
                        this.buf = null;
                        this.ch = (char) 0;
                        this.eof = true;
                        return;
                    }
                    this.pos = 0;
                    this.end = 0;
                    this.buf = null;
                    this.ch = (char) 0;
                    this.eof = true;
                    throw new com.alibaba.fastjson.JSONException("read error");
                }
            } catch (java.io.IOException unused) {
                throw new com.alibaba.fastjson.JSONException("read error");
            }
        }

        @Override // com.alibaba.fastjson.JSONValidator, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
            bufLocal.set(this.buf);
            this.is.close();
        }
    }

    static class UTF16Validator extends com.alibaba.fastjson.JSONValidator {
        private final java.lang.String str;

        public UTF16Validator(java.lang.String str) {
            this.str = str;
            next();
            skipWhiteSpace();
        }

        @Override // com.alibaba.fastjson.JSONValidator
        void next() {
            this.pos++;
            if (this.pos >= this.str.length()) {
                this.ch = (char) 0;
                this.eof = true;
            } else {
                this.ch = this.str.charAt(this.pos);
            }
        }

        @Override // com.alibaba.fastjson.JSONValidator
        protected final void fieldName() {
            char cCharAt;
            int i = this.pos;
            do {
                i++;
                if (i >= this.str.length() || (cCharAt = this.str.charAt(i)) == '\\') {
                    next();
                    while (true) {
                        if (this.ch == '\\') {
                            next();
                            if (this.ch == 'u') {
                                next();
                                next();
                                next();
                                next();
                                next();
                            } else {
                                next();
                            }
                        } else if (this.ch == '\"') {
                            next();
                            return;
                        } else if (this.eof) {
                            return;
                        } else {
                            next();
                        }
                    }
                }
            } while (cCharAt != '\"');
            int i2 = i + 1;
            this.ch = this.str.charAt(i2);
            this.pos = i2;
        }
    }

    static class ReaderValidator extends com.alibaba.fastjson.JSONValidator {
        private static final java.lang.ThreadLocal<char[]> bufLocal = new java.lang.ThreadLocal<>();
        private char[] buf;
        final java.io.Reader r;
        private int end = -1;
        private int readCount = 0;

        ReaderValidator(java.io.Reader reader) {
            this.r = reader;
            java.lang.ThreadLocal<char[]> threadLocal = bufLocal;
            char[] cArr = threadLocal.get();
            this.buf = cArr;
            if (cArr != null) {
                threadLocal.set(null);
            } else {
                this.buf = new char[8192];
            }
            next();
            skipWhiteSpace();
        }

        @Override // com.alibaba.fastjson.JSONValidator
        void next() {
            if (this.pos < this.end) {
                char[] cArr = this.buf;
                int i = this.pos + 1;
                this.pos = i;
                this.ch = cArr[i];
                return;
            }
            if (this.eof) {
                return;
            }
            try {
                java.io.Reader reader = this.r;
                char[] cArr2 = this.buf;
                int i2 = reader.read(cArr2, 0, cArr2.length);
                this.readCount++;
                if (i2 > 0) {
                    this.ch = this.buf[0];
                    this.pos = 0;
                    this.end = i2 - 1;
                } else {
                    if (i2 == -1) {
                        this.pos = 0;
                        this.end = 0;
                        this.buf = null;
                        this.ch = (char) 0;
                        this.eof = true;
                        return;
                    }
                    this.pos = 0;
                    this.end = 0;
                    this.buf = null;
                    this.ch = (char) 0;
                    this.eof = true;
                    throw new com.alibaba.fastjson.JSONException("read error");
                }
            } catch (java.io.IOException unused) {
                throw new com.alibaba.fastjson.JSONException("read error");
            }
        }

        @Override // com.alibaba.fastjson.JSONValidator, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
            bufLocal.set(this.buf);
            this.r.close();
        }
    }
}
