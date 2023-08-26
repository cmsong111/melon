package com.gulio.model.youtubeapi

import com.google.gson.annotations.SerializedName


data class Result(

    @SerializedName("kind") var kind: String? = null,
    @SerializedName("etag") var etag: String? = null,
    @SerializedName("nextPageToken") var nextPageToken: String? = null,
    @SerializedName("regionCode") var regionCode: String? = null,
    @SerializedName("pageInfo") var pageInfo: PageInfo? = PageInfo(),
    @SerializedName("items") var items: ArrayList<Items> = arrayListOf()

)
