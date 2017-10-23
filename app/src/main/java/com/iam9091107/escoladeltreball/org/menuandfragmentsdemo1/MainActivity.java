package com.iam9091107.escoladeltreball.org.menuandfragmentsdemo1;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements BlankFragment.OnFragmentInteractionListener{

    private Button btnAdd;
    private Button btnRemove;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setup();

    }

    private void setup() {
        btnAdd = (Button) findViewById(R.id.add);
        btnRemove = (Button) findViewById(R.id.remove);

        btnAdd.setOnClickListener(view -> addFragment());
        btnRemove.setOnClickListener(view -> removeFragment());
    }

    private void removeFragment() {


        //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, BlankFragment.newInstance(null, null)).commit();
        if (getSupportFragmentManager().getBackStackEntryCount()>0){
            getSupportFragmentManager().popBackStack();
        }
    }

    private void addFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, BlankFragment.newInstance(null, null))
                .addToBackStack(null).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.item_about:
                Toast.makeText(this,"About", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.item_contact:
                Toast.makeText(this,"Contact", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.item_Programming:
                Toast.makeText(this,"Programming", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.item_projects:
                Toast.makeText(this,"Projects", Toast.LENGTH_SHORT).show();
                // indica que hem consumit l'event
                return true;

        }
        return false;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem menuItem = menu.findItem(R.id.item_about);
        menuItem.setEnabled(false);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
