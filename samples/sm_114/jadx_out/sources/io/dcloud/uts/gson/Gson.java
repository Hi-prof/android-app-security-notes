package io.dcloud.uts.gson;

/* JADX INFO: loaded from: classes2.dex */
public final class Gson {
    static final boolean DEFAULT_COMPLEX_MAP_KEYS = false;
    static final boolean DEFAULT_ESCAPE_HTML = true;
    static final boolean DEFAULT_JSON_NON_EXECUTABLE = false;
    static final boolean DEFAULT_LENIENT = false;
    static final boolean DEFAULT_PRETTY_PRINT = false;
    static final boolean DEFAULT_SERIALIZE_NULLS = false;
    static final boolean DEFAULT_SPECIALIZE_FLOAT_VALUES = false;
    private static final java.lang.String JSON_NON_EXECUTABLE_PREFIX = ")]}'\n";
    private static final io.dcloud.uts.gson.reflect.TypeToken<?> NULL_KEY_SURROGATE = io.dcloud.uts.gson.reflect.TypeToken.get(java.lang.Object.class);
    final java.util.List<io.dcloud.uts.gson.TypeAdapterFactory> builderFactories;
    final java.util.List<io.dcloud.uts.gson.TypeAdapterFactory> builderHierarchyFactories;
    private final java.lang.ThreadLocal<java.util.Map<io.dcloud.uts.gson.reflect.TypeToken<?>, io.dcloud.uts.gson.Gson.FutureTypeAdapter<?>>> calls;
    final boolean complexMapKeySerialization;
    private final io.dcloud.uts.gson.internal.ConstructorConstructor constructorConstructor;
    final java.lang.String datePattern;
    final int dateStyle;
    final io.dcloud.uts.gson.internal.Excluder excluder;
    final java.util.List<io.dcloud.uts.gson.TypeAdapterFactory> factories;
    final io.dcloud.uts.gson.FieldNamingStrategy fieldNamingStrategy;
    final boolean generateNonExecutableJson;
    final boolean htmlSafe;
    final java.util.Map<java.lang.reflect.Type, io.dcloud.uts.gson.InstanceCreator<?>> instanceCreators;
    private final io.dcloud.uts.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory jsonAdapterFactory;
    final boolean lenient;
    final io.dcloud.uts.gson.LongSerializationPolicy longSerializationPolicy;
    final io.dcloud.uts.gson.ToNumberStrategy numberToNumberStrategy;
    final io.dcloud.uts.gson.ToNumberStrategy objectToNumberStrategy;
    final boolean prettyPrinting;
    final boolean serializeNulls;
    final boolean serializeSpecialFloatingPointValues;
    final int timeStyle;
    private final java.util.Map<io.dcloud.uts.gson.reflect.TypeToken<?>, io.dcloud.uts.gson.TypeAdapter<?>> typeTokenCache;

    public Gson() {
        this(io.dcloud.uts.gson.internal.Excluder.DEFAULT, io.dcloud.uts.gson.FieldNamingPolicy.IDENTITY, java.util.Collections.EMPTY_MAP, false, false, false, true, false, false, false, io.dcloud.uts.gson.LongSerializationPolicy.DEFAULT, null, 2, 2, java.util.Collections.EMPTY_LIST, java.util.Collections.EMPTY_LIST, java.util.Collections.EMPTY_LIST, io.dcloud.uts.gson.ToNumberPolicy.DOUBLE, io.dcloud.uts.gson.ToNumberPolicy.LAZILY_PARSED_NUMBER);
    }

