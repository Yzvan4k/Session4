package com.example.session4

import com.example.session4.modules.Lesson
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

interface API {
    @GET("workSapce/paln")
    fun getPlan(@Header("idUser")id:Int,@Query("date")date:String,@Query("courseId")courseId:Int,@Query("direction")direction:String):Call<List<Lesson>>
    @POST("workSapce/confirmLesson")
    fun postConfirm(@Header("idUser")id:Int,@Query("idLesson")idLesson:Int,@Query("qcommentFile")comment:String):Call<Boolean>
    @GET("workSpace/delaySessions")
    fun getDelaySession(@Header("idUser")id:Int):Call<List<Lesson>>
}