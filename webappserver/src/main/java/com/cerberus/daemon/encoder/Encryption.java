package com.cerberus.daemon.encoder;

public class Encryption {
	
	public static byte[] encrypt(byte[] key, byte[] msg){
		byte[] encryptedMsg = new byte[msg.length];
		
		for(int i=0; i<msg.length; i++){
			encryptedMsg[i] = (byte) (msg[i] ^ key[i%16]);
		}
		
		return encryptedMsg;
	}
	
	public static byte[] decrypt(byte[] key, byte[] msg){
		return encrypt(key, msg);
	}

}
