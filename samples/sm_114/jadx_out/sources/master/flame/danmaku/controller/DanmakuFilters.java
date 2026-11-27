package master.flame.danmaku.controller;

/* JADX INFO: loaded from: classes2.dex */
public class DanmakuFilters {
    public static final int FILTER_TYPE_DUPLICATE_MERGE = 128;
    public static final int FILTER_TYPE_ELAPSED_TIME = 4;
    public static final int FILTER_TYPE_MAXIMUM_LINES = 256;
    public static final int FILTER_TYPE_OVERLAPPING = 512;
    public static final int FILTER_TYPE_TEXTCOLOR = 8;
    public static final int FILTER_TYPE_TYPE = 1;
    public static final int FILTER_TYPE_USER_GUEST = 64;
    public static final int FILTER_TYPE_USER_HASH = 32;
    public static final int FILTER_TYPE_USER_ID = 16;
    public static final int FILYER_TYPE_QUANTITY = 2;
    public static final java.lang.String TAG_DUPLICATE_FILTER = "1017_Filter";
    public static final java.lang.String TAG_ELAPSED_TIME_FILTER = "1012_Filter";
    public static final java.lang.String TAG_GUEST_FILTER = "1016_Filter";
    public static final java.lang.String TAG_MAXIMUN_LINES_FILTER = "1018_Filter";
    public static final java.lang.String TAG_OVERLAPPING_FILTER = "1019_Filter";
    public static final java.lang.String TAG_QUANTITY_DANMAKU_FILTER = "1011_Filter";
    public static final java.lang.String TAG_TEXT_COLOR_DANMAKU_FILTER = "1013_Filter";
    public static final java.lang.String TAG_TYPE_DANMAKU_FILTER = "1010_Filter";
    public static final java.lang.String TAG_USER_HASH_FILTER = "1015_Filter";
    public static final java.lang.String TAG_USER_ID_FILTER = "1014_Filter";
    public final java.lang.Exception filterException = new java.lang.Exception("not suuport this filter tag");
    private final java.util.Map<java.lang.String, master.flame.danmaku.controller.DanmakuFilters.IDanmakuFilter<?>> filters = java.util.Collections.synchronizedSortedMap(new java.util.TreeMap());
    private final java.util.Map<java.lang.String, master.flame.danmaku.controller.DanmakuFilters.IDanmakuFilter<?>> filtersSecondary = java.util.Collections.synchronizedSortedMap(new java.util.TreeMap());
    master.flame.danmaku.controller.DanmakuFilters.IDanmakuFilter<?>[] mFilterArray = new master.flame.danmaku.controller.DanmakuFilters.IDanmakuFilter[0];
    master.flame.danmaku.controller.DanmakuFilters.IDanmakuFilter<?>[] mFilterArraySecondary = new master.flame.danmaku.controller.DanmakuFilters.IDanmakuFilter[0];

    public static abstract class BaseDanmakuFilter<T> implements master.flame.danmaku.controller.DanmakuFilters.IDanmakuFilter<T> {
        @Override // master.flame.danmaku.controller.DanmakuFilters.IDanmakuFilter
        public void clear() {
        }
    }

    public interface IDanmakuFilter<T> {
        void clear();

        boolean filter(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku, int i, int i2, master.flame.danmaku.danmaku.model.DanmakuTimer danmakuTimer, boolean z, master.flame.danmaku.danmaku.model.android.DanmakuContext danmakuContext);

        void reset();

        void setData(T t);
    }

    public static class TypeDanmakuFilter extends master.flame.danmaku.controller.DanmakuFilters.BaseDanmakuFilter<java.util.List<java.lang.Integer>> {
        final java.util.List<java.lang.Integer> mFilterTypes = java.util.Collections.synchronizedList(new java.util.ArrayList());

        public void enableType(java.lang.Integer num) {
            if (this.mFilterTypes.contains(num)) {
                return;
            }
            this.mFilterTypes.add(num);
        }

        public void disableType(java.lang.Integer num) {
            if (this.mFilterTypes.contains(num)) {
                this.mFilterTypes.remove(num);
            }
        }

