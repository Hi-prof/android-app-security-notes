package com.taobao.weex.ui.component.binding;

/* JADX INFO: loaded from: classes.dex */
public class Layouts {
    public static void doLayoutAsync(com.taobao.weex.ui.component.list.template.TemplateViewHolder templateViewHolder, boolean z) {
        com.taobao.weex.ui.component.WXComponent component = templateViewHolder.getComponent();
        int holderPosition = templateViewHolder.getHolderPosition();
        if (templateViewHolder.asyncTask != null) {
            templateViewHolder.asyncTask.cancel(false);
            templateViewHolder.asyncTask = null;
        }
        if (z) {
            com.taobao.weex.ui.component.binding.AsynLayoutTask asynLayoutTask = new com.taobao.weex.ui.component.binding.AsynLayoutTask(templateViewHolder, holderPosition, component);
            templateViewHolder.asyncTask = asynLayoutTask;
            asynLayoutTask.executeOnExecutor(android.os.AsyncTask.SERIAL_EXECUTOR, new java.lang.Void[0]);
        } else {
            doLayoutOnly(component, templateViewHolder);
            setLayout(component, false);
            if (templateViewHolder.getHolderPosition() >= 0) {
                templateViewHolder.getTemplateList().fireEvent(com.taobao.weex.ui.component.list.template.TemplateDom.ATTACH_CELL_SLOT, com.taobao.weex.ui.component.list.template.TemplateDom.findAllComponentRefs(templateViewHolder.getTemplateList().getRef(), holderPosition, component));
            }
        }
    }

    public static void doLayoutSync(com.taobao.weex.ui.component.list.WXCell wXCell, float f, float f2) {
        doSafeLayout(wXCell, f, f2);
        setLayout(wXCell, false);
    }

    public static void doLayoutOnly(com.taobao.weex.ui.component.WXComponent wXComponent, com.taobao.weex.ui.component.list.template.TemplateViewHolder templateViewHolder) {
        doSafeLayout(wXComponent, templateViewHolder.getTemplateList().getLayoutWidth(), templateViewHolder.getTemplateList().getLayoutHeight());
    }

    private static void doSafeLayout(com.taobao.weex.ui.component.WXComponent wXComponent, float f, float f2) {
        try {
            java.lang.System.currentTimeMillis();
            int iNativeLayoutRenderObject = com.taobao.weex.ui.component.list.template.jni.NativeRenderObjectUtils.nativeLayoutRenderObject(wXComponent.getRenderObjectPtr(), f, f2);
            com.taobao.weex.WXEnvironment.isOpenDebugLog();
            if (iNativeLayoutRenderObject <= 0) {
                com.taobao.weex.utils.WXLogUtils.e(com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList.TAG, " WXTemplateList doSafeLayout wrong template " + wXComponent.getAttrs().get(com.taobao.weex.common.Constants.Name.Recycler.SLOT_TEMPLATE_CASE) + " cell height " + iNativeLayoutRenderObject);
            }
        } catch (java.lang.Exception e) {
            if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
                com.taobao.weex.utils.WXLogUtils.e(com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList.TAG, e);
            }
        }
    }

    public static final void setLayout(com.taobao.weex.ui.component.WXComponent wXComponent, boolean z) {
        if (wXComponent.isWaste()) {
            return;
        }
        if (wXComponent.getAttrs().containsKey(com.taobao.weex.ui.component.list.template.TemplateDom.KEY_RESET_ANIMATION) && com.taobao.weex.utils.WXUtils.getBoolean(wXComponent.getAttrs().get(com.taobao.weex.ui.component.list.template.TemplateDom.KEY_RESET_ANIMATION), true).booleanValue()) {
            com.taobao.weex.ui.component.list.template.TemplateDom.resetAnimaiton(wXComponent.getHostView());
        }
        long renderObjectPtr = wXComponent.getRenderObjectPtr();
        if (com.taobao.weex.ui.component.list.template.jni.NativeRenderObjectUtils.nativeRenderObjectHasNewLayout(renderObjectPtr)) {
            com.taobao.weex.ui.component.list.template.jni.NativeRenderObjectUtils.nativeRenderObjectUpdateComponent(renderObjectPtr, wXComponent);
        }
        if (wXComponent instanceof com.taobao.weex.ui.component.WXVContainer) {
            com.taobao.weex.ui.component.WXVContainer wXVContainer = (com.taobao.weex.ui.component.WXVContainer) wXComponent;
            int childCount = wXVContainer.getChildCount();
            for (int i = 0; i < childCount; i++) {
                com.taobao.weex.ui.component.WXComponent child = wXVContainer.getChild(i);
                if (child != null) {
                    setLayout(child, z);
                }
            }
        }
    }
}
