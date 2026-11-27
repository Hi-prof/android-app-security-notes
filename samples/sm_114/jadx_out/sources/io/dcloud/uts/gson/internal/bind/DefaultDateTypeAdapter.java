package io.dcloud.uts.gson.internal.bind;

/* JADX INFO: loaded from: classes2.dex */
public final class DefaultDateTypeAdapter<T extends java.util.Date> extends io.dcloud.uts.gson.TypeAdapter<T> {
    private static final java.lang.String SIMPLE_NAME = "DefaultDateTypeAdapter";
    private final java.util.List<java.text.DateFormat> dateFormats;
    private final io.dcloud.uts.gson.internal.bind.DefaultDateTypeAdapter.DateType<T> dateType;

    public static abstract class DateType<T extends java.util.Date> {
        public static final io.dcloud.uts.gson.internal.bind.DefaultDateTypeAdapter.DateType<java.util.Date> DATE = new io.dcloud.uts.gson.internal.bind.DefaultDateTypeAdapter.DateType<java.util.Date>(java.util.Date.class) { // from class: io.dcloud.uts.gson.internal.bind.DefaultDateTypeAdapter.DateType.1
            @Override // io.dcloud.uts.gson.internal.bind.DefaultDateTypeAdapter.DateType
            protected java.util.Date deserialize(java.util.Date date) {
                return date;
            }
        };
        private final java.lang.Class<T> dateClass;

        protected abstract T deserialize(java.util.Date date);

        protected DateType(java.lang.Class<T> cls) {
            this.dateClass = cls;
        }

        private final io.dcloud.uts.gson.TypeAdapterFactory createFactory(io.dcloud.uts.gson.internal.bind.DefaultDateTypeAdapter<T> defaultDateTypeAdapter) {
            return io.dcloud.uts.gson.internal.bind.TypeAdapters.newFactory(this.dateClass, defaultDateTypeAdapter);
        }

        public final io.dcloud.uts.gson.TypeAdapterFactory createAdapterFactory(java.lang.String str) {
            return createFactory(new io.dcloud.uts.gson.internal.bind.DefaultDateTypeAdapter<>(this, str));
        }

        public final io.dcloud.uts.gson.TypeAdapterFactory createAdapterFactory(int i) {
            return createFactory(new io.dcloud.uts.gson.internal.bind.DefaultDateTypeAdapter<>(this, i));
        }

        public final io.dcloud.uts.gson.TypeAdapterFactory createAdapterFactory(int i, int i2) {
            return createFactory(new io.dcloud.uts.gson.internal.bind.DefaultDateTypeAdapter<>(this, i, i2));
        }

        public final io.dcloud.uts.gson.TypeAdapterFactory createDefaultsAdapterFactory() {
            int i = 2;
            return createFactory(new io.dcloud.uts.gson.internal.bind.DefaultDateTypeAdapter<>(this, i, i));
        }
    }

    private DefaultDateTypeAdapter(io.dcloud.uts.gson.internal.bind.DefaultDateTypeAdapter.DateType<T> dateType, java.lang.String str) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        this.dateFormats = arrayList;
        this.dateType = (io.dcloud.uts.gson.internal.bind.DefaultDateTypeAdapter.DateType) io.dcloud.uts.gson.internal.C$Gson$Preconditions.checkNotNull(dateType);
        arrayList.add(new java.text.SimpleDateFormat(str, java.util.Locale.US));
        if (java.util.Locale.getDefault().equals(java.util.Locale.US)) {
            return;
        }
        arrayList.add(new java.text.SimpleDateFormat(str));
    }

    private DefaultDateTypeAdapter(io.dcloud.uts.gson.internal.bind.DefaultDateTypeAdapter.DateType<T> dateType, int i) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        this.dateFormats = arrayList;
        this.dateType = (io.dcloud.uts.gson.internal.bind.DefaultDateTypeAdapter.DateType) io.dcloud.uts.gson.internal.C$Gson$Preconditions.checkNotNull(dateType);
        arrayList.add(java.text.DateFormat.getDateInstance(i, java.util.Locale.US));
        if (!java.util.Locale.getDefault().equals(java.util.Locale.US)) {
            arrayList.add(java.text.DateFormat.getDateInstance(i));
        }
        if (io.dcloud.uts.gson.internal.JavaVersion.isJava9OrLater()) {
            arrayList.add(io.dcloud.uts.gson.internal.PreJava9DateFormatProvider.getUSDateFormat(i));
        }
    }

    private DefaultDateTypeAdapter(io.dcloud.uts.gson.internal.bind.DefaultDateTypeAdapter.DateType<T> dateType, int i, int i2) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        this.dateFormats = arrayList;
        this.dateType = (io.dcloud.uts.gson.internal.bind.DefaultDateTypeAdapter.DateType) io.dcloud.uts.gson.internal.C$Gson$Preconditions.checkNotNull(dateType);
        arrayList.add(java.text.DateFormat.getDateTimeInstance(i, i2, java.util.Locale.US));
        if (!java.util.Locale.getDefault().equals(java.util.Locale.US)) {
            arrayList.add(java.text.DateFormat.getDateTimeInstance(i, i2));
        }
        if (io.dcloud.uts.gson.internal.JavaVersion.isJava9OrLater()) {
            arrayList.add(io.dcloud.uts.gson.internal.PreJava9DateFormatProvider.getUSDateTimeFormat(i, i2));
        }
    }

    @Override // io.dcloud.uts.gson.TypeAdapter
    public void write(io.dcloud.uts.gson.stream.JsonWriter jsonWriter, java.util.Date date) throws java.io.IOException {
        if (date == null) {
            jsonWriter.nullValue();
            return;
        }
        synchronized (this.dateFormats) {
            jsonWriter.value(this.dateFormats.get(0).format(date));
        }
    }

    @Override // io.dcloud.uts.gson.TypeAdapter
    /* JADX INFO: renamed from: read */
    public T read2(io.dcloud.uts.gson.stream.JsonReader jsonReader) throws java.io.IOException {
        if (jsonReader.peek() == io.dcloud.uts.gson.stream.JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        return (T) this.dateType.deserialize(deserializeToDate(jsonReader.nextString()));
    }

    private java.util.Date deserializeToDate(java.lang.String str) {
        synchronized (this.dateFormats) {
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
    }

    public java.lang.String toString() {
        java.text.DateFormat dateFormat = this.dateFormats.get(0);
        if (dateFormat instanceof java.text.SimpleDateFormat) {
            return "DefaultDateTypeAdapter(" + ((java.text.SimpleDateFormat) dateFormat).toPattern() + com.taobao.weex.el.parse.Operators.BRACKET_END;
        }
        return "DefaultDateTypeAdapter(" + dateFormat.getClass().getSimpleName() + com.taobao.weex.el.parse.Operators.BRACKET_END;
    }
}
