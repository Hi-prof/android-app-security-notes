package com.alibaba.android.bindingx.plugin.weex;

/* JADX INFO: loaded from: classes.dex */
final class WXViewUpdateService {
    private static final com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.NOpUpdater EMPTY_INVOKER;
    private static final java.lang.String LAYOUT_PROPERTY_HEIGHT = "height";
    private static final java.lang.String LAYOUT_PROPERTY_PADDING_LEFT = "padding-left";
    private static final java.lang.String LAYOUT_PROPERTY_PADDING_RIGHT = "padding-right";
    private static final java.lang.String LAYOUT_PROPERTY_WIDTH = "width";
    private static final java.lang.String PERSPECTIVE = "perspective";
    private static final java.lang.String TRANSFORM_ORIGIN = "transformOrigin";
    private static final java.util.Map<java.lang.String, com.alibaba.android.bindingx.plugin.weex.IWXViewUpdater> sTransformPropertyUpdaterMap;
    private static final com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.LayoutUpdater sLayoutUpdater = new com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.LayoutUpdater();
    private static final java.lang.String LAYOUT_PROPERTY_MARGIN_LEFT = "margin-left";
    private static final java.lang.String LAYOUT_PROPERTY_MARGIN_RIGHT = "margin-right";
    private static final java.lang.String LAYOUT_PROPERTY_MARGIN_TOP = "margin-top";
    private static final java.lang.String LAYOUT_PROPERTY_MARGIN_BOTTOM = "margin-bottom";
    private static final java.lang.String LAYOUT_PROPERTY_PADDING_TOP = "padding-top";
    private static final java.lang.String LAYOUT_PROPERTY_PADDING_BOTTOM = "padding-bottom";
    private static final java.util.List<java.lang.String> LAYOUT_PROPERTIES = java.util.Arrays.asList("width", "height", LAYOUT_PROPERTY_MARGIN_LEFT, LAYOUT_PROPERTY_MARGIN_RIGHT, LAYOUT_PROPERTY_MARGIN_TOP, LAYOUT_PROPERTY_MARGIN_BOTTOM, "padding-left", "padding-right", LAYOUT_PROPERTY_PADDING_TOP, LAYOUT_PROPERTY_PADDING_BOTTOM);
    private static final android.os.Handler sUIHandler = new android.os.Handler(android.os.Looper.getMainLooper());

    WXViewUpdateService() {
    }

    static {
        EMPTY_INVOKER = new com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.NOpUpdater();
        java.util.HashMap map = new java.util.HashMap();
        sTransformPropertyUpdaterMap = map;
        map.put("opacity", new com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.OpacityUpdater());
        map.put("transform.translate", new com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.TranslateUpdater());
        map.put("transform.translateX", new com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.TranslateXUpdater());
        map.put("transform.translateY", new com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.TranslateYUpdater());
        map.put("transform.scale", new com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.ScaleUpdater());
        map.put("transform.scaleX", new com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.ScaleXUpdater());
        map.put("transform.scaleY", new com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.ScaleYUpdater());
        map.put("transform.rotate", new com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.RotateUpdater());
        map.put("transform.rotateZ", new com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.RotateUpdater());
        map.put("transform.rotateX", new com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.RotateXUpdater());
        map.put("transform.rotateY", new com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.RotateYUpdater());
        map.put("background-color", new com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.BackgroundUpdater());
        map.put("color", new com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.ColorUpdater());
        map.put("scroll.contentOffset", new com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.ContentOffsetUpdater());
        map.put("scroll.contentOffsetX", new com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.ContentOffsetXUpdater());
        map.put("scroll.contentOffsetY", new com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.ContentOffsetYUpdater());
        map.put("border-top-left-radius", new com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.BorderRadiusTopLeftUpdater());
        map.put("border-top-right-radius", new com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.BorderRadiusTopRightUpdater());
        map.put("border-bottom-left-radius", new com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.BorderRadiusBottomLeftUpdater());
        map.put("border-bottom-right-radius", new com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.BorderRadiusBottomRightUpdater());
        map.put("border-radius", new com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.BorderRadiusUpdater());
    }

    static com.alibaba.android.bindingx.plugin.weex.IWXViewUpdater findUpdater(java.lang.String str) {
        com.alibaba.android.bindingx.plugin.weex.IWXViewUpdater iWXViewUpdater = sTransformPropertyUpdaterMap.get(str);
        if (iWXViewUpdater != null) {
            return iWXViewUpdater;
        }
        if (LAYOUT_PROPERTIES.contains(str)) {
            com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.LayoutUpdater layoutUpdater = sLayoutUpdater;
            layoutUpdater.setPropertyName(str);
            return layoutUpdater;
        }
        com.alibaba.android.bindingx.core.LogProxy.e("unknown property [" + str + com.taobao.weex.el.parse.Operators.ARRAY_END_STR);
        return EMPTY_INVOKER;
    }

