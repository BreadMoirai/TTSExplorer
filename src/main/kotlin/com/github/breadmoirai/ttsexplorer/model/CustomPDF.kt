package com.github.breadmoirai.ttsexplorer.model

import com.squareup.moshi.Json

data class CustomPDF(
    @Json(name = "PDFUrl") var pdfUrl: String,
    @Json(name = "PDFPassword") var pdfPassword: String,
    @Json(name = "PDFPage") var pdfPage: Int,
    @Json(name = "PDFPageOffset") var pdfPageOffset: Int
)