package com.example.session4

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.session4.databinding.ItemLessonBinding
import com.example.session4.modules.Lesson
import com.example.session4.modules.LessonData
import java.text.SimpleDateFormat
import java.util.*
// yzvan
// 14.04.23
// класс  создан для подстановки item recyclerView
class AdapterPlan(private  val lessons:List<LessonData>): RecyclerView.Adapter<AdapterPlan.PlanHolder>() {
    class PlanHolder(private  val binding : ItemLessonBinding) :RecyclerView.ViewHolder(binding.root) {
        fun bind(lesson: LessonData,position: Int) {
            binding.titleLesson.text = lesson.title
            val hour = lesson.duration / 60
            binding.duration.text = "$hour ${getHourText(hour)}"

            if (lesson.isComplete){
                binding.textStatus.text = "выполнено"
                binding.cardStatus.setCardBackgroundColor(Color.parseColor("#FFE07F"))
            }else{
                val datelesson: Date = SimpleDateFormat("dd.MM.yyyy hh:mm",Locale.getDefault()).parse(lesson.datetime)!!
                val dateNow = Date()
                if (dateNow.time < datelesson.time){
                    binding.textStatus.text = "начать"
                    binding.cardStatus.setCardBackgroundColor(Color.parseColor("#FFC100"))
                }else {
                    binding.textStatus.text = "просрочено"
                    binding.cardStatus.setCardBackgroundColor(Color.parseColor("#FFC100"))
                }
            }

        }
            private fun getHourText(hour:Int):String{
                val hourstr = hour.toString()
                if (hourstr.last() == '1' && hourstr != "11")
                    return "час"
                if (hourstr.last() in "234")
                    return  "часа"
                return "часов"


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanHolder {
        return PlanHolder(ItemLessonBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return  lessons.size
    }

    override fun onBindViewHolder(holder: PlanHolder, position: Int) {
        holder.bind(lessons[position],position)

    }

}