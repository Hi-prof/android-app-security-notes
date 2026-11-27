package io.dcloud.uts.gson;

/* JADX INFO: loaded from: classes2.dex */
public final class GsonBuilder {
    private boolean complexMapKeySerialization;
    private java.lang.String datePattern;
    private int dateStyle;
    private boolean escapeHtmlChars;
    private io.dcloud.uts.gson.internal.Excluder excluder;
    private final java.util.List<io.dcloud.uts.gson.TypeAdapterFactory> factories;
    private io.dcloud.uts.gson.FieldNamingStrategy fieldNamingPolicy;
    private boolean generateNonExecutableJson;
    private final java.util.List<io.dcloud.uts.gson.TypeAdapterFactory> hierarchyFactories;
    private final java.util.Map<java.lang.reflect.Type, io.dcloud.uts.gson.InstanceCreator<?>> instanceCreators;
    private boolean lenient;
    private io.dcloud.uts.gson.LongSerializationPolicy longSerializationPolicy;
    private io.dcloud.uts.gson.ToNumberStrategy numberToNumberStrategy;
    private io.dcloud.uts.gson.ToNumberStrategy objectToNumberStrategy;
    private boolean prettyPrinting;
    private boolean serializeNulls;
    private boolean serializeSpecialFloatingPointValues;
    private int timeStyle;

    public GsonBuilder() {
        this.excluder = io.dcloud.uts.gson.internal.Excluder.DEFAULT;
        this.longSerializationPolicy = io.dcloud.uts.gson.LongSerializationPolicy.DEFAULT;
        this.fieldNamingPolicy = io.dcloud.uts.gson.FieldNamingPolicy.IDENTITY;
        this.instanceCreators = new java.util.HashMap();
        this.factories = new java.util.ArrayList();
        this.hierarchyFactories = new java.util.ArrayList();
        this.serializeNulls = false;
        this.dateStyle = 2;
        this.timeStyle = 2;
        this.complexMapKeySerialization = false;
        this.serializeSpecialFloatingPointValues = false;
        this.escapeHtmlChars = true;
        this.prettyPrinting = false;
        this.generateNonExecutableJson = false;
        this.lenient = false;
        this.objectToNumberStrategy = io.dcloud.uts.gson.ToNumberPolicy.DOUBLE;
        this.numberToNumberStrategy = io.dcloud.uts.gson.ToNumberPolicy.LAZILY_PARSED_NUMBER;
    }

    GsonBuilder(io.dcloud.uts.gson.Gson gson) {
        this.excluder = io.dcloud.uts.gson.internal.Excluder.DEFAULT;
        this.longSerializationPolicy = io.dcloud.uts.gson.LongSerializationPolicy.DEFAULT;
        this.fieldNamingPolicy = io.dcloud.uts.gson.FieldNamingPolicy.IDENTITY;
        java.util.HashMap map = new java.util.HashMap();
        this.instanceCreators = map;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        this.factories = arrayList;
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        this.hierarchyFactories = arrayList2;
        this.serializeNulls = false;
        this.dateStyle = 2;
        this.timeStyle = 2;
        this.complexMapKeySerialization = false;
        this.serializeSpecialFloatingPointValues = false;
        this.escapeHtmlChars = true;
        this.prettyPrinting = false;
        this.generateNonExecutableJson = false;
        this.lenient = false;
        this.objectToNumberStrategy = io.dcloud.uts.gson.ToNumberPolicy.DOUBLE;
        this.numberToNumberStrategy = io.dcloud.uts.gson.ToNumberPolicy.LAZILY_PARSED_NUMBER;
        this.excluder = gson.excluder;
        this.fieldNamingPolicy = gson.fieldNamingStrategy;
        map.putAll(gson.instanceCreators);
        this.serializeNulls = gson.serializeNulls;
        this.complexMapKeySerialization = gson.complexMapKeySerialization;
        this.generateNonExecutableJson = gson.generateNonExecutableJson;
        this.escapeHtmlChars = gson.htmlSafe;
        this.prettyPrinting = gson.prettyPrinting;
        this.lenient = gson.lenient;
        this.serializeSpecialFloatingPointValues = gson.serializeSpecialFloatingPointValues;
        this.longSerializationPolicy = gson.longSerializationPolicy;
        this.datePattern = gson.datePattern;
        this.dateStyle = gson.dateStyle;
        this.timeStyle = gson.timeStyle;
        arrayList.addAll(gson.builderFactories);
        arrayList2.addAll(gson.builderHierarchyFactories);
        this.objectToNumberStrategy = gson.objectToNumberStrategy;
        this.numberToNumberStrategy = gson.numberToNumberStrategy;
    }

