package com.example.myjudiciaryapp

class Case {
    var name:String=""
    var email:String=""
    var phone:String=""
    var idNumber:String=""
    var case:String=""
    var id:String=""


    constructor(
        name: String,
        email: String,
        phone: String,
        idNumber: String,
        case: String,
        id: String
    ) {
        this.name = name
        this.email = email
        this.phone = phone
        this.idNumber = idNumber
        this.case = case
        this.id = id
    }
    constructor()
}