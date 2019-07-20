package ru.skillbranch.devintensive

import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import ru.skillbranch.devintensive.models.Bender
import android.widget.TextView.OnEditorActionListener
import ru.skillbranch.devintensive.extensions.hideKeyboard


class MainActivity : AppCompatActivity(), View.OnClickListener {


    lateinit var benderImage: ImageView
    lateinit var textTxt: TextView
    lateinit var messageEt: EditText
    lateinit var sendBtn: ImageView

    lateinit var benderObj: Bender

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        benderImage = iv_bender
        textTxt = tv_text
        messageEt = et_message
        sendBtn = iv_send

        messageEt.imeOptions = EditorInfo.IME_ACTION_DONE
        messageEt.setRawInputType(InputType.TYPE_CLASS_TEXT)
        messageEt.setSingleLine()

        messageEt.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                handleOnClickSend()
                hideKeyboard()
            }
            false
        }


        val status = savedInstanceState?.getString("STATUS") ?: Bender.Status.NORMAL.name
        val question = savedInstanceState?.getString("QUESTION") ?: Bender.Question.NAME.name
        benderObj = Bender(Bender.Status.valueOf(status), Bender.Question.valueOf(question))

        Log.d("M_MainActivity", "onCreate")
        val (r, g, b) = benderObj.status.color
        benderImage.setColorFilter(Color.rgb(r, g, b), PorterDuff.Mode.MULTIPLY)

        textTxt.text = benderObj.askQuestion()
        sendBtn.setOnClickListener(this)


    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putString("STATUS", benderObj.status.name)
        outState?.putString("QUESTION", benderObj.question.name)
        Log.d("M_MainActivity", "onSaveInstanceState ${benderObj.status.name} ${benderObj.question.name}")
    }

    private fun handleOnClickSend() {
        val validation = benderObj.validationCheck(messageEt.text.toString())
        if (benderObj.validationCheck(messageEt.text.toString()) == Bender.Validation.OK) {
            val (phrase, color) = benderObj.listenAnswer(messageEt.text.toString().toLowerCase())
            messageEt.setText("")
            val (r, g, b) = color
            benderImage.setColorFilter(Color.rgb(r, g, b), PorterDuff.Mode.MULTIPLY)
            textTxt.text = phrase
        } else {
            textTxt.text = "${validation.msg}\n${benderObj.askQuestion()}"
        }
//        val (phrase, color) = benderObj.listenAnswer(messageEt.text.toString().toLowerCase())
//        messageEt.setText("")
//        val (r, g, b) = color
//        benderImage.setColorFilter(Color.rgb(r, g, b), PorterDuff.Mode.MULTIPLY)
//        textTxt.text = phrase
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.iv_send) {
            handleOnClickSend()
        }
    }
}
