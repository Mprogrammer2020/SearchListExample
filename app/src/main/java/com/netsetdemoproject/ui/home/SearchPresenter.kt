package com.netsetdemoproject.ui.home


import com.arellomobile.mvp.MvpPresenter
import com.netset.mvpexample.network.ApiClient
import com.netsetdemoproject.ui.base.BaseActivity
import com.netsetdemoproject.utils.CommonInterface
import retrofit2.Response
import rx.Observer
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class SearchPresenter : MvpPresenter<CommonInterface.SearchView>(){
    lateinit var service: ApiClient
    lateinit var subscription: Subscription

    /**
     *
     * @param ApiToken
     */
    fun SearchAPI(api_token: String,baseActivity: BaseActivity) {

        val call = baseActivity.apiInterface!!.apiName(api_token)

        subscription = call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<Response<Void>> {
                    override fun onCompleted() {

                    }

                    override fun onError(e: Throwable) {
                        val it = attachedViews.iterator()
                        while (it.hasNext()) {
                            val f = it.next()


                            f.ResponseError(e)

                            break

                        }
                    }

                    override fun onNext(response: Response<Void>) {

                        if (response.code() == 200) {
                            val it = attachedViews.iterator()
                            while (it.hasNext()) {
                                val f = it.next()

                                f.ResponseSucess(response.body())

                                break
                            }

                        }/*else {
                            val it = attachedViews.iterator()
                            while (it.hasNext()) {
                                val f = it.next()

                                try {
                                    val jsonObject = JSONObject(response.errorBody()!!.string())
                                    val jsonString = jsonObject.toString()
                                    val obj = JSONObject(jsonString)
                                    f.ResponseError(obj.getString("message"))

                                } catch (e: JSONException) {
                                    e.printStackTrace()
                                } catch (e: IOException) {
                                    e.printStackTrace()
                                }

                                break
                            }*/



                    }
                })
    }


}