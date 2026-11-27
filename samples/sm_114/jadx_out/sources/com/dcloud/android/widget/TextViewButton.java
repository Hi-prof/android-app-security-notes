package com.dcloud.android.widget;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class TextViewButton extends android.widget.TextView {
    public TextViewButton(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            setBackgroundColor(-3355444);
        } else if (action == 1 || action == 4) {
            setBackgroundColor(-1118482);
        }
        return super.onTouchEvent(motionEvent);
    }
}
