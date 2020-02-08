package allam9072.fm.DB;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonAPI {
    @GET("categories")
    Call<List<Category>>getAllCategories();
    @GET("products")
    Call<List<Product>>getAllProducts();
}
