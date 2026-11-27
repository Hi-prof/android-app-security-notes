package master.flame.danmaku.danmaku.model.android;

/* JADX INFO: loaded from: classes2.dex */
public class Danmakus implements master.flame.danmaku.danmaku.model.IDanmakus {
    public static final int ST_BY_LIST = 4;
    public static final int ST_BY_TIME = 0;
    public static final int ST_BY_YPOS = 1;
    public static final int ST_BY_YPOS_DESC = 2;
    private master.flame.danmaku.danmaku.model.BaseDanmaku endItem;
    private master.flame.danmaku.danmaku.model.BaseDanmaku endSubItem;
    public java.util.Collection<master.flame.danmaku.danmaku.model.BaseDanmaku> items;
    private master.flame.danmaku.danmaku.model.android.Danmakus.DanmakuIterator iterator;
    private master.flame.danmaku.danmaku.model.android.Danmakus.BaseComparator mComparator;
    private boolean mDuplicateMergingEnabled;
    private int mSize;
    private int mSortType;
    private master.flame.danmaku.danmaku.model.BaseDanmaku startItem;
    private master.flame.danmaku.danmaku.model.BaseDanmaku startSubItem;
    private master.flame.danmaku.danmaku.model.android.Danmakus subItems;

    static /* synthetic */ int access$010(master.flame.danmaku.danmaku.model.android.Danmakus danmakus) {
        int i = danmakus.mSize;
        danmakus.mSize = i - 1;
        return i;
    }

    public Danmakus() {
        this(0, false);
    }

    public Danmakus(int i) {
        this(i, false);
    }

    public Danmakus(int i, boolean z) {
        master.flame.danmaku.danmaku.model.android.Danmakus.BaseComparator yPosDescComparator;
        this.mSize = 0;
        this.mSortType = 0;
        if (i == 0) {
            yPosDescComparator = new master.flame.danmaku.danmaku.model.android.Danmakus.TimeComparator(z);
        } else if (i == 1) {
            yPosDescComparator = new master.flame.danmaku.danmaku.model.android.Danmakus.YPosComparator(z);
        } else {
            yPosDescComparator = i == 2 ? new master.flame.danmaku.danmaku.model.android.Danmakus.YPosDescComparator(z) : null;
        }
        if (i == 4) {
            this.items = new java.util.LinkedList();
        } else {
            this.mDuplicateMergingEnabled = z;
            yPosDescComparator.setDuplicateMergingEnabled(z);
            this.items = new java.util.TreeSet(yPosDescComparator);
            this.mComparator = yPosDescComparator;
        }
        this.mSortType = i;
        this.mSize = 0;
        this.iterator = new master.flame.danmaku.danmaku.model.android.Danmakus.DanmakuIterator(this.items);
    }

    public Danmakus(java.util.Collection<master.flame.danmaku.danmaku.model.BaseDanmaku> collection) {
        this.mSize = 0;
        this.mSortType = 0;
        setItems(collection);
    }

    public Danmakus(boolean z) {
        this(0, z);
    }

