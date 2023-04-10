package com.example.datasource

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException
import java.io.InputStream
import java.net.URL

suspend fun download(urlStr: String): InputStream? = withContext(Dispatchers.IO) {
    var inputStream: InputStream? = null

    try {
        val url = URL(urlStr)

        val connection = url.openConnection()
        inputStream = connection.getInputStream()

    } catch (e: IOException) {
        e.printStackTrace()
    }

    return@withContext inputStream
}