package io.dcloud.nineoldandroids.animation;

/* JADX INFO: loaded from: classes2.dex */
public final class AnimatorSet extends io.dcloud.nineoldandroids.animation.Animator {
    private java.util.ArrayList<io.dcloud.nineoldandroids.animation.Animator> mPlayingSet = new java.util.ArrayList<>();
    private java.util.HashMap<io.dcloud.nineoldandroids.animation.Animator, io.dcloud.nineoldandroids.animation.AnimatorSet.Node> mNodeMap = new java.util.HashMap<>();
    private java.util.ArrayList<io.dcloud.nineoldandroids.animation.AnimatorSet.Node> mNodes = new java.util.ArrayList<>();
    private java.util.ArrayList<io.dcloud.nineoldandroids.animation.AnimatorSet.Node> mSortedNodes = new java.util.ArrayList<>();
    private boolean mNeedsSort = true;
    private io.dcloud.nineoldandroids.animation.AnimatorSet.AnimatorSetListener mSetListener = null;
    boolean mTerminated = false;
    private boolean mStarted = false;
    private long mStartDelay = 0;
    private io.dcloud.nineoldandroids.animation.ValueAnimator mDelayAnim = null;
    private long mDuration = -1;

    public void playTogether(io.dcloud.nineoldandroids.animation.Animator... animatorArr) {
        if (animatorArr != null) {
            this.mNeedsSort = true;
            io.dcloud.nineoldandroids.animation.AnimatorSet.Builder builderPlay = play(animatorArr[0]);
            for (int i = 1; i < animatorArr.length; i++) {
                builderPlay.with(animatorArr[i]);
            }
        }
    }

    public void playTogether(java.util.Collection<io.dcloud.nineoldandroids.animation.Animator> collection) {
        if (collection == null || collection.size() <= 0) {
            return;
        }
        this.mNeedsSort = true;
        io.dcloud.nineoldandroids.animation.AnimatorSet.Builder builderPlay = null;
        for (io.dcloud.nineoldandroids.animation.Animator animator : collection) {
            if (builderPlay == null) {
                builderPlay = play(animator);
            } else {
                builderPlay.with(animator);
            }
        }
    }

    public void playSequentially(io.dcloud.nineoldandroids.animation.Animator... animatorArr) {
        if (animatorArr != null) {
            this.mNeedsSort = true;
            int i = 0;
            if (animatorArr.length == 1) {
                play(animatorArr[0]);
                return;
            }
            while (i < animatorArr.length - 1) {
                io.dcloud.nineoldandroids.animation.AnimatorSet.Builder builderPlay = play(animatorArr[i]);
                i++;
                builderPlay.before(animatorArr[i]);
            }
        }
    }

    public void playSequentially(java.util.List<io.dcloud.nineoldandroids.animation.Animator> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.mNeedsSort = true;
        int i = 0;
        if (list.size() == 1) {
            play(list.get(0));
            return;
        }
        while (i < list.size() - 1) {
            io.dcloud.nineoldandroids.animation.AnimatorSet.Builder builderPlay = play(list.get(i));
            i++;
            builderPlay.before(list.get(i));
        }
    }

