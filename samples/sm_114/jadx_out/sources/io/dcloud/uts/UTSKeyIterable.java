package io.dcloud.uts;

/* JADX INFO: compiled from: UTSIterator.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016J\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\tH\u0002J\u0013\u0010\n\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000b\u001a\u00020\u0001H\u0096\u0002J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010H\u0016¨\u0006\u0011À\u0006\u0003"}, d2 = {"Lio/dcloud/uts/UTSKeyIterable;", "", "ignoredKeys", "Lio/dcloud/uts/UTSArray;", "", "getAllFields", "", "Ljava/lang/reflect/Field;", "clazz", "Ljava/lang/Class;", "get", "propertyName", "set", "", "value", "keyIterator", "Lio/dcloud/uts/UTSIterator;", "utsplugin_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface UTSKeyIterable {
    java.lang.Object get(java.lang.Object propertyName);

    io.dcloud.uts.UTSArray<java.lang.String> ignoredKeys();

    io.dcloud.uts.UTSIterator<java.lang.String> keyIterator();

    void set(java.lang.Object propertyName, java.lang.Object value);

    /* JADX INFO: renamed from: io.dcloud.uts.UTSKeyIterable$-CC, reason: invalid class name */
    /* JADX INFO: compiled from: UTSIterator.kt */
    public final /* synthetic */ class CC {
        public static java.util.List $private$getAllFields(io.dcloud.uts.UTSKeyIterable _this, java.lang.Class cls) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            while (cls != null) {
                java.util.Iterator it = kotlin.jvm.internal.ArrayIteratorKt.iterator(cls.getDeclaredFields());
                while (it.hasNext()) {
                    java.lang.reflect.Field field = (java.lang.reflect.Field) it.next();
                    kotlin.jvm.internal.Intrinsics.checkNotNull(field);
                    arrayList.add(field);
                }
                cls = cls.getSuperclass();
            }
            return arrayList;
        }

        public static java.lang.Object $default$get(io.dcloud.uts.UTSKeyIterable _this, java.lang.Object propertyName) {
            java.lang.Object next;
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(propertyName, "propertyName");
            try {
                java.util.Iterator it = $private$getAllFields(_this, _this.getClass()).iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!kotlin.jvm.internal.Intrinsics.areEqual(((java.lang.reflect.Field) next).getName(), propertyName));
                java.lang.reflect.Field field = (java.lang.reflect.Field) next;
                if (field == null) {
                    return null;
                }
                field.setAccessible(true);
                return field.get(_this);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                io.dcloud.uts.console.INSTANCE.errorV1(e);
                return null;
            }
        }

        public static void $default$set(io.dcloud.uts.UTSKeyIterable _this, java.lang.Object propertyName, java.lang.Object obj) {
            java.lang.Object next;
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(propertyName, "propertyName");
            try {
                java.util.Iterator it = $private$getAllFields(_this, _this.getClass()).iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!kotlin.jvm.internal.Intrinsics.areEqual(((java.lang.reflect.Field) next).getName(), propertyName));
                java.lang.reflect.Field field = (java.lang.reflect.Field) next;
                if (field != null) {
                    field.setAccessible(true);
                    field.set(_this, obj);
                    return;
                }
                io.dcloud.uts.console.INSTANCE.errorV1("not found field " + propertyName);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                io.dcloud.uts.console.INSTANCE.errorV1(e);
            }
        }

        public static io.dcloud.uts.UTSIterator $default$keyIterator(io.dcloud.uts.UTSKeyIterable _this) {
            kotlin.reflect.KClass orCreateKotlinClass = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(_this.getClass());
            io.dcloud.uts.UTSArray<java.lang.String> uTSArrayIgnoredKeys = _this.ignoredKeys();
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (kotlin.reflect.KProperty1 kProperty1 : kotlin.reflect.full.KClasses.getMemberProperties(orCreateKotlinClass)) {
                if (!uTSArrayIgnoredKeys.contains(kProperty1.getName())) {
                    arrayList.add(kProperty1.getName());
                }
            }
            final java.util.Iterator it = arrayList.iterator();
            return new io.dcloud.uts.UTSIterator(new kotlin.jvm.functions.Function0() { // from class: io.dcloud.uts.UTSKeyIterable$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final java.lang.Object invoke() {
                    return io.dcloud.uts.UTSKeyIterable.CC.keyIterator$lambda$2(it);
                }
            });
        }

        public static io.dcloud.uts.UTSIteratorResult<java.lang.String> keyIterator$lambda$2(java.util.Iterator<java.lang.String> it) {
            if (it.hasNext()) {
                return new io.dcloud.uts.UTSIteratorResult<>(false, it.next());
            }
            return new io.dcloud.uts.UTSIteratorResult<>(true, "");
        }

        public static io.dcloud.uts.UTSArray $default$ignoredKeys(io.dcloud.uts.UTSKeyIterable _this) {
            return new io.dcloud.uts.UTSArray();
        }
    }

    /* JADX INFO: compiled from: UTSIterator.kt */
    @kotlin.Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @java.lang.Deprecated
        public static io.dcloud.uts.UTSArray<java.lang.String> ignoredKeys(io.dcloud.uts.UTSKeyIterable uTSKeyIterable) {
            return io.dcloud.uts.UTSKeyIterable.CC.$default$ignoredKeys(uTSKeyIterable);
        }

        @java.lang.Deprecated
        public static java.lang.Object get(io.dcloud.uts.UTSKeyIterable uTSKeyIterable, java.lang.Object propertyName) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(propertyName, "propertyName");
            return io.dcloud.uts.UTSKeyIterable.CC.$default$get(uTSKeyIterable, propertyName);
        }

        @java.lang.Deprecated
        public static void set(io.dcloud.uts.UTSKeyIterable uTSKeyIterable, java.lang.Object propertyName, java.lang.Object obj) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(propertyName, "propertyName");
            io.dcloud.uts.UTSKeyIterable.CC.$default$set(uTSKeyIterable, propertyName, obj);
        }

        @java.lang.Deprecated
        public static io.dcloud.uts.UTSIterator<java.lang.String> keyIterator(io.dcloud.uts.UTSKeyIterable uTSKeyIterable) {
            return io.dcloud.uts.UTSKeyIterable.CC.$default$keyIterator(uTSKeyIterable);
        }
    }
}
