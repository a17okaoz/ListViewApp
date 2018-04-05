package org.brohede.marcus.listviewapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    // Let the static raw data that you use in your ListView be created here as a
    // member variable to the MainActivity class.
    private String[] mountainNames = {"Matterhorn","Mont Blanc","Denali"};
    private String[] mountainLocations = {"Alps","Alps","Alaska"};
    private int[] mountainHeights ={4478,4808,6190};

    protected ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Skapa en array
        final String[] rawData = {"Okan", "Orkan", "Okian"};

        //Skapa att list-objekt med din array som in data
        List<String> listdata = new ArrayList<String>(Arrays.asList(rawData));

        //Skapa en ArrayAdapter som kopplar samman
        //List_item_textview, my_item_textview, och listan med rådata
        adapter = new ArrayAdapter(getApplicationContext(),R.layout.list_item_textview,
                R.id.my_item_listview, mountainNames);

        //Koppla samman ListView med ArrayAdapter
        ListView myListView = (ListView)findViewById(R.id.my_listview);
        myListView.setAdapter(adapter);

        //Se att vi kan lägga till element i adaptern
        //som automatiskt bir uppdaterat i ListView:n

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast toast = Toast.makeText(getApplicationContext(),
                        mountainNames[position] + " " + mountainLocations[position] + " " + mountainHeights[position] ,
                        Toast.LENGTH_SHORT);
                toast.show();

            }
        });



    }
}
