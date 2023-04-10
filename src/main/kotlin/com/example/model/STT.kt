package com.example.model

import com.example.consts.CloudKeys.FOLDER_ID
import com.example.consts.Urls
import com.example.datasource.synchRecognizer
import java.util.logging.Logger

class STT {
    val logger = Logger.getLogger("STT")

    fun getSynchText(content: ByteArray): String {
        logger.info("getSynchText start")

        var urlStr = Urls.url_speechkit
        val params = listOf(
            "topic=general",
            "folderId=$FOLDER_ID",
            "lang=en-EN",
            "format=lpcm",
            "sampleRateHertz=16000"
        )

        urlStr += params.joinToString("&")
        logger.info("getSynchText url: $urlStr")

        return synchRecognizer(urlStr, content)
    }
}

