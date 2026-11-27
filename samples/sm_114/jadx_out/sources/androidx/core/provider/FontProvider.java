package androidx.core.provider;

/* JADX INFO: loaded from: classes.dex */
class FontProvider {
    private static final java.util.Comparator<byte[]> sByteArrayComparator = new java.util.Comparator() { // from class: androidx.core.provider.FontProvider$$ExternalSyntheticLambda0
        @Override // java.util.Comparator
        public final int compare(java.lang.Object obj, java.lang.Object obj2) {
            return androidx.core.provider.FontProvider.lambda$static$0((byte[]) obj, (byte[]) obj2);
        }
    };

    private FontProvider() {
    }

    static androidx.core.provider.FontsContractCompat.FontFamilyResult getFontFamilyResult(android.content.Context context, androidx.core.provider.FontRequest fontRequest, android.os.CancellationSignal cancellationSignal) throws android.content.pm.PackageManager.NameNotFoundException {
        android.content.pm.ProviderInfo provider = getProvider(context.getPackageManager(), fontRequest, context.getResources());
        if (provider == null) {
            return androidx.core.provider.FontsContractCompat.FontFamilyResult.create(1, null);
        }
        return androidx.core.provider.FontsContractCompat.FontFamilyResult.create(0, query(context, fontRequest, provider.authority, cancellationSignal));
    }

