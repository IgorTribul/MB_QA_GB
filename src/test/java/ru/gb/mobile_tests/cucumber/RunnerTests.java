package ru.gb.mobile_tests.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/feature", glue = "ru/gb/mobile_tests/cucumber/steps")
public class RunnerTests extends AbstractTestNGCucumberTests {
}
