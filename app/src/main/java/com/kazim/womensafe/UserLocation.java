package com.kazim.womensafe;


public class UserLocation {

    private String userId;
    private double latitude;
    private double longitude;
    private String address;
    
    private String state;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String ToString(){
        return "{"+
                    "android_id:'" + userId + '\'' +
                    ", latitude:'" + Double.toString(latitude) + '\'' +
                    ", longitude:'" + Double.toString(longitude) + '\'' +
                    ", address:'" + userId + '\'' +
                    ", state:" + state
                +"}";
    }

}
