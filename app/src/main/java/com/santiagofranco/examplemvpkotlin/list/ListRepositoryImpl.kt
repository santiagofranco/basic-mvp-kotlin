package com.santiagofranco.examplemvpkotlin.list

import com.santiagofranco.examplemvpkotlin.entities.User


class ListRepositoryImpl : ListRepository {

    override fun getUsers(success: (List<User>) -> Unit, error: (String) -> Unit) {

        //Simulating access to API or local data storage
        val users = (1..10).map { User(it, "User $it") }
        success(users)

        //if something wrong
        //error("Something went wrong")
    }
}