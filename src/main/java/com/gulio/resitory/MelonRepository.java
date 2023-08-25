package com.gulio.resitory;

import com.gulio.model.Song;

import java.io.IOException;
import java.util.ArrayList;

public interface MelonRepository {

    /**
     * 멜론 Top100 차트를 가져온다.
     *
     * @return Melon Chart List (ArrayList)
     * @throws IOException Jsoup Connection Error
     * @author cmsong111
     */
    ArrayList<Song> getMelonChart() throws IOException;
}
