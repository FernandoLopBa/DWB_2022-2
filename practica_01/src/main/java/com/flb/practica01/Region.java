package com.flb.practica01;

public class Region{

    private int region_id;

    private String region;

    public Region(int region_id, String region){
	this.region_id = region_id;
	this.region = region;
    }

    public int getId(){
	return region_id;
    }

    public String getRegion(){
	return region;
    }

    public void setId(int region_id){
	this.region_id = region_id;
    }

    public void setRegion(String region){
	this.region = region;
    }

    @Override
    public String toString(){
	return String.format("%s\tRegion_id:%d\n", region, region_id);
    }

    public String insert(){
	return String.format("%d, %s", region_id, region);
    }
}
