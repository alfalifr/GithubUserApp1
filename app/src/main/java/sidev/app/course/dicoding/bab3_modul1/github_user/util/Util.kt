package sidev.app.course.dicoding.bab3_modul1.github_user.util

import android.content.Context
import org.json.JSONObject
import sidev.app.course.dicoding.bab3_modul1.github_user.R
import sidev.app.course.dicoding.bab3_modul1.github_user.model.User

object Util {
    fun dataList(c: Context): ArrayList<User>{
        val fis= c.resources.openRawResource(R.raw.githubuser)
        val bytes= fis.readBytes()
        val str= bytes.decodeToString()

        val json= JSONObject(str)
        val arr= json.getJSONArray("users")
        val len= arr.length()

        val list= ArrayList<User>(len)

        for(i in 0 until len){
            arr.getJSONObject(i).apply {
                val username= getString("username")
                val name= getString("name")
                val avatar= getString("avatar")
                val company= getString("company")
                val location= getString("location")
                val repository= getInt("repository")
                val follower= getInt("follower")
                val following= getInt("following")

                list += User(username, name, avatar, company, location, repository, follower, following)
            }
        }
        return list
    }
}