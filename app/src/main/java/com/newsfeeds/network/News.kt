package com.newsfeeds.network

class News {
    enum class Category(private val value: String) {
        BUSINESS("business");

        override fun toString(): String {
            return value
        }
    }

    enum class Country(private val value: String) {
        INDIA("in");

        override fun toString(): String {
            return value
        }
    }
}