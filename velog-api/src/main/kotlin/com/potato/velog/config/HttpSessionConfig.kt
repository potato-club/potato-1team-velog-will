package com.potato.velog.config

import org.springframework.context.annotation.Configuration
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession

@EnableJdbcHttpSession(maxInactiveIntervalInSeconds = 60 * 60 * 24)
@Configuration
class HttpSessionConfig