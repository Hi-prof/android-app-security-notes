package io.dcloud.uts.component;

/* JADX INFO: compiled from: UTSComponent.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H'¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lio/dcloud/uts/component/IMeasureAble;", "", "NVMeasure", "Lio/dcloud/uts/component/UTSSize;", io.dcloud.common.constant.AbsoluteConst.JSON_KEY_SIZE, "mode", "Lio/dcloud/uts/component/UTSMeasureMode;", "utsplugin_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IMeasureAble {
    @kotlin.Deprecated(message = "use NVMeasure(size:UTSSize,mode:UTSMeasureMode) instead", replaceWith = @kotlin.ReplaceWith(expression = "NVMeasure(size,mode)", imports = {}))
    io.dcloud.uts.component.UTSSize NVMeasure(io.dcloud.uts.component.UTSSize size);

    io.dcloud.uts.component.UTSSize NVMeasure(io.dcloud.uts.component.UTSSize size, io.dcloud.uts.component.UTSMeasureMode mode);
}
