package com.dmcbig.mediapicker.view;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class PreviewFragment extends androidx.fragment.app.Fragment {
    private com.dcloud.android.widget.photoview.PhotoView mPhotoView;
    android.widget.ImageView play_view;

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isIntentAvailable(android.content.Context context, android.content.Intent intent) {
        return context.getPackageManager().queryIntentActivities(intent, 0).size() > 0;
    }

    public static com.dmcbig.mediapicker.view.PreviewFragment newInstance(com.dmcbig.mediapicker.entity.Media media, java.lang.String str) {
        com.dmcbig.mediapicker.view.PreviewFragment previewFragment = new com.dmcbig.mediapicker.view.PreviewFragment();
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putParcelable("media", media);
        previewFragment.setArguments(bundle);
        return previewFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(android.os.Bundle bundle) {
        setRetainInstance(true);
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public android.view.View onCreateView(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, android.os.Bundle bundle) {
        return layoutInflater.inflate(com.dmcbig.mediapicker.MediaPickerR.MP_LAYOUT_PREVIEW_FRAGMENT_ITEM, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(android.view.View view, android.os.Bundle bundle) {
        super.onViewCreated(view, bundle);
        com.dmcbig.mediapicker.entity.Media media = (com.dmcbig.mediapicker.entity.Media) getArguments().getParcelable("media");
        this.play_view = (android.widget.ImageView) view.findViewById(com.dmcbig.mediapicker.MediaPickerR.MP_ID_PLAY_VIEW);
        com.dcloud.android.widget.photoview.PhotoView photoView = (com.dcloud.android.widget.photoview.PhotoView) view.findViewById(com.dmcbig.mediapicker.MediaPickerR.MP_ID_PHOTOVIEW);
        this.mPhotoView = photoView;
        photoView.setMaximumScale(5.0f);
        this.mPhotoView.setOnPhotoTapListener(new com.dcloud.android.widget.photoview.OnPhotoTapListener() { // from class: com.dmcbig.mediapicker.view.PreviewFragment.1
            @Override // com.dcloud.android.widget.photoview.OnPhotoTapListener
            public void onPhotoTap(android.widget.ImageView imageView, float f, float f2) {
                ((com.dmcbig.mediapicker.PreviewActivity) com.dmcbig.mediapicker.view.PreviewFragment.this.getActivity()).setBarStatus();
            }
        });
        setPlayView(media);
        android.net.Uri uri = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        int i = media.mediaType;
        if (i != 1 && i == 3) {
            uri = android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        }
        com.bumptech.glide.Glide.with(getActivity()).load(android.content.ContentUris.withAppendedId(uri, media.id)).into(this.mPhotoView);
    }

    void setPlayView(final com.dmcbig.mediapicker.entity.Media media) {
        if (media.mediaType == 3) {
            this.play_view.setVisibility(0);
            this.play_view.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.dmcbig.mediapicker.view.PreviewFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(android.view.View view) {
                    android.content.Intent dataAndTypeIntent = io.dcloud.common.util.LoadAppUtils.getDataAndTypeIntent(com.dmcbig.mediapicker.view.PreviewFragment.this.getContext(), media.path, "video/*");
                    com.dmcbig.mediapicker.view.PreviewFragment previewFragment = com.dmcbig.mediapicker.view.PreviewFragment.this;
                    if (previewFragment.isIntentAvailable(previewFragment.getContext(), dataAndTypeIntent)) {
                        com.dmcbig.mediapicker.view.PreviewFragment.this.startActivity(dataAndTypeIntent);
                    } else {
                        com.dcloud.android.widget.toast.ToastCompat.makeText(com.dmcbig.mediapicker.view.PreviewFragment.this.getContext(), (java.lang.CharSequence) com.dmcbig.mediapicker.view.PreviewFragment.this.getString(com.dmcbig.mediapicker.MediaPickerR.MP_STRING_CANT_PLAY_VIDEO), 0).show();
                    }
                }
            });
        }
    }
}
