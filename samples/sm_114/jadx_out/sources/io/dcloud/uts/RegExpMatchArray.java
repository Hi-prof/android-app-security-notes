package io.dcloud.uts;

/* JADX INFO: compiled from: String.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u001b\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007B\t\b\u0016¢\u0006\u0004\b\u0006\u0010\bJ\u000e\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0015J\b\u0010\u0016\u001a\u00020\u0002H\u0016R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0002X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lio/dcloud/uts/RegExpMatchArray;", "Lio/dcloud/uts/UTSArray;", "", "matchResult", "Lkotlin/text/MatchResult;", "str", "<init>", "(Lkotlin/text/MatchResult;Ljava/lang/String;)V", "()V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "input", "getInput", "()Ljava/lang/String;", "setInput", "(Ljava/lang/String;)V", "getData", "", "toString", "utsplugin_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RegExpMatchArray extends io.dcloud.uts.UTSArray<java.lang.String> {
    private int index;
    private java.lang.String input;

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(java.lang.Object obj) {
        if (obj == null ? true : obj instanceof java.lang.String) {
            return contains((java.lang.String) obj);
        }
        return false;
    }

    public /* bridge */ boolean contains(java.lang.String str) {
        return super.contains((java.lang.Object) str);
    }

    @Override // io.dcloud.uts.UTSArray, java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int indexOf(java.lang.Object obj) {
        if (obj == null ? true : obj instanceof java.lang.String) {
            return indexOf((java.lang.String) obj);
        }
        return -1;
    }

    public /* bridge */ int indexOf(java.lang.String str) {
        return super.indexOf((java.lang.Object) str);
    }

    @Override // io.dcloud.uts.UTSArray, java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(java.lang.Object obj) {
        if (obj == null ? true : obj instanceof java.lang.String) {
            return lastIndexOf((java.lang.String) obj);
        }
        return -1;
    }

    public /* bridge */ int lastIndexOf(java.lang.String str) {
        return super.lastIndexOf((java.lang.Object) str);
    }

    @Override // io.dcloud.uts.UTSArray, java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ java.lang.String remove(int i) {
        return removeAt(i);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean remove(java.lang.Object obj) {
        if (obj == null ? true : obj instanceof java.lang.String) {
            return remove((java.lang.String) obj);
        }
        return false;
    }

    public /* bridge */ boolean remove(java.lang.String str) {
        return super.remove((java.lang.Object) str);
    }

    @Override // io.dcloud.uts.UTSArray
    public /* bridge */ java.lang.String removeAt(int i) {
        return (java.lang.String) super.remove(i);
    }

    public final int getIndex() {
        return this.index;
    }

    public final void setIndex(int i) {
        this.index = i;
    }

    public final java.lang.String getInput() {
        return this.input;
    }

    public final void setInput(java.lang.String str) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.input = str;
    }

    public final java.util.List<java.lang.String> getData() {
        return toKotlinList();
    }

    @Override // io.dcloud.uts.UTSArray, java.util.AbstractCollection
    public java.lang.String toString() {
        java.lang.String strStringify = io.dcloud.uts.JSON.stringify(this);
        return strStringify == null ? "" : strStringify;
    }

    public RegExpMatchArray(kotlin.text.MatchResult matchResult, java.lang.String str) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "str");
        this.input = str;
        if (matchResult == null || matchResult.getGroups().isEmpty()) {
            return;
        }
        kotlin.text.MatchGroup matchGroup = matchResult.getGroups().get(0);
        kotlin.jvm.internal.Intrinsics.checkNotNull(matchGroup);
        this.index = matchGroup.getRange().getFirst();
        kotlin.text.MatchGroupCollection groups = matchResult.getGroups();
        if (groups != null) {
            for (kotlin.text.MatchGroup matchGroup2 : groups) {
                if (matchGroup2 != null) {
                    add(matchGroup2.getValue());
                }
            }
        }
    }

    public RegExpMatchArray() {
        this.input = "";
    }
}
