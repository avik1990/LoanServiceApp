package com.app.loanserviceapp.datasource

import com.app.loanserviceapp.dashboard.model.LoanApplicationSattus
import com.app.loanserviceapp.dashboard.model.payment.PaymentResponse
import com.app.loanserviceapp.loanapackages.model.LoanPckages
import com.app.loanserviceapp.login.model.CheckLoginResponse
import com.app.loanserviceapp.model.PageDetails
import com.app.loanserviceapp.password.model.LoginResponse
import com.app.loanserviceapp.payment.model.PaymentStatusResponse1
import com.app.loanserviceapp.register.model.RegisterResponse
import com.app.loanserviceapp.utils.Constants
import com.app.loanserviceapp.verification.documentation.model.UploadFileResponse
import com.app.loanserviceapp.verification.personal.model.ApplicationResponse
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.*

interface LoanApiServices {

    @FormUrlEncoded
    @POST(Constants.validateRegistration)
    suspend fun getUserRegistration(@Field("FullName") FullName: String,
                                    @Field("MobileNumber") MobileNumber: String,
                                    @Field("EmailAddress") EmailAddress: String): Response<RegisterResponse>

    @FormUrlEncoded
    @POST(Constants.OTP_URL)
    suspend fun getOTP(@Field("MobileNumber") MobileNumber: String,
    ): Response<RegisterResponse>

    @FormUrlEncoded
    @POST(Constants.loginValidation)
    suspend fun getloginValidation(@Field("MobileNumber") MobileNumber: String,
    ): Response<CheckLoginResponse>



    @FormUrlEncoded
    @POST(Constants.REGISTRATION_URL)
    suspend fun sentRegistration(@Field("FullName") FullName: String,
                                    @Field("MobileNumber") MobileNumber: String,
                                    @Field("EmailAddress") EmailAddress: String,
                                    @Field("OTPNumber") OTPNumber: String,): Response<RegisterResponse>

    @FormUrlEncoded
    @POST(Constants.CHECK_LOGIN)
    suspend fun checkLogin(@Field("MobileNumber") MobileNumber: String,
                                 @Field("OTPNumber") OTPNumber: String): Response<LoginResponse>



    @GET(Constants.PAYMENT_KEYS)
    suspend fun getPaymentKeys(): Response<PaymentResponse>

    @GET(Constants.GET_PACKAGES)
    suspend fun getPackages(): Response<LoanPckages>

    @GET(Constants.LOAN_STATUS)
    suspend fun getLoanStatus(@Query("UsersID") usersID: String): Response<LoanApplicationSattus>

    @Multipart
    @POST(Constants.UPLOAD_FILE)
    suspend fun uploadImage(@Part filePart: MultipartBody.Part): Response<UploadFileResponse>

    @GET(Constants.PAGE_CONTENT)
    suspend fun getPageContent(@Query("PagesIdentifier") pageContent: String): Response<PageDetails>

    @FormUrlEncoded
    @POST(Constants.SUBMIT_APPLICATION)
    suspend fun submitApplication(@Field("UsersID") UsersID: String,
                                  @Field("PackageID") PackageID: String,
                                  @Field("PackageName") PackageName: String,
                                  @Field("InsuranceFee") InsuranceFee: String,
                                  @Field("ProcessingFee") ProcessingFee: String,
                                  @Field("FullName") FullName: String,
                                  @Field("MobileNumber") MobileNumber: String,
                                  @Field("Age") Age: String,
                                  @Field("CurrentAddress") CurrentAddress: String,
                                  @Field("PermanentAddress") PermanentAddress: String,
                                  @Field("EmailAddress") EmailAddress: String,
                                  @Field("PassportImage") PassportImage: String,
                                  @Field("AadharImage") AadharImage: String,
                                  @Field("PancardImage") PancardImage: String,
                                  @Field("IncomeProofImage") IncomeProofImage: String,): Response<ApplicationResponse>


    @FormUrlEncoded
    @POST(Constants.PAYMENT_STATUS)
    suspend fun sentPaymentStatus(@Field("PaymentStatus") paymentstatus: String,
                                 ): Response<PaymentStatusResponse1>

}