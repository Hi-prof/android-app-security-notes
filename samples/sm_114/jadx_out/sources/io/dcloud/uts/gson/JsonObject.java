package io.dcloud.uts.gson;

/* JADX INFO: loaded from: classes2.dex */
public final class JsonObject extends io.dcloud.uts.gson.JsonElement {
    private final io.dcloud.uts.gson.internal.LinkedTreeMap<java.lang.String, io.dcloud.uts.gson.JsonElement> members = new io.dcloud.uts.gson.internal.LinkedTreeMap<>();

    @Override // io.dcloud.uts.gson.JsonElement
    public io.dcloud.uts.gson.JsonObject deepCopy() {
        io.dcloud.uts.gson.JsonObject jsonObject = new io.dcloud.uts.gson.JsonObject();
        for (java.util.Map.Entry<java.lang.String, io.dcloud.uts.gson.JsonElement> entry : this.members.entrySet()) {
            jsonObject.add(entry.getKey(), entry.getValue().deepCopy());
        }
        return jsonObject;
    }

    public void add(java.lang.String str, io.dcloud.uts.gson.JsonElement jsonElement) {
        io.dcloud.uts.gson.internal.LinkedTreeMap<java.lang.String, io.dcloud.uts.gson.JsonElement> linkedTreeMap = this.members;
        if (jsonElement == null) {
            jsonElement = io.dcloud.uts.gson.JsonNull.INSTANCE;
        }
        linkedTreeMap.put(str, jsonElement);
    }

    public io.dcloud.uts.gson.JsonElement remove(java.lang.String str) {
        return this.members.remove(str);
    }

    public void addProperty(java.lang.String str, java.lang.String str2) {
        add(str, str2 == null ? io.dcloud.uts.gson.JsonNull.INSTANCE : new io.dcloud.uts.gson.JsonPrimitive(str2));
    }

    public void addProperty(java.lang.String str, java.lang.Number number) {
        add(str, number == null ? io.dcloud.uts.gson.JsonNull.INSTANCE : new io.dcloud.uts.gson.JsonPrimitive(number));
    }

    public void addProperty(java.lang.String str, java.lang.Boolean bool) {
        add(str, bool == null ? io.dcloud.uts.gson.JsonNull.INSTANCE : new io.dcloud.uts.gson.JsonPrimitive(bool));
    }

    public void addProperty(java.lang.String str, java.lang.Character ch) {
        add(str, ch == null ? io.dcloud.uts.gson.JsonNull.INSTANCE : new io.dcloud.uts.gson.JsonPrimitive(ch));
    }

    public java.util.Set<java.util.Map.Entry<java.lang.String, io.dcloud.uts.gson.JsonElement>> entrySet() {
        return this.members.entrySet();
    }

    public java.util.Set<java.lang.String> keySet() {
        return this.members.keySet();
    }

    public int size() {
        return this.members.size();
    }

    public boolean has(java.lang.String str) {
        return this.members.containsKey(str);
    }

    public io.dcloud.uts.gson.JsonElement get(java.lang.String str) {
        return this.members.get(str);
    }

    public io.dcloud.uts.gson.JsonPrimitive getAsJsonPrimitive(java.lang.String str) {
        return (io.dcloud.uts.gson.JsonPrimitive) this.members.get(str);
    }

    public io.dcloud.uts.gson.JsonArray getAsJsonArray(java.lang.String str) {
        return (io.dcloud.uts.gson.JsonArray) this.members.get(str);
    }

    public io.dcloud.uts.gson.JsonObject getAsJsonObject(java.lang.String str) {
        return (io.dcloud.uts.gson.JsonObject) this.members.get(str);
    }

    public boolean equals(java.lang.Object obj) {
        if (obj != this) {
            return (obj instanceof io.dcloud.uts.gson.JsonObject) && ((io.dcloud.uts.gson.JsonObject) obj).members.equals(this.members);
        }
        return true;
    }

    public int hashCode() {
        return this.members.hashCode();
    }
}
