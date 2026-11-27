package com.alibaba.fastjson.util;

/* JADX INFO: loaded from: classes.dex */
public class TypeUtils {
    private static java.lang.Object OPTIONAL_EMPTY = null;
    private static boolean OPTIONAL_ERROR = false;
    private static com.alibaba.fastjson.util.Function<java.util.Map<java.lang.String, java.lang.Class<?>>, java.lang.Void> addBaseClassMappingsFunction = null;
    private static com.alibaba.fastjson.util.BiFunction<java.lang.Object, java.lang.Class, java.lang.Object> castFunction = null;
    private static com.alibaba.fastjson.util.Function<java.lang.Object, java.lang.Object> castToSqlDateFunction = null;
    private static com.alibaba.fastjson.util.Function<java.lang.Object, java.lang.Object> castToSqlTimeFunction = null;
    public static com.alibaba.fastjson.util.Function<java.lang.Object, java.lang.Object> castToTimestampFunction = null;
    private static java.lang.Class class_deque = null;
    public static boolean compatibleWithFieldName = false;
    public static boolean compatibleWithJavaBean = false;
    public static final long fnv1a_64_magic_hashcode = -3750763034362895579L;
    public static final long fnv1a_64_magic_prime = 1099511628211L;
    private static com.alibaba.fastjson.util.Function<java.lang.Class, java.lang.Boolean> isClobFunction;
    private static final java.util.Set<java.lang.String> isProxyClassNames;
    private static volatile java.util.Map<java.lang.Class, java.lang.String[]> kotlinIgnores;
    private static volatile boolean kotlinIgnores_error;
    private static volatile boolean kotlin_class_klass_error;
    private static volatile boolean kotlin_error;
    private static volatile java.lang.reflect.Constructor kotlin_kclass_constructor;
    private static volatile java.lang.reflect.Method kotlin_kclass_getConstructors;
    private static volatile java.lang.reflect.Method kotlin_kfunction_getParameters;
    private static volatile java.lang.reflect.Method kotlin_kparameter_getName;
    private static volatile java.lang.Class kotlin_metadata;
    private static volatile boolean kotlin_metadata_error;
    private static java.lang.Class<?> optionalClass;
    private static java.lang.reflect.Method oracleDateMethod;
    private static java.lang.reflect.Method oracleTimestampMethod;
    private static java.lang.Class<?> pathClass;
    private static final java.util.Map primitiveTypeMap;
    private static java.lang.Class<? extends java.lang.annotation.Annotation> transientClass;
    private static final java.util.regex.Pattern NUMBER_WITH_TRAILING_ZEROS_PATTERN = java.util.regex.Pattern.compile("\\.0*$");
    private static boolean setAccessibleEnable = true;
    private static boolean oracleTimestampMethodInited = false;
    private static boolean oracleDateMethodInited = false;
    private static boolean optionalClassInited = false;
    private static boolean transientClassInited = false;
    private static java.lang.Class<? extends java.lang.annotation.Annotation> class_OneToMany = null;
    private static boolean class_OneToMany_error = false;
    private static java.lang.Class<? extends java.lang.annotation.Annotation> class_ManyToMany = null;
    private static boolean class_ManyToMany_error = false;
    private static java.lang.reflect.Method method_HibernateIsInitialized = null;
    private static boolean method_HibernateIsInitialized_error = false;
    private static java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.Class<?>> mappings = new java.util.concurrent.ConcurrentHashMap(256, 0.75f, 1);
    private static boolean pathClass_error = false;
    private static java.lang.Class<? extends java.lang.annotation.Annotation> class_JacksonCreator = null;
    private static boolean class_JacksonCreator_error = false;
    private static volatile java.lang.Class class_XmlAccessType = null;
    private static volatile java.lang.Class class_XmlAccessorType = null;
    private static volatile boolean classXmlAccessorType_error = false;
    private static volatile java.lang.reflect.Method method_XmlAccessorType_value = null;
    private static volatile java.lang.reflect.Field field_XmlAccessType_FIELD = null;
    private static volatile java.lang.Object field_XmlAccessType_FIELD_VALUE = null;

    static int num(char c, char c2) {
        if (c < '0' || c > '9' || c2 < '0' || c2 > '9') {
            return -1;
        }
        return ((c - '0') * 10) + (c2 - '0');
    }

    static int num(char c, char c2, char c3, char c4) {
        if (c < '0' || c > '9' || c2 < '0' || c2 > '9' || c3 < '0' || c3 > '9' || c4 < '0' || c4 > '9') {
            return -1;
        }
        return ((c - '0') * 1000) + ((c2 - '0') * 100) + ((c3 - '0') * 10) + (c4 - '0');
    }

    static int num(char c, char c2, char c3, char c4, char c5, char c6, char c7, char c8, char c9) {
        if (c < '0' || c > '9' || c2 < '0' || c2 > '9' || c3 < '0' || c3 > '9' || c4 < '0' || c4 > '9' || c5 < '0' || c5 > '9' || c6 < '0' || c6 > '9' || c7 < '0' || c7 > '9' || c8 < '0' || c8 > '9' || c9 < '0' || c9 > '9') {
            return -1;
        }
        return ((c - '0') * 100000000) + ((c2 - '0') * 10000000) + ((c3 - '0') * kotlin.time.DurationKt.NANOS_IN_MILLIS) + ((c4 - '0') * 100000) + ((c5 - '0') * io.dcloud.feature.gg.dcloud.ADSim.INTISPLSH) + ((c6 - '0') * 1000) + ((c7 - '0') * 100) + ((c8 - '0') * 10) + (c9 - '0');
    }

