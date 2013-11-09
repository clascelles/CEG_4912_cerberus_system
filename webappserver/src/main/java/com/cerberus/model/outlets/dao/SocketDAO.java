package com.cerberus.model.outlets.dao;

import java.util.List;

import com.cerberus.model.generic.dao.GenericDAO;
import com.cerberus.model.outlets.bean.Socket;

public class SocketDAO extends GenericDAO<Socket, Integer> {

	public Socket getById(Integer socketId){
		return getById(Socket.class, socketId);
	}

	/***/
	public List<Socket> getAll(){
		return getAll(Socket.class);
	}

}
