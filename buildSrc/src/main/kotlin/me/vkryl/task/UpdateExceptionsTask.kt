/*
 * This file is a part of Telegram X
 * Copyright © 2014-2022 (tgx-android@pm.me)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses/>.
 */
package me.vkryl.task

import getOrThrow
import loadProperties
import org.gradle.api.tasks.TaskAction
import kotlin.contracts.ExperimentalContracts

open class UpdateExceptionsTask : BaseTask() {
  @ExperimentalContracts
  @TaskAction
  fun updateExceptions () {
    val appVersion = loadProperties("version.properties").getOrThrow("version.app").toInt()
    if (appVersion == 0)
      error("appVersion == 0")
    writeToFile("app/src/main/java/org/drinkmore/ClientException.java") { java ->
      java.append("""
        package org.drinkmore;

        import org.thunderdog.challegram.BuildConfig;

        import me.vkryl.annotation.Autogenerated;

        @Autogenerated
        public abstract class ClientException extends RuntimeException {
          private ClientException (String message) {
            super(message);
          }

          private static class ClientException_${appVersion} extends ClientException {
            private ClientException_${appVersion} (String message) {
              super(Tracer.format(message));
            }
          }

          static final class DatabaseError extends ClientException_${appVersion} {
            DatabaseError (String message) {
              super(message + ", versionCode: " + BuildConfig.VERSION_CODE);
            }
          }

          static final class TdlibLaunchError extends ClientException_${appVersion} {
            TdlibLaunchError (String message) {
              super(message);
            }
          }

          static final class TdlibLostPromiseError extends ClientException_${appVersion} {
            TdlibLostPromiseError (String message) {
              super(message);
            }
          }

          static void throwTestError (Throwable error) {
            throw new ClientException_${appVersion}(error.getMessage());
          }

          static void throwAssertionError (Throwable error) {
            throw new ClientException_${appVersion}(error.getMessage());
          }
        }
      """.trimIndent())
    }
  }
}