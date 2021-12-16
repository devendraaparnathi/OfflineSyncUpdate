package com.example.offlinesyncupdate;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.offlinesyncupdate.Api.Comment;

import java.util.List;

public class Repository {

    private CommentDAO mCommentDAO;
    private LiveData<List<Comment>> mLivedata;

    Repository(Application application) {
        CommentRoomDatabase database = CommentRoomDatabase.getDatabase(application);
        mCommentDAO = database.commentDAO();
        mLivedata = mCommentDAO.getAlphabetizedComment();
    }

    LiveData<List<Comment>> getLivedata() {
        return mLivedata;
    }

    void insert(Comment comment) {
        CommentRoomDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mCommentDAO.insert(comment);
            }
        });
    }

    void deleteAll()
    {
        mCommentDAO.deleteAll();
    }

}
