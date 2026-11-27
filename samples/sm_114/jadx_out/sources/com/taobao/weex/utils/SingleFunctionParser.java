package com.taobao.weex.utils;

/* JADX INFO: loaded from: classes.dex */
public class SingleFunctionParser<V> extends com.taobao.weex.utils.FunctionParser<java.lang.String, java.util.List<V>> {

    public interface FlatMapper<V> {
        V map(java.lang.String str);
    }

    public interface NonUniformMapper<V> {
        java.util.List<V> map(java.util.List<java.lang.String> list);
    }

    public SingleFunctionParser(java.lang.String str, final com.taobao.weex.utils.SingleFunctionParser.FlatMapper<V> flatMapper) {
        super(str, new com.taobao.weex.utils.FunctionParser.Mapper<java.lang.String, java.util.List<V>>() { // from class: com.taobao.weex.utils.SingleFunctionParser.1
            @Override // com.taobao.weex.utils.FunctionParser.Mapper
            public java.util.Map<java.lang.String, java.util.List<V>> map(java.lang.String str2, java.util.List<java.lang.String> list) {
                java.util.HashMap map = new java.util.HashMap();
                java.util.LinkedList linkedList = new java.util.LinkedList();
                java.util.Iterator<java.lang.String> it = list.iterator();
                while (it.hasNext()) {
                    linkedList.add(flatMapper.map(it.next()));
                }
                map.put(str2, linkedList);
                return map;
            }
        });
    }

    public SingleFunctionParser(java.lang.String str, final com.taobao.weex.utils.SingleFunctionParser.NonUniformMapper<V> nonUniformMapper) {
        super(str, new com.taobao.weex.utils.FunctionParser.Mapper<java.lang.String, java.util.List<V>>() { // from class: com.taobao.weex.utils.SingleFunctionParser.2
            @Override // com.taobao.weex.utils.FunctionParser.Mapper
            public java.util.Map<java.lang.String, java.util.List<V>> map(java.lang.String str2, java.util.List<java.lang.String> list) {
                java.util.HashMap map = new java.util.HashMap();
                map.put(str2, nonUniformMapper.map(list));
                return map;
            }
        });
    }

    public java.util.List<V> parse(java.lang.String str) {
        java.util.LinkedHashMap<java.lang.String, V> linkedHashMap = parse();
        if (linkedHashMap.containsKey(str)) {
            return (java.util.List) linkedHashMap.get(str);
        }
        return null;
    }
}
