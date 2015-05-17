package ii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        if (year != other.year) return year - other.year
        if (month != other.month) return month - other.month
        return dayOfMonth - other.dayOfMonth
    }
}

enum class TimeInterval {
    DAY
    WEEK
    YEAR
}

fun MyDate.rangeTo(other: MyDate) = DateRange(this, other)

fun MyDate.plus(dt: TimeInterval): MyDate = addTimeIntervals(dt, 1)
fun MyDate.plus(dt: RepeatedTimeInterval): MyDate = addTimeIntervals(dt.dt, dt.nb)

class RepeatedTimeInterval(val dt: TimeInterval, val nb: Int)

fun TimeInterval.times(nb: Int): RepeatedTimeInterval = RepeatedTimeInterval(this, nb)

class DateRange(override public val start: MyDate, override public val end: MyDate) : Iterable<MyDate>, Range<MyDate> {
    override fun contains(item: MyDate) = item >= start && item <= end

    override fun iterator(): Iterator<MyDate> =
            object : Iterator<MyDate> {
                var d: MyDate = start
                override fun next(): MyDate {
                    val t = d
                    d = d.nextDay()
                    return t
                }

                override fun hasNext(): Boolean =
                        d <= end
            }
}
