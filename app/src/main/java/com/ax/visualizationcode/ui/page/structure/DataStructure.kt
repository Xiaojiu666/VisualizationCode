package com.ax.visualizationcode.ui.page.structure

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.ax.visualizationcode.ui.entity.ArrayEntity
import com.ax.visualizationcode.ui.entity.MapEntity


@Composable
fun <T> StructureArray(arrayList: List<ArrayEntity<T>>) {
    LazyRow {
        itemsIndexed(arrayList) { index, item ->
            DataArrayItem(item, index)
        }
    }
}

@Composable
fun <K, V> StructureMap(mapEntities: List<MapEntity<K, V>>) {
    LazyColumn {
        itemsIndexed(mapEntities) { index, item ->
            DataMapItem(item)
            HorizontalDivider()
        }
    }
}


@Preview
@Composable
private fun PreviewStructureArray() {
    val items = listOf(ArrayEntity("Item 1"), ArrayEntity("Item 2"))
    StructureArray(items)
}

@Preview
@Composable
private fun PreviewStructureMap() {
    val items = listOf(MapEntity("123", "Item 1", "aaa"),
        MapEntity("456", "Item 2", "aaa"))
    StructureMap(items)
}