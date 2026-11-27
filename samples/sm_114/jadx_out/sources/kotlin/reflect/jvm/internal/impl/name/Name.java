package kotlin.reflect.jvm.internal.impl.name;

/* JADX INFO: loaded from: classes2.dex */
public final class Name implements java.lang.Comparable<kotlin.reflect.jvm.internal.impl.name.Name> {
    private final java.lang.String name;
    private final boolean special;

    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        java.lang.String str = (i == 1 || i == 2 || i == 3 || i == 4) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        java.lang.Object[] objArr = new java.lang.Object[(i == 1 || i == 2 || i == 3 || i == 4) ? 2 : 3];
        if (i == 1 || i == 2 || i == 3 || i == 4) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/name/Name";
        } else {
            objArr[0] = "name";
        }
        if (i == 1) {
            objArr[1] = "asString";
        } else if (i == 2) {
            objArr[1] = "getIdentifier";
        } else if (i == 3 || i == 4) {
            objArr[1] = "asStringStripSpecialMarkers";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/name/Name";
        }
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
                break;
            case 5:
                objArr[2] = com.taobao.weex.ui.view.gesture.WXGestureType.GestureInfo.POINTER_ID;
                break;
            case 6:
                objArr[2] = "isValidIdentifier";
                break;
            case 7:
                objArr[2] = "identifierIfValid";
                break;
            case 8:
                objArr[2] = "special";
                break;
            case 9:
                objArr[2] = "guessByFirstCharacter";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        java.lang.String str2 = java.lang.String.format(str, objArr);
        if (i != 1 && i != 2 && i != 3 && i != 4) {
            throw new java.lang.IllegalArgumentException(str2);
        }
        throw new java.lang.IllegalStateException(str2);
    }

    private Name(java.lang.String str, boolean z) {
        if (str == null) {
            $$$reportNull$$$0(0);
        }
        this.name = str;
        this.special = z;
    }

    public java.lang.String asString() {
        java.lang.String str = this.name;
        if (str == null) {
            $$$reportNull$$$0(1);
        }
        return str;
    }

    public java.lang.String getIdentifier() {
        if (this.special) {
            throw new java.lang.IllegalStateException("not identifier: " + this);
        }
        java.lang.String strAsString = asString();
        if (strAsString == null) {
            $$$reportNull$$$0(2);
        }
        return strAsString;
    }

    public boolean isSpecial() {
        return this.special;
    }

    @Override // java.lang.Comparable
    public int compareTo(kotlin.reflect.jvm.internal.impl.name.Name name) {
        return this.name.compareTo(name.name);
    }

    public static kotlin.reflect.jvm.internal.impl.name.Name identifier(java.lang.String str) {
        if (str == null) {
            $$$reportNull$$$0(5);
        }
        return new kotlin.reflect.jvm.internal.impl.name.Name(str, false);
    }

    public static boolean isValidIdentifier(java.lang.String str) {
        if (str == null) {
            $$$reportNull$$$0(6);
        }
        if (str.isEmpty() || str.startsWith(com.taobao.weex.el.parse.Operators.L)) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '.' || cCharAt == '/' || cCharAt == '\\') {
                return false;
            }
        }
        return true;
    }

    public static kotlin.reflect.jvm.internal.impl.name.Name special(java.lang.String str) {
        if (str == null) {
            $$$reportNull$$$0(8);
        }
        if (!str.startsWith(com.taobao.weex.el.parse.Operators.L)) {
            throw new java.lang.IllegalArgumentException("special name must start with '<': " + str);
        }
        return new kotlin.reflect.jvm.internal.impl.name.Name(str, true);
    }

    public static kotlin.reflect.jvm.internal.impl.name.Name guessByFirstCharacter(java.lang.String str) {
        if (str == null) {
            $$$reportNull$$$0(9);
        }
        if (str.startsWith(com.taobao.weex.el.parse.Operators.L)) {
            return special(str);
        }
        return identifier(str);
    }

    public java.lang.String toString() {
        return this.name;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof kotlin.reflect.jvm.internal.impl.name.Name)) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.name.Name name = (kotlin.reflect.jvm.internal.impl.name.Name) obj;
        return this.special == name.special && this.name.equals(name.name);
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + (this.special ? 1 : 0);
    }
}
