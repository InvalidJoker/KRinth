package me.invalidjoker.krinth.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Serializable
enum class ClientSide {
    @SerialName("required")
    REQUIRED,

    @SerialName("optional")
    OPTIONAL,

    @SerialName("unsupported")
    UNSUPPORTED
}

@Serializable
enum class ServerSide {

    @SerialName("required")
    REQUIRED,

    @SerialName("optional")
    OPTIONAL,

    @SerialName("unsupported")
    UNSUPPORTED
}

@Serializable
enum class ProjectStatus {
    @SerialName("approved")
    APPROVED,

    @SerialName("archived")
    ARCHIVED,

    @SerialName("rejected")
    REJECTED,

    @SerialName("draft")
    DRAFT,

    @SerialName("unlisted")
    UNLISTED,

    @SerialName("processing")
    PROCESSING,

    @SerialName("withheld")
    WITHHELD,

    @SerialName("scheduled")
    SCHEDULED,

    @SerialName("private")
    PRIVATE,

    @SerialName("unknown")
    UNKNOWN
}

@Serializable
enum class RequestedStatus {
    @SerialName("approved")
    APPROVED,

    @SerialName("archived")
    ARCHIVED,

    @SerialName("unlisted")
    UNLISTED,

    @SerialName("private")
    PRIVATE,

    @SerialName("draft")
    DRAFT
}

@Serializable
enum class ProjectType {
    @SerialName("mod")
    MOD,

    @SerialName("modpack")
    MODPACK,

    @SerialName("resourcepack")
    RESOURCEPACK,

    @SerialName("shader")
    SHADER
}

@Serializable
enum class MonetizationStatus {
    @SerialName("monetized")
    MONETIZED,

    @SerialName("demonetized")
    DEMONETIZED,

    @SerialName("force-demonetized")
    FORCE_DEMONETIZED
}

@Serializable
data class ProjectDonationURL(
    val id: String,
    val platform: String,
    val url: String
)

@Serializable
data class ProjectLicense(
    val id: String,
    val name: String,
)

@Serializable
data class GalleryImage(
    val url: String,
    val featured: Boolean,
    val title: String,
    val description: String,
    val created: String,
    val ordering: Int
)

@Serializable
data class Project(
    val slug: String,
    val title: String,
    val description: String,
    val categories: List<String>,

    @SerialName("client_side")
    val clientSide: ClientSide,

    @SerialName("server_side")
    val serverSide: ServerSide,
    val body: String,
    val status: ProjectStatus,

    @SerialName("requested_status")
    val requestedStatus: RequestedStatus?,

    @SerialName("additional_categories")
    val additionalCategories: List<String>,

    @SerialName("issues_url")
    val issuesUrl: String?,

    @SerialName("source_url")
    val sourceUrl: String?,

    @SerialName("wiki_url")
    val wikiUrl: String?,

    @SerialName("discord_url")
    val discordUrl: String?,

    @SerialName("donation_urls")
    val donationUrls: List<ProjectDonationURL>,

    @SerialName("project_type")
    val projectType: ProjectType,

    val downloads: Int,

    @SerialName("icon_url")
    val iconUrl: String?,
    val color: Int?,

    @SerialName("thread_id")
    val threadId: String,

    @SerialName("monetization_status")
    val monetizationStatus: MonetizationStatus,
    val id: String,
    val team: String,

    @SerialName("published")
    private val publishedInternal: String,

    @SerialName("updated")
    private val updatedInternal: String,

    @SerialName("approved")
    private val approvedInternal: String?,

    @SerialName("queued")
    private val queuedInternal: String?,

    val followers: Int,
    val license: ProjectLicense?,
    val versions: List<String>, // TODO: Create Version class

    @SerialName("game_versions")
    val gameVersions: List<String>,
    val loaders: List<String>,
    val gallery: List<GalleryImage>?
) {
    val published: Instant
        get() = Instant.parse(publishedInternal)

    val updated: Instant
        get() = Instant.parse(updatedInternal)

    val approved: Instant?
        get() = approvedInternal?.let { Instant.parse(it) }

    val queued: Instant?
        get() = queuedInternal?.let { Instant.parse(it) }
}
