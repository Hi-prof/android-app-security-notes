package io.dcloud.common.adapter.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class AnimOptions {
    public static final java.lang.String ANIM_FADE_IN = "fade-in";
    public static final java.lang.String ANIM_FADE_OUT = "fade-out";
    public static final java.lang.String ANIM_FLIP_RX = "flip-rx";
    public static final java.lang.String ANIM_FLIP_RY = "flip-ry";
    public static final java.lang.String ANIM_FLIP_X = "flip-x";
    public static final java.lang.String ANIM_FLIP_Y = "flip-y";
    public static final java.lang.String ANIM_NONE = "none";
    public static final java.lang.String ANIM_PAGE_BACKWARD = "page-backward";
    public static final java.lang.String ANIM_PAGE_FORWARD = "page-forward";
    public static final java.lang.String ANIM_POP_IN = "pop-in";
    public static final java.lang.String ANIM_POP_OUT = "pop-out";
    public static final java.lang.String ANIM_SLIDE_IN_BOTTOM = "slide-in-bottom";
    public static final java.lang.String ANIM_SLIDE_IN_LEFT = "slide-in-left";
    public static final java.lang.String ANIM_SLIDE_IN_RIGHT = "slide-in-right";
    public static final java.lang.String ANIM_SLIDE_IN_TOP = "slide-in-top";
    public static final java.lang.String ANIM_SLIDE_OUT_BOTTOM = "slide-out-bottom";
    public static final java.lang.String ANIM_SLIDE_OUT_LEFT = "slide-out-left";
    public static final java.lang.String ANIM_SLIDE_OUT_RIGHT = "slide-out-right";
    public static final java.lang.String ANIM_SLIDE_OUT_TOP = "slide-out-top";
    private static final int ANIM_TIME = 200;
    public static final java.lang.String ANIM_ZOOM_FADE_IN = "zoom-fade-in";
    public static final java.lang.String ANIM_ZOOM_FADE_OUT = "zoom-fade-out";
    public static final java.lang.String ANIM_ZOOM_IN = "zoom-in";
    public static final java.lang.String ANIM_ZOOM_OUT = "zoom-out";
    public static final byte OPTION_CLOSE = 1;
    public static final byte OPTION_HIDE = 3;
    public static final byte OPTION_HIDE_SHOW = 4;
    public static final byte OPTION_SHOW = 0;
    public static final byte OPTION_UPDATE = 2;
    static final java.lang.String TAG = "AnimOptions";
    public static final java.lang.String TF_EASE_IN = "ease-in";
    public static final java.lang.String TF_EASE_IN_OUT = "ease-in-out";
    public static final java.lang.String TF_EASE_OUT = "ease-out";
    public static final java.lang.String TF_LINEAR = "linear";
    public static final java.util.HashMap<java.lang.String, java.lang.String> mAnimTypes;
    public io.dcloud.common.adapter.util.AnimOptions.AnimMode mAnimMode;
    public java.lang.String mAnimType_close;
    public io.dcloud.common.DHInterface.IFrameView mHostFrame;
    public io.dcloud.common.adapter.ui.AdaFrameItem mRelFrameItem;
    public io.dcloud.common.adapter.ui.AdaFrameItem mUserFrameItem;
    public int sScreenHeight;
    public int sScreenWidth;
    public java.lang.String timingfunction = "linear";
    public int duration = 200;
    public int duration_show = 200;
    public int duration_close = 200;
    public java.lang.String translate = "";
    public java.lang.String scale = "";
    public java.lang.String opacity = "";
    public java.lang.String rotate = "";
    public java.lang.String mAnimType = "none";
    public byte mOption = 0;
    public java.util.ArrayList<java.lang.String> mStartCallback = null;
    public java.util.ArrayList<java.lang.String> mEndCallback = null;
    public android.view.animation.Animation mAnimator = null;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    enum AnimMode {
        CUSTOM
    }

    static {
        java.util.HashMap<java.lang.String, java.lang.String> map = new java.util.HashMap<>(12);
        mAnimTypes = map;
        map.put(ANIM_SLIDE_IN_RIGHT, ANIM_SLIDE_OUT_RIGHT);
        map.put(ANIM_SLIDE_IN_LEFT, ANIM_SLIDE_OUT_LEFT);
        map.put(ANIM_SLIDE_IN_TOP, ANIM_SLIDE_OUT_TOP);
        map.put(ANIM_SLIDE_IN_BOTTOM, ANIM_SLIDE_OUT_BOTTOM);
        map.put(ANIM_ZOOM_OUT, ANIM_ZOOM_IN);
        map.put(ANIM_ZOOM_FADE_OUT, ANIM_ZOOM_FADE_IN);
        map.put(ANIM_FADE_IN, ANIM_FADE_OUT);
        map.put(ANIM_FLIP_X, ANIM_FLIP_RX);
        map.put(ANIM_FLIP_RX, ANIM_FLIP_X);
        map.put(ANIM_FLIP_Y, ANIM_FLIP_RY);
        map.put(ANIM_FLIP_RY, ANIM_FLIP_Y);
        map.put(ANIM_PAGE_FORWARD, ANIM_PAGE_BACKWARD);
        map.put("none", "none");
        map.put(ANIM_POP_IN, ANIM_POP_OUT);
    }

    private final io.dcloud.nineoldandroids.animation.Animator closeOrHideAnimator(io.dcloud.common.adapter.ui.AdaFrameItem adaFrameItem, io.dcloud.common.adapter.util.ViewOptions viewOptions, io.dcloud.common.adapter.util.ViewOptions viewOptions2, io.dcloud.common.adapter.util.ViewOptions viewOptions3) {
        java.lang.String str = this.mAnimType_close;
        java.util.HashMap<java.lang.String, java.lang.String> map = mAnimTypes;
        if (!map.containsValue(str)) {
            str = map.get(this.mAnimType);
        }
        io.dcloud.common.adapter.util.Logger.d(io.dcloud.common.adapter.util.Logger.ANIMATION_TAG, "closeOrHideAnimator _animType=" + str);
        io.dcloud.nineoldandroids.animation.AnimatorSet animatorSet = new io.dcloud.nineoldandroids.animation.AnimatorSet();
        if (io.dcloud.common.util.PdrUtil.isEquals(str, ANIM_FADE_OUT)) {
            android.view.animation.AnimationSet animationSet = new android.view.animation.AnimationSet(false);
            animationSet.addAnimation(new android.view.animation.AlphaAnimation(1.0f, 0.0f));
            this.mAnimator = animationSet;
            animationSet.setDuration(this.duration_show);
        } else if (io.dcloud.common.util.PdrUtil.isEquals(str, ANIM_ZOOM_IN)) {
            ofFloat(animatorSet, adaFrameItem, "scaleX", 1.0f, 0.0f);
            ofFloat(animatorSet, adaFrameItem, "scaleY", 1.0f, 0.0f);
        } else if (io.dcloud.common.util.PdrUtil.isEquals(str, ANIM_ZOOM_FADE_IN)) {
            ofFloat(animatorSet, adaFrameItem, "scaleX", 1.0f, 0.8f);
            ofFloat(animatorSet, adaFrameItem, "scaleY", 1.0f, 0.8f);
            ofFloat(animatorSet, adaFrameItem, "alpha", 1.0f, 0.0f);
        } else if (!io.dcloud.common.util.PdrUtil.isEquals(str, ANIM_PAGE_BACKWARD)) {
            int i = viewOptions.anim_left;
            int i2 = viewOptions.anim_top;
            int i3 = viewOptions2.anim_left;
            int i4 = viewOptions2.anim_top;
            io.dcloud.common.adapter.util.Logger.d(io.dcloud.common.adapter.util.Logger.ANIMATION_TAG, "closeOrHideAnimator _animType=" + str + ";fromXDelta=" + i + ";toXDelta=" + i3 + ";fromYDelta=" + i2 + ";toYDelta=" + i4);
            if (io.dcloud.common.util.PdrUtil.isEquals(str, ANIM_FLIP_X)) {
                ofFloat(animatorSet, adaFrameItem, "rotationX", -90.0f, 0.0f);
            } else if (io.dcloud.common.util.PdrUtil.isEquals(str, ANIM_FLIP_Y)) {
                ofFloat(animatorSet, adaFrameItem, "rotationY", -90.0f, 0.0f);
            } else if (io.dcloud.common.util.PdrUtil.isEquals(str, ANIM_FLIP_RX)) {
                ofFloat(animatorSet, adaFrameItem, "rotationX", 0.0f, 90.0f);
            } else if (io.dcloud.common.util.PdrUtil.isEquals(str, ANIM_FLIP_RY)) {
                ofFloat(animatorSet, adaFrameItem, "rotationY", 0.0f, 90.0f);
            } else if (io.dcloud.common.util.PdrUtil.isEquals(str, ANIM_SLIDE_OUT_RIGHT)) {
                if (isUseBackground()) {
                    i = viewOptions.left;
                }
                android.view.animation.TranslateAnimation translateAnimation = new android.view.animation.TranslateAnimation(i, i3, 0.0f, 0.0f);
                this.mAnimator = translateAnimation;
                translateAnimation.setInterpolator(new android.view.animation.DecelerateInterpolator());
                this.mAnimator.setDuration(this.duration_close);
            } else if (io.dcloud.common.util.PdrUtil.isEquals(str, ANIM_POP_OUT)) {
                this.mAnimator = android.view.animation.AnimationUtils.loadAnimation(adaFrameItem.getContext(), io.dcloud.base.R.anim.dcloud_page_close_exit);
            } else if (io.dcloud.common.util.PdrUtil.isEquals(str, ANIM_SLIDE_OUT_LEFT)) {
                ofFloat(animatorSet, adaFrameItem, com.taobao.weex.common.Constants.Name.X, i, i3);
            } else if (io.dcloud.common.util.PdrUtil.isEquals(str, ANIM_SLIDE_OUT_TOP)) {
                ofFloat(animatorSet, adaFrameItem, com.taobao.weex.common.Constants.Name.Y, i2, i4);
            } else if (io.dcloud.common.util.PdrUtil.isEquals(str, ANIM_SLIDE_OUT_BOTTOM)) {
                float f = i;
                ofFloat(animatorSet, adaFrameItem, com.taobao.weex.common.Constants.Name.X, f, f);
                ofFloat(animatorSet, adaFrameItem, com.taobao.weex.common.Constants.Name.Y, i2, i4);
            }
        }
        setTimingFunction(animatorSet);
        animatorSet.setDuration(this.duration_close);
        return animatorSet;
    }

    public static java.lang.String getCloseAnimType(java.lang.String str) {
        java.util.HashMap<java.lang.String, java.lang.String> map = mAnimTypes;
        if (map != null) {
            return !map.containsValue(str) ? map.get(str) : str;
        }
        return null;
    }

    private final io.dcloud.nineoldandroids.animation.Animator setStyleOptionAnimator(io.dcloud.common.adapter.ui.AdaFrameItem adaFrameItem, io.dcloud.common.adapter.util.ViewOptions viewOptions, io.dcloud.common.adapter.util.ViewOptions viewOptions2, io.dcloud.common.adapter.util.ViewOptions viewOptions3) {
        boolean z;
        int i;
        int i2;
        int i3;
        io.dcloud.nineoldandroids.animation.AnimatorSet animatorSet = new io.dcloud.nineoldandroids.animation.AnimatorSet();
        int i4 = viewOptions.left;
        int i5 = viewOptions.top;
        int i6 = viewOptions.width;
        int i7 = viewOptions.height;
        int i8 = viewOptions2.left;
        int i9 = viewOptions2.top;
        int i10 = viewOptions2.width;
        int i11 = viewOptions2.height;
        boolean z2 = (i6 == i10 && i7 == i11) ? false : true;
        io.dcloud.common.adapter.util.Logger.d(io.dcloud.common.adapter.util.Logger.ANIMATION_TAG, "createAnimSet_update _oldX=" + i4 + ";_oldY=" + i5 + ";_newX=" + i8 + ";_newY=" + i9);
        if (i4 == i8 && i5 == i9) {
            i2 = i7;
            i = i11;
            i3 = i10;
            z = z2;
        } else {
            z = z2;
            i = i11;
            i2 = i7;
            i3 = i10;
            if (isUseBackground()) {
                io.dcloud.common.adapter.util.Logger.d(io.dcloud.common.adapter.util.Logger.ANIMATION_TAG, "createAnimSet_update not webview mode fromXDelta=" + i4 + ";toXDelta=" + i8 + ";fromYDelta=" + i5 + ";toYDelta=" + i9);
                ofFloat(animatorSet, adaFrameItem, com.taobao.weex.common.Constants.Name.X, (float) i4, (float) i8);
                ofFloat(animatorSet, adaFrameItem, com.taobao.weex.common.Constants.Name.Y, (float) i5, (float) i9);
            } else {
                io.dcloud.common.adapter.util.Logger.d(io.dcloud.common.adapter.util.Logger.ANIMATION_TAG, "createAnimSet_update not webview mode fromXDelta=" + i4 + ";toXDelta=" + i8 + ";fromYDelta=" + i5 + ";toYDelta=" + i9);
                ofFloat(animatorSet, adaFrameItem, com.taobao.weex.common.Constants.Name.X, (float) i4, (float) i8);
                ofFloat(animatorSet, adaFrameItem, com.taobao.weex.common.Constants.Name.Y, (float) i5, (float) i9);
            }
        }
        if (z) {
            float f = this.sScreenWidth;
            float f2 = i6 / f;
            int i12 = i3;
            float f3 = i12 / f;
            int i13 = i2;
            float f4 = this.sScreenHeight;
            int i14 = i;
            io.dcloud.common.adapter.util.Logger.d(io.dcloud.common.adapter.util.Logger.ANIMATION_TAG, "width (" + f2 + ";=" + f3 + ");height(" + (i13 / f4) + "," + (i14 / f4) + com.taobao.weex.el.parse.Operators.BRACKET_END_STR);
            ofInt(animatorSet, adaFrameItem, "width", i6, i12);
            ofInt(animatorSet, adaFrameItem, "height", i13, i14);
        }
        setTimingFunction(animatorSet);
        animatorSet.setDuration(this.duration);
        return animatorSet;
    }

    private void setTimingFunction(io.dcloud.nineoldandroids.animation.Animator animator) {
        java.lang.String lowerCase = (io.dcloud.common.util.PdrUtil.isEmpty(this.timingfunction) ? "linear" : this.timingfunction).toLowerCase(java.util.Locale.ENGLISH);
        io.dcloud.common.adapter.util.Logger.d(TAG, "timingfunction = " + lowerCase);
        if (io.dcloud.common.util.PdrUtil.isEquals("ease-in", lowerCase)) {
            animator.setInterpolator(new android.view.animation.AccelerateInterpolator(1.5f));
            return;
        }
        if (io.dcloud.common.util.PdrUtil.isEquals("ease-out", lowerCase)) {
            animator.setInterpolator(new android.view.animation.DecelerateInterpolator(1.5f));
        } else if (io.dcloud.common.util.PdrUtil.isEquals("linear", lowerCase)) {
            animator.setInterpolator(new android.view.animation.LinearInterpolator());
        } else {
            animator.setInterpolator(new android.view.animation.AccelerateDecelerateInterpolator());
        }
    }

    private final io.dcloud.nineoldandroids.animation.AnimatorSet showOrHideShowAnimator(io.dcloud.common.adapter.ui.AdaFrameItem adaFrameItem, io.dcloud.common.adapter.util.ViewOptions viewOptions, io.dcloud.common.adapter.util.ViewOptions viewOptions2, io.dcloud.common.adapter.util.ViewOptions viewOptions3) {
        java.lang.String str = io.dcloud.common.util.PdrUtil.isEmpty(this.mAnimType) ? "none" : this.mAnimType;
        io.dcloud.nineoldandroids.animation.AnimatorSet animatorSet = new io.dcloud.nineoldandroids.animation.AnimatorSet();
        io.dcloud.common.adapter.util.Logger.d(io.dcloud.common.adapter.util.Logger.ANIMATION_TAG, "showOrHideShowAnimator _animType=" + str);
        if (io.dcloud.common.util.PdrUtil.isEquals(str, ANIM_ZOOM_OUT)) {
            ofFloat(animatorSet, adaFrameItem, "scaleX", 0.0f, 1.0f);
            ofFloat(animatorSet, adaFrameItem, "scaleY", 0.0f, 1.0f);
        } else if (!io.dcloud.common.util.PdrUtil.isEquals(str, ANIM_PAGE_FORWARD)) {
            if (io.dcloud.common.util.PdrUtil.isEquals(str, ANIM_ZOOM_FADE_OUT)) {
                ofFloat(animatorSet, adaFrameItem, "scaleX", 0.8f, 1.0f);
                ofFloat(animatorSet, adaFrameItem, "scaleY", 0.8f, 1.0f);
                ofFloat(animatorSet, adaFrameItem, "alpha", 0.0f, 1.0f);
            } else if (io.dcloud.common.util.PdrUtil.isEquals(str, ANIM_FADE_IN)) {
                android.view.animation.AnimationSet animationSet = new android.view.animation.AnimationSet(false);
                animationSet.addAnimation(new android.view.animation.AlphaAnimation(0.0f, 1.0f));
                this.mAnimator = animationSet;
                animationSet.setDuration(this.duration_show);
            } else {
                int i = viewOptions.anim_left;
                int i2 = viewOptions.anim_top;
                int x = viewOptions2.anim_left;
                int i3 = viewOptions2.anim_top;
                io.dcloud.common.adapter.util.Logger.d(io.dcloud.common.adapter.util.Logger.ANIMATION_TAG, "showOrHideShowAnimator _animType=" + str + ";fromXDelta=" + i + ";toXDelta=" + x + ";fromYDelta=" + i2 + ";toYDelta=" + i3);
                if (io.dcloud.common.util.PdrUtil.isEquals(str, ANIM_FLIP_X)) {
                    ofFloat(animatorSet, adaFrameItem, "rotationX", -90.0f, 0.0f);
                } else if (io.dcloud.common.util.PdrUtil.isEquals(str, ANIM_FLIP_RX)) {
                    ofFloat(animatorSet, adaFrameItem, "rotationX", 0.0f, 90.0f);
                } else if (io.dcloud.common.util.PdrUtil.isEquals(str, ANIM_FLIP_Y)) {
                    ofFloat(animatorSet, adaFrameItem, "rotationY", -90.0f, 0.0f);
                } else if (io.dcloud.common.util.PdrUtil.isEquals(str, ANIM_FLIP_RY)) {
                    ofFloat(animatorSet, adaFrameItem, "rotationY", 0.0f, 90.0f);
                } else if (io.dcloud.common.util.PdrUtil.isEquals(str, ANIM_SLIDE_IN_RIGHT)) {
                    float f = x;
                    if (io.dcloud.nineoldandroids.view.ViewHelper.getX(adaFrameItem.obtainMainView()) <= f) {
                        x = (int) (f - io.dcloud.nineoldandroids.view.ViewHelper.getX(adaFrameItem.obtainMainView()));
                    }
                    android.view.animation.TranslateAnimation translateAnimation = new android.view.animation.TranslateAnimation(i, x, 0.0f, 0.0f);
                    this.mAnimator = translateAnimation;
                    translateAnimation.setInterpolator(new android.view.animation.DecelerateInterpolator());
                    this.mAnimator.setDuration(this.duration_show);
                } else if (io.dcloud.common.util.PdrUtil.isEquals(str, ANIM_POP_IN)) {
                    this.mAnimator = android.view.animation.AnimationUtils.loadAnimation(adaFrameItem.getContext(), io.dcloud.base.R.anim.dcloud_page_open_enter);
                } else if (io.dcloud.common.util.PdrUtil.isEquals(str, ANIM_SLIDE_IN_LEFT)) {
                    ofFloat(animatorSet, adaFrameItem, com.taobao.weex.common.Constants.Name.X, i, x);
                } else if (io.dcloud.common.util.PdrUtil.isEquals(str, ANIM_SLIDE_IN_TOP) || io.dcloud.common.util.PdrUtil.isEquals(str, ANIM_SLIDE_IN_BOTTOM)) {
                    ofFloat(animatorSet, adaFrameItem, com.taobao.weex.common.Constants.Name.Y, i2, i3);
                }
            }
        }
        setTimingFunction(animatorSet);
        animatorSet.setDuration(this.duration_show);
        return animatorSet;
    }

    public io.dcloud.nineoldandroids.animation.Animator createAnimation() {
        this.mAnimator = null;
        try {
            if (this.mUserFrameItem.obtainFrameOptions_Animate() == null && this.mOption != 2) {
                this.mUserFrameItem.makeViewOptions_animate();
            }
            if (this.mAnimMode != io.dcloud.common.adapter.util.AnimOptions.AnimMode.CUSTOM) {
                byte b = this.mOption;
                if (2 == b) {
                    io.dcloud.common.adapter.ui.AdaFrameItem adaFrameItemObtainWebviewParent = isUseBackground() ? ((io.dcloud.common.DHInterface.IFrameView) this.mUserFrameItem).obtainWebviewParent() : this.mUserFrameItem;
                    return setStyleOptionAnimator(adaFrameItemObtainWebviewParent, adaFrameItemObtainWebviewParent.obtainFrameOptions(), adaFrameItemObtainWebviewParent.obtainFrameOptions_Animate(), adaFrameItemObtainWebviewParent.obtainFrameOptions_Birth());
                }
                if (b != 0 && b != 4) {
                    if (1 != b) {
                        if (3 == b) {
                        }
                    }
                    io.dcloud.common.adapter.ui.AdaFrameItem adaFrameItem = this.mUserFrameItem;
                    return closeOrHideAnimator(adaFrameItem, adaFrameItem.obtainFrameOptions(), this.mUserFrameItem.obtainFrameOptions_Animate(), this.mUserFrameItem.obtainFrameOptions_Birth());
                }
                io.dcloud.common.adapter.ui.AdaFrameItem adaFrameItem2 = this.mUserFrameItem;
                return showOrHideShowAnimator(adaFrameItem2, adaFrameItem2.obtainFrameOptions(), this.mUserFrameItem.obtainFrameOptions_Animate(), this.mUserFrameItem.obtainFrameOptions_Birth());
            }
            return null;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    boolean isUseBackground() {
        return this.mUserFrameItem.obtainFrameOptions().background != -1;
    }

    io.dcloud.nineoldandroids.animation.ObjectAnimator ofFloat(io.dcloud.nineoldandroids.animation.AnimatorSet animatorSet, java.lang.Object obj, java.lang.String str, float... fArr) {
        if (fArr[0] == fArr[1]) {
            return null;
        }
        io.dcloud.nineoldandroids.animation.ObjectAnimator objectAnimator = new io.dcloud.nineoldandroids.animation.ObjectAnimator();
        objectAnimator.setPropertyName(str);
        objectAnimator.setFloatValues(fArr);
        animatorSet.playTogether(objectAnimator);
        return objectAnimator;
    }

    io.dcloud.nineoldandroids.animation.ObjectAnimator ofInt(io.dcloud.nineoldandroids.animation.AnimatorSet animatorSet, java.lang.Object obj, java.lang.String str, int... iArr) {
        if (iArr[0] == iArr[1]) {
            return null;
        }
        io.dcloud.nineoldandroids.animation.ObjectAnimator objectAnimator = new io.dcloud.nineoldandroids.animation.ObjectAnimator();
        objectAnimator.setPropertyName(str);
        objectAnimator.setIntValues(iArr);
        animatorSet.playTogether(objectAnimator);
        return objectAnimator;
    }

    public void parseTransform(org.json.JSONObject jSONObject) {
    }

    public void parseTransition(org.json.JSONObject jSONObject) {
        java.lang.String string = io.dcloud.common.util.JSONUtil.getString(jSONObject, "duration");
        if (string != null && string.toLowerCase(java.util.Locale.ENGLISH).endsWith("ms")) {
            string = string.substring(0, string.length() - 2);
        }
        this.duration = io.dcloud.common.util.PdrUtil.parseInt(string, this.duration);
        this.timingfunction = io.dcloud.common.util.JSONUtil.getString(jSONObject, io.dcloud.common.constant.AbsoluteConst.TRANS_TIMING_FUNCTION);
    }

    public void setCloseAnimType(java.lang.String str) {
        if (io.dcloud.common.util.PdrUtil.isEquals("auto", str)) {
            this.mAnimType_close = mAnimTypes.get(this.mAnimType);
            return;
        }
        this.mAnimType_close = str;
        if (mAnimTypes.containsValue(str)) {
            return;
        }
        this.mAnimType_close = "none";
    }
}
