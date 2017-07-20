package cn.itcast.mongoDb;

import java.net.UnknownHostException;

import org.junit.Test;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;

/**
 * 
 * 使用java 代码来调用mongodb 数据库
 * @author Administrator
 *
 */
public class MongoDbDao {
	/**
	 * 增加
	 * @throws UnknownHostException 
	 */
	@Test
	public void add() throws UnknownHostException{
		//建立起一个连接...
		Mongo mongo=new Mongo("localhost", 3333);
		//获取到指定的数据库...
		DB db=mongo.getDB("test");
		DBCollection collection=db.getCollection("person");
		DBObject dbObject=new BasicDBObject();
		dbObject.put("name", "zhaolianming");
		dbObject.put("date","2015-01-01");
		collection.insert(dbObject);
//		DBCollection dbCollection=db.getCollection("person");
		//{}
//		BasicDBObject dbObject=new BasicDBObject();
//		dbObject.put("name", "yuyunxue");
//		dbObject.put("desc", "11111");
//		//db.collectionName.insert({key:value})
//		dbCollection.insert(dbObject);
//		
		mongo.close();
	}
	
	@Test
	public void testQuery() throws UnknownHostException{
		//建立起一个连接...
		Mongo mongo=new Mongo("localhost", 3333);
		//获取到指定的数据库...
		DB db=mongo.getDB("test");
		DBCollection dbCollection=db.getCollection("person");
		//{}
		//db.collectionName.find({},{age:1})
		DBObject dbObject=new BasicDBObject();
		dbObject.put("name", "zhangsan");
		//dbCursor  结果集(ResultSet)
		DBCursor dbCursor=dbCollection.find(dbObject);
		
		while(dbCursor.hasNext()){
			DBObject dbObject2=dbCursor.next();
			System.out.println(dbObject2.toString());
		}
	}
	
	@Test
	public void testremove() throws UnknownHostException{
		//建立起一个连接...
		Mongo mongo=new Mongo("localhost", 3333);
		//获取到指定的数据库...
		DB db=mongo.getDB("test");
		DBCollection dbCollection=db.getCollection("person1");
		
		DBObject dbObject=new BasicDBObject();
		
		dbCollection.remove(dbObject);
		
		mongo.close();
		
	}
	
	
	@Test
	public void testUpdate() throws UnknownHostException{
		//建立起一个连接...
		Mongo mongo=new Mongo("localhost", 3333);
		//获取到指定的数据库...
		DB db=mongo.getDB("test");
		DBCollection dbCollection=db.getCollection("person1");
		/**
		 * 更新的条件
		 * 
		 * 更新的内容的对象
		 * 
		 * 
		 * 如果没有符合条件的记录，是否新增一条记录
		 * 
		 * 
		 * 如果有条记录符合，是否全部被更新...
		 * 
		 * 
		 */
//		BasicDBObject query = new BasicDBObject("_id",new ObjectId("519e2e393296cf3baccdb10c"));
//		BasicDBObject object = (BasicDBObject) collection.findOne(query);
//		object.put("name", “wangwu");
//		int n = collection.update(query, object).getN();
		
		
//		dbCollection.update(q, o, upsert, multi)
		
		
		
	}
	
	
	
}
