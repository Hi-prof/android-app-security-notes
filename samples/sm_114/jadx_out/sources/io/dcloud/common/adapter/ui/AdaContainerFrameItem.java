package io.dcloud.common.adapter.ui;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public abstract class AdaContainerFrameItem extends io.dcloud.common.adapter.ui.AdaFrameItem implements io.dcloud.common.DHInterface.IContainerView {
    private boolean isITypeofAble;
    public java.util.ArrayList<io.dcloud.common.adapter.ui.AdaFrameItem> mChildArrayList;
    public java.util.ArrayList<io.dcloud.common.DHInterface.INativeView> mChildNativeViewList;

    protected AdaContainerFrameItem(android.content.Context context) {
        super(context);
        this.isITypeofAble = false;
        this.mChildArrayList = null;
        this.mChildNativeViewList = null;
        this.mChildArrayList = new java.util.ArrayList<>(1);
    }

    @Override // io.dcloud.common.DHInterface.IContainerView
    public void addFrameItem(io.dcloud.common.adapter.ui.AdaFrameItem adaFrameItem, android.view.ViewGroup.LayoutParams layoutParams) {
        addFrameItem(adaFrameItem, -1, layoutParams);
    }

    public void addNativeViewChild(io.dcloud.common.DHInterface.INativeView iNativeView) {
        if (this.mChildNativeViewList == null) {
            this.mChildNativeViewList = new java.util.ArrayList<>();
        }
        if (iNativeView == null || this.mChildNativeViewList.contains(iNativeView)) {
            return;
        }
        this.mChildNativeViewList.add(iNativeView);
    }

    public boolean checkITypeofAble() {
        boolean z = this.isITypeofAble;
        if (z) {
            return z;
        }
        java.util.ArrayList<io.dcloud.common.adapter.ui.AdaFrameItem> arrayList = this.mChildArrayList;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            io.dcloud.common.adapter.ui.AdaFrameItem adaFrameItem = arrayList.get(i);
            i++;
            io.dcloud.common.adapter.ui.AdaFrameItem adaFrameItem2 = adaFrameItem;
            if (adaFrameItem2 instanceof io.dcloud.common.adapter.ui.AdaContainerFrameItem) {
                return ((io.dcloud.common.adapter.ui.AdaContainerFrameItem) adaFrameItem2).checkITypeofAble();
            }
        }
        return false;
    }

    public void clearView() {
        java.util.ArrayList<io.dcloud.common.adapter.ui.AdaFrameItem> arrayList = this.mChildArrayList;
        if (arrayList != null) {
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                io.dcloud.common.adapter.ui.AdaFrameItem adaFrameItem = arrayList.get(i);
                i++;
                adaFrameItem.dispose();
            }
            this.mChildArrayList.clear();
        }
        android.view.View view = this.mViewImpl;
        if ((view instanceof android.view.ViewGroup) && view != null) {
            ((android.view.ViewGroup) view).removeAllViews();
        }
        this.isITypeofAble = false;
    }

    @Override // io.dcloud.common.adapter.ui.AdaFrameItem
    public void dispose() {
        clearView();
        super.dispose();
    }

    public java.util.ArrayList<io.dcloud.common.adapter.ui.AdaFrameItem> getChilds() {
        return this.mChildArrayList;
    }

    public android.view.ViewGroup obtainMainViewGroup() {
        return (android.view.ViewGroup) this.mViewImpl;
    }

    @Override // io.dcloud.common.adapter.ui.AdaFrameItem
    public boolean onDispose() {
        boolean zOnDispose = super.onDispose();
        java.util.ArrayList<io.dcloud.common.adapter.ui.AdaFrameItem> arrayList = this.mChildArrayList;
        if (arrayList != null) {
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                io.dcloud.common.adapter.ui.AdaFrameItem adaFrameItem = arrayList.get(i);
                i++;
                zOnDispose |= adaFrameItem.onDispose();
            }
        }
        return zOnDispose;
    }

    @Override // io.dcloud.common.adapter.ui.AdaFrameItem
    public void onPopFromStack(boolean z) {
        super.onPopFromStack(z);
        java.util.ArrayList<io.dcloud.common.adapter.ui.AdaFrameItem> arrayList = this.mChildArrayList;
        if (arrayList != null) {
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                io.dcloud.common.adapter.ui.AdaFrameItem adaFrameItem = arrayList.get(i);
                i++;
                adaFrameItem.onPopFromStack(z);
            }
        }
    }

    @Override // io.dcloud.common.adapter.ui.AdaFrameItem
    public void onPushToStack(boolean z) {
        super.onPushToStack(z);
        java.util.ArrayList<io.dcloud.common.adapter.ui.AdaFrameItem> arrayList = this.mChildArrayList;
        if (arrayList != null) {
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                io.dcloud.common.adapter.ui.AdaFrameItem adaFrameItem = arrayList.get(i);
                i++;
                adaFrameItem.onPushToStack(z);
            }
        }
    }

    @Override // io.dcloud.common.adapter.ui.AdaFrameItem
    protected void onResize() {
        super.onResize();
        java.util.ArrayList<io.dcloud.common.adapter.ui.AdaFrameItem> arrayList = this.mChildArrayList;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            io.dcloud.common.adapter.ui.AdaFrameItem adaFrameItem = arrayList.get(i);
            i++;
            adaFrameItem.onResize();
        }
    }

    @Override // io.dcloud.common.DHInterface.IContainerView
    public void removeAllFrameItem() {
        if (this.mViewImpl != null) {
            clearView();
            ((android.view.ViewGroup) this.mViewImpl).removeAllViews();
        }
        this.isITypeofAble = false;
    }

    @Override // io.dcloud.common.DHInterface.IContainerView
    public void removeFrameItem(io.dcloud.common.adapter.ui.AdaFrameItem adaFrameItem) {
        if (adaFrameItem instanceof io.dcloud.common.DHInterface.ITypeofAble) {
            this.isITypeofAble = false;
        }
        android.view.View view = this.mViewImpl;
        if (view != null) {
            ((android.view.ViewGroup) view).removeView(adaFrameItem.obtainMainView());
            this.mChildArrayList.remove(adaFrameItem);
        }
    }

    public void removeNativeViewChild(io.dcloud.common.DHInterface.INativeView iNativeView) {
        java.util.ArrayList<io.dcloud.common.DHInterface.INativeView> arrayList = this.mChildNativeViewList;
        if (arrayList == null || !arrayList.contains(iNativeView)) {
            return;
        }
        this.mChildNativeViewList.remove(iNativeView);
    }

    public void sortNativeViewBringToFront() {
        java.util.ArrayList<io.dcloud.common.DHInterface.INativeView> arrayList = this.mChildNativeViewList;
        if (arrayList != null) {
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                io.dcloud.common.DHInterface.INativeView iNativeView = arrayList.get(i);
                i++;
                io.dcloud.common.DHInterface.INativeView iNativeView2 = iNativeView;
                if (iNativeView2.obtanMainView() != null && iNativeView2.obtanMainView().getParent() != null) {
                    iNativeView2.obtanMainView().bringToFront();
                }
            }
        }
    }

    @Override // io.dcloud.common.DHInterface.IContainerView
    public void addFrameItem(io.dcloud.common.adapter.ui.AdaFrameItem adaFrameItem) {
        addFrameItem(adaFrameItem, -1);
    }

    public void addFrameItem(io.dcloud.common.adapter.ui.AdaFrameItem adaFrameItem, int i, android.view.ViewGroup.LayoutParams layoutParams) {
        if (adaFrameItem instanceof io.dcloud.common.DHInterface.ITypeofAble) {
            this.isITypeofAble = true;
        }
        if (this.mViewImpl instanceof android.view.ViewGroup) {
            android.view.View viewObtainMainView = adaFrameItem.obtainMainView();
            android.view.ViewParent parent = viewObtainMainView.getParent();
            if (parent != null) {
                ((android.view.ViewGroup) parent).removeView(viewObtainMainView);
                this.mChildArrayList.remove(adaFrameItem);
            }
            if (((android.view.ViewGroup) this.mViewImpl).getChildCount() < i) {
                i = ((android.view.ViewGroup) this.mViewImpl).getChildCount();
            }
            ((android.view.ViewGroup) this.mViewImpl).addView(viewObtainMainView, i, layoutParams);
            if (i < 0 || i > this.mChildArrayList.size()) {
                i = this.mChildArrayList.size();
            }
            this.mChildArrayList.add(i, adaFrameItem);
        }
    }

    public void removeAllFrameItem(boolean z) {
        if (z) {
            android.view.View view = this.mViewImpl;
            if (view instanceof android.view.ViewGroup) {
                android.view.ViewGroup viewGroup = (android.view.ViewGroup) view;
                int i = 0;
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    android.view.View childAt = viewGroup.getChildAt(i2);
                    if (!(childAt instanceof io.dcloud.common.DHInterface.INativeView)) {
                        viewGroup.removeView(childAt);
                    }
                }
                java.util.ArrayList<io.dcloud.common.adapter.ui.AdaFrameItem> arrayList = this.mChildArrayList;
                if (arrayList != null) {
                    int size = arrayList.size();
                    while (i < size) {
                        io.dcloud.common.adapter.ui.AdaFrameItem adaFrameItem = arrayList.get(i);
                        i++;
                        adaFrameItem.dispose();
                    }
                    this.mChildArrayList.clear();
                    return;
                }
                return;
            }
            return;
        }
        removeAllFrameItem();
    }

    public void addFrameItem(io.dcloud.common.adapter.ui.AdaFrameItem adaFrameItem, int i) {
        android.view.ViewGroup.LayoutParams layoutParams = adaFrameItem.obtainMainView().getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new android.view.ViewGroup.LayoutParams(-1, -1);
        }
        addFrameItem(adaFrameItem, i, layoutParams);
    }
}
