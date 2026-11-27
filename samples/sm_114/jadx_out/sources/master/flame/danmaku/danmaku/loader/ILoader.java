package master.flame.danmaku.danmaku.loader;

/* JADX INFO: loaded from: classes2.dex */
public interface ILoader {
    master.flame.danmaku.danmaku.parser.IDataSource<?> getDataSource();

    void load(java.io.InputStream inputStream) throws master.flame.danmaku.danmaku.loader.IllegalDataException;

    void load(java.lang.String str) throws master.flame.danmaku.danmaku.loader.IllegalDataException;
}
