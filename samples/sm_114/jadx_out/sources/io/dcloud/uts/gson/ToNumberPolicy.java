package io.dcloud.uts.gson;

/* JADX INFO: loaded from: classes2.dex */
public enum ToNumberPolicy implements io.dcloud.uts.gson.ToNumberStrategy {
    DOUBLE { // from class: io.dcloud.uts.gson.ToNumberPolicy.1
        @Override // io.dcloud.uts.gson.ToNumberStrategy
        public java.lang.Double readNumber(io.dcloud.uts.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            return java.lang.Double.valueOf(jsonReader.nextDouble());
        }
    },
    LAZILY_PARSED_NUMBER { // from class: io.dcloud.uts.gson.ToNumberPolicy.2
        @Override // io.dcloud.uts.gson.ToNumberStrategy
        public java.lang.Number readNumber(io.dcloud.uts.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            return io.dcloud.uts.UTSNumber.INSTANCE.from(jsonReader.nextString());
        }
    },
    LONG_OR_DOUBLE { // from class: io.dcloud.uts.gson.ToNumberPolicy.3
        @Override // io.dcloud.uts.gson.ToNumberStrategy
        public java.lang.Number readNumber(io.dcloud.uts.gson.stream.JsonReader jsonReader) throws io.dcloud.uts.gson.JsonParseException, java.io.IOException {
            java.lang.String strNextString = jsonReader.nextString();
            try {
                try {
                    return java.lang.Long.valueOf(java.lang.Long.parseLong(strNextString));
                } catch (java.lang.NumberFormatException unused) {
                    java.lang.Double dValueOf = java.lang.Double.valueOf(strNextString);
                    if ((!dValueOf.isInfinite() && !dValueOf.isNaN()) || jsonReader.isLenient()) {
                        return dValueOf;
                    }
                    throw new io.dcloud.uts.gson.stream.MalformedJsonException("JSON forbids NaN and infinities: " + dValueOf + "; at path " + jsonReader.getPath());
                }
            } catch (java.lang.NumberFormatException e) {
                throw new io.dcloud.uts.gson.JsonParseException("Cannot parse " + strNextString + "; at path " + jsonReader.getPath(), e);
            }
        }
    },
    UTS_Number { // from class: io.dcloud.uts.gson.ToNumberPolicy.4
        @Override // io.dcloud.uts.gson.ToNumberStrategy
        public java.lang.Number readNumber(io.dcloud.uts.gson.stream.JsonReader jsonReader) throws io.dcloud.uts.gson.JsonParseException, java.io.IOException {
            java.lang.String strNextString = jsonReader.nextString();
            java.lang.Double dValueOf = java.lang.Double.valueOf(io.dcloud.uts.UTSNumber.INSTANCE.from(strNextString).doubleValue());
            if (jsonReader.isLenient() || (!io.dcloud.uts.UTSNumber.INSTANCE.isNaN(dValueOf) && io.dcloud.uts.UTSNumber.INSTANCE.isFinite(dValueOf))) {
                return dValueOf;
            }
            throw new io.dcloud.uts.gson.stream.MalformedJsonException("JSON forbids NaN and infinities: " + strNextString + "; at path " + jsonReader.getPath());
        }
    },
    BIG_DECIMAL { // from class: io.dcloud.uts.gson.ToNumberPolicy.5
        @Override // io.dcloud.uts.gson.ToNumberStrategy
        public java.math.BigDecimal readNumber(io.dcloud.uts.gson.stream.JsonReader jsonReader) throws java.io.IOException {
            java.lang.String strNextString = jsonReader.nextString();
            try {
                return new java.math.BigDecimal(strNextString);
            } catch (java.lang.NumberFormatException e) {
                throw new io.dcloud.uts.gson.JsonParseException("Cannot parse " + strNextString + "; at path " + jsonReader.getPath(), e);
            }
        }
    }
}
