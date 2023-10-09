package testng;


import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;



public class Timeout {
	// Expected exception allows your test method to handle that exception
  @Test(timeOut = 10000, expectedExceptions = IndexOutOfBoundsException.class)
  public void f() {
	  while (true) {
		System.out.println("This is an infinite loop");
		List<Integer> myIntegers = new ArrayList<Integer>();
		myIntegers.add(1);
		myIntegers.add(2);
		myIntegers.add(3);
		myIntegers.add(4);
		
		System.out.println(myIntegers.get(4));
	}
  }
}