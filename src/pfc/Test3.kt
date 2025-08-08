package pfc

/*
4. 이자를 계산하자 - 3. 상환 일정을 구해보자.

설명
이전 문제들을 바탕으로
대출 금액, 금리, 기표일, 대출 기간(개월수), 그리고 대한민국의 2025년 공휴일이 입력으로 주어질 때 매달 상환일자와 해당 일자에 상환해야 하는 금액을 계산해보자.

참고사항
• 대출 방식은 만기일시상환으로, 대출 기간 동안 원금은 변하지 않는다.
• 대출 이자의 계산은 초일산입말일불산입 으로 한다.
• 대출 기간은 2025~2027년 사이이며, 따라서 윤년을 계산에 고려하지 않아도 된다.
• 각 상환 일자는 이전 문제와 마찬가지로 공휴일 등의 비영업일의 경우, 가장 가까운 다음 영업일로 정한다.

입출력 예제

입력 예제
2025-01-02
12
10000000
3.5

출력 예제
2025-02-03 30684
2025-03-03 26849
2025-04-02 28767
2025-05-02 28767
2025-06-02 29726
2025-07-02 28767
2025-08-04 31643
2025-09-02 27808
2025-10-02 28767
2025-11-03 30684
2025-12-02 27808
2026-01-02 29726

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

data class RepaymentSchedule(
    val seq: Int,
    val repaymentDate: Date,
    val interestAmount: Int,
)


// RepaymentSchedule 클래스의 정의는 다음과 같다.
// data class RepaymentSchedule(
//    val seq: Int,
//    val repaymentDate: Date,
//    val interestAmount: Int,
// )

fun isHoliday(date: Date, holidays: Set<Long>): Boolean {
    val calendar = Calendar.getInstance()
    calendar.time = date
    val dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)
    return dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY || holidays.contains(date.time)
}

fun getNextBusinessDay(date: Date, holidays: Set<Long>): Date {
    val calendar = Calendar.getInstance()
    calendar.time = date
    while (isHoliday(calendar.time, holidays)) {
        calendar.add(Calendar.DAY_OF_MONTH, 1)
    }
    return calendar.time
}

fun calculateMonthlyRepaymentSchedule(
    executedDate: Date,
    loanMonth: Int,
    loanAmount: Int,
    interestRate: Double,
    holidays: List<Date>
): List<RepaymentSchedule> {
    // 이 곳에 코드를 작성하시오.
    val holidaySet = holidays.map { it.time }.toSet()
    val calendar = Calendar.getInstance()
    val result = mutableListOf<RepaymentSchedule>()

    var previousDate = executedDate

    for (i in 1..loanMonth) {
        calendar.time = executedDate
        calendar.add(Calendar.MONTH, i)

        val baseDay = executedDate.date
        val maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
        calendar.set(Calendar.DAY_OF_MONTH, if (baseDay > maxDay) maxDay else baseDay)

        val rawDate = calendar.time
        val repaymentDate = getNextBusinessDay(rawDate, holidaySet)

        val dayDiff = ((repaymentDate.time - previousDate.time) / (1000 * 60 * 60 * 24)).toInt()
        val dailyRate = (interestRate / 100) / 365
        val interest = (loanAmount * dailyRate * dayDiff).toInt()

        result.add(RepaymentSchedule(i, repaymentDate, interest))
        previousDate = repaymentDate
    }

    return result
}

fun main(args: Array<String>) {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd")
    val executedDate = dateFormat.parse(readLine()!!)
    val loanMonth = readLine()!!.trim().toInt()
    val loanAmount = readLine()!!.trim().toInt()
    val interestRate = readLine()!!.trim().toDouble()
    val holidays = listOf(
        dateFormat.parse("2025-01-01"),
        dateFormat.parse("2025-01-27"),
        dateFormat.parse("2025-01-28"),
        dateFormat.parse("2025-01-29"),
        dateFormat.parse("2025-01-30"),
        dateFormat.parse("2025-03-01"),
        dateFormat.parse("2025-05-01"),
        dateFormat.parse("2025-05-05"),
        dateFormat.parse("2025-05-06"),
        dateFormat.parse("2025-06-06"),
        dateFormat.parse("2025-08-15"),
        dateFormat.parse("2025-10-03"),
        dateFormat.parse("2025-10-05"),
        dateFormat.parse("2025-10-06"),
        dateFormat.parse("2025-10-07"),
        dateFormat.parse("2025-10-08"),
        dateFormat.parse("2025-10-09"),
        dateFormat.parse("2025-12-25"),
        dateFormat.parse("2026-01-01"),
        dateFormat.parse("2026-02-16"),
        dateFormat.parse("2026-02-17"),
        dateFormat.parse("2026-02-18"),
        dateFormat.parse("2026-03-01"),
        dateFormat.parse("2026-03-02"),
        dateFormat.parse("2026-05-01"),
        dateFormat.parse("2026-05-05"),
        dateFormat.parse("2026-05-24"),
        dateFormat.parse("2026-05-25"),
        dateFormat.parse("2026-06-03"),
        dateFormat.parse("2026-06-06"),
        dateFormat.parse("2026-08-15"),
        dateFormat.parse("2026-08-17"),
        dateFormat.parse("2026-09-24"),
        dateFormat.parse("2026-09-25"),
        dateFormat.parse("2026-09-26"),
        dateFormat.parse("2026-10-03"),
        dateFormat.parse("2026-10-05"),
        dateFormat.parse("2026-10-09"),
        dateFormat.parse("2026-12-25"),
    )
    val result = calculateMonthlyRepaymentSchedule(
        executedDate,
        loanMonth,
        loanAmount,
        interestRate,
        holidays)


    result.forEach {
        println("${dateFormat.format(it.repaymentDate)} ${it.interestAmount}")
    }
}

