package com.santiagofranco.examplemvpkotlin.list

import com.santiagofranco.examplemvpkotlin.entities.User


interface ListRepository {

    fun getUsers(success: (List<User>) -> Unit, error: (String) -> Unit)

}

interface ListView {

    var listener: ListViewListener

    fun show(users: List<User>)
    fun showErrorLoadingUsers()
    fun navigateToUser(user: User)

}

interface ListViewListener {

    fun onUserClick(user: User)

}

fun createListModule(view: ListView): ListPresenter {

    return ListPresenter(view, ListRepositoryImpl())

}