package master.flame.danmaku.danmaku.renderer.android;

/* JADX INFO: loaded from: classes2.dex */
public class DanmakusRetainer {
    private master.flame.danmaku.danmaku.renderer.android.DanmakusRetainer.IDanmakusRetainer rldrInstance = null;
    private master.flame.danmaku.danmaku.renderer.android.DanmakusRetainer.IDanmakusRetainer lrdrInstance = null;
    private master.flame.danmaku.danmaku.renderer.android.DanmakusRetainer.IDanmakusRetainer ftdrInstance = null;
    private master.flame.danmaku.danmaku.renderer.android.DanmakusRetainer.IDanmakusRetainer fbdrInstance = null;

    public interface IDanmakusRetainer {
        void clear();

        void fix(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku, master.flame.danmaku.danmaku.model.IDisplayer iDisplayer, master.flame.danmaku.danmaku.renderer.android.DanmakusRetainer.Verifier verifier);
    }

    public interface Verifier {
        boolean skipLayout(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku, float f, int i, boolean z);
    }

    public DanmakusRetainer(boolean z) {
        alignBottom(z);
    }

    public void alignBottom(boolean z) {
        this.rldrInstance = z ? new master.flame.danmaku.danmaku.renderer.android.DanmakusRetainer.AlignBottomRetainer() : new master.flame.danmaku.danmaku.renderer.android.DanmakusRetainer.AlignTopRetainer();
        this.lrdrInstance = z ? new master.flame.danmaku.danmaku.renderer.android.DanmakusRetainer.AlignBottomRetainer() : new master.flame.danmaku.danmaku.renderer.android.DanmakusRetainer.AlignTopRetainer();
        if (this.ftdrInstance == null) {
            this.ftdrInstance = new master.flame.danmaku.danmaku.renderer.android.DanmakusRetainer.FTDanmakusRetainer();
        }
        if (this.fbdrInstance == null) {
            this.fbdrInstance = new master.flame.danmaku.danmaku.renderer.android.DanmakusRetainer.AlignBottomRetainer();
        }
    }

    public void fix(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku, master.flame.danmaku.danmaku.model.IDisplayer iDisplayer, master.flame.danmaku.danmaku.renderer.android.DanmakusRetainer.Verifier verifier) {
        int type = baseDanmaku.getType();
        if (type == 1) {
            this.rldrInstance.fix(baseDanmaku, iDisplayer, verifier);
            return;
        }
        if (type == 4) {
            this.fbdrInstance.fix(baseDanmaku, iDisplayer, verifier);
            return;
        }
        if (type == 5) {
            this.ftdrInstance.fix(baseDanmaku, iDisplayer, verifier);
        } else if (type == 6) {
            this.lrdrInstance.fix(baseDanmaku, iDisplayer, verifier);
        } else {
            if (type != 7) {
                return;
            }
            baseDanmaku.layout(iDisplayer, 0.0f, 0.0f);
        }
    }

    public void clear() {
        master.flame.danmaku.danmaku.renderer.android.DanmakusRetainer.IDanmakusRetainer iDanmakusRetainer = this.rldrInstance;
        if (iDanmakusRetainer != null) {
            iDanmakusRetainer.clear();
        }
        master.flame.danmaku.danmaku.renderer.android.DanmakusRetainer.IDanmakusRetainer iDanmakusRetainer2 = this.lrdrInstance;
        if (iDanmakusRetainer2 != null) {
            iDanmakusRetainer2.clear();
        }
        master.flame.danmaku.danmaku.renderer.android.DanmakusRetainer.IDanmakusRetainer iDanmakusRetainer3 = this.ftdrInstance;
        if (iDanmakusRetainer3 != null) {
            iDanmakusRetainer3.clear();
        }
        master.flame.danmaku.danmaku.renderer.android.DanmakusRetainer.IDanmakusRetainer iDanmakusRetainer4 = this.fbdrInstance;
        if (iDanmakusRetainer4 != null) {
            iDanmakusRetainer4.clear();
        }
    }

    public void release() {
        clear();
    }

    private static class AlignTopRetainer implements master.flame.danmaku.danmaku.renderer.android.DanmakusRetainer.IDanmakusRetainer {
        protected boolean mCancelFixingFlag;
        protected master.flame.danmaku.danmaku.model.android.Danmakus mVisibleDanmakus;

