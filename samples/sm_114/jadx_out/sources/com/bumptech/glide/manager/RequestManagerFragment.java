package com.bumptech.glide.manager;

/* JADX INFO: loaded from: classes.dex */
@java.lang.Deprecated
public class RequestManagerFragment extends android.app.Fragment {
    @java.lang.Deprecated
    public com.bumptech.glide.RequestManager getRequestManager() {
        return null;
    }

    @java.lang.Deprecated
    public void setRequestManager(com.bumptech.glide.RequestManager requestManager) {
    }

    @java.lang.Deprecated
    public com.bumptech.glide.manager.RequestManagerTreeNode getRequestManagerTreeNode() {
        return new com.bumptech.glide.manager.RequestManagerTreeNode() { // from class: com.bumptech.glide.manager.RequestManagerFragment.1
            @Override // com.bumptech.glide.manager.RequestManagerTreeNode
            public java.util.Set<com.bumptech.glide.RequestManager> getDescendants() {
                return java.util.Collections.EMPTY_SET;
            }
        };
    }
}
