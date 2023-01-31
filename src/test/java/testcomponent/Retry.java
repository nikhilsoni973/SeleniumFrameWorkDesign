package testcomponent;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

	
	//Whenever Test fails it comes here
	int count=0;
	int maxTry=1;
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(count<maxTry) {
			count++;
			//When we return true-> It will retry
			return true;
		}
		//When we return false-> It will retry
		return false;
	}

}
