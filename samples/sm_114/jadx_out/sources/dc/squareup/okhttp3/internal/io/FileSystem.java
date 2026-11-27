package dc.squareup.okhttp3.internal.io;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public interface FileSystem {
    public static final dc.squareup.okhttp3.internal.io.FileSystem SYSTEM = new dc.squareup.okhttp3.internal.io.FileSystem() { // from class: dc.squareup.okhttp3.internal.io.FileSystem.1
        @Override // dc.squareup.okhttp3.internal.io.FileSystem
        public dc.squareup.okio.Sink appendingSink(java.io.File file) throws java.io.FileNotFoundException {
            try {
                return dc.squareup.okio.Okio.appendingSink(file);
            } catch (java.io.FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return dc.squareup.okio.Okio.appendingSink(file);
            }
        }

        @Override // dc.squareup.okhttp3.internal.io.FileSystem
        public void delete(java.io.File file) throws java.io.IOException {
            if (file.delete() || !file.exists()) {
                return;
            }
            throw new java.io.IOException("failed to delete " + file);
        }

        @Override // dc.squareup.okhttp3.internal.io.FileSystem
        public void deleteContents(java.io.File file) throws java.io.IOException {
            java.io.File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                throw new java.io.IOException("not a readable directory: " + file);
            }
            for (java.io.File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    deleteContents(file2);
                }
                if (!file2.delete()) {
                    throw new java.io.IOException("failed to delete " + file2);
                }
            }
        }

        @Override // dc.squareup.okhttp3.internal.io.FileSystem
        public boolean exists(java.io.File file) {
            return file.exists();
        }

        @Override // dc.squareup.okhttp3.internal.io.FileSystem
        public void rename(java.io.File file, java.io.File file2) throws java.io.IOException {
            delete(file2);
            if (file.renameTo(file2)) {
                return;
            }
            throw new java.io.IOException("failed to rename " + file + " to " + file2);
        }

        @Override // dc.squareup.okhttp3.internal.io.FileSystem
        public dc.squareup.okio.Sink sink(java.io.File file) throws java.io.FileNotFoundException {
            try {
                return dc.squareup.okio.Okio.sink(file);
            } catch (java.io.FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return dc.squareup.okio.Okio.sink(file);
            }
        }

        @Override // dc.squareup.okhttp3.internal.io.FileSystem
        public long size(java.io.File file) {
            return file.length();
        }

        @Override // dc.squareup.okhttp3.internal.io.FileSystem
        public dc.squareup.okio.Source source(java.io.File file) throws java.io.FileNotFoundException {
            return dc.squareup.okio.Okio.source(file);
        }
    };

    dc.squareup.okio.Sink appendingSink(java.io.File file) throws java.io.FileNotFoundException;

    void delete(java.io.File file) throws java.io.IOException;

    void deleteContents(java.io.File file) throws java.io.IOException;

    boolean exists(java.io.File file);

    void rename(java.io.File file, java.io.File file2) throws java.io.IOException;

    dc.squareup.okio.Sink sink(java.io.File file) throws java.io.FileNotFoundException;

    long size(java.io.File file);

    dc.squareup.okio.Source source(java.io.File file) throws java.io.FileNotFoundException;
}