    public io.dcloud.uts.gson.GsonBuilder setVersion(double d) {
        this.excluder = this.excluder.withVersion(d);
        return this;
    }

    public io.dcloud.uts.gson.GsonBuilder excludeFieldsWithModifiers(int... iArr) {
        this.excluder = this.excluder.withModifiers(iArr);
        return this;
    }

    public io.dcloud.uts.gson.GsonBuilder generateNonExecutableJson() {
        this.generateNonExecutableJson = true;
        return this;
    }

    public io.dcloud.uts.gson.GsonBuilder excludeFieldsWithoutExposeAnnotation() {
        this.excluder = this.excluder.excludeFieldsWithoutExposeAnnotation();
        return this;
    }

    public io.dcloud.uts.gson.GsonBuilder serializeNulls() {
        this.serializeNulls = true;
        return this;
    }

    public io.dcloud.uts.gson.GsonBuilder enableComplexMapKeySerialization() {
        this.complexMapKeySerialization = true;
        return this;
    }

    public io.dcloud.uts.gson.GsonBuilder disableInnerClassSerialization() {
        this.excluder = this.excluder.disableInnerClassSerialization();
        return this;
    }

    public io.dcloud.uts.gson.GsonBuilder setLongSerializationPolicy(io.dcloud.uts.gson.LongSerializationPolicy longSerializationPolicy) {
        this.longSerializationPolicy = longSerializationPolicy;
        return this;
    }

    public io.dcloud.uts.gson.GsonBuilder setFieldNamingPolicy(io.dcloud.uts.gson.FieldNamingPolicy fieldNamingPolicy) {
        this.fieldNamingPolicy = fieldNamingPolicy;
        return this;
    }

    public io.dcloud.uts.gson.GsonBuilder setFieldNamingStrategy(io.dcloud.uts.gson.FieldNamingStrategy fieldNamingStrategy) {
        this.fieldNamingPolicy = fieldNamingStrategy;
        return this;
    }

    public io.dcloud.uts.gson.GsonBuilder setObjectToNumberStrategy(io.dcloud.uts.gson.ToNumberStrategy toNumberStrategy) {
        this.objectToNumberStrategy = toNumberStrategy;
        return this;
    }

    public io.dcloud.uts.gson.GsonBuilder setNumberToNumberStrategy(io.dcloud.uts.gson.ToNumberStrategy toNumberStrategy) {
        this.numberToNumberStrategy = toNumberStrategy;
        return this;
    }

    public io.dcloud.uts.gson.GsonBuilder setExclusionStrategies(io.dcloud.uts.gson.ExclusionStrategy... exclusionStrategyArr) {
        for (io.dcloud.uts.gson.ExclusionStrategy exclusionStrategy : exclusionStrategyArr) {
            this.excluder = this.excluder.withExclusionStrategy(exclusionStrategy, true, true);
        }
        return this;
    }

    public io.dcloud.uts.gson.GsonBuilder addSerializationExclusionStrategy(io.dcloud.uts.gson.ExclusionStrategy exclusionStrategy) {
        this.excluder = this.excluder.withExclusionStrategy(exclusionStrategy, true, false);
        return this;
    }

    public io.dcloud.uts.gson.GsonBuilder addDeserializationExclusionStrategy(io.dcloud.uts.gson.ExclusionStrategy exclusionStrategy) {
        this.excluder = this.excluder.withExclusionStrategy(exclusionStrategy, false, true);
        return this;
    }

