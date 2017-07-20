package cn.itcast.bigdata.redis;

import redis.clients.jedis.Jedis;

public class RedisDao {

	
	public static void main(String[] args) {
		
		Jedis jedis = new Jedis("itcast1110-01");
		
		jedis.lpush("duanyu", "yuyan","wanqing","zhongling","ake","shuanger","jianning");
		
		jedis.close();
		
		
	}
	
	
}
