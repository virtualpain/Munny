package me.virtualpain.munny.activities.retrofit

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.TextView
import me.virtualpain.munny.helpers.debug
import org.jetbrains.anko.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TryRetrofitActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var resultText: TextView? = null

        verticalLayout {
            resultText = textView() {
                text = "Default result, should be changed in a moment"
            }.lparams() {
                width = matchParent
                height = wrapContent
            }
        }

        val call = postApi().viewPost(1)

        call.enqueue(object : Callback<PostModel> {
            override fun onFailure(call: Call<PostModel>?, t: Throwable?) {
                t?.printStackTrace()
                debug("Error: ".plus(t?.message))
                Handler(Looper.getMainLooper()).post {
                    toast("Error: " + t?.message)
                }
            }

            override fun onResponse(call: Call<PostModel>?, response: Response<PostModel>?) {
                Handler(Looper.getMainLooper()).post {
                    if (response?.code() == 200)
                    {
                        resultText?.text = response.body().toString()
                    }
                    else {
                        toast("Error: ".plus(response?.code().toString()))
                    }
                }
            }

        })


    }
}
