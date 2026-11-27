package com.dmcbig.mediapicker;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class PreviewActivity extends androidx.fragment.app.FragmentActivity implements android.view.View.OnClickListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener {
    android.widget.TextView bar_title;
    android.view.View bottom;
    android.widget.ImageView check_image;
    android.widget.LinearLayout check_layout;
    android.widget.Button done;
    private java.lang.Class editActivityClass;
    java.util.ArrayList<androidx.fragment.app.Fragment> fragmentArrayList;
    android.widget.ImageView fullImage;
    android.widget.TextView imageEdit;
    private int max;
    java.util.ArrayList<com.dmcbig.mediapicker.entity.Media> preRawList;
    java.util.ArrayList<com.dmcbig.mediapicker.entity.Media> selects;
    android.view.View top;
    androidx.viewpager.widget.ViewPager viewpager;
    boolean isSingle = false;
    private boolean editable = true;
    java.lang.String doneBtnText = "";

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public class AdapterFragment extends androidx.fragment.app.FragmentStatePagerAdapter {
        private java.util.List<androidx.fragment.app.Fragment> mFragments;

        public AdapterFragment(androidx.fragment.app.FragmentManager fragmentManager, java.util.List<androidx.fragment.app.Fragment> list) {
            super(fragmentManager);
            this.mFragments = list;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.mFragments.size();
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter
        public androidx.fragment.app.Fragment getItem(int i) {
            return this.mFragments.get(i);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(java.lang.Object obj) {
            return -2;
        }
    }

    public void done(java.util.ArrayList<com.dmcbig.mediapicker.entity.Media> arrayList, int i) {
        android.content.Intent intent = new android.content.Intent();
        intent.putParcelableArrayListExtra(com.dmcbig.mediapicker.PickerConfig.EXTRA_RESULT, arrayList);
        intent.putIntegerArrayListExtra(com.dmcbig.mediapicker.PickerConfig.ORIGINAL_PREVIEW_INDEX, getIntent().getIntegerArrayListExtra(com.dmcbig.mediapicker.PickerConfig.ORIGINAL_PREVIEW_INDEX));
        intent.putParcelableArrayListExtra(com.dmcbig.mediapicker.PickerConfig.EDITED_PREVIEW_DATA, this.preRawList);
        intent.putExtra(com.dmcbig.mediapicker.PickerConfig.FULL_IMAGE, this.fullImage.isSelected());
        setResult(i, intent);
        finish();
    }

    public void fitAndroid16WindowInsets(android.app.Activity activity, android.view.View view, final int i) {
        if (android.os.Build.VERSION.SDK_INT < 36 || io.dcloud.common.adapter.util.AndroidResources.sAppTargetSdkVersion < 36) {
            return;
        }
        androidx.core.view.ViewCompat.setOnApplyWindowInsetsListener(view, new androidx.core.view.OnApplyWindowInsetsListener() { // from class: com.dmcbig.mediapicker.PreviewActivity$$ExternalSyntheticLambda0
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final androidx.core.view.WindowInsetsCompat onApplyWindowInsets(android.view.View view2, androidx.core.view.WindowInsetsCompat windowInsetsCompat) {
                return this.f$0.m213x6dc081f3(i, view2, windowInsetsCompat);
            }
        });
    }

    public int isSelect(com.dmcbig.mediapicker.entity.Media media, java.util.ArrayList<com.dmcbig.mediapicker.entity.Media> arrayList) {
        if (arrayList.size() <= 0) {
            return -1;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).path.equals(media.path)) {
                return i;
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: lambda$fitAndroid16WindowInsets$0$com-dmcbig-mediapicker-PreviewActivity, reason: not valid java name */
    /* synthetic */ androidx.core.view.WindowInsetsCompat m213x6dc081f3(int i, android.view.View view, androidx.core.view.WindowInsetsCompat windowInsetsCompat) {
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

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, android.content.Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 0 && intent != null) {
            int intExtra = intent.getIntExtra("IMAGE_INDEX", -1);
            int intExtra2 = intent.getIntExtra("_id", -1);
            if (intExtra2 == -1 || intExtra == -1) {
                return;
            }
            com.dmcbig.mediapicker.entity.Media media = new com.dmcbig.mediapicker.entity.Media(intent.getStringExtra("PATH"), intent.getStringExtra("_display_name"), intent.getLongExtra("date_added", java.lang.System.currentTimeMillis()), intent.getIntExtra("mime_type", 0), intent.getLongExtra("_size", 0L), intExtra2, intent.getStringExtra("PARENTPATH"));
            int iIsSelect = isSelect(this.preRawList.get(intExtra), this.selects);
            if (iIsSelect >= 0) {
                this.selects.set(iIsSelect, media);
            }
            this.preRawList.set(intExtra, media);
            this.fragmentArrayList.set(intExtra, com.dmcbig.mediapicker.view.PreviewFragment.newInstance(media, ""));
            this.viewpager.getAdapter().notifyDataSetChanged();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        done(this.selects, com.dmcbig.mediapicker.PickerConfig.RESULT_UPDATE_CODE);
        super.onBackPressed();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(android.view.View view) {
        int id = view.getId();
        if (id == com.dmcbig.mediapicker.MediaPickerR.MP_ID_BTN_BACK) {
            done(this.selects, com.dmcbig.mediapicker.PickerConfig.RESULT_UPDATE_CODE);
            return;
        }
        if (id == com.dmcbig.mediapicker.MediaPickerR.MP_ID_DONE) {
            done(this.selects, com.dmcbig.mediapicker.PickerConfig.RESULT_CODE);
            return;
        }
        if (id == com.dmcbig.mediapicker.MediaPickerR.MP_ID_CHECK_LAYOUT) {
            com.dmcbig.mediapicker.entity.Media media = this.preRawList.get(this.viewpager.getCurrentItem());
            int iIsSelect = isSelect(media, this.selects);
            if (iIsSelect < 0) {
                this.check_image.setImageDrawable(androidx.core.content.ContextCompat.getDrawable(this, com.dmcbig.mediapicker.MediaPickerR.MP_DRAWABLE_BNT_SELECTED));
                this.selects.add(media);
            } else {
                this.check_image.setImageDrawable(androidx.core.content.ContextCompat.getDrawable(this, com.dmcbig.mediapicker.MediaPickerR.MP_DRAWABLE_BNT_UNSELECTED));
                this.selects.remove(iIsSelect);
            }
            setDoneView(this.selects.size());
            return;
        }
        if (id != io.dcloud.base.R.id.gallery_preview_edit) {
            if (id == io.dcloud.base.R.id.check_origin_image_layout) {
                android.widget.ImageView imageView = this.fullImage;
                imageView.setSelected(!imageView.isSelected());
                return;
            }
            return;
        }
        int currentItem = this.viewpager.getCurrentItem();
        com.dmcbig.mediapicker.entity.Media media2 = this.preRawList.get(currentItem);
        android.content.Intent intent = new android.content.Intent(this, (java.lang.Class<?>) this.editActivityClass);
        intent.putExtra("IMAGE_URI", android.net.Uri.parse(io.dcloud.common.adapter.util.DeviceInfo.FILE_PROTOCOL + media2.path));
        intent.putExtra("IMAGE_MEDIA_ID", media2.id);
        intent.putExtra("IMAGE_INDEX", currentItem);
        startActivityForResult(intent, 0);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            getWindow().setNavigationBarContrastEnforced(false);
        }
        setContentView(com.dmcbig.mediapicker.MediaPickerR.MP_LAYOUT_PREVIEW_MAIN);
        setTopAndBottomBarColor();
        findViewById(com.dmcbig.mediapicker.MediaPickerR.MP_ID_BTN_BACK).setOnClickListener(this);
        this.isSingle = getIntent().getBooleanExtra(com.dmcbig.mediapicker.PickerConfig.SINGLE_SELECT, false);
        this.check_image = (android.widget.ImageView) findViewById(com.dmcbig.mediapicker.MediaPickerR.MP_ID_CHECK_IMAGE);
        android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) findViewById(com.dmcbig.mediapicker.MediaPickerR.MP_ID_CHECK_LAYOUT);
        this.check_layout = linearLayout;
        linearLayout.setOnClickListener(this);
        this.bar_title = (android.widget.TextView) findViewById(com.dmcbig.mediapicker.MediaPickerR.MP_ID_BAR_TITLE);
        android.widget.Button button = (android.widget.Button) findViewById(com.dmcbig.mediapicker.MediaPickerR.MP_ID_DONE);
        this.done = button;
        button.setOnClickListener(this);
        this.top = findViewById(com.dmcbig.mediapicker.MediaPickerR.MP_ID_TOP);
        this.bottom = findViewById(com.dmcbig.mediapicker.MediaPickerR.MP_ID_BOTTOM);
        android.widget.TextView textView = (android.widget.TextView) findViewById(io.dcloud.base.R.id.gallery_preview_edit);
        this.imageEdit = textView;
        textView.setOnClickListener(this);
        this.fullImage = (android.widget.ImageView) findViewById(io.dcloud.base.R.id.check_origin_image);
        this.fullImage.setSelected(getIntent().getBooleanExtra(com.dmcbig.mediapicker.PickerConfig.FULL_IMAGE, false));
        java.lang.String stringExtra = getIntent().getStringExtra(com.dmcbig.mediapicker.PickerConfig.SIZE_TYPE);
        if (stringExtra == null) {
            findViewById(io.dcloud.base.R.id.check_origin_image_layout).setOnClickListener(this);
        } else if (stringExtra.contains(com.taobao.weex.common.Constants.Value.ORIGINAL) && stringExtra.contains("compressed")) {
            findViewById(io.dcloud.base.R.id.check_origin_image_layout).setOnClickListener(this);
        } else if (!stringExtra.contains(com.taobao.weex.common.Constants.Value.ORIGINAL)) {
            findViewById(io.dcloud.base.R.id.check_origin_image_layout).setVisibility(8);
        }
        if (getIntent().getIntExtra("select_mode", 101) == 102) {
            findViewById(io.dcloud.base.R.id.check_origin_image_layout).setVisibility(8);
        }
        this.editable = getIntent().getBooleanExtra(com.dmcbig.mediapicker.PickerConfig.IMAGE_EDITABLE, true);
        java.lang.String stringExtra2 = getIntent().getStringExtra(com.dmcbig.mediapicker.PickerConfig.DONE_BUTTON_TEXT);
        this.doneBtnText = stringExtra2;
        if (!io.dcloud.common.util.PdrUtil.isEmpty(stringExtra2)) {
            this.done.setText(this.doneBtnText);
        }
        this.max = getIntent().getIntExtra("max_select_count", Integer.MAX_VALUE);
        try {
            this.editActivityClass = java.lang.Class.forName("io.dcloud.feature.gallery.imageedit.IMGEditActivity");
        } catch (java.lang.ClassNotFoundException unused) {
        }
        if (this.isSingle) {
            this.bottom.setVisibility(8);
        }
        this.viewpager = (androidx.viewpager.widget.ViewPager) findViewById(com.dmcbig.mediapicker.MediaPickerR.MP_ID_VIEWPAGER);
        this.preRawList = getIntent().getParcelableArrayListExtra(com.dmcbig.mediapicker.PickerConfig.PRE_RAW_LIST);
        this.selects = new java.util.ArrayList<>();
        java.util.ArrayList<com.dmcbig.mediapicker.entity.Media> arrayList = this.preRawList;
        if (arrayList == null || arrayList.size() == 0) {
            onBackPressed();
            return;
        }
        this.selects.addAll(this.preRawList);
        if (io.dcloud.common.util.BaseInfo.sGlobalFullScreen) {
            setFullScreen(this, true);
        }
        setView(this.preRawList);
        if (android.os.Build.VERSION.SDK_INT < 36 || io.dcloud.common.adapter.util.AndroidResources.sAppTargetSdkVersion < 36) {
            return;
        }
        com.dmcbig.mediapicker.utils.ScreenUtils.fitAndroid16WindowInsets(this, findViewById(io.dcloud.base.R.id.top), android.view.WindowInsets.Type.statusBars());
        com.dmcbig.mediapicker.utils.ScreenUtils.fitAndroid16WindowInsets(this, findViewById(io.dcloud.base.R.id.bottom), android.view.WindowInsets.Type.navigationBars());
        fitAndroid16WindowInsets(this, findViewById(io.dcloud.base.R.id.root), android.view.WindowInsets.Type.navigationBars());
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.bar_title.setText((i + 1) + "/" + this.preRawList.size());
        com.dmcbig.mediapicker.entity.Media media = this.preRawList.get(i);
        if (".gif".equalsIgnoreCase(media.extension) || this.editActivityClass == null || media.mediaType == 3 || !this.editable) {
            this.imageEdit.setVisibility(4);
        } else {
            this.imageEdit.setVisibility(0);
        }
        this.check_image.setImageDrawable(androidx.core.content.ContextCompat.getDrawable(this, isSelect(media, this.selects) < 0 ? com.dmcbig.mediapicker.MediaPickerR.MP_DRAWABLE_BNT_UNSELECTED : com.dmcbig.mediapicker.MediaPickerR.MP_DRAWABLE_BNT_SELECTED));
    }

    public void setBarStatus() {
        android.util.Log.e("setBarStatus", "setBarStatus");
        if (this.top.getVisibility() == 0) {
            this.top.setVisibility(8);
            if (this.isSingle) {
                return;
            }
            this.bottom.setVisibility(8);
            return;
        }
        this.top.setVisibility(0);
        if (this.isSingle) {
            return;
        }
        this.bottom.setVisibility(0);
    }

    void setDoneView(int i) {
        if (io.dcloud.common.util.PdrUtil.isEmpty(this.doneBtnText)) {
            this.doneBtnText = getString(com.dmcbig.mediapicker.MediaPickerR.MP_STRING_DONE);
        }
        if (this.max == Integer.MAX_VALUE) {
            this.done.setText(this.doneBtnText + com.taobao.weex.el.parse.Operators.BRACKET_START_STR + i + com.taobao.weex.el.parse.Operators.BRACKET_END_STR);
            return;
        }
        this.done.setText(this.doneBtnText + com.taobao.weex.el.parse.Operators.BRACKET_START_STR + i + "/" + this.max + com.taobao.weex.el.parse.Operators.BRACKET_END_STR);
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

    void setView(java.util.ArrayList<com.dmcbig.mediapicker.entity.Media> arrayList) {
        setDoneView(arrayList.size());
        this.bar_title.setText("1/" + this.preRawList.size());
        int i = 0;
        com.dmcbig.mediapicker.entity.Media media = this.preRawList.get(0);
        if (".gif".equalsIgnoreCase(media.extension) || this.editActivityClass == null || media.mediaType == 3 || !this.editable) {
            this.imageEdit.setVisibility(4);
        }
        this.fragmentArrayList = new java.util.ArrayList<>();
        int size = arrayList.size();
        while (i < size) {
            com.dmcbig.mediapicker.entity.Media media2 = arrayList.get(i);
            i++;
            this.fragmentArrayList.add(com.dmcbig.mediapicker.view.PreviewFragment.newInstance(media2, ""));
        }
        this.viewpager.setAdapter(new com.dmcbig.mediapicker.PreviewActivity.AdapterFragment(getSupportFragmentManager(), this.fragmentArrayList));
        this.viewpager.addOnPageChangeListener(this);
    }

    private void setTopAndBottomBarColor() {
        android.view.Window window = getWindow();
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(android.graphics.Color.parseColor("#21282C"));
        window.setNavigationBarColor(android.graphics.Color.parseColor("#21282C"));
    }
}
