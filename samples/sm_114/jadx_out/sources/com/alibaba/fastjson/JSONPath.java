package com.alibaba.fastjson;

/* JADX INFO: loaded from: classes.dex */
public class JSONPath implements com.alibaba.fastjson.JSONAware {
    static final long LENGTH = -1580386065683472715L;
    static final long SIZE = 5614464919154503228L;
    private static java.util.concurrent.ConcurrentMap<java.lang.String, com.alibaba.fastjson.JSONPath> pathCache = new java.util.concurrent.ConcurrentHashMap(128, 0.75f, 1);
    private boolean hasRefSegment;
    private boolean ignoreNullValue;
    private com.alibaba.fastjson.parser.ParserConfig parserConfig;
    private final java.lang.String path;
    private com.alibaba.fastjson.JSONPath.Segment[] segments;
    private com.alibaba.fastjson.serializer.SerializeConfig serializeConfig;

    interface Filter {
        boolean apply(com.alibaba.fastjson.JSONPath jSONPath, java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3);
    }

    enum Operator {
        EQ,
        NE,
        GT,
        GE,
        LT,
        LE,
        LIKE,
        NOT_LIKE,
        RLIKE,
        NOT_RLIKE,
        IN,
        NOT_IN,
        BETWEEN,
        NOT_BETWEEN,
        And,
        Or,
        REG_MATCH
    }

    interface Segment {
        java.lang.Object eval(com.alibaba.fastjson.JSONPath jSONPath, java.lang.Object obj, java.lang.Object obj2);

        void extract(com.alibaba.fastjson.JSONPath jSONPath, com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, com.alibaba.fastjson.JSONPath.Context context);
    }

    public JSONPath(java.lang.String str) {
        this(str, com.alibaba.fastjson.serializer.SerializeConfig.getGlobalInstance(), com.alibaba.fastjson.parser.ParserConfig.getGlobalInstance(), true);
    }

    public JSONPath(java.lang.String str, boolean z) {
        this(str, com.alibaba.fastjson.serializer.SerializeConfig.getGlobalInstance(), com.alibaba.fastjson.parser.ParserConfig.getGlobalInstance(), z);
    }

    public JSONPath(java.lang.String str, com.alibaba.fastjson.serializer.SerializeConfig serializeConfig, com.alibaba.fastjson.parser.ParserConfig parserConfig, boolean z) {
        if (str == null || str.length() == 0) {
            throw new com.alibaba.fastjson.JSONPathException("json-path can not be null or empty");
        }
        this.path = str;
        this.serializeConfig = serializeConfig;
        this.parserConfig = parserConfig;
        this.ignoreNullValue = z;
    }

    protected void init() {
        if (this.segments != null) {
            return;
        }
        if ("*".equals(this.path)) {
            this.segments = new com.alibaba.fastjson.JSONPath.Segment[]{com.alibaba.fastjson.JSONPath.WildCardSegment.instance};
            return;
        }
        com.alibaba.fastjson.JSONPath.JSONPathParser jSONPathParser = new com.alibaba.fastjson.JSONPath.JSONPathParser(this.path);
        this.segments = jSONPathParser.explain();
        this.hasRefSegment = jSONPathParser.hasRefSegment;
    }

    public boolean isRef() {
        try {
            init();
            int i = 0;
            while (true) {
                com.alibaba.fastjson.JSONPath.Segment[] segmentArr = this.segments;
                if (i >= segmentArr.length) {
                    return true;
                }
                java.lang.Class<?> cls = segmentArr[i].getClass();
                if (cls != com.alibaba.fastjson.JSONPath.ArrayAccessSegment.class && cls != com.alibaba.fastjson.JSONPath.PropertySegment.class) {
                    return false;
                }
                i++;
            }
        } catch (com.alibaba.fastjson.JSONPathException unused) {
            return false;
        }
    }

    public java.lang.Object eval(java.lang.Object obj) {
        if (obj == null) {
            return null;
        }
        init();
        int i = 0;
        java.lang.Object objEval = obj;
        while (true) {
            com.alibaba.fastjson.JSONPath.Segment[] segmentArr = this.segments;
            if (i >= segmentArr.length) {
                return objEval;
            }
            objEval = segmentArr[i].eval(this, obj, objEval);
            i++;
        }
    }

    public <T> T eval(java.lang.Object obj, java.lang.reflect.Type type, com.alibaba.fastjson.parser.ParserConfig parserConfig) {
        return (T) com.alibaba.fastjson.util.TypeUtils.cast(eval(obj), type, parserConfig);
    }

    public <T> T eval(java.lang.Object obj, java.lang.reflect.Type type) {
        return (T) eval(obj, type, com.alibaba.fastjson.parser.ParserConfig.getGlobalInstance());
    }

    /* JADX WARN: Code duplicated, block: B:64:0x009e  */
    public java.lang.Object extract(com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser) {
        boolean z;
        if (defaultJSONParser == null) {
            return null;
        }
        init();
        if (this.hasRefSegment) {
            return eval(defaultJSONParser.parse());
        }
        com.alibaba.fastjson.JSONPath.Segment[] segmentArr = this.segments;
        if (segmentArr.length == 0) {
            return defaultJSONParser.parse();
        }
        com.alibaba.fastjson.JSONPath.Segment segment = segmentArr[segmentArr.length - 1];
        if ((segment instanceof com.alibaba.fastjson.JSONPath.TypeSegment) || (segment instanceof com.alibaba.fastjson.JSONPath.FloorSegment) || (segment instanceof com.alibaba.fastjson.JSONPath.MultiIndexSegment)) {
            return eval(defaultJSONParser.parse());
        }
        com.alibaba.fastjson.JSONPath.Context context = null;
        int i = 0;
        while (true) {
            com.alibaba.fastjson.JSONPath.Segment[] segmentArr2 = this.segments;
            if (i < segmentArr2.length) {
                com.alibaba.fastjson.JSONPath.Segment segment2 = segmentArr2[i];
                boolean z2 = i == segmentArr2.length - 1;
                if (context != null && context.object != null) {
                    context.object = segment2.eval(this, null, context.object);
                } else {
                    if (z2) {
                        z = true;
                    } else {
                        com.alibaba.fastjson.JSONPath.Segment segment3 = this.segments[i + 1];
                        if (((segment2 instanceof com.alibaba.fastjson.JSONPath.PropertySegment) && ((com.alibaba.fastjson.JSONPath.PropertySegment) segment2).deep && ((segment3 instanceof com.alibaba.fastjson.JSONPath.ArrayAccessSegment) || (segment3 instanceof com.alibaba.fastjson.JSONPath.MultiIndexSegment) || (segment3 instanceof com.alibaba.fastjson.JSONPath.MultiPropertySegment) || (segment3 instanceof com.alibaba.fastjson.JSONPath.SizeSegment) || (segment3 instanceof com.alibaba.fastjson.JSONPath.PropertySegment) || (segment3 instanceof com.alibaba.fastjson.JSONPath.FilterSegment))) || (((segment3 instanceof com.alibaba.fastjson.JSONPath.ArrayAccessSegment) && ((com.alibaba.fastjson.JSONPath.ArrayAccessSegment) segment3).index < 0) || (segment3 instanceof com.alibaba.fastjson.JSONPath.FilterSegment) || (segment2 instanceof com.alibaba.fastjson.JSONPath.WildCardSegment) || (segment2 instanceof com.alibaba.fastjson.JSONPath.MultiIndexSegment))) {
                            z = true;
                        } else {
                            z = false;
                        }
                    }
                    com.alibaba.fastjson.JSONPath.Context context2 = new com.alibaba.fastjson.JSONPath.Context(context, z);
                    segment2.extract(this, defaultJSONParser, context2);
                    context = context2;
                }
                i++;
            } else {
                return context.object;
            }
        }
    }

    private static class Context {
        final boolean eval;
        java.lang.Object object;
        final com.alibaba.fastjson.JSONPath.Context parent;

        public Context(com.alibaba.fastjson.JSONPath.Context context, boolean z) {
            this.parent = context;
            this.eval = z;
        }
    }

    public boolean contains(java.lang.Object obj) {
        if (obj == null) {
            return false;
        }
        init();
        java.lang.Object obj2 = obj;
        int i = 0;
        while (true) {
            com.alibaba.fastjson.JSONPath.Segment[] segmentArr = this.segments;
            if (i >= segmentArr.length) {
                return true;
            }
            java.lang.Object objEval = segmentArr[i].eval(this, obj, obj2);
            if (objEval == null) {
                return false;
            }
            if (objEval == java.util.Collections.EMPTY_LIST && (obj2 instanceof java.util.List)) {
                return ((java.util.List) obj2).contains(objEval);
            }
            i++;
            obj2 = objEval;
        }
    }

    public boolean containsValue(java.lang.Object obj, java.lang.Object obj2) {
        java.lang.Object objEval = eval(obj);
        if (objEval == obj2) {
            return true;
        }
        if (objEval == null) {
            return false;
        }
        if (objEval instanceof java.lang.Iterable) {
            java.util.Iterator it = ((java.lang.Iterable) objEval).iterator();
            while (it.hasNext()) {
                if (eq(it.next(), obj2)) {
                    return true;
                }
            }
            return false;
        }
        return eq(objEval, obj2);
    }

    public int size(java.lang.Object obj) {
        if (obj == null) {
            return -1;
        }
        init();
        int i = 0;
        java.lang.Object objEval = obj;
        while (true) {
            com.alibaba.fastjson.JSONPath.Segment[] segmentArr = this.segments;
            if (i < segmentArr.length) {
                objEval = segmentArr[i].eval(this, obj, objEval);
                i++;
            } else {
                return evalSize(objEval);
            }
        }
    }

    public java.util.Set<?> keySet(java.lang.Object obj) {
        if (obj == null) {
            return null;
        }
        init();
        int i = 0;
        java.lang.Object objEval = obj;
        while (true) {
            com.alibaba.fastjson.JSONPath.Segment[] segmentArr = this.segments;
            if (i < segmentArr.length) {
                objEval = segmentArr[i].eval(this, obj, objEval);
                i++;
            } else {
                return evalKeySet(objEval);
            }
        }
    }

    public void patchAdd(java.lang.Object obj, java.lang.Object obj2, boolean z) {
        if (obj == null) {
            return;
        }
        init();
        java.lang.Object obj3 = null;
        int i = 0;
        java.lang.Object obj4 = obj;
        while (true) {
            com.alibaba.fastjson.JSONPath.Segment[] segmentArr = this.segments;
            if (i >= segmentArr.length) {
                break;
            }
            com.alibaba.fastjson.JSONPath.Segment segment = segmentArr[i];
            java.lang.Object objEval = segment.eval(this, obj, obj4);
            if (objEval == null && i != this.segments.length - 1 && (segment instanceof com.alibaba.fastjson.JSONPath.PropertySegment)) {
                objEval = new com.alibaba.fastjson.JSONObject();
                ((com.alibaba.fastjson.JSONPath.PropertySegment) segment).setValue(this, obj4, objEval);
            }
            i++;
            obj3 = obj4;
            obj4 = objEval;
        }
        if (!z && (obj4 instanceof java.util.Collection)) {
            ((java.util.Collection) obj4).add(obj2);
            return;
        }
        if (obj4 != null && !z) {
            java.lang.Class<?> cls = obj4.getClass();
            if (cls.isArray()) {
                int length = java.lang.reflect.Array.getLength(obj4);
                java.lang.Object objNewInstance = java.lang.reflect.Array.newInstance(cls.getComponentType(), length + 1);
                java.lang.System.arraycopy(obj4, 0, objNewInstance, 0, length);
                java.lang.reflect.Array.set(objNewInstance, length, obj2);
                obj2 = objNewInstance;
            } else if (!java.util.Map.class.isAssignableFrom(cls)) {
                throw new com.alibaba.fastjson.JSONException("unsupported array put operation. " + cls);
            }
        }
        com.alibaba.fastjson.JSONPath.Segment[] segmentArr2 = this.segments;
        com.alibaba.fastjson.JSONPath.Segment segment2 = segmentArr2[segmentArr2.length - 1];
        if (segment2 instanceof com.alibaba.fastjson.JSONPath.PropertySegment) {
            ((com.alibaba.fastjson.JSONPath.PropertySegment) segment2).setValue(this, obj3, obj2);
        } else {
            if (segment2 instanceof com.alibaba.fastjson.JSONPath.ArrayAccessSegment) {
                ((com.alibaba.fastjson.JSONPath.ArrayAccessSegment) segment2).setValue(this, obj3, obj2);
                return;
            }
            throw new java.lang.UnsupportedOperationException();
        }
    }

    public void arrayAdd(java.lang.Object obj, java.lang.Object... objArr) {
        if (objArr == null || objArr.length == 0 || obj == null) {
            return;
        }
        init();
        int i = 0;
        java.lang.Object obj2 = null;
        java.lang.Object objEval = obj;
        int i2 = 0;
        while (true) {
            com.alibaba.fastjson.JSONPath.Segment[] segmentArr = this.segments;
            if (i2 >= segmentArr.length) {
                break;
            }
            if (i2 == segmentArr.length - 1) {
                obj2 = objEval;
            }
            objEval = segmentArr[i2].eval(this, obj, objEval);
            i2++;
        }
        if (objEval == null) {
            throw new com.alibaba.fastjson.JSONPathException("value not found in path " + this.path);
        }
        if (objEval instanceof java.util.Collection) {
            java.util.Collection collection = (java.util.Collection) objEval;
            int length = objArr.length;
            while (i < length) {
                collection.add(objArr[i]);
                i++;
            }
            return;
        }
        java.lang.Class<?> cls = objEval.getClass();
        if (cls.isArray()) {
            int length2 = java.lang.reflect.Array.getLength(objEval);
            java.lang.Object objNewInstance = java.lang.reflect.Array.newInstance(cls.getComponentType(), objArr.length + length2);
            java.lang.System.arraycopy(objEval, 0, objNewInstance, 0, length2);
            while (i < objArr.length) {
                java.lang.reflect.Array.set(objNewInstance, length2 + i, objArr[i]);
                i++;
            }
            com.alibaba.fastjson.JSONPath.Segment[] segmentArr2 = this.segments;
            com.alibaba.fastjson.JSONPath.Segment segment = segmentArr2[segmentArr2.length - 1];
            if (segment instanceof com.alibaba.fastjson.JSONPath.PropertySegment) {
                ((com.alibaba.fastjson.JSONPath.PropertySegment) segment).setValue(this, obj2, objNewInstance);
                return;
            } else {
                if (segment instanceof com.alibaba.fastjson.JSONPath.ArrayAccessSegment) {
                    ((com.alibaba.fastjson.JSONPath.ArrayAccessSegment) segment).setValue(this, obj2, objNewInstance);
                    return;
                }
                throw new java.lang.UnsupportedOperationException();
            }
        }
        throw new com.alibaba.fastjson.JSONException("unsupported array put operation. " + cls);
    }

    public boolean remove(java.lang.Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        init();
        com.alibaba.fastjson.JSONPath.Segment[] segmentArr = this.segments;
        com.alibaba.fastjson.JSONPath.Segment segment = segmentArr[segmentArr.length - 1];
        java.lang.Object objEval = obj;
        int i = 0;
        while (true) {
            com.alibaba.fastjson.JSONPath.Segment[] segmentArr2 = this.segments;
            if (i < segmentArr2.length) {
                if (i == segmentArr2.length - 1) {
                    break;
                }
                com.alibaba.fastjson.JSONPath.Segment segment2 = segmentArr2[i];
                if (i == segmentArr2.length - 2 && (segment instanceof com.alibaba.fastjson.JSONPath.FilterSegment) && (segment2 instanceof com.alibaba.fastjson.JSONPath.PropertySegment)) {
                    com.alibaba.fastjson.JSONPath.FilterSegment filterSegment = (com.alibaba.fastjson.JSONPath.FilterSegment) segment;
                    if (objEval instanceof java.util.List) {
                        com.alibaba.fastjson.JSONPath.PropertySegment propertySegment = (com.alibaba.fastjson.JSONPath.PropertySegment) segment2;
                        java.util.Iterator it = ((java.util.List) objEval).iterator();
                        while (it.hasNext()) {
                            java.lang.Object objEval2 = propertySegment.eval(this, obj, it.next());
                            if (objEval2 instanceof java.lang.Iterable) {
                                filterSegment.remove(this, obj, objEval2);
                            } else if ((objEval2 instanceof java.util.Map) && filterSegment.filter.apply(this, obj, objEval, objEval2)) {
                                it.remove();
                            }
                        }
                        return true;
                    }
                    if (objEval instanceof java.util.Map) {
                        com.alibaba.fastjson.JSONPath.PropertySegment propertySegment2 = (com.alibaba.fastjson.JSONPath.PropertySegment) segment2;
                        java.lang.Object objEval3 = propertySegment2.eval(this, obj, objEval);
                        if (objEval3 == null) {
                            return false;
                        }
                        if ((objEval3 instanceof java.util.Map) && filterSegment.filter.apply(this, obj, objEval, objEval3)) {
                            propertySegment2.remove(this, objEval);
                            return true;
                        }
                    }
                }
                objEval = segment2.eval(this, obj, objEval);
                if (objEval != null) {
                    i++;
                }
            }
            objEval = null;
            break;
        }
        if (objEval == null) {
            return false;
        }
        if (segment instanceof com.alibaba.fastjson.JSONPath.PropertySegment) {
            com.alibaba.fastjson.JSONPath.PropertySegment propertySegment3 = (com.alibaba.fastjson.JSONPath.PropertySegment) segment;
            if (objEval instanceof java.util.Collection) {
                com.alibaba.fastjson.JSONPath.Segment[] segmentArr3 = this.segments;
                if (segmentArr3.length > 1) {
                    com.alibaba.fastjson.JSONPath.Segment segment3 = segmentArr3[segmentArr3.length - 2];
                    if ((segment3 instanceof com.alibaba.fastjson.JSONPath.RangeSegment) || (segment3 instanceof com.alibaba.fastjson.JSONPath.MultiIndexSegment)) {
                        java.util.Iterator it2 = ((java.util.Collection) objEval).iterator();
                        while (it2.hasNext()) {
                            if (propertySegment3.remove(this, it2.next())) {
                                z = true;
                            }
                        }
                        return z;
                    }
                }
            }
            return propertySegment3.remove(this, objEval);
        }
        if (segment instanceof com.alibaba.fastjson.JSONPath.ArrayAccessSegment) {
            return ((com.alibaba.fastjson.JSONPath.ArrayAccessSegment) segment).remove(this, objEval);
        }
        if (segment instanceof com.alibaba.fastjson.JSONPath.FilterSegment) {
            return ((com.alibaba.fastjson.JSONPath.FilterSegment) segment).remove(this, obj, objEval);
        }
        throw new java.lang.UnsupportedOperationException();
    }

