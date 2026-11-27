package io.dcloud.uts.gson;

/* JADX INFO: loaded from: classes2.dex */
public final class JsonArray extends io.dcloud.uts.gson.JsonElement implements java.lang.Iterable<io.dcloud.uts.gson.JsonElement> {
    private final java.util.List<io.dcloud.uts.gson.JsonElement> elements;

    public JsonArray() {
        this.elements = new java.util.ArrayList();
    }

    public JsonArray(int i) {
        this.elements = new java.util.ArrayList(i);
    }

    @Override // io.dcloud.uts.gson.JsonElement
    public io.dcloud.uts.gson.JsonArray deepCopy() {
        if (!this.elements.isEmpty()) {
            io.dcloud.uts.gson.JsonArray jsonArray = new io.dcloud.uts.gson.JsonArray(this.elements.size());
            java.util.Iterator<io.dcloud.uts.gson.JsonElement> it = this.elements.iterator();
            while (it.hasNext()) {
                jsonArray.add(it.next().deepCopy());
            }
            return jsonArray;
        }
        return new io.dcloud.uts.gson.JsonArray();
    }

    public void add(java.lang.Boolean bool) {
        this.elements.add(bool == null ? io.dcloud.uts.gson.JsonNull.INSTANCE : new io.dcloud.uts.gson.JsonPrimitive(bool));
    }

    public void add(java.lang.Character ch) {
        this.elements.add(ch == null ? io.dcloud.uts.gson.JsonNull.INSTANCE : new io.dcloud.uts.gson.JsonPrimitive(ch));
    }

    public void add(java.lang.Number number) {
        this.elements.add(number == null ? io.dcloud.uts.gson.JsonNull.INSTANCE : new io.dcloud.uts.gson.JsonPrimitive(number));
    }

    public void add(java.lang.String str) {
        this.elements.add(str == null ? io.dcloud.uts.gson.JsonNull.INSTANCE : new io.dcloud.uts.gson.JsonPrimitive(str));
    }

    public void add(io.dcloud.uts.gson.JsonElement jsonElement) {
        if (jsonElement == null) {
            jsonElement = io.dcloud.uts.gson.JsonNull.INSTANCE;
        }
        this.elements.add(jsonElement);
    }

    public void addAll(io.dcloud.uts.gson.JsonArray jsonArray) {
        this.elements.addAll(jsonArray.elements);
    }

    public io.dcloud.uts.gson.JsonElement set(int i, io.dcloud.uts.gson.JsonElement jsonElement) {
        return this.elements.set(i, jsonElement);
    }

    public boolean remove(io.dcloud.uts.gson.JsonElement jsonElement) {
        return this.elements.remove(jsonElement);
    }

    public io.dcloud.uts.gson.JsonElement remove(int i) {
        return this.elements.remove(i);
    }

    public boolean contains(io.dcloud.uts.gson.JsonElement jsonElement) {
        return this.elements.contains(jsonElement);
    }

    public int size() {
        return this.elements.size();
    }

    public boolean isEmpty() {
        return this.elements.isEmpty();
    }

    @Override // java.lang.Iterable
    public java.util.Iterator<io.dcloud.uts.gson.JsonElement> iterator() {
        return this.elements.iterator();
    }

    public io.dcloud.uts.gson.JsonElement get(int i) {
        return this.elements.get(i);
    }

    @Override // io.dcloud.uts.gson.JsonElement
    public java.lang.Number getAsNumber() {
        if (this.elements.size() == 1) {
            return this.elements.get(0).getAsNumber();
        }
        throw new java.lang.IllegalStateException();
    }

    @Override // io.dcloud.uts.gson.JsonElement
    public java.lang.String getAsString() {
        if (this.elements.size() == 1) {
            return this.elements.get(0).getAsString();
        }
        throw new java.lang.IllegalStateException();
    }

    @Override // io.dcloud.uts.gson.JsonElement
    public double getAsDouble() {
        if (this.elements.size() == 1) {
            return this.elements.get(0).getAsDouble();
        }
        throw new java.lang.IllegalStateException();
    }

    @Override // io.dcloud.uts.gson.JsonElement
    public java.math.BigDecimal getAsBigDecimal() {
        if (this.elements.size() == 1) {
            return this.elements.get(0).getAsBigDecimal();
        }
        throw new java.lang.IllegalStateException();
    }

    @Override // io.dcloud.uts.gson.JsonElement
    public java.math.BigInteger getAsBigInteger() {
        if (this.elements.size() == 1) {
            return this.elements.get(0).getAsBigInteger();
        }
        throw new java.lang.IllegalStateException();
    }

    @Override // io.dcloud.uts.gson.JsonElement
    public float getAsFloat() {
        if (this.elements.size() == 1) {
            return this.elements.get(0).getAsFloat();
        }
        throw new java.lang.IllegalStateException();
    }

    @Override // io.dcloud.uts.gson.JsonElement
    public long getAsLong() {
        if (this.elements.size() == 1) {
            return this.elements.get(0).getAsLong();
        }
        throw new java.lang.IllegalStateException();
    }

    @Override // io.dcloud.uts.gson.JsonElement
    public int getAsInt() {
        if (this.elements.size() == 1) {
            return this.elements.get(0).getAsInt();
        }
        throw new java.lang.IllegalStateException();
    }

    @Override // io.dcloud.uts.gson.JsonElement
    public byte getAsByte() {
        if (this.elements.size() == 1) {
            return this.elements.get(0).getAsByte();
        }
        throw new java.lang.IllegalStateException();
    }

    @Override // io.dcloud.uts.gson.JsonElement
    public char getAsCharacter() {
        if (this.elements.size() == 1) {
            return this.elements.get(0).getAsCharacter();
        }
        throw new java.lang.IllegalStateException();
    }

    @Override // io.dcloud.uts.gson.JsonElement
    public short getAsShort() {
        if (this.elements.size() == 1) {
            return this.elements.get(0).getAsShort();
        }
        throw new java.lang.IllegalStateException();
    }

    @Override // io.dcloud.uts.gson.JsonElement
    public boolean getAsBoolean() {
        if (this.elements.size() == 1) {
            return this.elements.get(0).getAsBoolean();
        }
        throw new java.lang.IllegalStateException();
    }

    public boolean equals(java.lang.Object obj) {
        if (obj != this) {
            return (obj instanceof io.dcloud.uts.gson.JsonArray) && ((io.dcloud.uts.gson.JsonArray) obj).elements.equals(this.elements);
        }
        return true;
    }

    public int hashCode() {
        return this.elements.hashCode();
    }
}
