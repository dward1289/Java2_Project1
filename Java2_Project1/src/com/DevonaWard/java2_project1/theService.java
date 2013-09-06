package com.DevonaWard.java2_project1;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;






public class theService extends IntentService{
	JSONArray teamStat;
	ArrayList<String> teamRanks = new ArrayList<String>();
	ArrayList<String> teamName = new ArrayList<String>();
	ArrayList<String> teamArea = new ArrayList<String>();
	ArrayList<String> teamDivision = new ArrayList<String>();

  public theService() {
      super("theService");
  } 
     

  @Override
  protected void onHandleIntent(Intent intent) {
	  Log.d("TAG", "Service started");
	        String JSONString;
	        try {

	            //open the inputStream to the file 
	            InputStream inputStream = getAssets().open("document.json");

	            int sizeOfJSONFile = inputStream.available();

	            //array that will store all the data 
	            byte[] bytes = new byte[sizeOfJSONFile];

	            //reading data into the array from the file
	            inputStream.read(bytes);

	            //close the input stream
	            inputStream.close();

	            JSONString = new String(bytes, "UTF-8");
	            teamStat = new JSONArray(JSONString);
	            
	            //Adding pieces of the data to arrays.
	            for (int i=0; i<teamStat.length(); i++) {
	              String  theCity = teamStat.getJSONObject(i).getString("first_name");
	              String  theTeam = teamStat.getJSONObject(i).getString("full_name");
	              String  theDiv = teamStat.getJSONObject(i).getString("division");
	              String  theArena = teamStat.getJSONObject(i).getString("site_name");
	              teamRanks.add(theCity);
	              teamName.add(theTeam); 
	          	  teamArea.add(theDiv); 
	          	  teamDivision.add(theArena); 
	         }
	            //All data logged
	            Log.i("Cities:", teamRanks.toString()); 
	            Log.i("Teams:", teamName.toString()); 
	            Log.i("Divisions:", teamDivision.toString()); 
	            Log.i("Arenas:", teamArea.toString()); 
	            
	        } catch (IOException ex) {
	            ex.printStackTrace();
	            return;
	        }
	        catch (JSONException x) {
	            x.printStackTrace();
	            return;
	        }
	   } 
}