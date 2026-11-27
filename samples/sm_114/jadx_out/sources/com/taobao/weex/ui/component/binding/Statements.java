package com.taobao.weex.ui.component.binding;

/* JADX INFO: loaded from: classes.dex */
public class Statements {
    private static final java.lang.ThreadLocal<java.util.Map<java.lang.String, java.lang.Object>> dynamicLocal = new java.lang.ThreadLocal<>();

    public static void parseStatementsToken(com.taobao.weex.ui.component.WXComponent wXComponent) {
        if (wXComponent.getBasicComponentData().isRenderPtrEmpty()) {
            wXComponent.getBasicComponentData().setRenderObjectPr(wXComponent.getRenderObjectPtr());
        }
        if (wXComponent.getBasicComponentData() != null) {
            com.taobao.weex.ui.action.BasicComponentData basicComponentData = wXComponent.getBasicComponentData();
            basicComponentData.getAttrs().parseStatements();
            basicComponentData.getStyles().parseStatements();
            basicComponentData.getEvents().parseStatements();
        }
        if (wXComponent instanceof com.taobao.weex.ui.component.WXVContainer) {
            com.taobao.weex.ui.component.WXVContainer wXVContainer = (com.taobao.weex.ui.component.WXVContainer) wXComponent;
            int childCount = wXVContainer.getChildCount();
            for (int i = 0; i < childCount; i++) {
                parseStatementsToken(wXVContainer.getChild(i));
            }
        }
    }

    public static void initLazyComponent(com.taobao.weex.ui.component.WXComponent wXComponent, com.taobao.weex.ui.component.WXVContainer wXVContainer) {
        if (wXComponent.isLazy() || wXComponent.getHostView() == null) {
            wXComponent.lazy(false);
            if (wXVContainer != null) {
                wXVContainer.createChildViewAt(wXVContainer.indexOf(wXComponent));
            } else {
                wXComponent.createView();
            }
            wXComponent.applyLayoutAndEvent(wXComponent);
            wXComponent.bindData(wXComponent);
        }
    }

    public static com.taobao.weex.ui.component.WXComponent copyComponentTree(com.taobao.weex.ui.component.WXComponent wXComponent) {
        return copyComponentTree(wXComponent, wXComponent.getParent());
    }

    private static final com.taobao.weex.ui.component.WXComponent copyComponentTree(com.taobao.weex.ui.component.WXComponent wXComponent, com.taobao.weex.ui.component.WXVContainer wXVContainer) {
        com.taobao.weex.ui.action.BasicComponentData basicComponentDataMo403clone;
        try {
            basicComponentDataMo403clone = wXComponent.getBasicComponentData().mo403clone();
        } catch (java.lang.CloneNotSupportedException e) {
            e.printStackTrace();
            basicComponentDataMo403clone = null;
        }
        com.taobao.weex.ui.component.WXComponent wXComponentNewInstance = com.taobao.weex.ui.component.WXComponentFactory.newInstance(wXComponent.getInstance(), wXVContainer, basicComponentDataMo403clone);
        com.taobao.weex.ui.action.GraphicPosition layoutPosition = wXComponent.getLayoutPosition();
        com.taobao.weex.ui.action.GraphicSize layoutSize = wXComponent.getLayoutSize();
        wXComponentNewInstance.updateDemission(layoutPosition.getTop(), layoutPosition.getBottom(), layoutPosition.getLeft(), layoutPosition.getRight(), layoutSize.getHeight(), layoutSize.getWidth());
        wXComponentNewInstance.updateExtra(wXComponent.getExtra());
        if (wXComponent instanceof com.taobao.weex.ui.component.WXVContainer) {
            com.taobao.weex.ui.component.WXVContainer wXVContainer2 = (com.taobao.weex.ui.component.WXVContainer) wXComponent;
            com.taobao.weex.ui.component.WXVContainer wXVContainer3 = (com.taobao.weex.ui.component.WXVContainer) wXComponentNewInstance;
            int childCount = wXVContainer2.getChildCount();
            for (int i = 0; i < childCount; i++) {
                com.taobao.weex.ui.component.WXComponent child = wXVContainer2.getChild(i);
                if (child != null) {
                    com.taobao.weex.ui.component.WXComponent wXComponentCopyComponentTree = copyComponentTree(child, wXVContainer3);
                    wXVContainer3.addChild(wXComponentCopyComponentTree);
                    com.taobao.weex.ui.component.list.template.jni.NativeRenderObjectUtils.nativeAddChildRenderObject(wXVContainer3.getRenderObjectPtr(), wXComponentCopyComponentTree.getRenderObjectPtr());
                }
            }
        }
        if (wXComponent.isWaste()) {
            wXComponentNewInstance.setWaste(true);
        }
        return wXComponentNewInstance;
    }

