package com.newsfeeds.network.enums

class News {
    enum class Category(private val value: String, private val id: Int) {
        BUSINESS("business", 1);

        override fun toString(): String {
            return value
        }

        fun getId() = id
    }

    enum class Country(private val value: String) {
        INDIA("in");

        override fun toString(): String {
            return value
        }
    }
}