package com.example.service

import com.example.repository.DeleteRepository

class DeleteService{
    fun deleteMasterDate(id: String): Any {
        val deleteRepository=DeleteRepository()
        return deleteRepository.deleteMasterDate(id)
    }
}