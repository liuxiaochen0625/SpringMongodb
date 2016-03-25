package com.ebaolife;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.runner.RunWith;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-config-mongodb.xml")
public class AppTest  extends AbstractJUnit4SpringContextTests
{
	@Resource
	private MongoTemplate mongoTemplate;
	
	@org.junit.Test
	public void testAddDoc() {
		Person p = new Person("Joe", 34);
		Person p2 = new Person("1001", "Joe", 34);
		Person p11 = new Person("1011", "zhangsan", 20);
		Person p12 = new Person("1012", "zhangsan2", 21);
		Person p13 = new Person("1013", "zhangsan3", 23);
		List<Person> list = new ArrayList<Person>();
		list.add(p11);
		list.add(p12);
		list.add(p13);
		this.mongoTemplate.insert(p);// 默认保存在person集合中(与类名称一致)
		this.mongoTemplate.insert(p2, "person2");// 指定保存在person2集合中
		this.mongoTemplate.insertAll(list);// 默认保存在person集合中(与类名称一致)
	}
}
