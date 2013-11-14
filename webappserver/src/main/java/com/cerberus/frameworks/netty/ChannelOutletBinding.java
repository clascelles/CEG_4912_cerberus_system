package com.cerberus.frameworks.netty;

import java.util.HashMap;

import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.group.ChannelGroup;
import org.jboss.netty.channel.group.DefaultChannelGroup;

public class ChannelOutletBinding {

	private static int CHANNEL_ID_MAP_SIZE = 1000;

	//Create a new HashMap with 1000 places
	private static HashMap<String, Integer> map = new HashMap<String, Integer>(CHANNEL_ID_MAP_SIZE);
	private static HashMap<Integer, String> invertMap = new HashMap<Integer, String>(CHANNEL_ID_MAP_SIZE);
	private static ChannelGroup channelGroup = new DefaultChannelGroup();

	public static int getChannelId(String outletSerialNumber){
		return map.get(outletSerialNumber);
	}

	public static String getOutletSerialNumber(Integer channelId) {
		return invertMap.get(channelId);
	}

	public static boolean isChannelBinded(String outletSerialNumber){
		if (map.get(outletSerialNumber) != null){
			return true;
		}else{
			return false;
		}
	}

	public static void bindOutletSerialNumberWithChannelId(String outletSerialNumber, Integer channelId){
		map.put(outletSerialNumber, channelId);
		invertMap.put(channelId, outletSerialNumber);
	}

	public static void addChannelToGroup(Channel channel){
		channelGroup.add(channel);
	}

	public static Channel getChannelFromGroupById(Integer channelId){
		return channelGroup.find(channelId);
	}

	public static Channel getChannelFromGroupByOutlet(String outletSerialNumber){
		return getChannelFromGroupById(getChannelId(outletSerialNumber));
	}

}
