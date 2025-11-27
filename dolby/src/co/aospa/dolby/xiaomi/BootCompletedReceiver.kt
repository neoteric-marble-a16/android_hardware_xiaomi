/*
 * Copyright (C) 2023-24 Paranoid Android
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package co.aospa.dolby.xiaomi

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

private const val TAG = "XiaomiDolby-Boot"

class BootCompletedReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Log.d(TAG, "Received intent: ${intent.action}")
        when (intent.action) {
            // Only run once user storage is actually available
            Intent.ACTION_BOOT_COMPLETED,
            Intent.ACTION_USER_UNLOCKED -> {
                DolbyController.getInstance(context).onBootCompleted()
            }
            else -> Log.e(TAG, "unhandled intent action")
        }
    }
}
