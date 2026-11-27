package com.alibaba.fastjson.parser;

/* JADX INFO: loaded from: classes.dex */
public class SymbolTable {
    private final int indexMask;
    private final java.lang.String[] symbols;

    public SymbolTable(int i) {
        this.indexMask = i - 1;
        this.symbols = new java.lang.String[i];
        addSymbol("$ref", 0, 4, 1185263);
        addSymbol(com.alibaba.fastjson.JSON.DEFAULT_TYPE_KEY, 0, com.alibaba.fastjson.JSON.DEFAULT_TYPE_KEY.length(), com.alibaba.fastjson.JSON.DEFAULT_TYPE_KEY.hashCode());
    }

    public java.lang.String addSymbol(char[] cArr, int i, int i2) {
        return addSymbol(cArr, i, i2, hash(cArr, i, i2));
    }

    public java.lang.String addSymbol(char[] cArr, int i, int i2, int i3) {
        int i4 = this.indexMask & i3;
        java.lang.String str = this.symbols[i4];
        if (str != null) {
            if (i3 == str.hashCode() && i2 == str.length()) {
                for (int i5 = 0; i5 < i2; i5++) {
                    if (cArr[i + i5] == str.charAt(i5)) {
                    }
                }
                return str;
            }
            return new java.lang.String(cArr, i, i2);
        }
        java.lang.String strIntern = new java.lang.String(cArr, i, i2).intern();
        this.symbols[i4] = strIntern;
        return strIntern;
    }

    public java.lang.String addSymbol(java.lang.String str, int i, int i2, int i3) {
        return addSymbol(str, i, i2, i3, false);
    }

    public java.lang.String addSymbol(java.lang.String str, int i, int i2, int i3, boolean z) {
        int i4 = this.indexMask & i3;
        java.lang.String str2 = this.symbols[i4];
        if (str2 != null) {
            if (i3 == str2.hashCode() && i2 == str2.length() && str.startsWith(str2, i)) {
                return str2;
            }
            java.lang.String strSubString = subString(str, i, i2);
            if (z) {
                this.symbols[i4] = strSubString;
            }
            return strSubString;
        }
        if (i2 != str.length()) {
            str = subString(str, i, i2);
        }
        java.lang.String strIntern = str.intern();
        this.symbols[i4] = strIntern;
        return strIntern;
    }

    private static java.lang.String subString(java.lang.String str, int i, int i2) {
        char[] cArr = new char[i2];
        str.getChars(i, i2 + i, cArr, 0);
        return new java.lang.String(cArr);
    }

    public static int hash(char[] cArr, int i, int i2) {
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2) {
            i4 = (i4 * 31) + cArr[i];
            i3++;
            i++;
        }
        return i4;
    }
}
