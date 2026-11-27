package com.alibaba.fastjson.serializer;

/* JADX INFO: loaded from: classes.dex */
public abstract class SerializeFilterable {
    protected java.util.List<com.alibaba.fastjson.serializer.BeforeFilter> beforeFilters = null;
    protected java.util.List<com.alibaba.fastjson.serializer.AfterFilter> afterFilters = null;
    protected java.util.List<com.alibaba.fastjson.serializer.PropertyFilter> propertyFilters = null;
    protected java.util.List<com.alibaba.fastjson.serializer.ValueFilter> valueFilters = null;
    protected java.util.List<com.alibaba.fastjson.serializer.NameFilter> nameFilters = null;
    protected java.util.List<com.alibaba.fastjson.serializer.PropertyPreFilter> propertyPreFilters = null;
    protected java.util.List<com.alibaba.fastjson.serializer.LabelFilter> labelFilters = null;
    protected java.util.List<com.alibaba.fastjson.serializer.ContextValueFilter> contextValueFilters = null;
    protected boolean writeDirect = true;

    public java.util.List<com.alibaba.fastjson.serializer.BeforeFilter> getBeforeFilters() {
        if (this.beforeFilters == null) {
            this.beforeFilters = new java.util.ArrayList();
            this.writeDirect = false;
        }
        return this.beforeFilters;
    }

    public java.util.List<com.alibaba.fastjson.serializer.AfterFilter> getAfterFilters() {
        if (this.afterFilters == null) {
            this.afterFilters = new java.util.ArrayList();
            this.writeDirect = false;
        }
        return this.afterFilters;
    }

    public java.util.List<com.alibaba.fastjson.serializer.NameFilter> getNameFilters() {
        if (this.nameFilters == null) {
            this.nameFilters = new java.util.ArrayList();
            this.writeDirect = false;
        }
        return this.nameFilters;
    }

    public java.util.List<com.alibaba.fastjson.serializer.PropertyPreFilter> getPropertyPreFilters() {
        if (this.propertyPreFilters == null) {
            this.propertyPreFilters = new java.util.ArrayList();
            this.writeDirect = false;
        }
        return this.propertyPreFilters;
    }

    public java.util.List<com.alibaba.fastjson.serializer.LabelFilter> getLabelFilters() {
        if (this.labelFilters == null) {
            this.labelFilters = new java.util.ArrayList();
            this.writeDirect = false;
        }
        return this.labelFilters;
    }

    public java.util.List<com.alibaba.fastjson.serializer.PropertyFilter> getPropertyFilters() {
        if (this.propertyFilters == null) {
            this.propertyFilters = new java.util.ArrayList();
            this.writeDirect = false;
        }
        return this.propertyFilters;
    }

    public java.util.List<com.alibaba.fastjson.serializer.ContextValueFilter> getContextValueFilters() {
        if (this.contextValueFilters == null) {
            this.contextValueFilters = new java.util.ArrayList();
            this.writeDirect = false;
        }
        return this.contextValueFilters;
    }

    public java.util.List<com.alibaba.fastjson.serializer.ValueFilter> getValueFilters() {
        if (this.valueFilters == null) {
            this.valueFilters = new java.util.ArrayList();
            this.writeDirect = false;
        }
        return this.valueFilters;
    }

    public void addFilter(com.alibaba.fastjson.serializer.SerializeFilter serializeFilter) {
        if (serializeFilter == null) {
            return;
        }
        if (serializeFilter instanceof com.alibaba.fastjson.serializer.PropertyPreFilter) {
            getPropertyPreFilters().add((com.alibaba.fastjson.serializer.PropertyPreFilter) serializeFilter);
        }
        if (serializeFilter instanceof com.alibaba.fastjson.serializer.NameFilter) {
            getNameFilters().add((com.alibaba.fastjson.serializer.NameFilter) serializeFilter);
        }
        if (serializeFilter instanceof com.alibaba.fastjson.serializer.ValueFilter) {
            getValueFilters().add((com.alibaba.fastjson.serializer.ValueFilter) serializeFilter);
        }
        if (serializeFilter instanceof com.alibaba.fastjson.serializer.ContextValueFilter) {
            getContextValueFilters().add((com.alibaba.fastjson.serializer.ContextValueFilter) serializeFilter);
        }
        if (serializeFilter instanceof com.alibaba.fastjson.serializer.PropertyFilter) {
            getPropertyFilters().add((com.alibaba.fastjson.serializer.PropertyFilter) serializeFilter);
        }
        if (serializeFilter instanceof com.alibaba.fastjson.serializer.BeforeFilter) {
            getBeforeFilters().add((com.alibaba.fastjson.serializer.BeforeFilter) serializeFilter);
        }
        if (serializeFilter instanceof com.alibaba.fastjson.serializer.AfterFilter) {
            getAfterFilters().add((com.alibaba.fastjson.serializer.AfterFilter) serializeFilter);
        }
        if (serializeFilter instanceof com.alibaba.fastjson.serializer.LabelFilter) {
            getLabelFilters().add((com.alibaba.fastjson.serializer.LabelFilter) serializeFilter);
        }
    }

