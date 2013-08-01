package com.alarmclock;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.format.Time;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

@SuppressLint("NewApi")
@SuppressWarnings({ "unused" })
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
		boolean alarmSounding;
		boolean userIsDone;

		@Override
		protected void onCreate(Bundle savedInstanceState)
			{

				super.onCreate(savedInstanceState);

				// PowerManager powman = (PowerManager)
				// getSystemService(Context.POWER_SERVICE);
				// PowerManager.WakeLock wl =
				// powman.newWakeLock(PowerManager.FULL_WAKE_LOCK, "My Tag");
				// wl.acquire();

				setContentView(R.layout.activity_main);

				// Getting the system time;
				now = new Time();
				now.setToNow();

				alarmSounding = false;
				userIsDone = false;
				// creating the time on the application layout
				timePicker = (TimePicker) findViewById(R.id.timePicker);

				// Setting up the sound
				mp = MediaPlayer.create(this, R.raw.sound1);

				setAlarm(now);
				if (setAlarm(now) == 1)
					{
						Toast.makeText(this, "Alarm went off", Toast.LENGTH_SHORT).show();
					}
			}

		protected void onStop()
			{
				super.onStop();
			}

		@Override
		public boolean onCreateOptionsMenu(Menu menu)
			{
				// Inflate the menu; this adds items to the action bar if it is present.
				getMenuInflater().inflate(R.menu.main, menu);
				return true;
			}

		// What the button does. sets the alarm
		private int setAlarm(Time time)
			{

				Button alarmButton = (Button) findViewById(R.id.setButton);
				alarmButton.setOnClickListener(new View.OnClickListener()
					{
						@Override
						public void onClick(View v)
							{
								timePickerHour = timePicker.getCurrentHour();
								timePickerMinute = timePicker.getCurrentMinute();
							}
					});
				int currentHour = time.hour;
				int currentMinute = time.minute;

				if (timePickerHour == currentHour && timePickerMinute == currentMinute)
					{
						try
							{
								mp.start();
								alarmSounding = true;

								return 1;
							}
						catch (Exception e)
							{
								e.printStackTrace();
							}
					}

				return 0;
			}
	}
