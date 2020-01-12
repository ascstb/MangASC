package com.ascstb.mangasc.repository

sealed class ApiResult<out R> {
    class Error(val error: Exception) : ApiResult<Nothing>()
    class Ok<out R>(val result: R) : ApiResult<R>()
}

sealed class EmptyResult {
    class Err(val error: Exception) : EmptyResult()
    object Ok : EmptyResult()
}