    public io.dcloud.uts.gson.GsonBuilder setPrettyPrinting() {
        this.prettyPrinting = true;
        return this;
    }

    public io.dcloud.uts.gson.GsonBuilder setLenient() {
        this.lenient = true;
        return this;
    }

    public io.dcloud.uts.gson.GsonBuilder disableHtmlEscaping() {
        this.escapeHtmlChars = false;
        return this;
    }

    public io.dcloud.uts.gson.GsonBuilder setDateFormat(java.lang.String str) {
        this.datePattern = str;
        return this;
    }

    public io.dcloud.uts.gson.GsonBuilder setDateFormat(int i) {
        this.dateStyle = i;
        this.datePattern = null;
        return this;
    }

    public io.dcloud.uts.gson.GsonBuilder setDateFormat(int i, int i2) {
        this.dateStyle = i;
        this.timeStyle = i2;
        this.datePattern = null;
        return this;
    }

    public io.dcloud.uts.gson.GsonBuilder registerTypeAdapter(java.lang.reflect.Type type, java.lang.Object obj) {
        boolean z = obj instanceof io.dcloud.uts.gson.JsonSerializer;
        io.dcloud.uts.gson.internal.C$Gson$Preconditions.checkArgument(z || (obj instanceof io.dcloud.uts.gson.JsonDeserializer) || (obj instanceof io.dcloud.uts.gson.InstanceCreator) || (obj instanceof io.dcloud.uts.gson.TypeAdapter));
        if (obj instanceof io.dcloud.uts.gson.InstanceCreator) {
            this.instanceCreators.put(type, (io.dcloud.uts.gson.InstanceCreator) obj);
        }
        if (z || (obj instanceof io.dcloud.uts.gson.JsonDeserializer)) {
            this.factories.add(io.dcloud.uts.gson.internal.bind.TreeTypeAdapter.newFactoryWithMatchRawType(io.dcloud.uts.gson.reflect.TypeToken.get(type), obj));
        }
        if (obj instanceof io.dcloud.uts.gson.TypeAdapter) {
            this.factories.add(io.dcloud.uts.gson.internal.bind.TypeAdapters.newFactory(io.dcloud.uts.gson.reflect.TypeToken.get(type), (io.dcloud.uts.gson.TypeAdapter) obj));
        }
        return this;
    }

    public io.dcloud.uts.gson.GsonBuilder registerTypeAdapterFactory(io.dcloud.uts.gson.TypeAdapterFactory typeAdapterFactory) {
        this.factories.add(typeAdapterFactory);
        return this;
    }

    public io.dcloud.uts.gson.GsonBuilder registerTypeHierarchyAdapter(java.lang.Class<?> cls, java.lang.Object obj) {
        boolean z = obj instanceof io.dcloud.uts.gson.JsonSerializer;
        io.dcloud.uts.gson.internal.C$Gson$Preconditions.checkArgument(z || (obj instanceof io.dcloud.uts.gson.JsonDeserializer) || (obj instanceof io.dcloud.uts.gson.TypeAdapter));
        if ((obj instanceof io.dcloud.uts.gson.JsonDeserializer) || z) {
            this.hierarchyFactories.add(io.dcloud.uts.gson.internal.bind.TreeTypeAdapter.newTypeHierarchyFactory(cls, obj));
        }
        if (obj instanceof io.dcloud.uts.gson.TypeAdapter) {
            this.factories.add(io.dcloud.uts.gson.internal.bind.TypeAdapters.newTypeHierarchyFactory(cls, (io.dcloud.uts.gson.TypeAdapter) obj));
        }
        return this;
    }

    public io.dcloud.uts.gson.GsonBuilder serializeSpecialFloatingPointValues() {
        this.serializeSpecialFloatingPointValues = true;
        return this;
    }