    private static final class NOpUpdater implements com.alibaba.android.bindingx.plugin.weex.IWXViewUpdater {
        @Override // com.alibaba.android.bindingx.plugin.weex.IWXViewUpdater
        public void update(com.taobao.weex.ui.component.WXComponent wXComponent, android.view.View view, java.lang.Object obj, com.alibaba.android.bindingx.core.PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator, java.util.Map<java.lang.String, java.lang.Object> map) {
        }

        private NOpUpdater() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void runOnUIThread(java.lang.Runnable runnable) {
        sUIHandler.post(new com.alibaba.android.bindingx.core.WeakRunnable(runnable));
    }

    public static void clearCallbacks() {
        sUIHandler.removeCallbacksAndMessages(null);
    }

    private static final class ContentOffsetUpdater implements com.alibaba.android.bindingx.plugin.weex.IWXViewUpdater {
        private ContentOffsetUpdater() {
        }

        @Override // com.alibaba.android.bindingx.plugin.weex.IWXViewUpdater
        public void update(com.taobao.weex.ui.component.WXComponent wXComponent, android.view.View view, java.lang.Object obj, final com.alibaba.android.bindingx.core.PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator, java.util.Map<java.lang.String, java.lang.Object> map) {
            final android.view.View viewFindScrollTarget = com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.findScrollTarget(wXComponent);
            if (viewFindScrollTarget == null) {
                return;
            }
            if (obj instanceof java.lang.Double) {
                final double dDoubleValue = ((java.lang.Double) obj).doubleValue();
                com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.runOnUIThread(new java.lang.Runnable() { // from class: com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.ContentOffsetUpdater.1
                    @Override // java.lang.Runnable
                    public void run() {
                        viewFindScrollTarget.setScrollX((int) com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.getRealSize(dDoubleValue, iDeviceResolutionTranslator));
                        viewFindScrollTarget.setScrollY((int) com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.getRealSize(dDoubleValue, iDeviceResolutionTranslator));
                    }
                });
            } else if (obj instanceof java.util.ArrayList) {
                java.util.ArrayList arrayList = (java.util.ArrayList) obj;
                if (arrayList.size() >= 2 && (arrayList.get(0) instanceof java.lang.Double) && (arrayList.get(1) instanceof java.lang.Double)) {
                    final double dDoubleValue2 = ((java.lang.Double) arrayList.get(0)).doubleValue();
                    final double dDoubleValue3 = ((java.lang.Double) arrayList.get(1)).doubleValue();
                    com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.runOnUIThread(new java.lang.Runnable() { // from class: com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.ContentOffsetUpdater.2
                        @Override // java.lang.Runnable
                        public void run() {
                            viewFindScrollTarget.setScrollX((int) com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.getRealSize(dDoubleValue2, iDeviceResolutionTranslator));
                            viewFindScrollTarget.setScrollY((int) com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.getRealSize(dDoubleValue3, iDeviceResolutionTranslator));
                        }
                    });
                }
            }
        }
    }

    private static final class ContentOffsetXUpdater implements com.alibaba.android.bindingx.plugin.weex.IWXViewUpdater {
        private ContentOffsetXUpdater() {
        }

        @Override // com.alibaba.android.bindingx.plugin.weex.IWXViewUpdater
        public void update(com.taobao.weex.ui.component.WXComponent wXComponent, android.view.View view, java.lang.Object obj, final com.alibaba.android.bindingx.core.PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator, java.util.Map<java.lang.String, java.lang.Object> map) {
            final android.view.View viewFindScrollTarget = com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.findScrollTarget(wXComponent);
            if (viewFindScrollTarget != null && (obj instanceof java.lang.Double)) {
                final double dDoubleValue = ((java.lang.Double) obj).doubleValue();
                com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.runOnUIThread(new java.lang.Runnable() { // from class: com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.ContentOffsetXUpdater.1
                    @Override // java.lang.Runnable
                    public void run() {
                        viewFindScrollTarget.setScrollX((int) com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.getRealSize(dDoubleValue, iDeviceResolutionTranslator));
                    }
                });
            }
        }
    }

    private static final class ContentOffsetYUpdater implements com.alibaba.android.bindingx.plugin.weex.IWXViewUpdater {
        private ContentOffsetYUpdater() {
        }

        @Override // com.alibaba.android.bindingx.plugin.weex.IWXViewUpdater
        public void update(com.taobao.weex.ui.component.WXComponent wXComponent, android.view.View view, java.lang.Object obj, final com.alibaba.android.bindingx.core.PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator, java.util.Map<java.lang.String, java.lang.Object> map) {
            final android.view.View viewFindScrollTarget;
            if ((obj instanceof java.lang.Double) && (viewFindScrollTarget = com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.findScrollTarget(wXComponent)) != null) {
                final double dDoubleValue = ((java.lang.Double) obj).doubleValue();
                com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.runOnUIThread(new java.lang.Runnable() { // from class: com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.ContentOffsetYUpdater.1
                    @Override // java.lang.Runnable
                    public void run() {
                        viewFindScrollTarget.setScrollY((int) com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.getRealSize(dDoubleValue, iDeviceResolutionTranslator));
                    }
                });
            }
        }
    }

