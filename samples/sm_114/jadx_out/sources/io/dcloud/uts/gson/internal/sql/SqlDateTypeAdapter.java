package io.dcloud.uts.gson.internal.sql;

/* JADX INFO: loaded from: classes2.dex */
final class SqlDateTypeAdapter extends io.dcloud.uts.gson.TypeAdapter<java.sql.Date> {
    static final io.dcloud.uts.gson.TypeAdapterFactory FACTORY = new io.dcloud.uts.gson.TypeAdapterFactory() { // from class: io.dcloud.uts.gson.internal.sql.SqlDateTypeAdapter.1
        @Override // io.dcloud.uts.gson.TypeAdapterFactory
        public <T> io.dcloud.uts.gson.TypeAdapter<T> create(io.dcloud.uts.gson.Gson gson, io.dcloud.uts.gson.reflect.TypeToken<T> typeToken) {
            if (typeToken.getRawType() == java.sql.Date.class) {
                return new io.dcloud.uts.gson.internal.sql.SqlDateTypeAdapter();
            }
            return null;
        }
    };
    private final java.text.DateFormat format;

    private SqlDateTypeAdapter() {
        this.format = new java.text.SimpleDateFormat("MMM d, yyyy");
    }

    @Override // io.dcloud.uts.gson.TypeAdapter
    /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
    public synchronized java.sql.Date read2(io.dcloud.uts.gson.stream.JsonReader jsonReader) throws java.io.IOException {
        if (jsonReader.peek() == io.dcloud.uts.gson.stream.JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        try {
            return new java.sql.Date(this.format.parse(jsonReader.nextString()).getTime());
        } catch (java.text.ParseException e) {
            throw new io.dcloud.uts.gson.JsonSyntaxException(e);
        }
    }

    @Override // io.dcloud.uts.gson.TypeAdapter
    public synchronized void write(io.dcloud.uts.gson.stream.JsonWriter jsonWriter, java.sql.Date date) throws java.io.IOException {
        jsonWriter.value(date == null ? null : this.format.format((java.util.Date) date));
    }
}
