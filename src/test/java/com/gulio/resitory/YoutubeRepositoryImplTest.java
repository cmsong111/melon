package com.gulio.resitory;

import com.gulio.model.YoutubeVideo;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class YoutubeRepositoryImplTest {

    YoutubeRepository youtubeRepository = new YoutubeRepositoryImpl();
    @Test
    void search() throws IOException {
        ArrayList<YoutubeVideo> youtubeVideos = youtubeRepository.search("아이유");
        for (YoutubeVideo youtubeVideo : youtubeVideos) {
            System.out.println(youtubeVideo);
        }
    }
}
