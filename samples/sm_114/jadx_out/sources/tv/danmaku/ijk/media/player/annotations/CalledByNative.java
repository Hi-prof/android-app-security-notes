package tv.danmaku.ijk.media.player.annotations;

/* JADX INFO: loaded from: classes2.dex */
@java.lang.annotation.Target({java.lang.annotation.ElementType.METHOD})
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.CLASS)
public @interface CalledByNative {
    java.lang.String value() default "";
}
