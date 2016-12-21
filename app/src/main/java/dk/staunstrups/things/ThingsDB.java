package dk.staunstrups.things;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

public class ThingsDB {
  private static ThingsDB sThingsDB;
  //fake database
  private List<ThingItem> mThingsDB;

  public static ThingsDB get(Context context) {
    if (sThingsDB == null) sThingsDB= new ThingsDB(context);
    return sThingsDB;
  }

  public List<ThingItem> getThingsDB() {return mThingsDB; }

  public void addThing(ThingItem thing) { mThingsDB.add(thing); }

  public int size() {return mThingsDB.size(); }

  public ThingItem get(int i){ return mThingsDB.get(i); }

  // Fill database for testing purposes
  private ThingsDB(Context context) {
    mThingsDB= new ArrayList<ThingItem>();
    mThingsDB.add(new ThingItem("Android Pnone", "Desk"));
    mThingsDB.add(new ThingItem("Glasses", "Desk"));
    mThingsDB.add(new ThingItem("Mouse", "Desk"));
    mThingsDB.add(new ThingItem("iPhone", "Desk"));
    mThingsDB.add(new ThingItem("Sunlasses", "Desk"));
    mThingsDB.add(new ThingItem("Keyboard", "Desk"));
    mThingsDB.add(new ThingItem("Display", "Desk"));
    mThingsDB.add(new ThingItem("Computer", "Desk"));
    mThingsDB.add(new ThingItem("Big Nerd book", "Desk"));
  }
}
