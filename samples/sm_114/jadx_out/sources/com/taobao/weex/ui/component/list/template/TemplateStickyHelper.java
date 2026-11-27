package com.taobao.weex.ui.component.list.template;

/* JADX INFO: loaded from: classes.dex */
public class TemplateStickyHelper {
    private com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList recyclerTemplateList;
    private java.util.List<java.lang.Integer> stickyPositions = new java.util.ArrayList();
    private androidx.collection.ArrayMap<java.lang.Integer, com.taobao.weex.ui.component.list.template.TemplateViewHolder> stickyHolderCache = new androidx.collection.ArrayMap<>();
    private java.util.List<java.lang.String> mStickyTypes = new java.util.ArrayList(8);

    public TemplateStickyHelper(com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList wXRecyclerTemplateList) {
        this.recyclerTemplateList = wXRecyclerTemplateList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onBeforeScroll(int i, int i2) {
        int iFindLastVisibleItemPosition;
        int iFindFirstVisibleItemPosition;
        com.taobao.weex.ui.component.list.template.TemplateViewHolder templateViewHolder;
        java.util.List<java.lang.Integer> list = this.stickyPositions;
        if (list == null || list.size() == 0) {
            return;
        }
        com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView bounceRecyclerView = (com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) this.recyclerTemplateList.getHostView();
        androidx.recyclerview.widget.RecyclerView recyclerView = (androidx.recyclerview.widget.RecyclerView) ((com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) this.recyclerTemplateList.getHostView()).getInnerView();
        androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof androidx.recyclerview.widget.LinearLayoutManager) {
            androidx.recyclerview.widget.LinearLayoutManager linearLayoutManager = (androidx.recyclerview.widget.LinearLayoutManager) layoutManager;
            iFindFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            iFindLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
        } else if (layoutManager instanceof androidx.recyclerview.widget.StaggeredGridLayoutManager) {
            int[] iArr = new int[3];
            androidx.recyclerview.widget.StaggeredGridLayoutManager staggeredGridLayoutManager = (androidx.recyclerview.widget.StaggeredGridLayoutManager) layoutManager;
            int i3 = staggeredGridLayoutManager.findFirstVisibleItemPositions(iArr)[0];
            iFindLastVisibleItemPosition = staggeredGridLayoutManager.findLastVisibleItemPositions(iArr)[0];
            iFindFirstVisibleItemPosition = i3;
        } else {
            iFindLastVisibleItemPosition = -1;
            iFindFirstVisibleItemPosition = -1;
        }
        if (iFindFirstVisibleItemPosition >= 0 && (templateViewHolder = (com.taobao.weex.ui.component.list.template.TemplateViewHolder) recyclerView.findViewHolderForAdapterPosition(iFindFirstVisibleItemPosition)) != null) {
            int iMax = -1;
            for (java.lang.Integer num : this.stickyPositions) {
                if (num != null) {
                    if (num.intValue() > iFindFirstVisibleItemPosition) {
                        break;
                    } else {
                        iMax = java.lang.Math.max(iMax, num.intValue());
                    }
                }
            }
            if (iMax < 0) {
                android.view.View childAt = bounceRecyclerView.getChildAt(bounceRecyclerView.getChildCount() - 1);
                if (childAt.getTag() instanceof com.taobao.weex.ui.component.list.template.TemplateViewHolder) {
                    com.taobao.weex.ui.component.list.template.TemplateViewHolder templateViewHolder2 = (com.taobao.weex.ui.component.list.template.TemplateViewHolder) childAt.getTag();
                    bounceRecyclerView.removeView(templateViewHolder2.itemView);
                    templateViewHolder2.itemView.setTranslationY(0.0f);
                    if (templateViewHolder2.getComponent() != null && templateViewHolder2.getComponent().getEvents().contains(com.taobao.weex.common.Constants.Event.UNSTICKY)) {
                        templateViewHolder2.getComponent().fireEvent(com.taobao.weex.common.Constants.Event.UNSTICKY);
                    }
                }
                for (int i4 = 0; i4 < recyclerView.getChildCount(); i4++) {
                    android.view.View childAt2 = recyclerView.getChildAt(i4);
                    com.taobao.weex.ui.component.list.template.TemplateViewHolder templateViewHolder3 = (com.taobao.weex.ui.component.list.template.TemplateViewHolder) recyclerView.getChildViewHolder(childAt2);
                    if (templateViewHolder3 != null) {
                        if (this.stickyPositions.contains(java.lang.Integer.valueOf(templateViewHolder3.getAdapterPosition())) && childAt2.getVisibility() != 0) {
                            childAt2.setVisibility(0);
                        }
                    }
                }
                return;
            }
            android.view.View childAt3 = bounceRecyclerView.getChildAt(bounceRecyclerView.getChildCount() - 1);
            if (!(childAt3.getTag() instanceof com.taobao.weex.ui.component.list.template.TemplateViewHolder) || ((com.taobao.weex.ui.component.list.template.TemplateViewHolder) childAt3.getTag()).getHolderPosition() != iMax) {
                if ((childAt3.getTag() instanceof com.taobao.weex.ui.component.list.template.TemplateViewHolder) && ((com.taobao.weex.ui.component.list.template.TemplateViewHolder) childAt3.getTag()).getHolderPosition() != iMax) {
                    com.taobao.weex.ui.component.list.template.TemplateViewHolder templateViewHolder4 = (com.taobao.weex.ui.component.list.template.TemplateViewHolder) childAt3.getTag();
                    bounceRecyclerView.removeView(templateViewHolder4.itemView);
                    templateViewHolder4.itemView.setTranslationY(0.0f);
                    if (templateViewHolder4.getComponent() != null && templateViewHolder4.getComponent().getEvents().contains(com.taobao.weex.common.Constants.Event.UNSTICKY)) {
                        templateViewHolder4.getComponent().fireEvent(com.taobao.weex.common.Constants.Event.UNSTICKY);
                    }
                }
                int itemViewType = this.recyclerTemplateList.getItemViewType(iMax);
                com.taobao.weex.ui.component.list.template.TemplateViewHolder templateViewHolderOnCreateViewHolder = this.stickyHolderCache.get(java.lang.Integer.valueOf(itemViewType));
                if (templateViewHolderOnCreateViewHolder == null) {
                    templateViewHolderOnCreateViewHolder = this.recyclerTemplateList.onCreateViewHolder((android.view.ViewGroup) recyclerView, itemViewType);
                    this.stickyHolderCache.put(java.lang.Integer.valueOf(itemViewType), templateViewHolderOnCreateViewHolder);
                }
                this.recyclerTemplateList.onBindViewHolder(templateViewHolderOnCreateViewHolder, iMax);
                templateViewHolderOnCreateViewHolder.itemView.setTranslationY(0.0f);
                templateViewHolderOnCreateViewHolder.itemView.setTag(templateViewHolderOnCreateViewHolder);
                android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(-1, -2);
                templateViewHolderOnCreateViewHolder.getComponent().clearPreLayout();
                if (templateViewHolderOnCreateViewHolder.itemView.getParent() != null) {
                    ((android.view.ViewGroup) templateViewHolderOnCreateViewHolder.itemView.getParent()).removeView(templateViewHolderOnCreateViewHolder.itemView);
                }
                bounceRecyclerView.addView(templateViewHolderOnCreateViewHolder.itemView, layoutParams);
                templateViewHolderOnCreateViewHolder.getComponent().setLayout(templateViewHolderOnCreateViewHolder.getComponent());
                android.view.View view = templateViewHolderOnCreateViewHolder.itemView;
                if (templateViewHolderOnCreateViewHolder.getComponent() != null && templateViewHolderOnCreateViewHolder.getComponent().getEvents().contains("sticky")) {
                    templateViewHolderOnCreateViewHolder.getComponent().fireEvent("sticky");
                }
                childAt3 = view;
            }
            com.taobao.weex.ui.component.list.template.TemplateViewHolder templateViewHolder5 = (com.taobao.weex.ui.component.list.template.TemplateViewHolder) childAt3.getTag();
            for (int i5 = 0; i5 < recyclerView.getChildCount(); i5++) {
                android.view.View childAt4 = recyclerView.getChildAt(i5);
                com.taobao.weex.ui.component.list.template.TemplateViewHolder templateViewHolder6 = (com.taobao.weex.ui.component.list.template.TemplateViewHolder) recyclerView.getChildViewHolder(childAt4);
                if (templateViewHolder6 != null) {
                    int adapterPosition = templateViewHolder6.getAdapterPosition();
                    if (this.stickyPositions.contains(java.lang.Integer.valueOf(adapterPosition))) {
                        if (adapterPosition == templateViewHolder5.getHolderPosition()) {
                            if (childAt4.getVisibility() != 4) {
                                childAt4.setVisibility(4);
                            }
                        } else if (childAt4.getVisibility() != 0) {
                            childAt4.setVisibility(0);
                        }
                    }
                }
            }
            if (templateViewHolder.getComponent().isSticky()) {
                if (templateViewHolder.itemView.getY() < 0.0f) {
                    if (templateViewHolder.itemView.getVisibility() != 4) {
                        templateViewHolder.itemView.setVisibility(4);
                    }
                    if (childAt3.getVisibility() != 0) {
                        childAt3.setVisibility(0);
                    }
                    childAt3.bringToFront();
                } else {
                    if (templateViewHolder.itemView.getVisibility() != 0) {
                        templateViewHolder.itemView.setVisibility(0);
                    }
                    if (childAt3.getVisibility() != 8) {
                        childAt3.setVisibility(8);
                    }
                }
            } else if (childAt3.getVisibility() != 0) {
                childAt3.setVisibility(0);
            }
            int i6 = iFindFirstVisibleItemPosition + 1;
            if (iFindLastVisibleItemPosition > 0) {
                for (int i7 = i6; i7 <= iFindLastVisibleItemPosition; i7++) {
                    if (this.stickyPositions.contains(java.lang.Integer.valueOf(i7))) {
                        i6 = i7;
                        break;
                    }
                }
            }
            if (!this.stickyPositions.contains(java.lang.Integer.valueOf(i6))) {
                if (templateViewHolder5.itemView.getTranslationY() < 0.0f) {
                    templateViewHolder5.itemView.setTranslationY(0.0f);
                    return;
                }
                return;
            }
            com.taobao.weex.ui.component.list.template.TemplateViewHolder templateViewHolder7 = (com.taobao.weex.ui.component.list.template.TemplateViewHolder) recyclerView.findViewHolderForAdapterPosition(i6);
            if (templateViewHolder7 == null || templateViewHolder7.getComponent() == null) {
                return;
            }
            int y = (int) (templateViewHolder7.itemView.getY() - templateViewHolder5.itemView.getMeasuredHeight());
            if (y <= 0) {
                templateViewHolder5.itemView.setTranslationY(y);
            } else {
                templateViewHolder5.itemView.setTranslationY(0.0f);
            }
        }
    }

    public java.util.List<java.lang.Integer> getStickyPositions() {
        if (this.stickyPositions == null) {
            this.stickyPositions = new java.util.ArrayList();
        }
        return this.stickyPositions;
    }

    public java.util.List<java.lang.String> getStickyTypes() {
        return this.mStickyTypes;
    }
}
