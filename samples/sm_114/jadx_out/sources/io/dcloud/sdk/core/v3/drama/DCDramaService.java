package io.dcloud.sdk.core.v3.drama;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class DCDramaService {
    private final io.dcloud.sdk.core.v3.drama.DCDramaLoader a;
    private final io.dcloud.p.a1 b;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private static class DramaPage implements io.dcloud.sdk.core.v3.drama.DCDramaPage {
        private final io.dcloud.sdk.core.module.DCDramaLoader.AOLDramaPage a;

        DramaPage(io.dcloud.sdk.core.module.DCDramaLoader.AOLDramaPage aOLDramaPage) {
            this.a = aOLDramaPage;
        }

        static io.dcloud.sdk.core.interfaces.AOLLoader.DramaPageLoaderListener a(final io.dcloud.sdk.core.v3.drama.DCDramaPageLoaderListener dCDramaPageLoaderListener) {
            if (dCDramaPageLoaderListener == null) {
                return null;
            }
            return new io.dcloud.sdk.core.interfaces.AOLLoader.DramaPageLoaderListener() { // from class: io.dcloud.sdk.core.v3.drama.DCDramaService.DramaPage.1
                @Override // io.dcloud.sdk.core.interfaces.AOLLoader.DramaPageLoaderListener
                public void onError(int i, java.lang.String str) {
                    dCDramaPageLoaderListener.onError(i, str);
                }

                @Override // io.dcloud.sdk.core.interfaces.AOLLoader.DramaPageLoaderListener
                public void onSuccess() {
                    dCDramaPageLoaderListener.onSuccess();
                }
            };
        }

        @Override // io.dcloud.sdk.core.v3.drama.DCDramaPage
        public void destroy() {
            io.dcloud.sdk.core.module.DCDramaLoader.AOLDramaPage aOLDramaPage = this.a;
            if (aOLDramaPage != null) {
                aOLDramaPage.destroy();
            }
        }

        @Override // io.dcloud.sdk.core.v3.drama.DCDramaPage
        public androidx.fragment.app.Fragment getFragment() {
            io.dcloud.sdk.core.module.DCDramaLoader.AOLDramaPage aOLDramaPage = this.a;
            if (aOLDramaPage == null) {
                return null;
            }
            return aOLDramaPage.getFragment();
        }

        @Override // io.dcloud.sdk.core.v3.drama.DCDramaPage
        public void setDramaAdListener(io.dcloud.sdk.core.v3.drama.DCDramaAdListener dCDramaAdListener) {
            io.dcloud.sdk.core.module.DCDramaLoader.AOLDramaPage aOLDramaPage = this.a;
            if (aOLDramaPage != null) {
                aOLDramaPage.setDramaAdListener(a(dCDramaAdListener));
            }
        }

        @Override // io.dcloud.sdk.core.v3.drama.DCDramaPage
        public void setDramaListener(io.dcloud.sdk.core.v3.drama.DCDramaListener dCDramaListener) {
            io.dcloud.sdk.core.module.DCDramaLoader.AOLDramaPage aOLDramaPage = this.a;
            if (aOLDramaPage != null) {
                aOLDramaPage.setDramaListener(a(dCDramaListener));
            }
        }

        @Override // io.dcloud.sdk.core.v3.drama.DCDramaPage
        public void setDramaUnlockListener(io.dcloud.sdk.core.v3.drama.DCDramaUnlockListener dCDramaUnlockListener) {
            io.dcloud.sdk.core.module.DCDramaLoader.AOLDramaPage aOLDramaPage = this.a;
            if (aOLDramaPage != null) {
                aOLDramaPage.setDramaUnlockListener(a(dCDramaUnlockListener));
            }
        }

        @Override // io.dcloud.sdk.core.v3.drama.DCDramaPage
        public void setHideBack(boolean z) {
            io.dcloud.sdk.core.module.DCDramaLoader.AOLDramaPage aOLDramaPage = this.a;
            if (aOLDramaPage != null) {
                aOLDramaPage.setHideBack(z);
            }
        }

        @Override // io.dcloud.sdk.core.v3.drama.DCDramaPage
        public void setLoadListener(io.dcloud.sdk.core.v3.drama.DCDramaPageLoaderListener dCDramaPageLoaderListener) {
            io.dcloud.sdk.core.module.DCDramaLoader.AOLDramaPage aOLDramaPage = this.a;
            if (aOLDramaPage != null) {
                aOLDramaPage.setLoadListener(a(dCDramaPageLoaderListener));
            }
        }

        private io.dcloud.sdk.core.interfaces.AOLLoader.DramaListener a(final io.dcloud.sdk.core.v3.drama.DCDramaListener dCDramaListener) {
            if (dCDramaListener == null) {
                return null;
            }
            return new io.dcloud.sdk.core.interfaces.AOLLoader.DramaListener() { // from class: io.dcloud.sdk.core.v3.drama.DCDramaService.DramaPage.2
                @Override // io.dcloud.sdk.core.interfaces.AOLLoader.DramaListener
                public void onFullDisplay(int i) {
                    dCDramaListener.onFullDisplay(i);
                }

                @Override // io.dcloud.sdk.core.interfaces.AOLLoader.DramaListener
                public void onNextPlaylet() {
                    dCDramaListener.onNextPlaylet();
                }

                @Override // io.dcloud.sdk.core.interfaces.AOLLoader.DramaListener
                public void onPause() {
                    dCDramaListener.onPause();
                }

                @Override // io.dcloud.sdk.core.interfaces.AOLLoader.DramaListener
                public void onPlayComplete() {
                    dCDramaListener.onPlayComplete();
                }

                @Override // io.dcloud.sdk.core.interfaces.AOLLoader.DramaListener
                public void onPlayEnd() {
                    dCDramaListener.onPlayEnd();
                }

                @Override // io.dcloud.sdk.core.interfaces.AOLLoader.DramaListener
                public void onPlayError(int i, java.lang.String str) {
                    dCDramaListener.onPlayError(i, str);
                }

                @Override // io.dcloud.sdk.core.interfaces.AOLLoader.DramaListener
                public void onPlayStart() {
                    dCDramaListener.onPlayStart();
                }

                @Override // io.dcloud.sdk.core.interfaces.AOLLoader.DramaListener
                public void onProgress(long j) {
                    dCDramaListener.onProgress(j);
                }

                @Override // io.dcloud.sdk.core.interfaces.AOLLoader.DramaListener
                public void onResume() {
                    dCDramaListener.onResume();
                }

                @Override // io.dcloud.sdk.core.interfaces.AOLLoader.DramaListener
                public void onSeek(long j, int i) {
                    dCDramaListener.onSeek(j, i);
                }
            };
        }

        private io.dcloud.sdk.core.interfaces.AOLLoader.DramaRewardListener a(final io.dcloud.sdk.core.v3.drama.DCDramaAdListener dCDramaAdListener) {
            if (dCDramaAdListener == null) {
                return null;
            }
            return new io.dcloud.sdk.core.interfaces.AOLLoader.DramaRewardListener() { // from class: io.dcloud.sdk.core.v3.drama.DCDramaService.DramaPage.3
                @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
                public void onClick() {
                    dCDramaAdListener.onClick();
                }

                @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
                public void onClose() {
                    dCDramaAdListener.onClose();
                }

                @Override // io.dcloud.sdk.core.interfaces.AOLLoader.DramaRewardListener
                public void onLoadFail(int i, java.lang.String str, org.json.JSONObject jSONObject) {
                    dCDramaAdListener.onLoadFail(i, str, jSONObject);
                }

                @Override // io.dcloud.sdk.core.interfaces.AOLLoader.DramaRewardListener
                public void onLoadSuccess() {
                    dCDramaAdListener.onLoadSuccess();
                }

                @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
                public void onPaidGet(long j, java.lang.String str, int i) {
                }

                @Override // io.dcloud.sdk.core.interfaces.AOLLoader.RewVAOLInteractionListener
                public void onReward(org.json.JSONObject jSONObject) {
                    dCDramaAdListener.onReward(jSONObject);
                }

                @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
                public void onShow() {
                    dCDramaAdListener.onShow();
                }

                @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
                public void onShowError(int i, java.lang.String str) {
                    dCDramaAdListener.onShowError(i, str);
                }

                @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
                public void onSkip() {
                    dCDramaAdListener.onSkip();
                }

                @Override // io.dcloud.sdk.core.interfaces.AOLLoader.VAOLInteractionListener
                public void onVideoPlayEnd() {
                    dCDramaAdListener.onVideoPlayEnd();
                }
            };
        }

        private io.dcloud.sdk.core.interfaces.AOLLoader.DramaUnlockListener a(final io.dcloud.sdk.core.v3.drama.DCDramaUnlockListener dCDramaUnlockListener) {
            if (dCDramaUnlockListener == null) {
                return null;
            }
            return new io.dcloud.sdk.core.interfaces.AOLLoader.DramaUnlockListener() { // from class: io.dcloud.sdk.core.v3.drama.DCDramaService.DramaPage.4
                @Override // io.dcloud.sdk.core.interfaces.AOLLoader.DramaUnlockListener
                public void showCustomAd(io.dcloud.sdk.core.entry.DCDramaInfo dCDramaInfo) {
                    dCDramaUnlockListener.showCustomAd(dCDramaInfo);
                }

                @Override // io.dcloud.sdk.core.interfaces.AOLLoader.DramaUnlockListener
                public void unlockEnd(io.dcloud.sdk.core.entry.DCDramaInfo dCDramaInfo, boolean z, java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map) {
                    dCDramaUnlockListener.unlockEnd(dCDramaInfo, z, str, map);
                }

                @Override // io.dcloud.sdk.core.interfaces.AOLLoader.DramaUnlockListener
                public void unlockStart(io.dcloud.sdk.core.entry.DCDramaInfo dCDramaInfo, java.util.Map<java.lang.String, java.lang.Object> map) {
                    dCDramaUnlockListener.unlockStart(dCDramaInfo, map);
                }
            };
        }
    }

    DCDramaService(io.dcloud.sdk.core.v3.drama.DCDramaLoader dCDramaLoader, io.dcloud.p.a1 a1Var) {
        this.a = dCDramaLoader;
        this.b = a1Var;
    }

    private io.dcloud.sdk.core.v3.drama.DCDramaPage a(io.dcloud.sdk.core.module.DCDramaLoader.AOLDramaPage aOLDramaPage) {
        if (aOLDramaPage == null) {
            return null;
        }
        return new io.dcloud.sdk.core.v3.drama.DCDramaService.DramaPage(aOLDramaPage);
    }

    public void getDramaCollectionList(int i, int i2, io.dcloud.sdk.core.v3.drama.DCDramaResultListener dCDramaResultListener) {
        this.b.a(i, i2, a(dCDramaResultListener));
    }

    public io.dcloud.sdk.core.v3.drama.DCDramaPage getDramaDetailPage(long j, int i, int i2, int i3, java.util.Map<java.lang.String, java.lang.Object> map) {
        return a(this.b.a(j, i, i2, i3, map));
    }

    public void getDramaHistoryList(int i, int i2, io.dcloud.sdk.core.v3.drama.DCDramaResultListener dCDramaResultListener) {
        this.b.b(i, i2, a(dCDramaResultListener));
    }

    public io.dcloud.sdk.core.v3.drama.DCDramaPage getDramaHomePage() {
        return a(this.b.t());
    }

    public void getDramaInfo(java.util.List<java.lang.Long> list, io.dcloud.sdk.core.v3.drama.DCDramaResultListener dCDramaResultListener) {
        this.b.a(list, a(dCDramaResultListener));
    }

    public void getDramaList(int i, int i2, java.lang.String str, io.dcloud.sdk.core.v3.drama.DCDramaResultListener dCDramaResultListener) {
        this.b.a(i, i2, str, a(dCDramaResultListener));
    }

    public io.dcloud.sdk.core.v3.drama.DCDramaPage getDramaPage() {
        return getDramaHomePage();
    }

    public void getDramaRecommendedList(int i, int i2, io.dcloud.sdk.core.v3.drama.DCDramaResultListener dCDramaResultListener) {
        this.b.c(i, i2, a(dCDramaResultListener));
    }

    public void openDramaDetailPage(android.app.Activity activity, long j, int i, int i2, int i3, java.util.Map<java.lang.String, java.lang.Object> map, io.dcloud.sdk.core.v3.drama.DCDramaPageLoaderListener dCDramaPageLoaderListener) {
        io.dcloud.p.a1 a1Var = this.b;
        if (activity == null) {
            activity = this.a.getContext();
        }
        a1Var.a(activity, j, i, i2, i3, map, a(dCDramaPageLoaderListener));
    }

    public void searchDrama(java.lang.String str, int i, int i2, boolean z, io.dcloud.sdk.core.v3.drama.DCDramaResultListener dCDramaResultListener) {
        this.b.a(str, i, i2, z, a(dCDramaResultListener));
    }

    private io.dcloud.sdk.core.interfaces.AOLLoader.DramaPageLoaderListener a(io.dcloud.sdk.core.v3.drama.DCDramaPageLoaderListener dCDramaPageLoaderListener) {
        return io.dcloud.sdk.core.v3.drama.DCDramaService.DramaPage.a(dCDramaPageLoaderListener);
    }

    public io.dcloud.sdk.core.v3.drama.DCDramaPage getDramaHomePage(int i, int i2, java.util.Map<java.lang.String, java.lang.Object> map) {
        return a(this.b.a(i, i2, map));
    }

    public io.dcloud.sdk.core.v3.drama.DCDramaPage getDramaPage(int i, int i2, java.util.Map<java.lang.String, java.lang.Object> map) {
        return getDramaHomePage(i, i2, map);
    }

    private io.dcloud.sdk.core.interfaces.AOLLoader.DramaResultListener a(final io.dcloud.sdk.core.v3.drama.DCDramaResultListener dCDramaResultListener) {
        if (dCDramaResultListener == null) {
            return null;
        }
        return new io.dcloud.sdk.core.interfaces.AOLLoader.DramaResultListener() { // from class: io.dcloud.sdk.core.v3.drama.DCDramaService.1
            @Override // io.dcloud.sdk.core.interfaces.AOLLoader.DramaResultListener
            public void onError(int i, java.lang.String str) {
                dCDramaResultListener.onError(i, str);
            }

            @Override // io.dcloud.sdk.core.interfaces.AOLLoader.DramaResultListener
            public void onSuccess(java.util.List<io.dcloud.sdk.core.entry.DCDramaInfo> list, java.util.Map<java.lang.String, java.lang.Object> map) {
                dCDramaResultListener.onSuccess(list, map);
            }
        };
    }
}
