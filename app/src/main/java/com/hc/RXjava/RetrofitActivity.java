package com.hc.RXjava;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.hc.RXjava.Commons.RespStatusType;
import com.hc.RXjava.Object.FilmInfo;
import com.hc.RXjava.Object.ResultAd;
import com.hc.RXjava.Retrofit2.ApiStores;
import com.hc.RXjava.ServerUtils.ServerConfig;

import commonlibrary.hyx.com.baselibrary.Logger;
import commonlibrary.hyx.com.baselibrary.BaseResponse.BaseRespEntity;
import commonlibrary.hyx.com.baselibrary.BaseResponse.ResponEntityList;
import commonlibrary.hyx.com.baselibrary.BaseResponse.ResponEntityOb;
import commonlibrary.hyx.com.baselibrary.Retrofit.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RetrofitActivity extends AppCompatActivity {

    private static final String TAG = "RetrofitActivity";
    private CoordinatorLayout ll_coordinatorLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_retrofit);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Retrofit2");
        setSupportActionBar(toolbar);

        ll_coordinatorLayout = (CoordinatorLayout) findViewById(R.id.ll_coordinatorLayout);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSnackbar(".........");

            }
        });

        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TestRetrofit2();
            }
        });
        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TestRetrofit2ListObject();
            }
        });
        findViewById(R.id.btn3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TestRetrofit2Object();
            }
        });

    }

    /**
     * @author statham
     * @date 2016/10/25 0025 11:36
     * @Description: 只判断返回数据状态的情况
     * @param
     * @return
     */
    private void TestRetrofit2(){
        Call<BaseRespEntity> call = RetrofitClient.getInstance().getRetrofit()
                .create(ApiStores.class).getCityList();
        call.enqueue(new Callback<BaseRespEntity>() {
            @Override
            public void onResponse(Call<BaseRespEntity> call, Response<BaseRespEntity> response) {
                if(response == null || response.body() == null){
                    return;
                }
                try {
                    if (!RespStatusType.STATUS_OK.equals(response.body().getStatus())) {
                        showSnackbar("返回状态失败：" + response.body().getMsg());
                    } else {
                        showSnackbar("返回状态成功：" + response.body().getMsg());
                    }
                } catch (Exception e) {
                    showSnackbar("数据处理异常");
                }
            }

            @Override
            public void onFailure(Call<BaseRespEntity> call, Throwable t) {
                showSnackbar("onFailure ：" + t.getMessage());
            }
        });
    }

    /**
     * @author statham
     * @date 2016/10/25 0025 19:53
     * @Description: 请求ListObject类型数据  返回
     * @param
     * @return
     */
    private void TestRetrofit2ListObject(){
        Call<ResponEntityList<FilmInfo>> call = RetrofitClient.getInstance().getRetrofit()
                .create(ApiStores.class).getFilmSimpleByIds("10","3392");
        call.enqueue(new Callback<ResponEntityList<FilmInfo>>() {
            @Override
            public void onResponse(Call<ResponEntityList<FilmInfo>> call, Response<ResponEntityList<FilmInfo>> response) {
                if(response == null || response.body() == null){
                    return;
                }
                try{
                    if(!RespStatusType.STATUS_OK.equals(response.body().getStatus())){
                        showSnackbar("数据异常或数据为空 ：" + response.body().getStatus()
                                 + " : " + response.body().getMsg());
                        return;
                    }
                    FilmInfo film = response.body().getData().get(0);
                    if (film == null){
                        showSnackbar("返回实体数据为空 Null");
                        return;
                    }
                    Logger.i(TAG,film.toString());
                }catch (Exception e){
                    showSnackbar("数据处理异常");
                    return;
                }
            }

            @Override
            public void onFailure(Call<ResponEntityList<FilmInfo>> call, Throwable t) {
                showSnackbar("请求异常：" + t.getMessage());
            }
        });
    }

    /**
     * @author statham
     * @date 2016/10/25 22:13
     * @Description:请求Object类型数据  返回
     * @param
     * @return
     */
    private void TestRetrofit2Object(){
        Call<ResponEntityOb<ResultAd>> call = RetrofitClient.getInstance().getRetrofit()
                .create(ApiStores.class).getAdInfo("10");
        call.enqueue(new Callback<ResponEntityOb<ResultAd>>() {
            @Override
            public void onResponse(Call<ResponEntityOb<ResultAd>> call, Response<ResponEntityOb<ResultAd>> response) {
                if(response == null || response.body() == null){
                    return;
                }
                try{
                    if(!RespStatusType.STATUS_OK.equals(response.body().getStatus())){
                        showSnackbar("数据异常或数据为空 ："  + response.body().getStatus()
                                + " : " + response.body().getMsg());
                        return;
                    }
                    ResultAd data = response.body().getData();
                    if (data == null){
                        showSnackbar("返回实体数据为空 Null");
                        return;
                    }
                    Logger.i(TAG,data.toString());
                }catch (Exception e){
                    showSnackbar("数据处理异常");
                    return;
                }
            }

            @Override
            public void onFailure(Call<ResponEntityOb<ResultAd>> call, Throwable t) {
                showSnackbar("请求异常：" + t.getMessage());
            }
        });
    }


    private void showSnackbar(String msg){
        Snackbar.make(ll_coordinatorLayout, msg, Snackbar.LENGTH_SHORT)
                .setAction("Action", null).show();
    }
}
