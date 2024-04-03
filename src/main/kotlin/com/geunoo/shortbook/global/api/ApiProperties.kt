package com.geunoo.shortbook.global.api

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("api")
class ApiProperties(
    var clientSecret: String = "",
    var clientId: String = "",
)