    static android.content.pm.ProviderInfo getProvider(android.content.pm.PackageManager packageManager, androidx.core.provider.FontRequest fontRequest, android.content.res.Resources resources) throws android.content.pm.PackageManager.NameNotFoundException {
        java.lang.String providerAuthority = fontRequest.getProviderAuthority();
        android.content.pm.ProviderInfo providerInfoResolveContentProvider = packageManager.resolveContentProvider(providerAuthority, 0);
        if (providerInfoResolveContentProvider == null) {
            throw new android.content.pm.PackageManager.NameNotFoundException("No package found for authority: " + providerAuthority);
        }
        if (!providerInfoResolveContentProvider.packageName.equals(fontRequest.getProviderPackage())) {
            throw new android.content.pm.PackageManager.NameNotFoundException("Found content provider " + providerAuthority + ", but package was not " + fontRequest.getProviderPackage());
        }
        java.util.List<byte[]> listConvertToByteArrayList = convertToByteArrayList(packageManager.getPackageInfo(providerInfoResolveContentProvider.packageName, 64).signatures);
        java.util.Collections.sort(listConvertToByteArrayList, sByteArrayComparator);
        java.util.List<java.util.List<byte[]>> certificates = getCertificates(fontRequest, resources);
        for (int i = 0; i < certificates.size(); i++) {
            java.util.ArrayList arrayList = new java.util.ArrayList(certificates.get(i));
            java.util.Collections.sort(arrayList, sByteArrayComparator);
            if (equalsByteArrayList(listConvertToByteArrayList, arrayList)) {
                return providerInfoResolveContentProvider;
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x00cd  */
    static androidx.core.provider.FontsContractCompat.FontInfo[] query(android.content.Context context, androidx.core.provider.FontRequest fontRequest, java.lang.String str, android.os.CancellationSignal cancellationSignal) throws java.lang.Throwable {
        androidx.core.provider.FontProvider.ContentQueryWrapper contentQueryWrapper;
        androidx.core.provider.FontProvider.ContentQueryWrapper contentQueryWrapper2;
        android.net.Uri uriWithAppendedId;
        boolean z;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        android.net.Uri uriBuild = new android.net.Uri.Builder().scheme(com.facebook.common.util.UriUtil.LOCAL_CONTENT_SCHEME).authority(str).build();
        android.net.Uri uriBuild2 = new android.net.Uri.Builder().scheme(com.facebook.common.util.UriUtil.LOCAL_CONTENT_SCHEME).authority(str).appendPath("file").build();
        androidx.core.provider.FontProvider.ContentQueryWrapper contentQueryWrapperMake = androidx.core.provider.FontProvider.ContentQueryWrapper.CC.make(context, uriBuild);
        android.database.Cursor cursorQuery = null;
        try {
            cursorQuery = contentQueryWrapperMake.query(uriBuild, new java.lang.String[]{"_id", androidx.core.provider.FontsContractCompat.Columns.FILE_ID, androidx.core.provider.FontsContractCompat.Columns.TTC_INDEX, androidx.core.provider.FontsContractCompat.Columns.VARIATION_SETTINGS, androidx.core.provider.FontsContractCompat.Columns.WEIGHT, androidx.core.provider.FontsContractCompat.Columns.ITALIC, androidx.core.provider.FontsContractCompat.Columns.RESULT_CODE}, "query = ?", new java.lang.String[]{fontRequest.getQuery()}, null, cancellationSignal);
            if (cursorQuery == null || cursorQuery.getCount() <= 0) {
                contentQueryWrapper2 = contentQueryWrapperMake;
            } else {
                int columnIndex = cursorQuery.getColumnIndex(androidx.core.provider.FontsContractCompat.Columns.RESULT_CODE);
                java.util.ArrayList arrayList2 = new java.util.ArrayList();
                int columnIndex2 = cursorQuery.getColumnIndex("_id");
                int columnIndex3 = cursorQuery.getColumnIndex(androidx.core.provider.FontsContractCompat.Columns.FILE_ID);
                int columnIndex4 = cursorQuery.getColumnIndex(androidx.core.provider.FontsContractCompat.Columns.TTC_INDEX);
                int columnIndex5 = cursorQuery.getColumnIndex(androidx.core.provider.FontsContractCompat.Columns.WEIGHT);
                int columnIndex6 = cursorQuery.getColumnIndex(androidx.core.provider.FontsContractCompat.Columns.ITALIC);
                while (cursorQuery.moveToNext()) {
                    int i = columnIndex != -1 ? cursorQuery.getInt(columnIndex) : 0;
                    int i2 = columnIndex4 != -1 ? cursorQuery.getInt(columnIndex4) : 0;
                    if (columnIndex3 == -1) {
                        contentQueryWrapper = contentQueryWrapperMake;
                        try {
                            uriWithAppendedId = android.content.ContentUris.withAppendedId(uriBuild, cursorQuery.getLong(columnIndex2));
                        } catch (java.lang.Throwable th) {
                            th = th;
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            contentQueryWrapper.close();
                            throw th;
                        }
                    } else {
                        contentQueryWrapper = contentQueryWrapperMake;
                        uriWithAppendedId = android.content.ContentUris.withAppendedId(uriBuild2, cursorQuery.getLong(columnIndex3));
                    }
                    int i3 = columnIndex5 != -1 ? cursorQuery.getInt(columnIndex5) : com.facebook.common.statfs.StatFsHelper.DEFAULT_DISK_YELLOW_LEVEL_IN_MB;
                    if (columnIndex6 != -1) {
                        z = true;
                        if (cursorQuery.getInt(columnIndex6) != 1) {
                            z = false;
                        }
                    } else {
                        z = false;
                    }
                    arrayList2.add(androidx.core.provider.FontsContractCompat.FontInfo.create(uriWithAppendedId, i2, i3, z, i));
                    contentQueryWrapperMake = contentQueryWrapper;
                }
                contentQueryWrapper2 = contentQueryWrapperMake;
                arrayList = arrayList2;
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            contentQueryWrapper2.close();
            return (androidx.core.provider.FontsContractCompat.FontInfo[]) arrayList.toArray(new androidx.core.provider.FontsContractCompat.FontInfo[0]);
        } catch (java.lang.Throwable th2) {
            th = th2;
            contentQueryWrapper = contentQueryWrapperMake;
        }
    }

    private static java.util.List<java.util.List<byte[]>> getCertificates(androidx.core.provider.FontRequest fontRequest, android.content.res.Resources resources) {
        if (fontRequest.getCertificates() != null) {
            return fontRequest.getCertificates();
        }
        return androidx.core.content.res.FontResourcesParserCompat.readCerts(resources, fontRequest.getCertificatesArrayResId());
    }

    static /* synthetic */ int lambda$static$0(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return bArr.length - bArr2.length;
        }
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i];
            byte b2 = bArr2[i];
            if (b != b2) {
                return b - b2;
            }
        }
        return 0;
    }

    private static boolean equalsByteArrayList(java.util.List<byte[]> list, java.util.List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!java.util.Arrays.equals(list.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static java.util.List<byte[]> convertToByteArrayList(android.content.pm.Signature[] signatureArr) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (android.content.pm.Signature signature : signatureArr) {
            arrayList.add(signature.toByteArray());
        }
        return arrayList;
    }

    private interface ContentQueryWrapper {
        void close();

        android.database.Cursor query(android.net.Uri uri, java.lang.String[] strArr, java.lang.String str, java.lang.String[] strArr2, java.lang.String str2, android.os.CancellationSignal cancellationSignal);

        /* JADX INFO: renamed from: androidx.core.provider.FontProvider$ContentQueryWrapper$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static androidx.core.provider.FontProvider.ContentQueryWrapper make(android.content.Context context, android.net.Uri uri) {
                if (android.os.Build.VERSION.SDK_INT < 24) {
                    return new androidx.core.provider.FontProvider.ContentQueryWrapperApi16Impl(context, uri);
                }
                return new androidx.core.provider.FontProvider.ContentQueryWrapperApi24Impl(context, uri);
            }
        }
    }

    private static class ContentQueryWrapperApi16Impl implements androidx.core.provider.FontProvider.ContentQueryWrapper {
        private final android.content.ContentProviderClient mClient;

        ContentQueryWrapperApi16Impl(android.content.Context context, android.net.Uri uri) {
            this.mClient = context.getContentResolver().acquireUnstableContentProviderClient(uri);
        }

        @Override // androidx.core.provider.FontProvider.ContentQueryWrapper
        public android.database.Cursor query(android.net.Uri uri, java.lang.String[] strArr, java.lang.String str, java.lang.String[] strArr2, java.lang.String str2, android.os.CancellationSignal cancellationSignal) {
            android.content.ContentProviderClient contentProviderClient = this.mClient;
            if (contentProviderClient == null) {
                return null;
            }
            try {
                return contentProviderClient.query(uri, strArr, str, strArr2, str2, cancellationSignal);
            } catch (android.os.RemoteException e) {
                android.util.Log.w("FontsProvider", "Unable to query the content provider", e);
                return null;
            }
        }

        @Override // androidx.core.provider.FontProvider.ContentQueryWrapper
        public void close() {
            android.content.ContentProviderClient contentProviderClient = this.mClient;
            if (contentProviderClient != null) {
                contentProviderClient.release();
            }
        }
    }

    private static class ContentQueryWrapperApi24Impl implements androidx.core.provider.FontProvider.ContentQueryWrapper {
        private final android.content.ContentProviderClient mClient;

        ContentQueryWrapperApi24Impl(android.content.Context context, android.net.Uri uri) {
            this.mClient = context.getContentResolver().acquireUnstableContentProviderClient(uri);
        }

        @Override // androidx.core.provider.FontProvider.ContentQueryWrapper
        public android.database.Cursor query(android.net.Uri uri, java.lang.String[] strArr, java.lang.String str, java.lang.String[] strArr2, java.lang.String str2, android.os.CancellationSignal cancellationSignal) {
            android.content.ContentProviderClient contentProviderClient = this.mClient;
            if (contentProviderClient == null) {
                return null;
            }
            try {
                return contentProviderClient.query(uri, strArr, str, strArr2, str2, cancellationSignal);
            } catch (android.os.RemoteException e) {
                android.util.Log.w("FontsProvider", "Unable to query the content provider", e);
                return null;
            }
        }

        @Override // androidx.core.provider.FontProvider.ContentQueryWrapper
        public void close() throws java.lang.Exception {
            android.content.ContentProviderClient contentProviderClient = this.mClient;
            if (contentProviderClient != null) {
                kotlin.UByte$$ExternalSyntheticBackport0.m((java.lang.Object) contentProviderClient);
            }
        }
    }
}
