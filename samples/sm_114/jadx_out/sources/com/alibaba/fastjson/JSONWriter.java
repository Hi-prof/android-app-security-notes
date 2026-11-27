package com.alibaba.fastjson;

/* JADX INFO: loaded from: classes.dex */
public class JSONWriter implements java.io.Closeable, java.io.Flushable {
    private com.alibaba.fastjson.JSONStreamContext context;
    private com.alibaba.fastjson.serializer.JSONSerializer serializer;
    private com.alibaba.fastjson.serializer.SerializeWriter writer;

    public JSONWriter(java.io.Writer writer) {
        this.writer = new com.alibaba.fastjson.serializer.SerializeWriter(writer);
        this.serializer = new com.alibaba.fastjson.serializer.JSONSerializer(this.writer);
    }

    public void config(com.alibaba.fastjson.serializer.SerializerFeature serializerFeature, boolean z) {
        this.writer.config(serializerFeature, z);
    }

    public void startObject() {
        if (this.context != null) {
            beginStructure();
        }
        this.context = new com.alibaba.fastjson.JSONStreamContext(this.context, 1001);
        this.writer.write(123);
    }

    public void endObject() {
        this.writer.write(125);
        endStructure();
    }

    public void writeKey(java.lang.String str) {
        writeObject(str);
    }

    public void writeValue(java.lang.Object obj) {
        writeObject(obj);
    }

    public void writeObject(java.lang.String str) {
        beforeWrite();
        this.serializer.write(str);
        afterWrite();
    }

    public void writeObject(java.lang.Object obj) {
        beforeWrite();
        this.serializer.write(obj);
        afterWrite();
    }

    public void startArray() {
        if (this.context != null) {
            beginStructure();
        }
        this.context = new com.alibaba.fastjson.JSONStreamContext(this.context, 1004);
        this.writer.write(91);
    }

    private void beginStructure() {
        int i = this.context.state;
        switch (this.context.state) {
            case 1001:
            case 1004:
                return;
            case 1002:
                this.writer.write(58);
                return;
            case 1003:
            default:
                throw new com.alibaba.fastjson.JSONException("illegal state : " + i);
            case io.dcloud.feature.barcode2.decoding.CaptureActivityHandler.CODE_DECODE_portrait /* 1005 */:
                this.writer.write(44);
                return;
        }
    }

    public void endArray() {
        this.writer.write(93);
        endStructure();
    }

    private void endStructure() {
        com.alibaba.fastjson.JSONStreamContext jSONStreamContext = this.context.parent;
        this.context = jSONStreamContext;
        if (jSONStreamContext == null) {
            return;
        }
        int i = jSONStreamContext.state;
        int i2 = 1002;
        if (i != 1001) {
            if (i != 1002) {
                i2 = i != 1004 ? -1 : io.dcloud.feature.barcode2.decoding.CaptureActivityHandler.CODE_DECODE_portrait;
            } else {
                i2 = 1003;
            }
        }
        if (i2 != -1) {
            this.context.state = i2;
        }
    }

    private void beforeWrite() {
        com.alibaba.fastjson.JSONStreamContext jSONStreamContext = this.context;
        if (jSONStreamContext == null) {
            return;
        }
        int i = jSONStreamContext.state;
        if (i == 1002) {
            this.writer.write(58);
        } else if (i == 1003) {
            this.writer.write(44);
        } else {
            if (i != 1005) {
                return;
            }
            this.writer.write(44);
        }
    }

    private void afterWrite() {
        int i;
        com.alibaba.fastjson.JSONStreamContext jSONStreamContext = this.context;
        if (jSONStreamContext == null) {
            return;
        }
        switch (jSONStreamContext.state) {
            case 1001:
            case 1003:
                i = 1002;
                break;
            case 1002:
                i = 1003;
                break;
            case 1004:
                i = io.dcloud.feature.barcode2.decoding.CaptureActivityHandler.CODE_DECODE_portrait;
                break;
            default:
                i = -1;
                break;
        }
        if (i != -1) {
            this.context.state = i;
        }
    }

    @Override // java.io.Flushable
    public void flush() throws java.io.IOException {
        this.writer.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        this.writer.close();
    }

    @java.lang.Deprecated
    public void writeStartObject() {
        startObject();
    }

    @java.lang.Deprecated
    public void writeEndObject() {
        endObject();
    }

    @java.lang.Deprecated
    public void writeStartArray() {
        startArray();
    }

    @java.lang.Deprecated
    public void writeEndArray() {
        endArray();
    }
}
