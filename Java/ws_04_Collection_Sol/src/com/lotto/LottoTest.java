package com.lotto;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class LottoTest {
	Set<Integer> set = new TreeSet<Integer>();
	Random r = new Random();
    public LottoTest() {
    	while(set.size() < 6) {
    	 set.add(r.nextInt(45)+1);
    	}
    	
    	System.out.println(set);
    }
    
	public static void main(String[] args) {
		System.out.println("***로또 생성하기 ******");
        new LottoTest();
	}

}
