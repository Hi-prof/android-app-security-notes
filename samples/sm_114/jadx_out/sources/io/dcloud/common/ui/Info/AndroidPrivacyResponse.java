package io.dcloud.common.ui.Info;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class AndroidPrivacyResponse implements io.dcloud.common.DHInterface.IReflectAble {
    public java.lang.String buttonAccept;
    public java.lang.String buttonRefuse;
    public java.lang.String message;
    public java.lang.String prompt;
    public java.lang.String title;
    public java.lang.String version;
    public java.lang.String hrefLoader = "default";
    public boolean backToExit = false;
    public io.dcloud.common.ui.Info.AndroidPrivacyResponse.SecondDTO second = new io.dcloud.common.ui.Info.AndroidPrivacyResponse.SecondDTO();
    public io.dcloud.common.ui.Info.AndroidPrivacyResponse.StylesDTO styles = new io.dcloud.common.ui.Info.AndroidPrivacyResponse.StylesDTO();
    public io.dcloud.common.ui.Info.AndroidPrivacyResponse.disagreeModeDTO disagreeMode = new io.dcloud.common.ui.Info.AndroidPrivacyResponse.disagreeModeDTO();

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static class SecondDTO implements io.dcloud.common.DHInterface.IReflectAble {
        public java.lang.String buttonAccept;
        public java.lang.String buttonRefuse;
        public java.lang.String message;
        public java.lang.String title;
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static class StylesDTO implements io.dcloud.common.DHInterface.IReflectAble {
        public java.lang.String backgroundColor;
        public java.lang.String borderRadius;
        public io.dcloud.common.ui.Info.AndroidPrivacyResponse.StylesDTO.ButtonAcceptDTO buttonAccept;
        public io.dcloud.common.ui.Info.AndroidPrivacyResponse.StylesDTO.ButtonRefuseDTO buttonRefuse;
        public io.dcloud.common.ui.Info.AndroidPrivacyResponse.StylesDTO.ButtonRefuseDTO buttonVisitor;
        public io.dcloud.common.ui.Info.AndroidPrivacyResponse.StylesDTO.ContentDTO content;
        public io.dcloud.common.ui.Info.AndroidPrivacyResponse.StylesDTO.TitleDTO title;

        /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
        public static class ButtonAcceptDTO implements io.dcloud.common.DHInterface.IReflectAble {
            public java.lang.String color;
        }

        /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
        public static class ButtonRefuseDTO implements io.dcloud.common.DHInterface.IReflectAble {
            public java.lang.String color;
        }

        /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
        public static class ContentDTO implements io.dcloud.common.DHInterface.IReflectAble {
            public java.lang.String color;
        }

        /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
        public static class TitleDTO implements io.dcloud.common.DHInterface.IReflectAble {
            public java.lang.String color;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static class disagreeModeDTO implements io.dcloud.common.DHInterface.IReflectAble {
        public boolean support = false;
        public boolean loadNativePlugins = true;
        public boolean visitorEntry = false;
        public boolean showAlways = false;
    }
}
