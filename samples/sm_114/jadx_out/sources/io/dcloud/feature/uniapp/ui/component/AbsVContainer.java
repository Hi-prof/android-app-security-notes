package io.dcloud.feature.uniapp.ui.component;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbsVContainer<T extends android.view.ViewGroup> extends com.taobao.weex.ui.component.WXComponent<T> {
    protected java.util.ArrayList<com.taobao.weex.ui.component.WXComponent> mChildren;

    public void appendTreeCreateFinish() {
    }

    public abstract android.view.View getBoxShadowHost(boolean z);

    protected int getChildrenLayoutTopOffset() {
        return 0;
    }

    public abstract void removeBoxShadowHost();

    @java.lang.Deprecated
    public AbsVContainer(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, java.lang.String str, boolean z, com.taobao.weex.ui.action.BasicComponentData basicComponentData) {
        this(wXSDKInstance, wXVContainer, z, basicComponentData);
    }

    @java.lang.Deprecated
    public AbsVContainer(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, boolean z, com.taobao.weex.ui.action.BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
        this.mChildren = new java.util.ArrayList<>();
    }

    public AbsVContainer(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, com.taobao.weex.ui.action.BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
        this.mChildren = new java.util.ArrayList<>();
    }

    public void interceptFocus() {
        T hostView = getHostView();
        if (hostView != null) {
            hostView.setFocusable(true);
            hostView.setFocusableInTouchMode(true);
            hostView.setDescendantFocusability(131072);
            hostView.requestFocus();
        }
    }

    public void ignoreFocus() {
        T hostView = getHostView();
        if (hostView != null) {
            hostView.setFocusable(false);
            hostView.setFocusableInTouchMode(false);
            hostView.clearFocus();
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    @java.lang.Deprecated
    public android.view.ViewGroup getView() {
        return getHostView();
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void applyLayoutAndEvent(io.dcloud.feature.uniapp.ui.component.AbsBasicComponent absBasicComponent) {
        if (isLazy()) {
            return;
        }
        if (absBasicComponent == null) {
            absBasicComponent = this;
        }
        super.applyLayoutAndEvent(absBasicComponent);
        int iChildCount = childCount();
        for (int i = 0; i < iChildCount; i++) {
            getChild(i).applyLayoutAndEvent(((com.taobao.weex.ui.component.WXVContainer) absBasicComponent).getChild(i));
        }
    }

    public android.view.ViewGroup.LayoutParams getChildLayoutParams(com.taobao.weex.ui.component.WXComponent wXComponent, android.view.View view, int i, int i2, int i3, int i4, int i5, int i6) {
        android.view.ViewGroup.LayoutParams layoutParams = view != null ? view.getLayoutParams() : null;
        if (layoutParams == null) {
            return new android.view.ViewGroup.LayoutParams(i, i2);
        }
        layoutParams.width = i;
        layoutParams.height = i2;
        if (layoutParams instanceof android.view.ViewGroup.MarginLayoutParams) {
            setMarginsSupportRTL((android.view.ViewGroup.MarginLayoutParams) layoutParams, i3, i5, i4, i6);
        }
        return layoutParams;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.taobao.weex.ui.component.WXComponent
    public com.taobao.weex.ui.component.Scrollable getFirstScroller() {
        if (this instanceof com.taobao.weex.ui.component.Scrollable) {
            return (com.taobao.weex.ui.component.Scrollable) this;
        }
        for (int i = 0; i < getChildCount(); i++) {
            com.taobao.weex.ui.component.Scrollable firstScroller = getChild(i).getFirstScroller();
            if (firstScroller != null) {
                return firstScroller;
            }
        }
        return null;
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void bindComponentData(io.dcloud.feature.uniapp.ui.component.AbsBasicComponent absBasicComponent) {
        if (isLazy()) {
            return;
        }
        if (absBasicComponent == null) {
            absBasicComponent = this;
        }
        super.bindComponentData(absBasicComponent);
        int iChildCount = childCount();
        for (int i = 0; i < iChildCount; i++) {
            getChild(i).bindData(((com.taobao.weex.ui.component.WXVContainer) absBasicComponent).getChild(i));
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void refreshData(com.taobao.weex.ui.component.WXComponent wXComponent) {
        if (wXComponent == null) {
            wXComponent = this;
        }
        super.refreshData(wXComponent);
        int iChildCount = childCount();
        for (int i = 0; i < iChildCount; i++) {
            getChild(i).refreshData(((com.taobao.weex.ui.component.WXVContainer) wXComponent).getChild(i));
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public android.view.ViewGroup getRealView() {
        return (android.view.ViewGroup) super.getRealView();
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void createViewImpl() {
        super.createViewImpl();
        int iChildCount = childCount();
        for (int i = 0; i < iChildCount; i++) {
            createChildViewAt(i);
        }
        if (getHostView() != null) {
            getHostView().setClipToPadding(false);
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void destroy() {
        java.util.ArrayList<com.taobao.weex.ui.component.WXComponent> arrayList = this.mChildren;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.mChildren.get(i).destroy();
            }
            this.mChildren.clear();
        }
        super.destroy();
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void recycled() {
        if (this.mChildren != null && !isFixed() && getAttrs().canRecycled()) {
            int size = this.mChildren.size();
            for (int i = 0; i < size; i++) {
                this.mChildren.get(i).recycled();
            }
        }
        super.recycled();
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public android.view.View detachViewAndClearPreInfo() {
        android.view.View viewDetachViewAndClearPreInfo = super.detachViewAndClearPreInfo();
        if (this.mChildren != null) {
            int iChildCount = childCount();
            for (int i = 0; i < iChildCount; i++) {
                this.mChildren.get(i).detachViewAndClearPreInfo();
            }
        }
        return viewDetachViewAndClearPreInfo;
    }

    public int childCount() {
        java.util.ArrayList<com.taobao.weex.ui.component.WXComponent> arrayList = this.mChildren;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public com.taobao.weex.ui.component.WXComponent getChild(int i) {
        java.util.ArrayList<com.taobao.weex.ui.component.WXComponent> arrayList = this.mChildren;
        if (arrayList == null || i < 0 || i >= arrayList.size()) {
            return null;
        }
        return this.mChildren.get(i);
    }

    public int getChildCount() {
        return childCount();
    }

    public void addChild(com.taobao.weex.ui.component.WXComponent wXComponent) {
        addChild(wXComponent, -1);
    }

    public void addChild(com.taobao.weex.ui.component.WXComponent wXComponent, int i) {
        if (wXComponent == null || i < -1) {
            return;
        }
        wXComponent.mDeepInComponentTree = this.mDeepInComponentTree + 1;
        getInstance().setMaxDomDeep(wXComponent.mDeepInComponentTree);
        if (i >= this.mChildren.size()) {
            i = -1;
        }
        if (i == -1) {
            this.mChildren.add(wXComponent);
        } else {
            this.mChildren.add(i, wXComponent);
        }
    }

    public final int indexOf(com.taobao.weex.ui.component.WXComponent wXComponent) {
        return this.mChildren.indexOf(wXComponent);
    }

    public void createChildViewAt(int i) {
        android.util.Pair<com.taobao.weex.ui.component.WXComponent, java.lang.Integer> pairRearrangeIndexAndGetChild = rearrangeIndexAndGetChild(i);
        if (pairRearrangeIndexAndGetChild.first != null) {
            com.taobao.weex.ui.component.WXComponent wXComponent = (com.taobao.weex.ui.component.WXComponent) pairRearrangeIndexAndGetChild.first;
            wXComponent.createView();
            if (wXComponent.isVirtualComponent()) {
                return;
            }
            addSubView(wXComponent.getHostView(), ((java.lang.Integer) pairRearrangeIndexAndGetChild.second).intValue());
        }
    }

    protected android.util.Pair<com.taobao.weex.ui.component.WXComponent, java.lang.Integer> rearrangeIndexAndGetChild(int i) {
        if (i < 0) {
            i = childCount() - 1;
        }
        if (i < 0) {
            return new android.util.Pair<>(null, java.lang.Integer.valueOf(i));
        }
        return new android.util.Pair<>(getChild(i), java.lang.Integer.valueOf(i));
    }

    public void addSubView(android.view.View view, int i) {
        if (view == null || getRealView() == null) {
            return;
        }
        if (view.getParent() != null) {
            ((android.view.ViewGroup) view.getParent()).removeView(view);
        }
        if (i >= getRealView().getChildCount()) {
            i = -1;
        }
        if (i == -1) {
            getRealView().addView(view);
        } else {
            getRealView().addView(view, i);
        }
        com.taobao.weex.WXSDKInstance absVContainer = getInstance();
        if (absVContainer != null) {
            absVContainer.getApmForInstance().hasAddView = true;
        }
    }

    public void remove(com.taobao.weex.ui.component.WXComponent wXComponent, boolean z) {
        java.util.ArrayList<com.taobao.weex.ui.component.WXComponent> arrayList;
        if (wXComponent == null || (arrayList = this.mChildren) == null || arrayList.size() == 0) {
            return;
        }
        this.mChildren.remove(wXComponent);
        if (getInstance() != null && getInstance().getRootView() != null && wXComponent.isFixed()) {
            getInstance().removeFixedView(wXComponent.getHostView());
        } else if (getRealView() != null) {
            if (!wXComponent.isVirtualComponent()) {
                android.view.ViewParent parent = (!(wXComponent.getParent() instanceof com.taobao.weex.ui.component.WXBaseScroller) || wXComponent.getHostView() == null) ? null : wXComponent.getHostView().getParent();
                if (parent != null && (parent instanceof android.view.ViewGroup)) {
                    ((android.view.ViewGroup) parent).removeView(wXComponent.getHostView());
                } else {
                    getRealView().removeView(wXComponent.getHostView());
                }
            } else {
                wXComponent.removeVirtualComponent();
            }
        }
        if (z) {
            wXComponent.destroy();
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void notifyAppearStateChange(java.lang.String str, java.lang.String str2) {
        java.util.ArrayList<com.taobao.weex.ui.component.WXComponent> arrayList;
        super.notifyAppearStateChange(str, str2);
        if (getHostView() == null || (arrayList = this.mChildren) == null) {
            return;
        }
        for (com.taobao.weex.ui.component.WXComponent wXComponent : arrayList) {
            if (wXComponent.getHostView() != null && wXComponent.getHostView().getVisibility() != 0) {
                str = com.taobao.weex.common.Constants.Event.DISAPPEAR;
            }
            wXComponent.notifyAppearStateChange(str, str2);
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent, com.taobao.weex.IWXActivityStateListener
    public void onActivityCreate() {
        super.onActivityCreate();
        int iChildCount = childCount();
        for (int i = 0; i < iChildCount; i++) {
            getChild(i).onActivityCreate();
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent, com.taobao.weex.IWXActivityStateListener
    public void onActivityStart() {
        super.onActivityStart();
        int iChildCount = childCount();
        for (int i = 0; i < iChildCount; i++) {
            getChild(i).onActivityStart();
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent, com.taobao.weex.IWXActivityStateListener
    public void onActivityPause() {
        super.onActivityPause();
        int iChildCount = childCount();
        for (int i = 0; i < iChildCount; i++) {
            getChild(i).onActivityPause();
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent, com.taobao.weex.IWXActivityStateListener
    public void onActivityResume() {
        super.onActivityResume();
        int iChildCount = childCount();
        for (int i = 0; i < iChildCount; i++) {
            getChild(i).onActivityResume();
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent, com.taobao.weex.IWXActivityStateListener
    public void onActivityStop() {
        super.onActivityStop();
        int iChildCount = childCount();
        for (int i = 0; i < iChildCount; i++) {
            getChild(i).onActivityStop();
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent, com.taobao.weex.IWXActivityStateListener
    public void onActivityDestroy() {
        super.onActivityDestroy();
        int iChildCount = childCount();
        for (int i = 0; i < iChildCount; i++) {
            getChild(i).onActivityDestroy();
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent, com.taobao.weex.IWXActivityStateListener
    public boolean onActivityBack() {
        super.onActivityBack();
        int iChildCount = childCount();
        for (int i = 0; i < iChildCount; i++) {
            getChild(i).onActivityBack();
        }
        return false;
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void onActivityResult(int i, int i2, android.content.Intent intent) {
        super.onActivityResult(i, i2, intent);
        int iChildCount = childCount();
        for (int i3 = 0; i3 < iChildCount; i3++) {
            getChild(i3).onActivityResult(i, i2, intent);
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        super.onCreateOptionsMenu(menu);
        int iChildCount = childCount();
        for (int i = 0; i < iChildCount; i++) {
            getChild(i).onCreateOptionsMenu(menu);
        }
        return false;
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void onRequestPermissionsResult(int i, java.lang.String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        int iChildCount = childCount();
        for (int i2 = 0; i2 < iChildCount; i2++) {
            getChild(i2).onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void onRenderFinish(int i) {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            com.taobao.weex.ui.component.WXComponent child = getChild(i2);
            if (child != null) {
                child.mTraceInfo.uiQueueTime = this.mTraceInfo.uiQueueTime;
                child.onRenderFinish(i);
            }
        }
        super.onRenderFinish(i);
    }

    @io.dcloud.feature.uniapp.annotation.UniJSMethod
    public void releaseImageList(java.lang.String str) {
        if (getHostView() != null && androidx.core.view.ViewCompat.isAttachedToWindow(getHostView()) && (getHostView() instanceof android.view.ViewGroup)) {
            if (com.taobao.weex.utils.WXUtils.getBoolean(str, false).booleanValue()) {
                doViewTreeRecycleImageView(getHostView(), true);
                return;
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                com.taobao.weex.ui.component.WXComponent child = getChild(i);
                if ((child instanceof com.taobao.weex.ui.component.WXImage) && (((com.taobao.weex.ui.component.WXImage) child).getHostView() instanceof com.taobao.weex.ui.view.WXImageView)) {
                    com.taobao.weex.ui.view.WXImageView wXImageView = (com.taobao.weex.ui.view.WXImageView) child.getHostView();
                    if (wXImageView != null && androidx.core.view.ViewCompat.isAttachedToWindow(wXImageView)) {
                        wXImageView.autoReleaseImage();
                    }
                } else if (child instanceof com.taobao.weex.ui.component.WXVContainer) {
                    ((com.taobao.weex.ui.component.WXVContainer) child).releaseImageList(str);
                }
            }
        }
    }

    @io.dcloud.feature.uniapp.annotation.UniJSMethod
    public void recoverImageList(java.lang.String str) {
        if (getHostView() != null && androidx.core.view.ViewCompat.isAttachedToWindow(getHostView()) && (getHostView() instanceof android.view.ViewGroup)) {
            if (com.taobao.weex.utils.WXUtils.getBoolean(str, false).booleanValue()) {
                doViewTreeRecycleImageView(getHostView(), false);
                return;
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                com.taobao.weex.ui.component.WXComponent child = getChild(i);
                if ((child instanceof com.taobao.weex.ui.component.WXImage) && (((com.taobao.weex.ui.component.WXImage) child).getHostView() instanceof com.taobao.weex.ui.view.WXImageView)) {
                    com.taobao.weex.ui.view.WXImageView wXImageView = (com.taobao.weex.ui.view.WXImageView) child.getHostView();
                    if (wXImageView != null && androidx.core.view.ViewCompat.isAttachedToWindow(wXImageView)) {
                        wXImageView.autoRecoverImage();
                    }
                } else if (child instanceof com.taobao.weex.ui.component.WXVContainer) {
                    ((com.taobao.weex.ui.component.WXVContainer) child).recoverImageList(str);
                }
            }
        }
    }

    private void doViewTreeRecycleImageView(android.view.ViewGroup viewGroup, boolean z) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            android.view.View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof com.taobao.weex.ui.view.WXImageView) {
                if (z) {
                    ((com.taobao.weex.ui.view.WXImageView) childAt).autoReleaseImage();
                } else {
                    ((com.taobao.weex.ui.view.WXImageView) childAt).autoRecoverImage();
                }
            } else if (childAt instanceof android.view.ViewGroup) {
                doViewTreeRecycleImageView((android.view.ViewGroup) childAt, z);
            }
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (this.mGesture != null) {
            if (this.mGesture.isRequestDisallowInterceptTouchEvent()) {
                return;
            } else {
                this.mGesture.setRequestDisallowInterceptTouchEvent(z);
            }
        }
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }
}
