package com.example.bf_kotlin_client.apiworkers

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.ImageFormat
import android.media.Image
import android.media.ImageReader
import com.android.volley.Request
import com.example.bf_kotlin_client.dtos.requests.AppAuthRequest
import com.example.bf_kotlin_client.utils.GlobalVariables
import com.google.gson.Gson
import java.io.ByteArrayInputStream

class ImageApiWorker {
    /*fun getImage(path:String,successCallbackFunction: (Bitmap) -> Unit) {
        val httpMethod = Request.Method.GET
        val apiKey = GlobalVariables.instance.apiKey
        val deviceId = GlobalVariables.instance.androidId
        val url = "http://151.248.113.116:8080/mobile/productsCategories/getPictureByName/$path"

        val httpWorker = GlobalVariables.instance.httpWorker

        httpWorker.makeImageRequestWithBody(url,successCallbackFunction, request,mutableMapOf("API_KEY" to apiKey, "DEVICE_ID" to deviceId))
    }*/

}