    public io.dcloud.uts.gson.Gson create() {
        java.util.List<io.dcloud.uts.gson.TypeAdapterFactory> arrayList = new java.util.ArrayList<>(this.factories.size() + this.hierarchyFactories.size() + 3);
        arrayList.addAll(this.factories);
        java.util.Collections.reverse(arrayList);
        java.util.ArrayList arrayList2 = new java.util.ArrayList(this.hierarchyFactories);
        java.util.Collections.reverse(arrayList2);
        arrayList.addAll(arrayList2);
        addTypeAdaptersForDate(this.datePattern, this.dateStyle, this.timeStyle, arrayList);
        return new io.dcloud.uts.gson.Gson(this.excluder, this.fieldNamingPolicy, this.instanceCreators, this.serializeNulls, this.complexMapKeySerialization, this.generateNonExecutableJson, this.escapeHtmlChars, this.prettyPrinting, this.lenient, this.serializeSpecialFloatingPointValues, this.longSerializationPolicy, this.datePattern, this.dateStyle, this.timeStyle, this.factories, this.hierarchyFactories, arrayList, this.objectToNumberStrategy, this.numberToNumberStrategy);
    }

    private void addTypeAdaptersForDate(java.lang.String str, int i, int i2, java.util.List<io.dcloud.uts.gson.TypeAdapterFactory> list) {
        io.dcloud.uts.gson.TypeAdapterFactory typeAdapterFactoryCreateAdapterFactory;
        io.dcloud.uts.gson.TypeAdapterFactory typeAdapterFactoryCreateAdapterFactory2;
        boolean z = io.dcloud.uts.gson.internal.sql.SqlTypesSupport.SUPPORTS_SQL_TYPES;
        io.dcloud.uts.gson.TypeAdapterFactory typeAdapterFactoryCreateAdapterFactory3 = null;
        if (str != null && !str.trim().isEmpty()) {
            typeAdapterFactoryCreateAdapterFactory = io.dcloud.uts.gson.internal.bind.DefaultDateTypeAdapter.DateType.DATE.createAdapterFactory(str);
            if (z) {
                typeAdapterFactoryCreateAdapterFactory3 = io.dcloud.uts.gson.internal.sql.SqlTypesSupport.TIMESTAMP_DATE_TYPE.createAdapterFactory(str);
                typeAdapterFactoryCreateAdapterFactory2 = io.dcloud.uts.gson.internal.sql.SqlTypesSupport.DATE_DATE_TYPE.createAdapterFactory(str);
            } else {
                typeAdapterFactoryCreateAdapterFactory2 = null;
            }
        } else {
            if (i == 2 || i2 == 2) {
                return;
            }
            io.dcloud.uts.gson.TypeAdapterFactory typeAdapterFactoryCreateAdapterFactory4 = io.dcloud.uts.gson.internal.bind.DefaultDateTypeAdapter.DateType.DATE.createAdapterFactory(i, i2);
            if (z) {
                typeAdapterFactoryCreateAdapterFactory3 = io.dcloud.uts.gson.internal.sql.SqlTypesSupport.TIMESTAMP_DATE_TYPE.createAdapterFactory(i, i2);
                io.dcloud.uts.gson.TypeAdapterFactory typeAdapterFactoryCreateAdapterFactory5 = io.dcloud.uts.gson.internal.sql.SqlTypesSupport.DATE_DATE_TYPE.createAdapterFactory(i, i2);
                typeAdapterFactoryCreateAdapterFactory = typeAdapterFactoryCreateAdapterFactory4;
                typeAdapterFactoryCreateAdapterFactory2 = typeAdapterFactoryCreateAdapterFactory5;
            } else {
                typeAdapterFactoryCreateAdapterFactory = typeAdapterFactoryCreateAdapterFactory4;
                typeAdapterFactoryCreateAdapterFactory2 = null;
            }
        }
        list.add(typeAdapterFactoryCreateAdapterFactory);
        if (z) {
            list.add(typeAdapterFactoryCreateAdapterFactory3);
            list.add(typeAdapterFactoryCreateAdapterFactory2);
        }
    }
}
