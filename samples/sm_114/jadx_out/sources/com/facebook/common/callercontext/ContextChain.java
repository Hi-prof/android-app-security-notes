package com.facebook.common.callercontext;

/* JADX INFO: loaded from: classes.dex */
public class ContextChain implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.facebook.common.callercontext.ContextChain> CREATOR = new android.os.Parcelable.Creator<com.facebook.common.callercontext.ContextChain>() { // from class: com.facebook.common.callercontext.ContextChain.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.facebook.common.callercontext.ContextChain createFromParcel(android.os.Parcel parcel) {
            return new com.facebook.common.callercontext.ContextChain(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.facebook.common.callercontext.ContextChain[] newArray(int i) {
            return new com.facebook.common.callercontext.ContextChain[i];
        }
    };
    private static final char PARENT_SEPARATOR = '/';
    public static final java.lang.String TAG_INFRA = "i";
    public static final java.lang.String TAG_PRODUCT = "p";
    public static final java.lang.String TAG_PRODUCT_AND_INFRA = "pi";
    private static boolean sUseConcurrentHashMap = false;

    @javax.annotation.Nullable
    private java.util.Map<java.lang.String, java.lang.Object> mExtraData;
    private final java.lang.String mName;

    @javax.annotation.Nullable
    private final com.facebook.common.callercontext.ContextChain mParent;

    @javax.annotation.Nullable
    private java.lang.String mSerializedChainString;
    private java.lang.String mSerializedNodeString;
    private final java.lang.String mTag;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ContextChain(java.lang.String str, java.lang.String str2, @javax.annotation.Nullable java.util.Map<java.lang.String, java.lang.String> map, @javax.annotation.Nullable com.facebook.common.callercontext.ContextChain contextChain) {
        this.mTag = str;
        this.mName = str2;
        this.mSerializedNodeString = str + ":" + str2;
        this.mParent = contextChain;
        initializeExtraData(contextChain, map);
    }

    private void initializeExtraData(@javax.annotation.Nullable com.facebook.common.callercontext.ContextChain contextChain, @javax.annotation.Nullable java.util.Map<java.lang.String, ?> map) {
        java.util.Map<java.lang.String, java.lang.Object> extraData = contextChain != null ? contextChain.getExtraData() : null;
        if (extraData != null) {
            if (sUseConcurrentHashMap) {
                this.mExtraData = new java.util.concurrent.ConcurrentHashMap(extraData);
            } else {
                this.mExtraData = new java.util.HashMap(extraData);
            }
        }
        if (map != null) {
            if (this.mExtraData == null) {
                if (sUseConcurrentHashMap) {
                    this.mExtraData = new java.util.concurrent.ConcurrentHashMap();
                } else {
                    this.mExtraData = new java.util.HashMap();
                }
            }
            this.mExtraData.putAll(map);
        }
    }

    public ContextChain(java.lang.String str, @javax.annotation.Nullable java.util.Map<java.lang.String, java.lang.Object> map, @javax.annotation.Nullable com.facebook.common.callercontext.ContextChain contextChain) {
        this.mTag = "serialized_tag";
        this.mName = "serialized_name";
        this.mSerializedNodeString = str;
        this.mParent = contextChain;
        initializeExtraData(contextChain, map);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ContextChain(java.lang.String str, @javax.annotation.Nullable com.facebook.common.callercontext.ContextChain contextChain) {
        this(str, (java.util.Map<java.lang.String, java.lang.Object>) null, contextChain);
    }

    public ContextChain(java.lang.String str, java.lang.String str2, @javax.annotation.Nullable com.facebook.common.callercontext.ContextChain contextChain) {
        this(str, str2, null, contextChain);
    }

    protected ContextChain(android.os.Parcel parcel) {
        this.mTag = parcel.readString();
        this.mName = parcel.readString();
        this.mSerializedNodeString = parcel.readString();
        this.mParent = (com.facebook.common.callercontext.ContextChain) parcel.readParcelable(com.facebook.common.callercontext.ContextChain.class.getClassLoader());
    }

    public static void setUseConcurrentHashMap(boolean z) {
        sUseConcurrentHashMap = z;
    }

    public java.lang.String getName() {
        return this.mName;
    }

    public java.lang.String getTag() {
        return this.mTag;
    }

    @javax.annotation.Nullable
    public java.util.Map<java.lang.String, java.lang.Object> getExtraData() {
        return this.mExtraData;
    }

    @javax.annotation.Nullable
    public com.facebook.common.callercontext.ContextChain getParent() {
        return this.mParent;
    }

    public com.facebook.common.callercontext.ContextChain getRootContextChain() {
        com.facebook.common.callercontext.ContextChain contextChain = this.mParent;
        return contextChain == null ? this : contextChain.getRootContextChain();
    }

    @javax.annotation.Nullable
    public java.lang.String getStringExtra(java.lang.String str) {
        java.lang.Object obj;
        java.util.Map<java.lang.String, java.lang.Object> map = this.mExtraData;
        if (map == null) {
            return null;
        }
        if ((sUseConcurrentHashMap && str == null) || (obj = map.get(str)) == null) {
            return null;
        }
        return java.lang.String.valueOf(obj);
    }

    public void putObjectExtra(java.lang.String str, java.lang.Object obj) {
        boolean z = sUseConcurrentHashMap;
        if (z && (str == null || obj == null)) {
            return;
        }
        if (this.mExtraData == null) {
            if (z) {
                this.mExtraData = new java.util.concurrent.ConcurrentHashMap();
            } else {
                this.mExtraData = new java.util.HashMap();
            }
        }
        this.mExtraData.put(str, obj);
    }

    public java.lang.String toString() {
        if (this.mSerializedChainString == null) {
            this.mSerializedChainString = getNodeString();
            if (this.mParent != null) {
                this.mSerializedChainString = this.mParent.toString() + PARENT_SEPARATOR + this.mSerializedChainString;
            }
        }
        return this.mSerializedChainString;
    }

    protected java.lang.String getNodeString() {
        return this.mSerializedNodeString;
    }

    public java.lang.String[] toStringArray() {
        return toString().split(java.lang.String.valueOf(PARENT_SEPARATOR));
    }

    public boolean equals(@javax.annotation.Nullable java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            com.facebook.common.callercontext.ContextChain contextChain = (com.facebook.common.callercontext.ContextChain) obj;
            if (java.util.Objects.equals(getNodeString(), contextChain.getNodeString()) && java.util.Objects.equals(this.mParent, contextChain.mParent)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return java.util.Objects.hash(this.mParent, getNodeString());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.mTag);
        parcel.writeString(this.mName);
        parcel.writeString(getNodeString());
        parcel.writeParcelable(this.mParent, i);
    }
}
