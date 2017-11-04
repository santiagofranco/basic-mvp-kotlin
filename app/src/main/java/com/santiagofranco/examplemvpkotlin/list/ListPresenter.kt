package com.santiagofranco.examplemvpkotlin.list

import com.santiagofranco.examplemvpkotlin.entities.User


class ListPresenter(private val view: ListView, private val listRepo: ListRepository) : ListViewListener {


    fun start() {
        view.listener = this
        listRepo.getUsers({ users -> view.show(users)}, { _ -> view.showErrorLoadingUsers() } )
    }


    override fun onUserClick(user: User) {
        view.navigateToUser(user)
    }

}

