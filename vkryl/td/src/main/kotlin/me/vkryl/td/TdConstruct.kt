/*
 * This file is a part of tdlib-utils
 * Copyright © Vyacheslav Krylov (slavone@protonmail.ch) 2014-2022
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

@file:JvmName("Td")
@file:JvmMultifileClass

package me.vkryl.td

import org.drinkless.td.libcore.telegram.TdApi.*

fun constructSearchMessagesFilter (@SearchMessagesFilter.Constructors constructor: Int): SearchMessagesFilter {
  return when (constructor) {
    SearchMessagesFilterEmpty.CONSTRUCTOR -> SearchMessagesFilterEmpty()
    SearchMessagesFilterAnimation.CONSTRUCTOR -> SearchMessagesFilterAnimation()
    SearchMessagesFilterAudio.CONSTRUCTOR -> SearchMessagesFilterAudio()
    SearchMessagesFilterDocument.CONSTRUCTOR -> SearchMessagesFilterDocument()
    SearchMessagesFilterPhoto.CONSTRUCTOR -> SearchMessagesFilterPhoto()
    SearchMessagesFilterVideo.CONSTRUCTOR -> SearchMessagesFilterVideo()
    SearchMessagesFilterVoiceNote.CONSTRUCTOR -> SearchMessagesFilterVoiceNote()
    SearchMessagesFilterPhotoAndVideo.CONSTRUCTOR -> SearchMessagesFilterPhotoAndVideo()
    SearchMessagesFilterUrl.CONSTRUCTOR -> SearchMessagesFilterUrl()
    SearchMessagesFilterChatPhoto.CONSTRUCTOR -> SearchMessagesFilterChatPhoto()
    SearchMessagesFilterVideoNote.CONSTRUCTOR -> SearchMessagesFilterVideoNote()
    SearchMessagesFilterVoiceAndVideoNote.CONSTRUCTOR -> SearchMessagesFilterVoiceAndVideoNote()
    SearchMessagesFilterMention.CONSTRUCTOR -> SearchMessagesFilterMention()
    SearchMessagesFilterUnreadMention.CONSTRUCTOR -> SearchMessagesFilterUnreadMention()
    SearchMessagesFilterFailedToSend.CONSTRUCTOR -> SearchMessagesFilterFailedToSend()
    else -> error(constructor.toString())
  }
}

fun constructNotificationSettingsScope (@NotificationSettingsScope.Constructors constructor: Int): NotificationSettingsScope {
  return when (constructor) {
    NotificationSettingsScopePrivateChats.CONSTRUCTOR -> NotificationSettingsScopePrivateChats()
    NotificationSettingsScopeGroupChats.CONSTRUCTOR -> NotificationSettingsScopeGroupChats()
    NotificationSettingsScopeChannelChats.CONSTRUCTOR -> NotificationSettingsScopeChannelChats()
    else -> error(constructor.toString())
  }
}

fun constructChatAction (@ChatAction.Constructors constructor: Int): ChatAction? {
  return when (constructor) {
    ChatActionCancel.CONSTRUCTOR -> ChatActionCancel()
    ChatActionTyping.CONSTRUCTOR -> ChatActionTyping()
    ChatActionRecordingVoiceNote.CONSTRUCTOR -> ChatActionRecordingVoiceNote()
    ChatActionRecordingVideoNote.CONSTRUCTOR -> ChatActionRecordingVideoNote()
    ChatActionRecordingVideo.CONSTRUCTOR -> ChatActionRecordingVideo()
    ChatActionChoosingContact.CONSTRUCTOR -> ChatActionChoosingContact()
    ChatActionChoosingLocation.CONSTRUCTOR -> ChatActionChoosingLocation()
    ChatActionChoosingSticker.CONSTRUCTOR -> ChatActionChoosingSticker()
    ChatActionStartPlayingGame.CONSTRUCTOR -> ChatActionStartPlayingGame()

    ChatActionUploadingDocument.CONSTRUCTOR,
    ChatActionUploadingPhoto.CONSTRUCTOR,
    ChatActionUploadingVideo.CONSTRUCTOR,
    ChatActionUploadingVideoNote.CONSTRUCTOR,
    ChatActionUploadingVoiceNote.CONSTRUCTOR -> null

    else -> null
  }
}