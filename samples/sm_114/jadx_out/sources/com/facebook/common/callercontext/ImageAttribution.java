package com.facebook.common.callercontext;

/* JADX INFO: loaded from: classes.dex */
public interface ImageAttribution {
    java.lang.String getCallingClassName();

    @javax.annotation.Nullable
    com.facebook.common.callercontext.ContextChain getContextChain();
}
