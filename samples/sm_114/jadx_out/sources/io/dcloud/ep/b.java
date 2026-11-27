package io.dcloud.ep;

/* JADX INFO: compiled from: r8-map-id-b089b3ef14a7698b6fddd362455d593b6c2b269fff47748e8001e74ff4f7bd31 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class b {
    private static java.lang.String a = "X7YBPqS7I0cDrWg8xDIfY0YVZCGmXWQ5ugQWJrvTAemwpG4BtP7JHZQa8SEE90C9\r/jOaV/jrBnYbCXcLfwIDAQAB\r";
    static char[] b = {'x', 'v', '/', 't', 'E', 'C', 'D', 'b', 'i', 'A', 'D', 'x', 'L', 'w', 'y', 'q', 'b', 'e', '0', 'G', 'b', 'f', 'G', '6', 't', 'c'};
    static char[] c = {'H', 'B', 'y', 'W', 'j', 'U', 'H', 'g', 'm', '3', 'C', 'p', 'Z', 'a', 'c', 'r', 'I', 'x', 'K', 'A', '4', 'J', 'S', 'W', 'k', 'y', 'b', 's', 'y', 'Y', 'c', 'O', 'y', '3', 'D', 'v', '2', 't', 'y', 'N', 'w', 'N', 'A', '6', 'N', 'a', 'D', 'O', 'u', 'P', 'i', 'R', 'K', 'b', 'p', 'N', 'y', 'q', 'A', '0', 'W', 'y', 'l', 'K', 'F', 'e', '9', 'X', 'q', 'm', 'e'};
    private static java.lang.String d;
    private static java.lang.String e;

    /* JADX INFO: compiled from: r8-map-id-b089b3ef14a7698b6fddd362455d593b6c2b269fff47748e8001e74ff4f7bd31 */
    class a implements io.dcloud.ep.K.a {
        a() {
        }

        @Override // io.dcloud.ep.K.a
        public java.lang.String a(java.lang.String str) {
            return str.replace(io.dcloud.ep.b.b() + 'i' + io.dcloud.ep.b.b(), io.dcloud.ep.b.b());
        }
    }

    static java.lang.String a(android.content.Context context, byte b2) {
        if (context == null) {
            return "";
        }
        if (b2 == 2) {
            if (android.text.TextUtils.isEmpty(d)) {
                d = b() + io.dcloud.ep.K.j(new io.dcloud.ep.b.a());
            }
            return d;
        }
        if (android.text.TextUtils.isEmpty(e)) {
            e = io.dcloud.common.adapter.util.PlatformUtil.getFileContent4S("libso.so") + "\r" + a(b, 0) + a(c) + "\r" + a;
        }
        return e;
    }

    static java.lang.String b() {
        return "M";
    }

    static java.lang.String a() {
        return "CBQNDHUQDBUTEhUOFAkNBSo2YTNkODhmYS00YmEwLTQ3OWYtOTQyMi1lNWFhYmUxNTg5N2IxMjg=";
    }

    private static java.lang.String a(char[] cArr) {
        return new java.lang.String(cArr).replaceAll(com.taobao.weex.common.Constants.Name.Y, "");
    }

    private static java.lang.String a(char[] cArr, int i) {
        return new java.lang.String(cArr, 2, cArr.length - 3).replaceAll("b", "");
    }
}
