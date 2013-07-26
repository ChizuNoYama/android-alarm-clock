package com.alarmclock;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;
import android.text.format.Time;
import android.view.Menu;
import android.widget.Chronometer;

public class MainActivity extends Activity
	{

		@SuppressWarnings("deprecation")
		@Override
		protected void onCreate(Bundle savedInstanceState)
			{
				super.onCreate(savedInstanceState);
				PowerManager powman = (PowerManager) getSystemService(Context.POWER_SERVICE);
				PowerManager.WakeLock wl = powman.newWakeLock(PowerManager.FULL_WAKE_LOCK, "My Tag");
				wl.acquire();

				setContentView(R.layout.activity_main);
				Time now = new Time();
				now.setToNow();

				Chronometer chronometer1 = (Chronometer) findViewById(R.id.chronometer1);
				
			}

		// protected void onStop()
		// {
		// super.onStop();
		// wl.release();
		// }

		@Override
		public boolean onCreateOptionsMenu(Menu menu)
			{
				// Inflate the menu; this adds items to the action bar if it is present.
				getMenuInflater().inflate(R.menu.main, menu);
				return true;
			}

	}
