package com.taobao.weex.el.parse;

/* JADX INFO: loaded from: classes.dex */
public class Parser {
    private java.lang.String code;
    private int position = 0;
    private com.taobao.weex.el.parse.ArrayStack<com.taobao.weex.el.parse.Token> stacks = new com.taobao.weex.el.parse.ArrayStack<>();
    private com.taobao.weex.el.parse.ArrayStack<com.taobao.weex.el.parse.Symbol> operators = new com.taobao.weex.el.parse.ArrayStack<>();

    public Parser(java.lang.String str) {
        this.code = str;
    }

    public final com.taobao.weex.el.parse.Token parse() {
        while (hasNextToken()) {
            scanNextToken();
        }
        while (!this.operators.isEmpty()) {
            doOperator(this.operators.pop());
        }
        if (this.stacks.size() == 1) {
            return this.stacks.pop();
        }
        return new com.taobao.weex.el.parse.Block(this.stacks.getList(), 6);
    }

    public static com.taobao.weex.el.parse.Token parse(java.lang.String str) {
        try {
            return new com.taobao.weex.el.parse.Parser(str).parse();
        } catch (java.lang.Exception e) {
            if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
                com.taobao.weex.utils.WXLogUtils.e("code " + str, e);
            }
            return new com.taobao.weex.el.parse.Block(null, 6);
        }
    }

    final char scanNextToken() {
        char cNextToken = nextToken();
        if (cNextToken == '$') {
            this.position++;
            return cNextToken;
        }
        if (java.lang.Character.isJavaIdentifierStart(cNextToken)) {
            scanIdentifier();
            return cNextToken;
        }
        if (cNextToken == '(' || cNextToken == '{') {
            scanBracket();
            return cNextToken;
        }
        if (cNextToken == '[') {
            scanArray();
            return cNextToken;
        }
        if (cNextToken == '\"' || cNextToken == '\'') {
            scanString();
            return cNextToken;
        }
        if ((cNextToken == '.' && java.lang.Character.isDigit(this.code.charAt(this.position + 1))) || java.lang.Character.isDigit(cNextToken)) {
            scanNumber();
            return cNextToken;
        }
        if (cNextToken == '?') {
            scanIf();
            return cNextToken;
        }
        if (cNextToken == ':' || cNextToken == ')' || cNextToken == '}' || cNextToken == ' ' || cNextToken == ']') {
            this.position++;
            return cNextToken;
        }
        scanOperator();
        return cNextToken;
    }

    final void scanArray() {
        com.taobao.weex.el.parse.Token block;
        int size = this.stacks.size();
        int size2 = this.operators.size();
        int i = this.position;
        int i2 = (i + (-1) < 0 || !java.lang.Character.isJavaIdentifierPart(this.code.charAt(i - 1))) ? 7 : 0;
        this.operators.push(new com.taobao.weex.el.parse.Symbol(com.taobao.weex.el.parse.Operators.ARRAY_START_STR, this.stacks.size()));
        this.position++;
        while (hasNextToken() && scanNextToken() != ']') {
        }
        if (this.stacks.size() <= size) {
            while (this.operators.size() > size2) {
                this.operators.pop();
            }
            return;
        }
        while (this.operators.size() > size2) {
            com.taobao.weex.el.parse.Symbol symbolPop = this.operators.pop();
            if (this.stacks.size() > size) {
                doOperator(symbolPop);
            }
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(4);
        for (int i3 = size; i3 < this.stacks.size(); i3++) {
            arrayList.add(this.stacks.get(i3));
        }
        while (this.stacks.size() > size) {
            this.stacks.pop();
        }
        if (i2 == 7 || this.stacks.size() == 0) {
            this.stacks.push(new com.taobao.weex.el.parse.Block(arrayList, 7));
            return;
        }
        com.taobao.weex.el.parse.Token tokenPop = this.stacks.pop();
        if (arrayList.size() == 1) {
            block = (com.taobao.weex.el.parse.Token) arrayList.get(0);
        } else {
            block = new com.taobao.weex.el.parse.Block(arrayList, 6);
        }
        com.taobao.weex.el.parse.Operator operator = new com.taobao.weex.el.parse.Operator(com.taobao.weex.el.parse.Operators.DOT_STR, i2);
        operator.first = tokenPop;
        operator.second = block;
        this.stacks.push(operator);
    }

    void scanBracket() {
        int size = this.stacks.size();
        int size2 = this.operators.size();
        if (this.code.charAt(this.position) == '{') {
            this.operators.push(new com.taobao.weex.el.parse.Symbol(com.taobao.weex.el.parse.Operators.BLOCK_START_STR, this.stacks.size()));
            this.position++;
            while (hasNextToken() && scanNextToken() != '}') {
            }
        } else {
            this.operators.push(new com.taobao.weex.el.parse.Symbol(com.taobao.weex.el.parse.Operators.BRACKET_START_STR, this.stacks.size()));
            this.position++;
            while (hasNextToken() && scanNextToken() != ')') {
            }
        }
        if (this.stacks.size() <= size) {
            while (this.operators.size() > size2) {
                this.operators.pop();
            }
            return;
        }
        while (this.operators.size() > size2) {
            com.taobao.weex.el.parse.Symbol symbolPop = this.operators.pop();
            if (this.stacks.size() > size) {
                doOperator(symbolPop);
            }
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(4);
        for (int i = size; i < this.stacks.size(); i++) {
            arrayList.add(this.stacks.get(i));
        }
        while (this.stacks.size() > size) {
            this.stacks.pop();
        }
        if (arrayList.size() == 1) {
            this.stacks.push((com.taobao.weex.el.parse.Token) arrayList.get(0));
        } else {
            this.stacks.push(new com.taobao.weex.el.parse.Block(arrayList, 6));
        }
    }

    void scanOperator() {
        int i = this.position;
        java.lang.String strSubstring = this.code.substring(this.position, java.lang.Math.min(i + 3, this.code.length()));
        if (strSubstring.length() >= 3 && !com.taobao.weex.el.parse.Operators.OPERATORS_PRIORITY.containsKey(strSubstring)) {
            strSubstring = strSubstring.substring(0, 2);
        }
        if (strSubstring.length() >= 2 && !com.taobao.weex.el.parse.Operators.OPERATORS_PRIORITY.containsKey(strSubstring)) {
            strSubstring = strSubstring.substring(0, 1);
        }
        if (!com.taobao.weex.el.parse.Operators.OPERATORS_PRIORITY.containsKey(strSubstring)) {
            com.taobao.weex.utils.WXLogUtils.e("weex", new java.lang.IllegalArgumentException(this.code.substring(0, java.lang.Math.min(i + 1, this.code.length())) + " illegal code operator" + strSubstring));
            this.position = this.position + strSubstring.length();
            return;
        }
        if (!this.operators.isEmpty() && this.operators.peek() != null) {
            if (com.taobao.weex.el.parse.Operators.OPERATORS_PRIORITY.get(this.operators.peek().op).intValue() >= com.taobao.weex.el.parse.Operators.OPERATORS_PRIORITY.get(strSubstring).intValue()) {
                doOperator(this.operators.pop());
            }
        }
        if (!com.taobao.weex.el.parse.Operators.isOpEnd(strSubstring)) {
            this.operators.push(new com.taobao.weex.el.parse.Symbol(strSubstring, this.stacks.size()));
        }
        this.position += strSubstring.length();
    }

    void doOperator(com.taobao.weex.el.parse.Symbol symbol) {
        java.lang.String str = symbol.op;
        if (com.taobao.weex.el.parse.Operators.BRACKET_START_STR.equals(symbol.op) || com.taobao.weex.el.parse.Operators.BLOCK_START_STR.equals(symbol.op) || com.taobao.weex.el.parse.Operators.ARRAY_START_STR.equals(symbol.op) || com.taobao.weex.el.parse.Operators.DOLLAR_STR.equals(symbol.op) || com.taobao.weex.el.parse.Operators.BLOCK_START_STR.equals(symbol.op)) {
            return;
        }
        int i = symbol.pos;
        int iMax = java.lang.Math.max(symbol.pos - 1, 0);
        if (!this.operators.isEmpty()) {
            iMax = java.lang.Math.max(iMax, this.operators.peek().pos);
        }
        com.taobao.weex.el.parse.Operator operator = new com.taobao.weex.el.parse.Operator(str, 5);
        if (com.taobao.weex.el.parse.Operators.AND_NOT.equals(str)) {
            if (this.stacks.size() > i) {
                operator.self = this.stacks.remove(i);
                this.stacks.add(i, operator);
                return;
            }
            return;
        }
        if (this.stacks.size() > i) {
            operator.second = this.stacks.remove(i);
            if (this.stacks.size() > iMax) {
                operator.first = this.stacks.remove(iMax);
            } else if (operator.second == null) {
                return;
            }
            this.stacks.add(iMax, operator);
        }
    }

    void scanIf() {
        com.taobao.weex.el.parse.Operator operator = new com.taobao.weex.el.parse.Operator(com.taobao.weex.el.parse.Operators.CONDITION_IF_STRING, 5);
        doStackOperators(0);
        if (this.stacks.size() > (this.operators.size() > 0 ? java.lang.Math.max(this.operators.peek().pos, 0) : 0)) {
            operator.self = this.stacks.pop();
        }
        int size = this.stacks.size();
        int size2 = this.operators.size();
        this.position++;
        while (hasNextToken() && scanNextToken() != ':') {
        }
        while (this.operators.size() > size2) {
            doOperator(this.operators.pop());
        }
        while (this.stacks.size() > size) {
            operator.first = this.stacks.pop();
        }
        int size3 = this.operators.size();
        while (hasNextToken()) {
            scanNextToken();
            if (hasNextToken()) {
                scanNextToken();
            }
            if (this.operators.size() <= size3) {
                break;
            }
        }
        doStackOperators(size3);
        while (this.stacks.size() > size) {
            operator.second = this.stacks.pop();
        }
        this.stacks.push(operator);
    }

    private final void doStackOperators(int i) {
        while (this.operators.size() > i) {
            doOperator(this.operators.pop());
        }
    }

    final void scanNumber() {
        com.taobao.weex.el.parse.Token token;
        int i = this.position;
        boolean z = (this.code.charAt(i) == 'e' || this.code.charAt(this.position) == '.') ? false : true;
        this.position++;
        while (hasNext()) {
            char cCharAt = this.code.charAt(this.position);
            if (!java.lang.Character.isDigit(cCharAt) && cCharAt != '.' && cCharAt != 'e') {
                break;
            }
            if (cCharAt == 'e' || cCharAt == '.') {
                z = false;
            }
            this.position++;
        }
        java.lang.String strSubstring = this.code.substring(i, this.position);
        if (com.taobao.weex.el.parse.Operators.DOT_STR.equals(strSubstring)) {
            return;
        }
        if (z) {
            token = new com.taobao.weex.el.parse.Token(strSubstring, 1);
        } else {
            token = new com.taobao.weex.el.parse.Token(strSubstring, 2);
        }
        this.stacks.push(token);
    }

    final void scanString() {
        int i = this.position;
        com.taobao.weex.el.parse.ArrayStack arrayStack = new com.taobao.weex.el.parse.ArrayStack();
        char cCharAt = this.code.charAt(i);
        arrayStack.push(java.lang.Character.valueOf(cCharAt));
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        while (true) {
            this.position = i + 1;
            if (this.position >= this.code.length()) {
                break;
            }
            char cCharAt2 = this.code.charAt(this.position);
            if (cCharAt2 == cCharAt) {
                if (this.code.charAt(this.position - 1) != '\\') {
                    arrayStack.pop();
                    if (arrayStack.size() == 0) {
                        this.position++;
                        break;
                    }
                } else {
                    sb.deleteCharAt(sb.length() - 1);
                    sb.append(cCharAt2);
                }
            } else {
                sb.append(cCharAt2);
            }
            i = this.position;
        }
        this.stacks.push(new com.taobao.weex.el.parse.Token(sb.toString(), 3));
    }

    final void scanIdentifier() {
        int i = this.position;
        this.position = i + 1;
        while (hasNext() && java.lang.Character.isJavaIdentifierPart(this.code.charAt(this.position))) {
            this.position++;
        }
        java.lang.String strSubstring = this.code.substring(i, this.position);
        if (strSubstring.startsWith(com.taobao.weex.el.parse.Operators.DOLLAR_STR)) {
            if (strSubstring.length() == 1) {
                return;
            } else {
                strSubstring = strSubstring.substring(1);
            }
        }
        this.stacks.push(new com.taobao.weex.el.parse.Token(strSubstring, (!com.taobao.weex.el.parse.Operators.KEYWORDS.containsKey(strSubstring) || (!this.operators.isEmpty() && com.taobao.weex.el.parse.Operators.isDot(this.operators.peek().op))) ? 0 : 4));
    }

    final boolean hasNext() {
        return this.position < this.code.length();
    }

    final boolean hasNextToken() {
        while (hasNext()) {
            if (this.code.charAt(this.position) != ' ') {
                return true;
            }
            this.position++;
        }
        return false;
    }

    final char nextToken() {
        char cCharAt = this.code.charAt(this.position);
        while (cCharAt == ' ') {
            this.position++;
            int length = this.code.length();
            int i = this.position;
            if (length <= i) {
                break;
            }
            cCharAt = this.code.charAt(i);
        }
        return cCharAt;
    }
}
