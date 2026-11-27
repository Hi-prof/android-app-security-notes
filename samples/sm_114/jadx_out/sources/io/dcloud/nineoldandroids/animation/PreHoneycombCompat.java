package io.dcloud.nineoldandroids.animation;

/* JADX INFO: loaded from: classes2.dex */
final class PreHoneycombCompat {
    static io.dcloud.nineoldandroids.util.Property<android.view.View, java.lang.Float> ALPHA = new io.dcloud.nineoldandroids.util.FloatProperty<android.view.View>("alpha") { // from class: io.dcloud.nineoldandroids.animation.PreHoneycombCompat.1
        @Override // io.dcloud.nineoldandroids.util.FloatProperty
        public void setValue(android.view.View view, float f) {
            io.dcloud.nineoldandroids.view.animation.AnimatorProxy.wrap(view).setAlpha(f);
        }

        @Override // io.dcloud.nineoldandroids.util.Property
        public java.lang.Float get(android.view.View view) {
            return java.lang.Float.valueOf(io.dcloud.nineoldandroids.view.animation.AnimatorProxy.wrap(view).getAlpha());
        }
    };
    static io.dcloud.nineoldandroids.util.Property<android.view.View, java.lang.Float> PIVOT_X = new io.dcloud.nineoldandroids.util.FloatProperty<android.view.View>("pivotX") { // from class: io.dcloud.nineoldandroids.animation.PreHoneycombCompat.2
        @Override // io.dcloud.nineoldandroids.util.FloatProperty
        public void setValue(android.view.View view, float f) {
            io.dcloud.nineoldandroids.view.animation.AnimatorProxy.wrap(view).setPivotX(f);
        }

        @Override // io.dcloud.nineoldandroids.util.Property
        public java.lang.Float get(android.view.View view) {
            return java.lang.Float.valueOf(io.dcloud.nineoldandroids.view.animation.AnimatorProxy.wrap(view).getPivotX());
        }
    };
    static io.dcloud.nineoldandroids.util.Property<android.view.View, java.lang.Float> PIVOT_Y = new io.dcloud.nineoldandroids.util.FloatProperty<android.view.View>("pivotY") { // from class: io.dcloud.nineoldandroids.animation.PreHoneycombCompat.3
        @Override // io.dcloud.nineoldandroids.util.FloatProperty
        public void setValue(android.view.View view, float f) {
            io.dcloud.nineoldandroids.view.animation.AnimatorProxy.wrap(view).setPivotY(f);
        }

        @Override // io.dcloud.nineoldandroids.util.Property
        public java.lang.Float get(android.view.View view) {
            return java.lang.Float.valueOf(io.dcloud.nineoldandroids.view.animation.AnimatorProxy.wrap(view).getPivotY());
        }
    };
    static io.dcloud.nineoldandroids.util.Property<android.view.View, java.lang.Float> TRANSLATION_X = new io.dcloud.nineoldandroids.util.FloatProperty<android.view.View>("translationX") { // from class: io.dcloud.nineoldandroids.animation.PreHoneycombCompat.4
        @Override // io.dcloud.nineoldandroids.util.FloatProperty
        public void setValue(android.view.View view, float f) {
            io.dcloud.nineoldandroids.view.animation.AnimatorProxy.wrap(view).setTranslationX(f);
        }

        @Override // io.dcloud.nineoldandroids.util.Property
        public java.lang.Float get(android.view.View view) {
            return java.lang.Float.valueOf(io.dcloud.nineoldandroids.view.animation.AnimatorProxy.wrap(view).getTranslationX());
        }
    };
    static io.dcloud.nineoldandroids.util.Property<android.view.View, java.lang.Float> TRANSLATION_Y = new io.dcloud.nineoldandroids.util.FloatProperty<android.view.View>("translationY") { // from class: io.dcloud.nineoldandroids.animation.PreHoneycombCompat.5
        @Override // io.dcloud.nineoldandroids.util.FloatProperty
        public void setValue(android.view.View view, float f) {
            io.dcloud.nineoldandroids.view.animation.AnimatorProxy.wrap(view).setTranslationY(f);
        }

        @Override // io.dcloud.nineoldandroids.util.Property
        public java.lang.Float get(android.view.View view) {
            return java.lang.Float.valueOf(io.dcloud.nineoldandroids.view.animation.AnimatorProxy.wrap(view).getTranslationY());
        }
    };
    static io.dcloud.nineoldandroids.util.Property<android.view.View, java.lang.Float> ROTATION = new io.dcloud.nineoldandroids.util.FloatProperty<android.view.View>("rotation") { // from class: io.dcloud.nineoldandroids.animation.PreHoneycombCompat.6
        @Override // io.dcloud.nineoldandroids.util.FloatProperty
        public void setValue(android.view.View view, float f) {
            io.dcloud.nineoldandroids.view.animation.AnimatorProxy.wrap(view).setRotation(f);
        }

        @Override // io.dcloud.nineoldandroids.util.Property
        public java.lang.Float get(android.view.View view) {
            return java.lang.Float.valueOf(io.dcloud.nineoldandroids.view.animation.AnimatorProxy.wrap(view).getRotation());
        }
    };
    static io.dcloud.nineoldandroids.util.Property<android.view.View, java.lang.Float> ROTATION_X = new io.dcloud.nineoldandroids.util.FloatProperty<android.view.View>("rotationX") { // from class: io.dcloud.nineoldandroids.animation.PreHoneycombCompat.7
        @Override // io.dcloud.nineoldandroids.util.FloatProperty
        public void setValue(android.view.View view, float f) {
            io.dcloud.nineoldandroids.view.animation.AnimatorProxy.wrap(view).setRotationX(f);
        }

        @Override // io.dcloud.nineoldandroids.util.Property
        public java.lang.Float get(android.view.View view) {
            return java.lang.Float.valueOf(io.dcloud.nineoldandroids.view.animation.AnimatorProxy.wrap(view).getRotationX());
        }
    };
    static io.dcloud.nineoldandroids.util.Property<android.view.View, java.lang.Float> ROTATION_Y = new io.dcloud.nineoldandroids.util.FloatProperty<android.view.View>("rotationY") { // from class: io.dcloud.nineoldandroids.animation.PreHoneycombCompat.8
        @Override // io.dcloud.nineoldandroids.util.FloatProperty
        public void setValue(android.view.View view, float f) {
            io.dcloud.nineoldandroids.view.animation.AnimatorProxy.wrap(view).setRotationY(f);
        }

        @Override // io.dcloud.nineoldandroids.util.Property
        public java.lang.Float get(android.view.View view) {
            return java.lang.Float.valueOf(io.dcloud.nineoldandroids.view.animation.AnimatorProxy.wrap(view).getRotationY());
        }
    };
    static io.dcloud.nineoldandroids.util.Property<android.view.View, java.lang.Float> SCALE_X = new io.dcloud.nineoldandroids.util.FloatProperty<android.view.View>("scaleX") { // from class: io.dcloud.nineoldandroids.animation.PreHoneycombCompat.9
        @Override // io.dcloud.nineoldandroids.util.FloatProperty
        public void setValue(android.view.View view, float f) {
            io.dcloud.nineoldandroids.view.animation.AnimatorProxy.wrap(view).setScaleX(f);
        }

        @Override // io.dcloud.nineoldandroids.util.Property
        public java.lang.Float get(android.view.View view) {
            return java.lang.Float.valueOf(io.dcloud.nineoldandroids.view.animation.AnimatorProxy.wrap(view).getScaleX());
        }
    };
    static io.dcloud.nineoldandroids.util.Property<android.view.View, java.lang.Float> SCALE_Y = new io.dcloud.nineoldandroids.util.FloatProperty<android.view.View>("scaleY") { // from class: io.dcloud.nineoldandroids.animation.PreHoneycombCompat.10
        @Override // io.dcloud.nineoldandroids.util.FloatProperty
        public void setValue(android.view.View view, float f) {
            io.dcloud.nineoldandroids.view.animation.AnimatorProxy.wrap(view).setScaleY(f);
        }

        @Override // io.dcloud.nineoldandroids.util.Property
        public java.lang.Float get(android.view.View view) {
            return java.lang.Float.valueOf(io.dcloud.nineoldandroids.view.animation.AnimatorProxy.wrap(view).getScaleY());
        }
    };
    static io.dcloud.nineoldandroids.util.Property<android.view.View, java.lang.Integer> SCROLL_X = new io.dcloud.nineoldandroids.util.IntProperty<android.view.View>("scrollX") { // from class: io.dcloud.nineoldandroids.animation.PreHoneycombCompat.11
        @Override // io.dcloud.nineoldandroids.util.IntProperty
        public void setValue(android.view.View view, int i) {
            io.dcloud.nineoldandroids.view.animation.AnimatorProxy.wrap(view).setScrollX(i);
        }

        @Override // io.dcloud.nineoldandroids.util.Property
        public java.lang.Integer get(android.view.View view) {
            return java.lang.Integer.valueOf(io.dcloud.nineoldandroids.view.animation.AnimatorProxy.wrap(view).getScrollX());
        }
    };
    static io.dcloud.nineoldandroids.util.Property<android.view.View, java.lang.Integer> SCROLL_Y = new io.dcloud.nineoldandroids.util.IntProperty<android.view.View>("scrollY") { // from class: io.dcloud.nineoldandroids.animation.PreHoneycombCompat.12
        @Override // io.dcloud.nineoldandroids.util.IntProperty
        public void setValue(android.view.View view, int i) {
            io.dcloud.nineoldandroids.view.animation.AnimatorProxy.wrap(view).setScrollY(i);
        }

        @Override // io.dcloud.nineoldandroids.util.Property
        public java.lang.Integer get(android.view.View view) {
            return java.lang.Integer.valueOf(io.dcloud.nineoldandroids.view.animation.AnimatorProxy.wrap(view).getScrollY());
        }
    };
    static io.dcloud.nineoldandroids.util.Property<android.view.View, java.lang.Float> X = new io.dcloud.nineoldandroids.util.FloatProperty<android.view.View>(com.taobao.weex.common.Constants.Name.X) { // from class: io.dcloud.nineoldandroids.animation.PreHoneycombCompat.13
        @Override // io.dcloud.nineoldandroids.util.FloatProperty
        public void setValue(android.view.View view, float f) {
            io.dcloud.nineoldandroids.view.animation.AnimatorProxy.wrap(view).setX(f);
        }

        @Override // io.dcloud.nineoldandroids.util.Property
        public java.lang.Float get(android.view.View view) {
            return java.lang.Float.valueOf(io.dcloud.nineoldandroids.view.animation.AnimatorProxy.wrap(view).getX());
        }
    };
    static io.dcloud.nineoldandroids.util.Property<android.view.View, java.lang.Float> Y = new io.dcloud.nineoldandroids.util.FloatProperty<android.view.View>(com.taobao.weex.common.Constants.Name.Y) { // from class: io.dcloud.nineoldandroids.animation.PreHoneycombCompat.14
        @Override // io.dcloud.nineoldandroids.util.FloatProperty
        public void setValue(android.view.View view, float f) {
            io.dcloud.nineoldandroids.view.animation.AnimatorProxy.wrap(view).setY(f);
        }

        @Override // io.dcloud.nineoldandroids.util.Property
        public java.lang.Float get(android.view.View view) {
            return java.lang.Float.valueOf(io.dcloud.nineoldandroids.view.animation.AnimatorProxy.wrap(view).getY());
        }
    };

    private PreHoneycombCompat() {
    }
}
