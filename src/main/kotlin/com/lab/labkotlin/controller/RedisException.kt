package com.lab.labkotlin.controller

import com.lab.labkotlin.common.exception.BusinessException
import com.lab.labkotlin.common.exception.ErrorCode

abstract class RedisException(
    errorCode: ErrorCode
): BusinessException(errorCode) {
    class ResourceNotFound: RedisException(RedisErrorCode.RESOURCE_NOT_FOUND)
}