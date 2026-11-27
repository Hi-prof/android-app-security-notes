package master.flame.danmaku.danmaku.model.android;

/* JADX INFO: loaded from: classes2.dex */
public class DanmakuContext {
    public master.flame.danmaku.danmaku.model.AbsDanmakuSync danmakuSync;
    private master.flame.danmaku.danmaku.model.android.BaseCacheStuffer mCacheStuffer;
    private java.util.List<java.lang.ref.WeakReference<master.flame.danmaku.danmaku.model.android.DanmakuContext.ConfigChangedCallback>> mCallbackList;
    private boolean mIsMaxLinesLimited;
    private boolean mIsPreventOverlappingEnabled;
    public android.graphics.Typeface mFont = null;
    public int transparency = master.flame.danmaku.danmaku.model.AlphaValue.MAX;
    public float scaleTextSize = 1.0f;
    public boolean FTDanmakuVisibility = true;
    public boolean FBDanmakuVisibility = true;
    public boolean L2RDanmakuVisibility = true;
    public boolean R2LDanmakuVisibility = true;
    public boolean SpecialDanmakuVisibility = true;
    java.util.List<java.lang.Integer> mFilterTypes = new java.util.ArrayList();
    public int maximumNumsInScreen = -1;
    public float scrollSpeedFactor = 1.0f;
    public int refreshRateMS = 15;
    public master.flame.danmaku.danmaku.model.android.DanmakuContext.BorderType shadowType = master.flame.danmaku.danmaku.model.android.DanmakuContext.BorderType.SHADOW;
    public int shadowRadius = 3;
    java.util.List<java.lang.Integer> mColorValueWhiteList = new java.util.ArrayList();
    java.util.List<java.lang.Integer> mUserIdBlackList = new java.util.ArrayList();
    java.util.List<java.lang.String> mUserHashBlackList = new java.util.ArrayList();
    private boolean mBlockGuestDanmaku = false;
    private boolean mDuplicateMergingEnable = false;
    private boolean mIsAlignBottom = false;
    private final master.flame.danmaku.danmaku.model.AbsDisplayer mDisplayer = new master.flame.danmaku.danmaku.model.android.AndroidDisplayer();
    public final master.flame.danmaku.danmaku.model.GlobalFlagValues mGlobalFlagValues = new master.flame.danmaku.danmaku.model.GlobalFlagValues();
    public final master.flame.danmaku.controller.DanmakuFilters mDanmakuFilters = new master.flame.danmaku.controller.DanmakuFilters();
    public final master.flame.danmaku.danmaku.model.android.DanmakuFactory mDanmakuFactory = master.flame.danmaku.danmaku.model.android.DanmakuFactory.create();

    public enum BorderType {
        NONE,
        SHADOW,
        STROKEN
    }

    public interface ConfigChangedCallback {
        boolean onDanmakuConfigChanged(master.flame.danmaku.danmaku.model.android.DanmakuContext danmakuContext, master.flame.danmaku.danmaku.model.android.DanmakuContext.DanmakuConfigTag danmakuConfigTag, java.lang.Object... objArr);
    }

    public static master.flame.danmaku.danmaku.model.android.DanmakuContext create() {
        return new master.flame.danmaku.danmaku.model.android.DanmakuContext();
    }

    public enum DanmakuConfigTag {
        FT_DANMAKU_VISIBILITY,
        FB_DANMAKU_VISIBILITY,
        L2R_DANMAKU_VISIBILITY,
        R2L_DANMAKU_VISIBILIY,
        SPECIAL_DANMAKU_VISIBILITY,
        TYPEFACE,
        TRANSPARENCY,
        SCALE_TEXTSIZE,
        MAXIMUM_NUMS_IN_SCREEN,
        DANMAKU_STYLE,
        DANMAKU_BOLD,
        COLOR_VALUE_WHITE_LIST,
        USER_ID_BLACK_LIST,
        USER_HASH_BLACK_LIST,
        SCROLL_SPEED_FACTOR,
        BLOCK_GUEST_DANMAKU,
        DUPLICATE_MERGING_ENABLED,
        MAXIMUN_LINES,
        OVERLAPPING_ENABLE,
        ALIGN_BOTTOM;

