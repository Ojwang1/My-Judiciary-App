package com.example.myjudiciaryapp

class Clerk {
    var name:String=""
    var email:String=""
    var id:String=""
    var phone:String=""
    var password:String=""
    var time:String=""

    constructor(name: String, email: String, id: String, phone: String, password: String,  time:String) {
        this.name = name
        this.email = email
        this.id = id
        this.phone = phone
        this.password = password
        this.time = time
    }
    constructor()
}