        private AlignTopRetainer() {
            this.mVisibleDanmakus = new master.flame.danmaku.danmaku.model.android.Danmakus(1);
            this.mCancelFixingFlag = false;
        }

        @Override // master.flame.danmaku.danmaku.renderer.android.DanmakusRetainer.IDanmakusRetainer
        public void fix(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku, master.flame.danmaku.danmaku.model.IDisplayer iDisplayer, master.flame.danmaku.danmaku.renderer.android.DanmakusRetainer.Verifier verifier) {
            boolean z;
            int i;
            master.flame.danmaku.danmaku.model.BaseDanmaku next;
            boolean z2;
            master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku2;
            boolean z3;
            boolean z4;
            float top;
            boolean zIsOutVerticalEdge;
            master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku3 = baseDanmaku;
            if (baseDanmaku3.isOutside()) {
                return;
            }
            boolean zIsShown = baseDanmaku3.isShown();
            int i2 = 1;
            int i3 = 0;
            boolean z5 = (zIsShown || this.mVisibleDanmakus.isEmpty()) ? false : true;
            float f = 0.0f;
            master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku4 = null;
            if (zIsShown) {
                z = false;
            } else {
                this.mCancelFixingFlag = false;
                master.flame.danmaku.danmaku.model.IDanmakuIterator it = this.mVisibleDanmakus.iterator();
                master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku5 = null;
                master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku6 = null;
                master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku7 = null;
                int i4 = 0;
                while (true) {
                    if (this.mCancelFixingFlag || !it.hasNext()) {
                        i = i4;
                        next = null;
                        z2 = false;
                        baseDanmaku2 = baseDanmaku5;
                        break;
                    }
                    i = i4 + 1;
                    next = it.next();
                    if (next == baseDanmaku3) {
                        baseDanmaku7 = null;
                        z5 = false;
                        z2 = false;
                        zIsShown = true;
                        baseDanmaku2 = baseDanmaku5;
                        break;
                    }
                    master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku8 = baseDanmaku5 == null ? next : baseDanmaku5;
                    if (baseDanmaku3.paintHeight + next.getTop() > iDisplayer.getHeight()) {
                        baseDanmaku3 = baseDanmaku3;
                        baseDanmaku6 = baseDanmaku6;
                        next = null;
                        baseDanmaku2 = baseDanmaku8;
                        z2 = true;
                        break;
                    }
                    baseDanmaku6 = (baseDanmaku6 != null && baseDanmaku6.getRight() < next.getRight()) ? baseDanmaku6 : next;
                    master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku9 = baseDanmaku3;
                    boolean zWillHitInDuration = master.flame.danmaku.danmaku.util.DanmakuUtils.willHitInDuration(iDisplayer, next, baseDanmaku9, baseDanmaku3.getDuration(), baseDanmaku3.getTimer().currMillisecond);
                    baseDanmaku3 = baseDanmaku9;
                    if (!zWillHitInDuration) {
                        next = next;
                        z5 = zWillHitInDuration;
                        baseDanmaku2 = baseDanmaku8;
                        z2 = false;
                        break;
                    }
                    baseDanmaku7 = next;
                    z5 = zWillHitInDuration;
                    baseDanmaku3 = baseDanmaku3;
                    i4 = i;
                    baseDanmaku5 = baseDanmaku8;
                    baseDanmaku6 = baseDanmaku6;
                }
                if (next != null) {
                    if (baseDanmaku7 != null) {
                        top = baseDanmaku7.getBottom();
                    } else {
                        top = next.getTop();
                    }
                    z3 = z5;
                    if (next != baseDanmaku3) {
                        baseDanmaku4 = next;
                        z4 = true;
                        zIsShown = false;
                    } else {
                        z4 = true;
                    }
                } else if (z2 && baseDanmaku6 != null) {
                    top = baseDanmaku6.getTop();
                    z3 = z5;
                    z4 = false;
                    zIsShown = false;
                } else if (baseDanmaku7 != null) {
                    top = baseDanmaku7.getBottom();
                    z4 = true;
                    z3 = false;
                } else if (baseDanmaku2 != null) {
                    top = baseDanmaku2.getTop();
                    z3 = z5;
                    baseDanmaku4 = baseDanmaku2;
                    z4 = true;
                    zIsShown = false;
                } else {
                    z3 = z5;
                    z4 = true;
                    top = 0.0f;
                }
                if (z4) {
                    boolean z6 = z2;
                    baseDanmaku3 = baseDanmaku3;
                    zIsOutVerticalEdge = isOutVerticalEdge(z6, baseDanmaku3, iDisplayer, top, baseDanmaku2, baseDanmaku7);
                } else {
                    baseDanmaku3 = baseDanmaku3;
                    zIsOutVerticalEdge = false;
                }
                if (zIsOutVerticalEdge) {
                    top = 0.0f;
                    z3 = true;
                } else {
                    i2 = baseDanmaku4 != null ? i - 1 : i;
                }
                if (top == 0.0f) {
                    z = zIsOutVerticalEdge;
                    f = top;
                    z5 = z3;
                    i3 = i2;
                    zIsShown = false;
                } else {
                    z = zIsOutVerticalEdge;
                    f = top;
                    z5 = z3;
                    i3 = i2;
                }
            }
            if (verifier == null || !verifier.skipLayout(baseDanmaku3, f, i3, z5)) {
                if (z) {
                    clear();
                }
                baseDanmaku3.layout(iDisplayer, baseDanmaku3.getLeft(), f);
                if (zIsShown) {
                    return;
                }
                this.mVisibleDanmakus.removeItem(baseDanmaku4);
                this.mVisibleDanmakus.addItem(baseDanmaku3);
            }
        }

