package androidx.core.transition;

/* JADX INFO: compiled from: Transition.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\u001aÆ\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00022#\b\u0006\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\b\u001a2\u0010\r\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\b\u001a2\u0010\u000f\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\b\u001a2\u0010\u0010\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\b\u001a2\u0010\u0011\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\b\u001a2\u0010\u0012\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\b¨\u0006\u0013"}, d2 = {"addListener", "Landroid/transition/Transition$TransitionListener;", "Landroid/transition/Transition;", "onEnd", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", io.dcloud.common.constant.AbsoluteConst.JSON_KEY_TRANSITION, "", "onStart", "onCancel", "onResume", "onPause", "doOnCancel", "action", "doOnEnd", "doOnPause", "doOnResume", "doOnStart", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TransitionKt {
    public static /* synthetic */ android.transition.Transition.TransitionListener addListener$default(android.transition.Transition transition, kotlin.jvm.functions.Function1 function1, kotlin.jvm.functions.Function1 function2, kotlin.jvm.functions.Function1 function3, kotlin.jvm.functions.Function1 function4, kotlin.jvm.functions.Function1 function5, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            function1 = new kotlin.jvm.functions.Function1<android.transition.Transition, kotlin.Unit>() { // from class: androidx.core.transition.TransitionKt.addListener.1
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(android.transition.Transition transition2) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.Unit invoke(android.transition.Transition transition2) {
                    invoke2(transition2);
                    return kotlin.Unit.INSTANCE;
                }
            };
        }
        if ((i & 2) != 0) {
            function2 = new kotlin.jvm.functions.Function1<android.transition.Transition, kotlin.Unit>() { // from class: androidx.core.transition.TransitionKt.addListener.2
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(android.transition.Transition transition2) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.Unit invoke(android.transition.Transition transition2) {
                    invoke2(transition2);
                    return kotlin.Unit.INSTANCE;
                }
            };
        }
        kotlin.jvm.functions.Function1 function6 = function2;
        if ((i & 4) != 0) {
            function3 = new kotlin.jvm.functions.Function1<android.transition.Transition, kotlin.Unit>() { // from class: androidx.core.transition.TransitionKt.addListener.3
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(android.transition.Transition transition2) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.Unit invoke(android.transition.Transition transition2) {
                    invoke2(transition2);
                    return kotlin.Unit.INSTANCE;
                }
            };
        }
        if ((i & 8) != 0) {
            function4 = new kotlin.jvm.functions.Function1<android.transition.Transition, kotlin.Unit>() { // from class: androidx.core.transition.TransitionKt.addListener.4
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(android.transition.Transition transition2) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.Unit invoke(android.transition.Transition transition2) {
                    invoke2(transition2);
                    return kotlin.Unit.INSTANCE;
                }
            };
        }
        if ((i & 16) != 0) {
            function5 = new kotlin.jvm.functions.Function1<android.transition.Transition, kotlin.Unit>() { // from class: androidx.core.transition.TransitionKt.addListener.5
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(android.transition.Transition transition2) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.Unit invoke(android.transition.Transition transition2) {
                    invoke2(transition2);
                    return kotlin.Unit.INSTANCE;
                }
            };
        }
        androidx.core.transition.TransitionKt$addListener$listener$1 transitionKt$addListener$listener$1 = new androidx.core.transition.TransitionKt$addListener$listener$1(function1, function4, function5, function3, function6);
        transition.addListener(transitionKt$addListener$listener$1);
        return transitionKt$addListener$listener$1;
    }

    public static final android.transition.Transition.TransitionListener addListener(android.transition.Transition transition, kotlin.jvm.functions.Function1<? super android.transition.Transition, kotlin.Unit> function1, kotlin.jvm.functions.Function1<? super android.transition.Transition, kotlin.Unit> function2, kotlin.jvm.functions.Function1<? super android.transition.Transition, kotlin.Unit> function3, kotlin.jvm.functions.Function1<? super android.transition.Transition, kotlin.Unit> function4, kotlin.jvm.functions.Function1<? super android.transition.Transition, kotlin.Unit> function5) {
        androidx.core.transition.TransitionKt$addListener$listener$1 transitionKt$addListener$listener$1 = new androidx.core.transition.TransitionKt$addListener$listener$1(function1, function4, function5, function3, function2);
        transition.addListener(transitionKt$addListener$listener$1);
        return transitionKt$addListener$listener$1;
    }

    public static final android.transition.Transition.TransitionListener doOnEnd(android.transition.Transition transition, final kotlin.jvm.functions.Function1<? super android.transition.Transition, kotlin.Unit> function1) {
        android.transition.Transition.TransitionListener transitionListener = new android.transition.Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnEnd$$inlined$addListener$default$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(android.transition.Transition transition2) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(android.transition.Transition transition2) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(android.transition.Transition transition2) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(android.transition.Transition transition2) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(android.transition.Transition transition2) {
                function1.invoke(transition2);
            }
        };
        transition.addListener(transitionListener);
        return transitionListener;
    }

    public static final android.transition.Transition.TransitionListener doOnStart(android.transition.Transition transition, final kotlin.jvm.functions.Function1<? super android.transition.Transition, kotlin.Unit> function1) {
        android.transition.Transition.TransitionListener transitionListener = new android.transition.Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnStart$$inlined$addListener$default$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(android.transition.Transition transition2) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(android.transition.Transition transition2) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(android.transition.Transition transition2) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(android.transition.Transition transition2) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(android.transition.Transition transition2) {
                function1.invoke(transition2);
            }
        };
        transition.addListener(transitionListener);
        return transitionListener;
    }

    public static final android.transition.Transition.TransitionListener doOnCancel(android.transition.Transition transition, final kotlin.jvm.functions.Function1<? super android.transition.Transition, kotlin.Unit> function1) {
        android.transition.Transition.TransitionListener transitionListener = new android.transition.Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnCancel$$inlined$addListener$default$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(android.transition.Transition transition2) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(android.transition.Transition transition2) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(android.transition.Transition transition2) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(android.transition.Transition transition2) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(android.transition.Transition transition2) {
                function1.invoke(transition2);
            }
        };
        transition.addListener(transitionListener);
        return transitionListener;
    }

    public static final android.transition.Transition.TransitionListener doOnResume(android.transition.Transition transition, final kotlin.jvm.functions.Function1<? super android.transition.Transition, kotlin.Unit> function1) {
        android.transition.Transition.TransitionListener transitionListener = new android.transition.Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnResume$$inlined$addListener$default$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(android.transition.Transition transition2) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(android.transition.Transition transition2) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(android.transition.Transition transition2) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(android.transition.Transition transition2) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(android.transition.Transition transition2) {
                function1.invoke(transition2);
            }
        };
        transition.addListener(transitionListener);
        return transitionListener;
    }

    public static final android.transition.Transition.TransitionListener doOnPause(android.transition.Transition transition, final kotlin.jvm.functions.Function1<? super android.transition.Transition, kotlin.Unit> function1) {
        android.transition.Transition.TransitionListener transitionListener = new android.transition.Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnPause$$inlined$addListener$default$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(android.transition.Transition transition2) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(android.transition.Transition transition2) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(android.transition.Transition transition2) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(android.transition.Transition transition2) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(android.transition.Transition transition2) {
                function1.invoke(transition2);
            }
        };
        transition.addListener(transitionListener);
        return transitionListener;
    }
}
