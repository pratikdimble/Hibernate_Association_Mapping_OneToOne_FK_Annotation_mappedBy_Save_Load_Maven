package com.pratik.dao;

public class OTO_DAOFactory {
	
	public static OTO_DAO getInstance(){
		return new OTO_DAOImpl();
	}

}
