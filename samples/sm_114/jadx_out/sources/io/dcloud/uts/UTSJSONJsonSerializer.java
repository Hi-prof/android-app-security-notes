package io.dcloud.uts;

/* JADX INFO: compiled from: UTSJSONObject.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J&\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, d2 = {"Lio/dcloud/uts/UTSJSONJsonSerializer;", "Lio/dcloud/uts/gson/JsonSerializer;", "Lio/dcloud/uts/UTSJSONObject;", "<init>", "()V", "serialize", "Lio/dcloud/uts/gson/JsonElement;", "src", "typeOfSrc", "Ljava/lang/reflect/Type;", "context", "Lio/dcloud/uts/gson/JsonSerializationContext;", "utsplugin_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UTSJSONJsonSerializer implements io.dcloud.uts.gson.JsonSerializer<io.dcloud.uts.UTSJSONObject> {
    @Override // io.dcloud.uts.gson.JsonSerializer
    public io.dcloud.uts.gson.JsonElement serialize(io.dcloud.uts.UTSJSONObject src, java.lang.reflect.Type typeOfSrc, io.dcloud.uts.gson.JsonSerializationContext context) {
        if (src == null) {
            return new io.dcloud.uts.gson.JsonPrimitive("");
        }
        if (src.isJSONArray()) {
            java.lang.Object objFromJson = new io.dcloud.uts.gson.Gson().fromJson(src.toJSONObject().toJSONString(), (java.lang.Class<java.lang.Object>) io.dcloud.uts.gson.JsonArray.class);
            kotlin.jvm.internal.Intrinsics.checkNotNull(objFromJson);
            return (io.dcloud.uts.gson.JsonElement) objFromJson;
        }
        java.lang.Object objFromJson2 = new io.dcloud.uts.gson.Gson().fromJson(src.toJSONObject().toJSONString(), (java.lang.Class<java.lang.Object>) io.dcloud.uts.gson.JsonObject.class);
        kotlin.jvm.internal.Intrinsics.checkNotNull(objFromJson2);
        return (io.dcloud.uts.gson.JsonElement) objFromJson2;
    }
}
