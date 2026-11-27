package net.lingala.zip4j;

/* JADX INFO: loaded from: classes2.dex */
public class ZipFile implements java.io.Closeable {
    private int bufferSize;
    private java.nio.charset.Charset charset;
    private java.util.concurrent.ExecutorService executorService;
    private net.lingala.zip4j.headers.HeaderWriter headerWriter;
    private boolean isEncrypted;
    private java.util.List<java.io.InputStream> openInputStreams;
    private char[] password;
    private net.lingala.zip4j.progress.ProgressMonitor progressMonitor;
    private boolean runInThread;
    private java.util.concurrent.ThreadFactory threadFactory;
    private boolean useUtf8CharsetForPasswords;
    private java.io.File zipFile;
    private net.lingala.zip4j.model.ZipModel zipModel;

    public ZipFile(java.lang.String str) {
        this(new java.io.File(str), (char[]) null);
    }

    public ZipFile(java.lang.String str, char[] cArr) {
        this(new java.io.File(str), cArr);
    }

    public ZipFile(java.io.File file) {
        this(file, (char[]) null);
    }

    public ZipFile(java.io.File file, char[] cArr) {
        this.headerWriter = new net.lingala.zip4j.headers.HeaderWriter();
        this.charset = null;
        this.bufferSize = 4096;
        this.openInputStreams = new java.util.ArrayList();
        this.useUtf8CharsetForPasswords = true;
        if (file == null) {
            throw new java.lang.IllegalArgumentException("input zip file parameter is null");
        }
        this.zipFile = file;
        this.password = cArr;
        this.runInThread = false;
        this.progressMonitor = new net.lingala.zip4j.progress.ProgressMonitor();
    }

    public void createSplitZipFile(java.util.List<java.io.File> list, net.lingala.zip4j.model.ZipParameters zipParameters, boolean z, long j) throws net.lingala.zip4j.exception.ZipException {
        if (this.zipFile.exists()) {
            throw new net.lingala.zip4j.exception.ZipException("zip file: " + this.zipFile + " already exists. To add files to existing zip file use addFile method");
        }
        if (list == null || list.size() == 0) {
            throw new net.lingala.zip4j.exception.ZipException("input file List is null, cannot create zip file");
        }
        createNewZipModel();
        this.zipModel.setSplitArchive(z);
        this.zipModel.setSplitLength(j);
        new net.lingala.zip4j.tasks.AddFilesToZipTask(this.zipModel, this.password, this.headerWriter, buildAsyncParameters()).execute(new net.lingala.zip4j.tasks.AddFilesToZipTask.AddFilesToZipTaskParameters(list, zipParameters, buildConfig()));
    }

    public void createSplitZipFileFromFolder(java.io.File file, net.lingala.zip4j.model.ZipParameters zipParameters, boolean z, long j) throws net.lingala.zip4j.exception.ZipException {
        if (file == null) {
            throw new net.lingala.zip4j.exception.ZipException("folderToAdd is null, cannot create zip file from folder");
        }
        if (zipParameters == null) {
            throw new net.lingala.zip4j.exception.ZipException("input parameters are null, cannot create zip file from folder");
        }
        if (this.zipFile.exists()) {
            throw new net.lingala.zip4j.exception.ZipException("zip file: " + this.zipFile + " already exists. To add files to existing zip file use addFolder method");
        }
        createNewZipModel();
        this.zipModel.setSplitArchive(z);
        if (z) {
            this.zipModel.setSplitLength(j);
        }
        addFolder(file, zipParameters, false);
    }

    public void addFile(java.lang.String str) throws net.lingala.zip4j.exception.ZipException {
        addFile(str, new net.lingala.zip4j.model.ZipParameters());
    }

    public void addFile(java.lang.String str, net.lingala.zip4j.model.ZipParameters zipParameters) throws net.lingala.zip4j.exception.ZipException {
        if (!net.lingala.zip4j.util.Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
            throw new net.lingala.zip4j.exception.ZipException("file to add is null or empty");
        }
        addFiles(java.util.Collections.singletonList(new java.io.File(str)), zipParameters);
    }

