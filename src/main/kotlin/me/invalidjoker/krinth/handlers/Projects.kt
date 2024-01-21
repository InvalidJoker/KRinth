package me.invalidjoker.krinth.handlers

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import me.invalidjoker.krinth.models.Facet
import me.invalidjoker.krinth.models.Project
import me.invalidjoker.krinth.models.SearchData
import me.invalidjoker.krinth.models.SortIndex

class Projects(private val client: HttpClient) {

    suspend fun getProject(slug: String): Project? {
        val request = client.get("project/$slug")

        if (request.status.value != 200) return null

        val project = request.body<Project>()

        return project
    }

    suspend fun searchProjects(query: String, facets: List<List<Facet>>? = null, index: SortIndex = SortIndex.RELEVANCE, offset: Int = 0, limit: Int = 10): SearchData? {

        if (limit > 100) throw IllegalArgumentException("Limit cannot be greater than 100 (was $limit)")
        val request = client.get("search") {
            parameter("query", query)
            if (facets != null) {
                parameter("facets", facets.joinToString(",") { facetList ->
                    facetList.joinToString(",") { facet ->
                        "${facet.type}:${facet.operation}:${facet.value}"
                    }
                })
            }

            // serialize enum
            parameter("index", index.name.lowercase())
            parameter("offset", offset)
            parameter("limit", limit)
        }

        println(request.body<String>())
        if (request.status.value != 200) return null

        val searchData = request.body<SearchData>()

        return searchData
    }
}