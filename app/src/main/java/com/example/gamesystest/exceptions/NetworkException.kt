package com.example.gamesystest.exceptions

import java.io.IOException

open class NetworkException(val code : Int, message : String) : IOException(message)