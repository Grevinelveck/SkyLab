package at.Grevinelveck.SLFunctions;

public class sleepThread {
//Set a running sleep thread to use SLFunctions
	public class sleepTnterrupt implements Runnable {
		public void run() {
		    try {
		      Thread.sleep(4000);
		    } catch (InterruptedException x) {
		      return;
		    }
		  }
	}
}