    public void addFile(java.io.File file) throws net.lingala.zip4j.exception.ZipException {
        addFiles(java.util.Collections.singletonList(file), new net.lingala.zip4j.model.ZipParameters());
    }

    public void addFile(java.io.File file, net.lingala.zip4j.model.ZipParameters zipParameters) throws net.lingala.zip4j.exception.ZipException {
        addFiles(java.util.Collections.singletonList(file), zipParameters);
    }

    public void addFiles(java.util.List<java.io.File> list) throws net.lingala.zip4j.exception.ZipException {
        addFiles(list, new net.lingala.zip4j.model.ZipParameters());
    }

    public void addFiles(java.util.List<java.io.File> list, net.lingala.zip4j.model.ZipParameters zipParameters) throws net.lingala.zip4j.exception.ZipException {
        if (list == null || list.size() == 0) {
            throw new net.lingala.zip4j.exception.ZipException("input file List is null or empty");
        }
        if (zipParameters == null) {
            throw new net.lingala.zip4j.exception.ZipException("input parameters are null");
        }
        readZipInfo();
        if (this.zipModel == null) {
            throw new net.lingala.zip4j.exception.ZipException("internal error: zip model is null");
        }
        if (this.zipFile.exists() && this.zipModel.isSplitArchive()) {
            throw new net.lingala.zip4j.exception.ZipException("Zip file already exists. Zip file format does not allow updating split/spanned files");
        }
        new net.lingala.zip4j.tasks.AddFilesToZipTask(this.zipModel, this.password, this.headerWriter, buildAsyncParameters()).execute(new net.lingala.zip4j.tasks.AddFilesToZipTask.AddFilesToZipTaskParameters(list, zipParameters, buildConfig()));
    }

    public void addFolder(java.io.File file) throws net.lingala.zip4j.exception.ZipException {
        addFolder(file, new net.lingala.zip4j.model.ZipParameters());
    }

    public void addFolder(java.io.File file, net.lingala.zip4j.model.ZipParameters zipParameters) throws net.lingala.zip4j.exception.ZipException {
        if (file == null) {
            throw new net.lingala.zip4j.exception.ZipException("input path is null, cannot add folder to zip file");
        }
        if (!file.exists()) {
            throw new net.lingala.zip4j.exception.ZipException("folder does not exist");
        }
        if (!file.isDirectory()) {
            throw new net.lingala.zip4j.exception.ZipException("input folder is not a directory");
        }
        if (!file.canRead()) {
            throw new net.lingala.zip4j.exception.ZipException("cannot read input folder");
        }
        if (zipParameters == null) {
            throw new net.lingala.zip4j.exception.ZipException("input parameters are null, cannot add folder to zip file");
        }
        addFolder(file, zipParameters, true);
    }

    private void addFolder(java.io.File file, net.lingala.zip4j.model.ZipParameters zipParameters, boolean z) throws net.lingala.zip4j.exception.ZipException {
        readZipInfo();
        net.lingala.zip4j.model.ZipModel zipModel = this.zipModel;
        if (zipModel == null) {
            throw new net.lingala.zip4j.exception.ZipException("internal error: zip model is null");
        }
        if (z && zipModel.isSplitArchive()) {
            throw new net.lingala.zip4j.exception.ZipException("This is a split archive. Zip file format does not allow updating split/spanned files");
        }
        new net.lingala.zip4j.tasks.AddFolderToZipTask(this.zipModel, this.password, this.headerWriter, buildAsyncParameters()).execute(new net.lingala.zip4j.tasks.AddFolderToZipTask.AddFolderToZipTaskParameters(file, zipParameters, buildConfig()));
    }

