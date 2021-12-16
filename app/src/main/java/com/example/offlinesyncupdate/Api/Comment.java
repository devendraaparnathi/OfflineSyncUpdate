package com.example.offlinesyncupdate.Api;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "MY_COMMENT")
public class Comment {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "comment")

    private String mComment;

    public Comment(@NonNull String comment) {this.mComment = comment;}

    public String getComment(){return this.mComment;}

}
