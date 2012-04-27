package at.Grevinelveck.SLFunctions;

public class SleepThread {
//Set a running sleep thread to use SLFunctions
	public class SleepTnterrupt implements Runnable {
		public void run() {
		    try {
		      Thread.sleep(4000);
		    } catch (InterruptedException x) {
		      return;
		    }
		  }
	}
}
