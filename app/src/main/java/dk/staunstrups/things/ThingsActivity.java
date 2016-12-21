package dk.staunstrups.things;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

/*
Version 4 uses fragments
This version has a decent layout in non-landscape and a default initilialization of the DB
But landscape layout is not ok
 */

public class ThingsActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_things);
    FragmentManager fm= getSupportFragmentManager();
    Fragment fragment= fm.findFragmentById(R.id.fragment_container);

    if (fragment == null) {
      fragment = new ThingsFragment();
      fm.beginTransaction()
          .add(R.id.fragment_container, fragment)
          .commit();
    }
	}
}
