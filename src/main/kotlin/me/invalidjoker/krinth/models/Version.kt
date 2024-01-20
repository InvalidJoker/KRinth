package me.invalidjoker.krinth.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VersionDependency(
    val projectId: String,
    val versionRange: String
)

@Serializable
data class VersionFileHashes(
    val sha1: String,
    val sha512: String
)

@Serializable
enum class FileType {
    @SerialName("required-resource-pack")
    REQUIRED_RESOURCE_PACK,

    @SerialName("optional-resource-pack")
    OPTIONAL_RESOURCE_PACK
}

@Serializable
data class VersionFile(
    @SerialName("hashes")
    val hashes: VersionFileHashes,

    val url: String,
    val filename: String,

    val primary: Boolean,
    val size: Int,

    @SerialName("file_type")
    val fileType: FileType?
)


@Serializable
enum class VersionType {
    @SerialName("release")
    RELEASE,

    @SerialName("beta")
    BETA,

    @SerialName("alpha")
    ALPHA
}

@Serializable
enum class VersionStatus {
    @SerialName("listed")
    LISTED,

    @SerialName("archived")
    ARCHIVED,

    @SerialName("draft")
    DRAFT,

    @SerialName("unlisted")
    UNLISTED,

    @SerialName("scheduled")
    SCHEDULED,

    @SerialName("unknown")
    UNKNOWN
}

@Serializable
data class Version(
    val name: String,
    @SerialName("version_number")
    val versionNumber: String,
    val changelog: String?,
    val dependencies: List<VersionDependency>,
    @SerialName("game_versions")
    val gameVersions: List<String>,
    @SerialName("version_type")
    val versionType: VersionType,
    val loaders: List<String>,
    val featured: Boolean,
    val status: VersionStatus,
    @SerialName("requested_status")
    val requestedStatus: VersionStatus?,
    val id: String,
    @SerialName("project_id")
    val projectId: String,
    @SerialName("author_id")
    val authorId: String,
    @SerialName("date_published")
    val datePublished: String,
    val downloads: Int,
    val files: List<VersionFile>
)