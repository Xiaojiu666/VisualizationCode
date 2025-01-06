package com.ax.visualizationcode.ui.page.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ax.visualizationcode.UiState
import com.ax.visualizationcode.ui.vm.MainViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage() {
    val viewModel = viewModel<MainViewModel>()
    val topicState =
        viewModel.topicState.collectAsStateWithLifecycle() as UiState.Successful<MainViewModel.TopicState>
    var presses by remember { mutableIntStateOf(0) }
    Scaffold(
        topBar = {
            TopBar()
        },
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary,
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = "Bottom app bar",
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { presses++ }) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .background(
                    color = MaterialTheme.colorScheme.primary
                ),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            items(
                topicState.data.topicList ?: arrayListOf()
            ) {
                CodeItem(it.title)
            }
        }
    }
}

@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .requiredHeight(100.dp)
            .background(color = MaterialTheme.colorScheme.primary)
    ) {
        Text(
            "Day 011",
            modifier = Modifier.padding(20.dp, 20.dp),
            color = MaterialTheme.colorScheme.onPrimary,
            fontSize = 28.sp
        )
    }
}


@Composable
fun CodeItem(title: String, level: Int = 0, state: Boolean = false) {
    Column(modifier = Modifier.padding(8.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            RoundedBackgroundText("简单")

            Text(
                text = title, color = MaterialTheme.colorScheme.onPrimary,
                fontSize = 16.sp
            )
        }

        Row {

        }
    }
}

@Composable
fun RoundedBackgroundText(text: String) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .background(
                color = Color.LightGray,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(6.dp, 4.dp) // 内边距，让文字与背景有一定间距
    ) {
        Text(
            text = text,
            color = Color.Yellow,
            fontSize = 8.sp
        )
    }
}

@Preview
@Composable
private fun PreCodeItem() {
    CodeItem("1.两数之和")
}

@Preview
@Composable
private fun PreHomePage() {

    HomePage()
}
