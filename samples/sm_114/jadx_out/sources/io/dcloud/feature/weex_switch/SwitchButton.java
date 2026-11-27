package io.dcloud.feature.weex_switch;

/* JADX INFO: loaded from: classes2.dex */
public class SwitchButton extends android.view.View implements android.widget.Checkable {
    private final int ANIMATE_STATE_DRAGING;
    private final int ANIMATE_STATE_NONE;
    private final int ANIMATE_STATE_PENDING_DRAG;
    private final int ANIMATE_STATE_PENDING_RESET;
    private final int ANIMATE_STATE_PENDING_SETTLE;
    private final int ANIMATE_STATE_SWITCH;
    private io.dcloud.feature.weex_switch.SwitchButton.ViewState afterState;
    private int animateState;
    private android.animation.Animator.AnimatorListener animatorListener;
    private android.animation.ValueAnimator.AnimatorUpdateListener animatorUpdateListener;
    private final android.animation.ArgbEvaluator argbEvaluator;
    private int background;
    private io.dcloud.feature.weex_switch.SwitchButton.ViewState beforeState;
    private int borderWidth;
    private float bottom;
    private float buttonMaxX;
    private float buttonMinX;
    private android.graphics.Paint buttonPaint;
    private float buttonRadius;
    private float centerX;
    private float centerY;
    private int checkLineColor;
    private float checkLineLength;
    private int checkLineWidth;
    private int checkedColor;
    private float checkedLineOffsetX;
    private float checkedLineOffsetY;
    private float dragFraction;
    private boolean enableEffect;
    private float height;
    private boolean isChecked;
    private boolean isEventBroadcast;
    private boolean isInit;
    private boolean isTouchingDown;
    private boolean isUiInited;
    private float left;
    private io.dcloud.feature.weex_switch.SwitchButton.OnCheckedChangeListener onCheckedChangeListener;
    private android.graphics.Paint paint;
    private java.lang.Runnable postPendingDrag;
    private android.graphics.RectF rect;
    private float right;
    private int shadowColor;
    private boolean shadowEffect;
    private int shadowOffset;
    private int shadowRadius;
    private boolean showIndicator;
    private float top;
    private long touchDownTime;
    private int uncheckCircleColor;
    private float uncheckCircleOffsetX;
    private float uncheckCircleRadius;
    private int uncheckCircleWidth;
    private int uncheckColor;
    private android.animation.ValueAnimator valueAnimator;
    private float viewRadius;
    private io.dcloud.feature.weex_switch.SwitchButton.ViewState viewState;
    private float width;
    private static final int DEFAULT_WIDTH = dp2pxInt(58.0f);
    private static final int DEFAULT_HEIGHT = dp2pxInt(36.0f);

    public interface OnCheckedChangeListener {
        void onCheckedChanged(io.dcloud.feature.weex_switch.SwitchButton switchButton, boolean z);
    }

    @Override // android.view.View
    public final void setOnClickListener(android.view.View.OnClickListener onClickListener) {
    }

    @Override // android.view.View
    public final void setOnLongClickListener(android.view.View.OnLongClickListener onLongClickListener) {
    }

