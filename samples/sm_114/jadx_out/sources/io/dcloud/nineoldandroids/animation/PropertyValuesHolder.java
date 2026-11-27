package io.dcloud.nineoldandroids.animation;

/* JADX INFO: loaded from: classes2.dex */
public class PropertyValuesHolder implements java.lang.Cloneable {
    private java.lang.Object mAnimatedValue;
    private io.dcloud.nineoldandroids.animation.TypeEvaluator mEvaluator;
    private java.lang.reflect.Method mGetter;
    io.dcloud.nineoldandroids.animation.KeyframeSet mKeyframeSet;
    protected io.dcloud.nineoldandroids.util.Property mProperty;
    final java.util.concurrent.locks.ReentrantReadWriteLock mPropertyMapLock;
    java.lang.String mPropertyName;
    java.lang.reflect.Method mSetter;
    final java.lang.Object[] mTmpValueArray;
    java.lang.Class mValueType;
    private static final io.dcloud.nineoldandroids.animation.TypeEvaluator sIntEvaluator = new io.dcloud.nineoldandroids.animation.IntEvaluator();
    private static final io.dcloud.nineoldandroids.animation.TypeEvaluator sFloatEvaluator = new io.dcloud.nineoldandroids.animation.FloatEvaluator();
    private static java.lang.Class[] FLOAT_VARIANTS = {java.lang.Float.TYPE, java.lang.Float.class, java.lang.Double.TYPE, java.lang.Integer.TYPE, java.lang.Double.class, java.lang.Integer.class};
    private static java.lang.Class[] INTEGER_VARIANTS = {java.lang.Integer.TYPE, java.lang.Integer.class, java.lang.Float.TYPE, java.lang.Double.TYPE, java.lang.Float.class, java.lang.Double.class};
    private static java.lang.Class[] DOUBLE_VARIANTS = {java.lang.Double.TYPE, java.lang.Double.class, java.lang.Float.TYPE, java.lang.Integer.TYPE, java.lang.Float.class, java.lang.Integer.class};
    private static final java.util.HashMap<java.lang.Class, java.util.HashMap<java.lang.String, java.lang.reflect.Method>> sSetterPropertyMap = new java.util.HashMap<>();
    private static final java.util.HashMap<java.lang.Class, java.util.HashMap<java.lang.String, java.lang.reflect.Method>> sGetterPropertyMap = new java.util.HashMap<>();

    private PropertyValuesHolder(java.lang.String str) {
        this.mSetter = null;
        this.mGetter = null;
        this.mKeyframeSet = null;
        this.mPropertyMapLock = new java.util.concurrent.locks.ReentrantReadWriteLock();
        this.mTmpValueArray = new java.lang.Object[1];
        this.mPropertyName = str;
    }

    /* synthetic */ PropertyValuesHolder(java.lang.String str, io.dcloud.nineoldandroids.animation.PropertyValuesHolder propertyValuesHolder) {
        this(str);
    }

    private PropertyValuesHolder(io.dcloud.nineoldandroids.util.Property property) {
        this.mSetter = null;
        this.mGetter = null;
        this.mKeyframeSet = null;
        this.mPropertyMapLock = new java.util.concurrent.locks.ReentrantReadWriteLock();
        this.mTmpValueArray = new java.lang.Object[1];
        this.mProperty = property;
        if (property != null) {
            this.mPropertyName = property.getName();
        }
    }

    /* synthetic */ PropertyValuesHolder(io.dcloud.nineoldandroids.util.Property property, io.dcloud.nineoldandroids.animation.PropertyValuesHolder propertyValuesHolder) {
        this(property);
    }

    public static io.dcloud.nineoldandroids.animation.PropertyValuesHolder ofInt(java.lang.String str, int... iArr) {
        return new io.dcloud.nineoldandroids.animation.PropertyValuesHolder.IntPropertyValuesHolder(str, iArr);
    }

    public static io.dcloud.nineoldandroids.animation.PropertyValuesHolder ofInt(io.dcloud.nineoldandroids.util.Property<?, java.lang.Integer> property, int... iArr) {
        return new io.dcloud.nineoldandroids.animation.PropertyValuesHolder.IntPropertyValuesHolder(property, iArr);
    }

