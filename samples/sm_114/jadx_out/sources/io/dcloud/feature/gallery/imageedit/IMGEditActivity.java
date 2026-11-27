package io.dcloud.feature.gallery.imageedit;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class IMGEditActivity extends io.dcloud.feature.gallery.imageedit.a {
    private boolean j = false;
    private int k = 0;
    private int l = 0;
    private int m = 80;
    private boolean n = true;
    private boolean o = false;
    private java.lang.String p;
    int q;

    @Override // io.dcloud.feature.gallery.imageedit.a, io.dcloud.p.j2.b
    public /* bridge */ /* synthetic */ void a() {
        super.a();
    }

    @Override // io.dcloud.feature.gallery.imageedit.a, io.dcloud.p.j2.b
    public /* bridge */ /* synthetic */ void b() {
        super.b();
    }

    @Override // io.dcloud.feature.gallery.imageedit.a
    public /* bridge */ /* synthetic */ void c(int i) {
        super.c(i);
    }

    @Override // io.dcloud.feature.gallery.imageedit.a
    public void e() {
        finish();
    }

    @Override // io.dcloud.feature.gallery.imageedit.a
    public void f() {
        if (!this.j) {
            this.a.a();
            b(this.a.getMode() == io.dcloud.p.k2.CLIP ? 1 : 0);
        } else if (io.dcloud.common.util.PdrUtil.isEmpty(this.p) || !this.p.equals("camera")) {
            finish();
        } else {
            startActivityForResult(new android.content.Intent("android.media.action.IMAGE_CAPTURE"), 0, androidx.core.app.ActivityOptionsCompat.makeCustomAnimation(this, 0, 0).toBundle());
        }
    }

    @Override // io.dcloud.feature.gallery.imageedit.a
    public void g() {
        org.json.JSONObject jSONObject;
        int i;
        java.lang.String stringExtra = getIntent().getStringExtra("IMAGE_CROP");
        this.q = getIntent().getIntExtra("IMAGE_MEDIA_ID", 0);
        if (android.text.TextUtils.isEmpty(stringExtra)) {
            jSONObject = null;
        } else {
            try {
                jSONObject = new org.json.JSONObject(stringExtra);
            } catch (org.json.JSONException unused) {
                jSONObject = null;
            }
        }
        if (jSONObject != null && jSONObject.length() > 1) {
            java.util.regex.Pattern patternCompile = java.util.regex.Pattern.compile("[^0-9]");
            try {
                this.k = java.lang.Integer.parseInt(patternCompile.matcher(jSONObject.optString("width")).replaceAll(""));
                this.l = java.lang.Integer.parseInt(patternCompile.matcher(jSONObject.optString("height")).replaceAll(""));
            } catch (java.lang.Exception unused2) {
            }
            this.m = jSONObject.optInt(com.taobao.weex.common.Constants.Name.QUALITY, 80);
            this.n = jSONObject.optBoolean("resize", true);
            int i2 = this.k;
            if (i2 > 0 && (i = this.l) > 0) {
                this.a.b(i2, i);
            }
            if (jSONObject.has("saveToAlbum")) {
                this.o = jSONObject.optBoolean("saveToAlbum", false);
            }
            a(io.dcloud.p.k2.CLIP);
            this.j = true;
        }
        this.p = getIntent().getStringExtra("IMAGE_SOURCE");
    }

    @Override // io.dcloud.feature.gallery.imageedit.a
    public void h() {
        android.graphics.Bitmap bitmapI;
        android.net.Uri uriInsert;
        int i;
        int i2;
        int i3;
        java.lang.String stringExtra = getIntent().getStringExtra("IMAGE_SAVE_PATH");
        java.lang.String str = java.lang.System.currentTimeMillis() + ".jpg";
        if (android.text.TextUtils.isEmpty(stringExtra)) {
            if (android.os.Build.VERSION.SDK_INT >= 29) {
                stringExtra = getExternalFilesDir(android.os.Environment.DIRECTORY_PICTURES).getAbsolutePath() + "/DImage/" + str;
            } else {
                stringExtra = android.os.Environment.getExternalStoragePublicDirectory(android.os.Environment.DIRECTORY_DCIM).getAbsolutePath() + "/DImage/" + str;
            }
        }
        java.lang.String str2 = stringExtra;
        if (android.text.TextUtils.isEmpty(str2) || (bitmapI = this.a.i()) == null) {
            setResult(0);
            finish();
            return;
        }
        if (this.q == -1001) {
            java.io.File file = new java.io.File(str2);
            if (!file.exists()) {
                finish();
            }
            try {
                java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file);
                android.graphics.Bitmap bitmapA = a(bitmapI);
                android.graphics.Bitmap.CompressFormat compressFormat = android.graphics.Bitmap.CompressFormat.JPEG;
                int i4 = this.m;
                if (i4 > 100) {
                    i3 = 100;
                } else {
                    i3 = i4 < 0 ? 80 : i4;
                }
                bitmapA.compress(compressFormat, i3, fileOutputStream);
            } catch (java.io.FileNotFoundException e) {
                e.printStackTrace();
            }
            setResult(-1, new android.content.Intent());
            finish();
            return;
        }
        if (this.j && !this.o) {
            java.lang.String str3 = getExternalCacheDir().getPath() + "/DImage/" + str;
            java.io.File file2 = new java.io.File(str3);
            try {
                if (!file2.getParentFile().exists()) {
                    file2.getParentFile().mkdirs();
                }
                if (!file2.exists()) {
                    file2.createNewFile();
                }
                java.io.FileOutputStream fileOutputStream2 = new java.io.FileOutputStream(file2);
                android.graphics.Bitmap bitmapA2 = a(bitmapI);
                android.graphics.Bitmap.CompressFormat compressFormat2 = android.graphics.Bitmap.CompressFormat.JPEG;
                int i5 = this.m;
                if (i5 > 100) {
                    i2 = 100;
                } else {
                    i2 = i5 < 0 ? 80 : i5;
                }
                bitmapA2.compress(compressFormat2, i2, fileOutputStream2);
            } catch (java.io.IOException unused) {
                setResult(0);
                finish();
            }
            android.content.Intent intent = new android.content.Intent();
            intent.putExtra("_id", Integer.MAX_VALUE);
            intent.putExtra("IMAGE_INDEX", getIntent().getIntExtra("IMAGE_INDEX", -1));
            intent.putExtra("PATH", str3);
            setResult(-1, intent);
            finish();
            return;
        }
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            android.content.ContentValues contentValues = new android.content.ContentValues();
            contentValues.put("datetaken", java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
            contentValues.put("mime_type", "image/jpeg");
            contentValues.put("is_pending", (java.lang.Integer) 0);
            contentValues.put("_display_name", str);
            contentValues.put("relative_path", android.os.Environment.DIRECTORY_PICTURES + "/DImage");
            uriInsert = getContentResolver().insert(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
            try {
                java.io.OutputStream outputStreamOpenOutputStream = getContentResolver().openOutputStream(uriInsert);
                if (this.j) {
                    android.graphics.Bitmap bitmapA3 = a(bitmapI);
                    android.graphics.Bitmap.CompressFormat compressFormat3 = android.graphics.Bitmap.CompressFormat.JPEG;
                    int i6 = this.m;
                    if (i6 > 100) {
                        i6 = 100;
                    } else if (i6 < 0) {
                        i6 = 80;
                    }
                    bitmapA3.compress(compressFormat3, i6, outputStreamOpenOutputStream);
                } else {
                    bitmapI.compress(android.graphics.Bitmap.CompressFormat.JPEG, 100, outputStreamOpenOutputStream);
                }
            } catch (java.io.FileNotFoundException unused2) {
            }
        } else {
            java.io.File file3 = new java.io.File(str2);
            if (!file3.exists()) {
                try {
                    java.io.File parentFile = file3.getParentFile();
                    if (parentFile != null && !parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    file3.createNewFile();
                } catch (java.io.IOException unused3) {
                }
            }
            try {
                java.io.FileOutputStream fileOutputStream3 = new java.io.FileOutputStream(file3);
                if (this.j) {
                    android.graphics.Bitmap bitmapA4 = a(bitmapI);
                    android.graphics.Bitmap.CompressFormat compressFormat4 = android.graphics.Bitmap.CompressFormat.JPEG;
                    int i7 = this.m;
                    if (i7 > 100) {
                        i7 = 100;
                    } else if (i7 < 0) {
                        i7 = 80;
                    }
                    bitmapA4.compress(compressFormat4, i7, fileOutputStream3);
                } else {
                    bitmapI.compress(android.graphics.Bitmap.CompressFormat.JPEG, 100, fileOutputStream3);
                }
            } catch (java.io.FileNotFoundException e2) {
                e2.printStackTrace();
            }
            android.content.ContentValues contentValues2 = new android.content.ContentValues();
            contentValues2.put("_data", str2);
            contentValues2.put("datetaken", java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
            contentValues2.put("mime_type", "image/jpeg");
            uriInsert = getContentResolver().insert(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues2);
        }
        android.net.Uri uri = uriInsert;
        android.content.Intent intent2 = new android.content.Intent();
        android.database.Cursor cursorQuery = getContentResolver().query(uri, new java.lang.String[]{"_display_name", "date_added", "mime_type", "_size", "_data", "_id"}, null, null, null);
        if (cursorQuery != null) {
            cursorQuery.moveToNext();
            java.lang.String string = cursorQuery.getString(cursorQuery.getColumnIndex("_display_name"));
            long j = cursorQuery.getLong(cursorQuery.getColumnIndex("date_added"));
            int i8 = cursorQuery.getInt(cursorQuery.getColumnIndex("mime_type"));
            long j2 = cursorQuery.getLong(cursorQuery.getColumnIndex("_size"));
            int i9 = cursorQuery.getInt(cursorQuery.getColumnIndex("_id"));
            java.lang.String string2 = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
            java.lang.String strA = a(string2);
            cursorQuery.close();
            intent2.putExtra("_display_name", string);
            intent2.putExtra("date_added", j);
            intent2.putExtra("mime_type", i8);
            intent2.putExtra("_size", j2);
            intent2.putExtra("_id", i9);
            intent2.putExtra("PARENTPATH", strA);
            i = -1;
            intent2.putExtra("IMAGE_INDEX", getIntent().getIntExtra("IMAGE_INDEX", -1));
            intent2.putExtra("PATH", string2);
        } else {
            i = -1;
        }
        setResult(i, intent2);
        finish();
    }

    @Override // io.dcloud.feature.gallery.imageedit.a
    public void i() {
        this.a.b();
        if (this.j) {
            h();
        } else {
            b(this.a.getMode() == io.dcloud.p.k2.CLIP ? 1 : 0);
        }
    }

    @Override // io.dcloud.feature.gallery.imageedit.a
    public void j() {
        this.a.h();
    }

    @Override // io.dcloud.feature.gallery.imageedit.a
    public void k() {
        this.a.c();
    }

    @Override // io.dcloud.feature.gallery.imageedit.a
    public /* bridge */ /* synthetic */ void l() {
        super.l();
    }

    @Override // io.dcloud.feature.gallery.imageedit.a
    public void m() {
        io.dcloud.p.k2 mode = this.a.getMode();
        if (mode == io.dcloud.p.k2.DOODLE) {
            this.a.k();
        } else if (mode == io.dcloud.p.k2.MOSAIC) {
            this.a.l();
        }
    }

    @Override // io.dcloud.feature.gallery.imageedit.a
    public /* bridge */ /* synthetic */ void n() {
        super.n();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, android.content.Intent intent) {
    }

    @Override // io.dcloud.feature.gallery.imageedit.a, android.app.Activity
    public /* bridge */ /* synthetic */ void onBackPressed() {
        super.onBackPressed();
    }

    @Override // io.dcloud.feature.gallery.imageedit.a, android.view.View.OnClickListener
    public /* bridge */ /* synthetic */ void onClick(android.view.View view) {
        super.onClick(view);
    }

    @Override // io.dcloud.feature.gallery.imageedit.a, android.content.DialogInterface.OnDismissListener
    public /* bridge */ /* synthetic */ void onDismiss(android.content.DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
    }

    @Override // io.dcloud.feature.gallery.imageedit.a, android.content.DialogInterface.OnShowListener
    public /* bridge */ /* synthetic */ void onShow(android.content.DialogInterface dialogInterface) {
        super.onShow(dialogInterface);
    }

    @Override // io.dcloud.feature.gallery.imageedit.b.a
    public void a(io.dcloud.p.r2 r2Var) {
        this.a.a(r2Var);
    }

    @Override // io.dcloud.feature.gallery.imageedit.a
    public /* bridge */ /* synthetic */ void b(int i) {
        super.b(i);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0041  */
    @Override // io.dcloud.feature.gallery.imageedit.a
    public android.graphics.Bitmap c() {
        android.net.Uri uri;
        io.dcloud.p.e2 f2Var;
        java.io.FileInputStream fileInputStream;
        java.io.InputStream inputStreamOpenInputStream;
        android.content.Intent intent = getIntent();
        if (intent == null || (uri = (android.net.Uri) intent.getParcelableExtra("IMAGE_URI")) == null) {
            return null;
        }
        if (android.text.TextUtils.isEmpty(uri.getPath())) {
            f2Var = null;
        } else {
            java.lang.String scheme = uri.getScheme();
            scheme.getClass();
            if (scheme.equals("file")) {
                f2Var = new io.dcloud.p.f2(uri);
            } else if (scheme.equals(com.facebook.common.util.UriUtil.LOCAL_ASSET_SCHEME)) {
                f2Var = new io.dcloud.p.b2(this, uri);
            } else {
                f2Var = null;
            }
        }
        if (f2Var == null) {
            return null;
        }
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inSampleSize = 1;
        options.inJustDecodeBounds = true;
        f2Var.a(options);
        int i = options.outWidth;
        if (i > 1024) {
            options.inSampleSize = io.dcloud.p.s2.a(java.lang.Math.round((i * 1.0f) / 1024.0f));
        }
        int i2 = options.outHeight;
        if (i2 > 1024) {
            options.inSampleSize = java.lang.Math.max(options.inSampleSize, io.dcloud.p.s2.a(java.lang.Math.round((i2 * 1.0f) / 1024.0f)));
        }
        options.inJustDecodeBounds = false;
        android.graphics.Bitmap bitmapA = f2Var.a(options);
        if (bitmapA != null) {
            return bitmapA;
        }
        int intExtra = getIntent().getIntExtra("IMAGE_MEDIA_ID", -1);
        if (intExtra == -1) {
            return null;
        }
        if (intExtra == -1001) {
            try {
                fileInputStream = new java.io.FileInputStream(new java.io.File(uri.getPath()));
            } catch (java.io.FileNotFoundException unused) {
                fileInputStream = null;
            }
            if (fileInputStream == null) {
                return null;
            }
            return android.graphics.BitmapFactory.decodeStream(fileInputStream, null, options);
        }
        try {
            inputStreamOpenInputStream = getContentResolver().openInputStream(android.content.ContentUris.withAppendedId(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, intExtra));
        } catch (java.io.FileNotFoundException unused2) {
            inputStreamOpenInputStream = null;
        }
        if (inputStreamOpenInputStream == null) {
            return null;
        }
        return io.dcloud.p.a0.a(inputStreamOpenInputStream, options);
    }

    @Override // io.dcloud.feature.gallery.imageedit.a
    public void a(io.dcloud.p.k2 k2Var) {
        if (this.a.getMode() == k2Var) {
            k2Var = io.dcloud.p.k2.NONE;
        }
        this.a.setMode(k2Var);
        n();
        if (k2Var == io.dcloud.p.k2.CLIP) {
            b(1);
        }
    }

    private android.graphics.Bitmap a(android.graphics.Bitmap bitmap) {
        if (!this.n || this.l <= 0 || this.k <= 0) {
            return bitmap;
        }
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        matrix.postScale(this.k / bitmap.getWidth(), this.l / bitmap.getHeight());
        return android.graphics.Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
    }

    @Override // io.dcloud.feature.gallery.imageedit.a
    public void a(int i) {
        this.a.setPenColor(i);
    }

    public java.lang.String a(java.lang.String str) {
        java.lang.String[] strArrSplit = str.split("/");
        return strArrSplit[strArrSplit.length - 2];
    }
}
