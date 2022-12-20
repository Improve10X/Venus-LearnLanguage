package com.example.learnlanguage;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class VideoViewHolder extends RecyclerView.ViewHolder {

    ImageView imageUrlTxt;
    ImageButton deleteBtn;
    ImageView channelLogoUrlTxt;
    TextView titleTxt;
    TextView descriptionTxt;
    TextView channelNameTxt;
    TextView viewsTxt;
    TextView uploadTimeTxt;


    public VideoViewHolder(@NonNull View itemView) {
        super(itemView);
        imageUrlTxt = itemView.findViewById(R.id.image_url_txt);
        deleteBtn = itemView.findViewById(R.id.delete_btn);
        channelLogoUrlTxt = itemView.findViewById(R.id.channel_logo_url_txt);
        titleTxt = itemView.findViewById(R.id.title_txt);
        descriptionTxt = itemView.findViewById(R.id.description_txt);
        channelNameTxt = itemView.findViewById(R.id.channel_name_txt);
        viewsTxt = itemView.findViewById(R.id.views_txt);
        uploadTimeTxt = itemView.findViewById(R.id.upload_time_txt);
    }
}
