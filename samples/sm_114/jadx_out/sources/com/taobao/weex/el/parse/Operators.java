package com.taobao.weex.el.parse;

/* JADX INFO: loaded from: classes.dex */
public class Operators {
    public static final java.lang.String AND = "&&";
    public static final java.lang.String AND_NOT = "!";
    public static final char ARRAY_END = ']';
    public static final java.lang.String ARRAY_END_STR = "]";
    public static final char ARRAY_SEPRATOR = ',';
    public static final java.lang.String ARRAY_SEPRATOR_STR = ",";
    public static final char ARRAY_START = '[';
    public static final java.lang.String ARRAY_START_STR = "[";
    public static final char BLOCK_END = '}';
    public static final java.lang.String BLOCK_END_STR = "}";
    public static final char BLOCK_START = '{';
    public static final java.lang.String BLOCK_START_STR = "{";
    public static final char BRACKET_END = ')';
    public static final java.lang.String BRACKET_END_STR = ")";
    public static final char BRACKET_START = '(';
    public static final java.lang.String BRACKET_START_STR = "(";
    public static final char CONDITION_IF = '?';
    public static final char CONDITION_IF_MIDDLE = ':';
    public static final java.lang.String CONDITION_IF_STRING = "?";
    public static final java.lang.String DIV = "/";
    public static final char DOLLAR = '$';
    public static final java.lang.String DOLLAR_STR = "$";
    public static final char DOT = '.';
    public static final java.lang.String DOT_STR = ".";
    public static final java.lang.String EQUAL = "===";
    public static final java.lang.String EQUAL2 = "==";
    public static final java.lang.String G = ">";
    public static final java.lang.String GE = ">=";
    public static final java.util.Map<java.lang.String, java.lang.Object> KEYWORDS;
    public static final java.lang.String L = "<";
    public static final java.lang.String LE = "<=";
    public static final java.lang.String MOD = "%";
    public static final java.lang.String MUL = "*";
    public static final java.lang.String NOT_EQUAL = "!==";
    public static final java.lang.String NOT_EQUAL2 = "!=";
    public static java.util.Map<java.lang.String, java.lang.Integer> OPERATORS_PRIORITY = null;
    public static final java.lang.String OR = "||";
    public static final java.lang.String PLUS = "+";
    public static final char QUOTE = '\"';
    public static final char SINGLE_QUOTE = '\'';
    public static final char SPACE = ' ';
    public static final java.lang.String SPACE_STR = " ";
    public static final java.lang.String SUB = "-";

    public static boolean isOpEnd(char c) {
        return c == ')' || c == ']' || c == ' ' || c == ',';
    }

    public static java.lang.Object dot(com.taobao.weex.el.parse.Token token, com.taobao.weex.el.parse.Token token2, java.lang.Object obj) {
        java.lang.Object objExecute;
        java.lang.Object objExecute2;
        if (token == null || token2 == null || (objExecute = token.execute(obj)) == null) {
            return null;
        }
        if (token2.getType() != 0) {
            java.lang.Object objExecute3 = token2.execute(obj);
            if (objExecute3 instanceof java.lang.Double) {
                objExecute3 = java.lang.Integer.valueOf(((java.lang.Double) objExecute3).intValue());
            }
            objExecute2 = el(objExecute, objExecute3 == null ? "" : objExecute3.toString().trim());
        } else {
            objExecute2 = token2.execute(objExecute);
        }
        return objExecute2 != null ? objExecute2 : specialKey(objExecute, token2.getToken());
    }

