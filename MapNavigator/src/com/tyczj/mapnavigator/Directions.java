package com.chirinex.app.libraries.MapNavigator.src.com.tyczj.mapnavigator;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Directions {
	
	private ArrayList<Route> routes;
	private String directions;
	
	public enum DrivingMode{
		DRIVING,MASS_TRANSIT,BYCICLE,WALKING
	}
	
	public enum Avoid{
		TOLLS,HIGHWAYS,NONE
	}
	
	public Directions(String directions){
		this.directions = directions;
        routes = new ArrayList<Route>();
		if(directions != null){
			parseDirections();
		}
	}

    public Directions(Route route) {
        routes = new ArrayList<Route>();
        routes.add(route);
    }

    private void parseDirections(){
		try {
			JSONObject json = new JSONObject(directions);

			
			if(!json.isNull("routes")){
				JSONArray route = json.getJSONArray("routes");
				
				for(int k=0;k<route.length(); k++){
					
					JSONObject obj3 = route.getJSONObject(k);
					routes.add(new Route(obj3));
				}
			}
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Route> getRoutes(){
		return routes;
	}
}
