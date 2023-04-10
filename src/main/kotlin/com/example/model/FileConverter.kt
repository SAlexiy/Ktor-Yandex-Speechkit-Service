package com.example.model

import com.sipgate.mp3wav.Converter
import java.io.*
import java.util.logging.Logger
import javax.sound.sampled.AudioFormat

class FileConverter {
    val logger = Logger.getLogger("FileConverter")

    fun mp3ToWav(inputStream: InputStream): ByteArray {
        logger.info("mp3ToWav")
        val output: ByteArrayOutputStream  =  ByteArrayOutputStream()
        val audioFormat = AudioFormat(16000f, 16, 1, true, false)

        Converter.convertFrom(inputStream).withTargetFormat(audioFormat).to(output)

        return output.toByteArray()
    }
}
