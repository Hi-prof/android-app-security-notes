package com.bumptech.glide.load.model;

/* JADX INFO: loaded from: classes.dex */
public interface Headers {

    @java.lang.Deprecated
    public static final com.bumptech.glide.load.model.Headers NONE = new com.bumptech.glide.load.model.Headers() { // from class: com.bumptech.glide.load.model.Headers.1
        @Override // com.bumptech.glide.load.model.Headers
        public java.util.Map<java.lang.String, java.lang.String> getHeaders() {
            return java.util.Collections.EMPTY_MAP;
        }
    };
    public static final com.bumptech.glide.load.model.Headers DEFAULT = new com.bumptech.glide.load.model.LazyHeaders.Builder().build();

    java.util.Map<java.lang.String, java.lang.String> getHeaders();
}
