package com.hanz.recyclerview

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
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
import com.hanz.listmahasiswa.R
import com.hanz.listmahasiswa.data.DataProvider
import com.hanz.listmahasiswa.data.model.Mahasiswa
import com.hanz.listmahasiswa.ui.theme.ListMahasiswaTheme

@Composable
fun MahasiswaListItem(mahasiswa: Mahasiswa, navigateToProfile: (Mahasiswa) -> Unit) {
    Card(
        modifier = Modifier
            .background(Color.Gray)
            .padding(5.dp),
        shape = RoundedCornerShape(corner = CornerSize(15.dp)),
    ) {
        Row(
            Modifier
                .padding(8.dp)
                .clickable { navigateToProfile(mahasiswa) }) {
            MahasiswaImage(mahasiswa)
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 11.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Spacer (modifier = Modifier.width(2.dp))

                    Text(
                        text = mahasiswa.nama, fontSize = 23.sp, fontWeight = FontWeight.Bold,
                        overflow = TextOverflow.Ellipsis, maxLines = 1,
                        fontFamily = FontFamily(
                            Font(R.font.poppins_regular)
                        ),
                        letterSpacing = -0.4f.sp
                    )
                }

                Card(
                    shape = RoundedCornerShape(corner = CornerSize(10.dp))
                ) {

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

                        Spacer(modifier = Modifier.width(10.dp))

                    }
                }
            }
        }
    }
}

@Composable
private fun MahasiswaImage(mahasiswa: Mahasiswa) {
    Image(
        painter = painterResource(id = mahasiswa.idFotoMahasiswa),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(70.dp)
            .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
    )
}

@Preview
@Composable
fun PreviewMahasiswaItem() {
    val mahasiswa = DataProvider.listMahasiswa[4]
    ListMahasiswaTheme {
        MahasiswaListItem(mahasiswa = mahasiswa, navigateToProfile = {})
    }
}

@Preview(showBackground = true, uiMode = 0x20)
@Composable
fun PreviewMahasiswaItemDarkMode() {
    val mahasiswa = DataProvider.listMahasiswa[4]
    ListMahasiswaTheme {
        MahasiswaListItem(mahasiswa = mahasiswa, navigateToProfile = {})
    }
}
