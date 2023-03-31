package com.example.myapplication

import android.graphics.Paint
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.EventItemBinding


class EventAdapter: RecyclerView.Adapter <EventAdapter.EventHolder>() {
    val eventList = ArrayList<Event>()

    class EventHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = EventItemBinding.bind(item)
        fun bind(event: Event) = with(binding){
            checkB.setOnClickListener {
                if (checkB.isChecked())
                {
                    textV.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                }
                else
                {
                    textV.setPaintFlags(Paint.ANTI_ALIAS_FLAG);
                }
            }

            btnDel.setOnClickListener {
                cardV.visibility = View.GONE
            }

            if (checkB.isChecked())
            {
                textV.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            }
            textV.text = event.nameEvent

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.event_item, parent, false)
        return EventHolder(view)
    }

    override fun getItemCount(): Int {
        return eventList.size
    }

    override fun onBindViewHolder(holder: EventHolder, position: Int) {
        holder.bind(eventList[position])
    }

    fun addEvent(event: Event)
    {
        eventList.add(event)

        notifyDataSetChanged()
    }

}