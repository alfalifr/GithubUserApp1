package sidev.app.course.dicoding.bab3_modul1.github_user.app

import sidev.app.course.dicoding.bab3_modul1.github_user.act.SingleFragAct
import sidev.lib.android.siframe.tool.util.`fun`.setSingleFragAct
import sidev.lib.android.siframe.lifecycle.app.App as SiApp

class App: SiApp() {
    init {
        setSingleFragAct(SingleFragAct::class.java, false)
    }
}