    public static final java.util.List<com.taobao.weex.ui.component.WXComponent> doRender(com.taobao.weex.ui.component.WXComponent wXComponent, com.taobao.weex.ui.component.list.template.CellRenderContext cellRenderContext) {
        java.util.ArrayList arrayList = new java.util.ArrayList(4);
        try {
            doRenderComponent(wXComponent, cellRenderContext, arrayList);
            return arrayList;
        } catch (java.lang.Exception e) {
            com.taobao.weex.utils.WXLogUtils.e("WeexStatementRender", e);
            return arrayList;
        }
    }

    public static final void doInitCompontent(java.util.List<com.taobao.weex.ui.component.WXComponent> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        for (com.taobao.weex.ui.component.WXComponent wXComponent : list) {
            if (wXComponent.getParent() == null) {
                throw new java.lang.IllegalArgumentException("render node parent cann't find");
            }
            com.taobao.weex.ui.component.WXVContainer parent = wXComponent.getParent();
            int iIndexOf = parent.indexOf(wXComponent);
            if (iIndexOf < 0) {
                throw new java.lang.IllegalArgumentException("render node cann't find");
            }
            parent.createChildViewAt(iIndexOf);
            wXComponent.applyLayoutAndEvent(wXComponent);
            wXComponent.bindData(wXComponent);
        }
    }

