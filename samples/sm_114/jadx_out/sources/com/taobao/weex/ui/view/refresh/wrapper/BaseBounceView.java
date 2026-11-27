package com.taobao.weex.ui.view.refresh.wrapper;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseBounceView<T extends android.view.View> extends android.widget.FrameLayout {
    private T mInnerView;
    private int mOrientation;
    protected com.taobao.weex.ui.view.refresh.core.WXSwipeLayout swipeLayout;

    public abstract void onLoadmoreComplete();

    public abstract void onRefreshingComplete();

    public abstract T setInnerView(android.content.Context context);

    public BaseBounceView(android.content.Context context, int i) {
        this(context, null, i);
    }

    public BaseBounceView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.mOrientation = i;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public void init(android.content.Context context) {
        createBounceView(context);
    }

    boolean isVertical() {
        return this.mOrientation == 1;
    }

    public void setOnRefreshListener(com.taobao.weex.ui.view.refresh.core.WXSwipeLayout.WXOnRefreshListener wXOnRefreshListener) {
        com.taobao.weex.ui.view.refresh.core.WXSwipeLayout wXSwipeLayout = this.swipeLayout;
        if (wXSwipeLayout != null) {
            wXSwipeLayout.setOnRefreshListener(wXOnRefreshListener);
        }
    }

    public void setOnLoadingListener(com.taobao.weex.ui.view.refresh.core.WXSwipeLayout.WXOnLoadingListener wXOnLoadingListener) {
        com.taobao.weex.ui.view.refresh.core.WXSwipeLayout wXSwipeLayout = this.swipeLayout;
        if (wXSwipeLayout != null) {
            wXSwipeLayout.setOnLoadingListener(wXOnLoadingListener);
        }
    }

    public void finishPullRefresh() {
        com.taobao.weex.ui.view.refresh.core.WXSwipeLayout wXSwipeLayout = this.swipeLayout;
        if (wXSwipeLayout != null) {
            wXSwipeLayout.finishPullRefresh();
        }
    }

    public void finishPullLoad() {
        com.taobao.weex.ui.view.refresh.core.WXSwipeLayout wXSwipeLayout = this.swipeLayout;
        if (wXSwipeLayout != null) {
            wXSwipeLayout.finishPullLoad();
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private com.taobao.weex.ui.view.refresh.core.WXSwipeLayout createBounceView(android.content.Context context) {
        com.taobao.weex.ui.view.refresh.core.WXSwipeLayout wXSwipeLayout = new com.taobao.weex.ui.view.refresh.core.WXSwipeLayout(context);
        this.swipeLayout = wXSwipeLayout;
        wXSwipeLayout.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1));
        T t = (T) setInnerView(context);
        this.mInnerView = t;
        if (t == null) {
            return null;
        }
        this.swipeLayout.addTargetView(t);
        addView(this.swipeLayout, -1, -1);
        return this.swipeLayout;
    }

    public T getInnerView() {
        return this.mInnerView;
    }

    public void setHeaderView(com.taobao.weex.ui.component.WXComponent wXComponent) {
        com.taobao.weex.ui.view.refresh.core.WXRefreshView headerView;
        int color;
        setRefreshEnable(true);
        com.taobao.weex.ui.view.refresh.core.WXSwipeLayout wXSwipeLayout = this.swipeLayout;
        if (wXSwipeLayout == null || (headerView = wXSwipeLayout.getHeaderView()) == null) {
            return;
        }
        if (headerView.getParent() == null) {
            this.swipeLayout.addView(headerView, new android.widget.FrameLayout.LayoutParams(-1, 0));
        }
        if (wXComponent != null) {
            this.swipeLayout.setRefreshHeight((int) wXComponent.getLayoutHeight());
            java.lang.String string = com.taobao.weex.utils.WXUtils.getString((java.lang.String) wXComponent.getStyles().get("backgroundColor"), null);
            if (string != null && !android.text.TextUtils.isEmpty(string) && (color = com.taobao.weex.utils.WXResourceUtils.getColor(string)) != 0) {
                this.swipeLayout.setRefreshBgColor(color);
            }
            headerView.setRefreshView(wXComponent.getHostView());
        }
    }

    public void setFooterView(com.taobao.weex.ui.component.WXComponent wXComponent) {
        com.taobao.weex.ui.view.refresh.core.WXRefreshView footerView;
        int color;
        setLoadmoreEnable(true);
        com.taobao.weex.ui.view.refresh.core.WXSwipeLayout wXSwipeLayout = this.swipeLayout;
        if (wXSwipeLayout == null || (footerView = wXSwipeLayout.getFooterView()) == null) {
            return;
        }
        if (footerView.getParent() == null) {
            android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(-1, 0);
            layoutParams.gravity = 80;
            this.swipeLayout.addView(footerView, layoutParams);
        }
        if (wXComponent != null) {
            this.swipeLayout.setLoadingHeight((int) wXComponent.getLayoutHeight());
            java.lang.String string = com.taobao.weex.utils.WXUtils.getString((java.lang.String) wXComponent.getStyles().get("backgroundColor"), null);
            if (string != null && !android.text.TextUtils.isEmpty(string) && (color = com.taobao.weex.utils.WXResourceUtils.getColor(string)) != 0) {
                this.swipeLayout.setLoadingBgColor(color);
            }
            footerView.setRefreshView(wXComponent.getHostView());
        }
    }

    public void removeFooterView(com.taobao.weex.ui.component.WXComponent wXComponent) {
        setLoadmoreEnable(false);
        com.taobao.weex.ui.view.refresh.core.WXSwipeLayout wXSwipeLayout = this.swipeLayout;
        if (wXSwipeLayout == null || wXSwipeLayout.getFooterView() == null) {
            return;
        }
        this.swipeLayout.setLoadingHeight(0);
        this.swipeLayout.getFooterView().removeView(wXComponent.getHostView());
        this.swipeLayout.finishPullLoad();
    }

    public void removeHeaderView(com.taobao.weex.ui.component.WXComponent wXComponent) {
        setRefreshEnable(false);
        com.taobao.weex.ui.view.refresh.core.WXSwipeLayout wXSwipeLayout = this.swipeLayout;
        if (wXSwipeLayout == null || wXSwipeLayout.getHeaderView() == null) {
            return;
        }
        this.swipeLayout.setRefreshHeight(0);
        this.swipeLayout.getHeaderView().removeView(wXComponent.getHostView());
        this.swipeLayout.finishPullRefresh();
    }

    public void setRefreshEnable(boolean z) {
        com.taobao.weex.ui.view.refresh.core.WXSwipeLayout wXSwipeLayout = this.swipeLayout;
        if (wXSwipeLayout != null) {
            wXSwipeLayout.setPullRefreshEnable(z);
        }
    }

    public void setLoadmoreEnable(boolean z) {
        com.taobao.weex.ui.view.refresh.core.WXSwipeLayout wXSwipeLayout = this.swipeLayout;
        if (wXSwipeLayout != null) {
            wXSwipeLayout.setPullLoadEnable(z);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(android.view.View view) {
        if (view instanceof com.taobao.weex.ui.view.WXLoadingLayout) {
            finishPullLoad();
            setLoadmoreEnable(false);
            com.taobao.weex.ui.view.refresh.core.WXSwipeLayout wXSwipeLayout = this.swipeLayout;
            if (wXSwipeLayout != null) {
                wXSwipeLayout.removeView(wXSwipeLayout.getFooterView());
                return;
            }
            return;
        }
        if (view instanceof com.taobao.weex.ui.view.WXRefreshLayout) {
            finishPullRefresh();
            setRefreshEnable(false);
            com.taobao.weex.ui.view.refresh.core.WXSwipeLayout wXSwipeLayout2 = this.swipeLayout;
            if (wXSwipeLayout2 != null) {
                wXSwipeLayout2.removeView(wXSwipeLayout2.getHeaderView());
                return;
            }
            return;
        }
        super.removeView(view);
    }

    public com.taobao.weex.ui.view.refresh.core.WXSwipeLayout getSwipeLayout() {
        return this.swipeLayout;
    }
}
