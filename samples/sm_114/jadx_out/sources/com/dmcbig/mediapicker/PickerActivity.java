package com.dmcbig.mediapicker;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class PickerActivity extends androidx.fragment.app.FragmentActivity implements com.dmcbig.mediapicker.data.DataCallback, android.view.View.OnClickListener {
    android.content.Intent argsIntent;
    android.widget.Button category_btn;
    java.lang.String cropOptions;
    java.lang.String docPath;
    android.widget.Button done;
    android.widget.ImageView fullImage;
    com.dmcbig.mediapicker.adapter.MediaGridAdapter gridAdapter;
    private com.dmcbig.mediapicker.adapter.FolderAdapter mFolderAdapter;
    android.widget.ListPopupWindow mFolderPopupWindow;
    android.widget.Button preview;
    androidx.recyclerview.widget.RecyclerView recyclerView;
    java.util.Iterator<com.dmcbig.mediapicker.entity.Media> selectIterator;
    boolean isSingle = false;
    java.lang.String doneBtnText = "";
    boolean isCompress = false;
    boolean isAddImageFor34 = false;
    private boolean isFinish = false;

    private void checkoutNeedShowPermissionBar() {
        if (android.os.Build.VERSION.SDK_INT < 34 || androidx.core.app.ActivityCompat.checkSelfPermission(this, com.hjq.permissions.Permission.READ_MEDIA_IMAGES) == -1) {
            return;
        }
        restartMediaData();
        findViewById(io.dcloud.base.R.id.dcloud_gallery_permission_bar).setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: compress, reason: merged with bridge method [inline-methods] */
    public void m210lambda$done$2$comdmcbigmediapickerPickerActivity(final java.util.ArrayList<com.dmcbig.mediapicker.entity.Media> arrayList) {
        final java.lang.String str;
        if (isFinishing() || isDestroyed()) {
            return;
        }
        if (!this.selectIterator.hasNext()) {
            runOnUiThread(new java.lang.Runnable() { // from class: com.dmcbig.mediapicker.PickerActivity.5
                @Override // java.lang.Runnable
                public void run() {
                    android.content.Intent intent = new android.content.Intent();
                    intent.putParcelableArrayListExtra(com.dmcbig.mediapicker.PickerConfig.EXTRA_RESULT, arrayList);
                    com.dmcbig.mediapicker.PickerActivity.this.setResult(com.dmcbig.mediapicker.PickerConfig.RESULT_CODE, intent);
                    com.dmcbig.mediapicker.PickerActivity.this.finish();
                }
            });
            return;
        }
        final com.dmcbig.mediapicker.entity.Media next = this.selectIterator.next();
        if (next.extension.equalsIgnoreCase(".png") || next.extension.equalsIgnoreCase(".jpg") || next.extension.equalsIgnoreCase(".jpeg")) {
            java.lang.String[] strArrSplit = next.path.split("/");
            java.lang.String strCompressImage = io.dcloud.common.util.CompressUtil.compressImage(next.path, this.docPath + "uniapp_temp/compressed/" + java.lang.System.currentTimeMillis() + "_" + strArrSplit[strArrSplit.length - 1], next.extension.equalsIgnoreCase(".png"), this);
            if (!android.text.TextUtils.isEmpty(strCompressImage)) {
                next.path = strCompressImage;
            }
            m210lambda$done$2$comdmcbigmediapickerPickerActivity(arrayList);
            return;
        }
        if (next.mediaType != 3) {
            m210lambda$done$2$comdmcbigmediapickerPickerActivity(arrayList);
            return;
        }
        if (this.docPath.endsWith("/")) {
            str = this.docPath + "compress_video_" + android.os.SystemClock.elapsedRealtime() + ".mp4";
        } else {
            str = this.docPath + "/compress_video_" + android.os.SystemClock.elapsedRealtime() + ".mp4";
        }
        try {
            new java.io.File(str).getParentFile().mkdirs();
            androidtranscoder.MediaTranscoder.getInstance().transcodeVideo(next.path, str, androidtranscoder.format.MediaFormatStrategyPresets.createAndroid720pStrategy(2, 1.0d), new androidtranscoder.MediaTranscoder.Listener() { // from class: com.dmcbig.mediapicker.PickerActivity.4
                @Override // androidtranscoder.MediaTranscoder.Listener
                public void onTranscodeCanceled() {
                    com.dmcbig.mediapicker.PickerActivity.this.m210lambda$done$2$comdmcbigmediapickerPickerActivity(arrayList);
                }

                @Override // androidtranscoder.MediaTranscoder.Listener
                public void onTranscodeCompleted() {
                    next.path = str;
                    com.dmcbig.mediapicker.PickerActivity.this.m210lambda$done$2$comdmcbigmediapickerPickerActivity(arrayList);
                }

                @Override // androidtranscoder.MediaTranscoder.Listener
                public void onTranscodeFailed(java.lang.Exception exc) {
                    com.dmcbig.mediapicker.PickerActivity.this.m210lambda$done$2$comdmcbigmediapickerPickerActivity(arrayList);
                }

                @Override // androidtranscoder.MediaTranscoder.Listener
                public void onTranscodeProgress(double d) {
                }
            });
        } catch (java.lang.Exception unused) {
            m210lambda$done$2$comdmcbigmediapickerPickerActivity(arrayList);
        }
    }

    private void getOtherArgs() {
        java.lang.String stringExtra = this.argsIntent.getStringExtra(com.dmcbig.mediapicker.PickerConfig.DONE_BUTTON_TEXT);
        this.doneBtnText = stringExtra;
        if (!io.dcloud.common.util.PdrUtil.isEmpty(stringExtra)) {
            this.done.setText(this.doneBtnText);
        }
        if (io.dcloud.common.util.PdrUtil.isEmpty(this.cropOptions)) {
            return;
        }
        this.done.setVisibility(4);
        findViewById(com.dmcbig.mediapicker.MediaPickerR.MP_ID_PREVIEW).setVisibility(4);
        this.isCompress = false;
        findViewById(io.dcloud.base.R.id.check_origin_image_layout).setVisibility(8);
    }

    private void permissionBar() {
        if (android.os.Build.VERSION.SDK_INT < 34) {
            findViewById(io.dcloud.base.R.id.dcloud_gallery_permission_bar).setVisibility(4);
            return;
        }
        boolean z = androidx.core.app.ActivityCompat.checkSelfPermission(this, com.hjq.permissions.Permission.READ_MEDIA_IMAGES) == -1;
        this.isAddImageFor34 = z;
        if (z) {
            findViewById(io.dcloud.base.R.id.dcloud_gallery_permission_bar).setVisibility(0);
            findViewById(io.dcloud.base.R.id.dcloud_gallery_permission_bar_permission_request).setOnClickListener(new android.view.View.OnClickListener() { // from class: com.dmcbig.mediapicker.PickerActivity$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    this.f$0.m212lambda$permissionBar$1$comdmcbigmediapickerPickerActivity(view);
                }
            });
        }
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(android.content.Context context) {
        if (android.os.Build.VERSION.SDK_INT < 26) {
            super.attachBaseContext(context);
        } else {
            super.attachBaseContext(io.dcloud.common.util.language.LanguageUtil.updateContextLanguageAfterO(context, false));
        }
    }

    void createAdapter() {
        this.recyclerView.setLayoutManager(new androidx.recyclerview.widget.GridLayoutManager(this, com.dmcbig.mediapicker.PickerConfig.GridSpanCount));
        this.recyclerView.addItemDecoration(new com.dmcbig.mediapicker.adapter.SpacingDecoration(com.dmcbig.mediapicker.PickerConfig.GridSpanCount, com.dmcbig.mediapicker.PickerConfig.GridSpace));
        this.recyclerView.setHasFixedSize(true);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.ArrayList parcelableArrayListExtra = this.argsIntent.getParcelableArrayListExtra(com.dmcbig.mediapicker.PickerConfig.DEFAULT_SELECTED_LIST);
        final java.lang.String stringExtra = this.argsIntent.getStringExtra(com.dmcbig.mediapicker.PickerConfig.SELECTED_MAX_CALLBACK_ID);
        int intExtra = this.argsIntent.getIntExtra("max_select_count", Integer.MAX_VALUE);
        long longExtra = this.argsIntent.getLongExtra(com.dmcbig.mediapicker.PickerConfig.MAX_SELECT_SIZE, Long.MAX_VALUE);
        this.isSingle = this.argsIntent.getBooleanExtra(com.dmcbig.mediapicker.PickerConfig.SINGLE_SELECT, false);
        if (!android.text.TextUtils.isEmpty(this.cropOptions)) {
            this.isSingle = true;
        }
        if (this.isSingle) {
            android.widget.Button button = this.done;
            if (button != null) {
                button.setVisibility(8);
            }
            android.widget.Button button2 = this.preview;
            if (button2 != null) {
                button2.setVisibility(4);
            }
        }
        com.dmcbig.mediapicker.adapter.MediaGridAdapter mediaGridAdapter = new com.dmcbig.mediapicker.adapter.MediaGridAdapter(arrayList, this, parcelableArrayListExtra, intExtra, longExtra, this.isSingle);
        this.gridAdapter = mediaGridAdapter;
        mediaGridAdapter.setOnMaxListener(new com.dmcbig.mediapicker.adapter.MediaGridAdapter.OnPickerSelectMaxListener() { // from class: com.dmcbig.mediapicker.PickerActivity.1
            @Override // com.dmcbig.mediapicker.adapter.MediaGridAdapter.OnPickerSelectMaxListener
            public void onMaxed() {
                if (android.text.TextUtils.isEmpty(stringExtra)) {
                    return;
                }
                io.dcloud.js.gallery.GalleryFeatureImpl.onMaxed(com.dmcbig.mediapicker.PickerActivity.this, stringExtra);
            }
        });
        this.recyclerView.setAdapter(this.gridAdapter);
    }

    void createFolderAdapter() {
        this.mFolderAdapter = new com.dmcbig.mediapicker.adapter.FolderAdapter(new java.util.ArrayList(), this);
        android.widget.ListPopupWindow listPopupWindow = new android.widget.ListPopupWindow(this);
        this.mFolderPopupWindow = listPopupWindow;
        listPopupWindow.setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(-1));
        this.mFolderPopupWindow.setAdapter(this.mFolderAdapter);
        this.mFolderPopupWindow.setHeight((int) (((double) com.dmcbig.mediapicker.utils.ScreenUtils.getScreenHeight(this)) * 0.6d));
        this.mFolderPopupWindow.setAnchorView(findViewById(com.dmcbig.mediapicker.MediaPickerR.MP_ID_FOOTER));
        this.mFolderPopupWindow.setModal(true);
        this.mFolderPopupWindow.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() { // from class: com.dmcbig.mediapicker.PickerActivity.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(android.widget.AdapterView<?> adapterView, android.view.View view, int i, long j) {
                com.dmcbig.mediapicker.PickerActivity.this.mFolderAdapter.setSelectIndex(i);
                com.dmcbig.mediapicker.PickerActivity pickerActivity = com.dmcbig.mediapicker.PickerActivity.this;
                pickerActivity.category_btn.setText(pickerActivity.mFolderAdapter.getItem(i).name);
                com.dmcbig.mediapicker.PickerActivity pickerActivity2 = com.dmcbig.mediapicker.PickerActivity.this;
                pickerActivity2.gridAdapter.updateAdapter(pickerActivity2.mFolderAdapter.getSelectMedias());
                com.dmcbig.mediapicker.PickerActivity.this.mFolderPopupWindow.dismiss();
            }
        });
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        if (this.isFinish) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void done(final java.util.ArrayList<com.dmcbig.mediapicker.entity.Media> arrayList) {
        this.isFinish = true;
        if (!this.isCompress || arrayList == null || arrayList.size() <= 0) {
            android.content.Intent intent = new android.content.Intent();
            intent.putParcelableArrayListExtra(com.dmcbig.mediapicker.PickerConfig.EXTRA_RESULT, arrayList);
            setResult(com.dmcbig.mediapicker.PickerConfig.RESULT_CODE, intent);
            finish();
            return;
        }
        this.done.setClickable(false);
        this.done.setFocusable(true);
        findViewById(io.dcloud.base.R.id.loading).setVisibility(0);
        this.selectIterator = arrayList.iterator();
        io.dcloud.common.util.ThreadPool.self().addThreadTask(new java.lang.Runnable() { // from class: com.dmcbig.mediapicker.PickerActivity$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m210lambda$done$2$comdmcbigmediapickerPickerActivity(arrayList);
            }
        });
    }

    public void fitAndroid16WindowInsets(android.app.Activity activity, android.view.View view, final int i) {
        if (android.os.Build.VERSION.SDK_INT < 36 || io.dcloud.common.adapter.util.AndroidResources.sAppTargetSdkVersion < 36) {
            return;
        }
        androidx.core.view.ViewCompat.setOnApplyWindowInsetsListener(view, new androidx.core.view.OnApplyWindowInsetsListener() { // from class: com.dmcbig.mediapicker.PickerActivity$$ExternalSyntheticLambda2
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final androidx.core.view.WindowInsetsCompat onApplyWindowInsets(android.view.View view2, androidx.core.view.WindowInsetsCompat windowInsetsCompat) {
                return this.f$0.m211x23cf9341(i, view2, windowInsetsCompat);
            }
        });
    }

    void getMediaData() {
        int intExtra = this.argsIntent.getIntExtra("select_mode", 101);
        if (intExtra == 101) {
            getLoaderManager().initLoader(intExtra, null, new com.dmcbig.mediapicker.data.MediaLoader(this, this));
        } else if (intExtra == 100) {
            getLoaderManager().initLoader(intExtra, null, new com.dmcbig.mediapicker.data.ImageLoader(this, this));
        } else if (intExtra == 102) {
            getLoaderManager().initLoader(intExtra, null, new com.dmcbig.mediapicker.data.VideoLoader(this, this));
        }
    }

    /* JADX INFO: renamed from: lambda$fitAndroid16WindowInsets$0$com-dmcbig-mediapicker-PickerActivity, reason: not valid java name */
    /* synthetic */ androidx.core.view.WindowInsetsCompat m211x23cf9341(int i, android.view.View view, androidx.core.view.WindowInsetsCompat windowInsetsCompat) {
        if (windowInsetsCompat != null) {
            int i2 = getResources().getConfiguration().orientation;
            if (i2 != 3 && i2 != 1) {
                androidx.core.graphics.Insets insets = windowInsetsCompat.getInsets(i);
                view.setPadding(insets.left, 0, insets.right, 0);
                return windowInsetsCompat;
            }
            view.setPadding(0, 0, 0, 0);
        }
        return windowInsetsCompat;
    }

    /* JADX INFO: renamed from: lambda$permissionBar$1$com-dmcbig-mediapicker-PickerActivity, reason: not valid java name */
    /* synthetic */ void m212lambda$permissionBar$1$comdmcbigmediapickerPickerActivity(android.view.View view) {
        if (androidx.core.app.ActivityCompat.shouldShowRequestPermissionRationale(this, com.hjq.permissions.Permission.READ_MEDIA_IMAGES)) {
            androidx.core.app.ActivityCompat.requestPermissions(this, new java.lang.String[]{com.hjq.permissions.Permission.READ_MEDIA_IMAGES}, com.dmcbig.mediapicker.PickerConfig.PERMISSION_REQUEST);
            return;
        }
        android.content.Intent intent = new android.content.Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(android.net.Uri.fromParts("package", getPackageName(), null));
        startActivityForResult(intent, com.dmcbig.mediapicker.PickerConfig.PERMISSION_REQUEST);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, android.content.Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent != null && intent.hasExtra(com.dmcbig.mediapicker.PickerConfig.FULL_IMAGE)) {
            this.fullImage.setSelected(intent.getBooleanExtra(com.dmcbig.mediapicker.PickerConfig.FULL_IMAGE, false));
            this.isCompress = !this.fullImage.isSelected();
        }
        if (i == 200) {
            java.util.ArrayList<com.dmcbig.mediapicker.entity.Media> parcelableArrayListExtra = intent.getParcelableArrayListExtra(com.dmcbig.mediapicker.PickerConfig.EXTRA_RESULT);
            if (i2 != 1990) {
                if (i2 == 19901026) {
                    done(parcelableArrayListExtra);
                    return;
                }
                return;
            }
            java.util.ArrayList<java.lang.Integer> integerArrayListExtra = intent.getIntegerArrayListExtra(com.dmcbig.mediapicker.PickerConfig.ORIGINAL_PREVIEW_INDEX);
            java.util.ArrayList parcelableArrayListExtra2 = intent.getParcelableArrayListExtra(com.dmcbig.mediapicker.PickerConfig.EDITED_PREVIEW_DATA);
            if (integerArrayListExtra != null && integerArrayListExtra.size() > 0 && parcelableArrayListExtra2 != null && parcelableArrayListExtra2.size() > 0) {
                java.util.ArrayList<com.dmcbig.mediapicker.entity.Media> medias = this.gridAdapter.getMedias();
                for (int i3 = 0; i3 < integerArrayListExtra.size(); i3++) {
                    int iIntValue = integerArrayListExtra.get(i3).intValue();
                    if (iIntValue >= 0) {
                        medias.set(iIntValue, (com.dmcbig.mediapicker.entity.Media) parcelableArrayListExtra2.get(i3));
                    }
                }
                this.gridAdapter.updateAdapter(medias);
            }
            this.gridAdapter.updateSelectAdapter(parcelableArrayListExtra);
            setButtonText();
            return;
        }
        if (i != 201) {
            if (i == com.dmcbig.mediapicker.PickerConfig.PERMISSION_SETTING) {
                boolean z = androidx.core.app.ActivityCompat.checkSelfPermission(this, com.hjq.permissions.Permission.READ_MEDIA_IMAGES) == -1;
                boolean z2 = androidx.core.app.ActivityCompat.checkSelfPermission(this, com.hjq.permissions.Permission.READ_MEDIA_VISUAL_USER_SELECTED) == -1;
                if (z && z2) {
                    this.mFolderAdapter.updateAdapter(new java.util.ArrayList<>());
                    return;
                } else {
                    this.isAddImageFor34 = z;
                    checkoutNeedShowPermissionBar();
                    return;
                }
            }
            return;
        }
        if (i2 != -1 || intent == null) {
            return;
        }
        int intExtra = intent.getIntExtra("IMAGE_INDEX", -1);
        int intExtra2 = intent.getIntExtra("_id", -1);
        if (intExtra2 == -1 || intExtra == -1) {
            return;
        }
        com.dmcbig.mediapicker.entity.Media media = new com.dmcbig.mediapicker.entity.Media(intent.getStringExtra("PATH"), intent.getStringExtra("_display_name"), intent.getLongExtra("date_added", java.lang.System.currentTimeMillis()), intent.getIntExtra("mime_type", 0), intent.getLongExtra("_size", 0L), intExtra2, intent.getStringExtra("PARENTPATH"));
        java.util.ArrayList<com.dmcbig.mediapicker.entity.Media> arrayList = new java.util.ArrayList<>();
        arrayList.add(media);
        done(arrayList);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        done(new java.util.ArrayList<>());
        super.onBackPressed();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(android.view.View view) {
        int id = view.getId();
        if (id == com.dmcbig.mediapicker.MediaPickerR.MP_ID_BTN_BACK) {
            done(new java.util.ArrayList<>());
            return;
        }
        if (id == com.dmcbig.mediapicker.MediaPickerR.MP_ID_CATEGORY_BTN) {
            if (this.mFolderPopupWindow.isShowing()) {
                this.mFolderPopupWindow.dismiss();
                return;
            } else {
                this.mFolderPopupWindow.show();
                return;
            }
        }
        if (id == com.dmcbig.mediapicker.MediaPickerR.MP_ID_DONE) {
            done(this.gridAdapter.getSelectMedias());
            return;
        }
        if (id != com.dmcbig.mediapicker.MediaPickerR.MP_ID_PREVIEW) {
            if (id == io.dcloud.base.R.id.check_origin_image_layout) {
                android.widget.ImageView imageView = this.fullImage;
                imageView.setSelected(!imageView.isSelected());
                this.isCompress = !this.fullImage.isSelected();
                return;
            }
            return;
        }
        int i = 0;
        if (this.gridAdapter.getSelectMedias().size() <= 0) {
            com.dcloud.android.widget.toast.ToastCompat.makeText((android.content.Context) this, (java.lang.CharSequence) getString(com.dmcbig.mediapicker.MediaPickerR.MP_STRING_SELECT_NULL), 0).show();
            return;
        }
        if (io.dcloud.common.util.PdrUtil.isEmpty(this.cropOptions)) {
            android.content.Intent intent = new android.content.Intent(this, (java.lang.Class<?>) com.dmcbig.mediapicker.PreviewActivity.class);
            intent.putExtra("max_select_count", this.argsIntent.getIntExtra("max_select_count", Integer.MAX_VALUE));
            java.util.ArrayList<com.dmcbig.mediapicker.entity.Media> selectMedias = this.gridAdapter.getSelectMedias();
            intent.putExtra(com.dmcbig.mediapicker.PickerConfig.PRE_RAW_LIST, selectMedias);
            java.util.ArrayList<java.lang.Integer> arrayList = new java.util.ArrayList<>();
            int size = selectMedias.size();
            while (i < size) {
                com.dmcbig.mediapicker.entity.Media media = selectMedias.get(i);
                i++;
                arrayList.add(java.lang.Integer.valueOf(this.gridAdapter.getItemIndex(media)));
            }
            intent.putExtra(com.dmcbig.mediapicker.PickerConfig.FULL_IMAGE, this.fullImage.isSelected());
            intent.putExtra(com.dmcbig.mediapicker.PickerConfig.SIZE_TYPE, this.argsIntent.getStringExtra(com.dmcbig.mediapicker.PickerConfig.SIZE_TYPE));
            intent.putIntegerArrayListExtra(com.dmcbig.mediapicker.PickerConfig.ORIGINAL_PREVIEW_INDEX, arrayList);
            intent.putExtra(com.dmcbig.mediapicker.PickerConfig.IMAGE_EDITABLE, this.argsIntent.getBooleanExtra(com.dmcbig.mediapicker.PickerConfig.IMAGE_EDITABLE, true));
            intent.putExtra(com.dmcbig.mediapicker.PickerConfig.DONE_BUTTON_TEXT, this.argsIntent.getStringExtra(com.dmcbig.mediapicker.PickerConfig.DONE_BUTTON_TEXT));
            intent.putExtra("select_mode", this.argsIntent.getIntExtra("select_mode", 101));
            startActivityForResult(intent, 200);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(android.content.res.Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(android.os.Bundle bundle) {
        java.lang.String stringExtra;
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 29) {
            getWindow().setNavigationBarContrastEnforced(false);
        }
        super.onCreate(bundle);
        requestWindowFeature(1);
        this.argsIntent = getIntent();
        setContentView(com.dmcbig.mediapicker.MediaPickerR.MP_LAYOUT_PICKER_MAIN);
        this.recyclerView = (androidx.recyclerview.widget.RecyclerView) findViewById(com.dmcbig.mediapicker.MediaPickerR.MP_ID_RECYCLER_VIEW);
        findViewById(com.dmcbig.mediapicker.MediaPickerR.MP_ID_BTN_BACK).setOnClickListener(this);
        setTitleBar();
        this.done = (android.widget.Button) findViewById(com.dmcbig.mediapicker.MediaPickerR.MP_ID_DONE);
        this.category_btn = (android.widget.Button) findViewById(com.dmcbig.mediapicker.MediaPickerR.MP_ID_CATEGORY_BTN);
        this.preview = (android.widget.Button) findViewById(com.dmcbig.mediapicker.MediaPickerR.MP_ID_PREVIEW);
        this.fullImage = (android.widget.ImageView) findViewById(io.dcloud.base.R.id.check_origin_image);
        if (this.argsIntent.getIntExtra("select_mode", 101) == 102) {
            boolean booleanExtra = this.argsIntent.getBooleanExtra(com.dmcbig.mediapicker.PickerConfig.COMPRESSED, false);
            this.isCompress = booleanExtra;
            this.fullImage.setSelected(!booleanExtra);
            findViewById(io.dcloud.base.R.id.check_origin_image_layout).setVisibility(8);
        } else {
            android.content.Intent intent = this.argsIntent;
            if (intent == null || !intent.hasExtra(com.dmcbig.mediapicker.PickerConfig.SIZE_TYPE) || (stringExtra = this.argsIntent.getStringExtra(com.dmcbig.mediapicker.PickerConfig.SIZE_TYPE)) == null) {
                this.isCompress = true;
                findViewById(io.dcloud.base.R.id.check_origin_image_layout).setOnClickListener(this);
            } else if (stringExtra.contains(com.taobao.weex.common.Constants.Value.ORIGINAL) && stringExtra.contains("compressed")) {
                this.isCompress = true;
                findViewById(io.dcloud.base.R.id.check_origin_image_layout).setOnClickListener(this);
            } else if (stringExtra.contains(com.taobao.weex.common.Constants.Value.ORIGINAL)) {
                this.isCompress = false;
                this.fullImage.setSelected(true);
            } else {
                this.isCompress = true;
                findViewById(io.dcloud.base.R.id.check_origin_image_layout).setVisibility(8);
            }
        }
        this.done.setOnClickListener(this);
        this.category_btn.setOnClickListener(this);
        this.preview.setOnClickListener(this);
        if (io.dcloud.common.util.BaseInfo.sGlobalFullScreen) {
            setFullScreen(this, true);
        }
        this.cropOptions = this.argsIntent.getStringExtra(com.dmcbig.mediapicker.PickerConfig.IMAGE_CROP);
        this.docPath = this.argsIntent.getStringExtra("doc_path");
        permissionBar();
        createAdapter();
        createFolderAdapter();
        getMediaData();
        getOtherArgs();
        setTopAndBottomBarColor();
        if (i < 36 || io.dcloud.common.adapter.util.AndroidResources.sAppTargetSdkVersion < 36) {
            return;
        }
        com.dmcbig.mediapicker.utils.ScreenUtils.fitAndroid16WindowInsets(this, findViewById(io.dcloud.base.R.id.top), android.view.WindowInsets.Type.statusBars());
        com.dmcbig.mediapicker.utils.ScreenUtils.fitAndroid16WindowInsets(this, findViewById(io.dcloud.base.R.id.footer), android.view.WindowInsets.Type.navigationBars());
        fitAndroid16WindowInsets(this, findViewById(io.dcloud.base.R.id.root), android.view.WindowInsets.Type.navigationBars());
    }

    @Override // com.dmcbig.mediapicker.data.DataCallback
    public void onData(java.util.ArrayList<com.dmcbig.mediapicker.entity.Folder> arrayList) {
        if (this.isAddImageFor34) {
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                com.dmcbig.mediapicker.entity.Folder folder = arrayList.get(i);
                i++;
                folder.addMedias(new com.dmcbig.mediapicker.entity.Media(io.dcloud.base.R.drawable.dcloud_gallery_permission_add + "", "", 0L, 3, 0L, Integer.MIN_VALUE, ""));
            }
        }
        setView(arrayList);
        this.category_btn.setText(arrayList.get(0).name);
        this.mFolderAdapter.updateAdapter(arrayList);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        io.dcloud.common.util.RuningAcitvityUtil.removeRuningActivity(getComponentName().getClassName());
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, java.lang.String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        boolean z = androidx.core.app.ActivityCompat.checkSelfPermission(this, com.hjq.permissions.Permission.READ_MEDIA_IMAGES) == -1;
        boolean z2 = androidx.core.app.ActivityCompat.checkSelfPermission(this, com.hjq.permissions.Permission.READ_MEDIA_VISUAL_USER_SELECTED) == -1;
        if (z && z2) {
            this.mFolderAdapter.updateAdapter(new java.util.ArrayList<>());
            return;
        }
        restartMediaData();
        if (z) {
            return;
        }
        this.isAddImageFor34 = z;
        findViewById(io.dcloud.base.R.id.dcloud_gallery_permission_bar).setVisibility(8);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        io.dcloud.common.util.RuningAcitvityUtil.putRuningActivity(this);
    }

    void restartMediaData() {
        int intExtra = this.argsIntent.getIntExtra("select_mode", 101);
        if (intExtra == 101) {
            getLoaderManager().restartLoader(intExtra, null, new com.dmcbig.mediapicker.data.MediaLoader(this, this));
        } else if (intExtra == 100) {
            getLoaderManager().restartLoader(intExtra, null, new com.dmcbig.mediapicker.data.ImageLoader(this, this));
        } else if (intExtra == 102) {
            getLoaderManager().restartLoader(intExtra, null, new com.dmcbig.mediapicker.data.VideoLoader(this, this));
        }
    }

    void setButtonText() {
        int intExtra = this.argsIntent.getIntExtra("max_select_count", Integer.MAX_VALUE);
        if (io.dcloud.common.util.PdrUtil.isEmpty(this.doneBtnText)) {
            this.doneBtnText = getString(com.dmcbig.mediapicker.MediaPickerR.MP_STRING_DONE);
        }
        if (intExtra == Integer.MAX_VALUE) {
            this.done.setText(this.doneBtnText + com.taobao.weex.el.parse.Operators.BRACKET_START_STR + this.gridAdapter.getSelectMedias().size() + com.taobao.weex.el.parse.Operators.BRACKET_END_STR);
        } else {
            this.done.setText(this.doneBtnText + com.taobao.weex.el.parse.Operators.BRACKET_START_STR + this.gridAdapter.getSelectMedias().size() + "/" + intExtra + com.taobao.weex.el.parse.Operators.BRACKET_END_STR);
        }
        if (!io.dcloud.common.util.PdrUtil.isEmpty(this.cropOptions)) {
            this.done.setVisibility(4);
            findViewById(com.dmcbig.mediapicker.MediaPickerR.MP_ID_PREVIEW).setVisibility(4);
            return;
        }
        this.preview.setText(getString(com.dmcbig.mediapicker.MediaPickerR.MP_STRING_PREVIEW) + com.taobao.weex.el.parse.Operators.BRACKET_START_STR + this.gridAdapter.getSelectMedias().size() + com.taobao.weex.el.parse.Operators.BRACKET_END_STR);
    }

    public void setFullScreen(android.app.Activity activity, boolean z) {
        android.view.Window window = activity.getWindow();
        if (z) {
            android.view.WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.flags |= 1024;
            window.setAttributes(attributes);
        } else {
            android.view.WindowManager.LayoutParams attributes2 = window.getAttributes();
            attributes2.flags &= -1025;
            window.setAttributes(attributes2);
        }
    }

    public void setTitleBar() {
        int intExtra = this.argsIntent.getIntExtra("select_mode", 101);
        if (intExtra == 101) {
            ((android.widget.TextView) findViewById(com.dmcbig.mediapicker.MediaPickerR.MP_ID_BAR_TITLE)).setText(getString(com.dmcbig.mediapicker.MediaPickerR.MP_STRING_SELECT_TITLE));
        } else if (intExtra == 100) {
            ((android.widget.TextView) findViewById(com.dmcbig.mediapicker.MediaPickerR.MP_ID_BAR_TITLE)).setText(getString(com.dmcbig.mediapicker.MediaPickerR.MP_STRING_SELECT_IMAGE_TITLE));
        } else if (intExtra == 102) {
            ((android.widget.TextView) findViewById(com.dmcbig.mediapicker.MediaPickerR.MP_ID_BAR_TITLE)).setText(getString(com.dmcbig.mediapicker.MediaPickerR.MP_STRING_SELECT_VIDEO_TITLE));
        }
    }

    void setView(java.util.ArrayList<com.dmcbig.mediapicker.entity.Folder> arrayList) {
        this.gridAdapter.updateAdapter(arrayList.get(0).getMedias());
        setButtonText();
        this.gridAdapter.setOnItemClickListener(new com.dmcbig.mediapicker.adapter.MediaGridAdapter.OnRecyclerViewItemClickListener() { // from class: com.dmcbig.mediapicker.PickerActivity.3
            @Override // com.dmcbig.mediapicker.adapter.MediaGridAdapter.OnRecyclerViewItemClickListener
            public void onAddMore() {
                androidx.core.app.ActivityCompat.requestPermissions(com.dmcbig.mediapicker.PickerActivity.this, new java.lang.String[]{com.hjq.permissions.Permission.READ_MEDIA_IMAGES}, com.dmcbig.mediapicker.PickerConfig.PERMISSION_REQUEST);
            }

            @Override // com.dmcbig.mediapicker.adapter.MediaGridAdapter.OnRecyclerViewItemClickListener
            public void onItemClick(android.view.View view, com.dmcbig.mediapicker.entity.Media media, java.util.ArrayList<com.dmcbig.mediapicker.entity.Media> arrayList2) {
                com.dmcbig.mediapicker.PickerActivity pickerActivity = com.dmcbig.mediapicker.PickerActivity.this;
                if (!pickerActivity.isSingle) {
                    pickerActivity.setButtonText();
                    return;
                }
                if (io.dcloud.common.util.PdrUtil.isEmpty(pickerActivity.cropOptions)) {
                    android.content.Intent intent = new android.content.Intent(com.dmcbig.mediapicker.PickerActivity.this, (java.lang.Class<?>) com.dmcbig.mediapicker.PreviewActivity.class);
                    intent.putExtra("max_select_count", com.dmcbig.mediapicker.PickerActivity.this.argsIntent.getIntExtra("max_select_count", Integer.MAX_VALUE));
                    intent.putExtra(com.dmcbig.mediapicker.PickerConfig.SINGLE_SELECT, true);
                    java.util.ArrayList arrayList3 = new java.util.ArrayList(1);
                    arrayList3.add(media);
                    java.util.ArrayList<java.lang.Integer> arrayList4 = new java.util.ArrayList<>();
                    arrayList4.add(java.lang.Integer.valueOf(com.dmcbig.mediapicker.PickerActivity.this.gridAdapter.getItemIndex(media)));
                    intent.putExtra(com.dmcbig.mediapicker.PickerConfig.PRE_RAW_LIST, arrayList3);
                    intent.putExtra(com.dmcbig.mediapicker.PickerConfig.FULL_IMAGE, com.dmcbig.mediapicker.PickerActivity.this.fullImage.isSelected());
                    intent.putExtra(com.dmcbig.mediapicker.PickerConfig.SIZE_TYPE, com.dmcbig.mediapicker.PickerActivity.this.argsIntent.getStringExtra(com.dmcbig.mediapicker.PickerConfig.SIZE_TYPE));
                    intent.putExtra("select_mode", com.dmcbig.mediapicker.PickerActivity.this.argsIntent.getIntExtra("select_mode", 101));
                    intent.putIntegerArrayListExtra(com.dmcbig.mediapicker.PickerConfig.ORIGINAL_PREVIEW_INDEX, arrayList4);
                    com.dmcbig.mediapicker.PickerActivity.this.startActivityForResult(intent, 200);
                    return;
                }
                if (".gif".equalsIgnoreCase(media.extension) || media.mediaType == 3) {
                    java.util.ArrayList<com.dmcbig.mediapicker.entity.Media> arrayList5 = new java.util.ArrayList<>();
                    arrayList5.add(media);
                    com.dmcbig.mediapicker.PickerActivity.this.done(arrayList5);
                    return;
                }
                android.content.Intent intent2 = new android.content.Intent(com.dmcbig.mediapicker.PickerActivity.this, (java.lang.Class<?>) io.dcloud.feature.gallery.imageedit.IMGEditActivity.class);
                int itemIndex = com.dmcbig.mediapicker.PickerActivity.this.gridAdapter.getItemIndex(media);
                intent2.putExtra("IMAGE_URI", android.net.Uri.parse(io.dcloud.common.adapter.util.DeviceInfo.FILE_PROTOCOL + media.path));
                intent2.putExtra("IMAGE_MEDIA_ID", media.id);
                intent2.putExtra("IMAGE_INDEX", itemIndex);
                intent2.putExtra("IMAGE_CROP", com.dmcbig.mediapicker.PickerActivity.this.cropOptions);
                com.dmcbig.mediapicker.PickerActivity.this.startActivityForResult(intent2, com.dmcbig.mediapicker.PickerConfig.CODE_PICKER_CROP);
            }
        });
    }

    private void setTopAndBottomBarColor() {
        android.view.Window window = getWindow();
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(android.graphics.Color.parseColor("#21282C"));
        window.setNavigationBarColor(android.graphics.Color.parseColor("#21282C"));
    }
}
