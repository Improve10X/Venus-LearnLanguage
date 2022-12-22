package com.example.learnlanguage;

public interface OnItemActionListener {

    void onClicked(Video video);

    void onDelete(String id);

    void onEdit(Video video);
}
