package master.flame.danmaku.danmaku.model.android;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ViewCacheStuffer<VH extends master.flame.danmaku.danmaku.model.android.ViewCacheStuffer.ViewHolder> extends master.flame.danmaku.danmaku.model.android.BaseCacheStuffer {
    public static final int CACHE_VIEW_TYPE = -3;
    public static final int DRAW_VIEW_TYPE = -3;
    public static final int INVALID_TYPE = -1;
    public static final int MEASURE_VIEW_TYPE = -2;
    private android.util.SparseArray<java.util.List<VH>> mViewHolderArray = new android.util.SparseArray<>();
    private final int mMaximumWidthPixels = -1;
    private final int mMaximumHeightPixels = -1;

    @Override // master.flame.danmaku.danmaku.model.android.BaseCacheStuffer
    public void clearCaches() {
    }

    public int getItemViewType(int i, master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku) {
        return 0;
    }

    public abstract void onBindViewHolder(int i, VH vh, master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku, master.flame.danmaku.danmaku.model.android.AndroidDisplayer.DisplayerConfig displayerConfig, android.text.TextPaint textPaint);

    public abstract VH onCreateViewHolder(int i);

    public static abstract class ViewHolder {
        protected final android.view.View itemView;

        public ViewHolder(android.view.View view) {
            if (view == null) {
                throw new java.lang.IllegalArgumentException("itemView may not be null");
            }
            this.itemView = view;
        }

        public void measure(int i, int i2) {
            this.itemView.measure(i, i2);
        }

        public int getMeasureWidth() {
            return this.itemView.getMeasuredWidth();
        }

        public int getMeasureHeight() {
            return this.itemView.getMeasuredHeight();
        }

        public void layout(int i, int i2, int i3, int i4) {
            this.itemView.layout(i, i2, i3, i4);
        }

        public void draw(android.graphics.Canvas canvas, master.flame.danmaku.danmaku.model.android.AndroidDisplayer.DisplayerConfig displayerConfig) {
            this.itemView.draw(canvas);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.android.BaseCacheStuffer
    public void measure(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku, android.text.TextPaint textPaint, boolean z) {
        int itemViewType = getItemViewType(baseDanmaku.index, baseDanmaku);
        java.util.List arrayList = this.mViewHolderArray.get(itemViewType);
        if (arrayList == null) {
            arrayList = new java.util.ArrayList();
            arrayList.add(onCreateViewHolder(itemViewType));
            arrayList.add(onCreateViewHolder(itemViewType));
            arrayList.add(onCreateViewHolder(itemViewType));
            this.mViewHolderArray.put(itemViewType, (java.util.List<VH>) arrayList);
        }
        master.flame.danmaku.danmaku.model.android.ViewCacheStuffer.ViewHolder viewHolder = (master.flame.danmaku.danmaku.model.android.ViewCacheStuffer.ViewHolder) arrayList.get(0);
        onBindViewHolder(itemViewType, viewHolder, baseDanmaku, null, textPaint);
        viewHolder.measure(android.view.View.MeasureSpec.makeMeasureSpec(this.mMaximumWidthPixels, Integer.MIN_VALUE), android.view.View.MeasureSpec.makeMeasureSpec(this.mMaximumHeightPixels, Integer.MIN_VALUE));
        viewHolder.layout(0, 0, viewHolder.getMeasureWidth(), viewHolder.getMeasureHeight());
        baseDanmaku.paintWidth = viewHolder.getMeasureWidth();
        baseDanmaku.paintHeight = viewHolder.getMeasureHeight();
    }

    @Override // master.flame.danmaku.danmaku.model.android.BaseCacheStuffer
    public void releaseResource(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku) {
        super.releaseResource(baseDanmaku);
        baseDanmaku.tag = null;
    }

    @Override // master.flame.danmaku.danmaku.model.android.BaseCacheStuffer
    public void drawDanmaku(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku, android.graphics.Canvas canvas, float f, float f2, boolean z, master.flame.danmaku.danmaku.model.android.AndroidDisplayer.DisplayerConfig displayerConfig) {
        VH vh;
        int itemViewType = getItemViewType(baseDanmaku.index, baseDanmaku);
        java.util.List<VH> list = this.mViewHolderArray.get(itemViewType);
        boolean z2 = true;
        if (list != null) {
            vh = list.get(z ? 1 : 2);
        } else {
            vh = null;
        }
        if (vh == null) {
            return;
        }
        displayerConfig.definePaintParams(z);
        android.text.TextPaint paint = displayerConfig.getPaint(baseDanmaku, z);
        displayerConfig.applyPaintConfig(baseDanmaku, paint, false);
        onBindViewHolder(itemViewType, vh, baseDanmaku, displayerConfig, paint);
        vh.measure(android.view.View.MeasureSpec.makeMeasureSpec(java.lang.Math.round(baseDanmaku.paintWidth), 1073741824), android.view.View.MeasureSpec.makeMeasureSpec(java.lang.Math.round(baseDanmaku.paintHeight), 1073741824));
        if (z) {
            z2 = false;
        } else {
            canvas.save();
            canvas.translate(f, f2);
        }
        if (baseDanmaku.underlineColor != 0) {
            android.graphics.Paint underlinePaint = displayerConfig.getUnderlinePaint(baseDanmaku);
            float f3 = (f2 + baseDanmaku.paintHeight) - displayerConfig.UNDERLINE_HEIGHT;
            canvas.drawLine(f, f3, f + baseDanmaku.paintWidth, f3, underlinePaint);
        }
        if (baseDanmaku.borderColor != 0) {
            canvas.drawRect(f, f2, f + baseDanmaku.paintWidth, f2 + baseDanmaku.paintHeight, displayerConfig.getBorderPaint(baseDanmaku));
        }
        vh.layout(0, 0, (int) baseDanmaku.paintWidth, (int) baseDanmaku.paintHeight);
        vh.draw(canvas, displayerConfig);
        if (z2) {
            canvas.restore();
        }
    }
}
