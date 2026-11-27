package com.alibaba.fastjson.support.spring;

/* JADX INFO: loaded from: classes.dex */
public class FastJsonHttpMessageConverter extends org.springframework.http.converter.AbstractHttpMessageConverter<java.lang.Object> implements org.springframework.http.converter.GenericHttpMessageConverter<java.lang.Object> {
    public static final org.springframework.http.MediaType APPLICATION_JAVASCRIPT = new org.springframework.http.MediaType("application", "javascript");

    @java.lang.Deprecated
    protected java.lang.String dateFormat;
    private com.alibaba.fastjson.support.config.FastJsonConfig fastJsonConfig;

    @java.lang.Deprecated
    protected com.alibaba.fastjson.serializer.SerializerFeature[] features;

    @java.lang.Deprecated
    protected com.alibaba.fastjson.serializer.SerializeFilter[] filters;
    private boolean setLengthError;

    protected boolean supports(java.lang.Class<?> cls) {
        return true;
    }

    public com.alibaba.fastjson.support.config.FastJsonConfig getFastJsonConfig() {
        return this.fastJsonConfig;
    }

    public void setFastJsonConfig(com.alibaba.fastjson.support.config.FastJsonConfig fastJsonConfig) {
        this.fastJsonConfig = fastJsonConfig;
    }

    public FastJsonHttpMessageConverter() {
        super(org.springframework.http.MediaType.ALL);
        this.features = new com.alibaba.fastjson.serializer.SerializerFeature[0];
        this.filters = new com.alibaba.fastjson.serializer.SerializeFilter[0];
        this.setLengthError = false;
        this.fastJsonConfig = new com.alibaba.fastjson.support.config.FastJsonConfig();
    }

    @java.lang.Deprecated
    public java.nio.charset.Charset getCharset() {
        return this.fastJsonConfig.getCharset();
    }

    @java.lang.Deprecated
    public void setCharset(java.nio.charset.Charset charset) {
        this.fastJsonConfig.setCharset(charset);
    }

    @java.lang.Deprecated
    public java.lang.String getDateFormat() {
        return this.fastJsonConfig.getDateFormat();
    }

    @java.lang.Deprecated
    public void setDateFormat(java.lang.String str) {
        this.fastJsonConfig.setDateFormat(str);
    }

    @java.lang.Deprecated
    public com.alibaba.fastjson.serializer.SerializerFeature[] getFeatures() {
        return this.fastJsonConfig.getSerializerFeatures();
    }

    @java.lang.Deprecated
    public void setFeatures(com.alibaba.fastjson.serializer.SerializerFeature... serializerFeatureArr) {
        this.fastJsonConfig.setSerializerFeatures(serializerFeatureArr);
    }

    @java.lang.Deprecated
    public com.alibaba.fastjson.serializer.SerializeFilter[] getFilters() {
        return this.fastJsonConfig.getSerializeFilters();
    }

    @java.lang.Deprecated
    public void setFilters(com.alibaba.fastjson.serializer.SerializeFilter... serializeFilterArr) {
        this.fastJsonConfig.setSerializeFilters(serializeFilterArr);
    }

    @java.lang.Deprecated
    public void addSerializeFilter(com.alibaba.fastjson.serializer.SerializeFilter serializeFilter) {
        if (serializeFilter == null) {
            return;
        }
        int length = this.fastJsonConfig.getSerializeFilters().length;
        com.alibaba.fastjson.serializer.SerializeFilter[] serializeFilterArr = new com.alibaba.fastjson.serializer.SerializeFilter[length + 1];
        java.lang.System.arraycopy(this.fastJsonConfig.getSerializeFilters(), 0, serializeFilterArr, 0, length);
        serializeFilterArr[length] = serializeFilter;
        this.fastJsonConfig.setSerializeFilters(serializeFilterArr);
    }

    public boolean canRead(java.lang.reflect.Type type, java.lang.Class<?> cls, org.springframework.http.MediaType mediaType) {
        return super.canRead(cls, mediaType);
    }

    public boolean canWrite(java.lang.reflect.Type type, java.lang.Class<?> cls, org.springframework.http.MediaType mediaType) {
        return super.canWrite(cls, mediaType);
    }

    public java.lang.Object read(java.lang.reflect.Type type, java.lang.Class<?> cls, org.springframework.http.HttpInputMessage httpInputMessage) throws java.io.IOException, org.springframework.http.converter.HttpMessageNotReadableException {
        return readType(getType(type, cls), httpInputMessage);
    }

