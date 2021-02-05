package com.jy.yui.utils

import android.util.Log
import java.text.SimpleDateFormat
import java.util.*

/**
 * @description 打印log
 * @date: 2021/2/5 10:53
 * @author: jy
 */
object YUILogUtils {

    var SHOW_LOG = false
    private const val TAG = "YUILogUtils"
    private var level = LogLevel.ALL
    private val sLogFormat = SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.CHINA)
    private val logStr: String
        get() = sLogFormat.format(Date())

    enum class LogLevel {
        DEBUG,
        INFO,
        WARN,
        ERROR,
        ALL
    }

    fun setLogLevel(logLevel: LogLevel) {
        level = logLevel
    }

    fun e(vararg args: Any?) {
        if (SHOW_LOG) {
            val traceElement = Thread.currentThread().stackTrace[3]
            log(traceElement, getString(*args), LogLevel.ERROR)
        }
    }

    fun i(vararg args: Any?) {
        if (SHOW_LOG) {
            val traceElement = Thread.currentThread().stackTrace[3]
            log(traceElement, getString(*args), LogLevel.INFO)
        }
    }

    fun w(vararg args: Any?) {
        if (SHOW_LOG) {
            val traceElement = Thread.currentThread().stackTrace[3]
            log(traceElement, getString(*args), LogLevel.WARN)
        }
    }

    fun d(vararg args: Any?) {
        if (SHOW_LOG) {
            val traceElement = Thread.currentThread().stackTrace[3]
            log(traceElement, getString(*args), LogLevel.DEBUG)
        }
    }


    private fun getString(vararg args: Any?): String {
        return when (args.size) {
            1 -> args[0].toString()
            else -> {
                val message = StringBuilder()
                for (`object` in args) {
                    message.append(`object`)
                    message.append("---")
                }
                message.toString()
            }
        }
    }

    private fun log(
        traceElement: StackTraceElement,
        message: String,
        logLevel: LogLevel
    ) {
        val msgFormat = "[ %s %s ]---类名：%s---方法名：%s---第%d行---信息---%s"
        val messageWithTime = String.format(
            Locale.CHINA,
            msgFormat,
            logStr,
            logLevel.name,
            traceElement.fileName,
            traceElement.methodName,
            traceElement.lineNumber,
            message
        )
        if (level == LogLevel.ALL || logLevel == level) {
            when (logLevel) {
                LogLevel.INFO -> Log.i(TAG, messageWithTime)
                LogLevel.WARN -> Log.w(TAG, messageWithTime)
                LogLevel.DEBUG -> Log.d(TAG, messageWithTime)
                LogLevel.ERROR -> Log.e(TAG, messageWithTime)
                else -> Log.i(TAG, messageWithTime)
            }
        }
    }

}
