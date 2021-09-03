package top.lixiang007.taotao.sso.component;
/**
 * @Author Xiang Li
 * @Date 2021/9/3 上午9:33
 * @Since version-1.0
 * @青软实训 SSO做一个redis查询 也不用查询Mysql数据库了 更快哦 那token？？？？？？？？
 */

public interface JedisClient {

    String set(String key, String value);
    String get(String key);
    Long del(String key);
    Long hset(String key, String item, String value);
    String hget(String key, String item);
    Long incr(String key);
    Long decr(String key);
    Long expire(String key, int second);
    Long ttl(String key);
    Long hdel(String redis_content_key, String s);
}
