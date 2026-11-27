package io.dcloud.common.adapter.ui;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class AdaRootView extends io.dcloud.common.adapter.ui.AdaContainerFrameItem {
    android.widget.FrameLayout mMyRootView;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class MyRootView extends android.widget.FrameLayout {
        io.dcloud.common.adapter.ui.AdaRootView mProxy;

        public MyRootView(android.content.Context context, io.dcloud.common.adapter.ui.AdaRootView adaRootView) {
            super(context);
            this.mProxy = adaRootView;
        }

        @Override // android.view.View
        protected void onConfigurationChanged(android.content.res.Configuration configuration) {
            super.onConfigurationChanged(configuration);
            io.dcloud.common.adapter.ui.AdaRootView.this.mViewOptions.onScreenChanged();
        }

        @Override // android.view.View
        protected void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            io.dcloud.common.adapter.ui.AdaRootView.this.mViewOptions.onScreenChanged(i, i2);
            io.dcloud.common.adapter.util.Logger.d(io.dcloud.common.adapter.util.Logger.LAYOUT_TAG, "AdaRootView onSizeChanged", java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(i3), java.lang.Integer.valueOf(i4));
        }
    }

    protected AdaRootView(android.content.Context context, android.widget.FrameLayout frameLayout) {
        super(context);
        this.mMyRootView = null;
        if (frameLayout != null) {
            this.mMyRootView = frameLayout;
        } else {
            this.mMyRootView = new io.dcloud.common.adapter.ui.AdaRootView.MyRootView(context, this);
        }
        setMainView(this.mMyRootView);
    }
}
