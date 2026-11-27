package io.dcloud.nineoldandroids.view;

/* JADX INFO: loaded from: classes2.dex */
public final class ViewHelper {
    private ViewHelper() {
    }

    public static float getAlpha(android.view.View view) {
        return io.dcloud.nineoldandroids.view.animation.AnimatorProxy.NEEDS_PROXY ? io.dcloud.nineoldandroids.view.animation.AnimatorProxy.wrap(view).getAlpha() : io.dcloud.nineoldandroids.view.ViewHelper.Honeycomb.getAlpha(view);
    }

    public static void setAlpha(android.view.View view, float f) {
        if (io.dcloud.nineoldandroids.view.animation.AnimatorProxy.NEEDS_PROXY) {
            io.dcloud.nineoldandroids.view.animation.AnimatorProxy.wrap(view).setAlpha(f);
        } else {
            io.dcloud.nineoldandroids.view.ViewHelper.Honeycomb.setAlpha(view, f);
        }
    }

    public static float getPivotX(android.view.View view) {
        return io.dcloud.nineoldandroids.view.animation.AnimatorProxy.NEEDS_PROXY ? io.dcloud.nineoldandroids.view.animation.AnimatorProxy.wrap(view).getPivotX() : io.dcloud.nineoldandroids.view.ViewHelper.Honeycomb.getPivotX(view);
    }

    public static void setPivotX(android.view.View view, float f) {
        if (io.dcloud.nineoldandroids.view.animation.AnimatorProxy.NEEDS_PROXY) {
            io.dcloud.nineoldandroids.view.animation.AnimatorProxy.wrap(view).setPivotX(f);
        } else {
            io.dcloud.nineoldandroids.view.ViewHelper.Honeycomb.setPivotX(view, f);
        }
    }

    public static float getPivotY(android.view.View view) {
        return io.dcloud.nineoldandroids.view.animation.AnimatorProxy.NEEDS_PROXY ? io.dcloud.nineoldandroids.view.animation.AnimatorProxy.wrap(view).getPivotY() : io.dcloud.nineoldandroids.view.ViewHelper.Honeycomb.getPivotY(view);
    }

    public static void setPivotY(android.view.View view, float f) {
        if (io.dcloud.nineoldandroids.view.animation.AnimatorProxy.NEEDS_PROXY) {
            io.dcloud.nineoldandroids.view.animation.AnimatorProxy.wrap(view).setPivotY(f);
        } else {
            io.dcloud.nineoldandroids.view.ViewHelper.Honeycomb.setPivotY(view, f);
        }
    }

    public static float getRotation(android.view.View view) {
        return io.dcloud.nineoldandroids.view.animation.AnimatorProxy.NEEDS_PROXY ? io.dcloud.nineoldandroids.view.animation.AnimatorProxy.wrap(view).getRotation() : io.dcloud.nineoldandroids.view.ViewHelper.Honeycomb.getRotation(view);
    }

    public static void setRotation(android.view.View view, float f) {
        if (io.dcloud.nineoldandroids.view.animation.AnimatorProxy.NEEDS_PROXY) {
            io.dcloud.nineoldandroids.view.animation.AnimatorProxy.wrap(view).setRotation(f);
        } else {
            io.dcloud.nineoldandroids.view.ViewHelper.Honeycomb.setRotation(view, f);
        }
    }

    public static float getRotationX(android.view.View view) {
        return io.dcloud.nineoldandroids.view.animation.AnimatorProxy.NEEDS_PROXY ? io.dcloud.nineoldandroids.view.animation.AnimatorProxy.wrap(view).getRotationX() : io.dcloud.nineoldandroids.view.ViewHelper.Honeycomb.getRotationX(view);
    }

    public static void setRotationX(android.view.View view, float f) {
        if (io.dcloud.nineoldandroids.view.animation.AnimatorProxy.NEEDS_PROXY) {
            io.dcloud.nineoldandroids.view.animation.AnimatorProxy.wrap(view).setRotationX(f);
        } else {
            io.dcloud.nineoldandroids.view.ViewHelper.Honeycomb.setRotationX(view, f);
        }
    }

    public static float getRotationY(android.view.View view) {
        return io.dcloud.nineoldandroids.view.animation.AnimatorProxy.NEEDS_PROXY ? io.dcloud.nineoldandroids.view.animation.AnimatorProxy.wrap(view).getRotationY() : io.dcloud.nineoldandroids.view.ViewHelper.Honeycomb.getRotationY(view);
    }

