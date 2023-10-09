package testng;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;

//import dev.failsafe.internal.util.Assert;


public class firstTestng {
	@BeforeTest
	public void beforetest() {
		System.out.println("this is before first test");
	}
	@AfterTest
	public void Aftertest() {
		System.out.println("this is After last test");
	}
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("this is before every test");
	}
	@AfterMethod
	public void afterMethod() {
		System.out.println("this is after every test");
	}
	
  @Test(priority=18, enabled=true)
  public void f_in_firstTestng_class() {
	  Assert.assertEquals(true, true);
	  System.out.println("In class firstTestng This is my first testng test");
  }

  @Test(priority=1)
  public void d_test_in_firstTestng_class() {
	  System.out.println("In class firstTestng In Test D");
  }

  @Test(priority=8)
  public void a_test_in_firstTestng_class() {
	  System.out.println("In class firstTestng Demo In Test A");
  }

  @Test(priority=-1, dependsOnMethods="f_in_firstTestng_class")
  public void b_test_in_firstTestng_class() {
	  System.out.println("In class firstTestng Demo In Test B");
  }

  @Test(priority=10)
  public void c_test_in_firstTestng_class() {
	  System.out.println("In class firstTestng Demo In Test C");
  }

}
