package com.dmcbig.mediapicker.adapter;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class MediaGridAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.dmcbig.mediapicker.adapter.MediaGridAdapter.MyViewHolder> {
    android.content.Context context;
    private final android.os.Handler handler;
    boolean isSingle;
    long maxSelect;
    long maxSize;
    java.util.ArrayList<com.dmcbig.mediapicker.entity.Media> medias;
    java.util.ArrayList<com.dmcbig.mediapicker.entity.Media> selectMedias;
    com.dmcbig.mediapicker.utils.FileUtils fileUtils = new com.dmcbig.mediapicker.utils.FileUtils();
    private com.dmcbig.mediapicker.adapter.MediaGridAdapter.OnRecyclerViewItemClickListener mOnItemClickListener = null;
    private com.dmcbig.mediapicker.adapter.MediaGridAdapter.OnPickerSelectMaxListener mOnMaxListener = null;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public class MyViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        public android.widget.ImageView check_image;
        public android.widget.RelativeLayout gif_info;
        public android.view.View mask_view;
        public android.widget.ImageView media_image;
        public android.widget.TextView textView_size;
        public android.widget.RelativeLayout video_info;

        public MyViewHolder(android.view.View view) {
            super(view);
            this.media_image = (android.widget.ImageView) view.findViewById(com.dmcbig.mediapicker.MediaPickerR.MP_ID_MEDIA_IMAGE);
            this.check_image = (android.widget.ImageView) view.findViewById(com.dmcbig.mediapicker.MediaPickerR.MP_ID_CHECK_IMAGE);
            this.mask_view = view.findViewById(com.dmcbig.mediapicker.MediaPickerR.MP_ID_MASK_VIEW);
            this.video_info = (android.widget.RelativeLayout) view.findViewById(com.dmcbig.mediapicker.MediaPickerR.MP_ID_VIDEO_INFO);
            this.gif_info = (android.widget.RelativeLayout) view.findViewById(com.dmcbig.mediapicker.MediaPickerR.MP_ID_GIF_INFO);
            this.textView_size = (android.widget.TextView) view.findViewById(com.dmcbig.mediapicker.MediaPickerR.MP_ID_TEXTVIEW_SIZE);
            this.itemView.setLayoutParams(new android.widget.AbsListView.LayoutParams(-1, com.dmcbig.mediapicker.adapter.MediaGridAdapter.this.getItemWidth()));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface OnPickerSelectMaxListener {
        void onMaxed();
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface OnRecyclerViewItemClickListener {
        void onAddMore();

        void onItemClick(android.view.View view, com.dmcbig.mediapicker.entity.Media media, java.util.ArrayList<com.dmcbig.mediapicker.entity.Media> arrayList);
    }

    public MediaGridAdapter(java.util.ArrayList<com.dmcbig.mediapicker.entity.Media> arrayList, android.content.Context context, java.util.ArrayList<com.dmcbig.mediapicker.entity.Media> arrayList2, int i, long j, boolean z) {
        this.selectMedias = new java.util.ArrayList<>();
        this.isSingle = false;
        if (arrayList2 != null) {
            this.selectMedias = arrayList2;
        }
        this.maxSelect = i;
        this.maxSize = j;
        this.medias = arrayList;
        this.context = context;
        this.isSingle = z;
        this.handler = new android.os.Handler(android.os.Looper.getMainLooper());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.medias.size();
    }

    public int getItemIndex(java.lang.Object obj) {
        return this.medias.indexOf(obj);
    }

    int getItemWidth() {
        int screenWidth = com.dmcbig.mediapicker.utils.ScreenUtils.getScreenWidth(this.context);
        int i = com.dmcbig.mediapicker.PickerConfig.GridSpanCount;
        return (screenWidth / i) - i;
    }

    public java.util.ArrayList<com.dmcbig.mediapicker.entity.Media> getMedias() {
        return this.medias;
    }

    public java.util.ArrayList<com.dmcbig.mediapicker.entity.Media> getSelectMedias() {
        return this.selectMedias;
    }

    public int isSelect(com.dmcbig.mediapicker.entity.Media media) {
        if (this.selectMedias.size() <= 0) {
            return -1;
        }
        for (int i = 0; i < this.selectMedias.size(); i++) {
            com.dmcbig.mediapicker.entity.Media media2 = this.selectMedias.get(i);
            if (media2.path.equals(media.path)) {
                media2.id = media.id;
                return i;
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: lambda$onBindViewHolder$1$com-dmcbig-mediapicker-adapter-MediaGridAdapter, reason: not valid java name */
    /* synthetic */ void m214x45afd60c(android.net.Uri uri, com.dmcbig.mediapicker.entity.Media media, final com.dmcbig.mediapicker.adapter.MediaGridAdapter.MyViewHolder myViewHolder) {
        final android.graphics.Bitmap thumbnail;
        try {
            if (android.os.Build.VERSION.SDK_INT >= 29) {
                thumbnail = this.context.getContentResolver().loadThumbnail(uri, new android.util.Size(getItemWidth(), getItemWidth()), null);
            } else {
                thumbnail = media.mediaType == 3 ? android.provider.MediaStore.Video.Thumbnails.getThumbnail(this.context.getContentResolver(), media.id, 1, null) : android.provider.MediaStore.Images.Thumbnails.getThumbnail(this.context.getContentResolver(), media.id, 1, null);
            }
            this.handler.post(new java.lang.Runnable() { // from class: com.dmcbig.mediapicker.adapter.MediaGridAdapter$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    myViewHolder.media_image.setImageBitmap(thumbnail);
                }
            });
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    public void setOnItemClickListener(com.dmcbig.mediapicker.adapter.MediaGridAdapter.OnRecyclerViewItemClickListener onRecyclerViewItemClickListener) {
        this.mOnItemClickListener = onRecyclerViewItemClickListener;
    }

    public void setOnMaxListener(com.dmcbig.mediapicker.adapter.MediaGridAdapter.OnPickerSelectMaxListener onPickerSelectMaxListener) {
        this.mOnMaxListener = onPickerSelectMaxListener;
    }

    public void setSelectMedias(com.dmcbig.mediapicker.entity.Media media) {
        int iIsSelect = isSelect(media);
        if (iIsSelect == -1) {
            this.selectMedias.add(media);
        } else {
            this.selectMedias.remove(iIsSelect);
        }
    }

    public void updateAdapter(java.util.ArrayList<com.dmcbig.mediapicker.entity.Media> arrayList) {
        this.medias = arrayList;
        notifyDataSetChanged();
    }

    public void updateSelectAdapter(java.util.ArrayList<com.dmcbig.mediapicker.entity.Media> arrayList) {
        if (arrayList != null) {
            this.selectMedias = arrayList;
        }
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final com.dmcbig.mediapicker.adapter.MediaGridAdapter.MyViewHolder myViewHolder, int i) {
        android.content.Context context;
        int i2;
        final com.dmcbig.mediapicker.entity.Media media = this.medias.get(i);
        android.net.Uri uri = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        int i3 = media.mediaType;
        if (i3 != 1 && i3 == 3) {
            uri = android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        }
        int i4 = media.id;
        if (i4 != Integer.MIN_VALUE) {
            final android.net.Uri uriWithAppendedId = android.content.ContentUris.withAppendedId(uri, i4);
            if (io.dcloud.common.util.HarmonyUtils.isHarmonyOs()) {
                io.dcloud.common.util.ThreadPool.self().addThreadTask(new java.lang.Runnable() { // from class: com.dmcbig.mediapicker.adapter.MediaGridAdapter$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m214x45afd60c(uriWithAppendedId, media, myViewHolder);
                    }
                });
            } else {
                com.bumptech.glide.Glide.with(this.context).load(uriWithAppendedId).into(myViewHolder.media_image);
            }
        } else {
            myViewHolder.media_image.setImageResource(java.lang.Integer.parseInt(media.path));
        }
        if (media.id == Integer.MIN_VALUE) {
            myViewHolder.gif_info.setVisibility(4);
            myViewHolder.video_info.setVisibility(4);
            myViewHolder.textView_size.setVisibility(4);
        } else if (media.mediaType == 3) {
            myViewHolder.gif_info.setVisibility(4);
            myViewHolder.video_info.setVisibility(0);
            myViewHolder.textView_size.setVisibility(0);
            myViewHolder.textView_size.setText(this.fileUtils.getSizeByUnit(media.size));
        } else {
            myViewHolder.video_info.setVisibility(4);
            myViewHolder.textView_size.setVisibility(0);
            myViewHolder.gif_info.setVisibility(".gif".equalsIgnoreCase(media.extension) ? 0 : 4);
        }
        int iIsSelect = isSelect(media);
        if (media.id == Integer.MIN_VALUE || this.isSingle) {
            myViewHolder.check_image.setVisibility(8);
            myViewHolder.mask_view.setVisibility(8);
        } else {
            myViewHolder.mask_view.setVisibility(iIsSelect >= 0 ? 0 : 4);
            myViewHolder.check_image.setVisibility(0);
            android.widget.ImageView imageView = myViewHolder.check_image;
            if (iIsSelect >= 0) {
                context = this.context;
                i2 = com.dmcbig.mediapicker.MediaPickerR.MP_DRAWABLE_BNT_SELECTED;
            } else {
                context = this.context;
                i2 = com.dmcbig.mediapicker.MediaPickerR.MP_DRAWABLE_BNT_UNSELECTED;
            }
            imageView.setImageDrawable(androidx.core.content.ContextCompat.getDrawable(context, i2));
        }
        myViewHolder.media_image.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.dmcbig.mediapicker.adapter.MediaGridAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                android.content.Context context2;
                int i5;
                com.dmcbig.mediapicker.entity.Media media2 = media;
                if (media2.id == Integer.MIN_VALUE) {
                    com.dmcbig.mediapicker.adapter.MediaGridAdapter.this.mOnItemClickListener.onAddMore();
                    return;
                }
                com.dmcbig.mediapicker.adapter.MediaGridAdapter mediaGridAdapter = com.dmcbig.mediapicker.adapter.MediaGridAdapter.this;
                if (mediaGridAdapter.isSingle) {
                    mediaGridAdapter.mOnItemClickListener.onItemClick(view, media, null);
                    return;
                }
                int iIsSelect2 = mediaGridAdapter.isSelect(media2);
                long size = com.dmcbig.mediapicker.adapter.MediaGridAdapter.this.selectMedias.size();
                com.dmcbig.mediapicker.adapter.MediaGridAdapter mediaGridAdapter2 = com.dmcbig.mediapicker.adapter.MediaGridAdapter.this;
                if (size >= mediaGridAdapter2.maxSelect && iIsSelect2 < 0) {
                    if (mediaGridAdapter2.mOnMaxListener != null) {
                        com.dmcbig.mediapicker.adapter.MediaGridAdapter.this.mOnMaxListener.onMaxed();
                        return;
                    }
                    return;
                }
                if (media.size > mediaGridAdapter2.maxSize) {
                    com.dcloud.android.widget.toast.ToastCompat.makeText(mediaGridAdapter2.context, (java.lang.CharSequence) (com.dmcbig.mediapicker.adapter.MediaGridAdapter.this.context.getString(com.dmcbig.mediapicker.MediaPickerR.MP_STRING_MSG_SIZE_LIMIT) + com.dmcbig.mediapicker.utils.FileUtils.fileSize(com.dmcbig.mediapicker.adapter.MediaGridAdapter.this.maxSize)), 1).show();
                    return;
                }
                myViewHolder.mask_view.setVisibility(iIsSelect2 >= 0 ? 4 : 0);
                android.widget.ImageView imageView2 = myViewHolder.check_image;
                if (iIsSelect2 >= 0) {
                    context2 = com.dmcbig.mediapicker.adapter.MediaGridAdapter.this.context;
                    i5 = com.dmcbig.mediapicker.MediaPickerR.MP_DRAWABLE_BNT_UNSELECTED;
                } else {
                    context2 = com.dmcbig.mediapicker.adapter.MediaGridAdapter.this.context;
                    i5 = com.dmcbig.mediapicker.MediaPickerR.MP_DRAWABLE_BNT_SELECTED;
                }
                imageView2.setImageDrawable(androidx.core.content.ContextCompat.getDrawable(context2, i5));
                com.dmcbig.mediapicker.adapter.MediaGridAdapter.this.setSelectMedias(media);
                com.dmcbig.mediapicker.adapter.MediaGridAdapter.this.mOnItemClickListener.onItemClick(view, media, com.dmcbig.mediapicker.adapter.MediaGridAdapter.this.selectMedias);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public com.dmcbig.mediapicker.adapter.MediaGridAdapter.MyViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
        return new com.dmcbig.mediapicker.adapter.MediaGridAdapter.MyViewHolder(android.view.LayoutInflater.from(viewGroup.getContext()).inflate(com.dmcbig.mediapicker.MediaPickerR.MP_LAYOUT_MEDIA_VIEW_ITEM, viewGroup, false));
    }
}
