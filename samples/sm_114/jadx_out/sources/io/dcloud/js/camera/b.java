package io.dcloud.js.camera;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
abstract class b {
    /* JADX WARN: Code duplicated, block: B:24:0x002e A[Catch: Exception -> 0x002a, TRY_LEAVE, TryCatch #3 {Exception -> 0x002a, blocks: (B:20:0x0026, B:24:0x002e), top: B:42:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x0041 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:36:0x0043 A[Catch: Exception -> 0x003f, TRY_LEAVE, TryCatch #0 {Exception -> 0x003f, blocks: (B:32:0x003b, B:36:0x0043), top: B:40:0x003b }] */
    /* JADX WARN: Code duplicated, block: B:40:0x003b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static java.lang.String a(android.graphics.Bitmap bitmap, java.lang.String str) throws java.lang.Throwable {
        java.io.FileOutputStream fileOutputStream;
        java.io.FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new java.io.FileOutputStream(str);
            try {
                bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                try {
                    fileOutputStream.close();
                    bitmap.recycle();
                    return str;
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                    return str;
                }
            } catch (java.lang.Exception e2) {
                e = e2;
                try {
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                            if (bitmap != null) {
                                bitmap.recycle();
                            }
                        } catch (java.lang.Exception e3) {
                            e3.printStackTrace();
                            return null;
                        }
                    } else if (bitmap != null) {
                        bitmap.recycle();
                    }
                    return null;
                } catch (java.lang.Throwable th) {
                    th = th;
                    fileOutputStream2 = fileOutputStream;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                            if (bitmap != null) {
                                bitmap.recycle();
                            }
                        } catch (java.lang.Exception e4) {
                            e4.printStackTrace();
                            throw th;
                        }
                    } else if (bitmap != null) {
                        bitmap.recycle();
                    }
                    throw th;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                    if (bitmap != null) {
                        bitmap.recycle();
                    }
                } else if (bitmap != null) {
                    bitmap.recycle();
                }
                throw th;
            }
        } catch (java.lang.Exception e5) {
            e = e5;
            fileOutputStream = null;
        } catch (java.lang.Throwable th3) {
            th = th3;
            fileOutputStream = fileOutputStream2;
            if (fileOutputStream != null) {
                fileOutputStream.close();
                if (bitmap != null) {
                    bitmap.recycle();
                }
            } else if (bitmap != null) {
                bitmap.recycle();
            }
            throw th;
        }
    }

    public static android.graphics.Bitmap b(java.lang.String str) {
        return android.graphics.BitmapFactory.decodeFile(str, new android.graphics.BitmapFactory.Options());
    }

    public static int c(java.lang.String str) {
        try {
            int attributeInt = new android.media.ExifInterface(str).getAttributeInt("Orientation", 1);
            if (attributeInt == 3) {
                return 180;
            }
            if (attributeInt != 6) {
                return attributeInt != 8 ? 0 : 270;
            }
            return 90;
        } catch (java.io.IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static java.lang.String a(java.lang.String str) {
        int iC = c(str);
        if (iC == 0) {
            return str;
        }
        android.graphics.Bitmap bitmapB = b(str);
        if (bitmapB == null) {
            return null;
        }
        return a(a(iC, bitmapB), str);
    }

    public static android.graphics.Bitmap a(int i, android.graphics.Bitmap bitmap) {
        android.graphics.Bitmap bitmap2;
        android.graphics.Bitmap bitmapCreateBitmap;
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        matrix.postRotate(i);
        try {
            bitmap2 = bitmap;
            try {
                bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(bitmap2, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            } catch (java.lang.OutOfMemoryError unused) {
                bitmapCreateBitmap = null;
            }
        } catch (java.lang.OutOfMemoryError unused2) {
            bitmap2 = bitmap;
        }
        if (bitmapCreateBitmap == null) {
            bitmapCreateBitmap = bitmap2;
        }
        if (bitmap2 != bitmapCreateBitmap) {
            bitmap2.recycle();
        }
        return bitmapCreateBitmap;
    }

    public static android.app.Dialog a(android.content.Context context) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(context, io.dcloud.base.R.style.dialog_transparent);
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) android.view.LayoutInflater.from(context).inflate(io.dcloud.base.R.layout.dcloud_dialog_loading, (android.view.ViewGroup) null);
        viewGroup.findViewById(io.dcloud.base.R.id.loading_background).setBackgroundColor(0);
        android.app.AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.setCanceledOnTouchOutside(false);
        alertDialogCreate.setView(viewGroup, 0, 0, 0, 0);
        return alertDialogCreate;
    }
}
