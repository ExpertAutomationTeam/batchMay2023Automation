package util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.may23.BaseTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Reporting extends BaseTest implements ITestListener {

    public ExtentSparkReporter htmlReporter;//create html file & add configuration
    public ExtentReports extent;//attaching report
    public ExtentTest test;//maintain test cases, add log status

    public void onStart(ITestContext testCnt)
    {
        htmlReporter=new ExtentSparkReporter("ExtentReport.html");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setDocumentTitle("Test Report"); // Title of report
        htmlReporter.config().setReportName("Test Automation Report"); // name of the report
        htmlReporter.config().setTheme(Theme.STANDARD);
        extent=new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    public void onTestSuccess(ITestResult tr)
    {
        test=extent.createTest(tr.getName());
        test.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
        Log.info("on Test success");
    }

    public void onTestFailure(ITestResult tr)
    {
        test=extent.createTest(tr.getName());
        test.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));
    }

    public void onTestSkipped(ITestResult tr)
    {
        test=extent.createTest(tr.getName());
        test.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
    }

    public void onFinish(ITestContext testContext)
    {
        extent.flush();
    }


}