    public static io.dcloud.nineoldandroids.animation.PropertyValuesHolder ofFloat(java.lang.String str, float... fArr) {
        return new io.dcloud.nineoldandroids.animation.PropertyValuesHolder.FloatPropertyValuesHolder(str, fArr);
    }

    public static io.dcloud.nineoldandroids.animation.PropertyValuesHolder ofFloat(io.dcloud.nineoldandroids.util.Property<?, java.lang.Float> property, float... fArr) {
        return new io.dcloud.nineoldandroids.animation.PropertyValuesHolder.FloatPropertyValuesHolder(property, fArr);
    }

    public static io.dcloud.nineoldandroids.animation.PropertyValuesHolder ofObject(java.lang.String str, io.dcloud.nineoldandroids.animation.TypeEvaluator typeEvaluator, java.lang.Object... objArr) {
        io.dcloud.nineoldandroids.animation.PropertyValuesHolder propertyValuesHolder = new io.dcloud.nineoldandroids.animation.PropertyValuesHolder(str);
        propertyValuesHolder.setObjectValues(objArr);
        propertyValuesHolder.setEvaluator(typeEvaluator);
        return propertyValuesHolder;
    }

    public static <V> io.dcloud.nineoldandroids.animation.PropertyValuesHolder ofObject(io.dcloud.nineoldandroids.util.Property property, io.dcloud.nineoldandroids.animation.TypeEvaluator<V> typeEvaluator, V... vArr) {
        io.dcloud.nineoldandroids.animation.PropertyValuesHolder propertyValuesHolder = new io.dcloud.nineoldandroids.animation.PropertyValuesHolder(property);
        propertyValuesHolder.setObjectValues(vArr);
        propertyValuesHolder.setEvaluator(typeEvaluator);
        return propertyValuesHolder;
    }

    public static io.dcloud.nineoldandroids.animation.PropertyValuesHolder ofKeyframe(java.lang.String str, io.dcloud.nineoldandroids.animation.Keyframe... keyframeArr) {
        io.dcloud.nineoldandroids.animation.KeyframeSet keyframeSetOfKeyframe = io.dcloud.nineoldandroids.animation.KeyframeSet.ofKeyframe(keyframeArr);
        if (keyframeSetOfKeyframe instanceof io.dcloud.nineoldandroids.animation.IntKeyframeSet) {
            return new io.dcloud.nineoldandroids.animation.PropertyValuesHolder.IntPropertyValuesHolder(str, (io.dcloud.nineoldandroids.animation.IntKeyframeSet) keyframeSetOfKeyframe);
        }
        if (keyframeSetOfKeyframe instanceof io.dcloud.nineoldandroids.animation.FloatKeyframeSet) {
            return new io.dcloud.nineoldandroids.animation.PropertyValuesHolder.FloatPropertyValuesHolder(str, (io.dcloud.nineoldandroids.animation.FloatKeyframeSet) keyframeSetOfKeyframe);
        }
        io.dcloud.nineoldandroids.animation.PropertyValuesHolder propertyValuesHolder = new io.dcloud.nineoldandroids.animation.PropertyValuesHolder(str);
        propertyValuesHolder.mKeyframeSet = keyframeSetOfKeyframe;
        propertyValuesHolder.mValueType = keyframeArr[0].getType();
        return propertyValuesHolder;
    }

    public static io.dcloud.nineoldandroids.animation.PropertyValuesHolder ofKeyframe(io.dcloud.nineoldandroids.util.Property property, io.dcloud.nineoldandroids.animation.Keyframe... keyframeArr) {
        io.dcloud.nineoldandroids.animation.KeyframeSet keyframeSetOfKeyframe = io.dcloud.nineoldandroids.animation.KeyframeSet.ofKeyframe(keyframeArr);
        if (keyframeSetOfKeyframe instanceof io.dcloud.nineoldandroids.animation.IntKeyframeSet) {
            return new io.dcloud.nineoldandroids.animation.PropertyValuesHolder.IntPropertyValuesHolder(property, (io.dcloud.nineoldandroids.animation.IntKeyframeSet) keyframeSetOfKeyframe);
        }
        if (keyframeSetOfKeyframe instanceof io.dcloud.nineoldandroids.animation.FloatKeyframeSet) {
            return new io.dcloud.nineoldandroids.animation.PropertyValuesHolder.FloatPropertyValuesHolder(property, (io.dcloud.nineoldandroids.animation.FloatKeyframeSet) keyframeSetOfKeyframe);
        }
        io.dcloud.nineoldandroids.animation.PropertyValuesHolder propertyValuesHolder = new io.dcloud.nineoldandroids.animation.PropertyValuesHolder(property);
        propertyValuesHolder.mKeyframeSet = keyframeSetOfKeyframe;
        propertyValuesHolder.mValueType = keyframeArr[0].getType();
        return propertyValuesHolder;
    }

