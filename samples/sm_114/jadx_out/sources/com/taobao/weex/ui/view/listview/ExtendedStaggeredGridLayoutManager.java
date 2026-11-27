package com.taobao.weex.ui.view.listview;

/* JADX INFO: loaded from: classes.dex */
public class ExtendedStaggeredGridLayoutManager extends androidx.recyclerview.widget.StaggeredGridLayoutManager {
    public ExtendedStaggeredGridLayoutManager(int i, int i2) {
        super(i, i2);
    }

    @Override // androidx.recyclerview.widget.StaggeredGridLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(androidx.recyclerview.widget.RecyclerView recyclerView, int i, int i2) {
        if (i == -1) {
            com.taobao.weex.utils.WXLogUtils.e("ExtendedStaggeredGridLayoutManager: onItemsRemoved  Error Invalid Index : positionStart :" + i + "  itemCount:" + i2);
            return;
        }
        if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
            com.taobao.weex.utils.WXLogUtils.e("ExtendedStaggeredGridLayoutManager: onItemsRemoved  positionStart :" + i + "  itemCount:" + i2);
        }
        super.onItemsRemoved(recyclerView, i, i2);
    }
}