    public static void setRotationY(android.view.View view, float f) {
        if (io.dcloud.nineoldandroids.view.animation.AnimatorProxy.NEEDS_PROXY) {
            io.dcloud.nineoldandroids.view.animation.AnimatorProxy.wrap(view).setRotationY(f);
        } else {
            io.dcloud.nineoldandroids.view.ViewHelper.Honeycomb.setRotationY(view, f);
        }
    }

    public static float getScaleX(android.view.View view) {
        return io.dcloud.nineoldandroids.view.animation.AnimatorProxy.NEEDS_PROXY ? io.dcloud.nineoldandroids.view.animation.AnimatorProxy.wrap(view).getScaleX() : io.dcloud.nineoldandroids.view.ViewHelper.Honeycomb.getScaleX(view);
    }

    public static void setScaleX(android.view.View view, float f) {
        if (io.dcloud.nineoldandroids.view.animation.AnimatorProxy.NEEDS_PROXY) {
            io.dcloud.nineoldandroids.view.animation.AnimatorProxy.wrap(view).setScaleX(f);
        } else {
            io.dcloud.nineoldandroids.view.ViewHelper.Honeycomb.setScaleX(view, f);
        }
    }

    public static float getScaleY(android.view.View view) {
        return io.dcloud.nineoldandroids.view.animation.AnimatorProxy.NEEDS_PROXY ? io.dcloud.nineoldandroids.view.animation.AnimatorProxy.wrap(view).getScaleY() : io.dcloud.nineoldandroids.view.ViewHelper.Honeycomb.getScaleY(view);
    }

    public static void setScaleY(android.view.View view, float f) {
        if (io.dcloud.nineoldandroids.view.animation.AnimatorProxy.NEEDS_PROXY) {
            io.dcloud.nineoldandroids.view.animation.AnimatorProxy.wrap(view).setScaleY(f);
        } else {
            io.dcloud.nineoldandroids.view.ViewHelper.Honeycomb.setScaleY(view, f);
        }
    }

    public static float getScrollX(android.view.View view) {
        return io.dcloud.nineoldandroids.view.animation.AnimatorProxy.NEEDS_PROXY ? io.dcloud.nineoldandroids.view.animation.AnimatorProxy.wrap(view).getScrollX() : io.dcloud.nineoldandroids.view.ViewHelper.Honeycomb.getScrollX(view);
    }

    public static void setScrollX(android.view.View view, int i) {
        if (io.dcloud.nineoldandroids.view.animation.AnimatorProxy.NEEDS_PROXY) {
            io.dcloud.nineoldandroids.view.animation.AnimatorProxy.wrap(view).setScrollX(i);
        } else {
            io.dcloud.nineoldandroids.view.ViewHelper.Honeycomb.setScrollX(view, i);
        }
    }

    public static float getScrollY(android.view.View view) {
        return io.dcloud.nineoldandroids.view.animation.AnimatorProxy.NEEDS_PROXY ? io.dcloud.nineoldandroids.view.animation.AnimatorProxy.wrap(view).getScrollY() : io.dcloud.nineoldandroids.view.ViewHelper.Honeycomb.getScrollY(view);
    }

    public static void setScrollY(android.view.View view, int i) {
        if (io.dcloud.nineoldandroids.view.animation.AnimatorProxy.NEEDS_PROXY) {
            io.dcloud.nineoldandroids.view.animation.AnimatorProxy.wrap(view).setScrollY(i);
        } else {
            io.dcloud.nineoldandroids.view.ViewHelper.Honeycomb.setScrollY(view, i);
        }
    }

    public static float getTranslationX(android.view.View view) {
        return io.dcloud.nineoldandroids.view.animation.AnimatorProxy.NEEDS_PROXY ? io.dcloud.nineoldandroids.view.animation.AnimatorProxy.wrap(view).getTranslationX() : io.dcloud.nineoldandroids.view.ViewHelper.Honeycomb.getTranslationX(view);
    }

    public static void setTranslationX(android.view.View view, float f) {
        if (io.dcloud.nineoldandroids.view.animation.AnimatorProxy.NEEDS_PROXY) {
            io.dcloud.nineoldandroids.view.animation.AnimatorProxy.wrap(view).setTranslationX(f);
        } else {
            io.dcloud.nineoldandroids.view.ViewHelper.Honeycomb.setTranslationX(view, f);
        }
    }

    public static float getTranslationY(android.view.View view) {
        return io.dcloud.nineoldandroids.view.animation.AnimatorProxy.NEEDS_PROXY ? io.dcloud.nineoldandroids.view.animation.AnimatorProxy.wrap(view).getTranslationY() : io.dcloud.nineoldandroids.view.ViewHelper.Honeycomb.getTranslationY(view);
    }