    public SwitchButton(android.content.Context context) {
        super(context);
        this.ANIMATE_STATE_NONE = 0;
        this.ANIMATE_STATE_PENDING_DRAG = 1;
        this.ANIMATE_STATE_DRAGING = 2;
        this.ANIMATE_STATE_PENDING_RESET = 3;
        this.ANIMATE_STATE_PENDING_SETTLE = 4;
        this.ANIMATE_STATE_SWITCH = 5;
        this.isInit = true;
        this.rect = new android.graphics.RectF();
        this.animateState = 0;
        this.argbEvaluator = new android.animation.ArgbEvaluator();
        this.isTouchingDown = false;
        this.isUiInited = false;
        this.isEventBroadcast = false;
        this.postPendingDrag = new java.lang.Runnable() { // from class: io.dcloud.feature.weex_switch.SwitchButton.1
            @Override // java.lang.Runnable
            public void run() {
                if (io.dcloud.feature.weex_switch.SwitchButton.this.isInAnimating()) {
                    return;
                }
                io.dcloud.feature.weex_switch.SwitchButton.this.pendingDragState();
            }
        };
        this.animatorUpdateListener = new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: io.dcloud.feature.weex_switch.SwitchButton.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                float fFloatValue = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
                int i = io.dcloud.feature.weex_switch.SwitchButton.this.animateState;
                if (i == 1 || i == 3 || i == 4) {
                    io.dcloud.feature.weex_switch.SwitchButton.this.viewState.checkedLineColor = ((java.lang.Integer) io.dcloud.feature.weex_switch.SwitchButton.this.argbEvaluator.evaluate(fFloatValue, java.lang.Integer.valueOf(io.dcloud.feature.weex_switch.SwitchButton.this.beforeState.checkedLineColor), java.lang.Integer.valueOf(io.dcloud.feature.weex_switch.SwitchButton.this.afterState.checkedLineColor))).intValue();
                    io.dcloud.feature.weex_switch.SwitchButton.this.viewState.radius = io.dcloud.feature.weex_switch.SwitchButton.this.beforeState.radius + ((io.dcloud.feature.weex_switch.SwitchButton.this.afterState.radius - io.dcloud.feature.weex_switch.SwitchButton.this.beforeState.radius) * fFloatValue);
                    if (io.dcloud.feature.weex_switch.SwitchButton.this.animateState != 1) {
                        io.dcloud.feature.weex_switch.SwitchButton.this.viewState.buttonX = io.dcloud.feature.weex_switch.SwitchButton.this.beforeState.buttonX + ((io.dcloud.feature.weex_switch.SwitchButton.this.afterState.buttonX - io.dcloud.feature.weex_switch.SwitchButton.this.beforeState.buttonX) * fFloatValue);
                    }
                    io.dcloud.feature.weex_switch.SwitchButton.this.viewState.checkStateColor = ((java.lang.Integer) io.dcloud.feature.weex_switch.SwitchButton.this.argbEvaluator.evaluate(fFloatValue, java.lang.Integer.valueOf(io.dcloud.feature.weex_switch.SwitchButton.this.beforeState.checkStateColor), java.lang.Integer.valueOf(io.dcloud.feature.weex_switch.SwitchButton.this.afterState.checkStateColor))).intValue();
                } else if (i == 5) {
                    io.dcloud.feature.weex_switch.SwitchButton.this.viewState.buttonX = io.dcloud.feature.weex_switch.SwitchButton.this.beforeState.buttonX + ((io.dcloud.feature.weex_switch.SwitchButton.this.afterState.buttonX - io.dcloud.feature.weex_switch.SwitchButton.this.beforeState.buttonX) * fFloatValue);
                    float f = (io.dcloud.feature.weex_switch.SwitchButton.this.viewState.buttonX - io.dcloud.feature.weex_switch.SwitchButton.this.buttonMinX) / (io.dcloud.feature.weex_switch.SwitchButton.this.buttonMaxX - io.dcloud.feature.weex_switch.SwitchButton.this.buttonMinX);
                    io.dcloud.feature.weex_switch.SwitchButton.this.viewState.checkStateColor = ((java.lang.Integer) io.dcloud.feature.weex_switch.SwitchButton.this.argbEvaluator.evaluate(f, java.lang.Integer.valueOf(io.dcloud.feature.weex_switch.SwitchButton.this.uncheckColor), java.lang.Integer.valueOf(io.dcloud.feature.weex_switch.SwitchButton.this.checkedColor))).intValue();
                    io.dcloud.feature.weex_switch.SwitchButton.this.viewState.radius = io.dcloud.feature.weex_switch.SwitchButton.this.viewRadius * f;
                    io.dcloud.feature.weex_switch.SwitchButton.this.viewState.checkedLineColor = ((java.lang.Integer) io.dcloud.feature.weex_switch.SwitchButton.this.argbEvaluator.evaluate(f, 0, java.lang.Integer.valueOf(io.dcloud.feature.weex_switch.SwitchButton.this.checkLineColor))).intValue();
                }
                io.dcloud.feature.weex_switch.SwitchButton.this.postInvalidate();
            }
        };
        this.animatorListener = new android.animation.Animator.AnimatorListener() { // from class: io.dcloud.feature.weex_switch.SwitchButton.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(android.animation.Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(android.animation.Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(android.animation.Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                int i = io.dcloud.feature.weex_switch.SwitchButton.this.animateState;
                if (i == 1) {
                    io.dcloud.feature.weex_switch.SwitchButton.this.animateState = 2;
                    io.dcloud.feature.weex_switch.SwitchButton.this.viewState.checkedLineColor = 0;
                    io.dcloud.feature.weex_switch.SwitchButton.this.viewState.radius = io.dcloud.feature.weex_switch.SwitchButton.this.viewRadius;
                    io.dcloud.feature.weex_switch.SwitchButton.this.postInvalidate();
                    return;
                }
                if (i == 3) {
                    io.dcloud.feature.weex_switch.SwitchButton.this.animateState = 0;
                    io.dcloud.feature.weex_switch.SwitchButton.this.postInvalidate();
                    return;
                }
                if (i == 4) {
                    io.dcloud.feature.weex_switch.SwitchButton.this.animateState = 0;
                    io.dcloud.feature.weex_switch.SwitchButton.this.postInvalidate();
                    io.dcloud.feature.weex_switch.SwitchButton.this.broadcastEvent();
                } else {
                    if (i != 5) {
                        return;
                    }
                    io.dcloud.feature.weex_switch.SwitchButton switchButton = io.dcloud.feature.weex_switch.SwitchButton.this;
                    switchButton.isChecked = true ^ switchButton.isChecked;
                    io.dcloud.feature.weex_switch.SwitchButton.this.animateState = 0;
                    io.dcloud.feature.weex_switch.SwitchButton.this.postInvalidate();
                    io.dcloud.feature.weex_switch.SwitchButton.this.broadcastEvent();
                }
            }
        };
        init(context, null);
    }

    public SwitchButton(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ANIMATE_STATE_NONE = 0;
        this.ANIMATE_STATE_PENDING_DRAG = 1;
        this.ANIMATE_STATE_DRAGING = 2;
        this.ANIMATE_STATE_PENDING_RESET = 3;
        this.ANIMATE_STATE_PENDING_SETTLE = 4;
        this.ANIMATE_STATE_SWITCH = 5;
        this.isInit = true;
        this.rect = new android.graphics.RectF();
        this.animateState = 0;
        this.argbEvaluator = new android.animation.ArgbEvaluator();
        this.isTouchingDown = false;
        this.isUiInited = false;
        this.isEventBroadcast = false;
        this.postPendingDrag = new java.lang.Runnable() { // from class: io.dcloud.feature.weex_switch.SwitchButton.1
            @Override // java.lang.Runnable
            public void run() {
                if (io.dcloud.feature.weex_switch.SwitchButton.this.isInAnimating()) {
                    return;
                }
                io.dcloud.feature.weex_switch.SwitchButton.this.pendingDragState();
            }
        };
        this.animatorUpdateListener = new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: io.dcloud.feature.weex_switch.SwitchButton.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                float fFloatValue = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
                int i = io.dcloud.feature.weex_switch.SwitchButton.this.animateState;
                if (i == 1 || i == 3 || i == 4) {
                    io.dcloud.feature.weex_switch.SwitchButton.this.viewState.checkedLineColor = ((java.lang.Integer) io.dcloud.feature.weex_switch.SwitchButton.this.argbEvaluator.evaluate(fFloatValue, java.lang.Integer.valueOf(io.dcloud.feature.weex_switch.SwitchButton.this.beforeState.checkedLineColor), java.lang.Integer.valueOf(io.dcloud.feature.weex_switch.SwitchButton.this.afterState.checkedLineColor))).intValue();
                    io.dcloud.feature.weex_switch.SwitchButton.this.viewState.radius = io.dcloud.feature.weex_switch.SwitchButton.this.beforeState.radius + ((io.dcloud.feature.weex_switch.SwitchButton.this.afterState.radius - io.dcloud.feature.weex_switch.SwitchButton.this.beforeState.radius) * fFloatValue);
                    if (io.dcloud.feature.weex_switch.SwitchButton.this.animateState != 1) {
                        io.dcloud.feature.weex_switch.SwitchButton.this.viewState.buttonX = io.dcloud.feature.weex_switch.SwitchButton.this.beforeState.buttonX + ((io.dcloud.feature.weex_switch.SwitchButton.this.afterState.buttonX - io.dcloud.feature.weex_switch.SwitchButton.this.beforeState.buttonX) * fFloatValue);
                    }
                    io.dcloud.feature.weex_switch.SwitchButton.this.viewState.checkStateColor = ((java.lang.Integer) io.dcloud.feature.weex_switch.SwitchButton.this.argbEvaluator.evaluate(fFloatValue, java.lang.Integer.valueOf(io.dcloud.feature.weex_switch.SwitchButton.this.beforeState.checkStateColor), java.lang.Integer.valueOf(io.dcloud.feature.weex_switch.SwitchButton.this.afterState.checkStateColor))).intValue();
                } else if (i == 5) {
                    io.dcloud.feature.weex_switch.SwitchButton.this.viewState.buttonX = io.dcloud.feature.weex_switch.SwitchButton.this.beforeState.buttonX + ((io.dcloud.feature.weex_switch.SwitchButton.this.afterState.buttonX - io.dcloud.feature.weex_switch.SwitchButton.this.beforeState.buttonX) * fFloatValue);
                    float f = (io.dcloud.feature.weex_switch.SwitchButton.this.viewState.buttonX - io.dcloud.feature.weex_switch.SwitchButton.this.buttonMinX) / (io.dcloud.feature.weex_switch.SwitchButton.this.buttonMaxX - io.dcloud.feature.weex_switch.SwitchButton.this.buttonMinX);
                    io.dcloud.feature.weex_switch.SwitchButton.this.viewState.checkStateColor = ((java.lang.Integer) io.dcloud.feature.weex_switch.SwitchButton.this.argbEvaluator.evaluate(f, java.lang.Integer.valueOf(io.dcloud.feature.weex_switch.SwitchButton.this.uncheckColor), java.lang.Integer.valueOf(io.dcloud.feature.weex_switch.SwitchButton.this.checkedColor))).intValue();
                    io.dcloud.feature.weex_switch.SwitchButton.this.viewState.radius = io.dcloud.feature.weex_switch.SwitchButton.this.viewRadius * f;
                    io.dcloud.feature.weex_switch.SwitchButton.this.viewState.checkedLineColor = ((java.lang.Integer) io.dcloud.feature.weex_switch.SwitchButton.this.argbEvaluator.evaluate(f, 0, java.lang.Integer.valueOf(io.dcloud.feature.weex_switch.SwitchButton.this.checkLineColor))).intValue();
                }
                io.dcloud.feature.weex_switch.SwitchButton.this.postInvalidate();
            }
        };
        this.animatorListener = new android.animation.Animator.AnimatorListener() { // from class: io.dcloud.feature.weex_switch.SwitchButton.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(android.animation.Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(android.animation.Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(android.animation.Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                int i = io.dcloud.feature.weex_switch.SwitchButton.this.animateState;
                if (i == 1) {
                    io.dcloud.feature.weex_switch.SwitchButton.this.animateState = 2;
                    io.dcloud.feature.weex_switch.SwitchButton.this.viewState.checkedLineColor = 0;
                    io.dcloud.feature.weex_switch.SwitchButton.this.viewState.radius = io.dcloud.feature.weex_switch.SwitchButton.this.viewRadius;
                    io.dcloud.feature.weex_switch.SwitchButton.this.postInvalidate();
                    return;
                }
                if (i == 3) {
                    io.dcloud.feature.weex_switch.SwitchButton.this.animateState = 0;
                    io.dcloud.feature.weex_switch.SwitchButton.this.postInvalidate();
                    return;
                }
                if (i == 4) {
                    io.dcloud.feature.weex_switch.SwitchButton.this.animateState = 0;
                    io.dcloud.feature.weex_switch.SwitchButton.this.postInvalidate();
                    io.dcloud.feature.weex_switch.SwitchButton.this.broadcastEvent();
                } else {
                    if (i != 5) {
                        return;
                    }
                    io.dcloud.feature.weex_switch.SwitchButton switchButton = io.dcloud.feature.weex_switch.SwitchButton.this;
                    switchButton.isChecked = true ^ switchButton.isChecked;
                    io.dcloud.feature.weex_switch.SwitchButton.this.animateState = 0;
                    io.dcloud.feature.weex_switch.SwitchButton.this.postInvalidate();
                    io.dcloud.feature.weex_switch.SwitchButton.this.broadcastEvent();
                }
            }
        };
        init(context, attributeSet);
    }

    public SwitchButton(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ANIMATE_STATE_NONE = 0;
        this.ANIMATE_STATE_PENDING_DRAG = 1;
        this.ANIMATE_STATE_DRAGING = 2;
        this.ANIMATE_STATE_PENDING_RESET = 3;
        this.ANIMATE_STATE_PENDING_SETTLE = 4;
        this.ANIMATE_STATE_SWITCH = 5;
        this.isInit = true;
        this.rect = new android.graphics.RectF();
        this.animateState = 0;
        this.argbEvaluator = new android.animation.ArgbEvaluator();
        this.isTouchingDown = false;
        this.isUiInited = false;
        this.isEventBroadcast = false;
        this.postPendingDrag = new java.lang.Runnable() { // from class: io.dcloud.feature.weex_switch.SwitchButton.1
            @Override // java.lang.Runnable
            public void run() {
                if (io.dcloud.feature.weex_switch.SwitchButton.this.isInAnimating()) {
                    return;
                }
                io.dcloud.feature.weex_switch.SwitchButton.this.pendingDragState();
            }
        };
        this.animatorUpdateListener = new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: io.dcloud.feature.weex_switch.SwitchButton.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                float fFloatValue = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
                int i2 = io.dcloud.feature.weex_switch.SwitchButton.this.animateState;
                if (i2 == 1 || i2 == 3 || i2 == 4) {
                    io.dcloud.feature.weex_switch.SwitchButton.this.viewState.checkedLineColor = ((java.lang.Integer) io.dcloud.feature.weex_switch.SwitchButton.this.argbEvaluator.evaluate(fFloatValue, java.lang.Integer.valueOf(io.dcloud.feature.weex_switch.SwitchButton.this.beforeState.checkedLineColor), java.lang.Integer.valueOf(io.dcloud.feature.weex_switch.SwitchButton.this.afterState.checkedLineColor))).intValue();
                    io.dcloud.feature.weex_switch.SwitchButton.this.viewState.radius = io.dcloud.feature.weex_switch.SwitchButton.this.beforeState.radius + ((io.dcloud.feature.weex_switch.SwitchButton.this.afterState.radius - io.dcloud.feature.weex_switch.SwitchButton.this.beforeState.radius) * fFloatValue);
                    if (io.dcloud.feature.weex_switch.SwitchButton.this.animateState != 1) {
                        io.dcloud.feature.weex_switch.SwitchButton.this.viewState.buttonX = io.dcloud.feature.weex_switch.SwitchButton.this.beforeState.buttonX + ((io.dcloud.feature.weex_switch.SwitchButton.this.afterState.buttonX - io.dcloud.feature.weex_switch.SwitchButton.this.beforeState.buttonX) * fFloatValue);
                    }
                    io.dcloud.feature.weex_switch.SwitchButton.this.viewState.checkStateColor = ((java.lang.Integer) io.dcloud.feature.weex_switch.SwitchButton.this.argbEvaluator.evaluate(fFloatValue, java.lang.Integer.valueOf(io.dcloud.feature.weex_switch.SwitchButton.this.beforeState.checkStateColor), java.lang.Integer.valueOf(io.dcloud.feature.weex_switch.SwitchButton.this.afterState.checkStateColor))).intValue();
                } else if (i2 == 5) {
                    io.dcloud.feature.weex_switch.SwitchButton.this.viewState.buttonX = io.dcloud.feature.weex_switch.SwitchButton.this.beforeState.buttonX + ((io.dcloud.feature.weex_switch.SwitchButton.this.afterState.buttonX - io.dcloud.feature.weex_switch.SwitchButton.this.beforeState.buttonX) * fFloatValue);
                    float f = (io.dcloud.feature.weex_switch.SwitchButton.this.viewState.buttonX - io.dcloud.feature.weex_switch.SwitchButton.this.buttonMinX) / (io.dcloud.feature.weex_switch.SwitchButton.this.buttonMaxX - io.dcloud.feature.weex_switch.SwitchButton.this.buttonMinX);
                    io.dcloud.feature.weex_switch.SwitchButton.this.viewState.checkStateColor = ((java.lang.Integer) io.dcloud.feature.weex_switch.SwitchButton.this.argbEvaluator.evaluate(f, java.lang.Integer.valueOf(io.dcloud.feature.weex_switch.SwitchButton.this.uncheckColor), java.lang.Integer.valueOf(io.dcloud.feature.weex_switch.SwitchButton.this.checkedColor))).intValue();
                    io.dcloud.feature.weex_switch.SwitchButton.this.viewState.radius = io.dcloud.feature.weex_switch.SwitchButton.this.viewRadius * f;
                    io.dcloud.feature.weex_switch.SwitchButton.this.viewState.checkedLineColor = ((java.lang.Integer) io.dcloud.feature.weex_switch.SwitchButton.this.argbEvaluator.evaluate(f, 0, java.lang.Integer.valueOf(io.dcloud.feature.weex_switch.SwitchButton.this.checkLineColor))).intValue();
                }
                io.dcloud.feature.weex_switch.SwitchButton.this.postInvalidate();
            }
        };
        this.animatorListener = new android.animation.Animator.AnimatorListener() { // from class: io.dcloud.feature.weex_switch.SwitchButton.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(android.animation.Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(android.animation.Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(android.animation.Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                int i2 = io.dcloud.feature.weex_switch.SwitchButton.this.animateState;
                if (i2 == 1) {
                    io.dcloud.feature.weex_switch.SwitchButton.this.animateState = 2;
                    io.dcloud.feature.weex_switch.SwitchButton.this.viewState.checkedLineColor = 0;
                    io.dcloud.feature.weex_switch.SwitchButton.this.viewState.radius = io.dcloud.feature.weex_switch.SwitchButton.this.viewRadius;
                    io.dcloud.feature.weex_switch.SwitchButton.this.postInvalidate();
                    return;
                }
                if (i2 == 3) {
                    io.dcloud.feature.weex_switch.SwitchButton.this.animateState = 0;
                    io.dcloud.feature.weex_switch.SwitchButton.this.postInvalidate();
                    return;
                }
                if (i2 == 4) {
                    io.dcloud.feature.weex_switch.SwitchButton.this.animateState = 0;
                    io.dcloud.feature.weex_switch.SwitchButton.this.postInvalidate();
                    io.dcloud.feature.weex_switch.SwitchButton.this.broadcastEvent();
                } else {
                    if (i2 != 5) {
                        return;
                    }
                    io.dcloud.feature.weex_switch.SwitchButton switchButton = io.dcloud.feature.weex_switch.SwitchButton.this;
                    switchButton.isChecked = true ^ switchButton.isChecked;
                    io.dcloud.feature.weex_switch.SwitchButton.this.animateState = 0;
                    io.dcloud.feature.weex_switch.SwitchButton.this.postInvalidate();
                    io.dcloud.feature.weex_switch.SwitchButton.this.broadcastEvent();
                }
            }
        };
        init(context, attributeSet);
    }

    public SwitchButton(android.content.Context context, android.util.AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.ANIMATE_STATE_NONE = 0;
        this.ANIMATE_STATE_PENDING_DRAG = 1;
        this.ANIMATE_STATE_DRAGING = 2;
        this.ANIMATE_STATE_PENDING_RESET = 3;
        this.ANIMATE_STATE_PENDING_SETTLE = 4;
        this.ANIMATE_STATE_SWITCH = 5;
        this.isInit = true;
        this.rect = new android.graphics.RectF();
        this.animateState = 0;
        this.argbEvaluator = new android.animation.ArgbEvaluator();
        this.isTouchingDown = false;
        this.isUiInited = false;
        this.isEventBroadcast = false;
        this.postPendingDrag = new java.lang.Runnable() { // from class: io.dcloud.feature.weex_switch.SwitchButton.1
            @Override // java.lang.Runnable
            public void run() {
                if (io.dcloud.feature.weex_switch.SwitchButton.this.isInAnimating()) {
                    return;
                }
                io.dcloud.feature.weex_switch.SwitchButton.this.pendingDragState();
            }
        };
        this.animatorUpdateListener = new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: io.dcloud.feature.weex_switch.SwitchButton.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                float fFloatValue = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
                int i3 = io.dcloud.feature.weex_switch.SwitchButton.this.animateState;
                if (i3 == 1 || i3 == 3 || i3 == 4) {
                    io.dcloud.feature.weex_switch.SwitchButton.this.viewState.checkedLineColor = ((java.lang.Integer) io.dcloud.feature.weex_switch.SwitchButton.this.argbEvaluator.evaluate(fFloatValue, java.lang.Integer.valueOf(io.dcloud.feature.weex_switch.SwitchButton.this.beforeState.checkedLineColor), java.lang.Integer.valueOf(io.dcloud.feature.weex_switch.SwitchButton.this.afterState.checkedLineColor))).intValue();
                    io.dcloud.feature.weex_switch.SwitchButton.this.viewState.radius = io.dcloud.feature.weex_switch.SwitchButton.this.beforeState.radius + ((io.dcloud.feature.weex_switch.SwitchButton.this.afterState.radius - io.dcloud.feature.weex_switch.SwitchButton.this.beforeState.radius) * fFloatValue);
                    if (io.dcloud.feature.weex_switch.SwitchButton.this.animateState != 1) {
                        io.dcloud.feature.weex_switch.SwitchButton.this.viewState.buttonX = io.dcloud.feature.weex_switch.SwitchButton.this.beforeState.buttonX + ((io.dcloud.feature.weex_switch.SwitchButton.this.afterState.buttonX - io.dcloud.feature.weex_switch.SwitchButton.this.beforeState.buttonX) * fFloatValue);
                    }
                    io.dcloud.feature.weex_switch.SwitchButton.this.viewState.checkStateColor = ((java.lang.Integer) io.dcloud.feature.weex_switch.SwitchButton.this.argbEvaluator.evaluate(fFloatValue, java.lang.Integer.valueOf(io.dcloud.feature.weex_switch.SwitchButton.this.beforeState.checkStateColor), java.lang.Integer.valueOf(io.dcloud.feature.weex_switch.SwitchButton.this.afterState.checkStateColor))).intValue();
                } else if (i3 == 5) {
                    io.dcloud.feature.weex_switch.SwitchButton.this.viewState.buttonX = io.dcloud.feature.weex_switch.SwitchButton.this.beforeState.buttonX + ((io.dcloud.feature.weex_switch.SwitchButton.this.afterState.buttonX - io.dcloud.feature.weex_switch.SwitchButton.this.beforeState.buttonX) * fFloatValue);
                    float f = (io.dcloud.feature.weex_switch.SwitchButton.this.viewState.buttonX - io.dcloud.feature.weex_switch.SwitchButton.this.buttonMinX) / (io.dcloud.feature.weex_switch.SwitchButton.this.buttonMaxX - io.dcloud.feature.weex_switch.SwitchButton.this.buttonMinX);
                    io.dcloud.feature.weex_switch.SwitchButton.this.viewState.checkStateColor = ((java.lang.Integer) io.dcloud.feature.weex_switch.SwitchButton.this.argbEvaluator.evaluate(f, java.lang.Integer.valueOf(io.dcloud.feature.weex_switch.SwitchButton.this.uncheckColor), java.lang.Integer.valueOf(io.dcloud.feature.weex_switch.SwitchButton.this.checkedColor))).intValue();
                    io.dcloud.feature.weex_switch.SwitchButton.this.viewState.radius = io.dcloud.feature.weex_switch.SwitchButton.this.viewRadius * f;
                    io.dcloud.feature.weex_switch.SwitchButton.this.viewState.checkedLineColor = ((java.lang.Integer) io.dcloud.feature.weex_switch.SwitchButton.this.argbEvaluator.evaluate(f, 0, java.lang.Integer.valueOf(io.dcloud.feature.weex_switch.SwitchButton.this.checkLineColor))).intValue();
                }
                io.dcloud.feature.weex_switch.SwitchButton.this.postInvalidate();
            }
        };
        this.animatorListener = new android.animation.Animator.AnimatorListener() { // from class: io.dcloud.feature.weex_switch.SwitchButton.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(android.animation.Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(android.animation.Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(android.animation.Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                int i3 = io.dcloud.feature.weex_switch.SwitchButton.this.animateState;
                if (i3 == 1) {
                    io.dcloud.feature.weex_switch.SwitchButton.this.animateState = 2;
                    io.dcloud.feature.weex_switch.SwitchButton.this.viewState.checkedLineColor = 0;
                    io.dcloud.feature.weex_switch.SwitchButton.this.viewState.radius = io.dcloud.feature.weex_switch.SwitchButton.this.viewRadius;
                    io.dcloud.feature.weex_switch.SwitchButton.this.postInvalidate();
                    return;
                }
                if (i3 == 3) {
                    io.dcloud.feature.weex_switch.SwitchButton.this.animateState = 0;
                    io.dcloud.feature.weex_switch.SwitchButton.this.postInvalidate();
                    return;
                }
                if (i3 == 4) {
                    io.dcloud.feature.weex_switch.SwitchButton.this.animateState = 0;
                    io.dcloud.feature.weex_switch.SwitchButton.this.postInvalidate();
                    io.dcloud.feature.weex_switch.SwitchButton.this.broadcastEvent();
                } else {
                    if (i3 != 5) {
                        return;
                    }
                    io.dcloud.feature.weex_switch.SwitchButton switchButton = io.dcloud.feature.weex_switch.SwitchButton.this;
                    switchButton.isChecked = true ^ switchButton.isChecked;
                    io.dcloud.feature.weex_switch.SwitchButton.this.animateState = 0;
                    io.dcloud.feature.weex_switch.SwitchButton.this.postInvalidate();
                    io.dcloud.feature.weex_switch.SwitchButton.this.broadcastEvent();
                }
            }
        };
        init(context, attributeSet);
    }

    @Override // android.view.View
    public final void setPadding(int i, int i2, int i3, int i4) {
        super.setPadding(0, 0, 0, 0);
    }

    private void init(android.content.Context context, android.util.AttributeSet attributeSet) {
        this.dragFraction = 0.5f;
        android.content.res.TypedArray typedArrayObtainStyledAttributes = attributeSet != null ? context.obtainStyledAttributes(attributeSet, com.taobao.weex.R.styleable.SwitchButton) : null;
        this.shadowEffect = optBoolean(typedArrayObtainStyledAttributes, com.taobao.weex.R.styleable.SwitchButton_sb_shadow_effect, true);
        this.uncheckCircleColor = optColor(typedArrayObtainStyledAttributes, com.taobao.weex.R.styleable.SwitchButton_sb_uncheckcircle_color, 0);
        this.uncheckCircleWidth = optPixelSize(typedArrayObtainStyledAttributes, com.taobao.weex.R.styleable.SwitchButton_sb_uncheckcircle_width, dp2pxInt(1.5f));
        this.uncheckCircleOffsetX = dp2px(10.0f);
        this.uncheckCircleRadius = optPixelSize(typedArrayObtainStyledAttributes, com.taobao.weex.R.styleable.SwitchButton_sb_uncheckcircle_radius, dp2px(4.0f));
        this.checkedLineOffsetX = dp2px(4.0f);
        this.checkedLineOffsetY = dp2px(4.0f);
        this.shadowRadius = optPixelSize(typedArrayObtainStyledAttributes, com.taobao.weex.R.styleable.SwitchButton_sb_shadow_radius, dp2pxInt(2.0f));
        this.shadowOffset = optPixelSize(typedArrayObtainStyledAttributes, com.taobao.weex.R.styleable.SwitchButton_sb_shadow_offset, dp2pxInt(0.0f));
        this.shadowColor = optColor(typedArrayObtainStyledAttributes, com.taobao.weex.R.styleable.SwitchButton_sb_shadow_color, 855638016);
        this.uncheckColor = optColor(typedArrayObtainStyledAttributes, com.taobao.weex.R.styleable.SwitchButton_sb_uncheck_color, -2236963);
        this.checkedColor = optColor(typedArrayObtainStyledAttributes, com.taobao.weex.R.styleable.SwitchButton_sb_checked_color, -16466430);
        this.borderWidth = optPixelSize(typedArrayObtainStyledAttributes, com.taobao.weex.R.styleable.SwitchButton_sb_border_width, dp2pxInt(1.0f));
        this.checkLineColor = optColor(typedArrayObtainStyledAttributes, com.taobao.weex.R.styleable.SwitchButton_sb_checkline_color, 0);
        this.checkLineWidth = optPixelSize(typedArrayObtainStyledAttributes, com.taobao.weex.R.styleable.SwitchButton_sb_checkline_width, dp2pxInt(0.0f));
        this.checkLineLength = dp2px(0.0f);
        int iOptColor = optColor(typedArrayObtainStyledAttributes, com.taobao.weex.R.styleable.SwitchButton_sb_button_color, -1);
        int iOptInt = optInt(typedArrayObtainStyledAttributes, com.taobao.weex.R.styleable.SwitchButton_sb_effect_duration, 200);
        this.isChecked = optBoolean(typedArrayObtainStyledAttributes, com.taobao.weex.R.styleable.SwitchButton_sb_checked, false);
        this.showIndicator = optBoolean(typedArrayObtainStyledAttributes, com.taobao.weex.R.styleable.SwitchButton_sb_show_indicator, true);
        this.background = optColor(typedArrayObtainStyledAttributes, com.taobao.weex.R.styleable.SwitchButton_sb_background, -1);
        this.enableEffect = optBoolean(typedArrayObtainStyledAttributes, com.taobao.weex.R.styleable.SwitchButton_sb_enable_effect, true);
        if (typedArrayObtainStyledAttributes != null) {
            typedArrayObtainStyledAttributes.recycle();
        }
        android.graphics.Paint paint = new android.graphics.Paint(1);
        this.paint = paint;
        paint.setAntiAlias(true);
        android.graphics.Paint paint2 = new android.graphics.Paint(1);
        this.buttonPaint = paint2;
        paint2.setAntiAlias(true);
        this.buttonPaint.setColor(iOptColor);
        if (this.shadowEffect) {
            this.buttonPaint.setShadowLayer(this.shadowRadius, 0.0f, this.shadowOffset, this.shadowColor);
        }
        this.viewState = new io.dcloud.feature.weex_switch.SwitchButton.ViewState();
        this.beforeState = new io.dcloud.feature.weex_switch.SwitchButton.ViewState();
        this.afterState = new io.dcloud.feature.weex_switch.SwitchButton.ViewState();
        android.animation.ValueAnimator valueAnimatorOfFloat = android.animation.ValueAnimator.ofFloat(0.0f, 1.0f);
        this.valueAnimator = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(iOptInt);
        this.valueAnimator.setRepeatCount(0);
        this.valueAnimator.addUpdateListener(this.animatorUpdateListener);
        this.valueAnimator.addListener(this.animatorListener);
        super.setClickable(true);
        setPadding(0, 0, 0, 0);
        setLayerType(1, null);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = android.view.View.MeasureSpec.getMode(i);
        int mode2 = android.view.View.MeasureSpec.getMode(i2);
        if (mode == 0 || mode == Integer.MIN_VALUE) {
            i = android.view.View.MeasureSpec.makeMeasureSpec(DEFAULT_WIDTH, 1073741824);
        }
        if (mode2 == 0 || mode2 == Integer.MIN_VALUE) {
            i2 = android.view.View.MeasureSpec.makeMeasureSpec(DEFAULT_HEIGHT, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    public float getShadowBottomSize() {
        return ((this.shadowRadius + this.shadowOffset) - this.borderWidth) - 2.0f;
    }

    public float getShadowLeftSize() {
        return (this.shadowRadius - this.borderWidth) - 2.0f;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        int i5 = this.shadowRadius + this.shadowOffset;
        int i6 = this.borderWidth;
        float f = i2 - (i5 - i6);
        this.height = f;
        float f2 = i;
        this.width = f2;
        float f3 = f * 0.5f;
        this.viewRadius = f3;
        this.buttonRadius = f3 - i6;
        float f4 = i6 / 2.0f;
        this.left = f4;
        float f5 = i6 / 2.0f;
        this.top = f5;
        float f6 = f2 - (i6 / 2.0f);
        this.right = f6;
        float f7 = f - (i6 / 2.0f);
        this.bottom = f7;
        this.centerX = (f6 + f4) * 0.5f;
        this.centerY = (f5 + f7) * 0.5f;
        this.buttonMinX = (f4 / 2.0f) + f3;
        this.buttonMaxX = ((f2 - (i6 / 2.0f)) + ((i6 / 2.0f) / 2.0f)) - f3;
        if (isChecked()) {
            setCheckedViewState(this.viewState);
        } else {
            setUncheckViewState(this.viewState);
        }
        this.isUiInited = true;
        postInvalidate();
    }

    private void setUncheckViewState(io.dcloud.feature.weex_switch.SwitchButton.ViewState viewState) {
        viewState.radius = 0.0f;
        viewState.checkStateColor = this.uncheckColor;
        viewState.checkedLineColor = 0;
        viewState.buttonX = this.buttonMinX;
    }

    private void setCheckedViewState(io.dcloud.feature.weex_switch.SwitchButton.ViewState viewState) {
        viewState.radius = this.viewRadius;
        viewState.checkStateColor = this.checkedColor;
        viewState.checkedLineColor = this.checkLineColor;
        viewState.buttonX = this.buttonMaxX;
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        this.paint.setStrokeWidth(this.borderWidth);
        this.paint.setStyle(android.graphics.Paint.Style.FILL);
        this.paint.setColor(this.background);
        drawRoundRect(canvas, this.left, this.top, this.right, this.bottom, this.viewRadius, this.paint);
        float f = this.viewState.radius * 0.5f;
        this.paint.setStyle(android.graphics.Paint.Style.STROKE);
        this.paint.setColor(this.viewState.checkStateColor);
        this.paint.setStrokeWidth(this.borderWidth + (f * 2.0f));
        drawRoundRect(canvas, this.left + f, this.top + f, this.right - f, this.bottom - f, this.viewRadius, this.paint);
        this.paint.setStyle(android.graphics.Paint.Style.FILL);
        this.paint.setStrokeWidth(1.0f);
        float f2 = this.left;
        float f3 = this.top;
        float f4 = this.viewRadius;
        drawArc(canvas, f2, f3, (f4 * 2.0f) + f2, ((f4 * 2.0f) + f3) - this.borderWidth, 90.0f, 180.0f, this.paint);
        canvas.drawRect(this.viewRadius + this.left, this.top, this.viewState.buttonX, (this.top + (this.viewRadius * 2.0f)) - this.borderWidth, this.paint);
        drawButton(canvas, this.viewState.buttonX, this.centerY);
    }

    protected void drawCheckedIndicator(android.graphics.Canvas canvas) {
        int i = this.viewState.checkedLineColor;
        float f = this.checkLineWidth;
        float f2 = this.left;
        float f3 = this.viewRadius;
        float f4 = (f2 + f3) - this.checkedLineOffsetX;
        float f5 = this.centerY;
        float f6 = this.checkLineLength;
        drawCheckedIndicator(canvas, i, f, f4, f5 - f6, (f2 + f3) - this.checkedLineOffsetY, f5 + f6, this.paint);
    }

    protected void drawCheckedIndicator(android.graphics.Canvas canvas, int i, float f, float f2, float f3, float f4, float f5, android.graphics.Paint paint) {
        paint.setStyle(android.graphics.Paint.Style.STROKE);
        paint.setColor(i);
        paint.setStrokeWidth(f);
        canvas.drawLine(f2, f3, f4, f5, paint);
    }

    private void drawUncheckIndicator(android.graphics.Canvas canvas) {
        drawUncheckIndicator(canvas, this.uncheckCircleColor, this.uncheckCircleWidth, this.right - this.uncheckCircleOffsetX, this.centerY, this.uncheckCircleRadius, this.paint);
    }

    protected void drawUncheckIndicator(android.graphics.Canvas canvas, int i, float f, float f2, float f3, float f4, android.graphics.Paint paint) {
        paint.setStyle(android.graphics.Paint.Style.STROKE);
        paint.setColor(i);
        paint.setStrokeWidth(f);
        canvas.drawCircle(f2, f3, f4, paint);
    }

    private void drawArc(android.graphics.Canvas canvas, float f, float f2, float f3, float f4, float f5, float f6, android.graphics.Paint paint) {
        canvas.drawArc(f, f2, f3, f4, f5, f6, true, paint);
    }

    private void drawRoundRect(android.graphics.Canvas canvas, float f, float f2, float f3, float f4, float f5, android.graphics.Paint paint) {
        canvas.drawRoundRect(f, f2, f3, f4, f5, f5, paint);
    }

    private void drawButton(android.graphics.Canvas canvas, float f, float f2) {
        canvas.drawCircle(f, f2, this.buttonRadius, this.buttonPaint);
        this.paint.setStyle(android.graphics.Paint.Style.STROKE);
        this.paint.setStrokeWidth(1.0f);
        this.paint.setColor(-2236963);
        canvas.drawCircle(f, f2, this.buttonRadius, this.paint);
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (isEnabled() || this.isInit) {
            if (z == isChecked()) {
                postInvalidate();
                this.isInit = false;
                return;
            }
            toggle(this.enableEffect, false);
        }
        this.isInit = false;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.isChecked;
    }

    @Override // android.widget.Checkable
    public void toggle() {
        toggle(true);
    }

    public void toggle(boolean z) {
        toggle(z, true);
    }

    public void setCheckedColor(int i) {
        this.checkedColor = i;
    }

    private void toggle(boolean z, boolean z2) {
        if ((isChecked() && this.dragFraction != 1.0f) || (!isChecked() && this.dragFraction != 0.0f)) {
            if (isEnabled() || this.isInit) {
                if (this.isEventBroadcast) {
                    throw new java.lang.RuntimeException("should NOT switch the state in method: [onCheckedChanged]!");
                }
                if (!this.isUiInited) {
                    this.isChecked = !this.isChecked;
                    if (z2) {
                        broadcastEvent();
                        return;
                    }
                    return;
                }
                if (this.valueAnimator.isRunning()) {
                    this.valueAnimator.cancel();
                }
                if (!this.enableEffect || !z) {
                    this.isChecked = !this.isChecked;
                    if (isChecked()) {
                        setCheckedViewState(this.viewState);
                    } else {
                        setUncheckViewState(this.viewState);
                    }
                    postInvalidate();
                    if (z2) {
                        broadcastEvent();
                        return;
                    }
                    return;
                }
                this.animateState = 5;
                this.beforeState.copy(this.viewState);
                if (isChecked()) {
                    io.dcloud.common.adapter.util.Logger.d("ACTION_MOVE", "isChecked true =========== " + this.dragFraction);
                    setUncheckViewState(this.afterState);
                } else {
                    io.dcloud.common.adapter.util.Logger.d("ACTION_MOVE", "isChecked false =========== " + this.dragFraction);
                    setCheckedViewState(this.afterState);
                }
                this.valueAnimator.start();
                return;
            }
            return;
        }
        pendingCancelDragState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void broadcastEvent() {
        io.dcloud.feature.weex_switch.SwitchButton.OnCheckedChangeListener onCheckedChangeListener = this.onCheckedChangeListener;
        if (onCheckedChangeListener != null) {
            this.isEventBroadcast = true;
            onCheckedChangeListener.onCheckedChanged(this, isChecked());
        }
        this.isEventBroadcast = false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            io.dcloud.common.adapter.util.Logger.d("ACTION_MOVE", "ACTION_DOWN =========== " + this.dragFraction);
            this.dragFraction = 0.5f;
            this.isTouchingDown = true;
            this.touchDownTime = java.lang.System.currentTimeMillis();
            removeCallbacks(this.postPendingDrag);
            postDelayed(this.postPendingDrag, 100L);
        } else if (actionMasked == 1) {
            this.isTouchingDown = false;
            removeCallbacks(this.postPendingDrag);
            if (java.lang.System.currentTimeMillis() - this.touchDownTime <= 400) {
                toggle();
            } else if (isDragState()) {
                boolean z = java.lang.Math.max(0.0f, java.lang.Math.min(1.0f, motionEvent.getX() / ((float) getWidth()))) > 0.5f;
                if (z == isChecked()) {
                    pendingCancelDragState();
                } else {
                    this.isChecked = z;
                    pendingSettleState();
                }
            } else if (isPendingDragState()) {
                pendingCancelDragState();
            }
        } else if (actionMasked == 2) {
            float x = motionEvent.getX();
            if (isPendingDragState()) {
                float width = x / getWidth();
                this.dragFraction = width;
                this.dragFraction = java.lang.Math.max(0.0f, java.lang.Math.min(1.0f, width));
                io.dcloud.common.adapter.util.Logger.d("ACTION_MOVE", "isPendingDragState =========== " + this.dragFraction);
                io.dcloud.feature.weex_switch.SwitchButton.ViewState viewState = this.viewState;
                float f = this.buttonMinX;
                viewState.buttonX = f + ((this.buttonMaxX - f) * this.dragFraction);
            } else if (isDragState()) {
                float width2 = x / getWidth();
                this.dragFraction = width2;
                this.dragFraction = java.lang.Math.max(0.0f, java.lang.Math.min(1.0f, width2));
                io.dcloud.common.adapter.util.Logger.d("ACTION_MOVE", "isDragState =========== " + this.dragFraction);
                io.dcloud.feature.weex_switch.SwitchButton.ViewState viewState2 = this.viewState;
                float f2 = this.buttonMinX;
                viewState2.buttonX = f2 + ((this.buttonMaxX - f2) * this.dragFraction);
                this.viewState.checkStateColor = ((java.lang.Integer) this.argbEvaluator.evaluate(this.dragFraction, java.lang.Integer.valueOf(this.uncheckColor), java.lang.Integer.valueOf(this.checkedColor))).intValue();
                postInvalidate();
            }
        } else if (actionMasked == 3) {
            this.isTouchingDown = false;
            removeCallbacks(this.postPendingDrag);
            if (isPendingDragState() || isDragState()) {
                pendingCancelDragState();
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isInAnimating() {
        return this.animateState != 0;
    }

    private boolean isPendingDragState() {
        int i = this.animateState;
        return i == 1 || i == 3;
    }

    private boolean isDragState() {
        return this.animateState == 2;
    }

    public void setShadowEffect(boolean z) {
        if (this.shadowEffect == z) {
            return;
        }
        this.shadowEffect = z;
        if (z) {
            this.buttonPaint.setShadowLayer(this.shadowRadius, 0.0f, this.shadowOffset, this.shadowColor);
        } else {
            this.buttonPaint.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        }
    }

    public void setEnableEffect(boolean z) {
        this.enableEffect = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pendingDragState() {
        if (!isInAnimating() && this.isTouchingDown) {
            if (this.valueAnimator.isRunning()) {
                this.valueAnimator.cancel();
            }
            this.animateState = 1;
            this.beforeState.copy(this.viewState);
            this.afterState.copy(this.viewState);
            if (isChecked()) {
                this.afterState.checkStateColor = this.checkedColor;
                this.afterState.buttonX = this.buttonMaxX;
                this.afterState.checkedLineColor = this.checkedColor;
            } else {
                this.afterState.checkStateColor = this.uncheckColor;
                this.afterState.buttonX = this.buttonMinX;
                this.afterState.radius = this.viewRadius;
            }
            this.valueAnimator.start();
        }
    }

    private void pendingCancelDragState() {
        if (isDragState() || isPendingDragState()) {
            if (this.valueAnimator.isRunning()) {
                this.valueAnimator.cancel();
            }
            this.animateState = 3;
            this.beforeState.copy(this.viewState);
            if (isChecked()) {
                setCheckedViewState(this.afterState);
            } else {
                setUncheckViewState(this.afterState);
            }
            this.valueAnimator.start();
        }
    }

    private void pendingSettleState() {
        if (this.valueAnimator.isRunning()) {
            this.valueAnimator.cancel();
        }
        this.animateState = 4;
        this.beforeState.copy(this.viewState);
        if (isChecked()) {
            setCheckedViewState(this.afterState);
        } else {
            setUncheckViewState(this.afterState);
        }
        this.valueAnimator.start();
    }

    public void setOnCheckedChangeListener(io.dcloud.feature.weex_switch.SwitchButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.onCheckedChangeListener = onCheckedChangeListener;
    }

    private static float dp2px(float f) {
        return android.util.TypedValue.applyDimension(1, f, android.content.res.Resources.getSystem().getDisplayMetrics());
    }

    private static int dp2pxInt(float f) {
        return (int) dp2px(f);
    }

    private static int optInt(android.content.res.TypedArray typedArray, int i, int i2) {
        return typedArray == null ? i2 : typedArray.getInt(i, i2);
    }

    private static float optPixelSize(android.content.res.TypedArray typedArray, int i, float f) {
        return typedArray == null ? f : typedArray.getDimension(i, f);
    }

    private static int optPixelSize(android.content.res.TypedArray typedArray, int i, int i2) {
        return typedArray == null ? i2 : typedArray.getDimensionPixelOffset(i, i2);
    }

    private static int optColor(android.content.res.TypedArray typedArray, int i, int i2) {
        return typedArray == null ? i2 : typedArray.getColor(i, i2);
    }

    private static boolean optBoolean(android.content.res.TypedArray typedArray, int i, boolean z) {
        return typedArray == null ? z : typedArray.getBoolean(i, z);
    }

    private static class ViewState {
        float buttonX;
        int checkStateColor;
        int checkedLineColor;
        float radius;

        ViewState() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void copy(io.dcloud.feature.weex_switch.SwitchButton.ViewState viewState) {
            this.buttonX = viewState.buttonX;
            this.checkStateColor = viewState.checkStateColor;
            this.checkedLineColor = viewState.checkedLineColor;
            this.radius = viewState.radius;
        }
    }
}
