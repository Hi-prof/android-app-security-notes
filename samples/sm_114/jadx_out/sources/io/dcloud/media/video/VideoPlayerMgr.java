package io.dcloud.media.video;

/* JADX INFO: loaded from: classes2.dex */
public class VideoPlayerMgr {
    private static io.dcloud.media.video.VideoPlayerMgr mInstance;
    private android.view.ViewGroup.LayoutParams _vlps;
    private io.dcloud.common.DHInterface.AbsMgr mFeatureMgr;
    private java.util.HashMap<java.lang.String, io.dcloud.media.video.DHVideoFrameItem> mPlayerCaches = new java.util.HashMap<>();

    public static io.dcloud.media.video.VideoPlayerMgr getInstance() {
        if (mInstance == null) {
            mInstance = new io.dcloud.media.video.VideoPlayerMgr();
        }
        return mInstance;
    }

    public void initFeature(io.dcloud.common.DHInterface.AbsMgr absMgr) {
        this.mFeatureMgr = absMgr;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public io.dcloud.common.DHInterface.IWebview findWebview(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str) {
        io.dcloud.common.DHInterface.IApp iAppObtainApp;
        if (iWebview == null || (iAppObtainApp = iWebview.obtainApp()) == null) {
            return null;
        }
        java.lang.Object objProcessEvent = this.mFeatureMgr.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.FeatureMgr, 10, new java.lang.Object[]{iWebview, io.dcloud.common.constant.AbsoluteConst.F_UI, "findWebview", new java.lang.String[]{iAppObtainApp.obtainAppId(), str}});
        if (objProcessEvent instanceof io.dcloud.common.DHInterface.IWebview) {
            return (io.dcloud.common.DHInterface.IWebview) objProcessEvent;
        }
        return null;
    }

    public void createVideoPlayer(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, org.json.JSONArray jSONArray, org.json.JSONObject jSONObject, java.lang.String str2, boolean z) {
        io.dcloud.common.DHInterface.IWebview iWebview2;
        io.dcloud.media.video.DHVideoFrameItem dHVideoFrameItem;
        if (this.mPlayerCaches.containsKey(str)) {
            dHVideoFrameItem = this.mPlayerCaches.get(str);
            iWebview2 = iWebview;
        } else {
            iWebview2 = iWebview;
            io.dcloud.media.video.DHVideoFrameItem dHVideoFrameItem2 = new io.dcloud.media.video.DHVideoFrameItem(iWebview.getContext(), str, iWebview2, jSONArray, jSONObject, str2);
            this.mPlayerCaches.put(str, dHVideoFrameItem2);
            dHVideoFrameItem = dHVideoFrameItem2;
        }
        if (z) {
            return;
        }
        dHVideoFrameItem.appendToFrame(iWebview2.obtainFrameView());
    }

    public void play(java.lang.String str) {
        java.util.HashMap<java.lang.String, io.dcloud.media.video.DHVideoFrameItem> map = this.mPlayerCaches;
        io.dcloud.media.video.DHVideoFrameItem dHVideoFrameItem = (map == null || !map.containsKey(str)) ? null : this.mPlayerCaches.get(str);
        if (dHVideoFrameItem != null) {
            dHVideoFrameItem.play();
        }
    }

    public void pause(java.lang.String str) {
        java.util.HashMap<java.lang.String, io.dcloud.media.video.DHVideoFrameItem> map = this.mPlayerCaches;
        io.dcloud.media.video.DHVideoFrameItem dHVideoFrameItem = (map == null || !map.containsKey(str)) ? null : this.mPlayerCaches.get(str);
        if (dHVideoFrameItem != null) {
            dHVideoFrameItem.pause();
        }
    }

    public void stop(java.lang.String str) {
        java.util.HashMap<java.lang.String, io.dcloud.media.video.DHVideoFrameItem> map = this.mPlayerCaches;
        io.dcloud.media.video.DHVideoFrameItem dHVideoFrameItem = (map == null || !map.containsKey(str)) ? null : this.mPlayerCaches.get(str);
        if (dHVideoFrameItem != null) {
            dHVideoFrameItem.stop();
        }
    }

