package me.invalidjoker.krinth.handlers

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import me.invalidjoker.krinth.models.Project

class Projects(private val client: HttpClient) {

    suspend fun getProject(slug: String): Project? {
        val request = client.get("project/$slug")

        if (request.status.value != 200) return null

        val project = request.body<Project>()

        return project
    }
}