package io.dcloud.uts;

/* JADX INFO: compiled from: JSON.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J(\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, d2 = {"Lio/dcloud/uts/UTSJsonDeserializer;", "Lio/dcloud/uts/gson/JsonDeserializer;", "Lio/dcloud/uts/UTSJSONObject;", "<init>", "()V", "deserialize", "json", "Lio/dcloud/uts/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "context", "Lio/dcloud/uts/gson/JsonDeserializationContext;", "utsplugin_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UTSJsonDeserializer implements io.dcloud.uts.gson.JsonDeserializer<io.dcloud.uts.UTSJSONObject> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.dcloud.uts.gson.JsonDeserializer
    public io.dcloud.uts.UTSJSONObject deserialize(io.dcloud.uts.gson.JsonElement json, java.lang.reflect.Type typeOfT, io.dcloud.uts.gson.JsonDeserializationContext context) {
        if (json == null) {
            return new io.dcloud.uts.UTSJSONObject();
        }
        java.lang.String string = json.toString();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return io.dcloud.uts.JSON.parseObject(string);
    }
}
