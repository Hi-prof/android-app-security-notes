package io.dcloud.common.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class SubNViewsUtil {
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static void initFrameSubNViews(io.dcloud.common.adapter.ui.AdaFrameView adaFrameView) {
        if (adaFrameView.getFrameType() == 2) {
            org.json.JSONObject jSONObjectObtainThridInfo = adaFrameView.obtainApp().obtainThridInfo(io.dcloud.common.DHInterface.IApp.ConfigProperty.ThridInfo.LaunchWebviewJsonData);
            if (jSONObjectObtainThridInfo != null && jSONObjectObtainThridInfo.has(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_SUB_NVIEWS)) {
                try {
                    adaFrameView.obtainFrameOptions().mSubNViews = jSONObjectObtainThridInfo.getJSONArray(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_SUB_NVIEWS);
                } catch (org.json.JSONException e) {
                    e.printStackTrace();
                }
            }
            if (jSONObjectObtainThridInfo != null && jSONObjectObtainThridInfo.has(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_ANIMATION_OPTIMIZATION) && jSONObjectObtainThridInfo.optString(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_ANIMATION_OPTIMIZATION).equals("auto")) {
                adaFrameView.obtainFrameOptions().isAnimationOptimization = true;
            }
        } else if (adaFrameView.getFrameType() == 4) {
            org.json.JSONObject jSONObjectObtainThridInfo2 = adaFrameView.obtainApp().obtainThridInfo(io.dcloud.common.DHInterface.IApp.ConfigProperty.ThridInfo.SecondWebviewJsonData);
            if (jSONObjectObtainThridInfo2 != null && jSONObjectObtainThridInfo2.has(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_SUB_NVIEWS)) {
                try {
                    adaFrameView.obtainFrameOptions().mSubNViews = jSONObjectObtainThridInfo2.getJSONArray(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_SUB_NVIEWS);
                } catch (org.json.JSONException e2) {
                    e2.printStackTrace();
                }
            }
            if (jSONObjectObtainThridInfo2 != null && jSONObjectObtainThridInfo2.has(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_ANIMATION_OPTIMIZATION) && jSONObjectObtainThridInfo2.optString(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_ANIMATION_OPTIMIZATION).equals("auto")) {
                adaFrameView.obtainFrameOptions().isAnimationOptimization = true;
            }
        }
        if (adaFrameView.obtainFrameOptions().mSubNViews != null) {
            org.json.JSONArray jSONArray = adaFrameView.obtainFrameOptions().mSubNViews;
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    org.json.JSONObject jSONObject = jSONArray.getJSONObject(i);
                    java.lang.String strOptString = jSONObject.optString("id", i + "NativeView");
                    java.lang.String strOptString2 = jSONObject.optString("uuid");
                    if (android.text.TextUtils.isEmpty(strOptString2)) {
                        strOptString2 = "NativeView" + (java.lang.System.currentTimeMillis() + ((long) i));
                    }
                    java.lang.Object objProcessEvent = adaFrameView.mWindowMgr.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.FeatureMgr, 10, new java.lang.Object[]{adaFrameView.obtainWebView(), "nativeobj", "View", new java.lang.Object[]{adaFrameView, adaFrameView.obtainWebView(), strOptString, strOptString2, jSONObject.optJSONObject("styles"), jSONObject.optJSONArray("tags"), jSONObject.optString("type", "NView")}});
                    if (objProcessEvent != null) {
                        ((io.dcloud.common.DHInterface.INativeView) objProcessEvent).attachToViewGroup(adaFrameView);
                    }
                } catch (org.json.JSONException e3) {
                    e3.printStackTrace();
                    return;
                }
            }
        }
    }

    public static boolean startAnimation(final io.dcloud.common.adapter.ui.AdaFrameView adaFrameView, io.dcloud.nineoldandroids.animation.Animator animator, int i) {
        java.util.ArrayList<io.dcloud.common.DHInterface.INativeView> arrayList;
        if (adaFrameView.getAnimOptions().mAnimator != null && i == 0 && (arrayList = adaFrameView.mChildNativeViewList) != null && arrayList.size() > 0) {
            final android.view.ViewGroup viewGroupObtainWindowView = adaFrameView.obtainWebView().obtainWindowView();
            final android.view.ViewGroup viewGroup = (android.view.ViewGroup) viewGroupObtainWindowView.getParent();
            final java.util.ArrayList arrayList2 = new java.util.ArrayList();
            if (adaFrameView.obtainFrameOptions().background == -1) {
                viewGroup.setBackgroundColor(-1);
            }
            for (int i2 = 0; i2 < viewGroupObtainWindowView.getChildCount(); i2++) {
                android.view.KeyEvent.Callback childAt = viewGroupObtainWindowView.getChildAt(i2);
                if (childAt instanceof io.dcloud.common.DHInterface.INativeView) {
                    arrayList2.add((io.dcloud.common.DHInterface.INativeView) childAt);
                }
            }
            int size = arrayList2.size();
            int i3 = 0;
            while (i3 < size) {
                java.lang.Object obj = arrayList2.get(i3);
                i3++;
                io.dcloud.common.DHInterface.INativeView iNativeView = (io.dcloud.common.DHInterface.INativeView) obj;
                viewGroupObtainWindowView.removeView(iNativeView.obtanMainView());
                viewGroup.addView(iNativeView.obtanMainView());
            }
            viewGroup.removeView(viewGroupObtainWindowView);
            try {
                viewGroupObtainWindowView.getClass().getMethod("onPause", null).invoke(viewGroupObtainWindowView, null);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
            final android.view.View viewObtainMainView = adaFrameView.obtainMainView();
            if (!io.dcloud.common.util.PdrUtil.isEmpty(viewObtainMainView)) {
                viewObtainMainView.bringToFront();
                viewObtainMainView.setVisibility(0);
                adaFrameView.getAnimOptions().mAnimator.setAnimationListener(new android.view.animation.Animation.AnimationListener() { // from class: io.dcloud.common.util.SubNViewsUtil.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(android.view.animation.Animation animation) {
                        io.dcloud.nineoldandroids.animation.Animator.AnimatorListener animatorListener = adaFrameView.mAnimatorListener;
                        if (animatorListener != null) {
                            animatorListener.onAnimationEnd(null);
                        }
                        io.dcloud.common.util.BaseInfo.sDoingAnimation = false;
                        adaFrameView.setSlipping(false);
                        viewObtainMainView.post(new java.lang.Runnable() { // from class: io.dcloud.common.util.SubNViewsUtil.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                java.util.ArrayList arrayList3 = arrayList2;
                                int size2 = arrayList3.size();
                                int i4 = 0;
                                while (i4 < size2) {
                                    java.lang.Object obj2 = arrayList3.get(i4);
                                    i4++;
                                    io.dcloud.common.DHInterface.INativeView iNativeView2 = (io.dcloud.common.DHInterface.INativeView) obj2;
                                    viewGroup.removeView(iNativeView2.obtanMainView());
                                    viewGroupObtainWindowView.addView(iNativeView2.obtanMainView());
                                }
                                io.dcloud.common.util.SubNViewsUtil.AnonymousClass1 anonymousClass1 = io.dcloud.common.util.SubNViewsUtil.AnonymousClass1.this;
                                viewGroup.addView(viewGroupObtainWindowView);
                                if (adaFrameView.obtainFrameOptions().background == -1) {
                                    viewGroup.setBackgroundColor(0);
                                }
                                try {
                                    viewGroupObtainWindowView.getClass().getMethod("onResume", null).invoke(viewGroupObtainWindowView, null);
                                } catch (java.lang.Exception e2) {
                                    e2.printStackTrace();
                                }
                            }
                        });
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(android.view.animation.Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(android.view.animation.Animation animation) {
                        io.dcloud.nineoldandroids.animation.Animator.AnimatorListener animatorListener = adaFrameView.mAnimatorListener;
                        if (animatorListener != null) {
                            animatorListener.onAnimationStart(null);
                        }
                        io.dcloud.common.util.BaseInfo.sDoingAnimation = true;
                    }
                });
                adaFrameView.setSlipping(true);
                viewObtainMainView.startAnimation(adaFrameView.getAnimOptions().mAnimator);
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static void updateSubNViews(io.dcloud.common.adapter.ui.AdaFrameView adaFrameView, org.json.JSONArray jSONArray) {
        if (jSONArray != null) {
            adaFrameView.mWindowMgr.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.FeatureMgr, 10, new java.lang.Object[]{adaFrameView.obtainWebView(), "nativeobj", "updateSubNViews", new java.lang.Object[]{adaFrameView, adaFrameView.obtainWebView(), jSONArray}});
        }
    }
}
