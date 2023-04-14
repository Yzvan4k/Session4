package com.example.session4.modules

data class LessonData(
    val id:Int,
    val idCourse:Int,
    val title:String,
    val description:String,
    val isComplete:Boolean,
    val datetime:String,
    val duration:Int
)
