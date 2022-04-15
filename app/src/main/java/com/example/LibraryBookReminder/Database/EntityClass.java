package com.example.LibraryBookReminder.Database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.UUID;

@Entity(tableName = "Book_Return")
public class EntityClass {
    @PrimaryKey(autoGenerate = true)
    int id ;
//    @ColumnInfo(name = "Book_id")
//    private int Vid;

    @ColumnInfo(name = "eventname")
    String eventname;
    @ColumnInfo(name = "eventdate")
    String eventdate;
    @ColumnInfo(name = "eventtime")
    String eventtime;

//    public int getVid() { return Vid; }
//
//    public void setVid(int Vid) {this.Vid = id; }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public String getEventdate() {
        return eventdate;
    }

    public void setEventdate(String eventdate) {
        this.eventdate = eventdate;
    }

    public String getEventtime() {
        return eventtime;
    }

    public void setEventtime(String eventtime) {
        this.eventtime = eventtime;
    }
}
