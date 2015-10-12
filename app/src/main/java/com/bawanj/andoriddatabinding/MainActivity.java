package com.bawanj.andoriddatabinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.bawanj.andoriddatabinding.databinding.MyBinding;
import com.bawanj.andoriddatabinding.model.User;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // ViewModel: ActivityMainBinding <= activity_main.xml
        MyBinding myBinding
                = DataBindingUtil.setContentView(this, R.layout.activity_main);

        // Observable Fields
        final User user= new User();
        user.userName.set("Jeffrey");
        user.userPassword.set("Nyu168168168");
        myBinding.setUser(user);

//      // Observable object
//        final User user= new User("Jeffrey", "Nyu168168168" );
//        myBinding.setUser(user);
//
        // click the button to change values of TextView
        myBinding.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.userName.set("Hello");
                user.userPassword.set("Nyu1681689888");
//                user.setUserName("Hello");
//                user.setUserPassword("Nyu1681689888");
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
