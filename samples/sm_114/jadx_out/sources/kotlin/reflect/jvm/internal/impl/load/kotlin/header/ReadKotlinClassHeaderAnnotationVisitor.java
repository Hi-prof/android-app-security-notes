package kotlin.reflect.jvm.internal.impl.load.kotlin.header;

/* JADX INFO: loaded from: classes2.dex */
public class ReadKotlinClassHeaderAnnotationVisitor implements kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor {
    private static final java.util.Map<kotlin.reflect.jvm.internal.impl.name.ClassId, kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader.Kind> HEADER_KINDS;
    private static boolean IGNORE_OLD_METADATA;
    private int[] metadataVersionArray = null;
    private java.lang.String extraString = null;
    private int extraInt = 0;
    private java.lang.String packageName = null;
    private java.lang.String[] data = null;
    private java.lang.String[] strings = null;
    private java.lang.String[] incompatibleData = null;
    private kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader.Kind headerKind = null;
    private java.lang.String[] serializedIrFields = null;

    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        java.lang.Object[] objArr = new java.lang.Object[3];
        if (i != 1) {
            objArr[0] = "classId";
        } else {
            objArr[0] = "source";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor";
        objArr[2] = "visitAnnotation";
        throw new java.lang.IllegalArgumentException(java.lang.String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor
    public void visitEnd() {
    }

    static {
        try {
            IGNORE_OLD_METADATA = io.dcloud.common.constant.AbsoluteConst.TRUE.equals(java.lang.System.getProperty("kotlin.ignore.old.metadata"));
        } catch (java.security.AccessControlException unused) {
            IGNORE_OLD_METADATA = false;
        }
        java.util.HashMap map = new java.util.HashMap();
        HEADER_KINDS = map;
        map.put(kotlin.reflect.jvm.internal.impl.name.ClassId.topLevel(new kotlin.reflect.jvm.internal.impl.name.FqName("kotlin.jvm.internal.KotlinClass")), kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader.Kind.CLASS);
        map.put(kotlin.reflect.jvm.internal.impl.name.ClassId.topLevel(new kotlin.reflect.jvm.internal.impl.name.FqName("kotlin.jvm.internal.KotlinFileFacade")), kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader.Kind.FILE_FACADE);
        map.put(kotlin.reflect.jvm.internal.impl.name.ClassId.topLevel(new kotlin.reflect.jvm.internal.impl.name.FqName("kotlin.jvm.internal.KotlinMultifileClass")), kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader.Kind.MULTIFILE_CLASS);
        map.put(kotlin.reflect.jvm.internal.impl.name.ClassId.topLevel(new kotlin.reflect.jvm.internal.impl.name.FqName("kotlin.jvm.internal.KotlinMultifileClassPart")), kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader.Kind.MULTIFILE_CLASS_PART);
        map.put(kotlin.reflect.jvm.internal.impl.name.ClassId.topLevel(new kotlin.reflect.jvm.internal.impl.name.FqName("kotlin.jvm.internal.KotlinSyntheticClass")), kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader.Kind.SYNTHETIC_CLASS);
    }

    public kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader createHeaderWithDefaultMetadataVersion() {
        return createHeader(kotlin.reflect.jvm.internal.impl.metadata.deserialization.MetadataVersion.INSTANCE);
    }

    public kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader createHeader(kotlin.reflect.jvm.internal.impl.metadata.deserialization.MetadataVersion metadataVersion) {
        if (this.headerKind == null || this.metadataVersionArray == null) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.MetadataVersion metadataVersion2 = new kotlin.reflect.jvm.internal.impl.metadata.deserialization.MetadataVersion(this.metadataVersionArray, (this.extraInt & 8) != 0);
        if (!metadataVersion2.isCompatible(metadataVersion)) {
            this.incompatibleData = this.data;
            this.data = null;
        } else if (shouldHaveData() && this.data == null) {
            return null;
        }
        java.lang.String[] strArr = this.serializedIrFields;
        return new kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader(this.headerKind, metadataVersion2, this.data, this.incompatibleData, this.strings, this.extraString, this.extraInt, this.packageName, strArr != null ? kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.BitEncoding.decodeBytes(strArr) : null);
    }

    private boolean shouldHaveData() {
        return this.headerKind == kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader.Kind.CLASS || this.headerKind == kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader.Kind.FILE_FACADE || this.headerKind == kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader.Kind.MULTIFILE_CLASS_PART;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor
    public kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(kotlin.reflect.jvm.internal.impl.name.ClassId classId, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement sourceElement) {
        kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader.Kind kind;
        if (classId == null) {
            $$$reportNull$$$0(0);
        }
        if (sourceElement == null) {
            $$$reportNull$$$0(1);
        }
        kotlin.reflect.jvm.internal.impl.name.FqName fqNameAsSingleFqName = classId.asSingleFqName();
        if (fqNameAsSingleFqName.equals(kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames.METADATA_FQ_NAME)) {
            return new kotlin.reflect.jvm.internal.impl.load.kotlin.header.ReadKotlinClassHeaderAnnotationVisitor.KotlinMetadataArgumentVisitor();
        }
        if (fqNameAsSingleFqName.equals(kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames.SERIALIZED_IR_FQ_NAME)) {
            return new kotlin.reflect.jvm.internal.impl.load.kotlin.header.ReadKotlinClassHeaderAnnotationVisitor.KotlinSerializedIrArgumentVisitor();
        }
        if (IGNORE_OLD_METADATA || this.headerKind != null || (kind = HEADER_KINDS.get(classId)) == null) {
            return null;
        }
        this.headerKind = kind;
        return new kotlin.reflect.jvm.internal.impl.load.kotlin.header.ReadKotlinClassHeaderAnnotationVisitor.OldDeprecatedAnnotationArgumentVisitor();
    }

    private class KotlinMetadataArgumentVisitor implements kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor {
        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            java.lang.Object[] objArr = new java.lang.Object[3];
            if (i == 1) {
                objArr[0] = "enumClassId";
            } else if (i == 2) {
                objArr[0] = "enumEntryName";
            } else if (i != 3) {
                objArr[0] = "classLiteralValue";
            } else {
                objArr[0] = "classId";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor";
            if (i == 1 || i == 2) {
                objArr[2] = "visitEnum";
            } else if (i != 3) {
                objArr[2] = "visitClassLiteral";
            } else {
                objArr[2] = "visitAnnotation";
            }
            throw new java.lang.IllegalArgumentException(java.lang.String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.name.ClassId classId) {
            if (classId != null) {
                return null;
            }
            $$$reportNull$$$0(3);
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitClassLiteral(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue classLiteralValue) {
            if (classLiteralValue == null) {
                $$$reportNull$$$0(0);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitEnd() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitEnum(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.name.ClassId classId, kotlin.reflect.jvm.internal.impl.name.Name name2) {
            if (classId == null) {
                $$$reportNull$$$0(1);
            }
            if (name2 == null) {
                $$$reportNull$$$0(2);
            }
        }

        private KotlinMetadataArgumentVisitor() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visit(kotlin.reflect.jvm.internal.impl.name.Name name, java.lang.Object obj) {
            if (name == null) {
                return;
            }
            java.lang.String strAsString = name.asString();
            if ("k".equals(strAsString)) {
                if (obj instanceof java.lang.Integer) {
                    kotlin.reflect.jvm.internal.impl.load.kotlin.header.ReadKotlinClassHeaderAnnotationVisitor.this.headerKind = kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader.Kind.getById(((java.lang.Integer) obj).intValue());
                    return;
                }
                return;
            }
            if ("mv".equals(strAsString)) {
                if (obj instanceof int[]) {
                    kotlin.reflect.jvm.internal.impl.load.kotlin.header.ReadKotlinClassHeaderAnnotationVisitor.this.metadataVersionArray = (int[]) obj;
                    return;
                }
                return;
            }
            if ("xs".equals(strAsString)) {
                if (obj instanceof java.lang.String) {
                    java.lang.String str = (java.lang.String) obj;
                    if (str.isEmpty()) {
                        return;
                    }
                    kotlin.reflect.jvm.internal.impl.load.kotlin.header.ReadKotlinClassHeaderAnnotationVisitor.this.extraString = str;
                    return;
                }
                return;
            }
            if ("xi".equals(strAsString)) {
                if (obj instanceof java.lang.Integer) {
                    kotlin.reflect.jvm.internal.impl.load.kotlin.header.ReadKotlinClassHeaderAnnotationVisitor.this.extraInt = ((java.lang.Integer) obj).intValue();
                    return;
                }
                return;
            }
            if ("pn".equals(strAsString) && (obj instanceof java.lang.String)) {
                java.lang.String str2 = (java.lang.String) obj;
                if (str2.isEmpty()) {
                    return;
                }
                kotlin.reflect.jvm.internal.impl.load.kotlin.header.ReadKotlinClassHeaderAnnotationVisitor.this.packageName = str2;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor visitArray(kotlin.reflect.jvm.internal.impl.name.Name name) {
            java.lang.String strAsString = name != null ? name.asString() : null;
            if ("d1".equals(strAsString)) {
                return dataArrayVisitor();
            }
            if ("d2".equals(strAsString)) {
                return stringsArrayVisitor();
            }
            return null;
        }

        private kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor dataArrayVisitor() {
            return new kotlin.reflect.jvm.internal.impl.load.kotlin.header.ReadKotlinClassHeaderAnnotationVisitor.CollectStringArrayAnnotationVisitor() { // from class: kotlin.reflect.jvm.internal.impl.load.kotlin.header.ReadKotlinClassHeaderAnnotationVisitor.KotlinMetadataArgumentVisitor.1
                private static /* synthetic */ void $$$reportNull$$$0(int i) {
                    throw new java.lang.IllegalArgumentException(java.lang.String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "result", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor$1", "visitEnd"));
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.header.ReadKotlinClassHeaderAnnotationVisitor.CollectStringArrayAnnotationVisitor
                protected void visitEnd(java.lang.String[] strArr) {
                    if (strArr == null) {
                        $$$reportNull$$$0(0);
                    }
                    kotlin.reflect.jvm.internal.impl.load.kotlin.header.ReadKotlinClassHeaderAnnotationVisitor.this.data = strArr;
                }
            };
        }

        private kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor stringsArrayVisitor() {
            return new kotlin.reflect.jvm.internal.impl.load.kotlin.header.ReadKotlinClassHeaderAnnotationVisitor.CollectStringArrayAnnotationVisitor() { // from class: kotlin.reflect.jvm.internal.impl.load.kotlin.header.ReadKotlinClassHeaderAnnotationVisitor.KotlinMetadataArgumentVisitor.2
                private static /* synthetic */ void $$$reportNull$$$0(int i) {
                    throw new java.lang.IllegalArgumentException(java.lang.String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "result", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor$2", "visitEnd"));
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.header.ReadKotlinClassHeaderAnnotationVisitor.CollectStringArrayAnnotationVisitor
                protected void visitEnd(java.lang.String[] strArr) {
                    if (strArr == null) {
                        $$$reportNull$$$0(0);
                    }
                    kotlin.reflect.jvm.internal.impl.load.kotlin.header.ReadKotlinClassHeaderAnnotationVisitor.this.strings = strArr;
                }
            };
        }
    }

    private class OldDeprecatedAnnotationArgumentVisitor implements kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor {
        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            java.lang.Object[] objArr = new java.lang.Object[3];
            if (i == 1) {
                objArr[0] = "enumClassId";
            } else if (i == 2) {
                objArr[0] = "enumEntryName";
            } else if (i != 3) {
                objArr[0] = "classLiteralValue";
            } else {
                objArr[0] = "classId";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor";
            if (i == 1 || i == 2) {
                objArr[2] = "visitEnum";
            } else if (i != 3) {
                objArr[2] = "visitClassLiteral";
            } else {
                objArr[2] = "visitAnnotation";
            }
            throw new java.lang.IllegalArgumentException(java.lang.String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.name.ClassId classId) {
            if (classId != null) {
                return null;
            }
            $$$reportNull$$$0(3);
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitClassLiteral(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue classLiteralValue) {
            if (classLiteralValue == null) {
                $$$reportNull$$$0(0);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitEnd() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitEnum(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.name.ClassId classId, kotlin.reflect.jvm.internal.impl.name.Name name2) {
            if (classId == null) {
                $$$reportNull$$$0(1);
            }
            if (name2 == null) {
                $$$reportNull$$$0(2);
            }
        }

        private OldDeprecatedAnnotationArgumentVisitor() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visit(kotlin.reflect.jvm.internal.impl.name.Name name, java.lang.Object obj) {
            if (name == null) {
                return;
            }
            java.lang.String strAsString = name.asString();
            if ("version".equals(strAsString)) {
                if (obj instanceof int[]) {
                    kotlin.reflect.jvm.internal.impl.load.kotlin.header.ReadKotlinClassHeaderAnnotationVisitor.this.metadataVersionArray = (int[]) obj;
                }
            } else if ("multifileClassName".equals(strAsString)) {
                kotlin.reflect.jvm.internal.impl.load.kotlin.header.ReadKotlinClassHeaderAnnotationVisitor.this.extraString = obj instanceof java.lang.String ? (java.lang.String) obj : null;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor visitArray(kotlin.reflect.jvm.internal.impl.name.Name name) {
            java.lang.String strAsString = name != null ? name.asString() : null;
            if ("data".equals(strAsString) || "filePartClassNames".equals(strAsString)) {
                return dataArrayVisitor();
            }
            if ("strings".equals(strAsString)) {
                return stringsArrayVisitor();
            }
            return null;
        }

        private kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor dataArrayVisitor() {
            return new kotlin.reflect.jvm.internal.impl.load.kotlin.header.ReadKotlinClassHeaderAnnotationVisitor.CollectStringArrayAnnotationVisitor() { // from class: kotlin.reflect.jvm.internal.impl.load.kotlin.header.ReadKotlinClassHeaderAnnotationVisitor.OldDeprecatedAnnotationArgumentVisitor.1
                private static /* synthetic */ void $$$reportNull$$$0(int i) {
                    throw new java.lang.IllegalArgumentException(java.lang.String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "data", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor$1", "visitEnd"));
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.header.ReadKotlinClassHeaderAnnotationVisitor.CollectStringArrayAnnotationVisitor
                protected void visitEnd(java.lang.String[] strArr) {
                    if (strArr == null) {
                        $$$reportNull$$$0(0);
                    }
                    kotlin.reflect.jvm.internal.impl.load.kotlin.header.ReadKotlinClassHeaderAnnotationVisitor.this.data = strArr;
                }
            };
        }

        private kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor stringsArrayVisitor() {
            return new kotlin.reflect.jvm.internal.impl.load.kotlin.header.ReadKotlinClassHeaderAnnotationVisitor.CollectStringArrayAnnotationVisitor() { // from class: kotlin.reflect.jvm.internal.impl.load.kotlin.header.ReadKotlinClassHeaderAnnotationVisitor.OldDeprecatedAnnotationArgumentVisitor.2
                private static /* synthetic */ void $$$reportNull$$$0(int i) {
                    throw new java.lang.IllegalArgumentException(java.lang.String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "data", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor$2", "visitEnd"));
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.header.ReadKotlinClassHeaderAnnotationVisitor.CollectStringArrayAnnotationVisitor
                protected void visitEnd(java.lang.String[] strArr) {
                    if (strArr == null) {
                        $$$reportNull$$$0(0);
                    }
                    kotlin.reflect.jvm.internal.impl.load.kotlin.header.ReadKotlinClassHeaderAnnotationVisitor.this.strings = strArr;
                }
            };
        }
    }

    private class KotlinSerializedIrArgumentVisitor implements kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor {
        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            java.lang.Object[] objArr = new java.lang.Object[3];
            if (i == 1) {
                objArr[0] = "enumClassId";
            } else if (i == 2) {
                objArr[0] = "enumEntryName";
            } else if (i != 3) {
                objArr[0] = "classLiteralValue";
            } else {
                objArr[0] = "classId";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinSerializedIrArgumentVisitor";
            if (i == 1 || i == 2) {
                objArr[2] = "visitEnum";
            } else if (i != 3) {
                objArr[2] = "visitClassLiteral";
            } else {
                objArr[2] = "visitAnnotation";
            }
            throw new java.lang.IllegalArgumentException(java.lang.String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visit(kotlin.reflect.jvm.internal.impl.name.Name name, java.lang.Object obj) {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.name.ClassId classId) {
            if (classId != null) {
                return null;
            }
            $$$reportNull$$$0(3);
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitClassLiteral(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue classLiteralValue) {
            if (classLiteralValue == null) {
                $$$reportNull$$$0(0);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitEnd() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitEnum(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.name.ClassId classId, kotlin.reflect.jvm.internal.impl.name.Name name2) {
            if (classId == null) {
                $$$reportNull$$$0(1);
            }
            if (name2 == null) {
                $$$reportNull$$$0(2);
            }
        }

        private KotlinSerializedIrArgumentVisitor() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor visitArray(kotlin.reflect.jvm.internal.impl.name.Name name) {
            if ("b".equals(name != null ? name.asString() : null)) {
                return serializedIrArrayVisitor();
            }
            return null;
        }

        private kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor serializedIrArrayVisitor() {
            return new kotlin.reflect.jvm.internal.impl.load.kotlin.header.ReadKotlinClassHeaderAnnotationVisitor.CollectStringArrayAnnotationVisitor() { // from class: kotlin.reflect.jvm.internal.impl.load.kotlin.header.ReadKotlinClassHeaderAnnotationVisitor.KotlinSerializedIrArgumentVisitor.1
                private static /* synthetic */ void $$$reportNull$$$0(int i) {
                    throw new java.lang.IllegalArgumentException(java.lang.String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "result", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinSerializedIrArgumentVisitor$1", "visitEnd"));
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.header.ReadKotlinClassHeaderAnnotationVisitor.CollectStringArrayAnnotationVisitor
                protected void visitEnd(java.lang.String[] strArr) {
                    if (strArr == null) {
                        $$$reportNull$$$0(0);
                    }
                    kotlin.reflect.jvm.internal.impl.load.kotlin.header.ReadKotlinClassHeaderAnnotationVisitor.this.serializedIrFields = strArr;
                }
            };
        }
    }

    private static abstract class CollectStringArrayAnnotationVisitor implements kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor {
        private final java.util.List<java.lang.String> strings = new java.util.ArrayList();

        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            java.lang.Object[] objArr = new java.lang.Object[3];
            if (i == 1) {
                objArr[0] = "enumEntryName";
            } else if (i == 2) {
                objArr[0] = "classLiteralValue";
            } else if (i != 3) {
                objArr[0] = "enumClassId";
            } else {
                objArr[0] = "classId";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$CollectStringArrayAnnotationVisitor";
            if (i == 2) {
                objArr[2] = "visitClassLiteral";
            } else if (i != 3) {
                objArr[2] = "visitEnum";
            } else {
                objArr[2] = "visitAnnotation";
            }
            throw new java.lang.IllegalArgumentException(java.lang.String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
        public kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(kotlin.reflect.jvm.internal.impl.name.ClassId classId) {
            if (classId != null) {
                return null;
            }
            $$$reportNull$$$0(3);
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
        public void visitClassLiteral(kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue classLiteralValue) {
            if (classLiteralValue == null) {
                $$$reportNull$$$0(2);
            }
        }

        protected abstract void visitEnd(java.lang.String[] strArr);

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
        public void visitEnum(kotlin.reflect.jvm.internal.impl.name.ClassId classId, kotlin.reflect.jvm.internal.impl.name.Name name) {
            if (classId == null) {
                $$$reportNull$$$0(0);
            }
            if (name == null) {
                $$$reportNull$$$0(1);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
        public void visit(java.lang.Object obj) {
            if (obj instanceof java.lang.String) {
                this.strings.add((java.lang.String) obj);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
        public void visitEnd() {
            visitEnd((java.lang.String[]) this.strings.toArray(new java.lang.String[0]));
        }
    }
}
