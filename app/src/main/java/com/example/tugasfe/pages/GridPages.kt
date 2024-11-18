package com.example.tugasil.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
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
fun GridPages(
    modifier: Modifier = Modifier,
    onItemClick: (Game) -> Unit
) {
    Column {

        TopAppBar(
            title = { Text(text = "Grid") },
            modifier = Modifier.fillMaxWidth()
        )
        LazyVerticalGrid(
            modifier = modifier.padding(start = 10.dp, end = 10.dp),
            columns = GridCells.Fixed(2)
        ) {
            items(FakeGameData.dummyGames) { game ->
                GamesItem(game = game, onItemClick = { onItemClick(game)})
            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GamesItem(game: Game, onItemClick: () -> Unit) {
    Column(
        modifier = Modifier
            .height(200.dp)
            .fillMaxWidth()
            .clickable(onClick = onItemClick)
            .border(width = 1.dp, color = Color.Black)
            .background(color = Color(0xFFD0D1D0)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = game.image),
            contentDescription = game.title,
            modifier = Modifier
                .padding(start = 10.dp)
                .size(120.dp)
        )
        Text(
            text = game.title,
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight(700),
                color = Color(0xFF141916),
            ),
            modifier = Modifier.padding(start = 10.dp)
        )
    }
}
