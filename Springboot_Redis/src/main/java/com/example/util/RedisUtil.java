package com.example.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by jdd on 2019/12/4.
 */
@Component
public class RedisUtil {

//    private static final Logger logger = LoggerFactory.getLogger(RedisUtil.class);
    private static final String USER_CONN_STATUS_KEY = "IM:USER_CONN_STATUS:USERID:";
    private JedisPool jedisPool;

    public RedisUtil()
    {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxWaitMillis(2 * 1000);
//        String password = properties.getProperty("password");
//        String host=properties.getProperty("host");
//        Integer port=(Integer) properties.get("port");
        String password="";
        String host="172.16.247.145";
        Integer port=6379;
        jedisPool = new JedisPool(config, host, port,
                2 * 1000, password != null && !password.isEmpty() ? password : null);
    }


    public String HashSet(String userId, String connectorId)
    {
        try (Jedis jedis = jedisPool.getResource()) {
            String oldConnectorId = jedis.hget(USER_CONN_STATUS_KEY, String.valueOf(userId));
            jedis.hset(USER_CONN_STATUS_KEY, String.valueOf(userId), connectorId);
            return oldConnectorId;
        } catch (Exception e) {
//            logger.error(e.getMessage(), e);
            return null;
        }
    }
}
