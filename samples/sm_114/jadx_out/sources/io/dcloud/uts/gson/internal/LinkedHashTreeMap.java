package io.dcloud.uts.gson.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class LinkedHashTreeMap<K, V> extends java.util.AbstractMap<K, V> implements java.io.Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final java.util.Comparator<java.lang.Comparable> NATURAL_ORDER = new java.util.Comparator<java.lang.Comparable>() { // from class: io.dcloud.uts.gson.internal.LinkedHashTreeMap.1
        @Override // java.util.Comparator
        public int compare(java.lang.Comparable comparable, java.lang.Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    };
    java.util.Comparator<? super K> comparator;
    private io.dcloud.uts.gson.internal.LinkedHashTreeMap<K, V>.EntrySet entrySet;
    final io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> header;
    private io.dcloud.uts.gson.internal.LinkedHashTreeMap<K, V>.KeySet keySet;
    int modCount;
    int size;
    io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V>[] table;
    int threshold;

    private static int secondaryHash(int i) {
        int i2 = i ^ ((i >>> 20) ^ (i >>> 12));
        return (i2 >>> 4) ^ ((i2 >>> 7) ^ i2);
    }

    public LinkedHashTreeMap() {
        this(NATURAL_ORDER);
    }

    public LinkedHashTreeMap(java.util.Comparator<? super K> comparator) {
        this.size = 0;
        this.modCount = 0;
        this.comparator = comparator == null ? NATURAL_ORDER : comparator;
        this.header = new io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<>();
        io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V>[] nodeArr = new io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node[16];
        this.table = nodeArr;
        this.threshold = (nodeArr.length / 2) + (nodeArr.length / 4);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(java.lang.Object obj) {
        io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> nodeFindByObject = findByObject(obj);
        if (nodeFindByObject != null) {
            return nodeFindByObject.value;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(java.lang.Object obj) {
        return findByObject(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        if (k == null) {
            throw new java.lang.NullPointerException("key == null");
        }
        io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> nodeFind = find(k, true);
        V v2 = nodeFind.value;
        nodeFind.value = v;
        return v2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        java.util.Arrays.fill(this.table, (java.lang.Object) null);
        this.size = 0;
        this.modCount++;
        io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> node = this.header;
        io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> node2 = node.next;
        while (node2 != node) {
            io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> node3 = node2.next;
            node2.prev = null;
            node2.next = null;
            node2 = node3;
        }
        node.prev = node;
        node.next = node;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(java.lang.Object obj) {
        io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> nodeRemoveInternalByKey = removeInternalByKey(obj);
        if (nodeRemoveInternalByKey != null) {
            return nodeRemoveInternalByKey.value;
        }
        return null;
    }

    io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> find(K k, boolean z) {
        int i;
        io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> node;
        int iCompare;
        java.util.Comparator<? super K> comparator = this.comparator;
        io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V>[] nodeArr = this.table;
        int iSecondaryHash = secondaryHash(k.hashCode());
        int length = (nodeArr.length - 1) & iSecondaryHash;
        io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> node2 = nodeArr[length];
        if (node2 != null) {
            java.lang.Comparable comparable = comparator == NATURAL_ORDER ? (java.lang.Comparable) k : null;
            while (true) {
                if (comparable != null) {
                    iCompare = comparable.compareTo(node2.key);
                } else {
                    iCompare = comparator.compare(k, node2.key);
                }
                if (iCompare == 0) {
                    return node2;
                }
                io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> node3 = iCompare < 0 ? node2.left : node2.right;
                if (node3 == null) {
                    i = iCompare;
                    break;
                }
                node2 = node3;
            }
        } else {
            i = 0;
        }
        if (!z) {
            return null;
        }
        io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> node4 = this.header;
        if (node2 == null) {
            if (comparator == NATURAL_ORDER && !(k instanceof java.lang.Comparable)) {
                throw new java.lang.ClassCastException(k.getClass().getName() + " is not Comparable");
            }
            node = new io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<>(node2, k, iSecondaryHash, node4, node4.prev);
            nodeArr[length] = node;
        } else {
            io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> node5 = node2;
            node = new io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<>(node5, k, iSecondaryHash, node4, node4.prev);
            if (i < 0) {
                node5.left = node;
            } else {
                node5.right = node;
            }
            rebalance(node5, true);
        }
        int i2 = this.size;
        this.size = i2 + 1;
        if (i2 > this.threshold) {
            doubleCapacity();
        }
        this.modCount++;
        return node;
    }

    /* JADX WARN: Multi-variable type inference failed */
    io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> findByObject(java.lang.Object obj) {
        if (obj != 0) {
            try {
                return find(obj, false);
            } catch (java.lang.ClassCastException unused) {
            }
        }
        return null;
    }

    io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> findByEntry(java.util.Map.Entry<?, ?> entry) {
        io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> nodeFindByObject = findByObject(entry.getKey());
        if (nodeFindByObject == null || !equal(nodeFindByObject.value, entry.getValue())) {
            return null;
        }
        return nodeFindByObject;
    }

    private boolean equal(java.lang.Object obj, java.lang.Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    void removeInternal(io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> node, boolean z) {
        int i;
        if (z) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = null;
            node.next = null;
        }
        io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> node2 = node.left;
        io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> node3 = node.right;
        io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> node4 = node.parent;
        int i2 = 0;
        if (node2 != null && node3 != null) {
            io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> nodeLast = node2.height > node3.height ? node2.last() : node3.first();
            removeInternal(nodeLast, false);
            io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> node5 = node.left;
            if (node5 != null) {
                i = node5.height;
                nodeLast.left = node5;
                node5.parent = nodeLast;
                node.left = null;
            } else {
                i = 0;
            }
            io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> node6 = node.right;
            if (node6 != null) {
                i2 = node6.height;
                nodeLast.right = node6;
                node6.parent = nodeLast;
                node.right = null;
            }
            nodeLast.height = java.lang.Math.max(i, i2) + 1;
            replaceInParent(node, nodeLast);
            return;
        }
        if (node2 != null) {
            replaceInParent(node, node2);
            node.left = null;
        } else if (node3 != null) {
            replaceInParent(node, node3);
            node.right = null;
        } else {
            replaceInParent(node, null);
        }
        rebalance(node4, false);
        this.size--;
        this.modCount++;
    }

    io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> removeInternalByKey(java.lang.Object obj) {
        io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> nodeFindByObject = findByObject(obj);
        if (nodeFindByObject != null) {
            removeInternal(nodeFindByObject, true);
        }
        return nodeFindByObject;
    }

    private void replaceInParent(io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> node, io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> node2) {
        io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> node3 = node.parent;
        node.parent = null;
        if (node2 != null) {
            node2.parent = node3;
        }
        if (node3 != null) {
            if (node3.left == node) {
                node3.left = node2;
                return;
            } else {
                node3.right = node2;
                return;
            }
        }
        int i = node.hash;
        io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V>[] nodeArr = this.table;
        nodeArr[i & (nodeArr.length - 1)] = node2;
    }

    private void rebalance(io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> node, boolean z) {
        while (node != null) {
            io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> node2 = node.left;
            io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> node3 = node.right;
            int i = node2 != null ? node2.height : 0;
            int i2 = node3 != null ? node3.height : 0;
            int i3 = i - i2;
            if (i3 == -2) {
                io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> node4 = node3.left;
                io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> node5 = node3.right;
                int i4 = (node4 != null ? node4.height : 0) - (node5 != null ? node5.height : 0);
                if (i4 == -1 || (i4 == 0 && !z)) {
                    rotateLeft(node);
                } else {
                    rotateRight(node3);
                    rotateLeft(node);
                }
                if (z) {
                    return;
                }
            } else if (i3 == 2) {
                io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> node6 = node2.left;
                io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> node7 = node2.right;
                int i5 = (node6 != null ? node6.height : 0) - (node7 != null ? node7.height : 0);
                if (i5 == 1 || (i5 == 0 && !z)) {
                    rotateRight(node);
                } else {
                    rotateLeft(node2);
                    rotateRight(node);
                }
                if (z) {
                    return;
                }
            } else if (i3 == 0) {
                node.height = i + 1;
                if (z) {
                    return;
                }
            } else {
                node.height = java.lang.Math.max(i, i2) + 1;
                if (!z) {
                    return;
                }
            }
            node = node.parent;
        }
    }

    private void rotateLeft(io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> node) {
        io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> node2 = node.left;
        io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> node3 = node.right;
        io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> node4 = node3.left;
        io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> node5 = node3.right;
        node.right = node4;
        if (node4 != null) {
            node4.parent = node;
        }
        replaceInParent(node, node3);
        node3.left = node;
        node.parent = node3;
        node.height = java.lang.Math.max(node2 != null ? node2.height : 0, node4 != null ? node4.height : 0) + 1;
        node3.height = java.lang.Math.max(node.height, node5 != null ? node5.height : 0) + 1;
    }

    private void rotateRight(io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> node) {
        io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> node2 = node.left;
        io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> node3 = node.right;
        io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> node4 = node2.left;
        io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> node5 = node2.right;
        node.left = node5;
        if (node5 != null) {
            node5.parent = node;
        }
        replaceInParent(node, node2);
        node2.right = node;
        node.parent = node2;
        node.height = java.lang.Math.max(node3 != null ? node3.height : 0, node5 != null ? node5.height : 0) + 1;
        node2.height = java.lang.Math.max(node.height, node4 != null ? node4.height : 0) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public java.util.Set<java.util.Map.Entry<K, V>> entrySet() {
        io.dcloud.uts.gson.internal.LinkedHashTreeMap<K, V>.EntrySet entrySet = this.entrySet;
        if (entrySet != null) {
            return entrySet;
        }
        io.dcloud.uts.gson.internal.LinkedHashTreeMap<K, V>.EntrySet entrySet2 = new io.dcloud.uts.gson.internal.LinkedHashTreeMap.EntrySet();
        this.entrySet = entrySet2;
        return entrySet2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public java.util.Set<K> keySet() {
        io.dcloud.uts.gson.internal.LinkedHashTreeMap<K, V>.KeySet keySet = this.keySet;
        if (keySet != null) {
            return keySet;
        }
        io.dcloud.uts.gson.internal.LinkedHashTreeMap<K, V>.KeySet keySet2 = new io.dcloud.uts.gson.internal.LinkedHashTreeMap.KeySet();
        this.keySet = keySet2;
        return keySet2;
    }

    static final class Node<K, V> implements java.util.Map.Entry<K, V> {
        final int hash;
        int height;
        final K key;
        io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> left;
        io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> next;
        io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> parent;
        io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> prev;
        io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> right;
        V value;

        Node() {
            this.key = null;
            this.hash = -1;
            this.prev = this;
            this.next = this;
        }

        Node(io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> node, K k, int i, io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> node2, io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> node3) {
            this.parent = node;
            this.key = k;
            this.hash = i;
            this.height = 1;
            this.next = node2;
            this.prev = node3;
            node3.next = this;
            node2.prev = this;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = this.value;
            this.value = v;
            return v2;
        }

        @Override // java.util.Map.Entry
        public boolean equals(java.lang.Object obj) {
            if (obj instanceof java.util.Map.Entry) {
                java.util.Map.Entry entry = (java.util.Map.Entry) obj;
                K k = this.key;
                if (k != null ? k.equals(entry.getKey()) : entry.getKey() == null) {
                    V v = this.value;
                    if (v == null) {
                        if (entry.getValue() == null) {
                            return true;
                        }
                    } else if (v.equals(entry.getValue())) {
                        return true;
                    }
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k = this.key;
            int iHashCode = k == null ? 0 : k.hashCode();
            V v = this.value;
            return iHashCode ^ (v != null ? v.hashCode() : 0);
        }

        public java.lang.String toString() {
            return this.key + "=" + this.value;
        }

        public io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> first() {
            io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> node = this;
            for (io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> node2 = this.left; node2 != null; node2 = node2.left) {
                node = node2;
            }
            return node;
        }

        public io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> last() {
            io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> node = this;
            for (io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> node2 = this.right; node2 != null; node2 = node2.right) {
                node = node2;
            }
            return node;
        }
    }

    private void doubleCapacity() {
        io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V>[] nodeArrDoubleCapacity = doubleCapacity(this.table);
        this.table = nodeArrDoubleCapacity;
        this.threshold = (nodeArrDoubleCapacity.length / 2) + (nodeArrDoubleCapacity.length / 4);
    }

    static <K, V> io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V>[] doubleCapacity(io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V>[] nodeArr) {
        int length = nodeArr.length;
        io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V>[] nodeArr2 = new io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node[length * 2];
        io.dcloud.uts.gson.internal.LinkedHashTreeMap.AvlIterator avlIterator = new io.dcloud.uts.gson.internal.LinkedHashTreeMap.AvlIterator();
        io.dcloud.uts.gson.internal.LinkedHashTreeMap.AvlBuilder avlBuilder = new io.dcloud.uts.gson.internal.LinkedHashTreeMap.AvlBuilder();
        io.dcloud.uts.gson.internal.LinkedHashTreeMap.AvlBuilder avlBuilder2 = new io.dcloud.uts.gson.internal.LinkedHashTreeMap.AvlBuilder();
        for (int i = 0; i < length; i++) {
            io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> node = nodeArr[i];
            if (node != null) {
                avlIterator.reset(node);
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> next = avlIterator.next();
                    if (next == null) {
                        break;
                    }
                    if ((next.hash & length) == 0) {
                        i2++;
                    } else {
                        i3++;
                    }
                }
                avlBuilder.reset(i2);
                avlBuilder2.reset(i3);
                avlIterator.reset(node);
                while (true) {
                    io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> next2 = avlIterator.next();
                    if (next2 == null) {
                        break;
                    }
                    if ((next2.hash & length) == 0) {
                        avlBuilder.add(next2);
                    } else {
                        avlBuilder2.add(next2);
                    }
                }
                nodeArr2[i] = i2 > 0 ? avlBuilder.root() : null;
                nodeArr2[i + length] = i3 > 0 ? avlBuilder2.root() : null;
            }
        }
        return nodeArr2;
    }

    static class AvlIterator<K, V> {
        private io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> stackTop;

        AvlIterator() {
        }

        void reset(io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> node) {
            io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> node2 = null;
            while (node != null) {
                node.parent = node2;
                node2 = node;
                node = node.left;
            }
            this.stackTop = node2;
        }

        public io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> next() {
            io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> node = this.stackTop;
            if (node == null) {
                return null;
            }
            io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> node2 = node.parent;
            node.parent = null;
            io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> node3 = node.right;
            while (true) {
                io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> node4 = node2;
                node2 = node3;
                if (node2 != null) {
                    node2.parent = node4;
                    node3 = node2.left;
                } else {
                    this.stackTop = node4;
                    return node;
                }
            }
        }
    }

    static final class AvlBuilder<K, V> {
        private int leavesSkipped;
        private int leavesToSkip;
        private int size;
        private io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> stack;

        AvlBuilder() {
        }

        void reset(int i) {
            this.leavesToSkip = ((java.lang.Integer.highestOneBit(i) * 2) - 1) - i;
            this.size = 0;
            this.leavesSkipped = 0;
            this.stack = null;
        }

        void add(io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> node) {
            node.right = null;
            node.parent = null;
            node.left = null;
            node.height = 1;
            int i = this.leavesToSkip;
            if (i > 0) {
                int i2 = this.size;
                if ((i2 & 1) == 0) {
                    this.size = i2 + 1;
                    this.leavesToSkip = i - 1;
                    this.leavesSkipped++;
                }
            }
            node.parent = this.stack;
            this.stack = node;
            int i3 = this.size;
            int i4 = i3 + 1;
            this.size = i4;
            int i5 = this.leavesToSkip;
            if (i5 > 0 && (i4 & 1) == 0) {
                this.size = i3 + 2;
                this.leavesToSkip = i5 - 1;
                this.leavesSkipped++;
            }
            int i6 = 4;
            while (true) {
                int i7 = i6 - 1;
                if ((this.size & i7) != i7) {
                    return;
                }
                int i8 = this.leavesSkipped;
                if (i8 == 0) {
                    io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> node2 = this.stack;
                    io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> node3 = node2.parent;
                    io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> node4 = node3.parent;
                    node3.parent = node4.parent;
                    this.stack = node3;
                    node3.left = node4;
                    node3.right = node2;
                    node3.height = node2.height + 1;
                    node4.parent = node3;
                    node2.parent = node3;
                } else if (i8 == 1) {
                    io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> node5 = this.stack;
                    io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> node6 = node5.parent;
                    this.stack = node6;
                    node6.right = node5;
                    node6.height = node5.height + 1;
                    node5.parent = node6;
                    this.leavesSkipped = 0;
                } else if (i8 == 2) {
                    this.leavesSkipped = 0;
                }
                i6 *= 2;
            }
        }

        io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> root() {
            io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> node = this.stack;
            if (node.parent == null) {
                return node;
            }
            throw new java.lang.IllegalStateException();
        }
    }

    private abstract class LinkedTreeMapIterator<T> implements java.util.Iterator<T> {
        int expectedModCount;
        io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> lastReturned = null;
        io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> next;

        LinkedTreeMapIterator() {
            this.next = io.dcloud.uts.gson.internal.LinkedHashTreeMap.this.header.next;
            this.expectedModCount = io.dcloud.uts.gson.internal.LinkedHashTreeMap.this.modCount;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.next != io.dcloud.uts.gson.internal.LinkedHashTreeMap.this.header;
        }

        final io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> nextNode() {
            io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> node = this.next;
            if (node == io.dcloud.uts.gson.internal.LinkedHashTreeMap.this.header) {
                throw new java.util.NoSuchElementException();
            }
            if (io.dcloud.uts.gson.internal.LinkedHashTreeMap.this.modCount != this.expectedModCount) {
                throw new java.util.ConcurrentModificationException();
            }
            this.next = node.next;
            this.lastReturned = node;
            return node;
        }

        @Override // java.util.Iterator
        public final void remove() {
            io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> node = this.lastReturned;
            if (node == null) {
                throw new java.lang.IllegalStateException();
            }
            io.dcloud.uts.gson.internal.LinkedHashTreeMap.this.removeInternal(node, true);
            this.lastReturned = null;
            this.expectedModCount = io.dcloud.uts.gson.internal.LinkedHashTreeMap.this.modCount;
        }
    }

    final class EntrySet extends java.util.AbstractSet<java.util.Map.Entry<K, V>> {
        EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return io.dcloud.uts.gson.internal.LinkedHashTreeMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public java.util.Iterator<java.util.Map.Entry<K, V>> iterator() {
            return new io.dcloud.uts.gson.internal.LinkedHashTreeMap<K, V>.LinkedTreeMapIterator<java.util.Map.Entry<K, V>>() { // from class: io.dcloud.uts.gson.internal.LinkedHashTreeMap.EntrySet.1
                {
                    io.dcloud.uts.gson.internal.LinkedHashTreeMap linkedHashTreeMap = io.dcloud.uts.gson.internal.LinkedHashTreeMap.this;
                }

                @Override // java.util.Iterator
                public java.util.Map.Entry<K, V> next() {
                    return nextNode();
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(java.lang.Object obj) {
            return (obj instanceof java.util.Map.Entry) && io.dcloud.uts.gson.internal.LinkedHashTreeMap.this.findByEntry((java.util.Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(java.lang.Object obj) {
            io.dcloud.uts.gson.internal.LinkedHashTreeMap.Node<K, V> nodeFindByEntry;
            if (!(obj instanceof java.util.Map.Entry) || (nodeFindByEntry = io.dcloud.uts.gson.internal.LinkedHashTreeMap.this.findByEntry((java.util.Map.Entry) obj)) == null) {
                return false;
            }
            io.dcloud.uts.gson.internal.LinkedHashTreeMap.this.removeInternal(nodeFindByEntry, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            io.dcloud.uts.gson.internal.LinkedHashTreeMap.this.clear();
        }
    }

    final class KeySet extends java.util.AbstractSet<K> {
        KeySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return io.dcloud.uts.gson.internal.LinkedHashTreeMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public java.util.Iterator<K> iterator() {
            return new io.dcloud.uts.gson.internal.LinkedHashTreeMap<K, V>.LinkedTreeMapIterator<K>() { // from class: io.dcloud.uts.gson.internal.LinkedHashTreeMap.KeySet.1
                {
                    io.dcloud.uts.gson.internal.LinkedHashTreeMap linkedHashTreeMap = io.dcloud.uts.gson.internal.LinkedHashTreeMap.this;
                }

                @Override // java.util.Iterator
                public K next() {
                    return nextNode().key;
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(java.lang.Object obj) {
            return io.dcloud.uts.gson.internal.LinkedHashTreeMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(java.lang.Object obj) {
            return io.dcloud.uts.gson.internal.LinkedHashTreeMap.this.removeInternalByKey(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            io.dcloud.uts.gson.internal.LinkedHashTreeMap.this.clear();
        }
    }

    private java.lang.Object writeReplace() throws java.io.ObjectStreamException {
        return new java.util.LinkedHashMap(this);
    }

    private void readObject(java.io.ObjectInputStream objectInputStream) throws java.io.IOException {
        throw new java.io.InvalidObjectException("Deserialization is unsupported");
    }
}