        public boolean isVisibilityRelatedTag() {
            return equals(FT_DANMAKU_VISIBILITY) || equals(FB_DANMAKU_VISIBILITY) || equals(L2R_DANMAKU_VISIBILITY) || equals(R2L_DANMAKU_VISIBILIY) || equals(SPECIAL_DANMAKU_VISIBILITY) || equals(COLOR_VALUE_WHITE_LIST) || equals(USER_ID_BLACK_LIST);
        }
    }

    public master.flame.danmaku.danmaku.model.AbsDisplayer getDisplayer() {
        return this.mDisplayer;
    }

    public master.flame.danmaku.danmaku.model.android.DanmakuContext setTypeface(android.graphics.Typeface typeface) {
        if (this.mFont != typeface) {
            this.mFont = typeface;
            this.mDisplayer.clearTextHeightCache();
            this.mDisplayer.setTypeFace(typeface);
            notifyConfigureChanged(master.flame.danmaku.danmaku.model.android.DanmakuContext.DanmakuConfigTag.TYPEFACE, new java.lang.Object[0]);
        }
        return this;
    }

    public master.flame.danmaku.danmaku.model.android.DanmakuContext setDanmakuTransparency(float f) {
        int i = (int) (master.flame.danmaku.danmaku.model.AlphaValue.MAX * f);
        if (i != this.transparency) {
            this.transparency = i;
            this.mDisplayer.setTransparency(i);
            notifyConfigureChanged(master.flame.danmaku.danmaku.model.android.DanmakuContext.DanmakuConfigTag.TRANSPARENCY, java.lang.Float.valueOf(f));
        }
        return this;
    }

    public master.flame.danmaku.danmaku.model.android.DanmakuContext setScaleTextSize(float f) {
        if (this.scaleTextSize != f) {
            this.scaleTextSize = f;
            this.mDisplayer.clearTextHeightCache();
            this.mDisplayer.setScaleTextSizeFactor(f);
            this.mGlobalFlagValues.updateMeasureFlag();
            this.mGlobalFlagValues.updateVisibleFlag();
            notifyConfigureChanged(master.flame.danmaku.danmaku.model.android.DanmakuContext.DanmakuConfigTag.SCALE_TEXTSIZE, java.lang.Float.valueOf(f));
        }
        return this;
    }

    public boolean getFTDanmakuVisibility() {
        return this.FTDanmakuVisibility;
    }

    public master.flame.danmaku.danmaku.model.android.DanmakuContext setFTDanmakuVisibility(boolean z) {
        setDanmakuVisible(z, 5);
        setFilterData(master.flame.danmaku.controller.DanmakuFilters.TAG_TYPE_DANMAKU_FILTER, this.mFilterTypes);
        this.mGlobalFlagValues.updateFilterFlag();
        if (this.FTDanmakuVisibility != z) {
            this.FTDanmakuVisibility = z;
            notifyConfigureChanged(master.flame.danmaku.danmaku.model.android.DanmakuContext.DanmakuConfigTag.FT_DANMAKU_VISIBILITY, java.lang.Boolean.valueOf(z));
        }
        return this;
    }

    private <T> void setFilterData(java.lang.String str, T t) {
        setFilterData(str, t, true);
    }

    private <T> void setFilterData(java.lang.String str, T t, boolean z) {
        this.mDanmakuFilters.get(str, z).setData(t);
    }

    private void setDanmakuVisible(boolean z, int i) {
        if (z) {
            this.mFilterTypes.remove(java.lang.Integer.valueOf(i));
        } else {
            if (this.mFilterTypes.contains(java.lang.Integer.valueOf(i))) {
                return;
            }
            this.mFilterTypes.add(java.lang.Integer.valueOf(i));
        }
    }

    public boolean getFBDanmakuVisibility() {
        return this.FBDanmakuVisibility;
    }

