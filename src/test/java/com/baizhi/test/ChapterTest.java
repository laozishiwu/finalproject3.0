package com.baizhi.test;


import com.baizhi.entity.Chapter;
import com.baizhi.entity.Special;
import com.baizhi.service.ChapterService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ChapterTest extends BaseTest {
    @Autowired
    private ChapterService chapterService;

    @Test
    public void testAdd() {
        Special special = new Special();
        special.setId(2);
        Chapter chapter = new Chapter();
        chapter.setId(102);
        chapter.setTitle("234");
        chapter.setDuration(12.3);
        chapter.setAudioPath("/upload/d1.mp3");
        chapter.setSize(122.2);
        chapter.setSpecial(special);
        chapterService.insert(chapter);

    }

    @Test
    public void TestSelect() {
        chapterService.queryAll();
    }

    @Test
    public void TestSelectBypage() {
        chapterService.queryBypage(2, 6);
    }


}

