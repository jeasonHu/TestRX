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
import commonlibrary.hyx.com.baselibrary.Response.BaseRespEntity;
import commonlibrary.hyx.com.baselibrary.Response.ResponEntityList;
import commonlibrary.hyx.com.baselibrary.Response.ResponEntityOb;
import commonlibrary.hyx.com.baselibrary.Retrofit.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RetrofitActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
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
                TestRetrofit2ListObject();

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
        Call<BaseRespEntity> call = RetrofitClient.getRetrofit(ServerConfig.getRequestURL())
                .create(ApiStores.class).getCityList("31","31","4.9");
        call.enqueue(new Callback<BaseRespEntity>() {
            @Override
            public void onResponse(Call<BaseRespEntity> call, Response<BaseRespEntity> response) {
                if(response == null || response.body() == null){
                    return;
                }
                try {
                    if (RespStatusType.STATUS_OK != response.body().getStatus()) {
                        Snackbar.make(ll_coordinatorLayout, "返回状态失败：" + response.body().getMsg(), Snackbar.LENGTH_SHORT)
                                .setAction("Action", null).show();
                    } else {
                        Snackbar.make(ll_coordinatorLayout, "返回状态失败", Snackbar.LENGTH_SHORT)
                                .setAction("Action", null).show();
                    }
                } catch (Exception e) {
                    Snackbar.make(ll_coordinatorLayout, "数据处理异常", Snackbar.LENGTH_SHORT)
                            .setAction("Action", null).show();
                }
            }

            @Override
            public void onFailure(Call<BaseRespEntity> call, Throwable t) {
                Snackbar.make(ll_coordinatorLayout, "onFailure ：" + t.getMessage(), Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
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
        Call<ResponEntityList<FilmInfo>> call = RetrofitClient.getRetrofit(ServerConfig.getRequestURL())
                .create(ApiStores.class).getFilmSimpleByIds("10","3392","31","31","4.9");
        call.enqueue(new Callback<ResponEntityList<FilmInfo>>() {
            @Override
            public void onResponse(Call<ResponEntityList<FilmInfo>> call, Response<ResponEntityList<FilmInfo>> response) {
                if(response == null || response.body() == null){
                    return;
                }
                try{
                    if(RespStatusType.STATUS_OK != response.body().getStatus()){
                        Snackbar.make(ll_coordinatorLayout, "数据异常或数据为空 ：" + response.body().getStatus()
                                 + " : " + response.body().getMsg() , Snackbar.LENGTH_SHORT)
                                .setAction("Action", null).show();
                        return;
                    }
                    FilmInfo film = response.body().getData().get(0);
                    if (film == null){
                        Snackbar.make(ll_coordinatorLayout, "返回实体数据为空 Null", Snackbar.LENGTH_SHORT)
                                .setAction("Action", null).show();
                        return;
                    }
                    Logger.i(TAG,film.toString());
                }catch (Exception e){
                    Snackbar.make(ll_coordinatorLayout, "数据处理异常", Snackbar.LENGTH_SHORT)
                            .setAction("Action", null).show();
                    return;
                }
            }

            @Override
            public void onFailure(Call<ResponEntityList<FilmInfo>> call, Throwable t) {
                Snackbar.make(ll_coordinatorLayout, "请求异常：" + t.getMessage(), Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            }
        });
    }

    private void TestRetrofit2Object(){
        Call<ResponEntityOb<ResultAd>> call = RetrofitClient.getRetrofit(ServerConfig.getRequestURL())
                .create(ApiStores.class).getAdInfo("10","0-maizuo","31","31","4.9");
        call.enqueue(new Callback<ResponEntityOb<ResultAd>>() {
            @Override
            public void onResponse(Call<ResponEntityOb<ResultAd>> call, Response<ResponEntityOb<ResultAd>> response) {
                if(response == null || response.body() == null){
                    return;
                }
                try{
                    if(RespStatusType.STATUS_OK != response.body().getStatus()){
                        Snackbar.make(ll_coordinatorLayout, "数据异常或数据为空 ：" + response.body().getStatus(), Snackbar.LENGTH_SHORT)
                                .setAction("Action", null).show();
                        return;
                    }
                    ResultAd data = response.body().getData();
                    if (data == null){
                        Snackbar.make(ll_coordinatorLayout, "返回实体数据为空 Null", Snackbar.LENGTH_SHORT)
                                .setAction("Action", null).show();
                        return;
                    }
                    Logger.i(TAG,data.toString());
                }catch (Exception e){
                    Snackbar.make(ll_coordinatorLayout, "数据处理异常", Snackbar.LENGTH_SHORT)
                            .setAction("Action", null).show();
                    return;
                }
            }

            @Override
            public void onFailure(Call<ResponEntityOb<ResultAd>> call, Throwable t) {
                Snackbar.make(ll_coordinatorLayout, "请求异常：" + t.getMessage(), Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            }
        });
    }

}
