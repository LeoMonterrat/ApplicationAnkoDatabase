package com.example.leomo.classekotanko

import android.database.sqlite.SQLiteDatabase
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.db.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.info
import org.jetbrains.anko.uiThread


class MainActivity : AppCompatActivity(),AnkoLogger {

    private val courseDb by lazy {
        CourseDb(CourseDbHelper(applicationContext))
    }

    var list = listOf<MobileCourse>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        doAsync {
            val course1 = MobileCourse("ABC Android", 120)
            val course2 = MobileCourse("Cours sur les list", 240)
            courseDb.saveCourse(course1)
            courseDb.saveCourse(course2)
            list = courseDb.requestCourse()
            uiThread {
                showList()
            }
        }
    }

    private fun showList() {

        info("NB COURS : ${list.size}")
        for (c in list)
            info("Voici un cours ${c.title}")
    }



}
