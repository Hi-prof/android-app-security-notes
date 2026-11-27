package com.bumptech.glide.manager;

/* JADX INFO: loaded from: classes.dex */
final class LifecycleRequestManagerRetriever {
    private final com.bumptech.glide.manager.RequestManagerRetriever.RequestManagerFactory factory;
    final java.util.Map<androidx.lifecycle.Lifecycle, com.bumptech.glide.RequestManager> lifecycleToRequestManager = new java.util.HashMap();

    LifecycleRequestManagerRetriever(com.bumptech.glide.manager.RequestManagerRetriever.RequestManagerFactory requestManagerFactory) {
        this.factory = requestManagerFactory;
    }

    com.bumptech.glide.RequestManager getOnly(androidx.lifecycle.Lifecycle lifecycle) {
        com.bumptech.glide.util.Util.assertMainThread();
        return this.lifecycleToRequestManager.get(lifecycle);
    }

    com.bumptech.glide.RequestManager getOrCreate(android.content.Context context, com.bumptech.glide.Glide glide, final androidx.lifecycle.Lifecycle lifecycle, androidx.fragment.app.FragmentManager fragmentManager, boolean z) {
        com.bumptech.glide.util.Util.assertMainThread();
        com.bumptech.glide.RequestManager only = getOnly(lifecycle);
        if (only != null) {
            return only;
        }
        com.bumptech.glide.manager.LifecycleLifecycle lifecycleLifecycle = new com.bumptech.glide.manager.LifecycleLifecycle(lifecycle);
        com.bumptech.glide.RequestManager requestManagerBuild = this.factory.build(glide, lifecycleLifecycle, new com.bumptech.glide.manager.LifecycleRequestManagerRetriever.SupportRequestManagerTreeNode(fragmentManager), context);
        this.lifecycleToRequestManager.put(lifecycle, requestManagerBuild);
        lifecycleLifecycle.addListener(new com.bumptech.glide.manager.LifecycleListener() { // from class: com.bumptech.glide.manager.LifecycleRequestManagerRetriever.1
            @Override // com.bumptech.glide.manager.LifecycleListener
            public void onStart() {
            }

            @Override // com.bumptech.glide.manager.LifecycleListener
            public void onStop() {
            }

            @Override // com.bumptech.glide.manager.LifecycleListener
            public void onDestroy() {
                com.bumptech.glide.manager.LifecycleRequestManagerRetriever.this.lifecycleToRequestManager.remove(lifecycle);
            }
        });
        if (z) {
            requestManagerBuild.onStart();
        }
        return requestManagerBuild;
    }

    private final class SupportRequestManagerTreeNode implements com.bumptech.glide.manager.RequestManagerTreeNode {
        private final androidx.fragment.app.FragmentManager childFragmentManager;

        SupportRequestManagerTreeNode(androidx.fragment.app.FragmentManager fragmentManager) {
            this.childFragmentManager = fragmentManager;
        }

        @Override // com.bumptech.glide.manager.RequestManagerTreeNode
        public java.util.Set<com.bumptech.glide.RequestManager> getDescendants() {
            java.util.HashSet hashSet = new java.util.HashSet();
            getChildFragmentsRecursive(this.childFragmentManager, hashSet);
            return hashSet;
        }

        private void getChildFragmentsRecursive(androidx.fragment.app.FragmentManager fragmentManager, java.util.Set<com.bumptech.glide.RequestManager> set) {
            java.util.List<androidx.fragment.app.Fragment> fragments = fragmentManager.getFragments();
            int size = fragments.size();
            for (int i = 0; i < size; i++) {
                androidx.fragment.app.Fragment fragment = fragments.get(i);
                getChildFragmentsRecursive(fragment.getChildFragmentManager(), set);
                com.bumptech.glide.RequestManager only = com.bumptech.glide.manager.LifecycleRequestManagerRetriever.this.getOnly(fragment.getLifecycle());
                if (only != null) {
                    set.add(only);
                }
            }
        }
    }
}
