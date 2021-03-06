package com.iroha168.gamancounter.repository

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.FirebaseFirestore
import com.iroha168.gamancounter.view.model.SaveCheerMail
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

// チアメールを保存
class CheerMailRepository {
    suspend fun send(userName: String?, cheerMail: String?): Task<Void> {
        return suspendCoroutine { cont ->
            val db = FirebaseFirestore.getInstance()
            val saveCheerMail = SaveCheerMail(userName, cheerMail)
            val task = db.collection("cheerMail")
                .document()
                .set(saveCheerMail)
            task.addOnCompleteListener {
                cont.resume(it)
            }
        }
    }
}

// 保存したチアメールを取得
// TODO: チアメールとユーザー名を取得する処理をかく
