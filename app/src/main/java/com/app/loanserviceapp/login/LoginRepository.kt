package com.app.loanserviceapp.login

import com.app.loanserviceapp.datasource.RemoteDataSource
import com.app.loanserviceapp.login.model.CheckLoginResponse
import com.app.loanserviceapp.utils.BaseApiResponse
import com.app.loanserviceapp.utils.NetworkResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


class LoginRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : BaseApiResponse() {

    suspend fun getLoggedin(userPhone:String): Flow<NetworkResult<CheckLoginResponse>> {
        return flow {
            emit(safeApiCall { remoteDataSource.checkloginValidation(userPhone) })
        }.flowOn(Dispatchers.IO)
    }
}