        @Override // master.flame.danmaku.controller.DanmakuFilters.IDanmakuFilter
        public boolean filter(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku, int i, int i2, master.flame.danmaku.danmaku.model.DanmakuTimer danmakuTimer, boolean z, master.flame.danmaku.danmaku.model.android.DanmakuContext danmakuContext) {
            boolean z2 = baseDanmaku != null && this.mFilterTypes.contains(java.lang.Integer.valueOf(baseDanmaku.getType()));
            if (z2) {
                baseDanmaku.mFilterParam = 1 | baseDanmaku.mFilterParam;
            }
            return z2;
        }

        @Override // master.flame.danmaku.controller.DanmakuFilters.IDanmakuFilter
        public void setData(java.util.List<java.lang.Integer> list) {
            reset();
            if (list != null) {
                java.util.Iterator<java.lang.Integer> it = list.iterator();
                while (it.hasNext()) {
                    enableType(it.next());
                }
            }
        }

        @Override // master.flame.danmaku.controller.DanmakuFilters.IDanmakuFilter
        public void reset() {
            this.mFilterTypes.clear();
        }
    }

    public static class QuantityDanmakuFilter extends master.flame.danmaku.controller.DanmakuFilters.BaseDanmakuFilter<java.lang.Integer> {
        protected int mMaximumSize = -1;
        protected master.flame.danmaku.danmaku.model.BaseDanmaku mLastSkipped = null;
        private float mFilterFactor = 1.0f;

        private boolean needFilter(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku, int i, int i2, master.flame.danmaku.danmaku.model.DanmakuTimer danmakuTimer, boolean z, master.flame.danmaku.danmaku.model.android.DanmakuContext danmakuContext) {
            if (this.mMaximumSize > 0 && baseDanmaku.getType() == 1) {
                master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku2 = this.mLastSkipped;
                if (baseDanmaku2 == null || baseDanmaku2.isTimeOut()) {
                    this.mLastSkipped = baseDanmaku;
                } else {
                    long actualTime = baseDanmaku.getActualTime() - this.mLastSkipped.getActualTime();
                    if ((actualTime >= 0 && actualTime < danmakuContext.mDanmakuFactory.MAX_Duration_Scroll_Danmaku.value * this.mFilterFactor) || i > this.mMaximumSize) {
                        return true;
                    }
                    this.mLastSkipped = baseDanmaku;
                    return false;
                }
            }
            return false;
        }

