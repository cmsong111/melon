package com.gulio.screen;

import com.gulio.model.Song;
import com.gulio.model.YoutubeVideo;
import com.gulio.resitory.YoutubeRepository;
import com.gulio.resitory.YoutubeRepositoryImpl;
import me.friwi.jcefmaven.CefInitializationException;
import me.friwi.jcefmaven.UnsupportedPlatformException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class SongChartScreen extends JFrame {
    YoutubeRepository youtubeRepository = new YoutubeRepositoryImpl();
    private JTable table;
    private DefaultTableModel tableModel;

    public SongChartScreen(ArrayList<Song> songs) throws MalformedURLException {
        super("Song Table");

        ArrayList<Song> songList = songs;

        tableModel = new DefaultTableModel(new String[]{"rank", "Album", "Name", "Artist", "Album", "Likes"}, 0);
        table = new JTable(tableModel) {
            // 2열에 이미지가 들어갈 것이기 때문에 컬럼의 클래스를 ImageIcon으로 지정
            @Override
            public Class<?> getColumnClass(int column) {
                if (column == 1) {
                    return ImageIcon.class;
                }
                return Object.class;
            }

            // 테이블 내의 셀을 수정하지 못하도록 설정
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table.setRowHeight(120);

        int rank = 1;

        for (Song song : songList) {
            ImageIcon imageIcon = new ImageIcon(new URL(song.getAlbumArt()));
            tableModel.addRow(new Object[]{rank++, imageIcon, song.getName(), song.getArtist(), song.getAlbum(), String.valueOf(song.getLikes())});
        }

        JScrollPane scrollPane = new JScrollPane(table);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0 && selectedRow < songList.size()) {
                    Song selectedSong = songList.get(selectedRow);
                    System.out.println("Selected Song: " + selectedSong.getName());
                    try {
                        ArrayList<YoutubeVideo> search = youtubeRepository.search(selectedSong.getName() + " " + selectedSong.getArtist());
                        new YoutubeScreen(search.get(0).getUrl());
                    } catch (IOException | UnsupportedPlatformException | CefInitializationException | InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });

        getContentPane().add(scrollPane);

        setSize(800, 1000);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
