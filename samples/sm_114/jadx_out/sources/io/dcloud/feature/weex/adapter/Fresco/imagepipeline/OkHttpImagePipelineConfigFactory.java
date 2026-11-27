package io.dcloud.feature.weex.adapter.Fresco.imagepipeline;

/* JADX INFO: loaded from: classes2.dex */
public class OkHttpImagePipelineConfigFactory {
    public static com.facebook.imagepipeline.core.ImagePipelineConfig.Builder newBuilder(android.content.Context context, dc.squareup.okhttp3.OkHttpClient okHttpClient) {
        return com.facebook.imagepipeline.core.ImagePipelineConfig.newBuilder(context).setNetworkFetcher(new io.dcloud.feature.weex.adapter.Fresco.imagepipeline.OkHttpNetworkFetcher(okHttpClient));
    }
}
