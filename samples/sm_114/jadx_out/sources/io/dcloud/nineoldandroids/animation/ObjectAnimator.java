package io.dcloud.nineoldandroids.animation;

/* JADX INFO: loaded from: classes2.dex */
public final class ObjectAnimator extends io.dcloud.nineoldandroids.animation.ValueAnimator {
    private static final boolean DBG = false;
    private static final java.util.Map<java.lang.String, io.dcloud.nineoldandroids.util.Property> PROXY_PROPERTIES;
    private io.dcloud.nineoldandroids.util.Property mProperty;
    private java.lang.String mPropertyName;
    private java.lang.Object mTarget;

    static {
        java.util.HashMap map = new java.util.HashMap();
        PROXY_PROPERTIES = map;
        map.put("alpha", io.dcloud.nineoldandroids.animation.PreHoneycombCompat.ALPHA);
        map.put("pivotX", io.dcloud.nineoldandroids.animation.PreHoneycombCompat.PIVOT_X);
        map.put("pivotY", io.dcloud.nineoldandroids.animation.PreHoneycombCompat.PIVOT_Y);
        map.put("translationX", io.dcloud.nineoldandroids.animation.PreHoneycombCompat.TRANSLATION_X);
        map.put("translationY", io.dcloud.nineoldandroids.animation.PreHoneycombCompat.TRANSLATION_Y);
        map.put("rotation", io.dcloud.nineoldandroids.animation.PreHoneycombCompat.ROTATION);
        map.put("rotationX", io.dcloud.nineoldandroids.animation.PreHoneycombCompat.ROTATION_X);
        map.put("rotationY", io.dcloud.nineoldandroids.animation.PreHoneycombCompat.ROTATION_Y);
        map.put("scaleX", io.dcloud.nineoldandroids.animation.PreHoneycombCompat.SCALE_X);
        map.put("scaleY", io.dcloud.nineoldandroids.animation.PreHoneycombCompat.SCALE_Y);
        map.put("scrollX", io.dcloud.nineoldandroids.animation.PreHoneycombCompat.SCROLL_X);
        map.put("scrollY", io.dcloud.nineoldandroids.animation.PreHoneycombCompat.SCROLL_Y);
        map.put(com.taobao.weex.common.Constants.Name.X, io.dcloud.nineoldandroids.animation.PreHoneycombCompat.X);
        map.put(com.taobao.weex.common.Constants.Name.Y, io.dcloud.nineoldandroids.animation.PreHoneycombCompat.Y);
    }

    public void setPropertyName(java.lang.String str) {
        if (this.mValues != null) {
            io.dcloud.nineoldandroids.animation.PropertyValuesHolder propertyValuesHolder = this.mValues[0];
            java.lang.String propertyName = propertyValuesHolder.getPropertyName();
            propertyValuesHolder.setPropertyName(str);
            this.mValuesMap.remove(propertyName);
            this.mValuesMap.put(str, propertyValuesHolder);
        }
        this.mPropertyName = str;
        this.mInitialized = false;
    }

    public void setProperty(io.dcloud.nineoldandroids.util.Property property) {
        if (this.mValues != null) {
            io.dcloud.nineoldandroids.animation.PropertyValuesHolder propertyValuesHolder = this.mValues[0];
            java.lang.String propertyName = propertyValuesHolder.getPropertyName();
            propertyValuesHolder.setProperty(property);
            this.mValuesMap.remove(propertyName);
            this.mValuesMap.put(this.mPropertyName, propertyValuesHolder);
        }
        if (this.mProperty != null) {
            this.mPropertyName = property.getName();
        }
        this.mProperty = property;
        this.mInitialized = false;
    }

    public java.lang.String getPropertyName() {
        return this.mPropertyName;
    }

    public ObjectAnimator() {
    }

    private ObjectAnimator(java.lang.Object obj, java.lang.String str) {
        this.mTarget = obj;
        setPropertyName(str);
    }

    private <T> ObjectAnimator(T t, io.dcloud.nineoldandroids.util.Property<T, ?> property) {
        this.mTarget = t;
        setProperty(property);
    }

    public static io.dcloud.nineoldandroids.animation.ObjectAnimator ofInt(java.lang.Object obj, java.lang.String str, int... iArr) {
        io.dcloud.nineoldandroids.animation.ObjectAnimator objectAnimator = new io.dcloud.nineoldandroids.animation.ObjectAnimator(obj, str);
        objectAnimator.setIntValues(iArr);
        return objectAnimator;
    }

