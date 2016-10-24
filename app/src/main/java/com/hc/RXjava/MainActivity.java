package com.hc.RXjava;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.hc.RXjava.Object.User;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private List<User> userList = null;
    private CoordinatorLayout ll_coordinatorLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ll_coordinatorLayout = (CoordinatorLayout) findViewById(R.id.ll_coordinatorLayout);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        initData();
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
        switch (id){
            case R.id.action_rx_map:
                Log.i(TAG, "===================action_rx_map===================" + Thread.currentThread().getName());
                TestRx_map();
                break;
            case R.id.action_rx_flatmap:
                Log.i(TAG, "===================action_rx_flatmap===================" + Thread.currentThread().getName());
                TestRX_flatMap();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

   /**
    * @author statham
    * @date 2016/10/24 0024 15:07
    * @Description:
    * @param
    * @return
    */
    private void TestRx_map() {
        Observable.just("TestRx_map")

                .map(new Func1<String, String>() {
                    @Override
                    public String call(String str) {
                        Log.i(TAG, "map_Func1:" + Thread.currentThread().getName());
                        return str;
                    }
                })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String user) {
                        Log.i(TAG, "map_Action1:" + Thread.currentThread().getName());
                    }
                });
    }


    private void TestRX_flatMap(){
        Observable.just("TestRX_flatMap")

                .flatMap(new Func1<String, Observable<String>>() {
                    @Override
                    public Observable<String> call(String str) {
                        Log.i(TAG, "flatMap_Func1:" + Thread.currentThread().getName());
                        return Observable.just(str);
                    }
                }).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String user) {
                        Log.i(TAG, "flatMap_Action1:" + Thread.currentThread().getName());
                    }
                });
    }

    private void initData() {
        userList = new ArrayList<User>();

        User user = null;
        String name = null;
        String sex = "0";
        int age = 18;

        for (int i = 0; i < 20; i++) {
            name = "TUN" + i;
            if (i % 2 == 0) {
                sex = "0";
                age = age + i;
            } else {
                sex = "1";
                age = age + i * 2;
            }
            user = new User(name, sex, age);
            userList.add(user);
        }
    }


}
