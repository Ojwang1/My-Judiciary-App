package com.example.myjudiciaryapp

class Court {
    var CourtName:String=""
    var CourtLocation:String=""
    var CourtRoom:String=""
    var Date:String=""
    var Time:String=""

    constructor(
        CourtName: String,
        CourtLocation: String,
        CourtRoom: String,
        Date: String,
        Time: String
    ) {
        this.CourtName = CourtName
        this.CourtLocation = CourtLocation
        this.CourtRoom = CourtRoom
        this.Date = Date
        this.Time = Time
    }
    constructor()
}