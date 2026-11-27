package com.alibaba.fastjson.asm;

/* JADX INFO: loaded from: classes.dex */
public final class FieldWriter {
    private final int access;
    private final int desc;
    private final int name;
    com.alibaba.fastjson.asm.FieldWriter next;

    int getSize() {
        return 8;
    }

    public void visitEnd() {
    }

    public FieldWriter(com.alibaba.fastjson.asm.ClassWriter classWriter, int i, java.lang.String str, java.lang.String str2) {
        if (classWriter.firstField == null) {
            classWriter.firstField = this;
        } else {
            classWriter.lastField.next = this;
        }
        classWriter.lastField = this;
        this.access = i;
        this.name = classWriter.newUTF8(str);
        this.desc = classWriter.newUTF8(str2);
    }

    void put(com.alibaba.fastjson.asm.ByteVector byteVector) {
        byteVector.putShort(this.access & (-393217)).putShort(this.name).putShort(this.desc);
        byteVector.putShort(0);
    }
}
