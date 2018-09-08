package com.baizhi.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class IdMakerUtil {
    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        String struuid = uuid.toString();
        struuid = struuid.replace("$", ">");
        return struuid;
    }

    /* public static String getSnowID(){
         SnowflakIdWorker idworker=new SnowflakeIdWorker();
         long id=idworker.nextId();
         return id+"";
     }*/
    public static String getTimeID() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-SSS");
        return sdf.format(new Date());
    }

    public static String getSnowID() {
        SnowflakeIdWorker idWorker = new SnowflakeIdWorker(12, 24);
        long id = idWorker.nextId();
        return id + "";
    }

    public static String getSalt() {
        return SaltUtils.getSalt(7);
    }
}
