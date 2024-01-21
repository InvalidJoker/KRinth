package me.invalidjoker.krinth.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class SearchData(
    val hits: List<ProjectHit>,
    val offset: Int,
    val limit: Int,
    @SerialName("total_hits")
    val totalHits: Int
)


@Serializable
data class ProjectHit(
    val slug: String,
    val title: String,
    val description: String,
    val categories: List<String>,

    @SerialName("client_side")
    val clientSide: String,

    @SerialName("server_side")
    val serverSide: String,

    @SerialName("project_type")
    val projectType: String,
    val downloads: Int,

    @SerialName("icon_url")
    val iconUrl: String,
    val color: Int,

    @SerialName("thread_id")
    val threadId: String? = null,

    @SerialName("monetization_status")
    val monetizationStatus: String? = null,

    @SerialName("project_id")
    val projectId: String,
    val author: String,

    @SerialName("display_categories")
    val displayCategories: List<String>,
    val versions: List<String>,
    val follows: Int,

    @SerialName("date_created")
    val dateCreated: String,

    @SerialName("date_modified")
    val dateModified: String,

    @SerialName("latest_version")
    val latestVersion: String,
    val license: String,
    val gallery: List<String>,

    @SerialName("featured_gallery")
    val featuredGallery: String?
)

@Serializable
enum class SortIndex {
    @SerialName("relevance")
    RELEVANCE,

    @SerialName("downloads")
    DOWNLOADS,

    @SerialName("follows")
    FOLLOWS,

    @SerialName("newest")
    NEWEST,

    @SerialName("updated")
    UPDATED
}


@Serializable
data class Facet(
    val type: String,
    val operation: String,
    val value: String
)