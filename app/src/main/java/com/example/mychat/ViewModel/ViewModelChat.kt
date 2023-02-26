package com.example.mychat.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableSharedFlow

class ViewModelChat(application: Application): AndroidViewModel(application) {

   private val realTimedb: FirebaseFirestore = FirebaseFirestore.getInstance()



    val getMessageFlow = MutableSharedFlow<String>()
}