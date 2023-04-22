package com.homeproject.homeproject.codeforces.service;

import com.google.gson.*;
import com.homeproject.homeproject.codeforces.ICodeforcesAPI;
import com.homeproject.homeproject.codeforces.RetrofitUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;

@Service
public class CodeforcesService {
    private static final Logger LOG = LoggerFactory.getLogger(CodeforcesService.class);
    private final ICodeforcesAPI iCodeforcesAPI;
    private final Gson gson = new GsonBuilder()
            .setLenient()
            .create();
    @Autowired
    public CodeforcesService() {
        this.iCodeforcesAPI=RetrofitUtil.getInstance().create(ICodeforcesAPI.class);
    }

    public JsonArray getBlogComments(String id){
        try {
            Call<JsonObject> call = iCodeforcesAPI.getBlogComments(id);
            LOG.info("Call : {}",call);
            Response<JsonObject> response = call.execute();
            LOG.info("Response : {}",response);
            JsonArray result = response.body().get("result").getAsJsonArray();
            LOG.info("Found {} comments for the blog {}", result.size(), id);
            return result;
        } catch (JsonIOException | JsonSyntaxException e) {
            e.printStackTrace();
            // handle the exception gracefully
        } catch (Exception e) {
            // Handle the exception here
            LOG.info("Some error occurred while calling codeforces API ",e);
        }
        return null;
    }
}
