package kotlin.reflect.jvm.internal.impl.descriptors.java;

/* JADX INFO: compiled from: JavaVisibilities.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class JavaVisibilities {
    public static final kotlin.reflect.jvm.internal.impl.descriptors.java.JavaVisibilities INSTANCE = new kotlin.reflect.jvm.internal.impl.descriptors.java.JavaVisibilities();

    /* JADX INFO: compiled from: JavaVisibilities.kt */
    public static final class PackageVisibility extends kotlin.reflect.jvm.internal.impl.descriptors.Visibility {
        public static final kotlin.reflect.jvm.internal.impl.descriptors.java.JavaVisibilities.PackageVisibility INSTANCE = new kotlin.reflect.jvm.internal.impl.descriptors.java.JavaVisibilities.PackageVisibility();

        private PackageVisibility() {
            super("package", false);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
        public java.lang.Integer compareTo(kotlin.reflect.jvm.internal.impl.descriptors.Visibility visibility) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(visibility, "visibility");
            if (this == visibility) {
                return 0;
            }
            return kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.INSTANCE.isPrivate(visibility) ? 1 : -1;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
        public kotlin.reflect.jvm.internal.impl.descriptors.Visibility normalize() {
            return kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.Protected.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
        public java.lang.String getInternalDisplayName() {
            return "public/*package*/";
        }
    }

    private JavaVisibilities() {
    }

    /* JADX INFO: compiled from: JavaVisibilities.kt */
    public static final class ProtectedStaticVisibility extends kotlin.reflect.jvm.internal.impl.descriptors.Visibility {
        public static final kotlin.reflect.jvm.internal.impl.descriptors.java.JavaVisibilities.ProtectedStaticVisibility INSTANCE = new kotlin.reflect.jvm.internal.impl.descriptors.java.JavaVisibilities.ProtectedStaticVisibility();

        private ProtectedStaticVisibility() {
            super("protected_static", true);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
        public kotlin.reflect.jvm.internal.impl.descriptors.Visibility normalize() {
            return kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.Protected.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
        public java.lang.String getInternalDisplayName() {
            return "protected/*protected static*/";
        }
    }

    /* JADX INFO: compiled from: JavaVisibilities.kt */
    public static final class ProtectedAndPackage extends kotlin.reflect.jvm.internal.impl.descriptors.Visibility {
        public static final kotlin.reflect.jvm.internal.impl.descriptors.java.JavaVisibilities.ProtectedAndPackage INSTANCE = new kotlin.reflect.jvm.internal.impl.descriptors.java.JavaVisibilities.ProtectedAndPackage();

        private ProtectedAndPackage() {
            super("protected_and_package", true);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
        public java.lang.Integer compareTo(kotlin.reflect.jvm.internal.impl.descriptors.Visibility visibility) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(visibility, "visibility");
            if (kotlin.jvm.internal.Intrinsics.areEqual(this, visibility)) {
                return 0;
            }
            if (visibility == kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.Internal.INSTANCE) {
                return null;
            }
            return kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.INSTANCE.isPrivate(visibility) ? 1 : -1;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
        public kotlin.reflect.jvm.internal.impl.descriptors.Visibility normalize() {
            return kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.Protected.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
        public java.lang.String getInternalDisplayName() {
            return "protected/*protected and package*/";
        }
    }
}
