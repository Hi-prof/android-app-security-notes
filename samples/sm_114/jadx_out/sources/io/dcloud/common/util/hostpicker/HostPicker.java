package io.dcloud.common.util.hostpicker;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class HostPicker {
    private static io.dcloud.common.util.hostpicker.HostPicker instance = new io.dcloud.common.util.hostpicker.HostPicker();
    private final java.lang.String SP_FILE_NAME = "UNIAPP_HostPicker_0817";
    private final java.lang.String SP_LAST_SUIT_HOST_NAME = "SP_LAST_SUIT_HOST_NAME_0817";

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static class Host implements java.lang.Comparable<io.dcloud.common.util.hostpicker.HostPicker.Host>, java.lang.Cloneable {
        java.lang.String hostUrl;
        io.dcloud.common.util.hostpicker.HostPicker.Host.PriorityEnum priority;

        /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
        public enum PriorityEnum {
            NORMAL(0),
            FIRST(1),
            BACKUP(-1);

            int val;

            PriorityEnum(int i) {
                this.val = i;
            }
        }

        public Host(java.lang.String str, io.dcloud.common.util.hostpicker.HostPicker.Host.PriorityEnum priorityEnum) {
            io.dcloud.common.util.hostpicker.HostPicker.Host.PriorityEnum priorityEnum2 = io.dcloud.common.util.hostpicker.HostPicker.Host.PriorityEnum.NORMAL;
            this.hostUrl = str;
            this.priority = priorityEnum;
        }

        public boolean equals(java.lang.Object obj) {
            if (!(obj instanceof io.dcloud.common.util.hostpicker.HostPicker.Host)) {
                return false;
            }
            io.dcloud.common.util.hostpicker.HostPicker.Host host = (io.dcloud.common.util.hostpicker.HostPicker.Host) obj;
            if (android.text.TextUtils.isEmpty(host.hostUrl)) {
                return false;
            }
            return host.hostUrl.equals(this.hostUrl);
        }

        public java.lang.String getHostUrl() {
            return this.hostUrl;
        }

        public io.dcloud.common.util.hostpicker.HostPicker.Host.PriorityEnum getPriority() {
            return this.priority;
        }

        public java.lang.String getRealHost() {
            java.lang.String str = "";
            if (android.text.TextUtils.isEmpty(this.hostUrl)) {
                return "";
            }
            try {
                str = new java.lang.String(android.util.Base64.decode(this.hostUrl.getBytes("UTF-8"), 2), "UTF-8");
            } catch (java.io.UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return io.dcloud.p.e1.b(str);
        }

        public int hashCode() {
            return this.hostUrl.hashCode();
        }

        public boolean isFormatRightful() {
            return !android.text.TextUtils.isEmpty(this.hostUrl);
        }

        public java.lang.String toString() {
            return "Host{hostUrl='" + this.hostUrl + "', priority=" + this.priority + com.taobao.weex.el.parse.Operators.BLOCK_END;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
        public io.dcloud.common.util.hostpicker.HostPicker.Host m430clone() {
            return new io.dcloud.common.util.hostpicker.HostPicker.Host(this.hostUrl, this.priority);
        }

        @Override // java.lang.Comparable
        public int compareTo(io.dcloud.common.util.hostpicker.HostPicker.Host host) {
            if (host == null) {
                return 1;
            }
            return host.priority.val - this.priority.val;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface HostPickCallback {
        boolean doRequest(io.dcloud.common.util.hostpicker.HostPicker.Host host);

        void onNoOnePicked();

        void onOneSelected(io.dcloud.common.util.hostpicker.HostPicker.Host host);
    }

    private HostPicker() {
    }

    public static io.dcloud.common.util.hostpicker.HostPicker getInstance() {
        return instance;
    }

    private void initHostsForRequest(android.content.Context context, java.util.List<io.dcloud.common.util.hostpicker.HostPicker.Host> list, java.lang.String str) {
        java.lang.String str2 = "SP_LAST_SUIT_HOST_NAME_0817" + str;
        android.content.SharedPreferences sharedPreferences = context.getSharedPreferences("UNIAPP_HostPicker_0817", 0);
        java.lang.String string = sharedPreferences.getString(str2, "");
        for (io.dcloud.common.util.hostpicker.HostPicker.Host host : list) {
            if (!host.isFormatRightful()) {
                throw new java.lang.RuntimeException("error format host");
            }
            if (!android.text.TextUtils.isEmpty(string) && host.priority != io.dcloud.common.util.hostpicker.HostPicker.Host.PriorityEnum.BACKUP) {
                if (string.equals(host.hostUrl)) {
                    host.priority = io.dcloud.common.util.hostpicker.HostPicker.Host.PriorityEnum.FIRST;
                } else {
                    host.priority = io.dcloud.common.util.hostpicker.HostPicker.Host.PriorityEnum.NORMAL;
                }
            }
        }
        sharedPreferences.edit().remove(str2).apply();
    }

    public void pickSuitHost(android.content.Context context, java.util.List<io.dcloud.common.util.hostpicker.HostPicker.Host> list, java.lang.String str, io.dcloud.common.util.hostpicker.HostPicker.HostPickCallback hostPickCallback) {
        if (list == null || list.isEmpty()) {
            throw new java.lang.RuntimeException("call initHosts first");
        }
        initHostsForRequest(context, list, str);
        java.util.Collections.sort(list);
        for (io.dcloud.common.util.hostpicker.HostPicker.Host host : list) {
            if (hostPickCallback.doRequest(host)) {
                if (host.priority != io.dcloud.common.util.hostpicker.HostPicker.Host.PriorityEnum.BACKUP) {
                    context.getSharedPreferences("UNIAPP_HostPicker_0817", 0).edit().putString("SP_LAST_SUIT_HOST_NAME_0817" + str, host.hostUrl).apply();
                }
                hostPickCallback.onOneSelected(host);
                return;
            }
        }
        hostPickCallback.onNoOnePicked();
    }
}
