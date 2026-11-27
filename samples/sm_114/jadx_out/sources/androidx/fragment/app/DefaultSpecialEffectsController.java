package androidx.fragment.app;

/* JADX INFO: loaded from: classes.dex */
class DefaultSpecialEffectsController extends androidx.fragment.app.SpecialEffectsController {
    DefaultSpecialEffectsController(android.view.ViewGroup viewGroup) {
        super(viewGroup);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0085  */
    @Override // androidx.fragment.app.SpecialEffectsController
    void executeOperations(java.util.List<androidx.fragment.app.SpecialEffectsController.Operation> list, boolean z) {
        androidx.fragment.app.SpecialEffectsController.Operation operation = null;
        androidx.fragment.app.SpecialEffectsController.Operation operation2 = null;
        for (androidx.fragment.app.SpecialEffectsController.Operation operation3 : list) {
            androidx.fragment.app.SpecialEffectsController.Operation.State stateFrom = androidx.fragment.app.SpecialEffectsController.Operation.State.from(operation3.getFragment().mView);
            int i = androidx.fragment.app.DefaultSpecialEffectsController.AnonymousClass10.$SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[operation3.getFinalState().ordinal()];
            if (i == 1 || i == 2 || i == 3) {
                if (stateFrom == androidx.fragment.app.SpecialEffectsController.Operation.State.VISIBLE && operation == null) {
                    operation = operation3;
                }
            } else if (i == 4 && stateFrom != androidx.fragment.app.SpecialEffectsController.Operation.State.VISIBLE) {
                operation2 = operation3;
            }
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        final java.util.ArrayList arrayList3 = new java.util.ArrayList(list);
        for (final androidx.fragment.app.SpecialEffectsController.Operation operation4 : list) {
            androidx.core.os.CancellationSignal cancellationSignal = new androidx.core.os.CancellationSignal();
            operation4.markStartedSpecialEffect(cancellationSignal);
            arrayList.add(new androidx.fragment.app.DefaultSpecialEffectsController.AnimationInfo(operation4, cancellationSignal, z));
            androidx.core.os.CancellationSignal cancellationSignal2 = new androidx.core.os.CancellationSignal();
            operation4.markStartedSpecialEffect(cancellationSignal2);
            boolean z2 = false;
            if (z) {
                if (operation4 == operation) {
                    z2 = true;
                }
            } else if (operation4 == operation2) {
                z2 = true;
            }
            arrayList2.add(new androidx.fragment.app.DefaultSpecialEffectsController.TransitionInfo(operation4, cancellationSignal2, z, z2));
            operation4.addCompletionListener(new java.lang.Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.1
                @Override // java.lang.Runnable
                public void run() {
                    if (arrayList3.contains(operation4)) {
                        arrayList3.remove(operation4);
                        androidx.fragment.app.DefaultSpecialEffectsController.this.applyContainerChanges(operation4);
                    }
                }
            });
        }
        java.util.Map<androidx.fragment.app.SpecialEffectsController.Operation, java.lang.Boolean> mapStartTransitions = startTransitions(arrayList2, arrayList3, z, operation, operation2);
        startAnimations(arrayList, arrayList3, mapStartTransitions.containsValue(true), mapStartTransitions);
        java.util.Iterator<androidx.fragment.app.SpecialEffectsController.Operation> it = arrayList3.iterator();
        while (it.hasNext()) {
            applyContainerChanges(it.next());
        }
        arrayList3.clear();
    }

    /* JADX INFO: renamed from: androidx.fragment.app.DefaultSpecialEffectsController$10, reason: invalid class name */
    static /* synthetic */ class AnonymousClass10 {
        static final /* synthetic */ int[] $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State;

        static {
            int[] iArr = new int[androidx.fragment.app.SpecialEffectsController.Operation.State.values().length];
            $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State = iArr;
            try {
                iArr[androidx.fragment.app.SpecialEffectsController.Operation.State.GONE.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[androidx.fragment.app.SpecialEffectsController.Operation.State.INVISIBLE.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[androidx.fragment.app.SpecialEffectsController.Operation.State.REMOVED.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[androidx.fragment.app.SpecialEffectsController.Operation.State.VISIBLE.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
        }
    }

    private void startAnimations(java.util.List<androidx.fragment.app.DefaultSpecialEffectsController.AnimationInfo> list, java.util.List<androidx.fragment.app.SpecialEffectsController.Operation> list2, boolean z, java.util.Map<androidx.fragment.app.SpecialEffectsController.Operation, java.lang.Boolean> map) {
        final android.view.ViewGroup container = getContainer();
        android.content.Context context = container.getContext();
        java.util.ArrayList<androidx.fragment.app.DefaultSpecialEffectsController.AnimationInfo> arrayList = new java.util.ArrayList();
        boolean z2 = false;
        for (final androidx.fragment.app.DefaultSpecialEffectsController.AnimationInfo animationInfo : list) {
            if (animationInfo.isVisibilityUnchanged()) {
                animationInfo.completeSpecialEffect();
            } else {
                androidx.fragment.app.FragmentAnim.AnimationOrAnimator animation = animationInfo.getAnimation(context);
                if (animation == null) {
                    animationInfo.completeSpecialEffect();
                } else {
                    final android.animation.Animator animator = animation.animator;
                    if (animator == null) {
                        arrayList.add(animationInfo);
                    } else {
                        final androidx.fragment.app.SpecialEffectsController.Operation operation = animationInfo.getOperation();
                        androidx.fragment.app.Fragment fragment = operation.getFragment();
                        if (java.lang.Boolean.TRUE.equals(map.get(operation))) {
                            if (androidx.fragment.app.FragmentManager.isLoggingEnabled(2)) {
                                android.util.Log.v("FragmentManager", "Ignoring Animator set on " + fragment + " as this Fragment was involved in a Transition.");
                            }
                            animationInfo.completeSpecialEffect();
                        } else {
                            final boolean z3 = operation.getFinalState() == androidx.fragment.app.SpecialEffectsController.Operation.State.GONE;
                            if (z3) {
                                list2.remove(operation);
                            }
                            final android.view.View view = fragment.mView;
                            container.startViewTransition(view);
                            animator.addListener(new android.animation.AnimatorListenerAdapter() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.2
                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(android.animation.Animator animator2) {
                                    container.endViewTransition(view);
                                    if (z3) {
                                        operation.getFinalState().applyState(view);
                                    }
                                    animationInfo.completeSpecialEffect();
                                }
                            });
                            animator.setTarget(view);
                            animator.start();
                            animationInfo.getSignal().setOnCancelListener(new androidx.core.os.CancellationSignal.OnCancelListener() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.3
                                @Override // androidx.core.os.CancellationSignal.OnCancelListener
                                public void onCancel() {
                                    animator.end();
                                }
                            });
                            z2 = true;
                        }
                    }
                }
            }
        }
        for (final androidx.fragment.app.DefaultSpecialEffectsController.AnimationInfo animationInfo2 : arrayList) {
            androidx.fragment.app.SpecialEffectsController.Operation operation2 = animationInfo2.getOperation();
            androidx.fragment.app.Fragment fragment2 = operation2.getFragment();
            if (z) {
                if (androidx.fragment.app.FragmentManager.isLoggingEnabled(2)) {
                    android.util.Log.v("FragmentManager", "Ignoring Animation set on " + fragment2 + " as Animations cannot run alongside Transitions.");
                }
                animationInfo2.completeSpecialEffect();
            } else if (z2) {
                if (androidx.fragment.app.FragmentManager.isLoggingEnabled(2)) {
                    android.util.Log.v("FragmentManager", "Ignoring Animation set on " + fragment2 + " as Animations cannot run alongside Animators.");
                }
                animationInfo2.completeSpecialEffect();
            } else {
                final android.view.View view2 = fragment2.mView;
                android.view.animation.Animation animation2 = (android.view.animation.Animation) androidx.core.util.Preconditions.checkNotNull(((androidx.fragment.app.FragmentAnim.AnimationOrAnimator) androidx.core.util.Preconditions.checkNotNull(animationInfo2.getAnimation(context))).animation);
                if (operation2.getFinalState() != androidx.fragment.app.SpecialEffectsController.Operation.State.REMOVED) {
                    view2.startAnimation(animation2);
                    animationInfo2.completeSpecialEffect();
                } else {
                    container.startViewTransition(view2);
                    androidx.fragment.app.FragmentAnim.EndViewTransitionAnimation endViewTransitionAnimation = new androidx.fragment.app.FragmentAnim.EndViewTransitionAnimation(animation2, container, view2);
                    endViewTransitionAnimation.setAnimationListener(new android.view.animation.Animation.AnimationListener() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.4
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(android.view.animation.Animation animation3) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(android.view.animation.Animation animation3) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(android.view.animation.Animation animation3) {
                            container.post(new java.lang.Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    container.endViewTransition(view2);
                                    animationInfo2.completeSpecialEffect();
                                }
                            });
                        }
                    });
                    view2.startAnimation(endViewTransitionAnimation);
                }
                animationInfo2.getSignal().setOnCancelListener(new androidx.core.os.CancellationSignal.OnCancelListener() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.5
                    @Override // androidx.core.os.CancellationSignal.OnCancelListener
                    public void onCancel() {
                        view2.clearAnimation();
                        container.endViewTransition(view2);
                        animationInfo2.completeSpecialEffect();
                    }
                });
            }
        }
    }

