package com.yadavanjalii.weather_app.ui.screens


import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.yadavanjalii.common.constants.Constants.TAG
import com.yadavanjalii.common.constants.Constants.city
import com.yadavanjalii.weather_app.databinding.MainClass
import com.yadavanjalii.common.core.BaseActivity
import com.yadavanjalii.common.core.GlobalAdapter
import com.yadavanjalii.common.core.RvClickListener
import com.yadavanjalii.common.utils.Helper
import com.yadavanjalii.weather_app.data.response.ForecastResponse
import com.yadavanjalii.weather_app.ui.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * Weather-App
 *
 * @author Anjali Yadav
 * @date 08-Jul-22
 */
@AndroidEntryPoint
class MainActivity : BaseActivity<MainClass>(), View.OnClickListener {

    private lateinit var viewModel: MainViewModel
    private lateinit var fragmentClickListener: RvClickListener
    private lateinit var lists: ForecastResponse
    override fun getViewBinding(): MainClass {
        return MainClass.inflate(layoutInflater)

    }

    override fun onStart() {
        super.onStart()
        setListeners()
        setAdapter()
        getData()
    }

    private fun getData() {
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.getForecast(city[0]).observe(this) { response ->
            if (response != null) {
                Log.d(TAG, "onStart: forecast ${response.body()}")
                lists= response.body()!!
                setAdapter()
            }else{
                Log.d(TAG, "getData: No response : Failed")
            }
        }

        viewModel.getWeather(city[0]).observe(this) { response ->
            if (response != null) {
                Log.d(TAG, "onStart: weather ${response.body()}")
                binding.current= response.body()
            }else{
                Log.d(TAG, "getData: No response : Failed")
            }
        }

    }

    private fun setAdapter() {
        try {
            binding.click = this
            binding.itemclick = fragmentClickListener
            binding.model = lists
        } catch (e: Exception) {
            Helper.print("${e.message}")
        }
    }

    override fun onClick(p0: View?) {

    }

    private fun setListeners() {
        fragmentClickListener = object : RvClickListener {
            override fun click(
                view: View,
                item: Any?,
                position: Int,
                adapter: GlobalAdapter<Any>,
            ) {


            }
        }
    }


}