    public void addStream(java.io.InputStream inputStream, net.lingala.zip4j.model.ZipParameters zipParameters) throws net.lingala.zip4j.exception.ZipException {
        if (inputStream == null) {
            throw new net.lingala.zip4j.exception.ZipException("inputstream is null, cannot add file to zip");
        }
        if (zipParameters == null) {
            throw new net.lingala.zip4j.exception.ZipException("zip parameters are null");
        }
        setRunInThread(false);
        readZipInfo();
        if (this.zipModel == null) {
            throw new net.lingala.zip4j.exception.ZipException("internal error: zip model is null");
        }
        if (this.zipFile.exists() && this.zipModel.isSplitArchive()) {
            throw new net.lingala.zip4j.exception.ZipException("Zip file already exists. Zip file format does not allow updating split/spanned files");
        }
        new net.lingala.zip4j.tasks.AddStreamToZipTask(this.zipModel, this.password, this.headerWriter, buildAsyncParameters()).execute(new net.lingala.zip4j.tasks.AddStreamToZipTask.AddStreamToZipTaskParameters(inputStream, zipParameters, buildConfig()));
    }

    public void extractAll(java.lang.String str) throws net.lingala.zip4j.exception.ZipException {
        extractAll(str, new net.lingala.zip4j.model.UnzipParameters());
    }

    public void extractAll(java.lang.String str, net.lingala.zip4j.model.UnzipParameters unzipParameters) throws net.lingala.zip4j.exception.ZipException {
        if (!net.lingala.zip4j.util.Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
            throw new net.lingala.zip4j.exception.ZipException("output path is null or invalid");
        }
        if (!net.lingala.zip4j.util.Zip4jUtil.createDirectoryIfNotExists(new java.io.File(str))) {
            throw new net.lingala.zip4j.exception.ZipException("invalid output path");
        }
        if (this.zipModel == null) {
            readZipInfo();
        }
        if (this.zipModel == null) {
            throw new net.lingala.zip4j.exception.ZipException("Internal error occurred when extracting zip file");
        }
        new net.lingala.zip4j.tasks.ExtractAllFilesTask(this.zipModel, this.password, unzipParameters, buildAsyncParameters()).execute(new net.lingala.zip4j.tasks.ExtractAllFilesTask.ExtractAllFilesTaskParameters(str, buildConfig()));
    }

    public void extractFile(net.lingala.zip4j.model.FileHeader fileHeader, java.lang.String str) throws net.lingala.zip4j.exception.ZipException {
        extractFile(fileHeader, str, (java.lang.String) null, new net.lingala.zip4j.model.UnzipParameters());
    }

    public void extractFile(net.lingala.zip4j.model.FileHeader fileHeader, java.lang.String str, net.lingala.zip4j.model.UnzipParameters unzipParameters) throws net.lingala.zip4j.exception.ZipException {
        extractFile(fileHeader, str, (java.lang.String) null, unzipParameters);
    }

    public void extractFile(net.lingala.zip4j.model.FileHeader fileHeader, java.lang.String str, java.lang.String str2, net.lingala.zip4j.model.UnzipParameters unzipParameters) throws net.lingala.zip4j.exception.ZipException {
        if (fileHeader == null) {
            throw new net.lingala.zip4j.exception.ZipException("input file header is null, cannot extract file");
        }
        extractFile(fileHeader.getFileName(), str, str2, unzipParameters);
    }

    public void extractFile(java.lang.String str, java.lang.String str2) throws net.lingala.zip4j.exception.ZipException {
        extractFile(str, str2, (java.lang.String) null, new net.lingala.zip4j.model.UnzipParameters());
    }

    public void extractFile(java.lang.String str, java.lang.String str2, net.lingala.zip4j.model.UnzipParameters unzipParameters) throws net.lingala.zip4j.exception.ZipException {
        extractFile(str, str2, (java.lang.String) null, unzipParameters);
    }

    public void extractFile(java.lang.String str, java.lang.String str2, java.lang.String str3) throws net.lingala.zip4j.exception.ZipException {
        extractFile(str, str2, str3, new net.lingala.zip4j.model.UnzipParameters());
    }

    public void extractFile(net.lingala.zip4j.model.FileHeader fileHeader, java.lang.String str, java.lang.String str2) throws net.lingala.zip4j.exception.ZipException {
        extractFile(fileHeader, str, str2, new net.lingala.zip4j.model.UnzipParameters());
    }

