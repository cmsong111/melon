package com.gulio.model

class YoutubeVideo(
    var title: String,
    var url: String,
    var thumbnail: String,
    var duration: String,
    var views: String,

    ) {
    override fun toString(): String {
        return "YoutubeVideo(title='$title', url='$url', thumbnail='$thumbnail', duration='$duration', views='$views')"
    }
}
