package pfc

/*
* 이자를 계산하자 - 1. 일별 이자를 계산하자.
설명
PFCT에서 대출을 받은 사람의
대출일, 만기일, 대출액, 연이자율이 주어질 때 해당 대출의 이자를 계산하는 calculateInterest 함수를 작성합니다.

참고사항
• 테스트 케이스는 2025-2027년 내에서만 이루어집니다. (윤년 미포함)
• 입력되는 금액과 출력되는 이자는 Integer 범위 내에서 주어집니다.
• 일수 계산시 '초일산입말일불산입'이 적용됩니다.
	• 기간의 시작일(초일)은 포함하고, 종료일(말일)은 포함하지 않는 방식입니다.
	• 대출일이 1월1일, 만기일이 1월4일인 대출은 총 3일치(1,2,3일)의 이자가 부과됩니다.
• 이자 는 원단위 절사합니다. (소수점 첫째자리에서 버림)
• 금리는 % 단위로 입력됩니다. (금리 10%일 경우, 0.1이 아닌 10.0 으로 입력)

입출력 예제

입력
2025-01-02
2025-03-31
10000000
3.5

출력
84383
* */
import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*
import java.text.SimpleDateFormat

// 아래 함수 calculateInterest 를 완성하시오.
// executedDate : 대출이 시작되는 실행일
// maturityDate : 대출이 종료되는 만기일
// loanAmount : 대출 금액
// interestRate : 대출 금리

fun calculateInterest(executedDate: Date, maturityDate: Date, loanAmount: Int, interestRate: Double): Int{
    val millisPerDay = 1000 * 60 * 60 * 24
    val diffInMillies = maturityDate.time - executedDate.time
    val days = (diffInMillies / millisPerDay).toInt()  // 초일산입 말일불산입

    val dailyRate = (interestRate / 100) / 365
    val interest = loanAmount * dailyRate * days

    return interest.toInt()  // 원 단위 절사
}

fun main(args: Array<String>) {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd")
    val executedDate = dateFormat.parse(readLine()!!)
    val maturityDate = dateFormat.parse(readLine()!!)
    val loanAmount = readLine()!!.trim().toInt()
    val interestRate = readLine()!!.trim().toDouble()

    val result = calculateInterest(executedDate, maturityDate, loanAmount, interestRate)

    println(result)
}
