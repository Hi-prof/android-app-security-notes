package io.dcloud.uts.gson;

/* JADX INFO: loaded from: classes2.dex */
public enum LongSerializationPolicy {
    DEFAULT { // from class: io.dcloud.uts.gson.LongSerializationPolicy.1
        @Override // io.dcloud.uts.gson.LongSerializationPolicy
        public io.dcloud.uts.gson.JsonElement serialize(java.lang.Long l) {
            if (l == null) {
                return io.dcloud.uts.gson.JsonNull.INSTANCE;
            }
            return new io.dcloud.uts.gson.JsonPrimitive(l);
        }
    },
    STRING { // from class: io.dcloud.uts.gson.LongSerializationPolicy.2
        @Override // io.dcloud.uts.gson.LongSerializationPolicy
        public io.dcloud.uts.gson.JsonElement serialize(java.lang.Long l) {
            if (l == null) {
                return io.dcloud.uts.gson.JsonNull.INSTANCE;
            }
            return new io.dcloud.uts.gson.JsonPrimitive(l.toString());
        }
    };

    public abstract io.dcloud.uts.gson.JsonElement serialize(java.lang.Long l);
}