    public void extractFile(java.lang.String str, java.lang.String str2, java.lang.String str3, net.lingala.zip4j.model.UnzipParameters unzipParameters) throws net.lingala.zip4j.exception.ZipException {
        if (!net.lingala.zip4j.util.Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
            throw new net.lingala.zip4j.exception.ZipException("file to extract is null or empty, cannot extract file");
        }
        if (!net.lingala.zip4j.util.Zip4jUtil.isStringNotNullAndNotEmpty(str2)) {
            throw new net.lingala.zip4j.exception.ZipException("destination path is empty or null, cannot extract file");
        }
        if (unzipParameters == null) {
            unzipParameters = new net.lingala.zip4j.model.UnzipParameters();
        }
        readZipInfo();
        new net.lingala.zip4j.tasks.ExtractFileTask(this.zipModel, this.password, unzipParameters, buildAsyncParameters()).execute(new net.lingala.zip4j.tasks.ExtractFileTask.ExtractFileTaskParameters(str2, str, str3, buildConfig()));
    }

    public java.util.List<net.lingala.zip4j.model.FileHeader> getFileHeaders() throws net.lingala.zip4j.exception.ZipException {
        readZipInfo();
        net.lingala.zip4j.model.ZipModel zipModel = this.zipModel;
        if (zipModel == null || zipModel.getCentralDirectory() == null) {
            return java.util.Collections.EMPTY_LIST;
        }
        return this.zipModel.getCentralDirectory().getFileHeaders();
    }

    public net.lingala.zip4j.model.FileHeader getFileHeader(java.lang.String str) throws net.lingala.zip4j.exception.ZipException {
        if (!net.lingala.zip4j.util.Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
            throw new net.lingala.zip4j.exception.ZipException("input file name is emtpy or null, cannot get FileHeader");
        }
        readZipInfo();
        net.lingala.zip4j.model.ZipModel zipModel = this.zipModel;
        if (zipModel == null || zipModel.getCentralDirectory() == null) {
            return null;
        }
        return net.lingala.zip4j.headers.HeaderUtil.getFileHeader(this.zipModel, str);
    }

    public boolean isEncrypted() throws net.lingala.zip4j.exception.ZipException {
        if (this.zipModel == null) {
            readZipInfo();
            if (this.zipModel == null) {
                throw new net.lingala.zip4j.exception.ZipException("Zip Model is null");
            }
        }
        if (this.zipModel.getCentralDirectory() == null || this.zipModel.getCentralDirectory().getFileHeaders() == null) {
            throw new net.lingala.zip4j.exception.ZipException("invalid zip file");
        }
        for (net.lingala.zip4j.model.FileHeader fileHeader : this.zipModel.getCentralDirectory().getFileHeaders()) {
            if (fileHeader != null && fileHeader.isEncrypted()) {
                this.isEncrypted = true;
                break;
            }
        }
        return this.isEncrypted;
    }

    public boolean isSplitArchive() throws net.lingala.zip4j.exception.ZipException {
        if (this.zipModel == null) {
            readZipInfo();
            if (this.zipModel == null) {
                throw new net.lingala.zip4j.exception.ZipException("Zip Model is null");
            }
        }
        return this.zipModel.isSplitArchive();
    }

    public void removeFile(net.lingala.zip4j.model.FileHeader fileHeader) throws net.lingala.zip4j.exception.ZipException {
        if (fileHeader == null) {
            throw new net.lingala.zip4j.exception.ZipException("input file header is null, cannot remove file");
        }
        removeFile(fileHeader.getFileName());
    }

    public void removeFile(java.lang.String str) throws net.lingala.zip4j.exception.ZipException {
        if (!net.lingala.zip4j.util.Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
            throw new net.lingala.zip4j.exception.ZipException("file name is empty or null, cannot remove file");
        }
        removeFiles(java.util.Collections.singletonList(str));
    }

