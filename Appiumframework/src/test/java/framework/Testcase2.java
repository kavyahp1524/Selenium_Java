package framework;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import Framework.Capability3;

public class Testcase2 extends Capability3 {
@Test
public void tc4() {
	System.out.println("hai");
}
@AfterTest
public void tc() {
	service.stop();
}
}
