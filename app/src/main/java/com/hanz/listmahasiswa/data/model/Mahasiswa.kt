package com.hanz.listmahasiswa.data.model

import java.io.Serializable

data class Mahasiswa(
    val nim: String,
    val nama: String,
    val idFotoMahasiswa: Int = 0
) : Serializable
