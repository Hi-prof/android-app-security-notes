package io.dcloud.uts.gson;

/* JADX INFO: loaded from: classes2.dex */
public final class JsonParser {
    @java.lang.Deprecated
    public JsonParser() {
    }

    public static io.dcloud.uts.gson.JsonElement parseString(java.lang.String str) throws io.dcloud.uts.gson.JsonSyntaxException {
        return parseReader(new java.io.StringReader(str));
    }

    public static io.dcloud.uts.gson.JsonElement parseReader(java.io.Reader reader) throws io.dcloud.uts.gson.JsonSyntaxException, io.dcloud.uts.gson.JsonIOException {
        try {
            io.dcloud.uts.gson.stream.JsonReader jsonReader = new io.dcloud.uts.gson.stream.JsonReader(reader);
            io.dcloud.uts.gson.JsonElement reader2 = parseReader(jsonReader);
            if (!reader2.isJsonNull() && jsonReader.peek() != io.dcloud.uts.gson.stream.JsonToken.END_DOCUMENT) {
                throw new io.dcloud.uts.gson.JsonSyntaxException("Did not consume the entire document.");
            }
            return reader2;
        } catch (io.dcloud.uts.gson.stream.MalformedJsonException e) {
            throw new io.dcloud.uts.gson.JsonSyntaxException(e);
        } catch (java.io.IOException e2) {
            throw new io.dcloud.uts.gson.JsonIOException(e2);
        } catch (java.lang.NumberFormatException e3) {
            throw new io.dcloud.uts.gson.JsonSyntaxException(e3);
        }
    }

    public static io.dcloud.uts.gson.JsonElement parseReader(io.dcloud.uts.gson.stream.JsonReader jsonReader) throws io.dcloud.uts.gson.JsonSyntaxException, io.dcloud.uts.gson.JsonIOException {
        boolean zIsLenient = jsonReader.isLenient();
        jsonReader.setLenient(true);
        try {
            try {
                io.dcloud.uts.gson.JsonElement jsonElement = io.dcloud.uts.gson.internal.Streams.parse(jsonReader);
                jsonReader.setLenient(zIsLenient);
                return jsonElement;
            } catch (java.lang.OutOfMemoryError e) {
                throw new io.dcloud.uts.gson.JsonParseException("Failed parsing JSON source: " + jsonReader + " to Json", e);
            } catch (java.lang.StackOverflowError e2) {
                throw new io.dcloud.uts.gson.JsonParseException("Failed parsing JSON source: " + jsonReader + " to Json", e2);
            }
        } catch (java.lang.Throwable th) {
            jsonReader.setLenient(zIsLenient);
            throw th;
        }
    }

    @java.lang.Deprecated
    public io.dcloud.uts.gson.JsonElement parse(java.lang.String str) throws io.dcloud.uts.gson.JsonSyntaxException {
        return parseString(str);
    }

    @java.lang.Deprecated
    public io.dcloud.uts.gson.JsonElement parse(java.io.Reader reader) throws io.dcloud.uts.gson.JsonSyntaxException, io.dcloud.uts.gson.JsonIOException {
        return parseReader(reader);
    }

    @java.lang.Deprecated
    public io.dcloud.uts.gson.JsonElement parse(io.dcloud.uts.gson.stream.JsonReader jsonReader) throws io.dcloud.uts.gson.JsonSyntaxException, io.dcloud.uts.gson.JsonIOException {
        return parseReader(jsonReader);
    }
}
