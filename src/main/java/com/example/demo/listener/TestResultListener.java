// package com.example.demo.listener;

// import org.testng.ITestContext;
// import org.testng.ITestListener;
// import org.testng.ITestResult;

// public class TestResultListener implements ITestListener {

//     @Override
//     public void onTestStart(ITestResult result) {
//         System.out.println("[TEST START] " + result.getName());
//     }

//     @Override
//     public void onTestSuccess(ITestResult result) {
//         System.out.println("[TEST PASS] " + result.getName());
//     }

//     @Override
//     public void onTestFailure(ITestResult result) {
//         System.out.println("[TEST FAIL] " + result.getName());
//         if (result.getThrowable() != null) {
//             result.getThrowable().printStackTrace();
//         }
//     }

//     @Override
//     public void onTestSkipped(ITestResult result) {
//         System.out.println("[TEST SKIPPED] " + result.getName());
//     }

//     @Override
//     public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
//         System.out.println("[TEST FAIL PARTIAL] " + result.getName());
//     }

//     @Override
//     public void onStart(ITestContext context) {
//         System.out.println("[TEST SUITE START] " + context.getName());
//     }

//     @Override
//     public void onFinish(ITestContext context) {
//         System.out.println("[TEST SUITE FINISH] " + context.getName());
//     }
// }
