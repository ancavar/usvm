@file:Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")

package org.usvm.gameserver

import kotlinx.coroutines.*
import kotlinx.serialization.json.Json
import kotlin.random.Random

fun randomExplorer(
    inputBody: Start,
    getNextStep: () -> Step,
    sendOutputMessageBody: (outputMessageBody: OutputMessageBody) -> Unit,
): GameOver {
    val s =
        "{\"MessageType\":\"ReadyForNextStep\",\"MessageBody\":{\"GraphVertices\":[{\"Id\":0,\"InCoverageZone\":true,\"BasicBlockSize\":2,\"CoveredByTest\":true,\"VisitedByState\":false,\"TouchedByState\":false,\"ContainsCall\":false,\"ContainsThrow\":true,\"States\":[]},{\"Id\":1,\"InCoverageZone\":true,\"BasicBlockSize\":6,\"CoveredByTest\":true,\"VisitedByState\":false,\"TouchedByState\":true,\"ContainsCall\":false,\"ContainsThrow\":false,\"States\":[0]},{\"Id\":3,\"InCoverageZone\":true,\"BasicBlockSize\":3,\"CoveredByTest\":true,\"VisitedByState\":false,\"TouchedByState\":false,\"ContainsCall\":false,\"ContainsThrow\":false,\"States\":[1]},{\"Id\":2,\"InCoverageZone\":true,\"BasicBlockSize\":1,\"CoveredByTest\":false,\"VisitedByState\":false,\"TouchedByState\":false,\"ContainsCall\":false,\"ContainsThrow\":false,\"States\":[]},{\"Id\":4,\"InCoverageZone\":true,\"BasicBlockSize\":6,\"CoveredByTest\":false,\"VisitedByState\":false,\"TouchedByState\":true,\"ContainsCall\":false,\"ContainsThrow\":false,\"States\":[]},{\"Id\":5,\"InCoverageZone\":true,\"BasicBlockSize\":1,\"CoveredByTest\":false,\"VisitedByState\":false,\"TouchedByState\":false,\"ContainsCall\":false,\"ContainsThrow\":false,\"States\":[]},{\"Id\":6,\"InCoverageZone\":true,\"BasicBlockSize\":3,\"CoveredByTest\":false,\"VisitedByState\":false,\"TouchedByState\":false,\"ContainsCall\":false,\"ContainsThrow\":false,\"States\":[]},{\"Id\":7,\"InCoverageZone\":true,\"BasicBlockSize\":6,\"CoveredByTest\":false,\"VisitedByState\":false,\"TouchedByState\":true,\"ContainsCall\":false,\"ContainsThrow\":false,\"States\":[]},{\"Id\":8,\"InCoverageZone\":true,\"BasicBlockSize\":1,\"CoveredByTest\":false,\"VisitedByState\":false,\"TouchedByState\":false,\"ContainsCall\":false,\"ContainsThrow\":false,\"States\":[]},{\"Id\":9,\"InCoverageZone\":true,\"BasicBlockSize\":9,\"CoveredByTest\":false,\"VisitedByState\":false,\"TouchedByState\":false,\"ContainsCall\":false,\"ContainsThrow\":false,\"States\":[]},{\"Id\":12,\"InCoverageZone\":true,\"BasicBlockSize\":5,\"CoveredByTest\":false,\"VisitedByState\":false,\"TouchedByState\":false,\"ContainsCall\":false,\"ContainsThrow\":false,\"States\":[]},{\"Id\":13,\"InCoverageZone\":true,\"BasicBlockSize\":2,\"CoveredByTest\":false,\"VisitedByState\":false,\"TouchedByState\":false,\"ContainsCall\":false,\"ContainsThrow\":false,\"States\":[]},{\"Id\":14,\"InCoverageZone\":true,\"BasicBlockSize\":5,\"CoveredByTest\":false,\"VisitedByState\":false,\"TouchedByState\":false,\"ContainsCall\":false,\"ContainsThrow\":false,\"States\":[]},{\"Id\":15,\"InCoverageZone\":true,\"BasicBlockSize\":4,\"CoveredByTest\":false,\"VisitedByState\":false,\"TouchedByState\":false,\"ContainsCall\":false,\"ContainsThrow\":false,\"States\":[]},{\"Id\":16,\"InCoverageZone\":true,\"BasicBlockSize\":4,\"CoveredByTest\":false,\"VisitedByState\":false,\"TouchedByState\":false,\"ContainsCall\":false,\"ContainsThrow\":false,\"States\":[]},{\"Id\":10,\"InCoverageZone\":true,\"BasicBlockSize\":3,\"CoveredByTest\":false,\"VisitedByState\":false,\"TouchedByState\":false,\"ContainsCall\":false,\"ContainsThrow\":false,\"States\":[]},{\"Id\":11,\"InCoverageZone\":true,\"BasicBlockSize\":2,\"CoveredByTest\":false,\"VisitedByState\":false,\"TouchedByState\":false,\"ContainsCall\":false,\"ContainsThrow\":false,\"States\":[]}],\"States\":[{\"Id\":0,\"Position\":1,\"PathConditionSize\":1,\"VisitedAgainVertices\":0,\"VisitedNotCoveredVerticesInZone\":0,\"VisitedNotCoveredVerticesOutOfZone\":0,\"StepWhenMovedLastTime\":2,\"InstructionsVisitedInCurrentBlock\":1,\"History\":[{\"GraphVertexId\":0,\"NumOfVisits\":1,\"StepWhenVisitedLastTime\":0},{\"GraphVertexId\":1,\"NumOfVisits\":1,\"StepWhenVisitedLastTime\":2}],\"Children\":[1]},{\"Id\":1,\"Position\":1,\"PathConditionSize\":1,\"VisitedAgainVertices\":0,\"VisitedNotCoveredVerticesInZone\":0,\"VisitedNotCoveredVerticesOutOfZone\":0,\"StepWhenMovedLastTime\":3,\"InstructionsVisitedInCurrentBlock\":1,\"History\":[{\"GraphVertexId\":0,\"NumOfVisits\":1,\"StepWhenVisitedLastTime\":0},{\"GraphVertexId\":3,\"NumOfVisits\":1,\"StepWhenVisitedLastTime\":3}],\"Children\":[]}],\"Map\":[{\"VertexFrom\":0,\"VertexTo\":1,\"Label\":{\"Token\":0}},{\"VertexFrom\":0,\"VertexTo\":3,\"Label\":{\"Token\":0}},{\"VertexFrom\":1,\"VertexTo\":2,\"Label\":{\"Token\":0}},{\"VertexFrom\":3,\"VertexTo\":4,\"Label\":{\"Token\":0}},{\"VertexFrom\":3,\"VertexTo\":6,\"Label\":{\"Token\":0}},{\"VertexFrom\":4,\"VertexTo\":5,\"Label\":{\"Token\":0}},{\"VertexFrom\":6,\"VertexTo\":7,\"Label\":{\"Token\":0}},{\"VertexFrom\":6,\"VertexTo\":9,\"Label\":{\"Token\":0}},{\"VertexFrom\":7,\"VertexTo\":8,\"Label\":{\"Token\":0}},{\"VertexFrom\":9,\"VertexTo\":10,\"Label\":{\"Token\":0}},{\"VertexFrom\":12,\"VertexTo\":13,\"Label\":{\"Token\":0}},{\"VertexFrom\":12,\"VertexTo\":14,\"Label\":{\"Token\":0}},{\"VertexFrom\":14,\"VertexTo\":15,\"Label\":{\"Token\":0}},{\"VertexFrom\":14,\"VertexTo\":16,\"Label\":{\"Token\":0}},{\"VertexFrom\":15,\"VertexTo\":10,\"Label\":{\"Token\":0}},{\"VertexFrom\":16,\"VertexTo\":10,\"Label\":{\"Token\":0}},{\"VertexFrom\":10,\"VertexTo\":11,\"Label\":{\"Token\":0}},{\"VertexFrom\":10,\"VertexTo\":12,\"Label\":{\"Token\":0}}]}}"
    val deserialized = Json.decodeFromString<RawOutputMessage>(s).messageBody
    var i = 1U
    var stepsToPlay = inputBody.gameMap.stepsToPlay
    while (stepsToPlay > 0U && Random.nextInt(20) % 20 != 0) {
        sendOutputMessageBody(deserialized)
        val step = getNextStep()
        sendOutputMessageBody(MoveReward(Reward(MoveRewardData(i, i), i)))
        i += 1U
        stepsToPlay -= 1U
    }
    return GameOver(1.toUByte(), 2u, 3U)
}