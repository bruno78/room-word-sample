package com.brunogtavares.roomwordsample;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * In the DAO (data access object), you specify SQL queries and associate them with method calls.
 * The compiler checks the SQL and generates queries from convenience annotations for common queries, such as @Insert.
 * The DAO must be an interface or abstract class.
 * By default, all queries must be executed on a separate thread.
 * Room uses the DAO to create a clean API for your code.
 */
@Dao
public interface WordDao {

    @Insert
    void insert(Word word);

    // There is no convenience annotation for deleting multiple entities, so annotate the method with the generic
    @Query("DELETE FROM word_table")
    void deleteAll();

    @Query("SELECT * FROM word_table ORDER BY word ASC")
    List<Word> getAllWords();
}
