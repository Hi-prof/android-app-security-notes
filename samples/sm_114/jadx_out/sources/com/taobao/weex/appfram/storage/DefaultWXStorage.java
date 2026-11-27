package com.taobao.weex.appfram.storage;

/* JADX INFO: loaded from: classes.dex */
public class DefaultWXStorage implements com.taobao.weex.appfram.storage.IWXStorageAdapter {
    private com.taobao.weex.appfram.storage.WXSQLiteOpenHelper mDatabaseSupplier;
    private java.util.concurrent.ExecutorService mExecutorService;

    private void execute(java.lang.Runnable runnable) {
        if (this.mExecutorService == null) {
            this.mExecutorService = java.util.concurrent.Executors.newSingleThreadExecutor();
        }
        if (runnable == null || this.mExecutorService.isShutdown() || this.mExecutorService.isTerminated()) {
            return;
        }
        this.mExecutorService.execute(com.taobao.weex.common.WXThread.secure(runnable));
    }

    public DefaultWXStorage(android.content.Context context) {
        this.mDatabaseSupplier = new com.taobao.weex.appfram.storage.WXSQLiteOpenHelper(context);
    }

    @Override // com.taobao.weex.appfram.storage.IWXStorageAdapter
    public void setItem(final java.lang.String str, final java.lang.String str2, final com.taobao.weex.appfram.storage.IWXStorageAdapter.OnResultReceivedListener onResultReceivedListener) {
        execute(new java.lang.Runnable() { // from class: com.taobao.weex.appfram.storage.DefaultWXStorage.1
            @Override // java.lang.Runnable
            public void run() {
                java.util.Map<java.lang.String, java.lang.Object> itemResult = com.taobao.weex.appfram.storage.StorageResultHandler.setItemResult(com.taobao.weex.appfram.storage.DefaultWXStorage.this.performSetItem(str, str2, false, true));
                com.taobao.weex.appfram.storage.IWXStorageAdapter.OnResultReceivedListener onResultReceivedListener2 = onResultReceivedListener;
                if (onResultReceivedListener2 == null) {
                    return;
                }
                onResultReceivedListener2.onReceived(itemResult);
            }
        });
    }

    @Override // com.taobao.weex.appfram.storage.IWXStorageAdapter
    public void getItem(final java.lang.String str, final com.taobao.weex.appfram.storage.IWXStorageAdapter.OnResultReceivedListener onResultReceivedListener) {
        execute(new java.lang.Runnable() { // from class: com.taobao.weex.appfram.storage.DefaultWXStorage.2
            @Override // java.lang.Runnable
            public void run() {
                java.util.Map<java.lang.String, java.lang.Object> itemResult = com.taobao.weex.appfram.storage.StorageResultHandler.getItemResult(com.taobao.weex.appfram.storage.DefaultWXStorage.this.performGetItem(str));
                com.taobao.weex.appfram.storage.IWXStorageAdapter.OnResultReceivedListener onResultReceivedListener2 = onResultReceivedListener;
                if (onResultReceivedListener2 == null) {
                    return;
                }
                onResultReceivedListener2.onReceived(itemResult);
            }
        });
    }

    @Override // com.taobao.weex.appfram.storage.IWXStorageAdapter
    public void removeItem(final java.lang.String str, final com.taobao.weex.appfram.storage.IWXStorageAdapter.OnResultReceivedListener onResultReceivedListener) {
        execute(new java.lang.Runnable() { // from class: com.taobao.weex.appfram.storage.DefaultWXStorage.3
            @Override // java.lang.Runnable
            public void run() {
                java.util.Map<java.lang.String, java.lang.Object> mapRemoveItemResult = com.taobao.weex.appfram.storage.StorageResultHandler.removeItemResult(com.taobao.weex.appfram.storage.DefaultWXStorage.this.performRemoveItem(str));
                com.taobao.weex.appfram.storage.IWXStorageAdapter.OnResultReceivedListener onResultReceivedListener2 = onResultReceivedListener;
                if (onResultReceivedListener2 == null) {
                    return;
                }
                onResultReceivedListener2.onReceived(mapRemoveItemResult);
            }
        });
    }

