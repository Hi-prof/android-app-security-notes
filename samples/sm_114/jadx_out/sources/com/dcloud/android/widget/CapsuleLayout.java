package com.dcloud.android.widget;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class CapsuleLayout extends android.widget.LinearLayout {
    public static final int STYLE_DARK = 2;
    public static final int STYLE_LIGHT = 1;
    public boolean isDiy;
    public float mAngle;
    public int mBackgroundColor;
    com.dcloud.android.widget.CapsuleLayout.CapsuleDrawable mDrawable;
    private java.util.List<android.view.View> mIntervals;
    public android.graphics.Paint mPaint;
    private int mSelectColor;
    public int mStrokeColor;
    public int mStrokeWidth;
    private int mStyle;

    /* JADX INFO: renamed from: com.dcloud.android.widget.CapsuleLayout$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$dcloud$android$widget$CapsuleLayout$ButtonType;

        static {
            int[] iArr = new int[com.dcloud.android.widget.CapsuleLayout.ButtonType.values().length];
            $SwitchMap$com$dcloud$android$widget$CapsuleLayout$ButtonType = iArr;
            try {
                iArr[com.dcloud.android.widget.CapsuleLayout.ButtonType.LIFT.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dcloud$android$widget$CapsuleLayout$ButtonType[com.dcloud.android.widget.CapsuleLayout.ButtonType.RIGHT.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dcloud$android$widget$CapsuleLayout$ButtonType[com.dcloud.android.widget.CapsuleLayout.ButtonType.MIDDLE.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public enum ButtonType {
        LIFT,
        MIDDLE,
        RIGHT
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private class CapsuleDrawable extends android.graphics.drawable.GradientDrawable {
        private CapsuleDrawable() {
        }

        /* synthetic */ CapsuleDrawable(com.dcloud.android.widget.CapsuleLayout capsuleLayout, com.dcloud.android.widget.CapsuleLayout.AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public CapsuleLayout(android.content.Context context, float f) {
        super(context);
        this.mStyle = 1;
        this.isDiy = false;
        this.mAngle = f;
        this.mIntervals = new java.util.ArrayList();
        setRoundColor(android.graphics.Color.parseColor("#ffffffff"), android.graphics.Color.parseColor("#ffe5e5e5"), 1);
        this.mSelectColor = android.graphics.Color.parseColor("#CBCCCD");
    }

    private void initButtonBackground(android.view.View view, com.dcloud.android.widget.CapsuleLayout.ButtonType buttonType) {
        android.graphics.drawable.StateListDrawable stateListDrawable = new android.graphics.drawable.StateListDrawable();
        com.dcloud.android.widget.CapsuleLayout.AnonymousClass1 anonymousClass1 = null;
        com.dcloud.android.widget.CapsuleLayout.CapsuleDrawable capsuleDrawable = new com.dcloud.android.widget.CapsuleLayout.CapsuleDrawable(this, anonymousClass1);
        com.dcloud.android.widget.CapsuleLayout.CapsuleDrawable capsuleDrawable2 = new com.dcloud.android.widget.CapsuleLayout.CapsuleDrawable(this, anonymousClass1);
        float[] fArr = new float[0];
        int i = com.dcloud.android.widget.CapsuleLayout.AnonymousClass1.$SwitchMap$com$dcloud$android$widget$CapsuleLayout$ButtonType[buttonType.ordinal()];
        if (i == 1) {
            float f = this.mAngle;
            fArr = new float[]{f, f, 0.0f, 0.0f, 0.0f, 0.0f, f, f};
            capsuleDrawable2.setStroke(this.mStrokeWidth, 0);
        } else if (i == 2) {
            float f2 = this.mAngle;
            fArr = new float[]{0.0f, 0.0f, f2, f2, f2, f2, 0.0f, 0.0f};
            capsuleDrawable2.setStroke(this.mStrokeWidth, 0);
        } else if (i == 3) {
            fArr = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        }
        capsuleDrawable2.setCornerRadii(fArr);
        capsuleDrawable.setCornerRadii(fArr);
        capsuleDrawable.setColor(0);
        capsuleDrawable2.setColor(this.mSelectColor);
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed, android.R.attr.state_enabled}, capsuleDrawable2);
        stateListDrawable.addState(new int[]{android.R.attr.state_enabled, android.R.attr.state_focused}, capsuleDrawable2);
        stateListDrawable.addState(new int[]{android.R.attr.state_enabled}, capsuleDrawable);
        stateListDrawable.addState(new int[]{android.R.attr.state_focused}, capsuleDrawable2);
        stateListDrawable.addState(new int[]{android.R.attr.state_window_focused}, capsuleDrawable2);
        stateListDrawable.addState(new int[0], capsuleDrawable);
        view.setBackground(stateListDrawable);
    }

    private void updateBackground() {
        if (this.mDrawable == null) {
            com.dcloud.android.widget.CapsuleLayout.CapsuleDrawable capsuleDrawable = new com.dcloud.android.widget.CapsuleLayout.CapsuleDrawable(this, null);
            this.mDrawable = capsuleDrawable;
            setBackground(capsuleDrawable);
        }
        this.mDrawable.setCornerRadius(this.mAngle);
        this.mDrawable.setStroke(this.mStrokeWidth, this.mStrokeColor);
        this.mDrawable.setColor(this.mBackgroundColor);
        this.mDrawable.invalidateSelf();
    }

    private void updateIntervalColor() {
        java.util.Iterator<android.view.View> it = this.mIntervals.iterator();
        while (it.hasNext()) {
            it.next().setBackgroundColor(this.mStrokeColor);
        }
    }

    public void addButtonView(android.view.View view, android.widget.LinearLayout.LayoutParams layoutParams, com.dcloud.android.widget.CapsuleLayout.ButtonType buttonType, android.view.View.OnClickListener onClickListener) {
        android.widget.LinearLayout.LayoutParams layoutParams2 = new android.widget.LinearLayout.LayoutParams(-1, -1);
        layoutParams2.weight = 1.0f;
        layoutParams2.gravity = 17;
        android.widget.LinearLayout linearLayout = new android.widget.LinearLayout(getContext());
        linearLayout.addView(view, layoutParams);
        addView(linearLayout, layoutParams2);
        linearLayout.setOnClickListener(onClickListener);
        initButtonBackground(linearLayout, buttonType);
    }

    public void addIntervalView(float f) {
        android.view.View view = new android.view.View(getContext());
        view.setBackgroundColor(this.mStrokeColor);
        addView(view, new android.widget.LinearLayout.LayoutParams(this.mStrokeWidth, (int) (f * 18.0f)));
        this.mIntervals.add(view);
    }

    public int checkColorToStyle(int i) {
        if (this.isDiy) {
            return 1;
        }
        int i2 = (i >> 16) & 255;
        int i3 = (i >> 8) & 255;
        int i4 = i & 255;
        if (i2 <= 235 || i3 <= 235 || i4 <= 235) {
            if (this.mStyle == 1) {
                this.mStyle = 2;
                setRoundColor(android.graphics.Color.parseColor("#1a000000"), android.graphics.Color.parseColor("#4de5e5e5"), 1);
                updateIntervalColor();
            }
        } else if (this.mStyle == 2) {
            this.mStyle = 1;
            setRoundColor(android.graphics.Color.parseColor("#ffffffff"), android.graphics.Color.parseColor("#ffe5e5e5"), 1);
            updateIntervalColor();
        }
        return this.mStyle;
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        this.mIntervals.clear();
    }

    public void setAngle(float f) {
        this.mAngle = f;
        updateBackground();
    }

    @Override // android.view.View
    public void setBackground(android.graphics.drawable.Drawable drawable) {
        if (drawable instanceof com.dcloud.android.widget.CapsuleLayout.CapsuleDrawable) {
            super.setBackground(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.mBackgroundColor = i;
        updateBackground();
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
    }

    public void setButtonSelectColor(android.view.View view, com.dcloud.android.widget.CapsuleLayout.ButtonType buttonType, int i) {
        if (view == null || view.getParent() == null) {
            return;
        }
        this.mSelectColor = i;
        initButtonBackground((android.view.View) view.getParent(), buttonType);
    }

    public void setRoundColor(int i, int i2, int i3) {
        this.mBackgroundColor = i;
        this.mStrokeColor = i2;
        this.mStrokeWidth = i3;
        updateBackground();
    }

    public void setRoundColor(int i) {
        this.mStrokeColor = i;
        updateBackground();
    }
}
