package testel;

import java.io.Serializable;

public class TestBean implements Serializable {
	private String testData;
	
	public String getTestData() {
		return testData;
	}

	public void setTestData(String testData) {
		this.testData = testData;
	}
}
