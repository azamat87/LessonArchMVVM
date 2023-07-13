package kz.azamat.lessonarchmvvm

import android.os.Handler

class LoginRepository constructor() {

    fun login(user: UserData, callback:() -> Unit) {

        Handler().postDelayed({
            callback.invoke()
        }, 5000)
    }
}

class DataSource

class CloudSource

data class UserData(val email: String, val password: String)