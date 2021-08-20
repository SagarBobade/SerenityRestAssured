package testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Test {

	public static Properties prop;
	public static InputStream input;
	
	
	public static void main(String[] args) throws Exception {

			Test t = new Test();
			t.fun();
	
	}

	public void fun() throws IOException {
		prop = new Properties();
		try {
			input = new FileInputStream(".//myProp.properties");
			prop.load(input);
			
			System.out.println(prop.getProperty("test"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}
}
