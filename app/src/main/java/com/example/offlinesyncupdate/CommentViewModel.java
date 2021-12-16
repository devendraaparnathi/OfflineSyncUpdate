package com.example.offlinesyncupdate;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.offlinesyncupdate.Api.Comment;

import java.util.List;

public class CommentViewModel extends AndroidViewModel {

    private Repository repository;
    private final LiveData<List<Comment>> mListComment;

    public CommentViewModel(Application application) {
        super(application);
        repository = new Repository(application);
        mListComment = repository.getLivedata();
    }

    LiveData<List<Comment>> getListComment() {
        return mListComment;
    }

    public void insert(Comment comment) {
        repository.insert(comment);
    }

    public void deleteAll(){
        repository.deleteAll();
    }

}
