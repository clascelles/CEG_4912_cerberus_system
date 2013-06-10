package com.cerberus.persistence.DAO;

import java.util.List;

import com.cerberus.persistence.beans.Socket;

public class SocketDAO extends GenericDAO<Socket, Integer> {

	public Socket getById(Integer socketId){
		return getById(Socket.class, socketId);
	}
	
	/***/
	public List<Socket> getAll(){
		return getAll(Socket.class);
	}
	
}
