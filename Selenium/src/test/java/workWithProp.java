import static org.testng.Assert.assertEquals;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class workWithProp {
	@Test
	public void testProp() throws IOException {
		FileReader readFile=new FileReader("cred.properities");
		Properties prop= new Properties();
		prop.load(readFile);
		String username = prop.getProperty("username");
		prop.getProperty("password");
		assertEquals(username, "rasha");
	}
}
