package com.bumptech.glide.load.data;

/* JADX INFO: loaded from: classes.dex */
public class DataRewinderRegistry {
    private static final com.bumptech.glide.load.data.DataRewinder.Factory<?> DEFAULT_FACTORY = new com.bumptech.glide.load.data.DataRewinder.Factory<java.lang.Object>() { // from class: com.bumptech.glide.load.data.DataRewinderRegistry.1
        @Override // com.bumptech.glide.load.data.DataRewinder.Factory
        public com.bumptech.glide.load.data.DataRewinder<java.lang.Object> build(java.lang.Object obj) {
            return new com.bumptech.glide.load.data.DataRewinderRegistry.DefaultRewinder(obj);
        }

        @Override // com.bumptech.glide.load.data.DataRewinder.Factory
        public java.lang.Class<java.lang.Object> getDataClass() {
            throw new java.lang.UnsupportedOperationException("Not implemented");
        }
    };
    private final java.util.Map<java.lang.Class<?>, com.bumptech.glide.load.data.DataRewinder.Factory<?>> rewinders = new java.util.HashMap();

    public synchronized void register(com.bumptech.glide.load.data.DataRewinder.Factory<?> factory) {
        this.rewinders.put(factory.getDataClass(), factory);
    }

    public synchronized <T> com.bumptech.glide.load.data.DataRewinder<T> build(T t) {
        com.bumptech.glide.load.data.DataRewinder.Factory<?> factory;
        com.bumptech.glide.util.Preconditions.checkNotNull(t);
        factory = this.rewinders.get(t.getClass());
        if (factory == null) {
            for (com.bumptech.glide.load.data.DataRewinder.Factory<?> factory2 : this.rewinders.values()) {
                if (factory2.getDataClass().isAssignableFrom(t.getClass())) {
                    factory = factory2;
                    break;
                }
            }
        }
        if (factory == null) {
            factory = DEFAULT_FACTORY;
        }
        return (com.bumptech.glide.load.data.DataRewinder<T>) factory.build(t);
    }

    private static final class DefaultRewinder implements com.bumptech.glide.load.data.DataRewinder<java.lang.Object> {
        private final java.lang.Object data;

        @Override // com.bumptech.glide.load.data.DataRewinder
        public void cleanup() {
        }

        DefaultRewinder(java.lang.Object obj) {
            this.data = obj;
        }

        @Override // com.bumptech.glide.load.data.DataRewinder
        public java.lang.Object rewindAndGet() {
            return this.data;
        }
    }
}
