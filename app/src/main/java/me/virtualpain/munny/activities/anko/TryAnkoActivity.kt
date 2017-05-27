package me.virtualpain.munny.activities.anko

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity.CENTER_HORIZONTAL
import org.jetbrains.anko.*

class TryAnkoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_try_anko)

        var myText: String = "Whatever you write dude!"

        verticalLayout {
            textView {
                text = "Hello"
            }.lparams(width = matchParent)

            button("I <3 Anko") {
                setOnClickListener {
                    toast("Hi there, I am a view made by Anko")
                }
            }.lparams {
                width = wrapContent
                gravity = CENTER_HORIZONTAL
            }

            textView("Nier:Automata").lparams(width = matchParent)
            textView("I love banana") {
                textSize = 40f
                gravity = CENTER_HORIZONTAL
            }.lparams(width = matchParent) {
                topPadding = dip(10)
                bottomPadding = dip(10)
            }

            val myTextInput = editText(myText) {
                maxLines = 1
                lines = 1
            }
            button("Submit") {
                setOnClickListener {
                    myText = myTextInput.text.toString()
                    if (myText.isNotEmpty())
                    {
                        val max_len = 50
                        if (myText.length > max_len)
                        {
                            toast("You wrote: ".plus(myText.substring(0..max_len).plus("...")))
                        }
                        else {
                            toast("You wrote: ".plus(myText))
                        }
                    }
                    else {
                        toast("Please write something!")
                    }
                }
            }
        }
    }
}
