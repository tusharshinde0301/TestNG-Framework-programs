package testng;
//package demoCode;


import org.testng.annotations.Test;
public class GroupsDemo {
  @Test
  public void a() {
	  System.out.println("This is test A");
  }
  @Test(enabled = true, groups = {"One"})
  public void b() {
	  System.out.println("This is test B");
  }
  @Test(groups = {"Two"})
  public void c() {
	  System.out.println("This is test C");
  }
  @Test(groups = {"One", "Two"})
  public void d() {
	  System.out.println("This is test D");
  }
  @Test(groups = {"Three"})
  public void e() {
	  System.out.println("This is test E");
  }
  @Test(groups = {"One", "Three"})
  public void f() {
	  System.out.println("This is test F");
  }
  @Test(groups = {"Two", "Three"})
  public void g() {
	  System.out.println("This is test G");
  }
  @Test(groups = {"One", "Two", "Three"})
  public void h() {
	  System.out.println("This is test H");
  }
}
