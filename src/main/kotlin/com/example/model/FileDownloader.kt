package com.example.model

import com.example.datasource.download
import java.io.InputStream
import java.util.logging.Logger

class FileDownloader {
    val logger = Logger.getLogger("FileDownloader")

    suspend fun downloadFile(urlStr: String): InputStream{
        return download(urlStr)!!
    }
}
