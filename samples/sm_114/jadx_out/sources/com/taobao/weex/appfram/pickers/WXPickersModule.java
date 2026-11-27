package com.taobao.weex.appfram.pickers;

/* JADX INFO: loaded from: classes.dex */
public class WXPickersModule extends com.taobao.weex.common.WXModule {
    private static final java.lang.String CANCEL = "cancel";
    private static final java.lang.String DATA = "data";
    private static final java.lang.String ERROR = "error";
    private static final java.lang.String KEY_CANCEL_TITLE = "cancelTitle";
    private static final java.lang.String KEY_CANCEL_TITLE_COLOR = "cancelTitleColor";
    private static final java.lang.String KEY_CONFIRM_TITLE = "confirmTitle";
    private static final java.lang.String KEY_CONFIRM_TITLE_COLOR = "confirmTitleColor";
    private static final java.lang.String KEY_INDEX = "index";
    private static final java.lang.String KEY_ITEMS = "items";
    private static final java.lang.String KEY_MAX = "max";
    private static final java.lang.String KEY_MIN = "min";
    private static final java.lang.String KEY_SELECTION_COLOR = "selectionColor";
    private static final java.lang.String KEY_TEXT_COLOR = "textColor";
    private static final java.lang.String KEY_TITLE = "title";
    private static final java.lang.String KEY_TITLE_BACKGROUND_COLOR = "titleBackgroundColor";
    private static final java.lang.String KEY_TITLE_COLOR = "titleColor";
    private static final java.lang.String KEY_VALUE = "value";
    private static final java.lang.String RESULT = "result";
    private static final java.lang.String SUCCESS = "success";
    private int selected;

