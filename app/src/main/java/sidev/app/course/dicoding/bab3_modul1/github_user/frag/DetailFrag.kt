package sidev.app.course.dicoding.bab3_modul1.github_user.frag

import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.comp_icon_tv.view.*
import kotlinx.android.synthetic.main.comp_icon_tv_addition.view.*
import kotlinx.android.synthetic.main.page_detail.view.*
import sidev.app.course.dicoding.bab3_modul1.github_user.R
import sidev.app.course.dicoding.bab3_modul1.github_user.model.User
import sidev.app.course.dicoding.bab3_modul1.github_user.util.Const
import sidev.lib.android.std.tool.util.`fun`.getExtra
import sidev.lib.android.std.tool.util.`fun`.imgRes

class DetailFrag: StdFrag() {
    override val layoutId: Int = R.layout.page_detail
    override val actBarTitle: String = "User Detail"

    private lateinit var data: User

    override fun _initAllData(arguments: Bundle?) {
        data= arguments!!.getExtra(Const.DATA_USER, isSearchNested = true)!!
    }

    override fun _initView(layoutView: View) {
        layoutView.apply {
            Glide.with(context!!)
                .load(data.avatarInt(context!!))
                .into(iv_profile)
            tv_name.text= data.name
            tv_uname.text= data.username
            comp_repo.setCompData(R.drawable.ic_repo, data.repository.toString()){
                tv_addition.text= "repositories"
            }
            comp_follower.setCompData(R.drawable.ic_follower, data.follower.toString()){
                tv_addition.text= "followers"
            }
            comp_following.setCompData(0, data.following.toString()){
                iv.visibility= View.GONE
                tv_addition.text= "following"
            }
            comp_company.setCompData(R.drawable.ic_company, data.company)
            comp_location.setCompData(R.drawable.ic_location_, data.location)
        }
    }

    private fun View.setCompData(
        iconRes: Int,
        txt: String,
        config: (View.() -> Unit)?= null
    ){
        if(iconRes != 0)
            iv.imgRes= iconRes
        tv.text= txt
        scaleX= 1.2f
        scaleY= 1.2f
        config?.invoke(this)
    }
}