package io.dcloud.uts.gson.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class Excluder implements io.dcloud.uts.gson.TypeAdapterFactory, java.lang.Cloneable {
    public static final io.dcloud.uts.gson.internal.Excluder DEFAULT = new io.dcloud.uts.gson.internal.Excluder();
    private static final double IGNORE_VERSIONS = -1.0d;
    private boolean requireExpose;
    private double version = IGNORE_VERSIONS;
    private int modifiers = 136;
    private boolean serializeInnerClasses = true;
    private java.util.List<io.dcloud.uts.gson.ExclusionStrategy> serializationStrategies = java.util.Collections.EMPTY_LIST;
    private java.util.List<io.dcloud.uts.gson.ExclusionStrategy> deserializationStrategies = java.util.Collections.EMPTY_LIST;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public io.dcloud.uts.gson.internal.Excluder m535clone() {
        try {
            return (io.dcloud.uts.gson.internal.Excluder) super.clone();
        } catch (java.lang.CloneNotSupportedException e) {
            throw new java.lang.AssertionError(e);
        }
    }

    public io.dcloud.uts.gson.internal.Excluder withVersion(double d) {
        io.dcloud.uts.gson.internal.Excluder excluderM535clone = m535clone();
        excluderM535clone.version = d;
        return excluderM535clone;
    }

    public io.dcloud.uts.gson.internal.Excluder withModifiers(int... iArr) {
        io.dcloud.uts.gson.internal.Excluder excluderM535clone = m535clone();
        excluderM535clone.modifiers = 0;
        for (int i : iArr) {
            excluderM535clone.modifiers = i | excluderM535clone.modifiers;
        }
        return excluderM535clone;
    }

    public io.dcloud.uts.gson.internal.Excluder disableInnerClassSerialization() {
        io.dcloud.uts.gson.internal.Excluder excluderM535clone = m535clone();
        excluderM535clone.serializeInnerClasses = false;
        return excluderM535clone;
    }

    public io.dcloud.uts.gson.internal.Excluder excludeFieldsWithoutExposeAnnotation() {
        io.dcloud.uts.gson.internal.Excluder excluderM535clone = m535clone();
        excluderM535clone.requireExpose = true;
        return excluderM535clone;
    }

    public io.dcloud.uts.gson.internal.Excluder withExclusionStrategy(io.dcloud.uts.gson.ExclusionStrategy exclusionStrategy, boolean z, boolean z2) {
        io.dcloud.uts.gson.internal.Excluder excluderM535clone = m535clone();
        if (z) {
            java.util.ArrayList arrayList = new java.util.ArrayList(this.serializationStrategies);
            excluderM535clone.serializationStrategies = arrayList;
            arrayList.add(exclusionStrategy);
        }
        if (z2) {
            java.util.ArrayList arrayList2 = new java.util.ArrayList(this.deserializationStrategies);
            excluderM535clone.deserializationStrategies = arrayList2;
            arrayList2.add(exclusionStrategy);
        }
        return excluderM535clone;
    }

    @Override // io.dcloud.uts.gson.TypeAdapterFactory
    public <T> io.dcloud.uts.gson.TypeAdapter<T> create(final io.dcloud.uts.gson.Gson gson, final io.dcloud.uts.gson.reflect.TypeToken<T> typeToken) {
        java.lang.Class<? super T> rawType = typeToken.getRawType();
        boolean zExcludeClassChecks = excludeClassChecks(rawType);
        final boolean z = zExcludeClassChecks || excludeClassInStrategy(rawType, true);
        final boolean z2 = zExcludeClassChecks || excludeClassInStrategy(rawType, false);
        if (z || z2) {
            return new io.dcloud.uts.gson.TypeAdapter<T>() { // from class: io.dcloud.uts.gson.internal.Excluder.1
                private io.dcloud.uts.gson.TypeAdapter<T> delegate;

                @Override // io.dcloud.uts.gson.TypeAdapter
                /* JADX INFO: renamed from: read */
                public T read2(io.dcloud.uts.gson.stream.JsonReader jsonReader) throws java.io.IOException {
                    if (z2) {
                        jsonReader.skipValue();
                        return null;
                    }
                    return delegate().read2(jsonReader);
                }

                @Override // io.dcloud.uts.gson.TypeAdapter
                public void write(io.dcloud.uts.gson.stream.JsonWriter jsonWriter, T t) throws java.io.IOException {
                    if (z) {
                        jsonWriter.nullValue();
                    } else {
                        delegate().write(jsonWriter, t);
                    }
                }

                private io.dcloud.uts.gson.TypeAdapter<T> delegate() {
                    io.dcloud.uts.gson.TypeAdapter<T> typeAdapter = this.delegate;
                    if (typeAdapter != null) {
                        return typeAdapter;
                    }
                    io.dcloud.uts.gson.TypeAdapter<T> delegateAdapter = gson.getDelegateAdapter(io.dcloud.uts.gson.internal.Excluder.this, typeToken);
                    this.delegate = delegateAdapter;
                    return delegateAdapter;
                }
            };
        }
        return null;
    }

    public boolean excludeField(java.lang.reflect.Field field, boolean z) {
        io.dcloud.uts.gson.annotations.Expose expose;
        if ((this.modifiers & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.version != IGNORE_VERSIONS && !isValidVersion((io.dcloud.uts.gson.annotations.Since) field.getAnnotation(io.dcloud.uts.gson.annotations.Since.class), (io.dcloud.uts.gson.annotations.Until) field.getAnnotation(io.dcloud.uts.gson.annotations.Until.class))) || field.isSynthetic()) {
            return true;
        }
        if (this.requireExpose && ((expose = (io.dcloud.uts.gson.annotations.Expose) field.getAnnotation(io.dcloud.uts.gson.annotations.Expose.class)) == null || (!z ? expose.deserialize() : expose.serialize()))) {
            return true;
        }
        if ((!this.serializeInnerClasses && isInnerClass(field.getType())) || isAnonymousOrNonStaticLocal(field.getType())) {
            return true;
        }
        java.util.List<io.dcloud.uts.gson.ExclusionStrategy> list = z ? this.serializationStrategies : this.deserializationStrategies;
        if (list.isEmpty()) {
            return false;
        }
        io.dcloud.uts.gson.FieldAttributes fieldAttributes = new io.dcloud.uts.gson.FieldAttributes(field);
        java.util.Iterator<io.dcloud.uts.gson.ExclusionStrategy> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().shouldSkipField(fieldAttributes)) {
                return true;
            }
        }
        return false;
    }

    private boolean excludeClassChecks(java.lang.Class<?> cls) {
        if (this.version == IGNORE_VERSIONS || isValidVersion((io.dcloud.uts.gson.annotations.Since) cls.getAnnotation(io.dcloud.uts.gson.annotations.Since.class), (io.dcloud.uts.gson.annotations.Until) cls.getAnnotation(io.dcloud.uts.gson.annotations.Until.class))) {
            return (!this.serializeInnerClasses && isInnerClass(cls)) || isAnonymousOrNonStaticLocal(cls);
        }
        return true;
    }

    public boolean excludeClass(java.lang.Class<?> cls, boolean z) {
        return excludeClassChecks(cls) || excludeClassInStrategy(cls, z);
    }

    private boolean excludeClassInStrategy(java.lang.Class<?> cls, boolean z) {
        java.util.Iterator<io.dcloud.uts.gson.ExclusionStrategy> it = (z ? this.serializationStrategies : this.deserializationStrategies).iterator();
        while (it.hasNext()) {
            if (it.next().shouldSkipClass(cls)) {
                return true;
            }
        }
        return false;
    }

    private boolean isAnonymousOrNonStaticLocal(java.lang.Class<?> cls) {
        if (java.lang.Enum.class.isAssignableFrom(cls) || isStatic(cls)) {
            return false;
        }
        return cls.isAnonymousClass() || cls.isLocalClass();
    }

    private boolean isInnerClass(java.lang.Class<?> cls) {
        return cls.isMemberClass() && !isStatic(cls);
    }

    private boolean isStatic(java.lang.Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    private boolean isValidVersion(io.dcloud.uts.gson.annotations.Since since, io.dcloud.uts.gson.annotations.Until until) {
        return isValidSince(since) && isValidUntil(until);
    }

    private boolean isValidSince(io.dcloud.uts.gson.annotations.Since since) {
        return since == null || since.value() <= this.version;
    }

    private boolean isValidUntil(io.dcloud.uts.gson.annotations.Until until) {
        return until == null || until.value() > this.version;
    }
}
