package io.dcloud.uts;

/* JADX INFO: compiled from: UTSJSONObject.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J&\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, d2 = {"Lio/dcloud/uts/UTSJSONSelfJsonSerializer;", "Lio/dcloud/uts/gson/JsonSerializer;", "Lio/dcloud/uts/json/IJsonStringify;", "<init>", "()V", "serialize", "Lio/dcloud/uts/gson/JsonElement;", "src", "typeOfSrc", "Ljava/lang/reflect/Type;", "context", "Lio/dcloud/uts/gson/JsonSerializationContext;", "utsplugin_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UTSJSONSelfJsonSerializer implements io.dcloud.uts.gson.JsonSerializer<io.dcloud.uts.json.IJsonStringify> {
    @Override // io.dcloud.uts.gson.JsonSerializer
    public io.dcloud.uts.gson.JsonElement serialize(io.dcloud.uts.json.IJsonStringify src, java.lang.reflect.Type typeOfSrc, io.dcloud.uts.gson.JsonSerializationContext context) {
        io.dcloud.uts.gson.JsonElement jsonElementEncode = new io.dcloud.uts.android.UTSGsonEncoder().encode(src, null);
        if (jsonElementEncode != null) {
            return jsonElementEncode;
        }
        io.dcloud.uts.gson.JsonNull INSTANCE = io.dcloud.uts.gson.JsonNull.INSTANCE;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(INSTANCE, "INSTANCE");
        return INSTANCE;
    }
}
