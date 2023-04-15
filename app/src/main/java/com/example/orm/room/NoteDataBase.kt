package com.example.orm.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [NoteData::class], version = 1)
abstract class NoteDataBase : RoomDatabase() {

    abstract fun noteDao() : NoteDAO

    companion object{
        private var INSTANCE : NoteDataBase? = null

        fun getInstance(context: Context):NoteDataBase? {
            if (INSTANCE == null){
                synchronized(NoteDataBase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        NoteDataBase::class.java,"Note.db").build()
                }
            }
            return INSTANCE
        }
    }
}