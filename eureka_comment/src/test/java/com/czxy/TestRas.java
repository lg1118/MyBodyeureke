package com.czxy;

import com.czxy.utils.RasUtils;
import org.junit.Test;

/**
 * Created by Administrator on 2020/8/13.
 */
public class TestRas {
    private static final String pubKeyPath = "D:\\ras\\ras.pub";

    private static final String priKeyPath = "D:\\ras\\ras.pri";

    @Test
    public void testGen() throws Exception {
        //生产公钥和私钥
        RasUtils.generateKey(pubKeyPath,priKeyPath,"234");
    }
}
