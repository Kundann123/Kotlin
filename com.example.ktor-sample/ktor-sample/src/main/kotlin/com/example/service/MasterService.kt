package com.example.service

import com.example.model.MasterDTO
import com.example.repository.MasterRepository

class MasterService {
    fun saveMasterDetails(body: MasterDTO): Int {
        val masterRepository=MasterRepository()
        return masterRepository.saveMasterDetails(body)

    }
}