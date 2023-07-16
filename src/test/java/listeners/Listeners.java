
	package listeners;

	import org.testng.ITestContext;
	import org.testng.ITestListener;
	import org.testng.ITestResult;

	import dsAlgo_Utilities.LoggerLoad;



	public class Listeners implements ITestListener{

		@Override
		public void onTestStart(ITestResult result) {
			LoggerLoad.info("inTestStart");
		}

		@Override
		public void onTestSuccess(ITestResult result) {
			LoggerLoad.info("Test Success");
		}

		@Override
		public void onTestFailure(ITestResult result) {
			LoggerLoad.info("Test Failed");
		}

		

		@Override
		public void onTestSkipped(ITestResult result) {
			LoggerLoad.info("Test Skipped" + result.getName());
		}

		

		@Override
		public void onFinish(ITestContext context) {
			LoggerLoad.info("Test Finished" +context.getName());
		}
		

	}


