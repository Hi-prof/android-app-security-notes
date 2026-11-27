package kotlin.reflect.jvm.internal.impl.types.error;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'IMPLICIT_RETURN_TYPE_FOR_PROPERTY_ACCESSOR' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:399)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:364)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:349)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:315)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:288)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:160)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: ErrorTypeKind.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ErrorTypeKind {
    private static final /* synthetic */ kotlin.enums.EnumEntries $ENTRIES;
    private static final /* synthetic */ kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind[] $VALUES;
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind AD_HOC_ERROR_TYPE_FOR_LIGHTER_CLASSES_RESOLVE;
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind CANNOT_COMPUTE_ERASED_BOUND;
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind CANNOT_LOAD_DESERIALIZE_TYPE_PARAMETER_BY_NAME;
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind ERROR_TYPE_PARAMETER;
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind IMPLICIT_RETURN_TYPE_FOR_PROPERTY_ACCESSOR;
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind MISSED_TYPE_ARGUMENT_FOR_TYPE_PARAMETER;
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind STUB_TYPE;
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind UNINFERRED_LAMBDA_PARAMETER_TYPE;
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind UNKNOWN_ARRAY_ELEMENT_TYPE_OF_ANNOTATION_ARGUMENT;
    private final java.lang.String debugMessage;
    private final boolean isUnresolved;
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind UNRESOLVED_TYPE = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("UNRESOLVED_TYPE", 0, "Unresolved type for %s", true);
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind UNRESOLVED_TYPE_PARAMETER_TYPE = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("UNRESOLVED_TYPE_PARAMETER_TYPE", 1, "Unresolved type parameter type", true);
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind UNRESOLVED_CLASS_TYPE = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("UNRESOLVED_CLASS_TYPE", 2, "Unresolved class %s", true);
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind UNRESOLVED_JAVA_CLASS = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("UNRESOLVED_JAVA_CLASS", 3, "Unresolved java class %s", true);
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind UNRESOLVED_DECLARATION = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("UNRESOLVED_DECLARATION", 4, "Unresolved declaration %s", true);
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind UNRESOLVED_KCLASS_CONSTANT_VALUE = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("UNRESOLVED_KCLASS_CONSTANT_VALUE", 5, "Unresolved type for %s (arrayDimensions=%s)", true);
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind UNRESOLVED_TYPE_ALIAS = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("UNRESOLVED_TYPE_ALIAS", 6, "Unresolved type alias %s", false, 2, null);
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind RETURN_TYPE = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("RETURN_TYPE", 7, "Return type for %s cannot be resolved", false, 2, null);
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind RETURN_TYPE_FOR_FUNCTION = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("RETURN_TYPE_FOR_FUNCTION", 8, "Return type for function cannot be resolved", false, 2, null);
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind RETURN_TYPE_FOR_PROPERTY = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("RETURN_TYPE_FOR_PROPERTY", 9, "Return type for property %s cannot be resolved", false, 2, null);
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind RETURN_TYPE_FOR_CONSTRUCTOR = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("RETURN_TYPE_FOR_CONSTRUCTOR", 10, "Return type for constructor %s cannot be resolved", false, 2, null);
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind IMPLICIT_RETURN_TYPE_FOR_FUNCTION = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("IMPLICIT_RETURN_TYPE_FOR_FUNCTION", 11, "Implicit return type for function %s cannot be resolved", false, 2, null);
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind IMPLICIT_RETURN_TYPE_FOR_PROPERTY = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("IMPLICIT_RETURN_TYPE_FOR_PROPERTY", 12, "Implicit return type for property %s cannot be resolved", false, 2, null);
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind ERROR_TYPE_FOR_DESTRUCTURING_COMPONENT = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("ERROR_TYPE_FOR_DESTRUCTURING_COMPONENT", 14, "%s() return type", false, 2, null);
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind RECURSIVE_TYPE = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("RECURSIVE_TYPE", 15, "Recursive type", false, 2, null);
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind RECURSIVE_TYPE_ALIAS = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("RECURSIVE_TYPE_ALIAS", 16, "Recursive type alias %s", false, 2, null);
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind RECURSIVE_ANNOTATION_TYPE = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("RECURSIVE_ANNOTATION_TYPE", 17, "Recursive annotation's type", false, 2, null);
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind CYCLIC_UPPER_BOUNDS = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("CYCLIC_UPPER_BOUNDS", 18, "Cyclic upper bounds", false, 2, null);
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind CYCLIC_SUPERTYPES = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("CYCLIC_SUPERTYPES", 19, "Cyclic supertypes", false, 2, null);
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind UNINFERRED_LAMBDA_CONTEXT_RECEIVER_TYPE = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("UNINFERRED_LAMBDA_CONTEXT_RECEIVER_TYPE", 20, "Cannot infer a lambda context receiver type", false, 2, null);
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind UNINFERRED_TYPE_VARIABLE = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("UNINFERRED_TYPE_VARIABLE", 22, "Cannot infer a type variable %s", false, 2, null);
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind RESOLUTION_ERROR_TYPE = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("RESOLUTION_ERROR_TYPE", 23, "Resolution error type (%s)", false, 2, null);
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind ERROR_EXPECTED_TYPE = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("ERROR_EXPECTED_TYPE", 24, "Error expected type", false, 2, null);
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind ERROR_DATA_FLOW_TYPE = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("ERROR_DATA_FLOW_TYPE", 25, "Error type for data flow", false, 2, null);
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind ERROR_WHILE_RECONSTRUCTING_BARE_TYPE = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("ERROR_WHILE_RECONSTRUCTING_BARE_TYPE", 26, "Failed to reconstruct type %s", false, 2, null);
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind UNABLE_TO_SUBSTITUTE_TYPE = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("UNABLE_TO_SUBSTITUTE_TYPE", 27, "Unable to substitute type (%s)", false, 2, null);
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind DONT_CARE = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("DONT_CARE", 28, "Special DONT_CARE type", false, 2, null);
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind FUNCTION_PLACEHOLDER_TYPE = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("FUNCTION_PLACEHOLDER_TYPE", 30, "Function placeholder type (arguments: %s)", false, 2, null);
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind TYPE_FOR_COMPILER_EXCEPTION = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("TYPE_FOR_COMPILER_EXCEPTION", 31, "Error type for a compiler exception while analyzing %s", false, 2, null);
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind ERROR_FLEXIBLE_TYPE = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("ERROR_FLEXIBLE_TYPE", 32, "Error java flexible type with id %s. (%s..%s)", false, 2, null);
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind ERROR_RAW_TYPE = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("ERROR_RAW_TYPE", 33, "Error raw type %s", false, 2, null);
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind TYPE_WITH_MISMATCHED_TYPE_ARGUMENTS_AND_PARAMETERS = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("TYPE_WITH_MISMATCHED_TYPE_ARGUMENTS_AND_PARAMETERS", 34, "Inconsistent type %s (parameters.size = %s, arguments.size = %s)", false, 2, null);
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind ILLEGAL_TYPE_RANGE_FOR_DYNAMIC = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("ILLEGAL_TYPE_RANGE_FOR_DYNAMIC", 35, "Illegal type range for dynamic type %s..%s", false, 2, null);
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind CANNOT_LOAD_DESERIALIZE_TYPE_PARAMETER = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("CANNOT_LOAD_DESERIALIZE_TYPE_PARAMETER", 36, "Unknown type parameter %s. Please try recompiling module containing \"%s\"", false, 2, null);
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind INCONSISTENT_SUSPEND_FUNCTION = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("INCONSISTENT_SUSPEND_FUNCTION", 38, "Inconsistent suspend function type in metadata with constructor %s", false, 2, null);
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind UNEXPECTED_FLEXIBLE_TYPE_ID = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("UNEXPECTED_FLEXIBLE_TYPE_ID", 39, "Unexpected id of a flexible type %s. (%s..%s)", false, 2, null);
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind UNKNOWN_TYPE = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("UNKNOWN_TYPE", 40, "Unknown type", false, 2, null);
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind NO_TYPE_SPECIFIED = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("NO_TYPE_SPECIFIED", 41, "No type specified for %s", false, 2, null);
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind NO_TYPE_FOR_LOOP_RANGE = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("NO_TYPE_FOR_LOOP_RANGE", 42, "Loop range has no type", false, 2, null);
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind NO_TYPE_FOR_LOOP_PARAMETER = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("NO_TYPE_FOR_LOOP_PARAMETER", 43, "Loop parameter has no type", false, 2, null);
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind MISSED_TYPE_FOR_PARAMETER = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("MISSED_TYPE_FOR_PARAMETER", 44, "Missed a type for a value parameter %s", false, 2, null);
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind PARSE_ERROR_ARGUMENT = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("PARSE_ERROR_ARGUMENT", 46, "Error type for parse error argument %s", false, 2, null);
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind STAR_PROJECTION_IN_CALL = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("STAR_PROJECTION_IN_CALL", 47, "Error type for star projection directly passing as a call type argument", false, 2, null);
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind PROHIBITED_DYNAMIC_TYPE = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("PROHIBITED_DYNAMIC_TYPE", 48, "Dynamic type in a not allowed context", false, 2, null);
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind NOT_ANNOTATION_TYPE_IN_ANNOTATION_CONTEXT = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("NOT_ANNOTATION_TYPE_IN_ANNOTATION_CONTEXT", 49, "Not an annotation type %s in the annotation context", false, 2, null);
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind UNIT_RETURN_TYPE_FOR_INC_DEC = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("UNIT_RETURN_TYPE_FOR_INC_DEC", 50, "Unit type returned by inc or dec", false, 2, null);
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind RETURN_NOT_ALLOWED = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("RETURN_NOT_ALLOWED", 51, "Return not allowed", false, 2, null);
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind UNRESOLVED_PARCEL_TYPE = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("UNRESOLVED_PARCEL_TYPE", 52, "Unresolved 'Parcel' type", true);
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind KAPT_ERROR_TYPE = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("KAPT_ERROR_TYPE", 53, "Kapt error type", false, 2, null);
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind SYNTHETIC_ELEMENT_ERROR_TYPE = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("SYNTHETIC_ELEMENT_ERROR_TYPE", 54, "Error type for synthetic element", false, 2, null);
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind ERROR_EXPRESSION_TYPE = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("ERROR_EXPRESSION_TYPE", 56, "Error expression type", false, 2, null);
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind ERROR_RECEIVER_TYPE = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("ERROR_RECEIVER_TYPE", 57, "Error receiver type for %s", false, 2, null);
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind ERROR_CONSTANT_VALUE = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("ERROR_CONSTANT_VALUE", 58, "Error constant value %s", false, 2, null);
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind EMPTY_CALLABLE_REFERENCE = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("EMPTY_CALLABLE_REFERENCE", 59, "Empty callable reference", false, 2, null);
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind UNSUPPORTED_CALLABLE_REFERENCE_TYPE = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("UNSUPPORTED_CALLABLE_REFERENCE_TYPE", 60, "Unsupported callable reference type %s", false, 2, null);
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind TYPE_FOR_DELEGATION = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("TYPE_FOR_DELEGATION", 61, "Error delegation type for %s", false, 2, null);
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind UNAVAILABLE_TYPE_FOR_DECLARATION = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("UNAVAILABLE_TYPE_FOR_DECLARATION", 62, "Type is unavailable for declaration %s", false, 2, null);
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind ERROR_TYPE_PROJECTION = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("ERROR_TYPE_PROJECTION", 64, "Error type projection", false, 2, null);
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind ERROR_SUPER_TYPE = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("ERROR_SUPER_TYPE", 65, "Error super type", false, 2, null);
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind SUPER_TYPE_FOR_ERROR_TYPE = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("SUPER_TYPE_FOR_ERROR_TYPE", 66, "Supertype of error type %s", false, 2, null);
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind ERROR_PROPERTY_TYPE = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("ERROR_PROPERTY_TYPE", 67, "Error property type", false, 2, null);
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind ERROR_CLASS = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("ERROR_CLASS", 68, "Error class", false, 2, null);
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind TYPE_FOR_ERROR_TYPE_CONSTRUCTOR = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("TYPE_FOR_ERROR_TYPE_CONSTRUCTOR", 69, "Type for error type constructor (%s)", false, 2, null);
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind INTERSECTION_OF_ERROR_TYPES = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("INTERSECTION_OF_ERROR_TYPES", 70, "Intersection of error types %s", false, 2, null);
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind NOT_FOUND_UNSIGNED_TYPE = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("NOT_FOUND_UNSIGNED_TYPE", 72, "Unsigned type %s not found", false, 2, null);
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind ERROR_ENUM_TYPE = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("ERROR_ENUM_TYPE", 73, "Not found the corresponding enum class for given enum entry %s.%s", false, 2, null);
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind NO_RECORDED_TYPE = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("NO_RECORDED_TYPE", 74, "Not found recorded type for %s", false, 2, null);
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind NOT_FOUND_DESCRIPTOR_FOR_FUNCTION = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("NOT_FOUND_DESCRIPTOR_FOR_FUNCTION", 75, "Descriptor not found for function %s", false, 2, null);
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind NOT_FOUND_DESCRIPTOR_FOR_CLASS = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("NOT_FOUND_DESCRIPTOR_FOR_CLASS", 76, "Cannot build class type, descriptor not found for builder %s", false, 2, null);
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind NOT_FOUND_DESCRIPTOR_FOR_TYPE_PARAMETER = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("NOT_FOUND_DESCRIPTOR_FOR_TYPE_PARAMETER", 77, "Cannot build type parameter type, descriptor not found for builder %s", false, 2, null);
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind UNMAPPED_ANNOTATION_TARGET_TYPE = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("UNMAPPED_ANNOTATION_TARGET_TYPE", 78, "Type for unmapped Java annotation target to Kotlin one", false, 2, null);
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind NOT_FOUND_FQNAME_FOR_JAVA_ANNOTATION = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("NOT_FOUND_FQNAME_FOR_JAVA_ANNOTATION", 80, "No fqName for annotation %s", false, 2, null);
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind NOT_FOUND_FQNAME = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("NOT_FOUND_FQNAME", 81, "No fqName for %s", false, 2, null);
    public static final kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind TYPE_FOR_GENERATED_ERROR_EXPRESSION = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("TYPE_FOR_GENERATED_ERROR_EXPRESSION", 82, "Type for generated error expression", false, 2, null);

    private static final /* synthetic */ kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind[] $values() {
        return new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind[]{UNRESOLVED_TYPE, UNRESOLVED_TYPE_PARAMETER_TYPE, UNRESOLVED_CLASS_TYPE, UNRESOLVED_JAVA_CLASS, UNRESOLVED_DECLARATION, UNRESOLVED_KCLASS_CONSTANT_VALUE, UNRESOLVED_TYPE_ALIAS, RETURN_TYPE, RETURN_TYPE_FOR_FUNCTION, RETURN_TYPE_FOR_PROPERTY, RETURN_TYPE_FOR_CONSTRUCTOR, IMPLICIT_RETURN_TYPE_FOR_FUNCTION, IMPLICIT_RETURN_TYPE_FOR_PROPERTY, IMPLICIT_RETURN_TYPE_FOR_PROPERTY_ACCESSOR, ERROR_TYPE_FOR_DESTRUCTURING_COMPONENT, RECURSIVE_TYPE, RECURSIVE_TYPE_ALIAS, RECURSIVE_ANNOTATION_TYPE, CYCLIC_UPPER_BOUNDS, CYCLIC_SUPERTYPES, UNINFERRED_LAMBDA_CONTEXT_RECEIVER_TYPE, UNINFERRED_LAMBDA_PARAMETER_TYPE, UNINFERRED_TYPE_VARIABLE, RESOLUTION_ERROR_TYPE, ERROR_EXPECTED_TYPE, ERROR_DATA_FLOW_TYPE, ERROR_WHILE_RECONSTRUCTING_BARE_TYPE, UNABLE_TO_SUBSTITUTE_TYPE, DONT_CARE, STUB_TYPE, FUNCTION_PLACEHOLDER_TYPE, TYPE_FOR_COMPILER_EXCEPTION, ERROR_FLEXIBLE_TYPE, ERROR_RAW_TYPE, TYPE_WITH_MISMATCHED_TYPE_ARGUMENTS_AND_PARAMETERS, ILLEGAL_TYPE_RANGE_FOR_DYNAMIC, CANNOT_LOAD_DESERIALIZE_TYPE_PARAMETER, CANNOT_LOAD_DESERIALIZE_TYPE_PARAMETER_BY_NAME, INCONSISTENT_SUSPEND_FUNCTION, UNEXPECTED_FLEXIBLE_TYPE_ID, UNKNOWN_TYPE, NO_TYPE_SPECIFIED, NO_TYPE_FOR_LOOP_RANGE, NO_TYPE_FOR_LOOP_PARAMETER, MISSED_TYPE_FOR_PARAMETER, MISSED_TYPE_ARGUMENT_FOR_TYPE_PARAMETER, PARSE_ERROR_ARGUMENT, STAR_PROJECTION_IN_CALL, PROHIBITED_DYNAMIC_TYPE, NOT_ANNOTATION_TYPE_IN_ANNOTATION_CONTEXT, UNIT_RETURN_TYPE_FOR_INC_DEC, RETURN_NOT_ALLOWED, UNRESOLVED_PARCEL_TYPE, KAPT_ERROR_TYPE, SYNTHETIC_ELEMENT_ERROR_TYPE, AD_HOC_ERROR_TYPE_FOR_LIGHTER_CLASSES_RESOLVE, ERROR_EXPRESSION_TYPE, ERROR_RECEIVER_TYPE, ERROR_CONSTANT_VALUE, EMPTY_CALLABLE_REFERENCE, UNSUPPORTED_CALLABLE_REFERENCE_TYPE, TYPE_FOR_DELEGATION, UNAVAILABLE_TYPE_FOR_DECLARATION, ERROR_TYPE_PARAMETER, ERROR_TYPE_PROJECTION, ERROR_SUPER_TYPE, SUPER_TYPE_FOR_ERROR_TYPE, ERROR_PROPERTY_TYPE, ERROR_CLASS, TYPE_FOR_ERROR_TYPE_CONSTRUCTOR, INTERSECTION_OF_ERROR_TYPES, CANNOT_COMPUTE_ERASED_BOUND, NOT_FOUND_UNSIGNED_TYPE, ERROR_ENUM_TYPE, NO_RECORDED_TYPE, NOT_FOUND_DESCRIPTOR_FOR_FUNCTION, NOT_FOUND_DESCRIPTOR_FOR_CLASS, NOT_FOUND_DESCRIPTOR_FOR_TYPE_PARAMETER, UNMAPPED_ANNOTATION_TARGET_TYPE, UNKNOWN_ARRAY_ELEMENT_TYPE_OF_ANNOTATION_ARGUMENT, NOT_FOUND_FQNAME_FOR_JAVA_ANNOTATION, NOT_FOUND_FQNAME, TYPE_FOR_GENERATED_ERROR_EXPRESSION};
    }

    public static kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind valueOf(java.lang.String str) {
        return (kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind) java.lang.Enum.valueOf(kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind.class, str);
    }

    public static kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind[] values() {
        return (kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind[]) $VALUES.clone();
    }

    private ErrorTypeKind(java.lang.String str, int i, java.lang.String str2, boolean z) {
        super(str, i);
        this.debugMessage = str2;
        this.isUnresolved = z;
    }

    /* synthetic */ ErrorTypeKind(java.lang.String str, int i, java.lang.String str2, boolean z, int i2, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, str2, (i2 & 2) != 0 ? false : z);
    }

    public final java.lang.String getDebugMessage() {
        return this.debugMessage;
    }

    public final boolean isUnresolved() {
        return this.isUnresolved;
    }

    static {
        kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker = null;
        IMPLICIT_RETURN_TYPE_FOR_PROPERTY_ACCESSOR = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("IMPLICIT_RETURN_TYPE_FOR_PROPERTY_ACCESSOR", 13, "Implicit return type for property accessor %s cannot be resolved", false, 2, defaultConstructorMarker);
        UNINFERRED_LAMBDA_PARAMETER_TYPE = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("UNINFERRED_LAMBDA_PARAMETER_TYPE", 21, "Cannot infer a lambda parameter type", false, 2, defaultConstructorMarker);
        STUB_TYPE = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("STUB_TYPE", 29, "Stub type %s", false, 2, defaultConstructorMarker);
        CANNOT_LOAD_DESERIALIZE_TYPE_PARAMETER_BY_NAME = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("CANNOT_LOAD_DESERIALIZE_TYPE_PARAMETER_BY_NAME", 37, "Couldn't deserialize type parameter %s in %s", false, 2, defaultConstructorMarker);
        MISSED_TYPE_ARGUMENT_FOR_TYPE_PARAMETER = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("MISSED_TYPE_ARGUMENT_FOR_TYPE_PARAMETER", 45, "Missed a type argument for a type parameter %s", false, 2, defaultConstructorMarker);
        kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker2 = null;
        AD_HOC_ERROR_TYPE_FOR_LIGHTER_CLASSES_RESOLVE = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("AD_HOC_ERROR_TYPE_FOR_LIGHTER_CLASSES_RESOLVE", 55, "Error type in ad hoc resolve for lighter classes", false, 2, defaultConstructorMarker2);
        ERROR_TYPE_PARAMETER = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("ERROR_TYPE_PARAMETER", 63, "Error type parameter", false, 2, defaultConstructorMarker2);
        CANNOT_COMPUTE_ERASED_BOUND = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("CANNOT_COMPUTE_ERASED_BOUND", 71, "Cannot compute erased upper bound of a type parameter %s", false, 2, defaultConstructorMarker2);
        UNKNOWN_ARRAY_ELEMENT_TYPE_OF_ANNOTATION_ARGUMENT = new kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind("UNKNOWN_ARRAY_ELEMENT_TYPE_OF_ANNOTATION_ARGUMENT", 79, "Unknown type for an array element of a java annotation argument", false, 2, defaultConstructorMarker2);
        kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind[] errorTypeKindArr$values = $values();
        $VALUES = errorTypeKindArr$values;
        $ENTRIES = kotlin.enums.EnumEntriesKt.enumEntries(errorTypeKindArr$values);
    }
}
