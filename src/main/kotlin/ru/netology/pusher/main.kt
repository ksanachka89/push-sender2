package ru.netology.pusher

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import java.io.FileInputStream


fun main() {
    val options = FirebaseOptions.builder()
        .setCredentials(GoogleCredentials.fromStream(FileInputStream("fcm.json")))
        .build()

    FirebaseApp.initializeApp(options)

    val message = createNewPostMessage()

    FirebaseMessaging.getInstance().send(message)
}

fun createLikeMessage(): Message = Message.builder()
    .putData("action", "LIKE")
    .putData(
        "content", """{
          "userId": 1,
          "userName": "Петя",
          "postId": 2,
          "postAuthor": "ФФФ"
        }""".trimIndent()
    )
    .setToken(TOKEN)
    .build()

fun createNewPostMessage(): Message = Message.builder()
    .putData("action", "NEW_POST")
    .putData(
        "content", """{
          "userId": 1,
          "userName": "Петя",
          "postId": 2,
          "postAuthor": "ФФФ",
          "contentText": "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила, которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия — помочь встать на путь роста и начать цепочку перемен → http://netolo.gy/fyb"
        }""".trimIndent()
    )
    .setToken(TOKEN)
    .build()
const val TOKEN = "d2AdDw7nQBynvkJyDbMVHb:APA91bHZspntindqkkW734nz4k0CUwICdNXMk7Qkc0KM6kEMSW6B-p45u5ufRAIkRc6YqQ31XJXiSZmGkiUW45aGHIPLxeu3BOCr8aR-wL44sxt4kS7MlStw__EzOsYa2KEN36zMWhaP"