    Gson(io.dcloud.uts.gson.internal.Excluder excluder, io.dcloud.uts.gson.FieldNamingStrategy fieldNamingStrategy, java.util.Map<java.lang.reflect.Type, io.dcloud.uts.gson.InstanceCreator<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, io.dcloud.uts.gson.LongSerializationPolicy longSerializationPolicy, java.lang.String str, int i, int i2, java.util.List<io.dcloud.uts.gson.TypeAdapterFactory> list, java.util.List<io.dcloud.uts.gson.TypeAdapterFactory> list2, java.util.List<io.dcloud.uts.gson.TypeAdapterFactory> list3, io.dcloud.uts.gson.ToNumberStrategy toNumberStrategy, io.dcloud.uts.gson.ToNumberStrategy toNumberStrategy2) {
        this.calls = new java.lang.ThreadLocal<>();
        this.typeTokenCache = new java.util.concurrent.ConcurrentHashMap();
        this.excluder = excluder;
        this.fieldNamingStrategy = fieldNamingStrategy;
        this.instanceCreators = map;
        io.dcloud.uts.gson.internal.ConstructorConstructor constructorConstructor = new io.dcloud.uts.gson.internal.ConstructorConstructor(map);
        this.constructorConstructor = constructorConstructor;
        this.serializeNulls = z;
        this.complexMapKeySerialization = z2;
        this.generateNonExecutableJson = z3;
        this.htmlSafe = z4;
        this.prettyPrinting = z5;
        this.lenient = z6;
        this.serializeSpecialFloatingPointValues = z7;
        this.longSerializationPolicy = longSerializationPolicy;
        this.datePattern = str;
        this.dateStyle = i;
        this.timeStyle = i2;
        this.builderFactories = list;
        this.builderHierarchyFactories = list2;
        this.objectToNumberStrategy = toNumberStrategy;
        this.numberToNumberStrategy = toNumberStrategy2;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(io.dcloud.uts.gson.internal.bind.TypeAdapters.JSON_ELEMENT_FACTORY);
        arrayList.add(io.dcloud.uts.gson.internal.bind.ObjectTypeAdapter.getFactory(toNumberStrategy));
        arrayList.add(excluder);
        arrayList.addAll(list3);
        arrayList.add(io.dcloud.uts.gson.internal.bind.TypeAdapters.STRING_FACTORY);
        arrayList.add(io.dcloud.uts.gson.internal.bind.TypeAdapters.INTEGER_FACTORY);
        arrayList.add(io.dcloud.uts.gson.internal.bind.TypeAdapters.BOOLEAN_FACTORY);
        arrayList.add(io.dcloud.uts.gson.internal.bind.TypeAdapters.BYTE_FACTORY);
        arrayList.add(io.dcloud.uts.gson.internal.bind.TypeAdapters.SHORT_FACTORY);
        io.dcloud.uts.gson.TypeAdapter<java.lang.Number> typeAdapterLongAdapter = longAdapter(longSerializationPolicy);
        arrayList.add(io.dcloud.uts.gson.internal.bind.TypeAdapters.newFactory(java.lang.Long.TYPE, java.lang.Long.class, typeAdapterLongAdapter));
        arrayList.add(io.dcloud.uts.gson.internal.bind.TypeAdapters.newFactory(java.lang.Double.TYPE, java.lang.Double.class, doubleAdapter(z7)));
        arrayList.add(io.dcloud.uts.gson.internal.bind.TypeAdapters.newFactory(java.lang.Float.TYPE, java.lang.Float.class, floatAdapter(z7)));
        arrayList.add(io.dcloud.uts.gson.internal.bind.NumberTypeAdapter.getFactory(toNumberStrategy2));
        arrayList.add(io.dcloud.uts.gson.internal.bind.TypeAdapters.ATOMIC_INTEGER_FACTORY);
        arrayList.add(io.dcloud.uts.gson.internal.bind.TypeAdapters.ATOMIC_BOOLEAN_FACTORY);
        arrayList.add(io.dcloud.uts.gson.internal.bind.TypeAdapters.newFactory(java.util.concurrent.atomic.AtomicLong.class, atomicLongAdapter(typeAdapterLongAdapter)));
        arrayList.add(io.dcloud.uts.gson.internal.bind.TypeAdapters.newFactory(java.util.concurrent.atomic.AtomicLongArray.class, atomicLongArrayAdapter(typeAdapterLongAdapter)));
        arrayList.add(io.dcloud.uts.gson.internal.bind.TypeAdapters.ATOMIC_INTEGER_ARRAY_FACTORY);
        arrayList.add(io.dcloud.uts.gson.internal.bind.TypeAdapters.CHARACTER_FACTORY);
        arrayList.add(io.dcloud.uts.gson.internal.bind.TypeAdapters.STRING_BUILDER_FACTORY);
        arrayList.add(io.dcloud.uts.gson.internal.bind.TypeAdapters.STRING_BUFFER_FACTORY);
        arrayList.add(io.dcloud.uts.gson.internal.bind.TypeAdapters.newFactory(java.math.BigDecimal.class, io.dcloud.uts.gson.internal.bind.TypeAdapters.BIG_DECIMAL));
        arrayList.add(io.dcloud.uts.gson.internal.bind.TypeAdapters.newFactory(java.math.BigInteger.class, io.dcloud.uts.gson.internal.bind.TypeAdapters.BIG_INTEGER));
        arrayList.add(io.dcloud.uts.gson.internal.bind.TypeAdapters.URL_FACTORY);
        arrayList.add(io.dcloud.uts.gson.internal.bind.TypeAdapters.URI_FACTORY);
        arrayList.add(io.dcloud.uts.gson.internal.bind.TypeAdapters.UUID_FACTORY);
        arrayList.add(io.dcloud.uts.gson.internal.bind.TypeAdapters.CURRENCY_FACTORY);
        arrayList.add(io.dcloud.uts.gson.internal.bind.TypeAdapters.LOCALE_FACTORY);
        arrayList.add(io.dcloud.uts.gson.internal.bind.TypeAdapters.INET_ADDRESS_FACTORY);
        arrayList.add(io.dcloud.uts.gson.internal.bind.TypeAdapters.BIT_SET_FACTORY);
        arrayList.add(io.dcloud.uts.gson.internal.bind.DateTypeAdapter.FACTORY);
        arrayList.add(io.dcloud.uts.gson.internal.bind.TypeAdapters.CALENDAR_FACTORY);
        if (io.dcloud.uts.gson.internal.sql.SqlTypesSupport.SUPPORTS_SQL_TYPES) {
            arrayList.add(io.dcloud.uts.gson.internal.sql.SqlTypesSupport.TIME_FACTORY);
            arrayList.add(io.dcloud.uts.gson.internal.sql.SqlTypesSupport.DATE_FACTORY);
            arrayList.add(io.dcloud.uts.gson.internal.sql.SqlTypesSupport.TIMESTAMP_FACTORY);
        }
        arrayList.add(io.dcloud.uts.gson.internal.bind.ArrayTypeAdapter.FACTORY);
        arrayList.add(io.dcloud.uts.gson.internal.bind.TypeAdapters.CLASS_FACTORY);
        arrayList.add(new io.dcloud.uts.gson.internal.bind.CollectionTypeAdapterFactory(constructorConstructor));
        arrayList.add(new io.dcloud.uts.gson.internal.bind.MapTypeAdapterFactory(constructorConstructor, z2));
        io.dcloud.uts.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory = new io.dcloud.uts.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory(constructorConstructor);
        this.jsonAdapterFactory = jsonAdapterAnnotationTypeAdapterFactory;
        arrayList.add(jsonAdapterAnnotationTypeAdapterFactory);
        arrayList.add(io.dcloud.uts.gson.internal.bind.TypeAdapters.ENUM_FACTORY);
        arrayList.add(new io.dcloud.uts.gson.internal.bind.ReflectiveTypeAdapterFactory(constructorConstructor, fieldNamingStrategy, excluder, jsonAdapterAnnotationTypeAdapterFactory));
        this.factories = java.util.Collections.unmodifiableList(arrayList);
    }

