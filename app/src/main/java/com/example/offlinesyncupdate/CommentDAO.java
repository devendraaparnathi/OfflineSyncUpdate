package com.example.offlinesyncupdate;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
interface CommentDAO {
    // allowing the insert of the same word multiple times by passing a
    // conflict resolution strategy
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Comment comment);

    @Query("DELETE FROM MY_COMMENT")
    void deleteAll();

    @Query("SELECT * FROM MY_COMMENT ORDER BY comment ASC")
    LiveData<List<Comment>> getAlphabetizedComment();

}
