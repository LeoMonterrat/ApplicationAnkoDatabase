package com.example.leomo.classekotanko

import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select

class CourseDb(private val dbHelper: CourseDbHelper = CourseDbHelper.instance): AnkoLogger {
    fun requestCourse() = dbHelper.use {

        select(
            MobileCourseTable.NAME,
            MobileCourseTable.TITLE,
            MobileCourseTable.TIME)
            .parseList(classParser<MobileCourse>())
    }

    fun saveCourse(course: MobileCourse) = dbHelper.use {

        insert(MobileCourseTable.NAME,
            MobileCourseTable.TITLE to course.title,
            MobileCourseTable.TIME to course.time)
    }

    fun saveCourses(courseList: List<MobileCourse>){

        for (c in courseList)
            saveCourse(c)
    }
}