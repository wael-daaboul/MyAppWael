package exa.sa.myappwael

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.InputStreamReader

data class Category(val name: String, val subcategories: List<String>)

object CategoryLoader {
    fun loadCategories(context: Context): List<Category> {
        val inputStream = context.resources.openRawResource(R.raw.categories)
        val reader = InputStreamReader(inputStream)
        val type = object : TypeToken<List<Category>>() {}.type
        return Gson().fromJson(reader, type)
    }
}
