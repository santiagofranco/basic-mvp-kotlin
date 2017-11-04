package com.santiagofranco.examplemvpkotlin.list

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.santiagofranco.examplemvpkotlin.R
import com.santiagofranco.examplemvpkotlin.entities.User
import kotlinx.android.synthetic.main.activity_main.*

class ListActivity : AppCompatActivity(), ListView {

    lateinit var presenter: ListPresenter
    override lateinit var listener: ListViewListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = createListModule(this)  //Simulating dependency injection

    }

    override fun onResume() {
        super.onResume()
        presenter.start()
    }

    override fun show(users: List<User>) {
        var usersText = ""
        users.forEach { user -> usersText += user.name + "\n" }
        usersTextView.text = usersText
    }

    override fun showErrorLoadingUsers() {
        Toast.makeText(this, "Error loading users", Toast.LENGTH_LONG).show()
    }

    override fun navigateToUser(user: User) {
        //TODO: start user detail activity
    }


}
