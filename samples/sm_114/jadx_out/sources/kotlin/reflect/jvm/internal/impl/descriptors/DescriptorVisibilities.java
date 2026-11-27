package kotlin.reflect.jvm.internal.impl.descriptors;

/* JADX INFO: loaded from: classes2.dex */
public class DescriptorVisibilities {
    public static final kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue ALWAYS_SUITABLE_RECEIVER;
    public static final kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility DEFAULT_VISIBILITY;

    @java.lang.Deprecated
    public static final kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue FALSE_IF_PROTECTED;
    public static final kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility INHERITED;
    public static final kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility INTERNAL;
    public static final kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility INVISIBLE_FAKE;
    public static final java.util.Set<kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility> INVISIBLE_FROM_OTHER_MODULES;
    private static final kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue IRRELEVANT_RECEIVER;
    public static final kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility LOCAL;
    private static final kotlin.reflect.jvm.internal.impl.util.ModuleVisibilityHelper MODULE_VISIBILITY_HELPER;
    private static final java.util.Map<kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility, java.lang.Integer> ORDERED_VISIBILITIES;
    public static final kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility PRIVATE;
    public static final kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility PRIVATE_TO_THIS;
    public static final kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility PROTECTED;
    public static final kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility PUBLIC;
    public static final kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility UNKNOWN;
    private static final java.util.Map<kotlin.reflect.jvm.internal.impl.descriptors.Visibility, kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility> visibilitiesMapping;