        @Override // master.flame.danmaku.controller.DanmakuFilters.IDanmakuFilter
        public synchronized boolean filter(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku, int i, int i2, master.flame.danmaku.danmaku.model.DanmakuTimer danmakuTimer, boolean z, master.flame.danmaku.danmaku.model.android.DanmakuContext danmakuContext) throws java.lang.Throwable {
            try {
                try {
                    boolean zNeedFilter = needFilter(baseDanmaku, i, i2, danmakuTimer, z, danmakuContext);
                    if (zNeedFilter) {
                        baseDanmaku.mFilterParam |= 2;
                    }
                    return zNeedFilter;
                } catch (java.lang.Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        }

        @Override // master.flame.danmaku.controller.DanmakuFilters.IDanmakuFilter
        public void setData(java.lang.Integer num) {
            reset();
            if (num == null || num.intValue() == this.mMaximumSize) {
                return;
            }
            int iIntValue = num.intValue() + (num.intValue() / 5);
            this.mMaximumSize = iIntValue;
            this.mFilterFactor = 1.0f / iIntValue;
        }

        @Override // master.flame.danmaku.controller.DanmakuFilters.IDanmakuFilter
        public synchronized void reset() {
            this.mLastSkipped = null;
        }

        @Override // master.flame.danmaku.controller.DanmakuFilters.BaseDanmakuFilter, master.flame.danmaku.controller.DanmakuFilters.IDanmakuFilter
        public void clear() {
            reset();
        }
    }

    public static class ElapsedTimeFilter extends master.flame.danmaku.controller.DanmakuFilters.BaseDanmakuFilter<java.lang.Object> {
        long mMaxTime = 20;

        private synchronized boolean needFilter(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku, int i, int i2, master.flame.danmaku.danmaku.model.DanmakuTimer danmakuTimer, boolean z) {
            if (danmakuTimer != null) {
                if (baseDanmaku.isOutside()) {
                    return master.flame.danmaku.danmaku.util.SystemClock.uptimeMillis() - danmakuTimer.currMillisecond >= this.mMaxTime;
                }
            }
            return false;
        }

        @Override // master.flame.danmaku.controller.DanmakuFilters.IDanmakuFilter
        public boolean filter(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku, int i, int i2, master.flame.danmaku.danmaku.model.DanmakuTimer danmakuTimer, boolean z, master.flame.danmaku.danmaku.model.android.DanmakuContext danmakuContext) {
            boolean zNeedFilter = needFilter(baseDanmaku, i, i2, danmakuTimer, z);
            if (zNeedFilter) {
                baseDanmaku.mFilterParam |= 4;
            }
            return zNeedFilter;
        }

        @Override // master.flame.danmaku.controller.DanmakuFilters.IDanmakuFilter
        public void setData(java.lang.Object obj) {
            reset();
        }

        @Override // master.flame.danmaku.controller.DanmakuFilters.IDanmakuFilter
        public synchronized void reset() {
        }

        @Override // master.flame.danmaku.controller.DanmakuFilters.BaseDanmakuFilter, master.flame.danmaku.controller.DanmakuFilters.IDanmakuFilter
        public void clear() {
            reset();
        }
    }

    public static class TextColorFilter extends master.flame.danmaku.controller.DanmakuFilters.BaseDanmakuFilter<java.util.List<java.lang.Integer>> {
        public java.util.List<java.lang.Integer> mWhiteList = new java.util.ArrayList();

        private void addToWhiteList(java.lang.Integer num) {
            if (this.mWhiteList.contains(num)) {
                return;
            }
            this.mWhiteList.add(num);
        }

        @Override // master.flame.danmaku.controller.DanmakuFilters.IDanmakuFilter
        public boolean filter(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku, int i, int i2, master.flame.danmaku.danmaku.model.DanmakuTimer danmakuTimer, boolean z, master.flame.danmaku.danmaku.model.android.DanmakuContext danmakuContext) {
            boolean z2 = (baseDanmaku == null || this.mWhiteList.contains(java.lang.Integer.valueOf(baseDanmaku.textColor))) ? false : true;
            if (z2) {
                baseDanmaku.mFilterParam |= 8;
            }
            return z2;
        }

        @Override // master.flame.danmaku.controller.DanmakuFilters.IDanmakuFilter
        public void setData(java.util.List<java.lang.Integer> list) {
            reset();
            if (list != null) {
                java.util.Iterator<java.lang.Integer> it = list.iterator();
                while (it.hasNext()) {
                    addToWhiteList(it.next());
                }
            }
        }

        @Override // master.flame.danmaku.controller.DanmakuFilters.IDanmakuFilter
        public void reset() {
            this.mWhiteList.clear();
        }
    }

    public static abstract class UserFilter<T> extends master.flame.danmaku.controller.DanmakuFilters.BaseDanmakuFilter<java.util.List<T>> {
        public java.util.List<T> mBlackList = new java.util.ArrayList();

        @Override // master.flame.danmaku.controller.DanmakuFilters.IDanmakuFilter
        public abstract boolean filter(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku, int i, int i2, master.flame.danmaku.danmaku.model.DanmakuTimer danmakuTimer, boolean z, master.flame.danmaku.danmaku.model.android.DanmakuContext danmakuContext);

        private void addToBlackList(T t) {
            if (this.mBlackList.contains(t)) {
                return;
            }
            this.mBlackList.add(t);
        }

        @Override // master.flame.danmaku.controller.DanmakuFilters.IDanmakuFilter
        public void setData(java.util.List<T> list) {
            reset();
            if (list != null) {
                java.util.Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    addToBlackList(it.next());
                }
            }
        }

        @Override // master.flame.danmaku.controller.DanmakuFilters.IDanmakuFilter
        public void reset() {
            this.mBlackList.clear();
        }
    }

    public static class UserIdFilter extends master.flame.danmaku.controller.DanmakuFilters.UserFilter<java.lang.Integer> {
        @Override // master.flame.danmaku.controller.DanmakuFilters.UserFilter, master.flame.danmaku.controller.DanmakuFilters.IDanmakuFilter
        public boolean filter(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku, int i, int i2, master.flame.danmaku.danmaku.model.DanmakuTimer danmakuTimer, boolean z, master.flame.danmaku.danmaku.model.android.DanmakuContext danmakuContext) {
            boolean z2 = baseDanmaku != null && this.mBlackList.contains(java.lang.Integer.valueOf(baseDanmaku.userId));
            if (z2) {
                baseDanmaku.mFilterParam |= 16;
            }
            return z2;
        }
    }

