package com.gulio.resitory;

import com.gulio.model.Song;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class MelonRepositoryImplTest {

    MelonRepository melonRepository = new MelonRepositoryImpl();

    @Test
    void getMelonChart() throws Exception {
        ArrayList<Song> songList = melonRepository.getMelonChart();

        for (Song song : songList) {
            System.out.println(song);
        }
    }
}
