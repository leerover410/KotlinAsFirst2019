@file:Suppress("UNUSED_PARAMETER", "CAST_NEVER_SUCCEEDS")

package lesson2.task2

import lesson1.task1.sqr
import kotlin.math.min
import kotlin.math.sqrt

/**
 * Пример
 *
 * Лежит ли точка (x, y) внутри окружности с центром в (x0, y0) и радиусом r?
 */
fun pointInsideCircle(x: Double, y: Double, x0: Double, y0: Double, r: Double) =
    sqr(x - x0) + sqr(y - y0) <= sqr(r)

/**
 * Простая
 *
 * Четырехзначное число назовем счастливым, если сумма первых двух ее цифр равна сумме двух последних.
 * Определить, счастливое ли заданное число, вернуть true, если это так.
 */
fun isNumberHappy(number: Int): Boolean =
    ((number / 1000) + number / 100 % 10 == ((number % 100) % 10 + (number % 10)))

/**
 * Простая
 *
 * На шахматной доске стоят два ферзя (ферзь бьет по вертикали, горизонтали и диагоналям).
 * Определить, угрожают ли они друг другу. Вернуть true, если угрожают.
 * Считать, что ферзи не могут загораживать друг друга.
 */
fun queenThreatens(x1: Int, y1: Int, x2: Int, y2: Int): Boolean = TODO()


/**
 * Простая
 *
 * Дан номер месяца (от 1 до 12 включительно) и год (положительный).
 * Вернуть число дней в этом месяце этого года по григорианскому календарю.
 */
fun daysInMonth(month: Int, year: Int): Int = when {
    (month == 2) && (year % 400 == 0) && (year % 4 == 0) -> 29
    (month == 2) && (year % 4 != 0) -> 28
    ((month % 2 != 0) || (month % 8 != 0) || (month % 12 != 0)) && (month != 9) && (month != 11) -> 31
    else -> 30
}

/**
 * * Средняя
 *
 * Проверить, лежит ли окружность с центром в (x1, y1) и радиусом r1 целиком внутри
 * окружности с центром в (x2, y2) и радиусом r2.
 * Вернуть true, если утверждение верно
 * */
fun circleInside(
    x1: Double, y1: Double, r1: Double,
    x2: Double, y2: Double, r2: Double
): Boolean {
    val r = (sqrt(sqr(x1 - x2) + sqr(y1 - y2)))
    return (if ((r + r1) <= r2) true
    else 0) as Boolean
}

/**
 * Средняя
 *
 * Определить, пройдет ли кирпич со сторонами а, b, c сквозь прямоугольное отверстие в стене со сторонами r и s.
 * Стороны отверстия должны быть параллельны граням кирпича.
 * Считать, что совпадения длин сторон достаточно для прохождения кирпича, т.е., например,
 * кирпич 4 х 4 х 4 пройдёт через отверстие 4 х 4.
 * Вернуть true, если кирпич пройдёт
 */
fun brickPasses(a: Int, b: Int, c: Int, r: Int, s: Int): Boolean {
    val x1 = min(a, b)
    val x2 = min(b, c)
    val x3 = min(a, c)
    return (if ((x1 == x2) && ((x1 * x3) <= (r * s))) true
    else {
        if ((x1 == x3) && ((x1 * x2) <= (r * s))) true
        else {
            if ((x2 == x3) && ((x1 * x2) <= (r * s))) true
            else 0
        }
    }) as Boolean
}



