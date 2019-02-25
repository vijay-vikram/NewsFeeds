package com.newsfeeds.network.models

import android.text.TextUtils
import androidx.core.text.TextUtilsCompat
import com.google.gson.annotations.SerializedName
import com.newsfeeds.constants.EMPTY_STRING

abstract class BaseResponse(@SerializedName("status") val status: String = EMPTY_STRING,
                            @SerializedName("code") val code: String = EMPTY_STRING,
                            @SerializedName("message") val message: String = EMPTY_STRING)