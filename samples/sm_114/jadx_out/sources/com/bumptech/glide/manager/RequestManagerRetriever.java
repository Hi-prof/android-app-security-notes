package com.bumptech.glide.manager;

/* JADX INFO: loaded from: classes.dex */
public class RequestManagerRetriever implements android.os.Handler.Callback {
    private static final com.bumptech.glide.manager.RequestManagerRetriever.RequestManagerFactory DEFAULT_FACTORY = new com.bumptech.glide.manager.RequestManagerRetriever.RequestManagerFactory() { // from class: com.bumptech.glide.manager.RequestManagerRetriever.1
        @Override // com.bumptech.glide.manager.RequestManagerRetriever.RequestManagerFactory
        public com.bumptech.glide.RequestManager build(com.bumptech.glide.Glide glide, com.bumptech.glide.manager.Lifecycle lifecycle, com.bumptech.glide.manager.RequestManagerTreeNode requestManagerTreeNode, android.content.Context context) {
            return new com.bumptech.glide.RequestManager(glide, lifecycle, requestManagerTreeNode, context);
        }
    };
    static final java.lang.String FRAGMENT_TAG = "com.bumptech.glide.manager";
    private volatile com.bumptech.glide.RequestManager applicationManager;
    private final com.bumptech.glide.manager.RequestManagerRetriever.RequestManagerFactory factory;
    private final com.bumptech.glide.manager.FrameWaiter frameWaiter;
    private final com.bumptech.glide.manager.LifecycleRequestManagerRetriever lifecycleRequestManagerRetriever;
    private final androidx.collection.ArrayMap<android.view.View, androidx.fragment.app.Fragment> tempViewToSupportFragment = new androidx.collection.ArrayMap<>();

    public interface RequestManagerFactory {
        com.bumptech.glide.RequestManager build(com.bumptech.glide.Glide glide, com.bumptech.glide.manager.Lifecycle lifecycle, com.bumptech.glide.manager.RequestManagerTreeNode requestManagerTreeNode, android.content.Context context);
    }

    @Override // android.os.Handler.Callback
    @java.lang.Deprecated
    public boolean handleMessage(android.os.Message message) {
        return false;
    }

    public RequestManagerRetriever(com.bumptech.glide.manager.RequestManagerRetriever.RequestManagerFactory requestManagerFactory) {
        requestManagerFactory = requestManagerFactory == null ? DEFAULT_FACTORY : requestManagerFactory;
        this.factory = requestManagerFactory;
        this.lifecycleRequestManagerRetriever = new com.bumptech.glide.manager.LifecycleRequestManagerRetriever(requestManagerFactory);
        this.frameWaiter = buildFrameWaiter();
    }

    private static com.bumptech.glide.manager.FrameWaiter buildFrameWaiter() {
        if (!com.bumptech.glide.load.resource.bitmap.HardwareConfigState.HARDWARE_BITMAPS_SUPPORTED || !com.bumptech.glide.load.resource.bitmap.HardwareConfigState.BLOCK_HARDWARE_BITMAPS_WHEN_GL_CONTEXT_MIGHT_NOT_BE_INITIALIZED) {
            return new com.bumptech.glide.manager.DoNothingFirstFrameWaiter();
        }
        return new com.bumptech.glide.manager.FirstFrameWaiter();
    }

    private com.bumptech.glide.RequestManager getApplicationManager(android.content.Context context) {
        if (this.applicationManager == null) {
            synchronized (this) {
                if (this.applicationManager == null) {
                    this.applicationManager = this.factory.build(com.bumptech.glide.Glide.get(context.getApplicationContext()), new com.bumptech.glide.manager.ApplicationLifecycle(), new com.bumptech.glide.manager.EmptyRequestManagerTreeNode(), context.getApplicationContext());
                }
            }
        }
        return this.applicationManager;
    }

    public com.bumptech.glide.RequestManager get(android.content.Context context) {
        if (context == null) {
            throw new java.lang.IllegalArgumentException("You cannot start a load on a null Context");
        }
        if (com.bumptech.glide.util.Util.isOnMainThread() && !(context instanceof android.app.Application)) {
            if (context instanceof androidx.fragment.app.FragmentActivity) {
                return get((androidx.fragment.app.FragmentActivity) context);
            }
            if (context instanceof android.content.ContextWrapper) {
                android.content.ContextWrapper contextWrapper = (android.content.ContextWrapper) context;
                if (contextWrapper.getBaseContext().getApplicationContext() != null) {
                    return get(contextWrapper.getBaseContext());
                }
            }
        }
        return getApplicationManager(context);
    }

