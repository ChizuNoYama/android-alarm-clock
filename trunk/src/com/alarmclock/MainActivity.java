package com.alarmclock;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.MotionEventCompat;
import android.text.format.Time;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

@SuppressWarnings({ "unused" })
public class MainActivity extends Activity
{
	Time now;
	TimePicker timePicker;
	TextView testMessage;
	int timePickerHour;
	int timePickerMinute;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
//		PowerManager powman = (PowerManager) getSystemService(Context.POWER_SERVICE);
//		PowerManager.WakeLock wl = powman.newWakeLock(PowerManager.FULL_WAKE_LOCK, "My Tag");
//		wl.acquire();

		setContentView(R.layout.activity_main);
		//Getting the system time;
		now = new Time();
		now.setToNow();

		timePicker = (TimePicker) findViewById(R.id.timePicker);
		
		setAlarm(timePickerHour, timePickerMinute, timePicker);
		
		testMessage = (TextView) findViewById(R.id.testText);
		
		
		
		//update or while loop or whatever is here
		alarmCheck(timePickerHour, timePickerMinute, now, testMessage);

<<<<<<< .mine
				Chronometer mainTimeDisplay = (Chronometer) findViewById(R.id.chronometer1);
				
			}
=======
	}
>>>>>>> .r8

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

	
	private void alarmCheck(int timePickHour, int timePickMinute, Time time, TextView test)
	{
		int currentHour = time.hour;
		int currentMinute = time.minute;
		
		if(timePickHour == currentHour && timePickMinute == currentMinute){
			test.setText("Alarm!!");
		}
	}
	
	// What the button does. sets the alarm
	private void setAlarm(int timePickerHour, int timePickerMinute, final TimePicker timePicker){
		Button alarmButton = (Button) findViewById(R.id.setButton);
		alarmButton.setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				int timePickerHour = timePicker.getCurrentHour();
				int timePickerMinute = timePicker.getCurrentMinute();
				
			}
		});
	}

}