    public void removeFiles(java.util.List<java.lang.String> list) throws net.lingala.zip4j.exception.ZipException {
        if (list == null) {
            throw new net.lingala.zip4j.exception.ZipException("fileNames list is null");
        }
        if (list.isEmpty()) {
            return;
        }
        if (this.zipModel == null) {
            readZipInfo();
        }
        if (this.zipModel.isSplitArchive()) {
            throw new net.lingala.zip4j.exception.ZipException("Zip file format does not allow updating split/spanned files");
        }
        new net.lingala.zip4j.tasks.RemoveFilesFromZipTask(this.zipModel, this.headerWriter, buildAsyncParameters()).execute(new net.lingala.zip4j.tasks.RemoveFilesFromZipTask.RemoveFilesFromZipTaskParameters(list, buildConfig()));
    }

    public void renameFile(net.lingala.zip4j.model.FileHeader fileHeader, java.lang.String str) throws net.lingala.zip4j.exception.ZipException {
        if (fileHeader == null) {
            throw new net.lingala.zip4j.exception.ZipException("File header is null");
        }
        renameFile(fileHeader.getFileName(), str);
    }

    public void renameFile(java.lang.String str, java.lang.String str2) throws net.lingala.zip4j.exception.ZipException {
        if (!net.lingala.zip4j.util.Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
            throw new net.lingala.zip4j.exception.ZipException("file name to be changed is null or empty");
        }
        if (!net.lingala.zip4j.util.Zip4jUtil.isStringNotNullAndNotEmpty(str2)) {
            throw new net.lingala.zip4j.exception.ZipException("newFileName is null or empty");
        }
        renameFiles(java.util.Collections.singletonMap(str, str2));
    }

    public void renameFiles(java.util.Map<java.lang.String, java.lang.String> map) throws net.lingala.zip4j.exception.ZipException {
        if (map == null) {
            throw new net.lingala.zip4j.exception.ZipException("fileNamesMap is null");
        }
        if (map.size() == 0) {
            return;
        }
        readZipInfo();
        if (this.zipModel.isSplitArchive()) {
            throw new net.lingala.zip4j.exception.ZipException("Zip file format does not allow updating split/spanned files");
        }
        new net.lingala.zip4j.tasks.RenameFilesTask(this.zipModel, this.headerWriter, new net.lingala.zip4j.util.RawIO(), buildAsyncParameters()).execute(new net.lingala.zip4j.tasks.RenameFilesTask.RenameFilesTaskParameters(map, buildConfig()));
    }

    public void mergeSplitFiles(java.io.File file) throws net.lingala.zip4j.exception.ZipException {
        if (file == null) {
            throw new net.lingala.zip4j.exception.ZipException("outputZipFile is null, cannot merge split files");
        }
        if (file.exists()) {
            throw new net.lingala.zip4j.exception.ZipException("output Zip File already exists");
        }
        readZipInfo();
        if (this.zipModel == null) {
            throw new net.lingala.zip4j.exception.ZipException("zip model is null, corrupt zip file?");
        }
        new net.lingala.zip4j.tasks.MergeSplitZipFileTask(this.zipModel, buildAsyncParameters()).execute(new net.lingala.zip4j.tasks.MergeSplitZipFileTask.MergeSplitZipFileTaskParameters(file, buildConfig()));
    }

    public void setComment(java.lang.String str) throws net.lingala.zip4j.exception.ZipException {
        if (str == null) {
            throw new net.lingala.zip4j.exception.ZipException("input comment is null, cannot update zip file");
        }
        if (!this.zipFile.exists()) {
            throw new net.lingala.zip4j.exception.ZipException("zip file does not exist, cannot set comment for zip file");
        }
        readZipInfo();
        net.lingala.zip4j.model.ZipModel zipModel = this.zipModel;
        if (zipModel == null) {
            throw new net.lingala.zip4j.exception.ZipException("zipModel is null, cannot update zip file");
        }
        if (zipModel.getEndOfCentralDirectoryRecord() == null) {
            throw new net.lingala.zip4j.exception.ZipException("end of central directory is null, cannot set comment");
        }
        new net.lingala.zip4j.tasks.SetCommentTask(this.zipModel, buildAsyncParameters()).execute(new net.lingala.zip4j.tasks.SetCommentTask.SetCommentTaskTaskParameters(str, buildConfig()));
    }

