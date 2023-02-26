package com.example.mychat.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.mychat.Data.Group
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class ViewModelGroup(application: Application): AndroidViewModel(application) {

    private var fb: FirebaseFirestore = FirebaseFirestore.getInstance()

    val activeUsersFlow = MutableSharedFlow<List<Group>>()
    val messageFlow = MutableSharedFlow<String>()
    val erroFlow = MutableSharedFlow<Throwable>()
    val getIdFlow = MutableSharedFlow<String>()

    suspend fun getGruop() {
         try {
             fb.collection("chaty").get().addOnSuccessListener {
                 val list = mutableListOf<Group>()
                 viewModelScope.launch {
                     it.forEach {
                         val group = Group(it.data["id"].toString(), it.data["name"].toString())
                         list.add(group)
                     }
                     activeUsersFlow.emit(list)
                 }
             }.addOnFailureListener{
                 viewModelScope.launch {
                     messageFlow.emit(it.message ?: "")
                 }
             }
         } catch (e: Exception) {
             viewModelScope.launch {
                 erroFlow.emit(e)
             }
         }

    }

    suspend fun addGruop(group: Group) {
        val map = mapOf(
            "id" to group.id,
            "name" to group.name
        )

        fb.collection("chaty").add(
            map
        ).addOnSuccessListener {

        }
    }
}