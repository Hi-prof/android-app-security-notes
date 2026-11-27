package io.dcloud.uts.gson.internal.sql;

/* JADX INFO: loaded from: classes2.dex */
class SqlTimestampTypeAdapter extends io.dcloud.uts.gson.TypeAdapter<java.sql.Timestamp> {
    static final io.dcloud.uts.gson.TypeAdapterFactory FACTORY = new io.dcloud.uts.gson.TypeAdapterFactory() { // from class: io.dcloud.uts.gson.internal.sql.SqlTimestampTypeAdapter.1
        @Override // io.dcloud.uts.gson.TypeAdapterFactory
        public <T> io.dcloud.uts.gson.TypeAdapter<T> create(io.dcloud.uts.gson.Gson gson, io.dcloud.uts.gson.reflect.TypeToken<T> typeToken) {
            if (typeToken.getRawType() == java.sql.Timestamp.class) {
                return new io.dcloud.uts.gson.internal.sql.SqlTimestampTypeAdapter(gson.getAdapter(java.util.Date.class));
            }
            return null;
        }
    };
    private final io.dcloud.uts.gson.TypeAdapter<java.util.Date> dateTypeAdapter;

    private SqlTimestampTypeAdapter(io.dcloud.uts.gson.TypeAdapter<java.util.Date> typeAdapter) {
        this.dateTypeAdapter = typeAdapter;
    }

    @Override // io.dcloud.uts.gson.TypeAdapter
    /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
    public java.sql.Timestamp read2(io.dcloud.uts.gson.stream.JsonReader jsonReader) throws java.io.IOException {
        java.util.Date date = this.dateTypeAdapter.read2(jsonReader);
        if (date != null) {
            return new java.sql.Timestamp(date.getTime());
        }
        return null;
    }

    @Override // io.dcloud.uts.gson.TypeAdapter
    public void write(io.dcloud.uts.gson.stream.JsonWriter jsonWriter, java.sql.Timestamp timestamp) throws java.io.IOException {
        this.dateTypeAdapter.write(jsonWriter, timestamp);
    }
}
