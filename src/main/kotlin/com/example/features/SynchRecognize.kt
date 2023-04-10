package com.example.features

import com.example.datamodels.ResultSTT
import com.example.model.FileConverter
import com.example.model.FileDownloader
import com.example.model.STT
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
fun Application.synchRecognize() {
    routing {
        get("/sinhrecognize") {
            val url: String = call.receiveText()

            val file = FileDownloader().downloadFile(url)
            val bytes = FileConverter().mp3ToWav(file)
            val result = STT().getSynchText(bytes)

            if (result == ""){
                call.respondText("")
            } else {
                val resultSTT: ResultSTT =
                    Json.decodeFromString(
                        """$result"""
                    )


                call.respondText(resultSTT.result)
            }

        }
    }
}
