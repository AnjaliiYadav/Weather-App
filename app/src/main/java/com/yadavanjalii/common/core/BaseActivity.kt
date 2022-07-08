package com.yadavanjalii.common.core

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding


/**
 * Weather-App
 *
 * @author Anjali Yadav
 * @date 08-Jul-22
 */
abstract class BaseActivity<B : ViewDataBinding> : AppCompatActivity() {

     protected lateinit var binding: B


    private fun initBinding() {
        binding = getViewBinding()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.initBinding()
        setContentView(binding.root)
    }

    abstract fun getViewBinding(): B
}