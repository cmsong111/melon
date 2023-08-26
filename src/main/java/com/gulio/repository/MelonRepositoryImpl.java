package com.gulio.repository;

import com.gulio.model.Song;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class MelonRepositoryImpl implements MelonRepository {

    String URL = "https://www.melon.com/chart/index.htm";

    @Override
    public ArrayList<Song> getMelonChart() throws IOException {
        ArrayList<Song> songList = new ArrayList<>();

        // Jsoup 라이브러리를 사용하여 URL에 접속
        Connection conn = Jsoup.connect(URL);
        Document document = conn.get();

        // HTML에서 table 태그를 찾아서 가져오기
        Element table = document.select("table").get(0);
        Element tbody = table.select("tbody").get(0);
        Elements rows = tbody.select("tr");

        // table 태그 내의 tr 태그들을 순차적으로 가져오기
        for (Element songElement : rows) {
            int id = Integer.parseInt(songElement.attr("data-song-no"));
            String title = songElement.select("div.ellipsis.rank01 a").text();
            String artist = songElement.select("div.ellipsis.rank02 span a").text();
            String album = songElement.select("div.ellipsis.rank03 a").text();
            String albumArt = songElement.select("img[src]").attr("src"); // 앨범 이미지 URL

            // TODO: 좋아요 수 가져오기

            Song song = new Song(id, title, artist, album, albumArt, 0);
            songList.add(song);
        }

        return songList;
    }
}
