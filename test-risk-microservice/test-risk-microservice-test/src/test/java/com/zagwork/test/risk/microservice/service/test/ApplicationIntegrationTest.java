package com.zagwork.test.risk.microservice.service.test;

import com.googlecode.junittoolbox.SuiteClasses;
import com.googlecode.junittoolbox.WildcardPatternSuite;
import org.junit.runner.RunWith;

@RunWith(WildcardPatternSuite.class)
@SuiteClasses("**/features/**/*.class")
public class ApplicationIntegrationTest {

}
