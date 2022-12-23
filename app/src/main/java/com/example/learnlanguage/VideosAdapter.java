package com.example.learnlanguage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learnlanguage.databinding.VideoItemBinding;
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
        VideoItemBinding binding = VideoItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        VideoViewHolder videoViewHolder = new VideoViewHolder(binding);
        return videoViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        Video video = videos.get(position);
        holder.binding.titleText.setText(video.title);
        holder.binding.descriptionTxt.setText(video.description);
        holder.binding.channelNameTxt.setText(video.channelName);
        holder.binding.viewsTxt.setText(video.numberOfViews);
        holder.binding.uploadTimeTxt.setText(video.uploadedTime);
        Picasso.get().load(video.imageUrl).into(holder.binding.imageUrlText);
        Picasso.get().load(video.channelLogoUrl).into(holder.binding.channelLogoUrlTxt);
        holder.binding.deleteBtn.setOnClickListener(view -> {
            onItemActionListener.onDelete(video.id);
        });
        holder.binding.getRoot().setOnClickListener(view -> {
            onItemActionListener.onClicked(video);
        });
        holder.binding.editBtn.setOnClickListener(view -> {
            onItemActionListener.onEdit(video);
        });
    }

    @Override
    public int getItemCount() {
        return videos.size();
    }
}
