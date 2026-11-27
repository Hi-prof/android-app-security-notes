package io.dcloud.feature.nativeObj;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class BannerLayout extends android.widget.RelativeLayout {
    public static final java.lang.String CIRCULAR_INDICATOR = "default";
    public static final java.lang.String NONE_INDICATOR = "none";
    public static final java.lang.String WORD_INDICATOR = "number";
    public int MAX_VALUE;
    private int WHAT_AUTO_PLAY;
    private int autoPlayDuration;
    private int currentPosition;
    private android.os.Handler handler;
    private io.dcloud.feature.nativeObj.BannerLayout.ImageLoader imageLoader;
    private android.widget.LinearLayout indicatorContainer;
    private int indicatorMargin;
    private io.dcloud.feature.nativeObj.BannerLayout.Position indicatorPosition;
    private io.dcloud.feature.nativeObj.BannerLayout.Shape indicatorShape;
    private int indicatorSpace;
    private boolean isAllowImageDownload;
    private boolean isAutoPlay;
    private boolean isImageLoop;
    private boolean isImagePhoto;
    private int itemCount;
    private java.lang.String mIndicatorType;
    private java.util.ArrayList<io.dcloud.feature.nativeObj.data.NativeImageDataItem> mUrls;
    private io.dcloud.feature.nativeObj.BannerLayout.OnBannerItemClickListener onBannerItemClickListener;
    private androidx.viewpager.widget.ViewPager pager;
    private int ringIndicatorColor;
    private int scrollDuration;
    private android.graphics.drawable.Drawable selectedDrawable;
    private int selectedIndicatorColor;
    private int selectedIndicatorHeight;
    private int selectedIndicatorWidth;
    private android.graphics.drawable.Drawable unSelectedDrawable;
    private int unSelectedIndicatorColor;
    private int unSelectedIndicatorHeight;
    private int unSelectedIndicatorWidth;

    /* JADX INFO: renamed from: io.dcloud.feature.nativeObj.BannerLayout$6, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] $SwitchMap$io$dcloud$feature$nativeObj$BannerLayout$Position;
        static final /* synthetic */ int[] $SwitchMap$io$dcloud$feature$nativeObj$BannerLayout$Shape;

        static {
            int[] iArr = new int[io.dcloud.feature.nativeObj.BannerLayout.Position.values().length];
            $SwitchMap$io$dcloud$feature$nativeObj$BannerLayout$Position = iArr;
            try {
                iArr[io.dcloud.feature.nativeObj.BannerLayout.Position.centerBottom.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$BannerLayout$Position[io.dcloud.feature.nativeObj.BannerLayout.Position.centerTop.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$BannerLayout$Position[io.dcloud.feature.nativeObj.BannerLayout.Position.leftBottom.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$BannerLayout$Position[io.dcloud.feature.nativeObj.BannerLayout.Position.leftTop.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$BannerLayout$Position[io.dcloud.feature.nativeObj.BannerLayout.Position.rightBottom.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$BannerLayout$Position[io.dcloud.feature.nativeObj.BannerLayout.Position.rightTop.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$BannerLayout$Position[io.dcloud.feature.nativeObj.BannerLayout.Position.none.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
            int[] iArr2 = new int[io.dcloud.feature.nativeObj.BannerLayout.Shape.values().length];
            $SwitchMap$io$dcloud$feature$nativeObj$BannerLayout$Shape = iArr2;
            try {
                iArr2[io.dcloud.feature.nativeObj.BannerLayout.Shape.rect.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$io$dcloud$feature$nativeObj$BannerLayout$Shape[io.dcloud.feature.nativeObj.BannerLayout.Shape.oval.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused9) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public class FixedSpeedScroller extends android.widget.Scroller {
        private int mDuration;

        public FixedSpeedScroller(android.content.Context context) {
            super(context);
            this.mDuration = 1000;
        }

        @Override // android.widget.Scroller
        public void startScroll(int i, int i2, int i3, int i4, int i5) {
            super.startScroll(i, i2, i3, i4, this.mDuration);
        }

        @Override // android.widget.Scroller
        public void startScroll(int i, int i2, int i3, int i4) {
            super.startScroll(i, i2, i3, i4, this.mDuration);
        }

        public FixedSpeedScroller(android.content.Context context, android.view.animation.Interpolator interpolator) {
            super(context, interpolator);
            this.mDuration = 1000;
        }

        public FixedSpeedScroller(io.dcloud.feature.nativeObj.BannerLayout bannerLayout, android.content.Context context, android.view.animation.Interpolator interpolator, int i) {
            this(context, interpolator);
            this.mDuration = i;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface ImageLoader extends java.io.Serializable {
        void displayImage(android.content.Context context, java.lang.String str, android.view.View view, int i);
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private class LoopPagerAdapter extends androidx.viewpager.widget.PagerAdapter {
        private int mChildCount = 0;
        private java.util.List<android.view.View> views;

        LoopPagerAdapter(java.util.List<android.view.View> list) {
            this.views = list;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(android.view.ViewGroup viewGroup, int i, java.lang.Object obj) {
            android.view.View childAt = viewGroup.getChildAt(i);
            if (childAt != null) {
                childAt.setTag(null);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            if (this.views.size() != 1 && io.dcloud.feature.nativeObj.BannerLayout.this.isImageLoop) {
                return io.dcloud.feature.nativeObj.BannerLayout.this.MAX_VALUE;
            }
            return this.views.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(java.lang.Object obj) {
            int i = this.mChildCount;
            if (i <= 0) {
                return super.getItemPosition(obj);
            }
            this.mChildCount = i - 1;
            return -2;
        }

        public java.util.List<android.view.View> getViews() {
            return this.views;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public java.lang.Object instantiateItem(android.view.ViewGroup viewGroup, int i) {
            if (this.views.size() <= 0) {
                return null;
            }
            if (io.dcloud.feature.nativeObj.BannerLayout.this.isImageLoop) {
                i %= this.views.size();
            }
            android.view.View view = this.views.get(i);
            if (viewGroup.equals(view.getParent())) {
                viewGroup.removeView(view);
            }
            if (view.getTag() != null && (i == 0 || io.dcloud.feature.nativeObj.BannerLayout.this.isAllowImageDownload)) {
                io.dcloud.feature.nativeObj.BannerLayout.this.imageLoader.displayImage(io.dcloud.feature.nativeObj.BannerLayout.this.getContext(), ((io.dcloud.feature.nativeObj.data.NativeImageDataItem) view.getTag()).getUrl(), view, i);
            }
            viewGroup.addView(view);
            return view;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(android.view.View view, java.lang.Object obj) {
            return view == obj;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void notifyDataSetChanged() {
            this.mChildCount = getCount();
            super.notifyDataSetChanged();
        }

        public void notifyItemsView(java.util.List<android.view.View> list) {
            this.views = list;
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface OnBannerItemClickListener {
        void onItemClick(int i);

        void onItemLongClick(int i);
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public enum Position {
        centerBottom,
        rightBottom,
        leftBottom,
        centerTop,
        rightTop,
        leftTop,
        none
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private static class SavedState extends android.view.View.BaseSavedState {
        public static final android.os.Parcelable.Creator<io.dcloud.feature.nativeObj.BannerLayout.SavedState> CREATOR = new android.os.Parcelable.Creator<io.dcloud.feature.nativeObj.BannerLayout.SavedState>() { // from class: io.dcloud.feature.nativeObj.BannerLayout.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public io.dcloud.feature.nativeObj.BannerLayout.SavedState createFromParcel(android.os.Parcel parcel) {
                return new io.dcloud.feature.nativeObj.BannerLayout.SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public io.dcloud.feature.nativeObj.BannerLayout.SavedState[] newArray(int i) {
                return new io.dcloud.feature.nativeObj.BannerLayout.SavedState[i];
            }
        };
        int currentPosition;

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.currentPosition);
        }

        SavedState(android.os.Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(android.os.Parcel parcel) {
            super(parcel);
            this.currentPosition = parcel.readInt();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private enum Shape {
        rect,
        oval
    }

    public BannerLayout(android.content.Context context, boolean z, boolean z2) {
        this(context, null, z, z2);
    }

    private android.view.View getImageView(io.dcloud.feature.nativeObj.data.NativeImageDataItem nativeImageDataItem, final int i) {
        android.view.View view;
        if (this.isImagePhoto) {
            android.widget.RelativeLayout relativeLayout = new android.widget.RelativeLayout(getContext());
            relativeLayout.setClickable(true);
            io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView subsamplingScaleImageView = new io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView(getContext());
            subsamplingScaleImageView.setOnClickListener(new android.view.View.OnClickListener() { // from class: io.dcloud.feature.nativeObj.BannerLayout.2
                @Override // android.view.View.OnClickListener
                public void onClick(android.view.View view2) {
                    if (io.dcloud.feature.nativeObj.BannerLayout.this.onBannerItemClickListener != null) {
                        io.dcloud.feature.nativeObj.BannerLayout.this.onBannerItemClickListener.onItemClick(i);
                    }
                }
            });
            subsamplingScaleImageView.setOnLongClickListener(new android.view.View.OnLongClickListener() { // from class: io.dcloud.feature.nativeObj.BannerLayout.3
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(android.view.View view2) {
                    if (io.dcloud.feature.nativeObj.BannerLayout.this.onBannerItemClickListener == null) {
                        return true;
                    }
                    io.dcloud.feature.nativeObj.BannerLayout.this.onBannerItemClickListener.onItemLongClick(i);
                    return true;
                }
            });
            subsamplingScaleImageView.setOrientation(-1);
            relativeLayout.addView(subsamplingScaleImageView, new android.widget.RelativeLayout.LayoutParams(-1, -1));
            android.widget.ProgressBar progressBar = new android.widget.ProgressBar(getContext());
            try {
                progressBar.setIndeterminateDrawable(getContext().getResources().getDrawable(io.dcloud.PdrR.DRAWBLE_PROGRESSBAR_WHITE_CIRCLE));
            } catch (java.lang.Exception unused) {
            }
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(100, 100);
            layoutParams.addRule(13);
            relativeLayout.addView(progressBar, layoutParams);
            view = relativeLayout;
        } else {
            io.dcloud.feature.nativeObj.BannerImageView bannerImageView = new io.dcloud.feature.nativeObj.BannerImageView(getContext(), nativeImageDataItem);
            bannerImageView.setOnClickListener(new android.view.View.OnClickListener() { // from class: io.dcloud.feature.nativeObj.BannerLayout.4
                @Override // android.view.View.OnClickListener
                public void onClick(android.view.View view2) {
                    if (io.dcloud.feature.nativeObj.BannerLayout.this.onBannerItemClickListener != null) {
                        io.dcloud.feature.nativeObj.BannerLayout.this.onBannerItemClickListener.onItemClick(i);
                    }
                }
            });
            view = bannerImageView;
        }
        view.setTag(nativeImageDataItem);
        return view;
    }

    private android.widget.TextView getIndicatorTextView() {
        android.widget.TextView textView = new android.widget.TextView(getContext());
        this.indicatorContainer.addView(textView);
        textView.setGravity(17);
        textView.setTextColor(-1);
        textView.setPadding(10, 5, 10, 5);
        textView.setTextSize(15.0f);
        textView.setWidth(((int) textView.getPaint().measureText(this.itemCount + "/" + this.itemCount)) + 40);
        android.graphics.drawable.GradientDrawable gradientDrawable = new android.graphics.drawable.GradientDrawable();
        gradientDrawable.setColor(android.graphics.Color.parseColor(io.dcloud.common.util.TitleNViewUtil.TRANSPARENT_BUTTON_BACKGROUND_COLOR));
        gradientDrawable.setCornerRadius(45.0f);
        textView.setBackgroundDrawable(gradientDrawable);
        return textView;
    }

    private void init(boolean z, boolean z2) {
        android.graphics.drawable.GradientDrawable gradientDrawable = new android.graphics.drawable.GradientDrawable();
        android.graphics.drawable.GradientDrawable gradientDrawable2 = new android.graphics.drawable.GradientDrawable();
        android.graphics.drawable.GradientDrawable gradientDrawable3 = new android.graphics.drawable.GradientDrawable();
        int i = io.dcloud.feature.nativeObj.BannerLayout.AnonymousClass6.$SwitchMap$io$dcloud$feature$nativeObj$BannerLayout$Shape[this.indicatorShape.ordinal()];
        if (i == 1) {
            gradientDrawable.setShape(0);
            gradientDrawable2.setShape(0);
            gradientDrawable3.setShape(0);
        } else if (i == 2) {
            gradientDrawable.setShape(1);
            gradientDrawable2.setShape(1);
            gradientDrawable3.setShape(1);
        }
        gradientDrawable3.setSize(this.selectedIndicatorWidth, this.selectedIndicatorHeight);
        gradientDrawable3.setColor(this.ringIndicatorColor);
        gradientDrawable.setColor(this.unSelectedIndicatorColor);
        gradientDrawable.setSize(this.unSelectedIndicatorWidth, this.unSelectedIndicatorHeight);
        this.unSelectedDrawable = new android.graphics.drawable.LayerDrawable(new android.graphics.drawable.Drawable[]{gradientDrawable});
        gradientDrawable2.setColor(this.selectedIndicatorColor);
        gradientDrawable2.setSize(this.selectedIndicatorWidth, this.selectedIndicatorHeight);
        android.graphics.drawable.LayerDrawable layerDrawable = new android.graphics.drawable.LayerDrawable(new android.graphics.drawable.Drawable[]{gradientDrawable3, gradientDrawable2});
        layerDrawable.setLayerInset(0, 0, 0, 0, 0);
        layerDrawable.setLayerInset(1, 2, 2, 2, 2);
        this.selectedDrawable = layerDrawable;
        this.isImagePhoto = z2;
        this.isImageLoop = z;
        int i2 = (int) (getResources().getDisplayMetrics().density * 5.0f);
        this.selectedIndicatorHeight = i2;
        this.selectedIndicatorWidth = i2;
        this.unSelectedIndicatorHeight = i2;
        this.unSelectedIndicatorWidth = i2;
    }

    private void setViews(java.util.List<android.view.View> list, int i) {
        androidx.viewpager.widget.ViewPager viewPager = this.pager;
        if (viewPager != null) {
            io.dcloud.feature.nativeObj.BannerLayout.LoopPagerAdapter loopPagerAdapter = (io.dcloud.feature.nativeObj.BannerLayout.LoopPagerAdapter) viewPager.getAdapter();
            if (loopPagerAdapter.getViews().size() <= 1 || list.size() != 1) {
                loopPagerAdapter.notifyItemsView(list);
            } else {
                removeAllViews();
                this.pager = null;
            }
        }
        if (this.pager == null) {
            androidx.viewpager.widget.ViewPager bounceBackViewPager = this.isImagePhoto ? new io.dcloud.feature.nativeObj.photoview.BounceBackViewPager(getContext()) : new androidx.viewpager.widget.ViewPager(getContext());
            this.pager = bounceBackViewPager;
            addView(bounceBackViewPager);
            this.pager.setAdapter(new io.dcloud.feature.nativeObj.BannerLayout.LoopPagerAdapter(list));
        }
        setSliderTransformDuration(this.scrollDuration);
        initIndicatiorContainer();
        if (!this.isImageLoop || list.size() <= 1) {
            this.currentPosition = i;
            this.pager.setCurrentItem(i);
            switchIndicator(this.currentPosition);
        } else {
            int i2 = this.MAX_VALUE / 2;
            int i3 = (i2 - (i2 % this.itemCount)) + i;
            this.pager.setCurrentItem(i3);
            int i4 = i3 % this.itemCount;
            this.currentPosition = i4;
            switchIndicator(i4);
        }
        this.pager.setOnPageChangeListener(new androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener() { // from class: io.dcloud.feature.nativeObj.BannerLayout.5
            @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i5) {
                super.onPageScrollStateChanged(i5);
            }

            @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i5, float f, int i6) {
                super.onPageScrolled(i5, f, i6);
            }

            @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i5) {
                android.view.View view;
                io.dcloud.feature.nativeObj.BannerLayout bannerLayout = io.dcloud.feature.nativeObj.BannerLayout.this;
                if (bannerLayout.isImageLoop) {
                    i5 %= io.dcloud.feature.nativeObj.BannerLayout.this.itemCount;
                }
                bannerLayout.currentPosition = i5;
                if (!io.dcloud.feature.nativeObj.BannerLayout.this.isAllowImageDownload && io.dcloud.feature.nativeObj.BannerLayout.this.imageLoader != null && (view = ((io.dcloud.feature.nativeObj.BannerLayout.LoopPagerAdapter) io.dcloud.feature.nativeObj.BannerLayout.this.pager.getAdapter()).getViews().get(io.dcloud.feature.nativeObj.BannerLayout.this.currentPosition)) != null) {
                    io.dcloud.feature.nativeObj.BannerLayout.this.imageLoader.displayImage(io.dcloud.feature.nativeObj.BannerLayout.this.getContext(), ((io.dcloud.feature.nativeObj.data.NativeImageDataItem) view.getTag()).getUrl(), view, io.dcloud.feature.nativeObj.BannerLayout.this.currentPosition);
                }
                io.dcloud.feature.nativeObj.BannerLayout bannerLayout2 = io.dcloud.feature.nativeObj.BannerLayout.this;
                bannerLayout2.switchIndicator(bannerLayout2.currentPosition);
            }
        });
        if (this.isAutoPlay) {
            startAutoPlay();
        }
    }

    private void startAutoPlay() {
        stopAutoPlay();
        if (this.isAutoPlay) {
            this.handler.sendEmptyMessageDelayed(this.WHAT_AUTO_PLAY, this.autoPlayDuration);
        }
    }

    private void stopAutoPlay() {
        androidx.viewpager.widget.ViewPager viewPager = this.pager;
        if (viewPager != null) {
            viewPager.setCurrentItem(viewPager.getCurrentItem(), false);
        }
        if (this.isAutoPlay) {
            this.handler.removeMessages(this.WHAT_AUTO_PLAY);
            androidx.viewpager.widget.ViewPager viewPager2 = this.pager;
            if (viewPager2 != null) {
                viewPager2.setCurrentItem(viewPager2.getCurrentItem(), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void switchIndicator(int i) {
        int i2 = 0;
        if (!this.mIndicatorType.equals("number")) {
            if (this.mIndicatorType.equals("default")) {
                while (i2 < this.indicatorContainer.getChildCount()) {
                    ((android.widget.ImageView) this.indicatorContainer.getChildAt(i2)).setImageDrawable(i2 == i ? this.selectedDrawable : this.unSelectedDrawable);
                    i2++;
                }
                return;
            }
            return;
        }
        android.view.View childAt = this.indicatorContainer.getChildAt(0);
        if (childAt instanceof android.widget.TextView) {
            ((android.widget.TextView) childAt).setText((i + 1) + "/" + this.itemCount);
        }
    }

    public void addViewUrls(java.util.ArrayList<io.dcloud.feature.nativeObj.data.NativeImageDataItem> arrayList, int i) {
        if (this.pager == null) {
            setViewUrls(arrayList, i);
            return;
        }
        java.util.ArrayList<io.dcloud.feature.nativeObj.data.NativeImageDataItem> arrayList2 = this.mUrls;
        if (arrayList2 != null) {
            arrayList2.addAll(arrayList);
        } else {
            this.mUrls = arrayList;
        }
        java.util.ArrayList arrayList3 = new java.util.ArrayList();
        this.itemCount = this.mUrls.size();
        for (int i2 = 0; i2 < this.mUrls.size(); i2++) {
            arrayList3.add(getImageView(this.mUrls.get(i2), i2));
        }
        initIndicatiorContainer();
        if (this.isImageLoop) {
            int i3 = this.MAX_VALUE / 2;
            int i4 = (i3 - (i3 % this.itemCount)) + i;
            this.pager.setCurrentItem(i4);
            int i5 = this.itemCount;
            int i6 = i4 % i5;
            this.currentPosition = i6;
            switchIndicator(i6 % i5);
        } else {
            this.currentPosition = i;
            this.pager.setCurrentItem(i);
            switchIndicator(this.currentPosition);
        }
        ((io.dcloud.feature.nativeObj.BannerLayout.LoopPagerAdapter) this.pager.getAdapter()).notifyItemsView(arrayList3);
    }

    public void clearBannerData() {
        androidx.viewpager.widget.ViewPager viewPager = this.pager;
        if (viewPager != null) {
            viewPager.setAdapter(null);
            this.pager.removeAllViews();
            this.pager = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            stopAutoPlay();
        } else if (action == 1 || action == 3) {
            startAutoPlay();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public int getCurrentPosition() {
        return this.currentPosition;
    }

    public androidx.viewpager.widget.ViewPager getPager() {
        androidx.viewpager.widget.ViewPager viewPager = this.pager;
        if (viewPager != null) {
            return viewPager;
        }
        return null;
    }

    public java.util.ArrayList<io.dcloud.feature.nativeObj.data.NativeImageDataItem> getUrls() {
        return this.mUrls;
    }

    public void initIndicatiorContainer() {
        android.view.View view = this.indicatorContainer;
        if (view != null) {
            removeView(view);
        }
        android.widget.LinearLayout linearLayout = new android.widget.LinearLayout(getContext());
        this.indicatorContainer = linearLayout;
        linearLayout.setGravity(16);
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        switch (io.dcloud.feature.nativeObj.BannerLayout.AnonymousClass6.$SwitchMap$io$dcloud$feature$nativeObj$BannerLayout$Position[this.indicatorPosition.ordinal()]) {
            case 1:
                layoutParams.addRule(14);
                layoutParams.addRule(12);
                break;
            case 2:
                layoutParams.addRule(14);
                layoutParams.addRule(10);
                break;
            case 3:
                layoutParams.addRule(9);
                layoutParams.addRule(12);
                break;
            case 4:
                layoutParams.addRule(9);
                layoutParams.addRule(10);
                break;
            case 5:
                layoutParams.addRule(11);
                layoutParams.addRule(12);
                break;
            case 6:
                layoutParams.addRule(11);
                layoutParams.addRule(10);
                break;
            case 7:
                layoutParams = null;
                break;
        }
        if (layoutParams != null) {
            int i = this.indicatorMargin;
            int statusHeight = (i / 2) + io.dcloud.common.adapter.util.DeviceInfo.getStatusHeight(getContext());
            int i2 = this.indicatorMargin;
            layoutParams.setMargins(i, statusHeight, i2, i2);
            addView(this.indicatorContainer, layoutParams);
            if (this.mIndicatorType.equals("number")) {
                getIndicatorTextView().setText("1/" + this.itemCount);
            } else {
                for (int i3 = 0; i3 < this.itemCount; i3++) {
                    android.widget.ImageView imageView = new android.widget.ImageView(getContext());
                    imageView.setLayoutParams(new android.view.ViewGroup.LayoutParams(-2, -2));
                    int i4 = this.indicatorSpace;
                    imageView.setPadding(i4, i4, i4, i4);
                    imageView.setImageDrawable(this.unSelectedDrawable);
                    this.indicatorContainer.addView(imageView);
                }
            }
            if (this.itemCount == 1) {
                this.indicatorContainer.setVisibility(4);
            } else {
                this.indicatorContainer.setVisibility(0);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startAutoPlay();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopAutoPlay();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(android.os.Parcelable parcelable) {
        io.dcloud.feature.nativeObj.BannerLayout.SavedState savedState = (io.dcloud.feature.nativeObj.BannerLayout.SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.currentPosition = savedState.currentPosition;
        requestLayout();
    }

    @Override // android.view.View
    public android.os.Parcelable onSaveInstanceState() {
        io.dcloud.feature.nativeObj.BannerLayout.SavedState savedState = new io.dcloud.feature.nativeObj.BannerLayout.SavedState(super.onSaveInstanceState());
        savedState.currentPosition = this.currentPosition;
        return savedState;
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            startAutoPlay();
        } else {
            stopAutoPlay();
        }
    }

    public void setAllowImageDownload(boolean z, boolean z2) {
        androidx.viewpager.widget.ViewPager viewPager;
        this.isAllowImageDownload = z;
        if (!z2 || (viewPager = this.pager) == null || viewPager.getAdapter() == null) {
            return;
        }
        this.pager.getAdapter().notifyDataSetChanged();
    }

    public void setAutoPlay(boolean z, int i) {
        this.isAutoPlay = z;
        this.autoPlayDuration = i;
    }

    public void setImageLoader(io.dcloud.feature.nativeObj.BannerLayout.ImageLoader imageLoader) {
        this.imageLoader = imageLoader;
    }

    public void setImageLoop(java.lang.Boolean bool) {
        this.isImageLoop = bool.booleanValue();
    }

    public void setIndicatorContainerData(io.dcloud.feature.nativeObj.BannerLayout.Position position, int i, int i2, int i3, java.lang.String str) {
        if (position != null) {
            this.indicatorPosition = position;
        }
        this.indicatorMargin = i;
        this.indicatorSpace = i2;
        this.selectedIndicatorHeight = i3;
        this.selectedIndicatorWidth = i3;
        this.unSelectedIndicatorHeight = i3;
        this.unSelectedIndicatorWidth = i3;
        if (!android.text.TextUtils.isEmpty(str)) {
            this.mIndicatorType = str;
        }
        if (this.mIndicatorType.equals("default")) {
            this.indicatorPosition = io.dcloud.feature.nativeObj.BannerLayout.Position.centerBottom;
        } else if (this.mIndicatorType.equals("number")) {
            this.indicatorPosition = io.dcloud.feature.nativeObj.BannerLayout.Position.centerTop;
        } else if (this.mIndicatorType.equals("none")) {
            this.indicatorPosition = io.dcloud.feature.nativeObj.BannerLayout.Position.none;
        }
    }

    public void setIndicatorType(java.lang.String str) {
        if (!android.text.TextUtils.isEmpty(str)) {
            this.mIndicatorType = str;
        }
        if (this.mIndicatorType.equals("default")) {
            this.indicatorPosition = io.dcloud.feature.nativeObj.BannerLayout.Position.centerBottom;
        } else if (this.mIndicatorType.equals("number")) {
            this.indicatorPosition = io.dcloud.feature.nativeObj.BannerLayout.Position.centerTop;
        } else if (this.mIndicatorType.equals("none")) {
            this.indicatorPosition = io.dcloud.feature.nativeObj.BannerLayout.Position.none;
        }
    }

    public void setOnBannerItemClickListener(io.dcloud.feature.nativeObj.BannerLayout.OnBannerItemClickListener onBannerItemClickListener) {
        this.onBannerItemClickListener = onBannerItemClickListener;
    }

    public void setScrollDuration(int i) {
        this.scrollDuration = i;
    }

    public void setSliderTransformDuration(int i) {
        try {
            java.lang.reflect.Field declaredField = androidx.viewpager.widget.ViewPager.class.getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            declaredField.set(this.pager, new io.dcloud.feature.nativeObj.BannerLayout.FixedSpeedScroller(this, this.pager.getContext(), null, i));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public void setViewUrls(java.util.ArrayList<io.dcloud.feature.nativeObj.data.NativeImageDataItem> arrayList, int i) {
        java.util.ArrayList<io.dcloud.feature.nativeObj.data.NativeImageDataItem> arrayList2 = this.mUrls;
        if (arrayList2 != null) {
            arrayList2.clear();
        }
        this.mUrls = arrayList;
        java.util.ArrayList arrayList3 = new java.util.ArrayList();
        int size = arrayList.size();
        this.itemCount = size;
        if (size < 1) {
            throw new java.lang.IllegalStateException("item count not equal zero");
        }
        if (size == 2) {
            if (this.isImageLoop) {
                arrayList3.add(getImageView(arrayList.get(0), 0));
                arrayList3.add(getImageView(arrayList.get(1), 1));
            }
            arrayList3.add(getImageView(arrayList.get(0), 0));
            arrayList3.add(getImageView(arrayList.get(1), 1));
        } else {
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                arrayList3.add(getImageView(arrayList.get(i2), i2));
            }
        }
        setViews(arrayList3, i);
    }

    public void setmIndicatorType(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        this.mIndicatorType = str;
    }

    public BannerLayout(android.content.Context context, android.util.AttributeSet attributeSet, boolean z, boolean z2) {
        this(context, attributeSet, 0, z, z2);
    }

    public BannerLayout(android.content.Context context, android.util.AttributeSet attributeSet, int i, boolean z, boolean z2) {
        super(context, attributeSet, i);
        this.mIndicatorType = "default";
        this.WHAT_AUTO_PLAY = 1000;
        this.isAutoPlay = false;
        this.selectedIndicatorColor = -1;
        this.unSelectedIndicatorColor = -5592406;
        this.ringIndicatorColor = -5592406;
        this.indicatorShape = io.dcloud.feature.nativeObj.BannerLayout.Shape.oval;
        this.selectedIndicatorHeight = 15;
        this.selectedIndicatorWidth = 15;
        this.unSelectedIndicatorHeight = 15;
        this.unSelectedIndicatorWidth = 15;
        this.indicatorPosition = io.dcloud.feature.nativeObj.BannerLayout.Position.centerBottom;
        this.autoPlayDuration = 4000;
        this.scrollDuration = tv.danmaku.ijk.media.player.IMediaPlayer.MEDIA_INFO_TIMED_TEXT_ERROR;
        this.indicatorSpace = 3;
        this.indicatorMargin = 10;
        this.isAllowImageDownload = true;
        this.isImagePhoto = false;
        this.isImageLoop = false;
        this.MAX_VALUE = 150;
        this.handler = new android.os.Handler(new android.os.Handler.Callback() { // from class: io.dcloud.feature.nativeObj.BannerLayout.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(android.os.Message message) {
                if (message.what == io.dcloud.feature.nativeObj.BannerLayout.this.WHAT_AUTO_PLAY && io.dcloud.feature.nativeObj.BannerLayout.this.pager != null && io.dcloud.feature.nativeObj.BannerLayout.this.isAutoPlay && io.dcloud.feature.nativeObj.BannerLayout.this.mUrls != null && io.dcloud.feature.nativeObj.BannerLayout.this.mUrls.size() > 1) {
                    if (io.dcloud.feature.nativeObj.BannerLayout.this.isImageLoop) {
                        io.dcloud.feature.nativeObj.BannerLayout.this.pager.setCurrentItem(io.dcloud.feature.nativeObj.BannerLayout.this.pager.getCurrentItem() + 1, true);
                    } else {
                        int currentItem = io.dcloud.feature.nativeObj.BannerLayout.this.pager.getCurrentItem() + 1;
                        if (currentItem >= io.dcloud.feature.nativeObj.BannerLayout.this.mUrls.size()) {
                            return false;
                        }
                        io.dcloud.feature.nativeObj.BannerLayout.this.pager.setCurrentItem(currentItem, true);
                    }
                    io.dcloud.feature.nativeObj.BannerLayout.this.handler.sendEmptyMessageDelayed(io.dcloud.feature.nativeObj.BannerLayout.this.WHAT_AUTO_PLAY, io.dcloud.feature.nativeObj.BannerLayout.this.autoPlayDuration);
                }
                return false;
            }
        });
        io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.setPreferredBitmapConfig(android.graphics.Bitmap.Config.ARGB_8888);
        init(z, z2);
    }
}