    public io.dcloud.uts.gson.GsonBuilder newBuilder() {
        return new io.dcloud.uts.gson.GsonBuilder(this);
    }

    @java.lang.Deprecated
    public io.dcloud.uts.gson.internal.Excluder excluder() {
        return this.excluder;
    }

    public io.dcloud.uts.gson.FieldNamingStrategy fieldNamingStrategy() {
        return this.fieldNamingStrategy;
    }

    public boolean serializeNulls() {
        return this.serializeNulls;
    }

    public boolean htmlSafe() {
        return this.htmlSafe;
    }

    private io.dcloud.uts.gson.TypeAdapter<java.lang.Number> doubleAdapter(boolean z) {
        if (z) {
            return io.dcloud.uts.gson.internal.bind.TypeAdapters.DOUBLE;
        }
        return new io.dcloud.uts.gson.TypeAdapter<java.lang.Number>() { // from class: io.dcloud.uts.gson.Gson.1
            @Override // io.dcloud.uts.gson.TypeAdapter
            /* JADX INFO: renamed from: read, reason: merged with bridge method [inline-methods] */
            public java.lang.Number read2(io.dcloud.uts.gson.stream.JsonReader jsonReader) throws java.io.IOException {
                if (jsonReader.peek() == io.dcloud.uts.gson.stream.JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                return java.lang.Double.valueOf(jsonReader.nextDouble());
            }

            @Override // io.dcloud.uts.gson.TypeAdapter
            public void write(io.dcloud.uts.gson.stream.JsonWriter jsonWriter, java.lang.Number number) throws java.io.IOException {
                if (number == null) {
                    jsonWriter.nullValue();
                } else {
                    io.dcloud.uts.gson.Gson.checkValidFloatingPoint(number.doubleValue());
                    jsonWriter.value(number);
                }
            }
        };
    }

    private io.dcloud.uts.gson.TypeAdapter<java.lang.Number> floatAdapter(boolean z) {
        if (z) {
            return io.dcloud.uts.gson.internal.bind.TypeAdapters.FLOAT;
        }
        return new io.dcloud.uts.gson.TypeAdapter<java.lang.Number>() { // from class: io.dcloud.uts.gson.Gson.2
            @Override // io.dcloud.uts.gson.TypeAdapter
            /* JADX INFO: renamed from: read */
            public java.lang.Number read2(io.dcloud.uts.gson.stream.JsonReader jsonReader) throws java.io.IOException {
                if (jsonReader.peek() == io.dcloud.uts.gson.stream.JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                return java.lang.Float.valueOf((float) jsonReader.nextDouble());
            }

            @Override // io.dcloud.uts.gson.TypeAdapter
            public void write(io.dcloud.uts.gson.stream.JsonWriter jsonWriter, java.lang.Number number) throws java.io.IOException {
                if (number == null) {
                    jsonWriter.nullValue();
                } else {
                    io.dcloud.uts.gson.Gson.checkValidFloatingPoint(number.floatValue());
                    jsonWriter.value(number);
                }
            }
        };
    }

    static void checkValidFloatingPoint(double d) {
        if (java.lang.Double.isNaN(d) || java.lang.Double.isInfinite(d)) {
            throw new java.lang.IllegalArgumentException(d + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    private static io.dcloud.uts.gson.TypeAdapter<java.lang.Number> longAdapter(io.dcloud.uts.gson.LongSerializationPolicy longSerializationPolicy) {
        if (longSerializationPolicy == io.dcloud.uts.gson.LongSerializationPolicy.DEFAULT) {
            return io.dcloud.uts.gson.internal.bind.TypeAdapters.LONG;
        }
        return new io.dcloud.uts.gson.TypeAdapter<java.lang.Number>() { // from class: io.dcloud.uts.gson.Gson.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.dcloud.uts.gson.TypeAdapter
            /* JADX INFO: renamed from: read */
            public java.lang.Number read2(io.dcloud.uts.gson.stream.JsonReader jsonReader) throws java.io.IOException {
                if (jsonReader.peek() == io.dcloud.uts.gson.stream.JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                return java.lang.Long.valueOf(jsonReader.nextLong());
            }

            @Override // io.dcloud.uts.gson.TypeAdapter
            public void write(io.dcloud.uts.gson.stream.JsonWriter jsonWriter, java.lang.Number number) throws java.io.IOException {
                if (number == null) {
                    jsonWriter.nullValue();
                } else {
                    jsonWriter.value(number.toString());
                }
            }
        };
    }

    private static io.dcloud.uts.gson.TypeAdapter<java.util.concurrent.atomic.AtomicLong> atomicLongAdapter(final io.dcloud.uts.gson.TypeAdapter<java.lang.Number> typeAdapter) {
        return new io.dcloud.uts.gson.TypeAdapter<java.util.concurrent.atomic.AtomicLong>() { // from class: io.dcloud.uts.gson.Gson.4
            @Override // io.dcloud.uts.gson.TypeAdapter
            public void write(io.dcloud.uts.gson.stream.JsonWriter jsonWriter, java.util.concurrent.atomic.AtomicLong atomicLong) throws java.io.IOException {
                typeAdapter.write(jsonWriter, java.lang.Long.valueOf(atomicLong.get()));
            }

            @Override // io.dcloud.uts.gson.TypeAdapter
            /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
            public java.util.concurrent.atomic.AtomicLong read2(io.dcloud.uts.gson.stream.JsonReader jsonReader) throws java.io.IOException {
                return new java.util.concurrent.atomic.AtomicLong(((java.lang.Number) typeAdapter.read2(jsonReader)).longValue());
            }
        }.nullSafe();
    }

    private static io.dcloud.uts.gson.TypeAdapter<java.util.concurrent.atomic.AtomicLongArray> atomicLongArrayAdapter(final io.dcloud.uts.gson.TypeAdapter<java.lang.Number> typeAdapter) {
        return new io.dcloud.uts.gson.TypeAdapter<java.util.concurrent.atomic.AtomicLongArray>() { // from class: io.dcloud.uts.gson.Gson.5
            @Override // io.dcloud.uts.gson.TypeAdapter
            public void write(io.dcloud.uts.gson.stream.JsonWriter jsonWriter, java.util.concurrent.atomic.AtomicLongArray atomicLongArray) throws java.io.IOException {
                jsonWriter.beginArray();
                int length = atomicLongArray.length();
                for (int i = 0; i < length; i++) {
                    typeAdapter.write(jsonWriter, java.lang.Long.valueOf(atomicLongArray.get(i)));
                }
                jsonWriter.endArray();
            }

            @Override // io.dcloud.uts.gson.TypeAdapter
            /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
            public java.util.concurrent.atomic.AtomicLongArray read2(io.dcloud.uts.gson.stream.JsonReader jsonReader) throws java.io.IOException {
                java.util.ArrayList arrayList = new java.util.ArrayList();
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    arrayList.add(java.lang.Long.valueOf(((java.lang.Number) typeAdapter.read2(jsonReader)).longValue()));
                }
                jsonReader.endArray();
                int size = arrayList.size();
                java.util.concurrent.atomic.AtomicLongArray atomicLongArray = new java.util.concurrent.atomic.AtomicLongArray(size);
                for (int i = 0; i < size; i++) {
                    atomicLongArray.set(i, ((java.lang.Long) arrayList.get(i)).longValue());
                }
                return atomicLongArray;
            }
        }.nullSafe();
    }

    public <T> io.dcloud.uts.gson.TypeAdapter<T> getAdapter(io.dcloud.uts.gson.reflect.TypeToken<T> typeToken) {
        boolean z;
        io.dcloud.uts.gson.TypeAdapter<T> typeAdapter = (io.dcloud.uts.gson.TypeAdapter) this.typeTokenCache.get(typeToken == null ? NULL_KEY_SURROGATE : typeToken);
        if (typeAdapter != null) {
            return typeAdapter;
        }
        java.util.Map<io.dcloud.uts.gson.reflect.TypeToken<?>, io.dcloud.uts.gson.Gson.FutureTypeAdapter<?>> map = this.calls.get();
        if (map == null) {
            map = new java.util.HashMap<>();
            this.calls.set(map);
            z = true;
        } else {
            z = false;
        }
        io.dcloud.uts.gson.Gson.FutureTypeAdapter<?> futureTypeAdapter = map.get(typeToken);
        if (futureTypeAdapter != null) {
            return futureTypeAdapter;
        }
        try {
            io.dcloud.uts.gson.Gson.FutureTypeAdapter<?> futureTypeAdapter2 = new io.dcloud.uts.gson.Gson.FutureTypeAdapter<>();
            map.put(typeToken, futureTypeAdapter2);
            java.util.Iterator<io.dcloud.uts.gson.TypeAdapterFactory> it = this.factories.iterator();
            while (it.hasNext()) {
                io.dcloud.uts.gson.TypeAdapter<T> typeAdapterCreate = it.next().create(this, typeToken);
                if (typeAdapterCreate != null) {
                    futureTypeAdapter2.setDelegate(typeAdapterCreate);
                    this.typeTokenCache.put(typeToken, typeAdapterCreate);
                    map.remove(typeToken);
                    if (z) {
                        this.calls.remove();
                    }
                    return typeAdapterCreate;
                }
            }
            throw new java.lang.IllegalArgumentException("GSON () cannot handle " + typeToken);
        } catch (java.lang.Throwable th) {
            map.remove(typeToken);
            if (z) {
                this.calls.remove();
            }
            throw th;
        }
    }

    public <T> io.dcloud.uts.gson.TypeAdapter<T> getDelegateAdapter(io.dcloud.uts.gson.TypeAdapterFactory typeAdapterFactory, io.dcloud.uts.gson.reflect.TypeToken<T> typeToken) {
        if (!this.factories.contains(typeAdapterFactory)) {
            typeAdapterFactory = this.jsonAdapterFactory;
        }
        boolean z = false;
        for (io.dcloud.uts.gson.TypeAdapterFactory typeAdapterFactory2 : this.factories) {
            if (z) {
                io.dcloud.uts.gson.TypeAdapter<T> typeAdapterCreate = typeAdapterFactory2.create(this, typeToken);
                if (typeAdapterCreate != null) {
                    return typeAdapterCreate;
                }
            } else if (typeAdapterFactory2 == typeAdapterFactory) {
                z = true;
            }
        }
        throw new java.lang.IllegalArgumentException("GSON cannot serialize " + typeToken);
    }

    public <T> io.dcloud.uts.gson.TypeAdapter<T> getAdapter(java.lang.Class<T> cls) {
        return getAdapter(io.dcloud.uts.gson.reflect.TypeToken.get((java.lang.Class) cls));
    }

    public io.dcloud.uts.gson.JsonElement toJsonTree(java.lang.Object obj) {
        if (obj == null) {
            return io.dcloud.uts.gson.JsonNull.INSTANCE;
        }
        return toJsonTree(obj, obj.getClass());
    }

    public io.dcloud.uts.gson.JsonElement toJsonTree(java.lang.Object obj, java.lang.reflect.Type type) {
        io.dcloud.uts.gson.internal.bind.JsonTreeWriter jsonTreeWriter = new io.dcloud.uts.gson.internal.bind.JsonTreeWriter();
        toJson(obj, type, jsonTreeWriter);
        return jsonTreeWriter.get();
    }

    public java.lang.String toJson(java.lang.Object obj) {
        if (obj == null) {
            return toJson((io.dcloud.uts.gson.JsonElement) io.dcloud.uts.gson.JsonNull.INSTANCE);
        }
        return toJson(obj, obj.getClass());
    }

    public java.lang.String toJson(java.lang.Object obj, java.lang.reflect.Type type) {
        java.io.StringWriter stringWriter = new java.io.StringWriter();
        toJson(obj, type, stringWriter);
        return stringWriter.toString();
    }

    public void toJson(java.lang.Object obj, java.lang.Appendable appendable) throws io.dcloud.uts.gson.JsonIOException {
        if (obj != null) {
            toJson(obj, obj.getClass(), appendable);
        } else {
            toJson((io.dcloud.uts.gson.JsonElement) io.dcloud.uts.gson.JsonNull.INSTANCE, appendable);
        }
    }

    public void toJson(java.lang.Object obj, java.lang.reflect.Type type, java.lang.Appendable appendable) throws io.dcloud.uts.gson.JsonIOException {
        try {
            toJson(obj, type, newJsonWriter(io.dcloud.uts.gson.internal.Streams.writerForAppendable(appendable)));
        } catch (java.io.IOException e) {
            throw new io.dcloud.uts.gson.JsonIOException(e);
        }
    }

    public void toJson(java.lang.Object obj, java.lang.reflect.Type type, io.dcloud.uts.gson.stream.JsonWriter jsonWriter) throws io.dcloud.uts.gson.JsonIOException {
        io.dcloud.uts.gson.TypeAdapter adapter = getAdapter(io.dcloud.uts.gson.reflect.TypeToken.get(type));
        boolean zIsLenient = jsonWriter.isLenient();
        jsonWriter.setLenient(true);
        boolean zIsHtmlSafe = jsonWriter.isHtmlSafe();
        jsonWriter.setHtmlSafe(this.htmlSafe);
        boolean serializeNulls = jsonWriter.getSerializeNulls();
        jsonWriter.setSerializeNulls(this.serializeNulls);
        try {
            try {
                try {
                    adapter.write(jsonWriter, obj);
                    jsonWriter.setLenient(zIsLenient);
                    jsonWriter.setHtmlSafe(zIsHtmlSafe);
                    jsonWriter.setSerializeNulls(serializeNulls);
                } catch (java.lang.AssertionError e) {
                    java.lang.AssertionError assertionError = new java.lang.AssertionError("AssertionError (GSON ): " + e.getMessage());
                    assertionError.initCause(e);
                    throw assertionError;
                }
            } catch (java.io.IOException e2) {
                throw new io.dcloud.uts.gson.JsonIOException(e2);
            }
        } catch (java.lang.Throwable th) {
            jsonWriter.setLenient(zIsLenient);
            jsonWriter.setHtmlSafe(zIsHtmlSafe);
            jsonWriter.setSerializeNulls(serializeNulls);
            throw th;
        }
    }

    public java.lang.String toJson(io.dcloud.uts.gson.JsonElement jsonElement) {
        java.io.StringWriter stringWriter = new java.io.StringWriter();
        toJson(jsonElement, (java.lang.Appendable) stringWriter);
        return stringWriter.toString();
    }

    public void toJson(io.dcloud.uts.gson.JsonElement jsonElement, java.lang.Appendable appendable) throws io.dcloud.uts.gson.JsonIOException {
        try {
            toJson(jsonElement, newJsonWriter(io.dcloud.uts.gson.internal.Streams.writerForAppendable(appendable)));
        } catch (java.io.IOException e) {
            throw new io.dcloud.uts.gson.JsonIOException(e);
        }
    }

    public io.dcloud.uts.gson.stream.JsonWriter newJsonWriter(java.io.Writer writer) throws java.io.IOException {
        if (this.generateNonExecutableJson) {
            writer.write(JSON_NON_EXECUTABLE_PREFIX);
        }
        io.dcloud.uts.gson.stream.JsonWriter jsonWriter = new io.dcloud.uts.gson.stream.JsonWriter(writer);
        if (this.prettyPrinting) {
            jsonWriter.setIndent("  ");
        }
        jsonWriter.setSerializeNulls(this.serializeNulls);
        return jsonWriter;
    }

    public io.dcloud.uts.gson.stream.JsonReader newJsonReader(java.io.Reader reader) {
        io.dcloud.uts.gson.stream.JsonReader jsonReader = new io.dcloud.uts.gson.stream.JsonReader(reader);
        jsonReader.setLenient(this.lenient);
        return jsonReader;
    }

    public void toJson(io.dcloud.uts.gson.JsonElement jsonElement, io.dcloud.uts.gson.stream.JsonWriter jsonWriter) throws io.dcloud.uts.gson.JsonIOException {
        boolean zIsLenient = jsonWriter.isLenient();
        jsonWriter.setLenient(true);
        boolean zIsHtmlSafe = jsonWriter.isHtmlSafe();
        jsonWriter.setHtmlSafe(this.htmlSafe);
        boolean serializeNulls = jsonWriter.getSerializeNulls();
        jsonWriter.setSerializeNulls(this.serializeNulls);
        try {
            try {
                io.dcloud.uts.gson.internal.Streams.write(jsonElement, jsonWriter);
                jsonWriter.setLenient(zIsLenient);
                jsonWriter.setHtmlSafe(zIsHtmlSafe);
                jsonWriter.setSerializeNulls(serializeNulls);
            } catch (java.io.IOException e) {
                throw new io.dcloud.uts.gson.JsonIOException(e);
            } catch (java.lang.AssertionError e2) {
                java.lang.AssertionError assertionError = new java.lang.AssertionError("AssertionError (GSON ): " + e2.getMessage());
                assertionError.initCause(e2);
                throw assertionError;
            }
        } catch (java.lang.Throwable th) {
            jsonWriter.setLenient(zIsLenient);
            jsonWriter.setHtmlSafe(zIsHtmlSafe);
            jsonWriter.setSerializeNulls(serializeNulls);
            throw th;
        }
    }

    public <T> T fromJson(java.lang.String str, java.lang.Class<T> cls) throws io.dcloud.uts.gson.JsonSyntaxException {
        return (T) io.dcloud.uts.gson.internal.Primitives.wrap(cls).cast(fromJson(str, (java.lang.reflect.Type) cls));
    }

    public <T> T fromJson(java.lang.String str, java.lang.reflect.Type type) throws io.dcloud.uts.gson.JsonSyntaxException {
        if (str == null) {
            return null;
        }
        return (T) fromJson(new java.io.StringReader(str), type);
    }

    public <T> T fromJson(java.io.Reader reader, java.lang.Class<T> cls) throws io.dcloud.uts.gson.JsonSyntaxException, io.dcloud.uts.gson.JsonIOException {
        io.dcloud.uts.gson.stream.JsonReader jsonReaderNewJsonReader = newJsonReader(reader);
        java.lang.Object objFromJson = fromJson(jsonReaderNewJsonReader, cls);
        assertFullConsumption(objFromJson, jsonReaderNewJsonReader);
        return (T) io.dcloud.uts.gson.internal.Primitives.wrap(cls).cast(objFromJson);
    }

    public <T> T fromJson(java.io.Reader reader, java.lang.reflect.Type type) throws io.dcloud.uts.gson.JsonSyntaxException, io.dcloud.uts.gson.JsonIOException {
        io.dcloud.uts.gson.stream.JsonReader jsonReaderNewJsonReader = newJsonReader(reader);
        T t = (T) fromJson(jsonReaderNewJsonReader, type);
        assertFullConsumption(t, jsonReaderNewJsonReader);
        return t;
    }

    private static void assertFullConsumption(java.lang.Object obj, io.dcloud.uts.gson.stream.JsonReader jsonReader) {
        if (obj != null) {
            try {
                if (jsonReader.peek() == io.dcloud.uts.gson.stream.JsonToken.END_DOCUMENT) {
                } else {
                    throw new io.dcloud.uts.gson.JsonIOException("JSON document was not fully consumed.");
                }
            } catch (io.dcloud.uts.gson.stream.MalformedJsonException e) {
                throw new io.dcloud.uts.gson.JsonSyntaxException(e);
            } catch (java.io.IOException e2) {
                throw new io.dcloud.uts.gson.JsonIOException(e2);
            }
        }
    }

    public <T> T fromJson(io.dcloud.uts.gson.stream.JsonReader jsonReader, java.lang.reflect.Type type) throws io.dcloud.uts.gson.JsonSyntaxException, io.dcloud.uts.gson.JsonIOException {
        boolean zIsLenient = jsonReader.isLenient();
        boolean z = true;
        jsonReader.setLenient(true);
        try {
            try {
                try {
                    jsonReader.peek();
                    z = false;
                    T t = getAdapter(io.dcloud.uts.gson.reflect.TypeToken.get(type)).read2(jsonReader);
                    jsonReader.setLenient(zIsLenient);
                    return t;
                } catch (java.io.IOException e) {
                    throw new io.dcloud.uts.gson.JsonSyntaxException(e);
                } catch (java.lang.IllegalStateException e2) {
                    throw new io.dcloud.uts.gson.JsonSyntaxException(e2);
                }
            } catch (java.io.EOFException e3) {
                if (!z) {
                    throw new io.dcloud.uts.gson.JsonSyntaxException(e3);
                }
                jsonReader.setLenient(zIsLenient);
                return null;
            } catch (java.lang.AssertionError e4) {
                java.lang.AssertionError assertionError = new java.lang.AssertionError("AssertionError (GSON): " + e4.getMessage());
                assertionError.initCause(e4);
                throw assertionError;
            }
        } catch (java.lang.Throwable th) {
            jsonReader.setLenient(zIsLenient);
            throw th;
        }
    }

    public <T> T fromJson(io.dcloud.uts.gson.JsonElement jsonElement, java.lang.Class<T> cls) throws io.dcloud.uts.gson.JsonSyntaxException {
        return (T) io.dcloud.uts.gson.internal.Primitives.wrap(cls).cast(fromJson(jsonElement, (java.lang.reflect.Type) cls));
    }

    public <T> T fromJson(io.dcloud.uts.gson.JsonElement jsonElement, java.lang.reflect.Type type) throws io.dcloud.uts.gson.JsonSyntaxException {
        if (jsonElement == null) {
            return null;
        }
        return (T) fromJson(new io.dcloud.uts.gson.internal.bind.JsonTreeReader(jsonElement), type);
    }

    static class FutureTypeAdapter<T> extends io.dcloud.uts.gson.TypeAdapter<T> {
        private io.dcloud.uts.gson.TypeAdapter<T> delegate;

        FutureTypeAdapter() {
        }

        public void setDelegate(io.dcloud.uts.gson.TypeAdapter<T> typeAdapter) {
            if (this.delegate != null) {
                throw new java.lang.AssertionError();
            }
            this.delegate = typeAdapter;
        }

        @Override // io.dcloud.uts.gson.TypeAdapter
        /* JADX INFO: renamed from: read */
        public T read2(io.dcloud.uts.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            io.dcloud.uts.gson.TypeAdapter<T> typeAdapter = this.delegate;
            if (typeAdapter == null) {
                throw new java.lang.IllegalStateException();
            }
            return typeAdapter.read2(jsonReader);
        }

        @Override // io.dcloud.uts.gson.TypeAdapter
        public void write(io.dcloud.uts.gson.stream.JsonWriter jsonWriter, T t) throws java.io.IOException {
            io.dcloud.uts.gson.TypeAdapter<T> typeAdapter = this.delegate;
            if (typeAdapter == null) {
                throw new java.lang.IllegalStateException();
            }
            typeAdapter.write(jsonWriter, t);
        }
    }

    public java.lang.String toString() {
        return "{serializeNulls:" + this.serializeNulls + ",factories:" + this.factories + ",instanceCreators:" + this.constructorConstructor + com.taobao.weex.el.parse.Operators.BLOCK_END_STR;
    }
}
