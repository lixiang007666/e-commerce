package top.lixiang007;

import org.junit.Test;
import org.junit.jupiter.api.DynamicTest;
import redis.clients.jedis.Jedis;

/**
 * @Author Xiang Li
 * @Date 2021/9/1 上午9:47
 * @Since version-1.0
 * @青软实训
 */

public class RedisTest115 {
    /**
     * 单机版测试
     */
    
    @Test
    public void testJedis115() {
        //创建一个Jedis对象
        Jedis jedis = new Jedis("10.211.55.12", 6379);
        jedis.set("test", "hello jedis");
        String string = jedis.get("test");
        System.out.println(string);
        jedis.close();

    }
}
