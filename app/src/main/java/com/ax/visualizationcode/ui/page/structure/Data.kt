package com.ax.visualizationcode.ui.page.structure

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ax.visualizationcode.ui.entity.ArrayEntity
import com.ax.visualizationcode.ui.entity.MapEntity


@Composable
fun <T> DataArrayItem(data: ArrayEntity<T>, index: Int) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(Color.White)
            .widthIn(10.dp, 100.dp),
    ) {
        Text(modifier = Modifier.padding(2.dp), text = data.data.toString())

        HorizontalDivider(
            modifier = Modifier.fillMaxWidth(),
            color = Color.Black
        )

        Text(modifier = Modifier.padding(2.dp), text = index.toString())
    }
}

@Composable
fun <K, V> DataMapItem(map: MapEntity<K, V>) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .background(Color.White)
            .heightIn(10.dp, 100.dp),
    ) {
        Text(modifier = Modifier.padding(2.dp), text = map.key.toString())

        VerticalDivider(
            modifier = Modifier.fillMaxHeight(),
            color = Color.Black
        )

        Text(modifier = Modifier.padding(2.dp), text = map.data.toString())
    }
}


@Preview
@Composable
private fun PreviewDataArrayItem() {
    DataArrayItem(ArrayEntity("A"), 1)
}

@Preview
@Composable
private fun PreviewDataMapItem() {
    DataMapItem(MapEntity("A", "BAAAAAAAAAAAAA","hahah"))
}