    @com.taobao.weex.annotation.JSMethod
    public void pick(java.util.Map<java.lang.String, java.lang.Object> map, com.taobao.weex.bridge.JSCallback jSCallback) {
        try {
            performSinglePick(safeConvert((java.util.List) getOption(map, KEY_ITEMS, new java.util.ArrayList())), map, jSCallback);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @com.taobao.weex.annotation.JSMethod
    public void pickDate(java.util.Map<java.lang.String, java.lang.Object> map, com.taobao.weex.bridge.JSCallback jSCallback) {
        performPickDate(map, jSCallback);
    }

    @com.taobao.weex.annotation.JSMethod
    public void pickTime(java.util.Map<java.lang.String, java.lang.Object> map, com.taobao.weex.bridge.JSCallback jSCallback) {
        performPickTime(map, jSCallback);
    }

    private java.util.List<java.lang.String> safeConvert(java.util.List list) {
        java.util.ArrayList arrayList = new java.util.ArrayList(list.size());
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(java.lang.String.valueOf(it.next()));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> T getOption(java.util.Map<java.lang.String, java.lang.Object> map, java.lang.String str, T t) {
        T t2 = (T) map.get(str);
        return t2 == null ? t : t2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getColor(java.util.Map<java.lang.String, java.lang.Object> map, java.lang.String str, int i) {
        java.lang.Object option = getOption(map, str, null);
        return option == null ? i : com.taobao.weex.utils.WXResourceUtils.getColor(option.toString(), i);
    }

    private void performPickTime(java.util.Map<java.lang.String, java.lang.Object> map, final com.taobao.weex.bridge.JSCallback jSCallback) {
        com.taobao.weex.appfram.pickers.DatePickerImpl.pickTime(this.mWXSDKInstance.getContext(), (java.lang.String) getOption(map, "value", ""), new com.taobao.weex.appfram.pickers.DatePickerImpl.OnPickListener() { // from class: com.taobao.weex.appfram.pickers.WXPickersModule.1
            @Override // com.taobao.weex.appfram.pickers.DatePickerImpl.OnPickListener
            public void onPick(boolean z, java.lang.String str) {
                if (z) {
                    java.util.HashMap map2 = new java.util.HashMap(2);
                    map2.put("result", "success");
                    map2.put("data", str);
                    jSCallback.invoke(map2);
                    return;
                }
                java.util.HashMap map3 = new java.util.HashMap(2);
                map3.put("result", "cancel");
                map3.put("data", null);
                jSCallback.invoke(map3);
            }
        }, map);
    }

    private void performPickDate(java.util.Map<java.lang.String, java.lang.Object> map, final com.taobao.weex.bridge.JSCallback jSCallback) {
        com.taobao.weex.appfram.pickers.DatePickerImpl.pickDate(this.mWXSDKInstance.getContext(), (java.lang.String) getOption(map, "value", ""), (java.lang.String) getOption(map, "max", ""), (java.lang.String) getOption(map, "min", ""), new com.taobao.weex.appfram.pickers.DatePickerImpl.OnPickListener() { // from class: com.taobao.weex.appfram.pickers.WXPickersModule.2
            @Override // com.taobao.weex.appfram.pickers.DatePickerImpl.OnPickListener
            public void onPick(boolean z, java.lang.String str) {
                if (z) {
                    java.util.HashMap map2 = new java.util.HashMap(2);
                    map2.put("result", "success");
                    map2.put("data", str);
                    jSCallback.invoke(map2);
                    return;
                }
                java.util.HashMap map3 = new java.util.HashMap(2);
                map3.put("result", "cancel");
                map3.put("data", null);
                jSCallback.invoke(map3);
            }
        }, map);
    }

    private void performSinglePick(java.util.List<java.lang.String> list, final java.util.Map<java.lang.String, java.lang.Object> map, final com.taobao.weex.bridge.JSCallback jSCallback) {
        this.selected = ((java.lang.Integer) getOption(map, "index", 0)).intValue();
        final int color = getColor(map, KEY_TEXT_COLOR, 0);
        final int color2 = getColor(map, KEY_SELECTION_COLOR, 0);
        final android.widget.ArrayAdapter<java.lang.String> arrayAdapter = new android.widget.ArrayAdapter<java.lang.String>(this.mWXSDKInstance.getContext(), android.R.layout.simple_list_item_single_choice, list) { // from class: com.taobao.weex.appfram.pickers.WXPickersModule.3
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.widget.ArrayAdapter, android.widget.Adapter
            public android.view.View getView(int i, android.view.View view, android.view.ViewGroup viewGroup) {
                int i2;
                android.view.View view2 = super.getView(i, view, viewGroup);
                if (view2 != 0 && (view2 instanceof android.widget.Checkable)) {
                    boolean z = i == com.taobao.weex.appfram.pickers.WXPickersModule.this.selected;
                    ((android.widget.Checkable) view2).setChecked(z);
                    if (z) {
                        view2.setBackgroundColor(color2);
                    } else {
                        view2.setBackgroundColor(0);
                    }
                }
                if ((view2 instanceof android.widget.TextView) && (i2 = color) != 0) {
                    ((android.widget.TextView) view2).setTextColor(i2);
                }
                return view2;
            }
        };
        final android.app.AlertDialog alertDialogCreate = new android.app.AlertDialog.Builder(this.mWXSDKInstance.getContext()).setAdapter(arrayAdapter, null).setPositiveButton(android.R.string.ok, new android.content.DialogInterface.OnClickListener() { // from class: com.taobao.weex.appfram.pickers.WXPickersModule.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(android.content.DialogInterface dialogInterface, int i) {
                java.util.HashMap map2 = new java.util.HashMap(2);
                map2.put("result", "success");
                map2.put("data", java.lang.Integer.valueOf(com.taobao.weex.appfram.pickers.WXPickersModule.this.selected));
                jSCallback.invoke(map2);
            }
        }).setNegativeButton(android.R.string.cancel, new android.content.DialogInterface.OnClickListener() { // from class: com.taobao.weex.appfram.pickers.WXPickersModule.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(android.content.DialogInterface dialogInterface, int i) {
                java.util.HashMap map2 = new java.util.HashMap(2);
                map2.put("result", "cancel");
                map2.put("data", -1);
                jSCallback.invoke(map2);
            }
        }).setCustomTitle(makeTitleView(this.mWXSDKInstance.getContext(), map)).create();
        alertDialogCreate.create();
        alertDialogCreate.getListView().setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() { // from class: com.taobao.weex.appfram.pickers.WXPickersModule.6
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(android.widget.AdapterView<?> adapterView, android.view.View view, int i, long j) {
                com.taobao.weex.appfram.pickers.WXPickersModule.this.selected = i;
                arrayAdapter.notifyDataSetChanged();
            }
        });
        alertDialogCreate.getWindow().getDecorView().post(com.taobao.weex.common.WXThread.secure(new java.lang.Runnable() { // from class: com.taobao.weex.appfram.pickers.WXPickersModule.7
            @Override // java.lang.Runnable
            public void run() {
                android.widget.Button button = alertDialogCreate.getButton(-1);
                android.widget.Button button2 = alertDialogCreate.getButton(-2);
                if (button != null) {
                    java.lang.String str = (java.lang.String) com.taobao.weex.appfram.pickers.WXPickersModule.this.getOption(map, com.taobao.weex.appfram.pickers.WXPickersModule.KEY_CONFIRM_TITLE, null);
                    int color3 = com.taobao.weex.appfram.pickers.WXPickersModule.this.getColor(map, com.taobao.weex.appfram.pickers.WXPickersModule.KEY_CONFIRM_TITLE_COLOR, 0);
                    if (str != null) {
                        button.setText(str);
                        button.setAllCaps(false);
                    }
                    if (color3 != 0) {
                        button.setTextColor(color3);
                        button.setAllCaps(false);
                    }
                }
                if (button2 != null) {
                    java.lang.String str2 = (java.lang.String) com.taobao.weex.appfram.pickers.WXPickersModule.this.getOption(map, "cancelTitle", null);
                    int color4 = com.taobao.weex.appfram.pickers.WXPickersModule.this.getColor(map, com.taobao.weex.appfram.pickers.WXPickersModule.KEY_CANCEL_TITLE_COLOR, 0);
                    if (str2 != null) {
                        button2.setText(str2);
                    }
                    if (color4 != 0) {
                        button2.setTextColor(color4);
                    }
                }
            }
        }));
        alertDialogCreate.show();
    }

    private android.widget.TextView makeTitleView(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map) {
        java.lang.String str = (java.lang.String) getOption(map, "title", null);
        if (str == null) {
            return null;
        }
        android.widget.TextView textView = new android.widget.TextView(context);
        textView.setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, -2));
        textView.setTextSize(2, 20.0f);
        int iDip2px = com.taobao.weex.utils.WXViewUtils.dip2px(12.0f);
        textView.setPadding(iDip2px, iDip2px, iDip2px, iDip2px);
        textView.getPaint().setFakeBoldText(true);
        textView.setBackgroundColor(getColor(map, KEY_TITLE_BACKGROUND_COLOR, 0));
        textView.setTextColor(getColor(map, KEY_TITLE_COLOR, -16777216));
        textView.setText(str);
        return textView;
    }
}
