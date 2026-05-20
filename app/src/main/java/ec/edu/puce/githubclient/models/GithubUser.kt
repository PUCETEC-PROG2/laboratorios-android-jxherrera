package ec.edu.puce.githubclient.models

import com.google.gson.annotations.SerializedName

data class GithubUser (
    val id: String,
    val login: String,
    @SerializedName(value = "avatar_Url")
    val avatarUrl: String

)