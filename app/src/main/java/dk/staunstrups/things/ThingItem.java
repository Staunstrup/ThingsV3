package dk.staunstrups.things;

public class ThingItem {
	private String mWhat = null;
	private String mWhere = null;

	public ThingItem(String what, String where) {
		mWhat = what;
		mWhere = where;
	}
  @Override
  public String toString() { return oneLine("Item: ","is here: "); }

	public String getWhat() {	return mWhat;	}
	public void setWhat(String what) { mWhat = what; }
	public String getWhere() { return mWhere;	}
	public void setWhere(String where) { mWhere = where; }
	public String oneLine(String pre, String post) {
		return pre+mWhat + " "+post + mWhere;
	}
}
