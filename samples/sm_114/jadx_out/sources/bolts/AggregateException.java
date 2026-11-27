package bolts;

/* JADX INFO: loaded from: classes.dex */
public class AggregateException extends java.lang.Exception {
    private static final java.lang.String DEFAULT_MESSAGE = "There were multiple errors.";
    private static final long serialVersionUID = 1;
    private java.util.List<java.lang.Throwable> innerThrowables;

    public AggregateException(java.lang.String str, java.lang.Throwable[] thArr) {
        this(str, (java.util.List<? extends java.lang.Throwable>) java.util.Arrays.asList(thArr));
    }

    public AggregateException(java.lang.String str, java.util.List<? extends java.lang.Throwable> list) {
        super(str, (list == null || list.size() <= 0) ? null : list.get(0));
        this.innerThrowables = java.util.Collections.unmodifiableList(list);
    }

    public AggregateException(java.util.List<? extends java.lang.Throwable> list) {
        this(DEFAULT_MESSAGE, list);
    }

    public java.util.List<java.lang.Throwable> getInnerThrowables() {
        return this.innerThrowables;
    }

    @Override // java.lang.Throwable
    public void printStackTrace(java.io.PrintStream printStream) {
        super.printStackTrace(printStream);
        int i = -1;
        for (java.lang.Throwable th : this.innerThrowables) {
            printStream.append("\n");
            printStream.append("  Inner throwable #");
            i++;
            printStream.append((java.lang.CharSequence) java.lang.Integer.toString(i));
            printStream.append(": ");
            th.printStackTrace(printStream);
            printStream.append("\n");
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace(java.io.PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        int i = -1;
        for (java.lang.Throwable th : this.innerThrowables) {
            printWriter.append("\n");
            printWriter.append("  Inner throwable #");
            i++;
            printWriter.append((java.lang.CharSequence) java.lang.Integer.toString(i));
            printWriter.append(": ");
            th.printStackTrace(printWriter);
            printWriter.append("\n");
        }
    }

    @java.lang.Deprecated
    public java.util.List<java.lang.Exception> getErrors() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.List<java.lang.Throwable> list = this.innerThrowables;
        if (list != null) {
            for (java.lang.Throwable th : list) {
                if (th instanceof java.lang.Exception) {
                    arrayList.add((java.lang.Exception) th);
                } else {
                    arrayList.add(new java.lang.Exception(th));
                }
            }
        }
        return arrayList;
    }

    @java.lang.Deprecated
    public java.lang.Throwable[] getCauses() {
        java.util.List<java.lang.Throwable> list = this.innerThrowables;
        return (java.lang.Throwable[]) list.toArray(new java.lang.Throwable[list.size()]);
    }
}