    private java.util.Map<androidx.fragment.app.SpecialEffectsController.Operation, java.lang.Boolean> startTransitions(java.util.List<androidx.fragment.app.DefaultSpecialEffectsController.TransitionInfo> list, java.util.List<androidx.fragment.app.SpecialEffectsController.Operation> list2, final boolean z, final androidx.fragment.app.SpecialEffectsController.Operation operation, final androidx.fragment.app.SpecialEffectsController.Operation operation2) {
        java.util.ArrayList<android.view.View> arrayList;
        java.lang.Object obj;
        java.util.ArrayList<android.view.View> arrayList2;
        android.view.View view;
        java.lang.Object objMergeTransitionsTogether;
        java.lang.Object objMergeTransitionsTogether2;
        android.view.View view2;
        java.util.ArrayList arrayList3;
        androidx.fragment.app.SpecialEffectsController.Operation operation3;
        android.graphics.Rect rect;
        java.util.ArrayList<android.view.View> arrayList4;
        androidx.core.app.SharedElementCallback enterTransitionCallback;
        androidx.core.app.SharedElementCallback exitTransitionCallback;
        int i;
        android.view.View view3;
        final android.view.View view4;
        int i2;
        java.lang.String strFindKeyForValue;
        int i3;
        androidx.fragment.app.DefaultSpecialEffectsController defaultSpecialEffectsController = this;
        java.util.HashMap map = new java.util.HashMap();
        final androidx.fragment.app.FragmentTransitionImpl fragmentTransitionImpl = null;
        for (androidx.fragment.app.DefaultSpecialEffectsController.TransitionInfo transitionInfo : list) {
            if (!transitionInfo.isVisibilityUnchanged()) {
                androidx.fragment.app.FragmentTransitionImpl handlingImpl = transitionInfo.getHandlingImpl();
                if (fragmentTransitionImpl == null) {
                    fragmentTransitionImpl = handlingImpl;
                } else if (handlingImpl != null && fragmentTransitionImpl != handlingImpl) {
                    throw new java.lang.IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + transitionInfo.getOperation().getFragment() + " returned Transition " + transitionInfo.getTransition() + " which uses a different Transition  type than other Fragments.");
                }
            }
        }
        int i4 = 0;
        if (fragmentTransitionImpl == null) {
            for (androidx.fragment.app.DefaultSpecialEffectsController.TransitionInfo transitionInfo2 : list) {
                map.put(transitionInfo2.getOperation(), false);
                transitionInfo2.completeSpecialEffect();
            }
        } else {
            android.view.View view5 = new android.view.View(defaultSpecialEffectsController.getContainer().getContext());
            final android.graphics.Rect rect2 = new android.graphics.Rect();
            java.util.ArrayList<android.view.View> arrayList5 = new java.util.ArrayList<>();
            java.util.ArrayList<android.view.View> arrayList6 = new java.util.ArrayList<>();
            androidx.collection.ArrayMap arrayMap = new androidx.collection.ArrayMap();
            java.lang.Object obj2 = null;
            android.view.View view6 = null;
            boolean z2 = false;
            for (androidx.fragment.app.DefaultSpecialEffectsController.TransitionInfo transitionInfo3 : list) {
                if (!transitionInfo3.hasSharedElementTransition() || operation == null || operation2 == null) {
                    rect = rect2;
                    arrayList4 = arrayList5;
                    view6 = view6;
                } else {
                    java.lang.Object objWrapTransitionInSet = fragmentTransitionImpl.wrapTransitionInSet(fragmentTransitionImpl.cloneTransition(transitionInfo3.getSharedElementTransition()));
                    java.util.ArrayList<java.lang.String> sharedElementSourceNames = operation2.getFragment().getSharedElementSourceNames();
                    java.util.ArrayList<java.lang.String> sharedElementSourceNames2 = operation.getFragment().getSharedElementSourceNames();
                    java.util.ArrayList<java.lang.String> sharedElementTargetNames = operation.getFragment().getSharedElementTargetNames();
                    while (i4 < sharedElementTargetNames.size()) {
                        int iIndexOf = sharedElementSourceNames.indexOf(sharedElementTargetNames.get(i4));
                        java.lang.Object obj3 = objWrapTransitionInSet;
                        if (iIndexOf != -1) {
                            sharedElementSourceNames.set(iIndexOf, sharedElementSourceNames2.get(i4));
                        }
                        i4++;
                        objWrapTransitionInSet = obj3;
                    }
                    java.lang.Object obj4 = objWrapTransitionInSet;
                    java.util.ArrayList<java.lang.String> sharedElementTargetNames2 = operation2.getFragment().getSharedElementTargetNames();
                    if (z == 0) {
                        enterTransitionCallback = operation.getFragment().getExitTransitionCallback();
                        exitTransitionCallback = operation2.getFragment().getEnterTransitionCallback();
                    } else {
                        enterTransitionCallback = operation.getFragment().getEnterTransitionCallback();
                        exitTransitionCallback = operation2.getFragment().getExitTransitionCallback();
                    }
                    int i5 = 0;
                    for (int size = sharedElementSourceNames.size(); i5 < size; size = size) {
                        arrayMap.put(sharedElementSourceNames.get(i5), sharedElementTargetNames2.get(i5));
                        i5++;
                    }
                    androidx.collection.ArrayMap<java.lang.String, android.view.View> arrayMap2 = new androidx.collection.ArrayMap<>();
                    defaultSpecialEffectsController.findNamedViews(arrayMap2, operation.getFragment().mView);
                    arrayMap2.retainAll(sharedElementSourceNames);
                    if (enterTransitionCallback != null) {
                        enterTransitionCallback.onMapSharedElements(sharedElementSourceNames, arrayMap2);
                        int size2 = sharedElementSourceNames.size() - 1;
                        while (size2 >= 0) {
                            java.lang.String str = sharedElementSourceNames.get(size2);
                            android.view.View view7 = arrayMap2.get(str);
                            if (view7 == null) {
                                arrayMap.remove(str);
                                i3 = size2;
                            } else {
                                i3 = size2;
                                if (!str.equals(androidx.core.view.ViewCompat.getTransitionName(view7))) {
                                    arrayMap.put(androidx.core.view.ViewCompat.getTransitionName(view7), (java.lang.String) arrayMap.remove(str));
                                }
                            }
                            size2 = i3 - 1;
                        }
                    } else {
                        arrayMap.retainAll(arrayMap2.keySet());
                    }
                    final androidx.collection.ArrayMap<java.lang.String, android.view.View> arrayMap3 = new androidx.collection.ArrayMap<>();
                    defaultSpecialEffectsController.findNamedViews(arrayMap3, operation2.getFragment().mView);
                    arrayMap3.retainAll(sharedElementTargetNames2);
                    arrayMap3.retainAll(arrayMap.values());
                    if (exitTransitionCallback != null) {
                        exitTransitionCallback.onMapSharedElements(sharedElementTargetNames2, arrayMap3);
                        int size3 = sharedElementTargetNames2.size() - 1;
                        while (size3 >= 0) {
                            java.lang.String str2 = sharedElementTargetNames2.get(size3);
                            android.view.View view8 = arrayMap3.get(str2);
                            if (view8 == null) {
                                java.lang.String strFindKeyForValue2 = androidx.fragment.app.FragmentTransition.findKeyForValue(arrayMap, str2);
                                if (strFindKeyForValue2 != null) {
                                    arrayMap.remove(strFindKeyForValue2);
                                }
                                i2 = size3;
                            } else {
                                i2 = size3;
                                if (!str2.equals(androidx.core.view.ViewCompat.getTransitionName(view8)) && (strFindKeyForValue = androidx.fragment.app.FragmentTransition.findKeyForValue(arrayMap, str2)) != null) {
                                    arrayMap.put(strFindKeyForValue, androidx.core.view.ViewCompat.getTransitionName(view8));
                                }
                            }
                            size3 = i2 - 1;
                        }
                    } else {
                        androidx.fragment.app.FragmentTransition.retainValues(arrayMap, arrayMap3);
                    }
                    defaultSpecialEffectsController.retainMatchingViews(arrayMap2, arrayMap.keySet());
                    defaultSpecialEffectsController.retainMatchingViews(arrayMap3, arrayMap.values());
                    if (arrayMap.isEmpty()) {
                        arrayList5.clear();
                        arrayList6.clear();
                        rect = rect2;
                        arrayList4 = arrayList5;
                        obj2 = null;
                    } else {
                        androidx.fragment.app.FragmentTransition.callSharedElementStartEnd(operation2.getFragment(), operation.getFragment(), z, arrayMap2, true);
                        defaultSpecialEffectsController = this;
                        android.view.View view9 = view6;
                        androidx.core.view.OneShotPreDrawListener.add(getContainer(), new java.lang.Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.6
                            @Override // java.lang.Runnable
                            public void run() {
                                androidx.fragment.app.FragmentTransition.callSharedElementStartEnd(operation2.getFragment(), operation.getFragment(), z, arrayMap3, false);
                            }
                        });
                        arrayList5.addAll(arrayMap2.values());
                        if (sharedElementSourceNames.isEmpty()) {
                            i = 0;
                            view3 = view9;
                        } else {
                            i = 0;
                            view3 = arrayMap2.get(sharedElementSourceNames.get(0));
                            fragmentTransitionImpl.setEpicenter(obj4, view3);
                        }
                        arrayList6.addAll(arrayMap3.values());
                        if (!sharedElementTargetNames2.isEmpty() && (view4 = arrayMap3.get(sharedElementTargetNames2.get(i))) != null) {
                            androidx.core.view.OneShotPreDrawListener.add(defaultSpecialEffectsController.getContainer(), new java.lang.Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.7
                                @Override // java.lang.Runnable
                                public void run() {
                                    fragmentTransitionImpl.getBoundsOnScreen(view4, rect2);
                                }
                            });
                            z2 = true;
                        }
                        fragmentTransitionImpl.setSharedElementTargets(obj4, view5, arrayList5);
                        arrayList4 = arrayList5;
                        rect = rect2;
                        fragmentTransitionImpl.scheduleRemoveTargets(obj4, null, null, null, null, obj4, arrayList6);
                        map.put(operation, true);
                        map.put(operation2, true);
                        view6 = view3;
                        obj2 = obj4;
                    }
                }
                arrayList5 = arrayList4;
                rect2 = rect;
                view5 = view5;
                arrayList6 = arrayList6;
                arrayMap = arrayMap;
                i4 = 0;
            }
            androidx.fragment.app.SpecialEffectsController.Operation operation4 = operation;
            androidx.fragment.app.SpecialEffectsController.Operation operation5 = operation2;
            android.view.View view10 = view5;
            android.graphics.Rect rect3 = rect2;
            java.util.ArrayList<android.view.View> arrayList7 = arrayList5;
            androidx.collection.ArrayMap arrayMap4 = arrayMap;
            android.view.View view11 = view6;
            java.util.ArrayList<android.view.View> arrayList8 = arrayList6;
            java.util.ArrayList arrayList9 = new java.util.ArrayList();
            java.lang.Object obj5 = null;
            java.lang.Object obj6 = null;
            for (androidx.fragment.app.DefaultSpecialEffectsController.TransitionInfo transitionInfo4 : list) {
                if (transitionInfo4.isVisibilityUnchanged()) {
                    map.put(transitionInfo4.getOperation(), false);
                    transitionInfo4.completeSpecialEffect();
                } else {
                    java.lang.Object objCloneTransition = fragmentTransitionImpl.cloneTransition(transitionInfo4.getTransition());
                    androidx.fragment.app.SpecialEffectsController.Operation operation6 = transitionInfo4.getOperation();
                    boolean z3 = obj2 != null && (operation6 == operation4 || operation6 == operation5);
                    if (objCloneTransition == null) {
                        if (!z3) {
                            map.put(operation6, false);
                            transitionInfo4.completeSpecialEffect();
                        }
                        arrayList2 = arrayList7;
                        arrayList = arrayList8;
                        objMergeTransitionsTogether = obj5;
                        view = view11;
                        view2 = view10;
                        arrayList3 = arrayList9;
                    } else {
                        java.lang.Object obj7 = obj5;
                        final java.util.ArrayList<android.view.View> arrayList10 = new java.util.ArrayList<>();
                        java.util.ArrayList arrayList11 = arrayList9;
                        defaultSpecialEffectsController.captureTransitioningViews(arrayList10, operation6.getFragment().mView);
                        if (z3) {
                            if (operation6 == operation4) {
                                arrayList10.removeAll(arrayList7);
                            } else {
                                arrayList10.removeAll(arrayList8);
                            }
                        }
                        if (arrayList10.isEmpty()) {
                            fragmentTransitionImpl.addTarget(objCloneTransition, view10);
                            arrayList2 = arrayList7;
                            arrayList = arrayList8;
                            objMergeTransitionsTogether2 = obj6;
                            obj = objCloneTransition;
                            operation3 = operation6;
                            view = view11;
                            objMergeTransitionsTogether = obj7;
                            view2 = view10;
                            arrayList3 = arrayList11;
                        } else {
                            fragmentTransitionImpl.addTargets(objCloneTransition, arrayList10);
                            arrayList = arrayList8;
                            obj = objCloneTransition;
                            arrayList2 = arrayList7;
                            view = view11;
                            objMergeTransitionsTogether = obj7;
                            objMergeTransitionsTogether2 = obj6;
                            view2 = view10;
                            arrayList3 = arrayList11;
                            fragmentTransitionImpl.scheduleRemoveTargets(obj, obj, arrayList10, null, null, null, null);
                            if (operation6.getFinalState() == androidx.fragment.app.SpecialEffectsController.Operation.State.GONE) {
                                operation3 = operation6;
                                list2.remove(operation3);
                                java.util.ArrayList<android.view.View> arrayList12 = new java.util.ArrayList<>(arrayList10);
                                arrayList12.remove(operation3.getFragment().mView);
                                fragmentTransitionImpl.scheduleHideFragmentView(obj, operation3.getFragment().mView, arrayList12);
                                androidx.core.view.OneShotPreDrawListener.add(defaultSpecialEffectsController.getContainer(), new java.lang.Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.8
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        androidx.fragment.app.FragmentTransition.setViewVisibility(arrayList10, 4);
                                    }
                                });
                            } else {
                                operation3 = operation6;
                            }
                        }
                        if (operation3.getFinalState() == androidx.fragment.app.SpecialEffectsController.Operation.State.VISIBLE) {
                            arrayList3.addAll(arrayList10);
                            if (z2) {
                                fragmentTransitionImpl.setEpicenter(obj, rect3);
                            }
                        } else {
                            fragmentTransitionImpl.setEpicenter(obj, view);
                        }
                        map.put(operation3, true);
                        if (transitionInfo4.isOverlapAllowed()) {
                            objMergeTransitionsTogether = fragmentTransitionImpl.mergeTransitionsTogether(objMergeTransitionsTogether, obj, null);
                        } else {
                            objMergeTransitionsTogether2 = fragmentTransitionImpl.mergeTransitionsTogether(objMergeTransitionsTogether2, obj, null);
                        }
                        obj6 = objMergeTransitionsTogether2;
                    }
                    operation5 = operation2;
                    obj5 = objMergeTransitionsTogether;
                    arrayList9 = arrayList3;
                    view10 = view2;
                    arrayList8 = arrayList;
                    arrayList7 = arrayList2;
                    view11 = view;
                    operation4 = operation;
                }
            }
            java.util.ArrayList<android.view.View> arrayList13 = arrayList7;
            java.util.ArrayList<android.view.View> arrayList14 = arrayList8;
            java.util.ArrayList arrayList15 = arrayList9;
            java.lang.Object objMergeTransitionsInSequence = fragmentTransitionImpl.mergeTransitionsInSequence(obj5, obj6, obj2);
            for (final androidx.fragment.app.DefaultSpecialEffectsController.TransitionInfo transitionInfo5 : list) {
                if (!transitionInfo5.isVisibilityUnchanged()) {
                    java.lang.Object transition = transitionInfo5.getTransition();
                    androidx.fragment.app.SpecialEffectsController.Operation operation7 = transitionInfo5.getOperation();
                    boolean z4 = obj2 != null && (operation7 == operation || operation7 == operation2);
                    if (transition != null || z4) {
                        if (!androidx.core.view.ViewCompat.isLaidOut(defaultSpecialEffectsController.getContainer())) {
                            if (androidx.fragment.app.FragmentManager.isLoggingEnabled(2)) {
                                android.util.Log.v("FragmentManager", "SpecialEffectsController: Container " + defaultSpecialEffectsController.getContainer() + " has not been laid out. Completing operation " + operation7);
                            }
                            transitionInfo5.completeSpecialEffect();
                        } else {
                            fragmentTransitionImpl.setListenerForTransitionEnd(transitionInfo5.getOperation().getFragment(), objMergeTransitionsInSequence, transitionInfo5.getSignal(), new java.lang.Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.9
                                @Override // java.lang.Runnable
                                public void run() {
                                    transitionInfo5.completeSpecialEffect();
                                }
                            });
                        }
                    }
                }
            }
            if (androidx.core.view.ViewCompat.isLaidOut(defaultSpecialEffectsController.getContainer())) {
                androidx.fragment.app.FragmentTransition.setViewVisibility(arrayList15, 4);
                java.util.ArrayList<java.lang.String> arrayListPrepareSetNameOverridesReordered = fragmentTransitionImpl.prepareSetNameOverridesReordered(arrayList14);
                fragmentTransitionImpl.beginDelayedTransition(defaultSpecialEffectsController.getContainer(), objMergeTransitionsInSequence);
                fragmentTransitionImpl.setNameOverridesReordered(defaultSpecialEffectsController.getContainer(), arrayList13, arrayList14, arrayListPrepareSetNameOverridesReordered, arrayMap4);
                androidx.fragment.app.FragmentTransition.setViewVisibility(arrayList15, 0);
                fragmentTransitionImpl.swapSharedElementTargets(obj2, arrayList13, arrayList14);
                return map;
            }
        }
        return map;
    }

    void retainMatchingViews(androidx.collection.ArrayMap<java.lang.String, android.view.View> arrayMap, java.util.Collection<java.lang.String> collection) {
        java.util.Iterator<java.util.Map.Entry<java.lang.String, android.view.View>> it = arrayMap.entrySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(androidx.core.view.ViewCompat.getTransitionName(it.next().getValue()))) {
                it.remove();
            }
        }
    }

    void captureTransitioningViews(java.util.ArrayList<android.view.View> arrayList, android.view.View view) {
        if (view instanceof android.view.ViewGroup) {
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) view;
            if (androidx.core.view.ViewGroupCompat.isTransitionGroup(viewGroup)) {
                if (arrayList.contains(view)) {
                    return;
                }
                arrayList.add(viewGroup);
                return;
            }
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                android.view.View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    captureTransitioningViews(arrayList, childAt);
                }
            }
            return;
        }
        if (arrayList.contains(view)) {
            return;
        }
        arrayList.add(view);
    }

    void findNamedViews(java.util.Map<java.lang.String, android.view.View> map, android.view.View view) {
        java.lang.String transitionName = androidx.core.view.ViewCompat.getTransitionName(view);
        if (transitionName != null) {
            map.put(transitionName, view);
        }
        if (view instanceof android.view.ViewGroup) {
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                android.view.View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    findNamedViews(map, childAt);
                }
            }
        }
    }

    void applyContainerChanges(androidx.fragment.app.SpecialEffectsController.Operation operation) {
        operation.getFinalState().applyState(operation.getFragment().mView);
    }

    private static class SpecialEffectsInfo {
        private final androidx.fragment.app.SpecialEffectsController.Operation mOperation;
        private final androidx.core.os.CancellationSignal mSignal;

        SpecialEffectsInfo(androidx.fragment.app.SpecialEffectsController.Operation operation, androidx.core.os.CancellationSignal cancellationSignal) {
            this.mOperation = operation;
            this.mSignal = cancellationSignal;
        }

        androidx.fragment.app.SpecialEffectsController.Operation getOperation() {
            return this.mOperation;
        }

        androidx.core.os.CancellationSignal getSignal() {
            return this.mSignal;
        }

        boolean isVisibilityUnchanged() {
            androidx.fragment.app.SpecialEffectsController.Operation.State stateFrom = androidx.fragment.app.SpecialEffectsController.Operation.State.from(this.mOperation.getFragment().mView);
            androidx.fragment.app.SpecialEffectsController.Operation.State finalState = this.mOperation.getFinalState();
            if (stateFrom != finalState) {
                return (stateFrom == androidx.fragment.app.SpecialEffectsController.Operation.State.VISIBLE || finalState == androidx.fragment.app.SpecialEffectsController.Operation.State.VISIBLE) ? false : true;
            }
            return true;
        }

        void completeSpecialEffect() {
            this.mOperation.completeSpecialEffect(this.mSignal);
        }
    }

    private static class AnimationInfo extends androidx.fragment.app.DefaultSpecialEffectsController.SpecialEffectsInfo {
        private androidx.fragment.app.FragmentAnim.AnimationOrAnimator mAnimation;
        private boolean mIsPop;
        private boolean mLoadedAnim;

        AnimationInfo(androidx.fragment.app.SpecialEffectsController.Operation operation, androidx.core.os.CancellationSignal cancellationSignal, boolean z) {
            super(operation, cancellationSignal);
            this.mLoadedAnim = false;
            this.mIsPop = z;
        }

        androidx.fragment.app.FragmentAnim.AnimationOrAnimator getAnimation(android.content.Context context) {
            if (this.mLoadedAnim) {
                return this.mAnimation;
            }
            androidx.fragment.app.FragmentAnim.AnimationOrAnimator animationOrAnimatorLoadAnimation = androidx.fragment.app.FragmentAnim.loadAnimation(context, getOperation().getFragment(), getOperation().getFinalState() == androidx.fragment.app.SpecialEffectsController.Operation.State.VISIBLE, this.mIsPop);
            this.mAnimation = animationOrAnimatorLoadAnimation;
            this.mLoadedAnim = true;
            return animationOrAnimatorLoadAnimation;
        }
    }

    private static class TransitionInfo extends androidx.fragment.app.DefaultSpecialEffectsController.SpecialEffectsInfo {
        private final boolean mOverlapAllowed;
        private final java.lang.Object mSharedElementTransition;
        private final java.lang.Object mTransition;

        TransitionInfo(androidx.fragment.app.SpecialEffectsController.Operation operation, androidx.core.os.CancellationSignal cancellationSignal, boolean z, boolean z2) {
            java.lang.Object exitTransition;
            java.lang.Object enterTransition;
            boolean allowEnterTransitionOverlap;
            super(operation, cancellationSignal);
            if (operation.getFinalState() == androidx.fragment.app.SpecialEffectsController.Operation.State.VISIBLE) {
                if (z) {
                    enterTransition = operation.getFragment().getReenterTransition();
                } else {
                    enterTransition = operation.getFragment().getEnterTransition();
                }
                this.mTransition = enterTransition;
                if (z) {
                    allowEnterTransitionOverlap = operation.getFragment().getAllowReturnTransitionOverlap();
                } else {
                    allowEnterTransitionOverlap = operation.getFragment().getAllowEnterTransitionOverlap();
                }
                this.mOverlapAllowed = allowEnterTransitionOverlap;
            } else {
                if (z) {
                    exitTransition = operation.getFragment().getReturnTransition();
                } else {
                    exitTransition = operation.getFragment().getExitTransition();
                }
                this.mTransition = exitTransition;
                this.mOverlapAllowed = true;
            }
            if (!z2) {
                this.mSharedElementTransition = null;
            } else if (z) {
                this.mSharedElementTransition = operation.getFragment().getSharedElementReturnTransition();
            } else {
                this.mSharedElementTransition = operation.getFragment().getSharedElementEnterTransition();
            }
        }

        java.lang.Object getTransition() {
            return this.mTransition;
        }

        boolean isOverlapAllowed() {
            return this.mOverlapAllowed;
        }

        public boolean hasSharedElementTransition() {
            return this.mSharedElementTransition != null;
        }

        public java.lang.Object getSharedElementTransition() {
            return this.mSharedElementTransition;
        }

        androidx.fragment.app.FragmentTransitionImpl getHandlingImpl() {
            androidx.fragment.app.FragmentTransitionImpl handlingImpl = getHandlingImpl(this.mTransition);
            androidx.fragment.app.FragmentTransitionImpl handlingImpl2 = getHandlingImpl(this.mSharedElementTransition);
            if (handlingImpl == null || handlingImpl2 == null || handlingImpl == handlingImpl2) {
                return handlingImpl != null ? handlingImpl : handlingImpl2;
            }
            throw new java.lang.IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + getOperation().getFragment() + " returned Transition " + this.mTransition + " which uses a different Transition  type than its shared element transition " + this.mSharedElementTransition);
        }

        private androidx.fragment.app.FragmentTransitionImpl getHandlingImpl(java.lang.Object obj) {
            if (obj == null) {
                return null;
            }
            if (androidx.fragment.app.FragmentTransition.PLATFORM_IMPL != null && androidx.fragment.app.FragmentTransition.PLATFORM_IMPL.canHandle(obj)) {
                return androidx.fragment.app.FragmentTransition.PLATFORM_IMPL;
            }
            if (androidx.fragment.app.FragmentTransition.SUPPORT_IMPL != null && androidx.fragment.app.FragmentTransition.SUPPORT_IMPL.canHandle(obj)) {
                return androidx.fragment.app.FragmentTransition.SUPPORT_IMPL;
            }
            throw new java.lang.IllegalArgumentException("Transition " + obj + " for fragment " + getOperation().getFragment() + " is not a valid framework Transition or AndroidX Transition");
        }
    }
}
