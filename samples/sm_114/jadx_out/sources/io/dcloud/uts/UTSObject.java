package io.dcloud.uts;

/* JADX INFO: compiled from: UTSObject.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010(\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0016\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0002J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0096\u0002J\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0096\u0002J\u001b\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u0096\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lio/dcloud/uts/UTSObject;", "Lio/dcloud/uts/IUTSObject;", "<init>", "()V", io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_TARGET, "", "propertyFields", "", "Ljava/lang/reflect/Field;", "init", "", "iterator", "", "", "get", "propertyName", "set", "value", "Companion", "utsplugin_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class UTSObject implements io.dcloud.uts.IUTSObject {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final io.dcloud.uts.UTSObject.Companion INSTANCE = new io.dcloud.uts.UTSObject.Companion(null);
    private transient java.util.List<java.lang.reflect.Field> propertyFields;
    private transient java.lang.Object target;

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean init$lambda$0(java.lang.reflect.Field it) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(it, "it");
        return java.lang.reflect.Modifier.isPublic(it.getModifiers()) && java.lang.reflect.Modifier.isStatic(it.getModifiers()) && java.lang.reflect.Modifier.isFinal(it.getModifiers()) && it.getName().equals("$stable");
    }

    private final void init() throws java.lang.IllegalAccessException {
        java.lang.reflect.Field field;
        kotlin.jvm.functions.Function1 function1 = new kotlin.jvm.functions.Function1() { // from class: io.dcloud.uts.UTSObject$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final java.lang.Object invoke(java.lang.Object obj) {
                return java.lang.Boolean.valueOf(io.dcloud.uts.UTSObject.init$lambda$0((java.lang.reflect.Field) obj));
            }
        };
        java.lang.reflect.Field[] declaredFields = getClass().getDeclaredFields();
        kotlin.jvm.internal.Intrinsics.checkNotNull(declaredFields);
        int length = declaredFields.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                field = null;
                break;
            }
            field = declaredFields[i];
            if (kotlin.jvm.internal.Intrinsics.areEqual(field.getName(), "__v_raw")) {
                break;
            } else {
                i++;
            }
        }
        if (field != null) {
            field.setAccessible(true);
            java.lang.Object obj = field.get(this);
            this.target = obj;
            kotlin.jvm.internal.Intrinsics.checkNotNull(obj);
            java.lang.reflect.Field[] declaredFields2 = obj.getClass().getDeclaredFields();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(declaredFields2, "getDeclaredFields(...)");
            java.util.List list = kotlin.collections.ArraysKt.toList(declaredFields2);
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (java.lang.Object obj2 : list) {
                if (!((java.lang.Boolean) function1.invoke(obj2)).booleanValue()) {
                    arrayList.add(obj2);
                }
            }
            this.propertyFields = arrayList;
            return;
        }
        this.target = this;
        java.util.List list2 = kotlin.collections.ArraysKt.toList(declaredFields);
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        for (java.lang.Object obj3 : list2) {
            if (!((java.lang.Boolean) function1.invoke(obj3)).booleanValue()) {
                arrayList2.add(obj3);
            }
        }
        this.propertyFields = arrayList2;
    }

    @Override // io.dcloud.uts.IUTSObject
    public java.util.Iterator<java.lang.String> iterator() throws java.lang.IllegalAccessException {
        if (this.target == null) {
            init();
        }
        java.util.List<java.lang.reflect.Field> list = this.propertyFields;
        kotlin.jvm.internal.Intrinsics.checkNotNull(list);
        java.util.List<java.lang.reflect.Field> list2 = list;
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(list2, 10));
        java.util.Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(((java.lang.reflect.Field) it.next()).getName());
        }
        return arrayList.iterator();
    }

    @Override // io.dcloud.uts.IUTSObject
    public java.lang.Object get(java.lang.Object propertyName) throws java.lang.IllegalAccessException {
        java.lang.Object next;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(propertyName, "propertyName");
        if (this.target == null) {
            init();
        }
        java.util.List<java.lang.reflect.Field> list = this.propertyFields;
        kotlin.jvm.internal.Intrinsics.checkNotNull(list);
        java.util.Iterator<T> it = list.iterator();
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
        return field.get(this.target);
    }

    @Override // io.dcloud.uts.IUTSObject
    public void set(java.lang.Object propertyName, java.lang.Object value) throws java.lang.IllegalAccessException {
        java.lang.Object next;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(propertyName, "propertyName");
        if (this.target == null) {
            init();
        }
        java.util.List<java.lang.reflect.Field> list = this.propertyFields;
        kotlin.jvm.internal.Intrinsics.checkNotNull(list);
        java.util.Iterator<T> it = list.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!kotlin.jvm.internal.Intrinsics.areEqual(((java.lang.reflect.Field) next).getName(), propertyName));
        java.lang.reflect.Field field = (java.lang.reflect.Field) next;
        if (field == null) {
            return;
        }
        field.setAccessible(true);
        field.set(this.target, value);
    }

    /* JADX INFO: compiled from: UTSObject.kt */
    @kotlin.Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ#\u0010\n\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"Lio/dcloud/uts/UTSObject$Companion;", "", "<init>", "()V", "hasOwn", "", "obj", "Lio/dcloud/uts/UTSObject;", io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_KEY, "", "toGenericType", "T", "value", "type", "Ljava/lang/reflect/Type;", "(Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/Object;", "utsplugin_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean hasOwn(io.dcloud.uts.UTSObject obj, java.lang.String key) throws java.lang.IllegalAccessException {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(obj, "obj");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(key, "key");
            java.util.Iterator<java.lang.String> it = obj.iterator();
            while (it.hasNext()) {
                if (kotlin.jvm.internal.Intrinsics.areEqual(it.next(), key)) {
                    return true;
                }
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final <T> T toGenericType(java.lang.Object value, java.lang.reflect.Type type) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(type, "type");
            if (!(type instanceof java.lang.Class)) {
                return value;
            }
            java.lang.Class cls = (java.lang.Class) type;
            if (!io.dcloud.uts.UTSObject.class.isAssignableFrom(cls)) {
                return value;
            }
            if (value == 0) {
                return null;
            }
            if (cls.isInstance(value)) {
                return value;
            }
            T t = (T) io.dcloud.uts.JSON.parse(io.dcloud.uts.JSON.stringify(value), type);
            kotlin.jvm.internal.Intrinsics.checkNotNull(t);
            return t;
        }
    }
}
