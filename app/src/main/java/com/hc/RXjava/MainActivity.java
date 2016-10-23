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
import java.util.Objects;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    CoordinatorLayout coordlayout = null;
    private List<User> userList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        coordlayout = (CoordinatorLayout)findViewById(R.id.ll_coordinatorlayout);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action。。。", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        initData();
    }


    /**
     * @author statham 
     * @date 2016/8/30 0030 16:11
     * @Description: Rxjava 基础测试
     * @param  
     * @return      
     */	 
    private void TestRx(){


        /*.flatMap(new Func1<User, Observable<User>>() {
            @Override
            public Observable<User> call(User user) {
                return Observable.from();
            }
        })
                .filter(new Func1<User, Boolean>() {
                    @Override
                    public Boolean call(User user) {
                        return true;
                    }
                })*/
        Observable.from(userList)

                .map(new Func1<User, User>() {
                    @Override
                    public User call(User user) {
                        return user;
                    }
                })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<User>() {
                    @Override
                    public void call(User user) {

                    }
                });
    }


    private void initData(){
        userList = new ArrayList<User>();

        User user = null;
        String name = null;
        String sex = "0";
        int age = 18;

        for(int i=0;i<20;i++){
            name = "TUN"+i;
            if (i%2==0){
                sex = "0";
                age = age + i ;
            } else {
                sex = "1";
                age = age + i *2 ;
            }
            user = new User(name,sex,age);
            userList.add(user);
        }
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
            Log.i(TAG, "setting");
            Snackbar.make(coordlayout, "setting", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
