package com.taobao.weex.ui.component;

/* JADX INFO: loaded from: classes.dex */
public class ConfirmBar {
    private static com.taobao.weex.ui.component.ConfirmBar instance;
    private int height;
    private android.view.ViewGroup rootView;
    private android.widget.RelativeLayout rtl;
    private java.util.List<com.taobao.weex.ui.component.WXComponent> editText = new java.util.ArrayList();
    private java.util.concurrent.atomic.AtomicReference<io.dcloud.common.DHInterface.ISysEventListener> listener = null;

    static com.taobao.weex.ui.component.ConfirmBar getInstance() {
        if (instance == null) {
            synchronized (com.taobao.weex.ui.component.ConfirmBar.class) {
                if (instance == null) {
                    instance = new com.taobao.weex.ui.component.ConfirmBar();
                }
            }
        }
        return instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showConfirm(boolean z, int i) {
        try {
            if (this.rtl == null) {
                return;
            }
            android.view.ViewGroup viewGroup = this.rootView;
            android.view.View viewFindViewWithTag = viewGroup != null ? viewGroup.findViewWithTag("AppRootView") : null;
            if (z) {
                if (this.rootView != null) {
                    android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) viewFindViewWithTag.getLayoutParams();
                    layoutParams.bottomMargin = this.height;
                    viewFindViewWithTag.setLayoutParams(layoutParams);
                }
                android.widget.FrameLayout.LayoutParams layoutParams2 = (android.widget.FrameLayout.LayoutParams) this.rtl.getLayoutParams();
                layoutParams2.topMargin = i;
                this.rtl.setLayoutParams(layoutParams2);
                this.rtl.setVisibility(0);
                this.rtl.bringToFront();
                return;
            }
            this.rtl.setVisibility(4);
            if (viewFindViewWithTag != null) {
                android.widget.FrameLayout.LayoutParams layoutParams3 = (android.widget.FrameLayout.LayoutParams) viewFindViewWithTag.getLayoutParams();
                layoutParams3.bottomMargin = 0;
                viewFindViewWithTag.setLayoutParams(layoutParams3);
            }
        } catch (java.lang.Exception unused) {
        }
    }

    void addComponent(com.taobao.weex.ui.component.WXComponent wXComponent) {
        try {
            this.editText.add(wXComponent);
        } catch (java.lang.Exception unused) {
        }
    }

    void removeComponent(com.taobao.weex.ui.component.WXComponent wXComponent) {
        try {
            this.editText.remove(wXComponent);
        } catch (java.lang.Exception unused) {
        }
    }

