package com.learning.mysql;

import java.sql.SQLException;

public class App {
	public static void main(String[] args) {

		var props = Profile.getProperties("db");
		var db = Database.instance();
		try {
			db.connect(props);
		} catch (SQLException e) {
			System.out.println("Cannot connect to the db");
			return;
		}
		
		System.out.println("connected");

		UserDao userDao = new UserDaoImpl();

		// userDao.save(new User("Mark"));
		// userDao.save(new User("Ranjan"));
		// userDao.save(new User("Patel"));

		var list = userDao.getAll();
		list.forEach(e -> System.out.println(e));

		var user = userDao.findById(12);

		if (user.isPresent()) {

			User users = user.get();
			System.out.println("Retrieved " + users);
			users.setName("snoopy");

			userDao.update(users);

		} else {
			System.out.println("User Not present");
		}

		userDao.delete(new User(5, null));

		try {
			db.close();
		} catch (SQLException e) {
			System.out.println("cannot close the db");
			e.printStackTrace();
		}

	}
}
