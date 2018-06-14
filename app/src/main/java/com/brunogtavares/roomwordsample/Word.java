package com.brunogtavares.roomwordsample;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * The data for this app is words, and each word is an Entity. Here is were we describe word Entity
 * To make the Word class meaningful to Room database, it needs to be annotated. Annotations identify
 * how each part of this class relates to an entry in the database. Room uses this information to generate
 * the code.
 */
@Entity(tableName = "word_table")
public class Word {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @NonNull
    @ColumnInfo(name = "word")
    private String mWord;

    public Word(@NonNull String word) { this.mWord = word; }

    public String getWord() { return mWord; }
}
