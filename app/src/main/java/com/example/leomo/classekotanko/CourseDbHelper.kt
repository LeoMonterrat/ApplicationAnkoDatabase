package com.example.leomo.classekotanko

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

class CourseDbHelper(ctx: Context = App.instance) : ManagedSQLiteOpenHelper(ctx, DB_NAME, null, DB_VERSION) {
    override fun onCreate(db: SQLiteDatabase){

        db.createTable(MobileCourseTable.NAME, true,
            MobileCourseTable.ID to INTEGER + PRIMARY_KEY,
            MobileCourseTable.TITLE to TEXT, MobileCourseTable.TIME to INTEGER)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int){

        db.dropTable(MobileCourseTable.NAME, true)
        onCreate(db)
    }

    companion object {

        val DB_NAME = "course.db"
        val DB_VERSION = 1

        val instance by lazy { CourseDbHelper() }
    }

}