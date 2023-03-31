package com.example.myapplication

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.marginTop
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var  binding: ActivityMainBinding
    private val adapter = EventAdapter()
    private var m_Text = ""

    private lateinit var btn : Button
    private lateinit var rcl : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        init()
    }

    fun showdialog(adapter: EventAdapter)
    {
        val builder: AlertDialog.Builder = android.app.AlertDialog.Builder(this)

        val input = EditText(this)
        input.setHint("Enter your task")
        input.inputType = InputType.TYPE_CLASS_TEXT
        builder.setView(input)

        builder.setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which ->
            m_Text = input.text.toString()

            val event = Event(false, m_Text)
            adapter.addEvent(event)
        })

        builder.setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, which -> dialog.cancel() })

        builder.show()
    }

    private fun init()
    {
        btn = findViewById(R.id.btnAdd)

        rcl = findViewById(R.id.rcView)
        rcl.layoutManager = LinearLayoutManager(this@MainActivity)
        rcl.adapter = adapter

        btn.setOnClickListener{
            showdialog(adapter)
        }


//        checkBox.setOnClickListener {
//            if (checkBox.isChecked)
//            {
//
//            }
//
//        }
    }
}