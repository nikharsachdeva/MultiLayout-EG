package com.nikharsachdeva.multilayout_eg.Network;


import com.nikharsachdeva.multilayout_eg.All.AllResponse;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIinterface {


    @GET("common-service/api/crm/lead/getallinfo/{id}")
    Call<AllResponse> fetchLeadDetails2(
            @Path(value = "id") String id,
            @Header("Content-Type") String content_type,
            @Header("Authorization") String authHeader

    );

}
