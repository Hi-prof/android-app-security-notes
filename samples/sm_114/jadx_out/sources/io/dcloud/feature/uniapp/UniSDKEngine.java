package io.dcloud.feature.uniapp;

/* JADX INFO: loaded from: classes2.dex */
public class UniSDKEngine extends com.taobao.weex.WXSDKEngine {

    public static abstract class DestroyableUniModule extends io.dcloud.feature.uniapp.common.UniModule implements com.taobao.weex.common.Destroyable {
    }

    public static abstract class DestroyableUniModuleFactory<T extends io.dcloud.feature.uniapp.common.UniDestroyableModule> extends io.dcloud.feature.uniapp.common.TypeUniModuleFactory<T> {
        public DestroyableUniModuleFactory(java.lang.Class<T> cls) {
            super(cls);
        }
    }

    public static boolean registerUniVContainer(java.lang.String str, java.lang.Class<? extends io.dcloud.feature.uniapp.ui.component.UniVContainer> cls) throws com.taobao.weex.common.WXException {
        return com.taobao.weex.ui.WXComponentRegistry.registerComponent(str, new com.taobao.weex.ui.SimpleComponentHolder(cls), new java.util.HashMap());
    }

    public static boolean registerUniComponent(java.lang.String str, java.lang.Class<? extends io.dcloud.feature.uniapp.ui.component.UniComponent> cls) throws com.taobao.weex.common.WXException {
        return com.taobao.weex.ui.WXComponentRegistry.registerComponent(str, new com.taobao.weex.ui.SimpleComponentHolder(cls), new java.util.HashMap());
    }

    public static boolean registerUniComponent(java.lang.String str, java.lang.Class<? extends io.dcloud.feature.uniapp.ui.component.UniComponent> cls, boolean z) throws io.dcloud.feature.uniapp.common.UniException {
        return registerComponent(cls, z, str);
    }

    public static boolean registerUniComponent(java.lang.String str, io.dcloud.feature.uniapp.ui.IExternalUniComponentGetter iExternalUniComponentGetter, boolean z) throws io.dcloud.feature.uniapp.common.UniException {
        return registerComponent(new com.taobao.weex.ui.ExternalLoaderComponentHolder(str, iExternalUniComponentGetter), z, str);
    }

    public static boolean registerUniComponent(java.lang.Class<? extends io.dcloud.feature.uniapp.ui.component.UniComponent> cls, boolean z, java.lang.String... strArr) throws io.dcloud.feature.uniapp.common.UniException {
        return registerComponent(cls, z, strArr);
    }

    public static boolean registerUniComponent(io.dcloud.feature.uniapp.ui.IFUniComponentHolder iFUniComponentHolder, boolean z, java.lang.String... strArr) throws io.dcloud.feature.uniapp.common.UniException {
        return registerComponent(iFUniComponentHolder, z, strArr);
    }

    public static <T extends io.dcloud.feature.uniapp.common.UniModule> boolean registerUniModule(java.lang.String str, java.lang.Class<T> cls, boolean z) throws io.dcloud.feature.uniapp.common.UniException {
        return registerModule(str, cls, z);
    }

    public static <T extends io.dcloud.feature.uniapp.common.UniModule> boolean registerUniModuleWithFactory(java.lang.String str, io.dcloud.feature.uniapp.UniSDKEngine.DestroyableUniModuleFactory destroyableUniModuleFactory, boolean z) throws io.dcloud.feature.uniapp.common.UniException {
        return registerModule(str, destroyableUniModuleFactory, z);
    }

    public static <T extends io.dcloud.feature.uniapp.common.UniModule> boolean registerModuleWithFactory(java.lang.String str, io.dcloud.feature.uniapp.ui.IExternalUniModuleGetter iExternalUniModuleGetter, boolean z) throws com.taobao.weex.common.WXException {
        return registerModule(str, iExternalUniModuleGetter.getExternalModuleClass(str, com.taobao.weex.WXEnvironment.getApplication()), z);
    }

    public static <T extends io.dcloud.feature.uniapp.common.UniModule> boolean registerUniModule(java.lang.String str, io.dcloud.feature.uniapp.bridge.UniModuleFactory uniModuleFactory, boolean z) throws com.taobao.weex.common.WXException {
        return com.taobao.weex.bridge.WXModuleManager.registerModule(str, uniModuleFactory, z);
    }

    public static boolean registerUniModule(java.lang.String str, java.lang.Class<? extends io.dcloud.feature.uniapp.common.UniModule> cls) throws com.taobao.weex.common.WXException {
        return registerModule(str, (java.lang.Class) cls, false);
    }
}
