package io.dcloud.uts.android;

/* JADX INFO: compiled from: ClassLogWrapper.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J<\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\u00012\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00010\tj\b\u0012\u0004\u0012\u00020\u0001`\n2\b\b\u0002\u0010\u000b\u001a\u00020\fJ\u0010\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001JV\u0010\u0010\u001a\u00020\u00112\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00132\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00010\tj\b\u0012\u0004\u0012\u00020\u0001`\n2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u0001H\u0002J<\u0010\u0019\u001a\u00020\u00152\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001b2\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00010\tj\b\u0012\u0004\u0012\u00020\u0001`\n2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\fH\u0002J:\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\u00012\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00010\tj\b\u0012\u0004\u0012\u00020\u0001`\n2\u0006\u0010\u0016\u001a\u00020\fH\u0002J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001e\u001a\u00020\u0001H\u0002J\u001a\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u000e2\b\u0010\"\u001a\u0004\u0018\u00010\u0001H\u0002J\u0014\u0010#\u001a\u0004\u0018\u00010\u000e2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u0002J\u001c\u0010$\u001a\u00020\u000e2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010%\u001a\u00020 H\u0002¨\u0006&"}, d2 = {"Lio/dcloud/uts/android/ClassLogWrapper;", "", "<init>", "()V", "wrapClass", "Lio/dcloud/uts/gson/JsonElement;", "objInstance", "parentField", "inputStock", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "limitCounter", "Ljava/util/concurrent/atomic/AtomicInteger;", "wrapNumberText", "", "logValue", "fillRootJsonWithMap", "", "customMap", "", "rootJsonObject", "Lio/dcloud/uts/gson/JsonObject;", "nextLimitCounter", "valueProperObject", "Lio/dcloud/uts/gson/JsonArray;", "wrapClassInfo", "classObj", "Ljava/lang/Class;", "doJsonConvert", "logClassOf", "input", "needSubType", "", "type", "value", "logSubTypeOf", "logTypeOf", "isReturnTag", "utsplugin_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ClassLogWrapper {
    public static final io.dcloud.uts.android.ClassLogWrapper INSTANCE = new io.dcloud.uts.android.ClassLogWrapper();

    private ClassLogWrapper() {
    }

    public static /* synthetic */ io.dcloud.uts.gson.JsonElement wrapClass$default(io.dcloud.uts.android.ClassLogWrapper classLogWrapper, java.lang.Object obj, java.lang.Object obj2, java.util.HashSet hashSet, java.util.concurrent.atomic.AtomicInteger atomicInteger, int i, java.lang.Object obj3) {
        if ((i & 8) != 0) {
            atomicInteger = new java.util.concurrent.atomic.AtomicInteger(256);
        }
        return classLogWrapper.wrapClass(obj, obj2, hashSet, atomicInteger);
    }

    public final io.dcloud.uts.gson.JsonElement wrapClass(java.lang.Object objInstance, java.lang.Object parentField, java.util.HashSet<java.lang.Object> inputStock, java.util.concurrent.atomic.AtomicInteger limitCounter) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(inputStock, "inputStock");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(limitCounter, "limitCounter");
        if (objInstance == null) {
            if (parentField == null) {
                io.dcloud.uts.gson.JsonObject jsonObject = new io.dcloud.uts.gson.JsonObject();
                jsonObject.add("type", new io.dcloud.uts.gson.JsonPrimitive("null"));
                jsonObject.add("value", new io.dcloud.uts.gson.JsonPrimitive("null"));
                return jsonObject;
            }
            return new io.dcloud.uts.gson.JsonPrimitive("null");
        }
        if (inputStock.contains(objInstance)) {
            inputStock.remove(objInstance);
            return new io.dcloud.uts.gson.JsonPrimitive("[Circular]");
        }
        inputStock.add(objInstance);
        io.dcloud.uts.gson.JsonPrimitive jsonPrimitive = new io.dcloud.uts.gson.JsonPrimitive("null");
        try {
            jsonPrimitive = doJsonConvert(objInstance, parentField, inputStock, limitCounter);
        } catch (java.lang.Throwable unused) {
        }
        inputStock.remove(objInstance);
        return jsonPrimitive;
    }

    public final java.lang.String wrapNumberText(java.lang.Object logValue) {
        if (logValue == null) {
            return "null";
        }
        if (logValue instanceof java.lang.Number) {
            boolean zAreEqual = kotlin.jvm.internal.Intrinsics.areEqual(logValue, java.lang.Float.valueOf(0.0f));
            java.lang.String string = com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT;
            if (!zAreEqual && !kotlin.jvm.internal.Intrinsics.areEqual(logValue, java.lang.Double.valueOf(0.0d)) && !kotlin.jvm.internal.Intrinsics.areEqual(logValue, (java.lang.Object) 0L) && (!kotlin.jvm.internal.Intrinsics.areEqual(logValue, (java.lang.Object) 0) || !(logValue instanceof java.lang.Integer))) {
                java.lang.Number number = (java.lang.Number) logValue;
                if (number.intValue() != 0 || (!(logValue instanceof java.lang.Short) && !(logValue instanceof java.lang.Byte))) {
                    if (kotlin.jvm.internal.Intrinsics.areEqual(io.dcloud.uts.NumberKt.div(number, java.lang.Integer.valueOf(number.intValue())), java.lang.Double.valueOf(1.0d))) {
                        string = java.lang.String.valueOf(number.intValue());
                    } else if ((logValue instanceof java.lang.Double) || (logValue instanceof java.lang.Float)) {
                        if (kotlin.jvm.internal.Intrinsics.areEqual(logValue, io.dcloud.uts.UTSNumber.INSTANCE.getNaN()) || kotlin.jvm.internal.Intrinsics.areEqual(logValue, io.dcloud.uts.UTSNumber.INSTANCE.getPOSITIVE_INFINITY()) || kotlin.jvm.internal.Intrinsics.areEqual(logValue, io.dcloud.uts.UTSNumber.INSTANCE.getNEGATIVE_INFINITY())) {
                            string = logValue.toString();
                        } else {
                            double dAbs = java.lang.Math.abs(number.doubleValue());
                            if (dAbs >= 1.0E-6d && dAbs < 1.0E21d) {
                                string = io.dcloud.uts.android.ClassLogWrapper$$ExternalSyntheticBackportWithForwarding0.m(new java.math.BigDecimal(logValue.toString()).round(new java.math.MathContext(17, java.math.RoundingMode.HALF_UP))).toPlainString();
                            } else {
                                java.lang.String lowerCase = io.dcloud.uts.StringKt.toLowerCase(logValue.toString());
                                if (kotlin.text.StringsKt.contains$default((java.lang.CharSequence) lowerCase, (java.lang.CharSequence) ".0e", false, 2, (java.lang.Object) null)) {
                                    lowerCase = kotlin.text.StringsKt.replace$default(lowerCase, ".0e", "e", false, 4, (java.lang.Object) null);
                                }
                                java.lang.String str = lowerCase;
                                if (kotlin.text.StringsKt.contains$default((java.lang.CharSequence) str, (java.lang.CharSequence) "e-", false, 2, (java.lang.Object) null) || !kotlin.text.StringsKt.contains$default((java.lang.CharSequence) str, (java.lang.CharSequence) "e", false, 2, (java.lang.Object) null)) {
                                    return lowerCase;
                                }
                                java.util.List listSplit$default = kotlin.text.StringsKt.split$default((java.lang.CharSequence) str, new java.lang.String[]{"e"}, false, 0, 6, (java.lang.Object) null);
                                return ((java.lang.String) listSplit$default.get(0)) + "e+" + ((java.lang.String) listSplit$default.get(1));
                            }
                        }
                    } else {
                        string = io.dcloud.uts.android.ClassLogWrapper$$ExternalSyntheticBackportWithForwarding0.m(new java.math.BigDecimal(number.toString()).round(new java.math.MathContext(17, java.math.RoundingMode.HALF_UP))).toPlainString();
                    }
                }
            }
            kotlin.jvm.internal.Intrinsics.checkNotNull(string);
            return string;
        }
        return logValue.toString();
    }

    private final io.dcloud.uts.gson.JsonObject wrapClassInfo(java.lang.Class<?> classObj, java.util.HashSet<java.lang.Object> inputStock, io.dcloud.uts.gson.JsonObject rootJsonObject, java.util.concurrent.atomic.AtomicInteger nextLimitCounter) {
        java.lang.reflect.Field[] fieldArr;
        java.lang.String strLogSubTypeOf;
        io.dcloud.uts.gson.JsonObject jsonObject = new io.dcloud.uts.gson.JsonObject();
        io.dcloud.uts.gson.JsonArray jsonArray = new io.dcloud.uts.gson.JsonArray();
        java.lang.reflect.Field[] declaredFields = classObj.getDeclaredFields();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(declaredFields, "getDeclaredFields(...)");
        java.lang.reflect.Field[] fieldArr2 = declaredFields;
        int length = fieldArr2.length;
        boolean z = false;
        int i = 0;
        while (i < length) {
            java.lang.reflect.Field field = fieldArr2[i];
            java.lang.Object obj = java.lang.reflect.Modifier.isStatic(field.getModifiers()) ? field.get(classObj) : null;
            io.dcloud.uts.android.ClassLogWrapper classLogWrapper = INSTANCE;
            java.lang.String strLogTypeOf$default = logTypeOf$default(classLogWrapper, obj, z, 2, null);
            if (kotlin.jvm.internal.Intrinsics.areEqual(field.getName(), "Companion") && obj != null) {
                kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(obj.getClass()).isCompanion();
                fieldArr = fieldArr2;
            } else {
                io.dcloud.uts.gson.JsonObject jsonObject2 = new io.dcloud.uts.gson.JsonObject();
                jsonObject2.add("type", new io.dcloud.uts.gson.JsonPrimitive(strLogTypeOf$default));
                if (classLogWrapper.needSubType(strLogTypeOf$default, obj) && (strLogSubTypeOf = classLogWrapper.logSubTypeOf(obj)) != null) {
                    jsonObject2.add("subType", new io.dcloud.uts.gson.JsonPrimitive(strLogSubTypeOf));
                }
                jsonObject2.add("name", new io.dcloud.uts.gson.JsonPrimitive(field.getName()));
                if (obj instanceof kotlin.Function) {
                    kotlin.reflect.KFunction kFunctionReflect = kotlin.reflect.jvm.ReflectLambdaKt.reflect((kotlin.Function) obj);
                    if (kFunctionReflect != null) {
                        io.dcloud.uts.gson.JsonArray jsonArray2 = new io.dcloud.uts.gson.JsonArray();
                        java.util.Iterator<T> it = kFunctionReflect.getParameters().iterator();
                        while (it.hasNext()) {
                            jsonArray2.add(new io.dcloud.uts.gson.JsonPrimitive(INSTANCE.logTypeOf(((kotlin.reflect.KParameter) it.next()).getType().toString(), true)));
                        }
                        jsonObject2.add("parameter", jsonArray2);
                        if (!kotlin.jvm.internal.Intrinsics.areEqual("kotlin.Unit", kFunctionReflect.getReturnType().toString())) {
                            jsonObject2.add("returned", new io.dcloud.uts.gson.JsonPrimitive(INSTANCE.logTypeOf(kFunctionReflect.getReturnType().toString(), true)));
                        }
                    }
                    fieldArr = fieldArr2;
                } else {
                    io.dcloud.uts.gson.JsonElement jsonElementWrapClass = classLogWrapper.wrapClass(obj, classObj, inputStock, nextLimitCounter);
                    if (kotlin.jvm.internal.Intrinsics.areEqual("object", strLogTypeOf$default)) {
                        fieldArr = fieldArr2;
                        if (jsonElementWrapClass instanceof io.dcloud.uts.gson.JsonObject) {
                            java.util.Set<java.util.Map.Entry<java.lang.String, io.dcloud.uts.gson.JsonElement>> setEntrySet = ((io.dcloud.uts.gson.JsonObject) jsonElementWrapClass).entrySet();
                            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(setEntrySet, "entrySet(...)");
                            java.util.Iterator<T> it2 = setEntrySet.iterator();
                            while (it2.hasNext()) {
                                java.util.Map.Entry entry = (java.util.Map.Entry) it2.next();
                                jsonObject2.add((java.lang.String) entry.getKey(), (io.dcloud.uts.gson.JsonElement) entry.getValue());
                            }
                        }
                    } else {
                        fieldArr = fieldArr2;
                    }
                    if (kotlin.jvm.internal.Intrinsics.areEqual("object", strLogTypeOf$default) && kotlin.jvm.internal.Intrinsics.areEqual("\"[Circular]\"", jsonElementWrapClass.toString())) {
                        jsonObject2.add("value", jsonElementWrapClass);
                        kotlin.jvm.internal.Intrinsics.checkNotNull(obj);
                        jsonObject2.add("className", new io.dcloud.uts.gson.JsonPrimitive(classLogWrapper.logClassOf(obj)));
                    } else {
                        jsonObject2.add("value", jsonElementWrapClass);
                    }
                }
                jsonArray.add(jsonObject2);
            }
            i++;
            fieldArr2 = fieldArr;
            z = false;
        }
        if (io.dcloud.uts.UTSJSONObject.class.isAssignableFrom(classObj) && !rootJsonObject.has("__$originalPosition")) {
            io.dcloud.uts.gson.JsonObject jsonObject3 = new io.dcloud.uts.gson.JsonObject();
            jsonObject3.add("name", new io.dcloud.uts.gson.JsonPrimitive("UTSJSONObject"));
            rootJsonObject.add("__$originalPosition", jsonObject3);
        }
        jsonObject.add("properties", jsonArray);
        rootJsonObject.add("value", jsonObject);
        return rootJsonObject;
    }

    /* JADX WARN: Code duplicated, block: B:179:0x067e  */
    /* JADX WARN: Code duplicated, block: B:326:0x0a98  */
    /* JADX WARN: Multi-variable type inference failed */
    private final io.dcloud.uts.gson.JsonElement doJsonConvert(java.lang.Object objInstance, java.lang.Object parentField, java.util.HashSet<java.lang.Object> inputStock, java.util.concurrent.atomic.AtomicInteger nextLimitCounter) {
        io.dcloud.uts.gson.JsonObject jsonObject;
        io.dcloud.uts.gson.JsonObject jsonObject2;
        java.lang.String strStackTraceToString;
        io.dcloud.uts.gson.JsonObject jsonObject3;
        boolean z;
        java.lang.Object objCall;
        java.lang.String strLogTypeOf$default;
        java.lang.String str;
        java.lang.String str2;
        java.lang.String str3;
        io.dcloud.uts.gson.JsonArray jsonArray;
        java.lang.String str4;
        io.dcloud.uts.gson.JsonArray jsonArray2;
        java.util.HashSet<java.lang.Object> hashSet;
        java.util.concurrent.atomic.AtomicInteger atomicInteger;
        java.lang.String str5;
        io.dcloud.uts.gson.JsonArray jsonArray3;
        boolean z2;
        java.lang.Object objCall2;
        java.lang.String strLogTypeOf$default2;
        java.lang.String str6;
        java.lang.String str7;
        java.lang.String str8;
        io.dcloud.uts.gson.JsonArray jsonArray4;
        java.lang.String strLogSubTypeOf;
        java.util.Iterator<T> it;
        kotlin.reflect.KFunction kFunction;
        nextLimitCounter.decrementAndGet();
        java.lang.String str9 = "type";
        if (objInstance instanceof io.dcloud.uts.log.LogSelfV2Simple) {
            java.lang.Object logV2Simple = ((io.dcloud.uts.log.LogSelfV2Simple) objInstance).toLogV2Simple();
            if (logV2Simple instanceof io.dcloud.uts.gson.JsonElement) {
                return (io.dcloud.uts.gson.JsonElement) logV2Simple;
            }
        } else {
            if (objInstance instanceof io.dcloud.uts.android.UTSLogInfo) {
                io.dcloud.uts.android.UTSLogInfo uTSLogInfo = (io.dcloud.uts.android.UTSLogInfo) objInstance;
                java.lang.String type = uTSLogInfo.getType();
                java.lang.Object value = uTSLogInfo.getValue();
                java.lang.String subtype = uTSLogInfo.getSubtype();
                io.dcloud.uts.gson.JsonObject jsonObject4 = new io.dcloud.uts.gson.JsonObject();
                jsonObject4.add("type", new io.dcloud.uts.gson.JsonPrimitive(type));
                jsonObject4.add("value", new io.dcloud.uts.gson.JsonPrimitive(wrapNumberText(value)));
                if (subtype.length() > 0) {
                    jsonObject4.add("subType", new io.dcloud.uts.gson.JsonPrimitive(subtype));
                }
                return jsonObject4;
            }
            if (objInstance instanceof java.lang.Number) {
                if (parentField == null) {
                    io.dcloud.uts.gson.JsonObject jsonObject5 = new io.dcloud.uts.gson.JsonObject();
                    jsonObject5.add("type", new io.dcloud.uts.gson.JsonPrimitive(io.dcloud.uts.UTSAndroid.INSTANCE.typeof(objInstance)));
                    if (needSubType("number", objInstance)) {
                        jsonObject5.add("subType", new io.dcloud.uts.gson.JsonPrimitive("number"));
                    }
                    jsonObject5.add("value", new io.dcloud.uts.gson.JsonPrimitive(wrapNumberText(objInstance)));
                    return jsonObject5;
                }
                return new io.dcloud.uts.gson.JsonPrimitive(wrapNumberText(objInstance));
            }
            if (objInstance instanceof java.lang.String) {
                if (parentField == null) {
                    io.dcloud.uts.gson.JsonObject jsonObject6 = new io.dcloud.uts.gson.JsonObject();
                    jsonObject6.add("type", new io.dcloud.uts.gson.JsonPrimitive("string"));
                    jsonObject6.add("value", new io.dcloud.uts.gson.JsonPrimitive(((java.lang.String) objInstance).toString()));
                    return jsonObject6;
                }
                return new io.dcloud.uts.gson.JsonPrimitive(((java.lang.String) objInstance).toString());
            }
            if (objInstance instanceof java.lang.Character) {
                if (parentField == null) {
                    io.dcloud.uts.gson.JsonObject jsonObject7 = new io.dcloud.uts.gson.JsonObject();
                    jsonObject7.add("type", new io.dcloud.uts.gson.JsonPrimitive("Char"));
                    jsonObject7.add("subType", new io.dcloud.uts.gson.JsonPrimitive("string"));
                    jsonObject7.add("value", new io.dcloud.uts.gson.JsonPrimitive(java.lang.String.valueOf(((java.lang.Character) objInstance).charValue())));
                    return jsonObject7;
                }
                return new io.dcloud.uts.gson.JsonPrimitive(java.lang.String.valueOf(((java.lang.Character) objInstance).charValue()));
            }
            if (objInstance instanceof java.lang.Boolean) {
                if (parentField == null) {
                    io.dcloud.uts.gson.JsonObject jsonObject8 = new io.dcloud.uts.gson.JsonObject();
                    jsonObject8.add("type", new io.dcloud.uts.gson.JsonPrimitive("boolean"));
                    jsonObject8.add("value", new io.dcloud.uts.gson.JsonPrimitive(java.lang.String.valueOf(((java.lang.Boolean) objInstance).booleanValue())));
                    return jsonObject8;
                }
                return new io.dcloud.uts.gson.JsonPrimitive(java.lang.String.valueOf(((java.lang.Boolean) objInstance).booleanValue()));
            }
        }
        if (nextLimitCounter.get() < 0) {
            return new io.dcloud.uts.gson.JsonPrimitive("[depth-max-limit]");
        }
        java.lang.String str10 = "object";
        if (objInstance instanceof java.util.Map) {
            io.dcloud.uts.gson.JsonObject jsonObject9 = new io.dcloud.uts.gson.JsonObject();
            jsonObject9.add("type", new io.dcloud.uts.gson.JsonPrimitive("object"));
            jsonObject9.add("subType", new io.dcloud.uts.gson.JsonPrimitive("map"));
            java.lang.StringBuilder sb = new java.lang.StringBuilder("Map(");
            java.util.Map map = (java.util.Map) objInstance;
            sb.append(map.size());
            sb.append(com.taobao.weex.el.parse.Operators.BRACKET_END);
            java.lang.String string = sb.toString();
            jsonObject9.add("description", new io.dcloud.uts.gson.JsonPrimitive(string));
            io.dcloud.uts.gson.JsonArray jsonArray5 = new io.dcloud.uts.gson.JsonArray();
            for (java.util.Map.Entry entry : map.entrySet()) {
                io.dcloud.uts.gson.JsonObject jsonObject10 = new io.dcloud.uts.gson.JsonObject();
                io.dcloud.uts.android.ClassLogWrapper classLogWrapper = INSTANCE;
                jsonObject10.add(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_KEY, classLogWrapper.wrapClass(entry.getKey(), null, inputStock, nextLimitCounter));
                jsonObject10.add("value", classLogWrapper.wrapClass(entry.getValue(), null, inputStock, nextLimitCounter));
                jsonArray5.add(jsonObject10);
            }
            io.dcloud.uts.gson.JsonObject jsonObject11 = new io.dcloud.uts.gson.JsonObject();
            jsonObject11.add("entries", jsonArray5);
            jsonObject9.add("value", jsonObject11);
            jsonObject9.add("description", new io.dcloud.uts.gson.JsonPrimitive(string));
            return jsonObject9;
        }
        if (objInstance instanceof java.util.Set) {
            io.dcloud.uts.gson.JsonObject jsonObject12 = new io.dcloud.uts.gson.JsonObject();
            jsonObject12.add("type", new io.dcloud.uts.gson.JsonPrimitive("object"));
            jsonObject12.add("subType", new io.dcloud.uts.gson.JsonPrimitive("set"));
            io.dcloud.uts.gson.JsonArray jsonArray6 = new io.dcloud.uts.gson.JsonArray();
            for (java.lang.Object obj : (java.lang.Iterable) objInstance) {
                io.dcloud.uts.gson.JsonObject jsonObject13 = new io.dcloud.uts.gson.JsonObject();
                jsonObject13.add("value", INSTANCE.wrapClass(obj, null, inputStock, nextLimitCounter));
                jsonArray6.add(jsonObject13);
            }
            io.dcloud.uts.gson.JsonObject jsonObject14 = new io.dcloud.uts.gson.JsonObject();
            jsonObject14.add("entries", jsonArray6);
            jsonObject12.add("value", jsonObject14);
            jsonObject12.add("description", new io.dcloud.uts.gson.JsonPrimitive("Set(" + ((java.util.Set) objInstance).size() + com.taobao.weex.el.parse.Operators.BRACKET_END));
            return jsonObject12;
        }
        java.lang.String str11 = "returned";
        if (objInstance instanceof kotlin.Function) {
            io.dcloud.uts.gson.JsonObject jsonObject15 = new io.dcloud.uts.gson.JsonObject();
            if (parentField == null) {
                jsonObject15.add("type", new io.dcloud.uts.gson.JsonPrimitive("function"));
            }
            kotlin.reflect.KFunction kFunctionReflect = kotlin.reflect.jvm.ReflectLambdaKt.reflect((kotlin.Function) objInstance);
            if (kFunctionReflect != null) {
                io.dcloud.uts.gson.JsonArray jsonArray7 = new io.dcloud.uts.gson.JsonArray();
                java.util.Iterator<T> it2 = kFunctionReflect.getParameters().iterator();
                while (it2.hasNext()) {
                    jsonArray7.add(new io.dcloud.uts.gson.JsonPrimitive(INSTANCE.logTypeOf(((kotlin.reflect.KParameter) it2.next()).getType().toString(), true)));
                }
                jsonObject15.add("parameter", jsonArray7);
                if (!kotlin.jvm.internal.Intrinsics.areEqual("kotlin.Unit", kFunctionReflect.getReturnType().toString())) {
                    jsonObject15.add("returned", new io.dcloud.uts.gson.JsonPrimitive(logTypeOf$default(this, kFunctionReflect.getReturnType().toString(), false, 2, null)));
                }
            }
            return jsonObject15;
        }
        io.dcloud.uts.gson.JsonObject jsonObject16 = new io.dcloud.uts.gson.JsonObject();
        java.lang.String strLogTypeOf$default3 = logTypeOf$default(this, objInstance, false, 2, null);
        java.lang.String strLogSubTypeOf2 = logSubTypeOf(objInstance);
        boolean zAreEqual = kotlin.jvm.internal.Intrinsics.areEqual("class", strLogTypeOf$default3);
        kotlin.reflect.KClass orCreateKotlinClass = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(objInstance.getClass());
        boolean zIsAnonymousClass = kotlin.jvm.JvmClassMappingKt.getJavaClass(orCreateKotlinClass).isAnonymousClass();
        jsonObject16.add("className", new io.dcloud.uts.gson.JsonPrimitive(logClassOf(objInstance)));
        if (parentField == null) {
            jsonObject16.add("type", new io.dcloud.uts.gson.JsonPrimitive(strLogTypeOf$default3));
            if (needSubType(strLogTypeOf$default3, objInstance)) {
                jsonObject16.add("subType", new io.dcloud.uts.gson.JsonPrimitive(strLogSubTypeOf2));
            }
        }
        io.dcloud.uts.gson.JsonObject jsonObject17 = new io.dcloud.uts.gson.JsonObject();
        io.dcloud.uts.gson.JsonArray jsonArray8 = new io.dcloud.uts.gson.JsonArray();
        io.dcloud.uts.gson.JsonArray jsonArray9 = new io.dcloud.uts.gson.JsonArray();
        if (objInstance instanceof java.lang.Class) {
            return wrapClassInfo((java.lang.Class) objInstance, inputStock, jsonObject16, nextLimitCounter);
        }
        java.lang.String str12 = "Companion";
        java.lang.String str13 = "className";
        java.lang.String str14 = "kotlin.Number";
        java.lang.String str15 = "value";
        if (kotlin.jvm.internal.Intrinsics.areEqual("object", strLogSubTypeOf2)) {
            if (zAreEqual || !(objInstance instanceof io.dcloud.uts.log.LogSelfV2)) {
                io.dcloud.uts.gson.JsonArray jsonArray10 = jsonArray8;
                str4 = "__$originalPosition";
                char c = 0;
                if (kotlin.jvm.internal.Intrinsics.areEqual(orCreateKotlinClass.getObjectInstance(), objInstance)) {
                    str4 = str4;
                    jsonObject = jsonObject16;
                    jsonArray2 = jsonArray10;
                } else {
                    if (objInstance instanceof io.dcloud.uts.log.ILogParent) {
                        hashSet = inputStock;
                        atomicInteger = nextLimitCounter;
                        fillRootJsonWithMap(((io.dcloud.uts.log.ILogParent) objInstance).toLogMap(), hashSet, jsonObject16, atomicInteger, jsonArray10, objInstance);
                    } else {
                        hashSet = inputStock;
                        atomicInteger = nextLimitCounter;
                    }
                    io.dcloud.uts.gson.JsonObject jsonObject18 = jsonObject16;
                    java.util.Iterator it3 = kotlin.reflect.full.KClasses.getDeclaredMemberProperties(orCreateKotlinClass).iterator();
                    while (it3.hasNext()) {
                        kotlin.reflect.KProperty1 kProperty1 = (kotlin.reflect.KProperty1) it3.next();
                        java.lang.String name = kProperty1.getName();
                        java.util.Iterator it4 = it3;
                        try {
                            jsonArray3 = jsonArray10;
                            try {
                                kotlin.reflect.jvm.KCallablesJvm.setAccessible(kProperty1, true);
                                java.lang.Object[] objArr = new java.lang.Object[1];
                                objArr[c] = objInstance;
                                objCall2 = kProperty1.call(objArr);
                                z2 = false;
                            } catch (java.lang.Throwable unused) {
                                z2 = true;
                                objCall2 = null;
                            }
                        } catch (java.lang.Throwable unused2) {
                            jsonArray3 = jsonArray10;
                        }
                        if (z2) {
                            jsonObject18 = jsonObject18;
                            str14 = str14;
                            str6 = str10;
                            str7 = str13;
                            str8 = str15;
                            jsonArray4 = jsonArray3;
                        } else if ((objCall2 instanceof io.dcloud.uts.UTSSourceMapPosition) && kotlin.jvm.internal.Intrinsics.areEqual(str4, name)) {
                            io.dcloud.uts.gson.JsonObject jsonObject19 = new io.dcloud.uts.gson.JsonObject();
                            io.dcloud.uts.UTSSourceMapPosition uTSSourceMapPosition = (io.dcloud.uts.UTSSourceMapPosition) objCall2;
                            jsonObject19.addProperty("name", uTSSourceMapPosition.getName());
                            jsonObject19.addProperty("file", uTSSourceMapPosition.getFile());
                            jsonObject19.addProperty("column", java.lang.Integer.valueOf(uTSSourceMapPosition.getColumn()));
                            jsonObject19.addProperty("line", java.lang.Integer.valueOf(uTSSourceMapPosition.getLine()));
                            jsonObject18.add(str4, jsonObject19);
                            jsonObject18 = jsonObject18;
                            str14 = str14;
                            str6 = str10;
                            str7 = str13;
                            str8 = str15;
                            jsonArray4 = jsonArray3;
                        } else {
                            if (kotlin.jvm.internal.Intrinsics.areEqual(str14, kProperty1.getReturnType().toString())) {
                                strLogTypeOf$default2 = INSTANCE.logTypeOf(str14, true);
                            } else {
                                strLogTypeOf$default2 = logTypeOf$default(INSTANCE, objCall2, false, 2, null);
                            }
                            if (kotlin.jvm.internal.Intrinsics.areEqual(name, "Companion") && objCall2 != null) {
                                kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(objCall2.getClass()).isCompanion();
                                str6 = str10;
                                str7 = str13;
                                str8 = str15;
                                jsonArray4 = jsonArray3;
                            } else {
                                io.dcloud.uts.gson.JsonObject jsonObject20 = new io.dcloud.uts.gson.JsonObject();
                                jsonObject20.add(str9, new io.dcloud.uts.gson.JsonPrimitive(strLogTypeOf$default2));
                                io.dcloud.uts.android.ClassLogWrapper classLogWrapper2 = INSTANCE;
                                if (classLogWrapper2.needSubType(strLogTypeOf$default2, objCall2) && (strLogSubTypeOf = classLogWrapper2.logSubTypeOf(objCall2)) != null) {
                                    jsonObject20.add("subType", new io.dcloud.uts.gson.JsonPrimitive(strLogSubTypeOf));
                                }
                                jsonObject20.add("name", new io.dcloud.uts.gson.JsonPrimitive(name));
                                if (objCall2 instanceof kotlin.Function) {
                                    kotlin.reflect.KFunction kFunctionReflect2 = kotlin.reflect.jvm.ReflectLambdaKt.reflect((kotlin.Function) objCall2);
                                    if (kFunctionReflect2 != null) {
                                        io.dcloud.uts.gson.JsonArray jsonArray11 = new io.dcloud.uts.gson.JsonArray();
                                        java.util.Iterator<T> it5 = kFunctionReflect2.getParameters().iterator();
                                        while (it5.hasNext()) {
                                            jsonArray11.add(new io.dcloud.uts.gson.JsonPrimitive(INSTANCE.logTypeOf(((kotlin.reflect.KParameter) it5.next()).getType().toString(), true)));
                                            kFunctionReflect2 = kFunctionReflect2;
                                        }
                                        kotlin.reflect.KFunction kFunction2 = kFunctionReflect2;
                                        jsonObject20.add("parameter", jsonArray11);
                                        if (!kotlin.jvm.internal.Intrinsics.areEqual("kotlin.Unit", kFunction2.getReturnType().toString())) {
                                            jsonObject20.add(str11, new io.dcloud.uts.gson.JsonPrimitive(INSTANCE.logTypeOf(kFunction2.getReturnType().toString(), true)));
                                        }
                                    }
                                    str6 = str10;
                                } else {
                                    java.lang.String str16 = str11;
                                    io.dcloud.uts.gson.JsonElement jsonElementWrapClass = classLogWrapper2.wrapClass(objCall2, objInstance, hashSet, atomicInteger);
                                    str6 = str10;
                                    if (kotlin.jvm.internal.Intrinsics.areEqual(str6, strLogTypeOf$default2)) {
                                        str11 = str16;
                                        if (jsonElementWrapClass instanceof io.dcloud.uts.gson.JsonObject) {
                                            java.util.Set<java.util.Map.Entry<java.lang.String, io.dcloud.uts.gson.JsonElement>> setEntrySet = ((io.dcloud.uts.gson.JsonObject) jsonElementWrapClass).entrySet();
                                            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(setEntrySet, "entrySet(...)");
                                            java.util.Iterator<T> it6 = setEntrySet.iterator();
                                            while (it6.hasNext()) {
                                                java.util.Map.Entry entry2 = (java.util.Map.Entry) it6.next();
                                                jsonObject20.add((java.lang.String) entry2.getKey(), (io.dcloud.uts.gson.JsonElement) entry2.getValue());
                                            }
                                        }
                                        jsonArray4 = jsonArray3;
                                        jsonArray4.add(jsonObject20);
                                    } else {
                                        str11 = str16;
                                    }
                                    if (kotlin.jvm.internal.Intrinsics.areEqual(str6, strLogTypeOf$default2) && kotlin.jvm.internal.Intrinsics.areEqual("\"[Circular]\"", jsonElementWrapClass.toString())) {
                                        str8 = str15;
                                        jsonObject20.add(str8, jsonElementWrapClass);
                                        kotlin.jvm.internal.Intrinsics.checkNotNull(objCall2);
                                        io.dcloud.uts.gson.JsonPrimitive jsonPrimitive = new io.dcloud.uts.gson.JsonPrimitive(classLogWrapper2.logClassOf(objCall2));
                                        str7 = str13;
                                        jsonObject20.add(str7, jsonPrimitive);
                                    } else {
                                        str7 = str13;
                                        str8 = str15;
                                        jsonObject20.add(str8, jsonElementWrapClass);
                                    }
                                    jsonArray4 = jsonArray3;
                                    jsonArray4.add(jsonObject20);
                                }
                                str7 = str13;
                                str8 = str15;
                                jsonArray4 = jsonArray3;
                                jsonArray4.add(jsonObject20);
                            }
                        }
                        str15 = str8;
                        str13 = str7;
                        jsonArray10 = jsonArray4;
                        str10 = str6;
                        it3 = it4;
                        str14 = str14;
                        jsonObject18 = jsonObject18;
                        str9 = str9;
                        c = 0;
                    }
                    io.dcloud.uts.gson.JsonObject jsonObject21 = jsonObject18;
                    jsonArray2 = jsonArray10;
                    str5 = str15;
                    if (!zIsAnonymousClass || orCreateKotlinClass.getSupertypes().isEmpty()) {
                        jsonObject = jsonObject21;
                    } else {
                        io.dcloud.uts.gson.JsonPrimitive jsonPrimitive2 = new io.dcloud.uts.gson.JsonPrimitive(orCreateKotlinClass.getSupertypes().get(0).toString());
                        jsonObject = jsonObject21;
                        if (!jsonObject.has(str4)) {
                            io.dcloud.uts.gson.JsonObject jsonObject22 = new io.dcloud.uts.gson.JsonObject();
                            jsonObject22.add("name", jsonPrimitive2);
                            jsonObject.add(str4, jsonObject22);
                        }
                    }
                }
                jsonObject17.add("properties", jsonArray2);
                it = kotlin.reflect.full.KClasses.getDeclaredMemberFunctions(orCreateKotlinClass).iterator();
                while (it.hasNext()) {
                    kFunction = (kotlin.reflect.KFunction) it.next();
                    java.lang.String name2 = kFunction.getName();
                    try {
                        kotlin.reflect.jvm.KCallablesJvm.setAccessible(kFunction, true);
                        if (!(objInstance instanceof io.dcloud.uts.IUTSSourceMap) && kotlin.jvm.internal.Intrinsics.areEqual("__$getOriginalPosition", name2)) {
                            R rCall = kFunction.call(objInstance);
                            if (rCall instanceof io.dcloud.uts.UTSSourceMapPosition) {
                                io.dcloud.uts.gson.JsonObject jsonObject23 = new io.dcloud.uts.gson.JsonObject();
                                io.dcloud.uts.UTSSourceMapPosition uTSSourceMapPosition2 = (io.dcloud.uts.UTSSourceMapPosition) rCall;
                                jsonObject23.addProperty("name", uTSSourceMapPosition2.getName());
                                jsonObject23.addProperty("file", uTSSourceMapPosition2.getFile());
                                jsonObject23.addProperty("column", java.lang.Integer.valueOf(uTSSourceMapPosition2.getColumn()));
                                jsonObject23.addProperty("line", java.lang.Integer.valueOf(uTSSourceMapPosition2.getLine()));
                                jsonObject.add(str4, jsonObject23);
                            }
                        }
                    } catch (java.lang.Throwable unused3) {
                    }
                }
                jsonObject17.add("methods", jsonArray9);
                jsonObject.add(str5, jsonObject17);
            } else {
                fillRootJsonWithMap(((io.dcloud.uts.log.LogSelfV2) objInstance).toLogMap(), inputStock, jsonObject16, nextLimitCounter, jsonArray8, objInstance);
                jsonObject = jsonObject16;
                jsonArray2 = jsonArray8;
                str4 = "__$originalPosition";
            }
            str5 = str15;
            jsonObject17.add("properties", jsonArray2);
            it = kotlin.reflect.full.KClasses.getDeclaredMemberFunctions(orCreateKotlinClass).iterator();
            while (it.hasNext()) {
                kFunction = (kotlin.reflect.KFunction) it.next();
                java.lang.String name3 = kFunction.getName();
                kotlin.reflect.jvm.KCallablesJvm.setAccessible(kFunction, true);
                if (!(objInstance instanceof io.dcloud.uts.IUTSSourceMap)) {
                }
            }
            jsonObject17.add("methods", jsonArray9);
            jsonObject.add(str5, jsonObject17);
        } else {
            java.lang.String str17 = "returned";
            java.lang.Object obj2 = "kotlin.Number";
            io.dcloud.uts.gson.JsonObject jsonObject24 = jsonObject17;
            io.dcloud.uts.gson.JsonArray jsonArray12 = jsonArray8;
            jsonObject = jsonObject16;
            java.lang.String str18 = "properties";
            if (kotlin.jvm.internal.Intrinsics.areEqual("array", strLogSubTypeOf2)) {
                if (objInstance instanceof java.lang.Object[]) {
                    int i = 0;
                    for (java.lang.Object obj3 : (java.lang.Object[]) objInstance) {
                        io.dcloud.uts.gson.JsonElement jsonElementWrapClass2 = INSTANCE.wrapClass(obj3, null, inputStock, nextLimitCounter);
                        if (jsonElementWrapClass2 instanceof io.dcloud.uts.gson.JsonObject) {
                            ((io.dcloud.uts.gson.JsonObject) jsonElementWrapClass2).addProperty("name", java.lang.Integer.valueOf(i));
                        }
                        jsonArray12.add(jsonElementWrapClass2);
                        i++;
                    }
                    jsonObject24.add(str18, jsonArray12);
                }
                if (objInstance instanceof byte[]) {
                    int i2 = 0;
                    for (byte b : (byte[]) objInstance) {
                        io.dcloud.uts.gson.JsonElement jsonElementWrapClass3 = INSTANCE.wrapClass(java.lang.Byte.valueOf(b), null, inputStock, nextLimitCounter);
                        if (jsonElementWrapClass3 instanceof io.dcloud.uts.gson.JsonObject) {
                            ((io.dcloud.uts.gson.JsonObject) jsonElementWrapClass3).addProperty("name", java.lang.Integer.valueOf(i2));
                        }
                        jsonArray12.add(jsonElementWrapClass3);
                        i2++;
                    }
                    jsonObject24.add(str18, jsonArray12);
                }
                if (objInstance instanceof char[]) {
                    int i3 = 0;
                    for (char c2 : (char[]) objInstance) {
                        io.dcloud.uts.gson.JsonElement jsonElementWrapClass4 = INSTANCE.wrapClass(java.lang.Character.valueOf(c2), null, inputStock, nextLimitCounter);
                        if (jsonElementWrapClass4 instanceof io.dcloud.uts.gson.JsonObject) {
                            ((io.dcloud.uts.gson.JsonObject) jsonElementWrapClass4).addProperty("name", java.lang.Integer.valueOf(i3));
                        }
                        jsonArray12.add(jsonElementWrapClass4);
                        i3++;
                    }
                    jsonObject24.add(str18, jsonArray12);
                }
                if (objInstance instanceof short[]) {
                    int i4 = 0;
                    for (short s : (short[]) objInstance) {
                        io.dcloud.uts.gson.JsonElement jsonElementWrapClass5 = INSTANCE.wrapClass(java.lang.Short.valueOf(s), null, inputStock, nextLimitCounter);
                        if (jsonElementWrapClass5 instanceof io.dcloud.uts.gson.JsonObject) {
                            ((io.dcloud.uts.gson.JsonObject) jsonElementWrapClass5).addProperty("name", java.lang.Integer.valueOf(i4));
                        }
                        jsonArray12.add(jsonElementWrapClass5);
                        i4++;
                    }
                    jsonObject24.add(str18, jsonArray12);
                }
                if (objInstance instanceof int[]) {
                    int i5 = 0;
                    for (int i6 : (int[]) objInstance) {
                        io.dcloud.uts.gson.JsonElement jsonElementWrapClass6 = INSTANCE.wrapClass(java.lang.Integer.valueOf(i6), null, inputStock, nextLimitCounter);
                        if (jsonElementWrapClass6 instanceof io.dcloud.uts.gson.JsonObject) {
                            ((io.dcloud.uts.gson.JsonObject) jsonElementWrapClass6).addProperty("name", java.lang.Integer.valueOf(i5));
                        }
                        jsonArray12.add(jsonElementWrapClass6);
                        i5++;
                    }
                    jsonObject24.add(str18, jsonArray12);
                }
                if (objInstance instanceof long[]) {
                    int i7 = 0;
                    for (long j : (long[]) objInstance) {
                        io.dcloud.uts.gson.JsonElement jsonElementWrapClass7 = INSTANCE.wrapClass(java.lang.Long.valueOf(j), null, inputStock, nextLimitCounter);
                        if (jsonElementWrapClass7 instanceof io.dcloud.uts.gson.JsonObject) {
                            ((io.dcloud.uts.gson.JsonObject) jsonElementWrapClass7).addProperty("name", java.lang.Integer.valueOf(i7));
                        }
                        jsonArray12.add(jsonElementWrapClass7);
                        i7++;
                    }
                    jsonObject24.add(str18, jsonArray12);
                }
                if (objInstance instanceof float[]) {
                    int i8 = 0;
                    for (float f : (float[]) objInstance) {
                        io.dcloud.uts.gson.JsonElement jsonElementWrapClass8 = INSTANCE.wrapClass(java.lang.Float.valueOf(f), null, inputStock, nextLimitCounter);
                        if (jsonElementWrapClass8 instanceof io.dcloud.uts.gson.JsonObject) {
                            ((io.dcloud.uts.gson.JsonObject) jsonElementWrapClass8).addProperty("name", java.lang.Integer.valueOf(i8));
                        }
                        jsonArray12.add(jsonElementWrapClass8);
                        i8++;
                    }
                    jsonObject24.add(str18, jsonArray12);
                }
                if (objInstance instanceof double[]) {
                    int i9 = 0;
                    for (double d : (double[]) objInstance) {
                        io.dcloud.uts.gson.JsonElement jsonElementWrapClass9 = INSTANCE.wrapClass(java.lang.Double.valueOf(d), null, inputStock, nextLimitCounter);
                        if (jsonElementWrapClass9 instanceof io.dcloud.uts.gson.JsonObject) {
                            ((io.dcloud.uts.gson.JsonObject) jsonElementWrapClass9).addProperty("name", java.lang.Integer.valueOf(i9));
                        }
                        jsonArray12.add(jsonElementWrapClass9);
                        i9++;
                    }
                    jsonObject24.add(str18, jsonArray12);
                }
                if (objInstance instanceof boolean[]) {
                    int i10 = 0;
                    for (boolean z3 : (boolean[]) objInstance) {
                        io.dcloud.uts.gson.JsonElement jsonElementWrapClass10 = INSTANCE.wrapClass(java.lang.Boolean.valueOf(z3), null, inputStock, nextLimitCounter);
                        if (jsonElementWrapClass10 instanceof io.dcloud.uts.gson.JsonObject) {
                            ((io.dcloud.uts.gson.JsonObject) jsonElementWrapClass10).addProperty("name", java.lang.Integer.valueOf(i10));
                        }
                        jsonArray12.add(jsonElementWrapClass10);
                        i10++;
                    }
                    jsonObject24.add(str18, jsonArray12);
                } else if (objInstance instanceof java.util.List) {
                    java.util.Iterator it7 = ((java.lang.Iterable) objInstance).iterator();
                    int i11 = 0;
                    while (it7.hasNext()) {
                        io.dcloud.uts.gson.JsonElement jsonElementWrapClass11 = INSTANCE.wrapClass(it7.next(), null, inputStock, nextLimitCounter);
                        if (jsonElementWrapClass11 instanceof io.dcloud.uts.gson.JsonObject) {
                            ((io.dcloud.uts.gson.JsonObject) jsonElementWrapClass11).addProperty("name", java.lang.Integer.valueOf(i11));
                        }
                        jsonArray12.add(jsonElementWrapClass11);
                        i11++;
                    }
                    jsonObject24.add(str18, jsonArray12);
                }
                jsonObject.add(str15, jsonObject24);
            } else if (kotlin.jvm.internal.Intrinsics.areEqual("error", strLogSubTypeOf2)) {
                boolean z4 = objInstance instanceof java.lang.Throwable;
                if (z4) {
                    java.util.Iterator it8 = kotlin.reflect.full.KClasses.getMemberProperties(kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(objInstance.getClass())).iterator();
                    while (it8.hasNext()) {
                        boolean z5 = z4;
                        kotlin.reflect.KProperty1 kProperty2 = (kotlin.reflect.KProperty1) it8.next();
                        java.util.Iterator it9 = it8;
                        java.lang.String name4 = kProperty2.getName();
                        io.dcloud.uts.gson.JsonObject jsonObject25 = jsonObject;
                        try {
                            jsonObject3 = jsonObject24;
                            try {
                                kotlin.reflect.jvm.KCallablesJvm.setAccessible(kProperty2, true);
                                objCall = kProperty2.call(objInstance);
                                z = false;
                            } catch (java.lang.Throwable unused4) {
                                z = true;
                                objCall = null;
                            }
                        } catch (java.lang.Throwable unused5) {
                            jsonObject3 = jsonObject24;
                        }
                        if (z) {
                            jsonArray = jsonArray12;
                            str18 = str18;
                            str = str12;
                            str2 = str17;
                            str3 = str13;
                        } else {
                            java.lang.String string2 = kProperty2.getReturnType().toString();
                            obj2 = obj2;
                            if (kotlin.jvm.internal.Intrinsics.areEqual(obj2, string2)) {
                                strLogTypeOf$default = INSTANCE.logTypeOf(obj2, true);
                            } else {
                                strLogTypeOf$default = logTypeOf$default(INSTANCE, objCall, false, 2, null);
                            }
                            if (kotlin.jvm.internal.Intrinsics.areEqual(name4, str12) && objCall != null) {
                                kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(objCall.getClass()).isCompanion();
                                str = str12;
                                str2 = str17;
                                str3 = str13;
                                jsonArray = jsonArray12;
                            } else {
                                io.dcloud.uts.gson.JsonObject jsonObject26 = new io.dcloud.uts.gson.JsonObject();
                                jsonObject26.add("type", new io.dcloud.uts.gson.JsonPrimitive(strLogTypeOf$default));
                                io.dcloud.uts.android.ClassLogWrapper classLogWrapper3 = INSTANCE;
                                if (classLogWrapper3.needSubType(strLogTypeOf$default, objCall)) {
                                    java.lang.String strLogSubTypeOf3 = classLogWrapper3.logSubTypeOf(objCall);
                                    str = str12;
                                    if (strLogSubTypeOf3 != null) {
                                        jsonObject26.add("subType", new io.dcloud.uts.gson.JsonPrimitive(strLogSubTypeOf3));
                                    }
                                } else {
                                    str = str12;
                                }
                                jsonObject26.add("name", new io.dcloud.uts.gson.JsonPrimitive(name4));
                                if (objCall instanceof kotlin.Function) {
                                    kotlin.reflect.KFunction kFunctionReflect3 = kotlin.reflect.jvm.ReflectLambdaKt.reflect((kotlin.Function) objCall);
                                    if (kFunctionReflect3 != null) {
                                        io.dcloud.uts.gson.JsonArray jsonArray13 = new io.dcloud.uts.gson.JsonArray();
                                        java.util.Iterator<T> it10 = kFunctionReflect3.getParameters().iterator();
                                        while (it10.hasNext()) {
                                            jsonArray13.add(new io.dcloud.uts.gson.JsonPrimitive(INSTANCE.logTypeOf(((kotlin.reflect.KParameter) it10.next()).getType().toString(), true)));
                                            kFunctionReflect3 = kFunctionReflect3;
                                        }
                                        kotlin.reflect.KFunction kFunction3 = kFunctionReflect3;
                                        jsonObject26.add("parameter", jsonArray13);
                                        if (kotlin.jvm.internal.Intrinsics.areEqual("kotlin.Unit", kFunction3.getReturnType().toString())) {
                                            str2 = str17;
                                        } else {
                                            str2 = str17;
                                            jsonObject26.add(str2, new io.dcloud.uts.gson.JsonPrimitive(INSTANCE.logTypeOf(kFunction3.getReturnType().toString(), true)));
                                        }
                                    } else {
                                        str2 = str17;
                                    }
                                } else {
                                    str2 = str17;
                                    io.dcloud.uts.gson.JsonElement jsonElementWrapClass12 = classLogWrapper3.wrapClass(objCall, objInstance, inputStock, nextLimitCounter);
                                    if (kotlin.jvm.internal.Intrinsics.areEqual("object", strLogTypeOf$default) && (jsonElementWrapClass12 instanceof io.dcloud.uts.gson.JsonObject)) {
                                        java.util.Set<java.util.Map.Entry<java.lang.String, io.dcloud.uts.gson.JsonElement>> setEntrySet2 = ((io.dcloud.uts.gson.JsonObject) jsonElementWrapClass12).entrySet();
                                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(setEntrySet2, "entrySet(...)");
                                        java.util.Iterator<T> it11 = setEntrySet2.iterator();
                                        while (it11.hasNext()) {
                                            java.util.Map.Entry entry3 = (java.util.Map.Entry) it11.next();
                                            jsonObject26.add((java.lang.String) entry3.getKey(), (io.dcloud.uts.gson.JsonElement) entry3.getValue());
                                        }
                                    } else if (kotlin.jvm.internal.Intrinsics.areEqual("object", strLogTypeOf$default) && kotlin.jvm.internal.Intrinsics.areEqual("\"[Circular]\"", jsonElementWrapClass12.toString())) {
                                        jsonObject26.add(str15, jsonElementWrapClass12);
                                        kotlin.jvm.internal.Intrinsics.checkNotNull(objCall);
                                        io.dcloud.uts.gson.JsonPrimitive jsonPrimitive3 = new io.dcloud.uts.gson.JsonPrimitive(classLogWrapper3.logClassOf(objCall));
                                        str3 = str13;
                                        jsonObject26.add(str3, jsonPrimitive3);
                                    } else {
                                        str3 = str13;
                                        jsonObject26.add(str15, jsonElementWrapClass12);
                                    }
                                    jsonArray = jsonArray12;
                                    jsonArray.add(jsonObject26);
                                }
                                str3 = str13;
                                jsonArray = jsonArray12;
                                jsonArray.add(jsonObject26);
                            }
                        }
                        str17 = str2;
                        str13 = str3;
                        it8 = it9;
                        z4 = z5;
                        str12 = str;
                        str18 = str18;
                        jsonObject = jsonObject25;
                        jsonArray12 = jsonArray;
                        jsonObject24 = jsonObject3;
                    }
                }
                io.dcloud.uts.gson.JsonObject jsonObject27 = jsonObject24;
                boolean z6 = z4;
                io.dcloud.uts.gson.JsonArray jsonArray14 = jsonArray12;
                io.dcloud.uts.gson.JsonObject jsonObject28 = jsonObject;
                java.lang.String str19 = str18;
                if (objInstance instanceof java.lang.reflect.InvocationTargetException) {
                    java.lang.Throwable targetException = ((java.lang.reflect.InvocationTargetException) objInstance).getTargetException();
                    kotlin.jvm.internal.Intrinsics.checkNotNull(targetException);
                    strStackTraceToString = kotlin.ExceptionsKt.stackTraceToString(targetException);
                } else if (!z6) {
                    strStackTraceToString = "";
                } else {
                    strStackTraceToString = kotlin.ExceptionsKt.stackTraceToString((java.lang.Throwable) objInstance);
                }
                jsonObject27.add(str19, jsonArray14);
                jsonObject27.add("stack", new io.dcloud.uts.gson.JsonPrimitive(strStackTraceToString));
                jsonObject2 = jsonObject28;
                jsonObject2.add(str15, jsonObject27);
            } else {
                jsonObject2 = jsonObject;
                if (objInstance instanceof io.dcloud.uts.UTSRegExp) {
                    jsonObject2.add(str15, new io.dcloud.uts.gson.JsonPrimitive(((io.dcloud.uts.UTSRegExp) objInstance).toString()));
                } else if (objInstance instanceof io.dcloud.uts.Date) {
                    jsonObject2.add(str15, new io.dcloud.uts.gson.JsonPrimitive(((io.dcloud.uts.Date) objInstance).toString()));
                } else if (objInstance instanceof java.util.Date) {
                    jsonObject2.add(str15, new io.dcloud.uts.gson.JsonPrimitive(new io.dcloud.uts.Date(java.lang.Long.valueOf(((java.util.Date) objInstance).getTime())).toString()));
                }
            }
            return jsonObject2;
        }
        jsonObject2 = jsonObject;
        return jsonObject2;
    }

    private final java.lang.String logClassOf(java.lang.Object input) {
        if (input instanceof java.lang.Class) {
            return ((java.lang.Class) input).getName();
        }
        if (input instanceof kotlin.reflect.KClass) {
            return kotlin.jvm.JvmClassMappingKt.getJavaClass((kotlin.reflect.KClass) input).getName();
        }
        java.lang.String qualifiedName = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(input.getClass()).getQualifiedName();
        return qualifiedName != null ? qualifiedName : input.getClass().getName();
    }

    private final boolean needSubType(java.lang.String type, java.lang.Object value) {
        return kotlin.jvm.internal.Intrinsics.areEqual(type, "object") || (value instanceof java.lang.Number);
    }

    private final java.lang.String logSubTypeOf(java.lang.Object input) {
        if ((input instanceof io.dcloud.uts.UTSArray) || (input instanceof java.util.List) || (input instanceof java.lang.Object[]) || (input instanceof byte[]) || (input instanceof char[]) || (input instanceof short[]) || (input instanceof float[]) || (input instanceof double[]) || (input instanceof int[]) || (input instanceof boolean[]) || (input instanceof long[])) {
            return "array";
        }
        if ((input instanceof io.dcloud.uts.UTSRegExp) || (input instanceof kotlin.text.Regex)) {
            return "regexp";
        }
        if ((input instanceof io.dcloud.uts.Date) || (input instanceof java.util.Date)) {
            return "date";
        }
        if (input instanceof java.lang.Number) {
            return "number";
        }
        if (input instanceof java.lang.String) {
            return "string";
        }
        if (input instanceof java.lang.Throwable) {
            return "error";
        }
        if (input instanceof java.util.Set) {
            return "set";
        }
        if (input instanceof java.util.Map) {
            return "map";
        }
        if (input instanceof kotlin.Function) {
            return "function";
        }
        if ((input instanceof java.lang.Class) || (input instanceof kotlin.reflect.KClass)) {
            return "class";
        }
        return "object";
    }

    static /* synthetic */ java.lang.String logTypeOf$default(io.dcloud.uts.android.ClassLogWrapper classLogWrapper, java.lang.Object obj, boolean z, int i, java.lang.Object obj2) {
        if ((i & 2) != 0) {
            z = false;
        }
        return classLogWrapper.logTypeOf(obj, z);
    }

    private final java.lang.String logTypeOf(java.lang.Object input, boolean isReturnTag) {
        if (input == null) {
            return "null";
        }
        if (isReturnTag && (input instanceof java.lang.String)) {
            if (kotlin.jvm.internal.Intrinsics.areEqual("kotlin.Number", input)) {
                return "number";
            }
            if (kotlin.jvm.internal.Intrinsics.areEqual("kotlin.String", input)) {
                return "string";
            }
            return (java.lang.String) input;
        }
        return io.dcloud.uts.UTSAndroid.INSTANCE.typeof(input);
    }

    private final void fillRootJsonWithMap(java.util.Map<java.lang.String, ? extends java.lang.Object> customMap, java.util.HashSet<java.lang.Object> inputStock, io.dcloud.uts.gson.JsonObject rootJsonObject, java.util.concurrent.atomic.AtomicInteger nextLimitCounter, io.dcloud.uts.gson.JsonArray valueProperObject, java.lang.Object objInstance) {
        java.lang.String strLogTypeOf$default;
        java.lang.String strLogSubTypeOf;
        for (java.util.Map.Entry<java.lang.String, ? extends java.lang.Object> entry : customMap.entrySet()) {
            java.lang.String key = entry.getKey();
            java.lang.Object value = entry.getValue();
            io.dcloud.uts.gson.JsonObject jsonObject = new io.dcloud.uts.gson.JsonObject();
            if (kotlin.jvm.internal.Intrinsics.areEqual("__$originalPosition", key) && (value instanceof io.dcloud.uts.gson.JsonObject)) {
                rootJsonObject.add("__$originalPosition", (io.dcloud.uts.gson.JsonElement) value);
            } else {
                if (value instanceof io.dcloud.uts.android.UTSLogInfo) {
                    io.dcloud.uts.android.UTSLogInfo uTSLogInfo = (io.dcloud.uts.android.UTSLogInfo) value;
                    strLogTypeOf$default = INSTANCE.logTypeOf(uTSLogInfo.getType(), true);
                    value = uTSLogInfo.getValue();
                } else {
                    strLogTypeOf$default = logTypeOf$default(INSTANCE, value, false, 2, null);
                }
                jsonObject.add("type", new io.dcloud.uts.gson.JsonPrimitive(strLogTypeOf$default));
                io.dcloud.uts.android.ClassLogWrapper classLogWrapper = INSTANCE;
                if (classLogWrapper.needSubType(strLogTypeOf$default, value) && (strLogSubTypeOf = classLogWrapper.logSubTypeOf(value)) != null) {
                    jsonObject.add("subType", new io.dcloud.uts.gson.JsonPrimitive(strLogSubTypeOf));
                }
                jsonObject.add("name", new io.dcloud.uts.gson.JsonPrimitive(key));
                if (value instanceof kotlin.Function) {
                    kotlin.reflect.KFunction kFunctionReflect = kotlin.reflect.jvm.ReflectLambdaKt.reflect((kotlin.Function) value);
                    if (kFunctionReflect != null) {
                        io.dcloud.uts.gson.JsonArray jsonArray = new io.dcloud.uts.gson.JsonArray();
                        java.util.Iterator<T> it = kFunctionReflect.getParameters().iterator();
                        while (it.hasNext()) {
                            jsonArray.add(new io.dcloud.uts.gson.JsonPrimitive(INSTANCE.logTypeOf(((kotlin.reflect.KParameter) it.next()).getType().toString(), true)));
                        }
                        jsonObject.add("parameter", jsonArray);
                        if (!kotlin.jvm.internal.Intrinsics.areEqual("kotlin.Unit", kFunctionReflect.getReturnType().toString())) {
                            jsonObject.add("returned", new io.dcloud.uts.gson.JsonPrimitive(logTypeOf$default(INSTANCE, kFunctionReflect.getReturnType().toString(), false, 2, null)));
                        }
                    }
                } else {
                    io.dcloud.uts.gson.JsonElement jsonElementWrapClass = classLogWrapper.wrapClass(value, objInstance, inputStock, nextLimitCounter);
                    if (kotlin.jvm.internal.Intrinsics.areEqual("object", strLogTypeOf$default) && (jsonElementWrapClass instanceof io.dcloud.uts.gson.JsonObject)) {
                        java.util.Set<java.util.Map.Entry<java.lang.String, io.dcloud.uts.gson.JsonElement>> setEntrySet = ((io.dcloud.uts.gson.JsonObject) jsonElementWrapClass).entrySet();
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(setEntrySet, "entrySet(...)");
                        java.util.Iterator<T> it2 = setEntrySet.iterator();
                        while (it2.hasNext()) {
                            java.util.Map.Entry entry2 = (java.util.Map.Entry) it2.next();
                            jsonObject.add((java.lang.String) entry2.getKey(), (io.dcloud.uts.gson.JsonElement) entry2.getValue());
                        }
                    } else if (kotlin.jvm.internal.Intrinsics.areEqual("object", strLogTypeOf$default) && kotlin.jvm.internal.Intrinsics.areEqual("\"[Circular]\"", jsonElementWrapClass.toString())) {
                        jsonObject.add("value", jsonElementWrapClass);
                        kotlin.jvm.internal.Intrinsics.checkNotNull(value);
                        jsonObject.add("className", new io.dcloud.uts.gson.JsonPrimitive(classLogWrapper.logClassOf(value)));
                    } else {
                        jsonObject.add("value", jsonElementWrapClass);
                    }
                }
                valueProperObject.add(jsonObject);
            }
        }
        if (objInstance instanceof io.dcloud.uts.UTSJSONObject) {
            if (!rootJsonObject.has("__$originalPosition")) {
                io.dcloud.uts.gson.JsonObject jsonObject2 = new io.dcloud.uts.gson.JsonObject();
                jsonObject2.add("name", new io.dcloud.uts.gson.JsonPrimitive("UTSJSONObject"));
                rootJsonObject.add("__$originalPosition", jsonObject2);
            } else {
                io.dcloud.uts.gson.JsonElement jsonElement = rootJsonObject.get("__$originalPosition");
                if (jsonElement instanceof io.dcloud.uts.gson.JsonObject) {
                    ((io.dcloud.uts.gson.JsonObject) jsonElement).add("name", new io.dcloud.uts.gson.JsonPrimitive("UTSJSONObject"));
                }
                rootJsonObject.add("__$originalPosition", jsonElement);
            }
        }
    }
}
