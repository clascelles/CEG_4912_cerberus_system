package com.cerberus.server.persistence.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "RULE_TIP_XREF")
public class RuleTipXref implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Integer id;
	Rule rule;
	Tip tip;
	
	public RuleTipXref(){
		super();
	}
	
	public RuleTipXref(Rule rule, Tip tip) {
		super();
		this.rule = rule;
		this.tip = tip;
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
	
	@ManyToOne()
	@JoinColumn(name="RULE_ID", nullable=false)
	public Rule getRule() {
		return rule;
	}
	public void setRule(Rule rule) {
		this.rule = rule;
	}
	
	@ManyToOne()
	@JoinColumn(name="TIP_ID", nullable=false)
	public Tip getTip() {
		return tip;
	}
	public void setTip(Tip tip) {
		this.tip = tip;
	}

	@Override
	public String toString() {
		return "RuleTipXref [id=" + id + ", rule=" + rule + ", tip=" + tip
				+ "]";
	}	
	
	
	
}
