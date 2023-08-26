package com.gulio.resitory;

import com.gulio.model.YoutubeVideo;

import java.io.IOException;
import java.util.ArrayList;

public interface YoutubeRepository {
    /**
     * 유튜브에서 키워드로 검색한 결과를 가져온다.
     *
     * @param keyword 검색할 키워드
     * @return YoutubeVideo List (ArrayList)
     * @throws IOException Jsoup Connection Error
     */
    ArrayList<YoutubeVideo> search(String keyword) throws IOException;
}