    public void setItems(java.util.Collection<master.flame.danmaku.danmaku.model.BaseDanmaku> collection) {
        if (this.mDuplicateMergingEnabled && this.mSortType != 4) {
            this.items.clear();
            this.items.addAll(collection);
            collection = this.items;
        } else {
            this.items = collection;
        }
        if (collection instanceof java.util.List) {
            this.mSortType = 4;
        }
        this.mSize = collection == null ? 0 : collection.size();
        master.flame.danmaku.danmaku.model.android.Danmakus.DanmakuIterator danmakuIterator = this.iterator;
        if (danmakuIterator == null) {
            this.iterator = new master.flame.danmaku.danmaku.model.android.Danmakus.DanmakuIterator(collection);
        } else {
            danmakuIterator.setDatas(collection);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.IDanmakus
    public master.flame.danmaku.danmaku.model.IDanmakuIterator iterator() {
        this.iterator.reset();
        return this.iterator;
    }

    @Override // master.flame.danmaku.danmaku.model.IDanmakus
    public boolean addItem(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku) {
        java.util.Collection<master.flame.danmaku.danmaku.model.BaseDanmaku> collection = this.items;
        if (collection == null) {
            return false;
        }
        try {
            if (!collection.add(baseDanmaku)) {
                return false;
            }
            this.mSize++;
            return true;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // master.flame.danmaku.danmaku.model.IDanmakus
    public boolean removeItem(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku) {
        if (baseDanmaku == null) {
            return false;
        }
        if (baseDanmaku.isOutside()) {
            baseDanmaku.setVisibility(false);
        }
        if (!this.items.remove(baseDanmaku)) {
            return false;
        }
        this.mSize--;
        return true;
    }

    private java.util.Collection<master.flame.danmaku.danmaku.model.BaseDanmaku> subset(long j, long j2) {
        java.util.Collection<master.flame.danmaku.danmaku.model.BaseDanmaku> collection;
        if (this.mSortType == 4 || (collection = this.items) == null || collection.size() == 0) {
            return null;
        }
        if (this.subItems == null) {
            this.subItems = new master.flame.danmaku.danmaku.model.android.Danmakus(this.mDuplicateMergingEnabled);
        }
        if (this.startSubItem == null) {
            this.startSubItem = createItem("start");
        }
        if (this.endSubItem == null) {
            this.endSubItem = createItem("end");
        }
        this.startSubItem.setTime(j);
        this.endSubItem.setTime(j2);
        return ((java.util.SortedSet) this.items).subSet(this.startSubItem, this.endSubItem);
    }

    @Override // master.flame.danmaku.danmaku.model.IDanmakus
    public master.flame.danmaku.danmaku.model.IDanmakus subnew(long j, long j2) {
        java.util.Collection<master.flame.danmaku.danmaku.model.BaseDanmaku> collectionSubset = subset(j, j2);
        if (collectionSubset == null || collectionSubset.isEmpty()) {
            return null;
        }
        return new master.flame.danmaku.danmaku.model.android.Danmakus(new java.util.LinkedList(collectionSubset));
    }

    @Override // master.flame.danmaku.danmaku.model.IDanmakus
    public master.flame.danmaku.danmaku.model.IDanmakus sub(long j, long j2) {
        java.util.Collection<master.flame.danmaku.danmaku.model.BaseDanmaku> collection = this.items;
        if (collection == null || collection.size() == 0) {
            return null;
        }
        if (this.subItems == null) {
            if (this.mSortType == 4) {
                master.flame.danmaku.danmaku.model.android.Danmakus danmakus = new master.flame.danmaku.danmaku.model.android.Danmakus(4);
                this.subItems = danmakus;
                danmakus.setItems(this.items);
            } else {
                this.subItems = new master.flame.danmaku.danmaku.model.android.Danmakus(this.mDuplicateMergingEnabled);
            }
        }
        if (this.mSortType == 4) {
            return this.subItems;
        }
        if (this.startItem == null) {
            this.startItem = createItem("start");
        }
        if (this.endItem == null) {
            this.endItem = createItem("end");
        }
        if (this.subItems != null && j - this.startItem.getActualTime() >= 0 && j2 <= this.endItem.getActualTime()) {
            return this.subItems;
        }
        this.startItem.setTime(j);
        this.endItem.setTime(j2);
        this.subItems.setItems(((java.util.SortedSet) this.items).subSet(this.startItem, this.endItem));
        return this.subItems;
    }

    private master.flame.danmaku.danmaku.model.BaseDanmaku createItem(java.lang.String str) {
        return new master.flame.danmaku.danmaku.model.Danmaku(str);
    }

    @Override // master.flame.danmaku.danmaku.model.IDanmakus
    public int size() {
        return this.mSize;
    }

    @Override // master.flame.danmaku.danmaku.model.IDanmakus
    public void clear() {
        java.util.Collection<master.flame.danmaku.danmaku.model.BaseDanmaku> collection = this.items;
        if (collection != null) {
            collection.clear();
            this.mSize = 0;
            this.iterator = new master.flame.danmaku.danmaku.model.android.Danmakus.DanmakuIterator(this.items);
        }
        if (this.subItems != null) {
            this.subItems = null;
            this.startItem = createItem("start");
            this.endItem = createItem("end");
        }
    }

    @Override // master.flame.danmaku.danmaku.model.IDanmakus
    public master.flame.danmaku.danmaku.model.BaseDanmaku first() {
        java.util.Collection<master.flame.danmaku.danmaku.model.BaseDanmaku> collection = this.items;
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        if (this.mSortType == 4) {
            return (master.flame.danmaku.danmaku.model.BaseDanmaku) ((java.util.LinkedList) this.items).peek();
        }
        return (master.flame.danmaku.danmaku.model.BaseDanmaku) ((java.util.SortedSet) this.items).first();
    }

    @Override // master.flame.danmaku.danmaku.model.IDanmakus
    public master.flame.danmaku.danmaku.model.BaseDanmaku last() {
        java.util.Collection<master.flame.danmaku.danmaku.model.BaseDanmaku> collection = this.items;
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        if (this.mSortType == 4) {
            return (master.flame.danmaku.danmaku.model.BaseDanmaku) ((java.util.LinkedList) this.items).peekLast();
        }
        return (master.flame.danmaku.danmaku.model.BaseDanmaku) ((java.util.SortedSet) this.items).last();
    }

    private class DanmakuIterator implements master.flame.danmaku.danmaku.model.IDanmakuIterator {
        private java.util.Iterator<master.flame.danmaku.danmaku.model.BaseDanmaku> it;
        private java.util.Collection<master.flame.danmaku.danmaku.model.BaseDanmaku> mData;
        private boolean mIteratorUsed;

        public DanmakuIterator(java.util.Collection<master.flame.danmaku.danmaku.model.BaseDanmaku> collection) {
            setDatas(collection);
        }

        @Override // master.flame.danmaku.danmaku.model.IDanmakuIterator
        public synchronized void reset() {
            if (this.mIteratorUsed || this.it == null) {
                if (this.mData != null && master.flame.danmaku.danmaku.model.android.Danmakus.this.mSize > 0) {
                    this.it = this.mData.iterator();
                } else {
                    this.it = null;
                }
                this.mIteratorUsed = false;
            }
        }

        public synchronized void setDatas(java.util.Collection<master.flame.danmaku.danmaku.model.BaseDanmaku> collection) {
            if (this.mData != collection) {
                this.mIteratorUsed = false;
                this.it = null;
            }
            this.mData = collection;
        }

        @Override // master.flame.danmaku.danmaku.model.IDanmakuIterator
        public synchronized master.flame.danmaku.danmaku.model.BaseDanmaku next() {
            java.util.Iterator<master.flame.danmaku.danmaku.model.BaseDanmaku> it;
            this.mIteratorUsed = true;
            it = this.it;
            return it != null ? it.next() : null;
        }

        @Override // master.flame.danmaku.danmaku.model.IDanmakuIterator
        public synchronized boolean hasNext() {
            java.util.Iterator<master.flame.danmaku.danmaku.model.BaseDanmaku> it;
            it = this.it;
            return it != null && it.hasNext();
        }

        @Override // master.flame.danmaku.danmaku.model.IDanmakuIterator
        public synchronized void remove() {
            this.mIteratorUsed = true;
            java.util.Iterator<master.flame.danmaku.danmaku.model.BaseDanmaku> it = this.it;
            if (it != null) {
                it.remove();
                master.flame.danmaku.danmaku.model.android.Danmakus.access$010(master.flame.danmaku.danmaku.model.android.Danmakus.this);
            }
        }
    }

    private class BaseComparator implements java.util.Comparator<master.flame.danmaku.danmaku.model.BaseDanmaku> {
        protected boolean mDuplicateMergingEnable;

        public BaseComparator(boolean z) {
            setDuplicateMergingEnabled(z);
        }

        public void setDuplicateMergingEnabled(boolean z) {
            this.mDuplicateMergingEnable = z;
        }

        @Override // java.util.Comparator
        public int compare(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku, master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku2) {
            if (this.mDuplicateMergingEnable && master.flame.danmaku.danmaku.util.DanmakuUtils.isDuplicate(baseDanmaku, baseDanmaku2)) {
                return 0;
            }
            return master.flame.danmaku.danmaku.util.DanmakuUtils.compare(baseDanmaku, baseDanmaku2);
        }
    }

    private class TimeComparator extends master.flame.danmaku.danmaku.model.android.Danmakus.BaseComparator {
        public TimeComparator(boolean z) {
            super(z);
        }

        @Override // master.flame.danmaku.danmaku.model.android.Danmakus.BaseComparator, java.util.Comparator
        public int compare(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku, master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku2) {
            return super.compare(baseDanmaku, baseDanmaku2);
        }
    }

    private class YPosComparator extends master.flame.danmaku.danmaku.model.android.Danmakus.BaseComparator {
        public YPosComparator(boolean z) {
            super(z);
        }

        @Override // master.flame.danmaku.danmaku.model.android.Danmakus.BaseComparator, java.util.Comparator
        public int compare(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku, master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku2) {
            if (this.mDuplicateMergingEnable && master.flame.danmaku.danmaku.util.DanmakuUtils.isDuplicate(baseDanmaku, baseDanmaku2)) {
                return 0;
            }
            return java.lang.Float.compare(baseDanmaku.getTop(), baseDanmaku2.getTop());
        }
    }

    private class YPosDescComparator extends master.flame.danmaku.danmaku.model.android.Danmakus.BaseComparator {
        public YPosDescComparator(boolean z) {
            super(z);
        }

        @Override // master.flame.danmaku.danmaku.model.android.Danmakus.BaseComparator, java.util.Comparator
        public int compare(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku, master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku2) {
            if (this.mDuplicateMergingEnable && master.flame.danmaku.danmaku.util.DanmakuUtils.isDuplicate(baseDanmaku, baseDanmaku2)) {
                return 0;
            }
            return java.lang.Float.compare(baseDanmaku2.getTop(), baseDanmaku.getTop());
        }
    }

    @Override // master.flame.danmaku.danmaku.model.IDanmakus
    public boolean contains(master.flame.danmaku.danmaku.model.BaseDanmaku baseDanmaku) {
        java.util.Collection<master.flame.danmaku.danmaku.model.BaseDanmaku> collection = this.items;
        return collection != null && collection.contains(baseDanmaku);
    }

    @Override // master.flame.danmaku.danmaku.model.IDanmakus
    public boolean isEmpty() {
        java.util.Collection<master.flame.danmaku.danmaku.model.BaseDanmaku> collection = this.items;
        return collection == null || collection.isEmpty();
    }

    private void setDuplicateMergingEnabled(boolean z) {
        this.mComparator.setDuplicateMergingEnabled(z);
        this.mDuplicateMergingEnabled = z;
    }

    @Override // master.flame.danmaku.danmaku.model.IDanmakus
    public void setSubItemsDuplicateMergingEnabled(boolean z) {
        this.mDuplicateMergingEnabled = z;
        this.endItem = null;
        this.startItem = null;
        if (this.subItems == null) {
            this.subItems = new master.flame.danmaku.danmaku.model.android.Danmakus(z);
        }
        this.subItems.setDuplicateMergingEnabled(z);
    }
}
