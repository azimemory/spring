package com.kh.toy.common.util.encoding;

import java.io.UnsupportedEncodingException;

public class EncodingUtil {
	
	public void checkEncoding(String encode) {
	      String [] charSet = {"utf-8","euc-kr","ksc5601","iso-8859-1","x-windows-949"};
	      for (int i=0; i<charSet.length; i++) {
	         for (int j=0; j<charSet.length; j++) {
	            try {
	               System.out.println("[" + charSet[i] +"," + charSet[j] +"] = " 
	               + new String(encode.getBytes(charSet[i]), charSet[j]));

	            } catch (UnsupportedEncodingException e) {
	               e.printStackTrace();
	            }
	         }
	      }
	   }
}