    @Override // com.taobao.weex.appfram.storage.IWXStorageAdapter
    public void length(final com.taobao.weex.appfram.storage.IWXStorageAdapter.OnResultReceivedListener onResultReceivedListener) {
        execute(new java.lang.Runnable() { // from class: com.taobao.weex.appfram.storage.DefaultWXStorage.4
            @Override // java.lang.Runnable
            public void run() {
                java.util.Map<java.lang.String, java.lang.Object> lengthResult = com.taobao.weex.appfram.storage.StorageResultHandler.getLengthResult(com.taobao.weex.appfram.storage.DefaultWXStorage.this.performGetLength());
                com.taobao.weex.appfram.storage.IWXStorageAdapter.OnResultReceivedListener onResultReceivedListener2 = onResultReceivedListener;
                if (onResultReceivedListener2 == null) {
                    return;
                }
                onResultReceivedListener2.onReceived(lengthResult);
            }
        });
    }

    @Override // com.taobao.weex.appfram.storage.IWXStorageAdapter
    public void getAllKeys(final com.taobao.weex.appfram.storage.IWXStorageAdapter.OnResultReceivedListener onResultReceivedListener) {
        execute(new java.lang.Runnable() { // from class: com.taobao.weex.appfram.storage.DefaultWXStorage.5
            @Override // java.lang.Runnable
            public void run() {
                java.util.Map<java.lang.String, java.lang.Object> allkeysResult = com.taobao.weex.appfram.storage.StorageResultHandler.getAllkeysResult(com.taobao.weex.appfram.storage.DefaultWXStorage.this.performGetAllKeys());
                com.taobao.weex.appfram.storage.IWXStorageAdapter.OnResultReceivedListener onResultReceivedListener2 = onResultReceivedListener;
                if (onResultReceivedListener2 == null) {
                    return;
                }
                onResultReceivedListener2.onReceived(allkeysResult);
            }
        });
    }

    @Override // com.taobao.weex.appfram.storage.IWXStorageAdapter
    public void setItemPersistent(final java.lang.String str, final java.lang.String str2, final com.taobao.weex.appfram.storage.IWXStorageAdapter.OnResultReceivedListener onResultReceivedListener) {
        execute(new java.lang.Runnable() { // from class: com.taobao.weex.appfram.storage.DefaultWXStorage.6
            @Override // java.lang.Runnable
            public void run() {
                java.util.Map<java.lang.String, java.lang.Object> itemResult = com.taobao.weex.appfram.storage.StorageResultHandler.setItemResult(com.taobao.weex.appfram.storage.DefaultWXStorage.this.performSetItem(str, str2, true, true));
                com.taobao.weex.appfram.storage.IWXStorageAdapter.OnResultReceivedListener onResultReceivedListener2 = onResultReceivedListener;
                if (onResultReceivedListener2 == null) {
                    return;
                }
                onResultReceivedListener2.onReceived(itemResult);
            }
        });
    }