    public java.lang.String getComment() throws net.lingala.zip4j.exception.ZipException {
        if (!this.zipFile.exists()) {
            throw new net.lingala.zip4j.exception.ZipException("zip file does not exist, cannot read comment");
        }
        readZipInfo();
        net.lingala.zip4j.model.ZipModel zipModel = this.zipModel;
        if (zipModel == null) {
            throw new net.lingala.zip4j.exception.ZipException("zip model is null, cannot read comment");
        }
        if (zipModel.getEndOfCentralDirectoryRecord() == null) {
            throw new net.lingala.zip4j.exception.ZipException("end of central directory record is null, cannot read comment");
        }
        return this.zipModel.getEndOfCentralDirectoryRecord().getComment();
    }

    public net.lingala.zip4j.io.inputstream.ZipInputStream getInputStream(net.lingala.zip4j.model.FileHeader fileHeader) throws java.io.IOException {
        if (fileHeader == null) {
            throw new net.lingala.zip4j.exception.ZipException("FileHeader is null, cannot get InputStream");
        }
        readZipInfo();
        net.lingala.zip4j.model.ZipModel zipModel = this.zipModel;
        if (zipModel == null) {
            throw new net.lingala.zip4j.exception.ZipException("zip model is null, cannot get inputstream");
        }
        net.lingala.zip4j.io.inputstream.ZipInputStream zipInputStreamCreateZipInputStream = net.lingala.zip4j.util.UnzipUtil.createZipInputStream(zipModel, fileHeader, this.password);
        this.openInputStreams.add(zipInputStreamCreateZipInputStream);
        return zipInputStreamCreateZipInputStream;
    }

