package kz.azamat.lessonarchmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.ProgressBar
import androidx.lifecycle.ViewModelProvider

import kz.azamat.lessonarchmvvm.mvvm.MainViewModel
import kz.azamat.lessonarchmvvm.mvvm.State

class MainActivity : AppCompatActivity() {

//    private val presenter = LoginPresenter()

    private lateinit var viewModel: MainViewModel
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        progressBar = findViewById(R.id.progressBar)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        val button = findViewById<Button>(R.id.login)
        button.setOnClickListener {
            viewModel.login("email", "1234")
        }

        viewModel.loginLiveData.observe(this) {
            when (it){
                is State.LoadState -> {
                    progressBar.visibility = VISIBLE
                }
                is State.SuccessState -> {
                    progressBar.visibility = GONE
                    button.text = it.name
                }
                is State.ErrorState -> {
                    it.message
                }
            }
        }

//        presenter.attach(this)
//        presenter.onLoginClick("sds", "dsd")
    }

    override fun onDestroy() {
        super.onDestroy()
//        presenter.detach()
    }
//
//    override fun showError() {
//
//    }
//
//    override fun showProgress() {
//
//    }
//
//    override fun hideProgress() {
//
//    }
//
//    override fun showUserData(user: User) {
//
//    }
}