    public static void setTranslationY(android.view.View view, float f) {
        if (io.dcloud.nineoldandroids.view.animation.AnimatorProxy.NEEDS_PROXY) {
            io.dcloud.nineoldandroids.view.animation.AnimatorProxy.wrap(view).setTranslationY(f);
        } else {
            io.dcloud.nineoldandroids.view.ViewHelper.Honeycomb.setTranslationY(view, f);
        }
    }

    public static float getX(android.view.View view) {
        return io.dcloud.nineoldandroids.view.animation.AnimatorProxy.NEEDS_PROXY ? io.dcloud.nineoldandroids.view.animation.AnimatorProxy.wrap(view).getX() : io.dcloud.nineoldandroids.view.ViewHelper.Honeycomb.getX(view);
    }

    public static void setX(android.view.View view, float f) {
        if (io.dcloud.nineoldandroids.view.animation.AnimatorProxy.NEEDS_PROXY) {
            io.dcloud.nineoldandroids.view.animation.AnimatorProxy.wrap(view).setX(f);
        } else {
            io.dcloud.nineoldandroids.view.ViewHelper.Honeycomb.setX(view, f);
        }
    }

    public static float getY(android.view.View view) {
        return io.dcloud.nineoldandroids.view.animation.AnimatorProxy.NEEDS_PROXY ? io.dcloud.nineoldandroids.view.animation.AnimatorProxy.wrap(view).getY() : io.dcloud.nineoldandroids.view.ViewHelper.Honeycomb.getY(view);
    }

    public static void setY(android.view.View view, float f) {
        if (io.dcloud.nineoldandroids.view.animation.AnimatorProxy.NEEDS_PROXY) {
            io.dcloud.nineoldandroids.view.animation.AnimatorProxy.wrap(view).setY(f);
        } else {
            io.dcloud.nineoldandroids.view.ViewHelper.Honeycomb.setY(view, f);
        }
    }

    private static final class Honeycomb {
        private Honeycomb() {
        }

        static float getAlpha(android.view.View view) {
            return view.getAlpha();
        }

        static void setAlpha(android.view.View view, float f) {
            view.setAlpha(f);
        }

        static float getPivotX(android.view.View view) {
            return view.getPivotX();
        }

        static void setPivotX(android.view.View view, float f) {
            view.setPivotX(f);
        }

        static float getPivotY(android.view.View view) {
            return view.getPivotY();
        }

        static void setPivotY(android.view.View view, float f) {
            view.setPivotY(f);
        }

        static float getRotation(android.view.View view) {
            return view.getRotation();
        }

        static void setRotation(android.view.View view, float f) {
            view.setRotation(f);
        }

        static float getRotationX(android.view.View view) {
            return view.getRotationX();
        }

        static void setRotationX(android.view.View view, float f) {
            view.setRotationX(f);
        }

        static float getRotationY(android.view.View view) {
            return view.getRotationY();
        }

        static void setRotationY(android.view.View view, float f) {
            view.setRotationY(f);
        }

        static float getScaleX(android.view.View view) {
            return view.getScaleX();
        }

        static void setScaleX(android.view.View view, float f) {
            view.setScaleX(f);
        }

        static float getScaleY(android.view.View view) {
            return view.getScaleY();
        }

        static void setScaleY(android.view.View view, float f) {
            view.setScaleY(f);
        }

        static float getScrollX(android.view.View view) {
            return view.getScrollX();
        }

        static void setScrollX(android.view.View view, int i) {
            view.setScrollX(i);
        }

        static float getScrollY(android.view.View view) {
            return view.getScrollY();
        }

        static void setScrollY(android.view.View view, int i) {
            view.setScrollY(i);
        }

        static float getTranslationX(android.view.View view) {
            return view.getTranslationX();
        }

        static void setTranslationX(android.view.View view, float f) {
            view.setTranslationX(f);
        }

        static float getTranslationY(android.view.View view) {
            return view.getTranslationY();
        }

        static void setTranslationY(android.view.View view, float f) {
            view.setTranslationY(f);
        }

        static float getX(android.view.View view) {
            return view.getX();
        }

        static void setX(android.view.View view, float f) {
            view.setX(f);
        }

        static float getY(android.view.View view) {
            return view.getY();
        }

        static void setY(android.view.View view, float f) {
            view.setY(f);
        }
    }
}