    public boolean isValidZipFile() {
        if (!this.zipFile.exists()) {
            return false;
        }
        try {
            readZipInfo();
            return !this.zipModel.isSplitArchive() || verifyAllSplitFilesOfZipExists(getSplitZipFiles());
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    public java.util.List<java.io.File> getSplitZipFiles() throws net.lingala.zip4j.exception.ZipException {
        readZipInfo();
        return net.lingala.zip4j.util.FileUtils.getSplitZipFiles(this.zipModel);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        java.util.Iterator<java.io.InputStream> it = this.openInputStreams.iterator();
        while (it.hasNext()) {
            it.next().close();
        }
        this.openInputStreams.clear();
    }

    public void setPassword(char[] cArr) {
        this.password = cArr;
    }

    public int getBufferSize() {
        return this.bufferSize;
    }

    public void setBufferSize(int i) {
        if (i < 512) {
            throw new java.lang.IllegalArgumentException("Buffer size cannot be less than 512 bytes");
        }
        this.bufferSize = i;
    }

    private void readZipInfo() throws net.lingala.zip4j.exception.ZipException {
        if (this.zipModel != null) {
            return;
        }
        if (!this.zipFile.exists()) {
            createNewZipModel();
            return;
        }
        if (!this.zipFile.canRead()) {
            throw new net.lingala.zip4j.exception.ZipException("no read access for the input zip file");
        }
        try {
            java.io.RandomAccessFile randomAccessFileInitializeRandomAccessFileForHeaderReading = initializeRandomAccessFileForHeaderReading();
            try {
                net.lingala.zip4j.model.ZipModel allHeaders = new net.lingala.zip4j.headers.HeaderReader().readAllHeaders(randomAccessFileInitializeRandomAccessFileForHeaderReading, buildConfig());
                this.zipModel = allHeaders;
                allHeaders.setZipFile(this.zipFile);
                if (randomAccessFileInitializeRandomAccessFileForHeaderReading != null) {
                    randomAccessFileInitializeRandomAccessFileForHeaderReading.close();
                }
            } catch (java.lang.Throwable th) {
                if (randomAccessFileInitializeRandomAccessFileForHeaderReading != null) {
                    try {
                        randomAccessFileInitializeRandomAccessFileForHeaderReading.close();
                    } catch (java.lang.Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (net.lingala.zip4j.exception.ZipException e) {
            throw e;
        } catch (java.io.IOException e2) {
            throw new net.lingala.zip4j.exception.ZipException(e2);
        }
    }

    private void createNewZipModel() {
        net.lingala.zip4j.model.ZipModel zipModel = new net.lingala.zip4j.model.ZipModel();
        this.zipModel = zipModel;
        zipModel.setZipFile(this.zipFile);
    }

    private java.io.RandomAccessFile initializeRandomAccessFileForHeaderReading() throws java.io.IOException {
        if (net.lingala.zip4j.util.FileUtils.isNumberedSplitFile(this.zipFile)) {
            net.lingala.zip4j.io.inputstream.NumberedSplitRandomAccessFile numberedSplitRandomAccessFile = new net.lingala.zip4j.io.inputstream.NumberedSplitRandomAccessFile(this.zipFile, net.lingala.zip4j.model.enums.RandomAccessFileMode.READ.getValue(), net.lingala.zip4j.util.FileUtils.getAllSortedNumberedSplitFiles(this.zipFile));
            numberedSplitRandomAccessFile.openLastSplitFileForReading();
            return numberedSplitRandomAccessFile;
        }
        return new java.io.RandomAccessFile(this.zipFile, net.lingala.zip4j.model.enums.RandomAccessFileMode.READ.getValue());
    }

    private net.lingala.zip4j.tasks.AsyncZipTask.AsyncTaskParameters buildAsyncParameters() {
        if (this.runInThread) {
            if (this.threadFactory == null) {
                this.threadFactory = java.util.concurrent.Executors.defaultThreadFactory();
            }
            this.executorService = java.util.concurrent.Executors.newSingleThreadExecutor(this.threadFactory);
        }
        return new net.lingala.zip4j.tasks.AsyncZipTask.AsyncTaskParameters(this.executorService, this.runInThread, this.progressMonitor);
    }

    private boolean verifyAllSplitFilesOfZipExists(java.util.List<java.io.File> list) {
        java.util.Iterator<java.io.File> it = list.iterator();
        while (it.hasNext()) {
            if (!it.next().exists()) {
                return false;
            }
        }
        return true;
    }

    public net.lingala.zip4j.progress.ProgressMonitor getProgressMonitor() {
        return this.progressMonitor;
    }

    public boolean isRunInThread() {
        return this.runInThread;
    }

    public void setRunInThread(boolean z) {
        this.runInThread = z;
    }

    public java.io.File getFile() {
        return this.zipFile;
    }

    public java.nio.charset.Charset getCharset() {
        java.nio.charset.Charset charset = this.charset;
        return charset == null ? net.lingala.zip4j.util.InternalZipConstants.CHARSET_UTF_8 : charset;
    }

    public void setCharset(java.nio.charset.Charset charset) throws java.lang.IllegalArgumentException {
        if (charset == null) {
            throw new java.lang.IllegalArgumentException("charset cannot be null");
        }
        this.charset = charset;
    }

    public void setThreadFactory(java.util.concurrent.ThreadFactory threadFactory) {
        this.threadFactory = threadFactory;
    }

    public java.util.concurrent.ExecutorService getExecutorService() {
        return this.executorService;
    }

    public java.lang.String toString() {
        return this.zipFile.toString();
    }

    private net.lingala.zip4j.model.Zip4jConfig buildConfig() {
        return new net.lingala.zip4j.model.Zip4jConfig(this.charset, this.bufferSize, this.useUtf8CharsetForPasswords);
    }

    public boolean isUseUtf8CharsetForPasswords() {
        return this.useUtf8CharsetForPasswords;
    }

    public void setUseUtf8CharsetForPasswords(boolean z) {
        this.useUtf8CharsetForPasswords = z;
    }
}