    public master.flame.danmaku.danmaku.model.android.DanmakuContext setFBDanmakuVisibility(boolean z) {
        setDanmakuVisible(z, 4);
        setFilterData(master.flame.danmaku.controller.DanmakuFilters.TAG_TYPE_DANMAKU_FILTER, this.mFilterTypes);
        this.mGlobalFlagValues.updateFilterFlag();
        if (this.FBDanmakuVisibility != z) {
            this.FBDanmakuVisibility = z;
            notifyConfigureChanged(master.flame.danmaku.danmaku.model.android.DanmakuContext.DanmakuConfigTag.FB_DANMAKU_VISIBILITY, java.lang.Boolean.valueOf(z));
        }
        return this;
    }

    public boolean getL2RDanmakuVisibility() {
        return this.L2RDanmakuVisibility;
    }

    public master.flame.danmaku.danmaku.model.android.DanmakuContext setL2RDanmakuVisibility(boolean z) {
        setDanmakuVisible(z, 6);
        setFilterData(master.flame.danmaku.controller.DanmakuFilters.TAG_TYPE_DANMAKU_FILTER, this.mFilterTypes);
        this.mGlobalFlagValues.updateFilterFlag();
        if (this.L2RDanmakuVisibility != z) {
            this.L2RDanmakuVisibility = z;
            notifyConfigureChanged(master.flame.danmaku.danmaku.model.android.DanmakuContext.DanmakuConfigTag.L2R_DANMAKU_VISIBILITY, java.lang.Boolean.valueOf(z));
        }
        return this;
    }

    public boolean getR2LDanmakuVisibility() {
        return this.R2LDanmakuVisibility;
    }

    public master.flame.danmaku.danmaku.model.android.DanmakuContext setR2LDanmakuVisibility(boolean z) {
        setDanmakuVisible(z, 1);
        setFilterData(master.flame.danmaku.controller.DanmakuFilters.TAG_TYPE_DANMAKU_FILTER, this.mFilterTypes);
        this.mGlobalFlagValues.updateFilterFlag();
        if (this.R2LDanmakuVisibility != z) {
            this.R2LDanmakuVisibility = z;
            notifyConfigureChanged(master.flame.danmaku.danmaku.model.android.DanmakuContext.DanmakuConfigTag.R2L_DANMAKU_VISIBILIY, java.lang.Boolean.valueOf(z));
        }
        return this;
    }

    public boolean getSpecialDanmakuVisibility() {
        return this.SpecialDanmakuVisibility;
    }

    public master.flame.danmaku.danmaku.model.android.DanmakuContext setSpecialDanmakuVisibility(boolean z) {
        setDanmakuVisible(z, 7);
        setFilterData(master.flame.danmaku.controller.DanmakuFilters.TAG_TYPE_DANMAKU_FILTER, this.mFilterTypes);
        this.mGlobalFlagValues.updateFilterFlag();
        if (this.SpecialDanmakuVisibility != z) {
            this.SpecialDanmakuVisibility = z;
            notifyConfigureChanged(master.flame.danmaku.danmaku.model.android.DanmakuContext.DanmakuConfigTag.SPECIAL_DANMAKU_VISIBILITY, java.lang.Boolean.valueOf(z));
        }
        return this;
    }

