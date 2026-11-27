package io.dcloud.common.ui;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class PrivacyManager {
    private static io.dcloud.common.ui.PrivacyManager f;
    private java.util.List a = new java.util.ArrayList();
    private io.dcloud.common.ui.Info.AndroidPrivacyResponse b = new io.dcloud.common.ui.Info.AndroidPrivacyResponse();
    private boolean c = false;
    public boolean d = false;
    private io.dcloud.common.ui.a e;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    @java.lang.FunctionalInterface
    public interface PrivacyAgreeCallback {
        void call(java.lang.Boolean bool);
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface b {
        void a();

        void a(io.dcloud.common.ui.Info.AndroidPrivacyResponse androidPrivacyResponse);

        void a(java.lang.String str);

        void b(io.dcloud.common.ui.Info.AndroidPrivacyResponse androidPrivacyResponse);
    }

    private PrivacyManager() {
    }

    public static io.dcloud.common.ui.PrivacyManager getInstance() {
        if (f == null) {
            f = new io.dcloud.common.ui.PrivacyManager();
        }
        return f;
    }

    public static boolean isDebugMode() {
        java.lang.Class<?> cls;
        try {
            cls = java.lang.Class.forName("io.dcloud.common.util.net.http.LocalServer2");
        } catch (java.lang.ClassNotFoundException unused) {
            cls = null;
        }
        return cls != null;
    }

    public boolean getIsAppAsset() {
        return this.d;
    }

    public void init(android.content.Context context) {
        init(context, null);
    }

    public boolean isAgreePrivacy(android.content.Context context) {
        android.content.SharedPreferences sharedPreferences = context.getSharedPreferences("privacy_config_uni_sp_file", 0);
        return "1".equals(io.dcloud.common.adapter.util.SP.getBundleData(context, "pdr", "scok")) && sharedPreferences.getString("privacy_config_version_uni_current_key", "emptyPrivacyVersion").equals(this.b.version) && sharedPreferences.getInt("privacy_config_choose_disagree_uni_current_key", 0) == 0;
    }

    public boolean isNotPrivacyAllRight(android.content.Context context) {
        if (!this.c) {
            init(context);
        }
        java.lang.String str = this.b.prompt;
        java.lang.String bundleData = io.dcloud.common.adapter.util.SP.getBundleData(context, "pdr", "scok");
        return (io.dcloud.common.util.PdrUtil.isEmpty(bundleData) || !bundleData.equals("1")) && !io.dcloud.common.util.PdrUtil.isEmpty(str) && str.equalsIgnoreCase("template");
    }

    public boolean isPrivacyVersionChange(android.content.Context context) {
        this.c = false;
        init(context);
        return (io.dcloud.feature.internal.sdk.SDK.isUniMPSDK() || !"template".equals(this.b.prompt) || context.getSharedPreferences("privacy_config_uni_sp_file", 0).getString("privacy_config_version_uni_current_key", "").equals(this.b.version)) ? false : true;
    }

    public void reInit(android.content.Context context, com.alibaba.fastjson.JSONObject jSONObject) throws java.lang.Throwable {
        if (jSONObject != null) {
            this.c = false;
            init(context, jSONObject);
        } else {
            this.c = false;
            init(context, null);
        }
    }

    public void registerPrivacyAgreeListener(java.lang.String str, io.dcloud.common.ui.PrivacyManager.PrivacyAgreeCallback privacyAgreeCallback) {
        this.a.add(new android.util.Pair(str, privacyAgreeCallback));
    }

    public void resetPrivacyLocalConfig(android.content.Context context) {
        context.getSharedPreferences("privacy_config_uni_sp_file", 0).edit().putString("privacy_config_version_uni_current_key", "").putInt("privacy_config_choose_disagree_uni_current_key", 0).apply();
        io.dcloud.common.adapter.util.SP.setBundleData(context, "pdr", "scok", com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT);
        this.a.forEach(new java.util.function.Consumer() { // from class: io.dcloud.common.ui.PrivacyManager$$ExternalSyntheticLambda1
            @Override // java.util.function.Consumer
            public final void accept(java.lang.Object obj) {
                io.dcloud.common.ui.PrivacyManager.a((android.util.Pair) obj);
            }
        });
    }

    public void restartPrivacyDialogIfNeed(android.app.Activity activity) {
        io.dcloud.common.ui.a aVar = this.e;
        if (aVar == null || !aVar.d()) {
            return;
        }
        io.dcloud.common.ui.PrivacyManager.b bVarB = this.e.b();
        boolean zC = this.e.c();
        this.e.a();
        this.e = null;
        showPrivacyDialog(activity, bVarB, zC, true);
    }

    public void setAgreePrivacy(android.content.Context context, final boolean z) {
        io.dcloud.common.adapter.util.SP.setBundleData(context, "pdr", "scok", z ? "1" : com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT);
        context.getSharedPreferences("privacy_config_uni_sp_file", 0).edit().putInt("privacy_config_choose_disagree_uni_current_key", !z ? 1 : 0).putString("privacy_config_version_uni_current_key", this.b.version).apply();
        this.a.forEach(new java.util.function.Consumer() { // from class: io.dcloud.common.ui.PrivacyManager$$ExternalSyntheticLambda2
            @Override // java.util.function.Consumer
            public final void accept(java.lang.Object obj) {
                io.dcloud.common.ui.PrivacyManager.a(z, (android.util.Pair) obj);
            }
        });
    }

    public void showPrivacyDialog(android.app.Activity activity, io.dcloud.common.ui.PrivacyManager.b bVar, boolean z, boolean z2) {
        if (!a(activity)) {
            bVar.a(this.b.prompt);
            return;
        }
        io.dcloud.common.ui.PrivacyManager.a aVar = new io.dcloud.common.ui.PrivacyManager.a(activity, bVar);
        io.dcloud.common.ui.a aVar2 = this.e;
        if (aVar2 != null) {
            aVar2.a();
            this.e = null;
        }
        if (z) {
            io.dcloud.common.ui.a aVar3 = new io.dcloud.common.ui.a(activity);
            this.e = aVar3;
            aVar3.a(bVar);
            this.e.a(true);
            this.e.a(this.b, true, (io.dcloud.common.ui.a.d) aVar);
            this.e.a(io.dcloud.base.R.layout.dcloud_custom_privacy_second_dialog_layout);
            this.e.e();
            return;
        }
        io.dcloud.common.ui.a aVar4 = new io.dcloud.common.ui.a(activity);
        this.e = aVar4;
        aVar4.a(bVar);
        this.e.a(false);
        this.e.a(io.dcloud.base.R.layout.dcloud_custom_privacy_dialog_layout);
        this.e.a(this.b, false, (io.dcloud.common.ui.a.d) aVar);
        this.e.e();
    }

    public void unRegisterPrivacyAgreeAllListener() {
        this.a.clear();
    }

    public void unRegisterPrivacyAgreeListener(java.lang.String str) {
        java.util.Iterator it = this.a.iterator();
        while (it.hasNext()) {
            if (((android.util.Pair) it.next()).first.equals(str)) {
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(android.util.Pair pair) {
        ((io.dcloud.common.ui.PrivacyManager.PrivacyAgreeCallback) pair.second).call(java.lang.Boolean.FALSE);
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00ff  */
    public void init(android.content.Context context, com.alibaba.fastjson.JSONObject jSONObject) throws java.lang.Throwable {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        if (this.c) {
            return;
        }
        this.d = io.dcloud.common.util.AppRuntime.isAppResourcesInAssetsPath(context, "");
        java.lang.String str = io.dcloud.common.util.BaseInfo.sCacheFsAppsPath;
        java.lang.String str2 = io.dcloud.common.util.BaseInfo.sDefaultBootApp + "/www/androidPrivacy.json";
        if (jSONObject == null) {
            java.lang.Object obj = null;
            if (this.d) {
                java.lang.String strA = a(context, "apps/" + str2);
                if (android.text.TextUtils.isEmpty(strA)) {
                    jSONObject = null;
                } else {
                    try {
                        java.lang.Object object = com.alibaba.fastjson.JSONObject.parseObject(strA, (java.lang.Class<java.lang.Object>) io.dcloud.common.ui.Info.AndroidPrivacyResponse.class);
                        jSONObject = com.alibaba.fastjson.JSONObject.parseObject(strA);
                        obj = object;
                    } catch (java.lang.Exception unused) {
                        android.util.Log.e("uniapp", "privacy json format error");
                        jSONObject = null;
                    }
                    if (obj instanceof io.dcloud.common.ui.Info.AndroidPrivacyResponse) {
                        this.b = (io.dcloud.common.ui.Info.AndroidPrivacyResponse) obj;
                    } else {
                        this.b = new io.dcloud.common.ui.Info.AndroidPrivacyResponse();
                    }
                }
            } else {
                java.io.File file = new java.io.File(str + str2);
                if (file.exists()) {
                    java.lang.String strA2 = a(file.getPath());
                    try {
                        java.lang.Object object2 = com.alibaba.fastjson.JSONObject.parseObject(strA2, (java.lang.Class<java.lang.Object>) io.dcloud.common.ui.Info.AndroidPrivacyResponse.class);
                        jSONObject = com.alibaba.fastjson.JSONObject.parseObject(strA2);
                        obj = object2;
                    } catch (java.lang.Exception unused2) {
                        android.util.Log.e("uniapp", "privacy json format error");
                        jSONObject = null;
                    }
                    if (obj instanceof io.dcloud.common.ui.Info.AndroidPrivacyResponse) {
                        this.b = (io.dcloud.common.ui.Info.AndroidPrivacyResponse) obj;
                    } else {
                        this.b = new io.dcloud.common.ui.Info.AndroidPrivacyResponse();
                    }
                } else {
                    if (new java.io.File(str + io.dcloud.common.util.BaseInfo.sDefaultBootApp).exists()) {
                        jSONObject = null;
                    } else {
                        java.lang.String strA3 = a(context, "apps/" + str2);
                        if (android.text.TextUtils.isEmpty(strA3)) {
                            jSONObject = null;
                        } else {
                            try {
                                java.lang.Object object3 = com.alibaba.fastjson.JSONObject.parseObject(strA3, (java.lang.Class<java.lang.Object>) io.dcloud.common.ui.Info.AndroidPrivacyResponse.class);
                                jSONObject = com.alibaba.fastjson.JSONObject.parseObject(strA3);
                                obj = object3;
                            } catch (java.lang.Exception unused3) {
                                jSONObject = null;
                            }
                            if (obj instanceof io.dcloud.common.ui.Info.AndroidPrivacyResponse) {
                                this.b = (io.dcloud.common.ui.Info.AndroidPrivacyResponse) obj;
                            } else {
                                this.b = new io.dcloud.common.ui.Info.AndroidPrivacyResponse();
                            }
                        }
                    }
                }
            }
        }
        if (jSONObject == null) {
            jSONObject = new com.alibaba.fastjson.JSONObject();
        }
        if (this.b == null) {
            this.b = new io.dcloud.common.ui.Info.AndroidPrivacyResponse();
        }
        io.dcloud.common.ui.Info.AndroidPrivacyResponse androidPrivacyResponse = this.b;
        if (androidPrivacyResponse.second == null) {
            androidPrivacyResponse.second = new io.dcloud.common.ui.Info.AndroidPrivacyResponse.SecondDTO();
        }
        io.dcloud.common.ui.Info.AndroidPrivacyResponse androidPrivacyResponse2 = this.b;
        if (androidPrivacyResponse2.styles == null) {
            androidPrivacyResponse2.styles = new io.dcloud.common.ui.Info.AndroidPrivacyResponse.StylesDTO();
        }
        io.dcloud.common.ui.Info.AndroidPrivacyResponse.StylesDTO stylesDTO = this.b.styles;
        if (stylesDTO.title == null) {
            stylesDTO.title = new io.dcloud.common.ui.Info.AndroidPrivacyResponse.StylesDTO.TitleDTO();
        }
        io.dcloud.common.ui.Info.AndroidPrivacyResponse.StylesDTO stylesDTO2 = this.b.styles;
        if (stylesDTO2.buttonRefuse == null) {
            stylesDTO2.buttonRefuse = new io.dcloud.common.ui.Info.AndroidPrivacyResponse.StylesDTO.ButtonRefuseDTO();
        }
        io.dcloud.common.ui.Info.AndroidPrivacyResponse.StylesDTO stylesDTO3 = this.b.styles;
        if (stylesDTO3.buttonAccept == null) {
            stylesDTO3.buttonAccept = new io.dcloud.common.ui.Info.AndroidPrivacyResponse.StylesDTO.ButtonAcceptDTO();
        }
        com.alibaba.fastjson.JSONObject jSONObject2 = jSONObject.getJSONObject("titleLocales");
        if (jSONObject2 != null) {
            io.dcloud.common.ui.Info.AndroidPrivacyResponse androidPrivacyResponse3 = this.b;
            androidPrivacyResponse3.title = io.dcloud.common.util.language.LanguageUtil.getString(jSONObject2, androidPrivacyResponse3.title);
        }
        com.alibaba.fastjson.JSONObject jSONObject3 = jSONObject.getJSONObject("messageLocales");
        if (jSONObject3 != null) {
            io.dcloud.common.ui.Info.AndroidPrivacyResponse androidPrivacyResponse4 = this.b;
            androidPrivacyResponse4.message = io.dcloud.common.util.language.LanguageUtil.getString(jSONObject3, androidPrivacyResponse4.message);
        }
        com.alibaba.fastjson.JSONObject jSONObject4 = jSONObject.getJSONObject("buttonAcceptLocales");
        if (jSONObject4 != null) {
            io.dcloud.common.ui.Info.AndroidPrivacyResponse androidPrivacyResponse5 = this.b;
            androidPrivacyResponse5.buttonAccept = io.dcloud.common.util.language.LanguageUtil.getString(jSONObject4, androidPrivacyResponse5.buttonAccept);
        }
        com.alibaba.fastjson.JSONObject jSONObject5 = jSONObject.getJSONObject("buttonRefuseLocales");
        if (jSONObject5 != null) {
            io.dcloud.common.ui.Info.AndroidPrivacyResponse androidPrivacyResponse6 = this.b;
            androidPrivacyResponse6.buttonRefuse = io.dcloud.common.util.language.LanguageUtil.getString(jSONObject5, androidPrivacyResponse6.buttonRefuse);
        }
        com.alibaba.fastjson.JSONObject jSONObject6 = jSONObject.getJSONObject("second");
        if (jSONObject6 != null) {
            com.alibaba.fastjson.JSONObject jSONObject7 = jSONObject6.getJSONObject("titleLocales");
            if (jSONObject7 != null) {
                io.dcloud.common.ui.Info.AndroidPrivacyResponse.SecondDTO secondDTO = this.b.second;
                secondDTO.title = io.dcloud.common.util.language.LanguageUtil.getString(jSONObject7, secondDTO.title);
            }
            com.alibaba.fastjson.JSONObject jSONObject8 = jSONObject6.getJSONObject("messageLocales");
            if (jSONObject8 != null) {
                io.dcloud.common.ui.Info.AndroidPrivacyResponse.SecondDTO secondDTO2 = this.b.second;
                secondDTO2.message = io.dcloud.common.util.language.LanguageUtil.getString(jSONObject8, secondDTO2.message);
            }
            com.alibaba.fastjson.JSONObject jSONObject9 = jSONObject6.getJSONObject("buttonAcceptLocales");
            if (jSONObject9 != null) {
                io.dcloud.common.ui.Info.AndroidPrivacyResponse.SecondDTO secondDTO3 = this.b.second;
                secondDTO3.buttonAccept = io.dcloud.common.util.language.LanguageUtil.getString(jSONObject9, secondDTO3.buttonAccept);
            }
            com.alibaba.fastjson.JSONObject jSONObject10 = jSONObject6.getJSONObject("buttonRefuseLocales");
            if (jSONObject10 != null) {
                io.dcloud.common.ui.Info.AndroidPrivacyResponse.SecondDTO secondDTO4 = this.b.second;
                secondDTO4.buttonRefuse = io.dcloud.common.util.language.LanguageUtil.getString(jSONObject10, secondDTO4.buttonRefuse);
            }
        }
        if (android.text.TextUtils.isEmpty(this.b.version)) {
            this.b.version = "emptyPrivacyVersion";
        }
        if (android.text.TextUtils.isEmpty(this.b.prompt)) {
            java.lang.String metaValue = io.dcloud.common.adapter.util.AndroidResources.getMetaValue("DCLOUD_PRIVACY_PROMPT");
            if (metaValue == null) {
                metaValue = "";
            }
            this.b.prompt = metaValue;
        }
        if (android.text.TextUtils.isEmpty(this.b.title) && (i8 = io.dcloud.PdrR.getInt(context, "string", "dcloud_privacy_prompt_title")) != 0) {
            java.lang.String string = context.getString(i8);
            if (string == null) {
                string = "";
            }
            this.b.title = string;
        }
        if (android.text.TextUtils.isEmpty(this.b.message) && (i7 = io.dcloud.PdrR.getInt(context, "string", "dcloud_privacy_prompt_message")) != 0) {
            java.lang.String string2 = context.getString(i7);
            if (string2 == null) {
                string2 = "";
            }
            this.b.message = string2;
        }
        if (android.text.TextUtils.isEmpty(this.b.buttonAccept) && (i6 = io.dcloud.PdrR.getInt(context, "string", "dcloud_privacy_prompt_accept_button_text")) != 0) {
            java.lang.String string3 = context.getString(i6);
            if (string3 == null) {
                string3 = "";
            }
            this.b.buttonAccept = string3;
        }
        if (android.text.TextUtils.isEmpty(this.b.buttonRefuse) && (i5 = io.dcloud.PdrR.getInt(context, "string", "dcloud_privacy_prompt_refuse_button_text")) != 0) {
            java.lang.String string4 = context.getString(i5);
            if (string4 == null) {
                string4 = "";
            }
            this.b.buttonRefuse = string4;
        }
        if (android.text.TextUtils.isEmpty(this.b.second.message) && (i4 = io.dcloud.PdrR.getInt(context, "string", "dcloud_second_privacy_prompt_message")) != 0) {
            java.lang.String string5 = context.getString(i4);
            if (string5 == null) {
                string5 = "";
            }
            this.b.second.message = string5;
        }
        if (android.text.TextUtils.isEmpty(this.b.second.title) && (i3 = io.dcloud.PdrR.getInt(context, "string", "dcloud_second_privacy_prompt_title")) != 0) {
            java.lang.String string6 = context.getString(i3);
            if (string6 == null) {
                string6 = "";
            }
            this.b.second.title = string6;
        }
        if (android.text.TextUtils.isEmpty(this.b.second.buttonAccept) && (i2 = io.dcloud.PdrR.getInt(context, "string", "dcloud_second_privacy_prompt_accept_button_text")) != 0) {
            java.lang.String string7 = context.getString(i2);
            if (string7 == null) {
                string7 = "";
            }
            this.b.second.buttonAccept = string7;
        }
        if (android.text.TextUtils.isEmpty(this.b.second.buttonRefuse) && (i = io.dcloud.PdrR.getInt(context, "string", "dcloud_second_privacy_prompt_refuse_button_text")) != 0) {
            java.lang.String string8 = context.getString(i);
            this.b.second.buttonRefuse = string8 != null ? string8 : "";
        }
        if (android.text.TextUtils.isEmpty(this.b.styles.backgroundColor)) {
            this.b.styles.backgroundColor = io.dcloud.common.util.TitleNViewUtil.TRANSPARENT_BUTTON_TEXT_COLOR;
        }
        if (android.text.TextUtils.isEmpty(this.b.styles.borderRadius)) {
            this.b.styles.borderRadius = "10px";
        }
        if (android.text.TextUtils.isEmpty(this.b.styles.title.color)) {
            this.b.styles.title.color = "#000000";
        }
        if (android.text.TextUtils.isEmpty(this.b.styles.buttonAccept.color)) {
            this.b.styles.buttonAccept.color = "#000000";
        }
        if (android.text.TextUtils.isEmpty(this.b.styles.buttonRefuse.color)) {
            this.b.styles.buttonRefuse.color = "#000000";
        }
        if (android.text.TextUtils.isEmpty(this.b.buttonAccept)) {
            this.b.styles.buttonAccept.color = "#000000";
        }
        if (android.text.TextUtils.isEmpty(this.b.styles.buttonRefuse.color)) {
            this.b.styles.buttonRefuse.color = "#000000";
        }
        this.c = true;
    }

    private static java.lang.String a(java.lang.String str) throws java.lang.Throwable {
        java.io.BufferedReader bufferedReader;
        java.io.File file = new java.io.File(str);
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        java.io.BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new java.io.BufferedReader(new java.io.FileReader(file));
                while (true) {
                    try {
                        java.lang.String line = bufferedReader.readLine();
                        if (line != null) {
                            stringBuffer.append(line);
                        } else {
                            bufferedReader.close();
                            java.lang.String string = stringBuffer.toString();
                            try {
                                bufferedReader.close();
                                return string;
                            } catch (java.io.IOException e) {
                                e.printStackTrace();
                                return string;
                            }
                        }
                    } catch (java.io.IOException e2) {
                        e = e2;
                        bufferedReader2 = bufferedReader;
                        e.printStackTrace();
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (java.io.IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        return stringBuffer.toString();
                    } catch (java.lang.Throwable th) {
                        th = th;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (java.io.IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                bufferedReader = bufferedReader2;
            }
        } catch (java.io.IOException e5) {
            e = e5;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class a implements io.dcloud.common.ui.a.d {
        final /* synthetic */ android.app.Activity a;
        final /* synthetic */ io.dcloud.common.ui.PrivacyManager.b b;

        a(android.app.Activity activity, io.dcloud.common.ui.PrivacyManager.b bVar) {
            this.a = activity;
            this.b = bVar;
        }

        @Override // io.dcloud.common.ui.a.d
        public void a(java.lang.String str) {
            this.a.getSharedPreferences("privacy_config_uni_sp_file", 0).edit().putString("privacy_config_version_uni_current_key", str).apply();
            io.dcloud.common.adapter.util.SP.setBundleData(this.a, "pdr", "scok", "1");
            this.b.a();
        }

        @Override // io.dcloud.common.ui.a.d
        public void onCancel() {
            io.dcloud.common.adapter.util.SP.setBundleData(this.a, "pdr", "scok", com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT);
            this.b.a(io.dcloud.common.ui.PrivacyManager.this.b);
            this.a.getSharedPreferences("privacy_config_uni_sp_file", 0).edit().putInt("privacy_config_choose_disagree_uni_current_key", 1).apply();
        }

        @Override // io.dcloud.common.ui.a.d
        public void a() {
            io.dcloud.common.adapter.util.SP.setBundleData(this.a, "pdr", "scok", com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT);
            this.b.b(io.dcloud.common.ui.PrivacyManager.this.b);
        }
    }

    private static java.lang.String a(android.content.Context context, java.lang.String str) {
        try {
            java.io.InputStream inputStreamOpen = context.getResources().getAssets().open(str);
            byte[] bArr = new byte[inputStreamOpen.available()];
            inputStreamOpen.read(bArr);
            return new java.lang.String(bArr);
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    private boolean a(android.content.Context context) {
        android.content.SharedPreferences sharedPreferences = context.getSharedPreferences("privacy_config_uni_sp_file", 0);
        java.lang.String string = sharedPreferences.getString("privacy_config_version_uni_current_key", "emptyPrivacyVersion");
        int i = sharedPreferences.getInt("privacy_config_choose_disagree_uni_current_key", 0);
        if (!string.equals(this.b.version) && !"emptyPrivacyVersion".equals(string)) {
            sharedPreferences.edit().putInt("privacy_config_choose_disagree_uni_current_key", 0).apply();
            io.dcloud.common.adapter.util.SP.setBundleData(context, "pdr", "scok", "");
            if (!this.b.prompt.equals("template")) {
                return false;
            }
            io.dcloud.common.adapter.util.SP.setBundleData(context, "pdr", "scok", com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT);
            return true;
        }
        if (this.b.prompt.equals("template")) {
            io.dcloud.common.ui.Info.AndroidPrivacyResponse.disagreeModeDTO disagreemodedto = this.b.disagreeMode;
            if (((!disagreemodedto.support && !disagreemodedto.visitorEntry) || disagreemodedto.showAlways || i != 1) && !"1".equals(io.dcloud.common.adapter.util.SP.getBundleData(context, "pdr", "scok"))) {
                io.dcloud.common.adapter.util.SP.setBundleData(context, "pdr", "scok", com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(boolean z, android.util.Pair pair) {
        ((io.dcloud.common.ui.PrivacyManager.PrivacyAgreeCallback) pair.second).call(java.lang.Boolean.valueOf(z));
    }
}
