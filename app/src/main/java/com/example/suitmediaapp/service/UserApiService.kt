import com.example.suitmediaapp.models.UserResponse
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Call

interface UserApiService {
    @GET("users")
    fun getAllUsers(@Query("page") page: Int): Call<UserResponse>
}