    public static class UserHashFilter extends master.flame.danmaku.controller.DanmakuFilters.UserFilter<java.lang.String> {
        @Override // master.flame.danmaku.controller.DanmakuFilters.UserFilter, master.flame.danmaku.controller.DanmakuFilters.IDanmakuFilter
        public boolean filter(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku, int i, int i2, master.flame.danmaku.danmaku.model.DanmakuTimer danmakuTimer, boolean z, master.flame.danmaku.danmaku.model.android.DanmakuContext danmakuContext) {
            boolean z2 = baseDanmaku != null && this.mBlackList.contains(baseDanmaku.userHash);
            if (z2) {
                baseDanmaku.mFilterParam |= 32;
            }
            return z2;
        }
    }

    public static class GuestFilter extends master.flame.danmaku.controller.DanmakuFilters.BaseDanmakuFilter<java.lang.Boolean> {
        private java.lang.Boolean mBlock = false;

        @Override // master.flame.danmaku.controller.DanmakuFilters.IDanmakuFilter
        public boolean filter(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku, int i, int i2, master.flame.danmaku.danmaku.model.DanmakuTimer danmakuTimer, boolean z, master.flame.danmaku.danmaku.model.android.DanmakuContext danmakuContext) {
            boolean z2 = this.mBlock.booleanValue() && baseDanmaku.isGuest;
            if (z2) {
                baseDanmaku.mFilterParam |= 64;
            }
            return z2;
        }

        @Override // master.flame.danmaku.controller.DanmakuFilters.IDanmakuFilter
        public void setData(java.lang.Boolean bool) {
            this.mBlock = bool;
        }

        @Override // master.flame.danmaku.controller.DanmakuFilters.IDanmakuFilter
        public void reset() {
            this.mBlock = false;
        }
    }

    public static class DuplicateMergingFilter extends master.flame.danmaku.controller.DanmakuFilters.BaseDanmakuFilter<java.lang.Void> {
        protected final master.flame.danmaku.danmaku.model.IDanmakus blockedDanmakus = new master.flame.danmaku.danmaku.model.android.Danmakus(4);
        protected final java.util.LinkedHashMap<java.lang.String, master.flame.danmaku.danmaku.model.BaseDanmaku> currentDanmakus = new java.util.LinkedHashMap<>();
        private final master.flame.danmaku.danmaku.model.IDanmakus passedDanmakus = new master.flame.danmaku.danmaku.model.android.Danmakus(4);

        @Override // master.flame.danmaku.controller.DanmakuFilters.IDanmakuFilter
        public void setData(java.lang.Void r1) {
        }

        private final void removeTimeoutDanmakus(master.flame.danmaku.danmaku.model.IDanmakus iDanmakus, long j) {
            master.flame.danmaku.danmaku.model.IDanmakuIterator it = iDanmakus.iterator();
            long jUptimeMillis = master.flame.danmaku.danmaku.util.SystemClock.uptimeMillis();
            while (it.hasNext()) {
                try {
                    if (!it.next().isTimeOut()) {
                        return;
                    }
                    it.remove();
                    if (master.flame.danmaku.danmaku.util.SystemClock.uptimeMillis() - jUptimeMillis > j) {
                        return;
                    }
                } catch (java.lang.Exception unused) {
                    return;
                }
            }
        }

        private void removeTimeoutDanmakus(java.util.LinkedHashMap<java.lang.String, master.flame.danmaku.danmaku.model.BaseDanmaku> linkedHashMap, int i) {
            java.util.Iterator<java.util.Map.Entry<java.lang.String, master.flame.danmaku.danmaku.model.BaseDanmaku>> it = linkedHashMap.entrySet().iterator();
            long jUptimeMillis = master.flame.danmaku.danmaku.util.SystemClock.uptimeMillis();
            while (it.hasNext()) {
                try {
                    if (!it.next().getValue().isTimeOut()) {
                        return;
                    }
                    it.remove();
                    if (master.flame.danmaku.danmaku.util.SystemClock.uptimeMillis() - jUptimeMillis > i) {
                        return;
                    }
                } catch (java.lang.Exception unused) {
                    return;
                }
            }
        }

