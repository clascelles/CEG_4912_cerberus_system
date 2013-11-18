package com.cerberus.service.usage;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.joda.time.DateTime;

import com.cerberus.model.outlets.bean.Current;
import com.cerberus.model.outlets.dao.CurrentDAO;
import com.cerberus.model.outlets.filter.CurrentFilter;
import com.cerberus.model.usage.bean.CurrentDayView;
import com.cerberus.model.usage.bean.CurrentHourView;
import com.cerberus.model.usage.bean.SystemTip;
import com.cerberus.model.usage.bean.Tip;
import com.cerberus.model.usage.dao.CurrentDayViewDAO;
import com.cerberus.model.usage.dao.CurrentHourDAO;
import com.cerberus.model.usage.dao.CurrentHourViewDAO;
import com.cerberus.model.usage.dao.SystemTipDAO;
import com.cerberus.model.usage.dao.TipDAO;
import com.cerberus.model.usage.filter.CurrentDayViewFilter;
import com.cerberus.model.usage.filter.CurrentHourViewFilter;

public class ConsumptionService {

	private final CurrentDAO currentDAO;
	private final CurrentHourViewDAO currentHourViewDAO;
	private final CurrentDayViewDAO currentDayViewDAO;
	private final CurrentHourDAO currentHourDAO;
	private final TipDAO tipDAO;
	private final SystemTipDAO systemTipDAO;

	public ConsumptionService (){
		currentDAO = new CurrentDAO();
		currentHourViewDAO = new CurrentHourViewDAO();
		currentDayViewDAO = new CurrentDayViewDAO();
		currentHourDAO = new CurrentHourDAO();
		tipDAO = new TipDAO();
		systemTipDAO = new SystemTipDAO();
		//Add all the necessary DAOs here
	}

	//*************************************************
	//CURRENT
	//*************************************************

	public Integer insertCurrent(Current current){
		return currentDAO.save(current);
	}

	public Current updateCurrent(Current current){
		return currentDAO.merge(current);
	}

	public void deleteCurrent(Current current){
		currentDAO.delete(current);
	}

	public Current getCurrentById(Integer id){
		return currentDAO.getById(id);
	}
	
	public List<Current> getCurrentBySocketId(Integer socketId) {
		return currentDAO.getAllByFilter(CurrentFilter.getBySocketId(socketId));
	}
	
	public boolean deleteCurrentByThreshold(DateTime threshold){
		return currentDAO.deleteCurrent(new Timestamp(threshold.getMillis()));
	}
	
	public Long countCurrent(DetachedCriteria criteria){
		return currentDAO.count(criteria);
	}
	
	public List<Integer> listCurrent(DetachedCriteria criteria){
		return currentDAO.getAllIdsByFilter(criteria);
	}
	

	//*************************************************
	//CURRENT HOUR
	//*************************************************

	public List<CurrentHourView> getCurrentHourForDay(Integer systemId, Date selectedDate){

		//Should never be more then 24 item in this list.
		return currentHourViewDAO.getAllByFilter(CurrentHourViewFilter.getByThisDay(systemId, selectedDate));

	}

	//*************************************************
	//CURRENT DAY
	//*************************************************

	public List<CurrentDayView> getCurrentDayForMonth(Integer systemId, Date selectedDate){

		return currentDayViewDAO.getAllByFilter(CurrentDayViewFilter.getByThisMonth(systemId, selectedDate));

	}
	
	//*************************************************
	//AGGREGATION OF CURRENT
	//*************************************************

	public void updateCurrentHour(DateTime threshold){
		currentHourDAO.updateCurrentHour(new Timestamp(threshold.getMillis()));
	}
	
	//*************************************************
	//TIP
	//*************************************************
	
	public List<Tip> getTips(){
		return tipDAO.getAll();
	}
	
	//*************************************************
	//SYSTEM_TIP
	//*************************************************

	public Integer insertSystemTip(SystemTip systemTip){
		return systemTipDAO.save(systemTip);
	}
	
}
