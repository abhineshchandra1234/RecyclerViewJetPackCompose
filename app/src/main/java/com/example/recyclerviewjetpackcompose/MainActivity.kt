package com.example.recyclerviewjetpackcompose

import android.content.ClipData.Item
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.recyclerviewjetpackcompose.ui.theme.RecyclerViewJetPackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            ScrollableColumnDemo()
            LazyColumnDemo {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }
//            LazyVerticalGridDemo()
        }
    }
}

@Composable
fun ScrollableColumnDemo() {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier.verticalScroll(scrollState)
    ) {
        for(i in 1..100) {
            Text(text = "This is person $i", style = MaterialTheme.typography.h3,
                modifier = Modifier.padding(10.dp)
                )
            Divider(color = Color.Black, thickness = 5.dp)
        }
    }
}

@Composable
fun LazyColumnDemo(selectedItem: (String)->Unit) {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        items(100) {
            Text(text = "This is person $it", style = MaterialTheme.typography.h3,
                modifier = Modifier
                    .padding(10.dp)
                    .clickable { selectedItem("selected $it person") }
                )
            Divider(color = Color.Black, thickness = 5.dp)
        }
    }
}

@Composable
fun LazyVerticalGridDemo() {

    LazyVerticalGrid(columns = GridCells.Adaptive(minSize = 128.dp),
        contentPadding = PaddingValues(
        start = 12.dp,
        top = 16.dp,
        end = 12.dp,
        bottom = 16.dp
    ),
        content = {
        items(100) {
            Card(
                backgroundColor = Color.Red,
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth(),
                elevation = 8.dp,
            ) {
                Text(
                    text = "$it",
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    color = Color(0xFFFFFFFF),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    })
}

