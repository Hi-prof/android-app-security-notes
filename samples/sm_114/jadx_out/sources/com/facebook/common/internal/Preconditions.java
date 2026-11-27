package com.facebook.common.internal;

/* JADX INFO: loaded from: classes.dex */
public final class Preconditions {
    private Preconditions() {
    }

    public static void checkArgument(@javax.annotation.Nullable java.lang.Boolean bool) {
        if (bool != null && !bool.booleanValue()) {
            throw new java.lang.IllegalArgumentException();
        }
    }

    public static void checkArgument(boolean z, @javax.annotation.Nullable java.lang.Object obj) {
        if (!z) {
            throw new java.lang.IllegalArgumentException(java.lang.String.valueOf(obj));
        }
    }

    public static void checkArgument(boolean z, @javax.annotation.Nullable java.lang.String str, java.lang.Object... objArr) {
        if (!z) {
            throw new java.lang.IllegalArgumentException(format(str, objArr));
        }
    }

    public static void checkState(boolean z) {
        if (!z) {
            throw new java.lang.IllegalStateException();
        }
    }

    public static void checkState(boolean z, @javax.annotation.Nullable java.lang.Object obj) {
        if (!z) {
            throw new java.lang.IllegalStateException(java.lang.String.valueOf(obj));
        }
    }

    public static void checkState(boolean z, @javax.annotation.Nullable java.lang.String str, java.lang.Object... objArr) {
        if (!z) {
            throw new java.lang.IllegalStateException(format(str, objArr));
        }
    }

    public static <T> T checkNotNull(@javax.annotation.Nullable T t) {
        t.getClass();
        return t;
    }

    public static <T> T checkNotNull(@javax.annotation.Nullable T t, @javax.annotation.Nullable java.lang.Object obj) {
        if (t != null) {
            return t;
        }
        throw new java.lang.NullPointerException(java.lang.String.valueOf(obj));
    }

    public static <T> T checkNotNull(@javax.annotation.Nullable T t, @javax.annotation.Nullable java.lang.String str, java.lang.Object... objArr) {
        if (t != null) {
            return t;
        }
        throw new java.lang.NullPointerException(format(str, objArr));
    }

    public static int checkElementIndex(int i, int i2) {
        return checkElementIndex(i, i2, "index");
    }

    public static int checkElementIndex(int i, int i2, @javax.annotation.Nullable java.lang.String str) {
        if (i < 0 || i >= i2) {
            throw new java.lang.IndexOutOfBoundsException(badElementIndex(i, i2, str));
        }
        return i;
    }

    private static java.lang.String badElementIndex(int i, int i2, @javax.annotation.Nullable java.lang.String str) {
        if (i < 0) {
            return format("%s (%s) must not be negative", str, java.lang.Integer.valueOf(i));
        }
        if (i2 >= 0) {
            return format("%s (%s) must be less than size (%s)", str, java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2));
        }
        throw new java.lang.IllegalArgumentException("negative size: " + i2);
    }

    public static int checkPositionIndex(int i, int i2) {
        return checkPositionIndex(i, i2, "index");
    }

    public static int checkPositionIndex(int i, int i2, @javax.annotation.Nullable java.lang.String str) {
        if (i < 0 || i > i2) {
            throw new java.lang.IndexOutOfBoundsException(badPositionIndex(i, i2, str));
        }
        return i;
    }

    private static java.lang.String badPositionIndex(int i, int i2, @javax.annotation.Nullable java.lang.String str) {
        if (i < 0) {
            return format("%s (%s) must not be negative", str, java.lang.Integer.valueOf(i));
        }
        if (i2 >= 0) {
            return format("%s (%s) must not be greater than size (%s)", str, java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2));
        }
        throw new java.lang.IllegalArgumentException("negative size: " + i2);
    }

    public static void checkPositionIndexes(int i, int i2, int i3) {
        if (i < 0 || i2 < i || i2 > i3) {
            throw new java.lang.IndexOutOfBoundsException(badPositionIndexes(i, i2, i3));
        }
    }

    private static java.lang.String badPositionIndexes(int i, int i2, int i3) {
        if (i < 0 || i > i3) {
            return badPositionIndex(i, i3, "start index");
        }
        return (i2 < 0 || i2 > i3) ? badPositionIndex(i2, i3, "end index") : format("end index (%s) must not be less than start index (%s)", java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(i));
    }

    static java.lang.String format(@javax.annotation.Nullable java.lang.String str, java.lang.Object... objArr) {
        int iIndexOf;
        java.lang.String strValueOf = java.lang.String.valueOf(str);
        java.lang.StringBuilder sb = new java.lang.StringBuilder(strValueOf.length() + (objArr.length * 16));
        int i = 0;
        int i2 = 0;
        while (i < objArr.length && (iIndexOf = strValueOf.indexOf("%s", i2)) != -1) {
            sb.append(strValueOf.substring(i2, iIndexOf));
            sb.append(objArr[i]);
            i2 = iIndexOf + 2;
            i++;
        }
        sb.append(strValueOf.substring(i2));
        if (i < objArr.length) {
            sb.append(" [");
            sb.append(objArr[i]);
            for (int i3 = i + 1; i3 < objArr.length; i3++) {
                sb.append(", ");
                sb.append(objArr[i3]);
            }
            sb.append(com.taobao.weex.el.parse.Operators.ARRAY_END);
        }
        return sb.toString();
    }
}
