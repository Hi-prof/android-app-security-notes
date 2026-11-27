package io.dcloud.feature.weex.adapter;

/* JADX INFO: loaded from: classes2.dex */
public class FrescoDrawableLoader implements com.taobao.weex.adapter.IDrawableLoader {
    private android.content.Context mContext;

    public FrescoDrawableLoader(android.content.Context context) {
        this.mContext = context;
    }

    @Override // com.taobao.weex.adapter.IDrawableLoader
    public void setDrawable(java.lang.String str, final com.taobao.weex.adapter.IDrawableLoader.DrawableTarget drawableTarget, com.taobao.weex.adapter.DrawableStrategy drawableStrategy) {
        io.dcloud.feature.weex.adapter.FrescoLoadUtil.getInstance().loadImageBitmap(this.mContext, str, drawableStrategy.width, drawableStrategy.height, new io.dcloud.feature.uniapp.utils.bitmap.BitmapLoadCallback<android.graphics.Bitmap>() { // from class: io.dcloud.feature.weex.adapter.FrescoDrawableLoader.1
            @Override // io.dcloud.feature.uniapp.utils.bitmap.BitmapLoadCallback
            public void onFailure(java.lang.String str2, java.lang.Throwable th) {
            }

            @Override // io.dcloud.feature.uniapp.utils.bitmap.BitmapLoadCallback
            public void onSuccess(java.lang.String str2, android.graphics.Bitmap bitmap) {
                android.graphics.drawable.BitmapDrawable bitmapDrawable = new android.graphics.drawable.BitmapDrawable(io.dcloud.feature.weex.adapter.FrescoDrawableLoader.this.mContext.getResources(), bitmap);
                bitmapDrawable.setGravity(119);
                drawableTarget.setDrawable(bitmapDrawable, true);
            }
        });
    }
}
