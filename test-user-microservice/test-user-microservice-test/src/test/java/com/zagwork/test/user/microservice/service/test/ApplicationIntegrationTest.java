package com.zagwork.test.user.microservice.service.test;

import com.googlecode.junittoolbox.SuiteClasses;
import com.googlecode.junittoolbox.WildcardPatternSuite;
import org.junit.runner.RunWith;

@RunWith(WildcardPatternSuite.class)
@SuiteClasses("**/features/**/*.class")
public class ApplicationIntegrationTest {

}
