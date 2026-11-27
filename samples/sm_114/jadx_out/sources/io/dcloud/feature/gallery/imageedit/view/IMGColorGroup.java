package io.dcloud.feature.gallery.imageedit.view;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class IMGColorGroup extends android.widget.RadioGroup {
    public IMGColorGroup(android.content.Context context) {
        super(context);
    }

    public int getCheckColor() {
        io.dcloud.feature.gallery.imageedit.view.IMGColorRadio iMGColorRadio = (io.dcloud.feature.gallery.imageedit.view.IMGColorRadio) findViewById(getCheckedRadioButtonId());
        if (iMGColorRadio != null) {
            return iMGColorRadio.getColor();
        }
        return -1;
    }

    public void setCheckColor(int i) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            io.dcloud.feature.gallery.imageedit.view.IMGColorRadio iMGColorRadio = (io.dcloud.feature.gallery.imageedit.view.IMGColorRadio) getChildAt(i2);
            if (iMGColorRadio.getColor() == i) {
                iMGColorRadio.setChecked(true);
                return;
            }
        }
    }

    public IMGColorGroup(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