    public boolean applyName(com.alibaba.fastjson.serializer.JSONSerializer jSONSerializer, java.lang.Object obj, java.lang.String str) {
        if (jSONSerializer.propertyPreFilters != null) {
            java.util.Iterator<com.alibaba.fastjson.serializer.PropertyPreFilter> it = jSONSerializer.propertyPreFilters.iterator();
            while (it.hasNext()) {
                if (!it.next().apply(jSONSerializer, obj, str)) {
                    return false;
                }
            }
        }
        java.util.List<com.alibaba.fastjson.serializer.PropertyPreFilter> list = this.propertyPreFilters;
        if (list == null) {
            return true;
        }
        java.util.Iterator<com.alibaba.fastjson.serializer.PropertyPreFilter> it2 = list.iterator();
        while (it2.hasNext()) {
            if (!it2.next().apply(jSONSerializer, obj, str)) {
                return false;
            }
        }
        return true;
    }

    public boolean apply(com.alibaba.fastjson.serializer.JSONSerializer jSONSerializer, java.lang.Object obj, java.lang.String str, java.lang.Object obj2) {
        if (jSONSerializer.propertyFilters != null) {
            java.util.Iterator<com.alibaba.fastjson.serializer.PropertyFilter> it = jSONSerializer.propertyFilters.iterator();
            while (it.hasNext()) {
                if (!it.next().apply(obj, str, obj2)) {
                    return false;
                }
            }
        }
        java.util.List<com.alibaba.fastjson.serializer.PropertyFilter> list = this.propertyFilters;
        if (list == null) {
            return true;
        }
        java.util.Iterator<com.alibaba.fastjson.serializer.PropertyFilter> it2 = list.iterator();
        while (it2.hasNext()) {
            if (!it2.next().apply(obj, str, obj2)) {
                return false;
            }
        }
        return true;
    }

    protected java.lang.String processKey(com.alibaba.fastjson.serializer.JSONSerializer jSONSerializer, java.lang.Object obj, java.lang.String str, java.lang.Object obj2) {
        if (jSONSerializer.nameFilters != null) {
            java.util.Iterator<com.alibaba.fastjson.serializer.NameFilter> it = jSONSerializer.nameFilters.iterator();
            while (it.hasNext()) {
                str = it.next().process(obj, str, obj2);
            }
        }
        java.util.List<com.alibaba.fastjson.serializer.NameFilter> list = this.nameFilters;
        if (list != null) {
            java.util.Iterator<com.alibaba.fastjson.serializer.NameFilter> it2 = list.iterator();
            while (it2.hasNext()) {
                str = it2.next().process(obj, str, obj2);
            }
        }
        return str;
    }

    protected java.lang.Object processValue(com.alibaba.fastjson.serializer.JSONSerializer jSONSerializer, com.alibaba.fastjson.serializer.BeanContext beanContext, java.lang.Object obj, java.lang.String str, java.lang.Object obj2) {
        return processValue(jSONSerializer, beanContext, obj, str, obj2, 0);
    }

    protected java.lang.Object processValue(com.alibaba.fastjson.serializer.JSONSerializer jSONSerializer, com.alibaba.fastjson.serializer.BeanContext beanContext, java.lang.Object obj, java.lang.String str, java.lang.Object obj2, int i) {
        boolean z;
        if (obj2 != null) {
            if ((com.alibaba.fastjson.serializer.SerializerFeature.isEnabled(jSONSerializer.out.features, i, com.alibaba.fastjson.serializer.SerializerFeature.WriteNonStringValueAsString) || (beanContext != null && (beanContext.getFeatures() & com.alibaba.fastjson.serializer.SerializerFeature.WriteNonStringValueAsString.mask) != 0)) && (((z = obj2 instanceof java.lang.Number)) || (obj2 instanceof java.lang.Boolean))) {
                java.lang.String format = (!z || beanContext == null) ? null : beanContext.getFormat();
                if (format != null) {
                    obj2 = new java.text.DecimalFormat(format).format(obj2);
                } else {
                    obj2 = obj2.toString();
                }
            } else if (beanContext != null && beanContext.isJsonDirect()) {
                obj2 = com.alibaba.fastjson.JSON.parse((java.lang.String) obj2);
            }
        }
        if (jSONSerializer.valueFilters != null) {
            java.util.Iterator<com.alibaba.fastjson.serializer.ValueFilter> it = jSONSerializer.valueFilters.iterator();
            while (it.hasNext()) {
                obj2 = it.next().process(obj, str, obj2);
            }
        }
        java.util.List<com.alibaba.fastjson.serializer.ValueFilter> list = this.valueFilters;
        if (list != null) {
            java.util.Iterator<com.alibaba.fastjson.serializer.ValueFilter> it2 = list.iterator();
            while (it2.hasNext()) {
                obj2 = it2.next().process(obj, str, obj2);
            }
        }
        if (jSONSerializer.contextValueFilters != null) {
            java.util.Iterator<com.alibaba.fastjson.serializer.ContextValueFilter> it3 = jSONSerializer.contextValueFilters.iterator();
            while (it3.hasNext()) {
                obj2 = it3.next().process(beanContext, obj, str, obj2);
            }
        }
        java.util.List<com.alibaba.fastjson.serializer.ContextValueFilter> list2 = this.contextValueFilters;
        if (list2 != null) {
            java.util.Iterator<com.alibaba.fastjson.serializer.ContextValueFilter> it4 = list2.iterator();
            while (it4.hasNext()) {
                obj2 = it4.next().process(beanContext, obj, str, obj2);
            }
        }
        return obj2;
    }

    protected boolean writeDirect(com.alibaba.fastjson.serializer.JSONSerializer jSONSerializer) {
        return jSONSerializer.out.writeDirect && this.writeDirect && jSONSerializer.writeDirect;
    }
}