    public boolean set(java.lang.Object obj, java.lang.Object obj2) {
        return set(obj, obj2, true);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x004b  */
    public boolean set(java.lang.Object obj, java.lang.Object obj2, boolean z) {
        java.lang.Class<?> cls;
        com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer javaBeanDeserializer;
        if (obj == null) {
            return false;
        }
        init();
        java.lang.Object obj3 = obj;
        java.lang.Object obj4 = null;
        int i = 0;
        while (true) {
            com.alibaba.fastjson.JSONPath.Segment[] segmentArr = this.segments;
            if (i >= segmentArr.length) {
                obj3 = obj4;
                break;
            }
            com.alibaba.fastjson.JSONPath.Segment segment = segmentArr[i];
            java.lang.Object objEval = segment.eval(this, obj, obj3);
            if (objEval == null) {
                com.alibaba.fastjson.JSONPath.Segment[] segmentArr2 = this.segments;
                com.alibaba.fastjson.JSONPath.Segment segment2 = i < segmentArr2.length - 1 ? segmentArr2[i + 1] : null;
                if (segment2 instanceof com.alibaba.fastjson.JSONPath.PropertySegment) {
                    if (segment instanceof com.alibaba.fastjson.JSONPath.PropertySegment) {
                        java.lang.String str = ((com.alibaba.fastjson.JSONPath.PropertySegment) segment).propertyName;
                        com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer javaBeanDeserializer2 = getJavaBeanDeserializer(obj3.getClass());
                        if (javaBeanDeserializer2 != null) {
                            cls = javaBeanDeserializer2.getFieldDeserializer(str).fieldInfo.fieldClass;
                            javaBeanDeserializer = getJavaBeanDeserializer(cls);
                        } else {
                            cls = null;
                            javaBeanDeserializer = null;
                        }
                    } else {
                        cls = null;
                        javaBeanDeserializer = null;
                    }
                    if (javaBeanDeserializer != null) {
                        if (javaBeanDeserializer.beanInfo.defaultConstructor == null) {
                            return false;
                        }
                        objEval = javaBeanDeserializer.createInstance((com.alibaba.fastjson.parser.DefaultJSONParser) null, cls);
                    } else {
                        objEval = new com.alibaba.fastjson.JSONObject();
                    }
                } else {
                    objEval = segment2 instanceof com.alibaba.fastjson.JSONPath.ArrayAccessSegment ? new com.alibaba.fastjson.JSONArray() : null;
                }
                if (objEval != null) {
                    if (segment instanceof com.alibaba.fastjson.JSONPath.PropertySegment) {
                        ((com.alibaba.fastjson.JSONPath.PropertySegment) segment).setValue(this, obj3, objEval);
                    } else {
                        if (!(segment instanceof com.alibaba.fastjson.JSONPath.ArrayAccessSegment)) {
                            break;
                        }
                        ((com.alibaba.fastjson.JSONPath.ArrayAccessSegment) segment).setValue(this, obj3, objEval);
                    }
                } else {
                    break;
                }
            }
            i++;
            obj4 = obj3;
            obj3 = objEval;
        }
        if (obj3 == null) {
            return false;
        }
        com.alibaba.fastjson.JSONPath.Segment[] segmentArr3 = this.segments;
        com.alibaba.fastjson.JSONPath.Segment segment3 = segmentArr3[segmentArr3.length - 1];
        if (segment3 instanceof com.alibaba.fastjson.JSONPath.PropertySegment) {
            ((com.alibaba.fastjson.JSONPath.PropertySegment) segment3).setValue(this, obj3, obj2);
            return true;
        }
        if (segment3 instanceof com.alibaba.fastjson.JSONPath.ArrayAccessSegment) {
            return ((com.alibaba.fastjson.JSONPath.ArrayAccessSegment) segment3).setValue(this, obj3, obj2);
        }
        throw new java.lang.UnsupportedOperationException();
    }

    public static java.lang.Object eval(java.lang.Object obj, java.lang.String str) {
        return compile(str).eval(obj);
    }

    public static java.lang.Object eval(java.lang.Object obj, java.lang.String str, boolean z) {
        return compile(str, z).eval(obj);
    }

    public static int size(java.lang.Object obj, java.lang.String str) {
        com.alibaba.fastjson.JSONPath jSONPathCompile = compile(str);
        return jSONPathCompile.evalSize(jSONPathCompile.eval(obj));
    }

    public static java.util.Set<?> keySet(java.lang.Object obj, java.lang.String str) {
        com.alibaba.fastjson.JSONPath jSONPathCompile = compile(str);
        return jSONPathCompile.evalKeySet(jSONPathCompile.eval(obj));
    }

    public static boolean contains(java.lang.Object obj, java.lang.String str) {
        if (obj == null) {
            return false;
        }
        return compile(str).contains(obj);
    }

    public static boolean containsValue(java.lang.Object obj, java.lang.String str, java.lang.Object obj2) {
        return compile(str).containsValue(obj, obj2);
    }

    public static void arrayAdd(java.lang.Object obj, java.lang.String str, java.lang.Object... objArr) {
        compile(str).arrayAdd(obj, objArr);
    }

    public static boolean set(java.lang.Object obj, java.lang.String str, java.lang.Object obj2) {
        return compile(str).set(obj, obj2);
    }

    public static boolean remove(java.lang.Object obj, java.lang.String str) {
        return compile(str).remove(obj);
    }

    public static com.alibaba.fastjson.JSONPath compile(java.lang.String str) {
        if (str == null) {
            throw new com.alibaba.fastjson.JSONPathException("jsonpath can not be null");
        }
        com.alibaba.fastjson.JSONPath jSONPath = pathCache.get(str);
        if (jSONPath == null) {
            jSONPath = new com.alibaba.fastjson.JSONPath(str);
            if (pathCache.size() < 1024) {
                pathCache.putIfAbsent(str, jSONPath);
                return pathCache.get(str);
            }
        }
        return jSONPath;
    }

    public static com.alibaba.fastjson.JSONPath compile(java.lang.String str, boolean z) {
        if (str == null) {
            throw new com.alibaba.fastjson.JSONPathException("jsonpath can not be null");
        }
        com.alibaba.fastjson.JSONPath jSONPath = pathCache.get(str);
        if (jSONPath == null) {
            jSONPath = new com.alibaba.fastjson.JSONPath(str, z);
            if (pathCache.size() < 1024) {
                pathCache.putIfAbsent(str, jSONPath);
                return pathCache.get(str);
            }
        }
        return jSONPath;
    }

    public static java.lang.Object read(java.lang.String str, java.lang.String str2) {
        return compile(str2).eval(com.alibaba.fastjson.JSON.parse(str));
    }

    public static <T> T read(java.lang.String str, java.lang.String str2, java.lang.reflect.Type type, com.alibaba.fastjson.parser.ParserConfig parserConfig) {
        return (T) compile(str2).eval(com.alibaba.fastjson.JSON.parse(str), type, parserConfig);
    }

    public static <T> T read(java.lang.String str, java.lang.String str2, java.lang.reflect.Type type) {
        return (T) read(str, str2, type, null);
    }

    public static java.lang.Object extract(java.lang.String str, java.lang.String str2, com.alibaba.fastjson.parser.ParserConfig parserConfig, int i, com.alibaba.fastjson.parser.Feature... featureArr) {
        com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser = new com.alibaba.fastjson.parser.DefaultJSONParser(str, parserConfig, i | com.alibaba.fastjson.parser.Feature.OrderedField.mask);
        java.lang.Object objExtract = compile(str2).extract(defaultJSONParser);
        defaultJSONParser.lexer.close();
        return objExtract;
    }

    public static java.lang.Object extract(java.lang.String str, java.lang.String str2) {
        return extract(str, str2, com.alibaba.fastjson.parser.ParserConfig.global, com.alibaba.fastjson.JSON.DEFAULT_PARSER_FEATURE, new com.alibaba.fastjson.parser.Feature[0]);
    }

    public static java.util.Map<java.lang.String, java.lang.Object> paths(java.lang.Object obj) {
        return paths(obj, com.alibaba.fastjson.serializer.SerializeConfig.globalInstance);
    }

    public static java.util.Map<java.lang.String, java.lang.Object> paths(java.lang.Object obj, com.alibaba.fastjson.serializer.SerializeConfig serializeConfig) {
        java.util.IdentityHashMap identityHashMap = new java.util.IdentityHashMap();
        java.util.HashMap map = new java.util.HashMap();
        paths(identityHashMap, map, "/", obj, serializeConfig);
        return map;
    }

    private static void paths(java.util.Map<java.lang.Object, java.lang.String> map, java.util.Map<java.lang.String, java.lang.Object> map2, java.lang.String str, java.lang.Object obj, com.alibaba.fastjson.serializer.SerializeConfig serializeConfig) {
        java.lang.StringBuilder sb;
        java.lang.StringBuilder sb2;
        java.lang.StringBuilder sb3;
        java.lang.StringBuilder sb4;
        java.lang.Class<?> cls;
        if (obj == null) {
            return;
        }
        if (map.put(obj, str) == null || (cls = obj.getClass()) == java.lang.String.class || cls == java.lang.Boolean.class || cls == java.lang.Character.class || cls == java.util.UUID.class || cls.isEnum() || (obj instanceof java.lang.Number) || (obj instanceof java.util.Date)) {
            map2.put(str, obj);
            if (obj instanceof java.util.Map) {
                for (java.util.Map.Entry entry : ((java.util.Map) obj).entrySet()) {
                    java.lang.Object key = entry.getKey();
                    if (key instanceof java.lang.String) {
                        if (str.equals("/")) {
                            sb4 = new java.lang.StringBuilder("/");
                        } else {
                            sb4 = new java.lang.StringBuilder();
                            sb4.append(str);
                            sb4.append("/");
                        }
                        sb4.append(key);
                        paths(map, map2, sb4.toString(), entry.getValue(), serializeConfig);
                    }
                }
                return;
            }
            int i = 0;
            if (obj instanceof java.util.Collection) {
                for (java.lang.Object obj2 : (java.util.Collection) obj) {
                    if (str.equals("/")) {
                        sb3 = new java.lang.StringBuilder("/");
                    } else {
                        sb3 = new java.lang.StringBuilder();
                        sb3.append(str);
                        sb3.append("/");
                    }
                    sb3.append(i);
                    paths(map, map2, sb3.toString(), obj2, serializeConfig);
                    i++;
                }
                return;
            }
            java.lang.Class<?> cls2 = obj.getClass();
            if (cls2.isArray()) {
                int length = java.lang.reflect.Array.getLength(obj);
                while (i < length) {
                    java.lang.Object obj3 = java.lang.reflect.Array.get(obj, i);
                    if (str.equals("/")) {
                        sb2 = new java.lang.StringBuilder("/");
                    } else {
                        sb2 = new java.lang.StringBuilder();
                        sb2.append(str);
                        sb2.append("/");
                    }
                    sb2.append(i);
                    paths(map, map2, sb2.toString(), obj3, serializeConfig);
                    i++;
                }
                return;
            }
            if (com.alibaba.fastjson.parser.ParserConfig.isPrimitive2(cls2) || cls2.isEnum()) {
                return;
            }
            com.alibaba.fastjson.serializer.ObjectSerializer objectWriter = serializeConfig.getObjectWriter(cls2);
            if (objectWriter instanceof com.alibaba.fastjson.serializer.JavaBeanSerializer) {
                try {
                    for (java.util.Map.Entry<java.lang.String, java.lang.Object> entry2 : ((com.alibaba.fastjson.serializer.JavaBeanSerializer) objectWriter).getFieldValuesMap(obj).entrySet()) {
                        java.lang.String key2 = entry2.getKey();
                        if (key2 instanceof java.lang.String) {
                            if (str.equals("/")) {
                                sb = new java.lang.StringBuilder();
                                sb.append("/");
                            } else {
                                sb = new java.lang.StringBuilder();
                                sb.append(str);
                                sb.append("/");
                            }
                            sb.append(key2);
                            paths(map, map2, sb.toString(), entry2.getValue(), serializeConfig);
                        }
                    }
                } catch (java.lang.Exception e) {
                    throw new com.alibaba.fastjson.JSONException("toJSON error", e);
                }
            }
        }
    }

    public java.lang.String getPath() {
        return this.path;
    }

    static class JSONPathParser {
        private char ch;
        private boolean hasRefSegment;
        private int level;
        private final java.lang.String path;
        private int pos;
        private static final java.lang.String strArrayRegex = "'\\s*,\\s*'";
        private static final java.util.regex.Pattern strArrayPatternx = java.util.regex.Pattern.compile(strArrayRegex);

        static boolean isDigitFirst(char c) {
            if (c == '-' || c == '+') {
                return true;
            }
            return c >= '0' && c <= '9';
        }

        public JSONPathParser(java.lang.String str) {
            this.path = str;
            next();
        }

        void next() {
            java.lang.String str = this.path;
            int i = this.pos;
            this.pos = i + 1;
            this.ch = str.charAt(i);
        }

        char getNextChar() {
            return this.path.charAt(this.pos);
        }

        boolean isEOF() {
            return this.pos >= this.path.length();
        }

        com.alibaba.fastjson.JSONPath.Segment readSegement() {
            boolean z;
            if (this.level == 0 && this.path.length() == 1) {
                if (isDigitFirst(this.ch)) {
                    return new com.alibaba.fastjson.JSONPath.ArrayAccessSegment(this.ch - '0');
                }
                char c = this.ch;
                if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                    return new com.alibaba.fastjson.JSONPath.PropertySegment(java.lang.Character.toString(this.ch), false);
                }
            }
            while (!isEOF()) {
                skipWhitespace();
                char c2 = this.ch;
                if (c2 != '$') {
                    if (c2 != '.' && c2 != '/') {
                        if (c2 == '[') {
                            return parseArrayAccess(true);
                        }
                        if (this.level == 0) {
                            return new com.alibaba.fastjson.JSONPath.PropertySegment(readName(), false);
                        }
                        if (c2 != '?') {
                            throw new com.alibaba.fastjson.JSONPathException("not support jsonpath : " + this.path);
                        }
                        return new com.alibaba.fastjson.JSONPath.FilterSegment((com.alibaba.fastjson.JSONPath.Filter) parseArrayAccessFilter(false));
                    }
                    next();
                    if (c2 == '.' && this.ch == '.') {
                        next();
                        int length = this.path.length();
                        int i = this.pos;
                        if (length > i + 3 && this.ch == '[' && this.path.charAt(i) == '*' && this.path.charAt(this.pos + 1) == ']' && this.path.charAt(this.pos + 2) == '.') {
                            next();
                            next();
                            next();
                            next();
                        }
                        z = true;
                    } else {
                        z = false;
                    }
                    char c3 = this.ch;
                    if (c3 == '*' || (z && c3 == '[')) {
                        boolean z2 = c3 == '[';
                        if (!isEOF()) {
                            next();
                        }
                        if (!z) {
                            return com.alibaba.fastjson.JSONPath.WildCardSegment.instance;
                        }
                        if (z2) {
                            return com.alibaba.fastjson.JSONPath.WildCardSegment.instance_deep_objectOnly;
                        }
                        return com.alibaba.fastjson.JSONPath.WildCardSegment.instance_deep;
                    }
                    if (isDigitFirst(c3)) {
                        return parseArrayAccess(false);
                    }
                    java.lang.String name = readName();
                    if (this.ch == '(') {
                        next();
                        if (this.ch != ')') {
                            throw new com.alibaba.fastjson.JSONPathException("not support jsonpath : " + this.path);
                        }
                        if (!isEOF()) {
                            next();
                        }
                        if (io.dcloud.common.constant.AbsoluteConst.JSON_KEY_SIZE.equals(name) || "length".equals(name)) {
                            return com.alibaba.fastjson.JSONPath.SizeSegment.instance;
                        }
                        if ("max".equals(name)) {
                            return com.alibaba.fastjson.JSONPath.MaxSegment.instance;
                        }
                        if (com.taobao.weex.common.Constants.Name.MIN.equals(name)) {
                            return com.alibaba.fastjson.JSONPath.MinSegment.instance;
                        }
                        if ("keySet".equals(name)) {
                            return com.alibaba.fastjson.JSONPath.KeySetSegment.instance;
                        }
                        if ("type".equals(name)) {
                            return com.alibaba.fastjson.JSONPath.TypeSegment.instance;
                        }
                        if (!"floor".equals(name)) {
                            throw new com.alibaba.fastjson.JSONPathException("not support jsonpath : " + this.path);
                        }
                        return com.alibaba.fastjson.JSONPath.FloorSegment.instance;
                    }
                    return new com.alibaba.fastjson.JSONPath.PropertySegment(name, z);
                }
                next();
                skipWhitespace();
                if (this.ch == '?') {
                    return new com.alibaba.fastjson.JSONPath.FilterSegment((com.alibaba.fastjson.JSONPath.Filter) parseArrayAccessFilter(false));
                }
            }
            return null;
        }

        public final void skipWhitespace() {
            while (true) {
                char c = this.ch;
                if (c > ' ') {
                    return;
                }
                if (c != ' ' && c != '\r' && c != '\n' && c != '\t' && c != '\f' && c != '\b') {
                    return;
                } else {
                    next();
                }
            }
        }

        com.alibaba.fastjson.JSONPath.Segment parseArrayAccess(boolean z) {
            java.lang.Object arrayAccessFilter = parseArrayAccessFilter(z);
            if (arrayAccessFilter instanceof com.alibaba.fastjson.JSONPath.Segment) {
                return (com.alibaba.fastjson.JSONPath.Segment) arrayAccessFilter;
            }
            return new com.alibaba.fastjson.JSONPath.FilterSegment((com.alibaba.fastjson.JSONPath.Filter) arrayAccessFilter);
        }

        java.lang.Object parseArrayAccessFilter(boolean z) {
            int i;
            boolean z2;
            boolean z3;
            char c;
            char c2;
            char c3;
            char c4;
            char c5;
            com.alibaba.fastjson.JSONPath.Filter nullSegement;
            char c6;
            java.lang.String str;
            java.lang.String[] strArr;
            java.lang.String str2;
            java.lang.String str3;
            java.lang.String[] strArr2;
            java.lang.String str4;
            com.alibaba.fastjson.JSONPath.Filter matchSegement;
            com.alibaba.fastjson.JSONPath.Operator operator;
            com.alibaba.fastjson.JSONPath.StringOpSegement stringOpSegement;
            char c7;
            com.alibaba.fastjson.JSONPath.Filter valueSegment;
            char c8;
            com.alibaba.fastjson.JSONPath.Filter valueSegment2;
            char c9;
            com.alibaba.fastjson.JSONPath.Filter notNullSegement;
            char c10;
            int i2;
            com.alibaba.fastjson.JSONPath.Filter doubleOpSegement;
            char c11;
            char c12;
            char c13;
            char c14;
            char c15;
            int i3;
            java.lang.String strReplaceAll;
            int i4;
            char cCharAt;
            char c16;
            if (z) {
                accept(com.taobao.weex.el.parse.Operators.ARRAY_START);
            }
            if (this.ch == '?') {
                next();
                accept(com.taobao.weex.el.parse.Operators.BRACKET_START);
                i = 1;
                while (this.ch == '(') {
                    next();
                    i++;
                }
                z2 = true;
            } else {
                i = 0;
                z2 = false;
            }
            skipWhitespace();
            if (z2 || com.alibaba.fastjson.util.IOUtils.firstIdentifier(this.ch) || java.lang.Character.isJavaIdentifierStart(this.ch) || (c14 = this.ch) == '\\' || c14 == '@') {
                if (this.ch == '@') {
                    next();
                    accept(com.taobao.weex.el.parse.Operators.DOT);
                }
                java.lang.String name = readName();
                skipWhitespace();
                if (z2 && this.ch == ')') {
                    next();
                    com.alibaba.fastjson.JSONPath.Filter notNullSegement2 = new com.alibaba.fastjson.JSONPath.NotNullSegement(name, false);
                    while (true) {
                        c13 = this.ch;
                        if (c13 != ' ') {
                            break;
                        }
                        next();
                    }
                    if (c13 == '&' || c13 == '|') {
                        notNullSegement2 = filterRest(notNullSegement2);
                    }
                    if (z) {
                        accept(com.taobao.weex.el.parse.Operators.ARRAY_END);
                    }
                    return notNullSegement2;
                }
                if (z && this.ch == ']') {
                    if (isEOF() && name.equals("last")) {
                        return new com.alibaba.fastjson.JSONPath.MultiIndexSegment(new int[]{-1});
                    }
                    next();
                    com.alibaba.fastjson.JSONPath.Filter notNullSegement3 = new com.alibaba.fastjson.JSONPath.NotNullSegement(name, false);
                    while (true) {
                        c12 = this.ch;
                        if (c12 != ' ') {
                            break;
                        }
                        next();
                    }
                    if (c12 == '&' || c12 == '|') {
                        notNullSegement3 = filterRest(notNullSegement3);
                    }
                    accept(com.taobao.weex.el.parse.Operators.BRACKET_END);
                    if (z2) {
                        accept(com.taobao.weex.el.parse.Operators.BRACKET_END);
                    }
                    if (z) {
                        accept(com.taobao.weex.el.parse.Operators.ARRAY_END);
                    }
                    return notNullSegement3;
                }
                skipWhitespace();
                if (this.ch == '(') {
                    next();
                    accept(com.taobao.weex.el.parse.Operators.BRACKET_END);
                    skipWhitespace();
                    z3 = true;
                } else {
                    z3 = false;
                }
                com.alibaba.fastjson.JSONPath.Operator op = readOp();
                skipWhitespace();
                if (op == com.alibaba.fastjson.JSONPath.Operator.BETWEEN || op == com.alibaba.fastjson.JSONPath.Operator.NOT_BETWEEN) {
                    boolean z4 = z3;
                    boolean z5 = op == com.alibaba.fastjson.JSONPath.Operator.NOT_BETWEEN;
                    java.lang.Object value = readValue();
                    if (!"and".equalsIgnoreCase(readName())) {
                        throw new com.alibaba.fastjson.JSONPathException(this.path);
                    }
                    java.lang.Object value2 = readValue();
                    if (value == null || value2 == null) {
                        throw new com.alibaba.fastjson.JSONPathException(this.path);
                    }
                    if (com.alibaba.fastjson.JSONPath.isInt(value.getClass()) && com.alibaba.fastjson.JSONPath.isInt(value2.getClass())) {
                        return new com.alibaba.fastjson.JSONPath.IntBetweenSegement(name, z4, com.alibaba.fastjson.util.TypeUtils.longExtractValue((java.lang.Number) value), com.alibaba.fastjson.util.TypeUtils.longExtractValue((java.lang.Number) value2), z5);
                    }
                    throw new com.alibaba.fastjson.JSONPathException(this.path);
                }
                if (op == com.alibaba.fastjson.JSONPath.Operator.IN || op == com.alibaba.fastjson.JSONPath.Operator.NOT_IN) {
                    boolean z6 = z3;
                    boolean z7 = op == com.alibaba.fastjson.JSONPath.Operator.NOT_IN;
                    accept(com.taobao.weex.el.parse.Operators.BRACKET_START);
                    com.alibaba.fastjson.JSONArray jSONArray = new com.alibaba.fastjson.JSONArray();
                    jSONArray.add(readValue());
                    while (true) {
                        skipWhitespace();
                        if (this.ch != ',') {
                            break;
                        }
                        next();
                        jSONArray.add(readValue());
                    }
                    boolean z8 = true;
                    boolean z9 = true;
                    boolean z10 = true;
                    for (java.lang.Object obj : jSONArray) {
                        if (obj != null) {
                            java.lang.Class<?> cls = obj.getClass();
                            if (z8 && cls != java.lang.Byte.class && cls != java.lang.Short.class && cls != java.lang.Integer.class && cls != java.lang.Long.class) {
                                z8 = false;
                                z10 = false;
                            }
                            if (z9 && cls != java.lang.String.class) {
                                z9 = false;
                            }
                        } else if (z8) {
                            z8 = false;
                        }
                    }
                    if (jSONArray.size() == 1 && jSONArray.get(0) == null) {
                        if (z7) {
                            nullSegement = new com.alibaba.fastjson.JSONPath.NotNullSegement(name, z6);
                        } else {
                            nullSegement = new com.alibaba.fastjson.JSONPath.NullSegement(name, z6);
                        }
                        while (true) {
                            c6 = this.ch;
                            if (c6 != ' ') {
                                break;
                            }
                            next();
                        }
                        if (c6 == '&' || c6 == '|') {
                            nullSegement = filterRest(nullSegement);
                        }
                        accept(com.taobao.weex.el.parse.Operators.BRACKET_END);
                        if (z2) {
                            accept(com.taobao.weex.el.parse.Operators.BRACKET_END);
                        }
                        if (z) {
                            accept(com.taobao.weex.el.parse.Operators.ARRAY_END);
                        }
                        return nullSegement;
                    }
                    if (z8) {
                        if (jSONArray.size() == 1) {
                            com.alibaba.fastjson.JSONPath.IntOpSegement intOpSegement = new com.alibaba.fastjson.JSONPath.IntOpSegement(name, z6, com.alibaba.fastjson.util.TypeUtils.longExtractValue((java.lang.Number) jSONArray.get(0)), z7 ? com.alibaba.fastjson.JSONPath.Operator.NE : com.alibaba.fastjson.JSONPath.Operator.EQ);
                            while (true) {
                                c5 = this.ch;
                                if (c5 != ' ') {
                                    break;
                                }
                                next();
                            }
                            com.alibaba.fastjson.JSONPath.Filter filterFilterRest = (c5 == '&' || c5 == '|') ? filterRest(intOpSegement) : intOpSegement;
                            accept(com.taobao.weex.el.parse.Operators.BRACKET_END);
                            if (z2) {
                                accept(com.taobao.weex.el.parse.Operators.BRACKET_END);
                            }
                            if (z) {
                                accept(com.taobao.weex.el.parse.Operators.ARRAY_END);
                            }
                            return filterFilterRest;
                        }
                        int size = jSONArray.size();
                        long[] jArr = new long[size];
                        for (int i5 = 0; i5 < size; i5++) {
                            jArr[i5] = com.alibaba.fastjson.util.TypeUtils.longExtractValue((java.lang.Number) jSONArray.get(i5));
                        }
                        com.alibaba.fastjson.JSONPath.Filter intInSegement = new com.alibaba.fastjson.JSONPath.IntInSegement(name, z6, jArr, z7);
                        while (true) {
                            c4 = this.ch;
                            if (c4 != ' ') {
                                break;
                            }
                            next();
                        }
                        if (c4 == '&' || c4 == '|') {
                            intInSegement = filterRest(intInSegement);
                        }
                        accept(com.taobao.weex.el.parse.Operators.BRACKET_END);
                        if (z2) {
                            accept(com.taobao.weex.el.parse.Operators.BRACKET_END);
                        }
                        if (z) {
                            accept(com.taobao.weex.el.parse.Operators.ARRAY_END);
                        }
                        return intInSegement;
                    }
                    if (!z9) {
                        if (z10) {
                            int size2 = jSONArray.size();
                            java.lang.Long[] lArr = new java.lang.Long[size2];
                            for (int i6 = 0; i6 < size2; i6++) {
                                java.lang.Number number = (java.lang.Number) jSONArray.get(i6);
                                if (number != null) {
                                    lArr[i6] = java.lang.Long.valueOf(com.alibaba.fastjson.util.TypeUtils.longExtractValue(number));
                                }
                            }
                            com.alibaba.fastjson.JSONPath.Filter intObjInSegement = new com.alibaba.fastjson.JSONPath.IntObjInSegement(name, z6, lArr, z7);
                            while (true) {
                                c = this.ch;
                                if (c != ' ') {
                                    break;
                                }
                                next();
                            }
                            if (c == '&' || c == '|') {
                                intObjInSegement = filterRest(intObjInSegement);
                            }
                            accept(com.taobao.weex.el.parse.Operators.BRACKET_END);
                            if (z2) {
                                accept(com.taobao.weex.el.parse.Operators.BRACKET_END);
                            }
                            if (z) {
                                accept(com.taobao.weex.el.parse.Operators.ARRAY_END);
                            }
                            return intObjInSegement;
                        }
                        throw new java.lang.UnsupportedOperationException();
                    }
                    if (jSONArray.size() == 1) {
                        com.alibaba.fastjson.JSONPath.Filter stringOpSegement2 = new com.alibaba.fastjson.JSONPath.StringOpSegement(name, z6, (java.lang.String) jSONArray.get(0), z7 ? com.alibaba.fastjson.JSONPath.Operator.NE : com.alibaba.fastjson.JSONPath.Operator.EQ);
                        while (true) {
                            c3 = this.ch;
                            if (c3 != ' ') {
                                break;
                            }
                            next();
                        }
                        if (c3 == '&' || c3 == '|') {
                            stringOpSegement2 = filterRest(stringOpSegement2);
                        }
                        accept(com.taobao.weex.el.parse.Operators.BRACKET_END);
                        if (z2) {
                            accept(com.taobao.weex.el.parse.Operators.BRACKET_END);
                        }
                        if (z) {
                            accept(com.taobao.weex.el.parse.Operators.ARRAY_END);
                        }
                        return stringOpSegement2;
                    }
                    java.lang.String[] strArr3 = new java.lang.String[jSONArray.size()];
                    jSONArray.toArray(strArr3);
                    com.alibaba.fastjson.JSONPath.Filter stringInSegement = new com.alibaba.fastjson.JSONPath.StringInSegement(name, z6, strArr3, z7);
                    while (true) {
                        c2 = this.ch;
                        if (c2 != ' ') {
                            break;
                        }
                        next();
                    }
                    if (c2 == '&' || c2 == '|') {
                        stringInSegement = filterRest(stringInSegement);
                    }
                    accept(com.taobao.weex.el.parse.Operators.BRACKET_END);
                    if (z2) {
                        accept(com.taobao.weex.el.parse.Operators.BRACKET_END);
                    }
                    if (z) {
                        accept(com.taobao.weex.el.parse.Operators.ARRAY_END);
                    }
                    return stringInSegement;
                }
                char c17 = this.ch;
                java.lang.String str5 = null;
                if (c17 == '\'' || c17 == '\"') {
                    boolean z11 = z3;
                    java.lang.String string = readString();
                    if (op == com.alibaba.fastjson.JSONPath.Operator.RLIKE) {
                        matchSegement = new com.alibaba.fastjson.JSONPath.RlikeSegement(name, z11, string, false);
                    } else if (op == com.alibaba.fastjson.JSONPath.Operator.NOT_RLIKE) {
                        matchSegement = new com.alibaba.fastjson.JSONPath.RlikeSegement(name, z11, string, true);
                    } else {
                        if (op == com.alibaba.fastjson.JSONPath.Operator.LIKE || op == com.alibaba.fastjson.JSONPath.Operator.NOT_LIKE) {
                            while (string.indexOf("%%") != -1) {
                                string = string.replaceAll("%%", "%");
                            }
                            boolean z12 = op == com.alibaba.fastjson.JSONPath.Operator.NOT_LIKE;
                            int iIndexOf = string.indexOf(37);
                            if (iIndexOf == -1) {
                                if (op == com.alibaba.fastjson.JSONPath.Operator.LIKE) {
                                    operator = com.alibaba.fastjson.JSONPath.Operator.EQ;
                                } else {
                                    operator = com.alibaba.fastjson.JSONPath.Operator.NE;
                                }
                                stringOpSegement = new com.alibaba.fastjson.JSONPath.StringOpSegement(name, z11, string, operator);
                            } else {
                                java.lang.String[] strArrSplit = string.split("%");
                                if (iIndexOf == 0) {
                                    if (string.charAt(string.length() - 1) == '%') {
                                        int length = strArrSplit.length - 1;
                                        java.lang.String[] strArr4 = new java.lang.String[length];
                                        java.lang.System.arraycopy(strArrSplit, 1, strArr4, 0, length);
                                        strArr2 = strArr4;
                                        str3 = null;
                                        str2 = null;
                                    } else {
                                        str = strArrSplit[strArrSplit.length - 1];
                                        if (strArrSplit.length > 2) {
                                            int length2 = strArrSplit.length - 2;
                                            strArr = new java.lang.String[length2];
                                            java.lang.System.arraycopy(strArrSplit, 1, strArr, 0, length2);
                                            str2 = str;
                                            strArr2 = strArr;
                                            str3 = str5;
                                        } else {
                                            str2 = str;
                                            str3 = null;
                                            strArr2 = null;
                                        }
                                    }
                                } else {
                                    if (string.charAt(string.length() - 1) == '%') {
                                        if (strArrSplit.length == 1) {
                                            str4 = strArrSplit[0];
                                        } else {
                                            strArr2 = strArrSplit;
                                            str3 = null;
                                            str2 = null;
                                        }
                                    } else if (strArrSplit.length == 1) {
                                        str4 = strArrSplit[0];
                                    } else if (strArrSplit.length == 2) {
                                        java.lang.String str6 = strArrSplit[0];
                                        str2 = strArrSplit[1];
                                        str3 = str6;
                                        strArr2 = null;
                                    } else {
                                        str5 = strArrSplit[0];
                                        str = strArrSplit[strArrSplit.length - 1];
                                        int length3 = strArrSplit.length - 2;
                                        strArr = new java.lang.String[length3];
                                        java.lang.System.arraycopy(strArrSplit, 1, strArr, 0, length3);
                                        str2 = str;
                                        strArr2 = strArr;
                                        str3 = str5;
                                    }
                                    str3 = str4;
                                    str2 = null;
                                    strArr2 = null;
                                }
                                matchSegement = new com.alibaba.fastjson.JSONPath.MatchSegement(name, z11, str3, str2, strArr2, z12);
                            }
                        } else {
                            stringOpSegement = new com.alibaba.fastjson.JSONPath.StringOpSegement(name, z11, string, op);
                        }
                        matchSegement = stringOpSegement;
                    }
                    while (true) {
                        c7 = this.ch;
                        if (c7 != ' ') {
                            break;
                        }
                        next();
                    }
                    if (c7 == '&' || c7 == '|') {
                        matchSegement = filterRest(matchSegement);
                    }
                    if (z2) {
                        accept(com.taobao.weex.el.parse.Operators.BRACKET_END);
                    }
                    if (z) {
                        accept(com.taobao.weex.el.parse.Operators.ARRAY_END);
                    }
                    return matchSegement;
                }
                if (isDigitFirst(c17)) {
                    long longValue = readLongValue();
                    double doubleValue = this.ch == '.' ? readDoubleValue(longValue) : 0.0d;
                    if (doubleValue == 0.0d) {
                        doubleOpSegement = new com.alibaba.fastjson.JSONPath.IntOpSegement(name, z3, longValue, op);
                    } else {
                        doubleOpSegement = new com.alibaba.fastjson.JSONPath.DoubleOpSegement(name, z3, doubleValue, op);
                    }
                    com.alibaba.fastjson.JSONPath.Filter filterFilterRest2 = doubleOpSegement;
                    while (true) {
                        c11 = this.ch;
                        if (c11 != ' ') {
                            break;
                        }
                        next();
                    }
                    if (i > 1 && c11 == ')') {
                        next();
                    }
                    char c18 = this.ch;
                    if (c18 == '&' || c18 == '|') {
                        filterFilterRest2 = filterRest(filterFilterRest2);
                    }
                    if (z2) {
                        accept(com.taobao.weex.el.parse.Operators.BRACKET_END);
                    }
                    if (z) {
                        accept(com.taobao.weex.el.parse.Operators.ARRAY_END);
                    }
                    return filterFilterRest2;
                }
                boolean z13 = z3;
                char c19 = this.ch;
                if (c19 == '$') {
                    com.alibaba.fastjson.JSONPath.RefOpSegement refOpSegement = new com.alibaba.fastjson.JSONPath.RefOpSegement(name, z13, readSegement(), op);
                    this.hasRefSegment = true;
                    while (this.ch == ' ') {
                        next();
                    }
                    if (z2) {
                        accept(com.taobao.weex.el.parse.Operators.BRACKET_END);
                    }
                    if (z) {
                        accept(com.taobao.weex.el.parse.Operators.ARRAY_END);
                    }
                    return refOpSegement;
                }
                if (c19 == '/') {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    while (true) {
                        next();
                        char c20 = this.ch;
                        if (c20 == '/') {
                            break;
                        }
                        if (c20 == '\\') {
                            next();
                            sb.append(this.ch);
                        } else {
                            sb.append(c20);
                        }
                    }
                    next();
                    if (this.ch == 'i') {
                        next();
                        i2 = 2;
                    } else {
                        i2 = 0;
                    }
                    com.alibaba.fastjson.JSONPath.RegMatchSegement regMatchSegement = new com.alibaba.fastjson.JSONPath.RegMatchSegement(name, z13, java.util.regex.Pattern.compile(sb.toString(), i2), op);
                    if (z2) {
                        accept(com.taobao.weex.el.parse.Operators.BRACKET_END);
                    }
                    if (z) {
                        accept(com.taobao.weex.el.parse.Operators.ARRAY_END);
                    }
                    return regMatchSegement;
                }
                if (c19 == 'n') {
                    if ("null".equals(readName())) {
                        if (op == com.alibaba.fastjson.JSONPath.Operator.EQ) {
                            notNullSegement = new com.alibaba.fastjson.JSONPath.NullSegement(name, z13);
                        } else {
                            notNullSegement = op == com.alibaba.fastjson.JSONPath.Operator.NE ? new com.alibaba.fastjson.JSONPath.NotNullSegement(name, z13) : null;
                        }
                        if (notNullSegement != null) {
                            while (true) {
                                c10 = this.ch;
                                if (c10 != ' ') {
                                    break;
                                }
                                next();
                            }
                            if (c10 == '&' || c10 == '|') {
                                notNullSegement = filterRest(notNullSegement);
                            }
                        }
                        if (z2) {
                            accept(com.taobao.weex.el.parse.Operators.BRACKET_END);
                        }
                        accept(com.taobao.weex.el.parse.Operators.ARRAY_END);
                        if (notNullSegement != null) {
                            return notNullSegement;
                        }
                        throw new java.lang.UnsupportedOperationException();
                    }
                } else if (c19 == 't') {
                    if (io.dcloud.common.constant.AbsoluteConst.TRUE.equals(readName())) {
                        if (op == com.alibaba.fastjson.JSONPath.Operator.EQ) {
                            valueSegment2 = new com.alibaba.fastjson.JSONPath.ValueSegment(name, z13, java.lang.Boolean.TRUE, true);
                        } else {
                            valueSegment2 = op == com.alibaba.fastjson.JSONPath.Operator.NE ? new com.alibaba.fastjson.JSONPath.ValueSegment(name, z13, java.lang.Boolean.TRUE, false) : null;
                        }
                        if (valueSegment2 != null) {
                            while (true) {
                                c9 = this.ch;
                                if (c9 != ' ') {
                                    break;
                                }
                                next();
                            }
                            if (c9 == '&' || c9 == '|') {
                                valueSegment2 = filterRest(valueSegment2);
                            }
                        }
                        if (z2) {
                            accept(com.taobao.weex.el.parse.Operators.BRACKET_END);
                        }
                        accept(com.taobao.weex.el.parse.Operators.ARRAY_END);
                        if (valueSegment2 != null) {
                            return valueSegment2;
                        }
                        throw new java.lang.UnsupportedOperationException();
                    }
                } else if (c19 == 'f' && io.dcloud.common.constant.AbsoluteConst.FALSE.equals(readName())) {
                    if (op == com.alibaba.fastjson.JSONPath.Operator.EQ) {
                        valueSegment = new com.alibaba.fastjson.JSONPath.ValueSegment(name, z13, java.lang.Boolean.FALSE, true);
                    } else {
                        valueSegment = op == com.alibaba.fastjson.JSONPath.Operator.NE ? new com.alibaba.fastjson.JSONPath.ValueSegment(name, z13, java.lang.Boolean.FALSE, false) : null;
                    }
                    if (valueSegment != null) {
                        while (true) {
                            c8 = this.ch;
                            if (c8 != ' ') {
                                break;
                            }
                            next();
                        }
                        if (c8 == '&' || c8 == '|') {
                            valueSegment = filterRest(valueSegment);
                        }
                    }
                    if (z2) {
                        accept(com.taobao.weex.el.parse.Operators.BRACKET_END);
                    }
                    accept(com.taobao.weex.el.parse.Operators.ARRAY_END);
                    if (valueSegment != null) {
                        return valueSegment;
                    }
                    throw new java.lang.UnsupportedOperationException();
                }
                throw new java.lang.UnsupportedOperationException();
            }
            int i7 = this.pos - 1;
            while (true) {
                char c21 = this.ch;
                if (c21 == ']' || c21 == '/' || isEOF() || !((c16 = this.ch) != '.' || z2 || z2 || c14 == '\'')) {
                    break;
                }
                if (c16 == '\\') {
                    next();
                }
                next();
            }
            if (z || (c15 = this.ch) == '/' || c15 == '.') {
                int i8 = this.pos;
                i3 = i8 - 1;
            } else {
                i3 = this.pos;
            }
            java.lang.String strSubstring = this.path.substring(i7, i3);
            if (strSubstring.indexOf(92) != 0) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder(strSubstring.length());
                int i9 = 0;
                while (i9 < strSubstring.length()) {
                    char cCharAt2 = strSubstring.charAt(i9);
                    if (cCharAt2 == '\\' && i9 < strSubstring.length() - 1 && ((cCharAt = strSubstring.charAt((i4 = i9 + 1))) == '@' || cCharAt2 == '\\' || cCharAt2 == '\"')) {
                        sb2.append(cCharAt);
                        i9 = i4;
                    } else {
                        sb2.append(cCharAt2);
                    }
                    i9++;
                }
                strSubstring = sb2.toString();
            }
            if (strSubstring.indexOf("\\.") != -1) {
                if (c14 != '\'' || strSubstring.length() <= 2 || strSubstring.charAt(strSubstring.length() - 1) != c14) {
                    strReplaceAll = strSubstring.replaceAll("\\\\\\.", "\\.");
                    if (strReplaceAll.indexOf("\\-") != -1) {
                        strReplaceAll = strReplaceAll.replaceAll("\\\\-", com.taobao.weex.el.parse.Operators.SUB);
                    }
                } else {
                    strReplaceAll = strSubstring.substring(1, strSubstring.length() - 1);
                }
                if (z2) {
                    accept(com.taobao.weex.el.parse.Operators.BRACKET_END);
                }
                return new com.alibaba.fastjson.JSONPath.PropertySegment(strReplaceAll, false);
            }
            com.alibaba.fastjson.JSONPath.Segment segmentBuildArraySegement = buildArraySegement(strSubstring);
            if (z && !isEOF()) {
                accept(com.taobao.weex.el.parse.Operators.ARRAY_END);
            }
            return segmentBuildArraySegement;
        }

