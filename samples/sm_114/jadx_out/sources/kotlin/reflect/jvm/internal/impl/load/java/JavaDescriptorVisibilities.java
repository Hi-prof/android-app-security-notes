package kotlin.reflect.jvm.internal.impl.load.java;

/* JADX INFO: loaded from: classes2.dex */
public class JavaDescriptorVisibilities {
    public static final kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility PACKAGE_VISIBILITY;
    public static final kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility PROTECTED_AND_PACKAGE;
    public static final kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility PROTECTED_STATIC_VISIBILITY;
    private static final java.util.Map<kotlin.reflect.jvm.internal.impl.descriptors.Visibility, kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility> visibilitiesMapping;

    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        java.lang.String str = (i == 5 || i == 6) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        java.lang.Object[] objArr = new java.lang.Object[(i == 5 || i == 6) ? 2 : 3];
        switch (i) {
            case 1:
                objArr[0] = "from";
                break;
            case 2:
                objArr[0] = "first";
                break;
            case 3:
                objArr[0] = "second";
                break;
            case 4:
                objArr[0] = com.taobao.weex.common.Constants.Name.VISIBILITY;
                break;
            case 5:
            case 6:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities";
                break;
            default:
                objArr[0] = "what";
                break;
        }
        if (i == 5 || i == 6) {
            objArr[1] = "toDescriptorVisibility";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities";
        }
        if (i == 2 || i == 3) {
            objArr[2] = "areInSamePackage";
        } else if (i == 4) {
            objArr[2] = "toDescriptorVisibility";
        } else if (i != 5 && i != 6) {
            objArr[2] = "isVisibleForProtectedAndPackage";
        }
        java.lang.String str2 = java.lang.String.format(str, objArr);
        if (i != 5 && i != 6) {
            throw new java.lang.IllegalArgumentException(str2);
        }
        throw new java.lang.IllegalStateException(str2);
    }

    static {
        kotlin.reflect.jvm.internal.impl.descriptors.DelegatedDescriptorVisibility delegatedDescriptorVisibility = new kotlin.reflect.jvm.internal.impl.descriptors.DelegatedDescriptorVisibility(kotlin.reflect.jvm.internal.impl.descriptors.java.JavaVisibilities.PackageVisibility.INSTANCE) { // from class: kotlin.reflect.jvm.internal.impl.load.java.JavaDescriptorVisibilities.1
            private static /* synthetic */ void $$$reportNull$$$0(int i) {
                java.lang.Object[] objArr = new java.lang.Object[3];
                if (i == 1) {
                    objArr[0] = "from";
                } else if (i == 2) {
                    objArr[0] = "fromPackage";
                } else if (i != 3) {
                    objArr[0] = "what";
                } else {
                    objArr[0] = "myPackage";
                }
                objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities$1";
                if (i == 2 || i == 3) {
                    objArr[2] = "visibleFromPackage";
                } else {
                    objArr[2] = "isVisible";
                }
                throw new java.lang.IllegalArgumentException(java.lang.String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
            }

            @Override // kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility
            public boolean isVisible(kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue receiverValue, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor, boolean z) {
                if (declarationDescriptorWithVisibility == null) {
                    $$$reportNull$$$0(0);
                }
                if (declarationDescriptor == null) {
                    $$$reportNull$$$0(1);
                }
                return kotlin.reflect.jvm.internal.impl.load.java.JavaDescriptorVisibilities.areInSamePackage(declarationDescriptorWithVisibility, declarationDescriptor);
            }
        };
        PACKAGE_VISIBILITY = delegatedDescriptorVisibility;
        kotlin.reflect.jvm.internal.impl.descriptors.DelegatedDescriptorVisibility delegatedDescriptorVisibility2 = new kotlin.reflect.jvm.internal.impl.descriptors.DelegatedDescriptorVisibility(kotlin.reflect.jvm.internal.impl.descriptors.java.JavaVisibilities.ProtectedStaticVisibility.INSTANCE) { // from class: kotlin.reflect.jvm.internal.impl.load.java.JavaDescriptorVisibilities.2
            private static /* synthetic */ void $$$reportNull$$$0(int i) {
                java.lang.Object[] objArr = new java.lang.Object[3];
                if (i != 1) {
                    objArr[0] = "what";
                } else {
                    objArr[0] = "from";
                }
                objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities$2";
                objArr[2] = "isVisible";
                throw new java.lang.IllegalArgumentException(java.lang.String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
            }

            @Override // kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility
            public boolean isVisible(kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue receiverValue, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor, boolean z) {
                if (declarationDescriptorWithVisibility == null) {
                    $$$reportNull$$$0(0);
                }
                if (declarationDescriptor == null) {
                    $$$reportNull$$$0(1);
                }
                return kotlin.reflect.jvm.internal.impl.load.java.JavaDescriptorVisibilities.isVisibleForProtectedAndPackage(receiverValue, declarationDescriptorWithVisibility, declarationDescriptor);
            }
        };
        PROTECTED_STATIC_VISIBILITY = delegatedDescriptorVisibility2;
        kotlin.reflect.jvm.internal.impl.descriptors.DelegatedDescriptorVisibility delegatedDescriptorVisibility3 = new kotlin.reflect.jvm.internal.impl.descriptors.DelegatedDescriptorVisibility(kotlin.reflect.jvm.internal.impl.descriptors.java.JavaVisibilities.ProtectedAndPackage.INSTANCE) { // from class: kotlin.reflect.jvm.internal.impl.load.java.JavaDescriptorVisibilities.3
            private static /* synthetic */ void $$$reportNull$$$0(int i) {
                java.lang.Object[] objArr = new java.lang.Object[3];
                if (i != 1) {
                    objArr[0] = "what";
                } else {
                    objArr[0] = "from";
                }
                objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities$3";
                objArr[2] = "isVisible";
                throw new java.lang.IllegalArgumentException(java.lang.String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
            }

            @Override // kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility
            public boolean isVisible(kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue receiverValue, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor, boolean z) {
                if (declarationDescriptorWithVisibility == null) {
                    $$$reportNull$$$0(0);
                }
                if (declarationDescriptor == null) {
                    $$$reportNull$$$0(1);
                }
                return kotlin.reflect.jvm.internal.impl.load.java.JavaDescriptorVisibilities.isVisibleForProtectedAndPackage(receiverValue, declarationDescriptorWithVisibility, declarationDescriptor);
            }
        };
        PROTECTED_AND_PACKAGE = delegatedDescriptorVisibility3;
        visibilitiesMapping = new java.util.HashMap();
        recordVisibilityMapping(delegatedDescriptorVisibility);
        recordVisibilityMapping(delegatedDescriptorVisibility2);
        recordVisibilityMapping(delegatedDescriptorVisibility3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isVisibleForProtectedAndPackage(kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue receiverValue, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptorWithVisibility == null) {
            $$$reportNull$$$0(0);
        }
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(1);
        }
        if (areInSamePackage(kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.unwrapFakeOverrideToAnyDeclaration(declarationDescriptorWithVisibility), declarationDescriptor)) {
            return true;
        }
        return kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.PROTECTED.isVisible(receiverValue, declarationDescriptorWithVisibility, declarationDescriptor, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean areInSamePackage(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor2) {
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(2);
        }
        if (declarationDescriptor2 == null) {
            $$$reportNull$$$0(3);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor packageFragmentDescriptor = (kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor) kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.getParentOfType(declarationDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor.class, false);
        kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor packageFragmentDescriptor2 = (kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor) kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.getParentOfType(declarationDescriptor2, kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor.class, false);
        return (packageFragmentDescriptor2 == null || packageFragmentDescriptor == null || !packageFragmentDescriptor.getFqName().equals(packageFragmentDescriptor2.getFqName())) ? false : true;
    }

    private static void recordVisibilityMapping(kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility descriptorVisibility) {
        visibilitiesMapping.put(descriptorVisibility.getDelegate(), descriptorVisibility);
    }

    public static kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility toDescriptorVisibility(kotlin.reflect.jvm.internal.impl.descriptors.Visibility visibility) {
        if (visibility == null) {
            $$$reportNull$$$0(4);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility descriptorVisibility = visibilitiesMapping.get(visibility);
        if (descriptorVisibility != null) {
            if (descriptorVisibility == null) {
                $$$reportNull$$$0(6);
            }
            return descriptorVisibility;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility descriptorVisibility2 = kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.toDescriptorVisibility(visibility);
        if (descriptorVisibility2 == null) {
            $$$reportNull$$$0(5);
        }
        return descriptorVisibility2;
    }
}
