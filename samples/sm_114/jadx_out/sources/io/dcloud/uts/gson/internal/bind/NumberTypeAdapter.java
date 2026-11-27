package io.dcloud.uts.gson.internal.bind;

/* JADX INFO: loaded from: classes2.dex */
public final class NumberTypeAdapter extends io.dcloud.uts.gson.TypeAdapter<java.lang.Number> {
    private static final io.dcloud.uts.gson.TypeAdapterFactory LAZILY_PARSED_NUMBER_FACTORY = newFactory(io.dcloud.uts.gson.ToNumberPolicy.LAZILY_PARSED_NUMBER);
    private final io.dcloud.uts.gson.ToNumberStrategy toNumberStrategy;

    private NumberTypeAdapter(io.dcloud.uts.gson.ToNumberStrategy toNumberStrategy) {
        this.toNumberStrategy = toNumberStrategy;
    }

    private static io.dcloud.uts.gson.TypeAdapterFactory newFactory(io.dcloud.uts.gson.ToNumberStrategy toNumberStrategy) {
        return new io.dcloud.uts.gson.TypeAdapterFactory() { // from class: io.dcloud.uts.gson.internal.bind.NumberTypeAdapter.1
            @Override // io.dcloud.uts.gson.TypeAdapterFactory
            public <T> io.dcloud.uts.gson.TypeAdapter<T> create(io.dcloud.uts.gson.Gson gson, io.dcloud.uts.gson.reflect.TypeToken<T> typeToken) {
                if (typeToken.getRawType() == java.lang.Number.class) {
                    return io.dcloud.uts.gson.internal.bind.NumberTypeAdapter.this;
                }
                return null;
            }
        };
    }

    public static io.dcloud.uts.gson.TypeAdapterFactory getFactory(io.dcloud.uts.gson.ToNumberStrategy toNumberStrategy) {
        if (toNumberStrategy == io.dcloud.uts.gson.ToNumberPolicy.LAZILY_PARSED_NUMBER) {
            return LAZILY_PARSED_NUMBER_FACTORY;
        }
        return newFactory(toNumberStrategy);
    }

    /* JADX INFO: renamed from: io.dcloud.uts.gson.internal.bind.NumberTypeAdapter$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$io$dcloud$uts$gson$stream$JsonToken;

        static {
            int[] iArr = new int[io.dcloud.uts.gson.stream.JsonToken.values().length];
            $SwitchMap$io$dcloud$uts$gson$stream$JsonToken = iArr;
            try {
                iArr[io.dcloud.uts.gson.stream.JsonToken.NULL.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$dcloud$uts$gson$stream$JsonToken[io.dcloud.uts.gson.stream.JsonToken.NUMBER.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$dcloud$uts$gson$stream$JsonToken[io.dcloud.uts.gson.stream.JsonToken.STRING.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.dcloud.uts.gson.TypeAdapter
    /* JADX INFO: renamed from: read */
    public java.lang.Number read2(io.dcloud.uts.gson.stream.JsonReader jsonReader) throws java.io.IOException {
        io.dcloud.uts.gson.stream.JsonToken jsonTokenPeek = jsonReader.peek();
        int i = io.dcloud.uts.gson.internal.bind.NumberTypeAdapter.AnonymousClass2.$SwitchMap$io$dcloud$uts$gson$stream$JsonToken[jsonTokenPeek.ordinal()];
        if (i == 1) {
            jsonReader.nextNull();
            return null;
        }
        if (i == 2 || i == 3) {
            return this.toNumberStrategy.readNumber(jsonReader);
        }
        throw new io.dcloud.uts.gson.JsonSyntaxException("Expecting number, got: " + jsonTokenPeek);
    }

    @Override // io.dcloud.uts.gson.TypeAdapter
    public void write(io.dcloud.uts.gson.stream.JsonWriter jsonWriter, java.lang.Number number) throws java.io.IOException {
        jsonWriter.value(number);
    }
}
