package com.cerberus.server.persistence.DAO;

import java.util.List;

import com.cerberus.server.persistence.beans.Socket;

public class SocketDAO extends GenericDAO<Socket, Integer> {

	public Socket getById(Integer socketId){
		return getById(Socket.class, socketId);
	}
	
	/***/
	public List<Socket> getAll(){
		return getAll(Socket.class);
	}
	
}
