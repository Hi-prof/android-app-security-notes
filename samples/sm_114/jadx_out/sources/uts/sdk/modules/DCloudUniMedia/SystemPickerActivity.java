package uts.sdk.modules.DCloudUniMedia;

/* JADX INFO: loaded from: classes2.dex */
public class SystemPickerActivity extends androidx.fragment.app.FragmentActivity {
    public static final int DEFAULT_SELECTED_MAX_COUNT = Integer.MAX_VALUE;
    public static final java.lang.String DOC_PATH = "doc_path";
    public static final java.lang.String MAX_SELECT_COUNT = "max_select_count";
    public static final int PICKER_IMAGE = 100;
    public static final int PICKER_IMAGE_VIDEO = 101;
    public static final int PICKER_VIDEO = 102;
    public static final java.lang.String SELECT_MODE = "select_mode";
    int activityOrientation = Integer.MAX_VALUE;
    private boolean copyToPrivacyPath = false;
    private java.lang.String docPath;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(android.os.Bundle bundle) {
        androidx.activity.result.contract.ActivityResultContracts.PickVisualMedia.VisualMediaType visualMediaType;
        super.onCreate(bundle);
        setContentView(new android.widget.RelativeLayout(this));
        if (getIntent().hasExtra("page_orientation")) {
            int intExtra = getIntent().getIntExtra("page_orientation", 1);
            this.activityOrientation = intExtra;
            setRequestedOrientation(intExtra);
        }
        this.copyToPrivacyPath = getIntent().getBooleanExtra("copy_privacy_path", false);
        this.docPath = getIntent().getStringExtra("doc_path");
        int intExtra2 = getIntent().getIntExtra("select_mode", 101);
        int intExtra3 = getIntent().getIntExtra("max_select_count", Integer.MAX_VALUE);
        try {
            if (intExtra3 > android.provider.MediaStore.getPickImagesMaxLimit()) {
                intExtra3 = android.provider.MediaStore.getPickImagesMaxLimit();
            }
        } catch (java.lang.Throwable unused) {
            if (intExtra3 > 100) {
                intExtra3 = 100;
            }
        }
        androidx.activity.result.ActivityResultLauncher activityResultLauncherRegisterForActivityResult = null;
        switch (intExtra2) {
            case 100:
                visualMediaType = androidx.activity.result.contract.ActivityResultContracts.PickVisualMedia.ImageOnly.INSTANCE;
                break;
            case 101:
                visualMediaType = androidx.activity.result.contract.ActivityResultContracts.PickVisualMedia.ImageAndVideo.INSTANCE;
                break;
            case 102:
                visualMediaType = androidx.activity.result.contract.ActivityResultContracts.PickVisualMedia.VideoOnly.INSTANCE;
                break;
            default:
                visualMediaType = null;
                break;
        }
        if (intExtra3 == 1) {
            activityResultLauncherRegisterForActivityResult = registerForActivityResult(new androidx.activity.result.contract.ActivityResultContracts.PickVisualMedia(), new androidx.activity.result.ActivityResultCallback() { // from class: uts.sdk.modules.DCloudUniMedia.SystemPickerActivity$$ExternalSyntheticLambda1
                @Override // androidx.activity.result.ActivityResultCallback
                public final void onActivityResult(java.lang.Object obj) {
                    this.f$0.m2165xc81d2de2((android.net.Uri) obj);
                }
            });
        } else if (intExtra3 > 1) {
            activityResultLauncherRegisterForActivityResult = registerForActivityResult(new androidx.activity.result.contract.ActivityResultContracts.PickMultipleVisualMedia(intExtra3), new androidx.activity.result.ActivityResultCallback() { // from class: uts.sdk.modules.DCloudUniMedia.SystemPickerActivity$$ExternalSyntheticLambda2
                @Override // androidx.activity.result.ActivityResultCallback
                public final void onActivityResult(java.lang.Object obj) {
                    this.f$0.m2166x5557df63((java.util.List) obj);
                }
            });
        }
        if (activityResultLauncherRegisterForActivityResult != null && visualMediaType != null) {
            activityResultLauncherRegisterForActivityResult.launch(new androidx.activity.result.PickVisualMediaRequest.Builder().setMediaType(visualMediaType).build());
        } else {
            setResult(0);
            finish();
        }
    }

    /* JADX INFO: renamed from: lambda$onCreate$0$uts-sdk-modules-DCloudUniMedia-SystemPickerActivity, reason: not valid java name */
    /* synthetic */ void m2165xc81d2de2(android.net.Uri uri) {
        if (uri != null) {
            onChooseFinish(uri);
        } else {
            setResult(0);
            finish();
        }
    }

    /* JADX INFO: renamed from: lambda$onCreate$1$uts-sdk-modules-DCloudUniMedia-SystemPickerActivity, reason: not valid java name */
    /* synthetic */ void m2166x5557df63(java.util.List list) {
        if (list != null && !list.isEmpty()) {
            onChooseFinish((android.net.Uri[]) list.toArray(new android.net.Uri[0]));
        } else {
            setResult(0);
            finish();
        }
    }

