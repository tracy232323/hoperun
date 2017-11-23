package com.hoperun.service.imp;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hoperun.mapper.UserMapper;
import com.hoperun.pojo.User;
import com.hoperun.service.UserService;
import com.hoperun.utils.JedisClient;
import com.hoperun.utils.JsonUtils;

@Service
public class UserServiceImp implements UserService{
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private JedisClient jedisClient; 
	
	//过期时间
	private Integer expireTime=86400;
	
	@Override
	public void save(User user) {
		userMapper.save(user);
	}

	@Override
	public List<User> getUserList() {
		//先从缓存中获取
		String jsonData = jedisClient.get("userList");
		
		//缓存中没有数据
		if (jsonData == null) {
			List<User> list = userMapper.getUserList();
			//从数据库查询数据，存入缓存设置过期时间
			jedisClient.set("userList", JsonUtils.objectToJson(list));
			jedisClient.expire("userList", expireTime);
			
			return list;
		}
		
		return JsonUtils.jsonToList(jsonData, User.class);
	}

	@Override
	public User getUserById(String uid) {
		return userMapper.getUserById(uid);
	}

	@Override
	public void deleteById(String uid) {
		userMapper.deleteById(uid);
		
		//新增或删除时清除缓存
		jedisClient.del("userList");
	}

}