    void createConfirmBar(final android.content.Context context, io.dcloud.common.DHInterface.IApp iApp) {
        try {
            if (this.listener == null) {
                java.util.concurrent.atomic.AtomicReference<io.dcloud.common.DHInterface.ISysEventListener> atomicReference = new java.util.concurrent.atomic.AtomicReference<>(new io.dcloud.common.DHInterface.ISysEventListener() { // from class: com.taobao.weex.ui.component.ConfirmBar.1
                    @Override // io.dcloud.common.DHInterface.ISysEventListener
                    public boolean onExecute(io.dcloud.common.DHInterface.ISysEventListener.SysEventType sysEventType, java.lang.Object obj) {
                        if (sysEventType == io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onSizeChanged) {
                            int[] iArr = (int[]) obj;
                            int i = context.getResources().getDisplayMetrics().heightPixels;
                            int i2 = context.getResources().getDisplayMetrics().heightPixels / 4;
                            if (java.lang.Math.abs(iArr[1] - i) > i2 || java.lang.Math.abs(iArr[1] - iArr[3]) > i2) {
                                int i3 = iArr[1];
                                int i4 = iArr[3];
                                if (i3 <= i4 || java.lang.Math.abs(i3 - i4) <= i2) {
                                    for (com.taobao.weex.ui.component.WXComponent wXComponent : com.taobao.weex.ui.component.ConfirmBar.this.editText) {
                                        if (!wXComponent.getHostView().hasFocus() || !(wXComponent instanceof com.taobao.weex.ui.component.DCTextArea) || !((com.taobao.weex.ui.component.DCTextArea) wXComponent).isShowConfirm) {
                                            com.taobao.weex.ui.component.ConfirmBar.getInstance().showConfirm(false, iArr[1]);
                                        } else {
                                            com.taobao.weex.ui.component.ConfirmBar.getInstance().showConfirm(true, iArr[1]);
                                            break;
                                        }
                                    }
                                } else {
                                    com.taobao.weex.ui.component.ConfirmBar.getInstance().showConfirm(false, iArr[1]);
                                }
                            }
                        } else if (sysEventType == io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onWebAppStop) {
                            com.taobao.weex.ui.component.ConfirmBar.this.listener = null;
                            com.taobao.weex.ui.component.ConfirmBar.this.rtl = null;
                            com.taobao.weex.ui.component.ConfirmBar.this.rootView = null;
                        }
                        return false;
                    }
                });
                this.listener = atomicReference;
                iApp.registerSysEventListener(atomicReference.get(), io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onSizeChanged);
                iApp.registerSysEventListener(this.listener.get(), io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onWebAppStop);
            }
            this.height = (int) android.util.TypedValue.applyDimension(1, 44.0f, context.getResources().getDisplayMetrics());
            if (this.rtl == null) {
                this.rtl = new android.widget.RelativeLayout(context);
                android.view.ViewGroup viewGroup = (android.view.ViewGroup) iApp.obtainWebAppRootView().obtainMainView().getParent();
                this.rootView = viewGroup;
                if (viewGroup != null) {
                    this.rootView.addView(this.rtl, new android.widget.FrameLayout.LayoutParams(-1, this.height));
                }
                android.widget.Button button = new android.widget.Button(context);
                button.setText(android.R.string.ok);
                button.setGravity(17);
                button.setTextColor(android.graphics.Color.argb(255, 50, 205, 50));
                button.setTextSize(android.util.TypedValue.applyDimension(2, 6.0f, context.getResources().getDisplayMetrics()));
                button.setBackground(null);
                button.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.taobao.weex.ui.component.ConfirmBar.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(android.view.View view) {
                        com.taobao.weex.ui.component.WXComponent wXComponent;
                        if (com.taobao.weex.ui.component.ConfirmBar.this.editText.size() > 0) {
                            java.util.Iterator it = com.taobao.weex.ui.component.ConfirmBar.this.editText.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    wXComponent = null;
                                    break;
                                }
                                wXComponent = (com.taobao.weex.ui.component.WXComponent) it.next();
                                if ((wXComponent.getHostView() instanceof com.taobao.weex.ui.view.WXEditText) && wXComponent.getHostView().hasFocus()) {
                                    break;
                                }
                            }
                            if (wXComponent != null) {
                                java.util.HashMap map = new java.util.HashMap(1);
                                java.util.HashMap map2 = new java.util.HashMap(1);
                                map2.put("value", ((com.taobao.weex.ui.view.WXEditText) wXComponent.getHostView()).getText().toString());
                                map.put("detail", map2);
                                wXComponent.fireEvent("confirm", map);
                                if (wXComponent.getParent() != null) {
                                    wXComponent.getParent().interceptFocus();
                                }
                                wXComponent.getHostView().clearFocus();
                                ((com.taobao.weex.ui.component.DCTextArea) wXComponent).hideSoftKeyboard();
                            }
                        }
                    }
                });
                this.rtl.addView(button, new android.widget.RelativeLayout.LayoutParams(-2, -1));
                this.rtl.setBackgroundColor(android.graphics.Color.argb(255, 220, 220, 220));
                this.rtl.setTag("ConfirmBar");
                this.rtl.setVisibility(4);
            }
        } catch (java.lang.Exception unused) {
        }
    }
}