    private static final class OpacityUpdater implements com.alibaba.android.bindingx.plugin.weex.IWXViewUpdater {
        private OpacityUpdater() {
        }

        @Override // com.alibaba.android.bindingx.plugin.weex.IWXViewUpdater
        public void update(com.taobao.weex.ui.component.WXComponent wXComponent, final android.view.View view, java.lang.Object obj, com.alibaba.android.bindingx.core.PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator, java.util.Map<java.lang.String, java.lang.Object> map) {
            if (obj instanceof java.lang.Double) {
                final float fDoubleValue = (float) ((java.lang.Double) obj).doubleValue();
                com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.runOnUIThread(new java.lang.Runnable() { // from class: com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.OpacityUpdater.1
                    @Override // java.lang.Runnable
                    public void run() {
                        view.setAlpha(fDoubleValue);
                    }
                });
            }
        }
    }

    private static final class TranslateUpdater implements com.alibaba.android.bindingx.plugin.weex.IWXViewUpdater {
        private TranslateUpdater() {
        }

        @Override // com.alibaba.android.bindingx.plugin.weex.IWXViewUpdater
        public void update(com.taobao.weex.ui.component.WXComponent wXComponent, final android.view.View view, java.lang.Object obj, final com.alibaba.android.bindingx.core.PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator, java.util.Map<java.lang.String, java.lang.Object> map) {
            if (obj instanceof java.util.ArrayList) {
                java.util.ArrayList arrayList = (java.util.ArrayList) obj;
                if (arrayList.size() >= 2 && (arrayList.get(0) instanceof java.lang.Double) && (arrayList.get(1) instanceof java.lang.Double)) {
                    final double dDoubleValue = ((java.lang.Double) arrayList.get(0)).doubleValue();
                    final double dDoubleValue2 = ((java.lang.Double) arrayList.get(1)).doubleValue();
                    com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.runOnUIThread(new java.lang.Runnable() { // from class: com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.TranslateUpdater.1
                        @Override // java.lang.Runnable
                        public void run() {
                            view.setTranslationX((float) com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.getRealSize(dDoubleValue, iDeviceResolutionTranslator));
                            view.setTranslationY((float) com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.getRealSize(dDoubleValue2, iDeviceResolutionTranslator));
                        }
                    });
                }
            }
        }
    }

    private static final class TranslateXUpdater implements com.alibaba.android.bindingx.plugin.weex.IWXViewUpdater {
        private TranslateXUpdater() {
        }

        @Override // com.alibaba.android.bindingx.plugin.weex.IWXViewUpdater
        public void update(com.taobao.weex.ui.component.WXComponent wXComponent, final android.view.View view, java.lang.Object obj, final com.alibaba.android.bindingx.core.PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator, java.util.Map<java.lang.String, java.lang.Object> map) {
            if (obj instanceof java.lang.Double) {
                final double dDoubleValue = ((java.lang.Double) obj).doubleValue();
                com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.runOnUIThread(new java.lang.Runnable() { // from class: com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.TranslateXUpdater.1
                    @Override // java.lang.Runnable
                    public void run() {
                        view.setTranslationX((float) com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.getRealSize(dDoubleValue, iDeviceResolutionTranslator));
                    }
                });
            }
        }
    }

    private static final class TranslateYUpdater implements com.alibaba.android.bindingx.plugin.weex.IWXViewUpdater {
        private TranslateYUpdater() {
        }

        @Override // com.alibaba.android.bindingx.plugin.weex.IWXViewUpdater
        public void update(com.taobao.weex.ui.component.WXComponent wXComponent, final android.view.View view, java.lang.Object obj, final com.alibaba.android.bindingx.core.PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator, java.util.Map<java.lang.String, java.lang.Object> map) {
            if (obj instanceof java.lang.Double) {
                final double dDoubleValue = ((java.lang.Double) obj).doubleValue();
                com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.runOnUIThread(new java.lang.Runnable() { // from class: com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.TranslateYUpdater.1
                    @Override // java.lang.Runnable
                    public void run() {
                        view.setTranslationY((float) com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.getRealSize(dDoubleValue, iDeviceResolutionTranslator));
                    }
                });
            }
        }
    }

    private static final class ScaleUpdater implements com.alibaba.android.bindingx.plugin.weex.IWXViewUpdater {
        private ScaleUpdater() {
        }