    private void onChooseFinish(android.net.Uri... uriArr) {
        if (uriArr != null && uriArr.length > 0) {
            setTopAndBottomBarColor();
            compress(java.util.Arrays.asList(uriArr).iterator(), new java.util.ArrayList<>());
        } else {
            setResult(0);
            finish();
        }
    }

    private void compress(java.util.Iterator<android.net.Uri> it, final java.util.ArrayList<uts.sdk.modules.DCloudUniMedia.Media> arrayList) {
        java.lang.String string;
        while (it.hasNext()) {
            android.net.Uri next = it.next();
            getContentResolver().takePersistableUriPermission(next, 1);
            java.lang.String type = getContentResolver().getType(next);
            if (this.copyToPrivacyPath && type != null && type.startsWith("image/")) {
                string = this.docPath + java.lang.System.currentTimeMillis() + "_" + getFileName(next);
                if (!copyFile(next, string, this)) {
                    string = next.toString();
                }
            } else {
                string = next.toString();
            }
            arrayList.add(makeMedia(string));
        }
        runOnUiThread(new java.lang.Runnable() { // from class: uts.sdk.modules.DCloudUniMedia.SystemPickerActivity$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m2164x850f614b(arrayList);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$compress$2$uts-sdk-modules-DCloudUniMedia-SystemPickerActivity, reason: not valid java name */
    /* synthetic */ void m2164x850f614b(java.util.ArrayList arrayList) {
        android.content.Intent intent = new android.content.Intent();
        intent.putExtra(com.dmcbig.mediapicker.PickerConfig.EXTRA_RESULT, arrayList);
        setResult(-1, intent);
        finish();
    }

    private uts.sdk.modules.DCloudUniMedia.Media makeMedia(java.lang.String str) {
        uts.sdk.modules.DCloudUniMedia.Media media = new uts.sdk.modules.DCloudUniMedia.Media(str, "name", java.lang.System.currentTimeMillis(), 0, 0L, -1, "");
        new java.util.ArrayList().add(media);
        return media;
    }

    private void setTopAndBottomBarColor() {
        android.view.Window window = getWindow();
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(android.graphics.Color.parseColor("#99000000"));
        window.setNavigationBarColor(android.graphics.Color.parseColor("#99000000"));
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x004b A[PHI: r1
  0x004b: PHI (r1v6 java.lang.String) = (r1v0 java.lang.String), (r1v7 java.lang.String) binds: [B:19:0x0046, B:21:0x0049] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:26:0x0056  */
    /* JADX WARN: Code duplicated, block: B:28:0x0064  */
    /* JADX WARN: Code duplicated, block: B:29:0x0067  */
    /* JADX WARN: Code duplicated, block: B:34:? A[RETURN, SYNTHETIC] */
    private java.lang.String getFileName(android.net.Uri uri) {
        android.net.Uri uri2;
        java.lang.String type;
        java.lang.String strSubstring;
        java.lang.String string = null;
        if (android.text.TextUtils.isEmpty(uri.getScheme()) || !uri.getScheme().equals(com.facebook.common.util.UriUtil.LOCAL_CONTENT_SCHEME)) {
            uri2 = uri;
        } else {
            uri2 = uri;
            android.database.Cursor cursorQuery = getContentResolver().query(uri2, null, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        int columnIndex = cursorQuery.getColumnIndex("_display_name");
                        if (!cursorQuery.isNull(columnIndex)) {
                            string = cursorQuery.getString(columnIndex);
                        }
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                } catch (java.lang.Exception unused) {
                    if (cursorQuery != null) {
                    }
                    if (android.text.TextUtils.isEmpty(string)) {
                        return string;
                    }
                    type = getContentResolver().getType(uri2);
                    if (android.text.TextUtils.isEmpty(type)) {
                        strSubstring = "jpg";
                    } else {
                        strSubstring = type.substring(type.indexOf("/") + 1);
                    }
                    return java.lang.System.currentTimeMillis() + com.taobao.weex.el.parse.Operators.DOT_STR + strSubstring;
                } catch (java.lang.Throwable th) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    throw th;
                }
            } else if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
        if (android.text.TextUtils.isEmpty(string)) {
            return string;
        }
        type = getContentResolver().getType(uri2);
        if (android.text.TextUtils.isEmpty(type)) {
            strSubstring = "jpg";
        } else {
            strSubstring = type.substring(type.indexOf("/") + 1);
        }
        return java.lang.System.currentTimeMillis() + com.taobao.weex.el.parse.Operators.DOT_STR + strSubstring;
    }

    public boolean copyFile(android.net.Uri uri, java.lang.String str, android.content.Context context) {
        try {
            java.io.File file = new java.io.File(str);
            if (!file.exists()) {
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                if (file.exists()) {
                    file.createNewFile();
                }
            }
            java.io.InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
            java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(str);
            byte[] bArr = new byte[1024];
            while (true) {
                int i = inputStreamOpenInputStream.read(bArr);
                if (i != -1) {
                    fileOutputStream.write(bArr, 0, i);
                } else {
                    inputStreamOpenInputStream.close();
                    fileOutputStream.close();
                    return true;
                }
            }
        } catch (java.lang.Exception unused) {
            return false;
        }
    }
}
