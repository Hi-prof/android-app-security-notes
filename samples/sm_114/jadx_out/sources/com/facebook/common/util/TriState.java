package com.facebook.common.util;

/* JADX INFO: loaded from: classes.dex */
public enum TriState {
    YES,
    NO,
    UNSET;

    public boolean isSet() {
        return this != UNSET;
    }

    public static com.facebook.common.util.TriState valueOf(boolean z) {
        return z ? YES : NO;
    }

    public static com.facebook.common.util.TriState valueOf(@javax.annotation.Nullable java.lang.Boolean bool) {
        return bool != null ? valueOf(bool.booleanValue()) : UNSET;
    }

    /* JADX INFO: renamed from: com.facebook.common.util.TriState$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$common$util$TriState;

        static {
            int[] iArr = new int[com.facebook.common.util.TriState.values().length];
            $SwitchMap$com$facebook$common$util$TriState = iArr;
            try {
                iArr[com.facebook.common.util.TriState.YES.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$facebook$common$util$TriState[com.facebook.common.util.TriState.NO.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$facebook$common$util$TriState[com.facebook.common.util.TriState.UNSET.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
        }
    }

    public boolean asBoolean() {
        int i = com.facebook.common.util.TriState.AnonymousClass1.$SwitchMap$com$facebook$common$util$TriState[ordinal()];
        if (i == 1) {
            return true;
        }
        if (i == 2) {
            return false;
        }
        if (i == 3) {
            throw new java.lang.IllegalStateException("No boolean equivalent for UNSET");
        }
        throw new java.lang.IllegalStateException("Unrecognized TriState value: " + this);
    }

    public boolean asBoolean(boolean z) {
        int i = com.facebook.common.util.TriState.AnonymousClass1.$SwitchMap$com$facebook$common$util$TriState[ordinal()];
        if (i == 1) {
            return true;
        }
        if (i == 2) {
            return false;
        }
        if (i == 3) {
            return z;
        }
        throw new java.lang.IllegalStateException("Unrecognized TriState value: " + this);
    }

    @javax.annotation.Nullable
    public java.lang.Boolean asBooleanObject() {
        int i = com.facebook.common.util.TriState.AnonymousClass1.$SwitchMap$com$facebook$common$util$TriState[ordinal()];
        if (i == 1) {
            return java.lang.Boolean.TRUE;
        }
        if (i == 2) {
            return java.lang.Boolean.FALSE;
        }
        if (i == 3) {
            return null;
        }
        throw new java.lang.IllegalStateException("Unrecognized TriState value: " + this);
    }

    public int getDbValue() {
        int i = com.facebook.common.util.TriState.AnonymousClass1.$SwitchMap$com$facebook$common$util$TriState[ordinal()];
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                return 3;
            }
        }
        return i2;
    }

    public static com.facebook.common.util.TriState fromDbValue(int i) {
        if (i == 1) {
            return YES;
        }
        if (i == 2) {
            return NO;
        }
        return UNSET;
    }
}