        public synchronized boolean needFilter(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku, int i, int i2, master.flame.danmaku.danmaku.model.DanmakuTimer danmakuTimer, boolean z) {
            removeTimeoutDanmakus(this.blockedDanmakus, 2L);
            removeTimeoutDanmakus(this.passedDanmakus, 2L);
            removeTimeoutDanmakus(this.currentDanmakus, 3);
            if (this.blockedDanmakus.contains(baseDanmaku) && !baseDanmaku.isOutside()) {
                return true;
            }
            if (this.passedDanmakus.contains(baseDanmaku)) {
                return false;
            }
            if (this.currentDanmakus.containsKey(baseDanmaku.text)) {
                this.currentDanmakus.put(java.lang.String.valueOf(baseDanmaku.text), baseDanmaku);
                this.blockedDanmakus.removeItem(baseDanmaku);
                this.blockedDanmakus.addItem(baseDanmaku);
                return true;
            }
            this.currentDanmakus.put(java.lang.String.valueOf(baseDanmaku.text), baseDanmaku);
            this.passedDanmakus.addItem(baseDanmaku);
            return false;
        }

        @Override // master.flame.danmaku.controller.DanmakuFilters.IDanmakuFilter
        public boolean filter(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku, int i, int i2, master.flame.danmaku.danmaku.model.DanmakuTimer danmakuTimer, boolean z, master.flame.danmaku.danmaku.model.android.DanmakuContext danmakuContext) {
            boolean zNeedFilter = needFilter(baseDanmaku, i, i2, danmakuTimer, z);
            if (zNeedFilter) {
                baseDanmaku.mFilterParam |= 128;
            }
            return zNeedFilter;
        }

        @Override // master.flame.danmaku.controller.DanmakuFilters.IDanmakuFilter
        public synchronized void reset() {
            this.passedDanmakus.clear();
            this.blockedDanmakus.clear();
            this.currentDanmakus.clear();
        }

        @Override // master.flame.danmaku.controller.DanmakuFilters.BaseDanmakuFilter, master.flame.danmaku.controller.DanmakuFilters.IDanmakuFilter
        public void clear() {
            reset();
        }
    }

    public static class MaximumLinesFilter extends master.flame.danmaku.controller.DanmakuFilters.BaseDanmakuFilter<java.util.Map<java.lang.Integer, java.lang.Integer>> {
        private java.util.Map<java.lang.Integer, java.lang.Integer> mMaximumLinesPairs;

        @Override // master.flame.danmaku.controller.DanmakuFilters.IDanmakuFilter
        public boolean filter(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku, int i, int i2, master.flame.danmaku.danmaku.model.DanmakuTimer danmakuTimer, boolean z, master.flame.danmaku.danmaku.model.android.DanmakuContext danmakuContext) {
            java.util.Map<java.lang.Integer, java.lang.Integer> map = this.mMaximumLinesPairs;
            boolean z2 = false;
            if (map != null) {
                java.lang.Integer num = map.get(java.lang.Integer.valueOf(baseDanmaku.getType()));
                if (num != null && i >= num.intValue()) {
                    z2 = true;
                }
                if (z2) {
                    baseDanmaku.mFilterParam |= 256;
                }
            }
            return z2;
        }

        @Override // master.flame.danmaku.controller.DanmakuFilters.IDanmakuFilter
        public void setData(java.util.Map<java.lang.Integer, java.lang.Integer> map) {
            this.mMaximumLinesPairs = map;
        }

        @Override // master.flame.danmaku.controller.DanmakuFilters.IDanmakuFilter
        public void reset() {
            this.mMaximumLinesPairs = null;
        }
    }

    public static class OverlappingFilter extends master.flame.danmaku.controller.DanmakuFilters.BaseDanmakuFilter<java.util.Map<java.lang.Integer, java.lang.Boolean>> {
        private java.util.Map<java.lang.Integer, java.lang.Boolean> mEnabledPairs;

