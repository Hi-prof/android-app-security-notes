package androidx.core.widget;

/* JADX INFO: loaded from: classes.dex */
public final class PopupMenuCompat {
    private PopupMenuCompat() {
    }

    public static android.view.View.OnTouchListener getDragToOpenListener(java.lang.Object obj) {
        return ((android.widget.PopupMenu) obj).getDragToOpenListener();
    }
}
