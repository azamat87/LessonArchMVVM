package kz.azamat.lessonarchmvvm.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kz.azamat.lessonarchmvvm.LoginRepository
import kz.azamat.lessonarchmvvm.UserData

class MainViewModel : ViewModel() {

    private val _loginLiveData = MutableLiveData<State>()
    val loginLiveData: LiveData<State>
        get() = _loginLiveData

    private val repository = LoginRepository()

    fun login(email: String, password: String) {
        _loginLiveData.value = State.LoadState

        repository.login(UserData(email, password)) {
            _loginLiveData.value = State.SuccessState("User")
        }
    }

}

sealed interface State {
    object LoadState : State
    data class SuccessState(val name: String): State
    data class ErrorState(val message: String): State
}
