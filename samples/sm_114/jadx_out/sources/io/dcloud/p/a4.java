package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class a4 {
    private static io.dcloud.p.a4 g;
    android.content.Context e;
    int a = -16777216;
    int b = -16777216;
    int c = -16777216;
    int d = 17;
    java.lang.String f = "isSelected";

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class a extends android.text.style.ClickableSpan {
        final /* synthetic */ android.text.style.URLSpan a;

        a(android.text.style.URLSpan uRLSpan) {
            this.a = uRLSpan;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(android.view.View view) {
            try {
                java.lang.String url = this.a.getURL();
                android.content.Intent intent = new android.content.Intent();
                intent.setClass(io.dcloud.p.a4.this.e, io.dcloud.WebviewActivity.class);
                intent.putExtra("url", url);
                intent.setData(android.net.Uri.parse(url));
                intent.setAction("android.intent.action.VIEW");
                intent.setFlags(268435456);
                intent.putExtra("ANIM", "POP");
                io.dcloud.p.a4.this.e.startActivity(intent, androidx.core.app.ActivityOptionsCompat.makeCustomAnimation(io.dcloud.p.a4.this.e, io.dcloud.base.R.anim.dcloud_pop_in, io.dcloud.base.R.anim.dcloud_pop_in_out).toBundle());
            } catch (java.lang.Exception unused) {
            }
        }
    }

    public a4(android.content.Context context) {
        this.e = context;
    }

    public static io.dcloud.p.a4 a(android.content.Context context) {
        if (g == null) {
            g = new io.dcloud.p.a4(context);
        }
        return g;
    }

    public java.lang.CharSequence a(java.lang.String str) {
        android.text.Spanned spannedFromHtml = android.text.Html.fromHtml(str);
        android.text.SpannableStringBuilder spannableStringBuilder = new android.text.SpannableStringBuilder(spannedFromHtml);
        for (android.text.style.URLSpan uRLSpan : (android.text.style.URLSpan[]) spannableStringBuilder.getSpans(0, spannedFromHtml.length(), android.text.style.URLSpan.class)) {
            a(spannableStringBuilder, uRLSpan);
        }
        return spannableStringBuilder;
    }

    private void a(android.text.SpannableStringBuilder spannableStringBuilder, android.text.style.URLSpan uRLSpan) {
        int spanStart = spannableStringBuilder.getSpanStart(uRLSpan);
        int spanEnd = spannableStringBuilder.getSpanEnd(uRLSpan);
        spannableStringBuilder.setSpan(new io.dcloud.p.a4.a(uRLSpan), spanStart, spanEnd, spannableStringBuilder.getSpanFlags(uRLSpan));
        spannableStringBuilder.setSpan(new android.text.style.TextAppearanceSpan(this.e, io.dcloud.base.R.style.textAppearance), spanStart, spanEnd, 33);
    }
}
