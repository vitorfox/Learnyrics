package com.learnyrics;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import android.widget.*;

public class MusicDetecterActivity extends Activity {
	public static final String SERVICECMD = "com.android.music.musicservicecommand";
	public static final String CMDNAME = "command";
	public static final String CMDTOGGLEPAUSE = "togglepause";
	public static final String CMDSTOP = "stop";
	public static final String CMDPAUSE = "pause";
	public static final String CMDPREVIOUS = "previous";
	public static final String CMDNEXT = "next";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_music_detecter);
		IntentFilter iF = new IntentFilter();
		iF.addAction("com.android.music.metachanged");
		iF.addAction("com.android.music.playstatechanged");
		iF.addAction("com.android.music.playbackcomplete");
		iF.addAction("com.android.music.queuechanged"); 
		registerReceiver(mReceiver, iF);
	}
	private BroadcastReceiver mReceiver = new BroadcastReceiver() { @Override
		public void onReceive(Context context, Intent intent) {
			String action = intent.getAction();
			String cmd = intent.getStringExtra("command");
			Log.i("Music", action + " / " + cmd);
			String artist = intent.getStringExtra("artist");
			String album = intent.getStringExtra("album");
			String track = intent.getStringExtra("track");
			Log.i("Music",artist+":"+track);
			Toast.makeText(MusicDetecterActivity.this,track,Toast.LENGTH_SHORT).show(); 
			TextView textView = (TextView) findViewById(R.id.musicname);
			textView.setText(artist+":"+track);
		}
	};
}
