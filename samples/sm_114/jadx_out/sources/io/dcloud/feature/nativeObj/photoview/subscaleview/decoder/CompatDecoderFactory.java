package io.dcloud.feature.nativeObj.photoview.subscaleview.decoder;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class CompatDecoderFactory<T> implements io.dcloud.feature.nativeObj.photoview.subscaleview.decoder.DecoderFactory<T> {
    private final android.graphics.Bitmap.Config bitmapConfig;
    private final java.lang.Class<? extends T> clazz;

    public CompatDecoderFactory(java.lang.Class<? extends T> cls) {
        this(cls, null);
    }

    @Override // io.dcloud.feature.nativeObj.photoview.subscaleview.decoder.DecoderFactory
    public T make() throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.InstantiationException, java.lang.reflect.InvocationTargetException {
        return this.bitmapConfig == null ? this.clazz.newInstance() : this.clazz.getConstructor(android.graphics.Bitmap.Config.class).newInstance(this.bitmapConfig);
    }

    public CompatDecoderFactory(java.lang.Class<? extends T> cls, android.graphics.Bitmap.Config config) {
        this.clazz = cls;
        this.bitmapConfig = config;
    }
}
