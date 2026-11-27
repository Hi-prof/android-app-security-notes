package kotlin.reflect.jvm.internal.impl.descriptors;

/* JADX INFO: compiled from: Visibilities.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Visibilities {
    private static final kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.Public DEFAULT_VISIBILITY;
    public static final kotlin.reflect.jvm.internal.impl.descriptors.Visibilities INSTANCE = new kotlin.reflect.jvm.internal.impl.descriptors.Visibilities();
    private static final java.util.Map<kotlin.reflect.jvm.internal.impl.descriptors.Visibility, java.lang.Integer> ORDERED_VISIBILITIES;

    /* JADX INFO: compiled from: Visibilities.kt */
    public static final class Private extends kotlin.reflect.jvm.internal.impl.descriptors.Visibility {
        public static final kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.Private INSTANCE = new kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.Private();

        private Private() {
            super("private", false);
        }
    }

    private Visibilities() {
    }

    /* JADX INFO: compiled from: Visibilities.kt */
    public static final class PrivateToThis extends kotlin.reflect.jvm.internal.impl.descriptors.Visibility {
        public static final kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.PrivateToThis INSTANCE = new kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.PrivateToThis();

        private PrivateToThis() {
            super("private_to_this", false);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
        public java.lang.String getInternalDisplayName() {
            return "private/*private to this*/";
        }
    }

    /* JADX INFO: compiled from: Visibilities.kt */
    public static final class Protected extends kotlin.reflect.jvm.internal.impl.descriptors.Visibility {
        public static final kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.Protected INSTANCE = new kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.Protected();

        private Protected() {
            super("protected", true);
        }
    }

    /* JADX INFO: compiled from: Visibilities.kt */
    public static final class Internal extends kotlin.reflect.jvm.internal.impl.descriptors.Visibility {
        public static final kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.Internal INSTANCE = new kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.Internal();

        private Internal() {
            super("internal", false);
        }
    }

    /* JADX INFO: compiled from: Visibilities.kt */
    public static final class Public extends kotlin.reflect.jvm.internal.impl.descriptors.Visibility {
        public static final kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.Public INSTANCE = new kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.Public();

        private Public() {
            super("public", true);
        }
    }

    /* JADX INFO: compiled from: Visibilities.kt */
    public static final class Local extends kotlin.reflect.jvm.internal.impl.descriptors.Visibility {
        public static final kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.Local INSTANCE = new kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.Local();

        private Local() {
            super(com.taobao.weex.common.Constants.Scheme.LOCAL, false);
        }
    }

    /* JADX INFO: compiled from: Visibilities.kt */
    public static final class Inherited extends kotlin.reflect.jvm.internal.impl.descriptors.Visibility {
        public static final kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.Inherited INSTANCE = new kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.Inherited();

        private Inherited() {
            super("inherited", false);
        }
    }

    /* JADX INFO: compiled from: Visibilities.kt */
    public static final class InvisibleFake extends kotlin.reflect.jvm.internal.impl.descriptors.Visibility {
        public static final kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.InvisibleFake INSTANCE = new kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.InvisibleFake();

        private InvisibleFake() {
            super("invisible_fake", false);
        }
    }

    /* JADX INFO: compiled from: Visibilities.kt */
    public static final class Unknown extends kotlin.reflect.jvm.internal.impl.descriptors.Visibility {
        public static final kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.Unknown INSTANCE = new kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.Unknown();

        private Unknown() {
            super("unknown", false);
        }
    }

    static {
        java.util.Map mapCreateMapBuilder = kotlin.collections.MapsKt.createMapBuilder();
        mapCreateMapBuilder.put(kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.PrivateToThis.INSTANCE, 0);
        mapCreateMapBuilder.put(kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.Private.INSTANCE, 0);
        mapCreateMapBuilder.put(kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.Internal.INSTANCE, 1);
        mapCreateMapBuilder.put(kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.Protected.INSTANCE, 1);
        mapCreateMapBuilder.put(kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.Public.INSTANCE, 2);
        ORDERED_VISIBILITIES = kotlin.collections.MapsKt.build(mapCreateMapBuilder);
        DEFAULT_VISIBILITY = kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.Public.INSTANCE;
    }

    public final java.lang.Integer compareLocal$compiler_common(kotlin.reflect.jvm.internal.impl.descriptors.Visibility first, kotlin.reflect.jvm.internal.impl.descriptors.Visibility second) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(first, "first");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(second, "second");
        if (first == second) {
            return 0;
        }
        java.util.Map<kotlin.reflect.jvm.internal.impl.descriptors.Visibility, java.lang.Integer> map = ORDERED_VISIBILITIES;
        java.lang.Integer num = map.get(first);
        java.lang.Integer num2 = map.get(second);
        if (num == null || num2 == null || kotlin.jvm.internal.Intrinsics.areEqual(num, num2)) {
            return null;
        }
        return java.lang.Integer.valueOf(num.intValue() - num2.intValue());
    }

    public final boolean isPrivate(kotlin.reflect.jvm.internal.impl.descriptors.Visibility visibility) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(visibility, "visibility");
        return visibility == kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.Private.INSTANCE || visibility == kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.PrivateToThis.INSTANCE;
    }
}
