package io.dcloud.feature.gg.dcloud;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class ADResult {
    private java.lang.String d;
    private io.dcloud.p.u3 handler = (io.dcloud.p.u3) io.dcloud.p.r0.d().a();
    private io.dcloud.feature.gg.dcloud.IAolReceiver[] receivers;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static class CADReceiver implements io.dcloud.feature.gg.dcloud.IAolReceiver {
        private android.content.Context context;

        public CADReceiver(android.content.Context context) {
            this.context = context;
        }

        public void checkPromptData(org.json.JSONArray jSONArray) {
            try {
                if (jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        org.json.JSONObject jSONObject = jSONArray.getJSONObject(i);
                        if (jSONObject != null && jSONObject.length() > 0) {
                            if (jSONObject.optString("action").equals("prompt")) {
                                final java.lang.String strOptString = jSONObject.optString("onclose");
                                android.app.AlertDialog alertDialogCreate = new android.app.AlertDialog.Builder(this.context).setTitle(jSONObject.optString(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_TITLE)).setMessage(jSONObject.optString("message")).setCancelable(false).setPositiveButton(android.R.string.ok, new android.content.DialogInterface.OnClickListener() { // from class: io.dcloud.feature.gg.dcloud.ADResult.CADReceiver.2
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public void onClick(android.content.DialogInterface dialogInterface, int i2) {
                                        if (strOptString.equals(com.alibaba.android.bindingx.core.internal.BindingXConstants.STATE_EXIT)) {
                                            android.os.Process.killProcess(android.os.Process.myPid());
                                        } else {
                                            dialogInterface.dismiss();
                                        }
                                    }
                                }).create();
                                alertDialogCreate.setCanceledOnTouchOutside(false);
                                alertDialogCreate.show();
                            } else if (jSONObject.optString("action").equals("toast")) {
                                io.dcloud.p.g0 g0Var = new io.dcloud.p.g0((android.app.Activity) this.context, "");
                                android.widget.TextView textView = new android.widget.TextView(this.context);
                                textView.setAutoLinkMask(1);
                                textView.setClickable(true);
                                textView.setText(io.dcloud.p.a4.a(this.context).a(jSONObject.optString("message")));
                                android.widget.LinearLayout linearLayout = new android.widget.LinearLayout(this.context);
                                linearLayout.addView(textView);
                                g0Var.a(linearLayout, textView);
                                g0Var.setDuration(1);
                                g0Var.setGravity(80, g0Var.getXOffset(), g0Var.getYOffset());
                                int iDip2px = io.dcloud.common.adapter.util.CanvasHelper.dip2px(this.context, 10.0f);
                                int iDip2px2 = io.dcloud.common.adapter.util.CanvasHelper.dip2px(this.context, 8.0f);
                                linearLayout.setPadding(iDip2px, iDip2px2, iDip2px, iDip2px2);
                                android.graphics.drawable.GradientDrawable gradientDrawable = new android.graphics.drawable.GradientDrawable();
                                gradientDrawable.setCornerRadius(iDip2px2);
                                gradientDrawable.setShape(0);
                                gradientDrawable.setColor(-1308622848);
                                linearLayout.setBackground(gradientDrawable);
                                textView.setGravity(17);
                                textView.setTextColor(android.graphics.Color.parseColor("#ffffffff"));
                                g0Var.show();
                            }
                        }
                    }
                }
            } catch (java.lang.Exception unused) {
            }
        }

        @Override // io.dcloud.feature.gg.dcloud.IAolReceiver
        public void onError(java.lang.String str, java.lang.String str2) {
        }

        @Override // io.dcloud.feature.gg.dcloud.IAolReceiver
        public void onReceiver(org.json.JSONObject jSONObject) {
            final org.json.JSONArray jSONArrayOptJSONArray;
            if (!jSONObject.has("data") || (jSONArrayOptJSONArray = jSONObject.optJSONArray("data")) == null || jSONArrayOptJSONArray.length() <= 0) {
                return;
            }
            ((android.app.Activity) this.context).runOnUiThread(new java.lang.Runnable() { // from class: io.dcloud.feature.gg.dcloud.ADResult.CADReceiver.1
                @Override // java.lang.Runnable
                public void run() {
                    io.dcloud.feature.gg.dcloud.ADResult.CADReceiver.this.checkPromptData(jSONArrayOptJSONArray);
                }
            });
        }
    }

    public ADResult(io.dcloud.feature.gg.dcloud.IAolReceiver... iAolReceiverArr) {
        this.receivers = iAolReceiverArr;
    }

    private java.lang.String gd() {
        io.dcloud.common.DHInterface.IApp iApp = (io.dcloud.common.DHInterface.IApp) io.dcloud.EntryProxy.getInstnace().getCoreHandler().dispatchEvent(io.dcloud.common.DHInterface.IMgr.MgrType.AppMgr, 28, io.dcloud.common.util.BaseInfo.sDefaultBootApp);
        if (iApp != null) {
            android.app.Activity activity = iApp.getActivity();
            this.d = new org.json.JSONObject(this.handler.b(activity)).toString();
            this.receivers[0] = new io.dcloud.feature.gg.dcloud.ADHandler.ADReceiver(activity);
            this.receivers[1] = new io.dcloud.feature.gg.dcloud.ADResult.CADReceiver(activity);
            this.receivers[2] = new io.dcloud.feature.gg.dcloud.AolFeatureImpl.AdReceiver(activity, new java.lang.Object[]{null, null, ""}, iApp.obtainAppId());
        }
        return this.d;
    }

    public void cad(java.lang.String str) {
        if (this.receivers != null) {
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject(str);
                int iOptInt = jSONObject.optInt("ret", -1);
                if (iOptInt == 0) {
                    for (io.dcloud.feature.gg.dcloud.IAolReceiver iAolReceiver : this.receivers) {
                        if ((iAolReceiver instanceof io.dcloud.feature.gg.dcloud.ADResult.CADReceiver) || (iAolReceiver instanceof io.dcloud.feature.gg.dcloud.ADHandler.ADReceiver)) {
                            iAolReceiver.onReceiver(jSONObject);
                        }
                    }
                    return;
                }
                for (io.dcloud.feature.gg.dcloud.IAolReceiver iAolReceiver2 : this.receivers) {
                    if ((iAolReceiver2 instanceof io.dcloud.feature.gg.dcloud.ADResult.CADReceiver) || (iAolReceiver2 instanceof io.dcloud.feature.gg.dcloud.ADHandler.ADReceiver)) {
                        iAolReceiver2.onError(java.lang.String.valueOf(iOptInt), jSONObject.optString("desc"));
                    }
                }
            } catch (org.json.JSONException e) {
                for (io.dcloud.feature.gg.dcloud.IAolReceiver iAolReceiver3 : this.receivers) {
                    if ((iAolReceiver3 instanceof io.dcloud.feature.gg.dcloud.ADResult.CADReceiver) || (iAolReceiver3 instanceof io.dcloud.feature.gg.dcloud.ADHandler.ADReceiver)) {
                        iAolReceiver3.onError("Exception", e.getMessage());
                    }
                }
            }
        }
    }

    public void dc(java.lang.String str, int i, int i2) {
        io.dcloud.feature.gg.dcloud.IAolReceiver[] iAolReceiverArr = this.receivers;
        if (iAolReceiverArr != null) {
            int i3 = 0;
            if (i != 0) {
                int length = iAolReceiverArr.length;
                while (i3 < length) {
                    io.dcloud.feature.gg.dcloud.IAolReceiver iAolReceiver = iAolReceiverArr[i3];
                    if (!(iAolReceiver instanceof io.dcloud.feature.gg.dcloud.ADResult.CADReceiver)) {
                        iAolReceiver.onError("NotFountDataError", io.dcloud.common.constant.DOMException.MSG_NETWORK_ERROR);
                    }
                    i3++;
                }
                io.dcloud.p.u3 u3Var = this.handler;
                if (u3Var != null) {
                    u3Var.a(-5007, io.dcloud.common.constant.DOMException.MSG_NETWORK_ERROR);
                    return;
                }
                return;
            }
            if (i2 != 200) {
                int length2 = iAolReceiverArr.length;
                while (i3 < length2) {
                    io.dcloud.feature.gg.dcloud.IAolReceiver iAolReceiver2 = iAolReceiverArr[i3];
                    if (!(iAolReceiver2 instanceof io.dcloud.feature.gg.dcloud.ADResult.CADReceiver)) {
                        iAolReceiver2.onError("NotFountDataError", java.lang.String.valueOf(i2));
                    }
                    i3++;
                }
                io.dcloud.p.u3 u3Var2 = this.handler;
                if (u3Var2 != null) {
                    u3Var2.a(-5007, java.lang.String.valueOf(i2));
                    return;
                }
                return;
            }
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject(str);
                int iOptInt = jSONObject.optInt("ret", -1);
                if (iOptInt == 0) {
                    for (io.dcloud.feature.gg.dcloud.IAolReceiver iAolReceiver3 : this.receivers) {
                        if (!(iAolReceiver3 instanceof io.dcloud.feature.gg.dcloud.ADResult.CADReceiver)) {
                            io.dcloud.feature.gg.AolSplashUtil.decodeChannel(jSONObject.optJSONObject("data"));
                            iAolReceiver3.onReceiver(jSONObject);
                        }
                    }
                    io.dcloud.p.u3 u3Var3 = this.handler;
                    if (u3Var3 != null) {
                        u3Var3.a(jSONObject);
                        return;
                    }
                    return;
                }
                for (io.dcloud.feature.gg.dcloud.IAolReceiver iAolReceiver4 : this.receivers) {
                    if (!(iAolReceiver4 instanceof io.dcloud.feature.gg.dcloud.ADResult.CADReceiver)) {
                        iAolReceiver4.onError(java.lang.String.valueOf(iOptInt), jSONObject.optString("desc"));
                    }
                }
                io.dcloud.p.u3 u3Var4 = this.handler;
                if (u3Var4 != null) {
                    u3Var4.a(-5007, java.lang.String.valueOf(iOptInt) + ":" + jSONObject.optString("desc"));
                }
            } catch (java.lang.Exception e) {
                io.dcloud.feature.gg.dcloud.IAolReceiver[] iAolReceiverArr2 = this.receivers;
                int length3 = iAolReceiverArr2.length;
                while (i3 < length3) {
                    io.dcloud.feature.gg.dcloud.IAolReceiver iAolReceiver5 = iAolReceiverArr2[i3];
                    if (!(iAolReceiver5 instanceof io.dcloud.feature.gg.dcloud.ADResult.CADReceiver)) {
                        iAolReceiver5.onError("Exception", e.getMessage());
                    }
                    i3++;
                }
                io.dcloud.p.u3 u3Var5 = this.handler;
                if (u3Var5 != null) {
                    u3Var5.a(-5007, e.getMessage());
                }
            }
        }
    }
}
