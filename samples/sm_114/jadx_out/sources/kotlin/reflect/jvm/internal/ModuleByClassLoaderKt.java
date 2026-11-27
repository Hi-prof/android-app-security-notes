package kotlin.reflect.jvm.internal;

/* JADX INFO: compiled from: moduleByClassLoader.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u001a\u0010\u0010\u0005\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\u0006H\u0000\u001a\b\u0010\u0007\u001a\u00020\bH\u0000\" \u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"moduleByClassLoader", "Ljava/util/concurrent/ConcurrentMap;", "Lkotlin/reflect/jvm/internal/WeakClassLoaderBox;", "Ljava/lang/ref/WeakReference;", "Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/RuntimeModuleData;", "getOrCreateModule", "Ljava/lang/Class;", "clearModuleByClassLoaderCache", "", "kotlin-reflection"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ModuleByClassLoaderKt {
    private static final java.util.concurrent.ConcurrentMap<kotlin.reflect.jvm.internal.WeakClassLoaderBox, java.lang.ref.WeakReference<kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData>> moduleByClassLoader = new java.util.concurrent.ConcurrentHashMap();

    public static final kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData getOrCreateModule(java.lang.Class<?> cls) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cls, "<this>");
        java.lang.ClassLoader safeClassLoader = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt.getSafeClassLoader(cls);
        kotlin.reflect.jvm.internal.WeakClassLoaderBox weakClassLoaderBox = new kotlin.reflect.jvm.internal.WeakClassLoaderBox(safeClassLoader);
        java.util.concurrent.ConcurrentMap<kotlin.reflect.jvm.internal.WeakClassLoaderBox, java.lang.ref.WeakReference<kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData>> concurrentMap = moduleByClassLoader;
        java.lang.ref.WeakReference<kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData> weakReference = concurrentMap.get(weakClassLoaderBox);
        if (weakReference != null) {
            kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData runtimeModuleData = weakReference.get();
            if (runtimeModuleData != null) {
                return runtimeModuleData;
            }
            concurrentMap.remove(weakClassLoaderBox, weakReference);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData runtimeModuleDataCreate = kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData.Companion.create(safeClassLoader);
        while (true) {
            try {
                java.util.concurrent.ConcurrentMap<kotlin.reflect.jvm.internal.WeakClassLoaderBox, java.lang.ref.WeakReference<kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData>> concurrentMap2 = moduleByClassLoader;
                java.lang.ref.WeakReference<kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData> weakReferencePutIfAbsent = concurrentMap2.putIfAbsent(weakClassLoaderBox, new java.lang.ref.WeakReference<>(runtimeModuleDataCreate));
                if (weakReferencePutIfAbsent != null) {
                    kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData runtimeModuleData2 = weakReferencePutIfAbsent.get();
                    if (runtimeModuleData2 == null) {
                        concurrentMap2.remove(weakClassLoaderBox, weakReferencePutIfAbsent);
                    } else {
                        weakClassLoaderBox.setTemporaryStrongRef(null);
                        return runtimeModuleData2;
                    }
                } else {
                    weakClassLoaderBox.setTemporaryStrongRef(null);
                    return runtimeModuleDataCreate;
                }
            } catch (java.lang.Throwable th) {
                weakClassLoaderBox.setTemporaryStrongRef(null);
                throw th;
            }
        }
    }

    public static final void clearModuleByClassLoaderCache() {
        moduleByClassLoader.clear();
    }
}
