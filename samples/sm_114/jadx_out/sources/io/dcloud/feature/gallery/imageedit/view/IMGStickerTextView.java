package io.dcloud.feature.gallery.imageedit.view;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class IMGStickerTextView extends io.dcloud.feature.gallery.imageedit.view.IMGStickerView implements io.dcloud.feature.gallery.imageedit.b.a {
    private static float p = -1.0f;
    private android.widget.TextView m;
    private io.dcloud.p.r2 n;
    private io.dcloud.feature.gallery.imageedit.b o;

    public IMGStickerTextView(android.content.Context context) {
        this(context, null, 0);
    }

    private io.dcloud.feature.gallery.imageedit.b getDialog() {
        if (this.o == null) {
            this.o = new io.dcloud.feature.gallery.imageedit.b(getContext(), this);
        }
        return this.o;
    }

    @Override // io.dcloud.feature.gallery.imageedit.view.IMGStickerView
    public android.view.View a(android.content.Context context) {
        android.widget.TextView textView = new android.widget.TextView(context);
        this.m = textView;
        textView.setTextSize(p);
        this.m.setPadding(26, 26, 26, 26);
        this.m.setTextColor(-1);
        return this.m;
    }

    @Override // io.dcloud.feature.gallery.imageedit.view.IMGStickerView
    public void b(android.content.Context context) {
        if (p <= 0.0f) {
            p = android.util.TypedValue.applyDimension(2, 24.0f, context.getResources().getDisplayMetrics());
        }
        super.b(context);
    }

    @Override // io.dcloud.feature.gallery.imageedit.view.IMGStickerView
    public void c() {
        io.dcloud.feature.gallery.imageedit.b dialog = getDialog();
        dialog.a(this.n);
        dialog.show();
    }

    public io.dcloud.p.r2 getText() {
        return this.n;
    }

    public void setText(io.dcloud.p.r2 r2Var) {
        android.widget.TextView textView;
        this.n = r2Var;
        if (r2Var == null || (textView = this.m) == null) {
            return;
        }
        textView.setText(r2Var.c());
        this.m.setTextColor(this.n.b());
        this.m.setBackgroundColor(this.n.a());
    }

    public IMGStickerTextView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IMGStickerTextView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // io.dcloud.feature.gallery.imageedit.b.a
    public void a(io.dcloud.p.r2 r2Var) {
        android.widget.TextView textView;
        this.n = r2Var;
        if (r2Var == null || (textView = this.m) == null) {
            return;
        }
        textView.setText(r2Var.c());
        this.m.setTextColor(this.n.b());
        this.m.setBackgroundColor(this.n.a());
    }
}