        @Override // com.alibaba.android.bindingx.plugin.weex.IWXViewUpdater
        public void update(com.taobao.weex.ui.component.WXComponent wXComponent, final android.view.View view, final java.lang.Object obj, com.alibaba.android.bindingx.core.PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator, final java.util.Map<java.lang.String, java.lang.Object> map) {
            com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.runOnUIThread(new java.lang.Runnable() { // from class: com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.ScaleUpdater.1
                @Override // java.lang.Runnable
                public void run() {
                    int iNormalizedPerspectiveValue = com.alibaba.android.bindingx.core.internal.Utils.normalizedPerspectiveValue(view.getContext(), com.taobao.weex.utils.WXUtils.getInt(map.get("perspective")));
                    android.util.Pair<java.lang.Float, java.lang.Float> transformOrigin = com.alibaba.android.bindingx.core.internal.Utils.parseTransformOrigin(com.taobao.weex.utils.WXUtils.getString(map.get("transformOrigin"), null), view);
                    if (iNormalizedPerspectiveValue != 0) {
                        view.setCameraDistance(iNormalizedPerspectiveValue);
                    }
                    if (transformOrigin != null) {
                        view.setPivotX(((java.lang.Float) transformOrigin.first).floatValue());
                        view.setPivotY(((java.lang.Float) transformOrigin.second).floatValue());
                    }
                    java.lang.Object obj2 = obj;
                    if (obj2 instanceof java.lang.Double) {
                        float fDoubleValue = (float) ((java.lang.Double) obj2).doubleValue();
                        view.setScaleX(fDoubleValue);
                        view.setScaleY(fDoubleValue);
                        return;
                    }
                    if (obj2 instanceof java.util.ArrayList) {
                        java.util.ArrayList arrayList = (java.util.ArrayList) obj2;
                        if (arrayList.size() >= 2 && (arrayList.get(0) instanceof java.lang.Double) && (arrayList.get(1) instanceof java.lang.Double)) {
                            double dDoubleValue = ((java.lang.Double) arrayList.get(0)).doubleValue();
                            double dDoubleValue2 = ((java.lang.Double) arrayList.get(1)).doubleValue();
                            view.setScaleX((float) dDoubleValue);
                            view.setScaleY((float) dDoubleValue2);
                        }
                    }
                }
            });
        }
    }

    private static final class ScaleXUpdater implements com.alibaba.android.bindingx.plugin.weex.IWXViewUpdater {
        private ScaleXUpdater() {
        }

        @Override // com.alibaba.android.bindingx.plugin.weex.IWXViewUpdater
        public void update(com.taobao.weex.ui.component.WXComponent wXComponent, final android.view.View view, final java.lang.Object obj, com.alibaba.android.bindingx.core.PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator, final java.util.Map<java.lang.String, java.lang.Object> map) {
            if (obj instanceof java.lang.Double) {
                com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.runOnUIThread(new java.lang.Runnable() { // from class: com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.ScaleXUpdater.1
                    @Override // java.lang.Runnable
                    public void run() {
                        android.util.Pair<java.lang.Float, java.lang.Float> transformOrigin = com.alibaba.android.bindingx.core.internal.Utils.parseTransformOrigin(com.taobao.weex.utils.WXUtils.getString(map.get("transformOrigin"), null), view);
                        if (transformOrigin != null) {
                            view.setPivotX(((java.lang.Float) transformOrigin.first).floatValue());
                            view.setPivotY(((java.lang.Float) transformOrigin.second).floatValue());
                        }
                        view.setScaleX((float) ((java.lang.Double) obj).doubleValue());
                    }
                });
            }
        }
    }

    private static final class ScaleYUpdater implements com.alibaba.android.bindingx.plugin.weex.IWXViewUpdater {
        private ScaleYUpdater() {
        }

        @Override // com.alibaba.android.bindingx.plugin.weex.IWXViewUpdater
        public void update(com.taobao.weex.ui.component.WXComponent wXComponent, final android.view.View view, final java.lang.Object obj, com.alibaba.android.bindingx.core.PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator, final java.util.Map<java.lang.String, java.lang.Object> map) {
            if (obj instanceof java.lang.Double) {
                com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.runOnUIThread(new java.lang.Runnable() { // from class: com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.ScaleYUpdater.1
                    @Override // java.lang.Runnable
                    public void run() {
                        android.util.Pair<java.lang.Float, java.lang.Float> transformOrigin = com.alibaba.android.bindingx.core.internal.Utils.parseTransformOrigin(com.taobao.weex.utils.WXUtils.getString(map.get("transformOrigin"), null), view);
                        if (transformOrigin != null) {
                            view.setPivotX(((java.lang.Float) transformOrigin.first).floatValue());
                            view.setPivotY(((java.lang.Float) transformOrigin.second).floatValue());
                        }
                        view.setScaleY((float) ((java.lang.Double) obj).doubleValue());
                    }
                });
            }
        }
    }

    private static final class RotateUpdater implements com.alibaba.android.bindingx.plugin.weex.IWXViewUpdater {
        private RotateUpdater() {
        }

