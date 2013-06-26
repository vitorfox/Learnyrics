package com.learnyrics.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.googlecode.androidannotations.annotations.EActivity;
import com.learnyrics.R;


public class CurrentMusicTrackInfoActivity extends Activity 
{

	public static final String SERVICECMD = "com.android.music.musicservicecommand";
	
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_current_music_track_info);
		
	    IntentFilter iF = new IntentFilter();
	    iF.addAction("com.android.music.metachanged");
	    iF.addAction("com.android.music.playstatechanged");
	    iF.addAction("com.android.music.playbackcomplete");
	    iF.addAction("com.android.music.queuechanged");
	    iF.addAction("com.htc.music.metachanged");
	    iF.addAction("fm.last.android.metachanged");
	    iF.addAction("com.sec.android.app.music.metachanged");
	    iF.addAction("com.nullsoft.winamp.metachanged");
	    iF.addAction("com.amazon.mp3.metachanged");     
	    iF.addAction("com.miui.player.metachanged");        
	    iF.addAction("com.real.IMP.metachanged");
	    iF.addAction("com.sonyericsson.music.metachanged");
	    iF.addAction("com.rdio.android.metachanged");
	    iF.addAction("com.samsung.sec.android.MusicPlayer.metachanged");
	    iF.addAction("com.andrew.apollo.metachanged");	    
	    
		registerReceiver(mReceiver, iF);

	}
	
	private BroadcastReceiver mReceiver = new BroadcastReceiver() 
	{
	
	    @Override
	    public void onReceive(Context context, Intent intent)
	    {
		    String action = intent.getAction();
		    String cmd = intent.getStringExtra("command");
		    Log.v("TRACK", action + " / " + cmd);
		    String artist = intent.getStringExtra("artist");
		    String album = intent.getStringExtra("album");
		    String track = intent.getStringExtra("track");
		    Log.v("TRACK",artist+":"+album+":"+track);
			Toast.makeText(CurrentMusicTrackInfoActivity.this,track,Toast.LENGTH_SHORT).show(); 
	    }
	};

}

