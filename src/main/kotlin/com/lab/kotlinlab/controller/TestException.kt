package com.lab.kotlinlab.controller

import com.lab.kotlinlab.common.exception.BusinessException
import com.lab.kotlinlab.common.exception.ErrorCode

abstract class TestException(
    errorCode: ErrorCode,
) : BusinessException(errorCode) {
    class ResourceNotFound : TestException(TestErrorCode.RESOURCE_NOT_FOUND)
}
