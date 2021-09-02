package top.lixiang007;

import org.junit.Test;
import org.junit.jupiter.api.DynamicTest;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

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
    @Test
    public void testJedisCluster115() throws Exception {
        //创建一个JedisCluster对象
        Set<HostAndPort> nodes = new HashSet<>();
        nodes.add(new HostAndPort("10.211.55.12", 7001));
        nodes.add(new HostAndPort("10.211.55.12", 7002));
        nodes.add(new HostAndPort("10.211.55.12", 7003));
        nodes.add(new HostAndPort("10.211.55.12", 7004));
        nodes.add(new HostAndPort("10.211.55.12", 7005));
        nodes.add(new HostAndPort("10.211.55.12", 7006));
        //在nodes中指定每个节点的地址
        //jedisCluster在系统中是单例的。
        JedisCluster jedisCluster = new JedisCluster(nodes);
        jedisCluster.set("name", "zhangsan");
        jedisCluster.set("value", "100");
        String name = jedisCluster.get("name");
        String value = jedisCluster.get("value");
        System.out.println(name);
        System.out.println(value);


        //系统关闭时关闭jedisCluster
        jedisCluster.close();
    }

}