    @Override // com.taobao.weex.appfram.storage.IWXStorageAdapter
    public void close() {
        final java.util.concurrent.ExecutorService executorService = this.mExecutorService;
        execute(new java.lang.Runnable() { // from class: com.taobao.weex.appfram.storage.DefaultWXStorage.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.taobao.weex.appfram.storage.DefaultWXStorage.this.mDatabaseSupplier.closeDatabase();
                    java.util.concurrent.ExecutorService executorService2 = executorService;
                    if (executorService2 != null) {
                        executorService2.shutdown();
                    }
                } catch (java.lang.Exception e) {
                    com.taobao.weex.utils.WXLogUtils.e("weex_storage", e.getMessage());
                }
            }
        });
        this.mExecutorService = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:35:0x00d4  */
    public boolean performSetItem(java.lang.String str, java.lang.String str2, boolean z, boolean z2) throws java.lang.Throwable {
        android.database.sqlite.SQLiteDatabase database = this.mDatabaseSupplier.getDatabase();
        if (database == null) {
            return false;
        }
        com.taobao.weex.utils.WXLogUtils.d("weex_storage", "set k-v to storage(key:" + str + ",value:" + str2 + ",isPersistent:" + z + ",allowRetry:" + z2 + com.taobao.weex.el.parse.Operators.BRACKET_END_STR);
        java.lang.String str3 = com.taobao.weex.appfram.storage.WXSQLiteOpenHelper.sDateFormatter.format(new java.util.Date());
        android.database.sqlite.SQLiteStatement sQLiteStatementCompileStatement = null;
        try {
            try {
                sQLiteStatementCompileStatement = database.compileStatement("INSERT OR REPLACE INTO default_wx_storage VALUES (?,?,?,?);");
                sQLiteStatementCompileStatement.clearBindings();
                sQLiteStatementCompileStatement.bindString(1, str);
                sQLiteStatementCompileStatement.bindString(2, str2);
                sQLiteStatementCompileStatement.bindString(3, str3);
                sQLiteStatementCompileStatement.bindLong(4, z ? 1L : 0L);
                sQLiteStatementCompileStatement.execute();
                if (sQLiteStatementCompileStatement != null) {
                    sQLiteStatementCompileStatement.close();
                }
                return true;
            } catch (java.lang.Throwable th) {
                th = th;
                if (sQLiteStatementCompileStatement != null) {
                    sQLiteStatementCompileStatement.close();
                }
                throw th;
            }
        } catch (java.lang.Exception e) {
            com.taobao.weex.utils.WXLogUtils.e("weex_storage", "DefaultWXStorage occurred an exception when execute setItem :" + e.getMessage());
            if (!(e instanceof android.database.sqlite.SQLiteFullException) || !z2 || !trimToSize()) {
                if (sQLiteStatementCompileStatement != null) {
                    sQLiteStatementCompileStatement.close();
                }
                return false;
            }
            com.taobao.weex.utils.WXLogUtils.d("weex_storage", "retry set k-v to storage(key:" + str + ",value:" + str2 + com.taobao.weex.el.parse.Operators.BRACKET_END_STR);
            try {
                boolean zPerformSetItem = performSetItem(str, str2, z, false);
                if (sQLiteStatementCompileStatement != null) {
                    sQLiteStatementCompileStatement.close();
                }
                return zPerformSetItem;
            } catch (java.lang.Throwable th2) {
                th = th2;
                if (sQLiteStatementCompileStatement != null) {
                    sQLiteStatementCompileStatement.close();
                }
                throw th;
            }
        }
    }

    private boolean trimToSize() {
        int i;
        android.database.sqlite.SQLiteDatabase database = this.mDatabaseSupplier.getDatabase();
        if (database == null) {
            return false;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        android.database.Cursor cursorQuery = database.query("default_wx_storage", new java.lang.String[]{io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_KEY, "persistent"}, null, null, null, null, "timestamp ASC");
        try {
            try {
                int count = cursorQuery.getCount() / 10;
                i = 0;
                while (cursorQuery.moveToNext()) {
                    try {
                        java.lang.String string = cursorQuery.getString(cursorQuery.getColumnIndex(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_KEY));
                        if (cursorQuery.getInt(cursorQuery.getColumnIndex("persistent")) != 1 && string != null) {
                            i++;
                            arrayList.add(string);
                            if (i == count) {
                                break;
                            }
                        }
                    } catch (java.lang.Exception e) {
                        e = e;
                        com.taobao.weex.utils.WXLogUtils.e("weex_storage", "DefaultWXStorage occurred an exception when execute trimToSize:" + e.getMessage());
                    }
                }
            } catch (java.lang.Throwable th) {
                cursorQuery.close();
                throw th;
            }
        } catch (java.lang.Exception e2) {
            e = e2;
            i = 0;
        }
        cursorQuery.close();
        if (i <= 0) {
            return false;
        }
        java.util.Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            performRemoveItem((java.lang.String) it.next());
        }
        com.taobao.weex.utils.WXLogUtils.e("weex_storage", "remove " + i + " items by lru");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String performGetItem(java.lang.String str) {
        android.database.sqlite.SQLiteDatabase database = this.mDatabaseSupplier.getDatabase();
        if (database == null) {
            return null;
        }
        android.database.Cursor cursorQuery = database.query("default_wx_storage", new java.lang.String[]{"value"}, "key=?", new java.lang.String[]{str}, null, null, null);
        try {
            if (!cursorQuery.moveToNext()) {
                return null;
            }
            android.content.ContentValues contentValues = new android.content.ContentValues();
            contentValues.put("timestamp", com.taobao.weex.appfram.storage.WXSQLiteOpenHelper.sDateFormatter.format(new java.util.Date()));
            int iUpdate = this.mDatabaseSupplier.getDatabase().update("default_wx_storage", contentValues, "key= ?", new java.lang.String[]{str});
            java.lang.StringBuilder sb = new java.lang.StringBuilder("update timestamp ");
            sb.append(iUpdate == 1 ? com.taobao.weex.ui.component.WXImage.SUCCEED : io.dcloud.common.constant.AbsoluteConst.EVENTS_FAILED);
            sb.append(" for operation [getItem(key = ");
            sb.append(str);
            sb.append(")]");
            com.taobao.weex.utils.WXLogUtils.d("weex_storage", sb.toString());
            return cursorQuery.getString(cursorQuery.getColumnIndex("value"));
        } catch (java.lang.Exception e) {
            com.taobao.weex.utils.WXLogUtils.e("weex_storage", "DefaultWXStorage occurred an exception when execute getItem:" + e.getMessage());
            return null;
        } finally {
            cursorQuery.close();
        }
        cursorQuery.close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean performRemoveItem(java.lang.String str) {
        android.database.sqlite.SQLiteDatabase database = this.mDatabaseSupplier.getDatabase();
        if (database == null) {
            return false;
        }
        try {
            return database.delete("default_wx_storage", "key=?", new java.lang.String[]{str}) == 1;
        } catch (java.lang.Exception e) {
            com.taobao.weex.utils.WXLogUtils.e("weex_storage", "DefaultWXStorage occurred an exception when execute removeItem:" + e.getMessage());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long performGetLength() {
        android.database.sqlite.SQLiteDatabase database = this.mDatabaseSupplier.getDatabase();
        if (database == null) {
            return 0L;
        }
        android.database.sqlite.SQLiteStatement sQLiteStatementCompileStatement = null;
        try {
            sQLiteStatementCompileStatement = database.compileStatement("SELECT count(key) FROM default_wx_storage");
            return sQLiteStatementCompileStatement.simpleQueryForLong();
        } catch (java.lang.Exception e) {
            com.taobao.weex.utils.WXLogUtils.e("weex_storage", "DefaultWXStorage occurred an exception when execute getLength:" + e.getMessage());
            return 0L;
        } finally {
            if (sQLiteStatementCompileStatement != null) {
                sQLiteStatementCompileStatement.close();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.util.List<java.lang.String> performGetAllKeys() {
        android.database.sqlite.SQLiteDatabase database = this.mDatabaseSupplier.getDatabase();
        if (database == null) {
            return null;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        android.database.Cursor cursorQuery = database.query("default_wx_storage", new java.lang.String[]{io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_KEY}, null, null, null, null, null);
        while (cursorQuery.moveToNext()) {
            try {
                try {
                    arrayList.add(cursorQuery.getString(cursorQuery.getColumnIndex(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_KEY)));
                } catch (java.lang.Exception e) {
                    com.taobao.weex.utils.WXLogUtils.e("weex_storage", "DefaultWXStorage occurred an exception when execute getAllKeys:" + e.getMessage());
                    cursorQuery.close();
                    return arrayList;
                }
            } catch (java.lang.Throwable th) {
                cursorQuery.close();
                throw th;
            }
        }
        cursorQuery.close();
        return arrayList;
    }
}