        com.alibaba.fastjson.JSONPath.Filter filterRest(com.alibaba.fastjson.JSONPath.Filter filter) {
            char c = this.ch;
            boolean z = true;
            boolean z2 = c == '&';
            if ((c != '&' || getNextChar() != '&') && (this.ch != '|' || getNextChar() != '|')) {
                return filter;
            }
            next();
            next();
            if (this.ch == '(') {
                next();
            } else {
                z = false;
            }
            while (this.ch == ' ') {
                next();
            }
            com.alibaba.fastjson.JSONPath.FilterGroup filterGroup = new com.alibaba.fastjson.JSONPath.FilterGroup(filter, (com.alibaba.fastjson.JSONPath.Filter) parseArrayAccessFilter(false), z2);
            if (z && this.ch == ')') {
                next();
            }
            return filterGroup;
        }

        protected long readLongValue() {
            int i = this.pos - 1;
            char c = this.ch;
            if (c == '+' || c == '-') {
                next();
            }
            while (true) {
                char c2 = this.ch;
                if (c2 < '0' || c2 > '9') {
                    break;
                }
                next();
            }
            return java.lang.Long.parseLong(this.path.substring(i, this.pos - 1));
        }

        protected double readDoubleValue(long j) {
            int i = this.pos - 1;
            next();
            while (true) {
                char c = this.ch;
                if (c < '0' || c > '9') {
                    break;
                }
                next();
            }
            return java.lang.Double.parseDouble(this.path.substring(i, this.pos - 1)) + j;
        }

