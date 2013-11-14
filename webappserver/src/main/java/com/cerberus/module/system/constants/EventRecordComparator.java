package com.cerberus.module.system.constants;

import java.io.Serializable;
import java.util.Comparator;

import com.cerberus.model.system.bean.EventRecord;

public class EventRecordComparator implements Comparator<EventRecord>,
		Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public int compare(EventRecord o1, EventRecord o2) {
		long o1Time = o1.getTimestamp().getTime();
		long o2Time = o2.getTimestamp().getTime();
		// Inversing the comparator to get set in descending order
		return Long.compare(o1Time, o2Time);
	}

}
