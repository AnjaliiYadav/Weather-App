package com.yadavanjalii.common.utils

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.yadavanjalii.common.constants.Constants.TAG

/**
 * Weather-App
 *
 * @author Anjali Yadav
 * @date 08-Jul-22
 */
class Helper {
    companion object {
        fun print(message: String) {
            Log.d(TAG, message)
        }

        fun toastHome(message: String, context: Context)
        {
            Toast.makeText( context, message, Toast.LENGTH_SHORT).show()
        }

        fun convertMapToList(map: Map<String, String>): ArrayList<String> {
            return ArrayList(map.values)
        }

    }
}