    public void setIntValues(int... iArr) {
        this.mValueType = java.lang.Integer.TYPE;
        this.mKeyframeSet = io.dcloud.nineoldandroids.animation.KeyframeSet.ofInt(iArr);
    }

    public void setFloatValues(float... fArr) {
        this.mValueType = java.lang.Float.TYPE;
        this.mKeyframeSet = io.dcloud.nineoldandroids.animation.KeyframeSet.ofFloat(fArr);
    }

    public void setKeyframes(io.dcloud.nineoldandroids.animation.Keyframe... keyframeArr) {
        int length = keyframeArr.length;
        io.dcloud.nineoldandroids.animation.Keyframe[] keyframeArr2 = new io.dcloud.nineoldandroids.animation.Keyframe[java.lang.Math.max(length, 2)];
        this.mValueType = keyframeArr[0].getType();
        for (int i = 0; i < length; i++) {
            keyframeArr2[i] = keyframeArr[i];
        }
        this.mKeyframeSet = new io.dcloud.nineoldandroids.animation.KeyframeSet(keyframeArr2);
    }

    public void setObjectValues(java.lang.Object... objArr) {
        this.mValueType = objArr[0].getClass();
        this.mKeyframeSet = io.dcloud.nineoldandroids.animation.KeyframeSet.ofObject(objArr);
    }

    private java.lang.reflect.Method getPropertyFunction(java.lang.Class cls, java.lang.String str, java.lang.Class cls2) {
        java.lang.Class<?>[] clsArr;
        java.lang.String methodName = getMethodName(str, this.mPropertyName);
        java.lang.reflect.Method declaredMethod = null;
        if (cls2 == null) {
            try {
                return cls.getMethod(methodName, null);
            } catch (java.lang.NoSuchMethodException e) {
                try {
                    declaredMethod = cls.getDeclaredMethod(methodName, null);
                    declaredMethod.setAccessible(true);
                    return declaredMethod;
                } catch (java.lang.NoSuchMethodException unused) {
                    android.util.Log.e("PropertyValuesHolder", "Couldn't find no-arg method for property " + this.mPropertyName + ": " + e);
                    return declaredMethod;
                }
            }
        }
        if (this.mValueType.equals(java.lang.Float.class)) {
            clsArr = FLOAT_VARIANTS;
        } else if (this.mValueType.equals(java.lang.Integer.class)) {
            clsArr = INTEGER_VARIANTS;
        } else if (this.mValueType.equals(java.lang.Double.class)) {
            clsArr = DOUBLE_VARIANTS;
        } else {
            clsArr = new java.lang.Class[]{this.mValueType};
        }
        for (java.lang.Class<?> cls3 : clsArr) {
            java.lang.Class<?>[] clsArr2 = {cls3};
            try {
                try {
                    java.lang.reflect.Method method = cls.getMethod(methodName, clsArr2);
                    this.mValueType = cls3;
                    return method;
                } catch (java.lang.NoSuchMethodException unused2) {
                }
            } catch (java.lang.NoSuchMethodException unused3) {
                declaredMethod = cls.getDeclaredMethod(methodName, clsArr2);
                declaredMethod.setAccessible(true);
                this.mValueType = cls3;
                return declaredMethod;
            }
        }
        android.util.Log.e("PropertyValuesHolder", "Couldn't find setter/getter for property " + this.mPropertyName + " with value type " + this.mValueType);
        return declaredMethod;
    }

