package com.list.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ListTest {
			
	//comments:Map çš„keyå�ªèƒ½æ˜¯ å¼•ç”¨æ•°æ�®ç±»åž‹ ï¼Œ
	//Mapæ˜¯é€šè¿‡æ¯”è¾ƒ keyçš„hashcodeå€¼putå€¼ çš„ ï¼Œæ‰€ä»¥ä¸�èƒ½ä¸ºåŸºæœ¬æ•°æ�®ç±»åž‹
	private String teString;
	public String getTeString() {
		return teString;
	}

	public void setTeString(String teString) {
		this.teString = teString;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer, List<String>> nameMap = new HashMap<>();
		getValue(nameMap);
		for (Entry<Integer, List<String>> entry : nameMap.entrySet()) {
			System.out.println("Key=" + entry.getKey() + ",Value=" + entry.getValue());
		}
	}

	static void getValue(Map<Integer, List<String>> nameMap) {
		nameMap.put(1, new ArrayList<String>());
		nameMap.put(2, new ArrayList<String>());
		setKeyValue(nameMap);
	}

	static void setKeyValue(Map<Integer, List<String>> nameMap) {
		List<String> arrayList = nameMap.get(1);
		arrayList.add("first");
		List<String> arrayList2 = nameMap.get(2);
		arrayList2.add("two");
	}
}