        @Override // master.flame.danmaku.controller.DanmakuFilters.IDanmakuFilter
        public boolean filter(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku, int i, int i2, master.flame.danmaku.danmaku.model.DanmakuTimer danmakuTimer, boolean z, master.flame.danmaku.danmaku.model.android.DanmakuContext danmakuContext) {
            java.util.Map<java.lang.Integer, java.lang.Boolean> map = this.mEnabledPairs;
            boolean z2 = false;
            if (map != null) {
                java.lang.Boolean bool = map.get(java.lang.Integer.valueOf(baseDanmaku.getType()));
                if (bool != null && bool.booleanValue() && z) {
                    z2 = true;
                }
                if (z2) {
                    baseDanmaku.mFilterParam |= 512;
                }
            }
            return z2;
        }

        @Override // master.flame.danmaku.controller.DanmakuFilters.IDanmakuFilter
        public void setData(java.util.Map<java.lang.Integer, java.lang.Boolean> map) {
            this.mEnabledPairs = map;
        }

        @Override // master.flame.danmaku.controller.DanmakuFilters.IDanmakuFilter
        public void reset() {
            this.mEnabledPairs = null;
        }
    }

    public void filter(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku, int i, int i2, master.flame.danmaku.danmaku.model.DanmakuTimer danmakuTimer, boolean z, master.flame.danmaku.danmaku.model.android.DanmakuContext danmakuContext) {
        for (master.flame.danmaku.controller.DanmakuFilters.IDanmakuFilter<?> iDanmakuFilter : this.mFilterArray) {
            if (iDanmakuFilter != null) {
                boolean zFilter = iDanmakuFilter.filter(baseDanmaku, i, i2, danmakuTimer, z, danmakuContext);
                baseDanmaku.filterResetFlag = danmakuContext.mGlobalFlagValues.FILTER_RESET_FLAG;
                if (zFilter) {
                    return;
                }
            }
        }
    }

    public boolean filterSecondary(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku, int i, int i2, master.flame.danmaku.danmaku.model.DanmakuTimer danmakuTimer, boolean z, master.flame.danmaku.danmaku.model.android.DanmakuContext danmakuContext) {
        for (master.flame.danmaku.controller.DanmakuFilters.IDanmakuFilter<?> iDanmakuFilter : this.mFilterArraySecondary) {
            if (iDanmakuFilter != null) {
                boolean zFilter = iDanmakuFilter.filter(baseDanmaku, i, i2, danmakuTimer, z, danmakuContext);
                baseDanmaku.filterResetFlag = danmakuContext.mGlobalFlagValues.FILTER_RESET_FLAG;
                if (zFilter) {
                    return true;
                }
            }
        }
        return false;
    }

    public master.flame.danmaku.controller.DanmakuFilters.IDanmakuFilter<?> get(java.lang.String str) {
        return get(str, true);
    }

    public master.flame.danmaku.controller.DanmakuFilters.IDanmakuFilter<?> get(java.lang.String str, boolean z) {
        master.flame.danmaku.controller.DanmakuFilters.IDanmakuFilter<?> iDanmakuFilter = (z ? this.filters : this.filtersSecondary).get(str);
        return iDanmakuFilter == null ? registerFilter(str, z) : iDanmakuFilter;
    }

    public master.flame.danmaku.controller.DanmakuFilters.IDanmakuFilter<?> registerFilter(java.lang.String str) {
        return registerFilter(str, true);
    }