    public com.bumptech.glide.RequestManager get(androidx.fragment.app.FragmentActivity fragmentActivity) {
        if (com.bumptech.glide.util.Util.isOnBackgroundThread()) {
            return get(fragmentActivity.getApplicationContext());
        }
        assertNotDestroyed(fragmentActivity);
        this.frameWaiter.registerSelf(fragmentActivity);
        boolean zIsActivityVisible = isActivityVisible(fragmentActivity);
        return this.lifecycleRequestManagerRetriever.getOrCreate(fragmentActivity, com.bumptech.glide.Glide.get(fragmentActivity.getApplicationContext()), fragmentActivity.getLifecycle(), fragmentActivity.getSupportFragmentManager(), zIsActivityVisible);
    }

    public com.bumptech.glide.RequestManager get(androidx.fragment.app.Fragment fragment) {
        com.bumptech.glide.util.Preconditions.checkNotNull(fragment.getContext(), "You cannot start a load on a fragment before it is attached or after it is destroyed");
        if (com.bumptech.glide.util.Util.isOnBackgroundThread()) {
            return get(fragment.getContext().getApplicationContext());
        }
        if (fragment.getActivity() != null) {
            this.frameWaiter.registerSelf(fragment.getActivity());
        }
        androidx.fragment.app.FragmentManager childFragmentManager = fragment.getChildFragmentManager();
        android.content.Context context = fragment.getContext();
        return this.lifecycleRequestManagerRetriever.getOrCreate(context, com.bumptech.glide.Glide.get(context.getApplicationContext()), fragment.getLifecycle(), childFragmentManager, fragment.isVisible());
    }

    @java.lang.Deprecated
    public com.bumptech.glide.RequestManager get(android.app.Activity activity) {
        return get(activity.getApplicationContext());
    }

    public com.bumptech.glide.RequestManager get(android.view.View view) {
        if (com.bumptech.glide.util.Util.isOnBackgroundThread()) {
            return get(view.getContext().getApplicationContext());
        }
        com.bumptech.glide.util.Preconditions.checkNotNull(view);
        com.bumptech.glide.util.Preconditions.checkNotNull(view.getContext(), "Unable to obtain a request manager for a view without a Context");
        android.app.Activity activityFindActivity = findActivity(view.getContext());
        if (activityFindActivity == null) {
            return get(view.getContext().getApplicationContext());
        }
        if (activityFindActivity instanceof androidx.fragment.app.FragmentActivity) {
            androidx.fragment.app.FragmentActivity fragmentActivity = (androidx.fragment.app.FragmentActivity) activityFindActivity;
            androidx.fragment.app.Fragment fragmentFindSupportFragment = findSupportFragment(view, fragmentActivity);
            return fragmentFindSupportFragment != null ? get(fragmentFindSupportFragment) : get(fragmentActivity);
        }
        return get(view.getContext().getApplicationContext());
    }

    private static void findAllSupportFragmentsWithViews(java.util.Collection<androidx.fragment.app.Fragment> collection, java.util.Map<android.view.View, androidx.fragment.app.Fragment> map) {
        if (collection == null) {
            return;
        }
        for (androidx.fragment.app.Fragment fragment : collection) {
            if (fragment != null && fragment.getView() != null) {
                map.put(fragment.getView(), fragment);
                findAllSupportFragmentsWithViews(fragment.getChildFragmentManager().getFragments(), map);
            }
        }
    }

    private androidx.fragment.app.Fragment findSupportFragment(android.view.View view, androidx.fragment.app.FragmentActivity fragmentActivity) {
        this.tempViewToSupportFragment.clear();
        findAllSupportFragmentsWithViews(fragmentActivity.getSupportFragmentManager().getFragments(), this.tempViewToSupportFragment);
        android.view.View viewFindViewById = fragmentActivity.findViewById(android.R.id.content);
        androidx.fragment.app.Fragment fragment = null;
        while (!view.equals(viewFindViewById) && (fragment = this.tempViewToSupportFragment.get(view)) == null && (view.getParent() instanceof android.view.View)) {
            view = (android.view.View) view.getParent();
        }
        this.tempViewToSupportFragment.clear();
        return fragment;
    }

    private static android.app.Activity findActivity(android.content.Context context) {
        if (context instanceof android.app.Activity) {
            return (android.app.Activity) context;
        }
        if (context instanceof android.content.ContextWrapper) {
            return findActivity(((android.content.ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    private static void assertNotDestroyed(android.app.Activity activity) {
        if (activity.isDestroyed()) {
            throw new java.lang.IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    @java.lang.Deprecated
    public com.bumptech.glide.RequestManager get(android.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            throw new java.lang.IllegalArgumentException("You cannot start a load on a fragment before it is attached");
        }
        return get(fragment.getActivity().getApplicationContext());
    }

    private static boolean isActivityVisible(android.content.Context context) {
        android.app.Activity activityFindActivity = findActivity(context);
        return activityFindActivity == null || !activityFindActivity.isFinishing();
    }
}
