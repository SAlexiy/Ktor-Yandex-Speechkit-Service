package com.example.datasource

import com.example.consts.CloudKeys.API_KEY
import java.net.HttpURLConnection
import java.net.URL
import java.util.*
import java.util.logging.Logger

fun synchRecognizer(urlStr: String, content: ByteArray): String {
    val logger = Logger.getLogger("synchRecognizer")
    val url = URL(urlStr)

    val connection = url.openConnection() as HttpURLConnection
    connection.requestMethod = "POST"
    connection.setRequestProperty("Authorization", "Api-Key $API_KEY")
    connection.doOutput = true
    connection.outputStream.write(content)


    val responseCode = connection.responseCode

    logger.info(responseCode.toString())
    logger.info(connection.responseMessage)

    if (responseCode == HttpURLConnection.HTTP_OK) {
        val scanner = Scanner(connection.inputStream)
        val response = StringBuilder()

        while (scanner.hasNextLine()) {
            response.append(scanner.nextLine())
        }

        scanner.close()

        logger.info(response.toString())
        return response.toString()
    }

    return ""
}