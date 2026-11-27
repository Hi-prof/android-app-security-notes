package com.facebook.imagepipeline.producers;

/* JADX INFO: loaded from: classes.dex */
public abstract class MultiplexProducer<K, T extends java.io.Closeable> implements com.facebook.imagepipeline.producers.Producer<T> {
    public static final java.lang.String EXTRAS_STARTED_AS_PREFETCH = "started_as_prefetch";
    private final java.lang.String mDedupedRequestsCountKey;
    private final com.facebook.imagepipeline.producers.Producer<T> mInputProducer;
    private final boolean mKeepCancelledFetchAsLowPriority;
    final java.util.Map<K, com.facebook.imagepipeline.producers.MultiplexProducer<K, T>.Multiplexer> mMultiplexers;
    private final java.lang.String mProducerName;

    @javax.annotation.Nullable
    protected abstract T cloneOrNull(@javax.annotation.Nullable T t);

    protected abstract K getKey(com.facebook.imagepipeline.producers.ProducerContext producerContext);

    protected MultiplexProducer(com.facebook.imagepipeline.producers.Producer<T> producer, java.lang.String str, java.lang.String str2) {
        this(producer, str, str2, false);
    }

    protected MultiplexProducer(com.facebook.imagepipeline.producers.Producer<T> producer, java.lang.String str, java.lang.String str2, boolean z) {
        this.mInputProducer = producer;
        this.mMultiplexers = new java.util.HashMap();
        this.mKeepCancelledFetchAsLowPriority = z;
        this.mProducerName = str;
        this.mDedupedRequestsCountKey = str2;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(com.facebook.imagepipeline.producers.Consumer<T> consumer, com.facebook.imagepipeline.producers.ProducerContext producerContext) {
        com.facebook.imagepipeline.producers.MultiplexProducer<K, T>.Multiplexer existingMultiplexer;
        boolean z;
        try {
            if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("MultiplexProducer#produceResults");
            }
            producerContext.getProducerListener().onProducerStart(producerContext, this.mProducerName);
            K key = getKey(producerContext);
            do {
                synchronized (this) {
                    existingMultiplexer = getExistingMultiplexer(key);
                    if (existingMultiplexer == null) {
                        existingMultiplexer = createAndPutNewMultiplexer(key);
                        z = true;
                    } else {
                        z = false;
                    }
                }
            } while (!existingMultiplexer.addNewConsumer(consumer, producerContext));
            if (z) {
                existingMultiplexer.startInputProducerIfHasAttachedConsumers(com.facebook.common.util.TriState.valueOf(producerContext.isPrefetch()));
            }
            if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
            }
        } catch (java.lang.Throwable th) {
            if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
            }
            throw th;
        }
    }

    @javax.annotation.Nullable
    protected synchronized com.facebook.imagepipeline.producers.MultiplexProducer<K, T>.Multiplexer getExistingMultiplexer(K k) {
        return this.mMultiplexers.get(k);
    }

    private synchronized com.facebook.imagepipeline.producers.MultiplexProducer<K, T>.Multiplexer createAndPutNewMultiplexer(K k) {
        com.facebook.imagepipeline.producers.MultiplexProducer<K, T>.Multiplexer multiplexer;
        multiplexer = new com.facebook.imagepipeline.producers.MultiplexProducer.Multiplexer(k);
        this.mMultiplexers.put(k, multiplexer);
        return multiplexer;
    }

    protected synchronized void removeMultiplexer(K k, com.facebook.imagepipeline.producers.MultiplexProducer<K, T>.Multiplexer multiplexer) {
        if (this.mMultiplexers.get(k) == multiplexer) {
            this.mMultiplexers.remove(k);
        }
    }

    class Multiplexer {
        private final java.util.concurrent.CopyOnWriteArraySet<android.util.Pair<com.facebook.imagepipeline.producers.Consumer<T>, com.facebook.imagepipeline.producers.ProducerContext>> mConsumerContextPairs = com.facebook.common.internal.Sets.newCopyOnWriteArraySet();

        @javax.annotation.Nullable
        private com.facebook.imagepipeline.producers.MultiplexProducer<K, T>.Multiplexer.ForwardingConsumer mForwardingConsumer;
        private final K mKey;

        @javax.annotation.Nullable
        private T mLastIntermediateResult;
        private float mLastProgress;
        private int mLastStatus;

        @javax.annotation.Nullable
        private com.facebook.imagepipeline.producers.BaseProducerContext mMultiplexProducerContext;

        public Multiplexer(K k) {
            this.mKey = k;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public boolean addNewConsumer(com.facebook.imagepipeline.producers.Consumer<T> consumer, com.facebook.imagepipeline.producers.ProducerContext producerContext) {
            android.util.Pair<com.facebook.imagepipeline.producers.Consumer<T>, com.facebook.imagepipeline.producers.ProducerContext> pairCreate = android.util.Pair.create(consumer, producerContext);
            synchronized (this) {
                if (com.facebook.imagepipeline.producers.MultiplexProducer.this.getExistingMultiplexer(this.mKey) != this) {
                    return false;
                }
                this.mConsumerContextPairs.add(pairCreate);
                java.util.List<com.facebook.imagepipeline.producers.ProducerContextCallbacks> listUpdateIsPrefetch = updateIsPrefetch();
                java.util.List<com.facebook.imagepipeline.producers.ProducerContextCallbacks> listUpdatePriority = updatePriority();
                java.util.List<com.facebook.imagepipeline.producers.ProducerContextCallbacks> listUpdateIsIntermediateResultExpected = updateIsIntermediateResultExpected();
                java.io.Closeable closeableCloneOrNull = this.mLastIntermediateResult;
                float f = this.mLastProgress;
                int i = this.mLastStatus;
                com.facebook.imagepipeline.producers.BaseProducerContext.callOnIsPrefetchChanged(listUpdateIsPrefetch);
                com.facebook.imagepipeline.producers.BaseProducerContext.callOnPriorityChanged(listUpdatePriority);
                com.facebook.imagepipeline.producers.BaseProducerContext.callOnIsIntermediateResultExpectedChanged(listUpdateIsIntermediateResultExpected);
                synchronized (pairCreate) {
                    synchronized (this) {
                        if (closeableCloneOrNull != this.mLastIntermediateResult) {
                            closeableCloneOrNull = null;
                        } else if (closeableCloneOrNull != null) {
                            closeableCloneOrNull = com.facebook.imagepipeline.producers.MultiplexProducer.this.cloneOrNull(closeableCloneOrNull);
                        }
                    }
                    if (closeableCloneOrNull != null) {
                        if (f > 0.0f) {
                            consumer.onProgressUpdate(f);
                        }
                        consumer.onNewResult(closeableCloneOrNull, i);
                        closeSafely(closeableCloneOrNull);
                    }
                }
                addCallbacks(pairCreate, producerContext);
                return true;
            }
        }

        private void addCallbacks(final android.util.Pair<com.facebook.imagepipeline.producers.Consumer<T>, com.facebook.imagepipeline.producers.ProducerContext> pair, com.facebook.imagepipeline.producers.ProducerContext producerContext) {
            producerContext.addCallbacks(new com.facebook.imagepipeline.producers.BaseProducerContextCallbacks() { // from class: com.facebook.imagepipeline.producers.MultiplexProducer.Multiplexer.1
                @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
                public void onCancellationRequested() {
                    boolean zRemove;
                    java.util.List list;
                    com.facebook.imagepipeline.producers.BaseProducerContext baseProducerContext;
                    java.util.List listUpdatePriority;
                    java.util.List listUpdateIsIntermediateResultExpected;
                    synchronized (com.facebook.imagepipeline.producers.MultiplexProducer.Multiplexer.this) {
                        zRemove = com.facebook.imagepipeline.producers.MultiplexProducer.Multiplexer.this.mConsumerContextPairs.remove(pair);
                        list = null;
                        if (!zRemove) {
                            baseProducerContext = null;
                            listUpdatePriority = null;
                        } else if (com.facebook.imagepipeline.producers.MultiplexProducer.Multiplexer.this.mConsumerContextPairs.isEmpty()) {
                            baseProducerContext = com.facebook.imagepipeline.producers.MultiplexProducer.Multiplexer.this.mMultiplexProducerContext;
                            listUpdatePriority = null;
                        } else {
                            java.util.List listUpdateIsPrefetch = com.facebook.imagepipeline.producers.MultiplexProducer.Multiplexer.this.updateIsPrefetch();
                            listUpdatePriority = com.facebook.imagepipeline.producers.MultiplexProducer.Multiplexer.this.updatePriority();
                            listUpdateIsIntermediateResultExpected = com.facebook.imagepipeline.producers.MultiplexProducer.Multiplexer.this.updateIsIntermediateResultExpected();
                            baseProducerContext = null;
                            list = listUpdateIsPrefetch;
                        }
                        listUpdateIsIntermediateResultExpected = listUpdatePriority;
                    }
                    com.facebook.imagepipeline.producers.BaseProducerContext.callOnIsPrefetchChanged(list);
                    com.facebook.imagepipeline.producers.BaseProducerContext.callOnPriorityChanged(listUpdatePriority);
                    com.facebook.imagepipeline.producers.BaseProducerContext.callOnIsIntermediateResultExpectedChanged(listUpdateIsIntermediateResultExpected);
                    if (baseProducerContext != null) {
                        if (com.facebook.imagepipeline.producers.MultiplexProducer.this.mKeepCancelledFetchAsLowPriority && !baseProducerContext.isPrefetch()) {
                            com.facebook.imagepipeline.producers.BaseProducerContext.callOnPriorityChanged(baseProducerContext.setPriorityNoCallbacks(com.facebook.imagepipeline.common.Priority.LOW));
                        } else {
                            baseProducerContext.cancel();
                        }
                    }
                    if (zRemove) {
                        ((com.facebook.imagepipeline.producers.Consumer) pair.first).onCancellation();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
                public void onIsPrefetchChanged() {
                    com.facebook.imagepipeline.producers.BaseProducerContext.callOnIsPrefetchChanged(com.facebook.imagepipeline.producers.MultiplexProducer.Multiplexer.this.updateIsPrefetch());
                }

                @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
                public void onIsIntermediateResultExpectedChanged() {
                    com.facebook.imagepipeline.producers.BaseProducerContext.callOnIsIntermediateResultExpectedChanged(com.facebook.imagepipeline.producers.MultiplexProducer.Multiplexer.this.updateIsIntermediateResultExpected());
                }

                @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
                public void onPriorityChanged() {
                    com.facebook.imagepipeline.producers.BaseProducerContext.callOnPriorityChanged(com.facebook.imagepipeline.producers.MultiplexProducer.Multiplexer.this.updatePriority());
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void startInputProducerIfHasAttachedConsumers(com.facebook.common.util.TriState triState) {
            synchronized (this) {
                boolean z = true;
                com.facebook.common.internal.Preconditions.checkArgument(java.lang.Boolean.valueOf(this.mMultiplexProducerContext == null));
                if (this.mForwardingConsumer != null) {
                    z = false;
                }
                com.facebook.common.internal.Preconditions.checkArgument(java.lang.Boolean.valueOf(z));
                if (this.mConsumerContextPairs.isEmpty()) {
                    com.facebook.imagepipeline.producers.MultiplexProducer.this.removeMultiplexer(this.mKey, this);
                    return;
                }
                com.facebook.imagepipeline.producers.ProducerContext producerContext = (com.facebook.imagepipeline.producers.ProducerContext) this.mConsumerContextPairs.iterator().next().second;
                com.facebook.imagepipeline.producers.BaseProducerContext baseProducerContext = new com.facebook.imagepipeline.producers.BaseProducerContext(producerContext.getImageRequest(), producerContext.getId(), producerContext.getProducerListener(), producerContext.getCallerContext(), producerContext.getLowestPermittedRequestLevel(), computeIsPrefetch(), computeIsIntermediateResultExpected(), computePriority(), producerContext.getImagePipelineConfig());
                this.mMultiplexProducerContext = baseProducerContext;
                baseProducerContext.putExtras(producerContext.getExtras());
                if (triState.isSet()) {
                    this.mMultiplexProducerContext.putExtra(com.facebook.imagepipeline.producers.MultiplexProducer.EXTRAS_STARTED_AS_PREFETCH, java.lang.Boolean.valueOf(triState.asBoolean()));
                }
                com.facebook.imagepipeline.producers.MultiplexProducer<K, T>.Multiplexer.ForwardingConsumer forwardingConsumer = new com.facebook.imagepipeline.producers.MultiplexProducer.Multiplexer.ForwardingConsumer();
                this.mForwardingConsumer = forwardingConsumer;
                com.facebook.imagepipeline.producers.MultiplexProducer.this.mInputProducer.produceResults(forwardingConsumer, this.mMultiplexProducerContext);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @javax.annotation.Nullable
        public synchronized java.util.List<com.facebook.imagepipeline.producers.ProducerContextCallbacks> updateIsPrefetch() {
            com.facebook.imagepipeline.producers.BaseProducerContext baseProducerContext = this.mMultiplexProducerContext;
            if (baseProducerContext == null) {
                return null;
            }
            return baseProducerContext.setIsPrefetchNoCallbacks(computeIsPrefetch());
        }

        private synchronized boolean computeIsPrefetch() {
            java.util.Iterator<android.util.Pair<com.facebook.imagepipeline.producers.Consumer<T>, com.facebook.imagepipeline.producers.ProducerContext>> it = this.mConsumerContextPairs.iterator();
            while (it.hasNext()) {
                if (!((com.facebook.imagepipeline.producers.ProducerContext) it.next().second).isPrefetch()) {
                    return false;
                }
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @javax.annotation.Nullable
        public synchronized java.util.List<com.facebook.imagepipeline.producers.ProducerContextCallbacks> updateIsIntermediateResultExpected() {
            com.facebook.imagepipeline.producers.BaseProducerContext baseProducerContext = this.mMultiplexProducerContext;
            if (baseProducerContext == null) {
                return null;
            }
            return baseProducerContext.setIsIntermediateResultExpectedNoCallbacks(computeIsIntermediateResultExpected());
        }

        private synchronized boolean computeIsIntermediateResultExpected() {
            java.util.Iterator<android.util.Pair<com.facebook.imagepipeline.producers.Consumer<T>, com.facebook.imagepipeline.producers.ProducerContext>> it = this.mConsumerContextPairs.iterator();
            while (it.hasNext()) {
                if (((com.facebook.imagepipeline.producers.ProducerContext) it.next().second).isIntermediateResultExpected()) {
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @javax.annotation.Nullable
        public synchronized java.util.List<com.facebook.imagepipeline.producers.ProducerContextCallbacks> updatePriority() {
            com.facebook.imagepipeline.producers.BaseProducerContext baseProducerContext = this.mMultiplexProducerContext;
            if (baseProducerContext == null) {
                return null;
            }
            return baseProducerContext.setPriorityNoCallbacks(computePriority());
        }

        private synchronized com.facebook.imagepipeline.common.Priority computePriority() {
            com.facebook.imagepipeline.common.Priority higherPriority;
            higherPriority = com.facebook.imagepipeline.common.Priority.LOW;
            java.util.Iterator<android.util.Pair<com.facebook.imagepipeline.producers.Consumer<T>, com.facebook.imagepipeline.producers.ProducerContext>> it = this.mConsumerContextPairs.iterator();
            while (it.hasNext()) {
                higherPriority = com.facebook.imagepipeline.common.Priority.getHigherPriority(higherPriority, ((com.facebook.imagepipeline.producers.ProducerContext) it.next().second).getPriority());
            }
            return higherPriority;
        }

        public void onFailure(com.facebook.imagepipeline.producers.MultiplexProducer<K, T>.Multiplexer.ForwardingConsumer forwardingConsumer, java.lang.Throwable th) {
            synchronized (this) {
                if (this.mForwardingConsumer != forwardingConsumer) {
                    return;
                }
                this.mConsumerContextPairs.clear();
                com.facebook.imagepipeline.producers.MultiplexProducer.this.removeMultiplexer(this.mKey, this);
                closeSafely(this.mLastIntermediateResult);
                this.mLastIntermediateResult = null;
                for (android.util.Pair<com.facebook.imagepipeline.producers.Consumer<T>, com.facebook.imagepipeline.producers.ProducerContext> pair : this.mConsumerContextPairs) {
                    synchronized (pair) {
                        ((com.facebook.imagepipeline.producers.ProducerContext) pair.second).getProducerListener().onProducerFinishWithFailure((com.facebook.imagepipeline.producers.ProducerContext) pair.second, com.facebook.imagepipeline.producers.MultiplexProducer.this.mProducerName, th, null);
                        if (this.mMultiplexProducerContext != null) {
                            ((com.facebook.imagepipeline.producers.ProducerContext) pair.second).putExtras(this.mMultiplexProducerContext.getExtras());
                        }
                        ((com.facebook.imagepipeline.producers.Consumer) pair.first).onFailure(th);
                    }
                }
            }
        }

        public void onNextResult(com.facebook.imagepipeline.producers.MultiplexProducer<K, T>.Multiplexer.ForwardingConsumer forwardingConsumer, @javax.annotation.Nullable T t, int i) {
            synchronized (this) {
                if (this.mForwardingConsumer != forwardingConsumer) {
                    return;
                }
                closeSafely(this.mLastIntermediateResult);
                this.mLastIntermediateResult = null;
                int size = this.mConsumerContextPairs.size();
                if (com.facebook.imagepipeline.producers.BaseConsumer.isNotLast(i)) {
                    this.mLastIntermediateResult = (T) com.facebook.imagepipeline.producers.MultiplexProducer.this.cloneOrNull(t);
                    this.mLastStatus = i;
                } else {
                    this.mConsumerContextPairs.clear();
                    com.facebook.imagepipeline.producers.MultiplexProducer.this.removeMultiplexer(this.mKey, this);
                }
                for (android.util.Pair<com.facebook.imagepipeline.producers.Consumer<T>, com.facebook.imagepipeline.producers.ProducerContext> pair : this.mConsumerContextPairs) {
                    synchronized (pair) {
                        if (com.facebook.imagepipeline.producers.BaseConsumer.isLast(i)) {
                            ((com.facebook.imagepipeline.producers.ProducerContext) pair.second).getProducerListener().onProducerFinishWithSuccess((com.facebook.imagepipeline.producers.ProducerContext) pair.second, com.facebook.imagepipeline.producers.MultiplexProducer.this.mProducerName, null);
                            if (this.mMultiplexProducerContext != null) {
                                ((com.facebook.imagepipeline.producers.ProducerContext) pair.second).putExtras(this.mMultiplexProducerContext.getExtras());
                            }
                            ((com.facebook.imagepipeline.producers.ProducerContext) pair.second).putExtra(com.facebook.imagepipeline.producers.MultiplexProducer.this.mDedupedRequestsCountKey, java.lang.Integer.valueOf(size));
                        }
                        ((com.facebook.imagepipeline.producers.Consumer) pair.first).onNewResult(t, i);
                    }
                }
            }
        }

        public void onCancelled(com.facebook.imagepipeline.producers.MultiplexProducer<K, T>.Multiplexer.ForwardingConsumer forwardingConsumer) {
            synchronized (this) {
                if (this.mForwardingConsumer != forwardingConsumer) {
                    return;
                }
                this.mForwardingConsumer = null;
                this.mMultiplexProducerContext = null;
                closeSafely(this.mLastIntermediateResult);
                this.mLastIntermediateResult = null;
                startInputProducerIfHasAttachedConsumers(com.facebook.common.util.TriState.UNSET);
            }
        }

        public void onProgressUpdate(com.facebook.imagepipeline.producers.MultiplexProducer<K, T>.Multiplexer.ForwardingConsumer forwardingConsumer, float f) {
            synchronized (this) {
                if (this.mForwardingConsumer != forwardingConsumer) {
                    return;
                }
                this.mLastProgress = f;
                for (android.util.Pair<com.facebook.imagepipeline.producers.Consumer<T>, com.facebook.imagepipeline.producers.ProducerContext> pair : this.mConsumerContextPairs) {
                    synchronized (pair) {
                        ((com.facebook.imagepipeline.producers.Consumer) pair.first).onProgressUpdate(f);
                    }
                }
            }
        }

        private void closeSafely(@javax.annotation.Nullable java.io.Closeable closeable) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (java.io.IOException e) {
                    throw new java.lang.RuntimeException(e);
                }
            }
        }

        private class ForwardingConsumer extends com.facebook.imagepipeline.producers.BaseConsumer<T> {
            private ForwardingConsumer() {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.BaseConsumer
            public void onNewResultImpl(@javax.annotation.Nullable T t, int i) {
                try {
                    if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                        com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("MultiplexProducer#onNewResult");
                    }
                    com.facebook.imagepipeline.producers.MultiplexProducer.Multiplexer.this.onNextResult(this, t, i);
                } finally {
                    if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                        com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
                    }
                }
            }

            @Override // com.facebook.imagepipeline.producers.BaseConsumer
            protected void onFailureImpl(java.lang.Throwable th) {
                try {
                    if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                        com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("MultiplexProducer#onFailure");
                    }
                    com.facebook.imagepipeline.producers.MultiplexProducer.Multiplexer.this.onFailure(this, th);
                } finally {
                    if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                        com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
                    }
                }
            }

            @Override // com.facebook.imagepipeline.producers.BaseConsumer
            protected void onCancellationImpl() {
                try {
                    if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                        com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("MultiplexProducer#onCancellation");
                    }
                    com.facebook.imagepipeline.producers.MultiplexProducer.Multiplexer.this.onCancelled(this);
                } finally {
                    if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                        com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
                    }
                }
            }

            @Override // com.facebook.imagepipeline.producers.BaseConsumer
            protected void onProgressUpdateImpl(float f) {
                try {
                    if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                        com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("MultiplexProducer#onProgressUpdate");
                    }
                    com.facebook.imagepipeline.producers.MultiplexProducer.Multiplexer.this.onProgressUpdate(this, f);
                } finally {
                    if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                        com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
                    }
                }
            }
        }
    }
}
