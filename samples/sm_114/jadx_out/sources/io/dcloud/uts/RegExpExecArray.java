package io.dcloud.uts;

/* JADX INFO: compiled from: UTSRegExp2.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001BY\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0007\u0012\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\t\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u001dJ\b\u0010\u001e\u001a\u00020\u0002H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0007¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R!\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R!\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\t8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0016¨\u0006\u001f"}, d2 = {"Lio/dcloud/uts/RegExpExecArray;", "Lio/dcloud/uts/UTSArray;", "", "index", "", "input", "groupArray", "", "namedGroups", "", "indices", "", "<init>", "(ILjava/lang/String;[Ljava/lang/String;Ljava/util/Map;[[I)V", "getIndex", "()I", "getInput", "()Ljava/lang/String;", "getGroupArray", "()[Ljava/lang/String;", "[Ljava/lang/String;", "getNamedGroups", "()Ljava/util/Map;", "getIndices", "()[[I", "[[I", "groups", "getGroups", "getData", "", "toString", "utsplugin_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RegExpExecArray extends io.dcloud.uts.UTSArray<java.lang.String> {
    private final java.lang.String[] groupArray;
    private final int index;
    private final int[][] indices;
    private final java.lang.String input;
    private final java.util.Map<java.lang.String, java.lang.String> namedGroups;

    public RegExpExecArray() {
        this(0, null, null, null, null, 31, null);
    }

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

    public /* synthetic */ RegExpExecArray(int i, java.lang.String str, java.lang.String[] strArr, java.util.Map map, int[][] iArr, int i2, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? new java.lang.String[0] : strArr, (i2 & 8) != 0 ? null : map, (i2 & 16) != 0 ? null : iArr);
    }

    public final java.lang.String getInput() {
        return this.input;
    }

    public final java.lang.String[] getGroupArray() {
        return this.groupArray;
    }

    public final java.util.Map<java.lang.String, java.lang.String> getNamedGroups() {
        return this.namedGroups;
    }

    public final int[][] getIndices() {
        return this.indices;
    }

    public RegExpExecArray(int i, java.lang.String input, java.lang.String[] groupArray, java.util.Map<java.lang.String, java.lang.String> map, int[][] iArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(input, "input");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(groupArray, "groupArray");
        this.index = i;
        this.input = input;
        this.groupArray = groupArray;
        this.namedGroups = map;
        this.indices = iArr;
        kotlin.collections.CollectionsKt.addAll(this, groupArray);
    }

    public final java.util.Map<java.lang.String, java.lang.String> getGroups() {
        return this.namedGroups;
    }

    public final java.util.List<java.lang.String> getData() {
        return toKotlinList();
    }

    @Override // io.dcloud.uts.UTSArray, java.util.AbstractCollection
    public java.lang.String toString() {
        return "Array " + io.dcloud.uts.JSON.stringify(toKotlinList());
    }
}
