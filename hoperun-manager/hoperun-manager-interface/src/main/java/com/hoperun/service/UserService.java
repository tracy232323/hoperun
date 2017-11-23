package com.hoperun.service;

import java.util.List;
import com.hoperun.pojo.User;

public interface UserService {
	public void save(User user);

	public List<User> getUserList();

	public User getUserById(String uid);

	public void deleteById(String uid);
}