    public static java.lang.Object el(java.lang.Object obj, java.lang.String str) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof com.taobao.weex.el.parse.ArrayStack) {
            com.taobao.weex.el.parse.ArrayStack arrayStack = (com.taobao.weex.el.parse.ArrayStack) obj;
            for (int size = arrayStack.size() - 1; size >= 0; size--) {
                java.lang.Object obj2 = arrayStack.get(size);
                if (obj2 instanceof java.util.Map) {
                    java.util.Map map = (java.util.Map) obj2;
                    if (map.containsKey(str)) {
                        return map.get(str);
                    }
                }
            }
        }
        if (obj instanceof java.util.Stack) {
            java.util.Stack stack = (java.util.Stack) obj;
            for (int size2 = stack.size() - 1; size2 >= 0; size2--) {
                java.lang.Object obj3 = stack.get(size2);
                if (obj3 instanceof java.util.Map) {
                    java.util.Map map2 = (java.util.Map) obj3;
                    if (map2.containsKey(str)) {
                        return map2.get(str);
                    }
                }
            }
        }
        if (obj instanceof java.util.Map) {
            return ((java.util.Map) obj).get(str);
        }
        if (obj instanceof java.util.List) {
            try {
                return ((java.util.List) obj).get(java.lang.Integer.parseInt(str));
            } catch (java.lang.Exception unused) {
            }
        }
        if (obj.getClass().isArray()) {
            try {
                return java.lang.reflect.Array.get(obj, java.lang.Integer.parseInt(str));
            } catch (java.lang.Exception unused2) {
            }
        }
        return null;
    }

    public static java.lang.Object specialKey(java.lang.Object obj, java.lang.String str) {
        if (!"length".equals(str)) {
            return null;
        }
        if (obj instanceof java.lang.CharSequence) {
            return java.lang.Integer.valueOf(((java.lang.CharSequence) obj).length());
        }
        boolean z = obj instanceof java.util.Map;
        if (z) {
            return java.lang.Integer.valueOf(((java.util.Map) obj).size());
        }
        if (z) {
            return java.lang.Integer.valueOf(((java.util.Map) obj).size());
        }
        if (obj instanceof java.util.List) {
            return java.lang.Integer.valueOf(((java.util.List) obj).size());
        }
        if (obj.getClass().isArray()) {
            return java.lang.Integer.valueOf(java.lang.reflect.Array.getLength(obj));
        }
        return null;
    }

    public static java.lang.Object plus(com.taobao.weex.el.parse.Token token, com.taobao.weex.el.parse.Token token2, java.lang.Object obj) {
        java.lang.Object objExecute = token != null ? token.execute(obj) : null;
        java.lang.Object objExecute2 = token2 != null ? token2.execute(obj) : null;
        if ((objExecute instanceof java.lang.CharSequence) || (objExecute2 instanceof java.lang.CharSequence)) {
            if (objExecute == null) {
                return objExecute2;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(objExecute.toString());
            sb.append(objExecute2 != null ? objExecute2.toString() : "");
            return sb.toString();
        }
        if ((objExecute instanceof java.lang.Number) || (objExecute2 instanceof java.lang.Number)) {
            return java.lang.Double.valueOf(getNumber(objExecute) + getNumber(objExecute2));
        }
        if (objExecute == null && objExecute2 == null) {
            return null;
        }
        if (objExecute == null) {
            return objExecute2.toString();
        }
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        sb2.append(objExecute.toString());
        sb2.append(objExecute2 != null ? objExecute2.toString() : "");
        return sb2.toString();
    }

    public static java.lang.Object sub(com.taobao.weex.el.parse.Token token, com.taobao.weex.el.parse.Token token2, java.lang.Object obj) {
        return java.lang.Double.valueOf(getNumber(token != null ? token.execute(obj) : null) - getNumber(token2 != null ? token2.execute(obj) : null));
    }

    public static java.lang.Object div(com.taobao.weex.el.parse.Token token, com.taobao.weex.el.parse.Token token2, java.lang.Object obj) {
        return java.lang.Double.valueOf(getNumber(token != null ? token.execute(obj) : null) / getNumber(token2 != null ? token2.execute(obj) : null));
    }

    public static java.lang.Object mul(com.taobao.weex.el.parse.Token token, com.taobao.weex.el.parse.Token token2, java.lang.Object obj) {
        return java.lang.Double.valueOf(getNumber(token != null ? token.execute(obj) : null) * getNumber(token2 != null ? token2.execute(obj) : null));
    }

    public static java.lang.Object mod(com.taobao.weex.el.parse.Token token, com.taobao.weex.el.parse.Token token2, java.lang.Object obj) {
        return java.lang.Double.valueOf(getNumber(token != null ? token.execute(obj) : null) % getNumber(token2 != null ? token2.execute(obj) : null));
    }

    public static java.lang.Object condition(com.taobao.weex.el.parse.Token token, com.taobao.weex.el.parse.Token token2, com.taobao.weex.el.parse.Token token3, java.lang.Object obj) {
        if (token != null ? isTrue(token.execute(obj)) : false) {
            if (token2 != null) {
                return token2.execute(obj);
            }
            return null;
        }
        if (token3 != null) {
            return token3.execute(obj);
        }
        return null;
    }

    public static boolean tokenTrue(com.taobao.weex.el.parse.Token token, java.lang.Object obj) {
        if (token == null) {
            return false;
        }
        return isTrue(token.execute(obj));
    }

    public static double tokenNumber(com.taobao.weex.el.parse.Token token, java.lang.Object obj) {
        if (token == null) {
            return 0.0d;
        }
        return getNumber(token.execute(obj));
    }

    public static boolean isEquals(com.taobao.weex.el.parse.Token token, com.taobao.weex.el.parse.Token token2, java.lang.Object obj) {
        if (token == null && token2 == null) {
            return true;
        }
        java.lang.Object objExecute = token != null ? token.execute(obj) : null;
        java.lang.Object objExecute2 = token2 != null ? token2.execute(obj) : null;
        if (objExecute == null) {
            if (objExecute2 == null) {
                return true;
            }
            return (objExecute2 instanceof java.lang.CharSequence) && isEmpty(objExecute2.toString());
        }
        if (objExecute2 == null) {
            return isEmpty(objExecute.toString());
        }
        if (objExecute instanceof java.lang.Number) {
            if (objExecute2 instanceof java.lang.Number) {
                return ((java.lang.Number) objExecute).doubleValue() == ((java.lang.Number) objExecute2).doubleValue();
            }
            return ((java.lang.Number) objExecute).doubleValue() == getNumber(objExecute2);
        }
        if (objExecute2 instanceof java.lang.Number) {
            return getNumber(objExecute) == ((java.lang.Number) objExecute2).doubleValue();
        }
        if ((objExecute instanceof java.lang.CharSequence) || (objExecute2 instanceof java.lang.CharSequence)) {
            return objExecute.toString().trim().equals(objExecute2.toString().trim());
        }
        return objExecute.equals(objExecute2);
    }

    public static boolean isTrue(java.lang.Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof java.lang.Number) {
            return ((java.lang.Number) obj).doubleValue() != 0.0d;
        }
        java.lang.String strTrim = obj.toString().trim();
        return (io.dcloud.common.constant.AbsoluteConst.FALSE.equals(strTrim) || com.taobao.weex.common.Constants.Name.UNDEFINED.equals(strTrim) || "null".equals(strTrim) || isEmpty(strTrim)) ? false : true;
    }

    public static boolean isEmpty(java.lang.String str) {
        if (str == null) {
            return true;
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                return false;
            }
        }
        return true;
    }

    public static double getNumber(java.lang.Object obj) {
        if (obj == null) {
            return 0.0d;
        }
        if (obj instanceof java.lang.Number) {
            return ((java.lang.Number) obj).doubleValue();
        }
        try {
            return java.lang.Double.parseDouble(obj.toString());
        } catch (java.lang.Exception unused) {
            return 0.0d;
        }
    }

    public static boolean isOpEnd(java.lang.String str) {
        return isOpEnd(str.charAt(0));
    }

    public static boolean isDot(java.lang.String str) {
        char cCharAt = str.charAt(0);
        return cCharAt == '.' || cCharAt == '[';
    }

    static {
        java.util.HashMap map = new java.util.HashMap();
        OPERATORS_PRIORITY = map;
        map.put(BLOCK_END_STR, 0);
        OPERATORS_PRIORITY.put(BRACKET_END_STR, 0);
        OPERATORS_PRIORITY.put(SPACE_STR, 0);
        OPERATORS_PRIORITY.put(",", 0);
        OPERATORS_PRIORITY.put(ARRAY_END_STR, 0);
        OPERATORS_PRIORITY.put(OR, 1);
        OPERATORS_PRIORITY.put(AND, 1);
        OPERATORS_PRIORITY.put(EQUAL, 2);
        OPERATORS_PRIORITY.put(EQUAL2, 2);
        OPERATORS_PRIORITY.put(NOT_EQUAL, 2);
        OPERATORS_PRIORITY.put(NOT_EQUAL2, 2);
        OPERATORS_PRIORITY.put(G, 7);
        OPERATORS_PRIORITY.put(GE, 7);
        OPERATORS_PRIORITY.put(L, 7);
        OPERATORS_PRIORITY.put(LE, 8);
        OPERATORS_PRIORITY.put(PLUS, 9);
        OPERATORS_PRIORITY.put(SUB, 9);
        OPERATORS_PRIORITY.put("*", 10);
        OPERATORS_PRIORITY.put("/", 10);
        OPERATORS_PRIORITY.put("%", 10);
        OPERATORS_PRIORITY.put(AND_NOT, 11);
        OPERATORS_PRIORITY.put(DOT_STR, 15);
        OPERATORS_PRIORITY.put(ARRAY_START_STR, 16);
        OPERATORS_PRIORITY.put(BRACKET_START_STR, 17);
        OPERATORS_PRIORITY.put(BLOCK_START_STR, 17);
        java.util.HashMap map2 = new java.util.HashMap();
        KEYWORDS = map2;
        map2.put("null", null);
        map2.put(io.dcloud.common.constant.AbsoluteConst.TRUE, java.lang.Boolean.TRUE);
        map2.put(io.dcloud.common.constant.AbsoluteConst.FALSE, java.lang.Boolean.FALSE);
        map2.put(com.taobao.weex.common.Constants.Name.UNDEFINED, null);
    }
}
