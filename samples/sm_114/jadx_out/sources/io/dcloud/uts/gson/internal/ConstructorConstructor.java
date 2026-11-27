package io.dcloud.uts.gson.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class ConstructorConstructor {
    private final io.dcloud.uts.gson.internal.reflect.ReflectionAccessor accessor = io.dcloud.uts.gson.internal.reflect.ReflectionAccessor.getInstance();
    private final java.util.Map<java.lang.reflect.Type, io.dcloud.uts.gson.InstanceCreator<?>> instanceCreators;

    public ConstructorConstructor(java.util.Map<java.lang.reflect.Type, io.dcloud.uts.gson.InstanceCreator<?>> map) {
        this.instanceCreators = map;
    }

    public <T> io.dcloud.uts.gson.internal.ObjectConstructor<T> get(io.dcloud.uts.gson.reflect.TypeToken<T> typeToken) {
        final java.lang.reflect.Type type = typeToken.getType();
        java.lang.Class<? super T> rawType = typeToken.getRawType();
        final io.dcloud.uts.gson.InstanceCreator<?> instanceCreator = this.instanceCreators.get(type);
        if (instanceCreator != null) {
            return new io.dcloud.uts.gson.internal.ObjectConstructor<T>() { // from class: io.dcloud.uts.gson.internal.ConstructorConstructor.1
                @Override // io.dcloud.uts.gson.internal.ObjectConstructor
                public T construct() {
                    return (T) instanceCreator.createInstance(type);
                }
            };
        }
        final io.dcloud.uts.gson.InstanceCreator<?> instanceCreator2 = this.instanceCreators.get(rawType);
        if (instanceCreator2 != null) {
            return new io.dcloud.uts.gson.internal.ObjectConstructor<T>() { // from class: io.dcloud.uts.gson.internal.ConstructorConstructor.2
                @Override // io.dcloud.uts.gson.internal.ObjectConstructor
                public T construct() {
                    return (T) instanceCreator2.createInstance(type);
                }
            };
        }
        io.dcloud.uts.gson.internal.ObjectConstructor<T> objectConstructorNewDefaultConstructor = newDefaultConstructor(rawType);
        if (objectConstructorNewDefaultConstructor != null) {
            return objectConstructorNewDefaultConstructor;
        }
        io.dcloud.uts.gson.internal.ObjectConstructor<T> objectConstructorNewDefaultImplementationConstructor = newDefaultImplementationConstructor(type, rawType);
        return objectConstructorNewDefaultImplementationConstructor != null ? objectConstructorNewDefaultImplementationConstructor : newUnsafeAllocator(type, rawType);
    }

    private <T> io.dcloud.uts.gson.internal.ObjectConstructor<T> newDefaultConstructor(java.lang.Class<? super T> cls) {
        try {
            final java.lang.reflect.Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(null);
            if (!declaredConstructor.isAccessible()) {
                this.accessor.makeAccessible(declaredConstructor);
            }
            return new io.dcloud.uts.gson.internal.ObjectConstructor<T>() { // from class: io.dcloud.uts.gson.internal.ConstructorConstructor.3
                @Override // io.dcloud.uts.gson.internal.ObjectConstructor
                public T construct() {
                    try {
                        return (T) declaredConstructor.newInstance(null);
                    } catch (java.lang.IllegalAccessException e) {
                        throw new java.lang.AssertionError(e);
                    } catch (java.lang.InstantiationException e2) {
                        throw new java.lang.RuntimeException("Failed to invoke " + declaredConstructor + " with no args", e2);
                    } catch (java.lang.reflect.InvocationTargetException e3) {
                        throw new java.lang.RuntimeException("Failed to invoke " + declaredConstructor + " with no args", e3.getTargetException());
                    }
                }
            };
        } catch (java.lang.NoSuchMethodException unused) {
            return null;
        }
    }

    private <T> io.dcloud.uts.gson.internal.ObjectConstructor<T> newDefaultImplementationConstructor(final java.lang.reflect.Type type, java.lang.Class<? super T> cls) {
        if (java.util.Collection.class.isAssignableFrom(cls)) {
            if (java.util.SortedSet.class.isAssignableFrom(cls)) {
                return new io.dcloud.uts.gson.internal.ObjectConstructor<T>() { // from class: io.dcloud.uts.gson.internal.ConstructorConstructor.4
                    @Override // io.dcloud.uts.gson.internal.ObjectConstructor
                    public T construct() {
                        return (T) new java.util.TreeSet();
                    }
                };
            }
            if (java.util.EnumSet.class.isAssignableFrom(cls)) {
                return new io.dcloud.uts.gson.internal.ObjectConstructor<T>() { // from class: io.dcloud.uts.gson.internal.ConstructorConstructor.5
                    @Override // io.dcloud.uts.gson.internal.ObjectConstructor
                    public T construct() {
                        java.lang.reflect.Type type2 = type;
                        if (type2 instanceof java.lang.reflect.ParameterizedType) {
                            java.lang.reflect.Type type3 = ((java.lang.reflect.ParameterizedType) type2).getActualTypeArguments()[0];
                            if (type3 instanceof java.lang.Class) {
                                return (T) java.util.EnumSet.noneOf((java.lang.Class) type3);
                            }
                            throw new io.dcloud.uts.gson.JsonIOException("Invalid EnumSet type: " + type.toString());
                        }
                        throw new io.dcloud.uts.gson.JsonIOException("Invalid EnumSet type: " + type.toString());
                    }
                };
            }
            if (java.util.Set.class.isAssignableFrom(cls)) {
                return new io.dcloud.uts.gson.internal.ObjectConstructor<T>() { // from class: io.dcloud.uts.gson.internal.ConstructorConstructor.6
                    @Override // io.dcloud.uts.gson.internal.ObjectConstructor
                    public T construct() {
                        return (T) new java.util.LinkedHashSet();
                    }
                };
            }
            if (java.util.Queue.class.isAssignableFrom(cls)) {
                return new io.dcloud.uts.gson.internal.ObjectConstructor<T>() { // from class: io.dcloud.uts.gson.internal.ConstructorConstructor.7
                    @Override // io.dcloud.uts.gson.internal.ObjectConstructor
                    public T construct() {
                        return (T) new java.util.ArrayDeque();
                    }
                };
            }
            return new io.dcloud.uts.gson.internal.ObjectConstructor<T>() { // from class: io.dcloud.uts.gson.internal.ConstructorConstructor.8
                @Override // io.dcloud.uts.gson.internal.ObjectConstructor
                public T construct() {
                    return (T) new java.util.ArrayList();
                }
            };
        }
        if (!java.util.Map.class.isAssignableFrom(cls)) {
            return null;
        }
        if (java.util.concurrent.ConcurrentNavigableMap.class.isAssignableFrom(cls)) {
            return new io.dcloud.uts.gson.internal.ObjectConstructor<T>() { // from class: io.dcloud.uts.gson.internal.ConstructorConstructor.9
                @Override // io.dcloud.uts.gson.internal.ObjectConstructor
                public T construct() {
                    return (T) new java.util.concurrent.ConcurrentSkipListMap();
                }
            };
        }
        if (java.util.concurrent.ConcurrentMap.class.isAssignableFrom(cls)) {
            return new io.dcloud.uts.gson.internal.ObjectConstructor<T>() { // from class: io.dcloud.uts.gson.internal.ConstructorConstructor.10
                @Override // io.dcloud.uts.gson.internal.ObjectConstructor
                public T construct() {
                    return (T) new java.util.concurrent.ConcurrentHashMap();
                }
            };
        }
        if (java.util.SortedMap.class.isAssignableFrom(cls)) {
            return new io.dcloud.uts.gson.internal.ObjectConstructor<T>() { // from class: io.dcloud.uts.gson.internal.ConstructorConstructor.11
                @Override // io.dcloud.uts.gson.internal.ObjectConstructor
                public T construct() {
                    return (T) new java.util.TreeMap();
                }
            };
        }
        if ((type instanceof java.lang.reflect.ParameterizedType) && !java.lang.String.class.isAssignableFrom(io.dcloud.uts.gson.reflect.TypeToken.get(((java.lang.reflect.ParameterizedType) type).getActualTypeArguments()[0]).getRawType())) {
            return new io.dcloud.uts.gson.internal.ObjectConstructor<T>() { // from class: io.dcloud.uts.gson.internal.ConstructorConstructor.12
                @Override // io.dcloud.uts.gson.internal.ObjectConstructor
                public T construct() {
                    return (T) new java.util.LinkedHashMap();
                }
            };
        }
        return new io.dcloud.uts.gson.internal.ObjectConstructor<T>() { // from class: io.dcloud.uts.gson.internal.ConstructorConstructor.13
            @Override // io.dcloud.uts.gson.internal.ObjectConstructor
            public T construct() {
                return (T) new io.dcloud.uts.gson.internal.LinkedTreeMap();
            }
        };
    }

    private <T> io.dcloud.uts.gson.internal.ObjectConstructor<T> newUnsafeAllocator(final java.lang.reflect.Type type, final java.lang.Class<? super T> cls) {
        return new io.dcloud.uts.gson.internal.ObjectConstructor<T>() { // from class: io.dcloud.uts.gson.internal.ConstructorConstructor.14
            private final io.dcloud.uts.gson.internal.UnsafeAllocator unsafeAllocator = io.dcloud.uts.gson.internal.UnsafeAllocator.create();

            @Override // io.dcloud.uts.gson.internal.ObjectConstructor
            public T construct() {
                try {
                    return (T) this.unsafeAllocator.newInstance(cls);
                } catch (java.lang.Exception e) {
                    throw new java.lang.RuntimeException("Unable to invoke no-args constructor for " + type + ". Registering an InstanceCreator with Gson for this type may fix this problem.", e);
                }
            }
        };
    }

    public java.lang.String toString() {
        return this.instanceCreators.toString();
    }
}
