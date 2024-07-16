/*
 * Copyright (c) 2023 Airbyte, Inc., all rights reserved.
 */
package io.airbyte.commons.exceptions

/**
 * An exception that indicates that there is something wrong with the user's connector setup. This
 * exception is caught and emits an AirbyteTraceMessage.
 */
class ConfigErrorException : RuntimeException {
    val internalMessage: String
    val displayMessage: String

    constructor(displayMessage: String) : super(displayMessage) {
        this.displayMessage = displayMessage
        this.internalMessage = "internalMessage"
    }
    constructor(displayMessage: String, internalMessage: String = "") : super(displayMessage) {
        this.displayMessage = displayMessage
        this.internalMessage = internalMessage
    }

    constructor(
        displayMessage: String,
        exception: Throwable?,
        internalMessage: String = ""
    ) : super(displayMessage, exception) {
        this.displayMessage = displayMessage
        this.internalMessage = internalMessage
    }
}
