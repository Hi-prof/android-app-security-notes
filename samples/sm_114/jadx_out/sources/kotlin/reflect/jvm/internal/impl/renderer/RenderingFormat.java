package kotlin.reflect.jvm.internal.impl.renderer;

/* JADX INFO: compiled from: DescriptorRenderer.kt */
/* JADX INFO: loaded from: classes2.dex */
public enum RenderingFormat {
    PLAIN { // from class: kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat.PLAIN
        @Override // kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat
        public java.lang.String escape(java.lang.String string) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(string, "string");
            return string;
        }
    },
    HTML { // from class: kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat.HTML
        @Override // kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat
        public java.lang.String escape(java.lang.String string) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(string, "string");
            return kotlin.text.StringsKt.replace$default(kotlin.text.StringsKt.replace$default(string, com.taobao.weex.el.parse.Operators.L, "&lt;", false, 4, (java.lang.Object) null), com.taobao.weex.el.parse.Operators.G, "&gt;", false, 4, (java.lang.Object) null);
        }
    };

    private static final /* synthetic */ kotlin.enums.EnumEntries $ENTRIES = kotlin.enums.EnumEntriesKt.enumEntries(values());

    /* synthetic */ RenderingFormat(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract java.lang.String escape(java.lang.String str);
}
