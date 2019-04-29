package com.nf147.ssm_pet_spring.RedisConfig;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class test {

    public static void main(String[] args) {

        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(50);
        poolConfig.setMaxTotal(100);
        poolConfig.setMaxWaitMillis(20000);

        JedisPool pool = new JedisPool(poolConfig, "localhost");

        Jedis jedis = pool.getResource();

        int i = 0;  //记录操作的次数

        long start = System.currentTimeMillis(); // 开始毫秒数

        while (true) {
            long end = System.currentTimeMillis();
            if (end - start >= 1000) {
//                当大于1000毫秒（相当于1秒时），结果操作
                break;
            }
            i++;
            jedis.set("test" + i, i + "");
        }

        System.out.println("redis 每秒操作:" + i + "次");

        System.out.println("---------------------");

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContenxt.xml");
        RedisTemplate redisTemplate = context.getBean(RedisTemplate.class);
        Role role = new Role();
        role.setId(1);
        role.setRoleName("role_name_1");
        role.setNote("role_note_1");
    }

}
