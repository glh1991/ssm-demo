package me.allensea.redis;

import redis.clients.jedis.ShardedJedis;

/**
 * Created by allen on 17/7/1.
 */
public interface RedisDataSource {

    ShardedJedis getRedisClient();

    void returnResource(ShardedJedis shardedJedis);

    void returnResource(ShardedJedis shardedJedis, boolean broken);
}
