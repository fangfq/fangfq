package net.jqsoft.ssm.service;

import java.sql.SQLException;
import java.util.List;

import net.jqsoft.ssm.domain.User;

import org.springframework.stereotype.Service;

@Service
public interface IUserService {
	
	public List<User> findLike(String host) throws SQLException;
	
}
