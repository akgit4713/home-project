package com.homeproject.homeproject.codeforces;

import com.google.gson.JsonObject;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ICodeforcesAPI {
    @GET("blogEntry.comments")
    Call<JsonObject> getBlogComments(@Query("blogEntryId") String blogEntryId);
}
