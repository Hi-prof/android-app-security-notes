package net.lingala.zip4j.tasks;

/* JADX INFO: loaded from: classes2.dex */
public class MergeSplitZipFileTask extends net.lingala.zip4j.tasks.AsyncZipTask<net.lingala.zip4j.tasks.MergeSplitZipFileTask.MergeSplitZipFileTaskParameters> {
    private final net.lingala.zip4j.util.RawIO rawIO;
    private final net.lingala.zip4j.model.ZipModel zipModel;

    public MergeSplitZipFileTask(net.lingala.zip4j.model.ZipModel zipModel, net.lingala.zip4j.tasks.AsyncZipTask.AsyncTaskParameters asyncTaskParameters) {
        super(asyncTaskParameters);
        this.rawIO = new net.lingala.zip4j.util.RawIO();
        this.zipModel = zipModel;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Bottom block not found for handler: all -> 0x00b7 */
    /* JADX WARN: Code duplicated, block: B:102:? A[Catch: all -> 0x00b7, SYNTHETIC, TRY_LEAVE, TryCatch #7 {, blocks: (B:32:0x009a, B:46:0x00b6, B:45:0x00b3, B:42:0x00ae), top: B:89:0x009a, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:77:0x00ae A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // net.lingala.zip4j.tasks.AsyncZipTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void executeTask(net.lingala.zip4j.tasks.MergeSplitZipFileTask.MergeSplitZipFileTaskParameters r22, net.lingala.zip4j.progress.ProgressMonitor r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 257
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: net.lingala.zip4j.tasks.MergeSplitZipFileTask.executeTask(net.lingala.zip4j.tasks.MergeSplitZipFileTask$MergeSplitZipFileTaskParameters, net.lingala.zip4j.progress.ProgressMonitor):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // net.lingala.zip4j.tasks.AsyncZipTask
    public long calculateTotalWork(net.lingala.zip4j.tasks.MergeSplitZipFileTask.MergeSplitZipFileTaskParameters mergeSplitZipFileTaskParameters) {
        long length = 0;
        if (!this.zipModel.isSplitArchive()) {
            return 0L;
        }
        for (int i = 0; i <= this.zipModel.getEndOfCentralDirectoryRecord().getNumberOfThisDisk(); i++) {
            length += getNextSplitZipFile(this.zipModel, i).length();
        }
        return length;
    }

    private void updateFileHeaderOffsetsForIndex(java.util.List<net.lingala.zip4j.model.FileHeader> list, long j, int i, int i2) {
        for (net.lingala.zip4j.model.FileHeader fileHeader : list) {
            if (fileHeader.getDiskNumberStart() == i) {
                fileHeader.setOffsetLocalHeader((fileHeader.getOffsetLocalHeader() + j) - ((long) i2));
                fileHeader.setDiskNumberStart(0);
            }
        }
    }

    private java.io.File getNextSplitZipFile(net.lingala.zip4j.model.ZipModel zipModel, int i) {
        java.lang.String str;
        if (i == zipModel.getEndOfCentralDirectoryRecord().getNumberOfThisDisk()) {
            return zipModel.getZipFile();
        }
        if (i < 9) {
            str = ".z0";
        } else {
            str = ".z";
        }
        return new java.io.File(zipModel.getZipFile().getPath().substring(0, zipModel.getZipFile().getPath().lastIndexOf(com.taobao.weex.el.parse.Operators.DOT_STR)) + str + (i + 1));
    }

    private java.io.RandomAccessFile createSplitZipFileStream(net.lingala.zip4j.model.ZipModel zipModel, int i) throws java.io.FileNotFoundException {
        return new java.io.RandomAccessFile(getNextSplitZipFile(zipModel, i), net.lingala.zip4j.model.enums.RandomAccessFileMode.READ.getValue());
    }

    private void updateHeadersForMergeSplitFileAction(net.lingala.zip4j.model.ZipModel zipModel, long j, java.io.OutputStream outputStream, java.nio.charset.Charset charset) throws java.lang.Throwable {
        net.lingala.zip4j.model.ZipModel zipModel2 = (net.lingala.zip4j.model.ZipModel) zipModel.clone();
        zipModel2.getEndOfCentralDirectoryRecord().setOffsetOfStartOfCentralDirectory(j);
        updateSplitZipModel(zipModel2, j);
        new net.lingala.zip4j.headers.HeaderWriter().finalizeZipFileWithoutValidations(zipModel2, outputStream, charset);
    }

    private void updateSplitZipModel(net.lingala.zip4j.model.ZipModel zipModel, long j) {
        zipModel.setSplitArchive(false);
        updateSplitEndCentralDirectory(zipModel);
        if (zipModel.isZip64Format()) {
            updateSplitZip64EndCentralDirLocator(zipModel, j);
            updateSplitZip64EndCentralDirRec(zipModel, j);
        }
    }

    private void updateSplitEndCentralDirectory(net.lingala.zip4j.model.ZipModel zipModel) {
        int size = zipModel.getCentralDirectory().getFileHeaders().size();
        net.lingala.zip4j.model.EndOfCentralDirectoryRecord endOfCentralDirectoryRecord = zipModel.getEndOfCentralDirectoryRecord();
        endOfCentralDirectoryRecord.setNumberOfThisDisk(0);
        endOfCentralDirectoryRecord.setNumberOfThisDiskStartOfCentralDir(0);
        endOfCentralDirectoryRecord.setTotalNumberOfEntriesInCentralDirectory(size);
        endOfCentralDirectoryRecord.setTotalNumberOfEntriesInCentralDirectoryOnThisDisk(size);
    }

    private void updateSplitZip64EndCentralDirLocator(net.lingala.zip4j.model.ZipModel zipModel, long j) {
        if (zipModel.getZip64EndOfCentralDirectoryLocator() == null) {
            return;
        }
        net.lingala.zip4j.model.Zip64EndOfCentralDirectoryLocator zip64EndOfCentralDirectoryLocator = zipModel.getZip64EndOfCentralDirectoryLocator();
        zip64EndOfCentralDirectoryLocator.setNumberOfDiskStartOfZip64EndOfCentralDirectoryRecord(0);
        zip64EndOfCentralDirectoryLocator.setOffsetZip64EndOfCentralDirectoryRecord(zip64EndOfCentralDirectoryLocator.getOffsetZip64EndOfCentralDirectoryRecord() + j);
        zip64EndOfCentralDirectoryLocator.setTotalNumberOfDiscs(1);
    }

    private void updateSplitZip64EndCentralDirRec(net.lingala.zip4j.model.ZipModel zipModel, long j) {
        if (zipModel.getZip64EndOfCentralDirectoryRecord() == null) {
            return;
        }
        net.lingala.zip4j.model.Zip64EndOfCentralDirectoryRecord zip64EndOfCentralDirectoryRecord = zipModel.getZip64EndOfCentralDirectoryRecord();
        zip64EndOfCentralDirectoryRecord.setNumberOfThisDisk(0);
        zip64EndOfCentralDirectoryRecord.setNumberOfThisDiskStartOfCentralDirectory(0);
        zip64EndOfCentralDirectoryRecord.setTotalNumberOfEntriesInCentralDirectoryOnThisDisk(zipModel.getEndOfCentralDirectoryRecord().getTotalNumberOfEntriesInCentralDirectory());
        zip64EndOfCentralDirectoryRecord.setOffsetStartCentralDirectoryWRTStartDiskNumber(zip64EndOfCentralDirectoryRecord.getOffsetStartCentralDirectoryWRTStartDiskNumber() + j);
    }

    @Override // net.lingala.zip4j.tasks.AsyncZipTask
    protected net.lingala.zip4j.progress.ProgressMonitor.Task getTask() {
        return net.lingala.zip4j.progress.ProgressMonitor.Task.MERGE_ZIP_FILES;
    }

    public static class MergeSplitZipFileTaskParameters extends net.lingala.zip4j.tasks.AbstractZipTaskParameters {
        private java.io.File outputZipFile;

        public MergeSplitZipFileTaskParameters(java.io.File file, net.lingala.zip4j.model.Zip4jConfig zip4jConfig) {
            super(zip4jConfig);
            this.outputZipFile = file;
        }
    }
}