        @Override // com.alibaba.android.bindingx.plugin.weex.IWXViewUpdater
        public void update(com.taobao.weex.ui.component.WXComponent wXComponent, final android.view.View view, final java.lang.Object obj, com.alibaba.android.bindingx.core.PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator, final java.util.Map<java.lang.String, java.lang.Object> map) {
            if (obj instanceof java.lang.Double) {
                com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.runOnUIThread(new java.lang.Runnable() { // from class: com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.RotateUpdater.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int iNormalizedPerspectiveValue = com.alibaba.android.bindingx.core.internal.Utils.normalizedPerspectiveValue(view.getContext(), com.taobao.weex.utils.WXUtils.getInt(map.get("perspective")));
                        android.util.Pair<java.lang.Float, java.lang.Float> transformOrigin = com.alibaba.android.bindingx.core.internal.Utils.parseTransformOrigin(com.taobao.weex.utils.WXUtils.getString(map.get("transformOrigin"), null), view);
                        if (iNormalizedPerspectiveValue != 0) {
                            view.setCameraDistance(iNormalizedPerspectiveValue);
                        }
                        if (transformOrigin != null) {
                            view.setPivotX(((java.lang.Float) transformOrigin.first).floatValue());
                            view.setPivotY(((java.lang.Float) transformOrigin.second).floatValue());
                        }
                        view.setRotation((float) ((java.lang.Double) obj).doubleValue());
                    }
                });
            }
        }
    }

    private static final class RotateXUpdater implements com.alibaba.android.bindingx.plugin.weex.IWXViewUpdater {
        private RotateXUpdater() {
        }

