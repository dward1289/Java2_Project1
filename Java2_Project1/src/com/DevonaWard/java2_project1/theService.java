package com.DevonaWard.java2_project1;

import android.app.IntentService;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;




public class theService extends IntentService{

	public theService() {
		super("theService");
		
		Log.i("SERVICE", "Intent Service started");
	}

	@Override
	protected void onHandleIntent(Intent intent) {
	
	}
	

	  @Override
	  public void onCreate() {
	    
	  }

	  @Override
	  public int onStartCommand(Intent intent, int flags, int startId) {
		
		  return 0;
	     
	  }

	  @Override
	  public IBinder onBind(Intent intent) {
	      // We don't provide binding, so return null
	      return null;
	  }
	  
	  @Override
	  public void onDestroy() {
	     
	  }

}
