package exa.sa.myappwael.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CategoryScreen(categoryName: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "عرض المنتجات لـ: $categoryName",
            style = MaterialTheme.typography.headlineSmall
        )
        // يمكنك هنا إضافة قائمة بالمنتجات بناءً على المجموعة
    }
}
