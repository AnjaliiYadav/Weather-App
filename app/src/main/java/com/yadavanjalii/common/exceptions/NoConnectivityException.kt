package com.yadavanjalii.common.exceptions

import java.io.IOException

/**
 * Weather-App
 *
 * @author Anjali Yadav
 * @date 08-Jul-22
 */
class NoConnectivityException: IOException() {
    override val message: String?
        get() = "No Internet Connection"
}