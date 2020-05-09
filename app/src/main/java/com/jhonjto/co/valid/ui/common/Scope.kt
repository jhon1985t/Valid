package com.jhonjto.co.valid.ui.common

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlin.coroutines.CoroutineContext

/**
 * Created by jhon on 8/05/2020
 */
interface Scope: CoroutineScope {

    class Impl: Scope {
        override lateinit var job: Job
    }

    var job: Job
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    fun createScope() {
        job = SupervisorJob()
    }

    fun destroyScope() {
        job.cancel()
    }
}