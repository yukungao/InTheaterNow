package com.yukun.boxbuster1.entity;

import com.yukun.boxbuster1.entity.User;

public interface Address {
	String getStreet1();
	String getStreet2();
	String getCity();
	String getState();
	String getZip();
	User getUser();
}

