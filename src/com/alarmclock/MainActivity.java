package com.alarmclock;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.PowerManager;
import android.support.v4.view.MotionEventCompat;
import android.text.format.Time;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

@SuppressLint("NewApi")
@SuppressWarnings({ "unused", "deprecation" })
public class MainActivity extends Activity
{
	Time now;
	TimePicker timePicker;
	TextView testMessage;
	int timePickerHour;
	int timePickerMinute;
	MediaPlayer mp;
	Bundle bundle;
	Dialog dialog;
	

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		
		super.onCreate(savedInstanceState);
		

//		PowerManager powman = (PowerManager)
//		getSystemService(Context.POWER_SERVICE);
//		PowerManager.WakeLock wl =
//		powman.newWakeLock(PowerManager.FULL_WAKE_LOCK, "My Tag");
//		wl.acquire();

		setContentView(R.layout.activity_main);
		
		// Getting the system time;
		now = new Time();
		now.setToNow();
		
		// creating the time on the application layout
		timePicker = (TimePicker) findViewById(R.id.timePicker);
		
		// Setting up the sound
		mp = MediaPlayer.create(this, R.raw.sound1);

		setAlarm();
		
	}

//	protected void onStop()
//	{
//		super.onStop();
//	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	// What the button does. sets the alarm
	private void setAlarm()
	{

		Button alarmButton = (Button) findViewById(R.id.setButton);
		alarmButton.setOnClickListener(new View.OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				int timePickerHour = timePicker.getCurrentHour();
				int timePickerMinute = timePicker.getCurrentMinute();
				
				// Testing for the sound and the dialog
				mp.start();
				
				// creating the snooze and dismiss dialog box with bundle?
				
			}
		});
	}

	// Checks is the alarm and the time match. So later when we find out the update method
	private void alarmCheck(int timePickHour, int timePickMinute, Time time, TextView test, MediaPlayer mp)
	{
		int currentHour = time.hour;
		int currentMinute = time.minute;

		if(timePickHour == currentHour && timePickMinute == currentMinute)
		{
			try
			{
				mp.start();
			} catch (Exception e)
			{
				e.printStackTrace();
			}

		}
	}
	
	

}