    private java.lang.reflect.Method setupSetterOrGetter(java.lang.Class cls, java.util.HashMap<java.lang.Class, java.util.HashMap<java.lang.String, java.lang.reflect.Method>> map, java.lang.String str, java.lang.Class cls2) {
        try {
            this.mPropertyMapLock.writeLock().lock();
            java.util.HashMap<java.lang.String, java.lang.reflect.Method> map2 = map.get(cls);
            java.lang.reflect.Method propertyFunction = map2 != null ? map2.get(this.mPropertyName) : null;
            if (propertyFunction == null) {
                propertyFunction = getPropertyFunction(cls, str, cls2);
                if (map2 == null) {
                    map2 = new java.util.HashMap<>();
                    map.put(cls, map2);
                }
                map2.put(this.mPropertyName, propertyFunction);
            }
            return propertyFunction;
        } finally {
            this.mPropertyMapLock.writeLock().unlock();
        }
    }

    void setupSetter(java.lang.Class cls) {
        this.mSetter = setupSetterOrGetter(cls, sSetterPropertyMap, "set", this.mValueType);
    }

    private void setupGetter(java.lang.Class cls) {
        this.mGetter = setupSetterOrGetter(cls, sGetterPropertyMap, "get", null);
    }

    void setupSetterAndGetter(java.lang.Object obj) {
        io.dcloud.nineoldandroids.util.Property property = this.mProperty;
        if (property != null) {
            try {
                property.get(obj);
                for (io.dcloud.nineoldandroids.animation.Keyframe keyframe : this.mKeyframeSet.mKeyframes) {
                    if (!keyframe.hasValue()) {
                        keyframe.setValue(this.mProperty.get(obj));
                    }
                }
                return;
            } catch (java.lang.ClassCastException unused) {
                android.util.Log.e("PropertyValuesHolder", "No such property (" + this.mProperty.getName() + ") on target object " + obj + ". Trying reflection instead");
                this.mProperty = null;
            }
        }
        java.lang.Class<?> cls = obj.getClass();
        if (this.mSetter == null) {
            setupSetter(cls);
        }
        for (io.dcloud.nineoldandroids.animation.Keyframe keyframe2 : this.mKeyframeSet.mKeyframes) {
            if (!keyframe2.hasValue()) {
                if (this.mGetter == null) {
                    setupGetter(cls);
                }
                try {
                    keyframe2.setValue(this.mGetter.invoke(obj, null));
                } catch (java.lang.IllegalAccessException e) {
                    android.util.Log.e("PropertyValuesHolder", e.toString());
                } catch (java.lang.reflect.InvocationTargetException e2) {
                    android.util.Log.e("PropertyValuesHolder", e2.toString());
                }
            }
        }
    }

    private void setupValue(java.lang.Object obj, io.dcloud.nineoldandroids.animation.Keyframe keyframe) {
        io.dcloud.nineoldandroids.util.Property property = this.mProperty;
        if (property != null) {
            keyframe.setValue(property.get(obj));
        }
        try {
            if (this.mGetter == null) {
                setupGetter(obj.getClass());
            }
            keyframe.setValue(this.mGetter.invoke(obj, null));
        } catch (java.lang.IllegalAccessException e) {
            android.util.Log.e("PropertyValuesHolder", e.toString());
        } catch (java.lang.reflect.InvocationTargetException e2) {
            android.util.Log.e("PropertyValuesHolder", e2.toString());
        }
    }

    void setupStartValue(java.lang.Object obj) {
        setupValue(obj, this.mKeyframeSet.mKeyframes.get(0));
    }

