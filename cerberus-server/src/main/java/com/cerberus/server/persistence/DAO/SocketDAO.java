package com.cerberus.server.persistence.DAO;

import com.cerberus.server.persistence.beans.Socket;

public class SocketDAO extends GenericDAO<Socket, Integer> {

	public Socket getById(Integer socketId){
		return getById(Socket.class, socketId);
	}
	
}