    public void close(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str) {
        java.util.HashMap<java.lang.String, io.dcloud.media.video.DHVideoFrameItem> map = this.mPlayerCaches;
        io.dcloud.media.video.DHVideoFrameItem dHVideoFrameItem = (map == null || !map.containsKey(str)) ? null : this.mPlayerCaches.get(str);
        if (dHVideoFrameItem != null) {
            dHVideoFrameItem.close();
            dHVideoFrameItem.removeFrameItem();
        }
    }

    public void sendDanmu(java.lang.String str, org.json.JSONObject jSONObject) {
        java.util.HashMap<java.lang.String, io.dcloud.media.video.DHVideoFrameItem> map = this.mPlayerCaches;
        io.dcloud.media.video.DHVideoFrameItem dHVideoFrameItem = (map == null || !map.containsKey(str)) ? null : this.mPlayerCaches.get(str);
        if (dHVideoFrameItem != null) {
            dHVideoFrameItem.sendDanmu(jSONObject);
        }
    }

    public org.json.JSONObject findVideoPlayer(java.lang.String str) {
        io.dcloud.media.video.DHVideoFrameItem dHVideoFrameItem;
        if (str == null) {
            return null;
        }
        java.util.HashMap<java.lang.String, io.dcloud.media.video.DHVideoFrameItem> map = this.mPlayerCaches;
        if (map != null) {
            java.util.Iterator<java.lang.String> it = map.keySet().iterator();
            dHVideoFrameItem = null;
            while (it.hasNext()) {
                io.dcloud.media.video.DHVideoFrameItem dHVideoFrameItem2 = this.mPlayerCaches.get(it.next());
                if (str.equals(dHVideoFrameItem2.getUserId())) {
                    dHVideoFrameItem = dHVideoFrameItem2;
                }
            }
        } else {
            dHVideoFrameItem = null;
        }
        if (dHVideoFrameItem != null) {
            try {
                return new org.json.JSONObject("{'name':'" + dHVideoFrameItem.getUserId() + "','uid':'" + dHVideoFrameItem.getmId() + "'}");
            } catch (org.json.JSONException unused) {
            }
        }
        return null;
    }

    public io.dcloud.common.adapter.ui.AdaFrameItem appendVideoPlayer(java.lang.String str, io.dcloud.common.DHInterface.IFrameView iFrameView) {
        java.util.HashMap<java.lang.String, io.dcloud.media.video.DHVideoFrameItem> map = this.mPlayerCaches;
        io.dcloud.media.video.DHVideoFrameItem dHVideoFrameItem = (map == null || !map.containsKey(str)) ? null : this.mPlayerCaches.get(str);
        if (dHVideoFrameItem != null) {
            dHVideoFrameItem.appendToFrame(iFrameView);
        }
        return dHVideoFrameItem;
    }

    public void seekTo(java.lang.String str, java.lang.String str2) {
        java.util.HashMap<java.lang.String, io.dcloud.media.video.DHVideoFrameItem> map = this.mPlayerCaches;
        io.dcloud.media.video.DHVideoFrameItem dHVideoFrameItem = (map == null || !map.containsKey(str)) ? null : this.mPlayerCaches.get(str);
        if (dHVideoFrameItem != null) {
            dHVideoFrameItem.seek(str2);
        }
    }

    public void recovery() {
        java.util.HashMap<java.lang.String, io.dcloud.media.video.DHVideoFrameItem> map = this.mPlayerCaches;
        if (map != null && map.size() > 0) {
            java.util.Iterator<java.lang.String> it = this.mPlayerCaches.keySet().iterator();
            while (it.hasNext()) {
                this.mPlayerCaches.get(it.next()).release();
            }
        }
        this.mPlayerCaches.clear();
    }