    /* JADX WARN: Code duplicated, block: B:87:0x01ec  */
    private static final int doRenderComponent(com.taobao.weex.ui.component.WXComponent wXComponent, com.taobao.weex.ui.component.list.template.CellRenderContext cellRenderContext, java.util.List<com.taobao.weex.ui.component.WXComponent> list) {
        int i;
        java.util.Collection collectionKeySet;
        java.util.Map map;
        java.lang.Object obj;
        boolean z;
        com.taobao.weex.ui.component.WXComponent wXComponentCopyComponentTree;
        java.util.Map map2;
        java.lang.String str;
        int i2;
        com.taobao.weex.ui.component.WXVContainer parent = wXComponent.getParent();
        com.taobao.weex.dom.binding.WXStatement statement = wXComponent.getAttrs().getStatement();
        if (statement == null) {
            i = 1;
        } else {
            com.taobao.weex.el.parse.Token token = statement.get(com.taobao.weex.dom.binding.WXStatement.WX_IF) instanceof com.taobao.weex.el.parse.Token ? (com.taobao.weex.el.parse.Token) statement.get(com.taobao.weex.dom.binding.WXStatement.WX_IF) : null;
            java.lang.String str2 = com.taobao.weex.dom.binding.WXStatement.WX_FOR;
            com.alibaba.fastjson.JSONObject jSONObject = statement.get(com.taobao.weex.dom.binding.WXStatement.WX_FOR) instanceof com.alibaba.fastjson.JSONObject ? (com.alibaba.fastjson.JSONObject) statement.get(com.taobao.weex.dom.binding.WXStatement.WX_FOR) : null;
            if (jSONObject != null) {
                int iIndexOf = parent.indexOf(wXComponent);
                if (jSONObject.get(com.taobao.weex.dom.binding.WXStatement.WX_FOR_LIST) instanceof com.taobao.weex.el.parse.Token) {
                    com.taobao.weex.el.parse.Token token2 = (com.taobao.weex.el.parse.Token) jSONObject.get(com.taobao.weex.dom.binding.WXStatement.WX_FOR_LIST);
                    java.lang.String string = jSONObject.getString(com.taobao.weex.dom.binding.WXStatement.WX_FOR_INDEX);
                    java.lang.String string2 = jSONObject.getString(com.taobao.weex.dom.binding.WXStatement.WX_FOR_ITEM);
                    java.lang.Object objExecute = token2 != null ? token2.execute(cellRenderContext.stack) : null;
                    boolean z2 = objExecute instanceof java.util.List;
                    if (z2 || (objExecute instanceof java.util.Map)) {
                        if (z2) {
                            collectionKeySet = (java.util.List) objExecute;
                            map = null;
                        } else {
                            java.util.Map map3 = (java.util.Map) objExecute;
                            collectionKeySet = map3.keySet();
                            map = map3;
                        }
                        java.util.HashMap map4 = new java.util.HashMap();
                        int i3 = 0;
                        for (java.lang.Object obj2 : collectionKeySet) {
                            if (map == null) {
                                java.lang.Integer numValueOf = java.lang.Integer.valueOf(i3);
                                i3++;
                                obj = obj2;
                                obj2 = numValueOf;
                            } else {
                                obj = map.get(obj2);
                            }
                            i3 = i3;
                            if (string != null) {
                                map4.put(string, obj2);
                            }
                            if (string2 != null) {
                                map4.put(string2, obj);
                            } else {
                                cellRenderContext.stack.push(obj);
                            }
                            if (map4.size() > 0) {
                                cellRenderContext.stack.push(map4);
                            }
                            if (token == null || com.taobao.weex.el.parse.Operators.isTrue(token.execute(cellRenderContext.stack))) {
                                if (iIndexOf < parent.getChildCount()) {
                                    wXComponentCopyComponentTree = parent.getChild(iIndexOf);
                                    if (!isCreateFromNodeStatement(wXComponentCopyComponentTree, wXComponent)) {
                                        wXComponentCopyComponentTree = null;
                                    }
                                    if (wXComponentCopyComponentTree == null || !wXComponentCopyComponentTree.isWaste()) {
                                        z = false;
                                    } else {
                                        z = false;
                                        wXComponentCopyComponentTree.setWaste(false);
                                    }
                                } else {
                                    z = false;
                                    wXComponentCopyComponentTree = null;
                                }
                                if (wXComponentCopyComponentTree == null) {
                                    long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
                                    wXComponentCopyComponentTree = copyComponentTree(wXComponent, parent);
                                    wXComponentCopyComponentTree.setWaste(z);
                                    if (wXComponentCopyComponentTree.getAttrs().getStatement() != null) {
                                        wXComponentCopyComponentTree.getAttrs().getStatement().remove(str2);
                                        wXComponentCopyComponentTree.getAttrs().getStatement().remove(com.taobao.weex.dom.binding.WXStatement.WX_IF);
                                    }
                                    parent.addChild(wXComponentCopyComponentTree, iIndexOf);
                                    map2 = map;
                                    str = str2;
                                    i2 = iIndexOf;
                                    com.taobao.weex.ui.component.list.template.jni.NativeRenderObjectUtils.nativeAddChildRenderObject(parent.getRenderObjectPtr(), wXComponentCopyComponentTree.getRenderObjectPtr());
                                    list.add(wXComponentCopyComponentTree);
                                    if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
                                        com.taobao.weex.utils.WXLogUtils.d(com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList.TAG, java.lang.Thread.currentThread().getName() + wXComponentCopyComponentTree.getRef() + wXComponentCopyComponentTree.getComponentType() + "statements copy component tree used " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
                                    }
                                } else {
                                    map2 = map;
                                    str = str2;
                                    i2 = iIndexOf;
                                }
                                doBindingAttrsEventAndRenderChildNode(wXComponentCopyComponentTree, cellRenderContext, list);
                                iIndexOf = i2 + 1;
                                if (map4.size() > 0) {
                                    cellRenderContext.stack.push(map4);
                                }
                                if (string2 == null) {
                                    cellRenderContext.stack.pop();
                                }
                                map = map2;
                                str2 = str;
                            }
                        }
                    }
                } else {
                    com.taobao.weex.utils.WXLogUtils.e(com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList.TAG, jSONObject.toJSONString() + " not call vfor block, for pre compile");
                }
                while (iIndexOf < parent.getChildCount()) {
                    com.taobao.weex.ui.component.WXComponent child = parent.getChild(iIndexOf);
                    if (!isCreateFromNodeStatement(child, wXComponent)) {
                        break;
                    }
                    child.setWaste(true);
                    iIndexOf++;
                }
                return iIndexOf - parent.indexOf(wXComponent);
            }
            if (token == null) {
                i = 1;
            } else {
                if (!com.taobao.weex.el.parse.Operators.isTrue(token.execute(cellRenderContext.stack))) {
                    wXComponent.setWaste(true);
                    return 1;
                }
                i = 1;
                wXComponent.setWaste(false);
            }
        }
        doBindingAttrsEventAndRenderChildNode(wXComponent, cellRenderContext, list);
        return i;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0152  */
    private static void doBindingAttrsEventAndRenderChildNode(com.taobao.weex.ui.component.WXComponent wXComponent, com.taobao.weex.ui.component.list.template.CellRenderContext cellRenderContext, java.util.List<com.taobao.weex.ui.component.WXComponent> list) {
        char c;
        char c2;
        java.lang.String str;
        boolean z;
        java.lang.Object objRenderProps;
        java.lang.Object obj;
        boolean z2;
        java.lang.Object obj2;
        com.taobao.weex.dom.WXAttr attrs = wXComponent.getAttrs();
        com.taobao.weex.el.parse.ArrayStack arrayStack = cellRenderContext.stack;
        if (attrs.get(com.taobao.weex.dom.binding.ELUtils.IS_COMPONENT_ROOT) == null || !com.taobao.weex.utils.WXUtils.getBoolean(attrs.get(com.taobao.weex.dom.binding.ELUtils.IS_COMPONENT_ROOT), false).booleanValue() || attrs.get(com.taobao.weex.dom.binding.ELUtils.COMPONENT_PROPS) == null || !com.taobao.weex.dom.binding.JSONUtils.isJSON(attrs.get(com.taobao.weex.dom.binding.ELUtils.COMPONENT_PROPS))) {
            c = 3;
            c2 = 0;
            str = null;
            z = false;
        } else {
            java.lang.String str2 = (java.lang.String) attrs.get(com.taobao.weex.ui.component.list.template.CellDataManager.SUB_COMPONENT_TEMPLATE_ID);
            if (!android.text.TextUtils.isEmpty(str2)) {
                java.lang.String strCreateVirtualComponentId = cellRenderContext.getRenderState().getVirtualComponentIds().get(wXComponent.getViewTreeKey());
                if (strCreateVirtualComponentId == null) {
                    c = 3;
                    c2 = 0;
                    strCreateVirtualComponentId = com.taobao.weex.ui.component.list.template.CellDataManager.createVirtualComponentId(cellRenderContext.templateList.getRef(), wXComponent.getViewTreeKey(), cellRenderContext.templateList.getItemId(cellRenderContext.position));
                    java.util.Map<java.lang.String, java.lang.Object> mapRenderProps = renderProps(com.taobao.weex.dom.binding.JSONUtils.toJSON(attrs.get(com.taobao.weex.dom.binding.ELUtils.COMPONENT_PROPS)), cellRenderContext.stack);
                    com.taobao.weex.bridge.EventResult eventResultSyncCallJSEventWithResult = com.taobao.weex.bridge.WXBridgeManager.getInstance().syncCallJSEventWithResult(com.taobao.weex.bridge.WXBridgeManager.METHD_COMPONENT_HOOK_SYNC, wXComponent.getInstanceId(), null, str2, com.taobao.weex.ui.component.list.template.VirtualComponentLifecycle.LIFECYCLE, "create", new java.lang.Object[]{strCreateVirtualComponentId, mapRenderProps}, null);
                    if (eventResultSyncCallJSEventWithResult != null && eventResultSyncCallJSEventWithResult.getResult() != null && (eventResultSyncCallJSEventWithResult.getResult() instanceof java.util.Map)) {
                        mapRenderProps.putAll((java.util.Map) eventResultSyncCallJSEventWithResult.getResult());
                    }
                    cellRenderContext.getRenderState().getVirtualComponentIds().put(wXComponent.getViewTreeKey(), strCreateVirtualComponentId);
                    cellRenderContext.templateList.getCellDataManager().createVirtualComponentData(cellRenderContext.position, strCreateVirtualComponentId, mapRenderProps);
                    z2 = true;
                    obj2 = mapRenderProps;
                } else {
                    c = 3;
                    c2 = 0;
                    java.lang.Object obj3 = cellRenderContext.getRenderState().getVirtualComponentDatas().get(strCreateVirtualComponentId);
                    if (cellRenderContext.getRenderState().isHasDataUpdate()) {
                        java.util.Map<java.lang.String, java.lang.Object> mapRenderProps2 = renderProps((com.alibaba.fastjson.JSONObject) attrs.get(com.taobao.weex.dom.binding.ELUtils.COMPONENT_PROPS), cellRenderContext.stack);
                        com.taobao.weex.bridge.EventResult eventResultSyncCallJSEventWithResult2 = com.taobao.weex.bridge.WXBridgeManager.getInstance().syncCallJSEventWithResult(com.taobao.weex.bridge.WXBridgeManager.METHD_COMPONENT_HOOK_SYNC, wXComponent.getInstanceId(), null, strCreateVirtualComponentId, com.taobao.weex.ui.component.list.template.VirtualComponentLifecycle.LIFECYCLE, com.taobao.weex.ui.component.list.template.VirtualComponentLifecycle.SYNSTATE, new java.lang.Object[]{strCreateVirtualComponentId, mapRenderProps2}, null);
                        if (eventResultSyncCallJSEventWithResult2 == null || eventResultSyncCallJSEventWithResult2.getResult() == null || !(eventResultSyncCallJSEventWithResult2.getResult() instanceof java.util.Map)) {
                            obj = obj3;
                        } else {
                            mapRenderProps2.putAll((java.util.Map) eventResultSyncCallJSEventWithResult2.getResult());
                            cellRenderContext.templateList.getCellDataManager().updateVirtualComponentData(strCreateVirtualComponentId, mapRenderProps2);
                            obj = mapRenderProps2;
                        }
                    } else {
                        obj = obj3;
                    }
                    z2 = false;
                    obj2 = obj;
                }
                wXComponent.getAttrs().put(com.taobao.weex.ui.component.list.template.CellDataManager.VIRTUAL_COMPONENT_ID, (java.lang.Object) strCreateVirtualComponentId);
                z = z2;
                str = strCreateVirtualComponentId;
                objRenderProps = obj2;
            } else {
                c = 3;
                c2 = 0;
                str = null;
                z = false;
                objRenderProps = renderProps((com.alibaba.fastjson.JSONObject) attrs.get(com.taobao.weex.dom.binding.ELUtils.COMPONENT_PROPS), cellRenderContext.stack);
            }
            cellRenderContext.stack = new com.taobao.weex.el.parse.ArrayStack();
            if (objRenderProps != null) {
                cellRenderContext.stack.push(objRenderProps);
            }
        }
        if ((attrs.getStatement() != null ? attrs.getStatement().get(com.taobao.weex.dom.binding.WXStatement.WX_ONCE) : null) != null) {
            com.taobao.weex.el.parse.ArrayStack arrayStackCopyStack = cellRenderContext.getRenderState().getOnceComponentStates().get(wXComponent.getViewTreeKey());
            if (arrayStackCopyStack == null) {
                arrayStackCopyStack = cellRenderContext.templateList.copyStack(cellRenderContext, arrayStack);
                cellRenderContext.getRenderState().getOnceComponentStates().put(wXComponent.getViewTreeKey(), arrayStackCopyStack);
            }
            cellRenderContext.stack = arrayStackCopyStack;
        }
        doRenderBindingAttrsAndEvent(wXComponent, cellRenderContext);
        if (wXComponent instanceof com.taobao.weex.ui.component.WXVContainer) {
            if (wXComponent.isWaste() && !(wXComponent instanceof com.taobao.weex.ui.component.list.WXCell)) {
                return;
            }
            com.taobao.weex.ui.component.WXVContainer wXVContainer = (com.taobao.weex.ui.component.WXVContainer) wXComponent;
            int iDoRenderComponent = 0;
            while (iDoRenderComponent < wXVContainer.getChildCount()) {
                iDoRenderComponent += doRenderComponent(wXVContainer.getChild(iDoRenderComponent), cellRenderContext, list);
            }
        }
        if (arrayStack != cellRenderContext.stack) {
            cellRenderContext.stack = arrayStack;
        }
        if (!z || str == null) {
            return;
        }
        com.taobao.weex.bridge.WXBridgeManager wXBridgeManager = com.taobao.weex.bridge.WXBridgeManager.getInstance();
        java.lang.String instanceId = wXComponent.getInstanceId();
        java.lang.Object[] objArr = new java.lang.Object[1];
        objArr[c2] = com.taobao.weex.ui.component.list.template.TemplateDom.findAllComponentRefs(cellRenderContext.templateList.getRef(), cellRenderContext.position, wXComponent);
        java.lang.Object[] objArr2 = new java.lang.Object[4];
        objArr2[c2] = str;
        objArr2[1] = com.taobao.weex.ui.component.list.template.VirtualComponentLifecycle.LIFECYCLE;
        objArr2[2] = "attach";
        objArr2[c] = objArr;
        wXBridgeManager.asyncCallJSEventVoidResult(com.taobao.weex.bridge.WXBridgeManager.METHD_COMPONENT_HOOK_SYNC, instanceId, null, objArr2);
    }

    private static boolean isCreateFromNodeStatement(com.taobao.weex.ui.component.WXComponent wXComponent, com.taobao.weex.ui.component.WXComponent wXComponent2) {
        return wXComponent.getRef() != null && wXComponent.getRef().equals(wXComponent2.getRef());
    }

    private static void doRenderBindingAttrsAndEvent(com.taobao.weex.ui.component.WXComponent wXComponent, com.taobao.weex.ui.component.list.template.CellRenderContext cellRenderContext) {
        com.taobao.weex.el.parse.ArrayStack arrayStack = cellRenderContext.stack;
        wXComponent.setWaste(false);
        com.taobao.weex.dom.WXAttr attrs = wXComponent.getAttrs();
        if (attrs != null && attrs.getBindingAttrs() != null && attrs.getBindingAttrs().size() > 0) {
            java.util.Map<java.lang.String, java.lang.Object> mapRenderBindingAttrs = renderBindingAttrs(wXComponent.getAttrs().getBindingAttrs(), arrayStack);
            java.util.Iterator<java.util.Map.Entry<java.lang.String, java.lang.Object>> it = mapRenderBindingAttrs.entrySet().iterator();
            while (it.hasNext()) {
                java.util.Map.Entry<java.lang.String, java.lang.Object> next = it.next();
                java.lang.String key = next.getKey();
                java.lang.Object value = next.getValue();
                java.lang.Object obj = attrs.get(key);
                if (value == null) {
                    if (obj == null) {
                        it.remove();
                    }
                } else if (value.equals(obj)) {
                    it.remove();
                }
            }
            if (mapRenderBindingAttrs.size() > 0) {
                if (mapRenderBindingAttrs.size() == 1 && mapRenderBindingAttrs.get("src") != null && (wXComponent instanceof com.taobao.weex.ui.component.WXImage)) {
                    wXComponent.getAttrs().put("src", mapRenderBindingAttrs.get("src"));
                } else {
                    wXComponent.nativeUpdateAttrs(mapRenderBindingAttrs);
                }
                if (isMainThread()) {
                    wXComponent.updateProperties(mapRenderBindingAttrs);
                }
                mapRenderBindingAttrs.clear();
            }
        }
        com.taobao.weex.dom.WXStyle styles = wXComponent.getStyles();
        if (styles != null && styles.getBindingStyle() != null) {
            java.util.Map<java.lang.String, java.lang.Object> mapRenderBindingAttrs2 = renderBindingAttrs(styles.getBindingStyle(), arrayStack);
            java.util.Iterator<java.util.Map.Entry<java.lang.String, java.lang.Object>> it2 = mapRenderBindingAttrs2.entrySet().iterator();
            while (it2.hasNext()) {
                java.util.Map.Entry<java.lang.String, java.lang.Object> next2 = it2.next();
                java.lang.String key2 = next2.getKey();
                java.lang.Object value2 = next2.getValue();
                java.lang.Object obj2 = styles.get(key2);
                if (value2 == null) {
                    if (obj2 == null) {
                        it2.remove();
                    }
                } else if (value2.equals(obj2)) {
                    it2.remove();
                }
            }
            if (mapRenderBindingAttrs2.size() > 0) {
                wXComponent.updateNativeStyles(mapRenderBindingAttrs2);
                if (isMainThread()) {
                    wXComponent.updateProperties(mapRenderBindingAttrs2);
                }
            }
        }
        com.taobao.weex.dom.WXEvent events = wXComponent.getEvents();
        if (events == null || events.getEventBindingArgs() == null) {
            return;
        }
        for (java.util.Map.Entry entry : events.getEventBindingArgs().entrySet()) {
            java.util.List<java.lang.Object> bindingEventArgs = getBindingEventArgs(arrayStack, entry.getValue());
            if (bindingEventArgs != null) {
                events.putEventBindingArgsValue((java.lang.String) entry.getKey(), bindingEventArgs);
            }
        }
    }

    public static java.util.Map<java.lang.String, java.lang.Object> renderBindingAttrs(androidx.collection.ArrayMap arrayMap, com.taobao.weex.el.parse.ArrayStack arrayStack) {
        java.util.Set<java.util.Map.Entry> setEntrySet = arrayMap.entrySet();
        java.lang.ThreadLocal<java.util.Map<java.lang.String, java.lang.Object>> threadLocal = dynamicLocal;
        java.util.Map<java.lang.String, java.lang.Object> map = threadLocal.get();
        if (map == null) {
            map = new java.util.HashMap<>();
            threadLocal.set(map);
        }
        if (map.size() > 0) {
            map.clear();
        }
        for (java.util.Map.Entry entry : setEntrySet) {
            java.lang.Object value = entry.getValue();
            java.lang.String str = (java.lang.String) entry.getKey();
            if (value instanceof com.alibaba.fastjson.JSONObject) {
                com.alibaba.fastjson.JSONObject jSONObject = (com.alibaba.fastjson.JSONObject) value;
                if (jSONObject.get(com.taobao.weex.dom.binding.ELUtils.BINDING) instanceof com.taobao.weex.el.parse.Token) {
                    map.put(str, ((com.taobao.weex.el.parse.Token) jSONObject.get(com.taobao.weex.dom.binding.ELUtils.BINDING)).execute(arrayStack));
                }
            }
            if (value instanceof com.alibaba.fastjson.JSONArray) {
                com.alibaba.fastjson.JSONArray jSONArray = (com.alibaba.fastjson.JSONArray) value;
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                for (int i = 0; i < jSONArray.size(); i++) {
                    java.lang.Object obj = jSONArray.get(i);
                    if (obj instanceof java.lang.CharSequence) {
                        sb.append(obj);
                    } else if (obj instanceof com.alibaba.fastjson.JSONObject) {
                        com.alibaba.fastjson.JSONObject jSONObject2 = (com.alibaba.fastjson.JSONObject) obj;
                        if (jSONObject2.get(com.taobao.weex.dom.binding.ELUtils.BINDING) instanceof com.taobao.weex.el.parse.Token) {
                            java.lang.Object objExecute = ((com.taobao.weex.el.parse.Token) jSONObject2.get(com.taobao.weex.dom.binding.ELUtils.BINDING)).execute(arrayStack);
                            if (objExecute == null) {
                                objExecute = "";
                            }
                            sb.append(objExecute);
                        }
                    }
                }
                java.lang.String string = sb.toString();
                if (string.length() > 256 && com.taobao.weex.WXEnvironment.isApkDebugable()) {
                    com.taobao.weex.utils.WXLogUtils.w(com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList.TAG, " warn too big string " + string);
                }
                map.put(str, string);
            }
        }
        return map;
    }

    public static java.util.Map<java.lang.String, java.lang.Object> renderProps(com.alibaba.fastjson.JSONObject jSONObject, com.taobao.weex.el.parse.ArrayStack arrayStack) {
        java.util.Set<java.util.Map.Entry<java.lang.String, java.lang.Object>> setEntrySet = jSONObject.entrySet();
        androidx.collection.ArrayMap arrayMap = new androidx.collection.ArrayMap(4);
        for (java.util.Map.Entry<java.lang.String, java.lang.Object> entry : setEntrySet) {
            java.lang.Object value = entry.getValue();
            java.lang.String key = entry.getKey();
            if (value instanceof com.alibaba.fastjson.JSONObject) {
                com.alibaba.fastjson.JSONObject jSONObject2 = (com.alibaba.fastjson.JSONObject) value;
                if (jSONObject2.get(com.taobao.weex.dom.binding.ELUtils.BINDING) instanceof com.taobao.weex.el.parse.Token) {
                    arrayMap.put(key, ((com.taobao.weex.el.parse.Token) jSONObject2.get(com.taobao.weex.dom.binding.ELUtils.BINDING)).execute(arrayStack));
                }
            }
            arrayMap.put(key, value);
        }
        return arrayMap;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0036  */
    public static java.util.List<java.lang.Object> getBindingEventArgs(com.taobao.weex.el.parse.ArrayStack arrayStack, java.lang.Object obj) {
        java.util.ArrayList arrayList = new java.util.ArrayList(4);
        if (obj instanceof com.alibaba.fastjson.JSONArray) {
            com.alibaba.fastjson.JSONArray jSONArray = (com.alibaba.fastjson.JSONArray) obj;
            for (int i = 0; i < jSONArray.size(); i++) {
                java.lang.Object obj2 = jSONArray.get(i);
                if (obj2 instanceof com.alibaba.fastjson.JSONObject) {
                    com.alibaba.fastjson.JSONObject jSONObject = (com.alibaba.fastjson.JSONObject) obj2;
                    if (jSONObject.get(com.taobao.weex.dom.binding.ELUtils.BINDING) instanceof com.taobao.weex.el.parse.Token) {
                        arrayList.add(((com.taobao.weex.el.parse.Token) jSONObject.get(com.taobao.weex.dom.binding.ELUtils.BINDING)).execute(arrayStack));
                    } else {
                        arrayList.add(obj2);
                    }
                } else {
                    arrayList.add(obj2);
                }
            }
            return arrayList;
        }
        if (obj instanceof com.alibaba.fastjson.JSONObject) {
            com.alibaba.fastjson.JSONObject jSONObject2 = (com.alibaba.fastjson.JSONObject) obj;
            if (jSONObject2.get(com.taobao.weex.dom.binding.ELUtils.BINDING) instanceof com.taobao.weex.el.parse.Token) {
                arrayList.add(((com.taobao.weex.el.parse.Token) jSONObject2.get(com.taobao.weex.dom.binding.ELUtils.BINDING)).execute(arrayStack));
                return arrayList;
            }
            arrayList.add(obj.toString());
            return arrayList;
        }
        arrayList.add(obj.toString());
        return arrayList;
    }

    private static boolean isMainThread() {
        return java.lang.Thread.currentThread() == android.os.Looper.getMainLooper().getThread();
    }

    public static java.lang.String getComponentId(com.taobao.weex.ui.component.WXComponent wXComponent) {
        if ((wXComponent instanceof com.taobao.weex.ui.component.list.WXCell) || wXComponent == null) {
            return null;
        }
        com.taobao.weex.dom.WXAttr attrs = wXComponent.getAttrs();
        if (attrs.get(com.taobao.weex.dom.binding.ELUtils.IS_COMPONENT_ROOT) != null && com.taobao.weex.utils.WXUtils.getBoolean(attrs.get(com.taobao.weex.dom.binding.ELUtils.IS_COMPONENT_ROOT), false).booleanValue() && attrs.get(com.taobao.weex.dom.binding.ELUtils.COMPONENT_PROPS) != null && (attrs.get(com.taobao.weex.dom.binding.ELUtils.COMPONENT_PROPS) instanceof com.alibaba.fastjson.JSONObject)) {
            java.lang.Object obj = attrs.get(com.taobao.weex.ui.component.list.template.CellDataManager.VIRTUAL_COMPONENT_ID);
            if (obj == null) {
                return null;
            }
            return obj.toString();
        }
        return getComponentId(wXComponent.getParent());
    }
}
