package io.dcloud.common.adapter.ui.fresh;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public abstract class LoadingLayout extends android.widget.FrameLayout implements io.dcloud.common.adapter.ui.fresh.ILoadingLayout {
    private android.view.View mContainer;
    private io.dcloud.common.adapter.ui.fresh.ILoadingLayout.State mCurState;
    private io.dcloud.common.adapter.ui.fresh.ILoadingLayout.State mPreState;

    /* JADX INFO: renamed from: io.dcloud.common.adapter.ui.fresh.LoadingLayout$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$dcloud$common$adapter$ui$fresh$ILoadingLayout$State;

        static {
            int[] iArr = new int[io.dcloud.common.adapter.ui.fresh.ILoadingLayout.State.values().length];
            $SwitchMap$io$dcloud$common$adapter$ui$fresh$ILoadingLayout$State = iArr;
            try {
                iArr[io.dcloud.common.adapter.ui.fresh.ILoadingLayout.State.RESET.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$dcloud$common$adapter$ui$fresh$ILoadingLayout$State[io.dcloud.common.adapter.ui.fresh.ILoadingLayout.State.RELEASE_TO_REFRESH.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$dcloud$common$adapter$ui$fresh$ILoadingLayout$State[io.dcloud.common.adapter.ui.fresh.ILoadingLayout.State.PULL_TO_REFRESH.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$dcloud$common$adapter$ui$fresh$ILoadingLayout$State[io.dcloud.common.adapter.ui.fresh.ILoadingLayout.State.REFRESHING.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$dcloud$common$adapter$ui$fresh$ILoadingLayout$State[io.dcloud.common.adapter.ui.fresh.ILoadingLayout.State.NO_MORE_DATA.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
        }
    }

    public LoadingLayout(android.content.Context context) {
        this(context, null);
    }

    protected abstract android.view.View createLoadingView(android.content.Context context, android.util.AttributeSet attributeSet);

    public abstract int getContentSize();

    protected io.dcloud.common.adapter.ui.fresh.ILoadingLayout.State getPreState() {
        return this.mPreState;
    }

    @Override // io.dcloud.common.adapter.ui.fresh.ILoadingLayout
    public io.dcloud.common.adapter.ui.fresh.ILoadingLayout.State getState() {
        return this.mCurState;
    }

    protected void onNoMoreData() {
    }

    @Override // io.dcloud.common.adapter.ui.fresh.ILoadingLayout
    public void onPull(float f) {
    }

    protected void onPullToRefresh() {
    }

    protected void onRefreshing() {
    }

    protected void onReleaseToRefresh() {
    }

    protected void onReset() {
    }

    protected void onStateChanged(io.dcloud.common.adapter.ui.fresh.ILoadingLayout.State state, io.dcloud.common.adapter.ui.fresh.ILoadingLayout.State state2) {
        int i = io.dcloud.common.adapter.ui.fresh.LoadingLayout.AnonymousClass1.$SwitchMap$io$dcloud$common$adapter$ui$fresh$ILoadingLayout$State[state.ordinal()];
        if (i == 1) {
            onReset();
            return;
        }
        if (i == 2) {
            onReleaseToRefresh();
            return;
        }
        if (i == 3) {
            onPullToRefresh();
        } else if (i == 4) {
            onRefreshing();
        } else {
            if (i != 5) {
                return;
            }
            onNoMoreData();
        }
    }

    public void setLastUpdatedLabel(java.lang.CharSequence charSequence) {
    }

    public void setLoadingDrawable(android.graphics.drawable.Drawable drawable) {
    }

    public void setPullLabel(java.lang.CharSequence charSequence) {
    }

    public void setRefreshingLabel(java.lang.CharSequence charSequence) {
    }

    public void setReleaseLabel(java.lang.CharSequence charSequence) {
    }

    @Override // io.dcloud.common.adapter.ui.fresh.ILoadingLayout
    public void setState(io.dcloud.common.adapter.ui.fresh.ILoadingLayout.State state) {
        io.dcloud.common.adapter.ui.fresh.ILoadingLayout.State state2 = this.mCurState;
        if (state2 != state) {
            this.mPreState = state2;
            this.mCurState = state;
            onStateChanged(state, state2);
        }
    }

    public void show(boolean z) {
        android.view.ViewGroup.LayoutParams layoutParams;
        if (z == (getVisibility() == 0) || (layoutParams = this.mContainer.getLayoutParams()) == null) {
            return;
        }
        if (z) {
            layoutParams.height = -2;
        } else {
            layoutParams.height = 0;
        }
        setVisibility(z ? 0 : 4);
    }

    public LoadingLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LoadingLayout(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        io.dcloud.common.adapter.ui.fresh.ILoadingLayout.State state = io.dcloud.common.adapter.ui.fresh.ILoadingLayout.State.NONE;
        this.mCurState = state;
        this.mPreState = state;
    }
}
