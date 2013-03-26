package com.cerberus.server.persistence.DAO;

import java.util.List;

import com.cerberus.server.persistence.beans.Tip;

public class TipDAO extends GenericDAO<Tip, Integer> {

	/***/
	public Tip getById(Integer id){
		return getById(Tip.class, id);
	}
	
	/***/
	public List<Tip> getAll(){
		return getAll(Tip.class);
	}
}