    static {
        compatibleWithJavaBean = false;
        compatibleWithFieldName = false;
        class_deque = null;
        try {
            compatibleWithJavaBean = io.dcloud.common.constant.AbsoluteConst.TRUE.equals(com.alibaba.fastjson.util.IOUtils.getStringProperty(com.alibaba.fastjson.util.IOUtils.FASTJSON_COMPATIBLEWITHJAVABEAN));
            compatibleWithFieldName = io.dcloud.common.constant.AbsoluteConst.TRUE.equals(com.alibaba.fastjson.util.IOUtils.getStringProperty(com.alibaba.fastjson.util.IOUtils.FASTJSON_COMPATIBLEWITHFIELDNAME));
        } catch (java.lang.Throwable unused) {
        }
        try {
            class_deque = java.lang.Class.forName("java.util.Deque");
        } catch (java.lang.Throwable unused2) {
        }
        isClobFunction = new com.alibaba.fastjson.util.Function<java.lang.Class, java.lang.Boolean>() { // from class: com.alibaba.fastjson.util.TypeUtils.1
            @Override // com.alibaba.fastjson.util.Function
            public java.lang.Boolean apply(java.lang.Class cls) {
                return java.lang.Boolean.valueOf(java.sql.Clob.class.isAssignableFrom(cls));
            }
        };
        castToSqlDateFunction = new com.alibaba.fastjson.util.Function<java.lang.Object, java.lang.Object>() { // from class: com.alibaba.fastjson.util.TypeUtils.2
            @Override // com.alibaba.fastjson.util.Function
            public java.lang.Object apply(java.lang.Object obj) {
                long jLongValue;
                if (obj == null) {
                    return null;
                }
                if (obj instanceof java.sql.Date) {
                    return (java.sql.Date) obj;
                }
                if (obj instanceof java.util.Date) {
                    return new java.sql.Date(((java.util.Date) obj).getTime());
                }
                if (obj instanceof java.util.Calendar) {
                    return new java.sql.Date(((java.util.Calendar) obj).getTimeInMillis());
                }
                if (obj instanceof java.math.BigDecimal) {
                    jLongValue = com.alibaba.fastjson.util.TypeUtils.longValue((java.math.BigDecimal) obj);
                } else {
                    jLongValue = obj instanceof java.lang.Number ? ((java.lang.Number) obj).longValue() : 0L;
                }
                if (obj instanceof java.lang.String) {
                    java.lang.String str = (java.lang.String) obj;
                    if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                        return null;
                    }
                    if (com.alibaba.fastjson.util.TypeUtils.isNumber(str)) {
                        jLongValue = java.lang.Long.parseLong(str);
                    } else {
                        com.alibaba.fastjson.parser.JSONScanner jSONScanner = new com.alibaba.fastjson.parser.JSONScanner(str);
                        if (jSONScanner.scanISO8601DateIfMatch(false)) {
                            jLongValue = jSONScanner.getCalendar().getTime().getTime();
                        } else {
                            throw new com.alibaba.fastjson.JSONException("can not cast to Timestamp, value : " + str);
                        }
                    }
                }
                if (jLongValue <= 0) {
                    throw new com.alibaba.fastjson.JSONException("can not cast to Date, value : " + obj);
                }
                return new java.sql.Date(jLongValue);
            }
        };
        castToSqlTimeFunction = new com.alibaba.fastjson.util.Function<java.lang.Object, java.lang.Object>() { // from class: com.alibaba.fastjson.util.TypeUtils.3
            @Override // com.alibaba.fastjson.util.Function
            public java.lang.Object apply(java.lang.Object obj) {
                long jLongValue;
                if (obj == null) {
                    return null;
                }
                if (obj instanceof java.sql.Time) {
                    return (java.sql.Time) obj;
                }
                if (obj instanceof java.util.Date) {
                    return new java.sql.Time(((java.util.Date) obj).getTime());
                }
                if (obj instanceof java.util.Calendar) {
                    return new java.sql.Time(((java.util.Calendar) obj).getTimeInMillis());
                }
                if (obj instanceof java.math.BigDecimal) {
                    jLongValue = com.alibaba.fastjson.util.TypeUtils.longValue((java.math.BigDecimal) obj);
                } else {
                    jLongValue = obj instanceof java.lang.Number ? ((java.lang.Number) obj).longValue() : 0L;
                }
                if (obj instanceof java.lang.String) {
                    java.lang.String str = (java.lang.String) obj;
                    if (str.length() == 0 || "null".equalsIgnoreCase(str)) {
                        return null;
                    }
                    if (com.alibaba.fastjson.util.TypeUtils.isNumber(str)) {
                        jLongValue = java.lang.Long.parseLong(str);
                    } else {
                        if (str.length() == 8 && str.charAt(2) == ':' && str.charAt(5) == ':') {
                            return java.sql.Time.valueOf(str);
                        }
                        com.alibaba.fastjson.parser.JSONScanner jSONScanner = new com.alibaba.fastjson.parser.JSONScanner(str);
                        if (jSONScanner.scanISO8601DateIfMatch(false)) {
                            jLongValue = jSONScanner.getCalendar().getTime().getTime();
                        } else {
                            throw new com.alibaba.fastjson.JSONException("can not cast to Timestamp, value : " + str);
                        }
                    }
                }
                if (jLongValue <= 0) {
                    throw new com.alibaba.fastjson.JSONException("can not cast to Date, value : " + obj);
                }
                return new java.sql.Time(jLongValue);
            }
        };
        castToTimestampFunction = new com.alibaba.fastjson.util.Function<java.lang.Object, java.lang.Object>() { // from class: com.alibaba.fastjson.util.TypeUtils.4
            @Override // com.alibaba.fastjson.util.Function
            public java.lang.Object apply(java.lang.Object obj) {
                long jLongValue;
                if (obj == null) {
                    return null;
                }
                if (obj instanceof java.util.Calendar) {
                    return new java.sql.Timestamp(((java.util.Calendar) obj).getTimeInMillis());
                }
                if (obj instanceof java.sql.Timestamp) {
                    return (java.sql.Timestamp) obj;
                }
                if (obj instanceof java.util.Date) {
                    return new java.sql.Timestamp(((java.util.Date) obj).getTime());
                }
                if (obj instanceof java.math.BigDecimal) {
                    jLongValue = com.alibaba.fastjson.util.TypeUtils.longValue((java.math.BigDecimal) obj);
                } else {
                    jLongValue = obj instanceof java.lang.Number ? ((java.lang.Number) obj).longValue() : 0L;
                }
                if (obj instanceof java.lang.String) {
                    java.lang.String strSubstring = (java.lang.String) obj;
                    if (strSubstring.length() == 0 || "null".equals(strSubstring) || "NULL".equals(strSubstring)) {
                        return null;
                    }
                    if (strSubstring.endsWith(".000000000")) {
                        strSubstring = strSubstring.substring(0, strSubstring.length() - 10);
                    } else if (strSubstring.endsWith(".000000")) {
                        strSubstring = strSubstring.substring(0, strSubstring.length() - 7);
                    }
                    if (strSubstring.length() == 29 && strSubstring.charAt(4) == '-' && strSubstring.charAt(7) == '-' && strSubstring.charAt(10) == ' ' && strSubstring.charAt(13) == ':' && strSubstring.charAt(16) == ':' && strSubstring.charAt(19) == '.') {
                        return new java.sql.Timestamp(com.alibaba.fastjson.util.TypeUtils.num(strSubstring.charAt(0), strSubstring.charAt(1), strSubstring.charAt(2), strSubstring.charAt(3)) - 1900, com.alibaba.fastjson.util.TypeUtils.num(strSubstring.charAt(5), strSubstring.charAt(6)) - 1, com.alibaba.fastjson.util.TypeUtils.num(strSubstring.charAt(8), strSubstring.charAt(9)), com.alibaba.fastjson.util.TypeUtils.num(strSubstring.charAt(11), strSubstring.charAt(12)), com.alibaba.fastjson.util.TypeUtils.num(strSubstring.charAt(14), strSubstring.charAt(15)), com.alibaba.fastjson.util.TypeUtils.num(strSubstring.charAt(17), strSubstring.charAt(18)), com.alibaba.fastjson.util.TypeUtils.num(strSubstring.charAt(20), strSubstring.charAt(21), strSubstring.charAt(22), strSubstring.charAt(23), strSubstring.charAt(24), strSubstring.charAt(25), strSubstring.charAt(26), strSubstring.charAt(27), strSubstring.charAt(28)));
                    }
                    if (com.alibaba.fastjson.util.TypeUtils.isNumber(strSubstring)) {
                        jLongValue = java.lang.Long.parseLong(strSubstring);
                    } else {
                        com.alibaba.fastjson.parser.JSONScanner jSONScanner = new com.alibaba.fastjson.parser.JSONScanner(strSubstring);
                        if (jSONScanner.scanISO8601DateIfMatch(false)) {
                            jLongValue = jSONScanner.getCalendar().getTime().getTime();
                        } else {
                            throw new com.alibaba.fastjson.JSONException("can not cast to Timestamp, value : " + strSubstring);
                        }
                    }
                }
                return new java.sql.Timestamp(jLongValue);
            }
        };
        castFunction = new com.alibaba.fastjson.util.BiFunction<java.lang.Object, java.lang.Class, java.lang.Object>() { // from class: com.alibaba.fastjson.util.TypeUtils.5
            @Override // com.alibaba.fastjson.util.BiFunction
            public java.lang.Object apply(java.lang.Object obj, java.lang.Class cls) {
                if (cls == java.sql.Date.class) {
                    return com.alibaba.fastjson.util.TypeUtils.castToSqlDate(obj);
                }
                if (cls == java.sql.Time.class) {
                    return com.alibaba.fastjson.util.TypeUtils.castToSqlTime(obj);
                }
                if (cls == java.sql.Timestamp.class) {
                    return com.alibaba.fastjson.util.TypeUtils.castToTimestamp(obj);
                }
                return null;
            }
        };
        addBaseClassMappingsFunction = new com.alibaba.fastjson.util.Function<java.util.Map<java.lang.String, java.lang.Class<?>>, java.lang.Void>() { // from class: com.alibaba.fastjson.util.TypeUtils.6
            @Override // com.alibaba.fastjson.util.Function
            public java.lang.Void apply(java.util.Map<java.lang.String, java.lang.Class<?>> map) {
                java.lang.Class<?>[] clsArr = {java.sql.Time.class, java.sql.Date.class, java.sql.Timestamp.class};
                for (int i = 0; i < 3; i++) {
                    java.lang.Class<?> cls = clsArr[i];
                    if (cls != null) {
                        map.put(cls.getName(), cls);
                    }
                }
                return null;
            }
        };
        addBaseClassMappings();
        primitiveTypeMap = new java.util.HashMap<java.lang.Class, java.lang.String>(8) { // from class: com.alibaba.fastjson.util.TypeUtils.7
            {
                put(java.lang.Boolean.TYPE, "Z");
                put(java.lang.Character.TYPE, "C");
                put(java.lang.Byte.TYPE, "B");
                put(java.lang.Short.TYPE, "S");
                put(java.lang.Integer.TYPE, "I");
                put(java.lang.Long.TYPE, "J");
                put(java.lang.Float.TYPE, "F");
                put(java.lang.Double.TYPE, "D");
            }
        };
        isProxyClassNames = new java.util.HashSet<java.lang.String>(6) { // from class: com.alibaba.fastjson.util.TypeUtils.8
            {
                add("net.sf.cglib.proxy.Factory");
                add("org.springframework.cglib.proxy.Factory");
                add("javassist.util.proxy.ProxyObject");
                add("org.apache.ibatis.javassist.util.proxy.ProxyObject");
                add("org.hibernate.proxy.HibernateProxy");
                add("org.springframework.context.annotation.ConfigurationClassEnhancer$EnhancedConfiguration");
            }
        };
        OPTIONAL_ERROR = false;
    }

    public static boolean isXmlField(java.lang.Class cls) {
        java.lang.annotation.Annotation annotation;
        java.lang.Object objInvoke;
        if (class_XmlAccessorType == null && !classXmlAccessorType_error) {
            try {
                class_XmlAccessorType = java.lang.Class.forName("javax.xml.bind.annotation.XmlAccessorType");
            } catch (java.lang.Throwable unused) {
                classXmlAccessorType_error = true;
            }
        }
        if (class_XmlAccessorType == null || (annotation = getAnnotation((java.lang.Class<?>) cls, (java.lang.Class<java.lang.annotation.Annotation>) class_XmlAccessorType)) == null) {
            return false;
        }
        if (method_XmlAccessorType_value == null && !classXmlAccessorType_error) {
            try {
                method_XmlAccessorType_value = class_XmlAccessorType.getMethod("value", null);
            } catch (java.lang.Throwable unused2) {
                classXmlAccessorType_error = true;
            }
        }
        if (method_XmlAccessorType_value == null) {
            return false;
        }
        if (classXmlAccessorType_error) {
            objInvoke = null;
        } else {
            try {
                objInvoke = method_XmlAccessorType_value.invoke(annotation, null);
            } catch (java.lang.Throwable unused3) {
                classXmlAccessorType_error = true;
                objInvoke = null;
            }
        }
        if (objInvoke == null) {
            return false;
        }
        if (class_XmlAccessType == null && !classXmlAccessorType_error) {
            try {
                class_XmlAccessType = java.lang.Class.forName("javax.xml.bind.annotation.XmlAccessType");
                field_XmlAccessType_FIELD = class_XmlAccessType.getField("FIELD");
                field_XmlAccessType_FIELD_VALUE = field_XmlAccessType_FIELD.get(null);
            } catch (java.lang.Throwable unused4) {
                classXmlAccessorType_error = true;
            }
        }
        return objInvoke == field_XmlAccessType_FIELD_VALUE;
    }

    public static java.lang.annotation.Annotation getXmlAccessorType(java.lang.Class cls) {
        if (class_XmlAccessorType == null && !classXmlAccessorType_error) {
            try {
                class_XmlAccessorType = java.lang.Class.forName("javax.xml.bind.annotation.XmlAccessorType");
            } catch (java.lang.Throwable unused) {
                classXmlAccessorType_error = true;
            }
        }
        if (class_XmlAccessorType == null) {
            return null;
        }
        return getAnnotation((java.lang.Class<?>) cls, class_XmlAccessorType);
    }

    public static boolean isClob(java.lang.Class cls) {
        java.lang.Boolean bool = (java.lang.Boolean) com.alibaba.fastjson.util.ModuleUtil.callWhenHasJavaSql(isClobFunction, cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public static java.lang.String castToString(java.lang.Object obj) {
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public static java.lang.Byte castToByte(java.lang.Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof java.math.BigDecimal) {
            return java.lang.Byte.valueOf(byteValue((java.math.BigDecimal) obj));
        }
        if (obj instanceof java.lang.Number) {
            return java.lang.Byte.valueOf(((java.lang.Number) obj).byteValue());
        }
        if (obj instanceof java.lang.String) {
            java.lang.String str = (java.lang.String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
            return java.lang.Byte.valueOf(java.lang.Byte.parseByte(str));
        }
        if (obj instanceof java.lang.Boolean) {
            return java.lang.Byte.valueOf(((java.lang.Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0);
        }
        throw new com.alibaba.fastjson.JSONException("can not cast to byte, value : " + obj);
    }

    public static java.lang.Character castToChar(java.lang.Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof java.lang.Character) {
            return (java.lang.Character) obj;
        }
        if (obj instanceof java.lang.String) {
            java.lang.String str = (java.lang.String) obj;
            if (str.length() == 0) {
                return null;
            }
            if (str.length() != 1) {
                throw new com.alibaba.fastjson.JSONException("can not cast to char, value : " + obj);
            }
            return java.lang.Character.valueOf(str.charAt(0));
        }
        throw new com.alibaba.fastjson.JSONException("can not cast to char, value : " + obj);
    }

    public static java.lang.Short castToShort(java.lang.Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof java.math.BigDecimal) {
            return java.lang.Short.valueOf(shortValue((java.math.BigDecimal) obj));
        }
        if (obj instanceof java.lang.Number) {
            return java.lang.Short.valueOf(((java.lang.Number) obj).shortValue());
        }
        if (obj instanceof java.lang.String) {
            java.lang.String str = (java.lang.String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
            return java.lang.Short.valueOf(java.lang.Short.parseShort(str));
        }
        if (obj instanceof java.lang.Boolean) {
            return java.lang.Short.valueOf(((java.lang.Boolean) obj).booleanValue() ? (short) 1 : (short) 0);
        }
        throw new com.alibaba.fastjson.JSONException("can not cast to short, value : " + obj);
    }

    public static java.math.BigDecimal castToBigDecimal(java.lang.Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof java.lang.Float) {
            java.lang.Float f = (java.lang.Float) obj;
            if (java.lang.Float.isNaN(f.floatValue()) || java.lang.Float.isInfinite(f.floatValue())) {
                return null;
            }
        } else if (obj instanceof java.lang.Double) {
            java.lang.Double d = (java.lang.Double) obj;
            if (java.lang.Double.isNaN(d.doubleValue()) || java.lang.Double.isInfinite(d.doubleValue())) {
                return null;
            }
        } else {
            if (obj instanceof java.math.BigDecimal) {
                return (java.math.BigDecimal) obj;
            }
            if (obj instanceof java.math.BigInteger) {
                return new java.math.BigDecimal((java.math.BigInteger) obj);
            }
            if ((obj instanceof java.util.Map) && ((java.util.Map) obj).size() == 0) {
                return null;
            }
        }
        java.lang.String string = obj.toString();
        if (string.length() == 0 || string.equalsIgnoreCase("null")) {
            return null;
        }
        if (string.length() > 65535) {
            throw new com.alibaba.fastjson.JSONException("decimal overflow");
        }
        return new java.math.BigDecimal(string);
    }

    public static java.math.BigInteger castToBigInteger(java.lang.Object obj) {
        java.math.BigDecimal bigDecimal;
        int iScale;
        if (obj == null) {
            return null;
        }
        if (obj instanceof java.lang.Float) {
            java.lang.Float f = (java.lang.Float) obj;
            if (java.lang.Float.isNaN(f.floatValue()) || java.lang.Float.isInfinite(f.floatValue())) {
                return null;
            }
            return java.math.BigInteger.valueOf(f.longValue());
        }
        if (obj instanceof java.lang.Double) {
            java.lang.Double d = (java.lang.Double) obj;
            if (java.lang.Double.isNaN(d.doubleValue()) || java.lang.Double.isInfinite(d.doubleValue())) {
                return null;
            }
            return java.math.BigInteger.valueOf(d.longValue());
        }
        if (obj instanceof java.math.BigInteger) {
            return (java.math.BigInteger) obj;
        }
        if ((obj instanceof java.math.BigDecimal) && (iScale = (bigDecimal = (java.math.BigDecimal) obj).scale()) > -1000 && iScale < 1000) {
            return bigDecimal.toBigInteger();
        }
        java.lang.String string = obj.toString();
        if (string.length() == 0 || string.equalsIgnoreCase("null")) {
            return null;
        }
        if (string.length() > 65535) {
            throw new com.alibaba.fastjson.JSONException("decimal overflow");
        }
        return new java.math.BigInteger(string);
    }

    public static java.lang.Float castToFloat(java.lang.Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof java.lang.Number) {
            return java.lang.Float.valueOf(((java.lang.Number) obj).floatValue());
        }
        if (obj instanceof java.lang.String) {
            java.lang.String string = obj.toString();
            if (string.length() == 0 || "null".equals(string) || "NULL".equals(string)) {
                return null;
            }
            if (string.indexOf(44) != -1) {
                string = string.replaceAll(",", "");
            }
            return java.lang.Float.valueOf(java.lang.Float.parseFloat(string));
        }
        if (obj instanceof java.lang.Boolean) {
            return java.lang.Float.valueOf(((java.lang.Boolean) obj).booleanValue() ? 1.0f : 0.0f);
        }
        throw new com.alibaba.fastjson.JSONException("can not cast to float, value : " + obj);
    }

    public static java.lang.Double castToDouble(java.lang.Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof java.lang.Number) {
            return java.lang.Double.valueOf(((java.lang.Number) obj).doubleValue());
        }
        if (obj instanceof java.lang.String) {
            java.lang.String string = obj.toString();
            if (string.length() == 0 || "null".equals(string) || "NULL".equals(string)) {
                return null;
            }
            if (string.indexOf(44) != -1) {
                string = string.replaceAll(",", "");
            }
            return java.lang.Double.valueOf(java.lang.Double.parseDouble(string));
        }
        if (obj instanceof java.lang.Boolean) {
            return java.lang.Double.valueOf(((java.lang.Boolean) obj).booleanValue() ? 1.0d : 0.0d);
        }
        throw new com.alibaba.fastjson.JSONException("can not cast to double, value : " + obj);
    }

    public static java.util.Date castToDate(java.lang.Object obj) {
        return castToDate(obj, null);
    }

    public static java.util.Date castToDate(java.lang.Object obj, java.lang.String str) {
        long j;
        if (obj == null) {
            return null;
        }
        if (obj instanceof java.util.Date) {
            return (java.util.Date) obj;
        }
        if (obj instanceof java.util.Calendar) {
            return ((java.util.Calendar) obj).getTime();
        }
        if (obj instanceof java.math.BigDecimal) {
            return new java.util.Date(longValue((java.math.BigDecimal) obj));
        }
        if (obj instanceof java.lang.Number) {
            long jLongValue = ((java.lang.Number) obj).longValue();
            if ("unixtime".equals(str)) {
                jLongValue *= 1000;
            }
            return new java.util.Date(jLongValue);
        }
        if (obj instanceof java.lang.String) {
            java.lang.String strSubstring = (java.lang.String) obj;
            com.alibaba.fastjson.parser.JSONScanner jSONScanner = new com.alibaba.fastjson.parser.JSONScanner(strSubstring);
            try {
                if (jSONScanner.scanISO8601DateIfMatch(false)) {
                    java.util.Date time = jSONScanner.getCalendar().getTime();
                    jSONScanner.close();
                    return time;
                }
                jSONScanner.close();
                if (strSubstring.startsWith("/Date(") && strSubstring.endsWith(")/")) {
                    strSubstring = strSubstring.substring(6, strSubstring.length() - 2);
                }
                if (strSubstring.indexOf(45) > 0 || strSubstring.indexOf(43) > 0 || str != null) {
                    if (str == null) {
                        int length = strSubstring.length();
                        if (length == com.alibaba.fastjson.JSON.DEFFAULT_DATE_FORMAT.length() || (length == 22 && com.alibaba.fastjson.JSON.DEFFAULT_DATE_FORMAT.equals("yyyyMMddHHmmssSSSZ"))) {
                            str = com.alibaba.fastjson.JSON.DEFFAULT_DATE_FORMAT;
                        } else if (length == 10) {
                            str = "yyyy-MM-dd";
                        } else if (length == 19) {
                            str = "yyyy-MM-dd HH:mm:ss";
                        } else if (length == 29 && strSubstring.charAt(26) == ':' && strSubstring.charAt(28) == '0') {
                            str = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";
                        } else if (length == 23 && strSubstring.charAt(19) == ',') {
                            str = "yyyy-MM-dd HH:mm:ss,SSS";
                        } else {
                            str = "yyyy-MM-dd HH:mm:ss.SSS";
                        }
                    }
                    java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat(str, com.alibaba.fastjson.JSON.defaultLocale);
                    simpleDateFormat.setTimeZone(com.alibaba.fastjson.JSON.defaultTimeZone);
                    try {
                        return simpleDateFormat.parse(strSubstring);
                    } catch (java.text.ParseException unused) {
                        throw new com.alibaba.fastjson.JSONException("can not cast to Date, value : " + strSubstring);
                    }
                }
                if (strSubstring.length() == 0) {
                    return null;
                }
                j = java.lang.Long.parseLong(strSubstring);
            } catch (java.lang.Throwable th) {
                jSONScanner.close();
                throw th;
            }
        } else {
            j = -1;
        }
        if (j == -1) {
            java.lang.Class<?> cls = obj.getClass();
            if ("oracle.sql.TIMESTAMP".equals(cls.getName())) {
                if (oracleTimestampMethod == null && !oracleTimestampMethodInited) {
                    try {
                        oracleTimestampMethod = cls.getMethod("toJdbc", null);
                    } catch (java.lang.NoSuchMethodException unused2) {
                    } finally {
                        oracleTimestampMethodInited = true;
                    }
                }
                try {
                    return (java.util.Date) oracleTimestampMethod.invoke(obj, null);
                } catch (java.lang.Exception e) {
                    throw new com.alibaba.fastjson.JSONException("can not cast oracle.sql.TIMESTAMP to Date", e);
                }
            }
            if ("oracle.sql.DATE".equals(cls.getName())) {
                if (oracleDateMethod == null && !oracleDateMethodInited) {
                    try {
                        oracleDateMethod = cls.getMethod("toJdbc", null);
                    } catch (java.lang.NoSuchMethodException unused3) {
                    } finally {
                        oracleDateMethodInited = true;
                    }
                }
                try {
                    return (java.util.Date) oracleDateMethod.invoke(obj, null);
                } catch (java.lang.Exception e2) {
                    throw new com.alibaba.fastjson.JSONException("can not cast oracle.sql.DATE to Date", e2);
                }
            }
            throw new com.alibaba.fastjson.JSONException("can not cast to Date, value : " + obj);
        }
        return new java.util.Date(j);
    }

    public static java.lang.Object castToSqlDate(java.lang.Object obj) {
        return com.alibaba.fastjson.util.ModuleUtil.callWhenHasJavaSql(castToSqlDateFunction, obj);
    }

    public static long longExtractValue(java.lang.Number number) {
        if (number instanceof java.math.BigDecimal) {
            return ((java.math.BigDecimal) number).longValueExact();
        }
        return number.longValue();
    }

    public static java.lang.Object castToSqlTime(java.lang.Object obj) {
        return com.alibaba.fastjson.util.ModuleUtil.callWhenHasJavaSql(castToSqlTimeFunction, obj);
    }

    public static java.lang.Object castToTimestamp(java.lang.Object obj) {
        return com.alibaba.fastjson.util.ModuleUtil.callWhenHasJavaSql(castToTimestampFunction, obj);
    }

    public static boolean isNumber(java.lang.String str) {
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '+' || cCharAt == '-') {
                if (i != 0) {
                    return false;
                }
            } else if (cCharAt < '0' || cCharAt > '9') {
                return false;
            }
        }
        return true;
    }

    public static java.lang.Long castToLong(java.lang.Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof java.math.BigDecimal) {
            return java.lang.Long.valueOf(longValue((java.math.BigDecimal) obj));
        }
        if (obj instanceof java.lang.Number) {
            return java.lang.Long.valueOf(((java.lang.Number) obj).longValue());
        }
        if (obj instanceof java.lang.String) {
            java.lang.String strReplaceAll = (java.lang.String) obj;
            if (strReplaceAll.length() == 0 || "null".equals(strReplaceAll) || "NULL".equals(strReplaceAll)) {
                return null;
            }
            if (strReplaceAll.indexOf(44) != -1) {
                strReplaceAll = strReplaceAll.replaceAll(",", "");
            }
            try {
                return java.lang.Long.valueOf(java.lang.Long.parseLong(strReplaceAll));
            } catch (java.lang.NumberFormatException unused) {
                com.alibaba.fastjson.parser.JSONScanner jSONScanner = new com.alibaba.fastjson.parser.JSONScanner(strReplaceAll);
                java.util.Calendar calendar = jSONScanner.scanISO8601DateIfMatch(false) ? jSONScanner.getCalendar() : null;
                jSONScanner.close();
                if (calendar != null) {
                    return java.lang.Long.valueOf(calendar.getTimeInMillis());
                }
            }
        }
        if (obj instanceof java.util.Map) {
            java.util.Map map = (java.util.Map) obj;
            if (map.size() == 2 && map.containsKey("andIncrement") && map.containsKey("andDecrement")) {
                java.util.Iterator it = map.values().iterator();
                it.next();
                return castToLong(it.next());
            }
        }
        if (obj instanceof java.lang.Boolean) {
            return java.lang.Long.valueOf(((java.lang.Boolean) obj).booleanValue() ? 1L : 0L);
        }
        throw new com.alibaba.fastjson.JSONException("can not cast to long, value : " + obj);
    }

    public static byte byteValue(java.math.BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            return (byte) 0;
        }
        int iScale = bigDecimal.scale();
        if (iScale >= -100 && iScale <= 100) {
            return bigDecimal.byteValue();
        }
        return bigDecimal.byteValueExact();
    }

    public static short shortValue(java.math.BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            return (short) 0;
        }
        int iScale = bigDecimal.scale();
        if (iScale >= -100 && iScale <= 100) {
            return bigDecimal.shortValue();
        }
        return bigDecimal.shortValueExact();
    }

    public static int intValue(java.math.BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            return 0;
        }
        int iScale = bigDecimal.scale();
        if (iScale >= -100 && iScale <= 100) {
            return bigDecimal.intValue();
        }
        return bigDecimal.intValueExact();
    }

    public static long longValue(java.math.BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            return 0L;
        }
        int iScale = bigDecimal.scale();
        if (iScale >= -100 && iScale <= 100) {
            return bigDecimal.longValue();
        }
        return bigDecimal.longValueExact();
    }

    public static java.lang.Integer castToInt(java.lang.Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof java.lang.Integer) {
            return (java.lang.Integer) obj;
        }
        if (obj instanceof java.math.BigDecimal) {
            return java.lang.Integer.valueOf(intValue((java.math.BigDecimal) obj));
        }
        if (obj instanceof java.lang.Number) {
            return java.lang.Integer.valueOf(((java.lang.Number) obj).intValue());
        }
        if (obj instanceof java.lang.String) {
            java.lang.String strReplaceAll = (java.lang.String) obj;
            if (strReplaceAll.length() == 0 || "null".equals(strReplaceAll) || "NULL".equals(strReplaceAll)) {
                return null;
            }
            if (strReplaceAll.indexOf(44) != -1) {
                strReplaceAll = strReplaceAll.replaceAll(",", "");
            }
            java.util.regex.Matcher matcher = NUMBER_WITH_TRAILING_ZEROS_PATTERN.matcher(strReplaceAll);
            if (matcher.find()) {
                strReplaceAll = matcher.replaceAll("");
            }
            return java.lang.Integer.valueOf(java.lang.Integer.parseInt(strReplaceAll));
        }
        if (obj instanceof java.lang.Boolean) {
            return java.lang.Integer.valueOf(((java.lang.Boolean) obj).booleanValue() ? 1 : 0);
        }
        if (obj instanceof java.util.Map) {
            java.util.Map map = (java.util.Map) obj;
            if (map.size() == 2 && map.containsKey("andIncrement") && map.containsKey("andDecrement")) {
                java.util.Iterator it = map.values().iterator();
                it.next();
                return castToInt(it.next());
            }
        }
        throw new com.alibaba.fastjson.JSONException("can not cast to int, value : " + obj);
    }

    public static byte[] castToBytes(java.lang.Object obj) {
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        if (obj instanceof java.lang.String) {
            return com.alibaba.fastjson.util.IOUtils.decodeBase64((java.lang.String) obj);
        }
        throw new com.alibaba.fastjson.JSONException("can not cast to byte[], value : " + obj);
    }

    public static java.lang.Boolean castToBoolean(java.lang.Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof java.lang.Boolean) {
            return (java.lang.Boolean) obj;
        }
        if (obj instanceof java.math.BigDecimal) {
            return java.lang.Boolean.valueOf(intValue((java.math.BigDecimal) obj) == 1);
        }
        if (obj instanceof java.lang.Number) {
            return java.lang.Boolean.valueOf(((java.lang.Number) obj).intValue() == 1);
        }
        if (obj instanceof java.lang.String) {
            java.lang.String str = (java.lang.String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
            if (io.dcloud.common.constant.AbsoluteConst.TRUE.equalsIgnoreCase(str) || "1".equals(str)) {
                return java.lang.Boolean.TRUE;
            }
            if (io.dcloud.common.constant.AbsoluteConst.FALSE.equalsIgnoreCase(str) || com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT.equals(str)) {
                return java.lang.Boolean.FALSE;
            }
            if ("Y".equalsIgnoreCase(str) || "T".equals(str)) {
                return java.lang.Boolean.TRUE;
            }
            if ("F".equalsIgnoreCase(str) || "N".equals(str)) {
                return java.lang.Boolean.FALSE;
            }
        }
        throw new com.alibaba.fastjson.JSONException("can not cast to boolean, value : " + obj);
    }

    public static <T> T castToJavaBean(java.lang.Object obj, java.lang.Class<T> cls) {
        return (T) cast(obj, (java.lang.Class) cls, com.alibaba.fastjson.parser.ParserConfig.getGlobalInstance());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T cast(java.lang.Object obj, java.lang.Class<T> cls, com.alibaba.fastjson.parser.ParserConfig parserConfig) {
        java.lang.Object obj2;
        int i = 0;
        if (obj == 0) {
            if (cls == java.lang.Integer.TYPE) {
                return (T) 0;
            }
            if (cls == java.lang.Long.TYPE) {
                return (T) 0L;
            }
            if (cls == java.lang.Short.TYPE) {
                return (T) (short) 0;
            }
            if (cls == java.lang.Byte.TYPE) {
                return (T) (byte) 0;
            }
            if (cls == java.lang.Float.TYPE) {
                return (T) java.lang.Float.valueOf(0.0f);
            }
            if (cls == java.lang.Double.TYPE) {
                return (T) java.lang.Double.valueOf(0.0d);
            }
            if (cls == java.lang.Boolean.TYPE) {
                return (T) java.lang.Boolean.FALSE;
            }
            return null;
        }
        if (cls == null) {
            throw new java.lang.IllegalArgumentException("clazz is null");
        }
        if (cls != obj.getClass()) {
            if (obj instanceof java.util.Map) {
                if (cls != java.util.Map.class) {
                    java.util.Map map = (java.util.Map) obj;
                    if (cls != java.lang.Object.class || map.containsKey(com.alibaba.fastjson.JSON.DEFAULT_TYPE_KEY)) {
                        return (T) castToJavaBean(map, cls, parserConfig);
                    }
                }
            } else {
                if (cls.isArray()) {
                    if (obj instanceof java.util.Collection) {
                        java.util.Collection collection = (java.util.Collection) obj;
                        T t = (T) java.lang.reflect.Array.newInstance(cls.getComponentType(), collection.size());
                        java.util.Iterator it = collection.iterator();
                        while (it.hasNext()) {
                            java.lang.reflect.Array.set(t, i, cast(it.next(), (java.lang.Class) cls.getComponentType(), parserConfig));
                            i++;
                        }
                        return t;
                    }
                    if (cls == byte[].class) {
                        return (T) castToBytes(obj);
                    }
                }
                if (!cls.isAssignableFrom(obj.getClass())) {
                    if (cls == java.lang.Boolean.TYPE || cls == java.lang.Boolean.class) {
                        return (T) castToBoolean(obj);
                    }
                    if (cls == java.lang.Byte.TYPE || cls == java.lang.Byte.class) {
                        return (T) castToByte(obj);
                    }
                    if (cls == java.lang.Character.TYPE || cls == java.lang.Character.class) {
                        return (T) castToChar(obj);
                    }
                    if (cls == java.lang.Short.TYPE || cls == java.lang.Short.class) {
                        return (T) castToShort(obj);
                    }
                    if (cls == java.lang.Integer.TYPE || cls == java.lang.Integer.class) {
                        return (T) castToInt(obj);
                    }
                    if (cls == java.lang.Long.TYPE || cls == java.lang.Long.class) {
                        return (T) castToLong(obj);
                    }
                    if (cls == java.lang.Float.TYPE || cls == java.lang.Float.class) {
                        return (T) castToFloat(obj);
                    }
                    if (cls == java.lang.Double.TYPE || cls == java.lang.Double.class) {
                        return (T) castToDouble(obj);
                    }
                    if (cls == java.lang.String.class) {
                        return (T) castToString(obj);
                    }
                    if (cls == java.math.BigDecimal.class) {
                        return (T) castToBigDecimal(obj);
                    }
                    if (cls == java.math.BigInteger.class) {
                        return (T) castToBigInteger(obj);
                    }
                    if (cls == java.util.Date.class) {
                        return (T) castToDate(obj);
                    }
                    T t2 = (T) com.alibaba.fastjson.util.ModuleUtil.callWhenHasJavaSql(castFunction, obj, cls);
                    if (t2 != null) {
                        return t2;
                    }
                    if (cls.isEnum()) {
                        return (T) castToEnum(obj, cls, parserConfig);
                    }
                    if (java.util.Calendar.class.isAssignableFrom(cls)) {
                        java.util.Date dateCastToDate = castToDate(obj);
                        if (cls == java.util.Calendar.class) {
                            obj2 = (T) java.util.Calendar.getInstance(com.alibaba.fastjson.JSON.defaultTimeZone, com.alibaba.fastjson.JSON.defaultLocale);
                        } else {
                            try {
                                obj2 = (T) ((java.util.Calendar) cls.newInstance());
                            } catch (java.lang.Exception e) {
                                throw new com.alibaba.fastjson.JSONException("can not cast to : " + cls.getName(), e);
                            }
                        }
                        ((java.util.Calendar) obj2).setTime(dateCastToDate);
                        return (T) obj2;
                    }
                    java.lang.String name = cls.getName();
                    if (name.equals("javax.xml.datatype.XMLGregorianCalendar")) {
                        java.util.Date dateCastToDate2 = castToDate(obj);
                        java.util.Calendar calendar = java.util.Calendar.getInstance(com.alibaba.fastjson.JSON.defaultTimeZone, com.alibaba.fastjson.JSON.defaultLocale);
                        calendar.setTime(dateCastToDate2);
                        return (T) com.alibaba.fastjson.serializer.CalendarCodec.instance.createXMLGregorianCalendar(calendar);
                    }
                    if (obj instanceof java.lang.String) {
                        java.lang.String str = (java.lang.String) obj;
                        if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                            return null;
                        }
                        if (cls == java.util.Currency.class) {
                            return (T) java.util.Currency.getInstance(str);
                        }
                        if (cls == java.util.Locale.class) {
                            return (T) toLocale(str);
                        }
                        if (name.startsWith("java.time.")) {
                            return (T) com.alibaba.fastjson.JSON.parseObject(com.alibaba.fastjson.JSON.toJSONString(str), cls);
                        }
                    }
                    if (parserConfig.get(cls) != null) {
                        return (T) com.alibaba.fastjson.JSON.parseObject(com.alibaba.fastjson.JSON.toJSONString(obj), cls);
                    }
                    throw new com.alibaba.fastjson.JSONException("can not cast to : " + cls.getName());
                }
            }
        }
        return obj;
    }

    public static java.util.Locale toLocale(java.lang.String str) {
        java.lang.String[] strArrSplit = str.split("_");
        if (strArrSplit.length == 1) {
            return new java.util.Locale(strArrSplit[0]);
        }
        if (strArrSplit.length == 2) {
            return new java.util.Locale(strArrSplit[0], strArrSplit[1]);
        }
        return new java.util.Locale(strArrSplit[0], strArrSplit[1], strArrSplit[2]);
    }

    public static <T> T castToEnum(java.lang.Object obj, java.lang.Class<T> cls, com.alibaba.fastjson.parser.ParserConfig parserConfig) {
        try {
            if (obj instanceof java.lang.String) {
                java.lang.String str = (java.lang.String) obj;
                if (str.length() == 0) {
                    return null;
                }
                if (parserConfig == null) {
                    parserConfig = com.alibaba.fastjson.parser.ParserConfig.getGlobalInstance();
                }
                com.alibaba.fastjson.parser.deserializer.ObjectDeserializer deserializer = parserConfig.getDeserializer(cls);
                if (deserializer instanceof com.alibaba.fastjson.parser.deserializer.EnumDeserializer) {
                    return (T) ((com.alibaba.fastjson.parser.deserializer.EnumDeserializer) deserializer).getEnumByHashCode(fnv1a_64(str));
                }
                return (T) java.lang.Enum.valueOf(cls, str);
            }
            if (obj instanceof java.math.BigDecimal) {
                int iIntValue = intValue((java.math.BigDecimal) obj);
                T[] enumConstants = cls.getEnumConstants();
                if (iIntValue < enumConstants.length) {
                    return enumConstants[iIntValue];
                }
            }
            if (obj instanceof java.lang.Number) {
                int iIntValue2 = ((java.lang.Number) obj).intValue();
                T[] enumConstants2 = cls.getEnumConstants();
                if (iIntValue2 < enumConstants2.length) {
                    return enumConstants2[iIntValue2];
                }
            }
            throw new com.alibaba.fastjson.JSONException("can not cast to : " + cls.getName());
        } catch (java.lang.Exception e) {
            throw new com.alibaba.fastjson.JSONException("can not cast to : " + cls.getName(), e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T cast(java.lang.Object obj, java.lang.reflect.Type type, com.alibaba.fastjson.parser.ParserConfig parserConfig) {
        if (obj == 0) {
            return null;
        }
        if (type instanceof java.lang.Class) {
            return (T) cast(obj, (java.lang.Class) type, parserConfig);
        }
        if (type instanceof java.lang.reflect.ParameterizedType) {
            return (T) cast(obj, (java.lang.reflect.ParameterizedType) type, parserConfig);
        }
        if (obj instanceof java.lang.String) {
            java.lang.String str = (java.lang.String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
        }
        if (type instanceof java.lang.reflect.TypeVariable) {
            return obj;
        }
        throw new com.alibaba.fastjson.JSONException("can not cast to : " + type);
    }

    /* JADX WARN: Type inference failed for: r6v14, types: [T, java.util.Map$Entry] */
    /* JADX WARN: Type inference failed for: r7v1, types: [T, java.util.ArrayList, java.util.List] */
    /* JADX WARN: Type inference failed for: r7v9, types: [T, java.util.HashMap, java.util.Map] */
    public static <T> T cast(java.lang.Object obj, java.lang.reflect.ParameterizedType parameterizedType, com.alibaba.fastjson.parser.ParserConfig parserConfig) {
        java.lang.Object objCast;
        T t;
        java.lang.Object objCast2;
        java.lang.reflect.Type rawType = parameterizedType.getRawType();
        if (rawType == java.util.List.class || rawType == java.util.ArrayList.class) {
            java.lang.reflect.Type type = parameterizedType.getActualTypeArguments()[0];
            if (obj instanceof java.util.List) {
                java.util.List list = (java.util.List) obj;
                ?? r7 = (T) new java.util.ArrayList(list.size());
                for (java.lang.Object obj2 : list) {
                    if (type instanceof java.lang.Class) {
                        if (obj2 != null && obj2.getClass() == com.alibaba.fastjson.JSONObject.class) {
                            objCast = ((com.alibaba.fastjson.JSONObject) obj2).toJavaObject((java.lang.Class) type, parserConfig, 0);
                        } else {
                            objCast = cast(obj2, (java.lang.Class<java.lang.Object>) type, parserConfig);
                        }
                    } else {
                        objCast = cast(obj2, type, parserConfig);
                    }
                    r7.add(objCast);
                }
                return r7;
            }
        }
        if (rawType == java.util.Set.class || rawType == java.util.HashSet.class || rawType == java.util.TreeSet.class || rawType == java.util.Collection.class || rawType == java.util.List.class || rawType == java.util.ArrayList.class) {
            java.lang.reflect.Type type2 = parameterizedType.getActualTypeArguments()[0];
            if (obj instanceof java.lang.Iterable) {
                if (rawType == java.util.Set.class || rawType == java.util.HashSet.class) {
                    t = (T) new java.util.HashSet();
                } else if (rawType == java.util.TreeSet.class) {
                    t = (T) new java.util.TreeSet();
                } else {
                    t = (T) new java.util.ArrayList();
                }
                for (T t2 : (java.lang.Iterable) obj) {
                    if (type2 instanceof java.lang.Class) {
                        if (t2 != null && t2.getClass() == com.alibaba.fastjson.JSONObject.class) {
                            objCast2 = ((com.alibaba.fastjson.JSONObject) t2).toJavaObject((java.lang.Class) type2, parserConfig, 0);
                        } else {
                            objCast2 = cast((java.lang.Object) t2, (java.lang.Class<java.lang.Object>) type2, parserConfig);
                        }
                    } else {
                        objCast2 = cast(t2, type2, parserConfig);
                    }
                    ((java.util.Collection) t).add(objCast2);
                }
                return t;
            }
        }
        if (rawType == java.util.Map.class || rawType == java.util.HashMap.class) {
            java.lang.reflect.Type type3 = parameterizedType.getActualTypeArguments()[0];
            java.lang.reflect.Type type4 = parameterizedType.getActualTypeArguments()[1];
            if (obj instanceof java.util.Map) {
                ?? r8 = (T) new java.util.HashMap();
                for (java.util.Map.Entry entry : ((java.util.Map) obj).entrySet()) {
                    r8.put(cast(entry.getKey(), type3, parserConfig), cast(entry.getValue(), type4, parserConfig));
                }
                return r8;
            }
        }
        if ((obj instanceof java.lang.String) && ((java.lang.String) obj).length() == 0) {
            return null;
        }
        java.lang.reflect.Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        if (actualTypeArguments.length == 1 && (parameterizedType.getActualTypeArguments()[0] instanceof java.lang.reflect.WildcardType)) {
            return (T) cast(obj, rawType, parserConfig);
        }
        if (rawType == java.util.Map.Entry.class && (obj instanceof java.util.Map)) {
            java.util.Map map = (java.util.Map) obj;
            if (map.size() == 1) {
                ?? r6 = (T) ((java.util.Map.Entry) map.entrySet().iterator().next());
                java.lang.Object value = r6.getValue();
                if (actualTypeArguments.length == 2 && (value instanceof java.util.Map)) {
                    r6.setValue(cast(value, actualTypeArguments[1], parserConfig));
                }
                return r6;
            }
        }
        if (rawType instanceof java.lang.Class) {
            if (parserConfig == null) {
                parserConfig = com.alibaba.fastjson.parser.ParserConfig.global;
            }
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer deserializer = parserConfig.getDeserializer(rawType);
            if (deserializer != null) {
                return (T) deserializer.deserialze(new com.alibaba.fastjson.parser.DefaultJSONParser(com.alibaba.fastjson.JSON.toJSONString(obj), parserConfig), parameterizedType, null);
            }
        }
        throw new com.alibaba.fastjson.JSONException("can not cast to : " + parameterizedType);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T castToJavaBean(java.util.Map<java.lang.String, java.lang.Object> map, java.lang.Class<T> cls, com.alibaba.fastjson.parser.ParserConfig parserConfig) {
        com.alibaba.fastjson.JSONObject jSONObject;
        int iIntValue = 0;
        try {
            if (cls == java.lang.StackTraceElement.class) {
                java.lang.String str = (java.lang.String) map.get("className");
                java.lang.String str2 = (java.lang.String) map.get("methodName");
                java.lang.String str3 = (java.lang.String) map.get("fileName");
                java.lang.Number number = (java.lang.Number) map.get("lineNumber");
                if (number != null) {
                    if (number instanceof java.math.BigDecimal) {
                        iIntValue = ((java.math.BigDecimal) number).intValueExact();
                    } else {
                        iIntValue = number.intValue();
                    }
                }
                return (T) new java.lang.StackTraceElement(str, str2, str3, iIntValue);
            }
            java.lang.Object obj = map.get(com.alibaba.fastjson.JSON.DEFAULT_TYPE_KEY);
            if (obj instanceof java.lang.String) {
                java.lang.String str4 = (java.lang.String) obj;
                if (parserConfig == null) {
                    parserConfig = com.alibaba.fastjson.parser.ParserConfig.global;
                }
                java.lang.Class<?> clsCheckAutoType = parserConfig.checkAutoType(str4, null);
                if (clsCheckAutoType == null) {
                    throw new java.lang.ClassNotFoundException(str4 + " not found");
                }
                if (!clsCheckAutoType.equals(cls)) {
                    return (T) castToJavaBean(map, clsCheckAutoType, parserConfig);
                }
            }
            if (cls.isInterface()) {
                if (map instanceof com.alibaba.fastjson.JSONObject) {
                    jSONObject = (com.alibaba.fastjson.JSONObject) map;
                } else {
                    jSONObject = new com.alibaba.fastjson.JSONObject(map);
                }
                if (parserConfig == null) {
                    parserConfig = com.alibaba.fastjson.parser.ParserConfig.getGlobalInstance();
                }
                return parserConfig.get(cls) != null ? (T) com.alibaba.fastjson.JSON.parseObject(com.alibaba.fastjson.JSON.toJSONString(jSONObject), cls) : (T) java.lang.reflect.Proxy.newProxyInstance(java.lang.Thread.currentThread().getContextClassLoader(), new java.lang.Class[]{cls}, jSONObject);
            }
            if (cls == java.util.Locale.class) {
                java.lang.Object obj2 = map.get("language");
                java.lang.Object obj3 = map.get("country");
                if (obj2 instanceof java.lang.String) {
                    java.lang.String str5 = (java.lang.String) obj2;
                    if (obj3 instanceof java.lang.String) {
                        return (T) new java.util.Locale(str5, (java.lang.String) obj3);
                    }
                    if (obj3 == null) {
                        return (T) new java.util.Locale(str5);
                    }
                }
            }
            if (cls == java.lang.String.class && (map instanceof com.alibaba.fastjson.JSONObject)) {
                return (T) map.toString();
            }
            if (cls != com.alibaba.fastjson.JSON.class || !(map instanceof com.alibaba.fastjson.JSONObject)) {
                if (cls == java.util.LinkedHashMap.class && (map instanceof com.alibaba.fastjson.JSONObject)) {
                    T t = (T) ((com.alibaba.fastjson.JSONObject) map).getInnerMap();
                    if (t instanceof java.util.LinkedHashMap) {
                        return t;
                    }
                }
                if (!cls.isInstance(map)) {
                    if (cls == com.alibaba.fastjson.JSONObject.class) {
                        return (T) new com.alibaba.fastjson.JSONObject(map);
                    }
                    if (parserConfig == null) {
                        parserConfig = com.alibaba.fastjson.parser.ParserConfig.getGlobalInstance();
                    }
                    com.alibaba.fastjson.parser.deserializer.ObjectDeserializer deserializer = parserConfig.getDeserializer(cls);
                    com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer javaBeanDeserializer = deserializer instanceof com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer ? (com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) deserializer : null;
                    if (javaBeanDeserializer == null) {
                        throw new com.alibaba.fastjson.JSONException("can not get javaBeanDeserializer. " + cls.getName());
                    }
                    return (T) javaBeanDeserializer.createInstance(map, parserConfig);
                }
            }
            return map;
        } catch (java.lang.Exception e) {
            throw new com.alibaba.fastjson.JSONException(e.getMessage(), e);
        }
    }

    private static void addBaseClassMappings() {
        mappings.put("byte", java.lang.Byte.TYPE);
        mappings.put("short", java.lang.Short.TYPE);
        mappings.put("int", java.lang.Integer.TYPE);
        mappings.put("long", java.lang.Long.TYPE);
        mappings.put("float", java.lang.Float.TYPE);
        mappings.put("double", java.lang.Double.TYPE);
        mappings.put("boolean", java.lang.Boolean.TYPE);
        mappings.put("char", java.lang.Character.TYPE);
        mappings.put("[byte", byte[].class);
        mappings.put("[short", short[].class);
        mappings.put("[int", int[].class);
        mappings.put("[long", long[].class);
        mappings.put("[float", float[].class);
        mappings.put("[double", double[].class);
        mappings.put("[boolean", boolean[].class);
        mappings.put("[char", char[].class);
        mappings.put("[B", byte[].class);
        mappings.put("[S", short[].class);
        mappings.put("[I", int[].class);
        mappings.put("[J", long[].class);
        mappings.put("[F", float[].class);
        mappings.put("[D", double[].class);
        mappings.put("[C", char[].class);
        mappings.put("[Z", boolean[].class);
        java.lang.Class<?>[] clsArr = {java.lang.Object.class, java.lang.Cloneable.class, loadClass("java.lang.AutoCloseable"), java.lang.Exception.class, java.lang.RuntimeException.class, java.lang.IllegalAccessError.class, java.lang.IllegalAccessException.class, java.lang.IllegalArgumentException.class, java.lang.IllegalMonitorStateException.class, java.lang.IllegalStateException.class, java.lang.IllegalThreadStateException.class, java.lang.IndexOutOfBoundsException.class, java.lang.InstantiationError.class, java.lang.InstantiationException.class, java.lang.InternalError.class, java.lang.InterruptedException.class, java.lang.LinkageError.class, java.lang.NegativeArraySizeException.class, java.lang.NoClassDefFoundError.class, java.lang.NoSuchFieldError.class, java.lang.NoSuchFieldException.class, java.lang.NoSuchMethodError.class, java.lang.NoSuchMethodException.class, java.lang.NullPointerException.class, java.lang.NumberFormatException.class, java.lang.OutOfMemoryError.class, java.lang.SecurityException.class, java.lang.StackOverflowError.class, java.lang.StringIndexOutOfBoundsException.class, java.lang.TypeNotPresentException.class, java.lang.VerifyError.class, java.lang.StackTraceElement.class, java.util.HashMap.class, java.util.LinkedHashMap.class, java.util.Hashtable.class, java.util.TreeMap.class, java.util.IdentityHashMap.class, java.util.WeakHashMap.class, java.util.LinkedHashMap.class, java.util.HashSet.class, java.util.LinkedHashSet.class, java.util.TreeSet.class, java.util.ArrayList.class, java.util.concurrent.TimeUnit.class, java.util.concurrent.ConcurrentHashMap.class, java.util.concurrent.atomic.AtomicInteger.class, java.util.concurrent.atomic.AtomicLong.class, java.util.Collections.EMPTY_MAP.getClass(), java.lang.Boolean.class, java.lang.Character.class, java.lang.Byte.class, java.lang.Short.class, java.lang.Integer.class, java.lang.Long.class, java.lang.Float.class, java.lang.Double.class, java.lang.Number.class, java.lang.String.class, java.math.BigDecimal.class, java.math.BigInteger.class, java.util.BitSet.class, java.util.Calendar.class, java.util.Date.class, java.util.Locale.class, java.util.UUID.class, java.text.SimpleDateFormat.class, com.alibaba.fastjson.JSONObject.class, com.alibaba.fastjson.JSONPObject.class, com.alibaba.fastjson.JSONArray.class};
        for (int i = 0; i < 69; i++) {
            java.lang.Class<?> cls = clsArr[i];
            if (cls != null) {
                mappings.put(cls.getName(), cls);
            }
        }
        com.alibaba.fastjson.util.ModuleUtil.callWhenHasJavaSql(addBaseClassMappingsFunction, mappings);
    }

    public static void clearClassMapping() {
        mappings.clear();
        addBaseClassMappings();
    }

    public static void addMapping(java.lang.String str, java.lang.Class<?> cls) {
        mappings.put(str, cls);
    }

    public static java.lang.Class<?> loadClass(java.lang.String str) {
        return loadClass(str, null);
    }

    public static boolean isPath(java.lang.Class<?> cls) {
        if (pathClass == null && !pathClass_error) {
            try {
                pathClass = java.lang.Class.forName("java.nio.file.Path");
            } catch (java.lang.Throwable unused) {
                pathClass_error = true;
            }
        }
        java.lang.Class<?> cls2 = pathClass;
        if (cls2 != null) {
            return cls2.isAssignableFrom(cls);
        }
        return false;
    }

    public static java.lang.Class<?> getClassFromMapping(java.lang.String str) {
        return mappings.get(str);
    }

    public static java.lang.Class<?> loadClass(java.lang.String str, java.lang.ClassLoader classLoader) {
        return loadClass(str, classLoader, false);
    }

    public static java.lang.Class<?> loadClass(java.lang.String str, java.lang.ClassLoader classLoader, boolean z) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (str.length() > 198) {
            throw new com.alibaba.fastjson.JSONException("illegal className : " + str);
        }
        java.lang.Class<?> clsLoadClass = mappings.get(str);
        if (clsLoadClass != null) {
            return clsLoadClass;
        }
        if (str.charAt(0) == '[') {
            return java.lang.reflect.Array.newInstance(loadClass(str.substring(1), classLoader), 0).getClass();
        }
        if (str.startsWith("L") && str.endsWith(";")) {
            return loadClass(str.substring(1, str.length() - 1), classLoader);
        }
        if (classLoader != null) {
            try {
                clsLoadClass = classLoader.loadClass(str);
                if (z) {
                    mappings.put(str, clsLoadClass);
                }
                return clsLoadClass;
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
        java.lang.ClassLoader contextClassLoader = java.lang.Thread.currentThread().getContextClassLoader();
        if (contextClassLoader != null && contextClassLoader != classLoader) {
            java.lang.Class<?> clsLoadClass2 = contextClassLoader.loadClass(str);
            if (z) {
                try {
                    mappings.put(str, clsLoadClass2);
                } catch (java.lang.Throwable unused) {
                    clsLoadClass = clsLoadClass2;
                }
            }
            return clsLoadClass2;
        }
        try {
            clsLoadClass = java.lang.Class.forName(str);
            if (z) {
                mappings.put(str, clsLoadClass);
            }
        } catch (java.lang.Throwable unused2) {
        }
        return clsLoadClass;
    }

    public static com.alibaba.fastjson.serializer.SerializeBeanInfo buildBeanInfo(java.lang.Class<?> cls, java.util.Map<java.lang.String, java.lang.String> map, com.alibaba.fastjson.PropertyNamingStrategy propertyNamingStrategy) {
        return buildBeanInfo(cls, map, propertyNamingStrategy, false);
    }

    public static com.alibaba.fastjson.serializer.SerializeBeanInfo buildBeanInfo(java.lang.Class<?> cls, java.util.Map<java.lang.String, java.lang.String> map, com.alibaba.fastjson.PropertyNamingStrategy propertyNamingStrategy, boolean z) {
        com.alibaba.fastjson.PropertyNamingStrategy propertyNamingStrategy2;
        java.lang.String[] strArr;
        java.lang.String str;
        java.lang.String str2;
        int i;
        java.lang.Class<?> cls2;
        java.util.Map<java.lang.String, java.lang.String> map2;
        java.util.List<com.alibaba.fastjson.util.FieldInfo> listComputeGetters;
        java.util.List arrayList;
        com.alibaba.fastjson.annotation.JSONType jSONType = (com.alibaba.fastjson.annotation.JSONType) getAnnotation(cls, com.alibaba.fastjson.annotation.JSONType.class);
        if (jSONType != null) {
            java.lang.String[] strArrOrders = jSONType.orders();
            java.lang.String strTypeName = jSONType.typeName();
            if (strTypeName.length() == 0) {
                strTypeName = null;
            }
            com.alibaba.fastjson.PropertyNamingStrategy propertyNamingStrategyNaming = jSONType.naming();
            if (propertyNamingStrategyNaming != com.alibaba.fastjson.PropertyNamingStrategy.NeverUseThisValueExceptDefaultValue) {
                propertyNamingStrategy = propertyNamingStrategyNaming;
            }
            int iOf = com.alibaba.fastjson.serializer.SerializerFeature.of(jSONType.serialzeFeatures());
            java.lang.String strTypeKey = null;
            for (java.lang.Class<? super java.lang.Object> superclass = cls.getSuperclass(); superclass != null && superclass != java.lang.Object.class; superclass = superclass.getSuperclass()) {
                com.alibaba.fastjson.annotation.JSONType jSONType2 = (com.alibaba.fastjson.annotation.JSONType) getAnnotation(superclass, com.alibaba.fastjson.annotation.JSONType.class);
                if (jSONType2 == null) {
                    break;
                }
                strTypeKey = jSONType2.typeKey();
                if (strTypeKey.length() != 0) {
                    break;
                }
            }
            for (java.lang.Class<?> cls3 : cls.getInterfaces()) {
                com.alibaba.fastjson.annotation.JSONType jSONType3 = (com.alibaba.fastjson.annotation.JSONType) getAnnotation(cls3, com.alibaba.fastjson.annotation.JSONType.class);
                if (jSONType3 != null) {
                    strTypeKey = jSONType3.typeKey();
                    if (strTypeKey.length() != 0) {
                        break;
                    }
                }
            }
            propertyNamingStrategy2 = propertyNamingStrategy;
            str2 = (strTypeKey == null || strTypeKey.length() != 0) ? strTypeKey : null;
            strArr = strArrOrders;
            str = strTypeName;
            i = iOf;
        } else {
            propertyNamingStrategy2 = propertyNamingStrategy;
            strArr = null;
            str = null;
            str2 = null;
            i = 0;
        }
        java.util.HashMap map3 = new java.util.HashMap();
        com.alibaba.fastjson.parser.ParserConfig.parserAllFieldToCache(cls, map3);
        if (z) {
            listComputeGetters = computeGettersWithFieldBase(cls, map, false, propertyNamingStrategy2);
            cls2 = cls;
            map2 = map;
        } else {
            cls2 = cls;
            map2 = map;
            listComputeGetters = computeGetters(cls2, jSONType, map2, map3, false, propertyNamingStrategy2);
        }
        com.alibaba.fastjson.util.FieldInfo[] fieldInfoArr = new com.alibaba.fastjson.util.FieldInfo[listComputeGetters.size()];
        listComputeGetters.toArray(fieldInfoArr);
        if (strArr == null || strArr.length == 0) {
            arrayList = new java.util.ArrayList(listComputeGetters);
            java.util.Collections.sort(arrayList);
        } else if (z) {
            arrayList = computeGettersWithFieldBase(cls2, map2, true, propertyNamingStrategy2);
        } else {
            arrayList = computeGetters(cls2, jSONType, map2, map3, true, propertyNamingStrategy2);
        }
        com.alibaba.fastjson.util.FieldInfo[] fieldInfoArr2 = new com.alibaba.fastjson.util.FieldInfo[arrayList.size()];
        arrayList.toArray(fieldInfoArr2);
        if (java.util.Arrays.equals(fieldInfoArr2, fieldInfoArr)) {
            fieldInfoArr2 = fieldInfoArr;
        }
        return new com.alibaba.fastjson.serializer.SerializeBeanInfo(cls2, jSONType, str, str2, i, fieldInfoArr, fieldInfoArr2);
    }

    public static java.util.List<com.alibaba.fastjson.util.FieldInfo> computeGettersWithFieldBase(java.lang.Class<?> cls, java.util.Map<java.lang.String, java.lang.String> map, boolean z, com.alibaba.fastjson.PropertyNamingStrategy propertyNamingStrategy) {
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        for (java.lang.Class<?> superclass = cls; superclass != null; superclass = superclass.getSuperclass()) {
            computeFields(superclass, map, propertyNamingStrategy, linkedHashMap, superclass.getDeclaredFields());
        }
        return getFieldInfos(cls, z, linkedHashMap);
    }

    public static java.util.List<com.alibaba.fastjson.util.FieldInfo> computeGetters(java.lang.Class<?> cls, java.util.Map<java.lang.String, java.lang.String> map) {
        return computeGetters(cls, map, true);
    }

    public static java.util.List<com.alibaba.fastjson.util.FieldInfo> computeGetters(java.lang.Class<?> cls, java.util.Map<java.lang.String, java.lang.String> map, boolean z) {
        com.alibaba.fastjson.annotation.JSONType jSONType = (com.alibaba.fastjson.annotation.JSONType) getAnnotation(cls, com.alibaba.fastjson.annotation.JSONType.class);
        java.util.HashMap map2 = new java.util.HashMap();
        com.alibaba.fastjson.parser.ParserConfig.parserAllFieldToCache(cls, map2);
        return computeGetters(cls, jSONType, map, map2, z, com.alibaba.fastjson.PropertyNamingStrategy.CamelCase);
    }

    /* JADX WARN: Code duplicated, block: B:102:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:104:0x0203  */
    /* JADX WARN: Code duplicated, block: B:105:0x0208  */
    /* JADX WARN: Code duplicated, block: B:108:0x0220  */
    /* JADX WARN: Code duplicated, block: B:143:0x02a6  */
    /* JADX WARN: Code duplicated, block: B:145:0x02ab  */
    /* JADX WARN: Code duplicated, block: B:146:0x02b4  */
    /* JADX WARN: Code duplicated, block: B:153:0x02c7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:154:0x02c9  */
    /* JADX WARN: Code duplicated, block: B:157:0x02d2  */
    /* JADX WARN: Code duplicated, block: B:165:0x02f6  */
    /* JADX WARN: Code duplicated, block: B:168:0x02fd  */
    /* JADX WARN: Code duplicated, block: B:170:0x0307  */
    /* JADX WARN: Code duplicated, block: B:173:0x030f  */
    /* JADX WARN: Code duplicated, block: B:175:0x032d  */
    /* JADX WARN: Code duplicated, block: B:177:0x0339  */
    /* JADX WARN: Code duplicated, block: B:181:0x0349  */
    /* JADX WARN: Code duplicated, block: B:184:0x0357  */
    /* JADX WARN: Code duplicated, block: B:185:0x035c  */
    /* JADX WARN: Code duplicated, block: B:187:0x0365  */
    /* JADX WARN: Code duplicated, block: B:189:0x036d  */
    /* JADX WARN: Code duplicated, block: B:193:0x0379  */
    /* JADX WARN: Code duplicated, block: B:197:0x0396  */
    /* JADX WARN: Code duplicated, block: B:228:0x0420 A[PHI: r12
  0x0420: PHI (r12v7 java.util.Map<java.lang.String, java.lang.reflect.Field>) = 
  (r12v6 java.util.Map<java.lang.String, java.lang.reflect.Field>)
  (r12v8 java.util.Map<java.lang.String, java.lang.reflect.Field>)
  (r12v8 java.util.Map<java.lang.String, java.lang.reflect.Field>)
 binds: [B:227:0x041e, B:230:0x0428, B:240:0x0447] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:232:0x042b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:233:0x042d  */
    /* JADX WARN: Code duplicated, block: B:235:0x0433  */
    /* JADX WARN: Code duplicated, block: B:237:0x0439  */
    /* JADX WARN: Code duplicated, block: B:239:0x0443  */
    /* JADX WARN: Code duplicated, block: B:242:0x044a  */
    /* JADX WARN: Code duplicated, block: B:244:0x0468  */
    /* JADX WARN: Code duplicated, block: B:246:0x046e  */
    /* JADX WARN: Code duplicated, block: B:249:0x0479 A[PHI: r0
  0x0479: PHI (r0v31 java.lang.String) = (r0v21 java.lang.String), (r0v33 java.lang.String) binds: [B:243:0x0466, B:245:0x046c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:252:0x0485  */
    /* JADX WARN: Code duplicated, block: B:253:0x048a  */
    /* JADX WARN: Code duplicated, block: B:255:0x048e  */
    /* JADX WARN: Code duplicated, block: B:262:0x04a1  */
    /* JADX WARN: Code duplicated, block: B:266:0x04ad  */
    /* JADX WARN: Code duplicated, block: B:267:0x04b7  */
    /* JADX WARN: Code duplicated, block: B:54:0x0107 A[PHI: r6 r8 r20
  0x0107: PHI (r6v15 java.lang.String[]) = (r6v1 java.lang.String[]), (r6v1 java.lang.String[]), (r6v17 java.lang.String[]) binds: [B:44:0x00cd, B:46:0x00d7, B:48:0x00e1] A[DONT_GENERATE, DONT_INLINE]
  0x0107: PHI (r8v15 java.lang.annotation.Annotation[][]) = 
  (r8v1 java.lang.annotation.Annotation[][])
  (r8v1 java.lang.annotation.Annotation[][])
  (r8v17 java.lang.annotation.Annotation[][])
 binds: [B:44:0x00cd, B:46:0x00d7, B:48:0x00e1] A[DONT_GENERATE, DONT_INLINE]
  0x0107: PHI (r20v3 java.lang.reflect.Constructor<?>[]) = 
  (r20v0 java.lang.reflect.Constructor<?>[])
  (r20v9 java.lang.reflect.Constructor<?>[])
  (r20v9 java.lang.reflect.Constructor<?>[])
 binds: [B:44:0x00cd, B:46:0x00d7, B:48:0x00e1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:8:0x003c  */
    /* JADX WARN: Code duplicated, block: B:91:0x0190  */
    /* JADX WARN: Code duplicated, block: B:94:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:96:0x01c3  */
    /*  JADX ERROR: NullPointerException in pass: PrepareForCodeGen
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.RegisterArg.getSVar()" because "result" is null
        	at jadx.core.dex.visitors.PrepareForCodeGen.removeInstructions(PrepareForCodeGen.java:118)
        	at jadx.core.dex.visitors.PrepareForCodeGen.visit(PrepareForCodeGen.java:85)
        */
    public static java.util.List<com.alibaba.fastjson.util.FieldInfo> computeGetters(java.lang.Class<?> r31, com.alibaba.fastjson.annotation.JSONType r32, java.util.Map<java.lang.String, java.lang.String> r33, java.util.Map<java.lang.String, java.lang.reflect.Field> r34, boolean r35, com.alibaba.fastjson.PropertyNamingStrategy r36) {
        /*
            Method dump skipped, instruction units count: 1247
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.util.TypeUtils.computeGetters(java.lang.Class, com.alibaba.fastjson.annotation.JSONType, java.util.Map, java.util.Map, boolean, com.alibaba.fastjson.PropertyNamingStrategy):java.util.List");
    }

    private static java.util.List<com.alibaba.fastjson.util.FieldInfo> getFieldInfos(java.lang.Class<?> cls, boolean z, java.util.Map<java.lang.String, com.alibaba.fastjson.util.FieldInfo> map) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        com.alibaba.fastjson.annotation.JSONType jSONType = (com.alibaba.fastjson.annotation.JSONType) getAnnotation(cls, com.alibaba.fastjson.annotation.JSONType.class);
        java.lang.String[] strArrOrders = jSONType != null ? jSONType.orders() : null;
        if (strArrOrders != null && strArrOrders.length > 0) {
            java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap(map.size());
            for (com.alibaba.fastjson.util.FieldInfo fieldInfo : map.values()) {
                linkedHashMap.put(fieldInfo.name, fieldInfo);
            }
            for (java.lang.String str : strArrOrders) {
                com.alibaba.fastjson.util.FieldInfo fieldInfo2 = (com.alibaba.fastjson.util.FieldInfo) linkedHashMap.get(str);
                if (fieldInfo2 != null) {
                    arrayList.add(fieldInfo2);
                    linkedHashMap.remove(str);
                }
            }
            arrayList.addAll(linkedHashMap.values());
            return arrayList;
        }
        arrayList.addAll(map.values());
        if (z) {
            java.util.Collections.sort(arrayList);
        }
        return arrayList;
    }

    private static void computeFields(java.lang.Class<?> cls, java.util.Map<java.lang.String, java.lang.String> map, com.alibaba.fastjson.PropertyNamingStrategy propertyNamingStrategy, java.util.Map<java.lang.String, com.alibaba.fastjson.util.FieldInfo> map2, java.lang.reflect.Field[] fieldArr) {
        java.lang.String strLabel;
        int i;
        int i2;
        int i3;
        for (java.lang.reflect.Field field : fieldArr) {
            if (!java.lang.reflect.Modifier.isStatic(field.getModifiers())) {
                com.alibaba.fastjson.annotation.JSONField jSONField = (com.alibaba.fastjson.annotation.JSONField) getAnnotation(field, com.alibaba.fastjson.annotation.JSONField.class);
                java.lang.String name = field.getName();
                if (jSONField == null) {
                    strLabel = null;
                    i = 0;
                    i2 = 0;
                    i3 = 0;
                } else if (jSONField.serialize()) {
                    int iOrdinal = jSONField.ordinal();
                    int iOf = com.alibaba.fastjson.serializer.SerializerFeature.of(jSONField.serialzeFeatures());
                    int iOf2 = com.alibaba.fastjson.parser.Feature.of(jSONField.parseFeatures());
                    if (jSONField.name().length() != 0) {
                        name = jSONField.name();
                    }
                    strLabel = jSONField.label().length() != 0 ? jSONField.label() : null;
                    i = iOrdinal;
                    i2 = iOf;
                    i3 = iOf2;
                }
                if (map == null || (name = map.get(name)) != null) {
                    if (propertyNamingStrategy != null) {
                        name = propertyNamingStrategy.translate(name);
                    }
                    java.lang.String str = name;
                    if (!map2.containsKey(str)) {
                        map2.put(str, new com.alibaba.fastjson.util.FieldInfo(str, null, field, cls, null, i, i2, i3, null, jSONField, strLabel));
                    }
                }
            }
        }
    }

    private static java.lang.String getPropertyNameByCompatibleFieldName(java.util.Map<java.lang.String, java.lang.reflect.Field> map, java.lang.String str, java.lang.String str2, int i) {
        if (compatibleWithFieldName && !map.containsKey(str2)) {
            java.lang.String strSubstring = str.substring(i);
            if (map.containsKey(strSubstring)) {
                return strSubstring;
            }
        }
        return str2;
    }

    public static com.alibaba.fastjson.annotation.JSONField getSuperMethodAnnotation(java.lang.Class<?> cls, java.lang.reflect.Method method) {
        java.lang.Class<?>[] interfaces = cls.getInterfaces();
        if (interfaces.length > 0) {
            java.lang.Class<?>[] parameterTypes = method.getParameterTypes();
            for (java.lang.Class<?> cls2 : interfaces) {
                for (java.lang.reflect.Method method2 : cls2.getMethods()) {
                    java.lang.Class<?>[] parameterTypes2 = method2.getParameterTypes();
                    if (parameterTypes2.length == parameterTypes.length && method2.getName().equals(method.getName())) {
                        int i = 0;
                        while (true) {
                            if (i < parameterTypes.length) {
                                if (!parameterTypes2[i].equals(parameterTypes[i])) {
                                    break;
                                }
                                i++;
                            } else {
                                com.alibaba.fastjson.annotation.JSONField jSONField = (com.alibaba.fastjson.annotation.JSONField) getAnnotation(method2, com.alibaba.fastjson.annotation.JSONField.class);
                                if (jSONField == null) {
                                    break;
                                }
                                return jSONField;
                            }
                        }
                    }
                }
            }
        }
        java.lang.Class<? super java.lang.Object> superclass = cls.getSuperclass();
        if (superclass != null && java.lang.reflect.Modifier.isAbstract(superclass.getModifiers())) {
            java.lang.Class<?>[] parameterTypes3 = method.getParameterTypes();
            for (java.lang.reflect.Method method3 : superclass.getMethods()) {
                java.lang.Class<?>[] parameterTypes4 = method3.getParameterTypes();
                if (parameterTypes4.length == parameterTypes3.length && method3.getName().equals(method.getName())) {
                    int i2 = 0;
                    while (true) {
                        if (i2 < parameterTypes3.length) {
                            if (!parameterTypes4[i2].equals(parameterTypes3[i2])) {
                                break;
                            }
                            i2++;
                        } else {
                            com.alibaba.fastjson.annotation.JSONField jSONField2 = (com.alibaba.fastjson.annotation.JSONField) getAnnotation(method3, com.alibaba.fastjson.annotation.JSONField.class);
                            if (jSONField2 == null) {
                                break;
                            }
                            return jSONField2;
                        }
                    }
                }
            }
        }
        return null;
    }

    private static boolean isJSONTypeIgnore(java.lang.Class<?> cls, java.lang.String str) {
        com.alibaba.fastjson.annotation.JSONType jSONType = (com.alibaba.fastjson.annotation.JSONType) getAnnotation(cls, com.alibaba.fastjson.annotation.JSONType.class);
        if (jSONType != null) {
            java.lang.String[] strArrIncludes = jSONType.includes();
            if (strArrIncludes.length > 0) {
                for (java.lang.String str2 : strArrIncludes) {
                    if (str.equals(str2)) {
                        return false;
                    }
                }
                return true;
            }
            for (java.lang.String str3 : jSONType.ignores()) {
                if (str.equals(str3)) {
                    return true;
                }
            }
        }
        if (cls.getSuperclass() == java.lang.Object.class || cls.getSuperclass() == null) {
            return false;
        }
        return isJSONTypeIgnore(cls.getSuperclass(), str);
    }

    public static boolean isGenericParamType(java.lang.reflect.Type type) {
        java.lang.reflect.Type genericSuperclass;
        if (type instanceof java.lang.reflect.ParameterizedType) {
            return true;
        }
        return (type instanceof java.lang.Class) && (genericSuperclass = ((java.lang.Class) type).getGenericSuperclass()) != java.lang.Object.class && isGenericParamType(genericSuperclass);
    }

    public static java.lang.reflect.Type getGenericParamType(java.lang.reflect.Type type) {
        return (!(type instanceof java.lang.reflect.ParameterizedType) && (type instanceof java.lang.Class)) ? getGenericParamType(((java.lang.Class) type).getGenericSuperclass()) : type;
    }

    public static java.lang.reflect.Type unwrapOptional(java.lang.reflect.Type type) {
        if (!optionalClassInited) {
            try {
                optionalClass = java.lang.Class.forName("java.util.Optional");
            } catch (java.lang.Exception unused) {
            } finally {
                optionalClassInited = true;
            }
        }
        if (!(type instanceof java.lang.reflect.ParameterizedType)) {
            return type;
        }
        java.lang.reflect.ParameterizedType parameterizedType = (java.lang.reflect.ParameterizedType) type;
        return parameterizedType.getRawType() == optionalClass ? parameterizedType.getActualTypeArguments()[0] : type;
    }

    public static java.lang.Class<?> getClass(java.lang.reflect.Type type) {
        if (type.getClass() == java.lang.Class.class) {
            return (java.lang.Class) type;
        }
        if (type instanceof java.lang.reflect.ParameterizedType) {
            return getClass(((java.lang.reflect.ParameterizedType) type).getRawType());
        }
        if (type instanceof java.lang.reflect.TypeVariable) {
            java.lang.reflect.Type type2 = ((java.lang.reflect.TypeVariable) type).getBounds()[0];
            if (type2 instanceof java.lang.Class) {
                return (java.lang.Class) type2;
            }
            return getClass(type2);
        }
        if (type instanceof java.lang.reflect.WildcardType) {
            java.lang.reflect.Type[] upperBounds = ((java.lang.reflect.WildcardType) type).getUpperBounds();
            if (upperBounds.length == 1) {
                return getClass(upperBounds[0]);
            }
            return java.lang.Object.class;
        }
        return java.lang.Object.class;
    }

    public static java.lang.reflect.Field getField(java.lang.Class<?> cls, java.lang.String str, java.lang.reflect.Field[] fieldArr) {
        char cCharAt;
        char cCharAt2;
        for (java.lang.reflect.Field field : fieldArr) {
            java.lang.String name = field.getName();
            if (str.equals(name) || (str.length() > 2 && (cCharAt = str.charAt(0)) >= 'a' && cCharAt <= 'z' && (cCharAt2 = str.charAt(1)) >= 'A' && cCharAt2 <= 'Z' && str.equalsIgnoreCase(name))) {
                return field;
            }
        }
        java.lang.Class<? super java.lang.Object> superclass = cls.getSuperclass();
        if (superclass == null || superclass == java.lang.Object.class) {
            return null;
        }
        return getField(superclass, str, superclass.getDeclaredFields());
    }

    public static int getSerializeFeatures(java.lang.Class<?> cls) {
        com.alibaba.fastjson.annotation.JSONType jSONType = (com.alibaba.fastjson.annotation.JSONType) getAnnotation(cls, com.alibaba.fastjson.annotation.JSONType.class);
        if (jSONType == null) {
            return 0;
        }
        return com.alibaba.fastjson.serializer.SerializerFeature.of(jSONType.serialzeFeatures());
    }

    public static int getParserFeatures(java.lang.Class<?> cls) {
        com.alibaba.fastjson.annotation.JSONType jSONType = (com.alibaba.fastjson.annotation.JSONType) getAnnotation(cls, com.alibaba.fastjson.annotation.JSONType.class);
        if (jSONType == null) {
            return 0;
        }
        return com.alibaba.fastjson.parser.Feature.of(jSONType.parseFeatures());
    }

    public static java.lang.String decapitalize(java.lang.String str) {
        if (str == null || str.length() == 0 || (str.length() > 1 && java.lang.Character.isUpperCase(str.charAt(1)) && java.lang.Character.isUpperCase(str.charAt(0)))) {
            return str;
        }
        char[] charArray = str.toCharArray();
        charArray[0] = java.lang.Character.toLowerCase(charArray[0]);
        return new java.lang.String(charArray);
    }

    public static java.lang.String getPropertyNameByMethodName(java.lang.String str) {
        return java.lang.Character.toLowerCase(str.charAt(3)) + str.substring(4);
    }

    static void setAccessible(java.lang.reflect.AccessibleObject accessibleObject) {
        if (setAccessibleEnable && !accessibleObject.isAccessible()) {
            try {
                accessibleObject.setAccessible(true);
            } catch (java.lang.Throwable unused) {
                setAccessibleEnable = false;
            }
        }
    }

    public static java.lang.reflect.Type getCollectionItemType(java.lang.reflect.Type type) {
        if (type instanceof java.lang.reflect.ParameterizedType) {
            return getCollectionItemType((java.lang.reflect.ParameterizedType) type);
        }
        if (type instanceof java.lang.Class) {
            return getCollectionItemType((java.lang.Class<?>) type);
        }
        return java.lang.Object.class;
    }

    private static java.lang.reflect.Type getCollectionItemType(java.lang.Class<?> cls) {
        return cls.getName().startsWith("java.") ? java.lang.Object.class : getCollectionItemType(getCollectionSuperType(cls));
    }

    private static java.lang.reflect.Type getCollectionItemType(java.lang.reflect.ParameterizedType parameterizedType) {
        java.lang.reflect.Type rawType = parameterizedType.getRawType();
        java.lang.reflect.Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        if (rawType == java.util.Collection.class) {
            return getWildcardTypeUpperBounds(actualTypeArguments[0]);
        }
        java.lang.Class cls = (java.lang.Class) rawType;
        java.util.Map<java.lang.reflect.TypeVariable, java.lang.reflect.Type> mapCreateActualTypeMap = createActualTypeMap(cls.getTypeParameters(), actualTypeArguments);
        java.lang.reflect.Type collectionSuperType = getCollectionSuperType(cls);
        if (collectionSuperType instanceof java.lang.reflect.ParameterizedType) {
            java.lang.Class<?> rawClass = getRawClass(collectionSuperType);
            java.lang.reflect.Type[] actualTypeArguments2 = ((java.lang.reflect.ParameterizedType) collectionSuperType).getActualTypeArguments();
            if (actualTypeArguments2.length > 0) {
                return getCollectionItemType(makeParameterizedType(rawClass, actualTypeArguments2, mapCreateActualTypeMap));
            }
            return getCollectionItemType(rawClass);
        }
        return getCollectionItemType((java.lang.Class<?>) collectionSuperType);
    }

    private static java.lang.reflect.Type getCollectionSuperType(java.lang.Class<?> cls) {
        java.lang.reflect.Type type = null;
        for (java.lang.reflect.Type type2 : cls.getGenericInterfaces()) {
            java.lang.Class<?> rawClass = getRawClass(type2);
            if (rawClass == java.util.Collection.class) {
                return type2;
            }
            if (java.util.Collection.class.isAssignableFrom(rawClass)) {
                type = type2;
            }
        }
        return type == null ? cls.getGenericSuperclass() : type;
    }

    private static java.util.Map<java.lang.reflect.TypeVariable, java.lang.reflect.Type> createActualTypeMap(java.lang.reflect.TypeVariable[] typeVariableArr, java.lang.reflect.Type[] typeArr) {
        int length = typeVariableArr.length;
        java.util.HashMap map = new java.util.HashMap(length);
        for (int i = 0; i < length; i++) {
            map.put(typeVariableArr[i], typeArr[i]);
        }
        return map;
    }

    private static java.lang.reflect.ParameterizedType makeParameterizedType(java.lang.Class<?> cls, java.lang.reflect.Type[] typeArr, java.util.Map<java.lang.reflect.TypeVariable, java.lang.reflect.Type> map) {
        int length = typeArr.length;
        java.lang.reflect.Type[] typeArr2 = new java.lang.reflect.Type[length];
        for (int i = 0; i < length; i++) {
            typeArr2[i] = getActualType(typeArr[i], map);
        }
        return new com.alibaba.fastjson.util.ParameterizedTypeImpl(typeArr2, null, cls);
    }

    private static java.lang.reflect.Type getActualType(java.lang.reflect.Type type, java.util.Map<java.lang.reflect.TypeVariable, java.lang.reflect.Type> map) {
        if (type instanceof java.lang.reflect.TypeVariable) {
            return map.get(type);
        }
        if (type instanceof java.lang.reflect.ParameterizedType) {
            return makeParameterizedType(getRawClass(type), ((java.lang.reflect.ParameterizedType) type).getActualTypeArguments(), map);
        }
        return type instanceof java.lang.reflect.GenericArrayType ? new com.alibaba.fastjson.util.GenericArrayTypeImpl(getActualType(((java.lang.reflect.GenericArrayType) type).getGenericComponentType(), map)) : type;
    }

    private static java.lang.reflect.Type getWildcardTypeUpperBounds(java.lang.reflect.Type type) {
        if (!(type instanceof java.lang.reflect.WildcardType)) {
            return type;
        }
        java.lang.reflect.Type[] upperBounds = ((java.lang.reflect.WildcardType) type).getUpperBounds();
        return upperBounds.length > 0 ? upperBounds[0] : java.lang.Object.class;
    }

    public static java.lang.Class<?> getCollectionItemClass(java.lang.reflect.Type type) {
        if (type instanceof java.lang.reflect.ParameterizedType) {
            java.lang.reflect.Type type2 = ((java.lang.reflect.ParameterizedType) type).getActualTypeArguments()[0];
            if (type2 instanceof java.lang.reflect.WildcardType) {
                java.lang.reflect.Type[] upperBounds = ((java.lang.reflect.WildcardType) type2).getUpperBounds();
                if (upperBounds.length == 1) {
                    type2 = upperBounds[0];
                }
            }
            if (type2 instanceof java.lang.Class) {
                java.lang.Class<?> cls = (java.lang.Class) type2;
                if (java.lang.reflect.Modifier.isPublic(cls.getModifiers())) {
                    return cls;
                }
                throw new com.alibaba.fastjson.JSONException("can not create ASMParser");
            }
            throw new com.alibaba.fastjson.JSONException("can not create ASMParser");
        }
        return java.lang.Object.class;
    }

    public static java.lang.reflect.Type checkPrimitiveArray(java.lang.reflect.GenericArrayType genericArrayType) {
        java.lang.reflect.Type genericComponentType = genericArrayType.getGenericComponentType();
        java.lang.String str = com.taobao.weex.el.parse.Operators.ARRAY_START_STR;
        while (genericComponentType instanceof java.lang.reflect.GenericArrayType) {
            genericComponentType = ((java.lang.reflect.GenericArrayType) genericComponentType).getGenericComponentType();
            str = str + str;
        }
        if (!(genericComponentType instanceof java.lang.Class)) {
            return genericArrayType;
        }
        java.lang.Class cls = (java.lang.Class) genericComponentType;
        if (!cls.isPrimitive()) {
            return genericArrayType;
        }
        try {
            java.lang.String str2 = (java.lang.String) primitiveTypeMap.get(cls);
            if (str2 == null) {
                return genericArrayType;
            }
            return java.lang.Class.forName(str + str2);
        } catch (java.lang.ClassNotFoundException unused) {
            return genericArrayType;
        }
    }

    public static java.util.Set createSet(java.lang.reflect.Type type) {
        java.lang.reflect.Type type2;
        java.lang.Class<?> rawClass = getRawClass(type);
        if (rawClass == java.util.AbstractCollection.class || rawClass == java.util.Collection.class) {
            return new java.util.HashSet();
        }
        if (rawClass.isAssignableFrom(java.util.HashSet.class)) {
            return new java.util.HashSet();
        }
        if (rawClass.isAssignableFrom(java.util.LinkedHashSet.class)) {
            return new java.util.LinkedHashSet();
        }
        if (rawClass.isAssignableFrom(java.util.TreeSet.class)) {
            return new java.util.TreeSet();
        }
        if (rawClass.isAssignableFrom(java.util.EnumSet.class)) {
            if (type instanceof java.lang.reflect.ParameterizedType) {
                type2 = ((java.lang.reflect.ParameterizedType) type).getActualTypeArguments()[0];
            } else {
                type2 = java.lang.Object.class;
            }
            return java.util.EnumSet.noneOf((java.lang.Class) type2);
        }
        try {
            return (java.util.Set) rawClass.newInstance();
        } catch (java.lang.Exception unused) {
            throw new com.alibaba.fastjson.JSONException("create instance error, class " + rawClass.getName());
        }
    }

    public static java.util.Collection createCollection(java.lang.reflect.Type type) {
        java.lang.Class<?> cls;
        java.lang.reflect.Type type2;
        java.lang.Class<?> rawClass = getRawClass(type);
        if (rawClass == java.util.AbstractCollection.class || rawClass == java.util.Collection.class) {
            return new java.util.ArrayList();
        }
        if (rawClass.isAssignableFrom(java.util.HashSet.class)) {
            return new java.util.HashSet();
        }
        if (rawClass.isAssignableFrom(java.util.LinkedHashSet.class)) {
            return new java.util.LinkedHashSet();
        }
        if (rawClass.isAssignableFrom(java.util.TreeSet.class)) {
            return new java.util.TreeSet();
        }
        if (rawClass.isAssignableFrom(java.util.ArrayList.class)) {
            return new java.util.ArrayList();
        }
        if (rawClass.isAssignableFrom(java.util.EnumSet.class)) {
            if (type instanceof java.lang.reflect.ParameterizedType) {
                type2 = ((java.lang.reflect.ParameterizedType) type).getActualTypeArguments()[0];
            } else {
                type2 = java.lang.Object.class;
            }
            return java.util.EnumSet.noneOf((java.lang.Class) type2);
        }
        if (rawClass.isAssignableFrom(java.util.Queue.class) || ((cls = class_deque) != null && rawClass.isAssignableFrom(cls))) {
            return new java.util.LinkedList();
        }
        try {
            return (java.util.Collection) rawClass.newInstance();
        } catch (java.lang.Exception unused) {
            throw new com.alibaba.fastjson.JSONException("create instance error, class " + rawClass.getName());
        }
    }

    public static java.lang.Class<?> getRawClass(java.lang.reflect.Type type) {
        if (type instanceof java.lang.Class) {
            return (java.lang.Class) type;
        }
        if (type instanceof java.lang.reflect.ParameterizedType) {
            return getRawClass(((java.lang.reflect.ParameterizedType) type).getRawType());
        }
        if (type instanceof java.lang.reflect.WildcardType) {
            java.lang.reflect.Type[] upperBounds = ((java.lang.reflect.WildcardType) type).getUpperBounds();
            if (upperBounds.length == 1) {
                return getRawClass(upperBounds[0]);
            }
            throw new com.alibaba.fastjson.JSONException("TODO");
        }
        throw new com.alibaba.fastjson.JSONException("TODO");
    }

    public static boolean isProxy(java.lang.Class<?> cls) {
        for (java.lang.Class<?> cls2 : cls.getInterfaces()) {
            if (isProxyClassNames.contains(cls2.getName())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isTransient(java.lang.reflect.Method method) {
        if (method == null) {
            return false;
        }
        if (!transientClassInited) {
            try {
                transientClass = java.lang.Class.forName("java.beans.Transient");
            } catch (java.lang.Exception unused) {
            } finally {
                transientClassInited = true;
            }
        }
        java.lang.Class<? extends java.lang.annotation.Annotation> cls = transientClass;
        return (cls == null || getAnnotation(method, cls) == null) ? false : true;
    }

    public static boolean isAnnotationPresentOneToMany(java.lang.reflect.Method method) {
        if (method == null) {
            return false;
        }
        if (class_OneToMany == null && !class_OneToMany_error) {
            try {
                class_OneToMany = java.lang.Class.forName("javax.persistence.OneToMany");
            } catch (java.lang.Throwable unused) {
                class_OneToMany_error = true;
            }
        }
        java.lang.Class<? extends java.lang.annotation.Annotation> cls = class_OneToMany;
        return cls != null && method.isAnnotationPresent(cls);
    }

    public static boolean isAnnotationPresentManyToMany(java.lang.reflect.Method method) {
        if (method == null) {
            return false;
        }
        if (class_ManyToMany == null && !class_ManyToMany_error) {
            try {
                class_ManyToMany = java.lang.Class.forName("javax.persistence.ManyToMany");
            } catch (java.lang.Throwable unused) {
                class_ManyToMany_error = true;
            }
        }
        if (class_ManyToMany != null) {
            return method.isAnnotationPresent(class_OneToMany) || method.isAnnotationPresent(class_ManyToMany);
        }
        return false;
    }

    public static boolean isHibernateInitialized(java.lang.Object obj) {
        if (obj == null) {
            return false;
        }
        if (method_HibernateIsInitialized == null && !method_HibernateIsInitialized_error) {
            try {
                method_HibernateIsInitialized = java.lang.Class.forName("org.hibernate.Hibernate").getMethod("isInitialized", java.lang.Object.class);
            } catch (java.lang.Throwable unused) {
                method_HibernateIsInitialized_error = true;
            }
        }
        java.lang.reflect.Method method = method_HibernateIsInitialized;
        if (method != null) {
            try {
                return ((java.lang.Boolean) method.invoke(null, obj)).booleanValue();
            } catch (java.lang.Throwable unused2) {
            }
        }
        return true;
    }

    public static double parseDouble(java.lang.String str) {
        double d;
        double d2;
        int length = str.length();
        if (length > 10) {
            return java.lang.Double.parseDouble(str);
        }
        long j = 0;
        boolean z = false;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt == '-' && i2 == 0) {
                z = true;
            } else if (cCharAt == '.') {
                if (i != 0) {
                    return java.lang.Double.parseDouble(str);
                }
                i = (length - i2) - 1;
            } else {
                if (cCharAt < '0' || cCharAt > '9') {
                    return java.lang.Double.parseDouble(str);
                }
                j = (j * 10) + ((long) (cCharAt - '0'));
            }
        }
        if (z) {
            j = -j;
        }
        switch (i) {
            case 0:
                return j;
            case 1:
                d = j;
                d2 = 10.0d;
                break;
            case 2:
                d = j;
                d2 = 100.0d;
                break;
            case 3:
                d = j;
                d2 = 1000.0d;
                break;
            case 4:
                d = j;
                d2 = 10000.0d;
                break;
            case 5:
                d = j;
                d2 = 100000.0d;
                break;
            case 6:
                d = j;
                d2 = 1000000.0d;
                break;
            case 7:
                d = j;
                d2 = 1.0E7d;
                break;
            case 8:
                d = j;
                d2 = 1.0E8d;
                break;
            case 9:
                d = j;
                d2 = 1.0E9d;
                break;
            default:
                return java.lang.Double.parseDouble(str);
        }
        return d / d2;
    }

    public static float parseFloat(java.lang.String str) {
        float f;
        float f2;
        int length = str.length();
        if (length >= 10) {
            return java.lang.Float.parseFloat(str);
        }
        long j = 0;
        boolean z = false;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt == '-' && i2 == 0) {
                z = true;
            } else if (cCharAt == '.') {
                if (i != 0) {
                    return java.lang.Float.parseFloat(str);
                }
                i = (length - i2) - 1;
            } else {
                if (cCharAt < '0' || cCharAt > '9') {
                    return java.lang.Float.parseFloat(str);
                }
                j = (j * 10) + ((long) (cCharAt - '0'));
            }
        }
        if (z) {
            j = -j;
        }
        switch (i) {
            case 0:
                return j;
            case 1:
                f = j;
                f2 = 10.0f;
                break;
            case 2:
                f = j;
                f2 = 100.0f;
                break;
            case 3:
                f = j;
                f2 = 1000.0f;
                break;
            case 4:
                f = j;
                f2 = 10000.0f;
                break;
            case 5:
                f = j;
                f2 = 100000.0f;
                break;
            case 6:
                f = j;
                f2 = 1000000.0f;
                break;
            case 7:
                f = j;
                f2 = 1.0E7f;
                break;
            case 8:
                f = j;
                f2 = 1.0E8f;
                break;
            case 9:
                f = j;
                f2 = 1.0E9f;
                break;
            default:
                return java.lang.Float.parseFloat(str);
        }
        return f / f2;
    }

    public static long fnv1a_64_extract(java.lang.String str) {
        long j = fnv1a_64_magic_hashcode;
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt != '_' && cCharAt != '-') {
                if (cCharAt >= 'A' && cCharAt <= 'Z') {
                    cCharAt = (char) (cCharAt + ' ');
                }
                j = (j ^ ((long) cCharAt)) * fnv1a_64_magic_prime;
            }
        }
        return j;
    }

    public static long fnv1a_64_lower(java.lang.String str) {
        long j = fnv1a_64_magic_hashcode;
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt >= 'A' && cCharAt <= 'Z') {
                cCharAt = (char) (cCharAt + ' ');
            }
            j = (j ^ ((long) cCharAt)) * fnv1a_64_magic_prime;
        }
        return j;
    }

    public static long fnv1a_64(java.lang.String str) {
        long jCharAt = fnv1a_64_magic_hashcode;
        for (int i = 0; i < str.length(); i++) {
            jCharAt = (jCharAt ^ ((long) str.charAt(i))) * fnv1a_64_magic_prime;
        }
        return jCharAt;
    }

    public static boolean isKotlin(java.lang.Class cls) {
        if (kotlin_metadata == null && !kotlin_metadata_error) {
            try {
                kotlin_metadata = java.lang.Class.forName("kotlin.Metadata");
            } catch (java.lang.Throwable unused) {
                kotlin_metadata_error = true;
            }
        }
        return kotlin_metadata != null && cls.isAnnotationPresent(kotlin_metadata);
    }

    public static java.lang.reflect.Constructor getKotlinConstructor(java.lang.reflect.Constructor[] constructorArr) {
        return getKotlinConstructor(constructorArr, null);
    }

    public static java.lang.reflect.Constructor getKotlinConstructor(java.lang.reflect.Constructor[] constructorArr, java.lang.String[] strArr) {
        java.lang.reflect.Constructor constructor = null;
        for (java.lang.reflect.Constructor constructor2 : constructorArr) {
            java.lang.Class<?>[] parameterTypes = constructor2.getParameterTypes();
            if ((strArr == null || parameterTypes.length == strArr.length) && ((parameterTypes.length <= 0 || !parameterTypes[parameterTypes.length - 1].getName().equals("kotlin.jvm.internal.DefaultConstructorMarker")) && (constructor == null || constructor.getParameterTypes().length < parameterTypes.length))) {
                constructor = constructor2;
            }
        }
        return constructor;
    }

    public static java.lang.String[] getKoltinConstructorParameters(java.lang.Class cls) {
        if (kotlin_kclass_constructor == null && !kotlin_class_klass_error) {
            try {
                kotlin_kclass_constructor = java.lang.Class.forName("kotlin.reflect.jvm.internal.KClassImpl").getConstructor(java.lang.Class.class);
            } catch (java.lang.Throwable unused) {
                kotlin_class_klass_error = true;
            }
        }
        if (kotlin_kclass_constructor == null) {
            return null;
        }
        if (kotlin_kclass_getConstructors == null && !kotlin_class_klass_error) {
            try {
                kotlin_kclass_getConstructors = java.lang.Class.forName("kotlin.reflect.jvm.internal.KClassImpl").getMethod("getConstructors", null);
            } catch (java.lang.Throwable unused2) {
                kotlin_class_klass_error = true;
            }
        }
        if (kotlin_kfunction_getParameters == null && !kotlin_class_klass_error) {
            try {
                kotlin_kfunction_getParameters = java.lang.Class.forName("kotlin.reflect.KFunction").getMethod("getParameters", null);
            } catch (java.lang.Throwable unused3) {
                kotlin_class_klass_error = true;
            }
        }
        if (kotlin_kparameter_getName == null && !kotlin_class_klass_error) {
            try {
                kotlin_kparameter_getName = java.lang.Class.forName("kotlin.reflect.KParameter").getMethod("getName", null);
            } catch (java.lang.Throwable unused4) {
                kotlin_class_klass_error = true;
            }
        }
        if (kotlin_error) {
            return null;
        }
        try {
            java.util.Iterator it = ((java.lang.Iterable) kotlin_kclass_getConstructors.invoke(kotlin_kclass_constructor.newInstance(cls), null)).iterator();
            java.lang.Object obj = null;
            while (it.hasNext()) {
                java.lang.Object next = it.next();
                java.util.List list = (java.util.List) kotlin_kfunction_getParameters.invoke(next, null);
                if (obj == null || list.size() != 0) {
                    obj = next;
                }
                it.hasNext();
            }
            if (obj == null) {
                return null;
            }
            java.util.List list2 = (java.util.List) kotlin_kfunction_getParameters.invoke(obj, null);
            java.lang.String[] strArr = new java.lang.String[list2.size()];
            for (int i = 0; i < list2.size(); i++) {
                strArr[i] = (java.lang.String) kotlin_kparameter_getName.invoke(list2.get(i), null);
            }
            return strArr;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            kotlin_error = true;
            return null;
        }
    }

    private static boolean isKotlinIgnore(java.lang.Class cls, java.lang.String str) {
        java.lang.String[] strArr;
        if (kotlinIgnores == null && !kotlinIgnores_error) {
            try {
                java.util.HashMap map = new java.util.HashMap();
                map.put(java.lang.Class.forName("kotlin.ranges.CharRange"), new java.lang.String[]{"getEndInclusive", "isEmpty"});
                map.put(java.lang.Class.forName("kotlin.ranges.IntRange"), new java.lang.String[]{"getEndInclusive", "isEmpty"});
                map.put(java.lang.Class.forName("kotlin.ranges.LongRange"), new java.lang.String[]{"getEndInclusive", "isEmpty"});
                map.put(java.lang.Class.forName("kotlin.ranges.ClosedFloatRange"), new java.lang.String[]{"getEndInclusive", "isEmpty"});
                map.put(java.lang.Class.forName("kotlin.ranges.ClosedDoubleRange"), new java.lang.String[]{"getEndInclusive", "isEmpty"});
                kotlinIgnores = map;
            } catch (java.lang.Throwable unused) {
                kotlinIgnores_error = true;
            }
        }
        return (kotlinIgnores == null || (strArr = kotlinIgnores.get(cls)) == null || java.util.Arrays.binarySearch(strArr, str) < 0) ? false : true;
    }

    public static <A extends java.lang.annotation.Annotation> A getAnnotation(java.lang.Class<?> cls, java.lang.Class<A> cls2) {
        A a = (A) cls.getAnnotation(cls2);
        java.lang.reflect.Type mixInAnnotations = com.alibaba.fastjson.JSON.getMixInAnnotations(cls);
        java.lang.Class cls3 = mixInAnnotations instanceof java.lang.Class ? (java.lang.Class) mixInAnnotations : null;
        if (cls3 != null) {
            A a2 = (A) cls3.getAnnotation(cls2);
            java.lang.annotation.Annotation[] annotations = cls3.getAnnotations();
            if (a2 == null && annotations.length > 0) {
                for (java.lang.annotation.Annotation annotation : annotations) {
                    a2 = (A) annotation.annotationType().getAnnotation(cls2);
                    if (a2 != null) {
                        break;
                    }
                }
            }
            if (a2 != null) {
                return a2;
            }
        }
        java.lang.annotation.Annotation[] annotations2 = cls.getAnnotations();
        if (a == null && annotations2.length > 0) {
            for (java.lang.annotation.Annotation annotation2 : annotations2) {
                a = (A) annotation2.annotationType().getAnnotation(cls2);
                if (a != null) {
                    return a;
                }
            }
        }
        return a;
    }

    public static <A extends java.lang.annotation.Annotation> A getAnnotation(java.lang.reflect.Field field, java.lang.Class<A> cls) {
        A a;
        A a2 = (A) field.getAnnotation(cls);
        java.lang.reflect.Type mixInAnnotations = com.alibaba.fastjson.JSON.getMixInAnnotations(field.getDeclaringClass());
        java.lang.reflect.Field declaredField = null;
        java.lang.Class superclass = mixInAnnotations instanceof java.lang.Class ? (java.lang.Class) mixInAnnotations : null;
        if (superclass != null) {
            java.lang.String name = field.getName();
            while (superclass != null && superclass != java.lang.Object.class) {
                try {
                    declaredField = superclass.getDeclaredField(name);
                    break;
                } catch (java.lang.NoSuchFieldException unused) {
                    superclass = superclass.getSuperclass();
                }
            }
            if (declaredField != null && (a = (A) declaredField.getAnnotation(cls)) != null) {
                return a;
            }
        }
        return a2;
    }

    public static <A extends java.lang.annotation.Annotation> A getAnnotation(java.lang.reflect.Method method, java.lang.Class<A> cls) {
        A a;
        A a2 = (A) method.getAnnotation(cls);
        java.lang.reflect.Type mixInAnnotations = com.alibaba.fastjson.JSON.getMixInAnnotations(method.getDeclaringClass());
        java.lang.reflect.Method declaredMethod = null;
        java.lang.Class superclass = mixInAnnotations instanceof java.lang.Class ? (java.lang.Class) mixInAnnotations : null;
        if (superclass != null) {
            java.lang.String name = method.getName();
            java.lang.Class<?>[] parameterTypes = method.getParameterTypes();
            while (superclass != null && superclass != java.lang.Object.class) {
                try {
                    declaredMethod = superclass.getDeclaredMethod(name, parameterTypes);
                    break;
                } catch (java.lang.NoSuchMethodException unused) {
                    superclass = superclass.getSuperclass();
                }
            }
            if (declaredMethod != null && (a = (A) declaredMethod.getAnnotation(cls)) != null) {
                return a;
            }
        }
        return a2;
    }

    public static java.lang.annotation.Annotation[][] getParameterAnnotations(java.lang.reflect.Method method) {
        java.lang.annotation.Annotation[][] parameterAnnotations;
        java.lang.annotation.Annotation[][] parameterAnnotations2 = method.getParameterAnnotations();
        java.lang.reflect.Type mixInAnnotations = com.alibaba.fastjson.JSON.getMixInAnnotations(method.getDeclaringClass());
        java.lang.reflect.Method declaredMethod = null;
        java.lang.Class superclass = mixInAnnotations instanceof java.lang.Class ? (java.lang.Class) mixInAnnotations : null;
        if (superclass != null) {
            java.lang.String name = method.getName();
            java.lang.Class<?>[] parameterTypes = method.getParameterTypes();
            while (superclass != null && superclass != java.lang.Object.class) {
                try {
                    declaredMethod = superclass.getDeclaredMethod(name, parameterTypes);
                    break;
                } catch (java.lang.NoSuchMethodException unused) {
                    superclass = superclass.getSuperclass();
                }
            }
            if (declaredMethod != null && (parameterAnnotations = declaredMethod.getParameterAnnotations()) != null) {
                return parameterAnnotations;
            }
        }
        return parameterAnnotations2;
    }

    public static java.lang.annotation.Annotation[][] getParameterAnnotations(java.lang.reflect.Constructor constructor) {
        java.lang.annotation.Annotation[][] parameterAnnotations;
        java.lang.reflect.Constructor declaredConstructor;
        java.lang.annotation.Annotation[][] parameterAnnotations2 = constructor.getParameterAnnotations();
        java.lang.reflect.Type mixInAnnotations = com.alibaba.fastjson.JSON.getMixInAnnotations(constructor.getDeclaringClass());
        java.lang.reflect.Constructor constructor2 = null;
        java.lang.Class cls = mixInAnnotations instanceof java.lang.Class ? (java.lang.Class) mixInAnnotations : null;
        if (cls != null) {
            java.lang.Class<?>[] parameterTypes = constructor.getParameterTypes();
            java.util.ArrayList arrayList = new java.util.ArrayList(2);
            for (java.lang.Class<?> enclosingClass = cls.getEnclosingClass(); enclosingClass != null; enclosingClass = enclosingClass.getEnclosingClass()) {
                arrayList.add(enclosingClass);
            }
            int size = arrayList.size();
            for (java.lang.Class superclass = cls; superclass != null && superclass != java.lang.Object.class; superclass = superclass.getSuperclass()) {
                try {
                    if (size != 0) {
                        java.lang.Class<?>[] clsArr = new java.lang.Class[parameterTypes.length + size];
                        java.lang.System.arraycopy(parameterTypes, 0, clsArr, size, parameterTypes.length);
                        for (int i = size; i > 0; i--) {
                            int i2 = i - 1;
                            clsArr[i2] = (java.lang.Class) arrayList.get(i2);
                        }
                        declaredConstructor = cls.getDeclaredConstructor(clsArr);
                    } else {
                        declaredConstructor = cls.getDeclaredConstructor(parameterTypes);
                    }
                    constructor2 = declaredConstructor;
                    break;
                } catch (java.lang.NoSuchMethodException unused) {
                    size--;
                }
            }
            if (constructor2 != null && (parameterAnnotations = constructor2.getParameterAnnotations()) != null) {
                return parameterAnnotations;
            }
        }
        return parameterAnnotations2;
    }

    public static boolean isJacksonCreator(java.lang.reflect.Method method) {
        if (method == null) {
            return false;
        }
        if (class_JacksonCreator == null && !class_JacksonCreator_error) {
            try {
                class_JacksonCreator = java.lang.Class.forName("com.fasterxml.jackson.annotation.JsonCreator");
            } catch (java.lang.Throwable unused) {
                class_JacksonCreator_error = true;
            }
        }
        java.lang.Class<? extends java.lang.annotation.Annotation> cls = class_JacksonCreator;
        return cls != null && method.isAnnotationPresent(cls);
    }

    public static java.lang.Object optionalEmpty(java.lang.reflect.Type type) {
        java.lang.Class<?> cls;
        if (OPTIONAL_ERROR || (cls = getClass(type)) == null) {
            return null;
        }
        java.lang.String name = cls.getName();
        if (!"java.util.Optional".equals(name)) {
            return null;
        }
        if (OPTIONAL_EMPTY == null) {
            try {
                OPTIONAL_EMPTY = java.lang.Class.forName(name).getMethod("empty", null).invoke(null, null);
            } catch (java.lang.Throwable unused) {
                OPTIONAL_ERROR = true;
            }
        }
        return OPTIONAL_EMPTY;
    }

    public static class MethodInheritanceComparator implements java.util.Comparator<java.lang.reflect.Method> {
        @Override // java.util.Comparator
        public int compare(java.lang.reflect.Method method, java.lang.reflect.Method method2) {
            int iCompareTo = method.getName().compareTo(method2.getName());
            if (iCompareTo != 0) {
                return iCompareTo;
            }
            java.lang.Class<?> returnType = method.getReturnType();
            java.lang.Class<?> returnType2 = method2.getReturnType();
            if (returnType.equals(returnType2)) {
                return 0;
            }
            if (returnType.isAssignableFrom(returnType2)) {
                return -1;
            }
            return returnType2.isAssignableFrom(returnType) ? 1 : 0;
        }
    }
}
