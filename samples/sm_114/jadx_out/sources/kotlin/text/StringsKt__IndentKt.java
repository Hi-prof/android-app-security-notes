package kotlin.text;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: Indent.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0007\u001a\u001e\u0010\u0003\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0001\u001a\f\u0010\u0005\u001a\u00020\u0001*\u00020\u0001H\u0007\u001a\u0014\u0010\u0006\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0001\u001a\u0014\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\u0001\u001a\u0011\u0010\t\u001a\u00020\n*\u00020\u0001H\u0002¢\u0006\u0002\b\u000b\u001a!\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\r2\u0006\u0010\b\u001a\u00020\u0001H\u0002¢\u0006\u0002\b\u000e\u001aJ\u0010\u000f\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u00102\u0006\u0010\u0011\u001a\u00020\n2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\r2\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00010\rH\u0082\b¢\u0006\u0002\b\u0014¨\u0006\u0015"}, d2 = {"trimMargin", "", "marginPrefix", "replaceIndentByMargin", "newIndent", "trimIndent", "replaceIndent", "prependIndent", "indent", "indentWidth", "", "indentWidth$StringsKt__IndentKt", "getIndentFunction", "Lkotlin/Function1;", "getIndentFunction$StringsKt__IndentKt", "reindent", "", "resultSizeEstimate", "indentAddFunction", "indentCutFunction", "reindent$StringsKt__IndentKt", "kotlin-stdlib"}, k = 5, mv = {2, 2, 0}, xi = 49, xs = "kotlin/text/StringsKt")
public class StringsKt__IndentKt extends kotlin.text.StringsKt__AppendableKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.String getIndentFunction$lambda$8$StringsKt__IndentKt(java.lang.String line) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(line, "line");
        return line;
    }

    public static /* synthetic */ java.lang.String trimMargin$default(java.lang.String str, java.lang.String str2, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            str2 = "|";
        }
        return kotlin.text.StringsKt.trimMargin(str, str2);
    }

    public static final java.lang.String trimMargin(java.lang.String str, java.lang.String marginPrefix) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(marginPrefix, "marginPrefix");
        return kotlin.text.StringsKt.replaceIndentByMargin(str, "", marginPrefix);
    }

    public static /* synthetic */ java.lang.String replaceIndentByMargin$default(java.lang.String str, java.lang.String str2, java.lang.String str3, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            str2 = "";
        }
        if ((i & 2) != 0) {
            str3 = "|";
        }
        return kotlin.text.StringsKt.replaceIndentByMargin(str, str2, str3);
    }

    public static final java.lang.String replaceIndentByMargin(java.lang.String str, java.lang.String newIndent, java.lang.String marginPrefix) {
        java.lang.String str2;
        java.lang.String strInvoke;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(newIndent, "newIndent");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(marginPrefix, "marginPrefix");
        if (kotlin.text.StringsKt.isBlank(marginPrefix)) {
            throw new java.lang.IllegalArgumentException("marginPrefix must be non-blank string.".toString());
        }
        java.util.List<java.lang.String> listLines = kotlin.text.StringsKt.lines(str);
        int length = str.length() + (newIndent.length() * listLines.size());
        kotlin.jvm.functions.Function1<java.lang.String, java.lang.String> indentFunction$StringsKt__IndentKt = getIndentFunction$StringsKt__IndentKt(newIndent);
        int lastIndex = kotlin.collections.CollectionsKt.getLastIndex(listLines);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int i = 0;
        for (java.lang.Object obj : listLines) {
            int i2 = i + 1;
            if (i < 0) {
                kotlin.collections.CollectionsKt.throwIndexOverflow();
            }
            java.lang.String str3 = (java.lang.String) obj;
            java.lang.String strSubstring = null;
            if ((i == 0 || i == lastIndex) && kotlin.text.StringsKt.isBlank(str3)) {
                str2 = marginPrefix;
                str3 = null;
            } else {
                java.lang.String str4 = str3;
                int length2 = str4.length();
                int i3 = 0;
                while (true) {
                    if (i3 >= length2) {
                        i3 = -1;
                        break;
                    }
                    if (!kotlin.text.CharsKt.isWhitespace(str4.charAt(i3))) {
                        break;
                    }
                    i3++;
                }
                if (i3 == -1) {
                    str2 = marginPrefix;
                } else {
                    str2 = marginPrefix;
                    if (kotlin.text.StringsKt.startsWith$default(str3, str2, i3, false, 4, (java.lang.Object) null)) {
                        int length3 = i3 + str2.length();
                        kotlin.jvm.internal.Intrinsics.checkNotNull(str3, "null cannot be cast to non-null type java.lang.String");
                        strSubstring = str3.substring(length3);
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                    }
                }
                if (strSubstring != null && (strInvoke = indentFunction$StringsKt__IndentKt.invoke(strSubstring)) != null) {
                    str3 = strInvoke;
                }
            }
            if (str3 != null) {
                arrayList.add(str3);
            }
            i = i2;
            marginPrefix = str2;
        }
        return ((java.lang.StringBuilder) kotlin.collections.CollectionsKt.joinTo(arrayList, new java.lang.StringBuilder(length), (112 & 2) != 0 ? ", " : "\n", (112 & 4) != 0 ? "" : null, (112 & 8) != 0 ? "" : null, (112 & 16) != 0 ? -1 : 0, (112 & 32) != 0 ? "..." : null, (112 & 64) != 0 ? null : null)).toString();
    }

    public static final java.lang.String trimIndent(java.lang.String str) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        return kotlin.text.StringsKt.replaceIndent(str, "");
    }

    public static /* synthetic */ java.lang.String replaceIndent$default(java.lang.String str, java.lang.String str2, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            str2 = "";
        }
        return kotlin.text.StringsKt.replaceIndent(str, str2);
    }

    public static final java.lang.String replaceIndent(java.lang.String str, java.lang.String newIndent) {
        java.lang.String strInvoke;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(newIndent, "newIndent");
        java.util.List<java.lang.String> listLines = kotlin.text.StringsKt.lines(str);
        java.util.List<java.lang.String> list = listLines;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.Object obj : list) {
            if (!kotlin.text.StringsKt.isBlank((java.lang.String) obj)) {
                arrayList.add(obj);
            }
        }
        java.util.ArrayList arrayList2 = arrayList;
        java.util.ArrayList arrayList3 = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        java.util.Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(java.lang.Integer.valueOf(indentWidth$StringsKt__IndentKt((java.lang.String) it.next())));
        }
        java.lang.Integer num = (java.lang.Integer) kotlin.collections.CollectionsKt.minOrNull((java.lang.Iterable) arrayList3);
        int i = 0;
        int iIntValue = num != null ? num.intValue() : 0;
        int length = str.length() + (newIndent.length() * listLines.size());
        kotlin.jvm.functions.Function1<java.lang.String, java.lang.String> indentFunction$StringsKt__IndentKt = getIndentFunction$StringsKt__IndentKt(newIndent);
        int lastIndex = kotlin.collections.CollectionsKt.getLastIndex(listLines);
        java.util.ArrayList arrayList4 = new java.util.ArrayList();
        for (java.lang.Object obj2 : list) {
            int i2 = i + 1;
            if (i < 0) {
                kotlin.collections.CollectionsKt.throwIndexOverflow();
            }
            java.lang.String str2 = (java.lang.String) obj2;
            if ((i == 0 || i == lastIndex) && kotlin.text.StringsKt.isBlank(str2)) {
                str2 = null;
            } else {
                java.lang.String strDrop = kotlin.text.StringsKt.drop(str2, iIntValue);
                if (strDrop != null && (strInvoke = indentFunction$StringsKt__IndentKt.invoke(strDrop)) != null) {
                    str2 = strInvoke;
                }
            }
            if (str2 != null) {
                arrayList4.add(str2);
            }
            i = i2;
        }
        return ((java.lang.StringBuilder) kotlin.collections.CollectionsKt.joinTo(arrayList4, new java.lang.StringBuilder(length), (112 & 2) != 0 ? ", " : "\n", (112 & 4) != 0 ? "" : null, (112 & 8) != 0 ? "" : null, (112 & 16) != 0 ? -1 : 0, (112 & 32) != 0 ? "..." : null, (112 & 64) != 0 ? null : null)).toString();
    }

    public static /* synthetic */ java.lang.String prependIndent$default(java.lang.String str, java.lang.String str2, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            str2 = "    ";
        }
        return kotlin.text.StringsKt.prependIndent(str, str2);
    }

    public static final java.lang.String prependIndent(java.lang.String str, final java.lang.String indent) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(indent, "indent");
        return kotlin.sequences.SequencesKt.joinToString$default(kotlin.sequences.SequencesKt.map(kotlin.text.StringsKt.lineSequence(str), new kotlin.jvm.functions.Function1() { // from class: kotlin.text.StringsKt__IndentKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final java.lang.Object invoke(java.lang.Object obj) {
                return kotlin.text.StringsKt__IndentKt.prependIndent$lambda$5$StringsKt__IndentKt(indent, (java.lang.String) obj);
            }
        }), "\n", null, null, 0, null, null, 62, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.String prependIndent$lambda$5$StringsKt__IndentKt(java.lang.String str, java.lang.String it) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(it, "it");
        if (kotlin.text.StringsKt.isBlank(it)) {
            return it.length() < str.length() ? str : it;
        }
        return str + it;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x001c  */
    /* JADX WARN: Code duplicated, block: B:13:0x0021 A[RETURN] */
    private static final int indentWidth$StringsKt__IndentKt(java.lang.String str) {
        java.lang.String str2 = str;
        int length = str2.length();
        int i = 0;
        while (i < length) {
            if (!kotlin.text.CharsKt.isWhitespace(str2.charAt(i))) {
                if (i == -1) {
                    return str.length();
                }
                return i;
            }
            i++;
        }
        i = -1;
        if (i == -1) {
            return str.length();
        }
        return i;
    }

    private static final kotlin.jvm.functions.Function1<java.lang.String, java.lang.String> getIndentFunction$StringsKt__IndentKt(final java.lang.String str) {
        return str.length() == 0 ? new kotlin.jvm.functions.Function1() { // from class: kotlin.text.StringsKt__IndentKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final java.lang.Object invoke(java.lang.Object obj) {
                return kotlin.text.StringsKt__IndentKt.getIndentFunction$lambda$8$StringsKt__IndentKt((java.lang.String) obj);
            }
        } : new kotlin.jvm.functions.Function1() { // from class: kotlin.text.StringsKt__IndentKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final java.lang.Object invoke(java.lang.Object obj) {
                return kotlin.text.StringsKt__IndentKt.getIndentFunction$lambda$9$StringsKt__IndentKt(str, (java.lang.String) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.String getIndentFunction$lambda$9$StringsKt__IndentKt(java.lang.String str, java.lang.String line) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(line, "line");
        return str + line;
    }

    private static final java.lang.String reindent$StringsKt__IndentKt(java.util.List<java.lang.String> list, int i, kotlin.jvm.functions.Function1<? super java.lang.String, java.lang.String> function1, kotlin.jvm.functions.Function1<? super java.lang.String, java.lang.String> function2) {
        java.lang.String strInvoke;
        int lastIndex = kotlin.collections.CollectionsKt.getLastIndex(list);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int i2 = 0;
        for (java.lang.Object obj : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                kotlin.collections.CollectionsKt.throwIndexOverflow();
            }
            java.lang.String str = (java.lang.String) obj;
            if ((i2 == 0 || i2 == lastIndex) && kotlin.text.StringsKt.isBlank(str)) {
                str = null;
            } else {
                java.lang.String strInvoke2 = function2.invoke(str);
                if (strInvoke2 != null && (strInvoke = function1.invoke(strInvoke2)) != null) {
                    str = strInvoke;
                }
            }
            if (str != null) {
                arrayList.add(str);
            }
            i2 = i3;
        }
        return ((java.lang.StringBuilder) kotlin.collections.CollectionsKt.joinTo(arrayList, new java.lang.StringBuilder(i), (112 & 2) != 0 ? ", " : "\n", (112 & 4) != 0 ? "" : null, (112 & 8) != 0 ? "" : null, (112 & 16) != 0 ? -1 : 0, (112 & 32) != 0 ? "..." : null, (112 & 64) != 0 ? null : null)).toString();
    }
}
