package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
	
	public static ExtentReports getReport() {
		
        String path=System.getProperty("user.dir")+"\\reporting\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Nikhil Automation Report");
		reporter.config().setDocumentTitle("Nikhil Test Result");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Nikhil Soni");
		return extent;
	}

}
