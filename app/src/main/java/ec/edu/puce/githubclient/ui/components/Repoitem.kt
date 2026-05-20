package ec.edu.puce.githubclient.ui.components

import android.R
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import ec.edu.puce.githubclient.models.GithubUser
import ec.edu.puce.githubclient.models.Repository
import org.intellij.lang.annotations.Language

@Composable
fun RepoItem (
    repository: Repository
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding( all = 8.dp)
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding( all = 16.dp)
        ) {
            AsyncImage(
                model = repository.owner.avatarUrl,
                contentDescription = "Imagen de $repository.name",
                modifier = Modifier.size(68.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width( width = 16.dp))

            Column {
                Text(
                    text = repository.name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height( height = 4.dp))

                if (!repository.description.isNullOrBlank()) {
                    Text(
                        text = repository.description,
                        style = MaterialTheme.typography.bodySmall,
                    )
                }

                Spacer(modifier = Modifier.height( height = 4.dp))

                if (!repository.language.isNullOrBlank()) {
                    Text(
                        text = repository.language,
                        style = MaterialTheme.typography.labelSmall,

                        )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RepoItemPreview () {
    val repository = Repository(
        id = "1234",
        name = "Repositorio de android",
        description = "Repositorio paralelo 1471",
        language = "Kotlin",
        owner = GithubUser(
            id = "123",
            login = "jxherrera",
            avatarUrl = "https://www.google.com/url?sa=t&source=web&rct=j&url=https%3A%2F%2Fes.wikipedia.org%2Fwiki%2FBarcelona_Sporting_Club&ved=0CBYQjRxqFwoTCKDR55rZyJQDFQAAAAAdAAAAABAG&opi=89978449"
        )
    )
    RepoItem(repository)
}