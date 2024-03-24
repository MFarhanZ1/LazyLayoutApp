package com.hanz.recyclerview

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.tooling.preview.Preview
import com.hanz.listmahasiswa.data.DataProvider
import com.hanz.listmahasiswa.data.model.Mahasiswa

@Composable
fun MahasiswaHomeContent(navigateToProfile: (Mahasiswa) -> Unit) {

    val mahasiswa = remember {
        mutableListOf<Mahasiswa>().apply {
            addAll(DataProvider.listMahasiswa)
        }
    }

//    mahasiswa.add(Mahasiswa("1345667789", "Farhan Aulia", R.drawable.p12250113521))

    LazyColumn {
        items(
            items = mahasiswa.sortedBy {
                it.nama
            },
            itemContent = {
                MahasiswaListItem(mahasiswa = it, navigateToProfile)
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MahasiswaHomeContentPreview(){
    MahasiswaHomeContent({})
}