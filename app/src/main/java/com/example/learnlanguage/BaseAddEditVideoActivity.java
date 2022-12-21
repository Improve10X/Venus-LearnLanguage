package com.example.learnlanguage;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class BaseAddEditVideoActivity extends BaseActivity {

    protected Button addBtn;
    protected EditText titleTextTxt;
    protected EditText descriptionTextTxt;
    protected EditText channelNameTextTxt;
    protected EditText numberOfViewsTextTxt;
    protected EditText uploadTimeTextTxt;
    protected EditText imageUrlTextTxt;
    protected EditText channelLogoTextTxt;
    protected Button editBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_add_edit_video);
        setUpViews();
    }

    private void setUpViews() {
        editBtn = findViewById(R.id.edit_btn);
        addBtn = findViewById(R.id.add_btn);
        titleTextTxt = findViewById(R.id.tilte_text_txt);
        descriptionTextTxt = findViewById(R.id.description_text_txt);
        channelNameTextTxt = findViewById(R.id.channel_name_text_txt);
        numberOfViewsTextTxt = findViewById(R.id.numberof_text_txt);
        uploadTimeTextTxt = findViewById(R.id.upload_time_text_txt);
        imageUrlTextTxt = findViewById(R.id.image_url_text_txt);
        channelLogoTextTxt = findViewById(R.id.channel_logo_url_text_txt);
    }
}