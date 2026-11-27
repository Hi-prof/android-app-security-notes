package net.lingala.zip4j.tasks;

/* JADX INFO: loaded from: classes2.dex */
abstract class AbstractModifyFileTask<T> extends net.lingala.zip4j.tasks.AsyncZipTask<T> {
    AbstractModifyFileTask(net.lingala.zip4j.tasks.AsyncZipTask.AsyncTaskParameters asyncTaskParameters) {
        super(asyncTaskParameters);
    }

    java.io.File getTemporaryFile(java.lang.String str) {
        java.security.SecureRandom secureRandom = new java.security.SecureRandom();
        java.io.File file = new java.io.File(str + secureRandom.nextInt(io.dcloud.feature.gg.dcloud.ADSim.INTISPLSH));
        while (file.exists()) {
            file = new java.io.File(str + secureRandom.nextInt(io.dcloud.feature.gg.dcloud.ADSim.INTISPLSH));
        }
        return file;
    }

    void updateOffsetsForAllSubsequentFileHeaders(java.util.List<net.lingala.zip4j.model.FileHeader> list, net.lingala.zip4j.model.ZipModel zipModel, net.lingala.zip4j.model.FileHeader fileHeader, long j) throws net.lingala.zip4j.exception.ZipException {
        int indexOfFileHeader = getIndexOfFileHeader(list, fileHeader);
        if (indexOfFileHeader == -1) {
            throw new net.lingala.zip4j.exception.ZipException("Could not locate modified file header in zipModel");
        }
        while (true) {
            indexOfFileHeader++;
            if (indexOfFileHeader >= list.size()) {
                return;
            }
            net.lingala.zip4j.model.FileHeader fileHeader2 = list.get(indexOfFileHeader);
            fileHeader2.setOffsetLocalHeader(fileHeader2.getOffsetLocalHeader() + j);
            if (zipModel.isZip64Format() && fileHeader2.getZip64ExtendedInfo() != null && fileHeader2.getZip64ExtendedInfo().getOffsetLocalHeader() != -1) {
                fileHeader2.getZip64ExtendedInfo().setOffsetLocalHeader(fileHeader2.getZip64ExtendedInfo().getOffsetLocalHeader() + j);
            }
        }
    }

    void cleanupFile(boolean z, java.io.File file, java.io.File file2) throws net.lingala.zip4j.exception.ZipException {
        if (z) {
            restoreFileName(file, file2);
        } else if (!file2.delete()) {
            throw new net.lingala.zip4j.exception.ZipException("Could not delete temporary file");
        }
    }

    long copyFile(java.io.RandomAccessFile randomAccessFile, java.io.OutputStream outputStream, long j, long j2, net.lingala.zip4j.progress.ProgressMonitor progressMonitor, int i) throws java.io.IOException {
        net.lingala.zip4j.util.FileUtils.copyFile(randomAccessFile, outputStream, j, j + j2, progressMonitor, i);
        return j2;
    }

    java.util.List<net.lingala.zip4j.model.FileHeader> cloneAndSortFileHeadersByOffset(java.util.List<net.lingala.zip4j.model.FileHeader> list) {
        java.util.ArrayList arrayList = new java.util.ArrayList(list);
        java.util.Collections.sort(arrayList, new java.util.Comparator<net.lingala.zip4j.model.FileHeader>() { // from class: net.lingala.zip4j.tasks.AbstractModifyFileTask.1
            @Override // java.util.Comparator
            public int compare(net.lingala.zip4j.model.FileHeader fileHeader, net.lingala.zip4j.model.FileHeader fileHeader2) {
                if (fileHeader.getFileName().equals(fileHeader2.getFileName())) {
                    return 0;
                }
                return fileHeader.getOffsetLocalHeader() < fileHeader2.getOffsetLocalHeader() ? -1 : 1;
            }
        });
        return arrayList;
    }

    long getOffsetOfNextEntry(java.util.List<net.lingala.zip4j.model.FileHeader> list, net.lingala.zip4j.model.FileHeader fileHeader, net.lingala.zip4j.model.ZipModel zipModel) throws net.lingala.zip4j.exception.ZipException {
        int indexOfFileHeader = getIndexOfFileHeader(list, fileHeader);
        if (indexOfFileHeader == list.size() - 1) {
            return net.lingala.zip4j.headers.HeaderUtil.getOffsetStartOfCentralDirectory(zipModel);
        }
        return list.get(indexOfFileHeader + 1).getOffsetLocalHeader();
    }

    private void restoreFileName(java.io.File file, java.io.File file2) throws net.lingala.zip4j.exception.ZipException {
        if (file.delete()) {
            if (!file2.renameTo(file)) {
                throw new net.lingala.zip4j.exception.ZipException("cannot rename modified zip file");
            }
            return;
        }
        throw new net.lingala.zip4j.exception.ZipException("cannot delete old zip file");
    }

    private int getIndexOfFileHeader(java.util.List<net.lingala.zip4j.model.FileHeader> list, net.lingala.zip4j.model.FileHeader fileHeader) throws net.lingala.zip4j.exception.ZipException {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(fileHeader)) {
                return i;
            }
        }
        throw new net.lingala.zip4j.exception.ZipException("Could not find file header in list of central directory file headers");
    }
}
