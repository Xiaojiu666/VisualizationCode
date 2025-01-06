package com.ax.visualizationcode.ui.page.visualization

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ax.visualizationcode.UiState
import com.ax.visualizationcode.ui.vm.MainViewModel


@Composable
fun VisualizationPage() {

    Row(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .fillMaxHeight()
        ) { VisualizationItem() }
        Column(modifier = Modifier.fillMaxSize(0.5f)) { }
    }
}

@Composable
fun VisualizationItem() {
    Column(modifier = Modifier.padding(8.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {

            LazyColumn {
                items(10) {
                    InstanceItem()
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
        Text("30", fontSize = 18.sp)

        Text("1", fontSize = 14.sp)
    }
}

@Composable
fun InstanceItem() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.primary)
    ) {
        Text(
            "name", fontSize = 16.sp, modifier = Modifier
                .drawBehind {
                    drawBottomBorder(Color.White, 2f)
                }
                .padding(4.dp)

        )

        Text("1", fontSize = 16.sp, modifier = Modifier
            .drawBehind {
                drawBottomBorder(Color.White, 2f)
                drawLeftBorder(Color.White, 2f)
            }
            .padding(4.dp))
    }
}


fun DrawScope.drawLeftBorder(borderColor: Color, borderWidth: Float) {
    // 绘制左部边框
    drawLine(
        color = borderColor,
        start = Offset(0f, 0f),  // 起始点：Box的底部左侧
        end = Offset(0f, size.height),  // 结束点：Box的底部右侧
        strokeWidth = borderWidth  // 设置边框宽度
    )
}

fun DrawScope.drawBottomBorder(borderColor: Color, borderWidth: Float) {
    // 绘制底部边框
    drawLine(
        color = borderColor,
        start = Offset(0f, size.height),  // 起始点：Box的底部左侧
        end = Offset(size.width, size.height),  // 结束点：Box的底部右侧
        strokeWidth = borderWidth  // 设置边框宽度
    )
}

@Preview
@Composable
private fun preVisualizationItem() {
//    VisualizationItem()
//    InstanceItem()
//    NumberIndexItem()
    VisualizationPage()
}