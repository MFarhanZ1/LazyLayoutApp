package com.hanz.listmahasiswa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hanz.listmahasiswa.ui.theme.ListMahasiswaTheme

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
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                            .offset((-8).dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            Icons.Rounded.AccountCircle,
                            contentDescription = null,
                            modifier = Modifier.size(35.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            "Data Mahasiswa (TIF 4C)",
                            fontWeight = FontWeight.Medium,
                            fontSize = 22.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_medium)),
                            modifier = Modifier.height(33.dp)
                        )
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {

                },
                containerColor = Color.Magenta
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
        ) {
            MahasiswaHomeContent()
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