    public static <T> io.dcloud.nineoldandroids.animation.ObjectAnimator ofInt(T t, io.dcloud.nineoldandroids.util.Property<T, java.lang.Integer> property, int... iArr) {
        io.dcloud.nineoldandroids.animation.ObjectAnimator objectAnimator = new io.dcloud.nineoldandroids.animation.ObjectAnimator(t, property);
        objectAnimator.setIntValues(iArr);
        return objectAnimator;
    }

    public static io.dcloud.nineoldandroids.animation.ObjectAnimator ofFloat(java.lang.Object obj, java.lang.String str, float... fArr) {
        io.dcloud.nineoldandroids.animation.ObjectAnimator objectAnimator = new io.dcloud.nineoldandroids.animation.ObjectAnimator(obj, str);
        objectAnimator.setFloatValues(fArr);
        return objectAnimator;
    }

    public static <T> io.dcloud.nineoldandroids.animation.ObjectAnimator ofFloat(T t, io.dcloud.nineoldandroids.util.Property<T, java.lang.Float> property, float... fArr) {
        io.dcloud.nineoldandroids.animation.ObjectAnimator objectAnimator = new io.dcloud.nineoldandroids.animation.ObjectAnimator(t, property);
        objectAnimator.setFloatValues(fArr);
        return objectAnimator;
    }

    public static io.dcloud.nineoldandroids.animation.ObjectAnimator ofObject(java.lang.Object obj, java.lang.String str, io.dcloud.nineoldandroids.animation.TypeEvaluator typeEvaluator, java.lang.Object... objArr) {
        io.dcloud.nineoldandroids.animation.ObjectAnimator objectAnimator = new io.dcloud.nineoldandroids.animation.ObjectAnimator(obj, str);
        objectAnimator.setObjectValues(objArr);
        objectAnimator.setEvaluator(typeEvaluator);
        return objectAnimator;
    }

    public static <T, V> io.dcloud.nineoldandroids.animation.ObjectAnimator ofObject(T t, io.dcloud.nineoldandroids.util.Property<T, V> property, io.dcloud.nineoldandroids.animation.TypeEvaluator<V> typeEvaluator, V... vArr) {
        io.dcloud.nineoldandroids.animation.ObjectAnimator objectAnimator = new io.dcloud.nineoldandroids.animation.ObjectAnimator(t, property);
        objectAnimator.setObjectValues(vArr);
        objectAnimator.setEvaluator(typeEvaluator);
        return objectAnimator;
    }

    public static io.dcloud.nineoldandroids.animation.ObjectAnimator ofPropertyValuesHolder(java.lang.Object obj, io.dcloud.nineoldandroids.animation.PropertyValuesHolder... propertyValuesHolderArr) {
        io.dcloud.nineoldandroids.animation.ObjectAnimator objectAnimator = new io.dcloud.nineoldandroids.animation.ObjectAnimator();
        objectAnimator.mTarget = obj;
        objectAnimator.setValues(propertyValuesHolderArr);
        return objectAnimator;
    }

    @Override // io.dcloud.nineoldandroids.animation.ValueAnimator
    public void setIntValues(int... iArr) {
        if (this.mValues == null || this.mValues.length == 0) {
            io.dcloud.nineoldandroids.util.Property property = this.mProperty;
            if (property != null) {
                setValues(io.dcloud.nineoldandroids.animation.PropertyValuesHolder.ofInt((io.dcloud.nineoldandroids.util.Property<?, java.lang.Integer>) property, iArr));
                return;
            } else {
                setValues(io.dcloud.nineoldandroids.animation.PropertyValuesHolder.ofInt(this.mPropertyName, iArr));
                return;
            }
        }
        super.setIntValues(iArr);
    }

    @Override // io.dcloud.nineoldandroids.animation.ValueAnimator
    public void setFloatValues(float... fArr) {
        if (this.mValues == null || this.mValues.length == 0) {
            io.dcloud.nineoldandroids.util.Property property = this.mProperty;
            if (property != null) {
                setValues(io.dcloud.nineoldandroids.animation.PropertyValuesHolder.ofFloat((io.dcloud.nineoldandroids.util.Property<?, java.lang.Float>) property, fArr));
                return;
            } else {
                setValues(io.dcloud.nineoldandroids.animation.PropertyValuesHolder.ofFloat(this.mPropertyName, fArr));
                return;
            }
        }
        super.setFloatValues(fArr);
    }

