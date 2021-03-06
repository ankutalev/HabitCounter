package com.example.neofr.habitcounter.view

import android.view.View
import com.example.neofr.habitcounter.R
import com.example.neofr.habitcounter.model.HabitCounter

class HabitCounterAdapterImpl(protected val onClickListener: View.OnClickListener) : HabitCounterAdapter {
    override fun modelToView(habitCounter: HabitCounter, view: HabitView) {
        view.counter.text = habitCounter
            .resourceCounters
            .joinToString(
                separator = "\n",
                transform = { " ${it.resource.name} : ${it.count}\n" }
            )
        view.name.text = habitCounter.habit.name
        view.countButton.setOnClickListener(onClickListener)
        view.description.text = habitCounter.habit.description
        view.logo.setImageResource(logoCache[habitCounter.habit.name] ?: R.drawable.smoke_logo)
    }

    protected val logoCache = hashMapOf<String, Int>(
        Pair("smoking", R.drawable.smoke_logo),
        Pair("drinking", R.drawable.coffee)
    )
}