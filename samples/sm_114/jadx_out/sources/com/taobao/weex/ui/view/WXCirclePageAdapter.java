package com.taobao.weex.ui.view;

/* JADX INFO: loaded from: classes.dex */
public class WXCirclePageAdapter extends androidx.viewpager.widget.PagerAdapter {
    public boolean isRTL;
    private boolean needLoop;
    private java.util.List<android.view.View> originalViews;
    private java.util.List<android.view.View> shadow;
    private java.util.List<android.view.View> views;

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(java.lang.Object obj) {
        return -2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(android.view.View view, java.lang.Object obj) {
        return view == obj;
    }

    public WXCirclePageAdapter(java.util.List<android.view.View> list, boolean z) {
        this.views = new java.util.ArrayList();
        this.shadow = new java.util.ArrayList();
        this.needLoop = true;
        this.isRTL = false;
        this.originalViews = new java.util.ArrayList();
        this.views = new java.util.ArrayList(list);
        this.originalViews = new java.util.ArrayList(list);
        this.needLoop = z;
    }

    public void setLayoutDirectionRTL(boolean z) {
        if (z == this.isRTL) {
            return;
        }
        this.isRTL = z;
        java.util.ArrayList arrayList = new java.util.ArrayList(this.originalViews);
        this.views = arrayList;
        if (z) {
            java.util.Collections.reverse(arrayList);
        }
        ensureShadow();
    }

    public WXCirclePageAdapter() {
        this(true);
    }

    public WXCirclePageAdapter(boolean z) {
        this.views = new java.util.ArrayList();
        this.shadow = new java.util.ArrayList();
        this.needLoop = true;
        this.isRTL = false;
        this.originalViews = new java.util.ArrayList();
        this.needLoop = z;
    }

    public void addPageView(android.view.View view) {
        if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
            com.taobao.weex.utils.WXLogUtils.d("onPageSelected >>>> addPageView");
        }
        this.originalViews.add(view);
        if (this.isRTL) {
            this.views.add(0, view);
        } else {
            this.views.add(view);
        }
        ensureShadow();
    }

    public void removePageView(android.view.View view) {
        if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
            com.taobao.weex.utils.WXLogUtils.d("onPageSelected >>>> removePageView");
        }
        this.views.remove(view);
        this.originalViews.remove(view);
        ensureShadow();
    }

    public void replacePageView(android.view.View view, android.view.View view2) {
        if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
            com.taobao.weex.utils.WXLogUtils.d("onPageSelected >>>> replacePageView");
        }
        int iIndexOf = this.views.indexOf(view);
        this.views.remove(iIndexOf);
        this.views.add(iIndexOf, view2);
        ensureShadow();
        int iIndexOf2 = this.originalViews.indexOf(view);
        this.originalViews.remove(iIndexOf2);
        this.originalViews.add(iIndexOf2, view2);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.shadow.size();
    }

    public int getRealCount() {
        return this.views.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public java.lang.Object instantiateItem(android.view.ViewGroup viewGroup, int i) {
        android.view.View view = null;
        try {
            android.view.View view2 = this.shadow.get(i);
            try {
                if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
                    com.taobao.weex.utils.WXLogUtils.d("onPageSelected >>>> instantiateItem >>>>> position:" + i + ",position % getRealCount()" + (i % getRealCount()));
                }
                if (view2.getParent() == null) {
                    viewGroup.addView(view2);
                    return view2;
                }
                ((android.view.ViewGroup) view2.getParent()).removeView(view2);
                viewGroup.addView(view2);
                return view2;
            } catch (java.lang.Exception e) {
                e = e;
                view = view2;
                com.taobao.weex.utils.WXLogUtils.e("[CirclePageAdapter] instantiateItem: ", e);
                return view;
            }
        } catch (java.lang.Exception e2) {
            e = e2;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(android.view.ViewGroup viewGroup, int i, java.lang.Object obj) {
        if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
            com.taobao.weex.utils.WXLogUtils.d("onPageSelected >>>> destroyItem >>>>> position:" + i);
        }
        if (this.needLoop) {
            return;
        }
        viewGroup.removeView((android.view.View) obj);
    }

    public int getPagePosition(android.view.View view) {
        return this.views.indexOf(view);
    }

    public int getItemIndex(java.lang.Object obj) {
        if (obj instanceof android.view.View) {
            return this.views.indexOf(obj);
        }
        return -1;
    }

    public java.util.List<android.view.View> getViews() {
        return this.views;
    }

    private void ensureShadow() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (this.needLoop && this.views.size() > 2) {
            java.util.List<android.view.View> list = this.views;
            arrayList.add(0, list.get(list.size() - 1));
            for (android.view.View view : this.views) {
                if (view.getParent() != null) {
                    ((android.view.ViewGroup) view.getParent()).removeView(view);
                }
                arrayList.add(view);
            }
            arrayList.add(this.views.get(0));
        } else {
            arrayList.addAll(this.views);
        }
        this.shadow.clear();
        notifyDataSetChanged();
        this.shadow.addAll(arrayList);
        notifyDataSetChanged();
    }

    public int getRealPosition(int i) {
        if (i < 0 || i >= this.shadow.size()) {
            return -1;
        }
        return getItemIndex(this.shadow.get(i));
    }

    public int getFirst() {
        return (!this.needLoop || this.views.size() <= 2) ? 0 : 1;
    }
}
