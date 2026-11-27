package com.bumptech.glide;

/* JADX INFO: loaded from: classes.dex */
public abstract class TransitionOptions<CHILD extends com.bumptech.glide.TransitionOptions<CHILD, TranscodeType>, TranscodeType> implements java.lang.Cloneable {
    private com.bumptech.glide.request.transition.TransitionFactory<? super TranscodeType> transitionFactory = com.bumptech.glide.request.transition.NoTransition.getFactory();

    private CHILD self() {
        return this;
    }

    public final CHILD dontTransition() {
        return (CHILD) transition(com.bumptech.glide.request.transition.NoTransition.getFactory());
    }

    public final CHILD transition(int i) {
        return (CHILD) transition(new com.bumptech.glide.request.transition.ViewAnimationFactory(i));
    }

    public final CHILD transition(com.bumptech.glide.request.transition.ViewPropertyTransition.Animator animator) {
        return (CHILD) transition(new com.bumptech.glide.request.transition.ViewPropertyAnimationFactory(animator));
    }

    public final CHILD transition(com.bumptech.glide.request.transition.TransitionFactory<? super TranscodeType> transitionFactory) {
        this.transitionFactory = (com.bumptech.glide.request.transition.TransitionFactory) com.bumptech.glide.util.Preconditions.checkNotNull(transitionFactory);
        return (CHILD) self();
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public final CHILD m207clone() {
        try {
            return (CHILD) super.clone();
        } catch (java.lang.CloneNotSupportedException e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    final com.bumptech.glide.request.transition.TransitionFactory<? super TranscodeType> getTransitionFactory() {
        return this.transitionFactory;
    }

    public boolean equals(java.lang.Object obj) {
        if (obj instanceof com.bumptech.glide.TransitionOptions) {
            return com.bumptech.glide.util.Util.bothNullOrEqual(this.transitionFactory, ((com.bumptech.glide.TransitionOptions) obj).transitionFactory);
        }
        return false;
    }

    public int hashCode() {
        com.bumptech.glide.request.transition.TransitionFactory<? super TranscodeType> transitionFactory = this.transitionFactory;
        if (transitionFactory != null) {
            return transitionFactory.hashCode();
        }
        return 0;
    }
}
