package sidev.app.course.dicoding.bab3_modul1.github_user.frag

import android.view.View
import androidx.annotation.CallSuper
import kotlinx.android.synthetic.main.comp_act_bar.view.*
import org.jetbrains.anko.support.v4.act
import sidev.app.course.dicoding.bab3_modul1.github_user.R
import sidev.lib.android.siframe.lifecycle.fragment.ActBarFrag

abstract class StdFrag: ActBarFrag() {
    final override val actBarId: Int = R.layout.comp_act_bar
    abstract val actBarTitle: String

    open val isBackVisible= true
    open val isLogoVisible= false
    open val isOptionVisible= false

    @CallSuper
    override fun _initActBar(actBarView: View) {
        actBarView.apply {
            iv_back.apply {
                visibility= if(isBackVisible) View.VISIBLE else View.GONE
                setOnClickListener { act.onBackPressed() }
            }
            iv_option.visibility= if(isOptionVisible) View.VISIBLE else View.GONE
            iv_logo.visibility= if(isLogoVisible) View.VISIBLE else View.GONE
            tv_title.text= actBarTitle
        }
    }
}