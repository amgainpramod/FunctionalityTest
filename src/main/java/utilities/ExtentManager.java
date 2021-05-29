package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class ExtentManager {
    private static final Logger log = LogManager.getLogger(ExtentManager.class.getName());
    private static ExtentReports extentReports;

    public static ExtentReports getInstance(){
        if(extentReports == null){
            createInstance();
        }
        return extentReports;
    }

    public static synchronized ExtentReports createInstance(){
        String fileName = Util.getReportName();
        String reportsDirectory = Constants.REPORTS_DIRECTORY;
        new File(reportsDirectory).mkdirs();
        String path = reportsDirectory + fileName;

        log.info("**************** Report Path *****************");
        log.info(path);
        log.info("**************** Report Path *****************");

        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(path);
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setDocumentTitle("Automation Run");
        sparkReporter.config().setEncoding("utf-8");
        sparkReporter.config().setReportName(fileName);

        extentReports = new ExtentReports();
        extentReports.setSystemInfo("Organization", "Let's Kode It");
        extentReports.setSystemInfo("Automation Framework", "Selenium WebDriver");
        extentReports.attachReporter(sparkReporter);

        return extentReports;
    }
}
