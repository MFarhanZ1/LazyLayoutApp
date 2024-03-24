package com.hanz.listmahasiswa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hanz.listmahasiswa.ui.theme.ListMahasiswaTheme
import com.hanz.recyclerview.MahasiswaHomeContent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListMahasiswaTheme {
                MainListMahasiswa()
            }
        }
    }
}

val poppinsFontFamily = FontFamily(
    Font(R.font.poppins_medium),
    Font(R.font.poppins_bold, FontWeight.Bold),
    Font(R.font.poppins_italic, FontWeight.Normal)
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainListMahasiswa() {

    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Row (modifier = Modifier.fillMaxWidth().offset(-8.dp), verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Rounded.AccountCircle, contentDescription = null, modifier = Modifier.size(35.dp))
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            "Data Mahasiswa (TIF 4C)",
                            fontWeight = FontWeight.Medium,
                            fontSize = 20.sp,
                            fontFamily = poppinsFontFamily,
                            modifier = Modifier.height(30.dp)
                        )
                    }
                }
            )
        },
//        bottomBar = {
//            BottomAppBar(
//                containerColor = MaterialTheme.colorScheme.primaryContainer,
//                contentColor = MaterialTheme.colorScheme.primary,
//            ) {
//                Text(
//                    modifier = Modifier
//                        .fillMaxWidth(),
//                    textAlign = TextAlign.Center,
//                    text = "Bottom app bar",
//                )
//            }
//        },
        floatingActionButton = {
            FloatingActionButton(onClick = { }, containerColor = Color.Magenta) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
        ) {
            MahasiswaHomeContent(navigateToProfile = {})
        }
    }
}

@Preview(showBackground = true, uiMode = 0x20)
@Composable
fun MainListMahasiswaPreviewDarkMode(){
    ListMahasiswaTheme {
        MainListMahasiswa()
    }
}

@Preview(showBackground = true, uiMode = 0x10)
@Composable
fun MainListMahasiswaPreview(){
    ListMahasiswaTheme {
        MainListMahasiswa()
    }
}