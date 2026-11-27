package com.bumptech.glide.util;

/* JADX INFO: loaded from: classes.dex */
public final class GlideSuppliers {

    public interface GlideSupplier<T> {
        T get();
    }

    private GlideSuppliers() {
    }

    public static <T> com.bumptech.glide.util.GlideSuppliers.GlideSupplier<T> memorize(final com.bumptech.glide.util.GlideSuppliers.GlideSupplier<T> glideSupplier) {
        return new com.bumptech.glide.util.GlideSuppliers.GlideSupplier<T>() { // from class: com.bumptech.glide.util.GlideSuppliers.1
            private volatile T instance;

            @Override // com.bumptech.glide.util.GlideSuppliers.GlideSupplier
            public T get() {
                if (this.instance == null) {
                    synchronized (this) {
                        if (this.instance == null) {
                            this.instance = (T) com.bumptech.glide.util.Preconditions.checkNotNull(glideSupplier.get());
                        }
                    }
                }
                return this.instance;
            }
        };
    }
}
