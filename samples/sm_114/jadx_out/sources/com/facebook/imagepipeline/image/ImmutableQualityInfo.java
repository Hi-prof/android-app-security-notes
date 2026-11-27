package com.facebook.imagepipeline.image;

/* JADX INFO: loaded from: classes.dex */
public class ImmutableQualityInfo implements com.facebook.imagepipeline.image.QualityInfo {
    public static final com.facebook.imagepipeline.image.QualityInfo FULL_QUALITY = of(Integer.MAX_VALUE, true, true);
    boolean mIsOfFullQuality;
    boolean mIsOfGoodEnoughQuality;
    int mQuality;

    private ImmutableQualityInfo(int i, boolean z, boolean z2) {
        this.mQuality = i;
        this.mIsOfGoodEnoughQuality = z;
        this.mIsOfFullQuality = z2;
    }

    @Override // com.facebook.imagepipeline.image.QualityInfo
    public int getQuality() {
        return this.mQuality;
    }

    @Override // com.facebook.imagepipeline.image.QualityInfo
    public boolean isOfGoodEnoughQuality() {
        return this.mIsOfGoodEnoughQuality;
    }

    @Override // com.facebook.imagepipeline.image.QualityInfo
    public boolean isOfFullQuality() {
        return this.mIsOfFullQuality;
    }

    public int hashCode() {
        return (this.mQuality ^ (this.mIsOfGoodEnoughQuality ? 4194304 : 0)) ^ (this.mIsOfFullQuality ? 8388608 : 0);
    }

    public boolean equals(@javax.annotation.Nullable java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof com.facebook.imagepipeline.image.ImmutableQualityInfo)) {
            return false;
        }
        com.facebook.imagepipeline.image.ImmutableQualityInfo immutableQualityInfo = (com.facebook.imagepipeline.image.ImmutableQualityInfo) obj;
        return this.mQuality == immutableQualityInfo.mQuality && this.mIsOfGoodEnoughQuality == immutableQualityInfo.mIsOfGoodEnoughQuality && this.mIsOfFullQuality == immutableQualityInfo.mIsOfFullQuality;
    }

    public static com.facebook.imagepipeline.image.QualityInfo of(int i, boolean z, boolean z2) {
        return new com.facebook.imagepipeline.image.ImmutableQualityInfo(i, z, z2);
    }
}
