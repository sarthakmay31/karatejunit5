package com.demo.runners;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.apache.commons.io.FileUtils;

public class CucumberReporting {
	

	@Test
	void testParallel() {
		System.getProperty("java.class.path");
			Results results = Runner.path("/Users/sarthak/Re-Be/KarateDemo/src/test/resources/Store.feature")
//					.tags("@first","@second")
					.reportDir("target/myReports")
					.outputCucumberJson(true)
					.parallel(1);
			generateReport(results.getReportDir());
			assertEquals(0, results.getFailCount(), results.getErrorMessages());
	}
	
	public static void generateReport(String karateOutputPath) {        
        Collection<File> jsonFiles = FileUtils.listFiles(new File(karateOutputPath), new String[] {"json"}, true);
        List<String> jsonPaths = new ArrayList(jsonFiles.size());
        jsonFiles.forEach(file -> jsonPaths.add(file.getAbsolutePath()));
        Configuration config = new Configuration(new File("target"), "cucumber-reports");
        ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, config);
        reportBuilder.generateReports();        
    }

}

