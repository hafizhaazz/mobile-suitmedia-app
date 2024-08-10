import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserService {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://reqres.in/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val api = retrofit.create(UserApiService::class.java)

    suspend fun getAllUsers(page: Int): List<UserModel> {
        return try {
            val response = api.getAllUsers(page).execute()
            if (response.isSuccessful) {
                response.body()?.data ?: emptyList()
            } else {
                emptyList()
            }
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }
}