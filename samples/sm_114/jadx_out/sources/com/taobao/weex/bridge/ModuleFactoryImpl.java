package com.taobao.weex.bridge;

/* JADX INFO: loaded from: classes.dex */
public class ModuleFactoryImpl {
    public boolean hasRigster;
    public com.taobao.weex.bridge.ModuleFactory mFactory;

    public ModuleFactoryImpl(com.taobao.weex.bridge.ModuleFactory moduleFactory) {
        this.hasRigster = false;
        this.mFactory = moduleFactory;
    }

    public ModuleFactoryImpl(com.taobao.weex.bridge.ModuleFactory moduleFactory, boolean z) {
        this.mFactory = moduleFactory;
        this.hasRigster = z;
    }
}
