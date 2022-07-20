package com.weightwatchers.ww_exercise_01.util

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import cn.pedant.SweetAlert.SweetAlertDialog


object LoadingScreen {
    private lateinit var loadingDialog:SweetAlertDialog //obj
    private lateinit var errorDialog:SweetAlertDialog //obj
    fun displayLoadingWithText(context: Context?, text: String?, cancelable: Boolean) { // function -- context(parent (reference))
        loadingDialog = SweetAlertDialog(context, SweetAlertDialog.PROGRESS_TYPE)
        loadingDialog.progressHelper.barColor = Color.parseColor("#A5DC86")
        loadingDialog.titleText = text
        loadingDialog.setCancelable(true)
        try {
            loadingDialog.show()
        }catch (e:Exception) {
        }
    }

    fun hideLoading() {
        try {
            loadingDialog.dismiss()
        } catch (e: Exception) {
        }
    }

    fun showErrorMessage(context: Context,title:String,message:String,lmd:()->Unit){
        errorDialog= SweetAlertDialog(context ,SweetAlertDialog.ERROR_TYPE)
            .setTitleText(title)
            .setContentText(message)
            .setRetryText("Retry") { sDialog ->
                lmd()
                sDialog
                    .setTitleText("Retry!")
                    .setConfirmClickListener(null)
                sDialog.dismiss()
            }
        try {
            errorDialog.show()
        }catch (e:Exception) {
        }
    }

    fun hideErrorDialog(){
        try {
            errorDialog.dismiss()
        }catch (e:Exception) {
        }
    }
     fun SweetAlertDialog.setRetryText( text:String,  listener: SweetAlertDialog.OnSweetClickListener): SweetAlertDialog {
        setConfirmButton(text, listener)
        return this
    }
}

fun calculateNoOfColumns(context: Context): Int {
    val displayMetrics = context.resources.displayMetrics
    val dpWidth = displayMetrics.widthPixels / displayMetrics.density
    return (dpWidth / 180).toInt()
}


