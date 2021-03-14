package sidev.app.course.dicoding.bab3_modul1.github_user.adp

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.comp_icon_tv.view.*
import kotlinx.android.synthetic.main.comp_item.view.*
import sidev.app.course.dicoding.bab3_modul1.github_user.R
import sidev.app.course.dicoding.bab3_modul1.github_user.frag.DetailFrag
import sidev.app.course.dicoding.bab3_modul1.github_user.model.User
import sidev.app.course.dicoding.bab3_modul1.github_user.util.Const
import sidev.lib.android.siframe.adapter.RvAdp
import sidev.lib.android.siframe.tool.util.`fun`.startSingleFragAct_config
import sidev.lib.android.std.tool.util.`fun`.imgRes

class Adp(c: Context): RvAdp<User, LinearLayoutManager>(c) {
    override val itemLayoutId: Int = R.layout.comp_item

    override fun bindVH(vh: SimpleViewHolder, pos: Int, data: User) {
        vh.itemView.apply {
            Glide.with(ctx)
                .load(data.avatarInt(ctx))
                .into(iv_profile)
            tv_name.text= data.name
            comp_repo.apply {
                tv.text= data.repository.toString()
                iv.imgRes = R.drawable.ic_repo
            }
            comp_follower.apply {
                tv.text= data.follower.toString()
                iv.imgRes = R.drawable.ic_follower
            }

            cv.setOnClickListener {
                ctx.startSingleFragAct_config<DetailFrag>(Const.DATA_USER to data)
            }
        }
    }

    override fun setupLayoutManager(context: Context): LinearLayoutManager =
        LinearLayoutManager(context)
}