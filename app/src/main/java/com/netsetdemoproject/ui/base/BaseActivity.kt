package com.netsetdemoproject.ui.base


import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatActivity
import com.netset.mvpexample.network.ApiClient
import com.netset.mvpexample.network.ApiInterface
import com.netsetdemoproject.R
import com.netsetdemoproject.ui.home.SearchActivity
import org.json.JSONObject
import retrofit2.HttpException

open class BaseActivity : MvpAppCompatActivity(),BaseView {


     var mProgressDialog: ProgressDialog? = null
     var apiClient: ApiClient? = null
    var apiInterface: ApiInterface ?= null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /**
         * Creating Api Client for Network calls
         * [ApiClient]
         * [ApiInterface]
         */
        createApiClient()
    }


    /**
     * Intent Method for starting activity and clearing all the activities in the stack.
     */
    fun startActivityWithFinish(required_class: Class<*>) {
        val intent = Intent(this, required_class)
        startActivity(intent)
        finishAffinity()
    }


    /**
     * Api Client create for Network calls using retrofit and Rx-java
     * Now client is created we can access it any Activity or Fragment.
     */
    private fun createApiClient() {
        apiClient = ApiClient(this)
        apiInterface = apiClient!!.getClient().create(ApiInterface::class.java)
    }

    /**
     * To display progress dialog.
     * to be displayed while making any network call.
     */
    override fun showLoading() {
        try {
            if (mProgressDialog == null) {
                mProgressDialog = ProgressDialog(this)
                mProgressDialog!!.setCancelable(false)
                mProgressDialog!!.setTitle("")
                mProgressDialog!!.setMessage("Please wait...")
                mProgressDialog!!.show()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
    /**
     * To hide progress dialog.
     * But first check if Progress Dialog is not null and progress
     * dialog is currently active/displaying
     */
    override fun hideLoading() {
        try {
            if (mProgressDialog != null && mProgressDialog!!.isShowing) {
                mProgressDialog!!.dismiss()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    /**
     * Showing Toast for whole app.
     */

    override fun showToast(message:String) {
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show()
    }



    /**
     * This method will check all the error thrown on onError Method of Rx-java
     * first we will check that if exception is of HttpException
     * then check it will Html Codes like 401,402 and all
     * if its is 401: Redirect user on Login Screen as this error id for
     * Unauthorized or Session expire.
     */

    override fun ResponseError(e: Throwable) {
        if (e is HttpException) {
            val errorCode = e.response().code()
            if (errorCode == 401) {
                showToast(getString(R.string.session_expire))
                startActivityWithFinish(SearchActivity::class.java)
            } else {
                try {
                    val errorBody = e.response().errorBody()!!.string()
                    val msgobj = JSONObject(errorBody)
                    val msg = msgobj.optString("message")
                    showToast(msg)
                } catch (e1: Exception) {
                    e1.printStackTrace()
                }

            }
        } else {
            showToast(e.toString())
        }
    }


}
