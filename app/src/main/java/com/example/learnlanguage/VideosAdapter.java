package com.example.learnlanguage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class VideosAdapter extends RecyclerView.Adapter<VideoViewHolder> {

    private List<Video> videos;

    private OnItemActionListener onItemActionListener;

    void setOnItemActionListener(OnItemActionListener onItemActionListener) {
        this.onItemActionListener = onItemActionListener;
    }

    void setVideos(List<Video> videos) {
        this.videos = videos;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.videos_item, parent, false);
        VideoViewHolder videoViewHolder = new VideoViewHolder(view);
        return videoViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        Video video = videos.get(position);
        holder.titleTxt.setText(video.title);
        holder.descriptionTxt.setText(video.description);
        holder.channelNameTxt.setText(video.channelName);
        holder.viewsTxt.setText(video.numberOfViews);
        holder.uploadTimeTxt.setText(video.uploadedTime);
        Picasso.get().load(video.imageUrl).into(holder.imageUrlTxt);
        Picasso.get().load(video.channelLogoUrl).into(holder.channelLogoUrlTxt);
        holder.deleteBtn.setOnClickListener(view -> {
            onItemActionListener.onDelete(video.id);
        });
        holder.itemView.setOnClickListener(view -> {
            onItemActionListener.onEdit(video);
        });
    }

    @Override
    public int getItemCount() {
        return videos.size();
    }
}
