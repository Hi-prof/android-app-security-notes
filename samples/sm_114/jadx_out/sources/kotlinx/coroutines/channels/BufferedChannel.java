package kotlinx.coroutines.channels;

/* JADX INFO: compiled from: BufferedChannel.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b$\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0004à\u0001á\u0001B1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\"\b\u0002\u0010\u0005\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\b¢\u0006\u0002\u0010\tJ\u0010\u0010P\u001a\u00020\u001c2\u0006\u0010Q\u001a\u00020\u0010H\u0002J\u0006\u0010R\u001a\u00020\u0007J\u0010\u0010R\u001a\u00020\u001c2\b\u0010S\u001a\u0004\u0018\u00010\u0016J\u0016\u0010R\u001a\u00020\u00072\u000e\u0010S\u001a\n\u0018\u00010Tj\u0004\u0018\u0001`UJ\u0017\u0010V\u001a\u00020\u001c2\b\u0010S\u001a\u0004\u0018\u00010\u0016H\u0010¢\u0006\u0002\bWJ\u001e\u0010X\u001a\u00020\u00072\f\u0010Y\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010K\u001a\u00020\u0010H\u0002J\u0006\u0010Z\u001a\u00020\u0007J\u0012\u0010[\u001a\u00020\u001c2\b\u0010S\u001a\u0004\u0018\u00010\u0016H\u0016J\u000e\u0010\\\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0002J\u001a\u0010]\u001a\u00020\u001c2\b\u0010S\u001a\u0004\u0018\u00010\u00162\u0006\u0010R\u001a\u00020\u001cH\u0014J\u0010\u0010^\u001a\u00020\u00072\u0006\u0010_\u001a\u00020\u0010H\u0002J\u0016\u0010`\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010_\u001a\u00020\u0010H\u0002J\b\u0010a\u001a\u00020\u0007H\u0002J\u0010\u0010b\u001a\u00020\u00072\u0006\u0010c\u001a\u00020\u0010H\u0004J\b\u0010d\u001a\u00020\u0007H\u0002J.\u0010e\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00142\u0006\u0010f\u001a\u00020\u00102\f\u0010g\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010h\u001a\u00020\u0010H\u0002J&\u0010i\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00142\u0006\u0010f\u001a\u00020\u00102\f\u0010g\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0002J&\u0010j\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00142\u0006\u0010f\u001a\u00020\u00102\f\u0010g\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0002J\r\u0010k\u001a\u00020\u001cH\u0000¢\u0006\u0002\blJ\u0012\u0010m\u001a\u00020\u00072\b\b\u0002\u0010n\u001a\u00020\u0010H\u0002J\b\u0010o\u001a\u00020\u0007H\u0002J-\u0010p\u001a\u00020\u00072#\u0010q\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0016¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(S\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J&\u0010r\u001a\u00020\u001c2\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0006\u0010u\u001a\u00020\u0010H\u0002J\u0018\u0010v\u001a\u00020\u001c2\u0006\u0010w\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u000f\u0010x\u001a\b\u0012\u0004\u0012\u00028\u00000yH\u0096\u0002J\u0016\u0010z\u001a\u00020\u00102\f\u0010Y\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0002J\b\u0010{\u001a\u00020\u0007H\u0002J\b\u0010|\u001a\u00020\u0007H\u0002J\b\u0010}\u001a\u00020\u0007H\u0002J\u001e\u0010~\u001a\u00020\u00072\u0006\u0010f\u001a\u00020\u00102\f\u0010g\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0002J\b\u0010\u007f\u001a\u00020\u0007H\u0014J\u001f\u0010\u0080\u0001\u001a\u00020\u00072\u0014\u0010\u0081\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000,0\u0082\u0001H\u0002J\u0019\u0010\u0083\u0001\u001a\u00020\u00072\u000e\u0010\u0081\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000\u0082\u0001H\u0002J\u0015\u0010\u0084\u0001\u001a\u00020\u00072\n\u0010<\u001a\u0006\u0012\u0002\b\u000309H\u0002J$\u0010\u0085\u0001\u001a\u00020\u00072\u0007\u0010\u0086\u0001\u001a\u00028\u00002\n\u0010<\u001a\u0006\u0012\u0002\b\u000309H\u0002¢\u0006\u0003\u0010\u0087\u0001J\u0019\u0010\u0088\u0001\u001a\u00020\u00072\u0007\u0010\u0086\u0001\u001a\u00028\u0000H\u0082@¢\u0006\u0003\u0010\u0089\u0001J(\u0010\u008a\u0001\u001a\u00020\u00072\u0007\u0010\u0086\u0001\u001a\u00028\u00002\u000e\u0010\u0081\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070\u0082\u0001H\u0002¢\u0006\u0003\u0010\u008b\u0001J\t\u0010\u008c\u0001\u001a\u00020\u0007H\u0014J\t\u0010\u008d\u0001\u001a\u00020\u0007H\u0014J!\u0010\u008e\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010\fH\u0002J!\u0010\u0091\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010\fH\u0002J!\u0010\u0092\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010\fH\u0002J!\u0010\u0093\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010\fH\u0002J\u0010\u0010\u0094\u0001\u001a\u00028\u0000H\u0096@¢\u0006\u0003\u0010\u0095\u0001J\u001f\u0010\u0096\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000,H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\b\u0097\u0001\u0010\u0095\u0001J>\u0010\u0098\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000,2\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0099\u0001\u001a\u00020\u0010H\u0082@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001J\u008c\u0002\u0010\u009c\u0001\u001a\u0003H\u009d\u0001\"\u0005\b\u0001\u0010\u009d\u00012\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\f2$\u0010\u009f\u0001\u001a\u001f\u0012\u0014\u0012\u00128\u0000¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(\u0086\u0001\u0012\u0005\u0012\u0003H\u009d\u00010\u00062V\u0010 \u0001\u001aQ\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00028\u00000\u0014¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(¡\u0001\u0012\u0014\u0012\u00120\u0004¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(¢\u0001\u0012\u0014\u0012\u00120\u0010¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(\u0099\u0001\u0012\u0005\u0012\u0003H\u009d\u0001082\u000f\u0010£\u0001\u001a\n\u0012\u0005\u0012\u0003H\u009d\u00010¤\u00012X\b\u0002\u0010¥\u0001\u001aQ\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00028\u00000\u0014¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(¡\u0001\u0012\u0014\u0012\u00120\u0004¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(¢\u0001\u0012\u0014\u0012\u00120\u0010¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(\u0099\u0001\u0012\u0005\u0012\u0003H\u009d\u000108H\u0082\b¢\u0006\u0003\u0010¦\u0001Jh\u0010§\u0001\u001a\u00020\u00072\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0099\u0001\u001a\u00020\u00102\b\u0010\u009e\u0001\u001a\u00030¨\u00012#\u0010\u009f\u0001\u001a\u001e\u0012\u0014\u0012\u00128\u0000¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(\u0086\u0001\u0012\u0004\u0012\u00020\u00070\u00062\u000e\u0010£\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070¤\u0001H\u0082\bJ/\u0010©\u0001\u001a\u00028\u00002\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0099\u0001\u001a\u00020\u0010H\u0082@¢\u0006\u0003\u0010\u009b\u0001J \u0010ª\u0001\u001a\u00020\u00072\n\u0010<\u001a\u0006\u0012\u0002\b\u0003092\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010\fH\u0002J \u0010«\u0001\u001a\u00020\u00072\n\u0010<\u001a\u0006\u0012\u0002\b\u0003092\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010\fH\u0014J\u0017\u0010¬\u0001\u001a\u00020\u00072\f\u0010Y\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0002J\u0019\u0010\u00ad\u0001\u001a\u00020\u00072\u0007\u0010\u0086\u0001\u001a\u00028\u0000H\u0096@¢\u0006\u0003\u0010\u0089\u0001J\u001c\u0010®\u0001\u001a\u00020\u001c2\u0007\u0010\u0086\u0001\u001a\u00028\u0000H\u0090@¢\u0006\u0006\b¯\u0001\u0010\u0089\u0001J\u0082\u0002\u0010°\u0001\u001a\u0003H\u009d\u0001\"\u0005\b\u0001\u0010\u009d\u00012\u0007\u0010\u0086\u0001\u001a\u00028\u00002\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\f2\u000f\u0010±\u0001\u001a\n\u0012\u0005\u0012\u0003H\u009d\u00010¤\u00012A\u0010 \u0001\u001a<\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00028\u00000\u0014¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(¡\u0001\u0012\u0014\u0012\u00120\u0004¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(¢\u0001\u0012\u0005\u0012\u0003H\u009d\u00010²\u00012\u000f\u0010£\u0001\u001a\n\u0012\u0005\u0012\u0003H\u009d\u00010¤\u00012o\b\u0002\u0010¥\u0001\u001ah\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00028\u00000\u0014¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(¡\u0001\u0012\u0014\u0012\u00120\u0004¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(¢\u0001\u0012\u0014\u0012\u00128\u0000¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(\u0086\u0001\u0012\u0014\u0012\u00120\u0010¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(´\u0001\u0012\u0005\u0012\u0003H\u009d\u00010³\u0001H\u0082\b¢\u0006\u0003\u0010µ\u0001Jb\u0010¶\u0001\u001a\u00020\u00072\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0086\u0001\u001a\u00028\u00002\u0007\u0010´\u0001\u001a\u00020\u00102\b\u0010\u009e\u0001\u001a\u00030¨\u00012\u000e\u0010±\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070¤\u00012\u000e\u0010£\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070¤\u0001H\u0082\b¢\u0006\u0003\u0010·\u0001J8\u0010¸\u0001\u001a\u00020\u00072\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0086\u0001\u001a\u00028\u00002\u0007\u0010´\u0001\u001a\u00020\u0010H\u0082@¢\u0006\u0003\u0010¹\u0001J\u000f\u0010º\u0001\u001a\u00020\u001cH\u0010¢\u0006\u0003\b»\u0001J\u0012\u0010º\u0001\u001a\u00020\u001c2\u0007\u0010¼\u0001\u001a\u00020\u0010H\u0003J\n\u0010½\u0001\u001a\u00030¾\u0001H\u0016J\u0010\u0010¿\u0001\u001a\u00030¾\u0001H\u0000¢\u0006\u0003\bÀ\u0001J\u001e\u0010Á\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000,H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\bÂ\u0001\u0010Ã\u0001J'\u0010Ä\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070,2\u0007\u0010\u0086\u0001\u001a\u00028\u0000H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\bÅ\u0001\u0010Æ\u0001J'\u0010Ç\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070,2\u0007\u0010\u0086\u0001\u001a\u00028\u0000H\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\bÈ\u0001\u0010Æ\u0001J(\u0010É\u0001\u001a\u00020\u001c2\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010Ê\u0001\u001a\u00020\u0010H\u0002J(\u0010Ë\u0001\u001a\u00020\u001c2\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010Ê\u0001\u001a\u00020\u0010H\u0002J5\u0010Ì\u0001\u001a\u0004\u0018\u00010\f2\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0099\u0001\u001a\u00020\u00102\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\fH\u0002J5\u0010Í\u0001\u001a\u0004\u0018\u00010\f2\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0099\u0001\u001a\u00020\u00102\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\fH\u0002JK\u0010Î\u0001\u001a\u00020\u00042\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0086\u0001\u001a\u00028\u00002\u0007\u0010´\u0001\u001a\u00020\u00102\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\f2\u0007\u0010Ï\u0001\u001a\u00020\u001cH\u0002¢\u0006\u0003\u0010Ð\u0001JK\u0010Ñ\u0001\u001a\u00020\u00042\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0086\u0001\u001a\u00028\u00002\u0007\u0010´\u0001\u001a\u00020\u00102\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\f2\u0007\u0010Ï\u0001\u001a\u00020\u001cH\u0002¢\u0006\u0003\u0010Ð\u0001J\u0012\u0010Ò\u0001\u001a\u00020\u00072\u0007\u0010Ó\u0001\u001a\u00020\u0010H\u0002J\u0012\u0010Ô\u0001\u001a\u00020\u00072\u0007\u0010Ó\u0001\u001a\u00020\u0010H\u0002J\u0017\u0010Õ\u0001\u001a\u00020\u00072\u0006\u0010u\u001a\u00020\u0010H\u0000¢\u0006\u0003\bÖ\u0001J$\u0010×\u0001\u001a\u00020\u0007*\u00030¨\u00012\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u0004H\u0002J$\u0010Ø\u0001\u001a\u00020\u0007*\u00030¨\u00012\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u0004H\u0002J\u000e\u0010Ù\u0001\u001a\u00020\u0007*\u00030¨\u0001H\u0002J\u000e\u0010Ú\u0001\u001a\u00020\u0007*\u00030¨\u0001H\u0002J\u0017\u0010Û\u0001\u001a\u00020\u0007*\u00030¨\u00012\u0007\u0010Ü\u0001\u001a\u00020\u001cH\u0002J\u001c\u0010Ý\u0001\u001a\u00020\u001c*\u00020\f2\u0007\u0010\u0086\u0001\u001a\u00028\u0000H\u0002¢\u0006\u0003\u0010Þ\u0001J#\u0010ß\u0001\u001a\u00020\u001c*\u00020\f2\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u0004H\u0002R\u0011\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0082\u0004R\t\u0010\r\u001a\u00020\u000eX\u0082\u0004R\u0014\u0010\u000f\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00140\u000bX\u0082\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00168DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0082\u0004R\t\u0010\u001a\u001a\u00020\u000eX\u0082\u0004R\u001a\u0010\u001b\u001a\u00020\u001c8VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001fR\u001a\u0010 \u001a\u00020\u001c8VX\u0097\u0004¢\u0006\f\u0012\u0004\b!\u0010\u001e\u001a\u0004\b \u0010\u001fR\u0014\u0010\"\u001a\u00020\u001c8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u001fR\u001a\u0010#\u001a\u00020\u001c8VX\u0097\u0004¢\u0006\f\u0012\u0004\b$\u0010\u001e\u001a\u0004\b#\u0010\u001fR\u0014\u0010%\u001a\u00020\u001c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u001fR \u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000'8VX\u0096\u0004¢\u0006\f\u0012\u0004\b(\u0010\u001e\u001a\u0004\b)\u0010*R&\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000,0'8VX\u0096\u0004¢\u0006\f\u0012\u0004\b-\u0010\u001e\u001a\u0004\b.\u0010*R\"\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000'8VX\u0096\u0004¢\u0006\f\u0012\u0004\b0\u0010\u001e\u001a\u0004\b1\u0010*R,\u00102\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0000038VX\u0096\u0004¢\u0006\f\u0012\u0004\b4\u0010\u001e\u001a\u0004\b5\u00106R*\u0010\u0005\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\b8\u0000X\u0081\u0004¢\u0006\u0002\n\u0000Ru\u00107\u001ac\u0012\u0017\u0012\u0015\u0012\u0002\b\u000309¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(<\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(=\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(>\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u000108j\u0004\u0018\u0001`?X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b@\u0010\u001eR\u0014\u0010A\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bB\u0010\u0018R\u0015\u0010C\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00140\u000bX\u0082\u0004R\t\u0010D\u001a\u00020\u000eX\u0082\u0004R\u0014\u0010E\u001a\u00020\u00108@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bF\u0010\u0012R\u0014\u0010G\u001a\u00020\u00168DX\u0084\u0004¢\u0006\u0006\u001a\u0004\bH\u0010\u0018R\u0015\u0010I\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00140\u000bX\u0082\u0004R\t\u0010J\u001a\u00020\u000eX\u0082\u0004R\u0014\u0010K\u001a\u00020\u00108@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bL\u0010\u0012R\u0018\u0010M\u001a\u00020\u001c*\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bM\u0010NR\u0018\u0010O\u001a\u00020\u001c*\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bO\u0010N\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006â\u0001"}, d2 = {"Lkotlinx/coroutines/channels/BufferedChannel;", "E", "Lkotlinx/coroutines/channels/Channel;", "capacity", "", "onUndeliveredElement", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "(ILkotlin/jvm/functions/Function1;)V", "_closeCause", "Lkotlinx/atomicfu/AtomicRef;", "", "bufferEnd", "Lkotlinx/atomicfu/AtomicLong;", "bufferEndCounter", "", "getBufferEndCounter", "()J", "bufferEndSegment", "Lkotlinx/coroutines/channels/ChannelSegment;", "closeCause", "", "getCloseCause", "()Ljava/lang/Throwable;", "closeHandler", "completedExpandBuffersAndPauseFlag", "isClosedForReceive", "", "isClosedForReceive$annotations", "()V", "()Z", "isClosedForSend", "isClosedForSend$annotations", "isConflatedDropOldest", "isEmpty", "isEmpty$annotations", "isRendezvousOrUnlimited", "onReceive", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnReceive$annotations", "getOnReceive", "()Lkotlinx/coroutines/selects/SelectClause1;", "onReceiveCatching", "Lkotlinx/coroutines/channels/ChannelResult;", "getOnReceiveCatching$annotations", "getOnReceiveCatching", "onReceiveOrNull", "getOnReceiveOrNull$annotations", "getOnReceiveOrNull", "onSend", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend$annotations", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "onUndeliveredElementReceiveCancellationConstructor", "Lkotlin/Function3;", "Lkotlinx/coroutines/selects/SelectInstance;", "Lkotlin/ParameterName;", "name", "select", "param", "internalResult", "Lkotlinx/coroutines/selects/OnCancellationConstructor;", "getOnUndeliveredElementReceiveCancellationConstructor$annotations", "receiveException", "getReceiveException", "receiveSegment", "receivers", "receiversCounter", "getReceiversCounter$kotlinx_coroutines_core", "sendException", "getSendException", "sendSegment", "sendersAndCloseStatus", "sendersCounter", "getSendersCounter$kotlinx_coroutines_core", "isClosedForReceive0", "(J)Z", "isClosedForSend0", "bufferOrRendezvousSend", "curSenders", com.alibaba.android.bindingx.core.internal.BindingXConstants.STATE_CANCEL, "cause", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cancelImpl", "cancelImpl$kotlinx_coroutines_core", "cancelSuspendedReceiveRequests", "lastSegment", "checkSegmentStructureInvariants", io.dcloud.common.constant.AbsoluteConst.EVENTS_CLOSE, "closeLinkedList", "closeOrCancelImpl", "completeCancel", "sendersCur", "completeClose", "completeCloseOrCancel", "dropFirstElementUntilTheSpecifiedCellIsInTheBuffer", "globalCellIndex", "expandBuffer", "findSegmentBufferEnd", "id", "startFrom", "currentBufferEndCounter", "findSegmentReceive", "findSegmentSend", "hasElements", "hasElements$kotlinx_coroutines_core", "incCompletedExpandBufferAttempts", "nAttempts", "invokeCloseHandler", "invokeOnClose", "handler", "isCellNonEmpty", "segment", "index", "globalIndex", "isClosed", "sendersAndCloseStatusCur", "iterator", "Lkotlinx/coroutines/channels/ChannelIterator;", "markAllEmptyCellsAsClosed", "markCancellationStarted", "markCancelled", "markClosed", "moveSegmentBufferEndToSpecifiedOrLast", "onClosedIdempotent", "onClosedReceiveCatchingOnNoWaiterSuspend", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "onClosedReceiveOnNoWaiterSuspend", "onClosedSelectOnReceive", "onClosedSelectOnSend", com.alibaba.android.bindingx.core.internal.BindingXConstants.KEY_ELEMENT, "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)V", "onClosedSend", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onClosedSendOnNoWaiterSuspend", "(Ljava/lang/Object;Lkotlinx/coroutines/CancellableContinuation;)V", "onReceiveDequeued", "onReceiveEnqueued", "processResultSelectReceive", "ignoredParam", "selectResult", "processResultSelectReceiveCatching", "processResultSelectReceiveOrNull", "processResultSelectSend", "receive", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveCatching", "receiveCatching-JP2dKIU", "receiveCatchingOnNoWaiterSuspend", "r", "receiveCatchingOnNoWaiterSuspend-GKJJFZk", "(Lkotlinx/coroutines/channels/ChannelSegment;IJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveImpl", "R", "waiter", "onElementRetrieved", "onSuspend", "segm", com.facebook.common.callercontext.ContextChain.TAG_INFRA, "onClosed", "Lkotlin/Function0;", "onNoWaiterSuspend", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "receiveImplOnNoWaiter", "Lkotlinx/coroutines/Waiter;", "receiveOnNoWaiterSuspend", "registerSelectForReceive", "registerSelectForSend", "removeUnprocessedElements", "send", "sendBroadcast", "sendBroadcast$kotlinx_coroutines_core", "sendImpl", "onRendezvousOrBuffered", "Lkotlin/Function2;", "Lkotlin/Function4;", "s", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "sendImplOnNoWaiter", "(Lkotlinx/coroutines/channels/ChannelSegment;ILjava/lang/Object;JLkotlinx/coroutines/Waiter;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "sendOnNoWaiterSuspend", "(Lkotlinx/coroutines/channels/ChannelSegment;ILjava/lang/Object;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shouldSendSuspend", "shouldSendSuspend$kotlinx_coroutines_core", "curSendersAndCloseStatus", "toString", "", "toStringDebug", "toStringDebug$kotlinx_coroutines_core", "tryReceive", "tryReceive-PtdJZtk", "()Ljava/lang/Object;", "trySend", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "trySendDropOldest", "trySendDropOldest-JP2dKIU", "updateCellExpandBuffer", "b", "updateCellExpandBufferSlow", "updateCellReceive", "updateCellReceiveSlow", "updateCellSend", "closed", "(Lkotlinx/coroutines/channels/ChannelSegment;ILjava/lang/Object;JLjava/lang/Object;Z)I", "updateCellSendSlow", "updateReceiversCounterIfLower", "value", "updateSendersCounterIfLower", "waitExpandBufferCompletion", "waitExpandBufferCompletion$kotlinx_coroutines_core", "prepareReceiverForSuspension", "prepareSenderForSuspension", "resumeReceiverOnClosedChannel", "resumeSenderOnCancelledChannel", "resumeWaiterOnClosedChannel", "receiver", "tryResumeReceiver", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "tryResumeSender", "BufferedChannelIterator", "SendBroadcast", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class BufferedChannel<E> implements kotlinx.coroutines.channels.Channel<E> {
    private volatile /* synthetic */ java.lang.Object _closeCause$volatile;
    private volatile /* synthetic */ long bufferEnd$volatile;
    private volatile /* synthetic */ java.lang.Object bufferEndSegment$volatile;
    private final int capacity;
    private volatile /* synthetic */ java.lang.Object closeHandler$volatile;
    private volatile /* synthetic */ long completedExpandBuffersAndPauseFlag$volatile;
    public final kotlin.jvm.functions.Function1<E, kotlin.Unit> onUndeliveredElement;
    private final kotlin.jvm.functions.Function3<kotlinx.coroutines.selects.SelectInstance<?>, java.lang.Object, java.lang.Object, kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit>> onUndeliveredElementReceiveCancellationConstructor;
    private volatile /* synthetic */ java.lang.Object receiveSegment$volatile;
    private volatile /* synthetic */ long receivers$volatile;
    private volatile /* synthetic */ java.lang.Object sendSegment$volatile;
    private volatile /* synthetic */ long sendersAndCloseStatus$volatile;
    private static final /* synthetic */ java.util.concurrent.atomic.AtomicLongFieldUpdater sendersAndCloseStatus$volatile$FU = java.util.concurrent.atomic.AtomicLongFieldUpdater.newUpdater(kotlinx.coroutines.channels.BufferedChannel.class, "sendersAndCloseStatus$volatile");
    private static final /* synthetic */ java.util.concurrent.atomic.AtomicLongFieldUpdater receivers$volatile$FU = java.util.concurrent.atomic.AtomicLongFieldUpdater.newUpdater(kotlinx.coroutines.channels.BufferedChannel.class, "receivers$volatile");
    private static final /* synthetic */ java.util.concurrent.atomic.AtomicLongFieldUpdater bufferEnd$volatile$FU = java.util.concurrent.atomic.AtomicLongFieldUpdater.newUpdater(kotlinx.coroutines.channels.BufferedChannel.class, "bufferEnd$volatile");
    private static final /* synthetic */ java.util.concurrent.atomic.AtomicLongFieldUpdater completedExpandBuffersAndPauseFlag$volatile$FU = java.util.concurrent.atomic.AtomicLongFieldUpdater.newUpdater(kotlinx.coroutines.channels.BufferedChannel.class, "completedExpandBuffersAndPauseFlag$volatile");
    private static final /* synthetic */ java.util.concurrent.atomic.AtomicReferenceFieldUpdater sendSegment$volatile$FU = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(kotlinx.coroutines.channels.BufferedChannel.class, java.lang.Object.class, "sendSegment$volatile");
    private static final /* synthetic */ java.util.concurrent.atomic.AtomicReferenceFieldUpdater receiveSegment$volatile$FU = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(kotlinx.coroutines.channels.BufferedChannel.class, java.lang.Object.class, "receiveSegment$volatile");
    private static final /* synthetic */ java.util.concurrent.atomic.AtomicReferenceFieldUpdater bufferEndSegment$volatile$FU = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(kotlinx.coroutines.channels.BufferedChannel.class, java.lang.Object.class, "bufferEndSegment$volatile");
    private static final /* synthetic */ java.util.concurrent.atomic.AtomicReferenceFieldUpdater _closeCause$volatile$FU = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(kotlinx.coroutines.channels.BufferedChannel.class, java.lang.Object.class, "_closeCause$volatile");
    private static final /* synthetic */ java.util.concurrent.atomic.AtomicReferenceFieldUpdater closeHandler$volatile$FU = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(kotlinx.coroutines.channels.BufferedChannel.class, java.lang.Object.class, "closeHandler$volatile");

    private final /* synthetic */ java.lang.Object getAndUpdate$atomicfu(java.lang.Object obj, java.util.concurrent.atomic.AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, kotlin.jvm.functions.Function1<java.lang.Object, ? extends java.lang.Object> function1) {
        java.lang.Object obj2;
        do {
            obj2 = atomicReferenceFieldUpdater.get(obj);
        } while (!androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceFieldUpdater, obj, obj2, function1.invoke2(obj2)));
        return obj2;
    }

    private final /* synthetic */ long getBufferEnd$volatile() {
        return this.bufferEnd$volatile;
    }

    private final /* synthetic */ java.lang.Object getBufferEndSegment$volatile() {
        return this.bufferEndSegment$volatile;
    }

    private final /* synthetic */ java.lang.Object getCloseHandler$volatile() {
        return this.closeHandler$volatile;
    }

    private final /* synthetic */ long getCompletedExpandBuffersAndPauseFlag$volatile() {
        return this.completedExpandBuffersAndPauseFlag$volatile;
    }

    public static /* synthetic */ void getOnReceive$annotations() {
    }

    public static /* synthetic */ void getOnReceiveCatching$annotations() {
    }

    public static /* synthetic */ void getOnReceiveOrNull$annotations() {
    }

    public static /* synthetic */ void getOnSend$annotations() {
    }

    private static /* synthetic */ void getOnUndeliveredElementReceiveCancellationConstructor$annotations() {
    }

    private final /* synthetic */ java.lang.Object getReceiveSegment$volatile() {
        return this.receiveSegment$volatile;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ java.util.concurrent.atomic.AtomicReferenceFieldUpdater getReceiveSegment$volatile$FU() {
        return receiveSegment$volatile$FU;
    }

    private final /* synthetic */ long getReceivers$volatile() {
        return this.receivers$volatile;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ java.util.concurrent.atomic.AtomicLongFieldUpdater getReceivers$volatile$FU() {
        return receivers$volatile$FU;
    }

    private final /* synthetic */ java.lang.Object getSendSegment$volatile() {
        return this.sendSegment$volatile;
    }

    private final /* synthetic */ long getSendersAndCloseStatus$volatile() {
        return this.sendersAndCloseStatus$volatile;
    }

    private final /* synthetic */ java.lang.Object get_closeCause$volatile() {
        return this._closeCause$volatile;
    }

    public static /* synthetic */ void isClosedForReceive$annotations() {
    }

    public static /* synthetic */ void isClosedForSend$annotations() {
    }

    public static /* synthetic */ void isEmpty$annotations() {
    }

    private final /* synthetic */ void loop$atomicfu(java.lang.Object obj, java.util.concurrent.atomic.AtomicLongFieldUpdater atomicLongFieldUpdater, kotlin.jvm.functions.Function1<? super java.lang.Long, kotlin.Unit> function1) {
        while (true) {
            function1.invoke2(java.lang.Long.valueOf(atomicLongFieldUpdater.get(obj)));
        }
    }

    private final /* synthetic */ void loop$atomicfu(java.lang.Object obj, java.util.concurrent.atomic.AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> function1) {
        while (true) {
            function1.invoke2(atomicReferenceFieldUpdater.get(obj));
        }
    }

    private final /* synthetic */ void setBufferEnd$volatile(long j) {
        this.bufferEnd$volatile = j;
    }

    private final /* synthetic */ void setBufferEndSegment$volatile(java.lang.Object obj) {
        this.bufferEndSegment$volatile = obj;
    }

    private final /* synthetic */ void setCloseHandler$volatile(java.lang.Object obj) {
        this.closeHandler$volatile = obj;
    }

    private final /* synthetic */ void setCompletedExpandBuffersAndPauseFlag$volatile(long j) {
        this.completedExpandBuffersAndPauseFlag$volatile = j;
    }

    private final /* synthetic */ void setReceiveSegment$volatile(java.lang.Object obj) {
        this.receiveSegment$volatile = obj;
    }

    private final /* synthetic */ void setReceivers$volatile(long j) {
        this.receivers$volatile = j;
    }

    private final /* synthetic */ void setSendSegment$volatile(java.lang.Object obj) {
        this.sendSegment$volatile = obj;
    }

    private final /* synthetic */ void setSendersAndCloseStatus$volatile(long j) {
        this.sendersAndCloseStatus$volatile = j;
    }

    private final /* synthetic */ void set_closeCause$volatile(java.lang.Object obj) {
        this._closeCause$volatile = obj;
    }

    private final /* synthetic */ void update$atomicfu(java.lang.Object obj, java.util.concurrent.atomic.AtomicLongFieldUpdater atomicLongFieldUpdater, kotlin.jvm.functions.Function1<? super java.lang.Long, java.lang.Long> function1) {
        while (true) {
            long j = atomicLongFieldUpdater.get(obj);
            java.lang.Object obj2 = obj;
            java.util.concurrent.atomic.AtomicLongFieldUpdater atomicLongFieldUpdater2 = atomicLongFieldUpdater;
            if (atomicLongFieldUpdater2.compareAndSet(obj2, j, function1.invoke2(java.lang.Long.valueOf(j)).longValue())) {
                return;
            }
            atomicLongFieldUpdater = atomicLongFieldUpdater2;
            obj = obj2;
        }
    }

    protected boolean isConflatedDropOldest() {
        return false;
    }

    protected void onClosedIdempotent() {
    }

    protected void onReceiveDequeued() {
    }

    protected void onReceiveEnqueued() {
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public java.lang.Object receive(kotlin.coroutines.Continuation<? super E> continuation) {
        return receive$suspendImpl(this, continuation);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /* JADX INFO: renamed from: receiveCatching-JP2dKIU, reason: not valid java name */
    public java.lang.Object mo2094receiveCatchingJP2dKIU(kotlin.coroutines.Continuation<? super kotlinx.coroutines.channels.ChannelResult<? extends E>> continuation) {
        return m2092receiveCatchingJP2dKIU$suspendImpl(this, continuation);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public java.lang.Object send(E e, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return send$suspendImpl(this, e, continuation);
    }

    public java.lang.Object sendBroadcast$kotlinx_coroutines_core(E e, kotlin.coroutines.Continuation<? super java.lang.Boolean> continuation) {
        return sendBroadcast$suspendImpl(this, e, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BufferedChannel(int i, kotlin.jvm.functions.Function1<? super E, kotlin.Unit> function1) {
        this.capacity = i;
        this.onUndeliveredElement = function1;
        if (i >= 0) {
            this.bufferEnd$volatile = kotlinx.coroutines.channels.BufferedChannelKt.initialBufferEnd(i);
            this.completedExpandBuffersAndPauseFlag$volatile = getBufferEndCounter();
            kotlinx.coroutines.channels.ChannelSegment channelSegment = new kotlinx.coroutines.channels.ChannelSegment(0L, null, this, 3);
            this.sendSegment$volatile = channelSegment;
            this.receiveSegment$volatile = channelSegment;
            if (isRendezvousOrUnlimited()) {
                channelSegment = kotlinx.coroutines.channels.BufferedChannelKt.NULL_SEGMENT;
                kotlin.jvm.internal.Intrinsics.checkNotNull(channelSegment, "null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>");
            }
            this.bufferEndSegment$volatile = channelSegment;
            this.onUndeliveredElementReceiveCancellationConstructor = function1 != 0 ? (kotlin.jvm.functions.Function3) new kotlin.jvm.functions.Function3<kotlinx.coroutines.selects.SelectInstance<?>, java.lang.Object, java.lang.Object, kotlin.jvm.functions.Function1<? super java.lang.Throwable, ? extends kotlin.Unit>>(this) { // from class: kotlinx.coroutines.channels.BufferedChannel$onUndeliveredElementReceiveCancellationConstructor$1$1
                final /* synthetic */ kotlinx.coroutines.channels.BufferedChannel<E> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function3
                public final kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit> invoke(final kotlinx.coroutines.selects.SelectInstance<?> selectInstance, java.lang.Object obj, final java.lang.Object obj2) {
                    final kotlinx.coroutines.channels.BufferedChannel<E> bufferedChannel = this.this$0;
                    return new kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit>() { // from class: kotlinx.coroutines.channels.BufferedChannel$onUndeliveredElementReceiveCancellationConstructor$1$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        /* JADX INFO: renamed from: invoke */
                        public /* bridge */ /* synthetic */ kotlin.Unit invoke2(java.lang.Throwable th) {
                            invoke2(th);
                            return kotlin.Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(java.lang.Throwable th) {
                            if (obj2 != kotlinx.coroutines.channels.BufferedChannelKt.getCHANNEL_CLOSED()) {
                                kotlinx.coroutines.internal.OnUndeliveredElementKt.callUndeliveredElement(bufferedChannel.onUndeliveredElement, obj2, selectInstance.getContext());
                            }
                        }
                    };
                }
            } : null;
            this._closeCause$volatile = kotlinx.coroutines.channels.BufferedChannelKt.NO_CLOSE_CAUSE;
            return;
        }
        throw new java.lang.IllegalArgumentException(("Invalid channel capacity: " + i + ", should be >=0").toString());
    }

    public /* synthetic */ BufferedChannel(int i, kotlin.jvm.functions.Function1 function1, int i2, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : function1);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @kotlin.ReplaceWith(expression = "trySend(element).isSuccess", imports = {}))
    public boolean offer(E e) {
        return kotlinx.coroutines.channels.Channel.DefaultImpls.offer(this, e);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith = @kotlin.ReplaceWith(expression = "tryReceive().getOrNull()", imports = {}))
    public E poll() {
        return (E) kotlinx.coroutines.channels.Channel.DefaultImpls.poll(this);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith = @kotlin.ReplaceWith(expression = "receiveCatching().getOrNull()", imports = {}))
    public java.lang.Object receiveOrNull(kotlin.coroutines.Continuation<? super E> continuation) {
        return kotlinx.coroutines.channels.Channel.DefaultImpls.receiveOrNull(this, continuation);
    }

    public final long getSendersCounter$kotlinx_coroutines_core() {
        return sendersAndCloseStatus$volatile$FU.get(this) & 1152921504606846975L;
    }

    public final long getReceiversCounter$kotlinx_coroutines_core() {
        return receivers$volatile$FU.get(this);
    }

    private final long getBufferEndCounter() {
        return bufferEnd$volatile$FU.get(this);
    }

    private final boolean isRendezvousOrUnlimited() {
        long bufferEndCounter = getBufferEndCounter();
        return bufferEndCounter == 0 || bufferEndCounter == Long.MAX_VALUE;
    }

    static /* synthetic */ <E> java.lang.Object send$suspendImpl(kotlinx.coroutines.channels.BufferedChannel<E> bufferedChannel, E e, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) throws java.lang.Throwable {
        kotlinx.coroutines.channels.ChannelSegment<E> channelSegment;
        kotlinx.coroutines.channels.ChannelSegment<E> channelSegment2 = (kotlinx.coroutines.channels.ChannelSegment) sendSegment$volatile$FU.get(bufferedChannel);
        while (true) {
            long andIncrement = sendersAndCloseStatus$volatile$FU.getAndIncrement(bufferedChannel);
            long j = andIncrement & 1152921504606846975L;
            boolean zIsClosedForSend0 = bufferedChannel.isClosedForSend0(andIncrement);
            long j2 = j / ((long) kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE);
            int i = (int) (j % ((long) kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE));
            if (channelSegment2.id != j2) {
                kotlinx.coroutines.channels.ChannelSegment<E> channelSegmentFindSegmentSend = bufferedChannel.findSegmentSend(j2, channelSegment2);
                if (channelSegmentFindSegmentSend != null) {
                    channelSegment = channelSegmentFindSegmentSend;
                } else if (zIsClosedForSend0) {
                    java.lang.Object objOnClosedSend = bufferedChannel.onClosedSend(e, continuation);
                    if (objOnClosedSend != kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        break;
                    }
                    return objOnClosedSend;
                }
            } else {
                channelSegment = channelSegment2;
            }
            kotlinx.coroutines.channels.BufferedChannel<E> bufferedChannel2 = bufferedChannel;
            E e2 = e;
            int iUpdateCellSend = bufferedChannel2.updateCellSend(channelSegment, i, e2, j, null, zIsClosedForSend0);
            if (iUpdateCellSend == 0) {
                channelSegment.cleanPrev();
                break;
            }
            if (iUpdateCellSend != 1) {
                if (iUpdateCellSend == 2) {
                    if (!zIsClosedForSend0) {
                        if (!kotlinx.coroutines.DebugKt.getASSERTIONS_ENABLED()) {
                            break;
                        }
                        throw new java.lang.AssertionError();
                    }
                    channelSegment.onSlotCleaned();
                    java.lang.Object objOnClosedSend2 = bufferedChannel2.onClosedSend(e2, continuation);
                    if (objOnClosedSend2 != kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        break;
                    }
                    return objOnClosedSend2;
                }
                if (iUpdateCellSend == 3) {
                    java.lang.Object objSendOnNoWaiterSuspend = bufferedChannel2.sendOnNoWaiterSuspend(channelSegment, i, e2, j, continuation);
                    if (objSendOnNoWaiterSuspend != kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        break;
                    }
                    return objSendOnNoWaiterSuspend;
                }
                if (iUpdateCellSend == 4) {
                    if (j < bufferedChannel2.getReceiversCounter$kotlinx_coroutines_core()) {
                        channelSegment.cleanPrev();
                    }
                    java.lang.Object objOnClosedSend3 = bufferedChannel2.onClosedSend(e2, continuation);
                    if (objOnClosedSend3 != kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        break;
                    }
                    return objOnClosedSend3;
                }
                if (iUpdateCellSend == 5) {
                    channelSegment.cleanPrev();
                }
                bufferedChannel = bufferedChannel2;
                channelSegment2 = channelSegment;
                e = e2;
            } else {
                break;
            }
        }
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void prepareSenderForSuspension(kotlinx.coroutines.Waiter waiter, kotlinx.coroutines.channels.ChannelSegment<E> channelSegment, int i) {
        waiter.invokeOnCancellation(channelSegment, i + kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onClosedSendOnNoWaiterSuspend(E element, kotlinx.coroutines.CancellableContinuation<? super kotlin.Unit> cont) {
        kotlin.jvm.functions.Function1<E, kotlin.Unit> function1 = this.onUndeliveredElement;
        if (function1 != null) {
            kotlinx.coroutines.internal.OnUndeliveredElementKt.callUndeliveredElement(function1, element, cont.getContext());
        }
        kotlinx.coroutines.CancellableContinuation<? super kotlin.Unit> cancellableContinuation = cont;
        java.lang.Throwable sendException = getSendException();
        if (kotlinx.coroutines.DebugKt.getRECOVER_STACK_TRACES() && (cancellableContinuation instanceof kotlin.coroutines.jvm.internal.CoroutineStackFrame)) {
            sendException = kotlinx.coroutines.internal.StackTraceRecoveryKt.recoverFromStackFrame(sendException, (kotlin.coroutines.jvm.internal.CoroutineStackFrame) cancellableContinuation);
        }
        kotlin.Result.Companion companion = kotlin.Result.INSTANCE;
        cancellableContinuation.resumeWith(kotlin.Result.m541constructorimpl(kotlin.ResultKt.createFailure(sendException)));
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    /* JADX INFO: renamed from: trySend-JP2dKIU */
    public java.lang.Object mo2090trySendJP2dKIU(E element) {
        kotlinx.coroutines.channels.ChannelSegment channelSegmentFindSegmentSend;
        if (shouldSendSuspend(sendersAndCloseStatus$volatile$FU.get(this))) {
            return kotlinx.coroutines.channels.ChannelResult.INSTANCE.m2115failurePtdJZtk();
        }
        java.lang.Object obj = kotlinx.coroutines.channels.BufferedChannelKt.INTERRUPTED_SEND;
        kotlinx.coroutines.channels.ChannelSegment channelSegment = (kotlinx.coroutines.channels.ChannelSegment) sendSegment$volatile$FU.get(this);
        while (true) {
            long andIncrement = sendersAndCloseStatus$volatile$FU.getAndIncrement(this);
            long j = 1152921504606846975L & andIncrement;
            boolean zIsClosedForSend0 = isClosedForSend0(andIncrement);
            long j2 = j / ((long) kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE);
            int i = (int) (j % ((long) kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE));
            if (channelSegment.id != j2) {
                channelSegmentFindSegmentSend = findSegmentSend(j2, channelSegment);
                if (channelSegmentFindSegmentSend == null) {
                    if (zIsClosedForSend0) {
                        return kotlinx.coroutines.channels.ChannelResult.INSTANCE.m2114closedJP2dKIU(getSendException());
                    }
                }
            } else {
                channelSegmentFindSegmentSend = channelSegment;
            }
            E e = element;
            int iUpdateCellSend = updateCellSend(channelSegmentFindSegmentSend, i, e, j, obj, zIsClosedForSend0);
            channelSegment = channelSegmentFindSegmentSend;
            if (iUpdateCellSend == 0) {
                channelSegment.cleanPrev();
                return kotlinx.coroutines.channels.ChannelResult.INSTANCE.m2116successJP2dKIU(kotlin.Unit.INSTANCE);
            }
            if (iUpdateCellSend == 1) {
                return kotlinx.coroutines.channels.ChannelResult.INSTANCE.m2116successJP2dKIU(kotlin.Unit.INSTANCE);
            }
            if (iUpdateCellSend == 2) {
                if (zIsClosedForSend0) {
                    channelSegment.onSlotCleaned();
                    return kotlinx.coroutines.channels.ChannelResult.INSTANCE.m2114closedJP2dKIU(getSendException());
                }
                kotlinx.coroutines.Waiter waiter = obj instanceof kotlinx.coroutines.Waiter ? (kotlinx.coroutines.Waiter) obj : null;
                if (waiter != null) {
                    prepareSenderForSuspension(waiter, channelSegment, i);
                }
                channelSegment.onSlotCleaned();
                return kotlinx.coroutines.channels.ChannelResult.INSTANCE.m2115failurePtdJZtk();
            }
            if (iUpdateCellSend == 3) {
                throw new java.lang.IllegalStateException("unexpected".toString());
            }
            if (iUpdateCellSend == 4) {
                if (j < getReceiversCounter$kotlinx_coroutines_core()) {
                    channelSegment.cleanPrev();
                }
                return kotlinx.coroutines.channels.ChannelResult.INSTANCE.m2114closedJP2dKIU(getSendException());
            }
            if (iUpdateCellSend == 5) {
                channelSegment.cleanPrev();
            }
            element = e;
        }
    }

    /* JADX INFO: compiled from: BufferedChannel.kt */
    @kotlin.Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u001d\u0010\b\u001a\u00020\t2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\f\u001a\u00020\rH\u0096\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/channels/BufferedChannel$SendBroadcast;", "Lkotlinx/coroutines/Waiter;", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlinx/coroutines/CancellableContinuation;)V", "getCont", "()Lkotlinx/coroutines/CancellableContinuation;", "invokeOnCancellation", "", "segment", "Lkotlinx/coroutines/internal/Segment;", "index", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class SendBroadcast implements kotlinx.coroutines.Waiter {
        private final /* synthetic */ kotlinx.coroutines.CancellableContinuationImpl<java.lang.Boolean> $$delegate_0;
        private final kotlinx.coroutines.CancellableContinuation<java.lang.Boolean> cont;

        @Override // kotlinx.coroutines.Waiter
        public void invokeOnCancellation(kotlinx.coroutines.internal.Segment<?> segment, int index) {
            this.$$delegate_0.invokeOnCancellation(segment, index);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public SendBroadcast(kotlinx.coroutines.CancellableContinuation<? super java.lang.Boolean> cancellableContinuation) {
            this.cont = cancellableContinuation;
            kotlin.jvm.internal.Intrinsics.checkNotNull(cancellableContinuation, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuationImpl<kotlin.Boolean>");
            this.$$delegate_0 = (kotlinx.coroutines.CancellableContinuationImpl) cancellableContinuation;
        }

        public final kotlinx.coroutines.CancellableContinuation<java.lang.Boolean> getCont() {
            return this.cont;
        }
    }

    static /* synthetic */ java.lang.Object sendImpl$default(kotlinx.coroutines.channels.BufferedChannel bufferedChannel, java.lang.Object obj, java.lang.Object obj2, kotlin.jvm.functions.Function0 function0, kotlin.jvm.functions.Function2 function2, kotlin.jvm.functions.Function0 function1, kotlin.jvm.functions.Function4 function4, int i, java.lang.Object obj3) {
        if (obj3 != null) {
            throw new java.lang.UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendImpl");
        }
        kotlin.jvm.functions.Function4 function5 = (i & 32) != 0 ? new kotlin.jvm.functions.Function4() { // from class: kotlinx.coroutines.channels.BufferedChannel.sendImpl.1
            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object obj4, java.lang.Object obj5, java.lang.Object obj6, java.lang.Object obj7) {
                return invoke((kotlinx.coroutines.channels.ChannelSegment<java.lang.Object>) obj4, ((java.lang.Number) obj5).intValue(), obj6, ((java.lang.Number) obj7).longValue());
            }

            public final java.lang.Void invoke(kotlinx.coroutines.channels.ChannelSegment<E> channelSegment, int i2, E e, long j) {
                throw new java.lang.IllegalStateException("unexpected".toString());
            }
        } : function4;
        kotlinx.coroutines.channels.ChannelSegment channelSegment = (kotlinx.coroutines.channels.ChannelSegment) sendSegment$volatile$FU.get(bufferedChannel);
        while (true) {
            long andIncrement = sendersAndCloseStatus$volatile$FU.getAndIncrement(bufferedChannel);
            long j = 1152921504606846975L & andIncrement;
            boolean zIsClosedForSend0 = bufferedChannel.isClosedForSend0(andIncrement);
            long j2 = j / ((long) kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE);
            int i2 = (int) (j % ((long) kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE));
            if (channelSegment.id != j2) {
                kotlinx.coroutines.channels.ChannelSegment channelSegmentFindSegmentSend = bufferedChannel.findSegmentSend(j2, channelSegment);
                if (channelSegmentFindSegmentSend != null) {
                    channelSegment = channelSegmentFindSegmentSend;
                } else if (zIsClosedForSend0) {
                    return function1.invoke();
                }
            }
            int iUpdateCellSend = bufferedChannel.updateCellSend(channelSegment, i2, obj, j, obj2, zIsClosedForSend0);
            if (iUpdateCellSend == 0) {
                channelSegment.cleanPrev();
                return function0.invoke();
            }
            if (iUpdateCellSend == 1) {
                return function0.invoke();
            }
            if (iUpdateCellSend == 2) {
                if (zIsClosedForSend0) {
                    channelSegment.onSlotCleaned();
                    return function1.invoke();
                }
                kotlinx.coroutines.Waiter waiter = obj2 instanceof kotlinx.coroutines.Waiter ? (kotlinx.coroutines.Waiter) obj2 : null;
                if (waiter != null) {
                    bufferedChannel.prepareSenderForSuspension(waiter, channelSegment, i2);
                }
                return function2.invoke(channelSegment, java.lang.Integer.valueOf(i2));
            }
            if (iUpdateCellSend == 3) {
                return function5.invoke(channelSegment, java.lang.Integer.valueOf(i2), obj, java.lang.Long.valueOf(j));
            }
            if (iUpdateCellSend == 4) {
                if (j < bufferedChannel.getReceiversCounter$kotlinx_coroutines_core()) {
                    channelSegment.cleanPrev();
                }
                return function1.invoke();
            }
            if (iUpdateCellSend == 5) {
                channelSegment.cleanPrev();
            }
        }
    }

    private final <R> R sendImpl(E element, java.lang.Object waiter, kotlin.jvm.functions.Function0<? extends R> onRendezvousOrBuffered, kotlin.jvm.functions.Function2<? super kotlinx.coroutines.channels.ChannelSegment<E>, ? super java.lang.Integer, ? extends R> onSuspend, kotlin.jvm.functions.Function0<? extends R> onClosed, kotlin.jvm.functions.Function4<? super kotlinx.coroutines.channels.ChannelSegment<E>, ? super java.lang.Integer, ? super E, ? super java.lang.Long, ? extends R> onNoWaiterSuspend) {
        kotlinx.coroutines.channels.ChannelSegment channelSegment = (kotlinx.coroutines.channels.ChannelSegment) sendSegment$volatile$FU.get(this);
        while (true) {
            long andIncrement = sendersAndCloseStatus$volatile$FU.getAndIncrement(this);
            long j = 1152921504606846975L & andIncrement;
            boolean zIsClosedForSend0 = isClosedForSend0(andIncrement);
            long j2 = j / ((long) kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE);
            int i = (int) (j % ((long) kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE));
            if (channelSegment.id != j2) {
                kotlinx.coroutines.channels.ChannelSegment channelSegmentFindSegmentSend = findSegmentSend(j2, channelSegment);
                if (channelSegmentFindSegmentSend != null) {
                    channelSegment = channelSegmentFindSegmentSend;
                } else if (zIsClosedForSend0) {
                    return onClosed.invoke();
                }
            }
            int iUpdateCellSend = updateCellSend(channelSegment, i, element, j, waiter, zIsClosedForSend0);
            if (iUpdateCellSend == 0) {
                channelSegment.cleanPrev();
                return onRendezvousOrBuffered.invoke();
            }
            if (iUpdateCellSend == 1) {
                return onRendezvousOrBuffered.invoke();
            }
            if (iUpdateCellSend == 2) {
                if (zIsClosedForSend0) {
                    channelSegment.onSlotCleaned();
                    return onClosed.invoke();
                }
                kotlinx.coroutines.Waiter waiter2 = waiter instanceof kotlinx.coroutines.Waiter ? (kotlinx.coroutines.Waiter) waiter : null;
                if (waiter2 != null) {
                    prepareSenderForSuspension(waiter2, channelSegment, i);
                }
                return onSuspend.invoke(channelSegment, java.lang.Integer.valueOf(i));
            }
            if (iUpdateCellSend == 3) {
                return onNoWaiterSuspend.invoke(channelSegment, java.lang.Integer.valueOf(i), element, java.lang.Long.valueOf(j));
            }
            if (iUpdateCellSend == 4) {
                if (j < getReceiversCounter$kotlinx_coroutines_core()) {
                    channelSegment.cleanPrev();
                }
                return onClosed.invoke();
            }
            if (iUpdateCellSend == 5) {
                channelSegment.cleanPrev();
            }
        }
    }

    /* JADX INFO: renamed from: trySendDropOldest-JP2dKIU, reason: not valid java name */
    protected final java.lang.Object m2096trySendDropOldestJP2dKIU(E element) {
        kotlinx.coroutines.channels.ChannelSegment channelSegmentFindSegmentSend;
        java.lang.Object obj = kotlinx.coroutines.channels.BufferedChannelKt.BUFFERED;
        kotlinx.coroutines.channels.ChannelSegment channelSegment = (kotlinx.coroutines.channels.ChannelSegment) sendSegment$volatile$FU.get(this);
        while (true) {
            long andIncrement = sendersAndCloseStatus$volatile$FU.getAndIncrement(this);
            long j = 1152921504606846975L & andIncrement;
            boolean zIsClosedForSend0 = isClosedForSend0(andIncrement);
            long j2 = j / ((long) kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE);
            int i = (int) (j % ((long) kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE));
            if (channelSegment.id != j2) {
                channelSegmentFindSegmentSend = findSegmentSend(j2, channelSegment);
                if (channelSegmentFindSegmentSend == null) {
                    if (zIsClosedForSend0) {
                        return kotlinx.coroutines.channels.ChannelResult.INSTANCE.m2114closedJP2dKIU(getSendException());
                    }
                }
            } else {
                channelSegmentFindSegmentSend = channelSegment;
            }
            E e = element;
            int iUpdateCellSend = updateCellSend(channelSegmentFindSegmentSend, i, e, j, obj, zIsClosedForSend0);
            channelSegment = channelSegmentFindSegmentSend;
            if (iUpdateCellSend == 0) {
                channelSegment.cleanPrev();
                return kotlinx.coroutines.channels.ChannelResult.INSTANCE.m2116successJP2dKIU(kotlin.Unit.INSTANCE);
            }
            if (iUpdateCellSend == 1) {
                return kotlinx.coroutines.channels.ChannelResult.INSTANCE.m2116successJP2dKIU(kotlin.Unit.INSTANCE);
            }
            if (iUpdateCellSend == 2) {
                if (zIsClosedForSend0) {
                    channelSegment.onSlotCleaned();
                    return kotlinx.coroutines.channels.ChannelResult.INSTANCE.m2114closedJP2dKIU(getSendException());
                }
                kotlinx.coroutines.Waiter waiter = obj instanceof kotlinx.coroutines.Waiter ? (kotlinx.coroutines.Waiter) obj : null;
                if (waiter != null) {
                    prepareSenderForSuspension(waiter, channelSegment, i);
                }
                dropFirstElementUntilTheSpecifiedCellIsInTheBuffer((channelSegment.id * ((long) kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE)) + ((long) i));
                return kotlinx.coroutines.channels.ChannelResult.INSTANCE.m2116successJP2dKIU(kotlin.Unit.INSTANCE);
            }
            if (iUpdateCellSend == 3) {
                throw new java.lang.IllegalStateException("unexpected".toString());
            }
            if (iUpdateCellSend == 4) {
                if (j < getReceiversCounter$kotlinx_coroutines_core()) {
                    channelSegment.cleanPrev();
                }
                return kotlinx.coroutines.channels.ChannelResult.INSTANCE.m2114closedJP2dKIU(getSendException());
            }
            if (iUpdateCellSend == 5) {
                channelSegment.cleanPrev();
            }
            element = e;
        }
    }

    private final void sendImplOnNoWaiter(kotlinx.coroutines.channels.ChannelSegment<E> segment, int index, E element, long s, kotlinx.coroutines.Waiter waiter, kotlin.jvm.functions.Function0<kotlin.Unit> onRendezvousOrBuffered, kotlin.jvm.functions.Function0<kotlin.Unit> onClosed) {
        kotlin.Unit unitInvoke;
        int iUpdateCellSend = updateCellSend(segment, index, element, s, waiter, false);
        if (iUpdateCellSend == 0) {
            segment.cleanPrev();
            onRendezvousOrBuffered.invoke();
            return;
        }
        if (iUpdateCellSend == 1) {
            onRendezvousOrBuffered.invoke();
            return;
        }
        if (iUpdateCellSend == 2) {
            prepareSenderForSuspension(waiter, segment, index);
            return;
        }
        if (iUpdateCellSend == 4) {
            if (s < getReceiversCounter$kotlinx_coroutines_core()) {
                segment.cleanPrev();
            }
            onClosed.invoke();
            return;
        }
        if (iUpdateCellSend == 5) {
            segment.cleanPrev();
            kotlinx.coroutines.channels.ChannelSegment channelSegment = (kotlinx.coroutines.channels.ChannelSegment) sendSegment$volatile$FU.get(this);
            while (true) {
                long andIncrement = sendersAndCloseStatus$volatile$FU.getAndIncrement(this);
                long j = 1152921504606846975L & andIncrement;
                boolean zIsClosedForSend0 = isClosedForSend0(andIncrement);
                long j2 = j / ((long) kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE);
                int i = (int) (j % ((long) kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE));
                if (channelSegment.id != j2) {
                    kotlinx.coroutines.channels.ChannelSegment channelSegmentFindSegmentSend = findSegmentSend(j2, channelSegment);
                    if (channelSegmentFindSegmentSend != null) {
                        channelSegment = channelSegmentFindSegmentSend;
                    } else if (zIsClosedForSend0) {
                        unitInvoke = onClosed.invoke();
                        break;
                    }
                }
                int iUpdateCellSend2 = updateCellSend(channelSegment, i, element, j, waiter, zIsClosedForSend0);
                if (iUpdateCellSend2 == 0) {
                    channelSegment.cleanPrev();
                    unitInvoke = onRendezvousOrBuffered.invoke();
                    break;
                }
                if (iUpdateCellSend2 == 1) {
                    unitInvoke = onRendezvousOrBuffered.invoke();
                    break;
                }
                if (iUpdateCellSend2 == 2) {
                    if (zIsClosedForSend0) {
                        channelSegment.onSlotCleaned();
                        unitInvoke = onClosed.invoke();
                        break;
                    } else {
                        kotlinx.coroutines.Waiter waiter2 = waiter instanceof kotlinx.coroutines.Waiter ? waiter : null;
                        if (waiter2 != null) {
                            prepareSenderForSuspension(waiter2, channelSegment, i);
                        }
                        unitInvoke = kotlin.Unit.INSTANCE;
                        break;
                    }
                }
                if (iUpdateCellSend2 == 3) {
                    throw new java.lang.IllegalStateException("unexpected".toString());
                }
                if (iUpdateCellSend2 == 4) {
                    if (j < getReceiversCounter$kotlinx_coroutines_core()) {
                        channelSegment.cleanPrev();
                    }
                    unitInvoke = onClosed.invoke();
                    break;
                } else if (iUpdateCellSend2 == 5) {
                    channelSegment.cleanPrev();
                }
            }
            return;
        }
        throw new java.lang.IllegalStateException("unexpected".toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int updateCellSend(kotlinx.coroutines.channels.ChannelSegment<E> segment, int index, E element, long s, java.lang.Object waiter, boolean closed) {
        segment.storeElement$kotlinx_coroutines_core(index, element);
        if (closed) {
            return updateCellSendSlow(segment, index, element, s, waiter, closed);
        }
        java.lang.Object state$kotlinx_coroutines_core = segment.getState$kotlinx_coroutines_core(index);
        if (state$kotlinx_coroutines_core == null) {
            if (bufferOrRendezvousSend(s)) {
                if (segment.casState$kotlinx_coroutines_core(index, null, kotlinx.coroutines.channels.BufferedChannelKt.BUFFERED)) {
                    return 1;
                }
            } else {
                if (waiter == null) {
                    return 3;
                }
                if (segment.casState$kotlinx_coroutines_core(index, null, waiter)) {
                    return 2;
                }
            }
        } else if (state$kotlinx_coroutines_core instanceof kotlinx.coroutines.Waiter) {
            segment.cleanElement$kotlinx_coroutines_core(index);
            if (tryResumeReceiver(state$kotlinx_coroutines_core, element)) {
                segment.setState$kotlinx_coroutines_core(index, kotlinx.coroutines.channels.BufferedChannelKt.DONE_RCV);
                onReceiveDequeued();
                return 0;
            }
            if (segment.getAndSetState$kotlinx_coroutines_core(index, kotlinx.coroutines.channels.BufferedChannelKt.INTERRUPTED_RCV) == kotlinx.coroutines.channels.BufferedChannelKt.INTERRUPTED_RCV) {
                return 5;
            }
            segment.onCancelledRequest(index, true);
            return 5;
        }
        return updateCellSendSlow(segment, index, element, s, waiter, closed);
    }

    private final int updateCellSendSlow(kotlinx.coroutines.channels.ChannelSegment<E> segment, int index, E element, long s, java.lang.Object waiter, boolean closed) {
        while (true) {
            java.lang.Object state$kotlinx_coroutines_core = segment.getState$kotlinx_coroutines_core(index);
            if (state$kotlinx_coroutines_core != null) {
                if (state$kotlinx_coroutines_core != kotlinx.coroutines.channels.BufferedChannelKt.IN_BUFFER) {
                    if (state$kotlinx_coroutines_core != kotlinx.coroutines.channels.BufferedChannelKt.INTERRUPTED_RCV) {
                        if (state$kotlinx_coroutines_core == kotlinx.coroutines.channels.BufferedChannelKt.POISONED) {
                            segment.cleanElement$kotlinx_coroutines_core(index);
                            return 5;
                        }
                        if (state$kotlinx_coroutines_core == kotlinx.coroutines.channels.BufferedChannelKt.getCHANNEL_CLOSED()) {
                            segment.cleanElement$kotlinx_coroutines_core(index);
                            completeCloseOrCancel();
                            return 4;
                        }
                        if (kotlinx.coroutines.DebugKt.getASSERTIONS_ENABLED() && !(state$kotlinx_coroutines_core instanceof kotlinx.coroutines.Waiter) && !(state$kotlinx_coroutines_core instanceof kotlinx.coroutines.channels.WaiterEB)) {
                            throw new java.lang.AssertionError();
                        }
                        segment.cleanElement$kotlinx_coroutines_core(index);
                        if (state$kotlinx_coroutines_core instanceof kotlinx.coroutines.channels.WaiterEB) {
                            state$kotlinx_coroutines_core = ((kotlinx.coroutines.channels.WaiterEB) state$kotlinx_coroutines_core).waiter;
                        }
                        if (tryResumeReceiver(state$kotlinx_coroutines_core, element)) {
                            segment.setState$kotlinx_coroutines_core(index, kotlinx.coroutines.channels.BufferedChannelKt.DONE_RCV);
                            onReceiveDequeued();
                            return 0;
                        }
                        if (segment.getAndSetState$kotlinx_coroutines_core(index, kotlinx.coroutines.channels.BufferedChannelKt.INTERRUPTED_RCV) != kotlinx.coroutines.channels.BufferedChannelKt.INTERRUPTED_RCV) {
                            segment.onCancelledRequest(index, true);
                        }
                        return 5;
                    }
                    segment.cleanElement$kotlinx_coroutines_core(index);
                    return 5;
                }
                if (segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, kotlinx.coroutines.channels.BufferedChannelKt.BUFFERED)) {
                    return 1;
                }
            } else if (!bufferOrRendezvousSend(s) || closed) {
                if (closed) {
                    if (segment.casState$kotlinx_coroutines_core(index, null, kotlinx.coroutines.channels.BufferedChannelKt.INTERRUPTED_SEND)) {
                        segment.onCancelledRequest(index, false);
                        return 4;
                    }
                } else {
                    if (waiter == null) {
                        return 3;
                    }
                    if (segment.casState$kotlinx_coroutines_core(index, null, waiter)) {
                        return 2;
                    }
                }
            } else if (segment.casState$kotlinx_coroutines_core(index, null, kotlinx.coroutines.channels.BufferedChannelKt.BUFFERED)) {
                return 1;
            }
        }
    }

    private final boolean shouldSendSuspend(long curSendersAndCloseStatus) {
        if (isClosedForSend0(curSendersAndCloseStatus)) {
            return false;
        }
        return !bufferOrRendezvousSend(curSendersAndCloseStatus & 1152921504606846975L);
    }

    private final boolean bufferOrRendezvousSend(long curSenders) {
        return curSenders < getBufferEndCounter() || curSenders < getReceiversCounter$kotlinx_coroutines_core() + ((long) this.capacity);
    }

    public boolean shouldSendSuspend$kotlinx_coroutines_core() {
        return shouldSendSuspend(sendersAndCloseStatus$volatile$FU.get(this));
    }

    private final boolean tryResumeReceiver(java.lang.Object obj, E e) {
        if (obj instanceof kotlinx.coroutines.selects.SelectInstance) {
            return ((kotlinx.coroutines.selects.SelectInstance) obj).trySelect(this, e);
        }
        if (obj instanceof kotlinx.coroutines.channels.ReceiveCatching) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveCatching<E of kotlinx.coroutines.channels.BufferedChannel>");
            kotlinx.coroutines.channels.ReceiveCatching receiveCatching = (kotlinx.coroutines.channels.ReceiveCatching) obj;
            kotlinx.coroutines.CancellableContinuationImpl<kotlinx.coroutines.channels.ChannelResult<? extends E>> cancellableContinuationImpl = receiveCatching.cont;
            kotlinx.coroutines.channels.ChannelResult channelResultM2101boximpl = kotlinx.coroutines.channels.ChannelResult.m2101boximpl(kotlinx.coroutines.channels.ChannelResult.INSTANCE.m2116successJP2dKIU(e));
            kotlin.jvm.functions.Function1<E, kotlin.Unit> function1 = this.onUndeliveredElement;
            return kotlinx.coroutines.channels.BufferedChannelKt.tryResume0(cancellableContinuationImpl, channelResultM2101boximpl, function1 != null ? kotlinx.coroutines.internal.OnUndeliveredElementKt.bindCancellationFun(function1, e, receiveCatching.cont.getContext()) : null);
        }
        if (obj instanceof kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator<E of kotlinx.coroutines.channels.BufferedChannel>");
            return ((kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator) obj).tryResumeHasNext(e);
        }
        if (obj instanceof kotlinx.coroutines.CancellableContinuation) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<E of kotlinx.coroutines.channels.BufferedChannel>");
            kotlinx.coroutines.CancellableContinuation cancellableContinuation = (kotlinx.coroutines.CancellableContinuation) obj;
            kotlin.jvm.functions.Function1<E, kotlin.Unit> function2 = this.onUndeliveredElement;
            return kotlinx.coroutines.channels.BufferedChannelKt.tryResume0(cancellableContinuation, e, function2 != null ? kotlinx.coroutines.internal.OnUndeliveredElementKt.bindCancellationFun(function2, e, cancellableContinuation.getContext()) : null);
        }
        throw new java.lang.IllegalStateException(("Unexpected receiver type: " + obj).toString());
    }

    static /* synthetic */ <E> java.lang.Object receive$suspendImpl(kotlinx.coroutines.channels.BufferedChannel<E> bufferedChannel, kotlin.coroutines.Continuation<? super E> continuation) throws java.lang.Throwable {
        kotlinx.coroutines.channels.ChannelSegment<E> channelSegment;
        kotlinx.coroutines.channels.ChannelSegment<E> channelSegment2 = (kotlinx.coroutines.channels.ChannelSegment) getReceiveSegment$volatile$FU().get(bufferedChannel);
        while (!bufferedChannel.isClosedForReceive()) {
            long andIncrement = getReceivers$volatile$FU().getAndIncrement(bufferedChannel);
            long j = andIncrement / ((long) kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE);
            int i = (int) (andIncrement % ((long) kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE));
            if (channelSegment2.id != j) {
                kotlinx.coroutines.channels.ChannelSegment<E> channelSegmentFindSegmentReceive = bufferedChannel.findSegmentReceive(j, channelSegment2);
                if (channelSegmentFindSegmentReceive == null) {
                    continue;
                } else {
                    channelSegment = channelSegmentFindSegmentReceive;
                }
            } else {
                channelSegment = channelSegment2;
            }
            kotlinx.coroutines.channels.BufferedChannel<E> bufferedChannel2 = bufferedChannel;
            java.lang.Object objUpdateCellReceive = bufferedChannel2.updateCellReceive(channelSegment, i, andIncrement, null);
            if (objUpdateCellReceive != kotlinx.coroutines.channels.BufferedChannelKt.SUSPEND) {
                if (objUpdateCellReceive != kotlinx.coroutines.channels.BufferedChannelKt.FAILED) {
                    if (objUpdateCellReceive == kotlinx.coroutines.channels.BufferedChannelKt.SUSPEND_NO_WAITER) {
                        return bufferedChannel2.receiveOnNoWaiterSuspend(channelSegment, i, andIncrement, continuation);
                    }
                    channelSegment.cleanPrev();
                    return objUpdateCellReceive;
                }
                if (andIncrement < bufferedChannel2.getSendersCounter$kotlinx_coroutines_core()) {
                    channelSegment.cleanPrev();
                }
                bufferedChannel = bufferedChannel2;
                channelSegment2 = channelSegment;
            } else {
                throw new java.lang.IllegalStateException("unexpected".toString());
            }
        }
        throw kotlinx.coroutines.internal.StackTraceRecoveryKt.recoverStackTrace(bufferedChannel.getReceiveException());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void prepareReceiverForSuspension(kotlinx.coroutines.Waiter waiter, kotlinx.coroutines.channels.ChannelSegment<E> channelSegment, int i) {
        onReceiveEnqueued();
        waiter.invokeOnCancellation(channelSegment, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onClosedReceiveOnNoWaiterSuspend(kotlinx.coroutines.CancellableContinuation<? super E> cont) {
        kotlin.Result.Companion companion = kotlin.Result.INSTANCE;
        cont.resumeWith(kotlin.Result.m541constructorimpl(kotlin.ResultKt.createFailure(getReceiveException())));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: receiveCatching-JP2dKIU$suspendImpl, reason: not valid java name */
    static /* synthetic */ <E> java.lang.Object m2092receiveCatchingJP2dKIU$suspendImpl(kotlinx.coroutines.channels.BufferedChannel<E> bufferedChannel, kotlin.coroutines.Continuation<? super kotlinx.coroutines.channels.ChannelResult<? extends E>> continuation) throws java.lang.Throwable {
        kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1 bufferedChannel$receiveCatching$1;
        kotlinx.coroutines.channels.ChannelSegment<E> channelSegment;
        if (continuation instanceof kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1) {
            bufferedChannel$receiveCatching$1 = (kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1) continuation;
            if ((bufferedChannel$receiveCatching$1.label & Integer.MIN_VALUE) != 0) {
                bufferedChannel$receiveCatching$1.label -= Integer.MIN_VALUE;
            } else {
                bufferedChannel$receiveCatching$1 = new kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1(bufferedChannel, continuation);
            }
        } else {
            bufferedChannel$receiveCatching$1 = new kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1(bufferedChannel, continuation);
        }
        kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1 bufferedChannel$receiveCatching$2 = bufferedChannel$receiveCatching$1;
        java.lang.Object obj = bufferedChannel$receiveCatching$2.result;
        java.lang.Object coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = bufferedChannel$receiveCatching$2.label;
        if (i != 0) {
            if (i != 1) {
                throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.ResultKt.throwOnFailure(obj);
            return ((kotlinx.coroutines.channels.ChannelResult) obj).getHolder();
        }
        kotlin.ResultKt.throwOnFailure(obj);
        kotlinx.coroutines.channels.ChannelSegment<E> channelSegment2 = (kotlinx.coroutines.channels.ChannelSegment) getReceiveSegment$volatile$FU().get(bufferedChannel);
        while (!bufferedChannel.isClosedForReceive()) {
            long andIncrement = getReceivers$volatile$FU().getAndIncrement(bufferedChannel);
            long j = andIncrement / ((long) kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE);
            int i2 = (int) (andIncrement % ((long) kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE));
            if (channelSegment2.id != j) {
                kotlinx.coroutines.channels.ChannelSegment<E> channelSegmentFindSegmentReceive = bufferedChannel.findSegmentReceive(j, channelSegment2);
                if (channelSegmentFindSegmentReceive == null) {
                    continue;
                } else {
                    channelSegment = channelSegmentFindSegmentReceive;
                }
            } else {
                channelSegment = channelSegment2;
            }
            kotlinx.coroutines.channels.BufferedChannel<E> bufferedChannel2 = bufferedChannel;
            java.lang.Object objUpdateCellReceive = bufferedChannel2.updateCellReceive(channelSegment, i2, andIncrement, null);
            if (objUpdateCellReceive != kotlinx.coroutines.channels.BufferedChannelKt.SUSPEND) {
                if (objUpdateCellReceive != kotlinx.coroutines.channels.BufferedChannelKt.FAILED) {
                    if (objUpdateCellReceive == kotlinx.coroutines.channels.BufferedChannelKt.SUSPEND_NO_WAITER) {
                        bufferedChannel$receiveCatching$2.label = 1;
                        java.lang.Object objM2093receiveCatchingOnNoWaiterSuspendGKJJFZk = bufferedChannel2.m2093receiveCatchingOnNoWaiterSuspendGKJJFZk(channelSegment, i2, andIncrement, bufferedChannel$receiveCatching$2);
                        return objM2093receiveCatchingOnNoWaiterSuspendGKJJFZk == coroutine_suspended ? coroutine_suspended : objM2093receiveCatchingOnNoWaiterSuspendGKJJFZk;
                    }
                    channelSegment.cleanPrev();
                    return kotlinx.coroutines.channels.ChannelResult.INSTANCE.m2116successJP2dKIU(objUpdateCellReceive);
                }
                if (andIncrement < bufferedChannel2.getSendersCounter$kotlinx_coroutines_core()) {
                    channelSegment.cleanPrev();
                }
                bufferedChannel = bufferedChannel2;
                channelSegment2 = channelSegment;
            } else {
                throw new java.lang.IllegalStateException("unexpected".toString());
            }
        }
        return kotlinx.coroutines.channels.ChannelResult.INSTANCE.m2114closedJP2dKIU(bufferedChannel.getCloseCause());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: receiveCatchingOnNoWaiterSuspend-GKJJFZk, reason: not valid java name */
    public final java.lang.Object m2093receiveCatchingOnNoWaiterSuspendGKJJFZk(kotlinx.coroutines.channels.ChannelSegment<E> channelSegment, int i, long j, kotlin.coroutines.Continuation<? super kotlinx.coroutines.channels.ChannelResult<? extends E>> continuation) throws java.lang.Throwable {
        kotlinx.coroutines.channels.BufferedChannel$receiveCatchingOnNoWaiterSuspend$1 bufferedChannel$receiveCatchingOnNoWaiterSuspend$1;
        kotlinx.coroutines.channels.ChannelResult channelResultM2101boximpl;
        kotlin.jvm.functions.Function1<E, kotlin.Unit> function1;
        kotlin.coroutines.CoroutineContext context;
        kotlinx.coroutines.channels.ChannelSegment channelSegment2;
        if (continuation instanceof kotlinx.coroutines.channels.BufferedChannel$receiveCatchingOnNoWaiterSuspend$1) {
            bufferedChannel$receiveCatchingOnNoWaiterSuspend$1 = (kotlinx.coroutines.channels.BufferedChannel$receiveCatchingOnNoWaiterSuspend$1) continuation;
            if ((bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.label & Integer.MIN_VALUE) != 0) {
                bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.label -= Integer.MIN_VALUE;
            } else {
                bufferedChannel$receiveCatchingOnNoWaiterSuspend$1 = new kotlinx.coroutines.channels.BufferedChannel$receiveCatchingOnNoWaiterSuspend$1(this, continuation);
            }
        } else {
            bufferedChannel$receiveCatchingOnNoWaiterSuspend$1 = new kotlinx.coroutines.channels.BufferedChannel$receiveCatchingOnNoWaiterSuspend$1(this, continuation);
        }
        java.lang.Object result = bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.result;
        java.lang.Object coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.label;
        if (i2 == 0) {
            kotlin.ResultKt.throwOnFailure(result);
            bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.L$0 = this;
            bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.L$1 = channelSegment;
            bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.I$0 = i;
            bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.J$0 = j;
            bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.label = 1;
            kotlinx.coroutines.channels.BufferedChannel$receiveCatchingOnNoWaiterSuspend$1 bufferedChannel$receiveCatchingOnNoWaiterSuspend$2 = bufferedChannel$receiveCatchingOnNoWaiterSuspend$1;
            kotlinx.coroutines.CancellableContinuationImpl orCreateCancellableContinuation = kotlinx.coroutines.CancellableContinuationKt.getOrCreateCancellableContinuation(kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(bufferedChannel$receiveCatchingOnNoWaiterSuspend$2));
            try {
                kotlin.jvm.internal.Intrinsics.checkNotNull(orCreateCancellableContinuation, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuationImpl<kotlinx.coroutines.channels.ChannelResult<E of kotlinx.coroutines.channels.BufferedChannel.receiveCatchingOnNoWaiterSuspend_GKJJFZk$lambda$38>>");
                kotlinx.coroutines.channels.ReceiveCatching receiveCatching = new kotlinx.coroutines.channels.ReceiveCatching(orCreateCancellableContinuation);
                try {
                    java.lang.Object objUpdateCellReceive = updateCellReceive(channelSegment, i, j, receiveCatching);
                    try {
                        if (objUpdateCellReceive != kotlinx.coroutines.channels.BufferedChannelKt.SUSPEND) {
                            kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit> function1BindCancellationFun = null;
                            function1BindCancellationFun = null;
                            if (objUpdateCellReceive == kotlinx.coroutines.channels.BufferedChannelKt.FAILED) {
                                if (j < getSendersCounter$kotlinx_coroutines_core()) {
                                    channelSegment.cleanPrev();
                                }
                                kotlinx.coroutines.channels.ChannelSegment channelSegment3 = (kotlinx.coroutines.channels.ChannelSegment) getReceiveSegment$volatile$FU().get(this);
                                while (true) {
                                    if (isClosedForReceive()) {
                                        onClosedReceiveCatchingOnNoWaiterSuspend(orCreateCancellableContinuation);
                                    } else {
                                        long andIncrement = getReceivers$volatile$FU().getAndIncrement(this);
                                        long j2 = andIncrement / ((long) kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE);
                                        int i3 = (int) (andIncrement % ((long) kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE));
                                        if (channelSegment3.id != j2) {
                                            kotlinx.coroutines.channels.ChannelSegment channelSegmentFindSegmentReceive = findSegmentReceive(j2, channelSegment3);
                                            if (channelSegmentFindSegmentReceive != null) {
                                                channelSegment2 = channelSegmentFindSegmentReceive;
                                            }
                                        } else {
                                            channelSegment2 = channelSegment3;
                                        }
                                        objUpdateCellReceive = updateCellReceive(channelSegment2, i3, andIncrement, receiveCatching);
                                        if (objUpdateCellReceive != kotlinx.coroutines.channels.BufferedChannelKt.SUSPEND) {
                                            if (objUpdateCellReceive == kotlinx.coroutines.channels.BufferedChannelKt.FAILED) {
                                                if (andIncrement < getSendersCounter$kotlinx_coroutines_core()) {
                                                    channelSegment2.cleanPrev();
                                                }
                                                channelSegment3 = channelSegment2;
                                            } else {
                                                if (objUpdateCellReceive == kotlinx.coroutines.channels.BufferedChannelKt.SUSPEND_NO_WAITER) {
                                                    throw new java.lang.IllegalStateException("unexpected".toString());
                                                }
                                                channelSegment2.cleanPrev();
                                                channelResultM2101boximpl = kotlinx.coroutines.channels.ChannelResult.m2101boximpl(kotlinx.coroutines.channels.ChannelResult.INSTANCE.m2116successJP2dKIU(objUpdateCellReceive));
                                                function1 = this.onUndeliveredElement;
                                                if (function1 != null) {
                                                    context = orCreateCancellableContinuation.getContext();
                                                    function1BindCancellationFun = kotlinx.coroutines.internal.OnUndeliveredElementKt.bindCancellationFun(function1, objUpdateCellReceive, context);
                                                }
                                                orCreateCancellableContinuation.resume(channelResultM2101boximpl, function1BindCancellationFun);
                                            }
                                        } else {
                                            kotlinx.coroutines.channels.ReceiveCatching receiveCatching2 = receiveCatching instanceof kotlinx.coroutines.Waiter ? receiveCatching : null;
                                            if (receiveCatching2 != null) {
                                                prepareReceiverForSuspension(receiveCatching2, channelSegment2, i3);
                                            }
                                        }
                                    }
                                }
                            } else {
                                channelSegment.cleanPrev();
                                channelResultM2101boximpl = kotlinx.coroutines.channels.ChannelResult.m2101boximpl(kotlinx.coroutines.channels.ChannelResult.INSTANCE.m2116successJP2dKIU(objUpdateCellReceive));
                                function1 = this.onUndeliveredElement;
                                if (function1 != null) {
                                    context = orCreateCancellableContinuation.getContext();
                                    function1BindCancellationFun = kotlinx.coroutines.internal.OnUndeliveredElementKt.bindCancellationFun(function1, objUpdateCellReceive, context);
                                }
                                orCreateCancellableContinuation.resume(channelResultM2101boximpl, function1BindCancellationFun);
                            }
                        } else {
                            prepareReceiverForSuspension(receiveCatching, channelSegment, i);
                        }
                        result = orCreateCancellableContinuation.getResult();
                        if (result == kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(bufferedChannel$receiveCatchingOnNoWaiterSuspend$2);
                        }
                        if (result == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } catch (java.lang.Throwable th) {
                        th = th;
                        java.lang.Throwable th2 = th;
                        orCreateCancellableContinuation.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
                        throw th2;
                    }
                } catch (java.lang.Throwable th3) {
                    th = th3;
                }
            } catch (java.lang.Throwable th4) {
                th = th4;
            }
        } else {
            if (i2 != 1) {
                throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            long j3 = bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.J$0;
            int i4 = bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.I$0;
            kotlin.ResultKt.throwOnFailure(result);
        }
        return ((kotlinx.coroutines.channels.ChannelResult) result).getHolder();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onClosedReceiveCatchingOnNoWaiterSuspend(kotlinx.coroutines.CancellableContinuation<? super kotlinx.coroutines.channels.ChannelResult<? extends E>> cont) {
        kotlin.Result.Companion companion = kotlin.Result.INSTANCE;
        cont.resumeWith(kotlin.Result.m541constructorimpl(kotlinx.coroutines.channels.ChannelResult.m2101boximpl(kotlinx.coroutines.channels.ChannelResult.INSTANCE.m2114closedJP2dKIU(getCloseCause()))));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /* JADX INFO: renamed from: tryReceive-PtdJZtk, reason: not valid java name */
    public java.lang.Object mo2095tryReceivePtdJZtk() {
        kotlinx.coroutines.channels.ChannelSegment channelSegment;
        long j = receivers$volatile$FU.get(this);
        long j2 = sendersAndCloseStatus$volatile$FU.get(this);
        if (isClosedForReceive0(j2)) {
            return kotlinx.coroutines.channels.ChannelResult.INSTANCE.m2114closedJP2dKIU(getCloseCause());
        }
        if (j < (j2 & 1152921504606846975L)) {
            java.lang.Object obj = kotlinx.coroutines.channels.BufferedChannelKt.INTERRUPTED_RCV;
            kotlinx.coroutines.channels.ChannelSegment channelSegment2 = (kotlinx.coroutines.channels.ChannelSegment) getReceiveSegment$volatile$FU().get(this);
            while (!isClosedForReceive()) {
                long andIncrement = getReceivers$volatile$FU().getAndIncrement(this);
                long j3 = andIncrement / ((long) kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE);
                int i = (int) (andIncrement % ((long) kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE));
                if (channelSegment2.id != j3) {
                    kotlinx.coroutines.channels.ChannelSegment channelSegmentFindSegmentReceive = findSegmentReceive(j3, channelSegment2);
                    if (channelSegmentFindSegmentReceive == null) {
                        continue;
                    } else {
                        channelSegment = channelSegmentFindSegmentReceive;
                    }
                } else {
                    channelSegment = channelSegment2;
                }
                java.lang.Object objUpdateCellReceive = updateCellReceive(channelSegment, i, andIncrement, obj);
                kotlinx.coroutines.channels.ChannelSegment channelSegment3 = channelSegment;
                if (objUpdateCellReceive != kotlinx.coroutines.channels.BufferedChannelKt.SUSPEND) {
                    if (objUpdateCellReceive != kotlinx.coroutines.channels.BufferedChannelKt.FAILED) {
                        if (objUpdateCellReceive == kotlinx.coroutines.channels.BufferedChannelKt.SUSPEND_NO_WAITER) {
                            throw new java.lang.IllegalStateException("unexpected".toString());
                        }
                        channelSegment3.cleanPrev();
                        return kotlinx.coroutines.channels.ChannelResult.INSTANCE.m2116successJP2dKIU(objUpdateCellReceive);
                    }
                    if (andIncrement < getSendersCounter$kotlinx_coroutines_core()) {
                        channelSegment3.cleanPrev();
                    }
                    channelSegment2 = channelSegment3;
                } else {
                    kotlinx.coroutines.Waiter waiter = obj instanceof kotlinx.coroutines.Waiter ? (kotlinx.coroutines.Waiter) obj : null;
                    if (waiter != null) {
                        prepareReceiverForSuspension(waiter, channelSegment3, i);
                    }
                    waitExpandBufferCompletion$kotlinx_coroutines_core(andIncrement);
                    channelSegment3.onSlotCleaned();
                    return kotlinx.coroutines.channels.ChannelResult.INSTANCE.m2115failurePtdJZtk();
                }
            }
            return kotlinx.coroutines.channels.ChannelResult.INSTANCE.m2114closedJP2dKIU(getCloseCause());
        }
        return kotlinx.coroutines.channels.ChannelResult.INSTANCE.m2115failurePtdJZtk();
    }

    protected final void dropFirstElementUntilTheSpecifiedCellIsInTheBuffer(long globalCellIndex) {
        kotlinx.coroutines.channels.ChannelSegment<E> channelSegmentFindSegmentReceive;
        kotlinx.coroutines.internal.UndeliveredElementException undeliveredElementExceptionCallUndeliveredElementCatchingException$default;
        if (kotlinx.coroutines.DebugKt.getASSERTIONS_ENABLED() && !isConflatedDropOldest()) {
            throw new java.lang.AssertionError();
        }
        kotlinx.coroutines.channels.ChannelSegment<E> channelSegment = (kotlinx.coroutines.channels.ChannelSegment) receiveSegment$volatile$FU.get(this);
        while (true) {
            long j = receivers$volatile$FU.get(this);
            if (globalCellIndex < java.lang.Math.max(((long) this.capacity) + j, getBufferEndCounter())) {
                return;
            }
            if (receivers$volatile$FU.compareAndSet(this, j, 1 + j)) {
                long j2 = j / ((long) kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE);
                int i = (int) (j % ((long) kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE));
                if (channelSegment.id != j2) {
                    channelSegmentFindSegmentReceive = findSegmentReceive(j2, channelSegment);
                    if (channelSegmentFindSegmentReceive == null) {
                        continue;
                    }
                } else {
                    channelSegmentFindSegmentReceive = channelSegment;
                }
                java.lang.Object objUpdateCellReceive = updateCellReceive(channelSegmentFindSegmentReceive, i, j, null);
                if (objUpdateCellReceive != kotlinx.coroutines.channels.BufferedChannelKt.FAILED) {
                    channelSegmentFindSegmentReceive.cleanPrev();
                    kotlin.jvm.functions.Function1<E, kotlin.Unit> function1 = this.onUndeliveredElement;
                    if (function1 != null && (undeliveredElementExceptionCallUndeliveredElementCatchingException$default = kotlinx.coroutines.internal.OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(function1, objUpdateCellReceive, null, 2, null)) != null) {
                        throw undeliveredElementExceptionCallUndeliveredElementCatchingException$default;
                    }
                } else if (j < getSendersCounter$kotlinx_coroutines_core()) {
                    channelSegmentFindSegmentReceive.cleanPrev();
                }
                channelSegment = channelSegmentFindSegmentReceive;
            }
        }
    }

    static /* synthetic */ java.lang.Object receiveImpl$default(kotlinx.coroutines.channels.BufferedChannel bufferedChannel, java.lang.Object obj, kotlin.jvm.functions.Function1 function1, kotlin.jvm.functions.Function3 function3, kotlin.jvm.functions.Function0 function0, kotlin.jvm.functions.Function3 function4, int i, java.lang.Object obj2) {
        kotlinx.coroutines.channels.ChannelSegment channelSegment;
        if (obj2 != null) {
            throw new java.lang.UnsupportedOperationException("Super calls with default arguments not supported in this target, function: receiveImpl");
        }
        if ((i & 16) != 0) {
            function4 = new kotlin.jvm.functions.Function3() { // from class: kotlinx.coroutines.channels.BufferedChannel.receiveImpl.1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object obj3, java.lang.Object obj4, java.lang.Object obj5) {
                    return invoke((kotlinx.coroutines.channels.ChannelSegment) obj3, ((java.lang.Number) obj4).intValue(), ((java.lang.Number) obj5).longValue());
                }

                public final java.lang.Void invoke(kotlinx.coroutines.channels.ChannelSegment<E> channelSegment2, int i2, long j) {
                    throw new java.lang.IllegalStateException("unexpected".toString());
                }
            };
        }
        kotlinx.coroutines.channels.ChannelSegment channelSegment2 = (kotlinx.coroutines.channels.ChannelSegment) getReceiveSegment$volatile$FU().get(bufferedChannel);
        while (!bufferedChannel.isClosedForReceive()) {
            long andIncrement = getReceivers$volatile$FU().getAndIncrement(bufferedChannel);
            long j = andIncrement / ((long) kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE);
            int i2 = (int) (andIncrement % ((long) kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE));
            if (channelSegment2.id != j) {
                kotlinx.coroutines.channels.ChannelSegment channelSegmentFindSegmentReceive = bufferedChannel.findSegmentReceive(j, channelSegment2);
                if (channelSegmentFindSegmentReceive == null) {
                    continue;
                } else {
                    channelSegment = channelSegmentFindSegmentReceive;
                }
            } else {
                channelSegment = channelSegment2;
            }
            kotlinx.coroutines.channels.BufferedChannel bufferedChannel2 = bufferedChannel;
            java.lang.Object obj3 = obj;
            java.lang.Object objUpdateCellReceive = bufferedChannel2.updateCellReceive(channelSegment, i2, andIncrement, obj3);
            channelSegment2 = channelSegment;
            if (objUpdateCellReceive != kotlinx.coroutines.channels.BufferedChannelKt.SUSPEND) {
                if (objUpdateCellReceive != kotlinx.coroutines.channels.BufferedChannelKt.FAILED) {
                    if (objUpdateCellReceive == kotlinx.coroutines.channels.BufferedChannelKt.SUSPEND_NO_WAITER) {
                        return function4.invoke(channelSegment2, java.lang.Integer.valueOf(i2), java.lang.Long.valueOf(andIncrement));
                    }
                    channelSegment2.cleanPrev();
                    return function1.invoke2(objUpdateCellReceive);
                }
                if (andIncrement < bufferedChannel2.getSendersCounter$kotlinx_coroutines_core()) {
                    channelSegment2.cleanPrev();
                }
                bufferedChannel = bufferedChannel2;
                obj = obj3;
            } else {
                kotlinx.coroutines.Waiter waiter = obj3 instanceof kotlinx.coroutines.Waiter ? (kotlinx.coroutines.Waiter) obj3 : null;
                if (waiter != null) {
                    bufferedChannel2.prepareReceiverForSuspension(waiter, channelSegment2, i2);
                }
                return function3.invoke(channelSegment2, java.lang.Integer.valueOf(i2), java.lang.Long.valueOf(andIncrement));
            }
        }
        return function0.invoke();
    }

    private final <R> R receiveImpl(java.lang.Object waiter, kotlin.jvm.functions.Function1<? super E, ? extends R> onElementRetrieved, kotlin.jvm.functions.Function3<? super kotlinx.coroutines.channels.ChannelSegment<E>, ? super java.lang.Integer, ? super java.lang.Long, ? extends R> onSuspend, kotlin.jvm.functions.Function0<? extends R> onClosed, kotlin.jvm.functions.Function3<? super kotlinx.coroutines.channels.ChannelSegment<E>, ? super java.lang.Integer, ? super java.lang.Long, ? extends R> onNoWaiterSuspend) {
        kotlinx.coroutines.channels.ChannelSegment channelSegment;
        kotlinx.coroutines.channels.ChannelSegment channelSegment2 = (kotlinx.coroutines.channels.ChannelSegment) getReceiveSegment$volatile$FU().get(this);
        while (!isClosedForReceive()) {
            long andIncrement = getReceivers$volatile$FU().getAndIncrement(this);
            long j = andIncrement / ((long) kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE);
            int i = (int) (andIncrement % ((long) kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE));
            if (channelSegment2.id != j) {
                kotlinx.coroutines.channels.ChannelSegment channelSegmentFindSegmentReceive = findSegmentReceive(j, channelSegment2);
                if (channelSegmentFindSegmentReceive == null) {
                    continue;
                } else {
                    channelSegment = channelSegmentFindSegmentReceive;
                }
            } else {
                channelSegment = channelSegment2;
            }
            java.lang.Object obj = waiter;
            kotlinx.coroutines.internal.Symbol symbol = (java.lang.Object) updateCellReceive(channelSegment, i, andIncrement, obj);
            channelSegment2 = channelSegment;
            if (symbol != kotlinx.coroutines.channels.BufferedChannelKt.SUSPEND) {
                if (symbol != kotlinx.coroutines.channels.BufferedChannelKt.FAILED) {
                    if (symbol == kotlinx.coroutines.channels.BufferedChannelKt.SUSPEND_NO_WAITER) {
                        return onNoWaiterSuspend.invoke(channelSegment2, java.lang.Integer.valueOf(i), java.lang.Long.valueOf(andIncrement));
                    }
                    channelSegment2.cleanPrev();
                    return onElementRetrieved.invoke2(symbol);
                }
                if (andIncrement < getSendersCounter$kotlinx_coroutines_core()) {
                    channelSegment2.cleanPrev();
                }
                waiter = obj;
            } else {
                kotlinx.coroutines.Waiter waiter2 = obj instanceof kotlinx.coroutines.Waiter ? (kotlinx.coroutines.Waiter) obj : null;
                if (waiter2 != null) {
                    prepareReceiverForSuspension(waiter2, channelSegment2, i);
                }
                return onSuspend.invoke(channelSegment2, java.lang.Integer.valueOf(i), java.lang.Long.valueOf(andIncrement));
            }
        }
        return onClosed.invoke();
    }

    private final void receiveImplOnNoWaiter(kotlinx.coroutines.channels.ChannelSegment<E> segment, int index, long r, kotlinx.coroutines.Waiter waiter, kotlin.jvm.functions.Function1<? super E, kotlin.Unit> onElementRetrieved, kotlin.jvm.functions.Function0<kotlin.Unit> onClosed) {
        kotlinx.coroutines.channels.ChannelSegment channelSegment;
        kotlinx.coroutines.Waiter waiter2;
        kotlinx.coroutines.internal.Symbol symbol = (java.lang.Object) updateCellReceive(segment, index, r, waiter);
        kotlinx.coroutines.channels.BufferedChannel<E> bufferedChannel = this;
        if (symbol != kotlinx.coroutines.channels.BufferedChannelKt.SUSPEND) {
            if (symbol != kotlinx.coroutines.channels.BufferedChannelKt.FAILED) {
                segment.cleanPrev();
                onElementRetrieved.invoke2(symbol);
                return;
            }
            if (r < getSendersCounter$kotlinx_coroutines_core()) {
                segment.cleanPrev();
            }
            kotlinx.coroutines.channels.ChannelSegment channelSegment2 = (kotlinx.coroutines.channels.ChannelSegment) getReceiveSegment$volatile$FU().get(this);
            while (!isClosedForReceive()) {
                long andIncrement = getReceivers$volatile$FU().getAndIncrement(this);
                long j = andIncrement / ((long) kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE);
                int i = (int) (andIncrement % ((long) kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE));
                if (channelSegment2.id != j) {
                    kotlinx.coroutines.channels.ChannelSegment channelSegmentFindSegmentReceive = findSegmentReceive(j, channelSegment2);
                    if (channelSegmentFindSegmentReceive == null) {
                        continue;
                    } else {
                        channelSegment = channelSegmentFindSegmentReceive;
                    }
                } else {
                    channelSegment = channelSegment2;
                }
                kotlinx.coroutines.channels.BufferedChannel<E> bufferedChannel2 = bufferedChannel;
                kotlinx.coroutines.internal.Symbol symbol2 = (java.lang.Object) bufferedChannel2.updateCellReceive(channelSegment, i, andIncrement, waiter);
                channelSegment2 = channelSegment;
                if (symbol2 != kotlinx.coroutines.channels.BufferedChannelKt.SUSPEND) {
                    if (symbol2 != kotlinx.coroutines.channels.BufferedChannelKt.FAILED) {
                        if (symbol2 == kotlinx.coroutines.channels.BufferedChannelKt.SUSPEND_NO_WAITER) {
                            throw new java.lang.IllegalStateException("unexpected".toString());
                        }
                        channelSegment2.cleanPrev();
                        onElementRetrieved.invoke2(symbol2);
                        return;
                    }
                    if (andIncrement < getSendersCounter$kotlinx_coroutines_core()) {
                        channelSegment2.cleanPrev();
                    }
                    bufferedChannel = bufferedChannel2;
                } else {
                    if (!(waiter instanceof kotlinx.coroutines.Waiter)) {
                        waiter2 = null;
                    }
                    if (waiter2 != null) {
                        waiter2 = waiter;
                        prepareReceiverForSuspension(waiter2, channelSegment2, i);
                    }
                    waiter2 = waiter;
                    kotlin.Unit unit = kotlin.Unit.INSTANCE;
                    return;
                }
            }
            onClosed.invoke();
            return;
        }
        prepareReceiverForSuspension(waiter, segment, index);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final java.lang.Object updateCellReceive(kotlinx.coroutines.channels.ChannelSegment<E> segment, int index, long r, java.lang.Object waiter) {
        java.lang.Object state$kotlinx_coroutines_core = segment.getState$kotlinx_coroutines_core(index);
        if (state$kotlinx_coroutines_core == null) {
            if (r >= (sendersAndCloseStatus$volatile$FU.get(this) & 1152921504606846975L)) {
                if (waiter == null) {
                    return kotlinx.coroutines.channels.BufferedChannelKt.SUSPEND_NO_WAITER;
                }
                if (segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, waiter)) {
                    expandBuffer();
                    return kotlinx.coroutines.channels.BufferedChannelKt.SUSPEND;
                }
            }
        } else if (state$kotlinx_coroutines_core == kotlinx.coroutines.channels.BufferedChannelKt.BUFFERED && segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, kotlinx.coroutines.channels.BufferedChannelKt.DONE_RCV)) {
            expandBuffer();
            return segment.retrieveElement$kotlinx_coroutines_core(index);
        }
        return updateCellReceiveSlow(segment, index, r, waiter);
    }

    private final java.lang.Object updateCellReceiveSlow(kotlinx.coroutines.channels.ChannelSegment<E> segment, int index, long r, java.lang.Object waiter) {
        while (true) {
            java.lang.Object state$kotlinx_coroutines_core = segment.getState$kotlinx_coroutines_core(index);
            if (state$kotlinx_coroutines_core == null || state$kotlinx_coroutines_core == kotlinx.coroutines.channels.BufferedChannelKt.IN_BUFFER) {
                if (r < (sendersAndCloseStatus$volatile$FU.get(this) & 1152921504606846975L)) {
                    if (segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, kotlinx.coroutines.channels.BufferedChannelKt.POISONED)) {
                        expandBuffer();
                        return kotlinx.coroutines.channels.BufferedChannelKt.FAILED;
                    }
                } else {
                    if (waiter == null) {
                        return kotlinx.coroutines.channels.BufferedChannelKt.SUSPEND_NO_WAITER;
                    }
                    if (segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, waiter)) {
                        expandBuffer();
                        return kotlinx.coroutines.channels.BufferedChannelKt.SUSPEND;
                    }
                }
            } else if (state$kotlinx_coroutines_core == kotlinx.coroutines.channels.BufferedChannelKt.BUFFERED) {
                if (segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, kotlinx.coroutines.channels.BufferedChannelKt.DONE_RCV)) {
                    expandBuffer();
                    return segment.retrieveElement$kotlinx_coroutines_core(index);
                }
            } else {
                if (state$kotlinx_coroutines_core != kotlinx.coroutines.channels.BufferedChannelKt.INTERRUPTED_SEND && state$kotlinx_coroutines_core != kotlinx.coroutines.channels.BufferedChannelKt.POISONED) {
                    if (state$kotlinx_coroutines_core != kotlinx.coroutines.channels.BufferedChannelKt.getCHANNEL_CLOSED()) {
                        if (state$kotlinx_coroutines_core != kotlinx.coroutines.channels.BufferedChannelKt.RESUMING_BY_EB && segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, kotlinx.coroutines.channels.BufferedChannelKt.RESUMING_BY_RCV)) {
                            boolean z = state$kotlinx_coroutines_core instanceof kotlinx.coroutines.channels.WaiterEB;
                            if (z) {
                                state$kotlinx_coroutines_core = ((kotlinx.coroutines.channels.WaiterEB) state$kotlinx_coroutines_core).waiter;
                            }
                            if (tryResumeSender(state$kotlinx_coroutines_core, segment, index)) {
                                segment.setState$kotlinx_coroutines_core(index, kotlinx.coroutines.channels.BufferedChannelKt.DONE_RCV);
                                expandBuffer();
                                return segment.retrieveElement$kotlinx_coroutines_core(index);
                            }
                            segment.setState$kotlinx_coroutines_core(index, kotlinx.coroutines.channels.BufferedChannelKt.INTERRUPTED_SEND);
                            segment.onCancelledRequest(index, false);
                            if (z) {
                                expandBuffer();
                            }
                            return kotlinx.coroutines.channels.BufferedChannelKt.FAILED;
                        }
                    } else {
                        expandBuffer();
                        return kotlinx.coroutines.channels.BufferedChannelKt.FAILED;
                    }
                }
                return kotlinx.coroutines.channels.BufferedChannelKt.FAILED;
            }
        }
    }

    private final boolean tryResumeSender(java.lang.Object obj, kotlinx.coroutines.channels.ChannelSegment<E> channelSegment, int i) {
        if (obj instanceof kotlinx.coroutines.CancellableContinuation) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            return kotlinx.coroutines.channels.BufferedChannelKt.tryResume0$default((kotlinx.coroutines.CancellableContinuation) obj, kotlin.Unit.INSTANCE, null, 2, null);
        }
        if (obj instanceof kotlinx.coroutines.selects.SelectInstance) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
            kotlinx.coroutines.selects.TrySelectDetailedResult trySelectDetailedResultTrySelectDetailed = ((kotlinx.coroutines.selects.SelectImplementation) obj).trySelectDetailed(this, kotlin.Unit.INSTANCE);
            if (trySelectDetailedResultTrySelectDetailed == kotlinx.coroutines.selects.TrySelectDetailedResult.REREGISTER) {
                channelSegment.cleanElement$kotlinx_coroutines_core(i);
            }
            return trySelectDetailedResultTrySelectDetailed == kotlinx.coroutines.selects.TrySelectDetailedResult.SUCCESSFUL;
        }
        if (obj instanceof kotlinx.coroutines.channels.BufferedChannel.SendBroadcast) {
            return kotlinx.coroutines.channels.BufferedChannelKt.tryResume0$default(((kotlinx.coroutines.channels.BufferedChannel.SendBroadcast) obj).getCont(), true, null, 2, null);
        }
        throw new java.lang.IllegalStateException(("Unexpected waiter: " + obj).toString());
    }

    private final void expandBuffer() {
        if (isRendezvousOrUnlimited()) {
            return;
        }
        kotlinx.coroutines.channels.ChannelSegment<E> channelSegment = (kotlinx.coroutines.channels.ChannelSegment) bufferEndSegment$volatile$FU.get(this);
        while (true) {
            long andIncrement = bufferEnd$volatile$FU.getAndIncrement(this);
            long j = andIncrement / ((long) kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE);
            if (getSendersCounter$kotlinx_coroutines_core() <= andIncrement) {
                if (channelSegment.id < j && channelSegment.getNext() != 0) {
                    moveSegmentBufferEndToSpecifiedOrLast(j, channelSegment);
                }
                incCompletedExpandBufferAttempts$default(this, 0L, 1, null);
                return;
            }
            if (channelSegment.id != j) {
                kotlinx.coroutines.channels.ChannelSegment<E> channelSegmentFindSegmentBufferEnd = findSegmentBufferEnd(j, channelSegment, andIncrement);
                if (channelSegmentFindSegmentBufferEnd == null) {
                    continue;
                } else {
                    channelSegment = channelSegmentFindSegmentBufferEnd;
                }
            }
            if (updateCellExpandBuffer(channelSegment, (int) (andIncrement % ((long) kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE)), andIncrement)) {
                incCompletedExpandBufferAttempts$default(this, 0L, 1, null);
                return;
            }
            incCompletedExpandBufferAttempts$default(this, 0L, 1, null);
        }
    }

    private final boolean updateCellExpandBuffer(kotlinx.coroutines.channels.ChannelSegment<E> segment, int index, long b) {
        java.lang.Object state$kotlinx_coroutines_core = segment.getState$kotlinx_coroutines_core(index);
        if ((state$kotlinx_coroutines_core instanceof kotlinx.coroutines.Waiter) && b >= receivers$volatile$FU.get(this) && segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, kotlinx.coroutines.channels.BufferedChannelKt.RESUMING_BY_EB)) {
            if (!tryResumeSender(state$kotlinx_coroutines_core, segment, index)) {
                segment.setState$kotlinx_coroutines_core(index, kotlinx.coroutines.channels.BufferedChannelKt.INTERRUPTED_SEND);
                segment.onCancelledRequest(index, false);
                return false;
            }
            segment.setState$kotlinx_coroutines_core(index, kotlinx.coroutines.channels.BufferedChannelKt.BUFFERED);
            return true;
        }
        return updateCellExpandBufferSlow(segment, index, b);
    }

    private final boolean updateCellExpandBufferSlow(kotlinx.coroutines.channels.ChannelSegment<E> segment, int index, long b) {
        while (true) {
            java.lang.Object state$kotlinx_coroutines_core = segment.getState$kotlinx_coroutines_core(index);
            if (state$kotlinx_coroutines_core instanceof kotlinx.coroutines.Waiter) {
                if (b >= receivers$volatile$FU.get(this)) {
                    if (segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, kotlinx.coroutines.channels.BufferedChannelKt.RESUMING_BY_EB)) {
                        if (!tryResumeSender(state$kotlinx_coroutines_core, segment, index)) {
                            segment.setState$kotlinx_coroutines_core(index, kotlinx.coroutines.channels.BufferedChannelKt.INTERRUPTED_SEND);
                            segment.onCancelledRequest(index, false);
                            return false;
                        }
                        segment.setState$kotlinx_coroutines_core(index, kotlinx.coroutines.channels.BufferedChannelKt.BUFFERED);
                        return true;
                    }
                } else if (segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, new kotlinx.coroutines.channels.WaiterEB((kotlinx.coroutines.Waiter) state$kotlinx_coroutines_core))) {
                    return true;
                }
            } else {
                if (state$kotlinx_coroutines_core == kotlinx.coroutines.channels.BufferedChannelKt.INTERRUPTED_SEND) {
                    return false;
                }
                if (state$kotlinx_coroutines_core == null) {
                    if (segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, kotlinx.coroutines.channels.BufferedChannelKt.IN_BUFFER)) {
                        return true;
                    }
                } else {
                    if (state$kotlinx_coroutines_core == kotlinx.coroutines.channels.BufferedChannelKt.BUFFERED || state$kotlinx_coroutines_core == kotlinx.coroutines.channels.BufferedChannelKt.POISONED || state$kotlinx_coroutines_core == kotlinx.coroutines.channels.BufferedChannelKt.DONE_RCV || state$kotlinx_coroutines_core == kotlinx.coroutines.channels.BufferedChannelKt.INTERRUPTED_RCV || state$kotlinx_coroutines_core == kotlinx.coroutines.channels.BufferedChannelKt.getCHANNEL_CLOSED()) {
                        return true;
                    }
                    if (state$kotlinx_coroutines_core != kotlinx.coroutines.channels.BufferedChannelKt.RESUMING_BY_RCV) {
                        throw new java.lang.IllegalStateException(("Unexpected cell state: " + state$kotlinx_coroutines_core).toString());
                    }
                }
            }
        }
    }

    static /* synthetic */ void incCompletedExpandBufferAttempts$default(kotlinx.coroutines.channels.BufferedChannel bufferedChannel, long j, int i, java.lang.Object obj) {
        if (obj != null) {
            throw new java.lang.UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incCompletedExpandBufferAttempts");
        }
        if ((i & 1) != 0) {
            j = 1;
        }
        bufferedChannel.incCompletedExpandBufferAttempts(j);
    }

    private final void incCompletedExpandBufferAttempts(long nAttempts) {
        if ((completedExpandBuffersAndPauseFlag$volatile$FU.addAndGet(this, nAttempts) & 4611686018427387904L) != 0) {
            while ((completedExpandBuffersAndPauseFlag$volatile$FU.get(this) & 4611686018427387904L) != 0) {
            }
        }
    }

    public final void waitExpandBufferCompletion$kotlinx_coroutines_core(long globalIndex) {
        kotlinx.coroutines.channels.BufferedChannel<E> bufferedChannel = this;
        if (bufferedChannel.isRendezvousOrUnlimited()) {
            return;
        }
        while (bufferedChannel.getBufferEndCounter() <= globalIndex) {
            bufferedChannel = this;
        }
        int i = kotlinx.coroutines.channels.BufferedChannelKt.EXPAND_BUFFER_COMPLETION_WAIT_ITERATIONS;
        for (int i2 = 0; i2 < i; i2++) {
            long bufferEndCounter = bufferedChannel.getBufferEndCounter();
            if (bufferEndCounter == (kotlin.time.DurationKt.MAX_MILLIS & completedExpandBuffersAndPauseFlag$volatile$FU.get(bufferedChannel)) && bufferEndCounter == bufferedChannel.getBufferEndCounter()) {
                return;
            }
        }
        java.util.concurrent.atomic.AtomicLongFieldUpdater atomicLongFieldUpdater = completedExpandBuffersAndPauseFlag$volatile$FU;
        while (true) {
            long j = atomicLongFieldUpdater.get(bufferedChannel);
            if (atomicLongFieldUpdater.compareAndSet(bufferedChannel, j, kotlinx.coroutines.channels.BufferedChannelKt.constructEBCompletedAndPauseFlag(j & kotlin.time.DurationKt.MAX_MILLIS, true))) {
                break;
            } else {
                bufferedChannel = this;
            }
        }
        while (true) {
            long bufferEndCounter2 = bufferedChannel.getBufferEndCounter();
            long j2 = completedExpandBuffersAndPauseFlag$volatile$FU.get(bufferedChannel);
            long j3 = j2 & kotlin.time.DurationKt.MAX_MILLIS;
            boolean z = (4611686018427387904L & j2) != 0;
            if (bufferEndCounter2 == j3 && bufferEndCounter2 == bufferedChannel.getBufferEndCounter()) {
                break;
            }
            if (z) {
                bufferedChannel = this;
            } else {
                bufferedChannel = this;
                completedExpandBuffersAndPauseFlag$volatile$FU.compareAndSet(bufferedChannel, j2, kotlinx.coroutines.channels.BufferedChannelKt.constructEBCompletedAndPauseFlag(j3, true));
            }
        }
        java.util.concurrent.atomic.AtomicLongFieldUpdater atomicLongFieldUpdater2 = completedExpandBuffersAndPauseFlag$volatile$FU;
        while (true) {
            long j4 = atomicLongFieldUpdater2.get(bufferedChannel);
            boolean zCompareAndSet = atomicLongFieldUpdater2.compareAndSet(bufferedChannel, j4, kotlinx.coroutines.channels.BufferedChannelKt.constructEBCompletedAndPauseFlag(j4 & kotlin.time.DurationKt.MAX_MILLIS, false));
            java.util.concurrent.atomic.AtomicLongFieldUpdater atomicLongFieldUpdater3 = atomicLongFieldUpdater2;
            if (zCompareAndSet) {
                return;
            }
            atomicLongFieldUpdater2 = atomicLongFieldUpdater3;
            bufferedChannel = this;
        }
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public kotlinx.coroutines.selects.SelectClause2<E, kotlinx.coroutines.channels.BufferedChannel<E>> getOnSend() {
        kotlinx.coroutines.channels.BufferedChannel$onSend$1 bufferedChannel$onSend$1 = kotlinx.coroutines.channels.BufferedChannel$onSend$1.INSTANCE;
        kotlin.jvm.internal.Intrinsics.checkNotNull(bufferedChannel$onSend$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        kotlin.jvm.functions.Function3 function3 = (kotlin.jvm.functions.Function3) kotlin.jvm.internal.TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onSend$1, 3);
        kotlinx.coroutines.channels.BufferedChannel$onSend$2 bufferedChannel$onSend$2 = kotlinx.coroutines.channels.BufferedChannel$onSend$2.INSTANCE;
        kotlin.jvm.internal.Intrinsics.checkNotNull(bufferedChannel$onSend$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new kotlinx.coroutines.selects.SelectClause2Impl(this, function3, (kotlin.jvm.functions.Function3) kotlin.jvm.internal.TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onSend$2, 3), null, 8, null);
    }

    private final void onClosedSelectOnSend(E element, kotlinx.coroutines.selects.SelectInstance<?> select) {
        kotlin.jvm.functions.Function1<E, kotlin.Unit> function1 = this.onUndeliveredElement;
        if (function1 != null) {
            kotlinx.coroutines.internal.OnUndeliveredElementKt.callUndeliveredElement(function1, element, select.getContext());
        }
        select.selectInRegistrationPhase(kotlinx.coroutines.channels.BufferedChannelKt.getCHANNEL_CLOSED());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final java.lang.Object processResultSelectSend(java.lang.Object ignoredParam, java.lang.Object selectResult) throws java.lang.Throwable {
        if (selectResult != kotlinx.coroutines.channels.BufferedChannelKt.getCHANNEL_CLOSED()) {
            return this;
        }
        throw getSendException();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public kotlinx.coroutines.selects.SelectClause1<E> getOnReceive() {
        kotlinx.coroutines.channels.BufferedChannel$onReceive$1 bufferedChannel$onReceive$1 = kotlinx.coroutines.channels.BufferedChannel$onReceive$1.INSTANCE;
        kotlin.jvm.internal.Intrinsics.checkNotNull(bufferedChannel$onReceive$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        kotlin.jvm.functions.Function3 function3 = (kotlin.jvm.functions.Function3) kotlin.jvm.internal.TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onReceive$1, 3);
        kotlinx.coroutines.channels.BufferedChannel$onReceive$2 bufferedChannel$onReceive$2 = kotlinx.coroutines.channels.BufferedChannel$onReceive$2.INSTANCE;
        kotlin.jvm.internal.Intrinsics.checkNotNull(bufferedChannel$onReceive$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new kotlinx.coroutines.selects.SelectClause1Impl(this, function3, (kotlin.jvm.functions.Function3) kotlin.jvm.internal.TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onReceive$2, 3), this.onUndeliveredElementReceiveCancellationConstructor);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public kotlinx.coroutines.selects.SelectClause1<kotlinx.coroutines.channels.ChannelResult<E>> getOnReceiveCatching() {
        kotlinx.coroutines.channels.BufferedChannel$onReceiveCatching$1 bufferedChannel$onReceiveCatching$1 = kotlinx.coroutines.channels.BufferedChannel$onReceiveCatching$1.INSTANCE;
        kotlin.jvm.internal.Intrinsics.checkNotNull(bufferedChannel$onReceiveCatching$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        kotlin.jvm.functions.Function3 function3 = (kotlin.jvm.functions.Function3) kotlin.jvm.internal.TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onReceiveCatching$1, 3);
        kotlinx.coroutines.channels.BufferedChannel$onReceiveCatching$2 bufferedChannel$onReceiveCatching$2 = kotlinx.coroutines.channels.BufferedChannel$onReceiveCatching$2.INSTANCE;
        kotlin.jvm.internal.Intrinsics.checkNotNull(bufferedChannel$onReceiveCatching$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new kotlinx.coroutines.selects.SelectClause1Impl(this, function3, (kotlin.jvm.functions.Function3) kotlin.jvm.internal.TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onReceiveCatching$2, 3), this.onUndeliveredElementReceiveCancellationConstructor);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public kotlinx.coroutines.selects.SelectClause1<E> getOnReceiveOrNull() {
        kotlinx.coroutines.channels.BufferedChannel$onReceiveOrNull$1 bufferedChannel$onReceiveOrNull$1 = kotlinx.coroutines.channels.BufferedChannel$onReceiveOrNull$1.INSTANCE;
        kotlin.jvm.internal.Intrinsics.checkNotNull(bufferedChannel$onReceiveOrNull$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        kotlin.jvm.functions.Function3 function3 = (kotlin.jvm.functions.Function3) kotlin.jvm.internal.TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onReceiveOrNull$1, 3);
        kotlinx.coroutines.channels.BufferedChannel$onReceiveOrNull$2 bufferedChannel$onReceiveOrNull$2 = kotlinx.coroutines.channels.BufferedChannel$onReceiveOrNull$2.INSTANCE;
        kotlin.jvm.internal.Intrinsics.checkNotNull(bufferedChannel$onReceiveOrNull$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new kotlinx.coroutines.selects.SelectClause1Impl(this, function3, (kotlin.jvm.functions.Function3) kotlin.jvm.internal.TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onReceiveOrNull$2, 3), this.onUndeliveredElementReceiveCancellationConstructor);
    }

    private final void onClosedSelectOnReceive(kotlinx.coroutines.selects.SelectInstance<?> select) {
        select.selectInRegistrationPhase(kotlinx.coroutines.channels.BufferedChannelKt.getCHANNEL_CLOSED());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final java.lang.Object processResultSelectReceive(java.lang.Object ignoredParam, java.lang.Object selectResult) throws java.lang.Throwable {
        if (selectResult != kotlinx.coroutines.channels.BufferedChannelKt.getCHANNEL_CLOSED()) {
            return selectResult;
        }
        throw getReceiveException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final java.lang.Object processResultSelectReceiveOrNull(java.lang.Object ignoredParam, java.lang.Object selectResult) throws java.lang.Throwable {
        if (selectResult != kotlinx.coroutines.channels.BufferedChannelKt.getCHANNEL_CLOSED()) {
            return selectResult;
        }
        if (getCloseCause() == null) {
            return null;
        }
        throw getReceiveException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final java.lang.Object processResultSelectReceiveCatching(java.lang.Object ignoredParam, java.lang.Object selectResult) {
        return kotlinx.coroutines.channels.ChannelResult.m2101boximpl(selectResult == kotlinx.coroutines.channels.BufferedChannelKt.getCHANNEL_CLOSED() ? kotlinx.coroutines.channels.ChannelResult.INSTANCE.m2114closedJP2dKIU(getCloseCause()) : kotlinx.coroutines.channels.ChannelResult.INSTANCE.m2116successJP2dKIU(selectResult));
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public kotlinx.coroutines.channels.ChannelIterator<E> iterator() {
        return new kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator();
    }

    /* JADX INFO: compiled from: BufferedChannel.kt */
    @kotlin.Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\u0006H\u0096B¢\u0006\u0002\u0010\nJ,\u0010\u000b\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0082@¢\u0006\u0002\u0010\u0012J\u001c\u0010\u0013\u001a\u00020\u00142\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u00152\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u000e\u0010\u0016\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0006H\u0002J\b\u0010\u0019\u001a\u00020\u0014H\u0002J\u0013\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00028\u0000¢\u0006\u0002\u0010\u001cJ\u0006\u0010\u001d\u001a\u00020\u0014R\u001a\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lkotlinx/coroutines/channels/BufferedChannel$BufferedChannelIterator;", "Lkotlinx/coroutines/channels/ChannelIterator;", "Lkotlinx/coroutines/Waiter;", "(Lkotlinx/coroutines/channels/BufferedChannel;)V", "continuation", "Lkotlinx/coroutines/CancellableContinuationImpl;", "", "receiveResult", "", "hasNext", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hasNextOnNoWaiterSuspend", "segment", "Lkotlinx/coroutines/channels/ChannelSegment;", "index", "", "r", "", "(Lkotlinx/coroutines/channels/ChannelSegment;IJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invokeOnCancellation", "", "Lkotlinx/coroutines/internal/Segment;", "next", "()Ljava/lang/Object;", "onClosedHasNext", "onClosedHasNextNoWaiterSuspend", "tryResumeHasNext", com.alibaba.android.bindingx.core.internal.BindingXConstants.KEY_ELEMENT, "(Ljava/lang/Object;)Z", "tryResumeHasNextOnClosedChannel", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private final class BufferedChannelIterator implements kotlinx.coroutines.channels.ChannelIterator<E>, kotlinx.coroutines.Waiter {
        private kotlinx.coroutines.CancellableContinuationImpl<? super java.lang.Boolean> continuation;
        private java.lang.Object receiveResult = kotlinx.coroutines.channels.BufferedChannelKt.NO_RECEIVE_RESULT;

        public BufferedChannelIterator() {
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Since 1.3.0, binary compatibility with versions <= 1.2.x")
        public /* synthetic */ java.lang.Object next(kotlin.coroutines.Continuation continuation) {
            return kotlinx.coroutines.channels.ChannelIterator.DefaultImpls.next(this, continuation);
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        public java.lang.Object hasNext(kotlin.coroutines.Continuation<? super java.lang.Boolean> continuation) {
            kotlinx.coroutines.channels.BufferedChannel<E> bufferedChannel = kotlinx.coroutines.channels.BufferedChannel.this;
            kotlinx.coroutines.channels.ChannelSegment<E> channelSegment = (kotlinx.coroutines.channels.ChannelSegment) kotlinx.coroutines.channels.BufferedChannel.getReceiveSegment$volatile$FU().get(bufferedChannel);
            while (!bufferedChannel.isClosedForReceive()) {
                long andIncrement = kotlinx.coroutines.channels.BufferedChannel.getReceivers$volatile$FU().getAndIncrement(bufferedChannel);
                long j = andIncrement / ((long) kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE);
                int i = (int) (andIncrement % ((long) kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE));
                if (channelSegment.id != j) {
                    kotlinx.coroutines.channels.ChannelSegment<E> channelSegmentFindSegmentReceive = bufferedChannel.findSegmentReceive(j, channelSegment);
                    if (channelSegmentFindSegmentReceive == null) {
                        continue;
                    } else {
                        channelSegment = channelSegmentFindSegmentReceive;
                    }
                }
                java.lang.Object objUpdateCellReceive = bufferedChannel.updateCellReceive(channelSegment, i, andIncrement, null);
                if (objUpdateCellReceive != kotlinx.coroutines.channels.BufferedChannelKt.SUSPEND) {
                    if (objUpdateCellReceive != kotlinx.coroutines.channels.BufferedChannelKt.FAILED) {
                        if (objUpdateCellReceive == kotlinx.coroutines.channels.BufferedChannelKt.SUSPEND_NO_WAITER) {
                            return hasNextOnNoWaiterSuspend(channelSegment, i, andIncrement, continuation);
                        }
                        channelSegment.cleanPrev();
                        this.receiveResult = objUpdateCellReceive;
                        return kotlin.coroutines.jvm.internal.Boxing.boxBoolean(true);
                    }
                    if (andIncrement < bufferedChannel.getSendersCounter$kotlinx_coroutines_core()) {
                        channelSegment.cleanPrev();
                    }
                } else {
                    throw new java.lang.IllegalStateException("unreachable".toString());
                }
            }
            return kotlin.coroutines.jvm.internal.Boxing.boxBoolean(onClosedHasNext());
        }

        private final boolean onClosedHasNext() throws java.lang.Throwable {
            this.receiveResult = kotlinx.coroutines.channels.BufferedChannelKt.getCHANNEL_CLOSED();
            java.lang.Throwable closeCause = kotlinx.coroutines.channels.BufferedChannel.this.getCloseCause();
            if (closeCause == null) {
                return false;
            }
            throw kotlinx.coroutines.internal.StackTraceRecoveryKt.recoverStackTrace(closeCause);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final java.lang.Object hasNextOnNoWaiterSuspend(kotlinx.coroutines.channels.ChannelSegment<E> channelSegment, int i, long j, kotlin.coroutines.Continuation<? super java.lang.Boolean> continuation) {
            java.lang.Boolean boolBoxBoolean;
            kotlin.jvm.functions.Function1<E, kotlin.Unit> function1;
            kotlin.coroutines.CoroutineContext context;
            kotlinx.coroutines.channels.ChannelSegment channelSegmentFindSegmentReceive;
            kotlinx.coroutines.channels.BufferedChannel<E> bufferedChannel = kotlinx.coroutines.channels.BufferedChannel.this;
            kotlinx.coroutines.CancellableContinuationImpl orCreateCancellableContinuation = kotlinx.coroutines.CancellableContinuationKt.getOrCreateCancellableContinuation(kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(continuation));
            try {
                this.continuation = orCreateCancellableContinuation;
                java.lang.Object objUpdateCellReceive = bufferedChannel.updateCellReceive(channelSegment, i, j, this);
                if (objUpdateCellReceive != kotlinx.coroutines.channels.BufferedChannelKt.SUSPEND) {
                    kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit> function1BindCancellationFun = null;
                    function1BindCancellationFun = null;
                    if (objUpdateCellReceive == kotlinx.coroutines.channels.BufferedChannelKt.FAILED) {
                        if (j < bufferedChannel.getSendersCounter$kotlinx_coroutines_core()) {
                            channelSegment.cleanPrev();
                        }
                        kotlinx.coroutines.channels.ChannelSegment channelSegment2 = (kotlinx.coroutines.channels.ChannelSegment) kotlinx.coroutines.channels.BufferedChannel.getReceiveSegment$volatile$FU().get(bufferedChannel);
                        while (true) {
                            if (bufferedChannel.isClosedForReceive()) {
                                onClosedHasNextNoWaiterSuspend();
                            } else {
                                long andIncrement = kotlinx.coroutines.channels.BufferedChannel.getReceivers$volatile$FU().getAndIncrement(bufferedChannel);
                                long j2 = andIncrement / ((long) kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE);
                                int i2 = (int) (andIncrement % ((long) kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE));
                                if (channelSegment2.id != j2) {
                                    channelSegmentFindSegmentReceive = bufferedChannel.findSegmentReceive(j2, channelSegment2);
                                    if (channelSegmentFindSegmentReceive == null) {
                                    }
                                } else {
                                    channelSegmentFindSegmentReceive = channelSegment2;
                                }
                                objUpdateCellReceive = bufferedChannel.updateCellReceive(channelSegmentFindSegmentReceive, i2, andIncrement, this);
                                if (objUpdateCellReceive != kotlinx.coroutines.channels.BufferedChannelKt.SUSPEND) {
                                    if (objUpdateCellReceive == kotlinx.coroutines.channels.BufferedChannelKt.FAILED) {
                                        if (andIncrement < bufferedChannel.getSendersCounter$kotlinx_coroutines_core()) {
                                            channelSegmentFindSegmentReceive.cleanPrev();
                                        }
                                        channelSegment2 = channelSegmentFindSegmentReceive;
                                    } else {
                                        if (objUpdateCellReceive == kotlinx.coroutines.channels.BufferedChannelKt.SUSPEND_NO_WAITER) {
                                            throw new java.lang.IllegalStateException("unexpected".toString());
                                        }
                                        channelSegmentFindSegmentReceive.cleanPrev();
                                        this.receiveResult = objUpdateCellReceive;
                                        this.continuation = null;
                                        boolBoxBoolean = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(true);
                                        function1 = bufferedChannel.onUndeliveredElement;
                                        if (function1 != null) {
                                            context = orCreateCancellableContinuation.getContext();
                                            function1BindCancellationFun = kotlinx.coroutines.internal.OnUndeliveredElementKt.bindCancellationFun(function1, objUpdateCellReceive, context);
                                        }
                                        orCreateCancellableContinuation.resume(boolBoxBoolean, function1BindCancellationFun);
                                    }
                                } else {
                                    kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator bufferedChannelIterator = this instanceof kotlinx.coroutines.Waiter ? this : null;
                                    if (bufferedChannelIterator != null) {
                                        bufferedChannel.prepareReceiverForSuspension(bufferedChannelIterator, channelSegmentFindSegmentReceive, i2);
                                    }
                                }
                            }
                        }
                    } else {
                        channelSegment.cleanPrev();
                        this.receiveResult = objUpdateCellReceive;
                        this.continuation = null;
                        boolBoxBoolean = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(true);
                        function1 = bufferedChannel.onUndeliveredElement;
                        if (function1 != null) {
                            context = orCreateCancellableContinuation.getContext();
                            function1BindCancellationFun = kotlinx.coroutines.internal.OnUndeliveredElementKt.bindCancellationFun(function1, objUpdateCellReceive, context);
                        }
                        orCreateCancellableContinuation.resume(boolBoxBoolean, function1BindCancellationFun);
                    }
                } else {
                    bufferedChannel.prepareReceiverForSuspension(this, channelSegment, i);
                }
                java.lang.Object result = orCreateCancellableContinuation.getResult();
                if (result == kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(continuation);
                }
                return result;
            } catch (java.lang.Throwable th) {
                orCreateCancellableContinuation.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
                throw th;
            }
        }

        @Override // kotlinx.coroutines.Waiter
        public void invokeOnCancellation(kotlinx.coroutines.internal.Segment<?> segment, int index) {
            kotlinx.coroutines.CancellableContinuationImpl<? super java.lang.Boolean> cancellableContinuationImpl = this.continuation;
            if (cancellableContinuationImpl != null) {
                cancellableContinuationImpl.invokeOnCancellation(segment, index);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void onClosedHasNextNoWaiterSuspend() {
            kotlinx.coroutines.CancellableContinuationImpl<? super java.lang.Boolean> cancellableContinuationImpl = this.continuation;
            kotlin.jvm.internal.Intrinsics.checkNotNull(cancellableContinuationImpl);
            this.continuation = null;
            this.receiveResult = kotlinx.coroutines.channels.BufferedChannelKt.getCHANNEL_CLOSED();
            java.lang.Throwable closeCause = kotlinx.coroutines.channels.BufferedChannel.this.getCloseCause();
            if (closeCause == null) {
                kotlin.Result.Companion companion = kotlin.Result.INSTANCE;
                cancellableContinuationImpl.resumeWith(kotlin.Result.m541constructorimpl(false));
                return;
            }
            kotlinx.coroutines.CancellableContinuationImpl<? super java.lang.Boolean> cancellableContinuationImpl2 = cancellableContinuationImpl;
            if (kotlinx.coroutines.DebugKt.getRECOVER_STACK_TRACES() && (cancellableContinuationImpl2 instanceof kotlin.coroutines.jvm.internal.CoroutineStackFrame)) {
                closeCause = kotlinx.coroutines.internal.StackTraceRecoveryKt.recoverFromStackFrame(closeCause, cancellableContinuationImpl2);
            }
            kotlin.Result.Companion companion2 = kotlin.Result.INSTANCE;
            cancellableContinuationImpl2.resumeWith(kotlin.Result.m541constructorimpl(kotlin.ResultKt.createFailure(closeCause)));
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        public E next() throws java.lang.Throwable {
            E e = (E) this.receiveResult;
            if (e != kotlinx.coroutines.channels.BufferedChannelKt.NO_RECEIVE_RESULT) {
                this.receiveResult = kotlinx.coroutines.channels.BufferedChannelKt.NO_RECEIVE_RESULT;
                if (e != kotlinx.coroutines.channels.BufferedChannelKt.getCHANNEL_CLOSED()) {
                    return e;
                }
                throw kotlinx.coroutines.internal.StackTraceRecoveryKt.recoverStackTrace(kotlinx.coroutines.channels.BufferedChannel.this.getReceiveException());
            }
            throw new java.lang.IllegalStateException("`hasNext()` has not been invoked".toString());
        }

        public final boolean tryResumeHasNext(E element) {
            kotlinx.coroutines.CancellableContinuationImpl<? super java.lang.Boolean> cancellableContinuationImpl = this.continuation;
            kotlin.jvm.internal.Intrinsics.checkNotNull(cancellableContinuationImpl);
            this.continuation = null;
            this.receiveResult = element;
            kotlinx.coroutines.CancellableContinuationImpl<? super java.lang.Boolean> cancellableContinuationImpl2 = cancellableContinuationImpl;
            kotlin.jvm.functions.Function1<E, kotlin.Unit> function1 = kotlinx.coroutines.channels.BufferedChannel.this.onUndeliveredElement;
            return kotlinx.coroutines.channels.BufferedChannelKt.tryResume0(cancellableContinuationImpl2, true, function1 != null ? kotlinx.coroutines.internal.OnUndeliveredElementKt.bindCancellationFun(function1, element, cancellableContinuationImpl.getContext()) : null);
        }

        public final void tryResumeHasNextOnClosedChannel() {
            kotlinx.coroutines.CancellableContinuationImpl<? super java.lang.Boolean> cancellableContinuationImpl = this.continuation;
            kotlin.jvm.internal.Intrinsics.checkNotNull(cancellableContinuationImpl);
            this.continuation = null;
            this.receiveResult = kotlinx.coroutines.channels.BufferedChannelKt.getCHANNEL_CLOSED();
            java.lang.Throwable closeCause = kotlinx.coroutines.channels.BufferedChannel.this.getCloseCause();
            if (closeCause == null) {
                kotlin.Result.Companion companion = kotlin.Result.INSTANCE;
                cancellableContinuationImpl.resumeWith(kotlin.Result.m541constructorimpl(false));
                return;
            }
            kotlinx.coroutines.CancellableContinuationImpl<? super java.lang.Boolean> cancellableContinuationImpl2 = cancellableContinuationImpl;
            if (kotlinx.coroutines.DebugKt.getRECOVER_STACK_TRACES() && (cancellableContinuationImpl2 instanceof kotlin.coroutines.jvm.internal.CoroutineStackFrame)) {
                closeCause = kotlinx.coroutines.internal.StackTraceRecoveryKt.recoverFromStackFrame(closeCause, cancellableContinuationImpl2);
            }
            kotlin.Result.Companion companion2 = kotlin.Result.INSTANCE;
            cancellableContinuationImpl2.resumeWith(kotlin.Result.m541constructorimpl(kotlin.ResultKt.createFailure(closeCause)));
        }
    }

    protected final java.lang.Throwable getCloseCause() {
        return (java.lang.Throwable) _closeCause$volatile$FU.get(this);
    }

    protected final java.lang.Throwable getSendException() {
        java.lang.Throwable closeCause = getCloseCause();
        return closeCause == null ? new kotlinx.coroutines.channels.ClosedSendChannelException(kotlinx.coroutines.channels.ChannelsKt.DEFAULT_CLOSE_MESSAGE) : closeCause;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final java.lang.Throwable getReceiveException() {
        java.lang.Throwable closeCause = getCloseCause();
        return closeCause == null ? new kotlinx.coroutines.channels.ClosedReceiveChannelException(kotlinx.coroutines.channels.ChannelsKt.DEFAULT_CLOSE_MESSAGE) : closeCause;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean close(java.lang.Throwable cause) {
        return closeOrCancelImpl(cause, false);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final boolean cancel(java.lang.Throwable cause) {
        return cancelImpl$kotlinx_coroutines_core(cause);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final void cancel() {
        cancelImpl$kotlinx_coroutines_core(null);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final void cancel(java.util.concurrent.CancellationException cause) {
        cancelImpl$kotlinx_coroutines_core(cause);
    }

    public boolean cancelImpl$kotlinx_coroutines_core(java.lang.Throwable cause) {
        if (cause == null) {
            cause = new java.util.concurrent.CancellationException("Channel was cancelled");
        }
        return closeOrCancelImpl(cause, true);
    }

    protected boolean closeOrCancelImpl(java.lang.Throwable cause, boolean cancel) {
        if (cancel) {
            markCancellationStarted();
        }
        boolean zM = androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_closeCause$volatile$FU, this, kotlinx.coroutines.channels.BufferedChannelKt.NO_CLOSE_CAUSE, cause);
        if (cancel) {
            markCancelled();
        } else {
            markClosed();
        }
        completeCloseOrCancel();
        onClosedIdempotent();
        if (zM) {
            invokeCloseHandler();
        }
        return zM;
    }

    private final void invokeCloseHandler() {
        java.lang.Object obj;
        java.util.concurrent.atomic.AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = closeHandler$volatile$FU;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
        } while (!androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceFieldUpdater, this, obj, obj == null ? kotlinx.coroutines.channels.BufferedChannelKt.CLOSE_HANDLER_CLOSED : kotlinx.coroutines.channels.BufferedChannelKt.CLOSE_HANDLER_INVOKED));
        if (obj == null) {
            return;
        }
        ((kotlin.jvm.functions.Function1) obj).invoke2(getCloseCause());
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public void invokeOnClose(kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit> handler) {
        if (androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(closeHandler$volatile$FU, this, null, handler)) {
            return;
        }
        java.util.concurrent.atomic.AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = closeHandler$volatile$FU;
        do {
            java.lang.Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj != kotlinx.coroutines.channels.BufferedChannelKt.CLOSE_HANDLER_CLOSED) {
                if (obj == kotlinx.coroutines.channels.BufferedChannelKt.CLOSE_HANDLER_INVOKED) {
                    throw new java.lang.IllegalStateException("Another handler was already registered and successfully invoked".toString());
                }
                throw new java.lang.IllegalStateException(("Another handler is already registered: " + obj).toString());
            }
        } while (!androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(closeHandler$volatile$FU, this, kotlinx.coroutines.channels.BufferedChannelKt.CLOSE_HANDLER_CLOSED, kotlinx.coroutines.channels.BufferedChannelKt.CLOSE_HANDLER_INVOKED));
        handler.invoke2(getCloseCause());
    }

    private final void markClosed() {
        long j;
        long jConstructSendersAndCloseStatus;
        java.util.concurrent.atomic.AtomicLongFieldUpdater atomicLongFieldUpdater = sendersAndCloseStatus$volatile$FU;
        do {
            j = atomicLongFieldUpdater.get(this);
            int i = (int) (j >> 60);
            if (i == 0) {
                jConstructSendersAndCloseStatus = kotlinx.coroutines.channels.BufferedChannelKt.constructSendersAndCloseStatus(1152921504606846975L & j, 2);
            } else if (i != 1) {
                return;
            } else {
                jConstructSendersAndCloseStatus = kotlinx.coroutines.channels.BufferedChannelKt.constructSendersAndCloseStatus(1152921504606846975L & j, 3);
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j, jConstructSendersAndCloseStatus));
    }

    private final void markCancelled() {
        long j;
        java.util.concurrent.atomic.AtomicLongFieldUpdater atomicLongFieldUpdater = sendersAndCloseStatus$volatile$FU;
        do {
            j = atomicLongFieldUpdater.get(this);
        } while (!atomicLongFieldUpdater.compareAndSet(this, j, kotlinx.coroutines.channels.BufferedChannelKt.constructSendersAndCloseStatus(1152921504606846975L & j, 3)));
    }

    private final void markCancellationStarted() {
        long j;
        java.util.concurrent.atomic.AtomicLongFieldUpdater atomicLongFieldUpdater = sendersAndCloseStatus$volatile$FU;
        do {
            j = atomicLongFieldUpdater.get(this);
            if (((int) (j >> 60)) != 0) {
                return;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j, kotlinx.coroutines.channels.BufferedChannelKt.constructSendersAndCloseStatus(1152921504606846975L & j, 1)));
    }

    private final void completeCloseOrCancel() {
        isClosedForSend();
    }

    private final kotlinx.coroutines.channels.ChannelSegment<E> completeClose(long sendersCur) {
        kotlinx.coroutines.channels.ChannelSegment<E> channelSegmentCloseLinkedList = closeLinkedList();
        if (isConflatedDropOldest()) {
            long jMarkAllEmptyCellsAsClosed = markAllEmptyCellsAsClosed(channelSegmentCloseLinkedList);
            if (jMarkAllEmptyCellsAsClosed != -1) {
                dropFirstElementUntilTheSpecifiedCellIsInTheBuffer(jMarkAllEmptyCellsAsClosed);
            }
        }
        cancelSuspendedReceiveRequests(channelSegmentCloseLinkedList, sendersCur);
        return channelSegmentCloseLinkedList;
    }

    private final void completeCancel(long sendersCur) {
        removeUnprocessedElements(completeClose(sendersCur));
    }

    private final kotlinx.coroutines.channels.ChannelSegment<E> closeLinkedList() {
        java.lang.Object obj = bufferEndSegment$volatile$FU.get(this);
        kotlinx.coroutines.channels.ChannelSegment channelSegment = (kotlinx.coroutines.channels.ChannelSegment) sendSegment$volatile$FU.get(this);
        if (channelSegment.id > ((kotlinx.coroutines.channels.ChannelSegment) obj).id) {
            obj = channelSegment;
        }
        kotlinx.coroutines.channels.ChannelSegment channelSegment2 = (kotlinx.coroutines.channels.ChannelSegment) receiveSegment$volatile$FU.get(this);
        if (channelSegment2.id > ((kotlinx.coroutines.channels.ChannelSegment) obj).id) {
            obj = channelSegment2;
        }
        return (kotlinx.coroutines.channels.ChannelSegment) kotlinx.coroutines.internal.ConcurrentLinkedListKt.close((kotlinx.coroutines.internal.ConcurrentLinkedListNode) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final long markAllEmptyCellsAsClosed(kotlinx.coroutines.channels.ChannelSegment<E> lastSegment) {
        do {
            int i = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE;
            while (true) {
                i--;
                if (-1 < i) {
                    long j = (lastSegment.id * ((long) kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE)) + ((long) i);
                    if (j >= getReceiversCounter$kotlinx_coroutines_core()) {
                        while (true) {
                            java.lang.Object state$kotlinx_coroutines_core = lastSegment.getState$kotlinx_coroutines_core(i);
                            if (state$kotlinx_coroutines_core == null || state$kotlinx_coroutines_core == kotlinx.coroutines.channels.BufferedChannelKt.IN_BUFFER) {
                                if (lastSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, kotlinx.coroutines.channels.BufferedChannelKt.getCHANNEL_CLOSED())) {
                                    lastSegment.onSlotCleaned();
                                    break;
                                }
                            } else {
                                if (state$kotlinx_coroutines_core != kotlinx.coroutines.channels.BufferedChannelKt.BUFFERED) {
                                    break;
                                }
                                return j;
                            }
                        }
                    } else {
                        return -1L;
                    }
                }
            }
            lastSegment = (kotlinx.coroutines.channels.ChannelSegment) lastSegment.getPrev();
        } while (lastSegment != null);
        return -1L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void removeUnprocessedElements(kotlinx.coroutines.channels.ChannelSegment<E> lastSegment) {
        kotlin.jvm.functions.Function1<E, kotlin.Unit> function1 = this.onUndeliveredElement;
        kotlinx.coroutines.internal.UndeliveredElementException undeliveredElementExceptionCallUndeliveredElementCatchingException = null;
        java.lang.Object objM2137constructorimpl$default = kotlinx.coroutines.internal.InlineList.m2137constructorimpl$default(null, 1, null);
        loop0: do {
            for (int i = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE - 1; -1 < i; i--) {
                long j = (lastSegment.id * ((long) kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE)) + ((long) i);
                while (true) {
                    java.lang.Object state$kotlinx_coroutines_core = lastSegment.getState$kotlinx_coroutines_core(i);
                    if (state$kotlinx_coroutines_core == kotlinx.coroutines.channels.BufferedChannelKt.DONE_RCV) {
                        break loop0;
                    }
                    if (state$kotlinx_coroutines_core != kotlinx.coroutines.channels.BufferedChannelKt.BUFFERED) {
                        if (state$kotlinx_coroutines_core == kotlinx.coroutines.channels.BufferedChannelKt.IN_BUFFER || state$kotlinx_coroutines_core == null) {
                            if (lastSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, kotlinx.coroutines.channels.BufferedChannelKt.getCHANNEL_CLOSED())) {
                                lastSegment.onSlotCleaned();
                                break;
                            }
                        } else if (!(state$kotlinx_coroutines_core instanceof kotlinx.coroutines.Waiter) && !(state$kotlinx_coroutines_core instanceof kotlinx.coroutines.channels.WaiterEB)) {
                            if (state$kotlinx_coroutines_core != kotlinx.coroutines.channels.BufferedChannelKt.RESUMING_BY_EB && state$kotlinx_coroutines_core != kotlinx.coroutines.channels.BufferedChannelKt.RESUMING_BY_RCV) {
                                if (state$kotlinx_coroutines_core != kotlinx.coroutines.channels.BufferedChannelKt.RESUMING_BY_EB) {
                                    break;
                                }
                            } else {
                                break loop0;
                            }
                        } else {
                            if (j < getReceiversCounter$kotlinx_coroutines_core()) {
                                break loop0;
                            }
                            kotlinx.coroutines.Waiter waiter = state$kotlinx_coroutines_core instanceof kotlinx.coroutines.channels.WaiterEB ? ((kotlinx.coroutines.channels.WaiterEB) state$kotlinx_coroutines_core).waiter : (kotlinx.coroutines.Waiter) state$kotlinx_coroutines_core;
                            if (lastSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, kotlinx.coroutines.channels.BufferedChannelKt.getCHANNEL_CLOSED())) {
                                if (function1 != null) {
                                    undeliveredElementExceptionCallUndeliveredElementCatchingException = kotlinx.coroutines.internal.OnUndeliveredElementKt.callUndeliveredElementCatchingException(function1, lastSegment.getElement$kotlinx_coroutines_core(i), undeliveredElementExceptionCallUndeliveredElementCatchingException);
                                }
                                objM2137constructorimpl$default = kotlinx.coroutines.internal.InlineList.m2142plusFjFbRPM(objM2137constructorimpl$default, waiter);
                                lastSegment.cleanElement$kotlinx_coroutines_core(i);
                                lastSegment.onSlotCleaned();
                                break;
                            }
                        }
                    } else {
                        if (j < getReceiversCounter$kotlinx_coroutines_core()) {
                            break loop0;
                        }
                        if (lastSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, kotlinx.coroutines.channels.BufferedChannelKt.getCHANNEL_CLOSED())) {
                            if (function1 != null) {
                                undeliveredElementExceptionCallUndeliveredElementCatchingException = kotlinx.coroutines.internal.OnUndeliveredElementKt.callUndeliveredElementCatchingException(function1, lastSegment.getElement$kotlinx_coroutines_core(i), undeliveredElementExceptionCallUndeliveredElementCatchingException);
                            }
                            lastSegment.cleanElement$kotlinx_coroutines_core(i);
                            lastSegment.onSlotCleaned();
                            break;
                        }
                    }
                }
            }
            lastSegment = (kotlinx.coroutines.channels.ChannelSegment) lastSegment.getPrev();
        } while (lastSegment != null);
        if (objM2137constructorimpl$default != null) {
            if (!(objM2137constructorimpl$default instanceof java.util.ArrayList)) {
                resumeSenderOnCancelledChannel((kotlinx.coroutines.Waiter) objM2137constructorimpl$default);
            } else {
                kotlin.jvm.internal.Intrinsics.checkNotNull(objM2137constructorimpl$default, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
                java.util.ArrayList arrayList = (java.util.ArrayList) objM2137constructorimpl$default;
                for (int size = arrayList.size() - 1; -1 < size; size--) {
                    resumeSenderOnCancelledChannel((kotlinx.coroutines.Waiter) arrayList.get(size));
                }
            }
        }
        if (undeliveredElementExceptionCallUndeliveredElementCatchingException != null) {
            throw undeliveredElementExceptionCallUndeliveredElementCatchingException;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void cancelSuspendedReceiveRequests(kotlinx.coroutines.channels.ChannelSegment<E> lastSegment, long sendersCounter) {
        java.lang.Object objM2137constructorimpl$default = kotlinx.coroutines.internal.InlineList.m2137constructorimpl$default(null, 1, null);
        loop0: while (lastSegment != null) {
            for (int i = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE - 1; -1 < i; i--) {
                if ((lastSegment.id * ((long) kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE)) + ((long) i) < sendersCounter) {
                    break loop0;
                }
                while (true) {
                    java.lang.Object state$kotlinx_coroutines_core = lastSegment.getState$kotlinx_coroutines_core(i);
                    if (state$kotlinx_coroutines_core == null || state$kotlinx_coroutines_core == kotlinx.coroutines.channels.BufferedChannelKt.IN_BUFFER) {
                        if (lastSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, kotlinx.coroutines.channels.BufferedChannelKt.getCHANNEL_CLOSED())) {
                            lastSegment.onSlotCleaned();
                            break;
                        }
                    } else if (state$kotlinx_coroutines_core instanceof kotlinx.coroutines.channels.WaiterEB) {
                        if (lastSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, kotlinx.coroutines.channels.BufferedChannelKt.getCHANNEL_CLOSED())) {
                            objM2137constructorimpl$default = kotlinx.coroutines.internal.InlineList.m2142plusFjFbRPM(objM2137constructorimpl$default, ((kotlinx.coroutines.channels.WaiterEB) state$kotlinx_coroutines_core).waiter);
                            lastSegment.onCancelledRequest(i, true);
                            break;
                        }
                    } else {
                        if (!(state$kotlinx_coroutines_core instanceof kotlinx.coroutines.Waiter)) {
                            break;
                        }
                        if (lastSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, kotlinx.coroutines.channels.BufferedChannelKt.getCHANNEL_CLOSED())) {
                            objM2137constructorimpl$default = kotlinx.coroutines.internal.InlineList.m2142plusFjFbRPM(objM2137constructorimpl$default, state$kotlinx_coroutines_core);
                            lastSegment.onCancelledRequest(i, true);
                            break;
                        }
                    }
                }
            }
            lastSegment = (kotlinx.coroutines.channels.ChannelSegment) lastSegment.getPrev();
        }
        if (objM2137constructorimpl$default != null) {
            if (!(objM2137constructorimpl$default instanceof java.util.ArrayList)) {
                resumeReceiverOnClosedChannel((kotlinx.coroutines.Waiter) objM2137constructorimpl$default);
                return;
            }
            kotlin.jvm.internal.Intrinsics.checkNotNull(objM2137constructorimpl$default, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
            java.util.ArrayList arrayList = (java.util.ArrayList) objM2137constructorimpl$default;
            for (int size = arrayList.size() - 1; -1 < size; size--) {
                resumeReceiverOnClosedChannel((kotlinx.coroutines.Waiter) arrayList.get(size));
            }
        }
    }

    private final void resumeReceiverOnClosedChannel(kotlinx.coroutines.Waiter waiter) {
        resumeWaiterOnClosedChannel(waiter, true);
    }

    private final void resumeSenderOnCancelledChannel(kotlinx.coroutines.Waiter waiter) {
        resumeWaiterOnClosedChannel(waiter, false);
    }

    private final void resumeWaiterOnClosedChannel(kotlinx.coroutines.Waiter waiter, boolean z) {
        if (waiter instanceof kotlinx.coroutines.channels.BufferedChannel.SendBroadcast) {
            kotlinx.coroutines.CancellableContinuation<java.lang.Boolean> cont = ((kotlinx.coroutines.channels.BufferedChannel.SendBroadcast) waiter).getCont();
            kotlin.Result.Companion companion = kotlin.Result.INSTANCE;
            cont.resumeWith(kotlin.Result.m541constructorimpl(false));
            return;
        }
        if (waiter instanceof kotlinx.coroutines.CancellableContinuation) {
            kotlin.coroutines.Continuation continuation = (kotlin.coroutines.Continuation) waiter;
            kotlin.Result.Companion companion2 = kotlin.Result.INSTANCE;
            continuation.resumeWith(kotlin.Result.m541constructorimpl(kotlin.ResultKt.createFailure(z ? getReceiveException() : getSendException())));
        } else if (waiter instanceof kotlinx.coroutines.channels.ReceiveCatching) {
            kotlinx.coroutines.CancellableContinuationImpl<kotlinx.coroutines.channels.ChannelResult<? extends E>> cancellableContinuationImpl = ((kotlinx.coroutines.channels.ReceiveCatching) waiter).cont;
            kotlin.Result.Companion companion3 = kotlin.Result.INSTANCE;
            cancellableContinuationImpl.resumeWith(kotlin.Result.m541constructorimpl(kotlinx.coroutines.channels.ChannelResult.m2101boximpl(kotlinx.coroutines.channels.ChannelResult.INSTANCE.m2114closedJP2dKIU(getCloseCause()))));
        } else if (waiter instanceof kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator) {
            ((kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator) waiter).tryResumeHasNextOnClosedChannel();
        } else if (waiter instanceof kotlinx.coroutines.selects.SelectInstance) {
            ((kotlinx.coroutines.selects.SelectInstance) waiter).trySelect(this, kotlinx.coroutines.channels.BufferedChannelKt.getCHANNEL_CLOSED());
        } else {
            throw new java.lang.IllegalStateException(("Unexpected waiter: " + waiter).toString());
        }
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean isClosedForSend() {
        return isClosedForSend0(sendersAndCloseStatus$volatile$FU.get(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isClosedForSend0(long j) {
        return isClosed(j, false);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public boolean isClosedForReceive() {
        return isClosedForReceive0(sendersAndCloseStatus$volatile$FU.get(this));
    }

    private final boolean isClosedForReceive0(long j) {
        return isClosed(j, true);
    }

    private final boolean isClosed(long sendersAndCloseStatusCur, boolean isClosedForReceive) {
        int i = (int) (sendersAndCloseStatusCur >> 60);
        if (i == 0 || i == 1) {
            return false;
        }
        if (i == 2) {
            completeClose(sendersAndCloseStatusCur & 1152921504606846975L);
            return (isClosedForReceive && hasElements$kotlinx_coroutines_core()) ? false : true;
        }
        if (i == 3) {
            completeCancel(sendersAndCloseStatusCur & 1152921504606846975L);
            return true;
        }
        throw new java.lang.IllegalStateException(("unexpected close status: " + i).toString());
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public boolean isEmpty() {
        if (isClosedForReceive() || hasElements$kotlinx_coroutines_core()) {
            return false;
        }
        return !isClosedForReceive();
    }

    public final boolean hasElements$kotlinx_coroutines_core() {
        while (true) {
            kotlinx.coroutines.channels.ChannelSegment<E> channelSegmentFindSegmentReceive = (kotlinx.coroutines.channels.ChannelSegment) receiveSegment$volatile$FU.get(this);
            long receiversCounter$kotlinx_coroutines_core = getReceiversCounter$kotlinx_coroutines_core();
            if (getSendersCounter$kotlinx_coroutines_core() <= receiversCounter$kotlinx_coroutines_core) {
                return false;
            }
            long j = receiversCounter$kotlinx_coroutines_core / ((long) kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE);
            if (channelSegmentFindSegmentReceive.id == j || (channelSegmentFindSegmentReceive = findSegmentReceive(j, channelSegmentFindSegmentReceive)) != null) {
                channelSegmentFindSegmentReceive.cleanPrev();
                if (isCellNonEmpty(channelSegmentFindSegmentReceive, (int) (receiversCounter$kotlinx_coroutines_core % ((long) kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE)), receiversCounter$kotlinx_coroutines_core)) {
                    return true;
                }
                receivers$volatile$FU.compareAndSet(this, receiversCounter$kotlinx_coroutines_core, 1 + receiversCounter$kotlinx_coroutines_core);
            } else if (((kotlinx.coroutines.channels.ChannelSegment) receiveSegment$volatile$FU.get(this)).id < j) {
                return false;
            }
        }
    }

    private final boolean isCellNonEmpty(kotlinx.coroutines.channels.ChannelSegment<E> segment, int index, long globalIndex) {
        java.lang.Object state$kotlinx_coroutines_core;
        do {
            state$kotlinx_coroutines_core = segment.getState$kotlinx_coroutines_core(index);
            if (state$kotlinx_coroutines_core != null && state$kotlinx_coroutines_core != kotlinx.coroutines.channels.BufferedChannelKt.IN_BUFFER) {
                if (state$kotlinx_coroutines_core == kotlinx.coroutines.channels.BufferedChannelKt.BUFFERED) {
                    return true;
                }
                if (state$kotlinx_coroutines_core == kotlinx.coroutines.channels.BufferedChannelKt.INTERRUPTED_SEND || state$kotlinx_coroutines_core == kotlinx.coroutines.channels.BufferedChannelKt.getCHANNEL_CLOSED() || state$kotlinx_coroutines_core == kotlinx.coroutines.channels.BufferedChannelKt.DONE_RCV || state$kotlinx_coroutines_core == kotlinx.coroutines.channels.BufferedChannelKt.POISONED) {
                    return false;
                }
                if (state$kotlinx_coroutines_core == kotlinx.coroutines.channels.BufferedChannelKt.RESUMING_BY_EB) {
                    return true;
                }
                return state$kotlinx_coroutines_core != kotlinx.coroutines.channels.BufferedChannelKt.RESUMING_BY_RCV && globalIndex == getReceiversCounter$kotlinx_coroutines_core();
            }
        } while (!segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, kotlinx.coroutines.channels.BufferedChannelKt.POISONED));
        expandBuffer();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kotlinx.coroutines.channels.ChannelSegment<E> findSegmentSend(long id, kotlinx.coroutines.channels.ChannelSegment<E> startFrom) {
        java.lang.Object objFindSegmentInternal;
        java.util.concurrent.atomic.AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = sendSegment$volatile$FU;
        kotlin.jvm.functions.Function2 function2 = (kotlin.jvm.functions.Function2) kotlinx.coroutines.channels.BufferedChannelKt.createSegmentFunction();
        loop0: while (true) {
            objFindSegmentInternal = kotlinx.coroutines.internal.ConcurrentLinkedListKt.findSegmentInternal(startFrom, id, function2);
            if (!kotlinx.coroutines.internal.SegmentOrClosed.m2154isClosedimpl(objFindSegmentInternal)) {
                kotlinx.coroutines.internal.Segment segmentM2152getSegmentimpl = kotlinx.coroutines.internal.SegmentOrClosed.m2152getSegmentimpl(objFindSegmentInternal);
                while (true) {
                    kotlinx.coroutines.internal.Segment segment = (kotlinx.coroutines.internal.Segment) atomicReferenceFieldUpdater.get(this);
                    if (segment.id >= segmentM2152getSegmentimpl.id) {
                        break loop0;
                    }
                    if (!segmentM2152getSegmentimpl.tryIncPointers$kotlinx_coroutines_core()) {
                        break;
                    }
                    if (androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceFieldUpdater, this, segment, segmentM2152getSegmentimpl)) {
                        if (!segment.decPointers$kotlinx_coroutines_core()) {
                            break loop0;
                        }
                        segment.remove();
                        break loop0;
                    }
                    if (segmentM2152getSegmentimpl.decPointers$kotlinx_coroutines_core()) {
                        segmentM2152getSegmentimpl.remove();
                    }
                }
            } else {
                break;
            }
        }
        if (kotlinx.coroutines.internal.SegmentOrClosed.m2154isClosedimpl(objFindSegmentInternal)) {
            completeCloseOrCancel();
            if (startFrom.id * ((long) kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE) < getReceiversCounter$kotlinx_coroutines_core()) {
                startFrom.cleanPrev();
            }
            return null;
        }
        kotlinx.coroutines.channels.ChannelSegment<E> channelSegment = (kotlinx.coroutines.channels.ChannelSegment) kotlinx.coroutines.internal.SegmentOrClosed.m2152getSegmentimpl(objFindSegmentInternal);
        if (channelSegment.id > id) {
            updateSendersCounterIfLower(channelSegment.id * ((long) kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE));
            if (channelSegment.id * ((long) kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE) < getReceiversCounter$kotlinx_coroutines_core()) {
                channelSegment.cleanPrev();
            }
            return null;
        }
        if (!kotlinx.coroutines.DebugKt.getASSERTIONS_ENABLED() || channelSegment.id == id) {
            return channelSegment;
        }
        throw new java.lang.AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kotlinx.coroutines.channels.ChannelSegment<E> findSegmentReceive(long id, kotlinx.coroutines.channels.ChannelSegment<E> startFrom) {
        java.lang.Object objFindSegmentInternal;
        java.util.concurrent.atomic.AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = receiveSegment$volatile$FU;
        kotlin.jvm.functions.Function2 function2 = (kotlin.jvm.functions.Function2) kotlinx.coroutines.channels.BufferedChannelKt.createSegmentFunction();
        loop0: while (true) {
            objFindSegmentInternal = kotlinx.coroutines.internal.ConcurrentLinkedListKt.findSegmentInternal(startFrom, id, function2);
            if (!kotlinx.coroutines.internal.SegmentOrClosed.m2154isClosedimpl(objFindSegmentInternal)) {
                kotlinx.coroutines.internal.Segment segmentM2152getSegmentimpl = kotlinx.coroutines.internal.SegmentOrClosed.m2152getSegmentimpl(objFindSegmentInternal);
                while (true) {
                    kotlinx.coroutines.internal.Segment segment = (kotlinx.coroutines.internal.Segment) atomicReferenceFieldUpdater.get(this);
                    if (segment.id >= segmentM2152getSegmentimpl.id) {
                        break loop0;
                    }
                    if (!segmentM2152getSegmentimpl.tryIncPointers$kotlinx_coroutines_core()) {
                        break;
                    }
                    if (androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceFieldUpdater, this, segment, segmentM2152getSegmentimpl)) {
                        if (!segment.decPointers$kotlinx_coroutines_core()) {
                            break loop0;
                        }
                        segment.remove();
                        break loop0;
                    }
                    if (segmentM2152getSegmentimpl.decPointers$kotlinx_coroutines_core()) {
                        segmentM2152getSegmentimpl.remove();
                    }
                }
            } else {
                break;
            }
        }
        if (kotlinx.coroutines.internal.SegmentOrClosed.m2154isClosedimpl(objFindSegmentInternal)) {
            completeCloseOrCancel();
            if (startFrom.id * ((long) kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE) < getSendersCounter$kotlinx_coroutines_core()) {
                startFrom.cleanPrev();
            }
            return null;
        }
        kotlinx.coroutines.channels.ChannelSegment<E> channelSegment = (kotlinx.coroutines.channels.ChannelSegment) kotlinx.coroutines.internal.SegmentOrClosed.m2152getSegmentimpl(objFindSegmentInternal);
        if (!isRendezvousOrUnlimited() && id <= getBufferEndCounter() / ((long) kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE)) {
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = bufferEndSegment$volatile$FU;
            while (true) {
                kotlinx.coroutines.internal.Segment segment2 = (kotlinx.coroutines.internal.Segment) atomicReferenceFieldUpdater2.get(this);
                kotlinx.coroutines.channels.ChannelSegment<E> channelSegment2 = channelSegment;
                if (segment2.id >= channelSegment2.id || !channelSegment2.tryIncPointers$kotlinx_coroutines_core()) {
                    break;
                }
                if (androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceFieldUpdater2, this, segment2, channelSegment2)) {
                    if (!segment2.decPointers$kotlinx_coroutines_core()) {
                        break;
                    }
                    segment2.remove();
                    break;
                }
                if (channelSegment2.decPointers$kotlinx_coroutines_core()) {
                    channelSegment2.remove();
                }
            }
        }
        if (channelSegment.id > id) {
            updateReceiversCounterIfLower(channelSegment.id * ((long) kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE));
            if (channelSegment.id * ((long) kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE) < getSendersCounter$kotlinx_coroutines_core()) {
                channelSegment.cleanPrev();
            }
            return null;
        }
        if (!kotlinx.coroutines.DebugKt.getASSERTIONS_ENABLED() || channelSegment.id == id) {
            return channelSegment;
        }
        throw new java.lang.AssertionError();
    }

    private final kotlinx.coroutines.channels.ChannelSegment<E> findSegmentBufferEnd(long id, kotlinx.coroutines.channels.ChannelSegment<E> startFrom, long currentBufferEndCounter) {
        java.lang.Object objFindSegmentInternal;
        java.util.concurrent.atomic.AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = bufferEndSegment$volatile$FU;
        kotlin.jvm.functions.Function2 function2 = (kotlin.jvm.functions.Function2) kotlinx.coroutines.channels.BufferedChannelKt.createSegmentFunction();
        loop0: while (true) {
            objFindSegmentInternal = kotlinx.coroutines.internal.ConcurrentLinkedListKt.findSegmentInternal(startFrom, id, function2);
            if (!kotlinx.coroutines.internal.SegmentOrClosed.m2154isClosedimpl(objFindSegmentInternal)) {
                kotlinx.coroutines.internal.Segment segmentM2152getSegmentimpl = kotlinx.coroutines.internal.SegmentOrClosed.m2152getSegmentimpl(objFindSegmentInternal);
                while (true) {
                    kotlinx.coroutines.internal.Segment segment = (kotlinx.coroutines.internal.Segment) atomicReferenceFieldUpdater.get(this);
                    if (segment.id >= segmentM2152getSegmentimpl.id) {
                        break loop0;
                    }
                    if (!segmentM2152getSegmentimpl.tryIncPointers$kotlinx_coroutines_core()) {
                        break;
                    }
                    if (androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceFieldUpdater, this, segment, segmentM2152getSegmentimpl)) {
                        if (!segment.decPointers$kotlinx_coroutines_core()) {
                            break loop0;
                        }
                        segment.remove();
                        break loop0;
                    }
                    if (segmentM2152getSegmentimpl.decPointers$kotlinx_coroutines_core()) {
                        segmentM2152getSegmentimpl.remove();
                    }
                }
            } else {
                break;
            }
        }
        if (kotlinx.coroutines.internal.SegmentOrClosed.m2154isClosedimpl(objFindSegmentInternal)) {
            completeCloseOrCancel();
            moveSegmentBufferEndToSpecifiedOrLast(id, startFrom);
            incCompletedExpandBufferAttempts$default(this, 0L, 1, null);
            return null;
        }
        kotlinx.coroutines.channels.ChannelSegment<E> channelSegment = (kotlinx.coroutines.channels.ChannelSegment) kotlinx.coroutines.internal.SegmentOrClosed.m2152getSegmentimpl(objFindSegmentInternal);
        if (channelSegment.id > id) {
            if (bufferEnd$volatile$FU.compareAndSet(this, currentBufferEndCounter + 1, ((long) kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE) * channelSegment.id)) {
                incCompletedExpandBufferAttempts((channelSegment.id * ((long) kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE)) - currentBufferEndCounter);
            } else {
                incCompletedExpandBufferAttempts$default(this, 0L, 1, null);
            }
            return null;
        }
        if (!kotlinx.coroutines.DebugKt.getASSERTIONS_ENABLED() || channelSegment.id == id) {
            return channelSegment;
        }
        throw new java.lang.AssertionError();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void moveSegmentBufferEndToSpecifiedOrLast(long id, kotlinx.coroutines.channels.ChannelSegment<E> startFrom) {
        kotlinx.coroutines.channels.ChannelSegment<E> channelSegment;
        kotlinx.coroutines.channels.ChannelSegment<E> channelSegment2;
        while (startFrom.id < id && (channelSegment2 = (kotlinx.coroutines.channels.ChannelSegment) startFrom.getNext()) != null) {
            startFrom = channelSegment2;
        }
        while (true) {
            if (!startFrom.isRemoved() || (channelSegment = (kotlinx.coroutines.channels.ChannelSegment) startFrom.getNext()) == null) {
                java.util.concurrent.atomic.AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = bufferEndSegment$volatile$FU;
                while (true) {
                    kotlinx.coroutines.internal.Segment segment = (kotlinx.coroutines.internal.Segment) atomicReferenceFieldUpdater.get(this);
                    kotlinx.coroutines.channels.ChannelSegment<E> channelSegment3 = startFrom;
                    if (segment.id >= channelSegment3.id) {
                        return;
                    }
                    if (!channelSegment3.tryIncPointers$kotlinx_coroutines_core()) {
                        break;
                    }
                    if (androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceFieldUpdater, this, segment, channelSegment3)) {
                        if (segment.decPointers$kotlinx_coroutines_core()) {
                            segment.remove();
                            return;
                        }
                        return;
                    } else if (channelSegment3.decPointers$kotlinx_coroutines_core()) {
                        channelSegment3.remove();
                    }
                }
            } else {
                startFrom = channelSegment;
            }
        }
    }

    private final void updateSendersCounterIfLower(long value) {
        long j;
        long j2;
        java.util.concurrent.atomic.AtomicLongFieldUpdater atomicLongFieldUpdater = sendersAndCloseStatus$volatile$FU;
        do {
            j = atomicLongFieldUpdater.get(this);
            j2 = 1152921504606846975L & j;
            if (j2 >= value) {
                return;
            }
        } while (!sendersAndCloseStatus$volatile$FU.compareAndSet(this, j, kotlinx.coroutines.channels.BufferedChannelKt.constructSendersAndCloseStatus(j2, (int) (j >> 60))));
    }

    private final void updateReceiversCounterIfLower(long value) {
        java.util.concurrent.atomic.AtomicLongFieldUpdater atomicLongFieldUpdater = receivers$volatile$FU;
        while (true) {
            long j = atomicLongFieldUpdater.get(this);
            if (j >= value) {
                return;
            }
            long j2 = value;
            if (receivers$volatile$FU.compareAndSet(this, j, j2)) {
                return;
            } else {
                value = j2;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public java.lang.String toString() {
        java.lang.String string;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        int i = (int) (sendersAndCloseStatus$volatile$FU.get(this) >> 60);
        if (i == 2) {
            sb.append("closed,");
        } else if (i == 3) {
            sb.append("cancelled,");
        }
        sb.append("capacity=" + this.capacity + com.taobao.weex.el.parse.Operators.ARRAY_SEPRATOR);
        sb.append("data=[");
        java.util.List listListOf = kotlin.collections.CollectionsKt.listOf((java.lang.Object[]) new kotlinx.coroutines.channels.ChannelSegment[]{receiveSegment$volatile$FU.get(this), sendSegment$volatile$FU.get(this), bufferEndSegment$volatile$FU.get(this)});
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.Object obj : listListOf) {
            if (((kotlinx.coroutines.channels.ChannelSegment) obj) != kotlinx.coroutines.channels.BufferedChannelKt.NULL_SEGMENT) {
                arrayList.add(obj);
            }
        }
        java.util.Iterator it = arrayList.iterator();
        if (!it.hasNext()) {
            throw new java.util.NoSuchElementException();
        }
        java.lang.Object next = it.next();
        if (it.hasNext()) {
            long j = ((kotlinx.coroutines.channels.ChannelSegment) next).id;
            do {
                java.lang.Object next2 = it.next();
                long j2 = ((kotlinx.coroutines.channels.ChannelSegment) next2).id;
                if (j > j2) {
                    next = next2;
                    j = j2;
                }
            } while (it.hasNext());
        }
        kotlinx.coroutines.channels.ChannelSegment channelSegment = (kotlinx.coroutines.channels.ChannelSegment) next;
        long receiversCounter$kotlinx_coroutines_core = getReceiversCounter$kotlinx_coroutines_core();
        long sendersCounter$kotlinx_coroutines_core = getSendersCounter$kotlinx_coroutines_core();
        loop2: do {
            int i2 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE;
            for (int i3 = 0; i3 < i2; i3++) {
                long j3 = (channelSegment.id * ((long) kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE)) + ((long) i3);
                if (j3 >= sendersCounter$kotlinx_coroutines_core && j3 >= receiversCounter$kotlinx_coroutines_core) {
                    break loop2;
                }
                java.lang.Object state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i3);
                java.lang.Object element$kotlinx_coroutines_core = channelSegment.getElement$kotlinx_coroutines_core(i3);
                if (state$kotlinx_coroutines_core instanceof kotlinx.coroutines.CancellableContinuation) {
                    if (j3 < receiversCounter$kotlinx_coroutines_core && j3 >= sendersCounter$kotlinx_coroutines_core) {
                        string = "receive";
                    } else if (j3 < sendersCounter$kotlinx_coroutines_core && j3 >= receiversCounter$kotlinx_coroutines_core) {
                        string = "send";
                    } else {
                        string = "cont";
                    }
                } else if (state$kotlinx_coroutines_core instanceof kotlinx.coroutines.selects.SelectInstance) {
                    if (j3 < receiversCounter$kotlinx_coroutines_core && j3 >= sendersCounter$kotlinx_coroutines_core) {
                        string = "onReceive";
                    } else if (j3 < sendersCounter$kotlinx_coroutines_core && j3 >= receiversCounter$kotlinx_coroutines_core) {
                        string = "onSend";
                    } else {
                        string = "select";
                    }
                } else if (state$kotlinx_coroutines_core instanceof kotlinx.coroutines.channels.ReceiveCatching) {
                    string = "receiveCatching";
                } else if (state$kotlinx_coroutines_core instanceof kotlinx.coroutines.channels.BufferedChannel.SendBroadcast) {
                    string = "sendBroadcast";
                } else if (state$kotlinx_coroutines_core instanceof kotlinx.coroutines.channels.WaiterEB) {
                    string = "EB(" + state$kotlinx_coroutines_core + com.taobao.weex.el.parse.Operators.BRACKET_END;
                } else if (kotlin.jvm.internal.Intrinsics.areEqual(state$kotlinx_coroutines_core, kotlinx.coroutines.channels.BufferedChannelKt.RESUMING_BY_RCV) ? true : kotlin.jvm.internal.Intrinsics.areEqual(state$kotlinx_coroutines_core, kotlinx.coroutines.channels.BufferedChannelKt.RESUMING_BY_EB)) {
                    string = "resuming_sender";
                } else {
                    if (!(state$kotlinx_coroutines_core == null ? true : kotlin.jvm.internal.Intrinsics.areEqual(state$kotlinx_coroutines_core, kotlinx.coroutines.channels.BufferedChannelKt.IN_BUFFER) ? true : kotlin.jvm.internal.Intrinsics.areEqual(state$kotlinx_coroutines_core, kotlinx.coroutines.channels.BufferedChannelKt.DONE_RCV) ? true : kotlin.jvm.internal.Intrinsics.areEqual(state$kotlinx_coroutines_core, kotlinx.coroutines.channels.BufferedChannelKt.POISONED) ? true : kotlin.jvm.internal.Intrinsics.areEqual(state$kotlinx_coroutines_core, kotlinx.coroutines.channels.BufferedChannelKt.INTERRUPTED_RCV) ? true : kotlin.jvm.internal.Intrinsics.areEqual(state$kotlinx_coroutines_core, kotlinx.coroutines.channels.BufferedChannelKt.INTERRUPTED_SEND) ? true : kotlin.jvm.internal.Intrinsics.areEqual(state$kotlinx_coroutines_core, kotlinx.coroutines.channels.BufferedChannelKt.getCHANNEL_CLOSED()))) {
                        string = state$kotlinx_coroutines_core.toString();
                    }
                }
                if (element$kotlinx_coroutines_core != null) {
                    sb.append(com.taobao.weex.el.parse.Operators.BRACKET_START_STR + string + com.taobao.weex.el.parse.Operators.ARRAY_SEPRATOR + element$kotlinx_coroutines_core + "),");
                } else {
                    sb.append(string + com.taobao.weex.el.parse.Operators.ARRAY_SEPRATOR);
                }
            }
            channelSegment = (kotlinx.coroutines.channels.ChannelSegment) channelSegment.getNext();
        } while (channelSegment != null);
        if (kotlin.text.StringsKt.last(sb) == ',') {
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(sb.deleteCharAt(sb.length() - 1), "deleteCharAt(...)");
        }
        sb.append(com.taobao.weex.el.parse.Operators.ARRAY_END_STR);
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final java.lang.String toStringDebug$kotlinx_coroutines_core() {
        java.lang.String strValueOf;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("S=" + getSendersCounter$kotlinx_coroutines_core() + ",R=" + getReceiversCounter$kotlinx_coroutines_core() + ",B=" + getBufferEndCounter() + ",B'=" + completedExpandBuffersAndPauseFlag$volatile$FU.get(this) + ",C=" + ((int) (sendersAndCloseStatus$volatile$FU.get(this) >> 60)) + com.taobao.weex.el.parse.Operators.ARRAY_SEPRATOR);
        int i = (int) (sendersAndCloseStatus$volatile$FU.get(this) >> 60);
        if (i == 1) {
            sb.append("CANCELLATION_STARTED,");
        } else if (i == 2) {
            sb.append("CLOSED,");
        } else if (i == 3) {
            sb.append("CANCELLED,");
        }
        sb.append("SEND_SEGM=" + kotlinx.coroutines.DebugStringsKt.getHexAddress(sendSegment$volatile$FU.get(this)) + ",RCV_SEGM=" + kotlinx.coroutines.DebugStringsKt.getHexAddress(receiveSegment$volatile$FU.get(this)));
        if (!isRendezvousOrUnlimited()) {
            sb.append(",EB_SEGM=" + kotlinx.coroutines.DebugStringsKt.getHexAddress(bufferEndSegment$volatile$FU.get(this)));
        }
        sb.append("  ");
        java.util.List listListOf = kotlin.collections.CollectionsKt.listOf((java.lang.Object[]) new kotlinx.coroutines.channels.ChannelSegment[]{receiveSegment$volatile$FU.get(this), sendSegment$volatile$FU.get(this), bufferEndSegment$volatile$FU.get(this)});
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.Object obj : listListOf) {
            if (((kotlinx.coroutines.channels.ChannelSegment) obj) != kotlinx.coroutines.channels.BufferedChannelKt.NULL_SEGMENT) {
                arrayList.add(obj);
            }
        }
        java.util.Iterator it = arrayList.iterator();
        if (!it.hasNext()) {
            throw new java.util.NoSuchElementException();
        }
        java.lang.Object next = it.next();
        if (it.hasNext()) {
            long j = ((kotlinx.coroutines.channels.ChannelSegment) next).id;
            do {
                java.lang.Object next2 = it.next();
                long j2 = ((kotlinx.coroutines.channels.ChannelSegment) next2).id;
                if (j > j2) {
                    next = next2;
                    j = j2;
                }
            } while (it.hasNext());
        }
        kotlinx.coroutines.channels.ChannelSegment channelSegment = (kotlinx.coroutines.channels.ChannelSegment) next;
        do {
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append(kotlinx.coroutines.DebugStringsKt.getHexAddress(channelSegment));
            sb2.append("=[");
            sb2.append(channelSegment.isRemoved() ? "*" : "");
            sb2.append(channelSegment.id);
            sb2.append(",prev=");
            kotlinx.coroutines.channels.ChannelSegment channelSegment2 = (kotlinx.coroutines.channels.ChannelSegment) channelSegment.getPrev();
            sb2.append(channelSegment2 != null ? kotlinx.coroutines.DebugStringsKt.getHexAddress(channelSegment2) : null);
            sb2.append(com.taobao.weex.el.parse.Operators.ARRAY_SEPRATOR);
            sb.append(sb2.toString());
            int i2 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE;
            for (int i3 = 0; i3 < i2; i3++) {
                java.lang.Object state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i3);
                java.lang.Object element$kotlinx_coroutines_core = channelSegment.getElement$kotlinx_coroutines_core(i3);
                if (state$kotlinx_coroutines_core instanceof kotlinx.coroutines.CancellableContinuation) {
                    strValueOf = "cont";
                } else if (state$kotlinx_coroutines_core instanceof kotlinx.coroutines.selects.SelectInstance) {
                    strValueOf = "select";
                } else if (state$kotlinx_coroutines_core instanceof kotlinx.coroutines.channels.ReceiveCatching) {
                    strValueOf = "receiveCatching";
                } else if (state$kotlinx_coroutines_core instanceof kotlinx.coroutines.channels.BufferedChannel.SendBroadcast) {
                    strValueOf = "send(broadcast)";
                } else if (state$kotlinx_coroutines_core instanceof kotlinx.coroutines.channels.WaiterEB) {
                    strValueOf = "EB(" + state$kotlinx_coroutines_core + com.taobao.weex.el.parse.Operators.BRACKET_END;
                } else {
                    strValueOf = java.lang.String.valueOf(state$kotlinx_coroutines_core);
                }
                sb.append(com.taobao.weex.el.parse.Operators.ARRAY_START_STR + i3 + "]=(" + strValueOf + com.taobao.weex.el.parse.Operators.ARRAY_SEPRATOR + element$kotlinx_coroutines_core + "),");
            }
            java.lang.StringBuilder sb3 = new java.lang.StringBuilder("next=");
            kotlinx.coroutines.channels.ChannelSegment channelSegment3 = (kotlinx.coroutines.channels.ChannelSegment) channelSegment.getNext();
            sb3.append(channelSegment3 != null ? kotlinx.coroutines.DebugStringsKt.getHexAddress(channelSegment3) : null);
            sb3.append("]  ");
            sb.append(sb3.toString());
            channelSegment = (kotlinx.coroutines.channels.ChannelSegment) channelSegment.getNext();
        } while (channelSegment != null);
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void checkSegmentStructureInvariants() {
        if (isRendezvousOrUnlimited()) {
            if (bufferEndSegment$volatile$FU.get(this) != kotlinx.coroutines.channels.BufferedChannelKt.NULL_SEGMENT) {
                throw new java.lang.IllegalStateException(("bufferEndSegment must be NULL_SEGMENT for rendezvous and unlimited channels; they do not manipulate it.\nChannel state: " + this).toString());
            }
        } else if (((kotlinx.coroutines.channels.ChannelSegment) receiveSegment$volatile$FU.get(this)).id > ((kotlinx.coroutines.channels.ChannelSegment) bufferEndSegment$volatile$FU.get(this)).id) {
            throw new java.lang.IllegalStateException(("bufferEndSegment should not have lower id than receiveSegment.\nChannel state: " + this).toString());
        }
        java.util.List listListOf = kotlin.collections.CollectionsKt.listOf((java.lang.Object[]) new kotlinx.coroutines.channels.ChannelSegment[]{receiveSegment$volatile$FU.get(this), sendSegment$volatile$FU.get(this), bufferEndSegment$volatile$FU.get(this)});
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.Object obj : listListOf) {
            if (((kotlinx.coroutines.channels.ChannelSegment) obj) != kotlinx.coroutines.channels.BufferedChannelKt.NULL_SEGMENT) {
                arrayList.add(obj);
            }
        }
        java.util.Iterator it = arrayList.iterator();
        if (!it.hasNext()) {
            throw new java.util.NoSuchElementException();
        }
        java.lang.Object next = it.next();
        if (it.hasNext()) {
            long j = ((kotlinx.coroutines.channels.ChannelSegment) next).id;
            do {
                java.lang.Object next2 = it.next();
                long j2 = ((kotlinx.coroutines.channels.ChannelSegment) next2).id;
                if (j > j2) {
                    next = next2;
                    j = j2;
                }
            } while (it.hasNext());
        }
        kotlinx.coroutines.channels.ChannelSegment channelSegment = (kotlinx.coroutines.channels.ChannelSegment) next;
        if (channelSegment.getPrev() != 0) {
            throw new java.lang.IllegalStateException(("All processed segments should be unreachable from the data structure, but the `prev` link of the leftmost segment is non-null.\nChannel state: " + this).toString());
        }
        while (channelSegment.getNext() != 0) {
            S next3 = channelSegment.getNext();
            kotlin.jvm.internal.Intrinsics.checkNotNull(next3);
            if (((kotlinx.coroutines.channels.ChannelSegment) next3).getPrev() != 0) {
                S next4 = channelSegment.getNext();
                kotlin.jvm.internal.Intrinsics.checkNotNull(next4);
                if (((kotlinx.coroutines.channels.ChannelSegment) next4).getPrev() != channelSegment) {
                    throw new java.lang.IllegalStateException(("The `segment.next.prev === segment` invariant is violated.\nChannel state: " + this).toString());
                }
            }
            int i = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE;
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                java.lang.Object state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i3);
                if (!kotlin.jvm.internal.Intrinsics.areEqual(state$kotlinx_coroutines_core, kotlinx.coroutines.channels.BufferedChannelKt.BUFFERED) && !(state$kotlinx_coroutines_core instanceof kotlinx.coroutines.Waiter)) {
                    if (!(kotlin.jvm.internal.Intrinsics.areEqual(state$kotlinx_coroutines_core, kotlinx.coroutines.channels.BufferedChannelKt.INTERRUPTED_RCV) ? true : kotlin.jvm.internal.Intrinsics.areEqual(state$kotlinx_coroutines_core, kotlinx.coroutines.channels.BufferedChannelKt.INTERRUPTED_SEND) ? true : kotlin.jvm.internal.Intrinsics.areEqual(state$kotlinx_coroutines_core, kotlinx.coroutines.channels.BufferedChannelKt.getCHANNEL_CLOSED()))) {
                        if (!(kotlin.jvm.internal.Intrinsics.areEqual(state$kotlinx_coroutines_core, kotlinx.coroutines.channels.BufferedChannelKt.POISONED) ? true : kotlin.jvm.internal.Intrinsics.areEqual(state$kotlinx_coroutines_core, kotlinx.coroutines.channels.BufferedChannelKt.DONE_RCV))) {
                            throw new java.lang.IllegalStateException(("Unexpected segment cell state: " + state$kotlinx_coroutines_core + ".\nChannel state: " + this).toString());
                        }
                        if (!(channelSegment.getElement$kotlinx_coroutines_core(i3) == null)) {
                            throw new java.lang.IllegalStateException("Check failed.".toString());
                        }
                    } else {
                        if (!(channelSegment.getElement$kotlinx_coroutines_core(i3) == null)) {
                            throw new java.lang.IllegalStateException("Check failed.".toString());
                        }
                        i2++;
                    }
                }
            }
            if (i2 == kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE && channelSegment != receiveSegment$volatile$FU.get(this) && channelSegment != sendSegment$volatile$FU.get(this) && channelSegment != bufferEndSegment$volatile$FU.get(this)) {
                throw new java.lang.IllegalStateException(("Logically removed segment is reachable.\nChannel state: " + this).toString());
            }
            S next5 = channelSegment.getNext();
            kotlin.jvm.internal.Intrinsics.checkNotNull(next5);
            channelSegment = (kotlinx.coroutines.channels.ChannelSegment) next5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final java.lang.Object onClosedSend(E e, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        kotlinx.coroutines.internal.UndeliveredElementException undeliveredElementExceptionCallUndeliveredElementCatchingException$default;
        kotlinx.coroutines.CancellableContinuationImpl cancellableContinuationImpl = new kotlinx.coroutines.CancellableContinuationImpl(kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        kotlinx.coroutines.CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        kotlin.jvm.functions.Function1<E, kotlin.Unit> function1 = this.onUndeliveredElement;
        if (function1 != null && (undeliveredElementExceptionCallUndeliveredElementCatchingException$default = kotlinx.coroutines.internal.OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(function1, e, null, 2, null)) != null) {
            kotlinx.coroutines.internal.UndeliveredElementException undeliveredElementExceptionRecoverFromStackFrame = undeliveredElementExceptionCallUndeliveredElementCatchingException$default;
            kotlin.ExceptionsKt.addSuppressed(undeliveredElementExceptionRecoverFromStackFrame, getSendException());
            kotlinx.coroutines.CancellableContinuationImpl cancellableContinuationImpl3 = cancellableContinuationImpl2;
            kotlin.Result.Companion companion = kotlin.Result.INSTANCE;
            if (kotlinx.coroutines.DebugKt.getRECOVER_STACK_TRACES() && (cancellableContinuationImpl3 instanceof kotlin.coroutines.jvm.internal.CoroutineStackFrame)) {
                undeliveredElementExceptionRecoverFromStackFrame = kotlinx.coroutines.internal.StackTraceRecoveryKt.recoverFromStackFrame(undeliveredElementExceptionRecoverFromStackFrame, cancellableContinuationImpl3);
            }
            cancellableContinuationImpl3.resumeWith(kotlin.Result.m541constructorimpl(kotlin.ResultKt.createFailure(undeliveredElementExceptionRecoverFromStackFrame)));
        } else {
            kotlinx.coroutines.CancellableContinuationImpl cancellableContinuationImpl4 = cancellableContinuationImpl2;
            java.lang.Throwable sendException = getSendException();
            kotlin.Result.Companion companion2 = kotlin.Result.INSTANCE;
            if (kotlinx.coroutines.DebugKt.getRECOVER_STACK_TRACES() && (cancellableContinuationImpl4 instanceof kotlin.coroutines.jvm.internal.CoroutineStackFrame)) {
                sendException = kotlinx.coroutines.internal.StackTraceRecoveryKt.recoverFromStackFrame(sendException, cancellableContinuationImpl4);
            }
            cancellableContinuationImpl4.resumeWith(kotlin.Result.m541constructorimpl(kotlin.ResultKt.createFailure(sendException)));
        }
        java.lang.Object result = cancellableContinuationImpl.getResult();
        if (result == kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:66:0x0112  */
    /* JADX WARN: Code duplicated, block: B:69:0x011b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:70:0x011c  */
    public final java.lang.Object sendOnNoWaiterSuspend(kotlinx.coroutines.channels.ChannelSegment<E> channelSegment, int i, E e, long j, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) throws java.lang.Throwable {
        kotlinx.coroutines.CancellableContinuationImpl cancellableContinuationImpl;
        kotlin.Unit unit;
        java.lang.Object result;
        kotlinx.coroutines.channels.ChannelSegment channelSegmentFindSegmentSend;
        kotlinx.coroutines.CancellableContinuationImpl orCreateCancellableContinuation = kotlinx.coroutines.CancellableContinuationKt.getOrCreateCancellableContinuation(kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(continuation));
        try {
            try {
                int iUpdateCellSend = updateCellSend(channelSegment, i, e, j, orCreateCancellableContinuation, false);
                if (iUpdateCellSend == 0) {
                    channelSegment.cleanPrev();
                    cancellableContinuationImpl = orCreateCancellableContinuation;
                    kotlin.Result.Companion companion = kotlin.Result.INSTANCE;
                    unit = kotlin.Unit.INSTANCE;
                } else {
                    if (iUpdateCellSend != 1) {
                        if (iUpdateCellSend != 2) {
                            if (iUpdateCellSend != 4) {
                                if (iUpdateCellSend != 5) {
                                    throw new java.lang.IllegalStateException("unexpected".toString());
                                }
                                channelSegment.cleanPrev();
                                kotlinx.coroutines.channels.ChannelSegment channelSegment2 = (kotlinx.coroutines.channels.ChannelSegment) sendSegment$volatile$FU.get(this);
                                while (true) {
                                    long andIncrement = sendersAndCloseStatus$volatile$FU.getAndIncrement(this);
                                    long j2 = 1152921504606846975L & andIncrement;
                                    boolean zIsClosedForSend0 = isClosedForSend0(andIncrement);
                                    long j3 = j2 / ((long) kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE);
                                    int i2 = (int) (j2 % ((long) kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE));
                                    if (channelSegment2.id != j3) {
                                        channelSegmentFindSegmentSend = findSegmentSend(j3, channelSegment2);
                                        if (channelSegmentFindSegmentSend == null) {
                                            if (zIsClosedForSend0) {
                                            }
                                        }
                                    } else {
                                        channelSegmentFindSegmentSend = channelSegment2;
                                    }
                                    int iUpdateCellSend2 = updateCellSend(channelSegmentFindSegmentSend, i2, e, j2, orCreateCancellableContinuation, zIsClosedForSend0);
                                    if (iUpdateCellSend2 == 0) {
                                        channelSegmentFindSegmentSend.cleanPrev();
                                        cancellableContinuationImpl = orCreateCancellableContinuation;
                                        kotlin.Result.Companion companion2 = kotlin.Result.INSTANCE;
                                        unit = kotlin.Unit.INSTANCE;
                                    } else if (iUpdateCellSend2 == 1) {
                                        cancellableContinuationImpl = orCreateCancellableContinuation;
                                        kotlin.Result.Companion companion3 = kotlin.Result.INSTANCE;
                                        unit = kotlin.Unit.INSTANCE;
                                    } else if (iUpdateCellSend2 != 2) {
                                        if (iUpdateCellSend2 == 3) {
                                            throw new java.lang.IllegalStateException("unexpected".toString());
                                        }
                                        if (iUpdateCellSend2 != 4) {
                                            if (iUpdateCellSend2 == 5) {
                                                channelSegmentFindSegmentSend.cleanPrev();
                                            }
                                            channelSegment2 = channelSegmentFindSegmentSend;
                                        } else if (j2 < getReceiversCounter$kotlinx_coroutines_core()) {
                                            channelSegmentFindSegmentSend.cleanPrev();
                                        }
                                    } else if (zIsClosedForSend0) {
                                        channelSegmentFindSegmentSend.onSlotCleaned();
                                    } else {
                                        kotlinx.coroutines.CancellableContinuationImpl cancellableContinuationImpl2 = orCreateCancellableContinuation instanceof kotlinx.coroutines.Waiter ? orCreateCancellableContinuation : null;
                                        if (cancellableContinuationImpl2 != null) {
                                            prepareSenderForSuspension(cancellableContinuationImpl2, channelSegmentFindSegmentSend, i2);
                                        }
                                    }
                                }
                            } else if (j < getReceiversCounter$kotlinx_coroutines_core()) {
                                channelSegment.cleanPrev();
                            }
                            onClosedSendOnNoWaiterSuspend(e, orCreateCancellableContinuation);
                        } else {
                            prepareSenderForSuspension(orCreateCancellableContinuation, channelSegment, i);
                        }
                        result = orCreateCancellableContinuation.getResult();
                        if (result == kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(continuation);
                        }
                        if (result == kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                            return result;
                        }
                        return kotlin.Unit.INSTANCE;
                    }
                    cancellableContinuationImpl = orCreateCancellableContinuation;
                    kotlin.Result.Companion companion4 = kotlin.Result.INSTANCE;
                    unit = kotlin.Unit.INSTANCE;
                }
                cancellableContinuationImpl.resumeWith(kotlin.Result.m541constructorimpl(unit));
                result = orCreateCancellableContinuation.getResult();
                if (result == kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(continuation);
                }
                if (result == kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return result;
                }
                return kotlin.Unit.INSTANCE;
            } catch (java.lang.Throwable th) {
                th = th;
                orCreateCancellableContinuation.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    static /* synthetic */ <E> java.lang.Object sendBroadcast$suspendImpl(kotlinx.coroutines.channels.BufferedChannel<E> bufferedChannel, E e, kotlin.coroutines.Continuation<? super java.lang.Boolean> continuation) {
        kotlinx.coroutines.CancellableContinuationImpl cancellableContinuationImpl = new kotlinx.coroutines.CancellableContinuationImpl(kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        kotlinx.coroutines.CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        if (bufferedChannel.onUndeliveredElement != null) {
            throw new java.lang.IllegalStateException("the `onUndeliveredElement` feature is unsupported for `sendBroadcast(e)`".toString());
        }
        kotlinx.coroutines.channels.BufferedChannel.SendBroadcast sendBroadcast = new kotlinx.coroutines.channels.BufferedChannel.SendBroadcast(cancellableContinuationImpl2);
        kotlinx.coroutines.channels.ChannelSegment channelSegment = (kotlinx.coroutines.channels.ChannelSegment) sendSegment$volatile$FU.get(bufferedChannel);
        while (true) {
            long andIncrement = sendersAndCloseStatus$volatile$FU.getAndIncrement(bufferedChannel);
            long j = 1152921504606846975L & andIncrement;
            boolean zIsClosedForSend0 = bufferedChannel.isClosedForSend0(andIncrement);
            long j2 = j / ((long) kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE);
            int i = (int) (j % ((long) kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE));
            if (channelSegment.id != j2) {
                kotlinx.coroutines.channels.ChannelSegment channelSegmentFindSegmentSend = bufferedChannel.findSegmentSend(j2, channelSegment);
                if (channelSegmentFindSegmentSend != null) {
                    channelSegment = channelSegmentFindSegmentSend;
                } else if (zIsClosedForSend0) {
                    kotlin.Result.Companion companion = kotlin.Result.INSTANCE;
                    cancellableContinuationImpl2.resumeWith(kotlin.Result.m541constructorimpl(kotlin.coroutines.jvm.internal.Boxing.boxBoolean(false)));
                    break;
                }
            }
            int iUpdateCellSend = bufferedChannel.updateCellSend(channelSegment, i, e, j, sendBroadcast, zIsClosedForSend0);
            if (iUpdateCellSend == 0) {
                channelSegment.cleanPrev();
            } else if (iUpdateCellSend != 1) {
                if (iUpdateCellSend == 2) {
                    if (zIsClosedForSend0) {
                        channelSegment.onSlotCleaned();
                    } else {
                        kotlinx.coroutines.channels.BufferedChannel.SendBroadcast sendBroadcast2 = sendBroadcast instanceof kotlinx.coroutines.Waiter ? sendBroadcast : null;
                        if (sendBroadcast2 == null) {
                            break;
                        }
                        bufferedChannel.prepareSenderForSuspension(sendBroadcast2, channelSegment, i);
                        break;
                    }
                } else {
                    if (iUpdateCellSend == 3) {
                        throw new java.lang.IllegalStateException("unexpected".toString());
                    }
                    if (iUpdateCellSend != 4) {
                        if (iUpdateCellSend == 5) {
                            channelSegment.cleanPrev();
                        }
                    } else if (j < bufferedChannel.getReceiversCounter$kotlinx_coroutines_core()) {
                        channelSegment.cleanPrev();
                    }
                }
                kotlin.Result.Companion companion2 = kotlin.Result.INSTANCE;
                cancellableContinuationImpl2.resumeWith(kotlin.Result.m541constructorimpl(kotlin.coroutines.jvm.internal.Boxing.boxBoolean(false)));
                break;
            }
            kotlin.Result.Companion companion3 = kotlin.Result.INSTANCE;
            cancellableContinuationImpl2.resumeWith(kotlin.Result.m541constructorimpl(kotlin.coroutines.jvm.internal.Boxing.boxBoolean(true)));
            break;
        }
        java.lang.Object result = cancellableContinuationImpl.getResult();
        if (result == kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final java.lang.Object receiveOnNoWaiterSuspend(kotlinx.coroutines.channels.ChannelSegment<E> channelSegment, int i, long j, kotlin.coroutines.Continuation<? super E> continuation) throws java.lang.Throwable {
        kotlin.jvm.functions.Function1<E, kotlin.Unit> function1;
        kotlin.coroutines.CoroutineContext context;
        kotlinx.coroutines.channels.ChannelSegment channelSegment2;
        kotlinx.coroutines.CancellableContinuationImpl orCreateCancellableContinuation = kotlinx.coroutines.CancellableContinuationKt.getOrCreateCancellableContinuation(kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(continuation));
        try {
            try {
                java.lang.Object objUpdateCellReceive = updateCellReceive(channelSegment, i, j, orCreateCancellableContinuation);
                if (objUpdateCellReceive != kotlinx.coroutines.channels.BufferedChannelKt.SUSPEND) {
                    kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit> function1BindCancellationFun = null;
                    function1BindCancellationFun = null;
                    if (objUpdateCellReceive == kotlinx.coroutines.channels.BufferedChannelKt.FAILED) {
                        if (j < getSendersCounter$kotlinx_coroutines_core()) {
                            channelSegment.cleanPrev();
                        }
                        kotlinx.coroutines.channels.ChannelSegment channelSegment3 = (kotlinx.coroutines.channels.ChannelSegment) getReceiveSegment$volatile$FU().get(this);
                        while (true) {
                            if (isClosedForReceive()) {
                                onClosedReceiveOnNoWaiterSuspend(orCreateCancellableContinuation);
                            } else {
                                long andIncrement = getReceivers$volatile$FU().getAndIncrement(this);
                                long j2 = andIncrement / ((long) kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE);
                                int i2 = (int) (andIncrement % ((long) kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE));
                                if (channelSegment3.id != j2) {
                                    kotlinx.coroutines.channels.ChannelSegment channelSegmentFindSegmentReceive = findSegmentReceive(j2, channelSegment3);
                                    if (channelSegmentFindSegmentReceive != null) {
                                        channelSegment2 = channelSegmentFindSegmentReceive;
                                    }
                                } else {
                                    channelSegment2 = channelSegment3;
                                }
                                objUpdateCellReceive = updateCellReceive(channelSegment2, i2, andIncrement, orCreateCancellableContinuation);
                                if (objUpdateCellReceive != kotlinx.coroutines.channels.BufferedChannelKt.SUSPEND) {
                                    if (objUpdateCellReceive == kotlinx.coroutines.channels.BufferedChannelKt.FAILED) {
                                        if (andIncrement < getSendersCounter$kotlinx_coroutines_core()) {
                                            channelSegment2.cleanPrev();
                                        }
                                        channelSegment3 = channelSegment2;
                                    } else {
                                        if (objUpdateCellReceive == kotlinx.coroutines.channels.BufferedChannelKt.SUSPEND_NO_WAITER) {
                                            throw new java.lang.IllegalStateException("unexpected".toString());
                                        }
                                        channelSegment2.cleanPrev();
                                        function1 = this.onUndeliveredElement;
                                        if (function1 != null) {
                                            context = orCreateCancellableContinuation.getContext();
                                            function1BindCancellationFun = kotlinx.coroutines.internal.OnUndeliveredElementKt.bindCancellationFun(function1, objUpdateCellReceive, context);
                                        }
                                        orCreateCancellableContinuation.resume(objUpdateCellReceive, function1BindCancellationFun);
                                    }
                                } else {
                                    kotlinx.coroutines.CancellableContinuationImpl cancellableContinuationImpl = orCreateCancellableContinuation instanceof kotlinx.coroutines.Waiter ? orCreateCancellableContinuation : null;
                                    if (cancellableContinuationImpl != null) {
                                        prepareReceiverForSuspension(cancellableContinuationImpl, channelSegment2, i2);
                                    }
                                }
                            }
                        }
                    } else {
                        channelSegment.cleanPrev();
                        function1 = this.onUndeliveredElement;
                        if (function1 != null) {
                            context = orCreateCancellableContinuation.getContext();
                            function1BindCancellationFun = kotlinx.coroutines.internal.OnUndeliveredElementKt.bindCancellationFun(function1, objUpdateCellReceive, context);
                        }
                        orCreateCancellableContinuation.resume(objUpdateCellReceive, function1BindCancellationFun);
                    }
                } else {
                    prepareReceiverForSuspension(orCreateCancellableContinuation, channelSegment, i);
                }
                java.lang.Object result = orCreateCancellableContinuation.getResult();
                if (result == kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(continuation);
                }
                return result;
            } catch (java.lang.Throwable th) {
                th = th;
                java.lang.Throwable th2 = th;
                orCreateCancellableContinuation.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
                throw th2;
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void registerSelectForSend(kotlinx.coroutines.selects.SelectInstance<?> select, java.lang.Object element) {
        kotlinx.coroutines.channels.ChannelSegment channelSegment;
        kotlinx.coroutines.channels.ChannelSegment channelSegment2 = (kotlinx.coroutines.channels.ChannelSegment) sendSegment$volatile$FU.get(this);
        while (true) {
            long andIncrement = sendersAndCloseStatus$volatile$FU.getAndIncrement(this);
            long j = andIncrement & 1152921504606846975L;
            boolean zIsClosedForSend0 = isClosedForSend0(andIncrement);
            long j2 = j / ((long) kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE);
            int i = (int) (j % ((long) kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE));
            if (channelSegment2.id != j2) {
                kotlinx.coroutines.channels.ChannelSegment channelSegmentFindSegmentSend = findSegmentSend(j2, channelSegment2);
                if (channelSegmentFindSegmentSend != null) {
                    channelSegment = channelSegmentFindSegmentSend;
                } else if (zIsClosedForSend0) {
                    onClosedSelectOnSend(element, select);
                    return;
                }
            } else {
                channelSegment = channelSegment2;
            }
            kotlinx.coroutines.selects.SelectInstance<?> selectInstance = select;
            java.lang.Object obj = element;
            int iUpdateCellSend = updateCellSend(channelSegment, i, obj, j, selectInstance, zIsClosedForSend0);
            channelSegment2 = channelSegment;
            if (iUpdateCellSend == 0) {
                channelSegment2.cleanPrev();
                selectInstance.selectInRegistrationPhase(kotlin.Unit.INSTANCE);
                return;
            }
            if (iUpdateCellSend == 1) {
                selectInstance.selectInRegistrationPhase(kotlin.Unit.INSTANCE);
                return;
            }
            if (iUpdateCellSend == 2) {
                if (zIsClosedForSend0) {
                    channelSegment2.onSlotCleaned();
                    onClosedSelectOnSend(obj, selectInstance);
                    return;
                } else {
                    kotlinx.coroutines.Waiter waiter = selectInstance instanceof kotlinx.coroutines.Waiter ? (kotlinx.coroutines.Waiter) selectInstance : null;
                    if (waiter != null) {
                        prepareSenderForSuspension(waiter, channelSegment2, i);
                        return;
                    }
                    return;
                }
            }
            if (iUpdateCellSend == 3) {
                throw new java.lang.IllegalStateException("unexpected".toString());
            }
            if (iUpdateCellSend == 4) {
                if (j < getReceiversCounter$kotlinx_coroutines_core()) {
                    channelSegment2.cleanPrev();
                }
                onClosedSelectOnSend(obj, selectInstance);
                return;
            } else {
                if (iUpdateCellSend == 5) {
                    channelSegment2.cleanPrev();
                }
                element = obj;
                select = selectInstance;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void registerSelectForReceive(kotlinx.coroutines.selects.SelectInstance<?> select, java.lang.Object ignoredParam) {
        kotlinx.coroutines.channels.ChannelSegment channelSegment;
        kotlinx.coroutines.channels.ChannelSegment channelSegment2 = (kotlinx.coroutines.channels.ChannelSegment) getReceiveSegment$volatile$FU().get(this);
        while (!isClosedForReceive()) {
            long andIncrement = getReceivers$volatile$FU().getAndIncrement(this);
            long j = andIncrement / ((long) kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE);
            int i = (int) (andIncrement % ((long) kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE));
            if (channelSegment2.id != j) {
                kotlinx.coroutines.channels.ChannelSegment channelSegmentFindSegmentReceive = findSegmentReceive(j, channelSegment2);
                if (channelSegmentFindSegmentReceive == null) {
                    continue;
                } else {
                    channelSegment = channelSegmentFindSegmentReceive;
                }
            } else {
                channelSegment = channelSegment2;
            }
            kotlinx.coroutines.selects.SelectInstance<?> selectInstance = select;
            java.lang.Object objUpdateCellReceive = updateCellReceive(channelSegment, i, andIncrement, selectInstance);
            channelSegment2 = channelSegment;
            if (objUpdateCellReceive != kotlinx.coroutines.channels.BufferedChannelKt.SUSPEND) {
                if (objUpdateCellReceive != kotlinx.coroutines.channels.BufferedChannelKt.FAILED) {
                    if (objUpdateCellReceive == kotlinx.coroutines.channels.BufferedChannelKt.SUSPEND_NO_WAITER) {
                        throw new java.lang.IllegalStateException("unexpected".toString());
                    }
                    channelSegment2.cleanPrev();
                    selectInstance.selectInRegistrationPhase(objUpdateCellReceive);
                    return;
                }
                if (andIncrement < getSendersCounter$kotlinx_coroutines_core()) {
                    channelSegment2.cleanPrev();
                }
                select = selectInstance;
            } else {
                kotlinx.coroutines.Waiter waiter = selectInstance instanceof kotlinx.coroutines.Waiter ? (kotlinx.coroutines.Waiter) selectInstance : null;
                if (waiter != null) {
                    prepareReceiverForSuspension(waiter, channelSegment2, i);
                    return;
                }
                return;
            }
        }
        onClosedSelectOnReceive(select);
    }
}
