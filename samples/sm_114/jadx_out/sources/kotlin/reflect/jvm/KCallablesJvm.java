package kotlin.reflect.jvm;

/* JADX INFO: compiled from: KCallablesJvm.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\",\u0010\u0002\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0002\u0010\u0004\"\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"value", "", "isAccessible", "Lkotlin/reflect/KCallable;", "(Lkotlin/reflect/KCallable;)Z", "setAccessible", "(Lkotlin/reflect/KCallable;Z)V", "kotlin-reflection"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class KCallablesJvm {
    public static final boolean isAccessible(kotlin.reflect.KCallable<?> kCallable) {
        kotlin.reflect.jvm.internal.calls.Caller<?> defaultCaller;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kCallable, "<this>");
        if (kCallable instanceof kotlin.reflect.KMutableProperty) {
            kotlin.reflect.KProperty kProperty = (kotlin.reflect.KProperty) kCallable;
            java.lang.reflect.Field javaField = kotlin.reflect.jvm.ReflectJvmMapping.getJavaField(kProperty);
            if (javaField != null ? javaField.isAccessible() : true) {
                java.lang.reflect.Method javaGetter = kotlin.reflect.jvm.ReflectJvmMapping.getJavaGetter(kProperty);
                if (javaGetter != null ? javaGetter.isAccessible() : true) {
                    java.lang.reflect.Method javaSetter = kotlin.reflect.jvm.ReflectJvmMapping.getJavaSetter((kotlin.reflect.KMutableProperty) kCallable);
                    if (javaSetter != null ? javaSetter.isAccessible() : true) {
                        return true;
                    }
                }
            }
            return false;
        }
        if (kCallable instanceof kotlin.reflect.KProperty) {
            kotlin.reflect.KProperty kProperty2 = (kotlin.reflect.KProperty) kCallable;
            java.lang.reflect.Field javaField2 = kotlin.reflect.jvm.ReflectJvmMapping.getJavaField(kProperty2);
            if (javaField2 != null ? javaField2.isAccessible() : true) {
                java.lang.reflect.Method javaGetter2 = kotlin.reflect.jvm.ReflectJvmMapping.getJavaGetter(kProperty2);
                if (javaGetter2 != null ? javaGetter2.isAccessible() : true) {
                    return true;
                }
            }
            return false;
        }
        if (kCallable instanceof kotlin.reflect.KProperty.Getter) {
            java.lang.reflect.Field javaField3 = kotlin.reflect.jvm.ReflectJvmMapping.getJavaField(((kotlin.reflect.KProperty.Getter) kCallable).getProperty());
            if (javaField3 != null ? javaField3.isAccessible() : true) {
                java.lang.reflect.Method javaMethod = kotlin.reflect.jvm.ReflectJvmMapping.getJavaMethod((kotlin.reflect.KFunction) kCallable);
                if (javaMethod != null ? javaMethod.isAccessible() : true) {
                    return true;
                }
            }
            return false;
        }
        if (kCallable instanceof kotlin.reflect.KMutableProperty.Setter) {
            java.lang.reflect.Field javaField4 = kotlin.reflect.jvm.ReflectJvmMapping.getJavaField(((kotlin.reflect.KMutableProperty.Setter) kCallable).getProperty());
            if (javaField4 != null ? javaField4.isAccessible() : true) {
                java.lang.reflect.Method javaMethod2 = kotlin.reflect.jvm.ReflectJvmMapping.getJavaMethod((kotlin.reflect.KFunction) kCallable);
                if (javaMethod2 != null ? javaMethod2.isAccessible() : true) {
                    return true;
                }
            }
            return false;
        }
        if (kCallable instanceof kotlin.reflect.KFunction) {
            kotlin.reflect.KFunction kFunction = (kotlin.reflect.KFunction) kCallable;
            java.lang.reflect.Method javaMethod3 = kotlin.reflect.jvm.ReflectJvmMapping.getJavaMethod(kFunction);
            if (javaMethod3 != null ? javaMethod3.isAccessible() : true) {
                kotlin.reflect.jvm.internal.KCallableImpl<?> kCallableImplAsKCallableImpl = kotlin.reflect.jvm.internal.UtilKt.asKCallableImpl(kCallable);
                java.lang.reflect.Member memberMo1823getMember = (kCallableImplAsKCallableImpl == null || (defaultCaller = kCallableImplAsKCallableImpl.getDefaultCaller()) == null) ? null : defaultCaller.mo1823getMember();
                java.lang.reflect.AccessibleObject accessibleObject = memberMo1823getMember instanceof java.lang.reflect.AccessibleObject ? (java.lang.reflect.AccessibleObject) memberMo1823getMember : null;
                if (accessibleObject != null ? accessibleObject.isAccessible() : true) {
                    java.lang.reflect.Constructor javaConstructor = kotlin.reflect.jvm.ReflectJvmMapping.getJavaConstructor(kFunction);
                    if (javaConstructor != null ? javaConstructor.isAccessible() : true) {
                        return true;
                    }
                }
            }
            return false;
        }
        throw new java.lang.UnsupportedOperationException("Unknown callable: " + kCallable + " (" + kCallable.getClass() + com.taobao.weex.el.parse.Operators.BRACKET_END);
    }

    public static final void setAccessible(kotlin.reflect.KCallable<?> kCallable, boolean z) {
        kotlin.reflect.jvm.internal.calls.Caller<?> defaultCaller;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kCallable, "<this>");
        if (kCallable instanceof kotlin.reflect.KMutableProperty) {
            kotlin.reflect.KProperty kProperty = (kotlin.reflect.KProperty) kCallable;
            java.lang.reflect.Field javaField = kotlin.reflect.jvm.ReflectJvmMapping.getJavaField(kProperty);
            if (javaField != null) {
                javaField.setAccessible(z);
            }
            java.lang.reflect.Method javaGetter = kotlin.reflect.jvm.ReflectJvmMapping.getJavaGetter(kProperty);
            if (javaGetter != null) {
                javaGetter.setAccessible(z);
            }
            java.lang.reflect.Method javaSetter = kotlin.reflect.jvm.ReflectJvmMapping.getJavaSetter((kotlin.reflect.KMutableProperty) kCallable);
            if (javaSetter != null) {
                javaSetter.setAccessible(z);
                return;
            }
            return;
        }
        if (kCallable instanceof kotlin.reflect.KProperty) {
            kotlin.reflect.KProperty kProperty2 = (kotlin.reflect.KProperty) kCallable;
            java.lang.reflect.Field javaField2 = kotlin.reflect.jvm.ReflectJvmMapping.getJavaField(kProperty2);
            if (javaField2 != null) {
                javaField2.setAccessible(z);
            }
            java.lang.reflect.Method javaGetter2 = kotlin.reflect.jvm.ReflectJvmMapping.getJavaGetter(kProperty2);
            if (javaGetter2 != null) {
                javaGetter2.setAccessible(z);
                return;
            }
            return;
        }
        if (kCallable instanceof kotlin.reflect.KProperty.Getter) {
            java.lang.reflect.Field javaField3 = kotlin.reflect.jvm.ReflectJvmMapping.getJavaField(((kotlin.reflect.KProperty.Getter) kCallable).getProperty());
            if (javaField3 != null) {
                javaField3.setAccessible(z);
            }
            java.lang.reflect.Method javaMethod = kotlin.reflect.jvm.ReflectJvmMapping.getJavaMethod((kotlin.reflect.KFunction) kCallable);
            if (javaMethod != null) {
                javaMethod.setAccessible(z);
                return;
            }
            return;
        }
        if (kCallable instanceof kotlin.reflect.KMutableProperty.Setter) {
            java.lang.reflect.Field javaField4 = kotlin.reflect.jvm.ReflectJvmMapping.getJavaField(((kotlin.reflect.KMutableProperty.Setter) kCallable).getProperty());
            if (javaField4 != null) {
                javaField4.setAccessible(z);
            }
            java.lang.reflect.Method javaMethod2 = kotlin.reflect.jvm.ReflectJvmMapping.getJavaMethod((kotlin.reflect.KFunction) kCallable);
            if (javaMethod2 != null) {
                javaMethod2.setAccessible(z);
                return;
            }
            return;
        }
        if (kCallable instanceof kotlin.reflect.KFunction) {
            kotlin.reflect.KFunction kFunction = (kotlin.reflect.KFunction) kCallable;
            java.lang.reflect.Method javaMethod3 = kotlin.reflect.jvm.ReflectJvmMapping.getJavaMethod(kFunction);
            if (javaMethod3 != null) {
                javaMethod3.setAccessible(z);
            }
            kotlin.reflect.jvm.internal.KCallableImpl<?> kCallableImplAsKCallableImpl = kotlin.reflect.jvm.internal.UtilKt.asKCallableImpl(kCallable);
            java.lang.reflect.Member memberMo1823getMember = (kCallableImplAsKCallableImpl == null || (defaultCaller = kCallableImplAsKCallableImpl.getDefaultCaller()) == null) ? null : defaultCaller.mo1823getMember();
            java.lang.reflect.AccessibleObject accessibleObject = memberMo1823getMember instanceof java.lang.reflect.AccessibleObject ? (java.lang.reflect.AccessibleObject) memberMo1823getMember : null;
            if (accessibleObject != null) {
                accessibleObject.setAccessible(true);
            }
            java.lang.reflect.Constructor javaConstructor = kotlin.reflect.jvm.ReflectJvmMapping.getJavaConstructor(kFunction);
            if (javaConstructor != null) {
                javaConstructor.setAccessible(z);
                return;
            }
            return;
        }
        throw new java.lang.UnsupportedOperationException("Unknown callable: " + kCallable + " (" + kCallable.getClass() + com.taobao.weex.el.parse.Operators.BRACKET_END);
    }
}
