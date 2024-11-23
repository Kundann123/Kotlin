package com.tdl.guaranteedsavings.exception

class GSInternalServerException(
    override val message: String?
) : Exception(message)

class GSBadRequestException(
        override val message: String?
) : Exception(message)
