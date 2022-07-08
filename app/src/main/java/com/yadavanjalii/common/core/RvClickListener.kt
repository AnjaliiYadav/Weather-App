package com.yadavanjalii.common.core

import android.view.View

/**
 * Weather-App
 *
 * @author Anjali Yadav
 * @date 08-Jul-22
 */
interface RvClickListener {
    fun click(
        view: View,
        item: Any?,
        position: Int,
        adapter: GlobalAdapter<Any>,
    )
}