package io.dcloud.uts.gson.internal.sql;

/* JADX INFO: loaded from: classes2.dex */
final class SqlTimeTypeAdapter extends io.dcloud.uts.gson.TypeAdapter<java.sql.Time> {
    static final io.dcloud.uts.gson.TypeAdapterFactory FACTORY = new io.dcloud.uts.gson.TypeAdapterFactory() { // from class: io.dcloud.uts.gson.internal.sql.SqlTimeTypeAdapter.1
        @Override // io.dcloud.uts.gson.TypeAdapterFactory
        public <T> io.dcloud.uts.gson.TypeAdapter<T> create(io.dcloud.uts.gson.Gson gson, io.dcloud.uts.gson.reflect.TypeToken<T> typeToken) {
            if (typeToken.getRawType() == java.sql.Time.class) {
                return new io.dcloud.uts.gson.internal.sql.SqlTimeTypeAdapter();
            }
            return null;
        }
    };
    private final java.text.DateFormat format;

    private SqlTimeTypeAdapter() {
        this.format = new java.text.SimpleDateFormat("hh:mm:ss a");
    }

    @Override // io.dcloud.uts.gson.TypeAdapter
    /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
    public synchronized java.sql.Time read2(io.dcloud.uts.gson.stream.JsonReader jsonReader) throws java.io.IOException {
        if (jsonReader.peek() == io.dcloud.uts.gson.stream.JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        try {
            return new java.sql.Time(this.format.parse(jsonReader.nextString()).getTime());
        } catch (java.text.ParseException e) {
            throw new io.dcloud.uts.gson.JsonSyntaxException(e);
        }
    }

    @Override // io.dcloud.uts.gson.TypeAdapter
    public synchronized void write(io.dcloud.uts.gson.stream.JsonWriter jsonWriter, java.sql.Time time) throws java.io.IOException {
        jsonWriter.value(time == null ? null : this.format.format((java.util.Date) time));
    }
}
