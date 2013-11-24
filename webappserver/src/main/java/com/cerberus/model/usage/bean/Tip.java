package com.cerberus.model.usage.bean;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TIP")
public class Tip implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	Integer id;
	String tipName;
	Set<Rule> rules;
	
	public Tip(){
		super();
	}
	
	
	public Tip(Integer id, String tipName, Set<Rule> rules) {
		super();
		this.id = id;
		this.tipName = tipName;
		this.rules = rules;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID", nullable=false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="NAME", nullable=false)
	public String getTipName() {
		return tipName;
	}

	public void setTipName(String tipName) {
		this.tipName = tipName;
	}

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "RULE_TIP_XREF", joinColumns = { 
			@JoinColumn(name = "TIP_ID",  nullable = false, updatable = false) },
			inverseJoinColumns = { @JoinColumn(name = "RULE_ID", 
				nullable = false, updatable = false) })
	
	public Set<Rule> getRules() {
		return rules;
	}


	public void setRules(Set<Rule> rules) {
		this.rules = rules;
	}


	@Override
	public String toString() {
		return "Tip [id=" + id + ", tipName=" + tipName + ", rules=" + rules
				+ "]";
	}


}
