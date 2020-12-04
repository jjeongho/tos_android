package deu.cse.tos;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RetrofitService {


    @FormUrlEncoded
    @POST("auth/info")
    Call<UserDTO> postUserResult(@FieldMap HashMap<String, Object> param);

}
