package pfc

/*
3. 이자를 계산하자 - 2. 만기일을 계산하자.
4.
설명
대출 기간이 개월수로 주어졌을 때, 해당 대출의 만기일을 계산하는 함수를 작성한다.

참고사항
대출 금액, 금리, 기표일, 대출 기간(개월수), 그리고 대한민국의 2025년 공휴일이 입력으로 주어질 때, 이를 바탕으로 해당 대출의 만기일과 이자를 계산하는 함수를 작성한다.

• 대출의 만기일은 대출 기표일로부터 해당 대출 기간(개월 수) 가 지난 같은 일자이다.
	• ex) 2025-01-02 에 기표된 4 개월 만기 대출은 2025-05-02 (금) 이 만기일이 된다.
• 대출의 만기일이 비영업일인 경우, 가장 빠른 다음 영업일이 된다.
	• ex) 2025-01-03 에 기표된 4 개월 만기 대출은 2025-05-03 이 토요일이며, 4일은 일요일, 5일은 어린이날, 6 일은 석가탄신일 대체휴일이므로2025-05-07 (수) 가 된다.
• 대출의 만기일이 해당 월에 없는 날짜인 경우, 해당 월의 가장 마지막 영업일이 된다.
	• ex) 2025-01-30 에 기표된 1개월 만기 대출은 2월은 30일이 없는 날짜이므로 2025-02-28 (금) 이 된다.

입출력 예제

입력 예제1
2025-01-02
4

출력 예제1
2025-05-02

입력 예제2
2025-01-03
4

출력 예제2
2025-05-07

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

fun calculateMaturityDate(executedDate: Date, loanMonth: Int, holidays:List<Date>): Date {
    val calendar = Calendar.getInstance()
    calendar.time = executedDate

    val originalDay = calendar.get(Calendar.DAY_OF_MONTH)

    // 개월 수 추가
    calendar.add(Calendar.MONTH, loanMonth)

    // 같은 일자가 없는 경우 조정
    val maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
    if (originalDay > maxDay) {
        calendar.set(Calendar.DAY_OF_MONTH, maxDay)
    } else {
        calendar.set(Calendar.DAY_OF_MONTH, originalDay)
    }

    // 비영업일인 경우 다음 영업일까지 이동
    val holidaySet = holidays.map { it.time }.toSet()
    while (true) {
        val dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)
        val isWeekend = dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY
        val isHoliday = holidaySet.contains(calendar.time.time)
        if (!isWeekend && !isHoliday) break
        calendar.add(Calendar.DAY_OF_MONTH, 1)
    }

    return calendar.time
}

fun main(args: Array<String>) {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd")
    val executedDate = dateFormat.parse(readLine()!!)
    val loanMonth = readLine()!!.trim().toInt()
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

    val result = calculateMaturityDate(executedDate,loanMonth, holidays)

    println(dateFormat.format(result))
}