        protected java.lang.Object readValue() {
            skipWhitespace();
            if (isDigitFirst(this.ch)) {
                return java.lang.Long.valueOf(readLongValue());
            }
            char c = this.ch;
            if (c == '\"' || c == '\'') {
                return readString();
            }
            if (c == 'n') {
                if ("null".equals(readName())) {
                    return null;
                }
                throw new com.alibaba.fastjson.JSONPathException(this.path);
            }
            throw new java.lang.UnsupportedOperationException();
        }

        protected com.alibaba.fastjson.JSONPath.Operator readOp() {
            com.alibaba.fastjson.JSONPath.Operator operator;
            char c = this.ch;
            if (c == '=') {
                next();
                char c2 = this.ch;
                if (c2 == '~') {
                    next();
                    operator = com.alibaba.fastjson.JSONPath.Operator.REG_MATCH;
                } else if (c2 == '=') {
                    next();
                    operator = com.alibaba.fastjson.JSONPath.Operator.EQ;
                } else {
                    operator = com.alibaba.fastjson.JSONPath.Operator.EQ;
                }
            } else if (c == '!') {
                next();
                accept('=');
                operator = com.alibaba.fastjson.JSONPath.Operator.NE;
            } else if (c == '<') {
                next();
                if (this.ch == '=') {
                    next();
                    operator = com.alibaba.fastjson.JSONPath.Operator.LE;
                } else {
                    operator = com.alibaba.fastjson.JSONPath.Operator.LT;
                }
            } else if (c == '>') {
                next();
                if (this.ch == '=') {
                    next();
                    operator = com.alibaba.fastjson.JSONPath.Operator.GE;
                } else {
                    operator = com.alibaba.fastjson.JSONPath.Operator.GT;
                }
            } else {
                operator = null;
            }
            if (operator != null) {
                return operator;
            }
            java.lang.String name = readName();
            if ("not".equalsIgnoreCase(name)) {
                skipWhitespace();
                java.lang.String name2 = readName();
                if ("like".equalsIgnoreCase(name2)) {
                    return com.alibaba.fastjson.JSONPath.Operator.NOT_LIKE;
                }
                if ("rlike".equalsIgnoreCase(name2)) {
                    return com.alibaba.fastjson.JSONPath.Operator.NOT_RLIKE;
                }
                if ("in".equalsIgnoreCase(name2)) {
                    return com.alibaba.fastjson.JSONPath.Operator.NOT_IN;
                }
                if ("between".equalsIgnoreCase(name2)) {
                    return com.alibaba.fastjson.JSONPath.Operator.NOT_BETWEEN;
                }
                throw new java.lang.UnsupportedOperationException();
            }
            if ("nin".equalsIgnoreCase(name)) {
                return com.alibaba.fastjson.JSONPath.Operator.NOT_IN;
            }
            if ("like".equalsIgnoreCase(name)) {
                return com.alibaba.fastjson.JSONPath.Operator.LIKE;
            }
            if ("rlike".equalsIgnoreCase(name)) {
                return com.alibaba.fastjson.JSONPath.Operator.RLIKE;
            }
            if ("in".equalsIgnoreCase(name)) {
                return com.alibaba.fastjson.JSONPath.Operator.IN;
            }
            if ("between".equalsIgnoreCase(name)) {
                return com.alibaba.fastjson.JSONPath.Operator.BETWEEN;
            }
            throw new java.lang.UnsupportedOperationException();
        }

        java.lang.String readName() {
            skipWhitespace();
            char c = this.ch;
            if (c != '\\' && !java.lang.Character.isJavaIdentifierStart(c)) {
                throw new com.alibaba.fastjson.JSONPathException("illeal jsonpath syntax. " + this.path);
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            while (!isEOF()) {
                char c2 = this.ch;
                if (c2 == '\\') {
                    next();
                    sb.append(this.ch);
                    if (isEOF()) {
                        return sb.toString();
                    }
                    next();
                } else {
                    if (!java.lang.Character.isJavaIdentifierPart(c2)) {
                        break;
                    }
                    sb.append(this.ch);
                    next();
                }
            }
            if (isEOF() && java.lang.Character.isJavaIdentifierPart(this.ch)) {
                sb.append(this.ch);
            }
            return sb.toString();
        }

        java.lang.String readString() {
            char c = this.ch;
            next();
            int i = this.pos - 1;
            while (this.ch != c && !isEOF()) {
                next();
            }
            java.lang.String strSubstring = this.path.substring(i, isEOF() ? this.pos : this.pos - 1);
            accept(c);
            return strSubstring;
        }

        void accept(char c) {
            if (this.ch == ' ') {
                next();
            }
            if (this.ch != c) {
                throw new com.alibaba.fastjson.JSONPathException("expect '" + c + ", but '" + this.ch + "'");
            }
            if (isEOF()) {
                return;
            }
            next();
        }

        public com.alibaba.fastjson.JSONPath.Segment[] explain() {
            java.lang.String str = this.path;
            if (str == null || str.length() == 0) {
                throw new java.lang.IllegalArgumentException();
            }
            com.alibaba.fastjson.JSONPath.Segment[] segmentArr = new com.alibaba.fastjson.JSONPath.Segment[8];
            while (true) {
                com.alibaba.fastjson.JSONPath.Segment segement = readSegement();
                if (segement == null) {
                    break;
                }
                if (segement instanceof com.alibaba.fastjson.JSONPath.PropertySegment) {
                    com.alibaba.fastjson.JSONPath.PropertySegment propertySegment = (com.alibaba.fastjson.JSONPath.PropertySegment) segement;
                    if (propertySegment.deep || !propertySegment.propertyName.equals("*")) {
                    }
                }
                int i = this.level;
                if (i == segmentArr.length) {
                    com.alibaba.fastjson.JSONPath.Segment[] segmentArr2 = new com.alibaba.fastjson.JSONPath.Segment[(i * 3) / 2];
                    java.lang.System.arraycopy(segmentArr, 0, segmentArr2, 0, i);
                    segmentArr = segmentArr2;
                }
                int i2 = this.level;
                this.level = i2 + 1;
                segmentArr[i2] = segement;
            }
            int i3 = this.level;
            if (i3 == segmentArr.length) {
                return segmentArr;
            }
            com.alibaba.fastjson.JSONPath.Segment[] segmentArr3 = new com.alibaba.fastjson.JSONPath.Segment[i3];
            java.lang.System.arraycopy(segmentArr, 0, segmentArr3, 0, i3);
            return segmentArr3;
        }

        com.alibaba.fastjson.JSONPath.Segment buildArraySegement(java.lang.String str) {
            int length = str.length();
            char cCharAt = str.charAt(0);
            int i = length - 1;
            char cCharAt2 = str.charAt(i);
            int iIndexOf = str.indexOf(44);
            if (str.length() > 2 && cCharAt == '\'' && cCharAt2 == '\'') {
                java.lang.String strSubstring = str.substring(1, i);
                if (iIndexOf == -1 || !strArrayPatternx.matcher(str).find()) {
                    return new com.alibaba.fastjson.JSONPath.PropertySegment(strSubstring, false);
                }
                return new com.alibaba.fastjson.JSONPath.MultiPropertySegment(strSubstring.split(strArrayRegex));
            }
            int iIndexOf2 = str.indexOf(58);
            if (iIndexOf == -1 && iIndexOf2 == -1) {
                if (com.alibaba.fastjson.util.TypeUtils.isNumber(str)) {
                    try {
                        return new com.alibaba.fastjson.JSONPath.ArrayAccessSegment(java.lang.Integer.parseInt(str));
                    } catch (java.lang.NumberFormatException unused) {
                        return new com.alibaba.fastjson.JSONPath.PropertySegment(str, false);
                    }
                }
                if (str.charAt(0) == '\"' && str.charAt(str.length() - 1) == '\"') {
                    str = str.substring(1, str.length() - 1);
                }
                return new com.alibaba.fastjson.JSONPath.PropertySegment(str, false);
            }
            if (iIndexOf != -1) {
                java.lang.String[] strArrSplit = str.split(",");
                int[] iArr = new int[strArrSplit.length];
                for (int i2 = 0; i2 < strArrSplit.length; i2++) {
                    iArr[i2] = java.lang.Integer.parseInt(strArrSplit[i2]);
                }
                return new com.alibaba.fastjson.JSONPath.MultiIndexSegment(iArr);
            }
            if (iIndexOf2 != -1) {
                java.lang.String[] strArrSplit2 = str.split(":");
                int length2 = strArrSplit2.length;
                int[] iArr2 = new int[length2];
                for (int i3 = 0; i3 < strArrSplit2.length; i3++) {
                    java.lang.String str2 = strArrSplit2[i3];
                    if (str2.length() != 0) {
                        iArr2[i3] = java.lang.Integer.parseInt(str2);
                    } else if (i3 == 0) {
                        iArr2[i3] = 0;
                    } else {
                        throw new java.lang.UnsupportedOperationException();
                    }
                }
                int i4 = iArr2[0];
                int i5 = length2 > 1 ? iArr2[1] : -1;
                int i6 = length2 == 3 ? iArr2[2] : 1;
                if (i5 < 0 || i5 >= i4) {
                    if (i6 <= 0) {
                        throw new java.lang.UnsupportedOperationException("step must greater than zero : " + i6);
                    }
                    return new com.alibaba.fastjson.JSONPath.RangeSegment(i4, i5, i6);
                }
                throw new java.lang.UnsupportedOperationException("end must greater than or equals start. start " + i4 + ",  end " + i5);
            }
            throw new java.lang.UnsupportedOperationException();
        }
    }