        @Override // com.alibaba.android.bindingx.plugin.weex.IWXViewUpdater
        public void update(com.taobao.weex.ui.component.WXComponent wXComponent, final android.view.View view, final java.lang.Object obj, com.alibaba.android.bindingx.core.PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator, final java.util.Map<java.lang.String, java.lang.Object> map) {
            if (obj instanceof java.lang.Double) {
                com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.runOnUIThread(new java.lang.Runnable() { // from class: com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.RotateXUpdater.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int iNormalizedPerspectiveValue = com.alibaba.android.bindingx.core.internal.Utils.normalizedPerspectiveValue(view.getContext(), com.taobao.weex.utils.WXUtils.getInt(map.get("perspective")));
                        android.util.Pair<java.lang.Float, java.lang.Float> transformOrigin = com.alibaba.android.bindingx.core.internal.Utils.parseTransformOrigin(com.taobao.weex.utils.WXUtils.getString(map.get("transformOrigin"), null), view);
                        if (iNormalizedPerspectiveValue != 0) {
                            view.setCameraDistance(iNormalizedPerspectiveValue);
                        }
                        if (transformOrigin != null) {
                            view.setPivotX(((java.lang.Float) transformOrigin.first).floatValue());
                            view.setPivotY(((java.lang.Float) transformOrigin.second).floatValue());
                        }
                        view.setRotationX((float) ((java.lang.Double) obj).doubleValue());
                    }
                });
            }
        }
    }

    private static final class RotateYUpdater implements com.alibaba.android.bindingx.plugin.weex.IWXViewUpdater {
        private RotateYUpdater() {
        }

        @Override // com.alibaba.android.bindingx.plugin.weex.IWXViewUpdater
        public void update(com.taobao.weex.ui.component.WXComponent wXComponent, final android.view.View view, final java.lang.Object obj, com.alibaba.android.bindingx.core.PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator, final java.util.Map<java.lang.String, java.lang.Object> map) {
            if (obj instanceof java.lang.Double) {
                com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.runOnUIThread(new java.lang.Runnable() { // from class: com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.RotateYUpdater.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int iNormalizedPerspectiveValue = com.alibaba.android.bindingx.core.internal.Utils.normalizedPerspectiveValue(view.getContext(), com.taobao.weex.utils.WXUtils.getInt(map.get("perspective")));
                        android.util.Pair<java.lang.Float, java.lang.Float> transformOrigin = com.alibaba.android.bindingx.core.internal.Utils.parseTransformOrigin(com.taobao.weex.utils.WXUtils.getString(map.get("transformOrigin"), null), view);
                        if (iNormalizedPerspectiveValue != 0) {
                            view.setCameraDistance(iNormalizedPerspectiveValue);
                        }
                        if (transformOrigin != null) {
                            view.setPivotX(((java.lang.Float) transformOrigin.first).floatValue());
                            view.setPivotY(((java.lang.Float) transformOrigin.second).floatValue());
                        }
                        view.setRotationY((float) ((java.lang.Double) obj).doubleValue());
                    }
                });
            }
        }
    }

    static final class LayoutUpdater implements com.alibaba.android.bindingx.plugin.weex.IWXViewUpdater {
        private java.lang.String propertyName;

        LayoutUpdater() {
        }

        void setPropertyName(java.lang.String str) {
            this.propertyName = str;
        }

        @Override // com.alibaba.android.bindingx.plugin.weex.IWXViewUpdater
        public void update(com.taobao.weex.ui.component.WXComponent wXComponent, android.view.View view, java.lang.Object obj, com.alibaba.android.bindingx.core.PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator, java.util.Map<java.lang.String, java.lang.Object> map) {
            if (!(obj instanceof java.lang.Double) || android.text.TextUtils.isEmpty(this.propertyName)) {
                return;
            }
            double dDoubleValue = ((java.lang.Double) obj).doubleValue();
            java.lang.String str = this.propertyName;
            str.hashCode();
            java.lang.String str2 = "width";
            switch (str) {
                case "padding-top":
                    str2 = com.taobao.weex.common.Constants.Name.PADDING_TOP;
                    break;
                case "height":
                    str2 = "height";
                    break;
                case "margin-right":
                    str2 = com.taobao.weex.common.Constants.Name.MARGIN_RIGHT;
                    break;
                case "padding-right":
                    str2 = com.taobao.weex.common.Constants.Name.PADDING_RIGHT;
                    break;
                case "width":
                    break;
                case "padding-bottom":
                    str2 = com.taobao.weex.common.Constants.Name.PADDING_BOTTOM;
                    break;
                case "padding-left":
                    str2 = com.taobao.weex.common.Constants.Name.PADDING_LEFT;
                    break;
                case "margin-left":
                    str2 = com.taobao.weex.common.Constants.Name.MARGIN_LEFT;
                    break;
                case "margin-top":
                    str2 = com.taobao.weex.common.Constants.Name.MARGIN_TOP;
                    break;
                case "margin-bottom":
                    str2 = com.taobao.weex.common.Constants.Name.MARGIN_BOTTOM;
                    break;
                default:
                    str2 = null;
                    break;
            }
            if (android.text.TextUtils.isEmpty(str2)) {
                return;
            }
            com.taobao.weex.dom.transition.WXTransition.asynchronouslyUpdateLayout(wXComponent, str2, (float) com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.getRealSize(dDoubleValue, iDeviceResolutionTranslator));
            this.propertyName = null;
        }
    }

    private static final class BackgroundUpdater implements com.alibaba.android.bindingx.plugin.weex.IWXViewUpdater {
        private BackgroundUpdater() {
        }

        @Override // com.alibaba.android.bindingx.plugin.weex.IWXViewUpdater
        public void update(com.taobao.weex.ui.component.WXComponent wXComponent, final android.view.View view, java.lang.Object obj, com.alibaba.android.bindingx.core.PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator, java.util.Map<java.lang.String, java.lang.Object> map) {
            if (obj instanceof java.lang.Integer) {
                final int iIntValue = ((java.lang.Integer) obj).intValue();
                com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.runOnUIThread(new java.lang.Runnable() { // from class: com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.BackgroundUpdater.1
                    @Override // java.lang.Runnable
                    public void run() {
                        android.graphics.drawable.Drawable background = view.getBackground();
                        if (background == null) {
                            view.setBackgroundColor(iIntValue);
                        } else if (background instanceof com.taobao.weex.ui.view.border.BorderDrawable) {
                            ((com.taobao.weex.ui.view.border.BorderDrawable) background).setColor(iIntValue);
                        } else if (background instanceof android.graphics.drawable.ColorDrawable) {
                            ((android.graphics.drawable.ColorDrawable) background).setColor(iIntValue);
                        }
                    }
                });
            }
        }
    }

    private static final class ColorUpdater implements com.alibaba.android.bindingx.plugin.weex.IWXViewUpdater {
        private ColorUpdater() {
        }

        @Override // com.alibaba.android.bindingx.plugin.weex.IWXViewUpdater
        public void update(final com.taobao.weex.ui.component.WXComponent wXComponent, final android.view.View view, java.lang.Object obj, com.alibaba.android.bindingx.core.PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator, java.util.Map<java.lang.String, java.lang.Object> map) {
            if (obj instanceof java.lang.Integer) {
                final int iIntValue = ((java.lang.Integer) obj).intValue();
                com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.runOnUIThread(new java.lang.Runnable() { // from class: com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.ColorUpdater.1
                    @Override // java.lang.Runnable
                    public void run() {
                        android.view.View view2 = view;
                        if (view2 instanceof android.widget.TextView) {
                            ((android.widget.TextView) view2).setTextColor(iIntValue);
                            return;
                        }
                        if ((wXComponent instanceof com.taobao.weex.ui.component.WXText) && (view2 instanceof com.taobao.weex.ui.view.WXTextView)) {
                            try {
                                ((com.taobao.weex.ui.view.WXTextView) view2).setTextColor(iIntValue);
                                view.invalidate();
                            } catch (java.lang.Throwable th) {
                                com.alibaba.android.bindingx.core.LogProxy.e("can not update text color, try fallback to call the old API", th);
                                android.text.Layout textLayout = ((com.taobao.weex.ui.view.WXTextView) view).getTextLayout();
                                if (textLayout != null) {
                                    android.text.TextPaint paint = textLayout.getPaint();
                                    if (paint != null) {
                                        paint.setColor(iIntValue);
                                    }
                                    view.invalidate();
                                }
                            }
                        }
                    }
                });
            }
        }
    }

    private static final class BorderRadiusTopLeftUpdater implements com.alibaba.android.bindingx.plugin.weex.IWXViewUpdater {
        private BorderRadiusTopLeftUpdater() {
        }

        @Override // com.alibaba.android.bindingx.plugin.weex.IWXViewUpdater
        public void update(com.taobao.weex.ui.component.WXComponent wXComponent, final android.view.View view, java.lang.Object obj, final com.alibaba.android.bindingx.core.PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator, java.util.Map<java.lang.String, java.lang.Object> map) {
            if (obj instanceof java.lang.Double) {
                final double dDoubleValue = ((java.lang.Double) obj).doubleValue();
                com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.runOnUIThread(new java.lang.Runnable() { // from class: com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.BorderRadiusTopLeftUpdater.1
                    @Override // java.lang.Runnable
                    public void run() {
                        android.graphics.drawable.Drawable background = view.getBackground();
                        if (background == null || !(background instanceof com.taobao.weex.ui.view.border.BorderDrawable)) {
                            return;
                        }
                        ((com.taobao.weex.ui.view.border.BorderDrawable) background).setBorderRadius(com.taobao.weex.dom.CSSShorthand.CORNER.BORDER_TOP_LEFT, (float) com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.getRealSize(dDoubleValue, iDeviceResolutionTranslator));
                    }
                });
            }
        }
    }

    private static final class BorderRadiusTopRightUpdater implements com.alibaba.android.bindingx.plugin.weex.IWXViewUpdater {
        private BorderRadiusTopRightUpdater() {
        }

        @Override // com.alibaba.android.bindingx.plugin.weex.IWXViewUpdater
        public void update(com.taobao.weex.ui.component.WXComponent wXComponent, final android.view.View view, java.lang.Object obj, final com.alibaba.android.bindingx.core.PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator, java.util.Map<java.lang.String, java.lang.Object> map) {
            if (obj instanceof java.lang.Double) {
                final double dDoubleValue = ((java.lang.Double) obj).doubleValue();
                com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.runOnUIThread(new java.lang.Runnable() { // from class: com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.BorderRadiusTopRightUpdater.1
                    @Override // java.lang.Runnable
                    public void run() {
                        android.graphics.drawable.Drawable background = view.getBackground();
                        if (background == null || !(background instanceof com.taobao.weex.ui.view.border.BorderDrawable)) {
                            return;
                        }
                        ((com.taobao.weex.ui.view.border.BorderDrawable) background).setBorderRadius(com.taobao.weex.dom.CSSShorthand.CORNER.BORDER_TOP_RIGHT, (float) com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.getRealSize(dDoubleValue, iDeviceResolutionTranslator));
                    }
                });
            }
        }
    }

    private static final class BorderRadiusBottomLeftUpdater implements com.alibaba.android.bindingx.plugin.weex.IWXViewUpdater {
        private BorderRadiusBottomLeftUpdater() {
        }

        @Override // com.alibaba.android.bindingx.plugin.weex.IWXViewUpdater
        public void update(com.taobao.weex.ui.component.WXComponent wXComponent, final android.view.View view, java.lang.Object obj, final com.alibaba.android.bindingx.core.PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator, java.util.Map<java.lang.String, java.lang.Object> map) {
            if (obj instanceof java.lang.Double) {
                final double dDoubleValue = ((java.lang.Double) obj).doubleValue();
                com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.runOnUIThread(new java.lang.Runnable() { // from class: com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.BorderRadiusBottomLeftUpdater.1
                    @Override // java.lang.Runnable
                    public void run() {
                        android.graphics.drawable.Drawable background = view.getBackground();
                        if (background == null || !(background instanceof com.taobao.weex.ui.view.border.BorderDrawable)) {
                            return;
                        }
                        ((com.taobao.weex.ui.view.border.BorderDrawable) background).setBorderRadius(com.taobao.weex.dom.CSSShorthand.CORNER.BORDER_BOTTOM_LEFT, (float) com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.getRealSize(dDoubleValue, iDeviceResolutionTranslator));
                    }
                });
            }
        }
    }

    private static final class BorderRadiusBottomRightUpdater implements com.alibaba.android.bindingx.plugin.weex.IWXViewUpdater {
        private BorderRadiusBottomRightUpdater() {
        }

        @Override // com.alibaba.android.bindingx.plugin.weex.IWXViewUpdater
        public void update(com.taobao.weex.ui.component.WXComponent wXComponent, final android.view.View view, java.lang.Object obj, final com.alibaba.android.bindingx.core.PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator, java.util.Map<java.lang.String, java.lang.Object> map) {
            if (obj instanceof java.lang.Double) {
                final double dDoubleValue = ((java.lang.Double) obj).doubleValue();
                com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.runOnUIThread(new java.lang.Runnable() { // from class: com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.BorderRadiusBottomRightUpdater.1
                    @Override // java.lang.Runnable
                    public void run() {
                        android.graphics.drawable.Drawable background = view.getBackground();
                        if (background == null || !(background instanceof com.taobao.weex.ui.view.border.BorderDrawable)) {
                            return;
                        }
                        ((com.taobao.weex.ui.view.border.BorderDrawable) background).setBorderRadius(com.taobao.weex.dom.CSSShorthand.CORNER.BORDER_BOTTOM_RIGHT, (float) com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.getRealSize(dDoubleValue, iDeviceResolutionTranslator));
                    }
                });
            }
        }
    }

    private static final class BorderRadiusUpdater implements com.alibaba.android.bindingx.plugin.weex.IWXViewUpdater {
        private BorderRadiusUpdater() {
        }

        @Override // com.alibaba.android.bindingx.plugin.weex.IWXViewUpdater
        public void update(com.taobao.weex.ui.component.WXComponent wXComponent, final android.view.View view, java.lang.Object obj, final com.alibaba.android.bindingx.core.PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator, java.util.Map<java.lang.String, java.lang.Object> map) {
            if (obj instanceof java.util.ArrayList) {
                final java.util.ArrayList arrayList = (java.util.ArrayList) obj;
                if (arrayList.size() != 4) {
                    return;
                }
                com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.runOnUIThread(new java.lang.Runnable() { // from class: com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.BorderRadiusUpdater.1
                    @Override // java.lang.Runnable
                    public void run() {
                        android.graphics.drawable.Drawable background = view.getBackground();
                        if (background == null || !(background instanceof com.taobao.weex.ui.view.border.BorderDrawable)) {
                            return;
                        }
                        double dDoubleValue = arrayList.get(0) instanceof java.lang.Double ? ((java.lang.Double) arrayList.get(0)).doubleValue() : 0.0d;
                        double dDoubleValue2 = arrayList.get(1) instanceof java.lang.Double ? ((java.lang.Double) arrayList.get(1)).doubleValue() : 0.0d;
                        double dDoubleValue3 = arrayList.get(2) instanceof java.lang.Double ? ((java.lang.Double) arrayList.get(2)).doubleValue() : 0.0d;
                        double dDoubleValue4 = arrayList.get(3) instanceof java.lang.Double ? ((java.lang.Double) arrayList.get(3)).doubleValue() : 0.0d;
                        com.taobao.weex.ui.view.border.BorderDrawable borderDrawable = (com.taobao.weex.ui.view.border.BorderDrawable) background;
                        borderDrawable.setBorderRadius(com.taobao.weex.dom.CSSShorthand.CORNER.BORDER_TOP_LEFT, (float) com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.getRealSize(dDoubleValue, iDeviceResolutionTranslator));
                        borderDrawable.setBorderRadius(com.taobao.weex.dom.CSSShorthand.CORNER.BORDER_TOP_RIGHT, (float) com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.getRealSize(dDoubleValue2, iDeviceResolutionTranslator));
                        borderDrawable.setBorderRadius(com.taobao.weex.dom.CSSShorthand.CORNER.BORDER_BOTTOM_LEFT, (float) com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.getRealSize(dDoubleValue3, iDeviceResolutionTranslator));
                        borderDrawable.setBorderRadius(com.taobao.weex.dom.CSSShorthand.CORNER.BORDER_BOTTOM_RIGHT, (float) com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.getRealSize(dDoubleValue4, iDeviceResolutionTranslator));
                    }
                });
                return;
            }
            if (obj instanceof java.lang.Double) {
                final double dDoubleValue = ((java.lang.Double) obj).doubleValue();
                com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.runOnUIThread(new java.lang.Runnable() { // from class: com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.BorderRadiusUpdater.2
                    @Override // java.lang.Runnable
                    public void run() {
                        android.graphics.drawable.Drawable background = view.getBackground();
                        if (background == null || !(background instanceof com.taobao.weex.ui.view.border.BorderDrawable)) {
                            return;
                        }
                        com.taobao.weex.ui.view.border.BorderDrawable borderDrawable = (com.taobao.weex.ui.view.border.BorderDrawable) background;
                        borderDrawable.setBorderRadius(com.taobao.weex.dom.CSSShorthand.CORNER.BORDER_TOP_LEFT, (float) com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.getRealSize(dDoubleValue, iDeviceResolutionTranslator));
                        borderDrawable.setBorderRadius(com.taobao.weex.dom.CSSShorthand.CORNER.BORDER_TOP_RIGHT, (float) com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.getRealSize(dDoubleValue, iDeviceResolutionTranslator));
                        borderDrawable.setBorderRadius(com.taobao.weex.dom.CSSShorthand.CORNER.BORDER_BOTTOM_LEFT, (float) com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.getRealSize(dDoubleValue, iDeviceResolutionTranslator));
                        borderDrawable.setBorderRadius(com.taobao.weex.dom.CSSShorthand.CORNER.BORDER_BOTTOM_RIGHT, (float) com.alibaba.android.bindingx.plugin.weex.WXViewUpdateService.getRealSize(dDoubleValue, iDeviceResolutionTranslator));
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double getRealSize(double d, com.alibaba.android.bindingx.core.PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator) {
        return iDeviceResolutionTranslator.webToNative(d, new java.lang.Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static android.view.View findScrollTarget(com.taobao.weex.ui.component.WXComponent wXComponent) {
        if (!(wXComponent instanceof com.taobao.weex.ui.component.WXScroller)) {
            com.alibaba.android.bindingx.core.LogProxy.e("scroll offset only support on Scroller Component");
            return null;
        }
        return ((com.taobao.weex.ui.component.WXScroller) wXComponent).getInnerView();
    }
}
