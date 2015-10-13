package com.bawanj.andoriddatabinding;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;

import com.bawanj.andoriddatabinding.adapter.UserListAdapter;
import com.bawanj.andoriddatabinding.databinding.ActivityMainBinding;
import com.bawanj.andoriddatabinding.model.User;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // ViewModel
        ActivityMainBinding binding
                = DataBindingUtil.setContentView(this, R.layout.activity_main);
        // setup toolbar
        binding.toolbar.setTitle("Data Binding");
        binding.toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(binding.toolbar);

        initData(); // set up user list

        //setup LayoutManager and Adapter recyclerView

        binding.recyclerView
                .setLayoutManager( new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        UserListAdapter adapter= new UserListAdapter(users);
        binding.recyclerView.setAdapter(adapter);
    }

    private void initData(){

        users= new ArrayList<>();

        for(int i=0; i<20; ++i ){
            String userName= "Name: user "+i;
            String userPassword= "Password: xyz "+i;
            User user = new User( userName, userPassword, i);
            users.add(user);
        }
    }

        // ViewModel: ActivityMainBinding <= recycler_item.xml
//        MyBinding myBinding
//                = DataBindingUtil.setContentView(this, R.layout.recycler_item);
//
//        //Observable collections
//        final ObservableMap<String, Object > map = new ObservableArrayMap<>();
//        map.put("name","Jeffrey");
//        map.put("age", "36");
//        myBinding.setMap(map);

//        // Observable Fields
//        final User user= new User();
//        user.userName.set("Jeffrey");
//        user.userPassword.set("Nyu168168168");
//        myBinding.setUser(user);

//      // Observable object
//        final User user= new User("Jeffrey", "Nyu168168168" );
//        myBinding.setUser(user);
//
        // click the button to change values of TextView
//        myBinding.btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                map.put("name", "Android");
//                map.put("age", "5");
                  // Observable Fields
//                user.userName.set("Hello");
//                user.userPassword.set("Nyu1681689888");

                  // Observable object
//                user.setUserName("Hello");
//                user.setUserPassword("Nyu1681689888");
//            }
//        });


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