    /* JADX WARN: Code duplicated, block: B:23:0x003a  */
    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        java.lang.String str = i != 16 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        java.lang.Object[] objArr = new java.lang.Object[i != 16 ? 3 : 2];
        if (i != 1 && i != 3 && i != 5 && i != 7) {
            switch (i) {
                case 9:
                    objArr[0] = "from";
                    break;
                case 10:
                case 12:
                    objArr[0] = "first";
                    break;
                case 11:
                case 13:
                    objArr[0] = "second";
                    break;
                case 14:
                case 15:
                    objArr[0] = com.taobao.weex.common.Constants.Name.VISIBILITY;
                    break;
                case 16:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities";
                    break;
                default:
                    objArr[0] = "what";
                    break;
            }
        } else {
            objArr[0] = "from";
        }
        if (i != 16) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities";
        } else {
            objArr[1] = "toDescriptorVisibility";
        }
        switch (i) {
            case 2:
            case 3:
                objArr[2] = "isVisibleIgnoringReceiver";
                break;
            case 4:
            case 5:
                objArr[2] = "isVisibleWithAnyReceiver";
                break;
            case 6:
            case 7:
                objArr[2] = "inSameFile";
                break;
            case 8:
            case 9:
                objArr[2] = "findInvisibleMember";
                break;
            case 10:
            case 11:
                objArr[2] = "compareLocal";
                break;
            case 12:
            case 13:
                objArr[2] = "compare";
                break;
            case 14:
                objArr[2] = "isPrivate";
                break;
            case 15:
                objArr[2] = "toDescriptorVisibility";
                break;
            case 16:
                break;
            default:
                objArr[2] = "isVisible";
                break;
        }
        java.lang.String str2 = java.lang.String.format(str, objArr);
        if (i == 16) {
            throw new java.lang.IllegalStateException(str2);
        }
    }

    static {
        kotlin.reflect.jvm.internal.impl.descriptors.DelegatedDescriptorVisibility delegatedDescriptorVisibility = new kotlin.reflect.jvm.internal.impl.descriptors.DelegatedDescriptorVisibility(kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.Private.INSTANCE) { // from class: kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.1
            private static /* synthetic */ void $$$reportNull$$$0(int i) {
                java.lang.Object[] objArr = new java.lang.Object[3];
                if (i == 1) {
                    objArr[0] = "what";
                } else if (i != 2) {
                    objArr[0] = "descriptor";
                } else {
                    objArr[0] = "from";
                }
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$1";
                if (i == 1 || i == 2) {
                    objArr[2] = "isVisible";
                } else {
                    objArr[2] = "hasContainingSourceFile";
                }
                throw new java.lang.IllegalArgumentException(java.lang.String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
            }

            private boolean hasContainingSourceFile(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor) {
                if (declarationDescriptor == null) {
                    $$$reportNull$$$0(0);
                }
                return kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.getContainingSourceFile(declarationDescriptor) != kotlin.reflect.jvm.internal.impl.descriptors.SourceFile.NO_SOURCE_FILE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility
            public boolean isVisible(kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue receiverValue, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor, boolean z) {
                if (declarationDescriptorWithVisibility == 0) {
                    $$$reportNull$$$0(1);
                }
                if (declarationDescriptor == null) {
                    $$$reportNull$$$0(2);
                }
                if (kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.isTopLevelDeclaration(declarationDescriptorWithVisibility) && hasContainingSourceFile(declarationDescriptor)) {
                    return kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.inSameFile(declarationDescriptorWithVisibility, declarationDescriptor);
                }
                if (declarationDescriptorWithVisibility instanceof kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor) {
                    kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters containingDeclaration = ((kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor) declarationDescriptorWithVisibility).getContainingDeclaration();
                    if (z && kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.isSealedClass(containingDeclaration) && kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.isTopLevelDeclaration(containingDeclaration) && (declarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor) && kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.isTopLevelDeclaration(declarationDescriptor.getContainingDeclaration()) && kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.inSameFile(declarationDescriptorWithVisibility, declarationDescriptor)) {
                        return true;
                    }
                }
                while (declarationDescriptorWithVisibility != 0) {
                    declarationDescriptorWithVisibility = declarationDescriptorWithVisibility.getContainingDeclaration();
                    if (((declarationDescriptorWithVisibility instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) && !kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.isCompanionObject(declarationDescriptorWithVisibility)) || (declarationDescriptorWithVisibility instanceof kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor)) {
                        break;
                    }
                }
                if (declarationDescriptorWithVisibility == 0) {
                    return false;
                }
                while (declarationDescriptor != null) {
                    if (declarationDescriptorWithVisibility == declarationDescriptor) {
                        return true;
                    }
                    if (declarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor) {
                        return (declarationDescriptorWithVisibility instanceof kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor) && ((kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor) declarationDescriptorWithVisibility).getFqName().equals(((kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor) declarationDescriptor).getFqName()) && kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.areInSameModule(declarationDescriptor, declarationDescriptorWithVisibility);
                    }
                    declarationDescriptor = declarationDescriptor.getContainingDeclaration();
                }
                return false;
            }
        };
        PRIVATE = delegatedDescriptorVisibility;
        kotlin.reflect.jvm.internal.impl.descriptors.DelegatedDescriptorVisibility delegatedDescriptorVisibility2 = new kotlin.reflect.jvm.internal.impl.descriptors.DelegatedDescriptorVisibility(kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.PrivateToThis.INSTANCE) { // from class: kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.2
            private static /* synthetic */ void $$$reportNull$$$0(int i) {
                java.lang.Object[] objArr = new java.lang.Object[3];
                if (i != 1) {
                    objArr[0] = "what";
                } else {
                    objArr[0] = "from";
                }
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$2";
                objArr[2] = "isVisible";
                throw new java.lang.IllegalArgumentException(java.lang.String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
            }

            @Override // kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility
            public boolean isVisible(kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue receiverValue, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor, boolean z) {
                kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor parentOfType;
                if (declarationDescriptorWithVisibility == null) {
                    $$$reportNull$$$0(0);
                }
                if (declarationDescriptor == null) {
                    $$$reportNull$$$0(1);
                }
                if (kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.PRIVATE.isVisible(receiverValue, declarationDescriptorWithVisibility, declarationDescriptor, z)) {
                    if (receiverValue == kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.ALWAYS_SUITABLE_RECEIVER) {
                        return true;
                    }
                    if (receiverValue != kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.IRRELEVANT_RECEIVER && (parentOfType = kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.getParentOfType(declarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor.class)) != null && (receiverValue instanceof kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ThisClassReceiver)) {
                        return ((kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ThisClassReceiver) receiverValue).getClassDescriptor().getOriginal().equals(parentOfType.getOriginal());
                    }
                }
                return false;
            }
        };
        PRIVATE_TO_THIS = delegatedDescriptorVisibility2;
        kotlin.reflect.jvm.internal.impl.descriptors.DelegatedDescriptorVisibility delegatedDescriptorVisibility3 = new kotlin.reflect.jvm.internal.impl.descriptors.DelegatedDescriptorVisibility(kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.Protected.INSTANCE) { // from class: kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.3
            private static /* synthetic */ void $$$reportNull$$$0(int i) {
                java.lang.Object[] objArr = new java.lang.Object[3];
                if (i == 1) {
                    objArr[0] = "from";
                } else if (i == 2) {
                    objArr[0] = "whatDeclaration";
                } else if (i != 3) {
                    objArr[0] = "what";
                } else {
                    objArr[0] = "fromClass";
                }
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$3";
                if (i == 2 || i == 3) {
                    objArr[2] = "doesReceiverFitForProtectedVisibility";
                } else {
                    objArr[2] = "isVisible";
                }
                throw new java.lang.IllegalArgumentException(java.lang.String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
            }

            @Override // kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility
            public boolean isVisible(kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue receiverValue, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor, boolean z) {
                kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor;
                if (declarationDescriptorWithVisibility == null) {
                    $$$reportNull$$$0(0);
                }
                if (declarationDescriptor == null) {
                    $$$reportNull$$$0(1);
                }
                kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor2 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.getParentOfType(declarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor.class);
                kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor3 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.getParentOfType(declarationDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor.class, false);
                if (classDescriptor3 == null) {
                    return false;
                }
                if (classDescriptor2 != null && kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.isCompanionObject(classDescriptor2) && (classDescriptor = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.getParentOfType(classDescriptor2, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor.class)) != null && kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.isSubclass(classDescriptor3, classDescriptor)) {
                    return true;
                }
                kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility declarationDescriptorWithVisibilityUnwrapFakeOverrideToAnyDeclaration = kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.unwrapFakeOverrideToAnyDeclaration(declarationDescriptorWithVisibility);
                kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor4 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.getParentOfType(declarationDescriptorWithVisibilityUnwrapFakeOverrideToAnyDeclaration, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor.class);
                if (classDescriptor4 == null) {
                    return false;
                }
                if (kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.isSubclass(classDescriptor3, classDescriptor4) && doesReceiverFitForProtectedVisibility(receiverValue, declarationDescriptorWithVisibilityUnwrapFakeOverrideToAnyDeclaration, classDescriptor3)) {
                    return true;
                }
                return isVisible(receiverValue, declarationDescriptorWithVisibility, classDescriptor3.getContainingDeclaration(), z);
            }

            private boolean doesReceiverFitForProtectedVisibility(kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue receiverValue, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor) {
                kotlin.reflect.jvm.internal.impl.types.KotlinType type;
                if (declarationDescriptorWithVisibility == null) {
                    $$$reportNull$$$0(2);
                }
                if (classDescriptor == null) {
                    $$$reportNull$$$0(3);
                }
                if (receiverValue == kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.FALSE_IF_PROTECTED) {
                    return false;
                }
                if (!(declarationDescriptorWithVisibility instanceof kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) || (declarationDescriptorWithVisibility instanceof kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor) || receiverValue == kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.ALWAYS_SUITABLE_RECEIVER) {
                    return true;
                }
                if (receiverValue == kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.IRRELEVANT_RECEIVER || receiverValue == null) {
                    return false;
                }
                if (receiverValue instanceof kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.SuperCallReceiverValue) {
                    type = ((kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.SuperCallReceiverValue) receiverValue).getThisType();
                } else {
                    type = receiverValue.getType();
                }
                return kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.isSubtypeOfClass(type, classDescriptor) || kotlin.reflect.jvm.internal.impl.types.DynamicTypesKt.isDynamic(type);
            }
        };
        PROTECTED = delegatedDescriptorVisibility3;
        kotlin.reflect.jvm.internal.impl.descriptors.DelegatedDescriptorVisibility delegatedDescriptorVisibility4 = new kotlin.reflect.jvm.internal.impl.descriptors.DelegatedDescriptorVisibility(kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.Internal.INSTANCE) { // from class: kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.4
            private static /* synthetic */ void $$$reportNull$$$0(int i) {
                java.lang.Object[] objArr = new java.lang.Object[3];
                if (i != 1) {
                    objArr[0] = "what";
                } else {
                    objArr[0] = "from";
                }
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$4";
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
                if (kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.getContainingModule(declarationDescriptor).shouldSeeInternalsOf(kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.getContainingModule(declarationDescriptorWithVisibility))) {
                    return kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.MODULE_VISIBILITY_HELPER.isInFriendModule(declarationDescriptorWithVisibility, declarationDescriptor);
                }
                return false;
            }
        };
        INTERNAL = delegatedDescriptorVisibility4;
        kotlin.reflect.jvm.internal.impl.descriptors.DelegatedDescriptorVisibility delegatedDescriptorVisibility5 = new kotlin.reflect.jvm.internal.impl.descriptors.DelegatedDescriptorVisibility(kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.Public.INSTANCE) { // from class: kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.5
            private static /* synthetic */ void $$$reportNull$$$0(int i) {
                java.lang.Object[] objArr = new java.lang.Object[3];
                if (i != 1) {
                    objArr[0] = "what";
                } else {
                    objArr[0] = "from";
                }
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$5";
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
                return true;
            }
        };
        PUBLIC = delegatedDescriptorVisibility5;
        kotlin.reflect.jvm.internal.impl.descriptors.DelegatedDescriptorVisibility delegatedDescriptorVisibility6 = new kotlin.reflect.jvm.internal.impl.descriptors.DelegatedDescriptorVisibility(kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.Local.INSTANCE) { // from class: kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.6
            private static /* synthetic */ void $$$reportNull$$$0(int i) {
                java.lang.Object[] objArr = new java.lang.Object[3];
                if (i != 1) {
                    objArr[0] = "what";
                } else {
                    objArr[0] = "from";
                }
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$6";
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
                throw new java.lang.IllegalStateException("This method shouldn't be invoked for LOCAL visibility");
            }
        };
        LOCAL = delegatedDescriptorVisibility6;
        kotlin.reflect.jvm.internal.impl.descriptors.DelegatedDescriptorVisibility delegatedDescriptorVisibility7 = new kotlin.reflect.jvm.internal.impl.descriptors.DelegatedDescriptorVisibility(kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.Inherited.INSTANCE) { // from class: kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.7
            private static /* synthetic */ void $$$reportNull$$$0(int i) {
                java.lang.Object[] objArr = new java.lang.Object[3];
                if (i != 1) {
                    objArr[0] = "what";
                } else {
                    objArr[0] = "from";
                }
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$7";
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
                throw new java.lang.IllegalStateException("Visibility is unknown yet");
            }
        };
        INHERITED = delegatedDescriptorVisibility7;
        kotlin.reflect.jvm.internal.impl.descriptors.DelegatedDescriptorVisibility delegatedDescriptorVisibility8 = new kotlin.reflect.jvm.internal.impl.descriptors.DelegatedDescriptorVisibility(kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.InvisibleFake.INSTANCE) { // from class: kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.8
            private static /* synthetic */ void $$$reportNull$$$0(int i) {
                java.lang.Object[] objArr = new java.lang.Object[3];
                if (i != 1) {
                    objArr[0] = "what";
                } else {
                    objArr[0] = "from";
                }
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$8";
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
                return false;
            }
        };
        INVISIBLE_FAKE = delegatedDescriptorVisibility8;
        kotlin.reflect.jvm.internal.impl.descriptors.DelegatedDescriptorVisibility delegatedDescriptorVisibility9 = new kotlin.reflect.jvm.internal.impl.descriptors.DelegatedDescriptorVisibility(kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.Unknown.INSTANCE) { // from class: kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.9
            private static /* synthetic */ void $$$reportNull$$$0(int i) {
                java.lang.Object[] objArr = new java.lang.Object[3];
                if (i != 1) {
                    objArr[0] = "what";
                } else {
                    objArr[0] = "from";
                }
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$9";
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
                return false;
            }
        };
        UNKNOWN = delegatedDescriptorVisibility9;
        INVISIBLE_FROM_OTHER_MODULES = java.util.Collections.unmodifiableSet(kotlin.collections.SetsKt.setOf((java.lang.Object[]) new kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility[]{delegatedDescriptorVisibility, delegatedDescriptorVisibility2, delegatedDescriptorVisibility4, delegatedDescriptorVisibility6}));
        java.util.HashMap mapNewHashMapWithExpectedSize = kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.newHashMapWithExpectedSize(4);
        mapNewHashMapWithExpectedSize.put(delegatedDescriptorVisibility2, 0);
        mapNewHashMapWithExpectedSize.put(delegatedDescriptorVisibility, 0);
        mapNewHashMapWithExpectedSize.put(delegatedDescriptorVisibility4, 1);
        mapNewHashMapWithExpectedSize.put(delegatedDescriptorVisibility3, 1);
        mapNewHashMapWithExpectedSize.put(delegatedDescriptorVisibility5, 2);
        ORDERED_VISIBILITIES = java.util.Collections.unmodifiableMap(mapNewHashMapWithExpectedSize);
        DEFAULT_VISIBILITY = delegatedDescriptorVisibility5;
        IRRELEVANT_RECEIVER = new kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.10
            @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue
            public kotlin.reflect.jvm.internal.impl.types.KotlinType getType() {
                throw new java.lang.IllegalStateException("This method should not be called");
            }
        };
        ALWAYS_SUITABLE_RECEIVER = new kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.11
            @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue
            public kotlin.reflect.jvm.internal.impl.types.KotlinType getType() {
                throw new java.lang.IllegalStateException("This method should not be called");
            }
        };
        FALSE_IF_PROTECTED = new kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.12
            @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue
            public kotlin.reflect.jvm.internal.impl.types.KotlinType getType() {
                throw new java.lang.IllegalStateException("This method should not be called");
            }
        };
        java.util.Iterator it = java.util.ServiceLoader.load(kotlin.reflect.jvm.internal.impl.util.ModuleVisibilityHelper.class, kotlin.reflect.jvm.internal.impl.util.ModuleVisibilityHelper.class.getClassLoader()).iterator();
        MODULE_VISIBILITY_HELPER = it.hasNext() ? (kotlin.reflect.jvm.internal.impl.util.ModuleVisibilityHelper) it.next() : kotlin.reflect.jvm.internal.impl.util.ModuleVisibilityHelper.EMPTY.INSTANCE;
        visibilitiesMapping = new java.util.HashMap();
        recordVisibilityMapping(delegatedDescriptorVisibility);
        recordVisibilityMapping(delegatedDescriptorVisibility2);
        recordVisibilityMapping(delegatedDescriptorVisibility3);
        recordVisibilityMapping(delegatedDescriptorVisibility4);
        recordVisibilityMapping(delegatedDescriptorVisibility5);
        recordVisibilityMapping(delegatedDescriptorVisibility6);
        recordVisibilityMapping(delegatedDescriptorVisibility7);
        recordVisibilityMapping(delegatedDescriptorVisibility8);
        recordVisibilityMapping(delegatedDescriptorVisibility9);
    }

    public static boolean isVisibleIgnoringReceiver(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor, boolean z) {
        if (declarationDescriptorWithVisibility == null) {
            $$$reportNull$$$0(2);
        }
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(3);
        }
        return findInvisibleMember(ALWAYS_SUITABLE_RECEIVER, declarationDescriptorWithVisibility, declarationDescriptor, z) == null;
    }

    public static boolean inSameFile(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor2) {
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(6);
        }
        if (declarationDescriptor2 == null) {
            $$$reportNull$$$0(7);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.SourceFile containingSourceFile = kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.getContainingSourceFile(declarationDescriptor2);
        if (containingSourceFile != kotlin.reflect.jvm.internal.impl.descriptors.SourceFile.NO_SOURCE_FILE) {
            return containingSourceFile.equals(kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.getContainingSourceFile(declarationDescriptor));
        }
        return false;
    }

    public static kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility findInvisibleMember(kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue receiverValue, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor, boolean z) {
        kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility declarationDescriptorWithVisibilityFindInvisibleMember;
        if (declarationDescriptorWithVisibility == null) {
            $$$reportNull$$$0(8);
        }
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(9);
        }
        for (kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility2 = (kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility) declarationDescriptorWithVisibility.getOriginal(); declarationDescriptorWithVisibility2 != null && declarationDescriptorWithVisibility2.getVisibility() != LOCAL; declarationDescriptorWithVisibility2 = (kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility) kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.getParentOfType(declarationDescriptorWithVisibility2, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility.class)) {
            if (!declarationDescriptorWithVisibility2.getVisibility().isVisible(receiverValue, declarationDescriptorWithVisibility2, declarationDescriptor, z)) {
                return declarationDescriptorWithVisibility2;
            }
        }
        if (!(declarationDescriptorWithVisibility instanceof kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptor) || (declarationDescriptorWithVisibilityFindInvisibleMember = findInvisibleMember(receiverValue, ((kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptor) declarationDescriptorWithVisibility).getUnderlyingConstructorDescriptor(), declarationDescriptor, z)) == null) {
            return null;
        }
        return declarationDescriptorWithVisibilityFindInvisibleMember;
    }

    public static java.lang.Integer compare(kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility descriptorVisibility, kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility descriptorVisibility2) {
        if (descriptorVisibility == null) {
            $$$reportNull$$$0(12);
        }
        if (descriptorVisibility2 == null) {
            $$$reportNull$$$0(13);
        }
        java.lang.Integer numCompareTo = descriptorVisibility.compareTo(descriptorVisibility2);
        if (numCompareTo != null) {
            return numCompareTo;
        }
        java.lang.Integer numCompareTo2 = descriptorVisibility2.compareTo(descriptorVisibility);
        if (numCompareTo2 != null) {
            return java.lang.Integer.valueOf(-numCompareTo2.intValue());
        }
        return null;
    }

    public static boolean isPrivate(kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility descriptorVisibility) {
        if (descriptorVisibility == null) {
            $$$reportNull$$$0(14);
        }
        return descriptorVisibility == PRIVATE || descriptorVisibility == PRIVATE_TO_THIS;
    }

    private static void recordVisibilityMapping(kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility descriptorVisibility) {
        visibilitiesMapping.put(descriptorVisibility.getDelegate(), descriptorVisibility);
    }

    public static kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility toDescriptorVisibility(kotlin.reflect.jvm.internal.impl.descriptors.Visibility visibility) {
        if (visibility == null) {
            $$$reportNull$$$0(15);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility descriptorVisibility = visibilitiesMapping.get(visibility);
        if (descriptorVisibility != null) {
            if (descriptorVisibility == null) {
                $$$reportNull$$$0(16);
            }
            return descriptorVisibility;
        }
        throw new java.lang.IllegalArgumentException("Inapplicable visibility: " + visibility);
    }
}
