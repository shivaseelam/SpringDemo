package org.demo.web.model;

import java.io.Serializable;

public class UserCO implements Comparable, Serializable {
	
	private int userId;
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String name;

	@Override
	public int compareTo(Object object) {
        UserCO user = (UserCO) object;
        if ((name).compareToIgnoreCase(user.name)==0) {
            return 0;
        } else if (name.compareToIgnoreCase(user.name)>1) {
            return 1;
        } else return -1;
    }

}
