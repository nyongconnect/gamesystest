package com.example.gamesystest.exceptions

class ServerException(code: Int, message: String) : NetworkException(code, message)