        protected boolean isOutVerticalEdge(boolean z, master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku, master.flame.danmaku.danmaku.model.IDisplayer iDisplayer, float f, master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku2, master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku3) {
            if (f >= 0.0f) {
                return (baseDanmaku2 != null && baseDanmaku2.getTop() > 0.0f) || f + baseDanmaku.paintHeight > ((float) iDisplayer.getHeight());
            }
            return true;
        }

        @Override // master.flame.danmaku.danmaku.renderer.android.DanmakusRetainer.IDanmakusRetainer
        public void clear() {
            this.mCancelFixingFlag = true;
            this.mVisibleDanmakus.clear();
        }
    }

    private static class FTDanmakusRetainer extends master.flame.danmaku.danmaku.renderer.android.DanmakusRetainer.AlignTopRetainer {
        private FTDanmakusRetainer() {
            super();
        }

        @Override // master.flame.danmaku.danmaku.renderer.android.DanmakusRetainer.AlignTopRetainer
        protected boolean isOutVerticalEdge(boolean z, master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku, master.flame.danmaku.danmaku.model.IDisplayer iDisplayer, float f, master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku2, master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku3) {
            return f + baseDanmaku.paintHeight > ((float) iDisplayer.getHeight());
        }
    }

    private static class AlignBottomRetainer extends master.flame.danmaku.danmaku.renderer.android.DanmakusRetainer.FTDanmakusRetainer {
        protected master.flame.danmaku.danmaku.model.android.Danmakus mVisibleDanmakus;

        private AlignBottomRetainer() {
            super();
            this.mVisibleDanmakus = new master.flame.danmaku.danmaku.model.android.Danmakus(2);
        }

