package com.cerberus.client;

public class ClientDataGenerator {

	private static final String[] socketIds = new String[] { "4500006701", "4500006702", "4500006703", "4500006704",
			"4500006705", "4500006706", "4500006707", "4500006708", "4500006709", "4500006710", "4500006711",
			"4500006712", "4500006713", "4500006714", "4500006715", "4500006716", "4500006717", };

	private static final String[] rfidNumbers = new String[] { "356AC37692", "6538B2349D", "845A3F5673", "761239DCF1",
			"628D23A853", "3849C32683", "22568A5638", "7538632468", "AA3578B34F", "479A347B31" };

	public String createCurrentConsumptionJsonMessage() {

		StringBuilder sb = new StringBuilder();
		sb.append("{\"type\":").append("\"CURRENT\"");
		sb.append(",\"socketId\":").append(getRandomSocketId());
		sb.append(",\"timestamp\":").append(System.currentTimeMillis() / 1000);
		sb.append(",\"current\":").append(getRandomCurrentValue());

		// RFID number is optional, will be part of the message 50% of the time
		if (Math.random() > 0.5) {
			sb.append(",\"rfidNumber\":").append("\"").append(getRandomRfidNumber()).append("\"");
		}
		sb.append("}").append("\n");

		return sb.toString();
	}

	private String getRandomSocketId() {
		return socketIds[(int) (Math.random() * socketIds.length)];
	}

	private String getRandomRfidNumber() {
		return rfidNumbers[(int) (Math.random() * rfidNumbers.length)];
	}

	private Integer getRandomCurrentValue() {
		return (int) (Math.random() * 6000);
	}

}
