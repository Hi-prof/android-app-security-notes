package com.facebook.common.internal;

/* JADX INFO: loaded from: classes.dex */
public final class Objects {
    @javax.annotation.CheckReturnValue
    public static boolean equal(@javax.annotation.Nullable java.lang.Object obj, @javax.annotation.Nullable java.lang.Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static int hashCode(@javax.annotation.Nullable java.lang.Object... objArr) {
        return java.util.Arrays.hashCode(objArr);
    }

    public static com.facebook.common.internal.Objects.ToStringHelper toStringHelper(java.lang.Object obj) {
        return new com.facebook.common.internal.Objects.ToStringHelper(obj.getClass().getSimpleName());
    }

    public static com.facebook.common.internal.Objects.ToStringHelper toStringHelper(java.lang.Class<?> cls) {
        return new com.facebook.common.internal.Objects.ToStringHelper(cls.getSimpleName());
    }

    public static com.facebook.common.internal.Objects.ToStringHelper toStringHelper(java.lang.String str) {
        return new com.facebook.common.internal.Objects.ToStringHelper(str);
    }

    public static <T> T firstNonNull(@javax.annotation.Nullable T t, @javax.annotation.Nullable T t2) {
        return t != null ? t : (T) com.facebook.common.internal.Preconditions.checkNotNull(t2);
    }

    public static final class ToStringHelper {
        private final java.lang.String className;
        private final com.facebook.common.internal.Objects.ToStringHelper.ValueHolder holderHead;
        private com.facebook.common.internal.Objects.ToStringHelper.ValueHolder holderTail;
        private boolean omitNullValues;

        private ToStringHelper(java.lang.String str) {
            com.facebook.common.internal.Objects.ToStringHelper.ValueHolder valueHolder = new com.facebook.common.internal.Objects.ToStringHelper.ValueHolder();
            this.holderHead = valueHolder;
            this.holderTail = valueHolder;
            this.omitNullValues = false;
            this.className = (java.lang.String) com.facebook.common.internal.Preconditions.checkNotNull(str);
        }

        public com.facebook.common.internal.Objects.ToStringHelper omitNullValues() {
            this.omitNullValues = true;
            return this;
        }

        public com.facebook.common.internal.Objects.ToStringHelper add(java.lang.String str, @javax.annotation.Nullable java.lang.Object obj) {
            return addHolder(str, obj);
        }

        public com.facebook.common.internal.Objects.ToStringHelper add(java.lang.String str, boolean z) {
            return addHolder(str, java.lang.String.valueOf(z));
        }

        public com.facebook.common.internal.Objects.ToStringHelper add(java.lang.String str, char c) {
            return addHolder(str, java.lang.String.valueOf(c));
        }

        public com.facebook.common.internal.Objects.ToStringHelper add(java.lang.String str, double d) {
            return addHolder(str, java.lang.String.valueOf(d));
        }

        public com.facebook.common.internal.Objects.ToStringHelper add(java.lang.String str, float f) {
            return addHolder(str, java.lang.String.valueOf(f));
        }

        public com.facebook.common.internal.Objects.ToStringHelper add(java.lang.String str, int i) {
            return addHolder(str, java.lang.String.valueOf(i));
        }

        public com.facebook.common.internal.Objects.ToStringHelper add(java.lang.String str, long j) {
            return addHolder(str, java.lang.String.valueOf(j));
        }

        public com.facebook.common.internal.Objects.ToStringHelper addValue(@javax.annotation.Nullable java.lang.Object obj) {
            return addHolder(obj);
        }

        public com.facebook.common.internal.Objects.ToStringHelper addValue(boolean z) {
            return addHolder(java.lang.String.valueOf(z));
        }

        public com.facebook.common.internal.Objects.ToStringHelper addValue(char c) {
            return addHolder(java.lang.String.valueOf(c));
        }

        public com.facebook.common.internal.Objects.ToStringHelper addValue(double d) {
            return addHolder(java.lang.String.valueOf(d));
        }

        public com.facebook.common.internal.Objects.ToStringHelper addValue(float f) {
            return addHolder(java.lang.String.valueOf(f));
        }

        public com.facebook.common.internal.Objects.ToStringHelper addValue(int i) {
            return addHolder(java.lang.String.valueOf(i));
        }

        public com.facebook.common.internal.Objects.ToStringHelper addValue(long j) {
            return addHolder(java.lang.String.valueOf(j));
        }

        public java.lang.String toString() {
            boolean z = this.omitNullValues;
            java.lang.StringBuilder sb = new java.lang.StringBuilder(32);
            sb.append(this.className);
            sb.append(com.taobao.weex.el.parse.Operators.BLOCK_START);
            java.lang.String str = "";
            for (com.facebook.common.internal.Objects.ToStringHelper.ValueHolder valueHolder = this.holderHead.next; valueHolder != null; valueHolder = valueHolder.next) {
                java.lang.Object obj = valueHolder.value;
                if (!z || obj != null) {
                    sb.append(str);
                    if (valueHolder.name != null) {
                        sb.append(valueHolder.name);
                        sb.append('=');
                    }
                    if (obj != null && obj.getClass().isArray()) {
                        java.lang.String strDeepToString = java.util.Arrays.deepToString(new java.lang.Object[]{obj});
                        sb.append((java.lang.CharSequence) strDeepToString, 1, strDeepToString.length() - 1);
                    } else {
                        sb.append(obj);
                    }
                    str = ", ";
                }
            }
            sb.append(com.taobao.weex.el.parse.Operators.BLOCK_END);
            return sb.toString();
        }

        private com.facebook.common.internal.Objects.ToStringHelper.ValueHolder addHolder() {
            com.facebook.common.internal.Objects.ToStringHelper.ValueHolder valueHolder = new com.facebook.common.internal.Objects.ToStringHelper.ValueHolder();
            this.holderTail.next = valueHolder;
            this.holderTail = valueHolder;
            return valueHolder;
        }

        private com.facebook.common.internal.Objects.ToStringHelper addHolder(@javax.annotation.Nullable java.lang.Object obj) {
            addHolder().value = obj;
            return this;
        }

        private com.facebook.common.internal.Objects.ToStringHelper addHolder(java.lang.String str, @javax.annotation.Nullable java.lang.Object obj) {
            com.facebook.common.internal.Objects.ToStringHelper.ValueHolder valueHolderAddHolder = addHolder();
            valueHolderAddHolder.value = obj;
            valueHolderAddHolder.name = (java.lang.String) com.facebook.common.internal.Preconditions.checkNotNull(str);
            return this;
        }

        private static final class ValueHolder {

            @javax.annotation.Nullable
            java.lang.String name;

            @javax.annotation.Nullable
            com.facebook.common.internal.Objects.ToStringHelper.ValueHolder next;

            @javax.annotation.Nullable
            java.lang.Object value;

            private ValueHolder() {
            }
        }
    }

    private Objects() {
    }
}
