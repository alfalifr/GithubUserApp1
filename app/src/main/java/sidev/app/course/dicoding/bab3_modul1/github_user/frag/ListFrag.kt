package sidev.app.course.dicoding.bab3_modul1.github_user.frag

import android.view.View
import kotlinx.android.synthetic.main.page_list.view.*
import sidev.app.course.dicoding.bab3_modul1.github_user.R
import sidev.app.course.dicoding.bab3_modul1.github_user.adp.Adp
import sidev.app.course.dicoding.bab3_modul1.github_user.util.Util

class ListFrag: StdFrag() {
    override val layoutId: Int = R.layout.page_list
    override val actBarTitle: String = "User List"
    override val isBackVisible: Boolean= false
    override val isLogoVisible: Boolean= true

    private lateinit var adp: Adp

    override fun _initView(layoutView: View) {
        adp= Adp(context!!)
        adp.dataList= Util.dataList(context!!)
        adp.rv= layoutView.rv
    }
}