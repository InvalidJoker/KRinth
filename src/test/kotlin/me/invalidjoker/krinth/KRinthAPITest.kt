package me.invalidjoker.krinth

import kotlinx.coroutines.runBlocking
import kotlin.test.Test

class KRinthAPITest {

    val api = KRinthAPI(staging = true)

    @Test
    fun test() {
        val d = runBlocking {
            return@runBlocking api.projects.getProject("fabric-api")
        }

        d?.let {
            println(it)
        }
    }
}