    public master.flame.danmaku.danmaku.model.android.DanmakuContext setMaximumVisibleSizeInScreen(int i) {
        this.maximumNumsInScreen = i;
        if (i == 0) {
            this.mDanmakuFilters.unregisterFilter(master.flame.danmaku.controller.DanmakuFilters.TAG_QUANTITY_DANMAKU_FILTER);
            this.mDanmakuFilters.unregisterFilter(master.flame.danmaku.controller.DanmakuFilters.TAG_ELAPSED_TIME_FILTER);
            notifyConfigureChanged(master.flame.danmaku.danmaku.model.android.DanmakuContext.DanmakuConfigTag.MAXIMUM_NUMS_IN_SCREEN, java.lang.Integer.valueOf(i));
            return this;
        }
        if (i == -1) {
            this.mDanmakuFilters.unregisterFilter(master.flame.danmaku.controller.DanmakuFilters.TAG_QUANTITY_DANMAKU_FILTER);
            this.mDanmakuFilters.registerFilter(master.flame.danmaku.controller.DanmakuFilters.TAG_ELAPSED_TIME_FILTER);
            notifyConfigureChanged(master.flame.danmaku.danmaku.model.android.DanmakuContext.DanmakuConfigTag.MAXIMUM_NUMS_IN_SCREEN, java.lang.Integer.valueOf(i));
            return this;
        }
        setFilterData(master.flame.danmaku.controller.DanmakuFilters.TAG_QUANTITY_DANMAKU_FILTER, java.lang.Integer.valueOf(i));
        this.mGlobalFlagValues.updateFilterFlag();
        notifyConfigureChanged(master.flame.danmaku.danmaku.model.android.DanmakuContext.DanmakuConfigTag.MAXIMUM_NUMS_IN_SCREEN, java.lang.Integer.valueOf(i));
        return this;
    }

    public master.flame.danmaku.danmaku.model.android.DanmakuContext setDanmakuStyle(int i, float... fArr) {
        this.mDisplayer.setDanmakuStyle(i, fArr);
        notifyConfigureChanged(master.flame.danmaku.danmaku.model.android.DanmakuContext.DanmakuConfigTag.DANMAKU_STYLE, java.lang.Integer.valueOf(i), fArr);
        return this;
    }

    public master.flame.danmaku.danmaku.model.android.DanmakuContext setDanmakuBold(boolean z) {
        this.mDisplayer.setFakeBoldText(z);
        notifyConfigureChanged(master.flame.danmaku.danmaku.model.android.DanmakuContext.DanmakuConfigTag.DANMAKU_BOLD, java.lang.Boolean.valueOf(z));
        return this;
    }

    public master.flame.danmaku.danmaku.model.android.DanmakuContext setColorValueWhiteList(java.lang.Integer... numArr) {
        this.mColorValueWhiteList.clear();
        if (numArr == null || numArr.length == 0) {
            this.mDanmakuFilters.unregisterFilter(master.flame.danmaku.controller.DanmakuFilters.TAG_TEXT_COLOR_DANMAKU_FILTER);
        } else {
            java.util.Collections.addAll(this.mColorValueWhiteList, numArr);
            setFilterData(master.flame.danmaku.controller.DanmakuFilters.TAG_TEXT_COLOR_DANMAKU_FILTER, this.mColorValueWhiteList);
        }
        this.mGlobalFlagValues.updateFilterFlag();
        notifyConfigureChanged(master.flame.danmaku.danmaku.model.android.DanmakuContext.DanmakuConfigTag.COLOR_VALUE_WHITE_LIST, this.mColorValueWhiteList);
        return this;
    }

    public java.util.List<java.lang.Integer> getColorValueWhiteList() {
        return this.mColorValueWhiteList;
    }

    public master.flame.danmaku.danmaku.model.android.DanmakuContext setUserHashBlackList(java.lang.String... strArr) {
        this.mUserHashBlackList.clear();
        if (strArr == null || strArr.length == 0) {
            this.mDanmakuFilters.unregisterFilter(master.flame.danmaku.controller.DanmakuFilters.TAG_USER_HASH_FILTER);
        } else {
            java.util.Collections.addAll(this.mUserHashBlackList, strArr);
            setFilterData(master.flame.danmaku.controller.DanmakuFilters.TAG_USER_HASH_FILTER, this.mUserHashBlackList);
        }
        this.mGlobalFlagValues.updateFilterFlag();
        notifyConfigureChanged(master.flame.danmaku.danmaku.model.android.DanmakuContext.DanmakuConfigTag.USER_HASH_BLACK_LIST, this.mUserHashBlackList);
        return this;
    }