    public master.flame.danmaku.controller.DanmakuFilters.IDanmakuFilter<?> registerFilter(java.lang.String str, boolean z) {
        if (str == null) {
            throwFilterException();
            return null;
        }
        master.flame.danmaku.controller.DanmakuFilters.IDanmakuFilter<?> overlappingFilter = this.filters.get(str);
        if (overlappingFilter == null) {
            if (TAG_TYPE_DANMAKU_FILTER.equals(str)) {
                overlappingFilter = new master.flame.danmaku.controller.DanmakuFilters.TypeDanmakuFilter();
            } else if (TAG_QUANTITY_DANMAKU_FILTER.equals(str)) {
                overlappingFilter = new master.flame.danmaku.controller.DanmakuFilters.QuantityDanmakuFilter();
            } else if (TAG_ELAPSED_TIME_FILTER.equals(str)) {
                overlappingFilter = new master.flame.danmaku.controller.DanmakuFilters.ElapsedTimeFilter();
            } else if (TAG_TEXT_COLOR_DANMAKU_FILTER.equals(str)) {
                overlappingFilter = new master.flame.danmaku.controller.DanmakuFilters.TextColorFilter();
            } else if (TAG_USER_ID_FILTER.equals(str)) {
                overlappingFilter = new master.flame.danmaku.controller.DanmakuFilters.UserIdFilter();
            } else if (TAG_USER_HASH_FILTER.equals(str)) {
                overlappingFilter = new master.flame.danmaku.controller.DanmakuFilters.UserHashFilter();
            } else if (TAG_GUEST_FILTER.equals(str)) {
                overlappingFilter = new master.flame.danmaku.controller.DanmakuFilters.GuestFilter();
            } else if (TAG_DUPLICATE_FILTER.equals(str)) {
                overlappingFilter = new master.flame.danmaku.controller.DanmakuFilters.DuplicateMergingFilter();
            } else if (TAG_MAXIMUN_LINES_FILTER.equals(str)) {
                overlappingFilter = new master.flame.danmaku.controller.DanmakuFilters.MaximumLinesFilter();
            } else if (TAG_OVERLAPPING_FILTER.equals(str)) {
                overlappingFilter = new master.flame.danmaku.controller.DanmakuFilters.OverlappingFilter();
            }
        }
        if (overlappingFilter == null) {
            throwFilterException();
            return null;
        }
        overlappingFilter.setData(null);
        if (z) {
            this.filters.put(str, overlappingFilter);
            this.mFilterArray = (master.flame.danmaku.controller.DanmakuFilters.IDanmakuFilter[]) this.filters.values().toArray(this.mFilterArray);
            return overlappingFilter;
        }
        this.filtersSecondary.put(str, overlappingFilter);
        this.mFilterArraySecondary = (master.flame.danmaku.controller.DanmakuFilters.IDanmakuFilter[]) this.filtersSecondary.values().toArray(this.mFilterArraySecondary);
        return overlappingFilter;
    }

    public void unregisterFilter(java.lang.String str) {
        unregisterFilter(str, true);
    }

    public void unregisterFilter(java.lang.String str, boolean z) {
        master.flame.danmaku.controller.DanmakuFilters.IDanmakuFilter<?> iDanmakuFilterRemove = (z ? this.filters : this.filtersSecondary).remove(str);
        if (iDanmakuFilterRemove != null) {
            iDanmakuFilterRemove.clear();
            if (z) {
                this.mFilterArray = (master.flame.danmaku.controller.DanmakuFilters.IDanmakuFilter[]) this.filters.values().toArray(this.mFilterArray);
            } else {
                this.mFilterArraySecondary = (master.flame.danmaku.controller.DanmakuFilters.IDanmakuFilter[]) this.filtersSecondary.values().toArray(this.mFilterArraySecondary);
            }
        }
    }

    public void clear() {
        for (master.flame.danmaku.controller.DanmakuFilters.IDanmakuFilter<?> iDanmakuFilter : this.mFilterArray) {
            if (iDanmakuFilter != null) {
                iDanmakuFilter.clear();
            }
        }
        for (master.flame.danmaku.controller.DanmakuFilters.IDanmakuFilter<?> iDanmakuFilter2 : this.mFilterArraySecondary) {
            if (iDanmakuFilter2 != null) {
                iDanmakuFilter2.clear();
            }
        }
    }

    public void reset() {
        for (master.flame.danmaku.controller.DanmakuFilters.IDanmakuFilter<?> iDanmakuFilter : this.mFilterArray) {
            if (iDanmakuFilter != null) {
                iDanmakuFilter.reset();
            }
        }
        for (master.flame.danmaku.controller.DanmakuFilters.IDanmakuFilter<?> iDanmakuFilter2 : this.mFilterArraySecondary) {
            if (iDanmakuFilter2 != null) {
                iDanmakuFilter2.reset();
            }
        }
    }

    public void release() {
        clear();
        this.filters.clear();
        this.mFilterArray = new master.flame.danmaku.controller.DanmakuFilters.IDanmakuFilter[0];
        this.filtersSecondary.clear();
        this.mFilterArraySecondary = new master.flame.danmaku.controller.DanmakuFilters.IDanmakuFilter[0];
    }

    private void throwFilterException() {
        try {
            throw this.filterException;
        } catch (java.lang.Exception unused) {
        }
    }
}
