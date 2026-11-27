package com.taobao.weex.ui.component.list;

/* JADX INFO: loaded from: classes.dex */
public class StickyHeaderHelper {
    private final android.view.ViewGroup mParent;
    private java.util.Map<java.lang.String, android.view.View> mHeaderViews = new java.util.HashMap();
    private java.util.Map<java.lang.String, com.taobao.weex.ui.component.list.WXCell> mHeaderComps = new java.util.HashMap();
    private java.lang.String mCurrentStickyRef = null;

    public StickyHeaderHelper(android.view.ViewGroup viewGroup) {
        this.mParent = viewGroup;
    }

    public void notifyStickyShow(com.taobao.weex.ui.component.list.WXCell wXCell) {
        com.taobao.weex.ui.component.list.WXCell wXCell2;
        if (wXCell == null) {
            return;
        }
        this.mHeaderComps.put(wXCell.getRef(), wXCell);
        java.lang.String str = this.mCurrentStickyRef;
        if (str == null || (wXCell2 = this.mHeaderComps.get(str)) == null || wXCell.getScrollPositon() > wXCell2.getScrollPositon()) {
            this.mCurrentStickyRef = wXCell.getRef();
        }
        java.lang.String str2 = this.mCurrentStickyRef;
        if (str2 == null) {
            com.taobao.weex.utils.WXLogUtils.e("Current Sticky ref is null.");
            return;
        }
        com.taobao.weex.ui.component.list.WXCell wXCell3 = this.mHeaderComps.get(str2);
        android.view.ViewGroup realView = wXCell3.getRealView();
        if (realView == null) {
            com.taobao.weex.utils.WXLogUtils.e("Sticky header's real view is null.");
            return;
        }
        android.view.View view = this.mHeaderViews.get(wXCell3.getRef());
        if (view != null) {
            view.bringToFront();
        } else {
            this.mHeaderViews.put(wXCell3.getRef(), realView);
            float translationX = realView.getTranslationX();
            float translationY = realView.getTranslationY();
            wXCell3.removeSticky();
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) realView.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(realView);
            }
            realView.setTag(wXCell3.getRef());
            this.mParent.addView(realView, new android.view.ViewGroup.MarginLayoutParams(-2, -2));
            realView.setTag(this);
            if (wXCell3.getStickyOffset() > 0) {
                android.view.ViewGroup.MarginLayoutParams marginLayoutParams = (android.view.ViewGroup.MarginLayoutParams) realView.getLayoutParams();
                if (wXCell3.getStickyOffset() != marginLayoutParams.topMargin) {
                    marginLayoutParams.topMargin = wXCell3.getStickyOffset();
                }
            }
            realView.setTranslationX(translationX);
            realView.setTranslationY(translationY);
        }
        changeFrontStickyVisible();
        if (wXCell3.getEvents().contains("sticky")) {
            wXCell3.fireEvent("sticky");
        }
    }

    public void notifyStickyRemove(com.taobao.weex.ui.component.list.WXCell wXCell) {
        if (wXCell == null) {
            return;
        }
        final com.taobao.weex.ui.component.list.WXCell wXCellRemove = this.mHeaderComps.containsValue(wXCell) ? this.mHeaderComps.remove(wXCell.getRef()) : wXCell;
        final android.view.View viewRemove = this.mHeaderViews.remove(wXCell.getRef());
        if (wXCellRemove == null || viewRemove == null) {
            com.taobao.weex.WXEnvironment.isApkDebugable();
            return;
        }
        java.lang.String str = this.mCurrentStickyRef;
        if (str != null && str.equals(wXCell.getRef())) {
            this.mCurrentStickyRef = null;
        }
        this.mParent.post(com.taobao.weex.common.WXThread.secure(new java.lang.Runnable() { // from class: com.taobao.weex.ui.component.list.StickyHeaderHelper.1
            @Override // java.lang.Runnable
            public void run() {
                com.taobao.weex.ui.component.list.StickyHeaderHelper.this.mParent.removeView(viewRemove);
                if (viewRemove.getVisibility() != 0) {
                    viewRemove.setVisibility(0);
                }
                wXCellRemove.recoverySticky();
                com.taobao.weex.ui.component.list.StickyHeaderHelper.this.changeFrontStickyVisible();
            }
        }));
        if (wXCellRemove.getEvents().contains(com.taobao.weex.common.Constants.Event.UNSTICKY)) {
            wXCellRemove.fireEvent(com.taobao.weex.common.Constants.Event.UNSTICKY);
        }
    }

    public void updateStickyView(int i) {
        java.util.Iterator<java.util.Map.Entry<java.lang.String, com.taobao.weex.ui.component.list.WXCell>> it = this.mHeaderComps.entrySet().iterator();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        while (it.hasNext()) {
            com.taobao.weex.ui.component.list.WXCell value = it.next().getValue();
            int scrollPositon = value.getScrollPositon();
            if (scrollPositon > i) {
                arrayList.add(value);
            } else if (scrollPositon == i) {
                this.mCurrentStickyRef = value.getRef();
                android.view.View view = this.mHeaderViews.get(value.getRef());
                if (view != null) {
                    view.bringToFront();
                    changeFrontStickyVisible();
                }
            }
        }
        java.util.Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            notifyStickyRemove((com.taobao.weex.ui.component.list.WXCell) it2.next());
        }
    }

    public void clearStickyHeaders() {
        if (this.mHeaderViews.size() <= 0) {
            return;
        }
        java.util.Iterator<java.util.Map.Entry<java.lang.String, com.taobao.weex.ui.component.list.WXCell>> it = this.mHeaderComps.entrySet().iterator();
        while (it.hasNext()) {
            com.taobao.weex.ui.component.list.WXCell value = it.next().getValue();
            it.remove();
            notifyStickyRemove(value);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeFrontStickyVisible() {
        if (this.mHeaderViews.size() <= 0) {
            return;
        }
        boolean z = false;
        for (int childCount = this.mParent.getChildCount() - 1; childCount >= 0; childCount--) {
            android.view.View childAt = this.mParent.getChildAt(childCount);
            if (z && (childAt.getTag() instanceof com.taobao.weex.ui.component.list.StickyHeaderHelper)) {
                if (childAt.getVisibility() != 8) {
                    childAt.setVisibility(8);
                }
            } else if (childAt.getTag() instanceof com.taobao.weex.ui.component.list.StickyHeaderHelper) {
                if (childAt != null && childAt.getVisibility() != 0) {
                    childAt.setVisibility(0);
                }
                z = true;
            }
        }
    }
}