    @Override // io.dcloud.nineoldandroids.animation.ValueAnimator
    public void setObjectValues(java.lang.Object... objArr) {
        if (this.mValues == null || this.mValues.length == 0) {
            io.dcloud.nineoldandroids.util.Property property = this.mProperty;
            if (property != null) {
                setValues(io.dcloud.nineoldandroids.animation.PropertyValuesHolder.ofObject(property, (io.dcloud.nineoldandroids.animation.TypeEvaluator) null, objArr));
                return;
            } else {
                setValues(io.dcloud.nineoldandroids.animation.PropertyValuesHolder.ofObject(this.mPropertyName, (io.dcloud.nineoldandroids.animation.TypeEvaluator) null, objArr));
                return;
            }
        }
        super.setObjectValues(objArr);
    }

    @Override // io.dcloud.nineoldandroids.animation.ValueAnimator, io.dcloud.nineoldandroids.animation.Animator
    public void start() {
        super.start();
    }

    @Override // io.dcloud.nineoldandroids.animation.ValueAnimator
    void initAnimation() {
        if (this.mInitialized) {
            return;
        }
        if (this.mProperty == null && io.dcloud.nineoldandroids.view.animation.AnimatorProxy.NEEDS_PROXY && (this.mTarget instanceof android.view.View)) {
            java.util.Map<java.lang.String, io.dcloud.nineoldandroids.util.Property> map = PROXY_PROPERTIES;
            if (map.containsKey(this.mPropertyName)) {
                setProperty(map.get(this.mPropertyName));
            }
        }
        int length = this.mValues.length;
        for (int i = 0; i < length; i++) {
            this.mValues[i].setupSetterAndGetter(this.mTarget);
        }
        super.initAnimation();
    }

    @Override // io.dcloud.nineoldandroids.animation.ValueAnimator, io.dcloud.nineoldandroids.animation.Animator
    public io.dcloud.nineoldandroids.animation.ObjectAnimator setDuration(long j) {
        super.setDuration(j);
        return this;
    }

    public java.lang.Object getTarget() {
        return this.mTarget;
    }

    @Override // io.dcloud.nineoldandroids.animation.Animator
    public void setTarget(java.lang.Object obj) {
        java.lang.Object obj2 = this.mTarget;
        if (obj2 != obj) {
            this.mTarget = obj;
            if (obj2 == null || obj == null || obj2.getClass() != obj.getClass()) {
                this.mInitialized = false;
            }
        }
    }

    @Override // io.dcloud.nineoldandroids.animation.Animator
    public void setupStartValues() {
        initAnimation();
        int length = this.mValues.length;
        for (int i = 0; i < length; i++) {
            this.mValues[i].setupStartValue(this.mTarget);
        }
    }

    @Override // io.dcloud.nineoldandroids.animation.Animator
    public void setupEndValues() {
        initAnimation();
        int length = this.mValues.length;
        for (int i = 0; i < length; i++) {
            this.mValues[i].setupEndValue(this.mTarget);
        }
    }

    @Override // io.dcloud.nineoldandroids.animation.ValueAnimator
    void animateValue(float f) {
        super.animateValue(f);
        int length = this.mValues.length;
        for (int i = 0; i < length; i++) {
            this.mValues[i].setAnimatedValue(this.mTarget);
        }
    }

    @Override // io.dcloud.nineoldandroids.animation.ValueAnimator, io.dcloud.nineoldandroids.animation.Animator
    /* JADX INFO: renamed from: clone */
    public io.dcloud.nineoldandroids.animation.ObjectAnimator m435clone() {
        return (io.dcloud.nineoldandroids.animation.ObjectAnimator) super.m435clone();
    }

    @Override // io.dcloud.nineoldandroids.animation.ValueAnimator
    public java.lang.String toString() {
        java.lang.String str = "ObjectAnimator@" + java.lang.Integer.toHexString(hashCode()) + ", target " + this.mTarget;
        if (this.mValues == null) {
            return str;
        }
        for (int i = 0; i < this.mValues.length; i++) {
            str = java.lang.String.valueOf(str) + "\n    " + this.mValues[i].toString();
        }
        return str;
    }
}
