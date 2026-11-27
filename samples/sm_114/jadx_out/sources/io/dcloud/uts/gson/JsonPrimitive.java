package io.dcloud.uts.gson;

/* JADX INFO: loaded from: classes2.dex */
public final class JsonPrimitive extends io.dcloud.uts.gson.JsonElement {
    private final java.lang.Object value;

    @Override // io.dcloud.uts.gson.JsonElement
    public io.dcloud.uts.gson.JsonPrimitive deepCopy() {
        return this;
    }

    public JsonPrimitive(java.lang.Boolean bool) {
        this.value = io.dcloud.uts.gson.internal.C$Gson$Preconditions.checkNotNull(bool);
    }

    public JsonPrimitive(java.lang.Number number) {
        this.value = io.dcloud.uts.gson.internal.C$Gson$Preconditions.checkNotNull(number);
    }

    public JsonPrimitive(java.lang.String str) {
        this.value = io.dcloud.uts.gson.internal.C$Gson$Preconditions.checkNotNull(str);
    }

    public JsonPrimitive(java.lang.Character ch) {
        this.value = ((java.lang.Character) io.dcloud.uts.gson.internal.C$Gson$Preconditions.checkNotNull(ch)).toString();
    }

    public boolean isBoolean() {
        return this.value instanceof java.lang.Boolean;
    }

    @Override // io.dcloud.uts.gson.JsonElement
    public boolean getAsBoolean() {
        if (isBoolean()) {
            return ((java.lang.Boolean) this.value).booleanValue();
        }
        return java.lang.Boolean.parseBoolean(getAsString());
    }

    public boolean isNumber() {
        return this.value instanceof java.lang.Number;
    }

    @Override // io.dcloud.uts.gson.JsonElement
    public java.lang.Number getAsNumber() {
        java.lang.Object obj = this.value;
        return obj instanceof java.lang.String ? io.dcloud.uts.UTSNumber.INSTANCE.from((java.lang.String) this.value) : (java.lang.Number) obj;
    }

    public boolean isString() {
        return this.value instanceof java.lang.String;
    }

    @Override // io.dcloud.uts.gson.JsonElement
    public java.lang.String getAsString() {
        if (isNumber()) {
            return getAsNumber().toString();
        }
        if (isBoolean()) {
            return ((java.lang.Boolean) this.value).toString();
        }
        return (java.lang.String) this.value;
    }

    @Override // io.dcloud.uts.gson.JsonElement
    public double getAsDouble() {
        return isNumber() ? getAsNumber().doubleValue() : java.lang.Double.parseDouble(getAsString());
    }

    @Override // io.dcloud.uts.gson.JsonElement
    public java.math.BigDecimal getAsBigDecimal() {
        java.lang.Object obj = this.value;
        return obj instanceof java.math.BigDecimal ? (java.math.BigDecimal) obj : new java.math.BigDecimal(this.value.toString());
    }

    @Override // io.dcloud.uts.gson.JsonElement
    public java.math.BigInteger getAsBigInteger() {
        java.lang.Object obj = this.value;
        return obj instanceof java.math.BigInteger ? (java.math.BigInteger) obj : new java.math.BigInteger(this.value.toString());
    }

    @Override // io.dcloud.uts.gson.JsonElement
    public float getAsFloat() {
        return isNumber() ? getAsNumber().floatValue() : java.lang.Float.parseFloat(getAsString());
    }

    @Override // io.dcloud.uts.gson.JsonElement
    public long getAsLong() {
        return isNumber() ? getAsNumber().longValue() : java.lang.Long.parseLong(getAsString());
    }

    @Override // io.dcloud.uts.gson.JsonElement
    public short getAsShort() {
        return isNumber() ? getAsNumber().shortValue() : java.lang.Short.parseShort(getAsString());
    }

    @Override // io.dcloud.uts.gson.JsonElement
    public int getAsInt() {
        return isNumber() ? getAsNumber().intValue() : java.lang.Integer.parseInt(getAsString());
    }

    @Override // io.dcloud.uts.gson.JsonElement
    public byte getAsByte() {
        return isNumber() ? getAsNumber().byteValue() : java.lang.Byte.parseByte(getAsString());
    }

    @Override // io.dcloud.uts.gson.JsonElement
    public char getAsCharacter() {
        return getAsString().charAt(0);
    }

    public int hashCode() {
        long jDoubleToLongBits;
        if (this.value == null) {
            return 31;
        }
        if (isIntegral(this)) {
            jDoubleToLongBits = getAsNumber().longValue();
        } else {
            java.lang.Object obj = this.value;
            if (obj instanceof java.lang.Number) {
                jDoubleToLongBits = java.lang.Double.doubleToLongBits(getAsNumber().doubleValue());
            } else {
                return obj.hashCode();
            }
        }
        return (int) ((jDoubleToLongBits >>> 32) ^ jDoubleToLongBits);
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        io.dcloud.uts.gson.JsonPrimitive jsonPrimitive = (io.dcloud.uts.gson.JsonPrimitive) obj;
        if (this.value == null) {
            return jsonPrimitive.value == null;
        }
        if (isIntegral(this) && isIntegral(jsonPrimitive)) {
            return getAsNumber().longValue() == jsonPrimitive.getAsNumber().longValue();
        }
        java.lang.Object obj2 = this.value;
        if ((obj2 instanceof java.lang.Number) && (jsonPrimitive.value instanceof java.lang.Number)) {
            double dDoubleValue = getAsNumber().doubleValue();
            double dDoubleValue2 = jsonPrimitive.getAsNumber().doubleValue();
            return dDoubleValue == dDoubleValue2 || (java.lang.Double.isNaN(dDoubleValue) && java.lang.Double.isNaN(dDoubleValue2));
        }
        return obj2.equals(jsonPrimitive.value);
    }

    private static boolean isIntegral(io.dcloud.uts.gson.JsonPrimitive jsonPrimitive) {
        java.lang.Object obj = jsonPrimitive.value;
        if (!(obj instanceof java.lang.Number)) {
            return false;
        }
        java.lang.Number number = (java.lang.Number) obj;
        return (number instanceof java.math.BigInteger) || (number instanceof java.lang.Long) || (number instanceof java.lang.Integer) || (number instanceof java.lang.Short) || (number instanceof java.lang.Byte);
    }
}