    static class SizeSegment implements com.alibaba.fastjson.JSONPath.Segment {
        public static final com.alibaba.fastjson.JSONPath.SizeSegment instance = new com.alibaba.fastjson.JSONPath.SizeSegment();

        SizeSegment() {
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public java.lang.Integer eval(com.alibaba.fastjson.JSONPath jSONPath, java.lang.Object obj, java.lang.Object obj2) {
            return java.lang.Integer.valueOf(jSONPath.evalSize(obj2));
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public void extract(com.alibaba.fastjson.JSONPath jSONPath, com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, com.alibaba.fastjson.JSONPath.Context context) {
            context.object = java.lang.Integer.valueOf(jSONPath.evalSize(defaultJSONParser.parse()));
        }
    }

    static class TypeSegment implements com.alibaba.fastjson.JSONPath.Segment {
        public static final com.alibaba.fastjson.JSONPath.TypeSegment instance = new com.alibaba.fastjson.JSONPath.TypeSegment();

        TypeSegment() {
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public java.lang.String eval(com.alibaba.fastjson.JSONPath jSONPath, java.lang.Object obj, java.lang.Object obj2) {
            if (obj2 == null) {
                return "null";
            }
            if (obj2 instanceof java.util.Collection) {
                return "array";
            }
            if (obj2 instanceof java.lang.Number) {
                return "number";
            }
            if (obj2 instanceof java.lang.Boolean) {
                return "boolean";
            }
            if ((obj2 instanceof java.lang.String) || (obj2 instanceof java.util.UUID) || (obj2 instanceof java.lang.Enum)) {
                return "string";
            }
            return "object";
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public void extract(com.alibaba.fastjson.JSONPath jSONPath, com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, com.alibaba.fastjson.JSONPath.Context context) {
            throw new java.lang.UnsupportedOperationException();
        }
    }

    static class FloorSegment implements com.alibaba.fastjson.JSONPath.Segment {
        public static final com.alibaba.fastjson.JSONPath.FloorSegment instance = new com.alibaba.fastjson.JSONPath.FloorSegment();

        FloorSegment() {
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public java.lang.Object eval(com.alibaba.fastjson.JSONPath jSONPath, java.lang.Object obj, java.lang.Object obj2) {
            if (obj2 instanceof com.alibaba.fastjson.JSONArray) {
                com.alibaba.fastjson.JSONArray jSONArray = (com.alibaba.fastjson.JSONArray) ((com.alibaba.fastjson.JSONArray) obj2).clone();
                for (int i = 0; i < jSONArray.size(); i++) {
                    java.lang.Object obj3 = jSONArray.get(i);
                    java.lang.Object objFloor = floor(obj3);
                    if (objFloor != obj3) {
                        jSONArray.set(i, objFloor);
                    }
                }
                return jSONArray;
            }
            return floor(obj2);
        }

        private static java.lang.Object floor(java.lang.Object obj) {
            if (obj == null) {
                return null;
            }
            if (obj instanceof java.lang.Float) {
                return java.lang.Double.valueOf(java.lang.Math.floor(((java.lang.Float) obj).floatValue()));
            }
            if (obj instanceof java.lang.Double) {
                return java.lang.Double.valueOf(java.lang.Math.floor(((java.lang.Double) obj).doubleValue()));
            }
            if (obj instanceof java.math.BigDecimal) {
                return ((java.math.BigDecimal) obj).setScale(0, java.math.RoundingMode.FLOOR);
            }
            if ((obj instanceof java.lang.Byte) || (obj instanceof java.lang.Short) || (obj instanceof java.lang.Integer) || (obj instanceof java.lang.Long) || (obj instanceof java.math.BigInteger)) {
                return obj;
            }
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public void extract(com.alibaba.fastjson.JSONPath jSONPath, com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, com.alibaba.fastjson.JSONPath.Context context) {
            throw new java.lang.UnsupportedOperationException();
        }
    }

    static class MaxSegment implements com.alibaba.fastjson.JSONPath.Segment {
        public static final com.alibaba.fastjson.JSONPath.MaxSegment instance = new com.alibaba.fastjson.JSONPath.MaxSegment();

        MaxSegment() {
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public java.lang.Object eval(com.alibaba.fastjson.JSONPath jSONPath, java.lang.Object obj, java.lang.Object obj2) {
            if (obj2 instanceof java.util.Collection) {
                java.lang.Object obj3 = null;
                for (java.lang.Object obj4 : (java.util.Collection) obj2) {
                    if (obj4 != null && (obj3 == null || com.alibaba.fastjson.JSONPath.compare(obj3, obj4) < 0)) {
                        obj3 = obj4;
                    }
                }
                return obj3;
            }
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public void extract(com.alibaba.fastjson.JSONPath jSONPath, com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, com.alibaba.fastjson.JSONPath.Context context) {
            throw new java.lang.UnsupportedOperationException();
        }
    }

    static class MinSegment implements com.alibaba.fastjson.JSONPath.Segment {
        public static final com.alibaba.fastjson.JSONPath.MinSegment instance = new com.alibaba.fastjson.JSONPath.MinSegment();

        MinSegment() {
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public java.lang.Object eval(com.alibaba.fastjson.JSONPath jSONPath, java.lang.Object obj, java.lang.Object obj2) {
            if (obj2 instanceof java.util.Collection) {
                java.lang.Object obj3 = null;
                for (java.lang.Object obj4 : (java.util.Collection) obj2) {
                    if (obj4 != null && (obj3 == null || com.alibaba.fastjson.JSONPath.compare(obj3, obj4) > 0)) {
                        obj3 = obj4;
                    }
                }
                return obj3;
            }
            throw new java.lang.UnsupportedOperationException();
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public void extract(com.alibaba.fastjson.JSONPath jSONPath, com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, com.alibaba.fastjson.JSONPath.Context context) {
            throw new java.lang.UnsupportedOperationException();
        }
    }

    static int compare(java.lang.Object obj, java.lang.Object obj2) {
        java.lang.Object d;
        java.lang.Object f;
        if (obj.getClass() == obj2.getClass()) {
            return ((java.lang.Comparable) obj).compareTo(obj2);
        }
        java.lang.Class<?> cls = obj.getClass();
        java.lang.Class<?> cls2 = obj2.getClass();
        if (cls == java.math.BigDecimal.class) {
            if (cls2 == java.lang.Integer.class) {
                f = new java.math.BigDecimal(((java.lang.Integer) obj2).intValue());
            } else if (cls2 == java.lang.Long.class) {
                f = new java.math.BigDecimal(((java.lang.Long) obj2).longValue());
            } else if (cls2 == java.lang.Float.class) {
                f = new java.math.BigDecimal(((java.lang.Float) obj2).floatValue());
            } else if (cls2 == java.lang.Double.class) {
                f = new java.math.BigDecimal(((java.lang.Double) obj2).doubleValue());
            }
            obj2 = f;
        } else if (cls == java.lang.Long.class) {
            if (cls2 == java.lang.Integer.class) {
                f = new java.lang.Long(((java.lang.Integer) obj2).intValue());
                obj2 = f;
            } else {
                if (cls2 == java.math.BigDecimal.class) {
                    d = new java.math.BigDecimal(((java.lang.Long) obj).longValue());
                } else if (cls2 == java.lang.Float.class) {
                    d = new java.lang.Float(((java.lang.Long) obj).longValue());
                } else if (cls2 == java.lang.Double.class) {
                    d = new java.lang.Double(((java.lang.Long) obj).longValue());
                }
                obj = d;
            }
        } else if (cls == java.lang.Integer.class) {
            if (cls2 == java.lang.Long.class) {
                d = new java.lang.Long(((java.lang.Integer) obj).intValue());
            } else if (cls2 == java.math.BigDecimal.class) {
                d = new java.math.BigDecimal(((java.lang.Integer) obj).intValue());
            } else if (cls2 == java.lang.Float.class) {
                d = new java.lang.Float(((java.lang.Integer) obj).intValue());
            } else if (cls2 == java.lang.Double.class) {
                d = new java.lang.Double(((java.lang.Integer) obj).intValue());
            }
            obj = d;
        } else if (cls == java.lang.Double.class) {
            if (cls2 == java.lang.Integer.class) {
                f = new java.lang.Double(((java.lang.Integer) obj2).intValue());
            } else if (cls2 == java.lang.Long.class) {
                f = new java.lang.Double(((java.lang.Long) obj2).longValue());
            } else if (cls2 == java.lang.Float.class) {
                f = new java.lang.Double(((java.lang.Float) obj2).floatValue());
            }
            obj2 = f;
        } else if (cls == java.lang.Float.class) {
            if (cls2 == java.lang.Integer.class) {
                f = new java.lang.Float(((java.lang.Integer) obj2).intValue());
            } else if (cls2 == java.lang.Long.class) {
                f = new java.lang.Float(((java.lang.Long) obj2).longValue());
            } else if (cls2 == java.lang.Double.class) {
                d = new java.lang.Double(((java.lang.Float) obj).floatValue());
                obj = d;
            }
            obj2 = f;
        }
        return ((java.lang.Comparable) obj).compareTo(obj2);
    }

    static class KeySetSegment implements com.alibaba.fastjson.JSONPath.Segment {
        public static final com.alibaba.fastjson.JSONPath.KeySetSegment instance = new com.alibaba.fastjson.JSONPath.KeySetSegment();

        KeySetSegment() {
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public java.lang.Object eval(com.alibaba.fastjson.JSONPath jSONPath, java.lang.Object obj, java.lang.Object obj2) {
            return jSONPath.evalKeySet(obj2);
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public void extract(com.alibaba.fastjson.JSONPath jSONPath, com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, com.alibaba.fastjson.JSONPath.Context context) {
            throw new java.lang.UnsupportedOperationException();
        }
    }

    static class PropertySegment implements com.alibaba.fastjson.JSONPath.Segment {
        private final boolean deep;
        private final java.lang.String propertyName;
        private final long propertyNameHash;

        public PropertySegment(java.lang.String str, boolean z) {
            this.propertyName = str;
            this.propertyNameHash = com.alibaba.fastjson.util.TypeUtils.fnv1a_64(str);
            this.deep = z;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public java.lang.Object eval(com.alibaba.fastjson.JSONPath jSONPath, java.lang.Object obj, java.lang.Object obj2) {
            if (this.deep) {
                java.util.ArrayList arrayList = new java.util.ArrayList();
                jSONPath.deepScan(obj2, this.propertyName, arrayList);
                return arrayList;
            }
            return jSONPath.getPropertyValue(obj2, this.propertyName, this.propertyNameHash);
        }

        /* JADX WARN: Code duplicated, block: B:110:0x00b4 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:111:0x00cf A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:54:0x00c4  */
        /* JADX WARN: Code duplicated, block: B:56:0x00ca  */
        @Override // com.alibaba.fastjson.JSONPath.Segment
        public void extract(com.alibaba.fastjson.JSONPath jSONPath, com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, com.alibaba.fastjson.JSONPath.Context context) {
            java.lang.Object objIntegerValue;
            java.lang.Object objIntegerValue2;
            com.alibaba.fastjson.JSONArray jSONArray;
            java.lang.Object objIntegerValue3;
            com.alibaba.fastjson.parser.JSONLexerBase jSONLexerBase = (com.alibaba.fastjson.parser.JSONLexerBase) defaultJSONParser.lexer;
            if (this.deep && context.object == null) {
                context.object = new com.alibaba.fastjson.JSONArray();
            }
            if (jSONLexerBase.token() == 14) {
                if ("*".equals(this.propertyName)) {
                    return;
                }
                jSONLexerBase.nextToken();
                if (this.deep) {
                    jSONArray = (com.alibaba.fastjson.JSONArray) context.object;
                } else {
                    jSONArray = new com.alibaba.fastjson.JSONArray();
                }
                while (true) {
                    int i = jSONLexerBase.token();
                    if (i != 12) {
                        if (i == 14) {
                            if (this.deep) {
                                extract(jSONPath, defaultJSONParser, context);
                            } else {
                                jSONLexerBase.skipObject(false);
                            }
                        } else {
                            switch (i) {
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                case 8:
                                    jSONLexerBase.nextToken();
                                default:
                                    if (jSONLexerBase.token() == 15) {
                                        jSONLexerBase.nextToken();
                                        if (!this.deep || jSONArray.size() <= 0) {
                                            return;
                                        }
                                        context.object = jSONArray;
                                        return;
                                    }
                                    if (jSONLexerBase.token() == 16) {
                                        jSONLexerBase.nextToken();
                                    } else {
                                        throw new com.alibaba.fastjson.JSONException("illegal json : " + jSONLexerBase.info());
                                    }
                                    break;
                                    break;
                            }
                        }
                    } else {
                        boolean z = this.deep;
                        if (z) {
                            extract(jSONPath, defaultJSONParser, context);
                        } else {
                            int iSeekObjectToField = jSONLexerBase.seekObjectToField(this.propertyNameHash, z);
                            if (iSeekObjectToField == 3) {
                                int i2 = jSONLexerBase.token();
                                if (i2 == 2) {
                                    objIntegerValue3 = jSONLexerBase.integerValue();
                                    jSONLexerBase.nextToken();
                                } else if (i2 == 4) {
                                    objIntegerValue3 = jSONLexerBase.stringVal();
                                    jSONLexerBase.nextToken();
                                } else {
                                    objIntegerValue3 = defaultJSONParser.parse();
                                }
                                jSONArray.add(objIntegerValue3);
                                if (jSONLexerBase.token() == 13) {
                                    jSONLexerBase.nextToken();
                                } else {
                                    jSONLexerBase.skipObject(false);
                                }
                            } else if (iSeekObjectToField == -1) {
                                continue;
                            } else {
                                if (this.deep) {
                                    throw new java.lang.UnsupportedOperationException(jSONLexerBase.info());
                                }
                                jSONLexerBase.skipObject(false);
                            }
                        }
                    }
                    if (jSONLexerBase.token() == 15) {
                        jSONLexerBase.nextToken();
                        if (this.deep) {
                            return;
                        } else {
                            return;
                        }
                    } else if (jSONLexerBase.token() == 16) {
                        jSONLexerBase.nextToken();
                    } else {
                        throw new com.alibaba.fastjson.JSONException("illegal json : " + jSONLexerBase.info());
                    }
                }
            } else {
                boolean z2 = this.deep;
                if (!z2) {
                    if (jSONLexerBase.seekObjectToField(this.propertyNameHash, z2) == 3 && context.eval) {
                        int i3 = jSONLexerBase.token();
                        if (i3 == 2) {
                            objIntegerValue2 = jSONLexerBase.integerValue();
                            jSONLexerBase.nextToken(16);
                        } else if (i3 == 3) {
                            objIntegerValue2 = jSONLexerBase.decimalValue();
                            jSONLexerBase.nextToken(16);
                        } else if (i3 == 4) {
                            objIntegerValue2 = jSONLexerBase.stringVal();
                            jSONLexerBase.nextToken(16);
                        } else {
                            objIntegerValue2 = defaultJSONParser.parse();
                        }
                        if (context.eval) {
                            context.object = objIntegerValue2;
                            return;
                        }
                        return;
                    }
                    return;
                }
                while (true) {
                    int iSeekObjectToField2 = jSONLexerBase.seekObjectToField(this.propertyNameHash, this.deep);
                    if (iSeekObjectToField2 == -1) {
                        return;
                    }
                    if (iSeekObjectToField2 == 3) {
                        if (context.eval) {
                            int i4 = jSONLexerBase.token();
                            if (i4 == 2) {
                                objIntegerValue = jSONLexerBase.integerValue();
                                jSONLexerBase.nextToken(16);
                            } else if (i4 == 3) {
                                objIntegerValue = jSONLexerBase.decimalValue();
                                jSONLexerBase.nextToken(16);
                            } else if (i4 == 4) {
                                objIntegerValue = jSONLexerBase.stringVal();
                                jSONLexerBase.nextToken(16);
                            } else {
                                objIntegerValue = defaultJSONParser.parse();
                            }
                            if (context.eval) {
                                if (context.object instanceof java.util.List) {
                                    java.util.List list = (java.util.List) context.object;
                                    if (list.size() == 0 && (objIntegerValue instanceof java.util.List)) {
                                        context.object = objIntegerValue;
                                    } else {
                                        list.add(objIntegerValue);
                                    }
                                } else {
                                    context.object = objIntegerValue;
                                }
                            }
                        }
                    } else if (iSeekObjectToField2 == 1 || iSeekObjectToField2 == 2) {
                        extract(jSONPath, defaultJSONParser, context);
                    }
                }
            }
        }

        public void setValue(com.alibaba.fastjson.JSONPath jSONPath, java.lang.Object obj, java.lang.Object obj2) {
            if (this.deep) {
                jSONPath.deepSet(obj, this.propertyName, this.propertyNameHash, obj2);
            } else {
                jSONPath.setPropertyValue(obj, this.propertyName, this.propertyNameHash, obj2);
            }
        }

        public boolean remove(com.alibaba.fastjson.JSONPath jSONPath, java.lang.Object obj) {
            return jSONPath.removePropertyValue(obj, this.propertyName, this.deep);
        }
    }

    static class MultiPropertySegment implements com.alibaba.fastjson.JSONPath.Segment {
        private final java.lang.String[] propertyNames;
        private final long[] propertyNamesHash;

        public MultiPropertySegment(java.lang.String[] strArr) {
            this.propertyNames = strArr;
            this.propertyNamesHash = new long[strArr.length];
            int i = 0;
            while (true) {
                long[] jArr = this.propertyNamesHash;
                if (i >= jArr.length) {
                    return;
                }
                jArr[i] = com.alibaba.fastjson.util.TypeUtils.fnv1a_64(strArr[i]);
                i++;
            }
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public java.lang.Object eval(com.alibaba.fastjson.JSONPath jSONPath, java.lang.Object obj, java.lang.Object obj2) {
            java.util.ArrayList arrayList = new java.util.ArrayList(this.propertyNames.length);
            int i = 0;
            while (true) {
                java.lang.String[] strArr = this.propertyNames;
                if (i >= strArr.length) {
                    return arrayList;
                }
                arrayList.add(jSONPath.getPropertyValue(obj2, strArr[i], this.propertyNamesHash[i]));
                i++;
            }
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public void extract(com.alibaba.fastjson.JSONPath jSONPath, com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, com.alibaba.fastjson.JSONPath.Context context) {
            com.alibaba.fastjson.JSONArray jSONArray;
            java.lang.Object objIntegerValue;
            com.alibaba.fastjson.parser.JSONLexerBase jSONLexerBase = (com.alibaba.fastjson.parser.JSONLexerBase) defaultJSONParser.lexer;
            if (context.object == null) {
                jSONArray = new com.alibaba.fastjson.JSONArray();
                context.object = jSONArray;
            } else {
                jSONArray = (com.alibaba.fastjson.JSONArray) context.object;
            }
            for (int size = jSONArray.size(); size < this.propertyNamesHash.length; size++) {
                jSONArray.add(null);
            }
            do {
                int iSeekObjectToField = jSONLexerBase.seekObjectToField(this.propertyNamesHash);
                if (jSONLexerBase.matchStat != 3) {
                    return;
                }
                int i = jSONLexerBase.token();
                if (i == 2) {
                    objIntegerValue = jSONLexerBase.integerValue();
                    jSONLexerBase.nextToken(16);
                } else if (i == 3) {
                    objIntegerValue = jSONLexerBase.decimalValue();
                    jSONLexerBase.nextToken(16);
                } else if (i == 4) {
                    objIntegerValue = jSONLexerBase.stringVal();
                    jSONLexerBase.nextToken(16);
                } else {
                    objIntegerValue = defaultJSONParser.parse();
                }
                jSONArray.set(iSeekObjectToField, objIntegerValue);
            } while (jSONLexerBase.token() == 16);
        }
    }

    static class WildCardSegment implements com.alibaba.fastjson.JSONPath.Segment {
        public static final com.alibaba.fastjson.JSONPath.WildCardSegment instance = new com.alibaba.fastjson.JSONPath.WildCardSegment(false, false);
        public static final com.alibaba.fastjson.JSONPath.WildCardSegment instance_deep = new com.alibaba.fastjson.JSONPath.WildCardSegment(true, false);
        public static final com.alibaba.fastjson.JSONPath.WildCardSegment instance_deep_objectOnly = new com.alibaba.fastjson.JSONPath.WildCardSegment(true, true);
        private boolean deep;
        private boolean objectOnly;

        private WildCardSegment(boolean z, boolean z2) {
            this.deep = z;
            this.objectOnly = z2;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public java.lang.Object eval(com.alibaba.fastjson.JSONPath jSONPath, java.lang.Object obj, java.lang.Object obj2) {
            if (!this.deep) {
                return jSONPath.getPropertyValues(obj2);
            }
            java.util.ArrayList arrayList = new java.util.ArrayList();
            jSONPath.deepGetPropertyValues(obj2, arrayList);
            return arrayList;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public void extract(com.alibaba.fastjson.JSONPath jSONPath, com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, com.alibaba.fastjson.JSONPath.Context context) {
            if (context.eval) {
                java.lang.Object obj = defaultJSONParser.parse();
                if (this.deep) {
                    java.util.ArrayList arrayList = new java.util.ArrayList();
                    if (this.objectOnly) {
                        jSONPath.deepGetObjects(obj, arrayList);
                    } else {
                        jSONPath.deepGetPropertyValues(obj, arrayList);
                    }
                    context.object = arrayList;
                    return;
                }
                if (obj instanceof com.alibaba.fastjson.JSONObject) {
                    java.util.Collection<?> collectionValues = ((com.alibaba.fastjson.JSONObject) obj).values();
                    com.alibaba.fastjson.JSONArray jSONArray = new com.alibaba.fastjson.JSONArray(collectionValues.size());
                    jSONArray.addAll(collectionValues);
                    context.object = jSONArray;
                    return;
                }
                if (obj instanceof com.alibaba.fastjson.JSONArray) {
                    context.object = obj;
                    return;
                }
            }
            throw new com.alibaba.fastjson.JSONException("TODO");
        }
    }

    static class ArrayAccessSegment implements com.alibaba.fastjson.JSONPath.Segment {
        private final int index;

        public ArrayAccessSegment(int i) {
            this.index = i;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public java.lang.Object eval(com.alibaba.fastjson.JSONPath jSONPath, java.lang.Object obj, java.lang.Object obj2) {
            return jSONPath.getArrayItem(obj2, this.index);
        }

        public boolean setValue(com.alibaba.fastjson.JSONPath jSONPath, java.lang.Object obj, java.lang.Object obj2) {
            return jSONPath.setArrayItem(jSONPath, obj, this.index, obj2);
        }

        public boolean remove(com.alibaba.fastjson.JSONPath jSONPath, java.lang.Object obj) {
            return jSONPath.removeArrayItem(jSONPath, obj, this.index);
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public void extract(com.alibaba.fastjson.JSONPath jSONPath, com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, com.alibaba.fastjson.JSONPath.Context context) {
            if (((com.alibaba.fastjson.parser.JSONLexerBase) defaultJSONParser.lexer).seekArrayToItem(this.index) && context.eval) {
                context.object = defaultJSONParser.parse();
            }
        }
    }

    static class MultiIndexSegment implements com.alibaba.fastjson.JSONPath.Segment {
        private final int[] indexes;

        public MultiIndexSegment(int[] iArr) {
            this.indexes = iArr;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public java.lang.Object eval(com.alibaba.fastjson.JSONPath jSONPath, java.lang.Object obj, java.lang.Object obj2) {
            com.alibaba.fastjson.JSONArray jSONArray = new com.alibaba.fastjson.JSONArray(this.indexes.length);
            int i = 0;
            while (true) {
                int[] iArr = this.indexes;
                if (i >= iArr.length) {
                    return jSONArray;
                }
                jSONArray.add(jSONPath.getArrayItem(obj2, iArr[i]));
                i++;
            }
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public void extract(com.alibaba.fastjson.JSONPath jSONPath, com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, com.alibaba.fastjson.JSONPath.Context context) {
            if (context.eval) {
                java.lang.Object obj = defaultJSONParser.parse();
                if (obj instanceof java.util.List) {
                    int[] iArr = this.indexes;
                    int length = iArr.length;
                    int[] iArr2 = new int[length];
                    java.lang.System.arraycopy(iArr, 0, iArr2, 0, length);
                    java.util.List list = (java.util.List) obj;
                    if (iArr2[0] >= 0) {
                        for (int size = list.size() - 1; size >= 0; size--) {
                            if (java.util.Arrays.binarySearch(iArr2, size) < 0) {
                                list.remove(size);
                            }
                        }
                        context.object = list;
                        return;
                    }
                }
            }
            throw new java.lang.UnsupportedOperationException();
        }
    }

    static class RangeSegment implements com.alibaba.fastjson.JSONPath.Segment {
        private final int end;
        private final int start;
        private final int step;

        public RangeSegment(int i, int i2, int i3) {
            this.start = i;
            this.end = i2;
            this.step = i3;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public java.lang.Object eval(com.alibaba.fastjson.JSONPath jSONPath, java.lang.Object obj, java.lang.Object obj2) {
            int iIntValue = com.alibaba.fastjson.JSONPath.SizeSegment.instance.eval(jSONPath, obj, obj2).intValue();
            int i = this.start;
            if (i < 0) {
                i += iIntValue;
            }
            int i2 = this.end;
            if (i2 < 0) {
                i2 += iIntValue;
            }
            int i3 = ((i2 - i) / this.step) + 1;
            if (i3 == -1) {
                return null;
            }
            java.util.ArrayList arrayList = new java.util.ArrayList(i3);
            while (i <= i2 && i < iIntValue) {
                arrayList.add(jSONPath.getArrayItem(obj2, i));
                i += this.step;
            }
            return arrayList;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public void extract(com.alibaba.fastjson.JSONPath jSONPath, com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, com.alibaba.fastjson.JSONPath.Context context) {
            throw new java.lang.UnsupportedOperationException();
        }
    }

    static class NotNullSegement extends com.alibaba.fastjson.JSONPath.PropertyFilter {
        public NotNullSegement(java.lang.String str, boolean z) {
            super(str, z);
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(com.alibaba.fastjson.JSONPath jSONPath, java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3) {
            return jSONPath.getPropertyValue(obj3, this.propertyName, this.propertyNameHash) != null;
        }
    }

    static class NullSegement extends com.alibaba.fastjson.JSONPath.PropertyFilter {
        public NullSegement(java.lang.String str, boolean z) {
            super(str, z);
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(com.alibaba.fastjson.JSONPath jSONPath, java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3) {
            return get(jSONPath, obj, obj3) == null;
        }
    }

    static class ValueSegment extends com.alibaba.fastjson.JSONPath.PropertyFilter {
        private boolean eq;
        private final java.lang.Object value;

        public ValueSegment(java.lang.String str, boolean z, java.lang.Object obj, boolean z2) {
            super(str, z);
            this.eq = true;
            if (obj == null) {
                throw new java.lang.IllegalArgumentException("value is null");
            }
            this.value = obj;
            this.eq = z2;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(com.alibaba.fastjson.JSONPath jSONPath, java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3) {
            boolean zEquals = this.value.equals(get(jSONPath, obj, obj3));
            return !this.eq ? !zEquals : zEquals;
        }
    }

    static class IntInSegement extends com.alibaba.fastjson.JSONPath.PropertyFilter {
        private final boolean not;
        private final long[] values;

        public IntInSegement(java.lang.String str, boolean z, long[] jArr, boolean z2) {
            super(str, z);
            this.values = jArr;
            this.not = z2;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(com.alibaba.fastjson.JSONPath jSONPath, java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3) {
            java.lang.Object obj4 = get(jSONPath, obj, obj3);
            if (obj4 == null) {
                return false;
            }
            if (obj4 instanceof java.lang.Number) {
                long jLongExtractValue = com.alibaba.fastjson.util.TypeUtils.longExtractValue((java.lang.Number) obj4);
                for (long j : this.values) {
                    if (j == jLongExtractValue) {
                        return !this.not;
                    }
                }
            }
            return this.not;
        }
    }

    static class IntBetweenSegement extends com.alibaba.fastjson.JSONPath.PropertyFilter {
        private final long endValue;
        private final boolean not;
        private final long startValue;

        public IntBetweenSegement(java.lang.String str, boolean z, long j, long j2, boolean z2) {
            super(str, z);
            this.startValue = j;
            this.endValue = j2;
            this.not = z2;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(com.alibaba.fastjson.JSONPath jSONPath, java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3) {
            java.lang.Object obj4 = get(jSONPath, obj, obj3);
            if (obj4 == null) {
                return false;
            }
            if (obj4 instanceof java.lang.Number) {
                long jLongExtractValue = com.alibaba.fastjson.util.TypeUtils.longExtractValue((java.lang.Number) obj4);
                if (jLongExtractValue >= this.startValue && jLongExtractValue <= this.endValue) {
                    return !this.not;
                }
            }
            return this.not;
        }
    }

    static class IntObjInSegement extends com.alibaba.fastjson.JSONPath.PropertyFilter {
        private final boolean not;
        private final java.lang.Long[] values;

        public IntObjInSegement(java.lang.String str, boolean z, java.lang.Long[] lArr, boolean z2) {
            super(str, z);
            this.values = lArr;
            this.not = z2;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(com.alibaba.fastjson.JSONPath jSONPath, java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3) {
            boolean z;
            java.lang.Object obj4 = get(jSONPath, obj, obj3);
            int i = 0;
            if (obj4 == null) {
                java.lang.Long[] lArr = this.values;
                int length = lArr.length;
                while (i < length) {
                    if (lArr[i] == null) {
                        z = this.not;
                    } else {
                        i++;
                    }
                }
                return this.not;
            }
            if (obj4 instanceof java.lang.Number) {
                long jLongExtractValue = com.alibaba.fastjson.util.TypeUtils.longExtractValue((java.lang.Number) obj4);
                java.lang.Long[] lArr2 = this.values;
                int length2 = lArr2.length;
                while (i < length2) {
                    java.lang.Long l = lArr2[i];
                    if (l != null && l.longValue() == jLongExtractValue) {
                        z = this.not;
                    } else {
                        i++;
                    }
                }
            }
            return this.not;
            return !z;
        }
    }

    static class StringInSegement extends com.alibaba.fastjson.JSONPath.PropertyFilter {
        private final boolean not;
        private final java.lang.String[] values;

        public StringInSegement(java.lang.String str, boolean z, java.lang.String[] strArr, boolean z2) {
            super(str, z);
            this.values = strArr;
            this.not = z2;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(com.alibaba.fastjson.JSONPath jSONPath, java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3) {
            boolean z;
            java.lang.Object obj4 = get(jSONPath, obj, obj3);
            for (java.lang.String str : this.values) {
                if (str == obj4) {
                    z = this.not;
                } else if (str != null && str.equals(obj4)) {
                    z = this.not;
                }
                return !z;
            }
            return this.not;
        }
    }

    static class IntOpSegement extends com.alibaba.fastjson.JSONPath.PropertyFilter {
        private final com.alibaba.fastjson.JSONPath.Operator op;
        private final long value;
        private java.math.BigDecimal valueDecimal;
        private java.lang.Double valueDouble;
        private java.lang.Float valueFloat;

        public IntOpSegement(java.lang.String str, boolean z, long j, com.alibaba.fastjson.JSONPath.Operator operator) {
            super(str, z);
            this.value = j;
            this.op = operator;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(com.alibaba.fastjson.JSONPath jSONPath, java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3) {
            java.lang.Object obj4 = get(jSONPath, obj, obj3);
            if (obj4 == null || !(obj4 instanceof java.lang.Number)) {
                return false;
            }
            if (obj4 instanceof java.math.BigDecimal) {
                if (this.valueDecimal == null) {
                    this.valueDecimal = java.math.BigDecimal.valueOf(this.value);
                }
                int iCompareTo = this.valueDecimal.compareTo((java.math.BigDecimal) obj4);
                switch (com.alibaba.fastjson.JSONPath.AnonymousClass1.$SwitchMap$com$alibaba$fastjson$JSONPath$Operator[this.op.ordinal()]) {
                    case 1:
                        return iCompareTo == 0;
                    case 2:
                        return iCompareTo != 0;
                    case 3:
                        return iCompareTo <= 0;
                    case 4:
                        return iCompareTo < 0;
                    case 5:
                        return iCompareTo >= 0;
                    case 6:
                        return iCompareTo > 0;
                    default:
                        return false;
                }
            }
            if (obj4 instanceof java.lang.Float) {
                if (this.valueFloat == null) {
                    this.valueFloat = java.lang.Float.valueOf(this.value);
                }
                int iCompareTo2 = this.valueFloat.compareTo((java.lang.Float) obj4);
                switch (com.alibaba.fastjson.JSONPath.AnonymousClass1.$SwitchMap$com$alibaba$fastjson$JSONPath$Operator[this.op.ordinal()]) {
                    case 1:
                        return iCompareTo2 == 0;
                    case 2:
                        return iCompareTo2 != 0;
                    case 3:
                        return iCompareTo2 <= 0;
                    case 4:
                        return iCompareTo2 < 0;
                    case 5:
                        return iCompareTo2 >= 0;
                    case 6:
                        return iCompareTo2 > 0;
                    default:
                        return false;
                }
            }
            if (obj4 instanceof java.lang.Double) {
                if (this.valueDouble == null) {
                    this.valueDouble = java.lang.Double.valueOf(this.value);
                }
                int iCompareTo3 = this.valueDouble.compareTo((java.lang.Double) obj4);
                switch (com.alibaba.fastjson.JSONPath.AnonymousClass1.$SwitchMap$com$alibaba$fastjson$JSONPath$Operator[this.op.ordinal()]) {
                    case 1:
                        return iCompareTo3 == 0;
                    case 2:
                        return iCompareTo3 != 0;
                    case 3:
                        return iCompareTo3 <= 0;
                    case 4:
                        return iCompareTo3 < 0;
                    case 5:
                        return iCompareTo3 >= 0;
                    case 6:
                        return iCompareTo3 > 0;
                    default:
                        return false;
                }
            }
            long jLongExtractValue = com.alibaba.fastjson.util.TypeUtils.longExtractValue((java.lang.Number) obj4);
            switch (com.alibaba.fastjson.JSONPath.AnonymousClass1.$SwitchMap$com$alibaba$fastjson$JSONPath$Operator[this.op.ordinal()]) {
                case 1:
                    return jLongExtractValue == this.value;
                case 2:
                    return jLongExtractValue != this.value;
                case 3:
                    return jLongExtractValue >= this.value;
                case 4:
                    return jLongExtractValue > this.value;
                case 5:
                    return jLongExtractValue <= this.value;
                case 6:
                    return jLongExtractValue < this.value;
                default:
                    return false;
            }
        }
    }

    /* JADX INFO: renamed from: com.alibaba.fastjson.JSONPath$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$alibaba$fastjson$JSONPath$Operator;

        static {
            int[] iArr = new int[com.alibaba.fastjson.JSONPath.Operator.values().length];
            $SwitchMap$com$alibaba$fastjson$JSONPath$Operator = iArr;
            try {
                iArr[com.alibaba.fastjson.JSONPath.Operator.EQ.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$alibaba$fastjson$JSONPath$Operator[com.alibaba.fastjson.JSONPath.Operator.NE.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$alibaba$fastjson$JSONPath$Operator[com.alibaba.fastjson.JSONPath.Operator.GE.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$alibaba$fastjson$JSONPath$Operator[com.alibaba.fastjson.JSONPath.Operator.GT.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$alibaba$fastjson$JSONPath$Operator[com.alibaba.fastjson.JSONPath.Operator.LE.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$alibaba$fastjson$JSONPath$Operator[com.alibaba.fastjson.JSONPath.Operator.LT.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
        }
    }

    static abstract class PropertyFilter implements com.alibaba.fastjson.JSONPath.Filter {
        static long TYPE = com.alibaba.fastjson.util.TypeUtils.fnv1a_64("type");
        protected final boolean function;
        protected com.alibaba.fastjson.JSONPath.Segment functionExpr;
        protected final java.lang.String propertyName;
        protected final long propertyNameHash;

        protected PropertyFilter(java.lang.String str, boolean z) {
            this.propertyName = str;
            long jFnv1a_64 = com.alibaba.fastjson.util.TypeUtils.fnv1a_64(str);
            this.propertyNameHash = jFnv1a_64;
            this.function = z;
            if (z) {
                if (jFnv1a_64 == TYPE) {
                    this.functionExpr = com.alibaba.fastjson.JSONPath.TypeSegment.instance;
                } else if (jFnv1a_64 == com.alibaba.fastjson.JSONPath.SIZE) {
                    this.functionExpr = com.alibaba.fastjson.JSONPath.SizeSegment.instance;
                } else {
                    throw new com.alibaba.fastjson.JSONPathException("unsupported funciton : " + str);
                }
            }
        }

        protected java.lang.Object get(com.alibaba.fastjson.JSONPath jSONPath, java.lang.Object obj, java.lang.Object obj2) {
            com.alibaba.fastjson.JSONPath.Segment segment = this.functionExpr;
            if (segment != null) {
                return segment.eval(jSONPath, obj, obj2);
            }
            return jSONPath.getPropertyValue(obj2, this.propertyName, this.propertyNameHash);
        }
    }

    static class DoubleOpSegement extends com.alibaba.fastjson.JSONPath.PropertyFilter {
        private final com.alibaba.fastjson.JSONPath.Operator op;
        private final double value;

        public DoubleOpSegement(java.lang.String str, boolean z, double d, com.alibaba.fastjson.JSONPath.Operator operator) {
            super(str, z);
            this.value = d;
            this.op = operator;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(com.alibaba.fastjson.JSONPath jSONPath, java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3) {
            java.lang.Object obj4 = get(jSONPath, obj, obj3);
            if (obj4 == null || !(obj4 instanceof java.lang.Number)) {
                return false;
            }
            double dDoubleValue = ((java.lang.Number) obj4).doubleValue();
            switch (com.alibaba.fastjson.JSONPath.AnonymousClass1.$SwitchMap$com$alibaba$fastjson$JSONPath$Operator[this.op.ordinal()]) {
                case 1:
                    return dDoubleValue == this.value;
                case 2:
                    return dDoubleValue != this.value;
                case 3:
                    return dDoubleValue >= this.value;
                case 4:
                    return dDoubleValue > this.value;
                case 5:
                    return dDoubleValue <= this.value;
                case 6:
                    return dDoubleValue < this.value;
                default:
                    return false;
            }
        }
    }

    static class RefOpSegement extends com.alibaba.fastjson.JSONPath.PropertyFilter {
        private final com.alibaba.fastjson.JSONPath.Operator op;
        private final com.alibaba.fastjson.JSONPath.Segment refSgement;

        public RefOpSegement(java.lang.String str, boolean z, com.alibaba.fastjson.JSONPath.Segment segment, com.alibaba.fastjson.JSONPath.Operator operator) {
            super(str, z);
            this.refSgement = segment;
            this.op = operator;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(com.alibaba.fastjson.JSONPath jSONPath, java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3) {
            java.lang.Object obj4 = get(jSONPath, obj, obj3);
            if (obj4 == null || !(obj4 instanceof java.lang.Number)) {
                return false;
            }
            java.lang.Object objEval = this.refSgement.eval(jSONPath, obj, obj);
            if ((objEval instanceof java.lang.Integer) || (objEval instanceof java.lang.Long) || (objEval instanceof java.lang.Short) || (objEval instanceof java.lang.Byte)) {
                long jLongExtractValue = com.alibaba.fastjson.util.TypeUtils.longExtractValue((java.lang.Number) objEval);
                if ((obj4 instanceof java.lang.Integer) || (obj4 instanceof java.lang.Long) || (obj4 instanceof java.lang.Short) || (obj4 instanceof java.lang.Byte)) {
                    long jLongExtractValue2 = com.alibaba.fastjson.util.TypeUtils.longExtractValue((java.lang.Number) obj4);
                    switch (com.alibaba.fastjson.JSONPath.AnonymousClass1.$SwitchMap$com$alibaba$fastjson$JSONPath$Operator[this.op.ordinal()]) {
                        case 1:
                            return jLongExtractValue2 == jLongExtractValue;
                        case 2:
                            return jLongExtractValue2 != jLongExtractValue;
                        case 3:
                            return jLongExtractValue2 >= jLongExtractValue;
                        case 4:
                            return jLongExtractValue2 > jLongExtractValue;
                        case 5:
                            return jLongExtractValue2 <= jLongExtractValue;
                        case 6:
                            return jLongExtractValue2 < jLongExtractValue;
                    }
                }
                if (obj4 instanceof java.math.BigDecimal) {
                    int iCompareTo = java.math.BigDecimal.valueOf(jLongExtractValue).compareTo((java.math.BigDecimal) obj4);
                    switch (com.alibaba.fastjson.JSONPath.AnonymousClass1.$SwitchMap$com$alibaba$fastjson$JSONPath$Operator[this.op.ordinal()]) {
                        case 1:
                            return iCompareTo == 0;
                        case 2:
                            return iCompareTo != 0;
                        case 3:
                            return iCompareTo <= 0;
                        case 4:
                            return iCompareTo < 0;
                        case 5:
                            return iCompareTo >= 0;
                        case 6:
                            return iCompareTo > 0;
                        default:
                            return false;
                    }
                }
            }
            throw new java.lang.UnsupportedOperationException();
        }
    }

    static class MatchSegement extends com.alibaba.fastjson.JSONPath.PropertyFilter {
        private final java.lang.String[] containsValues;
        private final java.lang.String endsWithValue;
        private final int minLength;
        private final boolean not;
        private final java.lang.String startsWithValue;

        public MatchSegement(java.lang.String str, boolean z, java.lang.String str2, java.lang.String str3, java.lang.String[] strArr, boolean z2) {
            super(str, z);
            this.startsWithValue = str2;
            this.endsWithValue = str3;
            this.containsValues = strArr;
            this.not = z2;
            int length = str2 != null ? str2.length() : 0;
            length = str3 != null ? length + str3.length() : length;
            if (strArr != null) {
                for (java.lang.String str4 : strArr) {
                    length += str4.length();
                }
            }
            this.minLength = length;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(com.alibaba.fastjson.JSONPath jSONPath, java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3) {
            int length;
            java.lang.Object obj4 = get(jSONPath, obj, obj3);
            if (obj4 == null) {
                return false;
            }
            java.lang.String string = obj4.toString();
            if (string.length() < this.minLength) {
                return this.not;
            }
            java.lang.String str = this.startsWithValue;
            if (str == null) {
                length = 0;
            } else {
                if (!string.startsWith(str)) {
                    return this.not;
                }
                length = this.startsWithValue.length();
            }
            java.lang.String[] strArr = this.containsValues;
            if (strArr != null) {
                for (java.lang.String str2 : strArr) {
                    int iIndexOf = string.indexOf(str2, length);
                    if (iIndexOf == -1) {
                        return this.not;
                    }
                    length = iIndexOf + str2.length();
                }
            }
            java.lang.String str3 = this.endsWithValue;
            if (str3 != null && !string.endsWith(str3)) {
                return this.not;
            }
            return !this.not;
        }
    }

    static class RlikeSegement extends com.alibaba.fastjson.JSONPath.PropertyFilter {
        private final boolean not;
        private final java.util.regex.Pattern pattern;

        public RlikeSegement(java.lang.String str, boolean z, java.lang.String str2, boolean z2) {
            super(str, z);
            this.pattern = java.util.regex.Pattern.compile(str2);
            this.not = z2;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(com.alibaba.fastjson.JSONPath jSONPath, java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3) {
            java.lang.Object obj4 = get(jSONPath, obj, obj3);
            if (obj4 == null) {
                return false;
            }
            boolean zMatches = this.pattern.matcher(obj4.toString()).matches();
            return this.not ? !zMatches : zMatches;
        }
    }

    static class StringOpSegement extends com.alibaba.fastjson.JSONPath.PropertyFilter {
        private final com.alibaba.fastjson.JSONPath.Operator op;
        private final java.lang.String value;

        public StringOpSegement(java.lang.String str, boolean z, java.lang.String str2, com.alibaba.fastjson.JSONPath.Operator operator) {
            super(str, z);
            this.value = str2;
            this.op = operator;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(com.alibaba.fastjson.JSONPath jSONPath, java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3) {
            java.lang.Object obj4 = get(jSONPath, obj, obj3);
            if (this.op == com.alibaba.fastjson.JSONPath.Operator.EQ) {
                return this.value.equals(obj4);
            }
            if (this.op == com.alibaba.fastjson.JSONPath.Operator.NE) {
                return !this.value.equals(obj4);
            }
            if (obj4 == null) {
                return false;
            }
            int iCompareTo = this.value.compareTo(obj4.toString());
            if (this.op == com.alibaba.fastjson.JSONPath.Operator.GE) {
                return iCompareTo <= 0;
            }
            if (this.op == com.alibaba.fastjson.JSONPath.Operator.GT) {
                return iCompareTo < 0;
            }
            if (this.op == com.alibaba.fastjson.JSONPath.Operator.LE) {
                return iCompareTo >= 0;
            }
            return this.op == com.alibaba.fastjson.JSONPath.Operator.LT && iCompareTo > 0;
        }
    }

    static class RegMatchSegement extends com.alibaba.fastjson.JSONPath.PropertyFilter {
        private final com.alibaba.fastjson.JSONPath.Operator op;
        private final java.util.regex.Pattern pattern;

        public RegMatchSegement(java.lang.String str, boolean z, java.util.regex.Pattern pattern, com.alibaba.fastjson.JSONPath.Operator operator) {
            super(str, z);
            this.pattern = pattern;
            this.op = operator;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(com.alibaba.fastjson.JSONPath jSONPath, java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3) {
            java.lang.Object obj4 = get(jSONPath, obj, obj3);
            if (obj4 == null) {
                return false;
            }
            return this.pattern.matcher(obj4.toString()).matches();
        }
    }

    public static class FilterSegment implements com.alibaba.fastjson.JSONPath.Segment {
        private final com.alibaba.fastjson.JSONPath.Filter filter;

        public FilterSegment(com.alibaba.fastjson.JSONPath.Filter filter) {
            this.filter = filter;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public java.lang.Object eval(com.alibaba.fastjson.JSONPath jSONPath, java.lang.Object obj, java.lang.Object obj2) {
            if (obj2 == null) {
                return null;
            }
            com.alibaba.fastjson.JSONArray jSONArray = new com.alibaba.fastjson.JSONArray();
            if (obj2 instanceof java.lang.Iterable) {
                for (java.lang.Object obj3 : (java.lang.Iterable) obj2) {
                    if (this.filter.apply(jSONPath, obj, obj2, obj3)) {
                        jSONArray.add(obj3);
                    }
                }
                return jSONArray;
            }
            if (this.filter.apply(jSONPath, obj, obj2, obj2)) {
                return obj2;
            }
            return null;
        }

        @Override // com.alibaba.fastjson.JSONPath.Segment
        public void extract(com.alibaba.fastjson.JSONPath jSONPath, com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, com.alibaba.fastjson.JSONPath.Context context) {
            java.lang.Object obj = defaultJSONParser.parse();
            context.object = eval(jSONPath, obj, obj);
        }

        public boolean remove(com.alibaba.fastjson.JSONPath jSONPath, java.lang.Object obj, java.lang.Object obj2) {
            if (obj2 == null || !(obj2 instanceof java.lang.Iterable)) {
                return false;
            }
            java.util.Iterator it = ((java.lang.Iterable) obj2).iterator();
            while (it.hasNext()) {
                if (this.filter.apply(jSONPath, obj, obj2, it.next())) {
                    it.remove();
                }
            }
            return true;
        }
    }

    static class FilterGroup implements com.alibaba.fastjson.JSONPath.Filter {
        private boolean and;
        private java.util.List<com.alibaba.fastjson.JSONPath.Filter> fitlers;

        public FilterGroup(com.alibaba.fastjson.JSONPath.Filter filter, com.alibaba.fastjson.JSONPath.Filter filter2, boolean z) {
            java.util.ArrayList arrayList = new java.util.ArrayList(2);
            this.fitlers = arrayList;
            arrayList.add(filter);
            this.fitlers.add(filter2);
            this.and = z;
        }

        @Override // com.alibaba.fastjson.JSONPath.Filter
        public boolean apply(com.alibaba.fastjson.JSONPath jSONPath, java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3) {
            if (this.and) {
                java.util.Iterator<com.alibaba.fastjson.JSONPath.Filter> it = this.fitlers.iterator();
                while (it.hasNext()) {
                    if (!it.next().apply(jSONPath, obj, obj2, obj3)) {
                        return false;
                    }
                }
                return true;
            }
            java.util.Iterator<com.alibaba.fastjson.JSONPath.Filter> it2 = this.fitlers.iterator();
            while (it2.hasNext()) {
                if (it2.next().apply(jSONPath, obj, obj2, obj3)) {
                    return true;
                }
            }
            return false;
        }
    }

    protected java.lang.Object getArrayItem(java.lang.Object obj, int i) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof java.util.List) {
            java.util.List list = (java.util.List) obj;
            if (i >= 0) {
                if (i < list.size()) {
                    return list.get(i);
                }
                return null;
            }
            if (java.lang.Math.abs(i) <= list.size()) {
                return list.get(list.size() + i);
            }
            return null;
        }
        if (obj.getClass().isArray()) {
            int length = java.lang.reflect.Array.getLength(obj);
            if (i >= 0) {
                if (i < length) {
                    return java.lang.reflect.Array.get(obj, i);
                }
                return null;
            }
            if (java.lang.Math.abs(i) <= length) {
                return java.lang.reflect.Array.get(obj, length + i);
            }
            return null;
        }
        if (obj instanceof java.util.Map) {
            java.util.Map map = (java.util.Map) obj;
            java.lang.Object obj2 = map.get(java.lang.Integer.valueOf(i));
            return obj2 == null ? map.get(java.lang.Integer.toString(i)) : obj2;
        }
        if (!(obj instanceof java.util.Collection)) {
            if (i == 0) {
                return obj;
            }
            throw new java.lang.UnsupportedOperationException();
        }
        int i2 = 0;
        for (java.lang.Object obj3 : (java.util.Collection) obj) {
            if (i2 == i) {
                return obj3;
            }
            i2++;
        }
        return null;
    }

    public boolean setArrayItem(com.alibaba.fastjson.JSONPath jSONPath, java.lang.Object obj, int i, java.lang.Object obj2) {
        if (obj instanceof java.util.List) {
            java.util.List list = (java.util.List) obj;
            if (i >= 0) {
                list.set(i, obj2);
            } else {
                list.set(list.size() + i, obj2);
            }
            return true;
        }
        java.lang.Class<?> cls = obj.getClass();
        if (cls.isArray()) {
            int length = java.lang.reflect.Array.getLength(obj);
            if (i >= 0) {
                if (i < length) {
                    java.lang.reflect.Array.set(obj, i, obj2);
                }
            } else if (java.lang.Math.abs(i) <= length) {
                java.lang.reflect.Array.set(obj, length + i, obj2);
            }
            return true;
        }
        throw new com.alibaba.fastjson.JSONPathException("unsupported set operation." + cls);
    }

    public boolean removeArrayItem(com.alibaba.fastjson.JSONPath jSONPath, java.lang.Object obj, int i) {
        if (obj instanceof java.util.List) {
            java.util.List list = (java.util.List) obj;
            if (i >= 0) {
                if (i >= list.size()) {
                    return false;
                }
                list.remove(i);
                return true;
            }
            int size = list.size() + i;
            if (size < 0) {
                return false;
            }
            list.remove(size);
            return true;
        }
        throw new com.alibaba.fastjson.JSONPathException("unsupported set operation." + obj.getClass());
    }

    protected java.util.Collection<java.lang.Object> getPropertyValues(java.lang.Object obj) {
        if (obj == null) {
            return null;
        }
        com.alibaba.fastjson.serializer.JavaBeanSerializer javaBeanSerializer = getJavaBeanSerializer(obj.getClass());
        if (javaBeanSerializer != null) {
            try {
                return javaBeanSerializer.getFieldValues(obj);
            } catch (java.lang.Exception e) {
                throw new com.alibaba.fastjson.JSONPathException("jsonpath error, path " + this.path, e);
            }
        }
        if (obj instanceof java.util.Map) {
            return ((java.util.Map) obj).values();
        }
        if (obj instanceof java.util.Collection) {
            return (java.util.Collection) obj;
        }
        throw new java.lang.UnsupportedOperationException();
    }

    protected void deepGetObjects(java.lang.Object obj, java.util.List<java.lang.Object> list) {
        java.util.Collection fieldValues;
        java.lang.Class<?> cls = obj.getClass();
        com.alibaba.fastjson.serializer.JavaBeanSerializer javaBeanSerializer = getJavaBeanSerializer(cls);
        if (javaBeanSerializer != null) {
            try {
                fieldValues = javaBeanSerializer.getFieldValues(obj);
                list.add(obj);
            } catch (java.lang.Exception e) {
                throw new com.alibaba.fastjson.JSONPathException("jsonpath error, path " + this.path, e);
            }
        } else if (obj instanceof java.util.Map) {
            list.add(obj);
            fieldValues = ((java.util.Map) obj).values();
        } else {
            fieldValues = obj instanceof java.util.Collection ? (java.util.Collection) obj : null;
        }
        if (fieldValues != null) {
            for (java.lang.Object obj2 : fieldValues) {
                if (obj2 != null && !com.alibaba.fastjson.parser.ParserConfig.isPrimitive2(obj2.getClass())) {
                    deepGetObjects(obj2, list);
                }
            }
            return;
        }
        throw new java.lang.UnsupportedOperationException(cls.getName());
    }

    protected void deepGetPropertyValues(java.lang.Object obj, java.util.List<java.lang.Object> list) {
        java.util.Collection fieldValues;
        java.lang.Class<?> cls = obj.getClass();
        com.alibaba.fastjson.serializer.JavaBeanSerializer javaBeanSerializer = getJavaBeanSerializer(cls);
        if (javaBeanSerializer != null) {
            try {
                fieldValues = javaBeanSerializer.getFieldValues(obj);
            } catch (java.lang.Exception e) {
                throw new com.alibaba.fastjson.JSONPathException("jsonpath error, path " + this.path, e);
            }
        } else if (obj instanceof java.util.Map) {
            fieldValues = ((java.util.Map) obj).values();
        } else {
            fieldValues = obj instanceof java.util.Collection ? (java.util.Collection) obj : null;
        }
        if (fieldValues != null) {
            for (java.lang.Object obj2 : fieldValues) {
                if (obj2 == null || com.alibaba.fastjson.parser.ParserConfig.isPrimitive2(obj2.getClass())) {
                    list.add(obj2);
                } else {
                    deepGetPropertyValues(obj2, list);
                }
            }
            return;
        }
        throw new java.lang.UnsupportedOperationException(cls.getName());
    }

    static boolean eq(java.lang.Object obj, java.lang.Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        if (obj.getClass() == obj2.getClass()) {
            return obj.equals(obj2);
        }
        if (obj instanceof java.lang.Number) {
            if (obj2 instanceof java.lang.Number) {
                return eqNotNull((java.lang.Number) obj, (java.lang.Number) obj2);
            }
            return false;
        }
        return obj.equals(obj2);
    }

    static boolean eqNotNull(java.lang.Number number, java.lang.Number number2) {
        java.lang.Class<?> cls = number.getClass();
        boolean zIsInt = isInt(cls);
        java.lang.Class<?> cls2 = number2.getClass();
        boolean zIsInt2 = isInt(cls2);
        if (number instanceof java.math.BigDecimal) {
            java.math.BigDecimal bigDecimal = (java.math.BigDecimal) number;
            if (zIsInt2) {
                return bigDecimal.equals(java.math.BigDecimal.valueOf(com.alibaba.fastjson.util.TypeUtils.longExtractValue(number2)));
            }
        }
        if (zIsInt) {
            if (zIsInt2) {
                return number.longValue() == number2.longValue();
            }
            if (number2 instanceof java.math.BigInteger) {
                return java.math.BigInteger.valueOf(number.longValue()).equals((java.math.BigInteger) number);
            }
        }
        if (zIsInt2 && (number instanceof java.math.BigInteger)) {
            return ((java.math.BigInteger) number).equals(java.math.BigInteger.valueOf(com.alibaba.fastjson.util.TypeUtils.longExtractValue(number2)));
        }
        boolean zIsDouble = isDouble(cls);
        boolean zIsDouble2 = isDouble(cls2);
        return ((zIsDouble && zIsDouble2) || ((zIsDouble && zIsInt2) || (zIsDouble2 && zIsInt))) && number.doubleValue() == number2.doubleValue();
    }

    protected static boolean isDouble(java.lang.Class<?> cls) {
        return cls == java.lang.Float.class || cls == java.lang.Double.class;
    }

    protected static boolean isInt(java.lang.Class<?> cls) {
        return cls == java.lang.Byte.class || cls == java.lang.Short.class || cls == java.lang.Integer.class || cls == java.lang.Long.class;
    }

    protected java.lang.Object getPropertyValue(java.lang.Object obj, java.lang.String str, long j) {
        java.lang.Object obj2;
        com.alibaba.fastjson.JSONArray jSONArray = null;
        if (obj == null) {
            return null;
        }
        if (obj instanceof java.lang.String) {
            try {
                obj2 = (com.alibaba.fastjson.JSONObject) com.alibaba.fastjson.JSON.parse((java.lang.String) obj, this.parserConfig);
            } catch (java.lang.Exception unused) {
                obj2 = obj;
            }
        } else {
            obj2 = obj;
        }
        if (obj2 instanceof java.util.Map) {
            java.util.Map map = (java.util.Map) obj2;
            java.lang.Object obj3 = map.get(str);
            if (obj3 == null) {
                return (SIZE == j || LENGTH == j) ? java.lang.Integer.valueOf(map.size()) : obj3;
            }
            return obj3;
        }
        com.alibaba.fastjson.serializer.JavaBeanSerializer javaBeanSerializer = getJavaBeanSerializer(obj2.getClass());
        if (javaBeanSerializer != null) {
            try {
                return javaBeanSerializer.getFieldValue(obj2, str, j, false);
            } catch (java.lang.Exception e) {
                throw new com.alibaba.fastjson.JSONPathException("jsonpath error, path " + this.path + ", segement " + str, e);
            }
        }
        int i = 0;
        if (obj2 instanceof java.util.List) {
            java.util.List list = (java.util.List) obj2;
            if (SIZE == j || LENGTH == j) {
                return java.lang.Integer.valueOf(list.size());
            }
            while (i < list.size()) {
                java.lang.Object obj4 = list.get(i);
                if (obj4 == list) {
                    if (jSONArray == null) {
                        jSONArray = new com.alibaba.fastjson.JSONArray(list.size());
                    }
                    jSONArray.add(obj4);
                } else {
                    java.lang.Object propertyValue = getPropertyValue(obj4, str, j);
                    if (propertyValue instanceof java.util.Collection) {
                        java.util.Collection collection = (java.util.Collection) propertyValue;
                        if (jSONArray == null) {
                            jSONArray = new com.alibaba.fastjson.JSONArray(list.size());
                        }
                        jSONArray.addAll(collection);
                    } else if (propertyValue != null || !this.ignoreNullValue) {
                        if (jSONArray == null) {
                            jSONArray = new com.alibaba.fastjson.JSONArray(list.size());
                        }
                        jSONArray.add(propertyValue);
                    }
                }
                i++;
            }
            return jSONArray == null ? java.util.Collections.EMPTY_LIST : jSONArray;
        }
        if (obj2 instanceof java.lang.Object[]) {
            java.lang.Object[] objArr = (java.lang.Object[]) obj2;
            if (SIZE == j || LENGTH == j) {
                return java.lang.Integer.valueOf(objArr.length);
            }
            com.alibaba.fastjson.JSONArray jSONArray2 = new com.alibaba.fastjson.JSONArray(objArr.length);
            while (i < objArr.length) {
                java.lang.Object[] objArr2 = objArr[i];
                if (objArr2 == objArr) {
                    jSONArray2.add(objArr2);
                } else {
                    java.lang.Object propertyValue2 = getPropertyValue(objArr2, str, j);
                    if (propertyValue2 instanceof java.util.Collection) {
                        jSONArray2.addAll((java.util.Collection) propertyValue2);
                    } else if (propertyValue2 != null || !this.ignoreNullValue) {
                        jSONArray2.add(propertyValue2);
                    }
                }
                i++;
            }
            return jSONArray2;
        }
        if (obj2 instanceof java.lang.Enum) {
            java.lang.Enum r9 = (java.lang.Enum) obj2;
            if (-4270347329889690746L == j) {
                return r9.name();
            }
            if (-1014497654951707614L == j) {
                return java.lang.Integer.valueOf(r9.ordinal());
            }
        }
        if (obj2 instanceof java.util.Calendar) {
            java.util.Calendar calendar = (java.util.Calendar) obj2;
            if (8963398325558730460L == j) {
                return java.lang.Integer.valueOf(calendar.get(1));
            }
            if (-811277319855450459L == j) {
                return java.lang.Integer.valueOf(calendar.get(2));
            }
            if (-3851359326990528739L == j) {
                return java.lang.Integer.valueOf(calendar.get(5));
            }
            if (4647432019745535567L == j) {
                return java.lang.Integer.valueOf(calendar.get(11));
            }
            if (6607618197526598121L == j) {
                return java.lang.Integer.valueOf(calendar.get(12));
            }
            if (-6586085717218287427L == j) {
                return java.lang.Integer.valueOf(calendar.get(13));
            }
        }
        return null;
    }

    protected void deepScan(java.lang.Object obj, java.lang.String str, java.util.List<java.lang.Object> list) {
        if (obj == null) {
            return;
        }
        if (obj instanceof java.util.Map) {
            for (java.util.Map.Entry entry : ((java.util.Map) obj).entrySet()) {
                java.lang.Object value = entry.getValue();
                if (str.equals(entry.getKey())) {
                    if (value instanceof java.util.Collection) {
                        list.addAll((java.util.Collection) value);
                    } else {
                        list.add(value);
                    }
                } else if (value != null && !com.alibaba.fastjson.parser.ParserConfig.isPrimitive2(value.getClass())) {
                    deepScan(value, str, list);
                }
            }
            return;
        }
        if (obj instanceof java.util.Collection) {
            for (java.lang.Object obj2 : (java.util.Collection) obj) {
                if (!com.alibaba.fastjson.parser.ParserConfig.isPrimitive2(obj2.getClass())) {
                    deepScan(obj2, str, list);
                }
            }
            return;
        }
        com.alibaba.fastjson.serializer.JavaBeanSerializer javaBeanSerializer = getJavaBeanSerializer(obj.getClass());
        if (javaBeanSerializer != null) {
            try {
                com.alibaba.fastjson.serializer.FieldSerializer fieldSerializer = javaBeanSerializer.getFieldSerializer(str);
                if (fieldSerializer != null) {
                    try {
                        list.add(fieldSerializer.getPropertyValueDirect(obj));
                        return;
                    } catch (java.lang.IllegalAccessException e) {
                        throw new com.alibaba.fastjson.JSONException("getFieldValue error." + str, e);
                    } catch (java.lang.reflect.InvocationTargetException e2) {
                        throw new com.alibaba.fastjson.JSONException("getFieldValue error." + str, e2);
                    }
                }
                java.util.Iterator<java.lang.Object> it = javaBeanSerializer.getFieldValues(obj).iterator();
                while (it.hasNext()) {
                    deepScan(it.next(), str, list);
                }
                return;
            } catch (java.lang.Exception e3) {
                throw new com.alibaba.fastjson.JSONPathException("jsonpath error, path " + this.path + ", segement " + str, e3);
            }
        }
        if (obj instanceof java.util.List) {
            java.util.List list2 = (java.util.List) obj;
            for (int i = 0; i < list2.size(); i++) {
                deepScan(list2.get(i), str, list);
            }
        }
    }

    protected void deepSet(java.lang.Object obj, java.lang.String str, long j, java.lang.Object obj2) {
        if (obj == null) {
            return;
        }
        if (obj instanceof java.util.Map) {
            java.util.Map map = (java.util.Map) obj;
            if (map.containsKey(str)) {
                map.get(str);
                map.put(str, obj2);
                return;
            }
            java.util.Iterator it = map.values().iterator();
            while (it.hasNext()) {
                java.lang.String str2 = str;
                long j2 = j;
                java.lang.Object obj3 = obj2;
                deepSet(it.next(), str2, j2, obj3);
                str = str2;
                j = j2;
                obj2 = obj3;
            }
            return;
        }
        com.alibaba.fastjson.JSONPath jSONPath = this;
        java.lang.Class<?> cls = obj.getClass();
        com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer javaBeanDeserializer = getJavaBeanDeserializer(cls);
        if (javaBeanDeserializer != null) {
            try {
                com.alibaba.fastjson.parser.deserializer.FieldDeserializer fieldDeserializer = javaBeanDeserializer.getFieldDeserializer(str);
                if (fieldDeserializer != null) {
                    fieldDeserializer.setValue(obj, obj2);
                    return;
                }
                java.util.Iterator<java.lang.Object> it2 = getJavaBeanSerializer(cls).getObjectFieldValues(obj).iterator();
                while (it2.hasNext()) {
                    jSONPath.deepSet(it2.next(), str, j, obj2);
                }
                return;
            } catch (java.lang.Exception e) {
                throw new com.alibaba.fastjson.JSONPathException("jsonpath error, path " + jSONPath.path + ", segement " + str, e);
            }
        }
        if (obj instanceof java.util.List) {
            java.util.List list = (java.util.List) obj;
            int i = 0;
            while (i < list.size()) {
                jSONPath.deepSet(list.get(i), str, j, obj2);
                i++;
                jSONPath = this;
            }
        }
    }

    protected boolean setPropertyValue(java.lang.Object obj, java.lang.String str, long j, java.lang.Object obj2) {
        if (obj instanceof java.util.Map) {
            ((java.util.Map) obj).put(str, obj2);
            return true;
        }
        if (obj instanceof java.util.List) {
            for (java.lang.Object obj3 : (java.util.List) obj) {
                if (obj3 != null) {
                    setPropertyValue(obj3, str, j, obj2);
                }
            }
            return true;
        }
        com.alibaba.fastjson.parser.deserializer.ObjectDeserializer deserializer = this.parserConfig.getDeserializer(obj.getClass());
        com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer javaBeanDeserializer = deserializer instanceof com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer ? (com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) deserializer : null;
        if (javaBeanDeserializer != null) {
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer fieldDeserializer = javaBeanDeserializer.getFieldDeserializer(j);
            if (fieldDeserializer == null) {
                return false;
            }
            fieldDeserializer.setValue(obj, (obj2 == null || obj2.getClass() == fieldDeserializer.fieldInfo.fieldClass) ? obj2 : com.alibaba.fastjson.util.TypeUtils.cast(obj2, fieldDeserializer.fieldInfo.fieldType, this.parserConfig));
            return true;
        }
        throw new java.lang.UnsupportedOperationException();
    }

    protected boolean removePropertyValue(java.lang.Object obj, java.lang.String str, boolean z) {
        boolean z2 = true;
        if (obj instanceof java.util.Map) {
            java.util.Map map = (java.util.Map) obj;
            z2 = map.remove(str) != null;
            if (z) {
                java.util.Iterator it = map.values().iterator();
                while (it.hasNext()) {
                    removePropertyValue(it.next(), str, z);
                }
            }
            return z2;
        }
        com.alibaba.fastjson.parser.deserializer.ObjectDeserializer deserializer = this.parserConfig.getDeserializer(obj.getClass());
        com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer javaBeanDeserializer = deserializer instanceof com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer ? (com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) deserializer : null;
        if (javaBeanDeserializer == null) {
            if (z) {
                return false;
            }
            throw new java.lang.UnsupportedOperationException();
        }
        com.alibaba.fastjson.parser.deserializer.FieldDeserializer fieldDeserializer = javaBeanDeserializer.getFieldDeserializer(str);
        if (fieldDeserializer != null) {
            fieldDeserializer.setValue(obj, (java.lang.String) null);
        } else {
            z2 = false;
        }
        if (z) {
            for (java.lang.Object obj2 : getPropertyValues(obj)) {
                if (obj2 != null) {
                    removePropertyValue(obj2, str, z);
                }
            }
        }
        return z2;
    }

    protected com.alibaba.fastjson.serializer.JavaBeanSerializer getJavaBeanSerializer(java.lang.Class<?> cls) {
        com.alibaba.fastjson.serializer.ObjectSerializer objectWriter = this.serializeConfig.getObjectWriter(cls);
        if (objectWriter instanceof com.alibaba.fastjson.serializer.JavaBeanSerializer) {
            return (com.alibaba.fastjson.serializer.JavaBeanSerializer) objectWriter;
        }
        return null;
    }

    protected com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer getJavaBeanDeserializer(java.lang.Class<?> cls) {
        com.alibaba.fastjson.parser.deserializer.ObjectDeserializer deserializer = this.parserConfig.getDeserializer(cls);
        if (deserializer instanceof com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) {
            return (com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) deserializer;
        }
        return null;
    }

    int evalSize(java.lang.Object obj) {
        if (obj == null) {
            return -1;
        }
        if (obj instanceof java.util.Collection) {
            return ((java.util.Collection) obj).size();
        }
        if (obj instanceof java.lang.Object[]) {
            return ((java.lang.Object[]) obj).length;
        }
        if (obj.getClass().isArray()) {
            return java.lang.reflect.Array.getLength(obj);
        }
        if (obj instanceof java.util.Map) {
            java.util.Iterator it = ((java.util.Map) obj).values().iterator();
            int i = 0;
            while (it.hasNext()) {
                if (it.next() != null) {
                    i++;
                }
            }
            return i;
        }
        com.alibaba.fastjson.serializer.JavaBeanSerializer javaBeanSerializer = getJavaBeanSerializer(obj.getClass());
        if (javaBeanSerializer == null) {
            return -1;
        }
        try {
            return javaBeanSerializer.getSize(obj);
        } catch (java.lang.Exception e) {
            throw new com.alibaba.fastjson.JSONPathException("evalSize error : " + this.path, e);
        }
    }

    java.util.Set<?> evalKeySet(java.lang.Object obj) {
        com.alibaba.fastjson.serializer.JavaBeanSerializer javaBeanSerializer;
        if (obj == null) {
            return null;
        }
        if (obj instanceof java.util.Map) {
            return ((java.util.Map) obj).keySet();
        }
        if ((obj instanceof java.util.Collection) || (obj instanceof java.lang.Object[]) || obj.getClass().isArray() || (javaBeanSerializer = getJavaBeanSerializer(obj.getClass())) == null) {
            return null;
        }
        try {
            return javaBeanSerializer.getFieldNames(obj);
        } catch (java.lang.Exception e) {
            throw new com.alibaba.fastjson.JSONPathException("evalKeySet error : " + this.path, e);
        }
    }

    @Override // com.alibaba.fastjson.JSONAware
    public java.lang.String toJSONString() {
        return com.alibaba.fastjson.JSON.toJSONString(this.path);
    }

    public static java.lang.Object reserveToArray(java.lang.Object obj, java.lang.String... strArr) {
        com.alibaba.fastjson.JSONArray jSONArray = new com.alibaba.fastjson.JSONArray();
        if (strArr != null && strArr.length != 0) {
            for (java.lang.String str : strArr) {
                com.alibaba.fastjson.JSONPath jSONPathCompile = compile(str);
                jSONPathCompile.init();
                jSONArray.add(jSONPathCompile.eval(obj));
            }
        }
        return jSONArray;
    }

    public static java.lang.Object reserveToObject(java.lang.Object obj, java.lang.String... strArr) {
        java.lang.Object objEval;
        if (strArr == null || strArr.length == 0) {
            return obj;
        }
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject(true);
        for (java.lang.String str : strArr) {
            com.alibaba.fastjson.JSONPath jSONPathCompile = compile(str);
            jSONPathCompile.init();
            com.alibaba.fastjson.JSONPath.Segment[] segmentArr = jSONPathCompile.segments;
            if ((segmentArr[segmentArr.length - 1] instanceof com.alibaba.fastjson.JSONPath.PropertySegment) && (objEval = jSONPathCompile.eval(obj)) != null) {
                jSONPathCompile.set(jSONObject, objEval);
            }
        }
        return jSONObject;
    }
}
