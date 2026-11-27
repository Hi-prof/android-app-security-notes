package io.dcloud.uts;

/* JADX INFO: compiled from: UTSArray.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010)\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u001c\b\u0016\u0018\u0000 k*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001kB\u0007¢\u0006\u0004\b\u0003\u0010\u0004B\u0017\b\u0016\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\u0003\u0010\u0007B\u001d\b\u0016\u0012\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\t\"\u00028\u0000¢\u0006\u0004\b\u0003\u0010\nB\u0019\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00028\u0000¢\u0006\u0004\b\u0003\u0010\u000eJ\u0016\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00020\fH\u0086\u0002¢\u0006\u0002\u0010\u0017J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0016J'\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001a0\t\"\u00020\u001aH\u0016¢\u0006\u0002\u0010\u001bJ.\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001d\u001a\u00020\f2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\fH\u0016J+\u0010 \u001a\u00020!2!\u0010\"\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020!0#H\u0016J@\u0010 \u001a\u00020!26\u0010\"\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\f¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020!0&H\u0016J[\u0010 \u001a\u00020!2Q\u0010\"\u001aM\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\f¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u0016\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0000¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b((\u0012\u0004\u0012\u00020!0'H\u0016J3\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u000f\u001a\u00028\u00002\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0002\u0010*J1\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002!\u0010\"\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020!0#H\u0016JF\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000\u000026\u0010\"\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\f¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020!0&H\u0016Ja\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002Q\u0010\"\u001aM\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\f¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u0016\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0000¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b((\u0012\u0004\u0012\u00020!0'H\u0016J2\u0010,\u001a\u0004\u0018\u00018\u00002!\u0010\"\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020!0#H\u0016¢\u0006\u0002\u0010-JG\u0010,\u001a\u0004\u0018\u00018\u000026\u0010\"\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\f¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020!0&H\u0016¢\u0006\u0002\u0010.Jb\u0010,\u001a\u0004\u0018\u00018\u00002Q\u0010\"\u001aM\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\f¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u0016\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0000¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b((\u0012\u0004\u0012\u00020!0'H\u0016¢\u0006\u0002\u0010/J+\u00100\u001a\u0002012!\u0010\"\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020!0#H\u0016J@\u00100\u001a\u00020126\u0010\"\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\f¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020!0&H\u0016J[\u00100\u001a\u0002012Q\u0010\"\u001aM\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\f¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u0016\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0000¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b((\u0012\u0004\u0012\u00020!0'H\u0016J\u0016\u00102\u001a\u0006\u0012\u0002\b\u00030\u00002\b\b\u0002\u00103\u001a\u00020\fH\u0016J3\u00104\u001a\u0006\u0012\u0002\b\u00030\u00002%\u0010\"\u001a!\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u000f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00000#H\u0016JH\u00104\u001a\u0006\u0012\u0002\b\u00030\u00002:\u0010\"\u001a6\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\f¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00000&H\u0016Jc\u00104\u001a\u0006\u0012\u0002\b\u00030\u00002U\u0010\"\u001aQ\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\f¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u0016\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0000¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b((\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00000'H\u0016J\u0015\u00105\u001a\u00020!2\u0006\u00106\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00107J\u001d\u00105\u001a\u00020!2\u0006\u00106\u001a\u00028\u00002\u0006\u00108\u001a\u00020\fH\u0016¢\u0006\u0002\u00109J@\u0010:\u001a\u00020;26\u0010\"\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\f¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020;0&H\u0016J[\u0010:\u001a\u00020;2Q\u0010\"\u001aM\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\f¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u0016\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0000¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b((\u0012\u0004\u0012\u00020;0'H\u0016J\u0015\u0010<\u001a\u0002012\u0006\u00106\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010=J\u001f\u0010<\u001a\u0002012\u0006\u00106\u001a\u00028\u00002\b\b\u0002\u00108\u001a\u00020\fH\u0016¢\u0006\u0002\u0010>J\u0012\u0010?\u001a\u00020@2\b\b\u0002\u0010A\u001a\u00020@H\u0016J\u000e\u0010B\u001a\b\u0012\u0004\u0012\u00020\f0CH\u0016J\u0015\u0010D\u001a\u0002012\u0006\u00106\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010=J\u001f\u0010D\u001a\u0002012\u0006\u00106\u001a\u00028\u00002\b\b\u0002\u00108\u001a\u00020\fH\u0016¢\u0006\u0002\u0010>J7\u0010E\u001a\b\u0012\u0004\u0012\u0002HF0\u0000\"\u0004\b\u0001\u0010F2!\u0010\"\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u0002HF0#H\u0016JL\u0010E\u001a\b\u0012\u0004\u0012\u0002HF0\u0000\"\u0004\b\u0001\u0010F26\u0010\"\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\f¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u0002HF0&H\u0016Jg\u0010E\u001a\b\u0012\u0004\u0012\u0002HF0\u0000\"\u0004\b\u0001\u0010F2Q\u0010\"\u001aM\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\f¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u0016\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0000¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b((\u0012\u0004\u0012\u0002HF0'H\u0016J\u000f\u0010G\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010HJ!\u0010I\u001a\u0002012\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\t\"\u00028\u0000H\u0016¢\u0006\u0002\u0010JJd\u0010K\u001a\u00028\u0000\"\b\b\u0001\u0010L*\u00028\u00002K\u0010\"\u001aG\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(M\u0012\u0013\u0012\u0011HL¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(N\u0012\u0013\u0012\u00110\f¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(O\u0012\u0004\u0012\u00028\u00000'H\u0016¢\u0006\u0002\u0010/J\u007f\u0010K\u001a\u00028\u0000\"\b\b\u0001\u0010L*\u00028\u00002f\u0010\"\u001ab\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(M\u0012\u0013\u0012\u0011HL¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(N\u0012\u0013\u0012\u00110\f¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(O\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0000¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b((\u0012\u0004\u0012\u00028\u00000PH\u0016¢\u0006\u0002\u0010QJS\u0010K\u001a\u0002HR\"\u0004\b\u0001\u0010R26\u0010\"\u001a2\u0012\u0013\u0012\u0011HR¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(M\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(N\u0012\u0004\u0012\u0002HR0&2\u0006\u0010S\u001a\u0002HRH\u0016¢\u0006\u0002\u0010TJh\u0010K\u001a\u0002HR\"\u0004\b\u0001\u0010R2K\u0010\"\u001aG\u0012\u0013\u0012\u0011HR¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(M\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(N\u0012\u0013\u0012\u00110\f¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(O\u0012\u0004\u0012\u0002HR0'2\u0006\u0010S\u001a\u0002HRH\u0016¢\u0006\u0002\u0010UJ\u0083\u0001\u0010K\u001a\u0002HR\"\u0004\b\u0001\u0010R2f\u0010\"\u001ab\u0012\u0013\u0012\u0011HR¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(M\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(N\u0012\u0013\u0012\u00110\f¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(O\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0000¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b((\u0012\u0004\u0012\u0002HR0P2\u0006\u0010S\u001a\u0002HRH\u0016¢\u0006\u0002\u0010VJO\u0010W\u001a\u00028\u0000\"\b\b\u0001\u0010L*\u00028\u000026\u0010\"\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(M\u0012\u0013\u0012\u0011HL¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(N\u0012\u0004\u0012\u00028\u00000&H\u0016¢\u0006\u0002\u0010.Jd\u0010W\u001a\u00028\u0000\"\b\b\u0001\u0010L*\u00028\u00002K\u0010\"\u001aG\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(M\u0012\u0013\u0012\u0011HL¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(N\u0012\u0013\u0012\u00110\f¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(O\u0012\u0004\u0012\u00028\u00000'H\u0016¢\u0006\u0002\u0010/J\u007f\u0010W\u001a\u00028\u0000\"\b\b\u0001\u0010L*\u00028\u00002f\u0010\"\u001ab\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(M\u0012\u0013\u0012\u0011HL¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(N\u0012\u0013\u0012\u00110\f¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(O\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0000¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b((\u0012\u0004\u0012\u00028\u00000PH\u0016¢\u0006\u0002\u0010QJS\u0010W\u001a\u0002HR\"\u0004\b\u0001\u0010R26\u0010\"\u001a2\u0012\u0013\u0012\u0011HR¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(M\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(N\u0012\u0004\u0012\u0002HR0&2\u0006\u0010S\u001a\u0002HRH\u0016¢\u0006\u0002\u0010TJh\u0010W\u001a\u0002HR\"\u0004\b\u0001\u0010R2K\u0010\"\u001aG\u0012\u0013\u0012\u0011HR¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(M\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(N\u0012\u0013\u0012\u00110\f¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(O\u0012\u0004\u0012\u0002HR0'2\u0006\u0010S\u001a\u0002HRH\u0016¢\u0006\u0002\u0010UJ\u0083\u0001\u0010W\u001a\u0002HR\"\u0004\b\u0001\u0010R2f\u0010\"\u001ab\u0012\u0013\u0012\u0011HR¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(M\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(N\u0012\u0013\u0012\u00110\f¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(O\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0000¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b((\u0012\u0004\u0012\u0002HR0P2\u0006\u0010S\u001a\u0002HRH\u0016¢\u0006\u0002\u0010VJ\u000e\u0010X\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0016J\u000f\u0010Y\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010HJ\"\u0010Z\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u001e\u001a\u00020\f2\b\b\u0002\u0010\u001f\u001a\u00020\fH\u0016J+\u0010[\u001a\u00020!2!\u0010\"\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020!0#H\u0016J@\u0010[\u001a\u00020!26\u0010\"\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\f¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020!0&H\u0016J[\u0010[\u001a\u00020!2Q\u0010\"\u001aM\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\f¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u0016\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0000¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b((\u0012\u0004\u0012\u00020!0'H\u0016J\f\u0010\\\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006JF\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u000026\u0010]\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(^\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(_\u0012\u0004\u0012\u00020\f0&H\u0016J\u0016\u0010`\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001e\u001a\u00020\fH\u0016J\u001e\u0010`\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010a\u001a\u00020\fH\u0016J7\u0010`\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010a\u001a\u00020\f2\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\t\"\u00028\u0000H\u0016¢\u0006\u0002\u0010bJ!\u0010c\u001a\u0002012\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\t\"\u00028\u0000H\u0016¢\u0006\u0002\u0010JJ\b\u0010d\u001a\u000201H\u0016J\b\u0010e\u001a\u00020@H\u0016J\u001e\u0010f\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010g\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010hJ\u0013\u0010i\u001a\u00020!2\b\u0010j\u001a\u0004\u0018\u00010\u001aH\u0096\u0002R$\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006l"}, d2 = {"Lio/dcloud/uts/UTSArray;", "E", "Ljava/util/ArrayList;", "<init>", "()V", com.taobao.weex.ui.component.WXBasicComponentType.LIST, "", "(Ljava/util/List;)V", "items", "", "([Ljava/lang/Object;)V", "initSize", "", "defaultValue", "(Ljava/lang/Number;Ljava/lang/Object;)V", "value", "length", "getLength", "()Ljava/lang/Number;", "setLength", "(Ljava/lang/Number;)V", "get", "index", "(Ljava/lang/Number;)Ljava/lang/Object;", "sort", "concat", "", "([Ljava/lang/Object;)Lio/dcloud/uts/UTSArray;", "copyWithin", io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_TARGET, "start", "end", "every", "", com.taobao.weex.bridge.WXBridgeManager.METHOD_CALLBACK, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlin/Function2;", "Lkotlin/Function3;", "array", "fill", "(Ljava/lang/Object;Ljava/lang/Number;Ljava/lang/Number;)Lio/dcloud/uts/UTSArray;", com.taobao.weex.common.Constants.Name.FILTER, "find", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "(Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "findIndex", "", com.taobao.weex.common.Constants.Name.FLAT, "depth", "flatMap", "includes", "searchElement", "(Ljava/lang/Object;)Z", "fromIndex", "(Ljava/lang/Object;Ljava/lang/Number;)Z", "forEach", "", "indexOf", "(Ljava/lang/Object;)I", "(Ljava/lang/Object;Ljava/lang/Number;)I", "join", "", "separator", "keys", "", "lastIndexOf", "map", "R", "pop", "()Ljava/lang/Object;", "push", "([Ljava/lang/Object;)I", "reduce", "T", "previousValue", "currentValue", "currentIndex", "Lkotlin/Function4;", "(Lkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "S", "initialValue", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;)Ljava/lang/Object;", "(Lkotlin/jvm/functions/Function3;Ljava/lang/Object;)Ljava/lang/Object;", "(Lkotlin/jvm/functions/Function4;Ljava/lang/Object;)Ljava/lang/Object;", "reduceRight", "reverse", "shift", "slice", "some", "toKotlinList", "compareFn", "a", "b", "splice", "deleteCount", "(Ljava/lang/Number;Ljava/lang/Number;[Ljava/lang/Object;)Lio/dcloud/uts/UTSArray;", "unshift", "hashCode", "toString", "set", com.alibaba.android.bindingx.core.internal.BindingXConstants.KEY_ELEMENT, "(Ljava/lang/Number;Ljava/lang/Object;)Ljava/lang/Object;", "equals", "other", "Companion", "utsplugin_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class UTSArray<E> extends java.util.ArrayList<E> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final io.dcloud.uts.UTSArray.Companion INSTANCE = new io.dcloud.uts.UTSArray.Companion(null);

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(java.lang.Object other) {
        return this == other;
    }

    public UTSArray() {
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ E remove(int i) {
        return (E) removeAt(i);
    }

    public /* bridge */ java.lang.Object removeAt(int i) {
        return super.remove(i);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return getSize();
    }

    /* JADX INFO: compiled from: UTSArray.kt */
    @kotlin.Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\u0010\u000e\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\u0010\u0012\n\u0002\u0010\u0016\n\u0002\u0010\u0014\n\u0002\u0010\u0013\n\u0002\u0010\u0017\n\u0002\u0010\f\n\u0002\u0010\u0019\n\u0002\u0010\u000b\n\u0002\u0010\u0018\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jb\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u00060\u0005\"\u0004\b\u0001\u0010\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\t2<\b\u0002\u0010\n\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u0002H\u0007\u0018\u00010\u000bJg\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u00060\u0005\"\u0004\b\u0001\u0010\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00112<\b\u0002\u0010\n\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u0002H\u0007\u0018\u00010\u000b¢\u0006\u0002\u0010\u0012Jd\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u00060\u0005\"\u0004\b\u0001\u0010\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00142<\b\u0002\u0010\n\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u0002H\u0007\u0018\u00010\u000bH\u0002Jb\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u00060\u0005\"\u0004\b\u0001\u0010\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00142<\b\u0002\u0010\n\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u0002H\u0007\u0018\u00010\u000bJV\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00060\u00052\u0006\u0010\b\u001a\u00020\u00162:\b\u0002\u0010\n\u001a4\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u000bJ\\\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0001\u0010\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\t2<\b\u0002\u0010\n\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u0002H\u0007\u0018\u00010\u000bJa\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0001\u0010\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00112<\b\u0002\u0010\n\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u0002H\u0007\u0018\u00010\u000b¢\u0006\u0002\u0010\u0018Jc\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00062\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00112>\b\u0002\u0010\n\u001a8\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000bH\u0007¢\u0006\u0004\b\u0019\u0010\u0018J\\\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0001\u0010\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00142<\b\u0002\u0010\n\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u0002H\u0007\u0018\u00010\u000bJa\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00062\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00142>\b\u0002\u0010\n\u001a8\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000bH\u0007¢\u0006\u0002\b\u001aJP\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\u00062\u0006\u0010\b\u001a\u00020\u00162:\b\u0002\u0010\n\u001a4\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u000bJ\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00062\u0006\u0010\b\u001a\u00020\u001cJ\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00062\u0006\u0010\b\u001a\u00020\u001dJ\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00062\u0006\u0010\b\u001a\u00020\u001eJ\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00062\u0006\u0010\b\u001a\u00020\u001fJ\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00062\u0006\u0010\b\u001a\u00020 J\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00062\u0006\u0010\b\u001a\u00020!J\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\"0\u00062\u0006\u0010\b\u001a\u00020#J\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020$0\u00062\u0006\u0010\b\u001a\u00020%J \u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H&0\u0006\"\u0004\b\u0001\u0010&2\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H&0'J%\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H&0\u0006\"\u0004\b\u0001\u0010&2\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H&0\u0011¢\u0006\u0002\u0010)J\u0014\u0010*\u001a\u00020$2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0001H\u0016J+\u0010,\u001a\b\u0012\u0004\u0012\u0002H&0\u0006\"\u0004\b\u0001\u0010&2\u0012\u0010-\u001a\n\u0012\u0006\b\u0001\u0012\u0002H&0\u0011\"\u0002H&¢\u0006\u0002\u0010)J\u000e\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006¨\u0006."}, d2 = {"Lio/dcloud/uts/UTSArray$Companion;", "", "<init>", "()V", "fromAsync", "Lio/dcloud/uts/UTSPromise;", "Lio/dcloud/uts/UTSArray;", "T", com.taobao.weex.ui.component.WXBasicComponentType.LIST, "Lio/dcloud/uts/UTSValueIterable;", "mapFn", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", com.alibaba.android.bindingx.core.internal.BindingXConstants.KEY_ELEMENT, "", "index", "", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Lio/dcloud/uts/UTSPromise;", "fromAsyncImpl", "", "", "", "from", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Lio/dcloud/uts/UTSArray;", "UTSArray_from_Array_no_type", "UTSArray_from_Iterable_no_type", "fromNative", "", "", "", "", "", "", "", "", "", "", "E", "", "array", "([Ljava/lang/Object;)Lio/dcloud/uts/UTSArray;", "isArray", "input", "of", "items", "utsplugin_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ io.dcloud.uts.UTSPromise fromAsync$default(io.dcloud.uts.UTSArray.Companion companion, io.dcloud.uts.UTSValueIterable uTSValueIterable, kotlin.jvm.functions.Function2 function2, int i, java.lang.Object obj) {
            if ((i & 2) != 0) {
                function2 = null;
            }
            return companion.fromAsync((io.dcloud.uts.UTSValueIterable<?>) uTSValueIterable, function2);
        }

        public final <T> io.dcloud.uts.UTSPromise<io.dcloud.uts.UTSArray<T>> fromAsync(final io.dcloud.uts.UTSValueIterable<?> list, final kotlin.jvm.functions.Function2<java.lang.Object, ? super java.lang.Number, ? extends T> mapFn) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(list, "list");
            final kotlinx.coroutines.CoroutineScope CoroutineScope = kotlinx.coroutines.CoroutineScopeKt.CoroutineScope(kotlinx.coroutines.SupervisorKt.SupervisorJob$default((kotlinx.coroutines.Job) null, 1, (java.lang.Object) null).plus(kotlinx.coroutines.Dispatchers.getDefault()));
            return new io.dcloud.uts.UTSPromise<>(new kotlin.jvm.functions.Function2() { // from class: io.dcloud.uts.UTSArray$Companion$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final java.lang.Object invoke(java.lang.Object obj, java.lang.Object obj2) {
                    return io.dcloud.uts.UTSArray.Companion.fromAsync$lambda$0(CoroutineScope, list, mapFn, (kotlin.jvm.functions.Function1) obj, (kotlin.jvm.functions.Function1) obj2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final <T> kotlin.Unit fromAsync$lambda$0(kotlinx.coroutines.CoroutineScope coroutineScope, io.dcloud.uts.UTSValueIterable<?> uTSValueIterable, kotlin.jvm.functions.Function2<java.lang.Object, ? super java.lang.Number, ? extends T> function2, kotlin.jvm.functions.Function1<? super io.dcloud.uts.UTSArray<T>, kotlin.Unit> function1, kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> function3) {
            kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new io.dcloud.uts.UTSArray$Companion$fromAsync$p$1$1(uTSValueIterable, function1, function3, function2, null), 3, null);
            return kotlin.Unit.INSTANCE;
        }

        public static /* synthetic */ io.dcloud.uts.UTSPromise fromAsync$default(io.dcloud.uts.UTSArray.Companion companion, java.lang.Object[] objArr, kotlin.jvm.functions.Function2 function2, int i, java.lang.Object obj) {
            if ((i & 2) != 0) {
                function2 = null;
            }
            return companion.fromAsync(objArr, function2);
        }

        public final <T> io.dcloud.uts.UTSPromise<io.dcloud.uts.UTSArray<T>> fromAsync(java.lang.Object[] list, kotlin.jvm.functions.Function2<java.lang.Object, ? super java.lang.Number, ? extends T> mapFn) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(list, "list");
            return fromAsyncImpl(kotlin.collections.ArraysKt.toList(list), mapFn);
        }

        static /* synthetic */ io.dcloud.uts.UTSPromise fromAsyncImpl$default(io.dcloud.uts.UTSArray.Companion companion, java.lang.Iterable iterable, kotlin.jvm.functions.Function2 function2, int i, java.lang.Object obj) {
            if ((i & 2) != 0) {
                function2 = null;
            }
            return companion.fromAsyncImpl(iterable, function2);
        }

        private final <T> io.dcloud.uts.UTSPromise<io.dcloud.uts.UTSArray<T>> fromAsyncImpl(final java.lang.Iterable<?> list, final kotlin.jvm.functions.Function2<java.lang.Object, ? super java.lang.Number, ? extends T> mapFn) {
            final kotlinx.coroutines.CoroutineScope CoroutineScope = kotlinx.coroutines.CoroutineScopeKt.CoroutineScope(kotlinx.coroutines.SupervisorKt.SupervisorJob$default((kotlinx.coroutines.Job) null, 1, (java.lang.Object) null).plus(kotlinx.coroutines.Dispatchers.getDefault()));
            return new io.dcloud.uts.UTSPromise<>(new kotlin.jvm.functions.Function2() { // from class: io.dcloud.uts.UTSArray$Companion$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final java.lang.Object invoke(java.lang.Object obj, java.lang.Object obj2) {
                    return io.dcloud.uts.UTSArray.Companion.fromAsyncImpl$lambda$1(CoroutineScope, list, mapFn, (kotlin.jvm.functions.Function1) obj, (kotlin.jvm.functions.Function1) obj2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final <T> kotlin.Unit fromAsyncImpl$lambda$1(kotlinx.coroutines.CoroutineScope coroutineScope, java.lang.Iterable<?> iterable, kotlin.jvm.functions.Function2<java.lang.Object, ? super java.lang.Number, ? extends T> function2, kotlin.jvm.functions.Function1<? super io.dcloud.uts.UTSArray<T>, kotlin.Unit> function1, kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> function3) {
            kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new io.dcloud.uts.UTSArray$Companion$fromAsyncImpl$p$1$1(iterable, function1, function3, function2, null), 3, null);
            return kotlin.Unit.INSTANCE;
        }

        public static /* synthetic */ io.dcloud.uts.UTSPromise fromAsync$default(io.dcloud.uts.UTSArray.Companion companion, java.lang.Iterable iterable, kotlin.jvm.functions.Function2 function2, int i, java.lang.Object obj) {
            if ((i & 2) != 0) {
                function2 = null;
            }
            return companion.fromAsync((java.lang.Iterable<?>) iterable, function2);
        }

        public final <T> io.dcloud.uts.UTSPromise<io.dcloud.uts.UTSArray<T>> fromAsync(java.lang.Iterable<?> list, kotlin.jvm.functions.Function2<java.lang.Object, ? super java.lang.Number, ? extends T> mapFn) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(list, "list");
            return fromAsyncImpl(list, mapFn);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ io.dcloud.uts.UTSPromise fromAsync$default(io.dcloud.uts.UTSArray.Companion companion, java.lang.CharSequence charSequence, kotlin.jvm.functions.Function2 function2, int i, java.lang.Object obj) {
            if ((i & 2) != 0) {
                function2 = null;
            }
            return companion.fromAsync(charSequence, (kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.Number, java.lang.String>) function2);
        }

        public final io.dcloud.uts.UTSPromise<io.dcloud.uts.UTSArray<java.lang.String>> fromAsync(final java.lang.CharSequence list, final kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.Number, java.lang.String> mapFn) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(list, "list");
            return new io.dcloud.uts.UTSPromise<>(new kotlin.jvm.functions.Function2() { // from class: io.dcloud.uts.UTSArray$Companion$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final java.lang.Object invoke(java.lang.Object obj, java.lang.Object obj2) {
                    return io.dcloud.uts.UTSArray.Companion.fromAsync$lambda$3(list, mapFn, (kotlin.jvm.functions.Function1) obj, (kotlin.jvm.functions.Function1) obj2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final kotlin.Unit fromAsync$lambda$3(java.lang.CharSequence charSequence, kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.Number, java.lang.String> function2, kotlin.jvm.functions.Function1<? super io.dcloud.uts.UTSArray<java.lang.String>, kotlin.Unit> function1, kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> function3) {
            io.dcloud.uts.UTSArray uTSArray = new io.dcloud.uts.UTSArray();
            int i = 0;
            int i2 = 0;
            while (i < charSequence.length()) {
                int i3 = i2 + 1;
                java.lang.String strValueOf = java.lang.String.valueOf(charSequence.charAt(i));
                if (function2 != null) {
                    strValueOf = function2.invoke(strValueOf, java.lang.Integer.valueOf(i2));
                }
                uTSArray.add(strValueOf);
                i++;
                i2 = i3;
            }
            function1.invoke(uTSArray);
            return kotlin.Unit.INSTANCE;
        }

        public static /* synthetic */ io.dcloud.uts.UTSArray from$default(io.dcloud.uts.UTSArray.Companion companion, io.dcloud.uts.UTSValueIterable uTSValueIterable, kotlin.jvm.functions.Function2 function2, int i, java.lang.Object obj) {
            if ((i & 2) != 0) {
                function2 = null;
            }
            return companion.from((io.dcloud.uts.UTSValueIterable<?>) uTSValueIterable, function2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final <T> io.dcloud.uts.UTSArray<T> from(io.dcloud.uts.UTSValueIterable<?> list, kotlin.jvm.functions.Function2<java.lang.Object, ? super java.lang.Number, ? extends T> mapFn) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(list, "list");
            io.dcloud.uts.RegExpMatchArray regExpMatchArray = (io.dcloud.uts.UTSArray<T>) new io.dcloud.uts.UTSArray();
            io.dcloud.uts.UTSIterator<?> uTSIteratorValueIterator = list.valueIterator();
            int i = 0;
            while (uTSIteratorValueIterator.hasNext()) {
                java.lang.Object next = uTSIteratorValueIterator.next();
                if (mapFn != null) {
                    next = mapFn.invoke(next, java.lang.Integer.valueOf(i));
                }
                regExpMatchArray.add(next);
                i++;
            }
            return regExpMatchArray;
        }

        public static /* synthetic */ io.dcloud.uts.UTSArray from$default(io.dcloud.uts.UTSArray.Companion companion, java.lang.Object[] objArr, kotlin.jvm.functions.Function2 function2, int i, java.lang.Object obj) {
            if ((i & 2) != 0) {
                function2 = null;
            }
            return companion.from(objArr, function2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final <T> io.dcloud.uts.UTSArray<T> from(java.lang.Object[] list, kotlin.jvm.functions.Function2<java.lang.Object, ? super java.lang.Number, ? extends T> mapFn) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(list, "list");
            io.dcloud.uts.RegExpMatchArray regExpMatchArray = (io.dcloud.uts.UTSArray<T>) new io.dcloud.uts.UTSArray();
            int length = list.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                java.lang.Object objInvoke = list[i];
                int i3 = i2 + 1;
                if (mapFn != null) {
                    objInvoke = mapFn.invoke(objInvoke, java.lang.Integer.valueOf(i2));
                }
                regExpMatchArray.add(objInvoke);
                i++;
                i2 = i3;
            }
            return regExpMatchArray;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ io.dcloud.uts.UTSArray UTSArray_from_Array_no_type$default(io.dcloud.uts.UTSArray.Companion companion, java.lang.Object[] objArr, kotlin.jvm.functions.Function2 function2, int i, java.lang.Object obj) {
            if ((i & 2) != 0) {
                function2 = null;
            }
            return companion.UTSArray_from_Array_no_type(objArr, function2);
        }

        public final io.dcloud.uts.UTSArray<java.lang.Object> UTSArray_from_Array_no_type(java.lang.Object[] list, kotlin.jvm.functions.Function2<java.lang.Object, ? super java.lang.Number, ? extends java.lang.Object> mapFn) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(list, "list");
            io.dcloud.uts.UTSArray<java.lang.Object> uTSArray = new io.dcloud.uts.UTSArray<>();
            int length = list.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                java.lang.Object objInvoke = list[i];
                int i3 = i2 + 1;
                if (mapFn != null) {
                    objInvoke = mapFn.invoke(objInvoke, java.lang.Integer.valueOf(i2));
                }
                uTSArray.add(objInvoke);
                i++;
                i2 = i3;
            }
            return uTSArray;
        }

        public static /* synthetic */ io.dcloud.uts.UTSArray from$default(io.dcloud.uts.UTSArray.Companion companion, java.lang.Iterable iterable, kotlin.jvm.functions.Function2 function2, int i, java.lang.Object obj) {
            if ((i & 2) != 0) {
                function2 = null;
            }
            return companion.from((java.lang.Iterable<?>) iterable, function2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final <T> io.dcloud.uts.UTSArray<T> from(java.lang.Iterable<?> list, kotlin.jvm.functions.Function2<java.lang.Object, ? super java.lang.Number, ? extends T> mapFn) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(list, "list");
            io.dcloud.uts.RegExpMatchArray regExpMatchArray = (io.dcloud.uts.UTSArray<T>) new io.dcloud.uts.UTSArray();
            int i = 0;
            for (java.lang.Object objInvoke : list) {
                int i2 = i + 1;
                if (i < 0) {
                    kotlin.collections.CollectionsKt.throwIndexOverflow();
                }
                if (mapFn != null) {
                    objInvoke = mapFn.invoke(objInvoke, java.lang.Integer.valueOf(i));
                }
                regExpMatchArray.add(objInvoke);
                i = i2;
            }
            return regExpMatchArray;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ io.dcloud.uts.UTSArray UTSArray_from_Iterable_no_type$default(io.dcloud.uts.UTSArray.Companion companion, java.lang.Iterable iterable, kotlin.jvm.functions.Function2 function2, int i, java.lang.Object obj) {
            if ((i & 2) != 0) {
                function2 = null;
            }
            return companion.UTSArray_from_Iterable_no_type(iterable, function2);
        }

        public final io.dcloud.uts.UTSArray<java.lang.Object> UTSArray_from_Iterable_no_type(java.lang.Iterable<?> list, kotlin.jvm.functions.Function2<java.lang.Object, ? super java.lang.Number, ? extends java.lang.Object> mapFn) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(list, "list");
            io.dcloud.uts.UTSArray<java.lang.Object> uTSArray = new io.dcloud.uts.UTSArray<>();
            int i = 0;
            for (java.lang.Object objInvoke : list) {
                int i2 = i + 1;
                if (i < 0) {
                    kotlin.collections.CollectionsKt.throwIndexOverflow();
                }
                if (mapFn != null) {
                    objInvoke = mapFn.invoke(objInvoke, java.lang.Integer.valueOf(i));
                }
                uTSArray.add(objInvoke);
                i = i2;
            }
            return uTSArray;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ io.dcloud.uts.UTSArray from$default(io.dcloud.uts.UTSArray.Companion companion, java.lang.CharSequence charSequence, kotlin.jvm.functions.Function2 function2, int i, java.lang.Object obj) {
            if ((i & 2) != 0) {
                function2 = null;
            }
            return companion.from(charSequence, (kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.Number, java.lang.String>) function2);
        }

        public final io.dcloud.uts.UTSArray<java.lang.String> from(java.lang.CharSequence list, kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.Number, java.lang.String> mapFn) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(list, "list");
            io.dcloud.uts.UTSArray<java.lang.String> uTSArray = new io.dcloud.uts.UTSArray<>();
            int i = 0;
            int i2 = 0;
            while (i < list.length()) {
                int i3 = i2 + 1;
                java.lang.String strValueOf = java.lang.String.valueOf(list.charAt(i));
                if (mapFn != null) {
                    strValueOf = mapFn.invoke(strValueOf, java.lang.Integer.valueOf(i2));
                }
                uTSArray.add(strValueOf);
                i++;
                i2 = i3;
            }
            return uTSArray;
        }

        public final io.dcloud.uts.UTSArray<java.lang.Number> fromNative(int[] list) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(list, "list");
            io.dcloud.uts.UTSArray<java.lang.Number> uTSArray = new io.dcloud.uts.UTSArray<>();
            for (int i : list) {
                uTSArray.add(java.lang.Integer.valueOf(i));
            }
            return uTSArray;
        }

        public final io.dcloud.uts.UTSArray<java.lang.Number> fromNative(byte[] list) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(list, "list");
            io.dcloud.uts.UTSArray<java.lang.Number> uTSArray = new io.dcloud.uts.UTSArray<>();
            for (byte b : list) {
                uTSArray.add(java.lang.Byte.valueOf(b));
            }
            return uTSArray;
        }

        public final io.dcloud.uts.UTSArray<java.lang.Number> fromNative(long[] list) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(list, "list");
            io.dcloud.uts.UTSArray<java.lang.Number> uTSArray = new io.dcloud.uts.UTSArray<>();
            for (long j : list) {
                uTSArray.add(java.lang.Long.valueOf(j));
            }
            return uTSArray;
        }

        public final io.dcloud.uts.UTSArray<java.lang.Number> fromNative(float[] list) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(list, "list");
            io.dcloud.uts.UTSArray<java.lang.Number> uTSArray = new io.dcloud.uts.UTSArray<>();
            for (float f : list) {
                uTSArray.add(java.lang.Float.valueOf(f));
            }
            return uTSArray;
        }

        public final io.dcloud.uts.UTSArray<java.lang.Number> fromNative(double[] list) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(list, "list");
            io.dcloud.uts.UTSArray<java.lang.Number> uTSArray = new io.dcloud.uts.UTSArray<>();
            for (double d : list) {
                uTSArray.add(java.lang.Double.valueOf(d));
            }
            return uTSArray;
        }

        public final io.dcloud.uts.UTSArray<java.lang.Number> fromNative(short[] list) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(list, "list");
            io.dcloud.uts.UTSArray<java.lang.Number> uTSArray = new io.dcloud.uts.UTSArray<>();
            for (short s : list) {
                uTSArray.add(java.lang.Short.valueOf(s));
            }
            return uTSArray;
        }

        public final io.dcloud.uts.UTSArray<java.lang.Character> fromNative(char[] list) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(list, "list");
            io.dcloud.uts.UTSArray<java.lang.Character> uTSArray = new io.dcloud.uts.UTSArray<>();
            for (char c : list) {
                uTSArray.add(java.lang.Character.valueOf(c));
            }
            return uTSArray;
        }

        public final io.dcloud.uts.UTSArray<java.lang.Boolean> fromNative(boolean[] list) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(list, "list");
            io.dcloud.uts.UTSArray<java.lang.Boolean> uTSArray = new io.dcloud.uts.UTSArray<>();
            for (boolean z : list) {
                uTSArray.add(java.lang.Boolean.valueOf(z));
            }
            return uTSArray;
        }

        public final <E> io.dcloud.uts.UTSArray<E> fromNative(java.util.List<? extends E> list) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(list, "list");
            return new io.dcloud.uts.UTSArray<>(list);
        }

        public final <E> io.dcloud.uts.UTSArray<E> fromNative(E[] array) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(array, "array");
            return new io.dcloud.uts.UTSArray<>(java.util.Arrays.copyOf(array, array.length));
        }

        public static /* synthetic */ boolean isArray$default(io.dcloud.uts.UTSArray.Companion companion, java.lang.Object obj, int i, java.lang.Object obj2) {
            if ((i & 1) != 0) {
                obj = null;
            }
            return companion.isArray(obj);
        }

        public boolean isArray(java.lang.Object input) {
            if (input == null) {
                return false;
            }
            return input instanceof io.dcloud.uts.UTSArray;
        }

        public final <E> io.dcloud.uts.UTSArray<E> of(E... items) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(items, "items");
            return new io.dcloud.uts.UTSArray<>(java.util.Arrays.copyOf(items, items.length));
        }

        public final io.dcloud.uts.UTSArray<java.lang.Object> of() {
            return new io.dcloud.uts.UTSArray<>();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UTSArray(java.util.List<? extends E> list) {
        this();
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(list, "list");
        java.util.Iterator<? extends E> it = list.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UTSArray(E... items) {
        this();
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(items, "items");
        for (E e : items) {
            add(e);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UTSArray(java.lang.Number initSize, E e) {
        this();
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(initSize, "initSize");
        int iIntValue = initSize.intValue();
        for (int i = 0; i < iIntValue; i++) {
            add(e);
        }
    }

    public final java.lang.Number getLength() {
        return java.lang.Integer.valueOf(size());
    }

    public final void setLength(java.lang.Number value) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(value, "value");
        splice(value);
    }

    public final E get(java.lang.Number index) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(index, "index");
        return get(index.intValue());
    }

    public io.dcloud.uts.UTSArray<E> sort() {
        if (io.dcloud.uts.NumberKt.compareTo(getLength(), (java.lang.Number) 2) < 0) {
            return this;
        }
        java.util.Collections.sort(this, new java.util.Comparator() { // from class: io.dcloud.uts.UTSArray$$ExternalSyntheticLambda1
            @Override // java.util.Comparator
            public final int compare(java.lang.Object obj, java.lang.Object obj2) {
                return io.dcloud.uts.UTSArray.sort$lambda$0(obj, obj2);
            }
        });
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int sort$lambda$0(java.lang.Object obj, java.lang.Object obj2) {
        byte[] bytes = obj.toString().getBytes(kotlin.text.Charsets.UTF_16BE);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        byte[] bytes2 = obj2.toString().getBytes(kotlin.text.Charsets.UTF_16BE);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
        if (bytes.length == 0) {
            return -1;
        }
        if (bytes2.length == 0) {
            return 1;
        }
        int length = bytes.length;
        int length2 = bytes2.length;
        int iIntValue = io.dcloud.uts.Math.min(java.lang.Integer.valueOf(length), java.lang.Integer.valueOf(length2)).intValue();
        for (int i = 0; i < iIntValue; i++) {
            byte b = bytes[i];
            byte b2 = bytes2[i];
            if (b < b2) {
                return -1;
            }
            if (b > b2) {
                return 1;
            }
        }
        return length - length2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public io.dcloud.uts.UTSArray<E> concat(java.lang.Object... items) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(items, "items");
        io.dcloud.uts.RegExpMatchArray regExpMatchArray = (io.dcloud.uts.UTSArray<E>) new io.dcloud.uts.UTSArray(this);
        for (java.lang.Object obj : items) {
            if (obj instanceof io.dcloud.uts.UTSArray) {
                java.util.Iterator<E> it = ((io.dcloud.uts.UTSArray) obj).iterator();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                while (it.hasNext()) {
                    regExpMatchArray.add(it.next());
                }
            } else {
                regExpMatchArray.add(obj);
            }
        }
        return regExpMatchArray;
    }

    public static /* synthetic */ io.dcloud.uts.UTSArray copyWithin$default(io.dcloud.uts.UTSArray uTSArray, java.lang.Number number, java.lang.Number number2, java.lang.Number number3, int i, java.lang.Object obj) {
        if (obj != null) {
            throw new java.lang.UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copyWithin");
        }
        if ((i & 2) != 0) {
            number2 = (java.lang.Number) 0;
        }
        if ((i & 4) != 0) {
            number3 = java.lang.Integer.valueOf(uTSArray.size());
        }
        return uTSArray.copyWithin(number, number2, number3);
    }

    public io.dcloud.uts.UTSArray<E> copyWithin(java.lang.Number target, java.lang.Number start, java.lang.Number end) {
        int iMin;
        int iMin2;
        int iMin3;
        int i;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(target, "target");
        int size = size();
        int iIntValue = target.intValue();
        if (io.dcloud.uts.NumberKt.compareTo(target, (java.lang.Number) 0) < 0) {
            iMin = java.lang.Math.max(iIntValue + size, 0);
        } else {
            iMin = java.lang.Math.min(iIntValue, size);
        }
        int iIntValue2 = start != null ? start.intValue() : 0;
        if (iIntValue2 < 0) {
            iMin2 = java.lang.Math.max(iIntValue2 + size, 0);
        } else {
            iMin2 = java.lang.Math.min(iIntValue2, size);
        }
        int iIntValue3 = end != null ? end.intValue() : size;
        if (iIntValue3 < 0) {
            iMin3 = java.lang.Math.max(iIntValue3 + size, 0);
        } else {
            iMin3 = java.lang.Math.min(iIntValue3, size);
        }
        int iMin4 = java.lang.Math.min(iMin3 - iMin2, size - iMin);
        if (iMin2 >= iMin || iMin >= iMin2 + iMin4) {
            i = 1;
        } else {
            int i2 = iMin4 - 1;
            iMin2 += i2;
            iMin += i2;
            i = -1;
        }
        while (iMin4 > 0) {
            if (iMin2 < size()) {
                set(iMin, get(iMin2));
            } else {
                remove(iMin);
            }
            iMin2 += i;
            iMin += i;
            iMin4--;
        }
        return this;
    }

    public boolean every(kotlin.jvm.functions.Function1<? super E, java.lang.Boolean> callback) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        int size = size();
        for (int i = 0; i < size; i++) {
            if (i < size() && !callback.invoke(get(i)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public boolean every(kotlin.jvm.functions.Function2<? super E, ? super java.lang.Number, java.lang.Boolean> callback) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        int size = size();
        for (int i = 0; i < size; i++) {
            if (i < size() && !callback.invoke(get(i), java.lang.Integer.valueOf(i)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public boolean every(kotlin.jvm.functions.Function3<? super E, ? super java.lang.Number, ? super io.dcloud.uts.UTSArray<E>, java.lang.Boolean> callback) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        int size = size();
        for (int i = 0; i < size; i++) {
            if (i < size() && !callback.invoke(get(i), java.lang.Integer.valueOf(i), this).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static /* synthetic */ io.dcloud.uts.UTSArray fill$default(io.dcloud.uts.UTSArray uTSArray, java.lang.Object obj, java.lang.Number number, java.lang.Number number2, int i, java.lang.Object obj2) {
        if (obj2 != null) {
            throw new java.lang.UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fill");
        }
        if ((i & 2) != 0) {
            number = (java.lang.Number) 0;
        }
        if ((i & 4) != 0) {
            number2 = java.lang.Integer.valueOf(uTSArray.size());
        }
        return uTSArray.fill(obj, number, number2);
    }

    public io.dcloud.uts.UTSArray<E> fill(E value, java.lang.Number start, java.lang.Number end) {
        int iMin;
        int iMin2;
        int size = size();
        int iIntValue = start != null ? start.intValue() : 0;
        if (iIntValue < 0) {
            iMin = java.lang.Math.max(iIntValue + size, 0);
        } else {
            iMin = java.lang.Math.min(iIntValue, size);
        }
        int iIntValue2 = end != null ? end.intValue() : size;
        if (iIntValue2 < 0) {
            iMin2 = java.lang.Math.max(size + iIntValue2, 0);
        } else {
            iMin2 = java.lang.Math.min(iIntValue2, size);
        }
        while (iMin < iMin2) {
            set(iMin, value);
            iMin++;
        }
        return this;
    }

    public io.dcloud.uts.UTSArray<E> filter(kotlin.jvm.functions.Function1<? super E, java.lang.Boolean> callback) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        io.dcloud.uts.UTSArray<E> uTSArray = new io.dcloud.uts.UTSArray<>();
        int size = size();
        for (int i = 0; i < size; i++) {
            E e = get(i);
            if (callback.invoke(e).booleanValue()) {
                uTSArray.add(e);
            }
        }
        return uTSArray;
    }

    public io.dcloud.uts.UTSArray<E> filter(kotlin.jvm.functions.Function2<? super E, ? super java.lang.Number, java.lang.Boolean> callback) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        io.dcloud.uts.UTSArray<E> uTSArray = new io.dcloud.uts.UTSArray<>();
        int size = size();
        for (int i = 0; i < size; i++) {
            E e = get(i);
            if (callback.invoke(e, java.lang.Integer.valueOf(i)).booleanValue()) {
                uTSArray.add(e);
            }
        }
        return uTSArray;
    }

    public io.dcloud.uts.UTSArray<E> filter(kotlin.jvm.functions.Function3<? super E, ? super java.lang.Number, ? super io.dcloud.uts.UTSArray<E>, java.lang.Boolean> callback) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        io.dcloud.uts.UTSArray<E> uTSArray = new io.dcloud.uts.UTSArray<>();
        int size = size();
        for (int i = 0; i < size; i++) {
            E e = get(i);
            if (callback.invoke(e, java.lang.Integer.valueOf(i), this).booleanValue()) {
                uTSArray.add(e);
            }
        }
        return uTSArray;
    }

    public E find(kotlin.jvm.functions.Function1<? super E, java.lang.Boolean> callback) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        int size = size();
        for (int i = 0; i < size; i++) {
            E e = get(i);
            if (callback.invoke(e).booleanValue()) {
                return e;
            }
        }
        return null;
    }

    public E find(kotlin.jvm.functions.Function2<? super E, ? super java.lang.Number, java.lang.Boolean> callback) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        int size = size();
        for (int i = 0; i < size; i++) {
            E e = get(i);
            if (callback.invoke(e, java.lang.Integer.valueOf(i)).booleanValue()) {
                return e;
            }
        }
        return null;
    }

    public E find(kotlin.jvm.functions.Function3<? super E, ? super java.lang.Number, ? super io.dcloud.uts.UTSArray<E>, java.lang.Boolean> callback) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        int size = size();
        for (int i = 0; i < size; i++) {
            E e = get(i);
            if (callback.invoke(e, java.lang.Integer.valueOf(i), this).booleanValue()) {
                return e;
            }
        }
        return null;
    }

    public int findIndex(kotlin.jvm.functions.Function1<? super E, java.lang.Boolean> callback) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        int size = size();
        for (int i = 0; i < size; i++) {
            if (callback.invoke(get(i)).booleanValue()) {
                return i;
            }
        }
        return -1;
    }

    public int findIndex(kotlin.jvm.functions.Function2<? super E, ? super java.lang.Number, java.lang.Boolean> callback) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        int size = size();
        for (int i = 0; i < size; i++) {
            if (callback.invoke(get(i), java.lang.Integer.valueOf(i)).booleanValue()) {
                return i;
            }
        }
        return -1;
    }

    public int findIndex(kotlin.jvm.functions.Function3<? super E, ? super java.lang.Number, ? super io.dcloud.uts.UTSArray<E>, java.lang.Boolean> callback) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        int size = size();
        for (int i = 0; i < size; i++) {
            if (callback.invoke(get(i), java.lang.Integer.valueOf(i), this).booleanValue()) {
                return i;
            }
        }
        return -1;
    }

    public static /* synthetic */ io.dcloud.uts.UTSArray flat$default(io.dcloud.uts.UTSArray uTSArray, java.lang.Number number, int i, java.lang.Object obj) {
        if (obj != null) {
            throw new java.lang.UnsupportedOperationException("Super calls with default arguments not supported in this target, function: flat");
        }
        if ((i & 1) != 0) {
            number = (java.lang.Number) 1;
        }
        return uTSArray.flat(number);
    }

    public io.dcloud.uts.UTSArray<?> flat(java.lang.Number depth) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(depth, "depth");
        io.dcloud.uts.UTSArray<?> uTSArray = new io.dcloud.uts.UTSArray<>();
        flat$flatDeep(uTSArray, this, depth);
        return uTSArray;
    }

    private static final void flat$flatDeep(io.dcloud.uts.UTSArray<java.lang.Object> uTSArray, java.util.List<?> list, java.lang.Number number) {
        for (java.lang.Object obj : list) {
            if (io.dcloud.uts.NumberKt.compareTo(number, (java.lang.Number) 0) > 0 && kotlin.jvm.internal.TypeIntrinsics.isMutableList(obj)) {
                flat$flatDeep(uTSArray, (java.util.List) obj, io.dcloud.uts.NumberKt.minus(number, (java.lang.Number) 1));
            } else {
                uTSArray.add(obj);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public io.dcloud.uts.UTSArray<?> flatMap(kotlin.jvm.functions.Function1<? super E, ? extends io.dcloud.uts.UTSArray<?>> callback) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        return map(callback).flat((java.lang.Number) 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public io.dcloud.uts.UTSArray<?> flatMap(kotlin.jvm.functions.Function2<? super E, ? super java.lang.Number, ? extends io.dcloud.uts.UTSArray<?>> callback) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        return map(callback).flat((java.lang.Number) 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public io.dcloud.uts.UTSArray<?> flatMap(kotlin.jvm.functions.Function3<? super E, ? super java.lang.Number, ? super io.dcloud.uts.UTSArray<E>, ? extends io.dcloud.uts.UTSArray<?>> callback) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        return map(callback).flat((java.lang.Number) 1);
    }

    public boolean includes(E searchElement) {
        return includes(searchElement, (java.lang.Number) 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean includes(E searchElement, java.lang.Number fromIndex) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fromIndex, "fromIndex");
        int iIntValue = fromIndex.intValue();
        int size = size();
        if (iIntValue < 0) {
            iIntValue = size - java.lang.Math.abs(iIntValue);
        }
        for (int iMax = java.lang.Math.max(iIntValue, 0); iMax < size; iMax++) {
            E e = get(iMax);
            if ((searchElement instanceof java.lang.Number) && (e instanceof java.lang.Number)) {
                if (((java.lang.Number) e).doubleValue() == ((java.lang.Number) searchElement).doubleValue()) {
                    return true;
                }
            } else if (kotlin.jvm.internal.Intrinsics.areEqual(e, searchElement)) {
                return true;
            }
        }
        return false;
    }

    public void forEach(kotlin.jvm.functions.Function2<? super E, ? super java.lang.Number, kotlin.Unit> callback) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        for (int i = 0; i < size(); i++) {
            callback.invoke(get(i), java.lang.Integer.valueOf(i));
        }
    }

    public void forEach(kotlin.jvm.functions.Function3<? super E, ? super java.lang.Number, ? super io.dcloud.uts.UTSArray<E>, kotlin.Unit> callback) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        for (int i = 0; i < size(); i++) {
            callback.invoke(get(i), java.lang.Integer.valueOf(i), this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public int indexOf(java.lang.Object searchElement) {
        return indexOf(searchElement, (java.lang.Number) 0);
    }

    public static /* synthetic */ int indexOf$default(io.dcloud.uts.UTSArray uTSArray, java.lang.Object obj, java.lang.Number number, int i, java.lang.Object obj2) {
        if (obj2 != null) {
            throw new java.lang.UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
        }
        if ((i & 2) != 0) {
            number = (java.lang.Number) 0;
        }
        return uTSArray.indexOf(obj, number);
    }

    public int indexOf(E searchElement, java.lang.Number fromIndex) {
        int iIntValue;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fromIndex, "fromIndex");
        int size = size();
        if (size == 0 || (iIntValue = fromIndex.intValue()) >= size) {
            return -1;
        }
        if (iIntValue < 0) {
            iIntValue = size - java.lang.Math.abs(iIntValue);
        }
        for (int iMax = java.lang.Math.max(iIntValue, 0); iMax < size; iMax++) {
            if (kotlin.jvm.internal.Intrinsics.areEqual(get(iMax), searchElement)) {
                return iMax;
            }
        }
        return -1;
    }

    public static /* synthetic */ java.lang.String join$default(io.dcloud.uts.UTSArray uTSArray, java.lang.String str, int i, java.lang.Object obj) {
        if (obj != null) {
            throw new java.lang.UnsupportedOperationException("Super calls with default arguments not supported in this target, function: join");
        }
        if ((i & 1) != 0) {
            str = ",";
        }
        return uTSArray.join(str);
    }

    public java.lang.String join(java.lang.String separator) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(separator, "separator");
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        java.util.Iterator<E> it = iterator();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            E next = it.next();
            if (next == null) {
                stringBuffer.append("");
            } else {
                stringBuffer.append(next.toString());
            }
            if (it.hasNext()) {
                stringBuffer.append(separator);
            }
        }
        java.lang.String string = stringBuffer.toString();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public java.util.Iterator<java.lang.Number> keys() {
        io.dcloud.uts.UTSArray uTSArray = new io.dcloud.uts.UTSArray();
        int size = size();
        for (int i = 0; i < size; i++) {
            uTSArray.add(java.lang.Integer.valueOf(i));
        }
        java.util.Iterator<java.lang.Number> it = uTSArray.iterator();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        return it;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public int lastIndexOf(java.lang.Object searchElement) {
        if (size() < 1) {
            return -1;
        }
        return lastIndexOf(searchElement, java.lang.Integer.valueOf(size() - 1));
    }

    public static /* synthetic */ int lastIndexOf$default(io.dcloud.uts.UTSArray uTSArray, java.lang.Object obj, java.lang.Number number, int i, java.lang.Object obj2) {
        if (obj2 != null) {
            throw new java.lang.UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
        }
        if ((i & 2) != 0) {
            number = (java.lang.Number) 0;
        }
        return uTSArray.lastIndexOf(obj, number);
    }

    public int lastIndexOf(E searchElement, java.lang.Number fromIndex) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fromIndex, "fromIndex");
        int size = size();
        if (size == 0) {
            return -1;
        }
        int iIntValue = fromIndex.intValue();
        for (int iMin = iIntValue >= 0 ? java.lang.Math.min(iIntValue, size - 1) : size - java.lang.Math.abs(iIntValue); iMin >= 0; iMin--) {
            if (kotlin.jvm.internal.Intrinsics.areEqual(get(iMin), searchElement)) {
                return iMin;
            }
        }
        return -1;
    }

    public <R> io.dcloud.uts.UTSArray<R> map(kotlin.jvm.functions.Function1<? super E, ? extends R> callback) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        int size = size();
        io.dcloud.uts.UTSArray<R> uTSArray = new io.dcloud.uts.UTSArray<>();
        for (int i = 0; i < size; i++) {
            uTSArray.add(callback.invoke(get(i)));
        }
        return uTSArray;
    }

    public <R> io.dcloud.uts.UTSArray<R> map(kotlin.jvm.functions.Function2<? super E, ? super java.lang.Number, ? extends R> callback) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        int size = size();
        io.dcloud.uts.UTSArray<R> uTSArray = new io.dcloud.uts.UTSArray<>();
        for (int i = 0; i < size; i++) {
            uTSArray.add(callback.invoke(get(i), java.lang.Integer.valueOf(i)));
        }
        return uTSArray;
    }

    public <R> io.dcloud.uts.UTSArray<R> map(kotlin.jvm.functions.Function3<? super E, ? super java.lang.Number, ? super io.dcloud.uts.UTSArray<E>, ? extends R> callback) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        int size = size();
        io.dcloud.uts.UTSArray<R> uTSArray = new io.dcloud.uts.UTSArray<>();
        for (int i = 0; i < size; i++) {
            uTSArray.add(callback.invoke(get(i), java.lang.Integer.valueOf(i), this));
        }
        return uTSArray;
    }

    public E pop() {
        return (E) kotlin.collections.CollectionsKt.removeLastOrNull(this);
    }

    public int push(E... items) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(items, "items");
        kotlin.collections.CollectionsKt.addAll(this, items);
        return size();
    }

    public <T extends E> E reduce(kotlin.jvm.functions.Function3<? super E, ? super T, ? super java.lang.Number, ? extends E> callback) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        int size = size();
        E eInvoke = get(0);
        for (int i = 1; i < size; i++) {
            eInvoke = callback.invoke(eInvoke, get(i), java.lang.Integer.valueOf(i));
        }
        return eInvoke;
    }

    public <T extends E> E reduce(kotlin.jvm.functions.Function4<? super E, ? super T, ? super java.lang.Number, ? super io.dcloud.uts.UTSArray<E>, ? extends E> callback) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        int size = size();
        E eInvoke = get(0);
        for (int i = 1; i < size; i++) {
            eInvoke = callback.invoke(eInvoke, get(i), java.lang.Integer.valueOf(i), this);
        }
        return eInvoke;
    }

    public <S> S reduce(kotlin.jvm.functions.Function2<? super S, ? super E, ? extends S> callback, S initialValue) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        int size = size();
        for (int i = 0; i < size; i++) {
            initialValue = callback.invoke(initialValue, get(i));
        }
        return initialValue;
    }

    public <S> S reduce(kotlin.jvm.functions.Function3<? super S, ? super E, ? super java.lang.Number, ? extends S> callback, S initialValue) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        int size = size();
        for (int i = 0; i < size; i++) {
            initialValue = callback.invoke(initialValue, get(i), java.lang.Integer.valueOf(i));
        }
        return initialValue;
    }

    public <S> S reduce(kotlin.jvm.functions.Function4<? super S, ? super E, ? super java.lang.Number, ? super io.dcloud.uts.UTSArray<E>, ? extends S> callback, S initialValue) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        int size = size();
        for (int i = 0; i < size; i++) {
            initialValue = callback.invoke(initialValue, get(i), java.lang.Integer.valueOf(i), this);
        }
        return initialValue;
    }

    public <T extends E> E reduceRight(kotlin.jvm.functions.Function2<? super E, ? super T, ? extends E> callback) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        int size = size();
        int i = size - 1;
        if (i < 0) {
            throw new java.lang.Error("Reduce of empty array with no initial value");
        }
        E eInvoke = get(i);
        for (int i2 = size - 2; i2 >= 0; i2--) {
            eInvoke = callback.invoke(eInvoke, get(i2));
        }
        return eInvoke;
    }

    public <T extends E> E reduceRight(kotlin.jvm.functions.Function3<? super E, ? super T, ? super java.lang.Number, ? extends E> callback) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        int size = size();
        int i = size - 1;
        if (i < 0) {
            throw new java.lang.Error("Reduce of empty array with no initial value");
        }
        E eInvoke = get(i);
        for (int i2 = size - 2; i2 >= 0; i2--) {
            eInvoke = callback.invoke(eInvoke, get(i2), java.lang.Integer.valueOf(i2));
        }
        return eInvoke;
    }

    public <T extends E> E reduceRight(kotlin.jvm.functions.Function4<? super E, ? super T, ? super java.lang.Number, ? super io.dcloud.uts.UTSArray<E>, ? extends E> callback) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        int size = size();
        int i = size - 1;
        if (i < 0) {
            throw new java.lang.Error("Reduce of empty array with no initial value");
        }
        E eInvoke = get(i);
        for (int i2 = size - 2; i2 >= 0; i2--) {
            eInvoke = callback.invoke(eInvoke, get(i2), java.lang.Integer.valueOf(i2), this);
        }
        return eInvoke;
    }

    public <S> S reduceRight(kotlin.jvm.functions.Function2<? super S, ? super E, ? extends S> callback, S initialValue) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        for (int size = size() - 1; size >= 0; size--) {
            initialValue = callback.invoke(initialValue, get(size));
        }
        return initialValue;
    }

    public <S> S reduceRight(kotlin.jvm.functions.Function3<? super S, ? super E, ? super java.lang.Number, ? extends S> callback, S initialValue) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        for (int size = size() - 1; size >= 0; size--) {
            initialValue = callback.invoke(initialValue, get(size), java.lang.Integer.valueOf(size));
        }
        return initialValue;
    }

    public <S> S reduceRight(kotlin.jvm.functions.Function4<? super S, ? super E, ? super java.lang.Number, ? super io.dcloud.uts.UTSArray<E>, ? extends S> callback, S initialValue) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        for (int size = size() - 1; size >= 0; size--) {
            initialValue = callback.invoke(initialValue, get(size), java.lang.Integer.valueOf(size), this);
        }
        return initialValue;
    }

    public io.dcloud.uts.UTSArray<E> reverse() {
        java.util.Collections.reverse(this);
        return this;
    }

    public E shift() {
        return (E) kotlin.collections.CollectionsKt.removeFirstOrNull(this);
    }

    public static /* synthetic */ io.dcloud.uts.UTSArray slice$default(io.dcloud.uts.UTSArray uTSArray, java.lang.Number number, java.lang.Number number2, int i, java.lang.Object obj) {
        if (obj != null) {
            throw new java.lang.UnsupportedOperationException("Super calls with default arguments not supported in this target, function: slice");
        }
        if ((i & 1) != 0) {
            number = (java.lang.Number) 0;
        }
        if ((i & 2) != 0) {
            number2 = java.lang.Integer.valueOf(uTSArray.size());
        }
        return uTSArray.slice(number, number2);
    }

    public io.dcloud.uts.UTSArray<E> slice(java.lang.Number start, java.lang.Number end) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(start, "start");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(end, "end");
        io.dcloud.uts.UTSArray<E> uTSArray = new io.dcloud.uts.UTSArray<>();
        int sliceIndex = io.dcloud.uts.utils.IndexKt.toSliceIndex(end, size());
        for (int sliceIndex2 = io.dcloud.uts.utils.IndexKt.toSliceIndex(start, size()); sliceIndex2 < sliceIndex; sliceIndex2++) {
            uTSArray.add(get(sliceIndex2));
        }
        return uTSArray;
    }

    public boolean some(kotlin.jvm.functions.Function1<? super E, java.lang.Boolean> callback) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        int size = size();
        for (int i = 0; i < size; i++) {
            if (i < size() && callback.invoke(get(i)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public boolean some(kotlin.jvm.functions.Function2<? super E, ? super java.lang.Number, java.lang.Boolean> callback) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        int size = size();
        for (int i = 0; i < size; i++) {
            if (i < size() && callback.invoke(get(i), java.lang.Integer.valueOf(i)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public boolean some(kotlin.jvm.functions.Function3<? super E, ? super java.lang.Number, ? super io.dcloud.uts.UTSArray<E>, java.lang.Boolean> callback) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        int size = size();
        for (int i = 0; i < size; i++) {
            if (i < size() && callback.invoke(get(i), java.lang.Integer.valueOf(i), this).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public final java.util.List<E> toKotlinList() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<E> it = iterator();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public io.dcloud.uts.UTSArray<E> sort(final kotlin.jvm.functions.Function2<? super E, ? super E, ? extends java.lang.Number> compareFn) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(compareFn, "compareFn");
        java.util.Collections.sort(this, new java.util.Comparator() { // from class: io.dcloud.uts.UTSArray$$ExternalSyntheticLambda0
            @Override // java.util.Comparator
            public final int compare(java.lang.Object obj, java.lang.Object obj2) {
                return io.dcloud.uts.UTSArray.sort$lambda$2(compareFn, obj, obj2);
            }
        });
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int sort$lambda$2(kotlin.jvm.functions.Function2 function2, java.lang.Object obj, java.lang.Object obj2) {
        java.lang.Number number = (java.lang.Number) function2.invoke(obj, obj2);
        if (io.dcloud.uts.NumberKt.compareTo(number, (java.lang.Number) 0) > 0) {
            return 1;
        }
        return io.dcloud.uts.NumberKt.compareTo(number, (java.lang.Number) 0) < 0 ? -1 : 0;
    }

    public io.dcloud.uts.UTSArray<E> splice(java.lang.Number start) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(start, "start");
        io.dcloud.uts.UTSArray<E> uTSArray = new io.dcloud.uts.UTSArray<>();
        int sliceIndex = io.dcloud.uts.utils.IndexKt.toSliceIndex(start, size());
        int size = size();
        for (int i = sliceIndex; i < size; i++) {
            uTSArray.add(get(i));
        }
        while (size() > sliceIndex) {
            kotlin.collections.CollectionsKt.removeLastOrNull(this);
        }
        return uTSArray;
    }

    public io.dcloud.uts.UTSArray<E> splice(java.lang.Number start, java.lang.Number deleteCount) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(start, "start");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(deleteCount, "deleteCount");
        io.dcloud.uts.UTSArray<E> uTSArray = new io.dcloud.uts.UTSArray<>();
        int sliceIndex = io.dcloud.uts.utils.IndexKt.toSliceIndex(start, size());
        int iIntValue = 0;
        if (io.dcloud.uts.NumberKt.compareTo(deleteCount, (java.lang.Number) 0) >= 0) {
            if (io.dcloud.uts.NumberKt.compareTo(deleteCount, java.lang.Integer.valueOf(size() - sliceIndex)) > 0) {
                iIntValue = size() - sliceIndex;
            } else {
                iIntValue = deleteCount.intValue();
            }
        }
        int i = iIntValue + sliceIndex;
        for (int i2 = sliceIndex; i2 < i; i2++) {
            uTSArray.add(get(i2));
        }
        while (iIntValue > 0) {
            remove(sliceIndex);
            iIntValue--;
        }
        return uTSArray;
    }

    public io.dcloud.uts.UTSArray<E> splice(java.lang.Number start, java.lang.Number deleteCount, E... items) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(start, "start");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(deleteCount, "deleteCount");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(items, "items");
        io.dcloud.uts.UTSArray<E> uTSArray = new io.dcloud.uts.UTSArray<>();
        int sliceIndex = io.dcloud.uts.utils.IndexKt.toSliceIndex(start, size());
        int iIntValue = 0;
        if (io.dcloud.uts.NumberKt.compareTo(deleteCount, (java.lang.Number) 0) >= 0) {
            if (io.dcloud.uts.NumberKt.compareTo(deleteCount, java.lang.Integer.valueOf(size() - sliceIndex)) > 0) {
                iIntValue = size() - sliceIndex;
            } else {
                iIntValue = deleteCount.intValue();
            }
        }
        int i = iIntValue + sliceIndex;
        for (int i2 = sliceIndex; i2 < i; i2++) {
            uTSArray.add(get(i2));
        }
        while (iIntValue > 0) {
            remove(sliceIndex);
            iIntValue--;
        }
        int length = items.length;
        while (true) {
            length--;
            if (-1 >= length) {
                return uTSArray;
            }
            add(sliceIndex, items[length]);
        }
    }

    public int unshift(E... items) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(items, "items");
        addAll(0, kotlin.collections.ArraysKt.toList(items));
        return size();
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        return java.lang.System.identityHashCode(this);
    }

    @Override // java.util.AbstractCollection
    public java.lang.String toString() {
        java.lang.String string;
        java.util.Iterator<E> it = iterator();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        if (!it.hasNext()) {
            return "";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        while (true) {
            E next = it.next();
            if (next == null) {
                sb.append("");
            } else {
                if (next instanceof java.lang.Number) {
                    string = io.dcloud.uts.NumberKt.toStringAsJS((java.lang.Number) next);
                } else {
                    string = next.toString();
                }
                sb.append(string);
            }
            if (!it.hasNext()) {
                java.lang.String string2 = sb.toString();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
                return string2;
            }
            sb.append(com.taobao.weex.el.parse.Operators.ARRAY_SEPRATOR);
        }
    }

    public final E set(java.lang.Number index, E element) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(index, "index");
        return set(index.intValue(), element);
    }
}
