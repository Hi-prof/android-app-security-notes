package io.dcloud.feature.pdr;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class ZipFeature implements io.dcloud.common.DHInterface.IFeature {
    java.util.HashMap a = null;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class a implements java.lang.Runnable {
        boolean a = false;
        java.lang.String b = null;
        java.lang.String c;
        java.lang.String d;
        java.lang.String e;
        io.dcloud.common.DHInterface.IWebview f;

        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (this.a) {
                    io.dcloud.common.adapter.util.Logger.d("compress mUnZipDirPath=" + this.d + ";mZipFilePath" + this.c);
                    java.io.File file = new java.io.File(this.d);
                    if (!file.exists()) {
                        io.dcloud.common.util.Deprecated_JSUtil.excCallbackError(this.f, this.e, io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.DOMException.JSON_ERROR_INFO, 2, this.b + " open failed:ENOENT (No such file or directory)"), true);
                    }
                    if (io.dcloud.common.util.JSUtil.checkOperateDirErrorAndCallback(this.f, this.e, this.c)) {
                        return;
                    }
                    java.io.File file2 = new java.io.File(this.c);
                    java.io.File[] fileArrListFiles = file.isDirectory() ? file2.listFiles() : null;
                    if (file.isFile() || fileArrListFiles == null) {
                        fileArrListFiles = new java.io.File[]{file};
                    }
                    if (!io.dcloud.common.util.FileUtil.checkPathAccord(this.f.getContext(), file.getPath(), file2.getPath())) {
                        io.dcloud.common.util.Deprecated_JSUtil.excCallbackError(this.f, this.e, io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.DOMException.JSON_ERROR_INFO, 2, io.dcloud.common.constant.DOMException.MSG_PATH_NOT_PRIVATE_ERROR), true);
                        return;
                    }
                    io.dcloud.common.util.ZipUtils.zipFiles(fileArrListFiles, file2);
                } else {
                    io.dcloud.common.adapter.util.Logger.d("decompress mUnZipDirPath=" + this.d + ";mZipFilePath" + this.c);
                    if (io.dcloud.common.util.JSUtil.checkOperateDirErrorAndCallback(this.f, this.e, this.d)) {
                        return;
                    }
                    java.io.File file3 = new java.io.File(this.c);
                    if (!file3.exists()) {
                        io.dcloud.common.util.Deprecated_JSUtil.excCallbackError(this.f, this.e, io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.DOMException.JSON_ERROR_INFO, 2, this.b + " open failed:ENOENT (No such file or directory)"), true);
                        return;
                    }
                    if (!io.dcloud.common.util.FileUtil.checkPathAccord(this.f.getContext(), file3.getPath(), this.d)) {
                        io.dcloud.common.util.Deprecated_JSUtil.excCallbackError(this.f, this.e, io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.DOMException.JSON_ERROR_INFO, 2, io.dcloud.common.constant.DOMException.MSG_PATH_NOT_PRIVATE_ERROR), true);
                        return;
                    }
                    io.dcloud.common.util.ZipUtils.upZipFile(file3, this.d);
                }
                io.dcloud.common.util.Deprecated_JSUtil.excCallbackSuccess(this.f, this.e, "");
            } catch (java.lang.Exception e) {
                io.dcloud.common.util.Deprecated_JSUtil.excCallbackError(this.f, this.e, io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.DOMException.JSON_ERROR_INFO, 2, e.getMessage()), true);
            }
        }
    }

    private void a(io.dcloud.feature.pdr.ZipFeature.a aVar) {
        new java.lang.Thread(aVar).start();
    }

    @Override // io.dcloud.common.DHInterface.IFeature
    public void dispose(java.lang.String str) {
    }

    @Override // io.dcloud.common.DHInterface.IFeature
    public java.lang.String execute(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String[] strArr) {
        if (!io.dcloud.common.util.PdrUtil.isEquals(str, "compress")) {
            if (!io.dcloud.common.util.PdrUtil.isEquals(str, "decompress")) {
                if (io.dcloud.common.util.PdrUtil.isEquals(str, "compressImage")) {
                    io.dcloud.p.h0.b(iWebview, strArr);
                    return null;
                }
                if (!io.dcloud.common.util.PdrUtil.isEquals(str, "compressVideo")) {
                    return null;
                }
                androidtranscoder.VideoCompressor.getInstance().compressVideo(iWebview, strArr);
                return null;
            }
            io.dcloud.feature.pdr.ZipFeature.a aVar = new io.dcloud.feature.pdr.ZipFeature.a();
            aVar.f = iWebview;
            aVar.a = false;
            io.dcloud.common.DHInterface.IApp iAppObtainApp = iWebview.obtainFrameView().obtainApp();
            aVar.c = iAppObtainApp.convert2AbsFullPath(iWebview.obtainFullUrl(), iAppObtainApp.checkPrivateDirAndCopy2Temp(strArr[0]));
            aVar.d = iAppObtainApp.convert2AbsFullPath(iWebview.obtainFullUrl(), strArr[1]);
            aVar.e = strArr[2];
            a(aVar);
            return null;
        }
        io.dcloud.feature.pdr.ZipFeature.a aVar2 = new io.dcloud.feature.pdr.ZipFeature.a();
        aVar2.f = iWebview;
        aVar2.a = true;
        io.dcloud.common.DHInterface.IApp iAppObtainApp2 = iWebview.obtainFrameView().obtainApp();
        aVar2.b = strArr[0];
        aVar2.d = iAppObtainApp2.convert2AbsFullPath(iWebview.obtainFullUrl(), strArr[0]);
        java.lang.String str2 = strArr[1];
        if (str2 == null) {
            str2 = io.dcloud.common.constant.AbsoluteConst.MINI_SERVER_APP_DOC + java.lang.System.currentTimeMillis();
        }
        if (!str2.endsWith(".zip")) {
            str2 = str2 + ".zip";
        }
        aVar2.c = iAppObtainApp2.convert2AbsFullPath(iWebview.obtainFullUrl(), str2);
        aVar2.e = strArr[2];
        a(aVar2);
        return null;
    }

    @Override // io.dcloud.common.DHInterface.IFeature
    public void init(io.dcloud.common.DHInterface.AbsMgr absMgr, java.lang.String str) {
        this.a = new java.util.HashMap(1);
    }
}
