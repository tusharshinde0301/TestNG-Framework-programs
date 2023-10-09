package testng;


import org.testng.annotations.Test;


public class InvocationCount {
  @Test(invocationCount = 5)
  public void f() {
	  System.out.println("Hello world");
  }
}
