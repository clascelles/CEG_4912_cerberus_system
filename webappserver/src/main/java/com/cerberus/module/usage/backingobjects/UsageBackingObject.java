package com.cerberus.module.usage.backingobjects;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class UsageBackingObject {

	private Integer timeSpan;
	private Date selectedDate;
	private String chartTitle;
	private String xaxisLabel;
	private String yaxisLabel;
	
	private Integer numberOfDataPoints;
	
	private Integer maximumXAxisValue;
	private Integer minimumXAxisValue;
	private Integer maximumYAxisValue;
	private Integer minimumYAxisValue;
	
	
	//Initialized for Day
	public UsageBackingObject() {
		timeSpan = 1;
		selectedDate = new Date();
		chartTitle = "Daily	Consumption Profile (" + getDateFormated() + ")";
		xaxisLabel = "Hours (h)";
		yaxisLabel = "Consumption (kW/h)";
		numberOfDataPoints = 24;
		maximumXAxisValue = 23;
		minimumXAxisValue = 0;
		minimumYAxisValue = 0;
	}
	public UsageBackingObject(Integer timeSpan, Date selectedDate) {
		this.timeSpan = timeSpan;
		this.selectedDate = selectedDate;
	}
	public Integer getTimeSpan() {
		return timeSpan;
	}
	public void setTimeSpan(Integer timeSpan) {
		this.timeSpan = timeSpan;
	}
	public Date getSelectedDate() {
		return selectedDate;
	}
	public void setSelectedDate(Date selectedDate) {
		this.selectedDate = selectedDate;
	}
	
	public String getDateFormated(){
		DateFormat df2 = new SimpleDateFormat("MM/dd/yyyy");
		return df2.format(selectedDate);
	}
	
	public String getChartTitle() {
		return chartTitle;
	}
	public void setChartTitle(String chartTitle) {
		this.chartTitle = chartTitle;
	}
	
	public String getXaxisLabel() {
		return xaxisLabel;
	}
	public void setXaxisLabel(String xaxisLabel) {
		this.xaxisLabel = xaxisLabel;
	}
	
	public String getYaxisLabel() {
		return yaxisLabel;
	}
	public void setYaxisLabel(String yaxisLabel) {
		this.yaxisLabel = yaxisLabel;
	}
	
	public Integer getNumberOfDataPoints() {
		return numberOfDataPoints;
	}
	public void setNumberOfDataPoints(Integer numberOfDataPoints) {
		this.numberOfDataPoints = numberOfDataPoints;
	}
	
	public Integer getMaximumXAxisValue() {
		return maximumXAxisValue;
	}
	public void setMaximumXAxisValue(Integer maximumXAxisValue) {
		this.maximumXAxisValue = maximumXAxisValue;
	}
	
	public Integer getMinimumXAxisValue() {
		return minimumXAxisValue;
	}
	public void setMinimumXAxisValue(Integer minimumXAxisValue) {
		this.minimumXAxisValue = minimumXAxisValue;
	}
	
	public Integer getMaximumYAxisValue() {
		return maximumYAxisValue;
	}
	public void setMaximumYAxisValue(Integer maximumYAxisValue) {
		this.maximumYAxisValue = maximumYAxisValue;
	}
	
	public Integer getMinimumYAxisValue() {
		return minimumYAxisValue;
	}
	public void setMinimumYAxisValue(Integer minimumYAxisValue) {
		this.minimumYAxisValue = minimumYAxisValue;
	}
	
	public void setGraphForDay(){
		chartTitle = "Daily	Consumption Profile (" + getDateFormated() + ")";
		xaxisLabel = "Hours (h)";
		numberOfDataPoints = 24;
		maximumXAxisValue = 23;
		minimumXAxisValue = 0;
		minimumYAxisValue = 0;
	}
	
	public void setGraphForMonth(){
		chartTitle = "Monthly	Consumption Profile (" + getDateFormated() + ")";
		xaxisLabel = "Days";
		maximumXAxisValue = numberOfDataPoints;
		minimumXAxisValue = 1;
		minimumYAxisValue = 0;
	}
	
	
	
	
	
	
}
