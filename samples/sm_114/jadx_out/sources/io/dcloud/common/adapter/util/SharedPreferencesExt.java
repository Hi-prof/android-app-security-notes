package io.dcloud.common.adapter.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class SharedPreferencesExt implements android.content.SharedPreferences {
    static final byte BOOLEAN = 2;
    static final byte FLOAT = 3;
    static final byte INT = 1;
    static final byte LONG = 4;
    public static final java.lang.String N_BASE = "pdr";
    static final byte STRING = 5;
    static final byte STRING_SET = 6;
    private static final java.util.HashMap<java.lang.String, java.util.LinkedHashMap> mLinkedHashMapCollenction = new java.util.HashMap<>(4);
    private io.dcloud.common.adapter.util.SharedPreferencesExt.W2AEditor editor;
    private java.io.File mFileHandler;
    private long mFileModifyTime;
    private java.util.LinkedHashMap<java.lang.String, java.lang.Object> mKeyValue;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static class W2AEditor implements android.content.SharedPreferences.Editor {
        java.util.LinkedHashMap<java.lang.String, java.lang.Object> mCache;
        io.dcloud.common.adapter.util.SharedPreferencesExt mSP;

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
            this.mSP.mKeyValue.putAll(this.mCache);
            this.mCache.clear();
        }

        @Override // android.content.SharedPreferences.Editor
        public android.content.SharedPreferences.Editor clear() {
            this.mCache.clear();
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            this.mSP.mKeyValue.putAll(this.mCache);
            this.mSP.saveLocal();
            this.mCache.clear();
            return false;
        }

        @Override // android.content.SharedPreferences.Editor
        public android.content.SharedPreferences.Editor putBoolean(java.lang.String str, boolean z) {
            this.mCache.put(str, java.lang.Boolean.valueOf(z));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public android.content.SharedPreferences.Editor putFloat(java.lang.String str, float f) {
            this.mCache.put(str, java.lang.Float.valueOf(f));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public android.content.SharedPreferences.Editor putInt(java.lang.String str, int i) {
            this.mCache.put(str, java.lang.Integer.valueOf(i));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public android.content.SharedPreferences.Editor putLong(java.lang.String str, long j) {
            this.mCache.put(str, java.lang.Long.valueOf(j));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public android.content.SharedPreferences.Editor putString(java.lang.String str, java.lang.String str2) {
            this.mCache.put(str, str2);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public android.content.SharedPreferences.Editor putStringSet(java.lang.String str, java.util.Set<java.lang.String> set) {
            this.mCache.put(str, set);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public android.content.SharedPreferences.Editor remove(java.lang.String str) {
            this.mCache.remove(str);
            return this;
        }

        private W2AEditor(io.dcloud.common.adapter.util.SharedPreferencesExt sharedPreferencesExt) {
            this.mCache = new java.util.LinkedHashMap<>(16);
            this.mSP = sharedPreferencesExt;
        }
    }

    public SharedPreferencesExt(android.content.Context context, java.lang.String str) {
        this(context, str, 0);
    }

    private void checkModify() {
        if (this.mFileModifyTime != this.mFileHandler.lastModified()) {
            reset();
        }
    }

    private void reset() {
        try {
            this.mKeyValue.clear();
            this.mFileModifyTime = this.mFileHandler.lastModified();
            java.io.FileInputStream fileInputStream = new java.io.FileInputStream(this.mFileHandler);
            byte[] bArr = new byte[4];
            byte[] bArr2 = new byte[1];
            byte[] bArr3 = new byte[256];
            while (fileInputStream.read(bArr) > 0) {
                int i = io.dcloud.common.adapter.util.ByteUtil.toInt(bArr);
                if (i > bArr3.length) {
                    bArr3 = new byte[i];
                }
                java.lang.String str = new java.lang.String(bArr3, 0, fileInputStream.read(bArr3, 0, i), "UTF-8");
                fileInputStream.read(bArr2);
                byte b = bArr2[0];
                fileInputStream.read(bArr);
                int i2 = io.dcloud.common.adapter.util.ByteUtil.toInt(bArr);
                if (i2 > bArr3.length) {
                    bArr3 = new byte[i2];
                }
                byte[] bArr4 = bArr3;
                load(this.mKeyValue, str, bArr4, fileInputStream.read(bArr4, 0, i2), b);
                bArr3 = bArr4;
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean saveLocal() {
        save(this.mKeyValue);
        return false;
    }

    @Override // android.content.SharedPreferences
    public boolean contains(java.lang.String str) {
        checkModify();
        return this.mKeyValue.containsKey(str);
    }

    @Override // android.content.SharedPreferences
    public android.content.SharedPreferences.Editor edit() {
        checkModify();
        return this.editor;
    }

    @Override // android.content.SharedPreferences
    public java.util.Map<java.lang.String, ?> getAll() {
        checkModify();
        return (java.util.HashMap) this.mKeyValue.clone();
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(java.lang.String str, boolean z) {
        try {
            checkModify();
            return this.mKeyValue.containsKey(str) ? ((java.lang.Boolean) this.mKeyValue.get(str)).booleanValue() : z;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return z;
        }
    }

    @Override // android.content.SharedPreferences
    public float getFloat(java.lang.String str, float f) {
        try {
            checkModify();
            return this.mKeyValue.containsKey(str) ? ((java.lang.Float) this.mKeyValue.get(str)).floatValue() : f;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return f;
        }
    }

    @Override // android.content.SharedPreferences
    public int getInt(java.lang.String str, int i) {
        try {
            checkModify();
            return this.mKeyValue.containsKey(str) ? ((java.lang.Integer) this.mKeyValue.get(str)).intValue() : i;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return i;
        }
    }

    @Override // android.content.SharedPreferences
    public long getLong(java.lang.String str, long j) {
        try {
            checkModify();
            return this.mKeyValue.containsKey(str) ? ((java.lang.Long) this.mKeyValue.get(str)).longValue() : j;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return j;
        }
    }

    @Override // android.content.SharedPreferences
    public java.lang.String getString(java.lang.String str, java.lang.String str2) {
        try {
            checkModify();
            return this.mKeyValue.containsKey(str) ? (java.lang.String) this.mKeyValue.get(str) : str2;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return str2;
        }
    }

    @Override // android.content.SharedPreferences
    public java.util.Set<java.lang.String> getStringSet(java.lang.String str, java.util.Set<java.lang.String> set) {
        try {
            checkModify();
            return (java.util.Set) this.mKeyValue.get(str);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return set;
        }
    }

    boolean hasChaged() {
        return this.mFileHandler.lastModified() != this.mFileModifyTime;
    }

    void load(java.util.LinkedHashMap<java.lang.String, java.lang.Object> linkedHashMap, java.lang.String str, byte[] bArr, int i, byte b) {
        int i2 = 0;
        switch (b) {
            case 1:
                linkedHashMap.put(str, java.lang.Integer.valueOf(io.dcloud.common.adapter.util.ByteUtil.toInt(new byte[]{bArr[0], bArr[1], bArr[2], bArr[3]})));
                break;
            case 2:
                linkedHashMap.put(str, java.lang.Boolean.valueOf(bArr[0] == 1));
                break;
            case 3:
                byte[] bArr2 = new byte[i];
                while (i2 < i && i2 < bArr.length) {
                    bArr2[i2] = bArr[i2];
                    i2++;
                }
                linkedHashMap.put(str, java.lang.Float.valueOf(io.dcloud.common.adapter.util.ByteUtil.bytesToFloat(bArr2)));
                break;
            case 4:
                byte[] bArr3 = new byte[i];
                while (i2 < i && i2 < bArr.length) {
                    bArr3[i2] = bArr[i2];
                    i2++;
                }
                linkedHashMap.put(str, java.lang.Long.valueOf(io.dcloud.common.adapter.util.ByteUtil.bytesToLong(bArr3)));
                break;
            case 5:
                try {
                    linkedHashMap.put(str, new java.lang.String(bArr, 0, i, "UTF-8"));
                } catch (java.io.UnsupportedEncodingException e) {
                    e.printStackTrace();
                    return;
                }
                break;
            case 6:
                try {
                    linkedHashMap.put(str, new java.lang.String(bArr, 0, i, "UTF-8"));
                } catch (java.io.UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                    return;
                }
                break;
        }
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(android.content.SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    void save(java.util.LinkedHashMap<java.lang.String, java.lang.Object> linkedHashMap) {
        byte[] bytes;
        try {
            java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(this.mFileHandler, false);
            byte[] bArr = new byte[1];
            for (java.util.Map.Entry<java.lang.String, java.lang.Object> entry : linkedHashMap.entrySet()) {
                byte[] bytes2 = entry.getKey().getBytes("UTF-8");
                fileOutputStream.write(io.dcloud.common.adapter.util.ByteUtil.toBytes(bytes2.length));
                fileOutputStream.write(bytes2);
                java.lang.Object value = entry.getValue();
                java.lang.Class<?> cls = value.getClass();
                if (cls == java.lang.Integer.TYPE || cls == java.lang.Integer.class) {
                    bArr[0] = 1;
                    bytes = io.dcloud.common.adapter.util.ByteUtil.toBytes(((java.lang.Integer) value).intValue());
                } else if (cls == java.lang.Boolean.TYPE || cls == java.lang.Boolean.class) {
                    bArr[0] = 2;
                    bytes = ((java.lang.Boolean) value).booleanValue() ? new byte[]{1} : new byte[]{0};
                } else if (cls == java.lang.String.class) {
                    bArr[0] = 5;
                    bytes = ((java.lang.String) value).getBytes("UTF-8");
                } else if (cls == java.lang.Long.TYPE || cls == java.lang.Long.class) {
                    bArr[0] = 4;
                    bytes = io.dcloud.common.adapter.util.ByteUtil.longToBytes(((java.lang.Long) value).longValue());
                } else if (cls == java.lang.Float.TYPE || cls == java.lang.Float.class) {
                    bArr[0] = 3;
                    bytes = io.dcloud.common.adapter.util.ByteUtil.floatToBytes(((java.lang.Float) value).floatValue());
                } else if (cls == java.util.Set.class) {
                    bArr[0] = 6;
                    bytes = value.toString().getBytes("UTF-8");
                }
                fileOutputStream.write(bArr);
                fileOutputStream.write(io.dcloud.common.adapter.util.ByteUtil.toBytes(bytes.length));
                fileOutputStream.write(bytes);
            }
            this.mFileModifyTime = this.mFileHandler.lastModified();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(android.content.SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    public SharedPreferencesExt(android.content.Context context, java.lang.String str, int i) {
        this.editor = null;
        this.mFileHandler = null;
        this.mFileModifyTime = java.lang.System.currentTimeMillis();
        this.mKeyValue = null;
        this.mKeyValue = mLinkedHashMapCollenction.get(str);
        this.editor = new io.dcloud.common.adapter.util.SharedPreferencesExt.W2AEditor();
        java.lang.String str2 = "/data/data/" + context.getPackageName() + "/shared_prefs_ext/" + str;
        if (this.mKeyValue != null) {
            this.mFileHandler = new java.io.File(str2);
            return;
        }
        this.mKeyValue = new java.util.LinkedHashMap<>(16);
        java.io.File file = new java.io.File(str2);
        this.mFileHandler = file;
        if (!file.getParentFile().exists()) {
            this.mFileHandler.getParentFile().mkdirs();
        }
        if (this.mFileHandler.exists()) {
            reset();
        } else {
            try {
                this.mFileHandler.createNewFile();
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        }
        mLinkedHashMapCollenction.put(str, this.mKeyValue);
    }
}