    void setupEndValue(java.lang.Object obj) {
        setupValue(obj, this.mKeyframeSet.mKeyframes.get(this.mKeyframeSet.mKeyframes.size() - 1));
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public io.dcloud.nineoldandroids.animation.PropertyValuesHolder m439clone() {
        try {
            io.dcloud.nineoldandroids.animation.PropertyValuesHolder propertyValuesHolder = (io.dcloud.nineoldandroids.animation.PropertyValuesHolder) super.clone();
            propertyValuesHolder.mPropertyName = this.mPropertyName;
            propertyValuesHolder.mProperty = this.mProperty;
            propertyValuesHolder.mKeyframeSet = this.mKeyframeSet.m438clone();
            propertyValuesHolder.mEvaluator = this.mEvaluator;
            return propertyValuesHolder;
        } catch (java.lang.CloneNotSupportedException unused) {
            return null;
        }
    }

    void setAnimatedValue(java.lang.Object obj) {
        io.dcloud.nineoldandroids.util.Property property = this.mProperty;
        if (property != null) {
            property.set(obj, getAnimatedValue());
        }
        if (this.mSetter != null) {
            try {
                this.mTmpValueArray[0] = getAnimatedValue();
                this.mSetter.invoke(obj, this.mTmpValueArray);
            } catch (java.lang.IllegalAccessException e) {
                android.util.Log.e("PropertyValuesHolder", e.toString());
            } catch (java.lang.reflect.InvocationTargetException e2) {
                android.util.Log.e("PropertyValuesHolder", e2.toString());
            }
        }
    }

    void init() {
        io.dcloud.nineoldandroids.animation.TypeEvaluator typeEvaluator;
        if (this.mEvaluator == null) {
            java.lang.Class cls = this.mValueType;
            if (cls == java.lang.Integer.class) {
                typeEvaluator = sIntEvaluator;
            } else {
                typeEvaluator = cls == java.lang.Float.class ? sFloatEvaluator : null;
            }
            this.mEvaluator = typeEvaluator;
        }
        io.dcloud.nineoldandroids.animation.TypeEvaluator typeEvaluator2 = this.mEvaluator;
        if (typeEvaluator2 != null) {
            this.mKeyframeSet.setEvaluator(typeEvaluator2);
        }
    }

    public void setEvaluator(io.dcloud.nineoldandroids.animation.TypeEvaluator typeEvaluator) {
        this.mEvaluator = typeEvaluator;
        this.mKeyframeSet.setEvaluator(typeEvaluator);
    }

    void calculateValue(float f) {
        this.mAnimatedValue = this.mKeyframeSet.getValue(f);
    }

    public void setPropertyName(java.lang.String str) {
        this.mPropertyName = str;
    }

    public void setProperty(io.dcloud.nineoldandroids.util.Property property) {
        this.mProperty = property;
    }

    public java.lang.String getPropertyName() {
        return this.mPropertyName;
    }

    java.lang.Object getAnimatedValue() {
        return this.mAnimatedValue;
    }

    public java.lang.String toString() {
        return java.lang.String.valueOf(this.mPropertyName) + ": " + this.mKeyframeSet.toString();
    }

    static java.lang.String getMethodName(java.lang.String str, java.lang.String str2) {
        if (str2 == null || str2.length() == 0) {
            return str;
        }
        return java.lang.String.valueOf(str) + java.lang.Character.toUpperCase(str2.charAt(0)) + str2.substring(1);
    }

    static class IntPropertyValuesHolder extends io.dcloud.nineoldandroids.animation.PropertyValuesHolder {
        int mIntAnimatedValue;
        io.dcloud.nineoldandroids.animation.IntKeyframeSet mIntKeyframeSet;
        private io.dcloud.nineoldandroids.util.IntProperty mIntProperty;

        public IntPropertyValuesHolder(java.lang.String str, io.dcloud.nineoldandroids.animation.IntKeyframeSet intKeyframeSet) {
            super(str, (io.dcloud.nineoldandroids.animation.PropertyValuesHolder) null);
            this.mValueType = java.lang.Integer.TYPE;
            this.mKeyframeSet = intKeyframeSet;
            this.mIntKeyframeSet = (io.dcloud.nineoldandroids.animation.IntKeyframeSet) this.mKeyframeSet;
        }

        public IntPropertyValuesHolder(io.dcloud.nineoldandroids.util.Property property, io.dcloud.nineoldandroids.animation.IntKeyframeSet intKeyframeSet) {
            super(property, (io.dcloud.nineoldandroids.animation.PropertyValuesHolder) null);
            this.mValueType = java.lang.Integer.TYPE;
            this.mKeyframeSet = intKeyframeSet;
            this.mIntKeyframeSet = (io.dcloud.nineoldandroids.animation.IntKeyframeSet) this.mKeyframeSet;
            if (property instanceof io.dcloud.nineoldandroids.util.IntProperty) {
                this.mIntProperty = (io.dcloud.nineoldandroids.util.IntProperty) this.mProperty;
            }
        }

        public IntPropertyValuesHolder(java.lang.String str, int... iArr) {
            super(str, (io.dcloud.nineoldandroids.animation.PropertyValuesHolder) null);
            setIntValues(iArr);
        }

        public IntPropertyValuesHolder(io.dcloud.nineoldandroids.util.Property property, int... iArr) {
            super(property, (io.dcloud.nineoldandroids.animation.PropertyValuesHolder) null);
            setIntValues(iArr);
            if (property instanceof io.dcloud.nineoldandroids.util.IntProperty) {
                this.mIntProperty = (io.dcloud.nineoldandroids.util.IntProperty) this.mProperty;
            }
        }

        @Override // io.dcloud.nineoldandroids.animation.PropertyValuesHolder
        public void setIntValues(int... iArr) {
            super.setIntValues(iArr);
            this.mIntKeyframeSet = (io.dcloud.nineoldandroids.animation.IntKeyframeSet) this.mKeyframeSet;
        }

        @Override // io.dcloud.nineoldandroids.animation.PropertyValuesHolder
        void calculateValue(float f) {
            this.mIntAnimatedValue = this.mIntKeyframeSet.getIntValue(f);
        }

        @Override // io.dcloud.nineoldandroids.animation.PropertyValuesHolder
        java.lang.Object getAnimatedValue() {
            return java.lang.Integer.valueOf(this.mIntAnimatedValue);
        }

        @Override // io.dcloud.nineoldandroids.animation.PropertyValuesHolder
        /* JADX INFO: renamed from: clone */
        public io.dcloud.nineoldandroids.animation.PropertyValuesHolder.IntPropertyValuesHolder m439clone() {
            io.dcloud.nineoldandroids.animation.PropertyValuesHolder.IntPropertyValuesHolder intPropertyValuesHolder = (io.dcloud.nineoldandroids.animation.PropertyValuesHolder.IntPropertyValuesHolder) super.m439clone();
            intPropertyValuesHolder.mIntKeyframeSet = (io.dcloud.nineoldandroids.animation.IntKeyframeSet) intPropertyValuesHolder.mKeyframeSet;
            return intPropertyValuesHolder;
        }

        @Override // io.dcloud.nineoldandroids.animation.PropertyValuesHolder
        void setAnimatedValue(java.lang.Object obj) {
            io.dcloud.nineoldandroids.util.IntProperty intProperty = this.mIntProperty;
            if (intProperty != null) {
                intProperty.setValue(obj, this.mIntAnimatedValue);
                return;
            }
            if (this.mProperty != null) {
                this.mProperty.set(obj, java.lang.Integer.valueOf(this.mIntAnimatedValue));
                return;
            }
            if (this.mSetter != null) {
                try {
                    this.mTmpValueArray[0] = java.lang.Integer.valueOf(this.mIntAnimatedValue);
                    this.mSetter.invoke(obj, this.mTmpValueArray);
                } catch (java.lang.IllegalAccessException e) {
                    android.util.Log.e("PropertyValuesHolder", e.toString());
                } catch (java.lang.reflect.InvocationTargetException e2) {
                    android.util.Log.e("PropertyValuesHolder", e2.toString());
                }
            }
        }

        @Override // io.dcloud.nineoldandroids.animation.PropertyValuesHolder
        void setupSetter(java.lang.Class cls) {
            if (this.mProperty != null) {
                return;
            }
            super.setupSetter(cls);
        }
    }

    static class FloatPropertyValuesHolder extends io.dcloud.nineoldandroids.animation.PropertyValuesHolder {
        float mFloatAnimatedValue;
        io.dcloud.nineoldandroids.animation.FloatKeyframeSet mFloatKeyframeSet;
        private io.dcloud.nineoldandroids.util.FloatProperty mFloatProperty;

        public FloatPropertyValuesHolder(java.lang.String str, io.dcloud.nineoldandroids.animation.FloatKeyframeSet floatKeyframeSet) {
            super(str, (io.dcloud.nineoldandroids.animation.PropertyValuesHolder) null);
            this.mValueType = java.lang.Float.TYPE;
            this.mKeyframeSet = floatKeyframeSet;
            this.mFloatKeyframeSet = (io.dcloud.nineoldandroids.animation.FloatKeyframeSet) this.mKeyframeSet;
        }

        public FloatPropertyValuesHolder(io.dcloud.nineoldandroids.util.Property property, io.dcloud.nineoldandroids.animation.FloatKeyframeSet floatKeyframeSet) {
            super(property, (io.dcloud.nineoldandroids.animation.PropertyValuesHolder) null);
            this.mValueType = java.lang.Float.TYPE;
            this.mKeyframeSet = floatKeyframeSet;
            this.mFloatKeyframeSet = (io.dcloud.nineoldandroids.animation.FloatKeyframeSet) this.mKeyframeSet;
            if (property instanceof io.dcloud.nineoldandroids.util.FloatProperty) {
                this.mFloatProperty = (io.dcloud.nineoldandroids.util.FloatProperty) this.mProperty;
            }
        }

        public FloatPropertyValuesHolder(java.lang.String str, float... fArr) {
            super(str, (io.dcloud.nineoldandroids.animation.PropertyValuesHolder) null);
            setFloatValues(fArr);
        }

        public FloatPropertyValuesHolder(io.dcloud.nineoldandroids.util.Property property, float... fArr) {
            super(property, (io.dcloud.nineoldandroids.animation.PropertyValuesHolder) null);
            setFloatValues(fArr);
            if (property instanceof io.dcloud.nineoldandroids.util.FloatProperty) {
                this.mFloatProperty = (io.dcloud.nineoldandroids.util.FloatProperty) this.mProperty;
            }
        }

        @Override // io.dcloud.nineoldandroids.animation.PropertyValuesHolder
        public void setFloatValues(float... fArr) {
            super.setFloatValues(fArr);
            this.mFloatKeyframeSet = (io.dcloud.nineoldandroids.animation.FloatKeyframeSet) this.mKeyframeSet;
        }

        @Override // io.dcloud.nineoldandroids.animation.PropertyValuesHolder
        void calculateValue(float f) {
            this.mFloatAnimatedValue = this.mFloatKeyframeSet.getFloatValue(f);
        }

        @Override // io.dcloud.nineoldandroids.animation.PropertyValuesHolder
        java.lang.Object getAnimatedValue() {
            return java.lang.Float.valueOf(this.mFloatAnimatedValue);
        }

        @Override // io.dcloud.nineoldandroids.animation.PropertyValuesHolder
        /* JADX INFO: renamed from: clone */
        public io.dcloud.nineoldandroids.animation.PropertyValuesHolder.FloatPropertyValuesHolder m439clone() {
            io.dcloud.nineoldandroids.animation.PropertyValuesHolder.FloatPropertyValuesHolder floatPropertyValuesHolder = (io.dcloud.nineoldandroids.animation.PropertyValuesHolder.FloatPropertyValuesHolder) super.m439clone();
            floatPropertyValuesHolder.mFloatKeyframeSet = (io.dcloud.nineoldandroids.animation.FloatKeyframeSet) floatPropertyValuesHolder.mKeyframeSet;
            return floatPropertyValuesHolder;
        }

        @Override // io.dcloud.nineoldandroids.animation.PropertyValuesHolder
        void setAnimatedValue(java.lang.Object obj) {
            io.dcloud.nineoldandroids.util.FloatProperty floatProperty = this.mFloatProperty;
            if (floatProperty != null) {
                floatProperty.setValue(obj, this.mFloatAnimatedValue);
                return;
            }
            if (this.mProperty != null) {
                this.mProperty.set(obj, java.lang.Float.valueOf(this.mFloatAnimatedValue));
                return;
            }
            if (this.mSetter != null) {
                try {
                    this.mTmpValueArray[0] = java.lang.Float.valueOf(this.mFloatAnimatedValue);
                    this.mSetter.invoke(obj, this.mTmpValueArray);
                } catch (java.lang.IllegalAccessException e) {
                    android.util.Log.e("PropertyValuesHolder", e.toString());
                } catch (java.lang.reflect.InvocationTargetException e2) {
                    android.util.Log.e("PropertyValuesHolder", e2.toString());
                }
            }
        }

        @Override // io.dcloud.nineoldandroids.animation.PropertyValuesHolder
        void setupSetter(java.lang.Class cls) {
            if (this.mProperty != null) {
                return;
            }
            super.setupSetter(cls);
        }
    }
}
