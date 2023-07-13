package kz.azamat.lessonarchmvvm.mvp

interface View {
    fun showError()
    fun showProgress()
    fun hideProgress()
    fun showUserData(user: User)
}

interface Presenter {
    fun attach(view: View)
    fun detach()
    fun onLoginClick(login: String, password: String)
}

class LoginPresenter : Presenter {

    private var view: View?= null
//    private val repo = LoginRepository()

    override fun attach(view: View) {
        this.view = view
    }

    override fun detach() {
        view = null
    }

    override fun onLoginClick(login: String, password: String) {
        view?.showProgress()
//        val response = repo.login()
//        response
//        view?.showUserData(User())
    }

}

//class LoginRepository() {
//
//    private val rest = RestClient()
//
//    fun login() : Response{
//        val response = rest.login()
//        return response
//    }
//
//}



data class User(val id: String, val name: String)