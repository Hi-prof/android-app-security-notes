package com.dmcbig.mediapicker.adapter;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class FolderAdapter extends android.widget.BaseAdapter {
    java.util.ArrayList<com.dmcbig.mediapicker.entity.Folder> folders;
    int lastSelected = 0;
    private android.content.Context mContext;
    private android.view.LayoutInflater mInflater;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class ViewHolder {
        android.widget.ImageView cover;
        android.widget.ImageView indicator;
        android.widget.TextView name;
        android.widget.TextView path;
        android.widget.TextView size;

        ViewHolder(android.view.View view) {
            this.cover = (android.widget.ImageView) view.findViewById(com.dmcbig.mediapicker.MediaPickerR.MP_ID_COVER);
            this.name = (android.widget.TextView) view.findViewById(com.dmcbig.mediapicker.MediaPickerR.MP_ID_NAME);
            this.path = (android.widget.TextView) view.findViewById(com.dmcbig.mediapicker.MediaPickerR.MP_ID_PATH);
            this.size = (android.widget.TextView) view.findViewById(com.dmcbig.mediapicker.MediaPickerR.MP_ID_SIZE);
            this.indicator = (android.widget.ImageView) view.findViewById(com.dmcbig.mediapicker.MediaPickerR.MP_ID_INDICATOR);
            view.setTag(this);
        }
    }

    public FolderAdapter(java.util.ArrayList<com.dmcbig.mediapicker.entity.Folder> arrayList, android.content.Context context) {
        this.mInflater = (android.view.LayoutInflater) context.getSystemService("layout_inflater");
        this.folders = arrayList;
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.folders.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    public java.util.ArrayList<com.dmcbig.mediapicker.entity.Media> getSelectMedias() {
        return this.folders.get(this.lastSelected).getMedias();
    }

    @Override // android.widget.Adapter
    public android.view.View getView(int i, android.view.View view, android.view.ViewGroup viewGroup) {
        com.dmcbig.mediapicker.adapter.FolderAdapter.ViewHolder viewHolder;
        if (view == null) {
            view = this.mInflater.inflate(com.dmcbig.mediapicker.MediaPickerR.MP_LAYOUT_FOLDERS_VIEW_ITME, viewGroup, false);
            viewHolder = new com.dmcbig.mediapicker.adapter.FolderAdapter.ViewHolder(view);
        } else {
            viewHolder = (com.dmcbig.mediapicker.adapter.FolderAdapter.ViewHolder) view.getTag();
        }
        com.dmcbig.mediapicker.entity.Folder item = getItem(i);
        if (item.getMedias().size() > 0) {
            com.dmcbig.mediapicker.entity.Media media = item.getMedias().get(0);
            com.bumptech.glide.Glide.with(this.mContext).load(android.net.Uri.parse(io.dcloud.common.adapter.util.DeviceInfo.FILE_PROTOCOL + media.path)).into(viewHolder.cover);
        } else {
            viewHolder.cover.setImageDrawable(androidx.core.content.ContextCompat.getDrawable(this.mContext, com.dmcbig.mediapicker.MediaPickerR.MP_DRAWABLE_DEFAULT_IMAGE));
        }
        viewHolder.name.setText(item.name);
        viewHolder.size.setText(item.getMedias().size() + "" + this.mContext.getString(com.dmcbig.mediapicker.MediaPickerR.MP_STRING_COUNT_STRING));
        viewHolder.indicator.setVisibility(this.lastSelected != i ? 4 : 0);
        return view;
    }

    public void setSelectIndex(int i) {
        if (this.lastSelected == i) {
            return;
        }
        this.lastSelected = i;
        notifyDataSetChanged();
    }

    public void updateAdapter(java.util.ArrayList<com.dmcbig.mediapicker.entity.Folder> arrayList) {
        this.folders = arrayList;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public com.dmcbig.mediapicker.entity.Folder getItem(int i) {
        return this.folders.get(i);
    }
}
