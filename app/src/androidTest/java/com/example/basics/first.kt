package com.example.basics

fun main(){
    println("Hello")
    println("Everyone")

    //mutable
    var name = "Ram"

    //Immutable
    val age = 21

    var name2 : String = "santosh"
    var age2 : Int = 22
    var terms : Boolean = false

    println("The name is ${name2.uppercase()} and his age is $age2")

    var age3 = arrayOf<Int>(10,20) //Size fixed
    var age5 = arrayOf<Any>(10,20,"Santosh",false,"Shrestha")
    age3[0] = 50
    println("The first element is ${age3[0]}")

    var age4 = ArrayList<Int>()

    




}