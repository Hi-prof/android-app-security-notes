package com.taobao.weex.ui.flat;

/* JADX INFO: loaded from: classes.dex */
public interface FlatComponent<T extends com.taobao.weex.ui.flat.widget.Widget> {
    T getOrCreateFlatWidget();

    boolean promoteToView(boolean z);
}
