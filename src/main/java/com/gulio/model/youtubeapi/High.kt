package com.gulio.model.youtubeapi

import com.google.gson.annotations.SerializedName


data class High(

    @SerializedName("url") var url: String? = null,
    @SerializedName("width") var width: Int? = null,
    @SerializedName("height") var height: Int? = null

)
