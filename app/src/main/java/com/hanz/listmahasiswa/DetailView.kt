package com.hanz.listmahasiswa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hanz.listmahasiswa.data.model.Mahasiswa
import com.hanz.listmahasiswa.ui.theme.ListMahasiswaTheme

@Suppress("DEPRECATION")
class DetailView : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListMahasiswaTheme {
                DetailViewMhs(mahasiswa = intent.getSerializableExtra("objMhs") as Mahasiswa)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailViewMhs(mahasiswa: Mahasiswa) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
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
                            "Detail Mahasiswa (TIF 4C)",
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
            Column (
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Spacer(modifier = Modifier.height(17.dp))
                MahasiswaImage(mahasiswa)

                Spacer(modifier = Modifier.height(13.dp))

                Text (text = mahasiswa.nama,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    overflow = TextOverflow.Ellipsis, maxLines = 1,
                    fontFamily = FontFamily(
                        Font(R.font.poppins_regular)
                    ),
                    letterSpacing = (-0.4f).sp
                )

                Row(
                    modifier =
                    Modifier
                        .background(Color.Yellow).height(30.dp)
                        .clip(RoundedCornerShape(corner = CornerSize(16.dp))),
                ) {

                    Spacer(modifier = Modifier.width(5.dp))

                    Icon(
                        Icons.Rounded.CheckCircle,
                        contentDescription = null,
                        modifier = Modifier.size(25.dp).offset(y = 3.dp),
                        tint = Color.Black
                    )

                    Spacer(modifier = Modifier.width(2.dp))

                    Text(
                        text = mahasiswa.nim, fontSize = 22.sp,
                        color = Color.Black,
                        fontFamily = FontFamily(
                            Font(R.font.poppins_regular)
                        )
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailViewMhsPreview() {
    ListMahasiswaTheme {
        DetailViewMhs(Mahasiswa("12250113521", "M. Farhan Aulia Pratama", R.drawable.p12250113521))
    }
}

@Composable
private fun MahasiswaImage(mahasiswa: Mahasiswa) {
    Image(
        painter = painterResource(id = mahasiswa.idFotoMahasiswa),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(350.dp)
            .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
    )
}