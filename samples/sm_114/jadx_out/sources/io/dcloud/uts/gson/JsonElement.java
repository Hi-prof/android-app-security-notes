package io.dcloud.uts.gson;

/* JADX INFO: loaded from: classes2.dex */
public abstract class JsonElement {
    public abstract io.dcloud.uts.gson.JsonElement deepCopy();

    public boolean isJsonArray() {
        return this instanceof io.dcloud.uts.gson.JsonArray;
    }

    public boolean isJsonObject() {
        return this instanceof io.dcloud.uts.gson.JsonObject;
    }

    public boolean isJsonPrimitive() {
        return this instanceof io.dcloud.uts.gson.JsonPrimitive;
    }

    public boolean isJsonNull() {
        return this instanceof io.dcloud.uts.gson.JsonNull;
    }

    public io.dcloud.uts.gson.JsonObject getAsJsonObject() {
        if (isJsonObject()) {
            return (io.dcloud.uts.gson.JsonObject) this;
        }
        throw new java.lang.IllegalStateException("Not a JSON Object: " + this);
    }

    public io.dcloud.uts.gson.JsonArray getAsJsonArray() {
        if (isJsonArray()) {
            return (io.dcloud.uts.gson.JsonArray) this;
        }
        throw new java.lang.IllegalStateException("Not a JSON Array: " + this);
    }

    public io.dcloud.uts.gson.JsonPrimitive getAsJsonPrimitive() {
        if (isJsonPrimitive()) {
            return (io.dcloud.uts.gson.JsonPrimitive) this;
        }
        throw new java.lang.IllegalStateException("Not a JSON Primitive: " + this);
    }

    public io.dcloud.uts.gson.JsonNull getAsJsonNull() {
        if (isJsonNull()) {
            return (io.dcloud.uts.gson.JsonNull) this;
        }
        throw new java.lang.IllegalStateException("Not a JSON Null: " + this);
    }

    public boolean getAsBoolean() {
        throw new java.lang.UnsupportedOperationException(getClass().getSimpleName());
    }

    public java.lang.Number getAsNumber() {
        throw new java.lang.UnsupportedOperationException(getClass().getSimpleName());
    }

    public java.lang.String getAsString() {
        throw new java.lang.UnsupportedOperationException(getClass().getSimpleName());
    }

    public double getAsDouble() {
        throw new java.lang.UnsupportedOperationException(getClass().getSimpleName());
    }

    public float getAsFloat() {
        throw new java.lang.UnsupportedOperationException(getClass().getSimpleName());
    }

    public long getAsLong() {
        throw new java.lang.UnsupportedOperationException(getClass().getSimpleName());
    }

    public int getAsInt() {
        throw new java.lang.UnsupportedOperationException(getClass().getSimpleName());
    }

    public byte getAsByte() {
        throw new java.lang.UnsupportedOperationException(getClass().getSimpleName());
    }

    @java.lang.Deprecated
    public char getAsCharacter() {
        throw new java.lang.UnsupportedOperationException(getClass().getSimpleName());
    }

    public java.math.BigDecimal getAsBigDecimal() {
        throw new java.lang.UnsupportedOperationException(getClass().getSimpleName());
    }

    public java.math.BigInteger getAsBigInteger() {
        throw new java.lang.UnsupportedOperationException(getClass().getSimpleName());
    }

    public short getAsShort() {
        throw new java.lang.UnsupportedOperationException(getClass().getSimpleName());
    }

    public java.lang.String toString() {
        try {
            java.io.StringWriter stringWriter = new java.io.StringWriter();
            io.dcloud.uts.gson.stream.JsonWriter jsonWriter = new io.dcloud.uts.gson.stream.JsonWriter(stringWriter);
            jsonWriter.setLenient(true);
            io.dcloud.uts.gson.internal.Streams.write(this, jsonWriter);
            return stringWriter.toString();
        } catch (java.io.IOException e) {
            throw new java.lang.AssertionError(e);
        }
    }

    public java.lang.String toString(java.lang.String str) {
        try {
            java.io.StringWriter stringWriter = new java.io.StringWriter();
            io.dcloud.uts.gson.stream.JsonWriter jsonWriter = new io.dcloud.uts.gson.stream.JsonWriter(stringWriter);
            jsonWriter.setIndent(str);
            jsonWriter.setLenient(true);
            io.dcloud.uts.gson.internal.Streams.write(this, jsonWriter);
            return stringWriter.toString();
        } catch (java.io.IOException e) {
            throw new java.lang.AssertionError(e);
        }
    }
}
