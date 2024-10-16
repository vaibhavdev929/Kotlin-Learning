package com.sapient.kotlinlearning.day2

// inheritable in same package, compile time child topicwise.classes
sealed class HTTPResponse(val logLevel: Int)

enum class HTTPErrorCode(val errCode: Int) {
    SERVER_ERROR(500),
    NETWORK_ERROR(-1),
    CLIENT_ERROR(400)
}

class Success(val data: String): HTTPResponse(0)
sealed class Error(val code: Int): HTTPResponse(2)
data object Loading: HTTPResponse( 1)
class NetworkError: Error(HTTPErrorCode.NETWORK_ERROR.errCode)
class ServerError: Error(HTTPErrorCode.SERVER_ERROR.errCode)
class ClientError: Error(HTTPErrorCode.CLIENT_ERROR.errCode)

fun handleResponse(resp: HTTPResponse){

    when(resp){
        is Error ->
        {
            println("Error with code: ${resp.code}")
            when(resp){
                is ClientError -> TODO()
                is NetworkError -> TODO()
                is ServerError -> TODO()
            }
        }
        is Loading -> println("its loading")
        is Success -> println("Success with data: ${resp.data}")
    }
}

// multiple inheritance
sealed interface PaymentType

class CreditCardPayment(val cardNo: String): PaymentType
class UPIPayment(val upiId: String): PaymentType
data object cashPayment: PaymentType

fun doPayment(amount: Int, type: PaymentType){

    when(type){
        is CreditCardPayment -> println("Paying by card ${type.cardNo}")
        is UPIPayment -> println("Paying by UPI ${type.upiId}")
        cashPayment -> println("Paying by cash")
    }
}