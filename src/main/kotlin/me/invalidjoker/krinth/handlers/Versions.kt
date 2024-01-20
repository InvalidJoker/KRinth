package me.invalidjoker.krinth.handlers

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import me.invalidjoker.krinth.models.Version

class Versions(private val client: HttpClient) {

    suspend fun getVersions(slug: String): List<Version>? {
        val request = client.get("project/$slug/version")

        if (request.status.value != 200) return null

        val versions = request.body<List<Version>>()

        return versions
    }

    suspend fun getVersion(id: String): Version? {
        val request = client.get("version/$id")

        if (request.status.value != 200) return null

        val version = request.body<Version>()

        return version
    }
}