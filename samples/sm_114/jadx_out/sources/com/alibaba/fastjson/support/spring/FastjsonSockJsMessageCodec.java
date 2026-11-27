package com.alibaba.fastjson.support.spring;

/* JADX INFO: loaded from: classes.dex */
public class FastjsonSockJsMessageCodec extends org.springframework.web.socket.sockjs.frame.AbstractSockJsMessageCodec {
    public java.lang.String[] decode(java.lang.String str) throws java.io.IOException {
        return (java.lang.String[]) com.alibaba.fastjson.JSON.parseObject(str, java.lang.String[].class);
    }

    public java.lang.String[] decodeInputStream(java.io.InputStream inputStream) throws java.io.IOException {
        return (java.lang.String[]) com.alibaba.fastjson.JSON.parseObject(inputStream, java.lang.String[].class, new com.alibaba.fastjson.parser.Feature[0]);
    }

    protected char[] applyJsonQuoting(java.lang.String str) {
        com.alibaba.fastjson.serializer.SerializeWriter serializeWriter = new com.alibaba.fastjson.serializer.SerializeWriter();
        try {
            new com.alibaba.fastjson.serializer.JSONSerializer(serializeWriter).write(str);
            return serializeWriter.toCharArrayForSpringWebSocket();
        } finally {
            serializeWriter.close();
        }
    }
}
