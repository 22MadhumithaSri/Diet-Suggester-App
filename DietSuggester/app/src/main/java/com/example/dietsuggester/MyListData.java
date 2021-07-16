package com.example.dietsuggester;

import android.os.Parcel;
import android.os.Parcelable;

//code written by me
public class MyListData implements Parcelable {
    private String description;
    private String cal;
    private int imgId;
    private static int full=0;


    public MyListData(String description, String cal, int imgId) {
        this.description = description;
        this.cal = cal;
        this.imgId = imgId;
    }

    protected MyListData(Parcel in) {
        description = in.readString();
        cal = in.readString();
        imgId = in.readInt();
    }

    public static final Creator<MyListData> CREATOR = new Creator<MyListData>() {
        @Override
        public MyListData createFromParcel(Parcel in) {
            return new MyListData(in);
        }

        @Override
        public MyListData[] newArray(int size) {
            return new MyListData[size];
        }
    };

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getCal() {  return "Calories: "+cal;    }

    public int caladd(){
        int i=Integer.parseInt(cal);

        full=full+i;
        return full;
    }
    public String setmsg(int cal){
        if(full>cal)
        {return "Your recommended calorie limit "+cal+" is over";}
        else
        {return "You can add some more calories to attain recommended calorie intake";}
    }
    public void setCal(String cal) {        this.cal = cal;    }
    public int getImgId() {
        return imgId;
    }
    public void setImgId(int imgId) {
        this.imgId = imgId;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(description);
        parcel.writeString(cal);
        parcel.writeInt(imgId);
    }
}