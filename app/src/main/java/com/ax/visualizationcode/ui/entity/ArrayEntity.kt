package com.ax.visualizationcode.ui.entity

data class ArrayEntity<T>(val data: T)


data class MapEntity<K, V>(val key: K, val data: V, val memoryAddress: String)