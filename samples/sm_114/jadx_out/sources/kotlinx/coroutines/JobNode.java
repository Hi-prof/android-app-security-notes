package kotlinx.coroutines;

/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b \u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0017"}, d2 = {"Lkotlinx/coroutines/JobNode;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/InternalCompletionHandler;", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/Incomplete;", "()V", "isActive", "", "()Z", "job", "Lkotlinx/coroutines/JobSupport;", "getJob", "()Lkotlinx/coroutines/JobSupport;", "setJob", "(Lkotlinx/coroutines/JobSupport;)V", com.taobao.weex.ui.component.WXBasicComponentType.LIST, "Lkotlinx/coroutines/NodeList;", "getList", "()Lkotlinx/coroutines/NodeList;", "dispose", "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class JobNode extends kotlinx.coroutines.internal.LockFreeLinkedListNode implements kotlinx.coroutines.InternalCompletionHandler, kotlinx.coroutines.DisposableHandle, kotlinx.coroutines.Incomplete {
    public kotlinx.coroutines.JobSupport job;

    @Override // kotlinx.coroutines.Incomplete
    public kotlinx.coroutines.NodeList getList() {
        return null;
    }

    @Override // kotlinx.coroutines.Incomplete
    public boolean isActive() {
        return true;
    }

    public final kotlinx.coroutines.JobSupport getJob() {
        kotlinx.coroutines.JobSupport jobSupport = this.job;
        if (jobSupport != null) {
            return jobSupport;
        }
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("job");
        return null;
    }

    public final void setJob(kotlinx.coroutines.JobSupport jobSupport) {
        this.job = jobSupport;
    }

    @Override // kotlinx.coroutines.DisposableHandle
    public void dispose() {
        getJob().removeNode$kotlinx_coroutines_core(this);
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public java.lang.String toString() {
        return kotlinx.coroutines.DebugStringsKt.getClassSimpleName(this) + com.taobao.weex.ui.component.list.template.TemplateDom.SEPARATOR + kotlinx.coroutines.DebugStringsKt.getHexAddress(this) + "[job@" + kotlinx.coroutines.DebugStringsKt.getHexAddress(getJob()) + com.taobao.weex.el.parse.Operators.ARRAY_END;
    }
}
