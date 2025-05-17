package com.capgemini.voting_project.service;


import java.util.List;

import com.capgemini.voting_project.model.Users;

public interface UserService {
	List<Users> getAllUsers();

	Users getUsersById(Long id);

	Users createUsers(Users users);

	Users updateUsers(Long id, Users users);

	Users patchUsers(Long id, Users users);

	void deleteUsers(Long id);
}
