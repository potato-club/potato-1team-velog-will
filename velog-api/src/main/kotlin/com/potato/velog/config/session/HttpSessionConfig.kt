package com.potato.velog.config.session

import org.springframework.context.annotation.Configuration
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession

@EnableJdbcHttpSession(maxInactiveIntervalInSeconds = 60 * 60 * 24 * 7)
@Configuration
class HttpSessionConfig