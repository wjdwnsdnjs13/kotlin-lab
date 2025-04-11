package com.lab.labkotlin.controller

import com.lab.labkotlin.common.exception.BusinessException
import com.lab.labkotlin.common.exception.ErrorCode

abstract class TestException(
    errorCode: ErrorCode
): BusinessException(errorCode) {
    class ResourceNotFound: TestException(TestErrorCode.RESOURCE_NOT_FOUND)
}