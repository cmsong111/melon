package com.gulio.resitory;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gulio.model.YoutubeVideo;
import com.gulio.model.youtubeapi.Items;
import com.gulio.model.youtubeapi.Result;
import com.gulio.model.youtubeapi.Snippet;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;

public class YoutubeRepositoryImpl implements YoutubeRepository {
    private final OkHttpClient client = new OkHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper().configure(
            DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);


    private final String YOUTUBE_API_URL = "https://www.googleapis.com";
    private final String API_KEY = "insert your api key";

    @Override
    public ArrayList<YoutubeVideo> search(String keyword) throws IOException {
        ArrayList<YoutubeVideo> youtubeVideos = new ArrayList<>();

        HttpUrl httpUrl = HttpUrl.parse(YOUTUBE_API_URL).newBuilder()
                .addPathSegment("youtube")
                .addPathSegment("v3")
                .addPathSegment("search")
                .addQueryParameter("q", keyword)
                .addQueryParameter("key", API_KEY)
                .addQueryParameter("part", "snippet")
                .addQueryParameter("type", "video")
                .build();

        Request request = new Request.Builder()
                .url(httpUrl.url())
                .build();

        Response response = client.newCall(request).execute();

        Result result = objectMapper.readValue(response.body().string(), Result.class);

        for (Items item : result.getItems()) {
            Snippet snippet = item.getSnippet();

            String title = snippet.getTitle();
            String videoId = item.getId().getVideoId();
            String thumbnail = snippet.getThumbnails().getHigh().getUrl();
            String duration = "";
            String viewCount = "";

            YoutubeVideo youtubeVideo = new YoutubeVideo(title, videoId, thumbnail, duration, viewCount);
            youtubeVideos.add(youtubeVideo);
        }

        return youtubeVideos;
    }
}
