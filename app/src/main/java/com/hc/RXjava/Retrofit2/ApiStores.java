package com.hc.RXjava.Retrofit2;

import com.hc.RXjava.Object.FilmInfo;
import com.hc.RXjava.Object.ResultAd;

import commonlibrary.hyx.com.baselibrary.Response.BaseRespEntity;
import commonlibrary.hyx.com.baselibrary.Response.ResponEntityList;
import commonlibrary.hyx.com.baselibrary.Response.ResponEntityOb;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author statham
 * @Email statham@maizuo.com
 * @date 2016/10/25 0025 11:58
 * @Description:
 */
public interface ApiStores {


    public final String VER4 = "/ver4";

    @FormUrlEncoded
    @POST("/ver4/city/list")
    Call<ResponseBody> TestPost(@Field("channelID") String channelID,
                                              @Field("clientID") String clientID,
                                              @Field("revision") String revision);

   /* @POST("ver4/bcnew/v2_0/barrage/send")
    Call<ResponseBody> sendBarrage(@Body ReqBarrageList barrageList);*/


    @GET("/ver4/city/list")
    Call<BaseRespEntity> getCityList(@Query("channelID") String channelID,
                                     @Query("clientID") String clientID,
                                     @Query("revision") String revision);

    @GET(VER4 + "/city/{cityId}/otherFilm")
    Call<ResponEntityList<FilmInfo>> getFilmSimpleByIds(@Path("cityId") String cityId, @Query("filmIds") String filmIds, @Query("channelID") String channelID,
                                                        @Query("clientID") String clientID,
                                                        @Query("revision") String revision);

    @GET(VER4 + "/city/{cityId}/ADInfo")
    Call<ResponEntityOb<ResultAd>> getAdInfo(@Path("cityId") String cityId, @Query("agentID") String agentID, @Query("channelID") String channelID,
                                             @Query("clientID") String clientID,
                                             @Query("revision") String revision);

    @GET("adat/sk/{cityId}.html")
    Call<ResponseBody> getWeatherRxjava(@Path("cityId") String cityId);

}