    public void write(java.lang.Object obj, java.lang.reflect.Type type, org.springframework.http.MediaType mediaType, org.springframework.http.HttpOutputMessage httpOutputMessage) throws java.io.IOException, org.springframework.http.converter.HttpMessageNotWritableException {
        super.write(obj, mediaType, httpOutputMessage);
    }

    protected java.lang.Object readInternal(java.lang.Class<?> cls, org.springframework.http.HttpInputMessage httpInputMessage) throws java.io.IOException, org.springframework.http.converter.HttpMessageNotReadableException {
        return readType(getType(cls, null), httpInputMessage);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.springframework.http.converter.HttpMessageNotReadableException */
    private java.lang.Object readType(java.lang.reflect.Type type, org.springframework.http.HttpInputMessage httpInputMessage) throws org.springframework.http.converter.HttpMessageNotReadableException {
        try {
            return com.alibaba.fastjson.JSON.parseObject(httpInputMessage.getBody(), this.fastJsonConfig.getCharset(), type, this.fastJsonConfig.getParserConfig(), this.fastJsonConfig.getParseProcess(), com.alibaba.fastjson.JSON.DEFAULT_PARSER_FEATURE, this.fastJsonConfig.getFeatures());
        } catch (com.alibaba.fastjson.JSONException e) {
            throw new org.springframework.http.converter.HttpMessageNotReadableException("JSON parse error: " + e.getMessage(), e);
        } catch (java.io.IOException e2) {
            throw new org.springframework.http.converter.HttpMessageNotReadableException("I/O error while reading input message", e2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x004c  */
    protected void writeInternal(java.lang.Object obj, org.springframework.http.HttpOutputMessage httpOutputMessage) throws java.io.IOException, org.springframework.http.converter.HttpMessageNotWritableException {
        boolean z;
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        try {
            try {
                org.springframework.http.HttpHeaders headers = httpOutputMessage.getHeaders();
                java.util.ArrayList arrayList = new java.util.ArrayList(java.util.Arrays.asList(this.fastJsonConfig.getSerializeFilters()));
                java.lang.Object objStrangeCodeForJackson = strangeCodeForJackson(obj);
                if (objStrangeCodeForJackson instanceof com.alibaba.fastjson.support.spring.FastJsonContainer) {
                    com.alibaba.fastjson.support.spring.FastJsonContainer fastJsonContainer = (com.alibaba.fastjson.support.spring.FastJsonContainer) objStrangeCodeForJackson;
                    arrayList.addAll(fastJsonContainer.getFilters().getFilters());
                    objStrangeCodeForJackson = fastJsonContainer.getValue();
                }
                if (objStrangeCodeForJackson instanceof com.alibaba.fastjson.support.spring.MappingFastJsonValue) {
                    if (org.springframework.util.StringUtils.isEmpty(((com.alibaba.fastjson.support.spring.MappingFastJsonValue) objStrangeCodeForJackson).getJsonpFunction())) {
                        z = false;
                    } else {
                        z = true;
                    }
                } else if (objStrangeCodeForJackson instanceof com.alibaba.fastjson.JSONPObject) {
                    z = true;
                } else {
                    z = false;
                }
                int iWriteJSONStringWithFastJsonConfig = com.alibaba.fastjson.JSON.writeJSONStringWithFastJsonConfig(byteArrayOutputStream, this.fastJsonConfig.getCharset(), objStrangeCodeForJackson, this.fastJsonConfig.getSerializeConfig(), (com.alibaba.fastjson.serializer.SerializeFilter[]) arrayList.toArray(new com.alibaba.fastjson.serializer.SerializeFilter[arrayList.size()]), this.fastJsonConfig.getDateFormat(), com.alibaba.fastjson.JSON.DEFAULT_GENERATE_FEATURE, this.fastJsonConfig.getSerializerFeatures());
                if (z) {
                    headers.setContentType(APPLICATION_JAVASCRIPT);
                }
                if (this.fastJsonConfig.isWriteContentLength() && !this.setLengthError) {
                    try {
                        headers.setContentLength(iWriteJSONStringWithFastJsonConfig);
                    } catch (java.lang.UnsupportedOperationException unused) {
                        this.setLengthError = true;
                    }
                }
                byteArrayOutputStream.writeTo(httpOutputMessage.getBody());
                byteArrayOutputStream.close();
            } catch (com.alibaba.fastjson.JSONException e) {
                throw new org.springframework.http.converter.HttpMessageNotWritableException("Could not write JSON: " + e.getMessage(), e);
            }
        } catch (java.lang.Throwable th) {
            byteArrayOutputStream.close();
            throw th;
        }
    }

    private java.lang.Object strangeCodeForJackson(java.lang.Object obj) {
        return (obj == null || !"com.fasterxml.jackson.databind.node.ObjectNode".equals(obj.getClass().getName())) ? obj : obj.toString();
    }

    protected java.lang.reflect.Type getType(java.lang.reflect.Type type, java.lang.Class<?> cls) {
        return com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter.Spring4TypeResolvableHelper.isSupport() ? com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter.Spring4TypeResolvableHelper.getType(type, cls) : type;
    }

    private static class Spring4TypeResolvableHelper {
        private static boolean hasClazzResolvableType;

        private Spring4TypeResolvableHelper() {
        }

        static {
            try {
                java.lang.Class.forName("org.springframework.core.ResolvableType");
                hasClazzResolvableType = true;
            } catch (java.lang.ClassNotFoundException unused) {
                hasClazzResolvableType = false;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isSupport() {
            return hasClazzResolvableType;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static java.lang.reflect.Type getType(java.lang.reflect.Type type, java.lang.Class<?> cls) {
            if (cls == null) {
                return type;
            }
            org.springframework.core.ResolvableType resolvableTypeForType = org.springframework.core.ResolvableType.forType(type);
            if (type instanceof java.lang.reflect.TypeVariable) {
                org.springframework.core.ResolvableType resolvableTypeResolveVariable = resolveVariable((java.lang.reflect.TypeVariable) type, org.springframework.core.ResolvableType.forClass(cls));
                return resolvableTypeResolveVariable != org.springframework.core.ResolvableType.NONE ? resolvableTypeResolveVariable.resolve() : type;
            }
            if (!(type instanceof java.lang.reflect.ParameterizedType) || !resolvableTypeForType.hasUnresolvableGenerics()) {
                return type;
            }
            java.lang.reflect.ParameterizedType parameterizedType = (java.lang.reflect.ParameterizedType) type;
            java.lang.Class[] clsArr = new java.lang.Class[parameterizedType.getActualTypeArguments().length];
            java.lang.reflect.Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            for (int i = 0; i < actualTypeArguments.length; i++) {
                java.lang.reflect.Type type2 = actualTypeArguments[i];
                if (type2 instanceof java.lang.reflect.TypeVariable) {
                    org.springframework.core.ResolvableType resolvableTypeResolveVariable2 = resolveVariable((java.lang.reflect.TypeVariable) type2, org.springframework.core.ResolvableType.forClass(cls));
                    if (resolvableTypeResolveVariable2 != org.springframework.core.ResolvableType.NONE) {
                        clsArr[i] = resolvableTypeResolveVariable2.resolve();
                    } else {
                        clsArr[i] = org.springframework.core.ResolvableType.forType(type2).resolve();
                    }
                } else {
                    clsArr[i] = org.springframework.core.ResolvableType.forType(type2).resolve();
                }
            }
            return org.springframework.core.ResolvableType.forClassWithGenerics(resolvableTypeForType.getRawClass(), clsArr).getType();
        }

        private static org.springframework.core.ResolvableType resolveVariable(java.lang.reflect.TypeVariable<?> typeVariable, org.springframework.core.ResolvableType resolvableType) {
            if (resolvableType.hasGenerics()) {
                org.springframework.core.ResolvableType resolvableTypeForType = org.springframework.core.ResolvableType.forType(typeVariable, resolvableType);
                if (resolvableTypeForType.resolve() != null) {
                    return resolvableTypeForType;
                }
            }
            org.springframework.core.ResolvableType superType = resolvableType.getSuperType();
            if (superType != org.springframework.core.ResolvableType.NONE) {
                org.springframework.core.ResolvableType resolvableTypeResolveVariable = resolveVariable(typeVariable, superType);
                if (resolvableTypeResolveVariable.resolve() != null) {
                    return resolvableTypeResolveVariable;
                }
            }
            for (org.springframework.core.ResolvableType resolvableType2 : resolvableType.getInterfaces()) {
                org.springframework.core.ResolvableType resolvableTypeResolveVariable2 = resolveVariable(typeVariable, resolvableType2);
                if (resolvableTypeResolveVariable2.resolve() != null) {
                    return resolvableTypeResolveVariable2;
                }
            }
            return org.springframework.core.ResolvableType.NONE;
        }
    }
}
