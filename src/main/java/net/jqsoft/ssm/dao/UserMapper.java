package net.jqsoft.ssm.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import net.jqsoft.ssm.domain.User;

@Repository
public interface UserMapper {
	
	public List<User> findLike(String host) throws SQLException;
	
	public List<User> get(Map map) throws SQLException; 
}
