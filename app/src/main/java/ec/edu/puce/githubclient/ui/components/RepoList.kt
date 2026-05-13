package ec.edu.puce.githubclient.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable

@Composable
fun RepoList() {
    Column {
            RepoItem(
                name = "Repositorio de Android",
                description = "Repositorio creado en Kotlin",
                avatarUrl = "https://example.com/image.png",
                language = "Kotlin"
            )
        RepoItem(
            name = "Repositorio de Android",
            description = "Repositorio creado en Kotlin",
            avatarUrl = "https://example.com/image.png",
            language = "Java"
        )
        RepoItem(
            name = "Repositorio de Android",
            description = "Repositorio creado en Kotlin",
            avatarUrl = "https://example.com/image.png",
            language = "C++"
        )
        RepoItem(
            name = "Repositorio de Android",
            description = "Repositorio creado en Kotlin",
            avatarUrl = "https://example.com/image.png",
            language = "Py"
        )
        RepoItem(
            name = "Repositorio de Android",
            description = "Repositorio creado en Kotlin",
            avatarUrl = "https://example.com/image.png",
            language = "Kotlin"
        )
        }
    }
}