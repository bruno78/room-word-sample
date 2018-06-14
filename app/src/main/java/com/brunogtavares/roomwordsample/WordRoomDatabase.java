package com.brunogtavares.roomwordsample;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Annotate the class to be a Room database, declare the entities that belong
 * in the database and set the version number.
 * Listing the entities will create tables in the database.
 */
@Database(entities = {Word.class}, version = 1)
public abstract class WordRoomDatabase extends RoomDatabase {

    // Define the DAOs that work with the database.
    // Provide an abstract "getter" method for each @Dao.
    public abstract WordDao wordDao();

    // Make the WordRoomDatabase a singleton to prevent having multiple instances
    // of the database opened at the same time.
    private static WordRoomDatabase INSTANCE;

    public static WordRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (WordRoomDatabase.class) {
                if (INSTANCE == null) {
                    // Create database here
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            WordRoomDatabase.class, "word_database").build();
                }
            }
        }
        return INSTANCE;
    }
}

