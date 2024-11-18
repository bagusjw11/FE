package com.example.tugasil.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tugasfe.model.FakeGameData
import com.example.tugasfe.model.Game

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListPages(
    modifier: Modifier = Modifier,
    onItemClick: (Game) -> Unit
) {
    LazyColumn(modifier = Modifier.padding(start = 10.dp, end = 10.dp)) {
        item {
            TopAppBar(
                title = { Text(text = "Row And Column List") },
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = "Featured Games",
                modifier = Modifier.padding(16.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            LazyRow {
                items(FakeGameData.dummyGames) { game ->
                    GameItem(game = game, onItemClick = { onItemClick(game) })
                    Spacer(modifier = Modifier.width(5.dp))
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "All Games",
                modifier = Modifier.padding(16.dp)
            )
        }
        items(FakeGameData.dummyGames) { game ->
            GameItem(game = game, onItemClick = { onItemClick(game) })
            Spacer(modifier = Modifier.width(5.dp))
        }
    }
}

@Composable
fun GameItem(game: Game, onItemClick: () -> Unit) {
    Row(
        modifier = Modifier
            .height(150.dp)
            .fillMaxWidth()
            .clickable(onClick = onItemClick)
            .border(width = 1.dp, color = Color.Black)
            .background(color = Color(0xFFD0D1D0)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = game.image),
            contentDescription = game.title,
            modifier = Modifier.padding(start = 10.dp).height(150.dp).width(75.dp)
        )
        Text(
            text = game.title,
            style = TextStyle(
                fontSize = 24.sp,
                lineHeight = 27.sp,
                fontWeight = FontWeight(700),
                color = Color(0xFF141916),
            ),
            modifier = Modifier.padding(start = 10.dp)
        )
    }
}
