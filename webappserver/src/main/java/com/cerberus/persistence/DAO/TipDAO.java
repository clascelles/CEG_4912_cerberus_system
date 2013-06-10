package com.cerberus.persistence.DAO;

import java.util.List;

import com.cerberus.persistence.beans.Tip;

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
