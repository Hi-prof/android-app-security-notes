package kotlin.reflect.jvm.internal.impl.renderer;

/* JADX INFO: compiled from: RenderingUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RenderingUtilsKt {
    public static final java.lang.String render(kotlin.reflect.jvm.internal.impl.name.Name name) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "<this>");
        if (!shouldBeEscaped(name)) {
            java.lang.String strAsString = name.asString();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strAsString, "asString(...)");
            return strAsString;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.lang.String strAsString2 = name.asString();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strAsString2, "asString(...)");
        sb.append("`" + strAsString2);
        sb.append('`');
        return sb.toString();
    }

    private static final boolean shouldBeEscaped(kotlin.reflect.jvm.internal.impl.name.Name name) {
        java.lang.String strAsString = name.asString();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strAsString, "asString(...)");
        if (kotlin.reflect.jvm.internal.impl.renderer.KeywordStringsGenerated.KEYWORDS.contains(strAsString)) {
            return true;
        }
        java.lang.String str = strAsString;
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (!java.lang.Character.isLetterOrDigit(cCharAt) && cCharAt != '_') {
                return true;
            }
        }
        return str.length() == 0 || !java.lang.Character.isJavaIdentifierStart(strAsString.codePointAt(0));
    }

    public static final java.lang.String render(kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe fqNameUnsafe) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fqNameUnsafe, "<this>");
        return renderFqName(fqNameUnsafe.pathSegments());
    }

    public static final java.lang.String renderFqName(java.util.List<kotlin.reflect.jvm.internal.impl.name.Name> pathSegments) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(pathSegments, "pathSegments");
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (kotlin.reflect.jvm.internal.impl.name.Name name : pathSegments) {
            if (sb.length() > 0) {
                sb.append(com.taobao.weex.el.parse.Operators.DOT_STR);
            }
            sb.append(render(name));
        }
        return sb.toString();
    }

    public static final java.lang.String replacePrefixesInTypeRepresentations(java.lang.String lowerRendered, java.lang.String lowerPrefix, java.lang.String upperRendered, java.lang.String upperPrefix, java.lang.String foldedPrefix) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(lowerRendered, "lowerRendered");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(lowerPrefix, "lowerPrefix");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(upperRendered, "upperRendered");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(upperPrefix, "upperPrefix");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(foldedPrefix, "foldedPrefix");
        if (kotlin.text.StringsKt.startsWith$default(lowerRendered, lowerPrefix, false, 2, (java.lang.Object) null) && kotlin.text.StringsKt.startsWith$default(upperRendered, upperPrefix, false, 2, (java.lang.Object) null)) {
            java.lang.String strSubstring = lowerRendered.substring(lowerPrefix.length());
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            java.lang.String strSubstring2 = upperRendered.substring(upperPrefix.length());
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
            java.lang.String str = foldedPrefix + strSubstring;
            if (kotlin.jvm.internal.Intrinsics.areEqual(strSubstring, strSubstring2)) {
                return str;
            }
            if (typeStringsDifferOnlyInNullability(strSubstring, strSubstring2)) {
                return str + '!';
            }
        }
        return null;
    }

    public static final boolean typeStringsDifferOnlyInNullability(java.lang.String lower, java.lang.String upper) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(lower, "lower");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(upper, "upper");
        if (kotlin.jvm.internal.Intrinsics.areEqual(lower, kotlin.text.StringsKt.replace$default(upper, com.taobao.weex.el.parse.Operators.CONDITION_IF_STRING, "", false, 4, (java.lang.Object) null))) {
            return true;
        }
        if (kotlin.text.StringsKt.endsWith$default(upper, com.taobao.weex.el.parse.Operators.CONDITION_IF_STRING, false, 2, (java.lang.Object) null)) {
            if (kotlin.jvm.internal.Intrinsics.areEqual(lower + com.taobao.weex.el.parse.Operators.CONDITION_IF, upper)) {
                return true;
            }
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder(com.taobao.weex.el.parse.Operators.BRACKET_START_STR);
        sb.append(lower);
        sb.append(")?");
        return kotlin.jvm.internal.Intrinsics.areEqual(sb.toString(), upper);
    }
}