        @Override // master.flame.danmaku.danmaku.renderer.android.DanmakusRetainer.AlignTopRetainer, master.flame.danmaku.danmaku.renderer.android.DanmakusRetainer.IDanmakusRetainer
        public void fix(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku, master.flame.danmaku.danmaku.model.IDisplayer iDisplayer, master.flame.danmaku.danmaku.renderer.android.DanmakusRetainer.Verifier verifier) {
            int i;
            boolean z;
            master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku2;
            master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku3;
            master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku4 = baseDanmaku;
            if (baseDanmaku4.isOutside()) {
                return;
            }
            boolean zIsShown = baseDanmaku4.isShown();
            float top = zIsShown ? baseDanmaku4.getTop() : -1.0f;
            int i2 = 1;
            boolean z2 = false;
            boolean z3 = (zIsShown || this.mVisibleDanmakus.isEmpty()) ? false : true;
            if (top < 0.0f) {
                top = iDisplayer.getHeight() - baseDanmaku4.paintHeight;
            }
            master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku5 = null;
            if (zIsShown) {
                i2 = 0;
            } else {
                this.mCancelFixingFlag = false;
                master.flame.danmaku.danmaku.model.IDanmakuIterator it = this.mVisibleDanmakus.iterator();
                float top2 = top;
                master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku6 = null;
                int i3 = 0;
                while (true) {
                    if (!this.mCancelFixingFlag && it.hasNext()) {
                        i = i3 + 1;
                        master.flame.danmaku.danmaku.model.BaseDanmaku next = it.next();
                        if (next != baseDanmaku4) {
                            if (baseDanmaku6 != null) {
                                baseDanmaku3 = baseDanmaku6;
                            } else {
                                if (next.getBottom() != iDisplayer.getHeight()) {
                                    baseDanmaku2 = next;
                                    z = z3;
                                    break;
                                }
                                baseDanmaku3 = next;
                            }
                            if (top2 < 0.0f) {
                                z = z3;
                            } else {
                                master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku7 = baseDanmaku4;
                                boolean zWillHitInDuration = master.flame.danmaku.danmaku.util.DanmakuUtils.willHitInDuration(iDisplayer, next, baseDanmaku7, baseDanmaku4.getDuration(), baseDanmaku4.getTimer().currMillisecond);
                                baseDanmaku4 = baseDanmaku7;
                                if (zWillHitInDuration) {
                                    top2 = next.getTop() - baseDanmaku4.paintHeight;
                                    z3 = zWillHitInDuration;
                                    i3 = i;
                                    baseDanmaku6 = baseDanmaku3;
                                } else {
                                    baseDanmaku5 = next;
                                    z = zWillHitInDuration;
                                }
                            }
                            baseDanmaku2 = baseDanmaku3;
                            break;
                        }
                        baseDanmaku2 = baseDanmaku6;
                        z = false;
                        break;
                    }
                    i = i3;
                    z = z3;
                    baseDanmaku2 = baseDanmaku6;
                    break;
                }
                float f = top2;
                boolean zIsOutVerticalEdge = isOutVerticalEdge(false, baseDanmaku4, iDisplayer, f, baseDanmaku2, null);
                if (zIsOutVerticalEdge) {
                    z2 = zIsOutVerticalEdge;
                    top = iDisplayer.getHeight() - baseDanmaku4.paintHeight;
                    z3 = true;
                } else {
                    boolean z4 = f >= 0.0f ? false : z;
                    if (baseDanmaku5 != null) {
                        boolean z5 = z4;
                        i2 = i - 1;
                        z3 = z5;
                        z2 = zIsOutVerticalEdge;
                        top = f;
                    } else {
                        z2 = zIsOutVerticalEdge;
                        top = f;
                        z3 = z4;
                        i2 = i;
                    }
                }
            }
            if (verifier == null || !verifier.skipLayout(baseDanmaku4, top, i2, z3)) {
                if (z2) {
                    clear();
                }
                baseDanmaku4.layout(iDisplayer, baseDanmaku4.getLeft(), top);
                if (zIsShown) {
                    return;
                }
                this.mVisibleDanmakus.removeItem(baseDanmaku5);
                this.mVisibleDanmakus.addItem(baseDanmaku4);
            }
        }

        @Override // master.flame.danmaku.danmaku.renderer.android.DanmakusRetainer.FTDanmakusRetainer, master.flame.danmaku.danmaku.renderer.android.DanmakusRetainer.AlignTopRetainer
        protected boolean isOutVerticalEdge(boolean z, master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku, master.flame.danmaku.danmaku.model.IDisplayer iDisplayer, float f, master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku2, master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku3) {
            if (f >= 0.0f) {
                return (baseDanmaku2 == null || baseDanmaku2.getBottom() == ((float) iDisplayer.getHeight())) ? false : true;
            }
            return true;
        }

        @Override // master.flame.danmaku.danmaku.renderer.android.DanmakusRetainer.AlignTopRetainer, master.flame.danmaku.danmaku.renderer.android.DanmakusRetainer.IDanmakusRetainer
        public void clear() {
            this.mCancelFixingFlag = true;
            this.mVisibleDanmakus.clear();
        }
    }
}
