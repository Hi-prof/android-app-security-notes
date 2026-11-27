package io.dcloud.uts.gson.internal.bind;

/* JADX INFO: loaded from: classes2.dex */
public final class DateTypeAdapter extends io.dcloud.uts.gson.TypeAdapter<java.util.Date> {
    public static final io.dcloud.uts.gson.TypeAdapterFactory FACTORY = new io.dcloud.uts.gson.TypeAdapterFactory() { // from class: io.dcloud.uts.gson.internal.bind.DateTypeAdapter.1
        @Override // io.dcloud.uts.gson.TypeAdapterFactory
        public <T> io.dcloud.uts.gson.TypeAdapter<T> create(io.dcloud.uts.gson.Gson gson, io.dcloud.uts.gson.reflect.TypeToken<T> typeToken) {
            if (typeToken.getRawType() == java.util.Date.class) {
                return new io.dcloud.uts.gson.internal.bind.DateTypeAdapter();
            }
            return null;
        }
    };
    private final java.util.List<java.text.DateFormat> dateFormats;

    public DateTypeAdapter() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        this.dateFormats = arrayList;
        arrayList.add(java.text.DateFormat.getDateTimeInstance(2, 2, java.util.Locale.US));
        if (!java.util.Locale.getDefault().equals(java.util.Locale.US)) {
            arrayList.add(java.text.DateFormat.getDateTimeInstance(2, 2));
        }
        if (io.dcloud.uts.gson.internal.JavaVersion.isJava9OrLater()) {
            arrayList.add(io.dcloud.uts.gson.internal.PreJava9DateFormatProvider.getUSDateTimeFormat(2, 2));
        }
    }

    @Override // io.dcloud.uts.gson.TypeAdapter
    /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
    public java.util.Date read2(io.dcloud.uts.gson.stream.JsonReader jsonReader) throws java.io.IOException {
        if (jsonReader.peek() == io.dcloud.uts.gson.stream.JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        return deserializeToDate(jsonReader.nextString());
    }

    private synchronized java.util.Date deserializeToDate(java.lang.String str) {
        java.util.Iterator<java.text.DateFormat> it = this.dateFormats.iterator();
        while (it.hasNext()) {
            try {
                return it.next().parse(str);
            } catch (java.text.ParseException unused) {
            }
        }
        try {
            return io.dcloud.uts.gson.internal.bind.util.ISO8601Utils.parse(str, new java.text.ParsePosition(0));
        } catch (java.text.ParseException e) {
            throw new io.dcloud.uts.gson.JsonSyntaxException(str, e);
        }
    }

    @Override // io.dcloud.uts.gson.TypeAdapter
    public synchronized void write(io.dcloud.uts.gson.stream.JsonWriter jsonWriter, java.util.Date date) throws java.io.IOException {
        try {
            if (date == null) {
                jsonWriter.nullValue();
            } else {
                jsonWriter.value(this.dateFormats.get(0).format(date));
            }
        } catch (java.lang.Throwable th) {
            throw th;
        }
    }
}
