package sidev.app.course.dicoding.bab3_modul1.github_user.act

import android.view.View
import sidev.app.course.dicoding.bab3_modul1.github_user.R
import sidev.app.course.dicoding.bab3_modul1.github_user.frag.ListFrag
import sidev.lib.android.siframe.lifecycle.activity.Act
import sidev.lib.android.siframe.tool.util.`fun`.startSingleFragAct_config
import sidev.lib.android.std.tool.util._ThreadUtil

class SplashAct: Act() {
    override val layoutId: Int = R.layout.page_splash
    override val styleId: Int = R.style.NoActionBar

    override fun _initView(layoutView: View) {
        _ThreadUtil.delayRun(2000){
            startSingleFragAct_config<ListFrag>()
            finish()
        }
    }
}