    public master.flame.danmaku.danmaku.model.android.DanmakuContext removeUserHashBlackList(java.lang.String... strArr) {
        if (strArr != null && strArr.length != 0) {
            for (java.lang.String str : strArr) {
                this.mUserHashBlackList.remove(str);
            }
            setFilterData(master.flame.danmaku.controller.DanmakuFilters.TAG_USER_HASH_FILTER, this.mUserHashBlackList);
            this.mGlobalFlagValues.updateFilterFlag();
            notifyConfigureChanged(master.flame.danmaku.danmaku.model.android.DanmakuContext.DanmakuConfigTag.USER_HASH_BLACK_LIST, this.mUserHashBlackList);
        }
        return this;
    }

    public master.flame.danmaku.danmaku.model.android.DanmakuContext addUserHashBlackList(java.lang.String... strArr) {
        if (strArr != null && strArr.length != 0) {
            java.util.Collections.addAll(this.mUserHashBlackList, strArr);
            setFilterData(master.flame.danmaku.controller.DanmakuFilters.TAG_USER_HASH_FILTER, this.mUserHashBlackList);
            this.mGlobalFlagValues.updateFilterFlag();
            notifyConfigureChanged(master.flame.danmaku.danmaku.model.android.DanmakuContext.DanmakuConfigTag.USER_HASH_BLACK_LIST, this.mUserHashBlackList);
        }
        return this;
    }

    public java.util.List<java.lang.String> getUserHashBlackList() {
        return this.mUserHashBlackList;
    }

    public master.flame.danmaku.danmaku.model.android.DanmakuContext setUserIdBlackList(java.lang.Integer... numArr) {
        this.mUserIdBlackList.clear();
        if (numArr == null || numArr.length == 0) {
            this.mDanmakuFilters.unregisterFilter(master.flame.danmaku.controller.DanmakuFilters.TAG_USER_ID_FILTER);
        } else {
            java.util.Collections.addAll(this.mUserIdBlackList, numArr);
            setFilterData(master.flame.danmaku.controller.DanmakuFilters.TAG_USER_ID_FILTER, this.mUserIdBlackList);
        }
        this.mGlobalFlagValues.updateFilterFlag();
        notifyConfigureChanged(master.flame.danmaku.danmaku.model.android.DanmakuContext.DanmakuConfigTag.USER_ID_BLACK_LIST, this.mUserIdBlackList);
        return this;
    }

    public master.flame.danmaku.danmaku.model.android.DanmakuContext removeUserIdBlackList(java.lang.Integer... numArr) {
        if (numArr != null && numArr.length != 0) {
            for (java.lang.Integer num : numArr) {
                this.mUserIdBlackList.remove(num);
            }
            setFilterData(master.flame.danmaku.controller.DanmakuFilters.TAG_USER_ID_FILTER, this.mUserIdBlackList);
            this.mGlobalFlagValues.updateFilterFlag();
            notifyConfigureChanged(master.flame.danmaku.danmaku.model.android.DanmakuContext.DanmakuConfigTag.USER_ID_BLACK_LIST, this.mUserIdBlackList);
        }
        return this;
    }

    public master.flame.danmaku.danmaku.model.android.DanmakuContext addUserIdBlackList(java.lang.Integer... numArr) {
        if (numArr != null && numArr.length != 0) {
            java.util.Collections.addAll(this.mUserIdBlackList, numArr);
            setFilterData(master.flame.danmaku.controller.DanmakuFilters.TAG_USER_ID_FILTER, this.mUserIdBlackList);
            this.mGlobalFlagValues.updateFilterFlag();
            notifyConfigureChanged(master.flame.danmaku.danmaku.model.android.DanmakuContext.DanmakuConfigTag.USER_ID_BLACK_LIST, this.mUserIdBlackList);
        }
        return this;
    }

    public java.util.List<java.lang.Integer> getUserIdBlackList() {
        return this.mUserIdBlackList;
    }

