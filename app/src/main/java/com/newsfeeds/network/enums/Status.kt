package com.newsfeeds.network.enums


enum class Status(private val value: String) {
    OK("ok"),
    ERROR("error");

    override fun toString(): String {
        return value
    }}