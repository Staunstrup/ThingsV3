package dk.staunstrups.things;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by jst on 12/19/15.
 */
public class ThingsFragment extends Fragment {

  private static String TAG= "ThingsDB";

  // GUI variables
  private Button addThing, listThings;
  private TextView lastAdded;
  private TextView newWhat, newWhere;

  private ListView mainListView; // area for displaying list of things
  private ArrayAdapter listAdapter;

  private static ThingsDB thingsDB;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    thingsDB = ThingsDB.get(getActivity());
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
    final View v = inflater.inflate(R.layout.fragment_things, container, false);
    lastAdded= (TextView) v.findViewById(R.id.last_thing);
    updateUI();

    // Buttons
    addThing = (Button) v.findViewById(R.id.add_button);
    newWhat= (TextView) v.findViewById(R.id.what_text);
    newWhere= (TextView) v.findViewById(R.id.where_text);
    listThings= (Button) v.findViewById(R.id.list_button);

    // adding a new thing
    addThing.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if ((newWhat.getText().length() > 0) && (newWhere.getText().length() > 0)) {
          thingsDB.addThing(new ThingItem(newWhat.getText().toString(), newWhere.getText().toString()));
          newWhat.setText("");
          newWhere.setText("");
          updateUI();
        }
      }
    });
    // list og all things
    listThings.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        // List of all things
        mainListView = (ListView) v.findViewById(R.id.mainListView);
        listAdapter = new ArrayAdapter<>(getActivity(), R.layout.list_item, thingsDB.getThingsDB());
        mainListView.setAdapter(listAdapter);
      }
    });

    return v;
  }
  private void updateUI(){
    int s= thingsDB.size();
    if (s>0) lastAdded.setText(thingsDB.get(s-1).toString());
  }
}
