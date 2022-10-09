package TestGoogle;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Core.BaseTest;

public class TestSearchWithGoogle extends BaseTest {
	@Test
	public void testAssert() {
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(false, true);
		sa.assertEquals(1, 0);
		sa.assertTrue(true);
		sa.assertAll();
	}
}
