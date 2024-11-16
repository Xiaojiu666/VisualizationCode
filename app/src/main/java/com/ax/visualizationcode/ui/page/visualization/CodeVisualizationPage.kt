package com.ax.visualizationcode.ui.page.visualization

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ax.visualizationcode.ui.page.home.RoundedBackgroundText


@Composable
fun VisualizationPage() {

}

@Composable
fun VisualizationItem() {
    Column(modifier = Modifier.padding(8.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {

            LazyRow {
                items(10) {
                    NumberIndexItem()
                }
            }
        }

        Row {

        }
    }
}

@Composable
fun NumberIndexItem() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .border(width = 1.dp, color = Color.White)
            .background(color = MaterialTheme.colorScheme.primary)
            .padding(4.dp)
    ) {
        Text("1", fontSize = 18.sp)

        Text("1", fontSize = 14.sp)
    }
}

@Preview
@Composable
private fun preVisualizationItem() {
    VisualizationItem()

//    NumberIndexItem()
}