package com.example.tugasil.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tugasfe.R
import com.example.tugasfe.ui.theme.TugasFETheme
//import com.example.tugasil.R
//import com.example.tugasil.ui.theme.TugasILTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutPages(modifier: Modifier){
    Column(modifier.fillMaxWidth().padding(top = 30.dp)) {
        TopAppBar(
            title = { Text(text = "About") },
            modifier = Modifier.fillMaxWidth()
        )
        Image(
            painter = painterResource(id = R.drawable.amdy),
            modifier = Modifier
                .size(160.dp)
                .clip(CircleShape)
                .align(Alignment.CenterHorizontally),
            contentDescription = "image description",
            contentScale = ContentScale.FillBounds
        )
        Text(
            text = "Nama",
            modifier.padding(start = 20.dp, top = 66.dp),
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF6B7280),
            )
        )
        Text(
            text = "Amdy Kuzuma",
            modifier.padding(start = 20.dp, top = 10.dp),
            style = TextStyle(
                fontSize = 18.sp,
                lineHeight = 27.sp,
                color = Color(0xFF7F8590),

                )
        )
        Text(
            text = "Email",
            modifier.padding(start = 20.dp, top = 34.dp),
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF6B7280),
            )
        )
        Text(
            text = "amdykuzuma129@gmail.com",
            modifier.padding(start = 20.dp, top = 10.dp),
            style = TextStyle(
                fontSize = 18.sp,
                lineHeight = 27.sp,
                color = Color(0xFF7F8590),

                )
        )
        Text(
            text = "Asal Perguruan Tinggi",
            modifier.padding(start = 20.dp, top = 34.dp),
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF6B7280),
            )
        )
        Text(
            text = "Universitas Bumigora",
            modifier.padding(start = 20.dp, top = 10.dp),
            style = TextStyle(
                fontSize = 18.sp,
                lineHeight = 27.sp,
                color = Color(0xFF7F8590),

                )
        )
        Text(
            text = "Jurusan",
            modifier.padding(start = 20.dp, top = 34.dp),
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF6B7280),
            )
        )
        Text(
            text = "Ilmu Komputer",
            modifier.padding(start = 20.dp, top = 10.dp),
            style = TextStyle(
                fontSize = 18.sp,
                lineHeight = 27.sp,
                color = Color(0xFF7F8590),

                )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AboutPreview() {
    TugasFETheme {
       AboutPages(modifier = Modifier)
    }
}