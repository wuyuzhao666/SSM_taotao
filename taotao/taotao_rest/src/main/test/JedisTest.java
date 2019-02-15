/**
 * by wyz on 2019/1/31/031.
 */

import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

import java.io.IOException;
import java.util.HashSet;

/**
 * @program: taotao_parent
 *
 * @description:
 *
 * @author: Mr.Wu
 *
 * @create: 2019-01-31 20:47
 **/

public class JedisTest {

    @Test
   public void testJedisPool(){
       JedisPool pool = new JedisPool("192.168.30.129",6379);
        System.out.println(pool.toString());
       Jedis jedis = pool.getResource();
       String a = jedis.get("a");
       System.out.println(a);
       jedis.close();
       pool.close();
   }

    @Test
    public void testJedisCluster() throws IOException {
        HashSet<HostAndPort> nodes = new HashSet<>();
        nodes.add(new HostAndPort("192.168.30.129", 7001));
        nodes.add(new HostAndPort("192.168.30.129", 7002));
        nodes.add(new HostAndPort("192.168.30.129", 7003));
        nodes.add(new HostAndPort("192.168.30.129", 7004));
        nodes.add(new HostAndPort("192.168.30.129", 7005));
        nodes.add(new HostAndPort("192.168.30.129", 7006));

        JedisCluster cluster = new JedisCluster(nodes);

        cluster.set("key1", "1000");
        String string = cluster.get("key1");
        System.out.println(string);

        cluster.close();

    }
}