    public master.flame.danmaku.danmaku.model.android.DanmakuContext blockGuestDanmaku(boolean z) {
        if (this.mBlockGuestDanmaku != z) {
            this.mBlockGuestDanmaku = z;
            if (z) {
                setFilterData(master.flame.danmaku.controller.DanmakuFilters.TAG_GUEST_FILTER, java.lang.Boolean.valueOf(z));
            } else {
                this.mDanmakuFilters.unregisterFilter(master.flame.danmaku.controller.DanmakuFilters.TAG_GUEST_FILTER);
            }
            this.mGlobalFlagValues.updateFilterFlag();
            notifyConfigureChanged(master.flame.danmaku.danmaku.model.android.DanmakuContext.DanmakuConfigTag.BLOCK_GUEST_DANMAKU, java.lang.Boolean.valueOf(z));
        }
        return this;
    }

    public master.flame.danmaku.danmaku.model.android.DanmakuContext setScrollSpeedFactor(float f) {
        if (this.scrollSpeedFactor != f) {
            this.scrollSpeedFactor = f;
            this.mDanmakuFactory.updateDurationFactor(f);
            this.mGlobalFlagValues.updateMeasureFlag();
            this.mGlobalFlagValues.updateVisibleFlag();
            notifyConfigureChanged(master.flame.danmaku.danmaku.model.android.DanmakuContext.DanmakuConfigTag.SCROLL_SPEED_FACTOR, java.lang.Float.valueOf(f));
        }
        return this;
    }

    public master.flame.danmaku.danmaku.model.android.DanmakuContext setDuplicateMergingEnabled(boolean z) {
        if (this.mDuplicateMergingEnable != z) {
            this.mDuplicateMergingEnable = z;
            this.mGlobalFlagValues.updateFilterFlag();
            notifyConfigureChanged(master.flame.danmaku.danmaku.model.android.DanmakuContext.DanmakuConfigTag.DUPLICATE_MERGING_ENABLED, java.lang.Boolean.valueOf(z));
        }
        return this;
    }

    public boolean isDuplicateMergingEnabled() {
        return this.mDuplicateMergingEnable;
    }

    public master.flame.danmaku.danmaku.model.android.DanmakuContext alignBottom(boolean z) {
        if (this.mIsAlignBottom != z) {
            this.mIsAlignBottom = z;
            notifyConfigureChanged(master.flame.danmaku.danmaku.model.android.DanmakuContext.DanmakuConfigTag.ALIGN_BOTTOM, java.lang.Boolean.valueOf(z));
            this.mGlobalFlagValues.updateVisibleFlag();
        }
        return this;
    }

    public boolean isAlignBottom() {
        return this.mIsAlignBottom;
    }

    public master.flame.danmaku.danmaku.model.android.DanmakuContext setMaximumLines(java.util.Map<java.lang.Integer, java.lang.Integer> map) {
        this.mIsMaxLinesLimited = map != null;
        if (map == null) {
            this.mDanmakuFilters.unregisterFilter(master.flame.danmaku.controller.DanmakuFilters.TAG_MAXIMUN_LINES_FILTER, false);
        } else {
            setFilterData(master.flame.danmaku.controller.DanmakuFilters.TAG_MAXIMUN_LINES_FILTER, map, false);
        }
        this.mGlobalFlagValues.updateFilterFlag();
        notifyConfigureChanged(master.flame.danmaku.danmaku.model.android.DanmakuContext.DanmakuConfigTag.MAXIMUN_LINES, map);
        return this;
    }

    @java.lang.Deprecated
    public master.flame.danmaku.danmaku.model.android.DanmakuContext setOverlapping(java.util.Map<java.lang.Integer, java.lang.Boolean> map) {
        return preventOverlapping(map);
    }

    public master.flame.danmaku.danmaku.model.android.DanmakuContext preventOverlapping(java.util.Map<java.lang.Integer, java.lang.Boolean> map) {
        this.mIsPreventOverlappingEnabled = map != null;
        if (map == null) {
            this.mDanmakuFilters.unregisterFilter(master.flame.danmaku.controller.DanmakuFilters.TAG_OVERLAPPING_FILTER, false);
        } else {
            setFilterData(master.flame.danmaku.controller.DanmakuFilters.TAG_OVERLAPPING_FILTER, map, false);
        }
        this.mGlobalFlagValues.updateFilterFlag();
        notifyConfigureChanged(master.flame.danmaku.danmaku.model.android.DanmakuContext.DanmakuConfigTag.OVERLAPPING_ENABLE, map);
        return this;
    }

