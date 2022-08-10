package space.beka.todoapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main3.*
import ramizbek.aliyev.todoapp.R
import space.beka.todoapp.MyShare.MyShare
import space.beka.todoapp.Object.Object
import space.beka.todoapp.Object.Object.todoListName
import space.beka.todoapp.Object.Object.todoName
import space.beka.todoapp.UserData.ForUserData
import space.beka.todoapp.UserData.UserData


class MainActivity3 : AppCompatActivity() {
    lateinit var dataList: ArrayList<UserData>
    lateinit var arrayListData: ArrayList<ForUserData>
    private var index = -1
    var todoListName = ""
    var todoName = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        MyShare.init(this)
        MyWorkShow()

        radio_button_open.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                arrayListData[index].todoListName = "Open"
                dataList[0].arrayListData = arrayListData
                MyShare.dataList = dataList
            }
        }
        radio_button_development.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                arrayListData[index].todoListName = "Development"
                dataList[0].arrayListData = arrayListData
                MyShare.dataList = dataList
            }
        }
        radio_button_uploading.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                arrayListData[index].todoListName = "Uploading"
                dataList[0].arrayListData = arrayListData
                MyShare.dataList = dataList
            }
        }
        radio_button_reject.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                arrayListData[index].todoListName = "Reject"
                dataList[0].arrayListData = arrayListData
                MyShare.dataList = dataList
            }
        }
        radio_button_closed.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                arrayListData[index].todoListName = "Closed"
                dataList[0].arrayListData = arrayListData
                MyShare.dataList = dataList
            }
        }

    }

    private fun MyWorkShow() {
        dataList = ArrayList()
        arrayListData = ArrayList()
        dataList.addAll(MyShare.dataList!!)
        arrayListData = dataList[0].arrayListData
        todoListName = Object.todoListName
        todoName = space.beka.todoapp.Object.Object.todoName

        for (k in 0 until arrayListData.size) {
            if (arrayListData[k].todoListName == todoListName && arrayListData[k].todoName == todoName) {
                index = k
                break
            }
        }
        tv_todo_name_AC3.text = arrayListData[index].todoName
        tv_description_AC3.text = arrayListData[index].todoDescription
        tv_degree_AC3.text = arrayListData[index].todoDegree
        tv_create_data_AC3.text = arrayListData[index].todoCreateDate
        tv_deadline_AC3.text = arrayListData[index].todoDeadline
        when (arrayListData[index].todoDegree) {
            "Urgent" -> {
                image_flag.setImageResource(R.drawable.ic_red_flag)
            }
            "High" -> {
                image_flag.setImageResource(R.drawable.ic_yellow_flag)
            }
            "Normal" -> {
                image_flag.setImageResource(R.drawable.ic_grean_flag)

            }
            "Low" -> {
                image_flag.setImageResource(R.drawable.ic_baseline_flag_24)
            }
        }
        when (arrayListData[index].todoListName) {
            "Open" -> {
                radio_button_open.isChecked = true
            }
            "Development" -> {
                radio_button_development.isChecked = true
            }
            "Uploading" -> {
                radio_button_uploading.isChecked = true
            }
            "Reject" -> {
                radio_button_reject.isChecked = true
            }
            "Closed" -> {
                radio_button_closed.isChecked = true
            }
        }
    }
}