    public java.util.ArrayList<io.dcloud.nineoldandroids.animation.Animator> getChildAnimations() {
        java.util.ArrayList<io.dcloud.nineoldandroids.animation.Animator> arrayList = new java.util.ArrayList<>();
        java.util.Iterator<io.dcloud.nineoldandroids.animation.AnimatorSet.Node> it = this.mNodes.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().animation);
        }
        return arrayList;
    }

    @Override // io.dcloud.nineoldandroids.animation.Animator
    public void setTarget(java.lang.Object obj) {
        java.util.Iterator<io.dcloud.nineoldandroids.animation.AnimatorSet.Node> it = this.mNodes.iterator();
        while (it.hasNext()) {
            io.dcloud.nineoldandroids.animation.Animator animator = it.next().animation;
            if (animator instanceof io.dcloud.nineoldandroids.animation.AnimatorSet) {
                ((io.dcloud.nineoldandroids.animation.AnimatorSet) animator).setTarget(obj);
            } else if (animator instanceof io.dcloud.nineoldandroids.animation.ObjectAnimator) {
                ((io.dcloud.nineoldandroids.animation.ObjectAnimator) animator).setTarget(obj);
            }
        }
    }

    @Override // io.dcloud.nineoldandroids.animation.Animator
    public void setInterpolator(android.view.animation.Interpolator interpolator) {
        java.util.Iterator<io.dcloud.nineoldandroids.animation.AnimatorSet.Node> it = this.mNodes.iterator();
        while (it.hasNext()) {
            it.next().animation.setInterpolator(interpolator);
        }
    }

    public io.dcloud.nineoldandroids.animation.AnimatorSet.Builder play(io.dcloud.nineoldandroids.animation.Animator animator) {
        if (animator == null) {
            return null;
        }
        this.mNeedsSort = true;
        return new io.dcloud.nineoldandroids.animation.AnimatorSet.Builder(animator);
    }

    @Override // io.dcloud.nineoldandroids.animation.Animator
    public void cancel() {
        java.util.ArrayList arrayList;
        this.mTerminated = true;
        if (isStarted()) {
            if (this.mListeners != null) {
                arrayList = (java.util.ArrayList) this.mListeners.clone();
                java.util.Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((io.dcloud.nineoldandroids.animation.Animator.AnimatorListener) it.next()).onAnimationCancel(this);
                }
            } else {
                arrayList = null;
            }
            io.dcloud.nineoldandroids.animation.ValueAnimator valueAnimator = this.mDelayAnim;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.mDelayAnim.cancel();
            } else if (this.mSortedNodes.size() > 0) {
                java.util.Iterator<io.dcloud.nineoldandroids.animation.AnimatorSet.Node> it2 = this.mSortedNodes.iterator();
                while (it2.hasNext()) {
                    it2.next().animation.cancel();
                }
            }
            if (arrayList != null) {
                java.util.Iterator it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    ((io.dcloud.nineoldandroids.animation.Animator.AnimatorListener) it3.next()).onAnimationEnd(this);
                }
            }
            this.mStarted = false;
        }
    }

    @Override // io.dcloud.nineoldandroids.animation.Animator
    public void end() {
        this.mTerminated = true;
        if (isStarted()) {
            if (this.mSortedNodes.size() != this.mNodes.size()) {
                sortNodes();
                for (io.dcloud.nineoldandroids.animation.AnimatorSet.Node node : this.mSortedNodes) {
                    if (this.mSetListener == null) {
                        this.mSetListener = new io.dcloud.nineoldandroids.animation.AnimatorSet.AnimatorSetListener(this);
                    }
                    node.animation.addListener(this.mSetListener);
                }
            }
            io.dcloud.nineoldandroids.animation.ValueAnimator valueAnimator = this.mDelayAnim;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            if (this.mSortedNodes.size() > 0) {
                java.util.Iterator<io.dcloud.nineoldandroids.animation.AnimatorSet.Node> it = this.mSortedNodes.iterator();
                while (it.hasNext()) {
                    it.next().animation.end();
                }
            }
            if (this.mListeners != null) {
                java.util.Iterator it2 = ((java.util.ArrayList) this.mListeners.clone()).iterator();
                while (it2.hasNext()) {
                    ((io.dcloud.nineoldandroids.animation.Animator.AnimatorListener) it2.next()).onAnimationEnd(this);
                }
            }
            this.mStarted = false;
        }
    }

    @Override // io.dcloud.nineoldandroids.animation.Animator
    public boolean isRunning() {
        java.util.Iterator<io.dcloud.nineoldandroids.animation.AnimatorSet.Node> it = this.mNodes.iterator();
        while (it.hasNext()) {
            if (it.next().animation.isRunning()) {
                return true;
            }
        }
        return false;
    }

    @Override // io.dcloud.nineoldandroids.animation.Animator
    public boolean isStarted() {
        return this.mStarted;
    }

    @Override // io.dcloud.nineoldandroids.animation.Animator
    public long getStartDelay() {
        return this.mStartDelay;
    }

    @Override // io.dcloud.nineoldandroids.animation.Animator
    public void setStartDelay(long j) {
        this.mStartDelay = j;
    }

    @Override // io.dcloud.nineoldandroids.animation.Animator
    public long getDuration() {
        return this.mDuration;
    }

    @Override // io.dcloud.nineoldandroids.animation.Animator
    public io.dcloud.nineoldandroids.animation.AnimatorSet setDuration(long j) {
        if (j < 0) {
            throw new java.lang.IllegalArgumentException("duration must be a value of zero or greater");
        }
        java.util.Iterator<io.dcloud.nineoldandroids.animation.AnimatorSet.Node> it = this.mNodes.iterator();
        while (it.hasNext()) {
            it.next().animation.setDuration(j);
        }
        this.mDuration = j;
        return this;
    }

    @Override // io.dcloud.nineoldandroids.animation.Animator
    public void setupStartValues() {
        java.util.Iterator<io.dcloud.nineoldandroids.animation.AnimatorSet.Node> it = this.mNodes.iterator();
        while (it.hasNext()) {
            it.next().animation.setupStartValues();
        }
    }

    @Override // io.dcloud.nineoldandroids.animation.Animator
    public void setupEndValues() {
        java.util.Iterator<io.dcloud.nineoldandroids.animation.AnimatorSet.Node> it = this.mNodes.iterator();
        while (it.hasNext()) {
            it.next().animation.setupEndValues();
        }
    }

    @Override // io.dcloud.nineoldandroids.animation.Animator
    public void start() {
        this.mTerminated = false;
        this.mStarted = true;
        sortNodes();
        int size = this.mSortedNodes.size();
        for (int i = 0; i < size; i++) {
            io.dcloud.nineoldandroids.animation.AnimatorSet.Node node = this.mSortedNodes.get(i);
            java.util.ArrayList<io.dcloud.nineoldandroids.animation.Animator.AnimatorListener> listeners = node.animation.getListeners();
            if (listeners != null && listeners.size() > 0) {
                for (io.dcloud.nineoldandroids.animation.Animator.AnimatorListener animatorListener : new java.util.ArrayList(listeners)) {
                    if ((animatorListener instanceof io.dcloud.nineoldandroids.animation.AnimatorSet.DependencyListener) || (animatorListener instanceof io.dcloud.nineoldandroids.animation.AnimatorSet.AnimatorSetListener)) {
                        node.animation.removeListener(animatorListener);
                    }
                }
            }
        }
        final java.util.ArrayList<io.dcloud.nineoldandroids.animation.AnimatorSet.Node> arrayList = new java.util.ArrayList();
        for (int i2 = 0; i2 < size; i2++) {
            io.dcloud.nineoldandroids.animation.AnimatorSet.Node node2 = this.mSortedNodes.get(i2);
            if (this.mSetListener == null) {
                this.mSetListener = new io.dcloud.nineoldandroids.animation.AnimatorSet.AnimatorSetListener(this);
            }
            if (node2.dependencies == null || node2.dependencies.size() == 0) {
                arrayList.add(node2);
            } else {
                int size2 = node2.dependencies.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    io.dcloud.nineoldandroids.animation.AnimatorSet.Dependency dependency = node2.dependencies.get(i3);
                    dependency.node.animation.addListener(new io.dcloud.nineoldandroids.animation.AnimatorSet.DependencyListener(this, node2, dependency.rule));
                }
                node2.tmpDependencies = (java.util.ArrayList) node2.dependencies.clone();
            }
            node2.animation.addListener(this.mSetListener);
        }
        if (this.mStartDelay <= 0) {
            for (io.dcloud.nineoldandroids.animation.AnimatorSet.Node node3 : arrayList) {
                node3.animation.start();
                this.mPlayingSet.add(node3.animation);
            }
        } else {
            io.dcloud.nineoldandroids.animation.ValueAnimator valueAnimatorOfFloat = io.dcloud.nineoldandroids.animation.ValueAnimator.ofFloat(0.0f, 1.0f);
            this.mDelayAnim = valueAnimatorOfFloat;
            valueAnimatorOfFloat.setDuration(this.mStartDelay);
            this.mDelayAnim.addListener(new io.dcloud.nineoldandroids.animation.AnimatorListenerAdapter() { // from class: io.dcloud.nineoldandroids.animation.AnimatorSet.1
                boolean canceled = false;

                @Override // io.dcloud.nineoldandroids.animation.AnimatorListenerAdapter, io.dcloud.nineoldandroids.animation.Animator.AnimatorListener
                public void onAnimationCancel(io.dcloud.nineoldandroids.animation.Animator animator) {
                    this.canceled = true;
                }

                @Override // io.dcloud.nineoldandroids.animation.AnimatorListenerAdapter, io.dcloud.nineoldandroids.animation.Animator.AnimatorListener
                public void onAnimationEnd(io.dcloud.nineoldandroids.animation.Animator animator) {
                    if (this.canceled) {
                        return;
                    }
                    int size3 = arrayList.size();
                    for (int i4 = 0; i4 < size3; i4++) {
                        io.dcloud.nineoldandroids.animation.AnimatorSet.Node node4 = (io.dcloud.nineoldandroids.animation.AnimatorSet.Node) arrayList.get(i4);
                        node4.animation.start();
                        io.dcloud.nineoldandroids.animation.AnimatorSet.this.mPlayingSet.add(node4.animation);
                    }
                }
            });
            this.mDelayAnim.start();
        }
        if (this.mListeners != null) {
            java.util.ArrayList arrayList2 = (java.util.ArrayList) this.mListeners.clone();
            int size3 = arrayList2.size();
            for (int i4 = 0; i4 < size3; i4++) {
                ((io.dcloud.nineoldandroids.animation.Animator.AnimatorListener) arrayList2.get(i4)).onAnimationStart(this);
            }
        }
        if (this.mNodes.size() == 0 && this.mStartDelay == 0) {
            this.mStarted = false;
            if (this.mListeners != null) {
                java.util.ArrayList arrayList3 = (java.util.ArrayList) this.mListeners.clone();
                int size4 = arrayList3.size();
                for (int i5 = 0; i5 < size4; i5++) {
                    ((io.dcloud.nineoldandroids.animation.Animator.AnimatorListener) arrayList3.get(i5)).onAnimationEnd(this);
                }
            }
        }
    }

    @Override // io.dcloud.nineoldandroids.animation.Animator
    /* JADX INFO: renamed from: clone */
    public io.dcloud.nineoldandroids.animation.AnimatorSet m435clone() {
        io.dcloud.nineoldandroids.animation.AnimatorSet animatorSet = (io.dcloud.nineoldandroids.animation.AnimatorSet) super.m435clone();
        animatorSet.mNeedsSort = true;
        animatorSet.mTerminated = false;
        animatorSet.mStarted = false;
        animatorSet.mPlayingSet = new java.util.ArrayList<>();
        animatorSet.mNodeMap = new java.util.HashMap<>();
        animatorSet.mNodes = new java.util.ArrayList<>();
        animatorSet.mSortedNodes = new java.util.ArrayList<>();
        java.util.HashMap map = new java.util.HashMap();
        for (io.dcloud.nineoldandroids.animation.AnimatorSet.Node node : this.mNodes) {
            io.dcloud.nineoldandroids.animation.AnimatorSet.Node nodeM436clone = node.m436clone();
            map.put(node, nodeM436clone);
            animatorSet.mNodes.add(nodeM436clone);
            animatorSet.mNodeMap.put(nodeM436clone.animation, nodeM436clone);
            java.util.ArrayList arrayList = null;
            nodeM436clone.dependencies = null;
            nodeM436clone.tmpDependencies = null;
            nodeM436clone.nodeDependents = null;
            nodeM436clone.nodeDependencies = null;
            java.util.ArrayList<io.dcloud.nineoldandroids.animation.Animator.AnimatorListener> listeners = nodeM436clone.animation.getListeners();
            if (listeners != null) {
                for (io.dcloud.nineoldandroids.animation.Animator.AnimatorListener animatorListener : listeners) {
                    if (animatorListener instanceof io.dcloud.nineoldandroids.animation.AnimatorSet.AnimatorSetListener) {
                        if (arrayList == null) {
                            arrayList = new java.util.ArrayList();
                        }
                        arrayList.add(animatorListener);
                    }
                }
                if (arrayList != null) {
                    java.util.Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        listeners.remove((io.dcloud.nineoldandroids.animation.Animator.AnimatorListener) it.next());
                    }
                }
            }
        }
        for (io.dcloud.nineoldandroids.animation.AnimatorSet.Node node2 : this.mNodes) {
            io.dcloud.nineoldandroids.animation.AnimatorSet.Node node3 = (io.dcloud.nineoldandroids.animation.AnimatorSet.Node) map.get(node2);
            if (node2.dependencies != null) {
                for (io.dcloud.nineoldandroids.animation.AnimatorSet.Dependency dependency : node2.dependencies) {
                    node3.addDependency(new io.dcloud.nineoldandroids.animation.AnimatorSet.Dependency((io.dcloud.nineoldandroids.animation.AnimatorSet.Node) map.get(dependency.node), dependency.rule));
                }
            }
        }
        return animatorSet;
    }

    private static class DependencyListener implements io.dcloud.nineoldandroids.animation.Animator.AnimatorListener {
        private io.dcloud.nineoldandroids.animation.AnimatorSet mAnimatorSet;
        private io.dcloud.nineoldandroids.animation.AnimatorSet.Node mNode;
        private int mRule;

        @Override // io.dcloud.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationCancel(io.dcloud.nineoldandroids.animation.Animator animator) {
        }

        @Override // io.dcloud.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationRepeat(io.dcloud.nineoldandroids.animation.Animator animator) {
        }

        public DependencyListener(io.dcloud.nineoldandroids.animation.AnimatorSet animatorSet, io.dcloud.nineoldandroids.animation.AnimatorSet.Node node, int i) {
            this.mAnimatorSet = animatorSet;
            this.mNode = node;
            this.mRule = i;
        }

        @Override // io.dcloud.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationEnd(io.dcloud.nineoldandroids.animation.Animator animator) {
            if (this.mRule == 1) {
                startIfReady(animator);
            }
        }

        @Override // io.dcloud.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationStart(io.dcloud.nineoldandroids.animation.Animator animator) {
            if (this.mRule == 0) {
                startIfReady(animator);
            }
        }

        private void startIfReady(io.dcloud.nineoldandroids.animation.Animator animator) {
            io.dcloud.nineoldandroids.animation.AnimatorSet.Dependency dependency;
            if (this.mAnimatorSet.mTerminated) {
                return;
            }
            int size = this.mNode.tmpDependencies.size();
            int i = 0;
            while (true) {
                if (i < size) {
                    io.dcloud.nineoldandroids.animation.AnimatorSet.Dependency dependency2 = this.mNode.tmpDependencies.get(i);
                    if (dependency2.rule == this.mRule && dependency2.node.animation == animator) {
                        animator.removeListener(this);
                        dependency = dependency2;
                        break;
                    }
                    i++;
                } else {
                    dependency = null;
                    break;
                }
            }
            this.mNode.tmpDependencies.remove(dependency);
            if (this.mNode.tmpDependencies.size() == 0) {
                this.mNode.animation.start();
                this.mAnimatorSet.mPlayingSet.add(this.mNode.animation);
            }
        }
    }

    private class AnimatorSetListener implements io.dcloud.nineoldandroids.animation.Animator.AnimatorListener {
        private io.dcloud.nineoldandroids.animation.AnimatorSet mAnimatorSet;

        @Override // io.dcloud.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationRepeat(io.dcloud.nineoldandroids.animation.Animator animator) {
        }

        @Override // io.dcloud.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationStart(io.dcloud.nineoldandroids.animation.Animator animator) {
        }

        AnimatorSetListener(io.dcloud.nineoldandroids.animation.AnimatorSet animatorSet) {
            this.mAnimatorSet = animatorSet;
        }

        @Override // io.dcloud.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationCancel(io.dcloud.nineoldandroids.animation.Animator animator) {
            if (io.dcloud.nineoldandroids.animation.AnimatorSet.this.mTerminated || io.dcloud.nineoldandroids.animation.AnimatorSet.this.mPlayingSet.size() != 0 || io.dcloud.nineoldandroids.animation.AnimatorSet.this.mListeners == null) {
                return;
            }
            int size = io.dcloud.nineoldandroids.animation.AnimatorSet.this.mListeners.size();
            for (int i = 0; i < size; i++) {
                io.dcloud.nineoldandroids.animation.AnimatorSet.this.mListeners.get(i).onAnimationCancel(this.mAnimatorSet);
            }
        }

        @Override // io.dcloud.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationEnd(io.dcloud.nineoldandroids.animation.Animator animator) {
            animator.removeListener(this);
            io.dcloud.nineoldandroids.animation.AnimatorSet.this.mPlayingSet.remove(animator);
            ((io.dcloud.nineoldandroids.animation.AnimatorSet.Node) this.mAnimatorSet.mNodeMap.get(animator)).done = true;
            if (io.dcloud.nineoldandroids.animation.AnimatorSet.this.mTerminated) {
                return;
            }
            java.util.ArrayList arrayList = this.mAnimatorSet.mSortedNodes;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (!((io.dcloud.nineoldandroids.animation.AnimatorSet.Node) arrayList.get(i)).done) {
                    return;
                }
            }
            if (io.dcloud.nineoldandroids.animation.AnimatorSet.this.mListeners != null) {
                java.util.ArrayList arrayList2 = (java.util.ArrayList) io.dcloud.nineoldandroids.animation.AnimatorSet.this.mListeners.clone();
                int size2 = arrayList2.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    ((io.dcloud.nineoldandroids.animation.Animator.AnimatorListener) arrayList2.get(i2)).onAnimationEnd(this.mAnimatorSet);
                }
            }
            this.mAnimatorSet.mStarted = false;
        }
    }

    private void sortNodes() {
        if (this.mNeedsSort) {
            this.mSortedNodes.clear();
            java.util.ArrayList arrayList = new java.util.ArrayList();
            int size = this.mNodes.size();
            for (int i = 0; i < size; i++) {
                io.dcloud.nineoldandroids.animation.AnimatorSet.Node node = this.mNodes.get(i);
                if (node.dependencies == null || node.dependencies.size() == 0) {
                    arrayList.add(node);
                }
            }
            java.util.ArrayList arrayList2 = new java.util.ArrayList();
            while (arrayList.size() > 0) {
                int size2 = arrayList.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    io.dcloud.nineoldandroids.animation.AnimatorSet.Node node2 = (io.dcloud.nineoldandroids.animation.AnimatorSet.Node) arrayList.get(i2);
                    this.mSortedNodes.add(node2);
                    if (node2.nodeDependents != null) {
                        int size3 = node2.nodeDependents.size();
                        for (int i3 = 0; i3 < size3; i3++) {
                            io.dcloud.nineoldandroids.animation.AnimatorSet.Node node3 = node2.nodeDependents.get(i3);
                            node3.nodeDependencies.remove(node2);
                            if (node3.nodeDependencies.size() == 0) {
                                arrayList2.add(node3);
                            }
                        }
                    }
                }
                arrayList.clear();
                arrayList.addAll(arrayList2);
                arrayList2.clear();
            }
            this.mNeedsSort = false;
            if (this.mSortedNodes.size() != this.mNodes.size()) {
                throw new java.lang.IllegalStateException("Circular dependencies cannot exist in AnimatorSet");
            }
            return;
        }
        int size4 = this.mNodes.size();
        for (int i4 = 0; i4 < size4; i4++) {
            io.dcloud.nineoldandroids.animation.AnimatorSet.Node node4 = this.mNodes.get(i4);
            if (node4.dependencies != null && node4.dependencies.size() > 0) {
                int size5 = node4.dependencies.size();
                for (int i5 = 0; i5 < size5; i5++) {
                    io.dcloud.nineoldandroids.animation.AnimatorSet.Dependency dependency = node4.dependencies.get(i5);
                    if (node4.nodeDependencies == null) {
                        node4.nodeDependencies = new java.util.ArrayList<>();
                    }
                    if (!node4.nodeDependencies.contains(dependency.node)) {
                        node4.nodeDependencies.add(dependency.node);
                    }
                }
            }
            node4.done = false;
        }
    }

    private static class Dependency {
        static final int AFTER = 1;
        static final int WITH = 0;
        public io.dcloud.nineoldandroids.animation.AnimatorSet.Node node;
        public int rule;

        public Dependency(io.dcloud.nineoldandroids.animation.AnimatorSet.Node node, int i) {
            this.node = node;
            this.rule = i;
        }
    }

    private static class Node implements java.lang.Cloneable {
        public io.dcloud.nineoldandroids.animation.Animator animation;
        public java.util.ArrayList<io.dcloud.nineoldandroids.animation.AnimatorSet.Dependency> dependencies = null;
        public java.util.ArrayList<io.dcloud.nineoldandroids.animation.AnimatorSet.Dependency> tmpDependencies = null;
        public java.util.ArrayList<io.dcloud.nineoldandroids.animation.AnimatorSet.Node> nodeDependencies = null;
        public java.util.ArrayList<io.dcloud.nineoldandroids.animation.AnimatorSet.Node> nodeDependents = null;
        public boolean done = false;

        public Node(io.dcloud.nineoldandroids.animation.Animator animator) {
            this.animation = animator;
        }

        public void addDependency(io.dcloud.nineoldandroids.animation.AnimatorSet.Dependency dependency) {
            if (this.dependencies == null) {
                this.dependencies = new java.util.ArrayList<>();
                this.nodeDependencies = new java.util.ArrayList<>();
            }
            this.dependencies.add(dependency);
            if (!this.nodeDependencies.contains(dependency.node)) {
                this.nodeDependencies.add(dependency.node);
            }
            io.dcloud.nineoldandroids.animation.AnimatorSet.Node node = dependency.node;
            if (node.nodeDependents == null) {
                node.nodeDependents = new java.util.ArrayList<>();
            }
            node.nodeDependents.add(this);
        }

        /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
        public io.dcloud.nineoldandroids.animation.AnimatorSet.Node m436clone() {
            try {
                io.dcloud.nineoldandroids.animation.AnimatorSet.Node node = (io.dcloud.nineoldandroids.animation.AnimatorSet.Node) super.clone();
                node.animation = this.animation.m435clone();
                return node;
            } catch (java.lang.CloneNotSupportedException unused) {
                throw new java.lang.AssertionError();
            }
        }
    }

    public class Builder {
        private io.dcloud.nineoldandroids.animation.AnimatorSet.Node mCurrentNode;

        Builder(io.dcloud.nineoldandroids.animation.Animator animator) {
            io.dcloud.nineoldandroids.animation.AnimatorSet.Node node = (io.dcloud.nineoldandroids.animation.AnimatorSet.Node) io.dcloud.nineoldandroids.animation.AnimatorSet.this.mNodeMap.get(animator);
            this.mCurrentNode = node;
            if (node == null) {
                this.mCurrentNode = new io.dcloud.nineoldandroids.animation.AnimatorSet.Node(animator);
                io.dcloud.nineoldandroids.animation.AnimatorSet.this.mNodeMap.put(animator, this.mCurrentNode);
                io.dcloud.nineoldandroids.animation.AnimatorSet.this.mNodes.add(this.mCurrentNode);
            }
        }

        public io.dcloud.nineoldandroids.animation.AnimatorSet.Builder with(io.dcloud.nineoldandroids.animation.Animator animator) {
            io.dcloud.nineoldandroids.animation.AnimatorSet.Node node = (io.dcloud.nineoldandroids.animation.AnimatorSet.Node) io.dcloud.nineoldandroids.animation.AnimatorSet.this.mNodeMap.get(animator);
            if (node == null) {
                node = new io.dcloud.nineoldandroids.animation.AnimatorSet.Node(animator);
                io.dcloud.nineoldandroids.animation.AnimatorSet.this.mNodeMap.put(animator, node);
                io.dcloud.nineoldandroids.animation.AnimatorSet.this.mNodes.add(node);
            }
            node.addDependency(new io.dcloud.nineoldandroids.animation.AnimatorSet.Dependency(this.mCurrentNode, 0));
            return this;
        }

        public io.dcloud.nineoldandroids.animation.AnimatorSet.Builder before(io.dcloud.nineoldandroids.animation.Animator animator) {
            io.dcloud.nineoldandroids.animation.AnimatorSet.Node node = (io.dcloud.nineoldandroids.animation.AnimatorSet.Node) io.dcloud.nineoldandroids.animation.AnimatorSet.this.mNodeMap.get(animator);
            if (node == null) {
                node = new io.dcloud.nineoldandroids.animation.AnimatorSet.Node(animator);
                io.dcloud.nineoldandroids.animation.AnimatorSet.this.mNodeMap.put(animator, node);
                io.dcloud.nineoldandroids.animation.AnimatorSet.this.mNodes.add(node);
            }
            node.addDependency(new io.dcloud.nineoldandroids.animation.AnimatorSet.Dependency(this.mCurrentNode, 1));
            return this;
        }

        public io.dcloud.nineoldandroids.animation.AnimatorSet.Builder after(io.dcloud.nineoldandroids.animation.Animator animator) {
            io.dcloud.nineoldandroids.animation.AnimatorSet.Node node = (io.dcloud.nineoldandroids.animation.AnimatorSet.Node) io.dcloud.nineoldandroids.animation.AnimatorSet.this.mNodeMap.get(animator);
            if (node == null) {
                node = new io.dcloud.nineoldandroids.animation.AnimatorSet.Node(animator);
                io.dcloud.nineoldandroids.animation.AnimatorSet.this.mNodeMap.put(animator, node);
                io.dcloud.nineoldandroids.animation.AnimatorSet.this.mNodes.add(node);
            }
            this.mCurrentNode.addDependency(new io.dcloud.nineoldandroids.animation.AnimatorSet.Dependency(node, 1));
            return this;
        }

        public io.dcloud.nineoldandroids.animation.AnimatorSet.Builder after(long j) {
            io.dcloud.nineoldandroids.animation.ValueAnimator valueAnimatorOfFloat = io.dcloud.nineoldandroids.animation.ValueAnimator.ofFloat(0.0f, 1.0f);
            valueAnimatorOfFloat.setDuration(j);
            after(valueAnimatorOfFloat);
            return this;
        }
    }
}
