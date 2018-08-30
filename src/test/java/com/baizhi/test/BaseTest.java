package com.baizhi.test;

import com.baizhi.cmfzMain;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//指出是pringboot环境
@RunWith(SpringRunner.class)
//指出类，包
@SpringBootTest(classes=cmfzMain.class)
public class BaseTest {

}
