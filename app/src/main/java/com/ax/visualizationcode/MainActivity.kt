package com.ax.visualizationcode

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInRoot
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.ax.visualizationcode.ui.theme.VisualizationCodeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VisualizationCodeTheme {
                ConnectViewsWithCurve()

//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
            }
        }
    }
}


@Composable
fun ConnectViewsWithCurve() {
    val firstPoint = Offset(100f, 200f)  // 第一个视图的位置
    val secondPoint = Offset(500f, 600f) // 第二个视图的位置

    Box(Modifier.fillMaxSize()) {
        // 第一个视图
        Box(
            Modifier
                .offset { IntOffset(firstPoint.x.toInt(), firstPoint.y.toInt()) }
                .size(100.dp)
                .background(androidx.compose.ui.graphics.Color.Yellow)
        )

        // 第二个视图
        Box(
            Modifier
                .offset { IntOffset(secondPoint.x.toInt(), secondPoint.y.toInt()) }
                .size(50.dp)
                .background(androidx.compose.ui.graphics.Color.Green)
        )

        // 绘制曲线
        Canvas(modifier = Modifier.fillMaxSize()) {
            val path = Path()

            // 移动到第一个视图的起始点
            path.moveTo(firstPoint.x + 150f, firstPoint.y + 150f)

            // 使用 quadraticBezierCurve 或 cubicBezierCurve 来绘制曲线
            // 这里使用 quadraticTo 来绘制简单的二次贝塞尔曲线
            val controlPoint =
                Offset((firstPoint.x + 150f + secondPoint.x + 150f) / 2, firstPoint.y + 150f - 200f)
            path.quadraticBezierTo(
                controlPoint.x,
                controlPoint.y,
                secondPoint.x + 75f,
                secondPoint.y + 75f
            )
//            path.quadTo()

            // 绘制路径
            drawPath(
                path,
                color = androidx.compose.ui.graphics.Color.Red,
                style = Stroke(width = 5f)
            )
        }
    }
}

@Composable
fun MainScreen() {
    val text1Position = remember { mutableStateOf(IntOffset.Zero) }
    val text2Position = remember { mutableStateOf(IntOffset.Zero) }
    Column {
        ConnectedComponents()
        DrawCurveBetweenComponents(
            text1Position.value,
            text2Position.value
        )
    }
}

@Composable
fun DrawCurveBetweenComponents(
    text1Position: IntOffset,
    text2Position: IntOffset
) {
    val curvePath = remember { Path() }
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            curvePath.reset()
            val start = Offset(text1Position.x.toFloat(), text1Position.y.toFloat())
            val end = Offset(text2Position.x.toFloat(), text2Position.y.toFloat())
            // 计算控制点，简单取中间位置示例，可按需调整
            val controlX = (text1Position.x + text2Position.x) / 2
            val controlY = (text1Position.y + text2Position.y) / 2
            val control = Offset(controlX.toFloat(), controlY.toFloat())
            curvePath.moveTo(start.x, start.y)
            curvePath.quadraticBezierTo(control.x, control.y, end.x, end.y)
            drawPath(
                path = curvePath,
                color = androidx.compose.ui.graphics.Color.Black,
                style = Stroke(),
            )
        }
    }
}

@Composable
fun ConnectedComponents() {
    val text1Position = remember { mutableStateOf(Offset.Zero) }
    val text2Position = remember { mutableStateOf(Offset.Zero) }
    Column {
        Text(
            text = "Text 1",
            modifier = Modifier
                .onGloballyPositioned { coordinates ->
                    text1Position.value = coordinates.positionInRoot()
                }
        )
        Text(
            text = "Text 2",
            modifier = Modifier
                .onGloballyPositioned { coordinates ->
                    text2Position.value = coordinates.positionInRoot()
                }
        )
    }
}

//
//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ConnectViewsWithCurve()
}