    public boolean isMaxLinesLimited() {
        return this.mIsMaxLinesLimited;
    }

    public boolean isPreventOverlappingEnabled() {
        return this.mIsPreventOverlappingEnabled;
    }

    public master.flame.danmaku.danmaku.model.android.DanmakuContext setCacheStuffer(master.flame.danmaku.danmaku.model.android.BaseCacheStuffer baseCacheStuffer, master.flame.danmaku.danmaku.model.android.BaseCacheStuffer.Proxy proxy) {
        this.mCacheStuffer = baseCacheStuffer;
        if (baseCacheStuffer != null) {
            baseCacheStuffer.setProxy(proxy);
            this.mDisplayer.setCacheStuffer(this.mCacheStuffer);
        }
        return this;
    }

    public master.flame.danmaku.danmaku.model.android.DanmakuContext setDanmakuSync(master.flame.danmaku.danmaku.model.AbsDanmakuSync absDanmakuSync) {
        this.danmakuSync = absDanmakuSync;
        return this;
    }

    public void registerConfigChangedCallback(master.flame.danmaku.danmaku.model.android.DanmakuContext.ConfigChangedCallback configChangedCallback) {
        if (configChangedCallback == null || this.mCallbackList == null) {
            this.mCallbackList = java.util.Collections.synchronizedList(new java.util.ArrayList());
        }
        java.util.Iterator<java.lang.ref.WeakReference<master.flame.danmaku.danmaku.model.android.DanmakuContext.ConfigChangedCallback>> it = this.mCallbackList.iterator();
        while (it.hasNext()) {
            if (configChangedCallback.equals(it.next().get())) {
                return;
            }
        }
        this.mCallbackList.add(new java.lang.ref.WeakReference<>(configChangedCallback));
    }

    public void unregisterConfigChangedCallback(master.flame.danmaku.danmaku.model.android.DanmakuContext.ConfigChangedCallback configChangedCallback) {
        java.util.List<java.lang.ref.WeakReference<master.flame.danmaku.danmaku.model.android.DanmakuContext.ConfigChangedCallback>> list;
        if (configChangedCallback == null || (list = this.mCallbackList) == null) {
            return;
        }
        java.util.Iterator<java.lang.ref.WeakReference<master.flame.danmaku.danmaku.model.android.DanmakuContext.ConfigChangedCallback>> it = list.iterator();
        while (it.hasNext()) {
            if (configChangedCallback.equals(it.next().get())) {
                this.mCallbackList.remove(configChangedCallback);
                return;
            }
        }
    }

    public void unregisterAllConfigChangedCallbacks() {
        java.util.List<java.lang.ref.WeakReference<master.flame.danmaku.danmaku.model.android.DanmakuContext.ConfigChangedCallback>> list = this.mCallbackList;
        if (list != null) {
            list.clear();
            this.mCallbackList = null;
        }
    }

    private void notifyConfigureChanged(master.flame.danmaku.danmaku.model.android.DanmakuContext.DanmakuConfigTag danmakuConfigTag, java.lang.Object... objArr) {
        java.util.List<java.lang.ref.WeakReference<master.flame.danmaku.danmaku.model.android.DanmakuContext.ConfigChangedCallback>> list = this.mCallbackList;
        if (list != null) {
            java.util.Iterator<java.lang.ref.WeakReference<master.flame.danmaku.danmaku.model.android.DanmakuContext.ConfigChangedCallback>> it = list.iterator();
            while (it.hasNext()) {
                master.flame.danmaku.danmaku.model.android.DanmakuContext.ConfigChangedCallback configChangedCallback = it.next().get();
                if (configChangedCallback != null) {
                    configChangedCallback.onDanmakuConfigChanged(this, danmakuConfigTag, objArr);
                }
            }
        }
    }
}
