package com.ax.visualizationcode.ui.page.visualization

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// 定义一些简单的颜色用于模拟语法高亮（可根据实际需求调整更接近Android Studio的配色）
val keywordColor = Color.Blue
val methodNameColor = Color.Green
val normalTextColor = Color.Black

@Composable
fun CodeArea() {
    val code = "fun main() {\n" +
            "    val num = 10\n" +
            "    println(num)\n" +
            "    val result = add(num, 5)\n" +
            "    println(result)\n" +
            "}\n" +
            "\n" +
            "fun add(a: Int, b: Int): Int {\n" +
            "    return a + b\n" +
            "}\n"
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        // 占屏幕一半高度（这里简单设置为屏幕高度的一半，可根据实际情况优化）
        val halfHeight = 300.dp
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(halfHeight)
                .background(Color.White)
                .padding(8.dp)
        ) {
            val lines = code.split("\n")
            for (i in lines.indices) {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    // 显示行数
                    Text(
                        text = "${i + 1}  ",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = normalTextColor,
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    // 处理代码文本并展示，进行简单语法高亮
                    val annotatedCode = highlightCode(lines[i])
                    BasicText(
                        text = annotatedCode,
                        modifier = Modifier.fillMaxWidth(),
                    )
                }
            }
        }
    }
}

fun highlightCode(code: String): AnnotatedString {
    val keywords = listOf("fun", "val", "return", "if", "else", "for", "while")
    val lines = code.split("\n")
    val annotatedString = buildAnnotatedString {
        for (line in lines) {
            val parts = line.split(" ")
            for (part in parts) {
                val spanStyle = when {
                    keywords.contains(part) -> SpanStyle(color = keywordColor)
                    part.contains("(") && part.contains(")") -> SpanStyle(color = methodNameColor)
                    else -> SpanStyle(color = normalTextColor)
                }
                append(part)
                addStyle(spanStyle, length - part.length, length)
                append(" ")
            }
            append("\n")
        }
    }
    return annotatedString
}


@Preview
@Composable
private fun PreviewCodeArea() {
    CodeArea()
}