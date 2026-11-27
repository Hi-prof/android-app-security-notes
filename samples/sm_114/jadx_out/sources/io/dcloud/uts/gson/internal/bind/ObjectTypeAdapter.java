package io.dcloud.uts.gson.internal.bind;

/* JADX INFO: loaded from: classes2.dex */
public final class ObjectTypeAdapter extends io.dcloud.uts.gson.TypeAdapter<java.lang.Object> {
    private static final io.dcloud.uts.gson.TypeAdapterFactory DOUBLE_FACTORY = newFactory(io.dcloud.uts.gson.ToNumberPolicy.DOUBLE);
    private final io.dcloud.uts.gson.Gson gson;
    private final io.dcloud.uts.gson.ToNumberStrategy toNumberStrategy;

    private ObjectTypeAdapter(io.dcloud.uts.gson.Gson gson, io.dcloud.uts.gson.ToNumberStrategy toNumberStrategy) {
        this.gson = gson;
        this.toNumberStrategy = toNumberStrategy;
    }

    private static io.dcloud.uts.gson.TypeAdapterFactory newFactory(final io.dcloud.uts.gson.ToNumberStrategy toNumberStrategy) {
        return new io.dcloud.uts.gson.TypeAdapterFactory() { // from class: io.dcloud.uts.gson.internal.bind.ObjectTypeAdapter.1
            @Override // io.dcloud.uts.gson.TypeAdapterFactory
            public <T> io.dcloud.uts.gson.TypeAdapter<T> create(io.dcloud.uts.gson.Gson gson, io.dcloud.uts.gson.reflect.TypeToken<T> typeToken) {
                if (typeToken.getRawType() == java.lang.Object.class) {
                    return new io.dcloud.uts.gson.internal.bind.ObjectTypeAdapter(gson, toNumberStrategy);
                }
                return null;
            }
        };
    }

    public static io.dcloud.uts.gson.TypeAdapterFactory getFactory(io.dcloud.uts.gson.ToNumberStrategy toNumberStrategy) {
        if (toNumberStrategy == io.dcloud.uts.gson.ToNumberPolicy.DOUBLE) {
            return DOUBLE_FACTORY;
        }
        return newFactory(toNumberStrategy);
    }

    /* JADX INFO: renamed from: io.dcloud.uts.gson.internal.bind.ObjectTypeAdapter$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$io$dcloud$uts$gson$stream$JsonToken;

        static {
            int[] iArr = new int[io.dcloud.uts.gson.stream.JsonToken.values().length];
            $SwitchMap$io$dcloud$uts$gson$stream$JsonToken = iArr;
            try {
                iArr[io.dcloud.uts.gson.stream.JsonToken.BEGIN_ARRAY.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$dcloud$uts$gson$stream$JsonToken[io.dcloud.uts.gson.stream.JsonToken.BEGIN_OBJECT.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$dcloud$uts$gson$stream$JsonToken[io.dcloud.uts.gson.stream.JsonToken.STRING.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$dcloud$uts$gson$stream$JsonToken[io.dcloud.uts.gson.stream.JsonToken.NUMBER.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$dcloud$uts$gson$stream$JsonToken[io.dcloud.uts.gson.stream.JsonToken.BOOLEAN.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$dcloud$uts$gson$stream$JsonToken[io.dcloud.uts.gson.stream.JsonToken.NULL.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
        }
    }

    @Override // io.dcloud.uts.gson.TypeAdapter
    /* JADX INFO: renamed from: read */
    public java.lang.Object read2(io.dcloud.uts.gson.stream.JsonReader jsonReader) throws java.io.IOException {
        switch (io.dcloud.uts.gson.internal.bind.ObjectTypeAdapter.AnonymousClass2.$SwitchMap$io$dcloud$uts$gson$stream$JsonToken[jsonReader.peek().ordinal()]) {
            case 1:
                io.dcloud.uts.UTSArray uTSArray = new io.dcloud.uts.UTSArray();
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    uTSArray.add(read2(jsonReader));
                }
                jsonReader.endArray();
                return uTSArray;
            case 2:
                io.dcloud.uts.UTSJSONObject uTSJSONObject = new io.dcloud.uts.UTSJSONObject();
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    uTSJSONObject.set(jsonReader.nextName(), read2(jsonReader));
                }
                jsonReader.endObject();
                return uTSJSONObject;
            case 3:
                return jsonReader.nextString();
            case 4:
                return this.toNumberStrategy.readNumber(jsonReader);
            case 5:
                return java.lang.Boolean.valueOf(jsonReader.nextBoolean());
            case 6:
                jsonReader.nextNull();
                return null;
            default:
                throw new java.lang.IllegalStateException();
        }
    }

    @Override // io.dcloud.uts.gson.TypeAdapter
    public void write(io.dcloud.uts.gson.stream.JsonWriter jsonWriter, java.lang.Object obj) throws java.io.IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        io.dcloud.uts.gson.TypeAdapter adapter = this.gson.getAdapter(obj.getClass());
        if (adapter instanceof io.dcloud.uts.gson.internal.bind.ObjectTypeAdapter) {
            jsonWriter.beginObject();
            jsonWriter.endObject();
        } else {
            adapter.write(jsonWriter, obj);
        }
    }
}
