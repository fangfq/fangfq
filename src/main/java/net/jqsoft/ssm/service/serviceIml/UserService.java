package net.jqsoft.ssm.service.serviceIml;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.jqsoft.ssm.dao.UserMapper;
import net.jqsoft.ssm.domain.User;
import net.jqsoft.ssm.service.IUserService;

@Service
public class UserService implements IUserService{

	@Autowired
	private UserMapper userMapper;
	
	public List<User> findLike(String host) throws SQLException {
		
		return userMapper.findLike(host);
	}

}
