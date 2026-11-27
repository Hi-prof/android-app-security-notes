package com.taobao.weex.utils;

/* JADX INFO: loaded from: classes.dex */
public class FunctionParser<K, V> {
    public static final char SPACE = ' ';
    private com.taobao.weex.utils.FunctionParser.Lexer lexer;
    private com.taobao.weex.utils.FunctionParser.Mapper<K, V> mapper;

    public interface Mapper<K, V> {
        java.util.Map<K, V> map(java.lang.String str, java.util.List<java.lang.String> list);
    }

    private enum Token {
        FUNC_NAME,
        PARAM_VALUE,
        LEFT_PARENT,
        RIGHT_PARENT,
        COMMA
    }

    public FunctionParser(java.lang.String str, com.taobao.weex.utils.FunctionParser.Mapper<K, V> mapper) {
        this.lexer = new com.taobao.weex.utils.FunctionParser.Lexer(str);
        this.mapper = mapper;
    }

    public java.util.LinkedHashMap<K, V> parse() {
        this.lexer.moveOn();
        return definition();
    }

    private java.util.LinkedHashMap<K, V> definition() {
        java.util.LinkedHashMap<K, V> linkedHashMap = new java.util.LinkedHashMap<>();
        do {
            linkedHashMap.putAll(function());
        } while (this.lexer.getCurrentToken() == com.taobao.weex.utils.FunctionParser.Token.FUNC_NAME);
        return linkedHashMap;
    }

    private java.util.Map<K, V> function() {
        java.util.LinkedList linkedList = new java.util.LinkedList();
        java.lang.String strMatch = match(com.taobao.weex.utils.FunctionParser.Token.FUNC_NAME);
        match(com.taobao.weex.utils.FunctionParser.Token.LEFT_PARENT);
        linkedList.add(match(com.taobao.weex.utils.FunctionParser.Token.PARAM_VALUE));
        while (this.lexer.getCurrentToken() == com.taobao.weex.utils.FunctionParser.Token.COMMA) {
            match(com.taobao.weex.utils.FunctionParser.Token.COMMA);
            linkedList.add(match(com.taobao.weex.utils.FunctionParser.Token.PARAM_VALUE));
        }
        match(com.taobao.weex.utils.FunctionParser.Token.RIGHT_PARENT);
        return this.mapper.map(strMatch, linkedList);
    }

    private java.lang.String match(com.taobao.weex.utils.FunctionParser.Token token) {
        try {
            if (token != this.lexer.getCurrentToken()) {
                return "";
            }
            java.lang.String currentTokenValue = this.lexer.getCurrentTokenValue();
            this.lexer.moveOn();
            return currentTokenValue;
        } catch (java.lang.Exception unused) {
            com.taobao.weex.utils.WXLogUtils.e(token + "Token doesn't match" + this.lexer.source);
            return "";
        }
    }

    private static class WXInterpretationException extends java.lang.RuntimeException {
        private WXInterpretationException(java.lang.String str) {
            super(str);
        }
    }

    private static class Lexer {
        private static final char A_LOWER = 'a';
        private static final char A_UPPER = 'A';
        private static final java.lang.String COMMA = ",";
        private static final char DOT = '.';
        private static final java.lang.String LEFT_PARENT = "(";
        private static final char MINUS = '-';
        private static final char NINE = '9';
        private static final char PLUS = '+';
        private static final java.lang.String RIGHT_PARENT = ")";
        private static final char ZERO = '0';
        private static final char Z_LOWER = 'z';
        private static final char Z_UPPER = 'Z';
        private com.taobao.weex.utils.FunctionParser.Token current;
        private int pointer;
        private java.lang.String source;
        private java.lang.String value;

        private boolean isCharacterOrDigit(char c) {
            if ('0' <= c && c <= '9') {
                return true;
            }
            if ('a' > c || c > 'z') {
                return 'A' <= c && c <= 'Z';
            }
            return true;
        }

        private Lexer(java.lang.String str) {
            this.pointer = 0;
            this.source = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public com.taobao.weex.utils.FunctionParser.Token getCurrentToken() {
            return this.current;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public java.lang.String getCurrentTokenValue() {
            return this.value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean moveOn() {
            int i = this.pointer;
            while (this.pointer < this.source.length()) {
                char cCharAt = this.source.charAt(this.pointer);
                if (cCharAt == ' ') {
                    int i2 = this.pointer;
                    this.pointer = i2 + 1;
                    if (i != i2) {
                        break;
                    }
                    i++;
                } else if (isCharacterOrDigit(cCharAt) || cCharAt == '.' || cCharAt == '%' || cCharAt == '-' || cCharAt == '+') {
                    this.pointer++;
                } else {
                    int i3 = this.pointer;
                    if (i != i3) {
                        break;
                    }
                    this.pointer = i3 + 1;
                    break;
                }
            }
            int i4 = this.pointer;
            if (i != i4) {
                moveOn(this.source.substring(i, i4));
                return true;
            }
            this.current = null;
            this.value = null;
            return false;
        }

        private void moveOn(java.lang.String str) {
            if ("(".equals(str)) {
                this.current = com.taobao.weex.utils.FunctionParser.Token.LEFT_PARENT;
                this.value = "(";
                return;
            }
            if (")".equals(str)) {
                this.current = com.taobao.weex.utils.FunctionParser.Token.RIGHT_PARENT;
                this.value = ")";
            } else if (",".equals(str)) {
                this.current = com.taobao.weex.utils.FunctionParser.Token.COMMA;
                this.value = ",";
            } else if (isFuncName(str)) {
                this.current = com.taobao.weex.utils.FunctionParser.Token.FUNC_NAME;
                this.value = str;
            } else {
                this.current = com.taobao.weex.utils.FunctionParser.Token.PARAM_VALUE;
                this.value = str;
            }
        }

        private boolean isFuncName(java.lang.CharSequence charSequence) {
            for (int i = 0; i < charSequence.length(); i++) {
                char cCharAt = charSequence.charAt(i);
                if (('a' > cCharAt || cCharAt > 'z') && (('A' > cCharAt || cCharAt > 'Z') && cCharAt != '-')) {
                    return false;
                }
            }
            return true;
        }
    }
}