    public void rmovePlayer(java.lang.String str) {
        java.util.HashMap<java.lang.String, io.dcloud.media.video.DHVideoFrameItem> map = this.mPlayerCaches;
        if (map == null || map.size() <= 0 || !this.mPlayerCaches.containsKey(str)) {
            return;
        }
        this.mPlayerCaches.remove(str);
    }

    public void requestFullScreen(java.lang.String str, java.lang.String str2) {
        java.util.HashMap<java.lang.String, io.dcloud.media.video.DHVideoFrameItem> map = this.mPlayerCaches;
        io.dcloud.media.video.DHVideoFrameItem dHVideoFrameItem = (map == null || !map.containsKey(str)) ? null : this.mPlayerCaches.get(str);
        if (dHVideoFrameItem != null) {
            dHVideoFrameItem.requestFullScreen(str2);
        }
    }

    public void exitFullScreen(java.lang.String str) {
        java.util.HashMap<java.lang.String, io.dcloud.media.video.DHVideoFrameItem> map = this.mPlayerCaches;
        io.dcloud.media.video.DHVideoFrameItem dHVideoFrameItem = (map == null || !map.containsKey(str)) ? null : this.mPlayerCaches.get(str);
        if (dHVideoFrameItem != null) {
            dHVideoFrameItem.exitFullScreen();
        }
    }

    public void show(java.lang.String str) {
        java.util.HashMap<java.lang.String, io.dcloud.media.video.DHVideoFrameItem> map = this.mPlayerCaches;
        io.dcloud.media.video.DHVideoFrameItem dHVideoFrameItem = (map == null || !map.containsKey(str)) ? null : this.mPlayerCaches.get(str);
        if (dHVideoFrameItem != null) {
            dHVideoFrameItem.show();
        }
    }

    public void hidden(java.lang.String str) {
        java.util.HashMap<java.lang.String, io.dcloud.media.video.DHVideoFrameItem> map = this.mPlayerCaches;
        io.dcloud.media.video.DHVideoFrameItem dHVideoFrameItem = (map == null || !map.containsKey(str)) ? null : this.mPlayerCaches.get(str);
        if (dHVideoFrameItem != null) {
            dHVideoFrameItem.hidden();
        }
    }

    public void addEventListener(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        java.util.HashMap<java.lang.String, io.dcloud.media.video.DHVideoFrameItem> map = this.mPlayerCaches;
        io.dcloud.media.video.DHVideoFrameItem dHVideoFrameItem = (map == null || !map.containsKey(str)) ? null : this.mPlayerCaches.get(str);
        if (dHVideoFrameItem != null) {
            dHVideoFrameItem.addEventListener(str2, str3, str4);
        }
    }

    public void setOptions(java.lang.String str, org.json.JSONObject jSONObject) {
        java.util.HashMap<java.lang.String, io.dcloud.media.video.DHVideoFrameItem> map = this.mPlayerCaches;
        io.dcloud.media.video.DHVideoFrameItem dHVideoFrameItem = (map == null || !map.containsKey(str)) ? null : this.mPlayerCaches.get(str);
        if (dHVideoFrameItem != null) {
            dHVideoFrameItem.setOptions(jSONObject);
        }
    }

    public void setPlayBackRate(java.lang.String str, java.lang.String str2) {
        java.util.HashMap<java.lang.String, io.dcloud.media.video.DHVideoFrameItem> map = this.mPlayerCaches;
        io.dcloud.media.video.DHVideoFrameItem dHVideoFrameItem = (map == null || !map.containsKey(str)) ? null : this.mPlayerCaches.get(str);
        if (dHVideoFrameItem != null) {
            dHVideoFrameItem.sendPlayBackRate(str2);
        }
    }

    public void resize(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, org.json.JSONArray jSONArray) {
        io.dcloud.media.video.DHVideoFrameItem dHVideoFrameItem = this.mPlayerCaches.containsKey(str) ? this.mPlayerCaches.get(str) : null;
        if (dHVideoFrameItem == null) {
            return;
        }
        dHVideoFrameItem.resize(jSONArray);
    }
}
