package io.dcloud.feature.nativeObj.photoview;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class PhotoActivity extends io.src.dcloud.adapter.DCloudBaseActivity {
    public static java.lang.String IMAGE_BG_KEY = "image_backgroud_color";
    public static java.lang.String IMAGE_CURRENT_INDEX_KEY = "image_current_index";
    public static java.lang.String IMAGE_INDICATOR_KEY = "image_indicator";
    public static java.lang.String IMAGE_LOOP_KEY = "image_loop";
    public static java.lang.String IMAGE_PHOTO_KEY = "image_photo";
    public static java.lang.String IMAGE_PHOTO_TOP = "image_photo_top";
    public static java.lang.String IMAGE_URLLIST_KEY = "image_urlList";
    public static java.lang.String IMAGE_URLS_KEY = "image_urls";
    private java.lang.String callbackId;
    private java.lang.String[] localImageUrls;
    private com.nostra13.dcloudimageloader.core.DisplayImageOptions mDefOps;
    java.util.ArrayList<io.dcloud.feature.nativeObj.data.NativeImageDataItem> mImageUrls;
    private java.util.ArrayList originalImageUrls;
    private io.dcloud.feature.nativeObj.BannerLayout photoLayout;
    int mCurrentItmeIndex = 0;
    public java.lang.String mIndicatorType = "default";
    public boolean isBack = false;

    private com.nostra13.dcloudimageloader.core.DisplayImageOptions getIconDisplayOptions() {
        return new com.nostra13.dcloudimageloader.core.DisplayImageOptions.Builder().cacheOnDisc(true).cacheInMemory(true).imageScaleType(com.nostra13.dcloudimageloader.core.assist.ImageScaleType.NONE).bitmapConfig(android.graphics.Bitmap.Config.ARGB_8888).showImageOnLoading(new android.graphics.drawable.ColorDrawable(0)).build();
    }

    public java.util.ArrayList<io.dcloud.feature.nativeObj.data.NativeImageDataItem> listToNativeDataItems(java.util.ArrayList<java.lang.String> arrayList) {
        if (arrayList == null) {
            return null;
        }
        java.util.ArrayList<io.dcloud.feature.nativeObj.data.NativeImageDataItem> arrayList2 = new java.util.ArrayList<>();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            java.lang.String str = arrayList.get(i);
            i++;
            io.dcloud.feature.nativeObj.data.NativeImageDataItem nativeImageDataItem = new io.dcloud.feature.nativeObj.data.NativeImageDataItem();
            nativeImageDataItem.setUrl(str);
            arrayList2.add(nativeImageDataItem);
        }
        return arrayList2;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (io.dcloud.common.util.EventDispatchManager.getInstance().dispatchEvent(io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onKeyUp, new java.lang.Object[]{4, null})) {
            return;
        }
        if (this.callbackId != null) {
            io.dcloud.feature.nativeObj.photoview.LongClickEventManager.getInstance().removeOnLongClickListener(this.callbackId);
        }
        io.dcloud.common.util.RuningAcitvityUtil.removeRuningActivity(getComponentName().getClassName());
        finish();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    @Override // io.src.dcloud.adapter.DCloudBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        io.dcloud.common.util.RuningAcitvityUtil.putRuningActivity(this);
        this.mDefOps = getIconDisplayOptions();
        android.content.Intent intent = getIntent();
        if (intent.hasExtra(IMAGE_URLLIST_KEY)) {
            this.mImageUrls = listToNativeDataItems(intent.getStringArrayListExtra(IMAGE_URLLIST_KEY));
        } else {
            this.mImageUrls = intent.getParcelableArrayListExtra(IMAGE_URLS_KEY);
        }
        if (this.mImageUrls == null) {
            onBackPressed();
            return;
        }
        int intExtra = intent.getIntExtra(IMAGE_CURRENT_INDEX_KEY, this.mCurrentItmeIndex);
        this.mCurrentItmeIndex = intExtra;
        if (intExtra > this.mImageUrls.size()) {
            this.mCurrentItmeIndex = 0;
        }
        if (intent.hasExtra("preview_callback")) {
            this.callbackId = intent.getStringExtra("preview_callback");
        }
        if (intent.hasExtra("original_image_urlArray")) {
            this.originalImageUrls = intent.getStringArrayListExtra("original_image_urlArray");
        }
        if (intent.hasExtra("screen_orientation")) {
            setRequestedOrientation(intent.getIntExtra("screen_orientation", 2));
        }
        boolean booleanExtra = intent.getBooleanExtra(IMAGE_LOOP_KEY, false);
        boolean booleanExtra2 = intent.getBooleanExtra(IMAGE_PHOTO_KEY, false);
        if (intent.hasExtra(IMAGE_INDICATOR_KEY)) {
            this.mIndicatorType = intent.getStringExtra(IMAGE_INDICATOR_KEY);
        }
        android.widget.RelativeLayout relativeLayout = new android.widget.RelativeLayout(this.that);
        relativeLayout.setBackgroundColor(intent.getIntExtra(IMAGE_BG_KEY, -16777216));
        relativeLayout.postDelayed(new java.lang.Runnable() { // from class: io.dcloud.feature.nativeObj.photoview.PhotoActivity.1
            @Override // java.lang.Runnable
            public void run() {
                io.dcloud.feature.nativeObj.photoview.PhotoActivity.this.isBack = true;
            }
        }, 1000L);
        if (this.mImageUrls.size() > 0) {
            this.localImageUrls = new java.lang.String[(booleanExtra && this.mImageUrls.size() == 2) ? this.mImageUrls.size() + 2 : this.mImageUrls.size()];
            io.dcloud.feature.nativeObj.BannerLayout bannerLayout = new io.dcloud.feature.nativeObj.BannerLayout(this.that, booleanExtra, booleanExtra2);
            this.photoLayout = bannerLayout;
            bannerLayout.setImageLoader(new io.dcloud.feature.nativeObj.BannerLayout.ImageLoader() { // from class: io.dcloud.feature.nativeObj.photoview.PhotoActivity.2
                @Override // io.dcloud.feature.nativeObj.BannerLayout.ImageLoader
                public void displayImage(android.content.Context context, final java.lang.String str, final android.view.View view, final int i) {
                    android.net.Uri imageFileUri;
                    java.lang.Object tag = view.getTag();
                    view.setTag(null);
                    if (str.startsWith(io.dcloud.common.adapter.util.DeviceInfo.FILE_PROTOCOL)) {
                        str = str.replace(io.dcloud.common.adapter.util.DeviceInfo.FILE_PROTOCOL, "");
                    }
                    if (!io.dcloud.common.util.PdrUtil.isDeviceRootDir(str) && !io.dcloud.common.util.PdrUtil.isNetPath(str) && !io.dcloud.common.util.PdrUtil.isBase64ImagePath(str)) {
                        if (str.startsWith("assets://")) {
                            str = str.replace("assets://", io.dcloud.feature.internal.sdk.SDK.ANDROID_ASSET);
                        } else if (str.startsWith("/")) {
                            str = "file:///android_asset" + str;
                        } else {
                            str = io.dcloud.feature.internal.sdk.SDK.ANDROID_ASSET + str;
                        }
                    }
                    if (!io.dcloud.common.util.FileUtil.checkPrivatePath(context, str) && (imageFileUri = io.dcloud.common.util.FileUtil.getImageFileUri(context, str)) != null) {
                        str = imageFileUri.toString();
                    }
                    com.bumptech.glide.Glide.with((androidx.fragment.app.FragmentActivity) io.dcloud.feature.nativeObj.photoview.PhotoActivity.this).download(str).into(new com.bumptech.glide.request.target.SimpleTarget<java.io.File>() { // from class: io.dcloud.feature.nativeObj.photoview.PhotoActivity.2.1
                        private android.widget.ProgressBar bar;
                        private io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView subImageview;

                        @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
                        public void onLoadStarted(android.graphics.drawable.Drawable drawable) {
                            android.view.View view2 = view;
                            if (view2 instanceof android.widget.RelativeLayout) {
                                try {
                                    this.subImageview = (io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView) ((android.widget.RelativeLayout) view2).getChildAt(0);
                                    this.bar = (android.widget.ProgressBar) ((android.widget.RelativeLayout) view).getChildAt(1);
                                } catch (java.lang.Exception unused) {
                                }
                            }
                        }

                        @Override // com.bumptech.glide.request.target.Target
                        public /* bridge */ /* synthetic */ void onResourceReady(java.lang.Object obj, com.bumptech.glide.request.transition.Transition transition) {
                            onResourceReady((java.io.File) obj, (com.bumptech.glide.request.transition.Transition<? super java.io.File>) transition);
                        }

                        public boolean typeOf(java.io.File file, java.lang.String str2) {
                            android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
                            options.inJustDecodeBounds = true;
                            android.graphics.BitmapFactory.decodeFile(file.getAbsolutePath(), options);
                            return options.outMimeType.toLowerCase(java.util.Locale.ENGLISH).contains(str2);
                        }

                        public void onResourceReady(java.io.File file, com.bumptech.glide.request.transition.Transition<? super java.io.File> transition) {
                            io.dcloud.feature.nativeObj.photoview.subscaleview.ImageSource imageSourceBitmap;
                            android.view.View view2 = view;
                            if (view2 instanceof android.widget.RelativeLayout) {
                                try {
                                    if (typeOf(file, "gif")) {
                                        this.subImageview.setScaleType(android.widget.ImageView.ScaleType.CENTER_INSIDE);
                                        this.subImageview.setImageURI(android.net.Uri.fromFile(file));
                                    } else {
                                        if (typeOf(file, "bmp")) {
                                            imageSourceBitmap = io.dcloud.feature.nativeObj.photoview.subscaleview.BitmapUtil.needRatationWithExif(file) ? io.dcloud.feature.nativeObj.photoview.subscaleview.ImageSource.bitmap(io.dcloud.feature.nativeObj.photoview.subscaleview.BitmapUtil.getRotatedBitmapFromFile(file)) : io.dcloud.feature.nativeObj.photoview.subscaleview.ImageSource.bitmap(android.graphics.BitmapFactory.decodeFile(file.getAbsolutePath()));
                                        } else {
                                            imageSourceBitmap = io.dcloud.feature.nativeObj.photoview.subscaleview.BitmapUtil.needRatationWithExif(file) ? io.dcloud.feature.nativeObj.photoview.subscaleview.ImageSource.bitmap(io.dcloud.feature.nativeObj.photoview.subscaleview.BitmapUtil.getRotatedBitmapFromFile(file)) : io.dcloud.feature.nativeObj.photoview.subscaleview.ImageSource.uri(file.getAbsolutePath());
                                        }
                                        this.subImageview.setImage(imageSourceBitmap);
                                    }
                                    this.bar.setVisibility(8);
                                } catch (java.lang.Exception unused) {
                                }
                            } else {
                                ((android.widget.ImageView) view2).setImageURI(android.net.Uri.fromFile(file));
                            }
                            if (!io.dcloud.common.util.PdrUtil.isNetPath(str) || io.dcloud.feature.nativeObj.photoview.PhotoActivity.this.localImageUrls == null || i >= io.dcloud.feature.nativeObj.photoview.PhotoActivity.this.localImageUrls.length) {
                                return;
                            }
                            io.dcloud.feature.nativeObj.photoview.PhotoActivity.this.localImageUrls[i] = file.getAbsolutePath();
                        }
                    });
                    view.setTag(tag);
                }
            });
            this.photoLayout.setIndicatorContainerData(null, 20, 10, 18, this.mIndicatorType);
            this.photoLayout.setScrollDuration(500);
            this.photoLayout.setViewUrls(this.mImageUrls, this.mCurrentItmeIndex);
            if (this.mImageUrls.size() == 2 && booleanExtra && this.photoLayout.getPager() != null) {
                this.photoLayout.getPager().setOffscreenPageLimit(2);
            }
            this.photoLayout.setOnBannerItemClickListener(new io.dcloud.feature.nativeObj.BannerLayout.OnBannerItemClickListener() { // from class: io.dcloud.feature.nativeObj.photoview.PhotoActivity.3
                @Override // io.dcloud.feature.nativeObj.BannerLayout.OnBannerItemClickListener
                public void onItemClick(int i) {
                    io.dcloud.feature.nativeObj.photoview.PhotoActivity photoActivity = io.dcloud.feature.nativeObj.photoview.PhotoActivity.this;
                    if (photoActivity.isBack) {
                        photoActivity.onBackPressed();
                    }
                }

                @Override // io.dcloud.feature.nativeObj.BannerLayout.OnBannerItemClickListener
                public void onItemLongClick(int i) {
                    org.json.JSONObject jSONObject = new org.json.JSONObject();
                    try {
                        jSONObject.put("index", i);
                        if (io.dcloud.feature.nativeObj.photoview.PhotoActivity.this.originalImageUrls != null && io.dcloud.feature.nativeObj.photoview.PhotoActivity.this.originalImageUrls.get(i) != null) {
                            jSONObject.put("url", io.dcloud.feature.nativeObj.photoview.PhotoActivity.this.originalImageUrls.get(i));
                        }
                        if (io.dcloud.feature.nativeObj.photoview.PhotoActivity.this.localImageUrls[i] != null) {
                            jSONObject.put(io.dcloud.common.constant.AbsoluteConst.XML_PATH, io.dcloud.feature.nativeObj.photoview.PhotoActivity.this.localImageUrls[i]);
                        }
                    } catch (org.json.JSONException unused) {
                    }
                    io.dcloud.feature.nativeObj.photoview.LongClickEventManager.getInstance().fireEvent(jSONObject);
                }
            });
            relativeLayout.addView(this.photoLayout, new android.widget.RelativeLayout.LayoutParams(-1, -1));
        }
        setContentView(relativeLayout, new android.view.ViewGroup.LayoutParams(-1, -1));
        fullScreen(this);
    }

    private void fullScreen(android.app.Activity activity) {
        android.view.Window window = activity.getWindow();
        window.getDecorView().setSystemUiVisibility(1792);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(0);
        window.setNavigationBarColor(0);
    }
}
